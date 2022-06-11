/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Dfecsrt;
import entidade.cplus.DfecsrtPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class DfecsrtJpaController implements Serializable {

    public DfecsrtJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Dfecsrt dfecsrt) throws PreexistingEntityException, Exception {
        if (dfecsrt.getDfecsrtPK() == null) {
            dfecsrt.setDfecsrtPK(new DfecsrtPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(dfecsrt);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDfecsrt(dfecsrt.getDfecsrtPK()) != null) {
                throw new PreexistingEntityException("Dfecsrt " + dfecsrt + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Dfecsrt dfecsrt) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            dfecsrt = em.merge(dfecsrt);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                DfecsrtPK id = dfecsrt.getDfecsrtPK();
                if (findDfecsrt(id) == null) {
                    throw new NonexistentEntityException("The dfecsrt with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(DfecsrtPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Dfecsrt dfecsrt;
            try {
                dfecsrt = em.getReference(Dfecsrt.class, id);
                dfecsrt.getDfecsrtPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dfecsrt with id " + id + " no longer exists.", enfe);
            }
            em.remove(dfecsrt);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Dfecsrt> findDfecsrtEntities() {
        return findDfecsrtEntities(true, -1, -1);
    }

    public List<Dfecsrt> findDfecsrtEntities(int maxResults, int firstResult) {
        return findDfecsrtEntities(false, maxResults, firstResult);
    }

    private List<Dfecsrt> findDfecsrtEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Dfecsrt.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Dfecsrt findDfecsrt(DfecsrtPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Dfecsrt.class, id);
        } finally {
            em.close();
        }
    }

    public int getDfecsrtCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Dfecsrt> rt = cq.from(Dfecsrt.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

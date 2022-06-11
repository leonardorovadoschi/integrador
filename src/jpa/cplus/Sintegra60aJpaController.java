/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Sintegra60a;
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
public class Sintegra60aJpaController implements Serializable {

    public Sintegra60aJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sintegra60a sintegra60a) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sintegra60a);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSintegra60a(sintegra60a.getCodsintegra60a()) != null) {
                throw new PreexistingEntityException("Sintegra60a " + sintegra60a + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sintegra60a sintegra60a) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            sintegra60a = em.merge(sintegra60a);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = sintegra60a.getCodsintegra60a();
                if (findSintegra60a(id) == null) {
                    throw new NonexistentEntityException("The sintegra60a with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sintegra60a sintegra60a;
            try {
                sintegra60a = em.getReference(Sintegra60a.class, id);
                sintegra60a.getCodsintegra60a();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sintegra60a with id " + id + " no longer exists.", enfe);
            }
            em.remove(sintegra60a);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sintegra60a> findSintegra60aEntities() {
        return findSintegra60aEntities(true, -1, -1);
    }

    public List<Sintegra60a> findSintegra60aEntities(int maxResults, int firstResult) {
        return findSintegra60aEntities(false, maxResults, firstResult);
    }

    private List<Sintegra60a> findSintegra60aEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sintegra60a.class));
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

    public Sintegra60a findSintegra60a(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sintegra60a.class, id);
        } finally {
            em.close();
        }
    }

    public int getSintegra60aCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sintegra60a> rt = cq.from(Sintegra60a.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

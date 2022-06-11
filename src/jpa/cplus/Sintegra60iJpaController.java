/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Sintegra60i;
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
public class Sintegra60iJpaController implements Serializable {

    public Sintegra60iJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sintegra60i sintegra60i) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sintegra60i);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSintegra60i(sintegra60i.getCodsintegra60i()) != null) {
                throw new PreexistingEntityException("Sintegra60i " + sintegra60i + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sintegra60i sintegra60i) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            sintegra60i = em.merge(sintegra60i);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = sintegra60i.getCodsintegra60i();
                if (findSintegra60i(id) == null) {
                    throw new NonexistentEntityException("The sintegra60i with id " + id + " no longer exists.");
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
            Sintegra60i sintegra60i;
            try {
                sintegra60i = em.getReference(Sintegra60i.class, id);
                sintegra60i.getCodsintegra60i();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sintegra60i with id " + id + " no longer exists.", enfe);
            }
            em.remove(sintegra60i);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sintegra60i> findSintegra60iEntities() {
        return findSintegra60iEntities(true, -1, -1);
    }

    public List<Sintegra60i> findSintegra60iEntities(int maxResults, int firstResult) {
        return findSintegra60iEntities(false, maxResults, firstResult);
    }

    private List<Sintegra60i> findSintegra60iEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sintegra60i.class));
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

    public Sintegra60i findSintegra60i(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sintegra60i.class, id);
        } finally {
            em.close();
        }
    }

    public int getSintegra60iCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sintegra60i> rt = cq.from(Sintegra60i.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

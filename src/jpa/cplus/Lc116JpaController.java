/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Lc116;
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
public class Lc116JpaController implements Serializable {

    public Lc116JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Lc116 lc116) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(lc116);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLc116(lc116.getCodlc116()) != null) {
                throw new PreexistingEntityException("Lc116 " + lc116 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Lc116 lc116) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            lc116 = em.merge(lc116);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = lc116.getCodlc116();
                if (findLc116(id) == null) {
                    throw new NonexistentEntityException("The lc116 with id " + id + " no longer exists.");
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
            Lc116 lc116;
            try {
                lc116 = em.getReference(Lc116.class, id);
                lc116.getCodlc116();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The lc116 with id " + id + " no longer exists.", enfe);
            }
            em.remove(lc116);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Lc116> findLc116Entities() {
        return findLc116Entities(true, -1, -1);
    }

    public List<Lc116> findLc116Entities(int maxResults, int firstResult) {
        return findLc116Entities(false, maxResults, firstResult);
    }

    private List<Lc116> findLc116Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Lc116.class));
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

    public Lc116 findLc116(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Lc116.class, id);
        } finally {
            em.close();
        }
    }

    public int getLc116Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Lc116> rt = cq.from(Lc116.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

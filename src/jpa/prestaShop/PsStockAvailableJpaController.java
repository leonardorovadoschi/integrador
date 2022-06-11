/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsStockAvailable;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.prestaShop.exceptions.NonexistentEntityException;

/**
 *
 * @author leo
 */
public class PsStockAvailableJpaController implements Serializable {

    public PsStockAvailableJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsStockAvailable psStockAvailable) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psStockAvailable);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsStockAvailable psStockAvailable) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psStockAvailable = em.merge(psStockAvailable);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psStockAvailable.getIdStockAvailable();
                if (findPsStockAvailable(id) == null) {
                    throw new NonexistentEntityException("The psStockAvailable with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsStockAvailable psStockAvailable;
            try {
                psStockAvailable = em.getReference(PsStockAvailable.class, id);
                psStockAvailable.getIdStockAvailable();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psStockAvailable with id " + id + " no longer exists.", enfe);
            }
            em.remove(psStockAvailable);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsStockAvailable> findPsStockAvailableEntities() {
        return findPsStockAvailableEntities(true, -1, -1);
    }

    public List<PsStockAvailable> findPsStockAvailableEntities(int maxResults, int firstResult) {
        return findPsStockAvailableEntities(false, maxResults, firstResult);
    }

    private List<PsStockAvailable> findPsStockAvailableEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsStockAvailable.class));
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

    public PsStockAvailable findPsStockAvailable(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsStockAvailable.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsStockAvailableCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsStockAvailable> rt = cq.from(PsStockAvailable.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

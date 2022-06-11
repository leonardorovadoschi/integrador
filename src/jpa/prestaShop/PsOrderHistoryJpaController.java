/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsOrderHistory;
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
public class PsOrderHistoryJpaController implements Serializable {

    public PsOrderHistoryJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsOrderHistory psOrderHistory) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psOrderHistory);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsOrderHistory psOrderHistory) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psOrderHistory = em.merge(psOrderHistory);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psOrderHistory.getIdOrderHistory();
                if (findPsOrderHistory(id) == null) {
                    throw new NonexistentEntityException("The psOrderHistory with id " + id + " no longer exists.");
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
            PsOrderHistory psOrderHistory;
            try {
                psOrderHistory = em.getReference(PsOrderHistory.class, id);
                psOrderHistory.getIdOrderHistory();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psOrderHistory with id " + id + " no longer exists.", enfe);
            }
            em.remove(psOrderHistory);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsOrderHistory> findPsOrderHistoryEntities() {
        return findPsOrderHistoryEntities(true, -1, -1);
    }

    public List<PsOrderHistory> findPsOrderHistoryEntities(int maxResults, int firstResult) {
        return findPsOrderHistoryEntities(false, maxResults, firstResult);
    }

    private List<PsOrderHistory> findPsOrderHistoryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsOrderHistory.class));
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

    public PsOrderHistory findPsOrderHistory(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsOrderHistory.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsOrderHistoryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsOrderHistory> rt = cq.from(PsOrderHistory.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

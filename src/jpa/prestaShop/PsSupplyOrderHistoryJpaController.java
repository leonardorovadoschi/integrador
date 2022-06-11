/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsSupplyOrderHistory;
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
public class PsSupplyOrderHistoryJpaController implements Serializable {

    public PsSupplyOrderHistoryJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsSupplyOrderHistory psSupplyOrderHistory) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psSupplyOrderHistory);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsSupplyOrderHistory psSupplyOrderHistory) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psSupplyOrderHistory = em.merge(psSupplyOrderHistory);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psSupplyOrderHistory.getIdSupplyOrderHistory();
                if (findPsSupplyOrderHistory(id) == null) {
                    throw new NonexistentEntityException("The psSupplyOrderHistory with id " + id + " no longer exists.");
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
            PsSupplyOrderHistory psSupplyOrderHistory;
            try {
                psSupplyOrderHistory = em.getReference(PsSupplyOrderHistory.class, id);
                psSupplyOrderHistory.getIdSupplyOrderHistory();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psSupplyOrderHistory with id " + id + " no longer exists.", enfe);
            }
            em.remove(psSupplyOrderHistory);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsSupplyOrderHistory> findPsSupplyOrderHistoryEntities() {
        return findPsSupplyOrderHistoryEntities(true, -1, -1);
    }

    public List<PsSupplyOrderHistory> findPsSupplyOrderHistoryEntities(int maxResults, int firstResult) {
        return findPsSupplyOrderHistoryEntities(false, maxResults, firstResult);
    }

    private List<PsSupplyOrderHistory> findPsSupplyOrderHistoryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsSupplyOrderHistory.class));
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

    public PsSupplyOrderHistory findPsSupplyOrderHistory(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsSupplyOrderHistory.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsSupplyOrderHistoryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsSupplyOrderHistory> rt = cq.from(PsSupplyOrderHistory.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

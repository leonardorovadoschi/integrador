/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsSupplyOrderReceiptHistory;
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
public class PsSupplyOrderReceiptHistoryJpaController implements Serializable {

    public PsSupplyOrderReceiptHistoryJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsSupplyOrderReceiptHistory psSupplyOrderReceiptHistory) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psSupplyOrderReceiptHistory);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsSupplyOrderReceiptHistory psSupplyOrderReceiptHistory) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psSupplyOrderReceiptHistory = em.merge(psSupplyOrderReceiptHistory);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psSupplyOrderReceiptHistory.getIdSupplyOrderReceiptHistory();
                if (findPsSupplyOrderReceiptHistory(id) == null) {
                    throw new NonexistentEntityException("The psSupplyOrderReceiptHistory with id " + id + " no longer exists.");
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
            PsSupplyOrderReceiptHistory psSupplyOrderReceiptHistory;
            try {
                psSupplyOrderReceiptHistory = em.getReference(PsSupplyOrderReceiptHistory.class, id);
                psSupplyOrderReceiptHistory.getIdSupplyOrderReceiptHistory();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psSupplyOrderReceiptHistory with id " + id + " no longer exists.", enfe);
            }
            em.remove(psSupplyOrderReceiptHistory);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsSupplyOrderReceiptHistory> findPsSupplyOrderReceiptHistoryEntities() {
        return findPsSupplyOrderReceiptHistoryEntities(true, -1, -1);
    }

    public List<PsSupplyOrderReceiptHistory> findPsSupplyOrderReceiptHistoryEntities(int maxResults, int firstResult) {
        return findPsSupplyOrderReceiptHistoryEntities(false, maxResults, firstResult);
    }

    private List<PsSupplyOrderReceiptHistory> findPsSupplyOrderReceiptHistoryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsSupplyOrderReceiptHistory.class));
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

    public PsSupplyOrderReceiptHistory findPsSupplyOrderReceiptHistory(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsSupplyOrderReceiptHistory.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsSupplyOrderReceiptHistoryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsSupplyOrderReceiptHistory> rt = cq.from(PsSupplyOrderReceiptHistory.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

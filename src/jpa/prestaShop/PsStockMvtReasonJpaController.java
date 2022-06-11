/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsStockMvtReason;
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
public class PsStockMvtReasonJpaController implements Serializable {

    public PsStockMvtReasonJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsStockMvtReason psStockMvtReason) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psStockMvtReason);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsStockMvtReason psStockMvtReason) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psStockMvtReason = em.merge(psStockMvtReason);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psStockMvtReason.getIdStockMvtReason();
                if (findPsStockMvtReason(id) == null) {
                    throw new NonexistentEntityException("The psStockMvtReason with id " + id + " no longer exists.");
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
            PsStockMvtReason psStockMvtReason;
            try {
                psStockMvtReason = em.getReference(PsStockMvtReason.class, id);
                psStockMvtReason.getIdStockMvtReason();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psStockMvtReason with id " + id + " no longer exists.", enfe);
            }
            em.remove(psStockMvtReason);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsStockMvtReason> findPsStockMvtReasonEntities() {
        return findPsStockMvtReasonEntities(true, -1, -1);
    }

    public List<PsStockMvtReason> findPsStockMvtReasonEntities(int maxResults, int firstResult) {
        return findPsStockMvtReasonEntities(false, maxResults, firstResult);
    }

    private List<PsStockMvtReason> findPsStockMvtReasonEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsStockMvtReason.class));
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

    public PsStockMvtReason findPsStockMvtReason(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsStockMvtReason.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsStockMvtReasonCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsStockMvtReason> rt = cq.from(PsStockMvtReason.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsStockMvt;
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
public class PsStockMvtJpaController implements Serializable {

    public PsStockMvtJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsStockMvt psStockMvt) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psStockMvt);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsStockMvt psStockMvt) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psStockMvt = em.merge(psStockMvt);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = psStockMvt.getIdStockMvt();
                if (findPsStockMvt(id) == null) {
                    throw new NonexistentEntityException("The psStockMvt with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsStockMvt psStockMvt;
            try {
                psStockMvt = em.getReference(PsStockMvt.class, id);
                psStockMvt.getIdStockMvt();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psStockMvt with id " + id + " no longer exists.", enfe);
            }
            em.remove(psStockMvt);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsStockMvt> findPsStockMvtEntities() {
        return findPsStockMvtEntities(true, -1, -1);
    }

    public List<PsStockMvt> findPsStockMvtEntities(int maxResults, int firstResult) {
        return findPsStockMvtEntities(false, maxResults, firstResult);
    }

    private List<PsStockMvt> findPsStockMvtEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsStockMvt.class));
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

    public PsStockMvt findPsStockMvt(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsStockMvt.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsStockMvtCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsStockMvt> rt = cq.from(PsStockMvt.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

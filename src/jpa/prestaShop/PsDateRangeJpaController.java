/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsDateRange;
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
public class PsDateRangeJpaController implements Serializable {

    public PsDateRangeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsDateRange psDateRange) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psDateRange);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsDateRange psDateRange) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psDateRange = em.merge(psDateRange);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psDateRange.getIdDateRange();
                if (findPsDateRange(id) == null) {
                    throw new NonexistentEntityException("The psDateRange with id " + id + " no longer exists.");
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
            PsDateRange psDateRange;
            try {
                psDateRange = em.getReference(PsDateRange.class, id);
                psDateRange.getIdDateRange();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psDateRange with id " + id + " no longer exists.", enfe);
            }
            em.remove(psDateRange);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsDateRange> findPsDateRangeEntities() {
        return findPsDateRangeEntities(true, -1, -1);
    }

    public List<PsDateRange> findPsDateRangeEntities(int maxResults, int firstResult) {
        return findPsDateRangeEntities(false, maxResults, firstResult);
    }

    private List<PsDateRange> findPsDateRangeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsDateRange.class));
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

    public PsDateRange findPsDateRange(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsDateRange.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsDateRangeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsDateRange> rt = cq.from(PsDateRange.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

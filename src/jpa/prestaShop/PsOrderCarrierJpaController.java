/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsOrderCarrier;
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
public class PsOrderCarrierJpaController implements Serializable {

    public PsOrderCarrierJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsOrderCarrier psOrderCarrier) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psOrderCarrier);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsOrderCarrier psOrderCarrier) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psOrderCarrier = em.merge(psOrderCarrier);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psOrderCarrier.getIdOrderCarrier();
                if (findPsOrderCarrier(id) == null) {
                    throw new NonexistentEntityException("The psOrderCarrier with id " + id + " no longer exists.");
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
            PsOrderCarrier psOrderCarrier;
            try {
                psOrderCarrier = em.getReference(PsOrderCarrier.class, id);
                psOrderCarrier.getIdOrderCarrier();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psOrderCarrier with id " + id + " no longer exists.", enfe);
            }
            em.remove(psOrderCarrier);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsOrderCarrier> findPsOrderCarrierEntities() {
        return findPsOrderCarrierEntities(true, -1, -1);
    }

    public List<PsOrderCarrier> findPsOrderCarrierEntities(int maxResults, int firstResult) {
        return findPsOrderCarrierEntities(false, maxResults, firstResult);
    }

    private List<PsOrderCarrier> findPsOrderCarrierEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsOrderCarrier.class));
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

    public PsOrderCarrier findPsOrderCarrier(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsOrderCarrier.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsOrderCarrierCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsOrderCarrier> rt = cq.from(PsOrderCarrier.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

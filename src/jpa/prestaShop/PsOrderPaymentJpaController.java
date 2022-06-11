/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsOrderPayment;
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
public class PsOrderPaymentJpaController implements Serializable {

    public PsOrderPaymentJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsOrderPayment psOrderPayment) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psOrderPayment);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsOrderPayment psOrderPayment) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psOrderPayment = em.merge(psOrderPayment);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psOrderPayment.getIdOrderPayment();
                if (findPsOrderPayment(id) == null) {
                    throw new NonexistentEntityException("The psOrderPayment with id " + id + " no longer exists.");
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
            PsOrderPayment psOrderPayment;
            try {
                psOrderPayment = em.getReference(PsOrderPayment.class, id);
                psOrderPayment.getIdOrderPayment();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psOrderPayment with id " + id + " no longer exists.", enfe);
            }
            em.remove(psOrderPayment);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsOrderPayment> findPsOrderPaymentEntities() {
        return findPsOrderPaymentEntities(true, -1, -1);
    }

    public List<PsOrderPayment> findPsOrderPaymentEntities(int maxResults, int firstResult) {
        return findPsOrderPaymentEntities(false, maxResults, firstResult);
    }

    private List<PsOrderPayment> findPsOrderPaymentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsOrderPayment.class));
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

    public PsOrderPayment findPsOrderPayment(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsOrderPayment.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsOrderPaymentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsOrderPayment> rt = cq.from(PsOrderPayment.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

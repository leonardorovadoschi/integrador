/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsOrderInvoicePayment;
import entidade.prestaShop.PsOrderInvoicePaymentPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.prestaShop.exceptions.NonexistentEntityException;
import jpa.prestaShop.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class PsOrderInvoicePaymentJpaController implements Serializable {

    public PsOrderInvoicePaymentJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsOrderInvoicePayment psOrderInvoicePayment) throws PreexistingEntityException, Exception {
        if (psOrderInvoicePayment.getPsOrderInvoicePaymentPK() == null) {
            psOrderInvoicePayment.setPsOrderInvoicePaymentPK(new PsOrderInvoicePaymentPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psOrderInvoicePayment);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsOrderInvoicePayment(psOrderInvoicePayment.getPsOrderInvoicePaymentPK()) != null) {
                throw new PreexistingEntityException("PsOrderInvoicePayment " + psOrderInvoicePayment + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsOrderInvoicePayment psOrderInvoicePayment) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psOrderInvoicePayment = em.merge(psOrderInvoicePayment);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsOrderInvoicePaymentPK id = psOrderInvoicePayment.getPsOrderInvoicePaymentPK();
                if (findPsOrderInvoicePayment(id) == null) {
                    throw new NonexistentEntityException("The psOrderInvoicePayment with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsOrderInvoicePaymentPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsOrderInvoicePayment psOrderInvoicePayment;
            try {
                psOrderInvoicePayment = em.getReference(PsOrderInvoicePayment.class, id);
                psOrderInvoicePayment.getPsOrderInvoicePaymentPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psOrderInvoicePayment with id " + id + " no longer exists.", enfe);
            }
            em.remove(psOrderInvoicePayment);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsOrderInvoicePayment> findPsOrderInvoicePaymentEntities() {
        return findPsOrderInvoicePaymentEntities(true, -1, -1);
    }

    public List<PsOrderInvoicePayment> findPsOrderInvoicePaymentEntities(int maxResults, int firstResult) {
        return findPsOrderInvoicePaymentEntities(false, maxResults, firstResult);
    }

    private List<PsOrderInvoicePayment> findPsOrderInvoicePaymentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsOrderInvoicePayment.class));
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

    public PsOrderInvoicePayment findPsOrderInvoicePayment(PsOrderInvoicePaymentPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsOrderInvoicePayment.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsOrderInvoicePaymentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsOrderInvoicePayment> rt = cq.from(PsOrderInvoicePayment.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsOrderInvoice;
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
public class PsOrderInvoiceJpaController implements Serializable {

    public PsOrderInvoiceJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsOrderInvoice psOrderInvoice) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psOrderInvoice);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsOrderInvoice psOrderInvoice) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psOrderInvoice = em.merge(psOrderInvoice);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psOrderInvoice.getIdOrderInvoice();
                if (findPsOrderInvoice(id) == null) {
                    throw new NonexistentEntityException("The psOrderInvoice with id " + id + " no longer exists.");
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
            PsOrderInvoice psOrderInvoice;
            try {
                psOrderInvoice = em.getReference(PsOrderInvoice.class, id);
                psOrderInvoice.getIdOrderInvoice();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psOrderInvoice with id " + id + " no longer exists.", enfe);
            }
            em.remove(psOrderInvoice);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsOrderInvoice> findPsOrderInvoiceEntities() {
        return findPsOrderInvoiceEntities(true, -1, -1);
    }

    public List<PsOrderInvoice> findPsOrderInvoiceEntities(int maxResults, int firstResult) {
        return findPsOrderInvoiceEntities(false, maxResults, firstResult);
    }

    private List<PsOrderInvoice> findPsOrderInvoiceEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsOrderInvoice.class));
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

    public PsOrderInvoice findPsOrderInvoice(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsOrderInvoice.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsOrderInvoiceCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsOrderInvoice> rt = cq.from(PsOrderInvoice.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

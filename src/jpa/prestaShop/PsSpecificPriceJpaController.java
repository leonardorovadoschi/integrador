/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsSpecificPrice;
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
public class PsSpecificPriceJpaController implements Serializable {

    public PsSpecificPriceJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsSpecificPrice psSpecificPrice) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psSpecificPrice);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsSpecificPrice psSpecificPrice) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psSpecificPrice = em.merge(psSpecificPrice);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psSpecificPrice.getIdSpecificPrice();
                if (findPsSpecificPrice(id) == null) {
                    throw new NonexistentEntityException("The psSpecificPrice with id " + id + " no longer exists.");
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
            PsSpecificPrice psSpecificPrice;
            try {
                psSpecificPrice = em.getReference(PsSpecificPrice.class, id);
                psSpecificPrice.getIdSpecificPrice();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psSpecificPrice with id " + id + " no longer exists.", enfe);
            }
            em.remove(psSpecificPrice);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsSpecificPrice> findPsSpecificPriceEntities() {
        return findPsSpecificPriceEntities(true, -1, -1);
    }

    public List<PsSpecificPrice> findPsSpecificPriceEntities(int maxResults, int firstResult) {
        return findPsSpecificPriceEntities(false, maxResults, firstResult);
    }

    private List<PsSpecificPrice> findPsSpecificPriceEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsSpecificPrice.class));
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

    public PsSpecificPrice findPsSpecificPrice(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsSpecificPrice.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsSpecificPriceCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsSpecificPrice> rt = cq.from(PsSpecificPrice.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

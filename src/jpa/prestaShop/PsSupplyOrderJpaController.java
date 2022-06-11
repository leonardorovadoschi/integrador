/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsSupplyOrder;
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
public class PsSupplyOrderJpaController implements Serializable {

    public PsSupplyOrderJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsSupplyOrder psSupplyOrder) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psSupplyOrder);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsSupplyOrder psSupplyOrder) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psSupplyOrder = em.merge(psSupplyOrder);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psSupplyOrder.getIdSupplyOrder();
                if (findPsSupplyOrder(id) == null) {
                    throw new NonexistentEntityException("The psSupplyOrder with id " + id + " no longer exists.");
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
            PsSupplyOrder psSupplyOrder;
            try {
                psSupplyOrder = em.getReference(PsSupplyOrder.class, id);
                psSupplyOrder.getIdSupplyOrder();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psSupplyOrder with id " + id + " no longer exists.", enfe);
            }
            em.remove(psSupplyOrder);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsSupplyOrder> findPsSupplyOrderEntities() {
        return findPsSupplyOrderEntities(true, -1, -1);
    }

    public List<PsSupplyOrder> findPsSupplyOrderEntities(int maxResults, int firstResult) {
        return findPsSupplyOrderEntities(false, maxResults, firstResult);
    }

    private List<PsSupplyOrder> findPsSupplyOrderEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsSupplyOrder.class));
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

    public PsSupplyOrder findPsSupplyOrder(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsSupplyOrder.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsSupplyOrderCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsSupplyOrder> rt = cq.from(PsSupplyOrder.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

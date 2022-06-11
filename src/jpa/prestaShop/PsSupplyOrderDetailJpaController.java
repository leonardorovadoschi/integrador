/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsSupplyOrderDetail;
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
public class PsSupplyOrderDetailJpaController implements Serializable {

    public PsSupplyOrderDetailJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsSupplyOrderDetail psSupplyOrderDetail) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psSupplyOrderDetail);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsSupplyOrderDetail psSupplyOrderDetail) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psSupplyOrderDetail = em.merge(psSupplyOrderDetail);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psSupplyOrderDetail.getIdSupplyOrderDetail();
                if (findPsSupplyOrderDetail(id) == null) {
                    throw new NonexistentEntityException("The psSupplyOrderDetail with id " + id + " no longer exists.");
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
            PsSupplyOrderDetail psSupplyOrderDetail;
            try {
                psSupplyOrderDetail = em.getReference(PsSupplyOrderDetail.class, id);
                psSupplyOrderDetail.getIdSupplyOrderDetail();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psSupplyOrderDetail with id " + id + " no longer exists.", enfe);
            }
            em.remove(psSupplyOrderDetail);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsSupplyOrderDetail> findPsSupplyOrderDetailEntities() {
        return findPsSupplyOrderDetailEntities(true, -1, -1);
    }

    public List<PsSupplyOrderDetail> findPsSupplyOrderDetailEntities(int maxResults, int firstResult) {
        return findPsSupplyOrderDetailEntities(false, maxResults, firstResult);
    }

    private List<PsSupplyOrderDetail> findPsSupplyOrderDetailEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsSupplyOrderDetail.class));
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

    public PsSupplyOrderDetail findPsSupplyOrderDetail(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsSupplyOrderDetail.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsSupplyOrderDetailCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsSupplyOrderDetail> rt = cq.from(PsSupplyOrderDetail.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

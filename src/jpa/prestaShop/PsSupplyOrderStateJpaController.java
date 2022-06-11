/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsSupplyOrderState;
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
public class PsSupplyOrderStateJpaController implements Serializable {

    public PsSupplyOrderStateJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsSupplyOrderState psSupplyOrderState) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psSupplyOrderState);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsSupplyOrderState psSupplyOrderState) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psSupplyOrderState = em.merge(psSupplyOrderState);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psSupplyOrderState.getIdSupplyOrderState();
                if (findPsSupplyOrderState(id) == null) {
                    throw new NonexistentEntityException("The psSupplyOrderState with id " + id + " no longer exists.");
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
            PsSupplyOrderState psSupplyOrderState;
            try {
                psSupplyOrderState = em.getReference(PsSupplyOrderState.class, id);
                psSupplyOrderState.getIdSupplyOrderState();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psSupplyOrderState with id " + id + " no longer exists.", enfe);
            }
            em.remove(psSupplyOrderState);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsSupplyOrderState> findPsSupplyOrderStateEntities() {
        return findPsSupplyOrderStateEntities(true, -1, -1);
    }

    public List<PsSupplyOrderState> findPsSupplyOrderStateEntities(int maxResults, int firstResult) {
        return findPsSupplyOrderStateEntities(false, maxResults, firstResult);
    }

    private List<PsSupplyOrderState> findPsSupplyOrderStateEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsSupplyOrderState.class));
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

    public PsSupplyOrderState findPsSupplyOrderState(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsSupplyOrderState.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsSupplyOrderStateCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsSupplyOrderState> rt = cq.from(PsSupplyOrderState.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

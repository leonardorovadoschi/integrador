/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsRangeWeight;
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
public class PsRangeWeightJpaController implements Serializable {

    public PsRangeWeightJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsRangeWeight psRangeWeight) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psRangeWeight);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsRangeWeight psRangeWeight) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psRangeWeight = em.merge(psRangeWeight);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psRangeWeight.getIdRangeWeight();
                if (findPsRangeWeight(id) == null) {
                    throw new NonexistentEntityException("The psRangeWeight with id " + id + " no longer exists.");
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
            PsRangeWeight psRangeWeight;
            try {
                psRangeWeight = em.getReference(PsRangeWeight.class, id);
                psRangeWeight.getIdRangeWeight();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psRangeWeight with id " + id + " no longer exists.", enfe);
            }
            em.remove(psRangeWeight);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsRangeWeight> findPsRangeWeightEntities() {
        return findPsRangeWeightEntities(true, -1, -1);
    }

    public List<PsRangeWeight> findPsRangeWeightEntities(int maxResults, int firstResult) {
        return findPsRangeWeightEntities(false, maxResults, firstResult);
    }

    private List<PsRangeWeight> findPsRangeWeightEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsRangeWeight.class));
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

    public PsRangeWeight findPsRangeWeight(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsRangeWeight.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsRangeWeightCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsRangeWeight> rt = cq.from(PsRangeWeight.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

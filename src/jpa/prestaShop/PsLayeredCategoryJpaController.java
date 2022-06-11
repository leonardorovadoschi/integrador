/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsLayeredCategory;
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
public class PsLayeredCategoryJpaController implements Serializable {

    public PsLayeredCategoryJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsLayeredCategory psLayeredCategory) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psLayeredCategory);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsLayeredCategory psLayeredCategory) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psLayeredCategory = em.merge(psLayeredCategory);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psLayeredCategory.getIdLayeredCategory();
                if (findPsLayeredCategory(id) == null) {
                    throw new NonexistentEntityException("The psLayeredCategory with id " + id + " no longer exists.");
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
            PsLayeredCategory psLayeredCategory;
            try {
                psLayeredCategory = em.getReference(PsLayeredCategory.class, id);
                psLayeredCategory.getIdLayeredCategory();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psLayeredCategory with id " + id + " no longer exists.", enfe);
            }
            em.remove(psLayeredCategory);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsLayeredCategory> findPsLayeredCategoryEntities() {
        return findPsLayeredCategoryEntities(true, -1, -1);
    }

    public List<PsLayeredCategory> findPsLayeredCategoryEntities(int maxResults, int firstResult) {
        return findPsLayeredCategoryEntities(false, maxResults, firstResult);
    }

    private List<PsLayeredCategory> findPsLayeredCategoryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsLayeredCategory.class));
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

    public PsLayeredCategory findPsLayeredCategory(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsLayeredCategory.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsLayeredCategoryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsLayeredCategory> rt = cq.from(PsLayeredCategory.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

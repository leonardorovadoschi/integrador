/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsSpecificPriceRuleCondition;
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
public class PsSpecificPriceRuleConditionJpaController implements Serializable {

    public PsSpecificPriceRuleConditionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsSpecificPriceRuleCondition psSpecificPriceRuleCondition) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psSpecificPriceRuleCondition);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsSpecificPriceRuleCondition psSpecificPriceRuleCondition) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psSpecificPriceRuleCondition = em.merge(psSpecificPriceRuleCondition);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psSpecificPriceRuleCondition.getIdSpecificPriceRuleCondition();
                if (findPsSpecificPriceRuleCondition(id) == null) {
                    throw new NonexistentEntityException("The psSpecificPriceRuleCondition with id " + id + " no longer exists.");
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
            PsSpecificPriceRuleCondition psSpecificPriceRuleCondition;
            try {
                psSpecificPriceRuleCondition = em.getReference(PsSpecificPriceRuleCondition.class, id);
                psSpecificPriceRuleCondition.getIdSpecificPriceRuleCondition();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psSpecificPriceRuleCondition with id " + id + " no longer exists.", enfe);
            }
            em.remove(psSpecificPriceRuleCondition);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsSpecificPriceRuleCondition> findPsSpecificPriceRuleConditionEntities() {
        return findPsSpecificPriceRuleConditionEntities(true, -1, -1);
    }

    public List<PsSpecificPriceRuleCondition> findPsSpecificPriceRuleConditionEntities(int maxResults, int firstResult) {
        return findPsSpecificPriceRuleConditionEntities(false, maxResults, firstResult);
    }

    private List<PsSpecificPriceRuleCondition> findPsSpecificPriceRuleConditionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsSpecificPriceRuleCondition.class));
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

    public PsSpecificPriceRuleCondition findPsSpecificPriceRuleCondition(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsSpecificPriceRuleCondition.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsSpecificPriceRuleConditionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsSpecificPriceRuleCondition> rt = cq.from(PsSpecificPriceRuleCondition.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

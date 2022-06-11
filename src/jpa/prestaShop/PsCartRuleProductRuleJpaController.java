/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCartRuleProductRule;
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
public class PsCartRuleProductRuleJpaController implements Serializable {

    public PsCartRuleProductRuleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCartRuleProductRule psCartRuleProductRule) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCartRuleProductRule);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCartRuleProductRule psCartRuleProductRule) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCartRuleProductRule = em.merge(psCartRuleProductRule);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psCartRuleProductRule.getIdProductRule();
                if (findPsCartRuleProductRule(id) == null) {
                    throw new NonexistentEntityException("The psCartRuleProductRule with id " + id + " no longer exists.");
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
            PsCartRuleProductRule psCartRuleProductRule;
            try {
                psCartRuleProductRule = em.getReference(PsCartRuleProductRule.class, id);
                psCartRuleProductRule.getIdProductRule();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCartRuleProductRule with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCartRuleProductRule);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCartRuleProductRule> findPsCartRuleProductRuleEntities() {
        return findPsCartRuleProductRuleEntities(true, -1, -1);
    }

    public List<PsCartRuleProductRule> findPsCartRuleProductRuleEntities(int maxResults, int firstResult) {
        return findPsCartRuleProductRuleEntities(false, maxResults, firstResult);
    }

    private List<PsCartRuleProductRule> findPsCartRuleProductRuleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCartRuleProductRule.class));
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

    public PsCartRuleProductRule findPsCartRuleProductRule(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCartRuleProductRule.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCartRuleProductRuleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCartRuleProductRule> rt = cq.from(PsCartRuleProductRule.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsTaxRule;
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
public class PsTaxRuleJpaController implements Serializable {

    public PsTaxRuleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsTaxRule psTaxRule) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psTaxRule);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsTaxRule psTaxRule) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psTaxRule = em.merge(psTaxRule);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psTaxRule.getIdTaxRule();
                if (findPsTaxRule(id) == null) {
                    throw new NonexistentEntityException("The psTaxRule with id " + id + " no longer exists.");
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
            PsTaxRule psTaxRule;
            try {
                psTaxRule = em.getReference(PsTaxRule.class, id);
                psTaxRule.getIdTaxRule();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psTaxRule with id " + id + " no longer exists.", enfe);
            }
            em.remove(psTaxRule);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsTaxRule> findPsTaxRuleEntities() {
        return findPsTaxRuleEntities(true, -1, -1);
    }

    public List<PsTaxRule> findPsTaxRuleEntities(int maxResults, int firstResult) {
        return findPsTaxRuleEntities(false, maxResults, firstResult);
    }

    private List<PsTaxRule> findPsTaxRuleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsTaxRule.class));
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

    public PsTaxRule findPsTaxRule(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsTaxRule.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsTaxRuleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsTaxRule> rt = cq.from(PsTaxRule.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

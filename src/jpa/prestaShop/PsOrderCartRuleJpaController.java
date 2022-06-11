/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsOrderCartRule;
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
public class PsOrderCartRuleJpaController implements Serializable {

    public PsOrderCartRuleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsOrderCartRule psOrderCartRule) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psOrderCartRule);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsOrderCartRule psOrderCartRule) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psOrderCartRule = em.merge(psOrderCartRule);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psOrderCartRule.getIdOrderCartRule();
                if (findPsOrderCartRule(id) == null) {
                    throw new NonexistentEntityException("The psOrderCartRule with id " + id + " no longer exists.");
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
            PsOrderCartRule psOrderCartRule;
            try {
                psOrderCartRule = em.getReference(PsOrderCartRule.class, id);
                psOrderCartRule.getIdOrderCartRule();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psOrderCartRule with id " + id + " no longer exists.", enfe);
            }
            em.remove(psOrderCartRule);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsOrderCartRule> findPsOrderCartRuleEntities() {
        return findPsOrderCartRuleEntities(true, -1, -1);
    }

    public List<PsOrderCartRule> findPsOrderCartRuleEntities(int maxResults, int firstResult) {
        return findPsOrderCartRuleEntities(false, maxResults, firstResult);
    }

    private List<PsOrderCartRule> findPsOrderCartRuleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsOrderCartRule.class));
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

    public PsOrderCartRule findPsOrderCartRule(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsOrderCartRule.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsOrderCartRuleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsOrderCartRule> rt = cq.from(PsOrderCartRule.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

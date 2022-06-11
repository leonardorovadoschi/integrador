/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCartCartRule;
import entidade.prestaShop.PsCartCartRulePK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.prestaShop.exceptions.NonexistentEntityException;
import jpa.prestaShop.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class PsCartCartRuleJpaController implements Serializable {

    public PsCartCartRuleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCartCartRule psCartCartRule) throws PreexistingEntityException, Exception {
        if (psCartCartRule.getPsCartCartRulePK() == null) {
            psCartCartRule.setPsCartCartRulePK(new PsCartCartRulePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCartCartRule);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCartCartRule(psCartCartRule.getPsCartCartRulePK()) != null) {
                throw new PreexistingEntityException("PsCartCartRule " + psCartCartRule + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCartCartRule psCartCartRule) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCartCartRule = em.merge(psCartCartRule);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCartCartRulePK id = psCartCartRule.getPsCartCartRulePK();
                if (findPsCartCartRule(id) == null) {
                    throw new NonexistentEntityException("The psCartCartRule with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCartCartRulePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCartCartRule psCartCartRule;
            try {
                psCartCartRule = em.getReference(PsCartCartRule.class, id);
                psCartCartRule.getPsCartCartRulePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCartCartRule with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCartCartRule);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCartCartRule> findPsCartCartRuleEntities() {
        return findPsCartCartRuleEntities(true, -1, -1);
    }

    public List<PsCartCartRule> findPsCartCartRuleEntities(int maxResults, int firstResult) {
        return findPsCartCartRuleEntities(false, maxResults, firstResult);
    }

    private List<PsCartCartRule> findPsCartCartRuleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCartCartRule.class));
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

    public PsCartCartRule findPsCartCartRule(PsCartCartRulePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCartCartRule.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCartCartRuleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCartCartRule> rt = cq.from(PsCartCartRule.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

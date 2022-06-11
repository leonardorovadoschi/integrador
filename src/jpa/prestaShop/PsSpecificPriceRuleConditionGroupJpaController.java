/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsSpecificPriceRuleConditionGroup;
import entidade.prestaShop.PsSpecificPriceRuleConditionGroupPK;
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
public class PsSpecificPriceRuleConditionGroupJpaController implements Serializable {

    public PsSpecificPriceRuleConditionGroupJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsSpecificPriceRuleConditionGroup psSpecificPriceRuleConditionGroup) throws PreexistingEntityException, Exception {
        if (psSpecificPriceRuleConditionGroup.getPsSpecificPriceRuleConditionGroupPK() == null) {
            psSpecificPriceRuleConditionGroup.setPsSpecificPriceRuleConditionGroupPK(new PsSpecificPriceRuleConditionGroupPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psSpecificPriceRuleConditionGroup);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsSpecificPriceRuleConditionGroup(psSpecificPriceRuleConditionGroup.getPsSpecificPriceRuleConditionGroupPK()) != null) {
                throw new PreexistingEntityException("PsSpecificPriceRuleConditionGroup " + psSpecificPriceRuleConditionGroup + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsSpecificPriceRuleConditionGroup psSpecificPriceRuleConditionGroup) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psSpecificPriceRuleConditionGroup = em.merge(psSpecificPriceRuleConditionGroup);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsSpecificPriceRuleConditionGroupPK id = psSpecificPriceRuleConditionGroup.getPsSpecificPriceRuleConditionGroupPK();
                if (findPsSpecificPriceRuleConditionGroup(id) == null) {
                    throw new NonexistentEntityException("The psSpecificPriceRuleConditionGroup with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsSpecificPriceRuleConditionGroupPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsSpecificPriceRuleConditionGroup psSpecificPriceRuleConditionGroup;
            try {
                psSpecificPriceRuleConditionGroup = em.getReference(PsSpecificPriceRuleConditionGroup.class, id);
                psSpecificPriceRuleConditionGroup.getPsSpecificPriceRuleConditionGroupPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psSpecificPriceRuleConditionGroup with id " + id + " no longer exists.", enfe);
            }
            em.remove(psSpecificPriceRuleConditionGroup);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsSpecificPriceRuleConditionGroup> findPsSpecificPriceRuleConditionGroupEntities() {
        return findPsSpecificPriceRuleConditionGroupEntities(true, -1, -1);
    }

    public List<PsSpecificPriceRuleConditionGroup> findPsSpecificPriceRuleConditionGroupEntities(int maxResults, int firstResult) {
        return findPsSpecificPriceRuleConditionGroupEntities(false, maxResults, firstResult);
    }

    private List<PsSpecificPriceRuleConditionGroup> findPsSpecificPriceRuleConditionGroupEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsSpecificPriceRuleConditionGroup.class));
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

    public PsSpecificPriceRuleConditionGroup findPsSpecificPriceRuleConditionGroup(PsSpecificPriceRuleConditionGroupPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsSpecificPriceRuleConditionGroup.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsSpecificPriceRuleConditionGroupCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsSpecificPriceRuleConditionGroup> rt = cq.from(PsSpecificPriceRuleConditionGroup.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

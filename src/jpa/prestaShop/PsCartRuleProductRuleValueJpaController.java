/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCartRuleProductRuleValue;
import entidade.prestaShop.PsCartRuleProductRuleValuePK;
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
public class PsCartRuleProductRuleValueJpaController implements Serializable {

    public PsCartRuleProductRuleValueJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCartRuleProductRuleValue psCartRuleProductRuleValue) throws PreexistingEntityException, Exception {
        if (psCartRuleProductRuleValue.getPsCartRuleProductRuleValuePK() == null) {
            psCartRuleProductRuleValue.setPsCartRuleProductRuleValuePK(new PsCartRuleProductRuleValuePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCartRuleProductRuleValue);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCartRuleProductRuleValue(psCartRuleProductRuleValue.getPsCartRuleProductRuleValuePK()) != null) {
                throw new PreexistingEntityException("PsCartRuleProductRuleValue " + psCartRuleProductRuleValue + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCartRuleProductRuleValue psCartRuleProductRuleValue) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCartRuleProductRuleValue = em.merge(psCartRuleProductRuleValue);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCartRuleProductRuleValuePK id = psCartRuleProductRuleValue.getPsCartRuleProductRuleValuePK();
                if (findPsCartRuleProductRuleValue(id) == null) {
                    throw new NonexistentEntityException("The psCartRuleProductRuleValue with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCartRuleProductRuleValuePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCartRuleProductRuleValue psCartRuleProductRuleValue;
            try {
                psCartRuleProductRuleValue = em.getReference(PsCartRuleProductRuleValue.class, id);
                psCartRuleProductRuleValue.getPsCartRuleProductRuleValuePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCartRuleProductRuleValue with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCartRuleProductRuleValue);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCartRuleProductRuleValue> findPsCartRuleProductRuleValueEntities() {
        return findPsCartRuleProductRuleValueEntities(true, -1, -1);
    }

    public List<PsCartRuleProductRuleValue> findPsCartRuleProductRuleValueEntities(int maxResults, int firstResult) {
        return findPsCartRuleProductRuleValueEntities(false, maxResults, firstResult);
    }

    private List<PsCartRuleProductRuleValue> findPsCartRuleProductRuleValueEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCartRuleProductRuleValue.class));
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

    public PsCartRuleProductRuleValue findPsCartRuleProductRuleValue(PsCartRuleProductRuleValuePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCartRuleProductRuleValue.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCartRuleProductRuleValueCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCartRuleProductRuleValue> rt = cq.from(PsCartRuleProductRuleValue.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCondition;
import entidade.prestaShop.PsConditionPK;
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
public class PsConditionJpaController implements Serializable {

    public PsConditionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCondition psCondition) throws PreexistingEntityException, Exception {
        if (psCondition.getPsConditionPK() == null) {
            psCondition.setPsConditionPK(new PsConditionPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCondition);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCondition(psCondition.getPsConditionPK()) != null) {
                throw new PreexistingEntityException("PsCondition " + psCondition + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCondition psCondition) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCondition = em.merge(psCondition);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsConditionPK id = psCondition.getPsConditionPK();
                if (findPsCondition(id) == null) {
                    throw new NonexistentEntityException("The psCondition with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsConditionPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCondition psCondition;
            try {
                psCondition = em.getReference(PsCondition.class, id);
                psCondition.getPsConditionPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCondition with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCondition);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCondition> findPsConditionEntities() {
        return findPsConditionEntities(true, -1, -1);
    }

    public List<PsCondition> findPsConditionEntities(int maxResults, int firstResult) {
        return findPsConditionEntities(false, maxResults, firstResult);
    }

    private List<PsCondition> findPsConditionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCondition.class));
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

    public PsCondition findPsCondition(PsConditionPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCondition.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsConditionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCondition> rt = cq.from(PsCondition.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

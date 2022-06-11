/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsConditionBadge;
import entidade.prestaShop.PsConditionBadgePK;
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
public class PsConditionBadgeJpaController implements Serializable {

    public PsConditionBadgeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsConditionBadge psConditionBadge) throws PreexistingEntityException, Exception {
        if (psConditionBadge.getPsConditionBadgePK() == null) {
            psConditionBadge.setPsConditionBadgePK(new PsConditionBadgePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psConditionBadge);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsConditionBadge(psConditionBadge.getPsConditionBadgePK()) != null) {
                throw new PreexistingEntityException("PsConditionBadge " + psConditionBadge + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsConditionBadge psConditionBadge) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psConditionBadge = em.merge(psConditionBadge);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsConditionBadgePK id = psConditionBadge.getPsConditionBadgePK();
                if (findPsConditionBadge(id) == null) {
                    throw new NonexistentEntityException("The psConditionBadge with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsConditionBadgePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsConditionBadge psConditionBadge;
            try {
                psConditionBadge = em.getReference(PsConditionBadge.class, id);
                psConditionBadge.getPsConditionBadgePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psConditionBadge with id " + id + " no longer exists.", enfe);
            }
            em.remove(psConditionBadge);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsConditionBadge> findPsConditionBadgeEntities() {
        return findPsConditionBadgeEntities(true, -1, -1);
    }

    public List<PsConditionBadge> findPsConditionBadgeEntities(int maxResults, int firstResult) {
        return findPsConditionBadgeEntities(false, maxResults, firstResult);
    }

    private List<PsConditionBadge> findPsConditionBadgeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsConditionBadge.class));
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

    public PsConditionBadge findPsConditionBadge(PsConditionBadgePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsConditionBadge.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsConditionBadgeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsConditionBadge> rt = cq.from(PsConditionBadge.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

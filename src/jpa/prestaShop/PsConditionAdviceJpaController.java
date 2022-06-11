/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsConditionAdvice;
import entidade.prestaShop.PsConditionAdvicePK;
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
public class PsConditionAdviceJpaController implements Serializable {

    public PsConditionAdviceJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsConditionAdvice psConditionAdvice) throws PreexistingEntityException, Exception {
        if (psConditionAdvice.getPsConditionAdvicePK() == null) {
            psConditionAdvice.setPsConditionAdvicePK(new PsConditionAdvicePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psConditionAdvice);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsConditionAdvice(psConditionAdvice.getPsConditionAdvicePK()) != null) {
                throw new PreexistingEntityException("PsConditionAdvice " + psConditionAdvice + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsConditionAdvice psConditionAdvice) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psConditionAdvice = em.merge(psConditionAdvice);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsConditionAdvicePK id = psConditionAdvice.getPsConditionAdvicePK();
                if (findPsConditionAdvice(id) == null) {
                    throw new NonexistentEntityException("The psConditionAdvice with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsConditionAdvicePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsConditionAdvice psConditionAdvice;
            try {
                psConditionAdvice = em.getReference(PsConditionAdvice.class, id);
                psConditionAdvice.getPsConditionAdvicePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psConditionAdvice with id " + id + " no longer exists.", enfe);
            }
            em.remove(psConditionAdvice);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsConditionAdvice> findPsConditionAdviceEntities() {
        return findPsConditionAdviceEntities(true, -1, -1);
    }

    public List<PsConditionAdvice> findPsConditionAdviceEntities(int maxResults, int firstResult) {
        return findPsConditionAdviceEntities(false, maxResults, firstResult);
    }

    private List<PsConditionAdvice> findPsConditionAdviceEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsConditionAdvice.class));
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

    public PsConditionAdvice findPsConditionAdvice(PsConditionAdvicePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsConditionAdvice.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsConditionAdviceCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsConditionAdvice> rt = cq.from(PsConditionAdvice.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

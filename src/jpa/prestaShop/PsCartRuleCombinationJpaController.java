/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCartRuleCombination;
import entidade.prestaShop.PsCartRuleCombinationPK;
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
public class PsCartRuleCombinationJpaController implements Serializable {

    public PsCartRuleCombinationJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCartRuleCombination psCartRuleCombination) throws PreexistingEntityException, Exception {
        if (psCartRuleCombination.getPsCartRuleCombinationPK() == null) {
            psCartRuleCombination.setPsCartRuleCombinationPK(new PsCartRuleCombinationPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCartRuleCombination);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCartRuleCombination(psCartRuleCombination.getPsCartRuleCombinationPK()) != null) {
                throw new PreexistingEntityException("PsCartRuleCombination " + psCartRuleCombination + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCartRuleCombination psCartRuleCombination) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCartRuleCombination = em.merge(psCartRuleCombination);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCartRuleCombinationPK id = psCartRuleCombination.getPsCartRuleCombinationPK();
                if (findPsCartRuleCombination(id) == null) {
                    throw new NonexistentEntityException("The psCartRuleCombination with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCartRuleCombinationPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCartRuleCombination psCartRuleCombination;
            try {
                psCartRuleCombination = em.getReference(PsCartRuleCombination.class, id);
                psCartRuleCombination.getPsCartRuleCombinationPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCartRuleCombination with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCartRuleCombination);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCartRuleCombination> findPsCartRuleCombinationEntities() {
        return findPsCartRuleCombinationEntities(true, -1, -1);
    }

    public List<PsCartRuleCombination> findPsCartRuleCombinationEntities(int maxResults, int firstResult) {
        return findPsCartRuleCombinationEntities(false, maxResults, firstResult);
    }

    private List<PsCartRuleCombination> findPsCartRuleCombinationEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCartRuleCombination.class));
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

    public PsCartRuleCombination findPsCartRuleCombination(PsCartRuleCombinationPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCartRuleCombination.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCartRuleCombinationCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCartRuleCombination> rt = cq.from(PsCartRuleCombination.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

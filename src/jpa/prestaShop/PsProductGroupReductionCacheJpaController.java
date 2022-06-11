/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsProductGroupReductionCache;
import entidade.prestaShop.PsProductGroupReductionCachePK;
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
public class PsProductGroupReductionCacheJpaController implements Serializable {

    public PsProductGroupReductionCacheJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsProductGroupReductionCache psProductGroupReductionCache) throws PreexistingEntityException, Exception {
        if (psProductGroupReductionCache.getPsProductGroupReductionCachePK() == null) {
            psProductGroupReductionCache.setPsProductGroupReductionCachePK(new PsProductGroupReductionCachePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psProductGroupReductionCache);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsProductGroupReductionCache(psProductGroupReductionCache.getPsProductGroupReductionCachePK()) != null) {
                throw new PreexistingEntityException("PsProductGroupReductionCache " + psProductGroupReductionCache + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsProductGroupReductionCache psProductGroupReductionCache) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psProductGroupReductionCache = em.merge(psProductGroupReductionCache);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsProductGroupReductionCachePK id = psProductGroupReductionCache.getPsProductGroupReductionCachePK();
                if (findPsProductGroupReductionCache(id) == null) {
                    throw new NonexistentEntityException("The psProductGroupReductionCache with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsProductGroupReductionCachePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsProductGroupReductionCache psProductGroupReductionCache;
            try {
                psProductGroupReductionCache = em.getReference(PsProductGroupReductionCache.class, id);
                psProductGroupReductionCache.getPsProductGroupReductionCachePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psProductGroupReductionCache with id " + id + " no longer exists.", enfe);
            }
            em.remove(psProductGroupReductionCache);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsProductGroupReductionCache> findPsProductGroupReductionCacheEntities() {
        return findPsProductGroupReductionCacheEntities(true, -1, -1);
    }

    public List<PsProductGroupReductionCache> findPsProductGroupReductionCacheEntities(int maxResults, int firstResult) {
        return findPsProductGroupReductionCacheEntities(false, maxResults, firstResult);
    }

    private List<PsProductGroupReductionCache> findPsProductGroupReductionCacheEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsProductGroupReductionCache.class));
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

    public PsProductGroupReductionCache findPsProductGroupReductionCache(PsProductGroupReductionCachePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsProductGroupReductionCache.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsProductGroupReductionCacheCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsProductGroupReductionCache> rt = cq.from(PsProductGroupReductionCache.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

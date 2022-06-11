/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsReferrerCache;
import entidade.prestaShop.PsReferrerCachePK;
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
public class PsReferrerCacheJpaController implements Serializable {

    public PsReferrerCacheJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsReferrerCache psReferrerCache) throws PreexistingEntityException, Exception {
        if (psReferrerCache.getPsReferrerCachePK() == null) {
            psReferrerCache.setPsReferrerCachePK(new PsReferrerCachePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psReferrerCache);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsReferrerCache(psReferrerCache.getPsReferrerCachePK()) != null) {
                throw new PreexistingEntityException("PsReferrerCache " + psReferrerCache + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsReferrerCache psReferrerCache) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psReferrerCache = em.merge(psReferrerCache);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsReferrerCachePK id = psReferrerCache.getPsReferrerCachePK();
                if (findPsReferrerCache(id) == null) {
                    throw new NonexistentEntityException("The psReferrerCache with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsReferrerCachePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsReferrerCache psReferrerCache;
            try {
                psReferrerCache = em.getReference(PsReferrerCache.class, id);
                psReferrerCache.getPsReferrerCachePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psReferrerCache with id " + id + " no longer exists.", enfe);
            }
            em.remove(psReferrerCache);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsReferrerCache> findPsReferrerCacheEntities() {
        return findPsReferrerCacheEntities(true, -1, -1);
    }

    public List<PsReferrerCache> findPsReferrerCacheEntities(int maxResults, int firstResult) {
        return findPsReferrerCacheEntities(false, maxResults, firstResult);
    }

    private List<PsReferrerCache> findPsReferrerCacheEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsReferrerCache.class));
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

    public PsReferrerCache findPsReferrerCache(PsReferrerCachePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsReferrerCache.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsReferrerCacheCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsReferrerCache> rt = cq.from(PsReferrerCache.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

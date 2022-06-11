/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsSmartyLazyCache;
import entidade.prestaShop.PsSmartyLazyCachePK;
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
public class PsSmartyLazyCacheJpaController implements Serializable {

    public PsSmartyLazyCacheJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsSmartyLazyCache psSmartyLazyCache) throws PreexistingEntityException, Exception {
        if (psSmartyLazyCache.getPsSmartyLazyCachePK() == null) {
            psSmartyLazyCache.setPsSmartyLazyCachePK(new PsSmartyLazyCachePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psSmartyLazyCache);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsSmartyLazyCache(psSmartyLazyCache.getPsSmartyLazyCachePK()) != null) {
                throw new PreexistingEntityException("PsSmartyLazyCache " + psSmartyLazyCache + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsSmartyLazyCache psSmartyLazyCache) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psSmartyLazyCache = em.merge(psSmartyLazyCache);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsSmartyLazyCachePK id = psSmartyLazyCache.getPsSmartyLazyCachePK();
                if (findPsSmartyLazyCache(id) == null) {
                    throw new NonexistentEntityException("The psSmartyLazyCache with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsSmartyLazyCachePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsSmartyLazyCache psSmartyLazyCache;
            try {
                psSmartyLazyCache = em.getReference(PsSmartyLazyCache.class, id);
                psSmartyLazyCache.getPsSmartyLazyCachePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psSmartyLazyCache with id " + id + " no longer exists.", enfe);
            }
            em.remove(psSmartyLazyCache);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsSmartyLazyCache> findPsSmartyLazyCacheEntities() {
        return findPsSmartyLazyCacheEntities(true, -1, -1);
    }

    public List<PsSmartyLazyCache> findPsSmartyLazyCacheEntities(int maxResults, int firstResult) {
        return findPsSmartyLazyCacheEntities(false, maxResults, firstResult);
    }

    private List<PsSmartyLazyCache> findPsSmartyLazyCacheEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsSmartyLazyCache.class));
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

    public PsSmartyLazyCache findPsSmartyLazyCache(PsSmartyLazyCachePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsSmartyLazyCache.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsSmartyLazyCacheCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsSmartyLazyCache> rt = cq.from(PsSmartyLazyCache.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

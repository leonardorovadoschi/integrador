/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsSmartyCache;
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
public class PsSmartyCacheJpaController implements Serializable {

    public PsSmartyCacheJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsSmartyCache psSmartyCache) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psSmartyCache);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsSmartyCache(psSmartyCache.getIdSmartyCache()) != null) {
                throw new PreexistingEntityException("PsSmartyCache " + psSmartyCache + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsSmartyCache psSmartyCache) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psSmartyCache = em.merge(psSmartyCache);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = psSmartyCache.getIdSmartyCache();
                if (findPsSmartyCache(id) == null) {
                    throw new NonexistentEntityException("The psSmartyCache with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsSmartyCache psSmartyCache;
            try {
                psSmartyCache = em.getReference(PsSmartyCache.class, id);
                psSmartyCache.getIdSmartyCache();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psSmartyCache with id " + id + " no longer exists.", enfe);
            }
            em.remove(psSmartyCache);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsSmartyCache> findPsSmartyCacheEntities() {
        return findPsSmartyCacheEntities(true, -1, -1);
    }

    public List<PsSmartyCache> findPsSmartyCacheEntities(int maxResults, int firstResult) {
        return findPsSmartyCacheEntities(false, maxResults, firstResult);
    }

    private List<PsSmartyCache> findPsSmartyCacheEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsSmartyCache.class));
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

    public PsSmartyCache findPsSmartyCache(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsSmartyCache.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsSmartyCacheCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsSmartyCache> rt = cq.from(PsSmartyCache.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

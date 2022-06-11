/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsLayeredIndexableFeature;
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
public class PsLayeredIndexableFeatureJpaController implements Serializable {

    public PsLayeredIndexableFeatureJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsLayeredIndexableFeature psLayeredIndexableFeature) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psLayeredIndexableFeature);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsLayeredIndexableFeature(psLayeredIndexableFeature.getIdFeature()) != null) {
                throw new PreexistingEntityException("PsLayeredIndexableFeature " + psLayeredIndexableFeature + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsLayeredIndexableFeature psLayeredIndexableFeature) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psLayeredIndexableFeature = em.merge(psLayeredIndexableFeature);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psLayeredIndexableFeature.getIdFeature();
                if (findPsLayeredIndexableFeature(id) == null) {
                    throw new NonexistentEntityException("The psLayeredIndexableFeature with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsLayeredIndexableFeature psLayeredIndexableFeature;
            try {
                psLayeredIndexableFeature = em.getReference(PsLayeredIndexableFeature.class, id);
                psLayeredIndexableFeature.getIdFeature();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psLayeredIndexableFeature with id " + id + " no longer exists.", enfe);
            }
            em.remove(psLayeredIndexableFeature);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsLayeredIndexableFeature> findPsLayeredIndexableFeatureEntities() {
        return findPsLayeredIndexableFeatureEntities(true, -1, -1);
    }

    public List<PsLayeredIndexableFeature> findPsLayeredIndexableFeatureEntities(int maxResults, int firstResult) {
        return findPsLayeredIndexableFeatureEntities(false, maxResults, firstResult);
    }

    private List<PsLayeredIndexableFeature> findPsLayeredIndexableFeatureEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsLayeredIndexableFeature.class));
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

    public PsLayeredIndexableFeature findPsLayeredIndexableFeature(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsLayeredIndexableFeature.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsLayeredIndexableFeatureCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsLayeredIndexableFeature> rt = cq.from(PsLayeredIndexableFeature.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

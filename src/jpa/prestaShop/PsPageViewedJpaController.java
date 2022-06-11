/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsPageViewed;
import entidade.prestaShop.PsPageViewedPK;
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
public class PsPageViewedJpaController implements Serializable {

    public PsPageViewedJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsPageViewed psPageViewed) throws PreexistingEntityException, Exception {
        if (psPageViewed.getPsPageViewedPK() == null) {
            psPageViewed.setPsPageViewedPK(new PsPageViewedPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psPageViewed);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsPageViewed(psPageViewed.getPsPageViewedPK()) != null) {
                throw new PreexistingEntityException("PsPageViewed " + psPageViewed + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsPageViewed psPageViewed) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psPageViewed = em.merge(psPageViewed);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsPageViewedPK id = psPageViewed.getPsPageViewedPK();
                if (findPsPageViewed(id) == null) {
                    throw new NonexistentEntityException("The psPageViewed with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsPageViewedPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsPageViewed psPageViewed;
            try {
                psPageViewed = em.getReference(PsPageViewed.class, id);
                psPageViewed.getPsPageViewedPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psPageViewed with id " + id + " no longer exists.", enfe);
            }
            em.remove(psPageViewed);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsPageViewed> findPsPageViewedEntities() {
        return findPsPageViewedEntities(true, -1, -1);
    }

    public List<PsPageViewed> findPsPageViewedEntities(int maxResults, int firstResult) {
        return findPsPageViewedEntities(false, maxResults, firstResult);
    }

    private List<PsPageViewed> findPsPageViewedEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsPageViewed.class));
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

    public PsPageViewed findPsPageViewed(PsPageViewedPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsPageViewed.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsPageViewedCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsPageViewed> rt = cq.from(PsPageViewed.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

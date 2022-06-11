/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsHomesliderSlides;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.prestaShop.exceptions.NonexistentEntityException;

/**
 *
 * @author leo
 */
public class PsHomesliderSlidesJpaController implements Serializable {

    public PsHomesliderSlidesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsHomesliderSlides psHomesliderSlides) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psHomesliderSlides);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsHomesliderSlides psHomesliderSlides) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psHomesliderSlides = em.merge(psHomesliderSlides);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psHomesliderSlides.getIdHomesliderSlides();
                if (findPsHomesliderSlides(id) == null) {
                    throw new NonexistentEntityException("The psHomesliderSlides with id " + id + " no longer exists.");
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
            PsHomesliderSlides psHomesliderSlides;
            try {
                psHomesliderSlides = em.getReference(PsHomesliderSlides.class, id);
                psHomesliderSlides.getIdHomesliderSlides();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psHomesliderSlides with id " + id + " no longer exists.", enfe);
            }
            em.remove(psHomesliderSlides);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsHomesliderSlides> findPsHomesliderSlidesEntities() {
        return findPsHomesliderSlidesEntities(true, -1, -1);
    }

    public List<PsHomesliderSlides> findPsHomesliderSlidesEntities(int maxResults, int firstResult) {
        return findPsHomesliderSlidesEntities(false, maxResults, firstResult);
    }

    private List<PsHomesliderSlides> findPsHomesliderSlidesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsHomesliderSlides.class));
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

    public PsHomesliderSlides findPsHomesliderSlides(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsHomesliderSlides.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsHomesliderSlidesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsHomesliderSlides> rt = cq.from(PsHomesliderSlides.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

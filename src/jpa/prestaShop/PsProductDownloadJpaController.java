/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsProductDownload;
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
public class PsProductDownloadJpaController implements Serializable {

    public PsProductDownloadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsProductDownload psProductDownload) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psProductDownload);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsProductDownload psProductDownload) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psProductDownload = em.merge(psProductDownload);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psProductDownload.getIdProductDownload();
                if (findPsProductDownload(id) == null) {
                    throw new NonexistentEntityException("The psProductDownload with id " + id + " no longer exists.");
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
            PsProductDownload psProductDownload;
            try {
                psProductDownload = em.getReference(PsProductDownload.class, id);
                psProductDownload.getIdProductDownload();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psProductDownload with id " + id + " no longer exists.", enfe);
            }
            em.remove(psProductDownload);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsProductDownload> findPsProductDownloadEntities() {
        return findPsProductDownloadEntities(true, -1, -1);
    }

    public List<PsProductDownload> findPsProductDownloadEntities(int maxResults, int firstResult) {
        return findPsProductDownloadEntities(false, maxResults, firstResult);
    }

    private List<PsProductDownload> findPsProductDownloadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsProductDownload.class));
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

    public PsProductDownload findPsProductDownload(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsProductDownload.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsProductDownloadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsProductDownload> rt = cq.from(PsProductDownload.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

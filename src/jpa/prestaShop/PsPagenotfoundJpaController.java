/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsPagenotfound;
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
public class PsPagenotfoundJpaController implements Serializable {

    public PsPagenotfoundJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsPagenotfound psPagenotfound) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psPagenotfound);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsPagenotfound psPagenotfound) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psPagenotfound = em.merge(psPagenotfound);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psPagenotfound.getIdPagenotfound();
                if (findPsPagenotfound(id) == null) {
                    throw new NonexistentEntityException("The psPagenotfound with id " + id + " no longer exists.");
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
            PsPagenotfound psPagenotfound;
            try {
                psPagenotfound = em.getReference(PsPagenotfound.class, id);
                psPagenotfound.getIdPagenotfound();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psPagenotfound with id " + id + " no longer exists.", enfe);
            }
            em.remove(psPagenotfound);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsPagenotfound> findPsPagenotfoundEntities() {
        return findPsPagenotfoundEntities(true, -1, -1);
    }

    public List<PsPagenotfound> findPsPagenotfoundEntities(int maxResults, int firstResult) {
        return findPsPagenotfoundEntities(false, maxResults, firstResult);
    }

    private List<PsPagenotfound> findPsPagenotfoundEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsPagenotfound.class));
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

    public PsPagenotfound findPsPagenotfound(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsPagenotfound.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsPagenotfoundCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsPagenotfound> rt = cq.from(PsPagenotfound.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

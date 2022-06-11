/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsQuickAccess;
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
public class PsQuickAccessJpaController implements Serializable {

    public PsQuickAccessJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsQuickAccess psQuickAccess) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psQuickAccess);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsQuickAccess psQuickAccess) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psQuickAccess = em.merge(psQuickAccess);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psQuickAccess.getIdQuickAccess();
                if (findPsQuickAccess(id) == null) {
                    throw new NonexistentEntityException("The psQuickAccess with id " + id + " no longer exists.");
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
            PsQuickAccess psQuickAccess;
            try {
                psQuickAccess = em.getReference(PsQuickAccess.class, id);
                psQuickAccess.getIdQuickAccess();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psQuickAccess with id " + id + " no longer exists.", enfe);
            }
            em.remove(psQuickAccess);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsQuickAccess> findPsQuickAccessEntities() {
        return findPsQuickAccessEntities(true, -1, -1);
    }

    public List<PsQuickAccess> findPsQuickAccessEntities(int maxResults, int firstResult) {
        return findPsQuickAccessEntities(false, maxResults, firstResult);
    }

    private List<PsQuickAccess> findPsQuickAccessEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsQuickAccess.class));
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

    public PsQuickAccess findPsQuickAccess(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsQuickAccess.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsQuickAccessCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsQuickAccess> rt = cq.from(PsQuickAccess.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

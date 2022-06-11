/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsHook;
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
public class PsHookJpaController implements Serializable {

    public PsHookJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsHook psHook) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psHook);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsHook psHook) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psHook = em.merge(psHook);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psHook.getIdHook();
                if (findPsHook(id) == null) {
                    throw new NonexistentEntityException("The psHook with id " + id + " no longer exists.");
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
            PsHook psHook;
            try {
                psHook = em.getReference(PsHook.class, id);
                psHook.getIdHook();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psHook with id " + id + " no longer exists.", enfe);
            }
            em.remove(psHook);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsHook> findPsHookEntities() {
        return findPsHookEntities(true, -1, -1);
    }

    public List<PsHook> findPsHookEntities(int maxResults, int firstResult) {
        return findPsHookEntities(false, maxResults, firstResult);
    }

    private List<PsHook> findPsHookEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsHook.class));
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

    public PsHook findPsHook(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsHook.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsHookCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsHook> rt = cq.from(PsHook.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsHookModuleExceptions;
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
public class PsHookModuleExceptionsJpaController implements Serializable {

    public PsHookModuleExceptionsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsHookModuleExceptions psHookModuleExceptions) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psHookModuleExceptions);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsHookModuleExceptions psHookModuleExceptions) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psHookModuleExceptions = em.merge(psHookModuleExceptions);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psHookModuleExceptions.getIdHookModuleExceptions();
                if (findPsHookModuleExceptions(id) == null) {
                    throw new NonexistentEntityException("The psHookModuleExceptions with id " + id + " no longer exists.");
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
            PsHookModuleExceptions psHookModuleExceptions;
            try {
                psHookModuleExceptions = em.getReference(PsHookModuleExceptions.class, id);
                psHookModuleExceptions.getIdHookModuleExceptions();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psHookModuleExceptions with id " + id + " no longer exists.", enfe);
            }
            em.remove(psHookModuleExceptions);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsHookModuleExceptions> findPsHookModuleExceptionsEntities() {
        return findPsHookModuleExceptionsEntities(true, -1, -1);
    }

    public List<PsHookModuleExceptions> findPsHookModuleExceptionsEntities(int maxResults, int firstResult) {
        return findPsHookModuleExceptionsEntities(false, maxResults, firstResult);
    }

    private List<PsHookModuleExceptions> findPsHookModuleExceptionsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsHookModuleExceptions.class));
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

    public PsHookModuleExceptions findPsHookModuleExceptions(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsHookModuleExceptions.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsHookModuleExceptionsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsHookModuleExceptions> rt = cq.from(PsHookModuleExceptions.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.integrador;

import entidade.integrador.IntLogs;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.integrador.exceptions.NonexistentEntityException;

/**
 *
 * @author leo
 */
public class IntLogsJpaController implements Serializable {

    public IntLogsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(IntLogs intLogs) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(intLogs);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(IntLogs intLogs) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            intLogs = em.merge(intLogs);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = intLogs.getEntityId();
                if (findIntLogs(id) == null) {
                    throw new NonexistentEntityException("The intLogs with id " + id + " no longer exists.");
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
            IntLogs intLogs;
            try {
                intLogs = em.getReference(IntLogs.class, id);
                intLogs.getEntityId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The intLogs with id " + id + " no longer exists.", enfe);
            }
            em.remove(intLogs);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<IntLogs> findIntLogsEntities() {
        return findIntLogsEntities(true, -1, -1);
    }

    public List<IntLogs> findIntLogsEntities(int maxResults, int firstResult) {
        return findIntLogsEntities(false, maxResults, firstResult);
    }

    private List<IntLogs> findIntLogsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(IntLogs.class));
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

    public IntLogs findIntLogs(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(IntLogs.class, id);
        } finally {
            em.close();
        }
    }

    public int getIntLogsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<IntLogs> rt = cq.from(IntLogs.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

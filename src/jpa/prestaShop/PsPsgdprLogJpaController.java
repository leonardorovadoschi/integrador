/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsPsgdprLog;
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
public class PsPsgdprLogJpaController implements Serializable {

    public PsPsgdprLogJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsPsgdprLog psPsgdprLog) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psPsgdprLog);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsPsgdprLog psPsgdprLog) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psPsgdprLog = em.merge(psPsgdprLog);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psPsgdprLog.getIdGdprLog();
                if (findPsPsgdprLog(id) == null) {
                    throw new NonexistentEntityException("The psPsgdprLog with id " + id + " no longer exists.");
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
            PsPsgdprLog psPsgdprLog;
            try {
                psPsgdprLog = em.getReference(PsPsgdprLog.class, id);
                psPsgdprLog.getIdGdprLog();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psPsgdprLog with id " + id + " no longer exists.", enfe);
            }
            em.remove(psPsgdprLog);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsPsgdprLog> findPsPsgdprLogEntities() {
        return findPsPsgdprLogEntities(true, -1, -1);
    }

    public List<PsPsgdprLog> findPsPsgdprLogEntities(int maxResults, int firstResult) {
        return findPsPsgdprLogEntities(false, maxResults, firstResult);
    }

    private List<PsPsgdprLog> findPsPsgdprLogEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsPsgdprLog.class));
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

    public PsPsgdprLog findPsPsgdprLog(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsPsgdprLog.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsPsgdprLogCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsPsgdprLog> rt = cq.from(PsPsgdprLog.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

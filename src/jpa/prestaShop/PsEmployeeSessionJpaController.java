/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsEmployeeSession;
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
public class PsEmployeeSessionJpaController implements Serializable {

    public PsEmployeeSessionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsEmployeeSession psEmployeeSession) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psEmployeeSession);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsEmployeeSession psEmployeeSession) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psEmployeeSession = em.merge(psEmployeeSession);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psEmployeeSession.getIdEmployeeSession();
                if (findPsEmployeeSession(id) == null) {
                    throw new NonexistentEntityException("The psEmployeeSession with id " + id + " no longer exists.");
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
            PsEmployeeSession psEmployeeSession;
            try {
                psEmployeeSession = em.getReference(PsEmployeeSession.class, id);
                psEmployeeSession.getIdEmployeeSession();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psEmployeeSession with id " + id + " no longer exists.", enfe);
            }
            em.remove(psEmployeeSession);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsEmployeeSession> findPsEmployeeSessionEntities() {
        return findPsEmployeeSessionEntities(true, -1, -1);
    }

    public List<PsEmployeeSession> findPsEmployeeSessionEntities(int maxResults, int firstResult) {
        return findPsEmployeeSessionEntities(false, maxResults, firstResult);
    }

    private List<PsEmployeeSession> findPsEmployeeSessionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsEmployeeSession.class));
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

    public PsEmployeeSession findPsEmployeeSession(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsEmployeeSession.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsEmployeeSessionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsEmployeeSession> rt = cq.from(PsEmployeeSession.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

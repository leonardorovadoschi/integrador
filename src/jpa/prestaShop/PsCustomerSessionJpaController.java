/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCustomerSession;
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
public class PsCustomerSessionJpaController implements Serializable {

    public PsCustomerSessionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCustomerSession psCustomerSession) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCustomerSession);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCustomerSession psCustomerSession) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCustomerSession = em.merge(psCustomerSession);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psCustomerSession.getIdCustomerSession();
                if (findPsCustomerSession(id) == null) {
                    throw new NonexistentEntityException("The psCustomerSession with id " + id + " no longer exists.");
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
            PsCustomerSession psCustomerSession;
            try {
                psCustomerSession = em.getReference(PsCustomerSession.class, id);
                psCustomerSession.getIdCustomerSession();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCustomerSession with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCustomerSession);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCustomerSession> findPsCustomerSessionEntities() {
        return findPsCustomerSessionEntities(true, -1, -1);
    }

    public List<PsCustomerSession> findPsCustomerSessionEntities(int maxResults, int firstResult) {
        return findPsCustomerSessionEntities(false, maxResults, firstResult);
    }

    private List<PsCustomerSession> findPsCustomerSessionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCustomerSession.class));
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

    public PsCustomerSession findPsCustomerSession(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCustomerSession.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCustomerSessionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCustomerSession> rt = cq.from(PsCustomerSession.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCustomerThread;
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
public class PsCustomerThreadJpaController implements Serializable {

    public PsCustomerThreadJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCustomerThread psCustomerThread) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCustomerThread);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCustomerThread psCustomerThread) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCustomerThread = em.merge(psCustomerThread);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psCustomerThread.getIdCustomerThread();
                if (findPsCustomerThread(id) == null) {
                    throw new NonexistentEntityException("The psCustomerThread with id " + id + " no longer exists.");
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
            PsCustomerThread psCustomerThread;
            try {
                psCustomerThread = em.getReference(PsCustomerThread.class, id);
                psCustomerThread.getIdCustomerThread();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCustomerThread with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCustomerThread);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCustomerThread> findPsCustomerThreadEntities() {
        return findPsCustomerThreadEntities(true, -1, -1);
    }

    public List<PsCustomerThread> findPsCustomerThreadEntities(int maxResults, int firstResult) {
        return findPsCustomerThreadEntities(false, maxResults, firstResult);
    }

    private List<PsCustomerThread> findPsCustomerThreadEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCustomerThread.class));
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

    public PsCustomerThread findPsCustomerThread(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCustomerThread.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCustomerThreadCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCustomerThread> rt = cq.from(PsCustomerThread.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

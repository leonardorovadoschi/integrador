/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCustomerMessage;
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
public class PsCustomerMessageJpaController implements Serializable {

    public PsCustomerMessageJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCustomerMessage psCustomerMessage) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCustomerMessage);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCustomerMessage psCustomerMessage) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCustomerMessage = em.merge(psCustomerMessage);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psCustomerMessage.getIdCustomerMessage();
                if (findPsCustomerMessage(id) == null) {
                    throw new NonexistentEntityException("The psCustomerMessage with id " + id + " no longer exists.");
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
            PsCustomerMessage psCustomerMessage;
            try {
                psCustomerMessage = em.getReference(PsCustomerMessage.class, id);
                psCustomerMessage.getIdCustomerMessage();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCustomerMessage with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCustomerMessage);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCustomerMessage> findPsCustomerMessageEntities() {
        return findPsCustomerMessageEntities(true, -1, -1);
    }

    public List<PsCustomerMessage> findPsCustomerMessageEntities(int maxResults, int firstResult) {
        return findPsCustomerMessageEntities(false, maxResults, firstResult);
    }

    private List<PsCustomerMessage> findPsCustomerMessageEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCustomerMessage.class));
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

    public PsCustomerMessage findPsCustomerMessage(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCustomerMessage.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCustomerMessageCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCustomerMessage> rt = cq.from(PsCustomerMessage.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

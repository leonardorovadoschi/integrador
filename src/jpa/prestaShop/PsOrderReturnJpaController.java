/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsOrderReturn;
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
public class PsOrderReturnJpaController implements Serializable {

    public PsOrderReturnJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsOrderReturn psOrderReturn) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psOrderReturn);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsOrderReturn psOrderReturn) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psOrderReturn = em.merge(psOrderReturn);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psOrderReturn.getIdOrderReturn();
                if (findPsOrderReturn(id) == null) {
                    throw new NonexistentEntityException("The psOrderReturn with id " + id + " no longer exists.");
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
            PsOrderReturn psOrderReturn;
            try {
                psOrderReturn = em.getReference(PsOrderReturn.class, id);
                psOrderReturn.getIdOrderReturn();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psOrderReturn with id " + id + " no longer exists.", enfe);
            }
            em.remove(psOrderReturn);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsOrderReturn> findPsOrderReturnEntities() {
        return findPsOrderReturnEntities(true, -1, -1);
    }

    public List<PsOrderReturn> findPsOrderReturnEntities(int maxResults, int firstResult) {
        return findPsOrderReturnEntities(false, maxResults, firstResult);
    }

    private List<PsOrderReturn> findPsOrderReturnEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsOrderReturn.class));
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

    public PsOrderReturn findPsOrderReturn(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsOrderReturn.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsOrderReturnCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsOrderReturn> rt = cq.from(PsOrderReturn.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

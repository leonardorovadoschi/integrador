/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsStatssearch;
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
public class PsStatssearchJpaController implements Serializable {

    public PsStatssearchJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsStatssearch psStatssearch) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psStatssearch);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsStatssearch psStatssearch) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psStatssearch = em.merge(psStatssearch);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psStatssearch.getIdStatssearch();
                if (findPsStatssearch(id) == null) {
                    throw new NonexistentEntityException("The psStatssearch with id " + id + " no longer exists.");
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
            PsStatssearch psStatssearch;
            try {
                psStatssearch = em.getReference(PsStatssearch.class, id);
                psStatssearch.getIdStatssearch();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psStatssearch with id " + id + " no longer exists.", enfe);
            }
            em.remove(psStatssearch);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsStatssearch> findPsStatssearchEntities() {
        return findPsStatssearchEntities(true, -1, -1);
    }

    public List<PsStatssearch> findPsStatssearchEntities(int maxResults, int firstResult) {
        return findPsStatssearchEntities(false, maxResults, firstResult);
    }

    private List<PsStatssearch> findPsStatssearchEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsStatssearch.class));
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

    public PsStatssearch findPsStatssearch(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsStatssearch.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsStatssearchCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsStatssearch> rt = cq.from(PsStatssearch.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

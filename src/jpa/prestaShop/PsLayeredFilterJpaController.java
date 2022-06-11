/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsLayeredFilter;
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
public class PsLayeredFilterJpaController implements Serializable {

    public PsLayeredFilterJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsLayeredFilter psLayeredFilter) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psLayeredFilter);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsLayeredFilter psLayeredFilter) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psLayeredFilter = em.merge(psLayeredFilter);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psLayeredFilter.getIdLayeredFilter();
                if (findPsLayeredFilter(id) == null) {
                    throw new NonexistentEntityException("The psLayeredFilter with id " + id + " no longer exists.");
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
            PsLayeredFilter psLayeredFilter;
            try {
                psLayeredFilter = em.getReference(PsLayeredFilter.class, id);
                psLayeredFilter.getIdLayeredFilter();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psLayeredFilter with id " + id + " no longer exists.", enfe);
            }
            em.remove(psLayeredFilter);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsLayeredFilter> findPsLayeredFilterEntities() {
        return findPsLayeredFilterEntities(true, -1, -1);
    }

    public List<PsLayeredFilter> findPsLayeredFilterEntities(int maxResults, int firstResult) {
        return findPsLayeredFilterEntities(false, maxResults, firstResult);
    }

    private List<PsLayeredFilter> findPsLayeredFilterEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsLayeredFilter.class));
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

    public PsLayeredFilter findPsLayeredFilter(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsLayeredFilter.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsLayeredFilterCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsLayeredFilter> rt = cq.from(PsLayeredFilter.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

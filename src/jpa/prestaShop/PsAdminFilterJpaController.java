/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsAdminFilter;
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
public class PsAdminFilterJpaController implements Serializable {

    public PsAdminFilterJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsAdminFilter psAdminFilter) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psAdminFilter);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsAdminFilter psAdminFilter) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psAdminFilter = em.merge(psAdminFilter);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psAdminFilter.getId();
                if (findPsAdminFilter(id) == null) {
                    throw new NonexistentEntityException("The psAdminFilter with id " + id + " no longer exists.");
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
            PsAdminFilter psAdminFilter;
            try {
                psAdminFilter = em.getReference(PsAdminFilter.class, id);
                psAdminFilter.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psAdminFilter with id " + id + " no longer exists.", enfe);
            }
            em.remove(psAdminFilter);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsAdminFilter> findPsAdminFilterEntities() {
        return findPsAdminFilterEntities(true, -1, -1);
    }

    public List<PsAdminFilter> findPsAdminFilterEntities(int maxResults, int firstResult) {
        return findPsAdminFilterEntities(false, maxResults, firstResult);
    }

    private List<PsAdminFilter> findPsAdminFilterEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsAdminFilter.class));
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

    public PsAdminFilter findPsAdminFilter(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsAdminFilter.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsAdminFilterCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsAdminFilter> rt = cq.from(PsAdminFilter.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

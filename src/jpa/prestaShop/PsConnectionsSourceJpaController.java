/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsConnectionsSource;
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
public class PsConnectionsSourceJpaController implements Serializable {

    public PsConnectionsSourceJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsConnectionsSource psConnectionsSource) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psConnectionsSource);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsConnectionsSource psConnectionsSource) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psConnectionsSource = em.merge(psConnectionsSource);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psConnectionsSource.getIdConnectionsSource();
                if (findPsConnectionsSource(id) == null) {
                    throw new NonexistentEntityException("The psConnectionsSource with id " + id + " no longer exists.");
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
            PsConnectionsSource psConnectionsSource;
            try {
                psConnectionsSource = em.getReference(PsConnectionsSource.class, id);
                psConnectionsSource.getIdConnectionsSource();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psConnectionsSource with id " + id + " no longer exists.", enfe);
            }
            em.remove(psConnectionsSource);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsConnectionsSource> findPsConnectionsSourceEntities() {
        return findPsConnectionsSourceEntities(true, -1, -1);
    }

    public List<PsConnectionsSource> findPsConnectionsSourceEntities(int maxResults, int firstResult) {
        return findPsConnectionsSourceEntities(false, maxResults, firstResult);
    }

    private List<PsConnectionsSource> findPsConnectionsSourceEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsConnectionsSource.class));
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

    public PsConnectionsSource findPsConnectionsSource(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsConnectionsSource.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsConnectionsSourceCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsConnectionsSource> rt = cq.from(PsConnectionsSource.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

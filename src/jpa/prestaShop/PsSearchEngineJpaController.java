/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsSearchEngine;
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
public class PsSearchEngineJpaController implements Serializable {

    public PsSearchEngineJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsSearchEngine psSearchEngine) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psSearchEngine);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsSearchEngine psSearchEngine) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psSearchEngine = em.merge(psSearchEngine);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psSearchEngine.getIdSearchEngine();
                if (findPsSearchEngine(id) == null) {
                    throw new NonexistentEntityException("The psSearchEngine with id " + id + " no longer exists.");
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
            PsSearchEngine psSearchEngine;
            try {
                psSearchEngine = em.getReference(PsSearchEngine.class, id);
                psSearchEngine.getIdSearchEngine();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psSearchEngine with id " + id + " no longer exists.", enfe);
            }
            em.remove(psSearchEngine);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsSearchEngine> findPsSearchEngineEntities() {
        return findPsSearchEngineEntities(true, -1, -1);
    }

    public List<PsSearchEngine> findPsSearchEngineEntities(int maxResults, int firstResult) {
        return findPsSearchEngineEntities(false, maxResults, firstResult);
    }

    private List<PsSearchEngine> findPsSearchEngineEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsSearchEngine.class));
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

    public PsSearchEngine findPsSearchEngine(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsSearchEngine.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsSearchEngineCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsSearchEngine> rt = cq.from(PsSearchEngine.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

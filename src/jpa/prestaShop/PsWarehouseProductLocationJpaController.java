/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsWarehouseProductLocation;
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
public class PsWarehouseProductLocationJpaController implements Serializable {

    public PsWarehouseProductLocationJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsWarehouseProductLocation psWarehouseProductLocation) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psWarehouseProductLocation);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsWarehouseProductLocation psWarehouseProductLocation) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psWarehouseProductLocation = em.merge(psWarehouseProductLocation);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psWarehouseProductLocation.getIdWarehouseProductLocation();
                if (findPsWarehouseProductLocation(id) == null) {
                    throw new NonexistentEntityException("The psWarehouseProductLocation with id " + id + " no longer exists.");
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
            PsWarehouseProductLocation psWarehouseProductLocation;
            try {
                psWarehouseProductLocation = em.getReference(PsWarehouseProductLocation.class, id);
                psWarehouseProductLocation.getIdWarehouseProductLocation();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psWarehouseProductLocation with id " + id + " no longer exists.", enfe);
            }
            em.remove(psWarehouseProductLocation);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsWarehouseProductLocation> findPsWarehouseProductLocationEntities() {
        return findPsWarehouseProductLocationEntities(true, -1, -1);
    }

    public List<PsWarehouseProductLocation> findPsWarehouseProductLocationEntities(int maxResults, int firstResult) {
        return findPsWarehouseProductLocationEntities(false, maxResults, firstResult);
    }

    private List<PsWarehouseProductLocation> findPsWarehouseProductLocationEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsWarehouseProductLocation.class));
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

    public PsWarehouseProductLocation findPsWarehouseProductLocation(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsWarehouseProductLocation.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsWarehouseProductLocationCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsWarehouseProductLocation> rt = cq.from(PsWarehouseProductLocation.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

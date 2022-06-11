/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsWarehouse;
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
public class PsWarehouseJpaController implements Serializable {

    public PsWarehouseJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsWarehouse psWarehouse) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psWarehouse);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsWarehouse psWarehouse) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psWarehouse = em.merge(psWarehouse);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psWarehouse.getIdWarehouse();
                if (findPsWarehouse(id) == null) {
                    throw new NonexistentEntityException("The psWarehouse with id " + id + " no longer exists.");
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
            PsWarehouse psWarehouse;
            try {
                psWarehouse = em.getReference(PsWarehouse.class, id);
                psWarehouse.getIdWarehouse();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psWarehouse with id " + id + " no longer exists.", enfe);
            }
            em.remove(psWarehouse);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsWarehouse> findPsWarehouseEntities() {
        return findPsWarehouseEntities(true, -1, -1);
    }

    public List<PsWarehouse> findPsWarehouseEntities(int maxResults, int firstResult) {
        return findPsWarehouseEntities(false, maxResults, firstResult);
    }

    private List<PsWarehouse> findPsWarehouseEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsWarehouse.class));
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

    public PsWarehouse findPsWarehouse(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsWarehouse.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsWarehouseCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsWarehouse> rt = cq.from(PsWarehouse.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

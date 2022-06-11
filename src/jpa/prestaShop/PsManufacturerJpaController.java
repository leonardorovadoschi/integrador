/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsManufacturer;
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
public class PsManufacturerJpaController implements Serializable {

    public PsManufacturerJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsManufacturer psManufacturer) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psManufacturer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsManufacturer psManufacturer) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psManufacturer = em.merge(psManufacturer);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psManufacturer.getIdManufacturer();
                if (findPsManufacturer(id) == null) {
                    throw new NonexistentEntityException("The psManufacturer with id " + id + " no longer exists.");
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
            PsManufacturer psManufacturer;
            try {
                psManufacturer = em.getReference(PsManufacturer.class, id);
                psManufacturer.getIdManufacturer();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psManufacturer with id " + id + " no longer exists.", enfe);
            }
            em.remove(psManufacturer);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsManufacturer> findPsManufacturerEntities() {
        return findPsManufacturerEntities(true, -1, -1);
    }

    public List<PsManufacturer> findPsManufacturerEntities(int maxResults, int firstResult) {
        return findPsManufacturerEntities(false, maxResults, firstResult);
    }

    private List<PsManufacturer> findPsManufacturerEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsManufacturer.class));
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

    public PsManufacturer findPsManufacturer(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsManufacturer.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsManufacturerCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsManufacturer> rt = cq.from(PsManufacturer.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

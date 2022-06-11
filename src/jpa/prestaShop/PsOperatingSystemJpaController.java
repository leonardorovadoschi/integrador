/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsOperatingSystem;
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
public class PsOperatingSystemJpaController implements Serializable {

    public PsOperatingSystemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsOperatingSystem psOperatingSystem) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psOperatingSystem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsOperatingSystem psOperatingSystem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psOperatingSystem = em.merge(psOperatingSystem);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psOperatingSystem.getIdOperatingSystem();
                if (findPsOperatingSystem(id) == null) {
                    throw new NonexistentEntityException("The psOperatingSystem with id " + id + " no longer exists.");
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
            PsOperatingSystem psOperatingSystem;
            try {
                psOperatingSystem = em.getReference(PsOperatingSystem.class, id);
                psOperatingSystem.getIdOperatingSystem();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psOperatingSystem with id " + id + " no longer exists.", enfe);
            }
            em.remove(psOperatingSystem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsOperatingSystem> findPsOperatingSystemEntities() {
        return findPsOperatingSystemEntities(true, -1, -1);
    }

    public List<PsOperatingSystem> findPsOperatingSystemEntities(int maxResults, int firstResult) {
        return findPsOperatingSystemEntities(false, maxResults, firstResult);
    }

    private List<PsOperatingSystem> findPsOperatingSystemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsOperatingSystem.class));
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

    public PsOperatingSystem findPsOperatingSystem(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsOperatingSystem.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsOperatingSystemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsOperatingSystem> rt = cq.from(PsOperatingSystem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsWebservicePermission;
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
public class PsWebservicePermissionJpaController implements Serializable {

    public PsWebservicePermissionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsWebservicePermission psWebservicePermission) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psWebservicePermission);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsWebservicePermission psWebservicePermission) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psWebservicePermission = em.merge(psWebservicePermission);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psWebservicePermission.getIdWebservicePermission();
                if (findPsWebservicePermission(id) == null) {
                    throw new NonexistentEntityException("The psWebservicePermission with id " + id + " no longer exists.");
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
            PsWebservicePermission psWebservicePermission;
            try {
                psWebservicePermission = em.getReference(PsWebservicePermission.class, id);
                psWebservicePermission.getIdWebservicePermission();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psWebservicePermission with id " + id + " no longer exists.", enfe);
            }
            em.remove(psWebservicePermission);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsWebservicePermission> findPsWebservicePermissionEntities() {
        return findPsWebservicePermissionEntities(true, -1, -1);
    }

    public List<PsWebservicePermission> findPsWebservicePermissionEntities(int maxResults, int firstResult) {
        return findPsWebservicePermissionEntities(false, maxResults, firstResult);
    }

    private List<PsWebservicePermission> findPsWebservicePermissionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsWebservicePermission.class));
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

    public PsWebservicePermission findPsWebservicePermission(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsWebservicePermission.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsWebservicePermissionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsWebservicePermission> rt = cq.from(PsWebservicePermission.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

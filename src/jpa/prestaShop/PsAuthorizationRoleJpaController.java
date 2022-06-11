/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsAuthorizationRole;
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
public class PsAuthorizationRoleJpaController implements Serializable {

    public PsAuthorizationRoleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsAuthorizationRole psAuthorizationRole) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psAuthorizationRole);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsAuthorizationRole psAuthorizationRole) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psAuthorizationRole = em.merge(psAuthorizationRole);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psAuthorizationRole.getIdAuthorizationRole();
                if (findPsAuthorizationRole(id) == null) {
                    throw new NonexistentEntityException("The psAuthorizationRole with id " + id + " no longer exists.");
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
            PsAuthorizationRole psAuthorizationRole;
            try {
                psAuthorizationRole = em.getReference(PsAuthorizationRole.class, id);
                psAuthorizationRole.getIdAuthorizationRole();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psAuthorizationRole with id " + id + " no longer exists.", enfe);
            }
            em.remove(psAuthorizationRole);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsAuthorizationRole> findPsAuthorizationRoleEntities() {
        return findPsAuthorizationRoleEntities(true, -1, -1);
    }

    public List<PsAuthorizationRole> findPsAuthorizationRoleEntities(int maxResults, int firstResult) {
        return findPsAuthorizationRoleEntities(false, maxResults, firstResult);
    }

    private List<PsAuthorizationRole> findPsAuthorizationRoleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsAuthorizationRole.class));
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

    public PsAuthorizationRole findPsAuthorizationRole(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsAuthorizationRole.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsAuthorizationRoleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsAuthorizationRole> rt = cq.from(PsAuthorizationRole.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

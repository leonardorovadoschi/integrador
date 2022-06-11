/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsMemcachedServers;
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
public class PsMemcachedServersJpaController implements Serializable {

    public PsMemcachedServersJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsMemcachedServers psMemcachedServers) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psMemcachedServers);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsMemcachedServers psMemcachedServers) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psMemcachedServers = em.merge(psMemcachedServers);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psMemcachedServers.getIdMemcachedServer();
                if (findPsMemcachedServers(id) == null) {
                    throw new NonexistentEntityException("The psMemcachedServers with id " + id + " no longer exists.");
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
            PsMemcachedServers psMemcachedServers;
            try {
                psMemcachedServers = em.getReference(PsMemcachedServers.class, id);
                psMemcachedServers.getIdMemcachedServer();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psMemcachedServers with id " + id + " no longer exists.", enfe);
            }
            em.remove(psMemcachedServers);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsMemcachedServers> findPsMemcachedServersEntities() {
        return findPsMemcachedServersEntities(true, -1, -1);
    }

    public List<PsMemcachedServers> findPsMemcachedServersEntities(int maxResults, int firstResult) {
        return findPsMemcachedServersEntities(false, maxResults, firstResult);
    }

    private List<PsMemcachedServers> findPsMemcachedServersEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsMemcachedServers.class));
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

    public PsMemcachedServers findPsMemcachedServers(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsMemcachedServers.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsMemcachedServersCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsMemcachedServers> rt = cq.from(PsMemcachedServers.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

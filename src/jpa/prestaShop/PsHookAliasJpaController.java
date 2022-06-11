/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsHookAlias;
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
public class PsHookAliasJpaController implements Serializable {

    public PsHookAliasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsHookAlias psHookAlias) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psHookAlias);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsHookAlias psHookAlias) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psHookAlias = em.merge(psHookAlias);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psHookAlias.getIdHookAlias();
                if (findPsHookAlias(id) == null) {
                    throw new NonexistentEntityException("The psHookAlias with id " + id + " no longer exists.");
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
            PsHookAlias psHookAlias;
            try {
                psHookAlias = em.getReference(PsHookAlias.class, id);
                psHookAlias.getIdHookAlias();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psHookAlias with id " + id + " no longer exists.", enfe);
            }
            em.remove(psHookAlias);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsHookAlias> findPsHookAliasEntities() {
        return findPsHookAliasEntities(true, -1, -1);
    }

    public List<PsHookAlias> findPsHookAliasEntities(int maxResults, int firstResult) {
        return findPsHookAliasEntities(false, maxResults, firstResult);
    }

    private List<PsHookAlias> findPsHookAliasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsHookAlias.class));
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

    public PsHookAlias findPsHookAlias(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsHookAlias.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsHookAliasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsHookAlias> rt = cq.from(PsHookAlias.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

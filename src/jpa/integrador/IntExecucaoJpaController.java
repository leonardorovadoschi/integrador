/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.integrador;

import entidade.integrador.IntExecucao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.integrador.exceptions.NonexistentEntityException;

/**
 *
 * @author leo
 */
public class IntExecucaoJpaController implements Serializable {

    public IntExecucaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    

    public void create(IntExecucao intExecucao) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(intExecucao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(IntExecucao intExecucao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(intExecucao);
            em.getTransaction().commit();
        } catch (Exception ex) {
           
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            IntExecucao intExecucao;
            try {
                intExecucao = em.getReference(IntExecucao.class, id);
                intExecucao.getIdExecucao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The intExecucao with id " + id + " no longer exists.", enfe);
            }
            em.remove(intExecucao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<IntExecucao> findIntExecucaoEntities() {
        return findIntExecucaoEntities(true, -1, -1);
    }

    public List<IntExecucao> findIntExecucaoEntities(int maxResults, int firstResult) {
        return findIntExecucaoEntities(false, maxResults, firstResult);
    }

    private List<IntExecucao> findIntExecucaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(IntExecucao.class));
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

    public IntExecucao findIntExecucao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(IntExecucao.class, id);
        } finally {
            em.close();
        }
    }

    public int getIntExecucaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<IntExecucao> rt = cq.from(IntExecucao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

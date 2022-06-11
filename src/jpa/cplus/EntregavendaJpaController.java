/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Entregavenda;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class EntregavendaJpaController implements Serializable {

    public EntregavendaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Entregavenda entregavenda) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(entregavenda);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEntregavenda(entregavenda.getCodentregavenda()) != null) {
                throw new PreexistingEntityException("Entregavenda " + entregavenda + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Entregavenda entregavenda) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            entregavenda = em.merge(entregavenda);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = entregavenda.getCodentregavenda();
                if (findEntregavenda(id) == null) {
                    throw new NonexistentEntityException("The entregavenda with id " + id + " no longer exists.");
                }
            }
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
            Entregavenda entregavenda;
            try {
                entregavenda = em.getReference(Entregavenda.class, id);
                entregavenda.getCodentregavenda();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The entregavenda with id " + id + " no longer exists.", enfe);
            }
            em.remove(entregavenda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Entregavenda> findEntregavendaEntities() {
        return findEntregavendaEntities(true, -1, -1);
    }

    public List<Entregavenda> findEntregavendaEntities(int maxResults, int firstResult) {
        return findEntregavendaEntities(false, maxResults, firstResult);
    }

    private List<Entregavenda> findEntregavendaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Entregavenda.class));
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

    public Entregavenda findEntregavenda(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Entregavenda.class, id);
        } finally {
            em.close();
        }
    }

    public int getEntregavendaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Entregavenda> rt = cq.from(Entregavenda.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Balancainfoextra;
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
public class BalancainfoextraJpaController implements Serializable {

    public BalancainfoextraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Balancainfoextra balancainfoextra) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(balancainfoextra);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBalancainfoextra(balancainfoextra.getCodbalancainfoextra()) != null) {
                throw new PreexistingEntityException("Balancainfoextra " + balancainfoextra + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Balancainfoextra balancainfoextra) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            balancainfoextra = em.merge(balancainfoextra);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = balancainfoextra.getCodbalancainfoextra();
                if (findBalancainfoextra(id) == null) {
                    throw new NonexistentEntityException("The balancainfoextra with id " + id + " no longer exists.");
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
            Balancainfoextra balancainfoextra;
            try {
                balancainfoextra = em.getReference(Balancainfoextra.class, id);
                balancainfoextra.getCodbalancainfoextra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The balancainfoextra with id " + id + " no longer exists.", enfe);
            }
            em.remove(balancainfoextra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Balancainfoextra> findBalancainfoextraEntities() {
        return findBalancainfoextraEntities(true, -1, -1);
    }

    public List<Balancainfoextra> findBalancainfoextraEntities(int maxResults, int firstResult) {
        return findBalancainfoextraEntities(false, maxResults, firstResult);
    }

    private List<Balancainfoextra> findBalancainfoextraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Balancainfoextra.class));
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

    public Balancainfoextra findBalancainfoextra(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Balancainfoextra.class, id);
        } finally {
            em.close();
        }
    }

    public int getBalancainfoextraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Balancainfoextra> rt = cq.from(Balancainfoextra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

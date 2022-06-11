/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Moventrada;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.IllegalOrphanException;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MoventradaJpaController implements Serializable {

    public MoventradaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Moventrada moventrada) throws PreexistingEntityException, Exception {
        
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
            
            em.persist(moventrada);
           
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMoventrada(moventrada.getCodmoventr()) != null) {
                throw new PreexistingEntityException("Moventrada " + moventrada + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Moventrada moventrada) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
      
            moventrada = em.merge(moventrada);
            
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = moventrada.getCodmoventr();
                if (findMoventrada(id) == null) {
                    throw new NonexistentEntityException("The moventrada with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Moventrada moventrada;
            try {
                moventrada = em.getReference(Moventrada.class, id);
                moventrada.getCodmoventr();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The moventrada with id " + id + " no longer exists.", enfe);
            }
            
            em.remove(moventrada);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Moventrada> findMoventradaEntities() {
        return findMoventradaEntities(true, -1, -1);
    }

    public List<Moventrada> findMoventradaEntities(int maxResults, int firstResult) {
        return findMoventradaEntities(false, maxResults, firstResult);
    }

    private List<Moventrada> findMoventradaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Moventrada.class));
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

    public Moventrada findMoventrada(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Moventrada.class, id);
        } finally {
            em.close();
        }
    }

    public int getMoventradaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Moventrada> rt = cq.from(Moventrada.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

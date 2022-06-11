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
import entidade.cplus.Movendaprod;
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
public class MovendaprodJpaController implements Serializable {

    public MovendaprodJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movendaprod movendaprod) throws PreexistingEntityException, Exception {
       
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(movendaprod);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovendaprod(movendaprod.getCodmovprod()) != null) {
                throw new PreexistingEntityException("Movendaprod " + movendaprod + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movendaprod movendaprod) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
      
            movendaprod = em.merge(movendaprod);
           
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = movendaprod.getCodmovprod();
                if (findMovendaprod(id) == null) {
                    throw new NonexistentEntityException("The movendaprod with id " + id + " no longer exists.");
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
            Movendaprod movendaprod;
            try {
                movendaprod = em.getReference(Movendaprod.class, id);
                movendaprod.getCodmovprod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movendaprod with id " + id + " no longer exists.", enfe);
            }
           
            em.remove(movendaprod);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movendaprod> findMovendaprodEntities() {
        return findMovendaprodEntities(true, -1, -1);
    }

    public List<Movendaprod> findMovendaprodEntities(int maxResults, int firstResult) {
        return findMovendaprodEntities(false, maxResults, firstResult);
    }

    private List<Movendaprod> findMovendaprodEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movendaprod.class));
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

    public Movendaprod findMovendaprod(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movendaprod.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovendaprodCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movendaprod> rt = cq.from(Movendaprod.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

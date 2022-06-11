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
import entidade.cplus.Movendaprodserial;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MovendaprodserialJpaController implements Serializable {

    public MovendaprodserialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movendaprodserial movendaprodserial) throws PreexistingEntityException, Exception {
        
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
        
            em.persist(movendaprodserial);
            
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovendaprodserial(movendaprodserial.getCodmovendaprodserial()) != null) {
                throw new PreexistingEntityException("Movendaprodserial " + movendaprodserial + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movendaprodserial movendaprodserial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
            movendaprodserial = em.merge(movendaprodserial);
            
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = movendaprodserial.getCodmovendaprodserial();
                if (findMovendaprodserial(id) == null) {
                    throw new NonexistentEntityException("The movendaprodserial with id " + id + " no longer exists.");
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
            Movendaprodserial movendaprodserial;
            try {
                movendaprodserial = em.getReference(Movendaprodserial.class, id);
                movendaprodserial.getCodmovendaprodserial();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movendaprodserial with id " + id + " no longer exists.", enfe);
            }
           
            em.remove(movendaprodserial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movendaprodserial> findMovendaprodserialEntities() {
        return findMovendaprodserialEntities(true, -1, -1);
    }

    public List<Movendaprodserial> findMovendaprodserialEntities(int maxResults, int firstResult) {
        return findMovendaprodserialEntities(false, maxResults, firstResult);
    }

    private List<Movendaprodserial> findMovendaprodserialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movendaprodserial.class));
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

    public Movendaprodserial findMovendaprodserial(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movendaprodserial.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovendaprodserialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movendaprodserial> rt = cq.from(Movendaprodserial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

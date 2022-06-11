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
import entidade.cplus.Moventradaprodserial;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MoventradaprodserialJpaController implements Serializable {

    public MoventradaprodserialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Moventradaprodserial moventradaprodserial) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
            em.persist(moventradaprodserial);
            
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMoventradaprodserial(moventradaprodserial.getCodmoventradaprodserial()) != null) {
                throw new PreexistingEntityException("Moventradaprodserial " + moventradaprodserial + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Moventradaprodserial moventradaprodserial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
           em.merge(moventradaprodserial);
            
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = moventradaprodserial.getCodmoventradaprodserial();
                if (findMoventradaprodserial(id) == null) {
                    throw new NonexistentEntityException("The moventradaprodserial with id " + id + " no longer exists.");
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
            Moventradaprodserial moventradaprodserial;
            try {
                moventradaprodserial = em.getReference(Moventradaprodserial.class, id);
                moventradaprodserial.getCodmoventradaprodserial();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The moventradaprodserial with id " + id + " no longer exists.", enfe);
            }
            
            em.remove(moventradaprodserial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Moventradaprodserial> findMoventradaprodserialEntities() {
        return findMoventradaprodserialEntities(true, -1, -1);
    }

    public List<Moventradaprodserial> findMoventradaprodserialEntities(int maxResults, int firstResult) {
        return findMoventradaprodserialEntities(false, maxResults, firstResult);
    }

    private List<Moventradaprodserial> findMoventradaprodserialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Moventradaprodserial.class));
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

    public Moventradaprodserial findMoventradaprodserial(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Moventradaprodserial.class, id);
        } finally {
            em.close();
        }
    }

    public int getMoventradaprodserialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Moventradaprodserial> rt = cq.from(Moventradaprodserial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

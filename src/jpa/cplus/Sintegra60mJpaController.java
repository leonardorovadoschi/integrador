/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Sintegra60m;
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
public class Sintegra60mJpaController implements Serializable {

    public Sintegra60mJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sintegra60m sintegra60m) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(sintegra60m);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSintegra60m(sintegra60m.getCodsintegra60m()) != null) {
                throw new PreexistingEntityException("Sintegra60m " + sintegra60m + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sintegra60m sintegra60m) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            sintegra60m = em.merge(sintegra60m);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = sintegra60m.getCodsintegra60m();
                if (findSintegra60m(id) == null) {
                    throw new NonexistentEntityException("The sintegra60m with id " + id + " no longer exists.");
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
            Sintegra60m sintegra60m;
            try {
                sintegra60m = em.getReference(Sintegra60m.class, id);
                sintegra60m.getCodsintegra60m();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sintegra60m with id " + id + " no longer exists.", enfe);
            }
            em.remove(sintegra60m);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sintegra60m> findSintegra60mEntities() {
        return findSintegra60mEntities(true, -1, -1);
    }

    public List<Sintegra60m> findSintegra60mEntities(int maxResults, int firstResult) {
        return findSintegra60mEntities(false, maxResults, firstResult);
    }

    private List<Sintegra60m> findSintegra60mEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sintegra60m.class));
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

    public Sintegra60m findSintegra60m(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sintegra60m.class, id);
        } finally {
            em.close();
        }
    }

    public int getSintegra60mCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sintegra60m> rt = cq.from(Sintegra60m.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

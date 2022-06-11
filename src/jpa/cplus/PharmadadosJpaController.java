/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Pharmadados;
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
public class PharmadadosJpaController implements Serializable {

    public PharmadadosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pharmadados pharmadados) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pharmadados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPharmadados(pharmadados.getCodpharmadados()) != null) {
                throw new PreexistingEntityException("Pharmadados " + pharmadados + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pharmadados pharmadados) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pharmadados = em.merge(pharmadados);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = pharmadados.getCodpharmadados();
                if (findPharmadados(id) == null) {
                    throw new NonexistentEntityException("The pharmadados with id " + id + " no longer exists.");
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
            Pharmadados pharmadados;
            try {
                pharmadados = em.getReference(Pharmadados.class, id);
                pharmadados.getCodpharmadados();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pharmadados with id " + id + " no longer exists.", enfe);
            }
            em.remove(pharmadados);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pharmadados> findPharmadadosEntities() {
        return findPharmadadosEntities(true, -1, -1);
    }

    public List<Pharmadados> findPharmadadosEntities(int maxResults, int firstResult) {
        return findPharmadadosEntities(false, maxResults, firstResult);
    }

    private List<Pharmadados> findPharmadadosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pharmadados.class));
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

    public Pharmadados findPharmadados(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pharmadados.class, id);
        } finally {
            em.close();
        }
    }

    public int getPharmadadosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pharmadados> rt = cq.from(Pharmadados.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

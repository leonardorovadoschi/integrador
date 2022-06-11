/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Vendedorbonusdesc;
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
public class VendedorbonusdescJpaController implements Serializable {

    public VendedorbonusdescJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vendedorbonusdesc vendedorbonusdesc) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(vendedorbonusdesc);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVendedorbonusdesc(vendedorbonusdesc.getCodvendedorbonusdesc()) != null) {
                throw new PreexistingEntityException("Vendedorbonusdesc " + vendedorbonusdesc + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vendedorbonusdesc vendedorbonusdesc) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            vendedorbonusdesc = em.merge(vendedorbonusdesc);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = vendedorbonusdesc.getCodvendedorbonusdesc();
                if (findVendedorbonusdesc(id) == null) {
                    throw new NonexistentEntityException("The vendedorbonusdesc with id " + id + " no longer exists.");
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
            Vendedorbonusdesc vendedorbonusdesc;
            try {
                vendedorbonusdesc = em.getReference(Vendedorbonusdesc.class, id);
                vendedorbonusdesc.getCodvendedorbonusdesc();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vendedorbonusdesc with id " + id + " no longer exists.", enfe);
            }
            em.remove(vendedorbonusdesc);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vendedorbonusdesc> findVendedorbonusdescEntities() {
        return findVendedorbonusdescEntities(true, -1, -1);
    }

    public List<Vendedorbonusdesc> findVendedorbonusdescEntities(int maxResults, int firstResult) {
        return findVendedorbonusdescEntities(false, maxResults, firstResult);
    }

    private List<Vendedorbonusdesc> findVendedorbonusdescEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vendedorbonusdesc.class));
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

    public Vendedorbonusdesc findVendedorbonusdesc(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vendedorbonusdesc.class, id);
        } finally {
            em.close();
        }
    }

    public int getVendedorbonusdescCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vendedorbonusdesc> rt = cq.from(Vendedorbonusdesc.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

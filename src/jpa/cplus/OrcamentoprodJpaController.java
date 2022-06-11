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
import entidade.cplus.Orcamentoprod;
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
public class OrcamentoprodJpaController implements Serializable {

    public OrcamentoprodJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Orcamentoprod orcamentoprod) throws PreexistingEntityException, Exception {
       
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
           
            em.persist(orcamentoprod);
           
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrcamentoprod(orcamentoprod.getCodorcprod()) != null) {
                throw new PreexistingEntityException("Orcamentoprod " + orcamentoprod + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Orcamentoprod orcamentoprod) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
           em.merge(orcamentoprod);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = orcamentoprod.getCodorcprod();
                if (findOrcamentoprod(id) == null) {
                    throw new NonexistentEntityException("The orcamentoprod with id " + id + " no longer exists.");
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
            Orcamentoprod orcamentoprod;
            try {
                orcamentoprod = em.getReference(Orcamentoprod.class, id);
                orcamentoprod.getCodorcprod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The orcamentoprod with id " + id + " no longer exists.", enfe);
            }
            
            em.remove(orcamentoprod);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Orcamentoprod> findOrcamentoprodEntities() {
        return findOrcamentoprodEntities(true, -1, -1);
    }

    public List<Orcamentoprod> findOrcamentoprodEntities(int maxResults, int firstResult) {
        return findOrcamentoprodEntities(false, maxResults, firstResult);
    }

    private List<Orcamentoprod> findOrcamentoprodEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Orcamentoprod.class));
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

    public Orcamentoprod findOrcamentoprod(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Orcamentoprod.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrcamentoprodCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Orcamentoprod> rt = cq.from(Orcamentoprod.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

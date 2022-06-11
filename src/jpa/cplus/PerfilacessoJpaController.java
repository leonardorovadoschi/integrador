/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Perfilacesso;
import entidade.cplus.PerfilacessoPK;
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
public class PerfilacessoJpaController implements Serializable {

    public PerfilacessoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Perfilacesso perfilacesso) throws PreexistingEntityException, Exception {
        if (perfilacesso.getPerfilacessoPK() == null) {
            perfilacesso.setPerfilacessoPK(new PerfilacessoPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(perfilacesso);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPerfilacesso(perfilacesso.getPerfilacessoPK()) != null) {
                throw new PreexistingEntityException("Perfilacesso " + perfilacesso + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Perfilacesso perfilacesso) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            perfilacesso = em.merge(perfilacesso);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PerfilacessoPK id = perfilacesso.getPerfilacessoPK();
                if (findPerfilacesso(id) == null) {
                    throw new NonexistentEntityException("The perfilacesso with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PerfilacessoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Perfilacesso perfilacesso;
            try {
                perfilacesso = em.getReference(Perfilacesso.class, id);
                perfilacesso.getPerfilacessoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The perfilacesso with id " + id + " no longer exists.", enfe);
            }
            em.remove(perfilacesso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Perfilacesso> findPerfilacessoEntities() {
        return findPerfilacessoEntities(true, -1, -1);
    }

    public List<Perfilacesso> findPerfilacessoEntities(int maxResults, int firstResult) {
        return findPerfilacessoEntities(false, maxResults, firstResult);
    }

    private List<Perfilacesso> findPerfilacessoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Perfilacesso.class));
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

    public Perfilacesso findPerfilacesso(PerfilacessoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Perfilacesso.class, id);
        } finally {
            em.close();
        }
    }

    public int getPerfilacessoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Perfilacesso> rt = cq.from(Perfilacesso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

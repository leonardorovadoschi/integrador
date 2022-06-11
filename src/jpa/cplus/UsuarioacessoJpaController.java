/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Usuarioacesso;
import entidade.cplus.UsuarioacessoPK;
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
public class UsuarioacessoJpaController implements Serializable {

    public UsuarioacessoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuarioacesso usuarioacesso) throws PreexistingEntityException, Exception {
        if (usuarioacesso.getUsuarioacessoPK() == null) {
            usuarioacesso.setUsuarioacessoPK(new UsuarioacessoPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(usuarioacesso);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuarioacesso(usuarioacesso.getUsuarioacessoPK()) != null) {
                throw new PreexistingEntityException("Usuarioacesso " + usuarioacesso + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuarioacesso usuarioacesso) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            usuarioacesso = em.merge(usuarioacesso);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                UsuarioacessoPK id = usuarioacesso.getUsuarioacessoPK();
                if (findUsuarioacesso(id) == null) {
                    throw new NonexistentEntityException("The usuarioacesso with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(UsuarioacessoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuarioacesso usuarioacesso;
            try {
                usuarioacesso = em.getReference(Usuarioacesso.class, id);
                usuarioacesso.getUsuarioacessoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarioacesso with id " + id + " no longer exists.", enfe);
            }
            em.remove(usuarioacesso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuarioacesso> findUsuarioacessoEntities() {
        return findUsuarioacessoEntities(true, -1, -1);
    }

    public List<Usuarioacesso> findUsuarioacessoEntities(int maxResults, int firstResult) {
        return findUsuarioacessoEntities(false, maxResults, firstResult);
    }

    private List<Usuarioacesso> findUsuarioacessoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuarioacesso.class));
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

    public Usuarioacesso findUsuarioacesso(UsuarioacessoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuarioacesso.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioacessoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuarioacesso> rt = cq.from(Usuarioacesso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

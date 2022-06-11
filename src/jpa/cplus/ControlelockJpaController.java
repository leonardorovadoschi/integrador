/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Controlelock;
import entidade.cplus.ControlelockPK;
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
public class ControlelockJpaController implements Serializable {

    public ControlelockJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Controlelock controlelock) throws PreexistingEntityException, Exception {
        if (controlelock.getControlelockPK() == null) {
            controlelock.setControlelockPK(new ControlelockPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(controlelock);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findControlelock(controlelock.getControlelockPK()) != null) {
                throw new PreexistingEntityException("Controlelock " + controlelock + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Controlelock controlelock) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            controlelock = em.merge(controlelock);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ControlelockPK id = controlelock.getControlelockPK();
                if (findControlelock(id) == null) {
                    throw new NonexistentEntityException("The controlelock with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ControlelockPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Controlelock controlelock;
            try {
                controlelock = em.getReference(Controlelock.class, id);
                controlelock.getControlelockPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The controlelock with id " + id + " no longer exists.", enfe);
            }
            em.remove(controlelock);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Controlelock> findControlelockEntities() {
        return findControlelockEntities(true, -1, -1);
    }

    public List<Controlelock> findControlelockEntities(int maxResults, int firstResult) {
        return findControlelockEntities(false, maxResults, firstResult);
    }

    private List<Controlelock> findControlelockEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Controlelock.class));
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

    public Controlelock findControlelock(ControlelockPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Controlelock.class, id);
        } finally {
            em.close();
        }
    }

    public int getControlelockCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Controlelock> rt = cq.from(Controlelock.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

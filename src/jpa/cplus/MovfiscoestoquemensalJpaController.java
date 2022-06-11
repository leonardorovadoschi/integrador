/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Movfiscoestoquemensal;
import entidade.cplus.MovfiscoestoquemensalPK;
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
public class MovfiscoestoquemensalJpaController implements Serializable {

    public MovfiscoestoquemensalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movfiscoestoquemensal movfiscoestoquemensal) throws PreexistingEntityException, Exception {
        if (movfiscoestoquemensal.getMovfiscoestoquemensalPK() == null) {
            movfiscoestoquemensal.setMovfiscoestoquemensalPK(new MovfiscoestoquemensalPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(movfiscoestoquemensal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovfiscoestoquemensal(movfiscoestoquemensal.getMovfiscoestoquemensalPK()) != null) {
                throw new PreexistingEntityException("Movfiscoestoquemensal " + movfiscoestoquemensal + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movfiscoestoquemensal movfiscoestoquemensal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            movfiscoestoquemensal = em.merge(movfiscoestoquemensal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                MovfiscoestoquemensalPK id = movfiscoestoquemensal.getMovfiscoestoquemensalPK();
                if (findMovfiscoestoquemensal(id) == null) {
                    throw new NonexistentEntityException("The movfiscoestoquemensal with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(MovfiscoestoquemensalPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movfiscoestoquemensal movfiscoestoquemensal;
            try {
                movfiscoestoquemensal = em.getReference(Movfiscoestoquemensal.class, id);
                movfiscoestoquemensal.getMovfiscoestoquemensalPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movfiscoestoquemensal with id " + id + " no longer exists.", enfe);
            }
            em.remove(movfiscoestoquemensal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movfiscoestoquemensal> findMovfiscoestoquemensalEntities() {
        return findMovfiscoestoquemensalEntities(true, -1, -1);
    }

    public List<Movfiscoestoquemensal> findMovfiscoestoquemensalEntities(int maxResults, int firstResult) {
        return findMovfiscoestoquemensalEntities(false, maxResults, firstResult);
    }

    private List<Movfiscoestoquemensal> findMovfiscoestoquemensalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movfiscoestoquemensal.class));
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

    public Movfiscoestoquemensal findMovfiscoestoquemensal(MovfiscoestoquemensalPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movfiscoestoquemensal.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovfiscoestoquemensalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movfiscoestoquemensal> rt = cq.from(Movfiscoestoquemensal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

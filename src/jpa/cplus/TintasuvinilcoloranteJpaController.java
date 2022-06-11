/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Tintasuvinilcolorante;
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
public class TintasuvinilcoloranteJpaController implements Serializable {

    public TintasuvinilcoloranteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tintasuvinilcolorante tintasuvinilcolorante) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tintasuvinilcolorante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTintasuvinilcolorante(tintasuvinilcolorante.getCodtintasuvinilcolorante()) != null) {
                throw new PreexistingEntityException("Tintasuvinilcolorante " + tintasuvinilcolorante + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tintasuvinilcolorante tintasuvinilcolorante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tintasuvinilcolorante = em.merge(tintasuvinilcolorante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tintasuvinilcolorante.getCodtintasuvinilcolorante();
                if (findTintasuvinilcolorante(id) == null) {
                    throw new NonexistentEntityException("The tintasuvinilcolorante with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tintasuvinilcolorante tintasuvinilcolorante;
            try {
                tintasuvinilcolorante = em.getReference(Tintasuvinilcolorante.class, id);
                tintasuvinilcolorante.getCodtintasuvinilcolorante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tintasuvinilcolorante with id " + id + " no longer exists.", enfe);
            }
            em.remove(tintasuvinilcolorante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tintasuvinilcolorante> findTintasuvinilcoloranteEntities() {
        return findTintasuvinilcoloranteEntities(true, -1, -1);
    }

    public List<Tintasuvinilcolorante> findTintasuvinilcoloranteEntities(int maxResults, int firstResult) {
        return findTintasuvinilcoloranteEntities(false, maxResults, firstResult);
    }

    private List<Tintasuvinilcolorante> findTintasuvinilcoloranteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tintasuvinilcolorante.class));
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

    public Tintasuvinilcolorante findTintasuvinilcolorante(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tintasuvinilcolorante.class, id);
        } finally {
            em.close();
        }
    }

    public int getTintasuvinilcoloranteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tintasuvinilcolorante> rt = cq.from(Tintasuvinilcolorante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Tintasuvinilcorrgb;
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
public class TintasuvinilcorrgbJpaController implements Serializable {

    public TintasuvinilcorrgbJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tintasuvinilcorrgb tintasuvinilcorrgb) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tintasuvinilcorrgb);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTintasuvinilcorrgb(tintasuvinilcorrgb.getCodtintasuvinilcorrgb()) != null) {
                throw new PreexistingEntityException("Tintasuvinilcorrgb " + tintasuvinilcorrgb + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tintasuvinilcorrgb tintasuvinilcorrgb) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tintasuvinilcorrgb = em.merge(tintasuvinilcorrgb);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tintasuvinilcorrgb.getCodtintasuvinilcorrgb();
                if (findTintasuvinilcorrgb(id) == null) {
                    throw new NonexistentEntityException("The tintasuvinilcorrgb with id " + id + " no longer exists.");
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
            Tintasuvinilcorrgb tintasuvinilcorrgb;
            try {
                tintasuvinilcorrgb = em.getReference(Tintasuvinilcorrgb.class, id);
                tintasuvinilcorrgb.getCodtintasuvinilcorrgb();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tintasuvinilcorrgb with id " + id + " no longer exists.", enfe);
            }
            em.remove(tintasuvinilcorrgb);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tintasuvinilcorrgb> findTintasuvinilcorrgbEntities() {
        return findTintasuvinilcorrgbEntities(true, -1, -1);
    }

    public List<Tintasuvinilcorrgb> findTintasuvinilcorrgbEntities(int maxResults, int firstResult) {
        return findTintasuvinilcorrgbEntities(false, maxResults, firstResult);
    }

    private List<Tintasuvinilcorrgb> findTintasuvinilcorrgbEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tintasuvinilcorrgb.class));
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

    public Tintasuvinilcorrgb findTintasuvinilcorrgb(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tintasuvinilcorrgb.class, id);
        } finally {
            em.close();
        }
    }

    public int getTintasuvinilcorrgbCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tintasuvinilcorrgb> rt = cq.from(Tintasuvinilcorrgb.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Tintasuvinilbase;
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
public class TintasuvinilbaseJpaController implements Serializable {

    public TintasuvinilbaseJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tintasuvinilbase tintasuvinilbase) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tintasuvinilbase);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTintasuvinilbase(tintasuvinilbase.getCodtintasuvinilbase()) != null) {
                throw new PreexistingEntityException("Tintasuvinilbase " + tintasuvinilbase + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tintasuvinilbase tintasuvinilbase) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tintasuvinilbase = em.merge(tintasuvinilbase);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tintasuvinilbase.getCodtintasuvinilbase();
                if (findTintasuvinilbase(id) == null) {
                    throw new NonexistentEntityException("The tintasuvinilbase with id " + id + " no longer exists.");
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
            Tintasuvinilbase tintasuvinilbase;
            try {
                tintasuvinilbase = em.getReference(Tintasuvinilbase.class, id);
                tintasuvinilbase.getCodtintasuvinilbase();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tintasuvinilbase with id " + id + " no longer exists.", enfe);
            }
            em.remove(tintasuvinilbase);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tintasuvinilbase> findTintasuvinilbaseEntities() {
        return findTintasuvinilbaseEntities(true, -1, -1);
    }

    public List<Tintasuvinilbase> findTintasuvinilbaseEntities(int maxResults, int firstResult) {
        return findTintasuvinilbaseEntities(false, maxResults, firstResult);
    }

    private List<Tintasuvinilbase> findTintasuvinilbaseEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tintasuvinilbase.class));
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

    public Tintasuvinilbase findTintasuvinilbase(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tintasuvinilbase.class, id);
        } finally {
            em.close();
        }
    }

    public int getTintasuvinilbaseCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tintasuvinilbase> rt = cq.from(Tintasuvinilbase.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

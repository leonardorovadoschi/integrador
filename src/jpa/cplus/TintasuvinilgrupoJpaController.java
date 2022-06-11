/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Tintasuvinilgrupo;
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
public class TintasuvinilgrupoJpaController implements Serializable {

    public TintasuvinilgrupoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tintasuvinilgrupo tintasuvinilgrupo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tintasuvinilgrupo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTintasuvinilgrupo(tintasuvinilgrupo.getCodtintasuvinilgrupo()) != null) {
                throw new PreexistingEntityException("Tintasuvinilgrupo " + tintasuvinilgrupo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tintasuvinilgrupo tintasuvinilgrupo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tintasuvinilgrupo = em.merge(tintasuvinilgrupo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tintasuvinilgrupo.getCodtintasuvinilgrupo();
                if (findTintasuvinilgrupo(id) == null) {
                    throw new NonexistentEntityException("The tintasuvinilgrupo with id " + id + " no longer exists.");
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
            Tintasuvinilgrupo tintasuvinilgrupo;
            try {
                tintasuvinilgrupo = em.getReference(Tintasuvinilgrupo.class, id);
                tintasuvinilgrupo.getCodtintasuvinilgrupo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tintasuvinilgrupo with id " + id + " no longer exists.", enfe);
            }
            em.remove(tintasuvinilgrupo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tintasuvinilgrupo> findTintasuvinilgrupoEntities() {
        return findTintasuvinilgrupoEntities(true, -1, -1);
    }

    public List<Tintasuvinilgrupo> findTintasuvinilgrupoEntities(int maxResults, int firstResult) {
        return findTintasuvinilgrupoEntities(false, maxResults, firstResult);
    }

    private List<Tintasuvinilgrupo> findTintasuvinilgrupoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tintasuvinilgrupo.class));
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

    public Tintasuvinilgrupo findTintasuvinilgrupo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tintasuvinilgrupo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTintasuvinilgrupoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tintasuvinilgrupo> rt = cq.from(Tintasuvinilgrupo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

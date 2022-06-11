/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpInventario;
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
public class TmpInventarioJpaController implements Serializable {

    public TmpInventarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpInventario tmpInventario) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpInventario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpInventario(tmpInventario.getCodprod()) != null) {
                throw new PreexistingEntityException("TmpInventario " + tmpInventario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpInventario tmpInventario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpInventario = em.merge(tmpInventario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tmpInventario.getCodprod();
                if (findTmpInventario(id) == null) {
                    throw new NonexistentEntityException("The tmpInventario with id " + id + " no longer exists.");
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
            TmpInventario tmpInventario;
            try {
                tmpInventario = em.getReference(TmpInventario.class, id);
                tmpInventario.getCodprod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpInventario with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpInventario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpInventario> findTmpInventarioEntities() {
        return findTmpInventarioEntities(true, -1, -1);
    }

    public List<TmpInventario> findTmpInventarioEntities(int maxResults, int firstResult) {
        return findTmpInventarioEntities(false, maxResults, firstResult);
    }

    private List<TmpInventario> findTmpInventarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpInventario.class));
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

    public TmpInventario findTmpInventario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpInventario.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpInventarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpInventario> rt = cq.from(TmpInventario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

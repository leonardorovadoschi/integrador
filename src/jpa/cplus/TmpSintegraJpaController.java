/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpSintegra;
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
public class TmpSintegraJpaController implements Serializable {

    public TmpSintegraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpSintegra tmpSintegra) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpSintegra);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpSintegra(tmpSintegra.getCodprod()) != null) {
                throw new PreexistingEntityException("TmpSintegra " + tmpSintegra + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpSintegra tmpSintegra) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpSintegra = em.merge(tmpSintegra);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tmpSintegra.getCodprod();
                if (findTmpSintegra(id) == null) {
                    throw new NonexistentEntityException("The tmpSintegra with id " + id + " no longer exists.");
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
            TmpSintegra tmpSintegra;
            try {
                tmpSintegra = em.getReference(TmpSintegra.class, id);
                tmpSintegra.getCodprod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpSintegra with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpSintegra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpSintegra> findTmpSintegraEntities() {
        return findTmpSintegraEntities(true, -1, -1);
    }

    public List<TmpSintegra> findTmpSintegraEntities(int maxResults, int firstResult) {
        return findTmpSintegraEntities(false, maxResults, firstResult);
    }

    private List<TmpSintegra> findTmpSintegraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpSintegra.class));
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

    public TmpSintegra findTmpSintegra(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpSintegra.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpSintegraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpSintegra> rt = cq.from(TmpSintegra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

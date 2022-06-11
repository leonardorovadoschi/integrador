/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpWms;
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
public class TmpWmsJpaController implements Serializable {

    public TmpWmsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpWms tmpWms) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpWms);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpWms(tmpWms.getCodprod()) != null) {
                throw new PreexistingEntityException("TmpWms " + tmpWms + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpWms tmpWms) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpWms = em.merge(tmpWms);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tmpWms.getCodprod();
                if (findTmpWms(id) == null) {
                    throw new NonexistentEntityException("The tmpWms with id " + id + " no longer exists.");
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
            TmpWms tmpWms;
            try {
                tmpWms = em.getReference(TmpWms.class, id);
                tmpWms.getCodprod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpWms with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpWms);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpWms> findTmpWmsEntities() {
        return findTmpWmsEntities(true, -1, -1);
    }

    public List<TmpWms> findTmpWmsEntities(int maxResults, int firstResult) {
        return findTmpWmsEntities(false, maxResults, firstResult);
    }

    private List<TmpWms> findTmpWmsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpWms.class));
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

    public TmpWms findTmpWms(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpWms.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpWmsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpWms> rt = cq.from(TmpWms.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

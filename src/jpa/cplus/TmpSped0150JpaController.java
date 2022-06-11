/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpSped0150;
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
public class TmpSped0150JpaController implements Serializable {

    public TmpSped0150JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpSped0150 tmpSped0150) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpSped0150);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpSped0150(tmpSped0150.getCodtmpSped0150()) != null) {
                throw new PreexistingEntityException("TmpSped0150 " + tmpSped0150 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpSped0150 tmpSped0150) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpSped0150 = em.merge(tmpSped0150);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpSped0150.getCodtmpSped0150();
                if (findTmpSped0150(id) == null) {
                    throw new NonexistentEntityException("The tmpSped0150 with id " + id + " no longer exists.");
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
            TmpSped0150 tmpSped0150;
            try {
                tmpSped0150 = em.getReference(TmpSped0150.class, id);
                tmpSped0150.getCodtmpSped0150();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpSped0150 with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpSped0150);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpSped0150> findTmpSped0150Entities() {
        return findTmpSped0150Entities(true, -1, -1);
    }

    public List<TmpSped0150> findTmpSped0150Entities(int maxResults, int firstResult) {
        return findTmpSped0150Entities(false, maxResults, firstResult);
    }

    private List<TmpSped0150> findTmpSped0150Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpSped0150.class));
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

    public TmpSped0150 findTmpSped0150(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpSped0150.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpSped0150Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpSped0150> rt = cq.from(TmpSped0150.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

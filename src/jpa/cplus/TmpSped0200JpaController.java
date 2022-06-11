/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpSped0200;
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
public class TmpSped0200JpaController implements Serializable {

    public TmpSped0200JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpSped0200 tmpSped0200) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpSped0200);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpSped0200(tmpSped0200.getCodtmpSped0200()) != null) {
                throw new PreexistingEntityException("TmpSped0200 " + tmpSped0200 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpSped0200 tmpSped0200) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpSped0200 = em.merge(tmpSped0200);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpSped0200.getCodtmpSped0200();
                if (findTmpSped0200(id) == null) {
                    throw new NonexistentEntityException("The tmpSped0200 with id " + id + " no longer exists.");
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
            TmpSped0200 tmpSped0200;
            try {
                tmpSped0200 = em.getReference(TmpSped0200.class, id);
                tmpSped0200.getCodtmpSped0200();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpSped0200 with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpSped0200);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpSped0200> findTmpSped0200Entities() {
        return findTmpSped0200Entities(true, -1, -1);
    }

    public List<TmpSped0200> findTmpSped0200Entities(int maxResults, int firstResult) {
        return findTmpSped0200Entities(false, maxResults, firstResult);
    }

    private List<TmpSped0200> findTmpSped0200Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpSped0200.class));
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

    public TmpSped0200 findTmpSped0200(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpSped0200.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpSped0200Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpSped0200> rt = cq.from(TmpSped0200.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

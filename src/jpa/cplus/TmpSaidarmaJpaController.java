/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpSaidarma;
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
public class TmpSaidarmaJpaController implements Serializable {

    public TmpSaidarmaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpSaidarma tmpSaidarma) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpSaidarma);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpSaidarma(tmpSaidarma.getCodrma()) != null) {
                throw new PreexistingEntityException("TmpSaidarma " + tmpSaidarma + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpSaidarma tmpSaidarma) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpSaidarma = em.merge(tmpSaidarma);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tmpSaidarma.getCodrma();
                if (findTmpSaidarma(id) == null) {
                    throw new NonexistentEntityException("The tmpSaidarma with id " + id + " no longer exists.");
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
            TmpSaidarma tmpSaidarma;
            try {
                tmpSaidarma = em.getReference(TmpSaidarma.class, id);
                tmpSaidarma.getCodrma();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpSaidarma with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpSaidarma);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpSaidarma> findTmpSaidarmaEntities() {
        return findTmpSaidarmaEntities(true, -1, -1);
    }

    public List<TmpSaidarma> findTmpSaidarmaEntities(int maxResults, int firstResult) {
        return findTmpSaidarmaEntities(false, maxResults, firstResult);
    }

    private List<TmpSaidarma> findTmpSaidarmaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpSaidarma.class));
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

    public TmpSaidarma findTmpSaidarma(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpSaidarma.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpSaidarmaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpSaidarma> rt = cq.from(TmpSaidarma.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

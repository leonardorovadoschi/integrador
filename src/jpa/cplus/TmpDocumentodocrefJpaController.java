/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpDocumentodocref;
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
public class TmpDocumentodocrefJpaController implements Serializable {

    public TmpDocumentodocrefJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpDocumentodocref tmpDocumentodocref) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpDocumentodocref);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpDocumentodocref(tmpDocumentodocref.getCodtmpDocumentodocref()) != null) {
                throw new PreexistingEntityException("TmpDocumentodocref " + tmpDocumentodocref + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpDocumentodocref tmpDocumentodocref) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpDocumentodocref = em.merge(tmpDocumentodocref);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpDocumentodocref.getCodtmpDocumentodocref();
                if (findTmpDocumentodocref(id) == null) {
                    throw new NonexistentEntityException("The tmpDocumentodocref with id " + id + " no longer exists.");
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
            TmpDocumentodocref tmpDocumentodocref;
            try {
                tmpDocumentodocref = em.getReference(TmpDocumentodocref.class, id);
                tmpDocumentodocref.getCodtmpDocumentodocref();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpDocumentodocref with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpDocumentodocref);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpDocumentodocref> findTmpDocumentodocrefEntities() {
        return findTmpDocumentodocrefEntities(true, -1, -1);
    }

    public List<TmpDocumentodocref> findTmpDocumentodocrefEntities(int maxResults, int firstResult) {
        return findTmpDocumentodocrefEntities(false, maxResults, firstResult);
    }

    private List<TmpDocumentodocref> findTmpDocumentodocrefEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpDocumentodocref.class));
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

    public TmpDocumentodocref findTmpDocumentodocref(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpDocumentodocref.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpDocumentodocrefCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpDocumentodocref> rt = cq.from(TmpDocumentodocref.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

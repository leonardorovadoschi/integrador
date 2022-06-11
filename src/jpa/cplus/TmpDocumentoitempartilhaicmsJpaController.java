/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpDocumentoitempartilhaicms;
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
public class TmpDocumentoitempartilhaicmsJpaController implements Serializable {

    public TmpDocumentoitempartilhaicmsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpDocumentoitempartilhaicms tmpDocumentoitempartilhaicms) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpDocumentoitempartilhaicms);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpDocumentoitempartilhaicms(tmpDocumentoitempartilhaicms.getCodtmpDocumentoitempartilha()) != null) {
                throw new PreexistingEntityException("TmpDocumentoitempartilhaicms " + tmpDocumentoitempartilhaicms + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpDocumentoitempartilhaicms tmpDocumentoitempartilhaicms) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpDocumentoitempartilhaicms = em.merge(tmpDocumentoitempartilhaicms);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpDocumentoitempartilhaicms.getCodtmpDocumentoitempartilha();
                if (findTmpDocumentoitempartilhaicms(id) == null) {
                    throw new NonexistentEntityException("The tmpDocumentoitempartilhaicms with id " + id + " no longer exists.");
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
            TmpDocumentoitempartilhaicms tmpDocumentoitempartilhaicms;
            try {
                tmpDocumentoitempartilhaicms = em.getReference(TmpDocumentoitempartilhaicms.class, id);
                tmpDocumentoitempartilhaicms.getCodtmpDocumentoitempartilha();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpDocumentoitempartilhaicms with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpDocumentoitempartilhaicms);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpDocumentoitempartilhaicms> findTmpDocumentoitempartilhaicmsEntities() {
        return findTmpDocumentoitempartilhaicmsEntities(true, -1, -1);
    }

    public List<TmpDocumentoitempartilhaicms> findTmpDocumentoitempartilhaicmsEntities(int maxResults, int firstResult) {
        return findTmpDocumentoitempartilhaicmsEntities(false, maxResults, firstResult);
    }

    private List<TmpDocumentoitempartilhaicms> findTmpDocumentoitempartilhaicmsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpDocumentoitempartilhaicms.class));
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

    public TmpDocumentoitempartilhaicms findTmpDocumentoitempartilhaicms(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpDocumentoitempartilhaicms.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpDocumentoitempartilhaicmsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpDocumentoitempartilhaicms> rt = cq.from(TmpDocumentoitempartilhaicms.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

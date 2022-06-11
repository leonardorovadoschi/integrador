/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpDocumentoentrega;
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
public class TmpDocumentoentregaJpaController implements Serializable {

    public TmpDocumentoentregaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpDocumentoentrega tmpDocumentoentrega) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpDocumentoentrega);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpDocumentoentrega(tmpDocumentoentrega.getCodtmpDocumentoentrega()) != null) {
                throw new PreexistingEntityException("TmpDocumentoentrega " + tmpDocumentoentrega + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpDocumentoentrega tmpDocumentoentrega) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpDocumentoentrega = em.merge(tmpDocumentoentrega);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpDocumentoentrega.getCodtmpDocumentoentrega();
                if (findTmpDocumentoentrega(id) == null) {
                    throw new NonexistentEntityException("The tmpDocumentoentrega with id " + id + " no longer exists.");
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
            TmpDocumentoentrega tmpDocumentoentrega;
            try {
                tmpDocumentoentrega = em.getReference(TmpDocumentoentrega.class, id);
                tmpDocumentoentrega.getCodtmpDocumentoentrega();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpDocumentoentrega with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpDocumentoentrega);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpDocumentoentrega> findTmpDocumentoentregaEntities() {
        return findTmpDocumentoentregaEntities(true, -1, -1);
    }

    public List<TmpDocumentoentrega> findTmpDocumentoentregaEntities(int maxResults, int firstResult) {
        return findTmpDocumentoentregaEntities(false, maxResults, firstResult);
    }

    private List<TmpDocumentoentrega> findTmpDocumentoentregaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpDocumentoentrega.class));
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

    public TmpDocumentoentrega findTmpDocumentoentrega(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpDocumentoentrega.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpDocumentoentregaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpDocumentoentrega> rt = cq.from(TmpDocumentoentrega.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

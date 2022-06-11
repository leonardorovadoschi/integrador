/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpDocumento;
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
public class TmpDocumentoJpaController implements Serializable {

    public TmpDocumentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpDocumento tmpDocumento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpDocumento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpDocumento(tmpDocumento.getCodtmpDocumento()) != null) {
                throw new PreexistingEntityException("TmpDocumento " + tmpDocumento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpDocumento tmpDocumento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpDocumento = em.merge(tmpDocumento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpDocumento.getCodtmpDocumento();
                if (findTmpDocumento(id) == null) {
                    throw new NonexistentEntityException("The tmpDocumento with id " + id + " no longer exists.");
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
            TmpDocumento tmpDocumento;
            try {
                tmpDocumento = em.getReference(TmpDocumento.class, id);
                tmpDocumento.getCodtmpDocumento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpDocumento with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpDocumento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpDocumento> findTmpDocumentoEntities() {
        return findTmpDocumentoEntities(true, -1, -1);
    }

    public List<TmpDocumento> findTmpDocumentoEntities(int maxResults, int firstResult) {
        return findTmpDocumentoEntities(false, maxResults, firstResult);
    }

    private List<TmpDocumento> findTmpDocumentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpDocumento.class));
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

    public TmpDocumento findTmpDocumento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpDocumento.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpDocumentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpDocumento> rt = cq.from(TmpDocumento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

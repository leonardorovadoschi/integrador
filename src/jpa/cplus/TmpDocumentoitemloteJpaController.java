/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpDocumentoitemlote;
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
public class TmpDocumentoitemloteJpaController implements Serializable {

    public TmpDocumentoitemloteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpDocumentoitemlote tmpDocumentoitemlote) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpDocumentoitemlote);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpDocumentoitemlote(tmpDocumentoitemlote.getCodtmpDocumentoitemlote()) != null) {
                throw new PreexistingEntityException("TmpDocumentoitemlote " + tmpDocumentoitemlote + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpDocumentoitemlote tmpDocumentoitemlote) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpDocumentoitemlote = em.merge(tmpDocumentoitemlote);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpDocumentoitemlote.getCodtmpDocumentoitemlote();
                if (findTmpDocumentoitemlote(id) == null) {
                    throw new NonexistentEntityException("The tmpDocumentoitemlote with id " + id + " no longer exists.");
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
            TmpDocumentoitemlote tmpDocumentoitemlote;
            try {
                tmpDocumentoitemlote = em.getReference(TmpDocumentoitemlote.class, id);
                tmpDocumentoitemlote.getCodtmpDocumentoitemlote();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpDocumentoitemlote with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpDocumentoitemlote);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpDocumentoitemlote> findTmpDocumentoitemloteEntities() {
        return findTmpDocumentoitemloteEntities(true, -1, -1);
    }

    public List<TmpDocumentoitemlote> findTmpDocumentoitemloteEntities(int maxResults, int firstResult) {
        return findTmpDocumentoitemloteEntities(false, maxResults, firstResult);
    }

    private List<TmpDocumentoitemlote> findTmpDocumentoitemloteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpDocumentoitemlote.class));
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

    public TmpDocumentoitemlote findTmpDocumentoitemlote(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpDocumentoitemlote.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpDocumentoitemloteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpDocumentoitemlote> rt = cq.from(TmpDocumentoitemlote.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

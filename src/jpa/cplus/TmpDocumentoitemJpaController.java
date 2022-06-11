/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpDocumentoitem;
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
public class TmpDocumentoitemJpaController implements Serializable {

    public TmpDocumentoitemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpDocumentoitem tmpDocumentoitem) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpDocumentoitem);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpDocumentoitem(tmpDocumentoitem.getCodtmpDocumentoitem()) != null) {
                throw new PreexistingEntityException("TmpDocumentoitem " + tmpDocumentoitem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpDocumentoitem tmpDocumentoitem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpDocumentoitem = em.merge(tmpDocumentoitem);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpDocumentoitem.getCodtmpDocumentoitem();
                if (findTmpDocumentoitem(id) == null) {
                    throw new NonexistentEntityException("The tmpDocumentoitem with id " + id + " no longer exists.");
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
            TmpDocumentoitem tmpDocumentoitem;
            try {
                tmpDocumentoitem = em.getReference(TmpDocumentoitem.class, id);
                tmpDocumentoitem.getCodtmpDocumentoitem();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpDocumentoitem with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpDocumentoitem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpDocumentoitem> findTmpDocumentoitemEntities() {
        return findTmpDocumentoitemEntities(true, -1, -1);
    }

    public List<TmpDocumentoitem> findTmpDocumentoitemEntities(int maxResults, int firstResult) {
        return findTmpDocumentoitemEntities(false, maxResults, firstResult);
    }

    private List<TmpDocumentoitem> findTmpDocumentoitemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpDocumentoitem.class));
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

    public TmpDocumentoitem findTmpDocumentoitem(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpDocumentoitem.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpDocumentoitemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpDocumentoitem> rt = cq.from(TmpDocumentoitem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.TmpSpedDocumento;
import entidade.cplus.TmpSpedDocumentoitem;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class TmpSpedDocumentoitemJpaController implements Serializable {

    public TmpSpedDocumentoitemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpSpedDocumentoitem tmpSpedDocumentoitem) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TmpSpedDocumento codtmpSpedDocumento = tmpSpedDocumentoitem.getCodtmpSpedDocumento();
            if (codtmpSpedDocumento != null) {
                codtmpSpedDocumento = em.getReference(codtmpSpedDocumento.getClass(), codtmpSpedDocumento.getCodtmpSpedDocumento());
                tmpSpedDocumentoitem.setCodtmpSpedDocumento(codtmpSpedDocumento);
            }
            em.persist(tmpSpedDocumentoitem);
            if (codtmpSpedDocumento != null) {
                codtmpSpedDocumento.getTmpSpedDocumentoitemCollection().add(tmpSpedDocumentoitem);
                codtmpSpedDocumento = em.merge(codtmpSpedDocumento);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpSpedDocumentoitem(tmpSpedDocumentoitem.getCodtmpSpedDocumentoitem()) != null) {
                throw new PreexistingEntityException("TmpSpedDocumentoitem " + tmpSpedDocumentoitem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpSpedDocumentoitem tmpSpedDocumentoitem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TmpSpedDocumentoitem persistentTmpSpedDocumentoitem = em.find(TmpSpedDocumentoitem.class, tmpSpedDocumentoitem.getCodtmpSpedDocumentoitem());
            TmpSpedDocumento codtmpSpedDocumentoOld = persistentTmpSpedDocumentoitem.getCodtmpSpedDocumento();
            TmpSpedDocumento codtmpSpedDocumentoNew = tmpSpedDocumentoitem.getCodtmpSpedDocumento();
            if (codtmpSpedDocumentoNew != null) {
                codtmpSpedDocumentoNew = em.getReference(codtmpSpedDocumentoNew.getClass(), codtmpSpedDocumentoNew.getCodtmpSpedDocumento());
                tmpSpedDocumentoitem.setCodtmpSpedDocumento(codtmpSpedDocumentoNew);
            }
            tmpSpedDocumentoitem = em.merge(tmpSpedDocumentoitem);
            if (codtmpSpedDocumentoOld != null && !codtmpSpedDocumentoOld.equals(codtmpSpedDocumentoNew)) {
                codtmpSpedDocumentoOld.getTmpSpedDocumentoitemCollection().remove(tmpSpedDocumentoitem);
                codtmpSpedDocumentoOld = em.merge(codtmpSpedDocumentoOld);
            }
            if (codtmpSpedDocumentoNew != null && !codtmpSpedDocumentoNew.equals(codtmpSpedDocumentoOld)) {
                codtmpSpedDocumentoNew.getTmpSpedDocumentoitemCollection().add(tmpSpedDocumentoitem);
                codtmpSpedDocumentoNew = em.merge(codtmpSpedDocumentoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpSpedDocumentoitem.getCodtmpSpedDocumentoitem();
                if (findTmpSpedDocumentoitem(id) == null) {
                    throw new NonexistentEntityException("The tmpSpedDocumentoitem with id " + id + " no longer exists.");
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
            TmpSpedDocumentoitem tmpSpedDocumentoitem;
            try {
                tmpSpedDocumentoitem = em.getReference(TmpSpedDocumentoitem.class, id);
                tmpSpedDocumentoitem.getCodtmpSpedDocumentoitem();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpSpedDocumentoitem with id " + id + " no longer exists.", enfe);
            }
            TmpSpedDocumento codtmpSpedDocumento = tmpSpedDocumentoitem.getCodtmpSpedDocumento();
            if (codtmpSpedDocumento != null) {
                codtmpSpedDocumento.getTmpSpedDocumentoitemCollection().remove(tmpSpedDocumentoitem);
                codtmpSpedDocumento = em.merge(codtmpSpedDocumento);
            }
            em.remove(tmpSpedDocumentoitem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpSpedDocumentoitem> findTmpSpedDocumentoitemEntities() {
        return findTmpSpedDocumentoitemEntities(true, -1, -1);
    }

    public List<TmpSpedDocumentoitem> findTmpSpedDocumentoitemEntities(int maxResults, int firstResult) {
        return findTmpSpedDocumentoitemEntities(false, maxResults, firstResult);
    }

    private List<TmpSpedDocumentoitem> findTmpSpedDocumentoitemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpSpedDocumentoitem.class));
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

    public TmpSpedDocumentoitem findTmpSpedDocumentoitem(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpSpedDocumentoitem.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpSpedDocumentoitemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpSpedDocumentoitem> rt = cq.from(TmpSpedDocumentoitem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

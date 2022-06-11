/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpSpedDocumento;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.TmpSpedDocumentoitem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.IllegalOrphanException;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class TmpSpedDocumentoJpaController implements Serializable {

    public TmpSpedDocumentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpSpedDocumento tmpSpedDocumento) throws PreexistingEntityException, Exception {
        if (tmpSpedDocumento.getTmpSpedDocumentoitemCollection() == null) {
            tmpSpedDocumento.setTmpSpedDocumentoitemCollection(new ArrayList<TmpSpedDocumentoitem>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<TmpSpedDocumentoitem> attachedTmpSpedDocumentoitemCollection = new ArrayList<TmpSpedDocumentoitem>();
            for (TmpSpedDocumentoitem tmpSpedDocumentoitemCollectionTmpSpedDocumentoitemToAttach : tmpSpedDocumento.getTmpSpedDocumentoitemCollection()) {
                tmpSpedDocumentoitemCollectionTmpSpedDocumentoitemToAttach = em.getReference(tmpSpedDocumentoitemCollectionTmpSpedDocumentoitemToAttach.getClass(), tmpSpedDocumentoitemCollectionTmpSpedDocumentoitemToAttach.getCodtmpSpedDocumentoitem());
                attachedTmpSpedDocumentoitemCollection.add(tmpSpedDocumentoitemCollectionTmpSpedDocumentoitemToAttach);
            }
            tmpSpedDocumento.setTmpSpedDocumentoitemCollection(attachedTmpSpedDocumentoitemCollection);
            em.persist(tmpSpedDocumento);
            for (TmpSpedDocumentoitem tmpSpedDocumentoitemCollectionTmpSpedDocumentoitem : tmpSpedDocumento.getTmpSpedDocumentoitemCollection()) {
                TmpSpedDocumento oldCodtmpSpedDocumentoOfTmpSpedDocumentoitemCollectionTmpSpedDocumentoitem = tmpSpedDocumentoitemCollectionTmpSpedDocumentoitem.getCodtmpSpedDocumento();
                tmpSpedDocumentoitemCollectionTmpSpedDocumentoitem.setCodtmpSpedDocumento(tmpSpedDocumento);
                tmpSpedDocumentoitemCollectionTmpSpedDocumentoitem = em.merge(tmpSpedDocumentoitemCollectionTmpSpedDocumentoitem);
                if (oldCodtmpSpedDocumentoOfTmpSpedDocumentoitemCollectionTmpSpedDocumentoitem != null) {
                    oldCodtmpSpedDocumentoOfTmpSpedDocumentoitemCollectionTmpSpedDocumentoitem.getTmpSpedDocumentoitemCollection().remove(tmpSpedDocumentoitemCollectionTmpSpedDocumentoitem);
                    oldCodtmpSpedDocumentoOfTmpSpedDocumentoitemCollectionTmpSpedDocumentoitem = em.merge(oldCodtmpSpedDocumentoOfTmpSpedDocumentoitemCollectionTmpSpedDocumentoitem);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpSpedDocumento(tmpSpedDocumento.getCodtmpSpedDocumento()) != null) {
                throw new PreexistingEntityException("TmpSpedDocumento " + tmpSpedDocumento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpSpedDocumento tmpSpedDocumento) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TmpSpedDocumento persistentTmpSpedDocumento = em.find(TmpSpedDocumento.class, tmpSpedDocumento.getCodtmpSpedDocumento());
            Collection<TmpSpedDocumentoitem> tmpSpedDocumentoitemCollectionOld = persistentTmpSpedDocumento.getTmpSpedDocumentoitemCollection();
            Collection<TmpSpedDocumentoitem> tmpSpedDocumentoitemCollectionNew = tmpSpedDocumento.getTmpSpedDocumentoitemCollection();
            List<String> illegalOrphanMessages = null;
            for (TmpSpedDocumentoitem tmpSpedDocumentoitemCollectionOldTmpSpedDocumentoitem : tmpSpedDocumentoitemCollectionOld) {
                if (!tmpSpedDocumentoitemCollectionNew.contains(tmpSpedDocumentoitemCollectionOldTmpSpedDocumentoitem)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain TmpSpedDocumentoitem " + tmpSpedDocumentoitemCollectionOldTmpSpedDocumentoitem + " since its codtmpSpedDocumento field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<TmpSpedDocumentoitem> attachedTmpSpedDocumentoitemCollectionNew = new ArrayList<TmpSpedDocumentoitem>();
            for (TmpSpedDocumentoitem tmpSpedDocumentoitemCollectionNewTmpSpedDocumentoitemToAttach : tmpSpedDocumentoitemCollectionNew) {
                tmpSpedDocumentoitemCollectionNewTmpSpedDocumentoitemToAttach = em.getReference(tmpSpedDocumentoitemCollectionNewTmpSpedDocumentoitemToAttach.getClass(), tmpSpedDocumentoitemCollectionNewTmpSpedDocumentoitemToAttach.getCodtmpSpedDocumentoitem());
                attachedTmpSpedDocumentoitemCollectionNew.add(tmpSpedDocumentoitemCollectionNewTmpSpedDocumentoitemToAttach);
            }
            tmpSpedDocumentoitemCollectionNew = attachedTmpSpedDocumentoitemCollectionNew;
            tmpSpedDocumento.setTmpSpedDocumentoitemCollection(tmpSpedDocumentoitemCollectionNew);
            tmpSpedDocumento = em.merge(tmpSpedDocumento);
            for (TmpSpedDocumentoitem tmpSpedDocumentoitemCollectionNewTmpSpedDocumentoitem : tmpSpedDocumentoitemCollectionNew) {
                if (!tmpSpedDocumentoitemCollectionOld.contains(tmpSpedDocumentoitemCollectionNewTmpSpedDocumentoitem)) {
                    TmpSpedDocumento oldCodtmpSpedDocumentoOfTmpSpedDocumentoitemCollectionNewTmpSpedDocumentoitem = tmpSpedDocumentoitemCollectionNewTmpSpedDocumentoitem.getCodtmpSpedDocumento();
                    tmpSpedDocumentoitemCollectionNewTmpSpedDocumentoitem.setCodtmpSpedDocumento(tmpSpedDocumento);
                    tmpSpedDocumentoitemCollectionNewTmpSpedDocumentoitem = em.merge(tmpSpedDocumentoitemCollectionNewTmpSpedDocumentoitem);
                    if (oldCodtmpSpedDocumentoOfTmpSpedDocumentoitemCollectionNewTmpSpedDocumentoitem != null && !oldCodtmpSpedDocumentoOfTmpSpedDocumentoitemCollectionNewTmpSpedDocumentoitem.equals(tmpSpedDocumento)) {
                        oldCodtmpSpedDocumentoOfTmpSpedDocumentoitemCollectionNewTmpSpedDocumentoitem.getTmpSpedDocumentoitemCollection().remove(tmpSpedDocumentoitemCollectionNewTmpSpedDocumentoitem);
                        oldCodtmpSpedDocumentoOfTmpSpedDocumentoitemCollectionNewTmpSpedDocumentoitem = em.merge(oldCodtmpSpedDocumentoOfTmpSpedDocumentoitemCollectionNewTmpSpedDocumentoitem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpSpedDocumento.getCodtmpSpedDocumento();
                if (findTmpSpedDocumento(id) == null) {
                    throw new NonexistentEntityException("The tmpSpedDocumento with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TmpSpedDocumento tmpSpedDocumento;
            try {
                tmpSpedDocumento = em.getReference(TmpSpedDocumento.class, id);
                tmpSpedDocumento.getCodtmpSpedDocumento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpSpedDocumento with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<TmpSpedDocumentoitem> tmpSpedDocumentoitemCollectionOrphanCheck = tmpSpedDocumento.getTmpSpedDocumentoitemCollection();
            for (TmpSpedDocumentoitem tmpSpedDocumentoitemCollectionOrphanCheckTmpSpedDocumentoitem : tmpSpedDocumentoitemCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This TmpSpedDocumento (" + tmpSpedDocumento + ") cannot be destroyed since the TmpSpedDocumentoitem " + tmpSpedDocumentoitemCollectionOrphanCheckTmpSpedDocumentoitem + " in its tmpSpedDocumentoitemCollection field has a non-nullable codtmpSpedDocumento field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tmpSpedDocumento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpSpedDocumento> findTmpSpedDocumentoEntities() {
        return findTmpSpedDocumentoEntities(true, -1, -1);
    }

    public List<TmpSpedDocumento> findTmpSpedDocumentoEntities(int maxResults, int firstResult) {
        return findTmpSpedDocumentoEntities(false, maxResults, firstResult);
    }

    private List<TmpSpedDocumento> findTmpSpedDocumentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpSpedDocumento.class));
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

    public TmpSpedDocumento findTmpSpedDocumento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpSpedDocumento.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpSpedDocumentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpSpedDocumento> rt = cq.from(TmpSpedDocumento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

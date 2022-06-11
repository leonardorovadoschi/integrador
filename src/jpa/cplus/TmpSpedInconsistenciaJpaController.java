/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpSpedInconsistencia;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.TmpSpedInconsistenciaitem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class TmpSpedInconsistenciaJpaController implements Serializable {

    public TmpSpedInconsistenciaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpSpedInconsistencia tmpSpedInconsistencia) throws PreexistingEntityException, Exception {
        if (tmpSpedInconsistencia.getTmpSpedInconsistenciaitemCollection() == null) {
            tmpSpedInconsistencia.setTmpSpedInconsistenciaitemCollection(new ArrayList<TmpSpedInconsistenciaitem>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<TmpSpedInconsistenciaitem> attachedTmpSpedInconsistenciaitemCollection = new ArrayList<TmpSpedInconsistenciaitem>();
            for (TmpSpedInconsistenciaitem tmpSpedInconsistenciaitemCollectionTmpSpedInconsistenciaitemToAttach : tmpSpedInconsistencia.getTmpSpedInconsistenciaitemCollection()) {
                tmpSpedInconsistenciaitemCollectionTmpSpedInconsistenciaitemToAttach = em.getReference(tmpSpedInconsistenciaitemCollectionTmpSpedInconsistenciaitemToAttach.getClass(), tmpSpedInconsistenciaitemCollectionTmpSpedInconsistenciaitemToAttach.getIditem());
                attachedTmpSpedInconsistenciaitemCollection.add(tmpSpedInconsistenciaitemCollectionTmpSpedInconsistenciaitemToAttach);
            }
            tmpSpedInconsistencia.setTmpSpedInconsistenciaitemCollection(attachedTmpSpedInconsistenciaitemCollection);
            em.persist(tmpSpedInconsistencia);
            for (TmpSpedInconsistenciaitem tmpSpedInconsistenciaitemCollectionTmpSpedInconsistenciaitem : tmpSpedInconsistencia.getTmpSpedInconsistenciaitemCollection()) {
                TmpSpedInconsistencia oldIdOfTmpSpedInconsistenciaitemCollectionTmpSpedInconsistenciaitem = tmpSpedInconsistenciaitemCollectionTmpSpedInconsistenciaitem.getId();
                tmpSpedInconsistenciaitemCollectionTmpSpedInconsistenciaitem.setId(tmpSpedInconsistencia);
                tmpSpedInconsistenciaitemCollectionTmpSpedInconsistenciaitem = em.merge(tmpSpedInconsistenciaitemCollectionTmpSpedInconsistenciaitem);
                if (oldIdOfTmpSpedInconsistenciaitemCollectionTmpSpedInconsistenciaitem != null) {
                    oldIdOfTmpSpedInconsistenciaitemCollectionTmpSpedInconsistenciaitem.getTmpSpedInconsistenciaitemCollection().remove(tmpSpedInconsistenciaitemCollectionTmpSpedInconsistenciaitem);
                    oldIdOfTmpSpedInconsistenciaitemCollectionTmpSpedInconsistenciaitem = em.merge(oldIdOfTmpSpedInconsistenciaitemCollectionTmpSpedInconsistenciaitem);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpSpedInconsistencia(tmpSpedInconsistencia.getId()) != null) {
                throw new PreexistingEntityException("TmpSpedInconsistencia " + tmpSpedInconsistencia + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpSpedInconsistencia tmpSpedInconsistencia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TmpSpedInconsistencia persistentTmpSpedInconsistencia = em.find(TmpSpedInconsistencia.class, tmpSpedInconsistencia.getId());
            Collection<TmpSpedInconsistenciaitem> tmpSpedInconsistenciaitemCollectionOld = persistentTmpSpedInconsistencia.getTmpSpedInconsistenciaitemCollection();
            Collection<TmpSpedInconsistenciaitem> tmpSpedInconsistenciaitemCollectionNew = tmpSpedInconsistencia.getTmpSpedInconsistenciaitemCollection();
            Collection<TmpSpedInconsistenciaitem> attachedTmpSpedInconsistenciaitemCollectionNew = new ArrayList<TmpSpedInconsistenciaitem>();
            for (TmpSpedInconsistenciaitem tmpSpedInconsistenciaitemCollectionNewTmpSpedInconsistenciaitemToAttach : tmpSpedInconsistenciaitemCollectionNew) {
                tmpSpedInconsistenciaitemCollectionNewTmpSpedInconsistenciaitemToAttach = em.getReference(tmpSpedInconsistenciaitemCollectionNewTmpSpedInconsistenciaitemToAttach.getClass(), tmpSpedInconsistenciaitemCollectionNewTmpSpedInconsistenciaitemToAttach.getIditem());
                attachedTmpSpedInconsistenciaitemCollectionNew.add(tmpSpedInconsistenciaitemCollectionNewTmpSpedInconsistenciaitemToAttach);
            }
            tmpSpedInconsistenciaitemCollectionNew = attachedTmpSpedInconsistenciaitemCollectionNew;
            tmpSpedInconsistencia.setTmpSpedInconsistenciaitemCollection(tmpSpedInconsistenciaitemCollectionNew);
            tmpSpedInconsistencia = em.merge(tmpSpedInconsistencia);
            for (TmpSpedInconsistenciaitem tmpSpedInconsistenciaitemCollectionOldTmpSpedInconsistenciaitem : tmpSpedInconsistenciaitemCollectionOld) {
                if (!tmpSpedInconsistenciaitemCollectionNew.contains(tmpSpedInconsistenciaitemCollectionOldTmpSpedInconsistenciaitem)) {
                    tmpSpedInconsistenciaitemCollectionOldTmpSpedInconsistenciaitem.setId(null);
                    tmpSpedInconsistenciaitemCollectionOldTmpSpedInconsistenciaitem = em.merge(tmpSpedInconsistenciaitemCollectionOldTmpSpedInconsistenciaitem);
                }
            }
            for (TmpSpedInconsistenciaitem tmpSpedInconsistenciaitemCollectionNewTmpSpedInconsistenciaitem : tmpSpedInconsistenciaitemCollectionNew) {
                if (!tmpSpedInconsistenciaitemCollectionOld.contains(tmpSpedInconsistenciaitemCollectionNewTmpSpedInconsistenciaitem)) {
                    TmpSpedInconsistencia oldIdOfTmpSpedInconsistenciaitemCollectionNewTmpSpedInconsistenciaitem = tmpSpedInconsistenciaitemCollectionNewTmpSpedInconsistenciaitem.getId();
                    tmpSpedInconsistenciaitemCollectionNewTmpSpedInconsistenciaitem.setId(tmpSpedInconsistencia);
                    tmpSpedInconsistenciaitemCollectionNewTmpSpedInconsistenciaitem = em.merge(tmpSpedInconsistenciaitemCollectionNewTmpSpedInconsistenciaitem);
                    if (oldIdOfTmpSpedInconsistenciaitemCollectionNewTmpSpedInconsistenciaitem != null && !oldIdOfTmpSpedInconsistenciaitemCollectionNewTmpSpedInconsistenciaitem.equals(tmpSpedInconsistencia)) {
                        oldIdOfTmpSpedInconsistenciaitemCollectionNewTmpSpedInconsistenciaitem.getTmpSpedInconsistenciaitemCollection().remove(tmpSpedInconsistenciaitemCollectionNewTmpSpedInconsistenciaitem);
                        oldIdOfTmpSpedInconsistenciaitemCollectionNewTmpSpedInconsistenciaitem = em.merge(oldIdOfTmpSpedInconsistenciaitemCollectionNewTmpSpedInconsistenciaitem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpSpedInconsistencia.getId();
                if (findTmpSpedInconsistencia(id) == null) {
                    throw new NonexistentEntityException("The tmpSpedInconsistencia with id " + id + " no longer exists.");
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
            TmpSpedInconsistencia tmpSpedInconsistencia;
            try {
                tmpSpedInconsistencia = em.getReference(TmpSpedInconsistencia.class, id);
                tmpSpedInconsistencia.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpSpedInconsistencia with id " + id + " no longer exists.", enfe);
            }
            Collection<TmpSpedInconsistenciaitem> tmpSpedInconsistenciaitemCollection = tmpSpedInconsistencia.getTmpSpedInconsistenciaitemCollection();
            for (TmpSpedInconsistenciaitem tmpSpedInconsistenciaitemCollectionTmpSpedInconsistenciaitem : tmpSpedInconsistenciaitemCollection) {
                tmpSpedInconsistenciaitemCollectionTmpSpedInconsistenciaitem.setId(null);
                tmpSpedInconsistenciaitemCollectionTmpSpedInconsistenciaitem = em.merge(tmpSpedInconsistenciaitemCollectionTmpSpedInconsistenciaitem);
            }
            em.remove(tmpSpedInconsistencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpSpedInconsistencia> findTmpSpedInconsistenciaEntities() {
        return findTmpSpedInconsistenciaEntities(true, -1, -1);
    }

    public List<TmpSpedInconsistencia> findTmpSpedInconsistenciaEntities(int maxResults, int firstResult) {
        return findTmpSpedInconsistenciaEntities(false, maxResults, firstResult);
    }

    private List<TmpSpedInconsistencia> findTmpSpedInconsistenciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpSpedInconsistencia.class));
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

    public TmpSpedInconsistencia findTmpSpedInconsistencia(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpSpedInconsistencia.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpSpedInconsistenciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpSpedInconsistencia> rt = cq.from(TmpSpedInconsistencia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

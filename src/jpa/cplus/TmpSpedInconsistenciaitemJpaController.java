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
import entidade.cplus.TmpSpedInconsistencia;
import entidade.cplus.TmpSpedInconsistenciaitem;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class TmpSpedInconsistenciaitemJpaController implements Serializable {

    public TmpSpedInconsistenciaitemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpSpedInconsistenciaitem tmpSpedInconsistenciaitem) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TmpSpedInconsistencia id = tmpSpedInconsistenciaitem.getId();
            if (id != null) {
                id = em.getReference(id.getClass(), id.getId());
                tmpSpedInconsistenciaitem.setId(id);
            }
            em.persist(tmpSpedInconsistenciaitem);
            if (id != null) {
                id.getTmpSpedInconsistenciaitemCollection().add(tmpSpedInconsistenciaitem);
                id = em.merge(id);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpSpedInconsistenciaitem(tmpSpedInconsistenciaitem.getIditem()) != null) {
                throw new PreexistingEntityException("TmpSpedInconsistenciaitem " + tmpSpedInconsistenciaitem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpSpedInconsistenciaitem tmpSpedInconsistenciaitem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TmpSpedInconsistenciaitem persistentTmpSpedInconsistenciaitem = em.find(TmpSpedInconsistenciaitem.class, tmpSpedInconsistenciaitem.getIditem());
            TmpSpedInconsistencia idOld = persistentTmpSpedInconsistenciaitem.getId();
            TmpSpedInconsistencia idNew = tmpSpedInconsistenciaitem.getId();
            if (idNew != null) {
                idNew = em.getReference(idNew.getClass(), idNew.getId());
                tmpSpedInconsistenciaitem.setId(idNew);
            }
            tmpSpedInconsistenciaitem = em.merge(tmpSpedInconsistenciaitem);
            if (idOld != null && !idOld.equals(idNew)) {
                idOld.getTmpSpedInconsistenciaitemCollection().remove(tmpSpedInconsistenciaitem);
                idOld = em.merge(idOld);
            }
            if (idNew != null && !idNew.equals(idOld)) {
                idNew.getTmpSpedInconsistenciaitemCollection().add(tmpSpedInconsistenciaitem);
                idNew = em.merge(idNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpSpedInconsistenciaitem.getIditem();
                if (findTmpSpedInconsistenciaitem(id) == null) {
                    throw new NonexistentEntityException("The tmpSpedInconsistenciaitem with id " + id + " no longer exists.");
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
            TmpSpedInconsistenciaitem tmpSpedInconsistenciaitem;
            try {
                tmpSpedInconsistenciaitem = em.getReference(TmpSpedInconsistenciaitem.class, id);
                tmpSpedInconsistenciaitem.getIditem();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpSpedInconsistenciaitem with id " + id + " no longer exists.", enfe);
            }
          
                        em.merge(id);
            
            em.remove(tmpSpedInconsistenciaitem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpSpedInconsistenciaitem> findTmpSpedInconsistenciaitemEntities() {
        return findTmpSpedInconsistenciaitemEntities(true, -1, -1);
    }

    public List<TmpSpedInconsistenciaitem> findTmpSpedInconsistenciaitemEntities(int maxResults, int firstResult) {
        return findTmpSpedInconsistenciaitemEntities(false, maxResults, firstResult);
    }

    private List<TmpSpedInconsistenciaitem> findTmpSpedInconsistenciaitemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpSpedInconsistenciaitem.class));
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

    public TmpSpedInconsistenciaitem findTmpSpedInconsistenciaitem(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpSpedInconsistenciaitem.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpSpedInconsistenciaitemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpSpedInconsistenciaitem> rt = cq.from(TmpSpedInconsistenciaitem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

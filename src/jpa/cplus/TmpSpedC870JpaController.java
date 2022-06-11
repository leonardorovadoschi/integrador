/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpSpedC870;
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
public class TmpSpedC870JpaController implements Serializable {

    public TmpSpedC870JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpSpedC870 tmpSpedC870) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpSpedC870);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpSpedC870(tmpSpedC870.getCodtmpSpedC870()) != null) {
                throw new PreexistingEntityException("TmpSpedC870 " + tmpSpedC870 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpSpedC870 tmpSpedC870) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpSpedC870 = em.merge(tmpSpedC870);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tmpSpedC870.getCodtmpSpedC870();
                if (findTmpSpedC870(id) == null) {
                    throw new NonexistentEntityException("The tmpSpedC870 with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TmpSpedC870 tmpSpedC870;
            try {
                tmpSpedC870 = em.getReference(TmpSpedC870.class, id);
                tmpSpedC870.getCodtmpSpedC870();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpSpedC870 with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpSpedC870);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpSpedC870> findTmpSpedC870Entities() {
        return findTmpSpedC870Entities(true, -1, -1);
    }

    public List<TmpSpedC870> findTmpSpedC870Entities(int maxResults, int firstResult) {
        return findTmpSpedC870Entities(false, maxResults, firstResult);
    }

    private List<TmpSpedC870> findTmpSpedC870Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpSpedC870.class));
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

    public TmpSpedC870 findTmpSpedC870(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpSpedC870.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpSpedC870Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpSpedC870> rt = cq.from(TmpSpedC870.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

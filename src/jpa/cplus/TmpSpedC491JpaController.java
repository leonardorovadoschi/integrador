/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpSpedC491;
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
public class TmpSpedC491JpaController implements Serializable {

    public TmpSpedC491JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpSpedC491 tmpSpedC491) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpSpedC491);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpSpedC491(tmpSpedC491.getCodtmpSpedC491()) != null) {
                throw new PreexistingEntityException("TmpSpedC491 " + tmpSpedC491 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpSpedC491 tmpSpedC491) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpSpedC491 = em.merge(tmpSpedC491);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpSpedC491.getCodtmpSpedC491();
                if (findTmpSpedC491(id) == null) {
                    throw new NonexistentEntityException("The tmpSpedC491 with id " + id + " no longer exists.");
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
            TmpSpedC491 tmpSpedC491;
            try {
                tmpSpedC491 = em.getReference(TmpSpedC491.class, id);
                tmpSpedC491.getCodtmpSpedC491();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpSpedC491 with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpSpedC491);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpSpedC491> findTmpSpedC491Entities() {
        return findTmpSpedC491Entities(true, -1, -1);
    }

    public List<TmpSpedC491> findTmpSpedC491Entities(int maxResults, int firstResult) {
        return findTmpSpedC491Entities(false, maxResults, firstResult);
    }

    private List<TmpSpedC491> findTmpSpedC491Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpSpedC491.class));
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

    public TmpSpedC491 findTmpSpedC491(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpSpedC491.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpSpedC491Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpSpedC491> rt = cq.from(TmpSpedC491.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

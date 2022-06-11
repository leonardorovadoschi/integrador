/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpSpedC495;
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
public class TmpSpedC495JpaController implements Serializable {

    public TmpSpedC495JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpSpedC495 tmpSpedC495) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpSpedC495);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpSpedC495(tmpSpedC495.getCodtmpSpedC495()) != null) {
                throw new PreexistingEntityException("TmpSpedC495 " + tmpSpedC495 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpSpedC495 tmpSpedC495) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpSpedC495 = em.merge(tmpSpedC495);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpSpedC495.getCodtmpSpedC495();
                if (findTmpSpedC495(id) == null) {
                    throw new NonexistentEntityException("The tmpSpedC495 with id " + id + " no longer exists.");
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
            TmpSpedC495 tmpSpedC495;
            try {
                tmpSpedC495 = em.getReference(TmpSpedC495.class, id);
                tmpSpedC495.getCodtmpSpedC495();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpSpedC495 with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpSpedC495);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpSpedC495> findTmpSpedC495Entities() {
        return findTmpSpedC495Entities(true, -1, -1);
    }

    public List<TmpSpedC495> findTmpSpedC495Entities(int maxResults, int firstResult) {
        return findTmpSpedC495Entities(false, maxResults, firstResult);
    }

    private List<TmpSpedC495> findTmpSpedC495Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpSpedC495.class));
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

    public TmpSpedC495 findTmpSpedC495(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpSpedC495.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpSpedC495Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpSpedC495> rt = cq.from(TmpSpedC495.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

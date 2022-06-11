/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpSpedC481;
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
public class TmpSpedC481JpaController implements Serializable {

    public TmpSpedC481JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpSpedC481 tmpSpedC481) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpSpedC481);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpSpedC481(tmpSpedC481.getCodtmpSpedC481()) != null) {
                throw new PreexistingEntityException("TmpSpedC481 " + tmpSpedC481 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpSpedC481 tmpSpedC481) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpSpedC481 = em.merge(tmpSpedC481);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpSpedC481.getCodtmpSpedC481();
                if (findTmpSpedC481(id) == null) {
                    throw new NonexistentEntityException("The tmpSpedC481 with id " + id + " no longer exists.");
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
            TmpSpedC481 tmpSpedC481;
            try {
                tmpSpedC481 = em.getReference(TmpSpedC481.class, id);
                tmpSpedC481.getCodtmpSpedC481();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpSpedC481 with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpSpedC481);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpSpedC481> findTmpSpedC481Entities() {
        return findTmpSpedC481Entities(true, -1, -1);
    }

    public List<TmpSpedC481> findTmpSpedC481Entities(int maxResults, int firstResult) {
        return findTmpSpedC481Entities(false, maxResults, firstResult);
    }

    private List<TmpSpedC481> findTmpSpedC481Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpSpedC481.class));
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

    public TmpSpedC481 findTmpSpedC481(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpSpedC481.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpSpedC481Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpSpedC481> rt = cq.from(TmpSpedC481.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

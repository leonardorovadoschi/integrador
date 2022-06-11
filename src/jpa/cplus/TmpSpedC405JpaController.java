/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpSpedC405;
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
public class TmpSpedC405JpaController implements Serializable {

    public TmpSpedC405JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpSpedC405 tmpSpedC405) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpSpedC405);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpSpedC405(tmpSpedC405.getCodtmpSpedC405()) != null) {
                throw new PreexistingEntityException("TmpSpedC405 " + tmpSpedC405 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpSpedC405 tmpSpedC405) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpSpedC405 = em.merge(tmpSpedC405);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpSpedC405.getCodtmpSpedC405();
                if (findTmpSpedC405(id) == null) {
                    throw new NonexistentEntityException("The tmpSpedC405 with id " + id + " no longer exists.");
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
            TmpSpedC405 tmpSpedC405;
            try {
                tmpSpedC405 = em.getReference(TmpSpedC405.class, id);
                tmpSpedC405.getCodtmpSpedC405();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpSpedC405 with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpSpedC405);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpSpedC405> findTmpSpedC405Entities() {
        return findTmpSpedC405Entities(true, -1, -1);
    }

    public List<TmpSpedC405> findTmpSpedC405Entities(int maxResults, int firstResult) {
        return findTmpSpedC405Entities(false, maxResults, firstResult);
    }

    private List<TmpSpedC405> findTmpSpedC405Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpSpedC405.class));
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

    public TmpSpedC405 findTmpSpedC405(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpSpedC405.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpSpedC405Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpSpedC405> rt = cq.from(TmpSpedC405.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

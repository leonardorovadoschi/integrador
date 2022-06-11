/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpSpedC100;
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
public class TmpSpedC100JpaController implements Serializable {

    public TmpSpedC100JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpSpedC100 tmpSpedC100) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpSpedC100);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpSpedC100(tmpSpedC100.getCodtmpSpedC100()) != null) {
                throw new PreexistingEntityException("TmpSpedC100 " + tmpSpedC100 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpSpedC100 tmpSpedC100) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpSpedC100 = em.merge(tmpSpedC100);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpSpedC100.getCodtmpSpedC100();
                if (findTmpSpedC100(id) == null) {
                    throw new NonexistentEntityException("The tmpSpedC100 with id " + id + " no longer exists.");
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
            TmpSpedC100 tmpSpedC100;
            try {
                tmpSpedC100 = em.getReference(TmpSpedC100.class, id);
                tmpSpedC100.getCodtmpSpedC100();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpSpedC100 with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpSpedC100);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpSpedC100> findTmpSpedC100Entities() {
        return findTmpSpedC100Entities(true, -1, -1);
    }

    public List<TmpSpedC100> findTmpSpedC100Entities(int maxResults, int firstResult) {
        return findTmpSpedC100Entities(false, maxResults, firstResult);
    }

    private List<TmpSpedC100> findTmpSpedC100Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpSpedC100.class));
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

    public TmpSpedC100 findTmpSpedC100(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpSpedC100.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpSpedC100Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpSpedC100> rt = cq.from(TmpSpedC100.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

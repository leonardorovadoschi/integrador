/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpSpedC420;
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
public class TmpSpedC420JpaController implements Serializable {

    public TmpSpedC420JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpSpedC420 tmpSpedC420) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpSpedC420);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpSpedC420(tmpSpedC420.getCodtmpSpedC420()) != null) {
                throw new PreexistingEntityException("TmpSpedC420 " + tmpSpedC420 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpSpedC420 tmpSpedC420) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpSpedC420 = em.merge(tmpSpedC420);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpSpedC420.getCodtmpSpedC420();
                if (findTmpSpedC420(id) == null) {
                    throw new NonexistentEntityException("The tmpSpedC420 with id " + id + " no longer exists.");
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
            TmpSpedC420 tmpSpedC420;
            try {
                tmpSpedC420 = em.getReference(TmpSpedC420.class, id);
                tmpSpedC420.getCodtmpSpedC420();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpSpedC420 with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpSpedC420);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpSpedC420> findTmpSpedC420Entities() {
        return findTmpSpedC420Entities(true, -1, -1);
    }

    public List<TmpSpedC420> findTmpSpedC420Entities(int maxResults, int firstResult) {
        return findTmpSpedC420Entities(false, maxResults, firstResult);
    }

    private List<TmpSpedC420> findTmpSpedC420Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpSpedC420.class));
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

    public TmpSpedC420 findTmpSpedC420(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpSpedC420.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpSpedC420Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpSpedC420> rt = cq.from(TmpSpedC420.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpConferenciaFci;
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
public class TmpConferenciaFciJpaController implements Serializable {

    public TmpConferenciaFciJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpConferenciaFci tmpConferenciaFci) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpConferenciaFci);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpConferenciaFci(tmpConferenciaFci.getCodtmpConferencia()) != null) {
                throw new PreexistingEntityException("TmpConferenciaFci " + tmpConferenciaFci + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpConferenciaFci tmpConferenciaFci) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpConferenciaFci = em.merge(tmpConferenciaFci);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpConferenciaFci.getCodtmpConferencia();
                if (findTmpConferenciaFci(id) == null) {
                    throw new NonexistentEntityException("The tmpConferenciaFci with id " + id + " no longer exists.");
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
            TmpConferenciaFci tmpConferenciaFci;
            try {
                tmpConferenciaFci = em.getReference(TmpConferenciaFci.class, id);
                tmpConferenciaFci.getCodtmpConferencia();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpConferenciaFci with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpConferenciaFci);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpConferenciaFci> findTmpConferenciaFciEntities() {
        return findTmpConferenciaFciEntities(true, -1, -1);
    }

    public List<TmpConferenciaFci> findTmpConferenciaFciEntities(int maxResults, int firstResult) {
        return findTmpConferenciaFciEntities(false, maxResults, firstResult);
    }

    private List<TmpConferenciaFci> findTmpConferenciaFciEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpConferenciaFci.class));
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

    public TmpConferenciaFci findTmpConferenciaFci(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpConferenciaFci.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpConferenciaFciCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpConferenciaFci> rt = cq.from(TmpConferenciaFci.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

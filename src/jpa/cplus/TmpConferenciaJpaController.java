/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpConferencia;
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
public class TmpConferenciaJpaController implements Serializable {

    public TmpConferenciaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpConferencia tmpConferencia) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpConferencia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpConferencia(tmpConferencia.getCodtmpConferencia()) != null) {
                throw new PreexistingEntityException("TmpConferencia " + tmpConferencia + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpConferencia tmpConferencia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpConferencia = em.merge(tmpConferencia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpConferencia.getCodtmpConferencia();
                if (findTmpConferencia(id) == null) {
                    throw new NonexistentEntityException("The tmpConferencia with id " + id + " no longer exists.");
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
            TmpConferencia tmpConferencia;
            try {
                tmpConferencia = em.getReference(TmpConferencia.class, id);
                tmpConferencia.getCodtmpConferencia();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpConferencia with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpConferencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpConferencia> findTmpConferenciaEntities() {
        return findTmpConferenciaEntities(true, -1, -1);
    }

    public List<TmpConferencia> findTmpConferenciaEntities(int maxResults, int firstResult) {
        return findTmpConferenciaEntities(false, maxResults, firstResult);
    }

    private List<TmpConferencia> findTmpConferenciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpConferencia.class));
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

    public TmpConferencia findTmpConferencia(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpConferencia.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpConferenciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpConferencia> rt = cq.from(TmpConferencia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

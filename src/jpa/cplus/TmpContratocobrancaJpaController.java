/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpContratocobranca;
import entidade.cplus.TmpContratocobrancaPK;
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
public class TmpContratocobrancaJpaController implements Serializable {

    public TmpContratocobrancaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpContratocobranca tmpContratocobranca) throws PreexistingEntityException, Exception {
        if (tmpContratocobranca.getTmpContratocobrancaPK() == null) {
            tmpContratocobranca.setTmpContratocobrancaPK(new TmpContratocobrancaPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpContratocobranca);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpContratocobranca(tmpContratocobranca.getTmpContratocobrancaPK()) != null) {
                throw new PreexistingEntityException("TmpContratocobranca " + tmpContratocobranca + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpContratocobranca tmpContratocobranca) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpContratocobranca = em.merge(tmpContratocobranca);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                TmpContratocobrancaPK id = tmpContratocobranca.getTmpContratocobrancaPK();
                if (findTmpContratocobranca(id) == null) {
                    throw new NonexistentEntityException("The tmpContratocobranca with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(TmpContratocobrancaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TmpContratocobranca tmpContratocobranca;
            try {
                tmpContratocobranca = em.getReference(TmpContratocobranca.class, id);
                tmpContratocobranca.getTmpContratocobrancaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpContratocobranca with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpContratocobranca);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpContratocobranca> findTmpContratocobrancaEntities() {
        return findTmpContratocobrancaEntities(true, -1, -1);
    }

    public List<TmpContratocobranca> findTmpContratocobrancaEntities(int maxResults, int firstResult) {
        return findTmpContratocobrancaEntities(false, maxResults, firstResult);
    }

    private List<TmpContratocobranca> findTmpContratocobrancaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpContratocobranca.class));
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

    public TmpContratocobranca findTmpContratocobranca(TmpContratocobrancaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpContratocobranca.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpContratocobrancaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpContratocobranca> rt = cq.from(TmpContratocobranca.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

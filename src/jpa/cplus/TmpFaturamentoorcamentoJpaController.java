/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpFaturamentoorcamento;
import entidade.cplus.TmpFaturamentoorcamentoPK;
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
public class TmpFaturamentoorcamentoJpaController implements Serializable {

    public TmpFaturamentoorcamentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpFaturamentoorcamento tmpFaturamentoorcamento) throws PreexistingEntityException, Exception {
        if (tmpFaturamentoorcamento.getTmpFaturamentoorcamentoPK() == null) {
            tmpFaturamentoorcamento.setTmpFaturamentoorcamentoPK(new TmpFaturamentoorcamentoPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpFaturamentoorcamento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpFaturamentoorcamento(tmpFaturamentoorcamento.getTmpFaturamentoorcamentoPK()) != null) {
                throw new PreexistingEntityException("TmpFaturamentoorcamento " + tmpFaturamentoorcamento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpFaturamentoorcamento tmpFaturamentoorcamento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpFaturamentoorcamento = em.merge(tmpFaturamentoorcamento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                TmpFaturamentoorcamentoPK id = tmpFaturamentoorcamento.getTmpFaturamentoorcamentoPK();
                if (findTmpFaturamentoorcamento(id) == null) {
                    throw new NonexistentEntityException("The tmpFaturamentoorcamento with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(TmpFaturamentoorcamentoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TmpFaturamentoorcamento tmpFaturamentoorcamento;
            try {
                tmpFaturamentoorcamento = em.getReference(TmpFaturamentoorcamento.class, id);
                tmpFaturamentoorcamento.getTmpFaturamentoorcamentoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpFaturamentoorcamento with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpFaturamentoorcamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpFaturamentoorcamento> findTmpFaturamentoorcamentoEntities() {
        return findTmpFaturamentoorcamentoEntities(true, -1, -1);
    }

    public List<TmpFaturamentoorcamento> findTmpFaturamentoorcamentoEntities(int maxResults, int firstResult) {
        return findTmpFaturamentoorcamentoEntities(false, maxResults, firstResult);
    }

    private List<TmpFaturamentoorcamento> findTmpFaturamentoorcamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpFaturamentoorcamento.class));
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

    public TmpFaturamentoorcamento findTmpFaturamentoorcamento(TmpFaturamentoorcamentoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpFaturamentoorcamento.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpFaturamentoorcamentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpFaturamentoorcamento> rt = cq.from(TmpFaturamentoorcamento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

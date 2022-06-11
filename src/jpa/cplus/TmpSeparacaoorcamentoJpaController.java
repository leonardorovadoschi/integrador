/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpSeparacaoorcamento;
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
public class TmpSeparacaoorcamentoJpaController implements Serializable {

    public TmpSeparacaoorcamentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpSeparacaoorcamento tmpSeparacaoorcamento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpSeparacaoorcamento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpSeparacaoorcamento(tmpSeparacaoorcamento.getCodorcprod()) != null) {
                throw new PreexistingEntityException("TmpSeparacaoorcamento " + tmpSeparacaoorcamento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpSeparacaoorcamento tmpSeparacaoorcamento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpSeparacaoorcamento = em.merge(tmpSeparacaoorcamento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tmpSeparacaoorcamento.getCodorcprod();
                if (findTmpSeparacaoorcamento(id) == null) {
                    throw new NonexistentEntityException("The tmpSeparacaoorcamento with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TmpSeparacaoorcamento tmpSeparacaoorcamento;
            try {
                tmpSeparacaoorcamento = em.getReference(TmpSeparacaoorcamento.class, id);
                tmpSeparacaoorcamento.getCodorcprod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpSeparacaoorcamento with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpSeparacaoorcamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpSeparacaoorcamento> findTmpSeparacaoorcamentoEntities() {
        return findTmpSeparacaoorcamentoEntities(true, -1, -1);
    }

    public List<TmpSeparacaoorcamento> findTmpSeparacaoorcamentoEntities(int maxResults, int firstResult) {
        return findTmpSeparacaoorcamentoEntities(false, maxResults, firstResult);
    }

    private List<TmpSeparacaoorcamento> findTmpSeparacaoorcamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpSeparacaoorcamento.class));
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

    public TmpSeparacaoorcamento findTmpSeparacaoorcamento(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpSeparacaoorcamento.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpSeparacaoorcamentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpSeparacaoorcamento> rt = cq.from(TmpSeparacaoorcamento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

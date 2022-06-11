/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpDocumentopagamento;
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
public class TmpDocumentopagamentoJpaController implements Serializable {

    public TmpDocumentopagamentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpDocumentopagamento tmpDocumentopagamento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpDocumentopagamento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpDocumentopagamento(tmpDocumentopagamento.getCodtmpDocumentopagamento()) != null) {
                throw new PreexistingEntityException("TmpDocumentopagamento " + tmpDocumentopagamento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpDocumentopagamento tmpDocumentopagamento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpDocumentopagamento = em.merge(tmpDocumentopagamento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpDocumentopagamento.getCodtmpDocumentopagamento();
                if (findTmpDocumentopagamento(id) == null) {
                    throw new NonexistentEntityException("The tmpDocumentopagamento with id " + id + " no longer exists.");
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
            TmpDocumentopagamento tmpDocumentopagamento;
            try {
                tmpDocumentopagamento = em.getReference(TmpDocumentopagamento.class, id);
                tmpDocumentopagamento.getCodtmpDocumentopagamento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpDocumentopagamento with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpDocumentopagamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpDocumentopagamento> findTmpDocumentopagamentoEntities() {
        return findTmpDocumentopagamentoEntities(true, -1, -1);
    }

    public List<TmpDocumentopagamento> findTmpDocumentopagamentoEntities(int maxResults, int firstResult) {
        return findTmpDocumentopagamentoEntities(false, maxResults, firstResult);
    }

    private List<TmpDocumentopagamento> findTmpDocumentopagamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpDocumentopagamento.class));
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

    public TmpDocumentopagamento findTmpDocumentopagamento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpDocumentopagamento.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpDocumentopagamentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpDocumentopagamento> rt = cq.from(TmpDocumentopagamento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

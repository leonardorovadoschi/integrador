/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Documento;
import entidade.cplus.Documentopagamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class DocumentopagamentoJpaController implements Serializable {

    public DocumentopagamentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Documentopagamento documentopagamento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documento coddocumento = documentopagamento.getCoddocumento();
            if (coddocumento != null) {
                coddocumento = em.getReference(coddocumento.getClass(), coddocumento.getCoddocumento());
                documentopagamento.setCoddocumento(coddocumento);
            }
            em.persist(documentopagamento);
            if (coddocumento != null) {
                coddocumento.getDocumentopagamentoCollection().add(documentopagamento);
                coddocumento = em.merge(coddocumento);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDocumentopagamento(documentopagamento.getCoddocumentopagamento()) != null) {
                throw new PreexistingEntityException("Documentopagamento " + documentopagamento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Documentopagamento documentopagamento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documentopagamento persistentDocumentopagamento = em.find(Documentopagamento.class, documentopagamento.getCoddocumentopagamento());
            Documento coddocumentoOld = persistentDocumentopagamento.getCoddocumento();
            Documento coddocumentoNew = documentopagamento.getCoddocumento();
            if (coddocumentoNew != null) {
                coddocumentoNew = em.getReference(coddocumentoNew.getClass(), coddocumentoNew.getCoddocumento());
                documentopagamento.setCoddocumento(coddocumentoNew);
            }
            documentopagamento = em.merge(documentopagamento);
            if (coddocumentoOld != null && !coddocumentoOld.equals(coddocumentoNew)) {
                coddocumentoOld.getDocumentopagamentoCollection().remove(documentopagamento);
                coddocumentoOld = em.merge(coddocumentoOld);
            }
            if (coddocumentoNew != null && !coddocumentoNew.equals(coddocumentoOld)) {
                coddocumentoNew.getDocumentopagamentoCollection().add(documentopagamento);
                coddocumentoNew = em.merge(coddocumentoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = documentopagamento.getCoddocumentopagamento();
                if (findDocumentopagamento(id) == null) {
                    throw new NonexistentEntityException("The documentopagamento with id " + id + " no longer exists.");
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
            Documentopagamento documentopagamento;
            try {
                documentopagamento = em.getReference(Documentopagamento.class, id);
                documentopagamento.getCoddocumentopagamento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The documentopagamento with id " + id + " no longer exists.", enfe);
            }
            Documento coddocumento = documentopagamento.getCoddocumento();
            if (coddocumento != null) {
                coddocumento.getDocumentopagamentoCollection().remove(documentopagamento);
                coddocumento = em.merge(coddocumento);
            }
            em.remove(documentopagamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Documentopagamento> findDocumentopagamentoEntities() {
        return findDocumentopagamentoEntities(true, -1, -1);
    }

    public List<Documentopagamento> findDocumentopagamentoEntities(int maxResults, int firstResult) {
        return findDocumentopagamentoEntities(false, maxResults, firstResult);
    }

    private List<Documentopagamento> findDocumentopagamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Documentopagamento.class));
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

    public Documentopagamento findDocumentopagamento(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Documentopagamento.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocumentopagamentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Documentopagamento> rt = cq.from(Documentopagamento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

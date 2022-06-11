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
import entidade.cplus.Documentodocref;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class DocumentodocrefJpaController implements Serializable {

    public DocumentodocrefJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Documentodocref documentodocref) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documento coddocumento = documentodocref.getCoddocumento();
            if (coddocumento != null) {
                coddocumento = em.getReference(coddocumento.getClass(), coddocumento.getCoddocumento());
                documentodocref.setCoddocumento(coddocumento);
            }
            em.persist(documentodocref);
            if (coddocumento != null) {
                coddocumento.getDocumentodocrefCollection().add(documentodocref);
                coddocumento = em.merge(coddocumento);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDocumentodocref(documentodocref.getCoddocumentodocref()) != null) {
                throw new PreexistingEntityException("Documentodocref " + documentodocref + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Documentodocref documentodocref) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documentodocref persistentDocumentodocref = em.find(Documentodocref.class, documentodocref.getCoddocumentodocref());
            Documento coddocumentoOld = persistentDocumentodocref.getCoddocumento();
            Documento coddocumentoNew = documentodocref.getCoddocumento();
            if (coddocumentoNew != null) {
                coddocumentoNew = em.getReference(coddocumentoNew.getClass(), coddocumentoNew.getCoddocumento());
                documentodocref.setCoddocumento(coddocumentoNew);
            }
            documentodocref = em.merge(documentodocref);
            if (coddocumentoOld != null && !coddocumentoOld.equals(coddocumentoNew)) {
                coddocumentoOld.getDocumentodocrefCollection().remove(documentodocref);
                coddocumentoOld = em.merge(coddocumentoOld);
            }
            if (coddocumentoNew != null && !coddocumentoNew.equals(coddocumentoOld)) {
                coddocumentoNew.getDocumentodocrefCollection().add(documentodocref);
                coddocumentoNew = em.merge(coddocumentoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = documentodocref.getCoddocumentodocref();
                if (findDocumentodocref(id) == null) {
                    throw new NonexistentEntityException("The documentodocref with id " + id + " no longer exists.");
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
            Documentodocref documentodocref;
            try {
                documentodocref = em.getReference(Documentodocref.class, id);
                documentodocref.getCoddocumentodocref();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The documentodocref with id " + id + " no longer exists.", enfe);
            }
            Documento coddocumento = documentodocref.getCoddocumento();
            if (coddocumento != null) {
                coddocumento.getDocumentodocrefCollection().remove(documentodocref);
                coddocumento = em.merge(coddocumento);
            }
            em.remove(documentodocref);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Documentodocref> findDocumentodocrefEntities() {
        return findDocumentodocrefEntities(true, -1, -1);
    }

    public List<Documentodocref> findDocumentodocrefEntities(int maxResults, int firstResult) {
        return findDocumentodocrefEntities(false, maxResults, firstResult);
    }

    private List<Documentodocref> findDocumentodocrefEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Documentodocref.class));
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

    public Documentodocref findDocumentodocref(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Documentodocref.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocumentodocrefCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Documentodocref> rt = cq.from(Documentodocref.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

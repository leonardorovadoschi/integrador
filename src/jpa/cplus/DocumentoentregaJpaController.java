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
import entidade.cplus.Documentoentrega;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class DocumentoentregaJpaController implements Serializable {

    public DocumentoentregaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Documentoentrega documentoentrega) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documento coddocumento = documentoentrega.getCoddocumento();
            if (coddocumento != null) {
                coddocumento = em.getReference(coddocumento.getClass(), coddocumento.getCoddocumento());
                documentoentrega.setCoddocumento(coddocumento);
            }
            em.persist(documentoentrega);
            if (coddocumento != null) {
                coddocumento.getDocumentoentregaCollection().add(documentoentrega);
                coddocumento = em.merge(coddocumento);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDocumentoentrega(documentoentrega.getCoddocumentoentrega()) != null) {
                throw new PreexistingEntityException("Documentoentrega " + documentoentrega + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Documentoentrega documentoentrega) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documentoentrega persistentDocumentoentrega = em.find(Documentoentrega.class, documentoentrega.getCoddocumentoentrega());
            Documento coddocumentoOld = persistentDocumentoentrega.getCoddocumento();
            Documento coddocumentoNew = documentoentrega.getCoddocumento();
            if (coddocumentoNew != null) {
                coddocumentoNew = em.getReference(coddocumentoNew.getClass(), coddocumentoNew.getCoddocumento());
                documentoentrega.setCoddocumento(coddocumentoNew);
            }
            documentoentrega = em.merge(documentoentrega);
            if (coddocumentoOld != null && !coddocumentoOld.equals(coddocumentoNew)) {
                coddocumentoOld.getDocumentoentregaCollection().remove(documentoentrega);
                coddocumentoOld = em.merge(coddocumentoOld);
            }
            if (coddocumentoNew != null && !coddocumentoNew.equals(coddocumentoOld)) {
                coddocumentoNew.getDocumentoentregaCollection().add(documentoentrega);
                coddocumentoNew = em.merge(coddocumentoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = documentoentrega.getCoddocumentoentrega();
                if (findDocumentoentrega(id) == null) {
                    throw new NonexistentEntityException("The documentoentrega with id " + id + " no longer exists.");
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
            Documentoentrega documentoentrega;
            try {
                documentoentrega = em.getReference(Documentoentrega.class, id);
                documentoentrega.getCoddocumentoentrega();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The documentoentrega with id " + id + " no longer exists.", enfe);
            }
            Documento coddocumento = documentoentrega.getCoddocumento();
            if (coddocumento != null) {
                coddocumento.getDocumentoentregaCollection().remove(documentoentrega);
                coddocumento = em.merge(coddocumento);
            }
            em.remove(documentoentrega);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Documentoentrega> findDocumentoentregaEntities() {
        return findDocumentoentregaEntities(true, -1, -1);
    }

    public List<Documentoentrega> findDocumentoentregaEntities(int maxResults, int firstResult) {
        return findDocumentoentregaEntities(false, maxResults, firstResult);
    }

    private List<Documentoentrega> findDocumentoentregaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Documentoentrega.class));
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

    public Documentoentrega findDocumentoentrega(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Documentoentrega.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocumentoentregaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Documentoentrega> rt = cq.from(Documentoentrega.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

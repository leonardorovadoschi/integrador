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
import entidade.cplus.Documentotransporte;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class DocumentotransporteJpaController implements Serializable {

    public DocumentotransporteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Documentotransporte documentotransporte) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documento coddocumento = documentotransporte.getCoddocumento();
            if (coddocumento != null) {
                coddocumento = em.getReference(coddocumento.getClass(), coddocumento.getCoddocumento());
                documentotransporte.setCoddocumento(coddocumento);
            }
            em.persist(documentotransporte);
            if (coddocumento != null) {
                coddocumento.getDocumentotransporteCollection().add(documentotransporte);
                coddocumento = em.merge(coddocumento);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDocumentotransporte(documentotransporte.getCoddocumentotransporte()) != null) {
                throw new PreexistingEntityException("Documentotransporte " + documentotransporte + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Documentotransporte documentotransporte) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documentotransporte persistentDocumentotransporte = em.find(Documentotransporte.class, documentotransporte.getCoddocumentotransporte());
            Documento coddocumentoOld = persistentDocumentotransporte.getCoddocumento();
            Documento coddocumentoNew = documentotransporte.getCoddocumento();
            if (coddocumentoNew != null) {
                coddocumentoNew = em.getReference(coddocumentoNew.getClass(), coddocumentoNew.getCoddocumento());
                documentotransporte.setCoddocumento(coddocumentoNew);
            }
            documentotransporte = em.merge(documentotransporte);
            if (coddocumentoOld != null && !coddocumentoOld.equals(coddocumentoNew)) {
                coddocumentoOld.getDocumentotransporteCollection().remove(documentotransporte);
                coddocumentoOld = em.merge(coddocumentoOld);
            }
            if (coddocumentoNew != null && !coddocumentoNew.equals(coddocumentoOld)) {
                coddocumentoNew.getDocumentotransporteCollection().add(documentotransporte);
                coddocumentoNew = em.merge(coddocumentoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = documentotransporte.getCoddocumentotransporte();
                if (findDocumentotransporte(id) == null) {
                    throw new NonexistentEntityException("The documentotransporte with id " + id + " no longer exists.");
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
            Documentotransporte documentotransporte;
            try {
                documentotransporte = em.getReference(Documentotransporte.class, id);
                documentotransporte.getCoddocumentotransporte();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The documentotransporte with id " + id + " no longer exists.", enfe);
            }
            Documento coddocumento = documentotransporte.getCoddocumento();
            if (coddocumento != null) {
                coddocumento.getDocumentotransporteCollection().remove(documentotransporte);
                coddocumento = em.merge(coddocumento);
            }
            em.remove(documentotransporte);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Documentotransporte> findDocumentotransporteEntities() {
        return findDocumentotransporteEntities(true, -1, -1);
    }

    public List<Documentotransporte> findDocumentotransporteEntities(int maxResults, int firstResult) {
        return findDocumentotransporteEntities(false, maxResults, firstResult);
    }

    private List<Documentotransporte> findDocumentotransporteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Documentotransporte.class));
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

    public Documentotransporte findDocumentotransporte(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Documentotransporte.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocumentotransporteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Documentotransporte> rt = cq.from(Documentotransporte.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

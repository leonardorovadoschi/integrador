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
import entidade.cplus.Documentoentidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class DocumentoentidadeJpaController implements Serializable {

    public DocumentoentidadeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Documentoentidade documentoentidade) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documento coddocumento = documentoentidade.getCoddocumento();
            if (coddocumento != null) {
                coddocumento = em.getReference(coddocumento.getClass(), coddocumento.getCoddocumento());
                documentoentidade.setCoddocumento(coddocumento);
            }
            em.persist(documentoentidade);
            if (coddocumento != null) {
                coddocumento.getDocumentoentidadeCollection().add(documentoentidade);
                coddocumento = em.merge(coddocumento);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDocumentoentidade(documentoentidade.getCoddocumentoentidade()) != null) {
                throw new PreexistingEntityException("Documentoentidade " + documentoentidade + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Documentoentidade documentoentidade) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documentoentidade persistentDocumentoentidade = em.find(Documentoentidade.class, documentoentidade.getCoddocumentoentidade());
            Documento coddocumentoOld = persistentDocumentoentidade.getCoddocumento();
            Documento coddocumentoNew = documentoentidade.getCoddocumento();
            if (coddocumentoNew != null) {
                coddocumentoNew = em.getReference(coddocumentoNew.getClass(), coddocumentoNew.getCoddocumento());
                documentoentidade.setCoddocumento(coddocumentoNew);
            }
            documentoentidade = em.merge(documentoentidade);
            if (coddocumentoOld != null && !coddocumentoOld.equals(coddocumentoNew)) {
                coddocumentoOld.getDocumentoentidadeCollection().remove(documentoentidade);
                coddocumentoOld = em.merge(coddocumentoOld);
            }
            if (coddocumentoNew != null && !coddocumentoNew.equals(coddocumentoOld)) {
                coddocumentoNew.getDocumentoentidadeCollection().add(documentoentidade);
                coddocumentoNew = em.merge(coddocumentoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = documentoentidade.getCoddocumentoentidade();
                if (findDocumentoentidade(id) == null) {
                    throw new NonexistentEntityException("The documentoentidade with id " + id + " no longer exists.");
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
            Documentoentidade documentoentidade;
            try {
                documentoentidade = em.getReference(Documentoentidade.class, id);
                documentoentidade.getCoddocumentoentidade();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The documentoentidade with id " + id + " no longer exists.", enfe);
            }
            Documento coddocumento = documentoentidade.getCoddocumento();
            if (coddocumento != null) {
                coddocumento.getDocumentoentidadeCollection().remove(documentoentidade);
                coddocumento = em.merge(coddocumento);
            }
            em.remove(documentoentidade);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Documentoentidade> findDocumentoentidadeEntities() {
        return findDocumentoentidadeEntities(true, -1, -1);
    }

    public List<Documentoentidade> findDocumentoentidadeEntities(int maxResults, int firstResult) {
        return findDocumentoentidadeEntities(false, maxResults, firstResult);
    }

    private List<Documentoentidade> findDocumentoentidadeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Documentoentidade.class));
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

    public Documentoentidade findDocumentoentidade(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Documentoentidade.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocumentoentidadeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Documentoentidade> rt = cq.from(Documentoentidade.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

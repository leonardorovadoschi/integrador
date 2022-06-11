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
import entidade.cplus.Documentocfesatreferenciado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class DocumentocfesatreferenciadoJpaController implements Serializable {

    public DocumentocfesatreferenciadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Documentocfesatreferenciado documentocfesatreferenciado) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documento coddocumento = documentocfesatreferenciado.getCoddocumento();
            if (coddocumento != null) {
                coddocumento = em.getReference(coddocumento.getClass(), coddocumento.getCoddocumento());
                documentocfesatreferenciado.setCoddocumento(coddocumento);
            }
            em.persist(documentocfesatreferenciado);
            if (coddocumento != null) {
                coddocumento.getDocumentocfesatreferenciadoCollection().add(documentocfesatreferenciado);
                coddocumento = em.merge(coddocumento);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDocumentocfesatreferenciado(documentocfesatreferenciado.getCoddocumentocfesatreferenciado()) != null) {
                throw new PreexistingEntityException("Documentocfesatreferenciado " + documentocfesatreferenciado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Documentocfesatreferenciado documentocfesatreferenciado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documentocfesatreferenciado persistentDocumentocfesatreferenciado = em.find(Documentocfesatreferenciado.class, documentocfesatreferenciado.getCoddocumentocfesatreferenciado());
            Documento coddocumentoOld = persistentDocumentocfesatreferenciado.getCoddocumento();
            Documento coddocumentoNew = documentocfesatreferenciado.getCoddocumento();
            if (coddocumentoNew != null) {
                coddocumentoNew = em.getReference(coddocumentoNew.getClass(), coddocumentoNew.getCoddocumento());
                documentocfesatreferenciado.setCoddocumento(coddocumentoNew);
            }
            documentocfesatreferenciado = em.merge(documentocfesatreferenciado);
            if (coddocumentoOld != null && !coddocumentoOld.equals(coddocumentoNew)) {
                coddocumentoOld.getDocumentocfesatreferenciadoCollection().remove(documentocfesatreferenciado);
                coddocumentoOld = em.merge(coddocumentoOld);
            }
            if (coddocumentoNew != null && !coddocumentoNew.equals(coddocumentoOld)) {
                coddocumentoNew.getDocumentocfesatreferenciadoCollection().add(documentocfesatreferenciado);
                coddocumentoNew = em.merge(coddocumentoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = documentocfesatreferenciado.getCoddocumentocfesatreferenciado();
                if (findDocumentocfesatreferenciado(id) == null) {
                    throw new NonexistentEntityException("The documentocfesatreferenciado with id " + id + " no longer exists.");
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
            Documentocfesatreferenciado documentocfesatreferenciado;
            try {
                documentocfesatreferenciado = em.getReference(Documentocfesatreferenciado.class, id);
                documentocfesatreferenciado.getCoddocumentocfesatreferenciado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The documentocfesatreferenciado with id " + id + " no longer exists.", enfe);
            }
            Documento coddocumento = documentocfesatreferenciado.getCoddocumento();
            if (coddocumento != null) {
                coddocumento.getDocumentocfesatreferenciadoCollection().remove(documentocfesatreferenciado);
                coddocumento = em.merge(coddocumento);
            }
            em.remove(documentocfesatreferenciado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Documentocfesatreferenciado> findDocumentocfesatreferenciadoEntities() {
        return findDocumentocfesatreferenciadoEntities(true, -1, -1);
    }

    public List<Documentocfesatreferenciado> findDocumentocfesatreferenciadoEntities(int maxResults, int firstResult) {
        return findDocumentocfesatreferenciadoEntities(false, maxResults, firstResult);
    }

    private List<Documentocfesatreferenciado> findDocumentocfesatreferenciadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Documentocfesatreferenciado.class));
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

    public Documentocfesatreferenciado findDocumentocfesatreferenciado(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Documentocfesatreferenciado.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocumentocfesatreferenciadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Documentocfesatreferenciado> rt = cq.from(Documentocfesatreferenciado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

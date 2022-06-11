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
import entidade.cplus.Documentoitem;
import entidade.cplus.Documentoitemperigoso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class DocumentoitemperigosoJpaController implements Serializable {

    public DocumentoitemperigosoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Documentoitemperigoso documentoitemperigoso) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documentoitem coddocumentoitem = documentoitemperigoso.getCoddocumentoitem();
            if (coddocumentoitem != null) {
                coddocumentoitem = em.getReference(coddocumentoitem.getClass(), coddocumentoitem.getCoddocumentoitem());
                documentoitemperigoso.setCoddocumentoitem(coddocumentoitem);
            }
            em.persist(documentoitemperigoso);
            if (coddocumentoitem != null) {
                coddocumentoitem.getDocumentoitemperigosoCollection().add(documentoitemperigoso);
                coddocumentoitem = em.merge(coddocumentoitem);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDocumentoitemperigoso(documentoitemperigoso.getCoddocumentoitemperigoso()) != null) {
                throw new PreexistingEntityException("Documentoitemperigoso " + documentoitemperigoso + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Documentoitemperigoso documentoitemperigoso) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documentoitemperigoso persistentDocumentoitemperigoso = em.find(Documentoitemperigoso.class, documentoitemperigoso.getCoddocumentoitemperigoso());
            Documentoitem coddocumentoitemOld = persistentDocumentoitemperigoso.getCoddocumentoitem();
            Documentoitem coddocumentoitemNew = documentoitemperigoso.getCoddocumentoitem();
            if (coddocumentoitemNew != null) {
                coddocumentoitemNew = em.getReference(coddocumentoitemNew.getClass(), coddocumentoitemNew.getCoddocumentoitem());
                documentoitemperigoso.setCoddocumentoitem(coddocumentoitemNew);
            }
            documentoitemperigoso = em.merge(documentoitemperigoso);
            if (coddocumentoitemOld != null && !coddocumentoitemOld.equals(coddocumentoitemNew)) {
                coddocumentoitemOld.getDocumentoitemperigosoCollection().remove(documentoitemperigoso);
                coddocumentoitemOld = em.merge(coddocumentoitemOld);
            }
            if (coddocumentoitemNew != null && !coddocumentoitemNew.equals(coddocumentoitemOld)) {
                coddocumentoitemNew.getDocumentoitemperigosoCollection().add(documentoitemperigoso);
                coddocumentoitemNew = em.merge(coddocumentoitemNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = documentoitemperigoso.getCoddocumentoitemperigoso();
                if (findDocumentoitemperigoso(id) == null) {
                    throw new NonexistentEntityException("The documentoitemperigoso with id " + id + " no longer exists.");
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
            Documentoitemperigoso documentoitemperigoso;
            try {
                documentoitemperigoso = em.getReference(Documentoitemperigoso.class, id);
                documentoitemperigoso.getCoddocumentoitemperigoso();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The documentoitemperigoso with id " + id + " no longer exists.", enfe);
            }
            Documentoitem coddocumentoitem = documentoitemperigoso.getCoddocumentoitem();
            if (coddocumentoitem != null) {
                coddocumentoitem.getDocumentoitemperigosoCollection().remove(documentoitemperigoso);
                coddocumentoitem = em.merge(coddocumentoitem);
            }
            em.remove(documentoitemperigoso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Documentoitemperigoso> findDocumentoitemperigosoEntities() {
        return findDocumentoitemperigosoEntities(true, -1, -1);
    }

    public List<Documentoitemperigoso> findDocumentoitemperigosoEntities(int maxResults, int firstResult) {
        return findDocumentoitemperigosoEntities(false, maxResults, firstResult);
    }

    private List<Documentoitemperigoso> findDocumentoitemperigosoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Documentoitemperigoso.class));
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

    public Documentoitemperigoso findDocumentoitemperigoso(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Documentoitemperigoso.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocumentoitemperigosoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Documentoitemperigoso> rt = cq.from(Documentoitemperigoso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
import entidade.cplus.Documentoitemlote;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class DocumentoitemloteJpaController implements Serializable {

    public DocumentoitemloteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Documentoitemlote documentoitemlote) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documentoitem coddocumentoitem = documentoitemlote.getCoddocumentoitem();
            if (coddocumentoitem != null) {
                coddocumentoitem = em.getReference(coddocumentoitem.getClass(), coddocumentoitem.getCoddocumentoitem());
                documentoitemlote.setCoddocumentoitem(coddocumentoitem);
            }
            em.persist(documentoitemlote);
            if (coddocumentoitem != null) {
                coddocumentoitem.getDocumentoitemloteCollection().add(documentoitemlote);
                coddocumentoitem = em.merge(coddocumentoitem);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDocumentoitemlote(documentoitemlote.getCoddocumentoitemlote()) != null) {
                throw new PreexistingEntityException("Documentoitemlote " + documentoitemlote + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Documentoitemlote documentoitemlote) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documentoitemlote persistentDocumentoitemlote = em.find(Documentoitemlote.class, documentoitemlote.getCoddocumentoitemlote());
            Documentoitem coddocumentoitemOld = persistentDocumentoitemlote.getCoddocumentoitem();
            Documentoitem coddocumentoitemNew = documentoitemlote.getCoddocumentoitem();
            if (coddocumentoitemNew != null) {
                coddocumentoitemNew = em.getReference(coddocumentoitemNew.getClass(), coddocumentoitemNew.getCoddocumentoitem());
                documentoitemlote.setCoddocumentoitem(coddocumentoitemNew);
            }
            documentoitemlote = em.merge(documentoitemlote);
            if (coddocumentoitemOld != null && !coddocumentoitemOld.equals(coddocumentoitemNew)) {
                coddocumentoitemOld.getDocumentoitemloteCollection().remove(documentoitemlote);
                coddocumentoitemOld = em.merge(coddocumentoitemOld);
            }
            if (coddocumentoitemNew != null && !coddocumentoitemNew.equals(coddocumentoitemOld)) {
                coddocumentoitemNew.getDocumentoitemloteCollection().add(documentoitemlote);
                coddocumentoitemNew = em.merge(coddocumentoitemNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = documentoitemlote.getCoddocumentoitemlote();
                if (findDocumentoitemlote(id) == null) {
                    throw new NonexistentEntityException("The documentoitemlote with id " + id + " no longer exists.");
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
            Documentoitemlote documentoitemlote;
            try {
                documentoitemlote = em.getReference(Documentoitemlote.class, id);
                documentoitemlote.getCoddocumentoitemlote();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The documentoitemlote with id " + id + " no longer exists.", enfe);
            }
            Documentoitem coddocumentoitem = documentoitemlote.getCoddocumentoitem();
            if (coddocumentoitem != null) {
                coddocumentoitem.getDocumentoitemloteCollection().remove(documentoitemlote);
                coddocumentoitem = em.merge(coddocumentoitem);
            }
            em.remove(documentoitemlote);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Documentoitemlote> findDocumentoitemloteEntities() {
        return findDocumentoitemloteEntities(true, -1, -1);
    }

    public List<Documentoitemlote> findDocumentoitemloteEntities(int maxResults, int firstResult) {
        return findDocumentoitemloteEntities(false, maxResults, firstResult);
    }

    private List<Documentoitemlote> findDocumentoitemloteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Documentoitemlote.class));
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

    public Documentoitemlote findDocumentoitemlote(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Documentoitemlote.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocumentoitemloteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Documentoitemlote> rt = cq.from(Documentoitemlote.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

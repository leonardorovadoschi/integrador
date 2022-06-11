/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Documentoitempartilhaicms;
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
public class DocumentoitempartilhaicmsJpaController implements Serializable {

    public DocumentoitempartilhaicmsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Documentoitempartilhaicms documentoitempartilhaicms) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(documentoitempartilhaicms);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDocumentoitempartilhaicms(documentoitempartilhaicms.getCoddocumentoitempartilhaicms()) != null) {
                throw new PreexistingEntityException("Documentoitempartilhaicms " + documentoitempartilhaicms + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Documentoitempartilhaicms documentoitempartilhaicms) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            documentoitempartilhaicms = em.merge(documentoitempartilhaicms);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = documentoitempartilhaicms.getCoddocumentoitempartilhaicms();
                if (findDocumentoitempartilhaicms(id) == null) {
                    throw new NonexistentEntityException("The documentoitempartilhaicms with id " + id + " no longer exists.");
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
            Documentoitempartilhaicms documentoitempartilhaicms;
            try {
                documentoitempartilhaicms = em.getReference(Documentoitempartilhaicms.class, id);
                documentoitempartilhaicms.getCoddocumentoitempartilhaicms();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The documentoitempartilhaicms with id " + id + " no longer exists.", enfe);
            }
            em.remove(documentoitempartilhaicms);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Documentoitempartilhaicms> findDocumentoitempartilhaicmsEntities() {
        return findDocumentoitempartilhaicmsEntities(true, -1, -1);
    }

    public List<Documentoitempartilhaicms> findDocumentoitempartilhaicmsEntities(int maxResults, int firstResult) {
        return findDocumentoitempartilhaicmsEntities(false, maxResults, firstResult);
    }

    private List<Documentoitempartilhaicms> findDocumentoitempartilhaicmsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Documentoitempartilhaicms.class));
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

    public Documentoitempartilhaicms findDocumentoitempartilhaicms(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Documentoitempartilhaicms.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocumentoitempartilhaicmsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Documentoitempartilhaicms> rt = cq.from(Documentoitempartilhaicms.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

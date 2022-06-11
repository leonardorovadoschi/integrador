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
import entidade.cplus.Documentoitementidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class DocumentoitementidadeJpaController implements Serializable {

    public DocumentoitementidadeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Documentoitementidade documentoitementidade) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documentoitem coddocumentoitem = documentoitementidade.getCoddocumentoitem();
            if (coddocumentoitem != null) {
                coddocumentoitem = em.getReference(coddocumentoitem.getClass(), coddocumentoitem.getCoddocumentoitem());
                documentoitementidade.setCoddocumentoitem(coddocumentoitem);
            }
            em.persist(documentoitementidade);
            if (coddocumentoitem != null) {
                coddocumentoitem.getDocumentoitementidadeCollection().add(documentoitementidade);
                coddocumentoitem = em.merge(coddocumentoitem);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDocumentoitementidade(documentoitementidade.getCoddocumentoitementidade()) != null) {
                throw new PreexistingEntityException("Documentoitementidade " + documentoitementidade + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Documentoitementidade documentoitementidade) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documentoitementidade persistentDocumentoitementidade = em.find(Documentoitementidade.class, documentoitementidade.getCoddocumentoitementidade());
            Documentoitem coddocumentoitemOld = persistentDocumentoitementidade.getCoddocumentoitem();
            Documentoitem coddocumentoitemNew = documentoitementidade.getCoddocumentoitem();
            if (coddocumentoitemNew != null) {
                coddocumentoitemNew = em.getReference(coddocumentoitemNew.getClass(), coddocumentoitemNew.getCoddocumentoitem());
                documentoitementidade.setCoddocumentoitem(coddocumentoitemNew);
            }
            documentoitementidade = em.merge(documentoitementidade);
            if (coddocumentoitemOld != null && !coddocumentoitemOld.equals(coddocumentoitemNew)) {
                coddocumentoitemOld.getDocumentoitementidadeCollection().remove(documentoitementidade);
                coddocumentoitemOld = em.merge(coddocumentoitemOld);
            }
            if (coddocumentoitemNew != null && !coddocumentoitemNew.equals(coddocumentoitemOld)) {
                coddocumentoitemNew.getDocumentoitementidadeCollection().add(documentoitementidade);
                coddocumentoitemNew = em.merge(coddocumentoitemNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = documentoitementidade.getCoddocumentoitementidade();
                if (findDocumentoitementidade(id) == null) {
                    throw new NonexistentEntityException("The documentoitementidade with id " + id + " no longer exists.");
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
            Documentoitementidade documentoitementidade;
            try {
                documentoitementidade = em.getReference(Documentoitementidade.class, id);
                documentoitementidade.getCoddocumentoitementidade();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The documentoitementidade with id " + id + " no longer exists.", enfe);
            }
            Documentoitem coddocumentoitem = documentoitementidade.getCoddocumentoitem();
            if (coddocumentoitem != null) {
                coddocumentoitem.getDocumentoitementidadeCollection().remove(documentoitementidade);
                coddocumentoitem = em.merge(coddocumentoitem);
            }
            em.remove(documentoitementidade);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Documentoitementidade> findDocumentoitementidadeEntities() {
        return findDocumentoitementidadeEntities(true, -1, -1);
    }

    public List<Documentoitementidade> findDocumentoitementidadeEntities(int maxResults, int firstResult) {
        return findDocumentoitementidadeEntities(false, maxResults, firstResult);
    }

    private List<Documentoitementidade> findDocumentoitementidadeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Documentoitementidade.class));
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

    public Documentoitementidade findDocumentoitementidade(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Documentoitementidade.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocumentoitementidadeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Documentoitementidade> rt = cq.from(Documentoitementidade.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

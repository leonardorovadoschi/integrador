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
import entidade.cplus.Documentoitem;
import entidade.cplus.Documentoitementidade;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Documentoitemperigoso;
import entidade.cplus.Documentoitemlote;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.IllegalOrphanException;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class DocumentoitemJpaController implements Serializable {

    public DocumentoitemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Documentoitem documentoitem) throws PreexistingEntityException, Exception {
        if (documentoitem.getDocumentoitementidadeCollection() == null) {
            documentoitem.setDocumentoitementidadeCollection(new ArrayList<Documentoitementidade>());
        }
        if (documentoitem.getDocumentoitemperigosoCollection() == null) {
            documentoitem.setDocumentoitemperigosoCollection(new ArrayList<Documentoitemperigoso>());
        }
        if (documentoitem.getDocumentoitemloteCollection() == null) {
            documentoitem.setDocumentoitemloteCollection(new ArrayList<Documentoitemlote>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documento coddocumento = documentoitem.getCoddocumento();
            if (coddocumento != null) {
                coddocumento = em.getReference(coddocumento.getClass(), coddocumento.getCoddocumento());
                documentoitem.setCoddocumento(coddocumento);
            }
            Collection<Documentoitementidade> attachedDocumentoitementidadeCollection = new ArrayList<Documentoitementidade>();
            for (Documentoitementidade documentoitementidadeCollectionDocumentoitementidadeToAttach : documentoitem.getDocumentoitementidadeCollection()) {
                documentoitementidadeCollectionDocumentoitementidadeToAttach = em.getReference(documentoitementidadeCollectionDocumentoitementidadeToAttach.getClass(), documentoitementidadeCollectionDocumentoitementidadeToAttach.getCoddocumentoitementidade());
                attachedDocumentoitementidadeCollection.add(documentoitementidadeCollectionDocumentoitementidadeToAttach);
            }
            documentoitem.setDocumentoitementidadeCollection(attachedDocumentoitementidadeCollection);
            Collection<Documentoitemperigoso> attachedDocumentoitemperigosoCollection = new ArrayList<Documentoitemperigoso>();
            for (Documentoitemperigoso documentoitemperigosoCollectionDocumentoitemperigosoToAttach : documentoitem.getDocumentoitemperigosoCollection()) {
                documentoitemperigosoCollectionDocumentoitemperigosoToAttach = em.getReference(documentoitemperigosoCollectionDocumentoitemperigosoToAttach.getClass(), documentoitemperigosoCollectionDocumentoitemperigosoToAttach.getCoddocumentoitemperigoso());
                attachedDocumentoitemperigosoCollection.add(documentoitemperigosoCollectionDocumentoitemperigosoToAttach);
            }
            documentoitem.setDocumentoitemperigosoCollection(attachedDocumentoitemperigosoCollection);
            Collection<Documentoitemlote> attachedDocumentoitemloteCollection = new ArrayList<Documentoitemlote>();
            for (Documentoitemlote documentoitemloteCollectionDocumentoitemloteToAttach : documentoitem.getDocumentoitemloteCollection()) {
                documentoitemloteCollectionDocumentoitemloteToAttach = em.getReference(documentoitemloteCollectionDocumentoitemloteToAttach.getClass(), documentoitemloteCollectionDocumentoitemloteToAttach.getCoddocumentoitemlote());
                attachedDocumentoitemloteCollection.add(documentoitemloteCollectionDocumentoitemloteToAttach);
            }
            documentoitem.setDocumentoitemloteCollection(attachedDocumentoitemloteCollection);
            em.persist(documentoitem);
            if (coddocumento != null) {
                coddocumento.getDocumentoitemCollection().add(documentoitem);
                coddocumento = em.merge(coddocumento);
            }
            for (Documentoitementidade documentoitementidadeCollectionDocumentoitementidade : documentoitem.getDocumentoitementidadeCollection()) {
                Documentoitem oldCoddocumentoitemOfDocumentoitementidadeCollectionDocumentoitementidade = documentoitementidadeCollectionDocumentoitementidade.getCoddocumentoitem();
                documentoitementidadeCollectionDocumentoitementidade.setCoddocumentoitem(documentoitem);
                documentoitementidadeCollectionDocumentoitementidade = em.merge(documentoitementidadeCollectionDocumentoitementidade);
                if (oldCoddocumentoitemOfDocumentoitementidadeCollectionDocumentoitementidade != null) {
                    oldCoddocumentoitemOfDocumentoitementidadeCollectionDocumentoitementidade.getDocumentoitementidadeCollection().remove(documentoitementidadeCollectionDocumentoitementidade);
                    oldCoddocumentoitemOfDocumentoitementidadeCollectionDocumentoitementidade = em.merge(oldCoddocumentoitemOfDocumentoitementidadeCollectionDocumentoitementidade);
                }
            }
            for (Documentoitemperigoso documentoitemperigosoCollectionDocumentoitemperigoso : documentoitem.getDocumentoitemperigosoCollection()) {
                Documentoitem oldCoddocumentoitemOfDocumentoitemperigosoCollectionDocumentoitemperigoso = documentoitemperigosoCollectionDocumentoitemperigoso.getCoddocumentoitem();
                documentoitemperigosoCollectionDocumentoitemperigoso.setCoddocumentoitem(documentoitem);
                documentoitemperigosoCollectionDocumentoitemperigoso = em.merge(documentoitemperigosoCollectionDocumentoitemperigoso);
                if (oldCoddocumentoitemOfDocumentoitemperigosoCollectionDocumentoitemperigoso != null) {
                    oldCoddocumentoitemOfDocumentoitemperigosoCollectionDocumentoitemperigoso.getDocumentoitemperigosoCollection().remove(documentoitemperigosoCollectionDocumentoitemperigoso);
                    oldCoddocumentoitemOfDocumentoitemperigosoCollectionDocumentoitemperigoso = em.merge(oldCoddocumentoitemOfDocumentoitemperigosoCollectionDocumentoitemperigoso);
                }
            }
            for (Documentoitemlote documentoitemloteCollectionDocumentoitemlote : documentoitem.getDocumentoitemloteCollection()) {
                Documentoitem oldCoddocumentoitemOfDocumentoitemloteCollectionDocumentoitemlote = documentoitemloteCollectionDocumentoitemlote.getCoddocumentoitem();
                documentoitemloteCollectionDocumentoitemlote.setCoddocumentoitem(documentoitem);
                documentoitemloteCollectionDocumentoitemlote = em.merge(documentoitemloteCollectionDocumentoitemlote);
                if (oldCoddocumentoitemOfDocumentoitemloteCollectionDocumentoitemlote != null) {
                    oldCoddocumentoitemOfDocumentoitemloteCollectionDocumentoitemlote.getDocumentoitemloteCollection().remove(documentoitemloteCollectionDocumentoitemlote);
                    oldCoddocumentoitemOfDocumentoitemloteCollectionDocumentoitemlote = em.merge(oldCoddocumentoitemOfDocumentoitemloteCollectionDocumentoitemlote);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDocumentoitem(documentoitem.getCoddocumentoitem()) != null) {
                throw new PreexistingEntityException("Documentoitem " + documentoitem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Documentoitem documentoitem) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documentoitem persistentDocumentoitem = em.find(Documentoitem.class, documentoitem.getCoddocumentoitem());
            Documento coddocumentoOld = persistentDocumentoitem.getCoddocumento();
            Documento coddocumentoNew = documentoitem.getCoddocumento();
            Collection<Documentoitementidade> documentoitementidadeCollectionOld = persistentDocumentoitem.getDocumentoitementidadeCollection();
            Collection<Documentoitementidade> documentoitementidadeCollectionNew = documentoitem.getDocumentoitementidadeCollection();
            Collection<Documentoitemperigoso> documentoitemperigosoCollectionOld = persistentDocumentoitem.getDocumentoitemperigosoCollection();
            Collection<Documentoitemperigoso> documentoitemperigosoCollectionNew = documentoitem.getDocumentoitemperigosoCollection();
            Collection<Documentoitemlote> documentoitemloteCollectionOld = persistentDocumentoitem.getDocumentoitemloteCollection();
            Collection<Documentoitemlote> documentoitemloteCollectionNew = documentoitem.getDocumentoitemloteCollection();
            List<String> illegalOrphanMessages = null;
            for (Documentoitementidade documentoitementidadeCollectionOldDocumentoitementidade : documentoitementidadeCollectionOld) {
                if (!documentoitementidadeCollectionNew.contains(documentoitementidadeCollectionOldDocumentoitementidade)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Documentoitementidade " + documentoitementidadeCollectionOldDocumentoitementidade + " since its coddocumentoitem field is not nullable.");
                }
            }
            for (Documentoitemperigoso documentoitemperigosoCollectionOldDocumentoitemperigoso : documentoitemperigosoCollectionOld) {
                if (!documentoitemperigosoCollectionNew.contains(documentoitemperigosoCollectionOldDocumentoitemperigoso)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Documentoitemperigoso " + documentoitemperigosoCollectionOldDocumentoitemperigoso + " since its coddocumentoitem field is not nullable.");
                }
            }
            for (Documentoitemlote documentoitemloteCollectionOldDocumentoitemlote : documentoitemloteCollectionOld) {
                if (!documentoitemloteCollectionNew.contains(documentoitemloteCollectionOldDocumentoitemlote)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Documentoitemlote " + documentoitemloteCollectionOldDocumentoitemlote + " since its coddocumentoitem field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (coddocumentoNew != null) {
                coddocumentoNew = em.getReference(coddocumentoNew.getClass(), coddocumentoNew.getCoddocumento());
                documentoitem.setCoddocumento(coddocumentoNew);
            }
            Collection<Documentoitementidade> attachedDocumentoitementidadeCollectionNew = new ArrayList<Documentoitementidade>();
            for (Documentoitementidade documentoitementidadeCollectionNewDocumentoitementidadeToAttach : documentoitementidadeCollectionNew) {
                documentoitementidadeCollectionNewDocumentoitementidadeToAttach = em.getReference(documentoitementidadeCollectionNewDocumentoitementidadeToAttach.getClass(), documentoitementidadeCollectionNewDocumentoitementidadeToAttach.getCoddocumentoitementidade());
                attachedDocumentoitementidadeCollectionNew.add(documentoitementidadeCollectionNewDocumentoitementidadeToAttach);
            }
            documentoitementidadeCollectionNew = attachedDocumentoitementidadeCollectionNew;
            documentoitem.setDocumentoitementidadeCollection(documentoitementidadeCollectionNew);
            Collection<Documentoitemperigoso> attachedDocumentoitemperigosoCollectionNew = new ArrayList<Documentoitemperigoso>();
            for (Documentoitemperigoso documentoitemperigosoCollectionNewDocumentoitemperigosoToAttach : documentoitemperigosoCollectionNew) {
                documentoitemperigosoCollectionNewDocumentoitemperigosoToAttach = em.getReference(documentoitemperigosoCollectionNewDocumentoitemperigosoToAttach.getClass(), documentoitemperigosoCollectionNewDocumentoitemperigosoToAttach.getCoddocumentoitemperigoso());
                attachedDocumentoitemperigosoCollectionNew.add(documentoitemperigosoCollectionNewDocumentoitemperigosoToAttach);
            }
            documentoitemperigosoCollectionNew = attachedDocumentoitemperigosoCollectionNew;
            documentoitem.setDocumentoitemperigosoCollection(documentoitemperigosoCollectionNew);
            Collection<Documentoitemlote> attachedDocumentoitemloteCollectionNew = new ArrayList<Documentoitemlote>();
            for (Documentoitemlote documentoitemloteCollectionNewDocumentoitemloteToAttach : documentoitemloteCollectionNew) {
                documentoitemloteCollectionNewDocumentoitemloteToAttach = em.getReference(documentoitemloteCollectionNewDocumentoitemloteToAttach.getClass(), documentoitemloteCollectionNewDocumentoitemloteToAttach.getCoddocumentoitemlote());
                attachedDocumentoitemloteCollectionNew.add(documentoitemloteCollectionNewDocumentoitemloteToAttach);
            }
            documentoitemloteCollectionNew = attachedDocumentoitemloteCollectionNew;
            documentoitem.setDocumentoitemloteCollection(documentoitemloteCollectionNew);
            documentoitem = em.merge(documentoitem);
            if (coddocumentoOld != null && !coddocumentoOld.equals(coddocumentoNew)) {
                coddocumentoOld.getDocumentoitemCollection().remove(documentoitem);
                coddocumentoOld = em.merge(coddocumentoOld);
            }
            if (coddocumentoNew != null && !coddocumentoNew.equals(coddocumentoOld)) {
                coddocumentoNew.getDocumentoitemCollection().add(documentoitem);
                coddocumentoNew = em.merge(coddocumentoNew);
            }
            for (Documentoitementidade documentoitementidadeCollectionNewDocumentoitementidade : documentoitementidadeCollectionNew) {
                if (!documentoitementidadeCollectionOld.contains(documentoitementidadeCollectionNewDocumentoitementidade)) {
                    Documentoitem oldCoddocumentoitemOfDocumentoitementidadeCollectionNewDocumentoitementidade = documentoitementidadeCollectionNewDocumentoitementidade.getCoddocumentoitem();
                    documentoitementidadeCollectionNewDocumentoitementidade.setCoddocumentoitem(documentoitem);
                    documentoitementidadeCollectionNewDocumentoitementidade = em.merge(documentoitementidadeCollectionNewDocumentoitementidade);
                    if (oldCoddocumentoitemOfDocumentoitementidadeCollectionNewDocumentoitementidade != null && !oldCoddocumentoitemOfDocumentoitementidadeCollectionNewDocumentoitementidade.equals(documentoitem)) {
                        oldCoddocumentoitemOfDocumentoitementidadeCollectionNewDocumentoitementidade.getDocumentoitementidadeCollection().remove(documentoitementidadeCollectionNewDocumentoitementidade);
                        oldCoddocumentoitemOfDocumentoitementidadeCollectionNewDocumentoitementidade = em.merge(oldCoddocumentoitemOfDocumentoitementidadeCollectionNewDocumentoitementidade);
                    }
                }
            }
            for (Documentoitemperigoso documentoitemperigosoCollectionNewDocumentoitemperigoso : documentoitemperigosoCollectionNew) {
                if (!documentoitemperigosoCollectionOld.contains(documentoitemperigosoCollectionNewDocumentoitemperigoso)) {
                    Documentoitem oldCoddocumentoitemOfDocumentoitemperigosoCollectionNewDocumentoitemperigoso = documentoitemperigosoCollectionNewDocumentoitemperigoso.getCoddocumentoitem();
                    documentoitemperigosoCollectionNewDocumentoitemperigoso.setCoddocumentoitem(documentoitem);
                    documentoitemperigosoCollectionNewDocumentoitemperigoso = em.merge(documentoitemperigosoCollectionNewDocumentoitemperigoso);
                    if (oldCoddocumentoitemOfDocumentoitemperigosoCollectionNewDocumentoitemperigoso != null && !oldCoddocumentoitemOfDocumentoitemperigosoCollectionNewDocumentoitemperigoso.equals(documentoitem)) {
                        oldCoddocumentoitemOfDocumentoitemperigosoCollectionNewDocumentoitemperigoso.getDocumentoitemperigosoCollection().remove(documentoitemperigosoCollectionNewDocumentoitemperigoso);
                        oldCoddocumentoitemOfDocumentoitemperigosoCollectionNewDocumentoitemperigoso = em.merge(oldCoddocumentoitemOfDocumentoitemperigosoCollectionNewDocumentoitemperigoso);
                    }
                }
            }
            for (Documentoitemlote documentoitemloteCollectionNewDocumentoitemlote : documentoitemloteCollectionNew) {
                if (!documentoitemloteCollectionOld.contains(documentoitemloteCollectionNewDocumentoitemlote)) {
                    Documentoitem oldCoddocumentoitemOfDocumentoitemloteCollectionNewDocumentoitemlote = documentoitemloteCollectionNewDocumentoitemlote.getCoddocumentoitem();
                    documentoitemloteCollectionNewDocumentoitemlote.setCoddocumentoitem(documentoitem);
                    documentoitemloteCollectionNewDocumentoitemlote = em.merge(documentoitemloteCollectionNewDocumentoitemlote);
                    if (oldCoddocumentoitemOfDocumentoitemloteCollectionNewDocumentoitemlote != null && !oldCoddocumentoitemOfDocumentoitemloteCollectionNewDocumentoitemlote.equals(documentoitem)) {
                        oldCoddocumentoitemOfDocumentoitemloteCollectionNewDocumentoitemlote.getDocumentoitemloteCollection().remove(documentoitemloteCollectionNewDocumentoitemlote);
                        oldCoddocumentoitemOfDocumentoitemloteCollectionNewDocumentoitemlote = em.merge(oldCoddocumentoitemOfDocumentoitemloteCollectionNewDocumentoitemlote);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = documentoitem.getCoddocumentoitem();
                if (findDocumentoitem(id) == null) {
                    throw new NonexistentEntityException("The documentoitem with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documentoitem documentoitem;
            try {
                documentoitem = em.getReference(Documentoitem.class, id);
                documentoitem.getCoddocumentoitem();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The documentoitem with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Documentoitementidade> documentoitementidadeCollectionOrphanCheck = documentoitem.getDocumentoitementidadeCollection();
            for (Documentoitementidade documentoitementidadeCollectionOrphanCheckDocumentoitementidade : documentoitementidadeCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Documentoitem (" + documentoitem + ") cannot be destroyed since the Documentoitementidade " + documentoitementidadeCollectionOrphanCheckDocumentoitementidade + " in its documentoitementidadeCollection field has a non-nullable coddocumentoitem field.");
            }
            Collection<Documentoitemperigoso> documentoitemperigosoCollectionOrphanCheck = documentoitem.getDocumentoitemperigosoCollection();
            for (Documentoitemperigoso documentoitemperigosoCollectionOrphanCheckDocumentoitemperigoso : documentoitemperigosoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Documentoitem (" + documentoitem + ") cannot be destroyed since the Documentoitemperigoso " + documentoitemperigosoCollectionOrphanCheckDocumentoitemperigoso + " in its documentoitemperigosoCollection field has a non-nullable coddocumentoitem field.");
            }
            Collection<Documentoitemlote> documentoitemloteCollectionOrphanCheck = documentoitem.getDocumentoitemloteCollection();
            for (Documentoitemlote documentoitemloteCollectionOrphanCheckDocumentoitemlote : documentoitemloteCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Documentoitem (" + documentoitem + ") cannot be destroyed since the Documentoitemlote " + documentoitemloteCollectionOrphanCheckDocumentoitemlote + " in its documentoitemloteCollection field has a non-nullable coddocumentoitem field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Documento coddocumento = documentoitem.getCoddocumento();
            if (coddocumento != null) {
                coddocumento.getDocumentoitemCollection().remove(documentoitem);
                coddocumento = em.merge(coddocumento);
            }
            em.remove(documentoitem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Documentoitem> findDocumentoitemEntities() {
        return findDocumentoitemEntities(true, -1, -1);
    }

    public List<Documentoitem> findDocumentoitemEntities(int maxResults, int firstResult) {
        return findDocumentoitemEntities(false, maxResults, firstResult);
    }

    private List<Documentoitem> findDocumentoitemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Documentoitem.class));
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

    public Documentoitem findDocumentoitem(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Documentoitem.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocumentoitemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Documentoitem> rt = cq.from(Documentoitem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

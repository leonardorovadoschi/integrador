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
import entidade.cplus.Consultaspc;
import entidade.cplus.Consultaspctipodocumento;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ConsultaspctipodocumentoJpaController implements Serializable {

    public ConsultaspctipodocumentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Consultaspctipodocumento consultaspctipodocumento) throws PreexistingEntityException, Exception {
        if (consultaspctipodocumento.getConsultaspcCollection() == null) {
            consultaspctipodocumento.setConsultaspcCollection(new ArrayList<Consultaspc>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Consultaspc> attachedConsultaspcCollection = new ArrayList<Consultaspc>();
            for (Consultaspc consultaspcCollectionConsultaspcToAttach : consultaspctipodocumento.getConsultaspcCollection()) {
                consultaspcCollectionConsultaspcToAttach = em.getReference(consultaspcCollectionConsultaspcToAttach.getClass(), consultaspcCollectionConsultaspcToAttach.getCodconsultaspc());
                attachedConsultaspcCollection.add(consultaspcCollectionConsultaspcToAttach);
            }
            consultaspctipodocumento.setConsultaspcCollection(attachedConsultaspcCollection);
            em.persist(consultaspctipodocumento);
            for (Consultaspc consultaspcCollectionConsultaspc : consultaspctipodocumento.getConsultaspcCollection()) {
                Consultaspctipodocumento oldCodconsultpdocOfConsultaspcCollectionConsultaspc = consultaspcCollectionConsultaspc.getCodconsultpdoc();
                consultaspcCollectionConsultaspc.setCodconsultpdoc(consultaspctipodocumento);
                consultaspcCollectionConsultaspc = em.merge(consultaspcCollectionConsultaspc);
                if (oldCodconsultpdocOfConsultaspcCollectionConsultaspc != null) {
                    oldCodconsultpdocOfConsultaspcCollectionConsultaspc.getConsultaspcCollection().remove(consultaspcCollectionConsultaspc);
                    oldCodconsultpdocOfConsultaspcCollectionConsultaspc = em.merge(oldCodconsultpdocOfConsultaspcCollectionConsultaspc);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConsultaspctipodocumento(consultaspctipodocumento.getCodconsultpdoc()) != null) {
                throw new PreexistingEntityException("Consultaspctipodocumento " + consultaspctipodocumento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Consultaspctipodocumento consultaspctipodocumento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consultaspctipodocumento persistentConsultaspctipodocumento = em.find(Consultaspctipodocumento.class, consultaspctipodocumento.getCodconsultpdoc());
            Collection<Consultaspc> consultaspcCollectionOld = persistentConsultaspctipodocumento.getConsultaspcCollection();
            Collection<Consultaspc> consultaspcCollectionNew = consultaspctipodocumento.getConsultaspcCollection();
            Collection<Consultaspc> attachedConsultaspcCollectionNew = new ArrayList<Consultaspc>();
            for (Consultaspc consultaspcCollectionNewConsultaspcToAttach : consultaspcCollectionNew) {
                consultaspcCollectionNewConsultaspcToAttach = em.getReference(consultaspcCollectionNewConsultaspcToAttach.getClass(), consultaspcCollectionNewConsultaspcToAttach.getCodconsultaspc());
                attachedConsultaspcCollectionNew.add(consultaspcCollectionNewConsultaspcToAttach);
            }
            consultaspcCollectionNew = attachedConsultaspcCollectionNew;
            consultaspctipodocumento.setConsultaspcCollection(consultaspcCollectionNew);
            consultaspctipodocumento = em.merge(consultaspctipodocumento);
            for (Consultaspc consultaspcCollectionOldConsultaspc : consultaspcCollectionOld) {
                if (!consultaspcCollectionNew.contains(consultaspcCollectionOldConsultaspc)) {
                    consultaspcCollectionOldConsultaspc.setCodconsultpdoc(null);
                    consultaspcCollectionOldConsultaspc = em.merge(consultaspcCollectionOldConsultaspc);
                }
            }
            for (Consultaspc consultaspcCollectionNewConsultaspc : consultaspcCollectionNew) {
                if (!consultaspcCollectionOld.contains(consultaspcCollectionNewConsultaspc)) {
                    Consultaspctipodocumento oldCodconsultpdocOfConsultaspcCollectionNewConsultaspc = consultaspcCollectionNewConsultaspc.getCodconsultpdoc();
                    consultaspcCollectionNewConsultaspc.setCodconsultpdoc(consultaspctipodocumento);
                    consultaspcCollectionNewConsultaspc = em.merge(consultaspcCollectionNewConsultaspc);
                    if (oldCodconsultpdocOfConsultaspcCollectionNewConsultaspc != null && !oldCodconsultpdocOfConsultaspcCollectionNewConsultaspc.equals(consultaspctipodocumento)) {
                        oldCodconsultpdocOfConsultaspcCollectionNewConsultaspc.getConsultaspcCollection().remove(consultaspcCollectionNewConsultaspc);
                        oldCodconsultpdocOfConsultaspcCollectionNewConsultaspc = em.merge(oldCodconsultpdocOfConsultaspcCollectionNewConsultaspc);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = consultaspctipodocumento.getCodconsultpdoc();
                if (findConsultaspctipodocumento(id) == null) {
                    throw new NonexistentEntityException("The consultaspctipodocumento with id " + id + " no longer exists.");
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
            Consultaspctipodocumento consultaspctipodocumento;
            try {
                consultaspctipodocumento = em.getReference(Consultaspctipodocumento.class, id);
                consultaspctipodocumento.getCodconsultpdoc();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The consultaspctipodocumento with id " + id + " no longer exists.", enfe);
            }
            Collection<Consultaspc> consultaspcCollection = consultaspctipodocumento.getConsultaspcCollection();
            for (Consultaspc consultaspcCollectionConsultaspc : consultaspcCollection) {
                consultaspcCollectionConsultaspc.setCodconsultpdoc(null);
                consultaspcCollectionConsultaspc = em.merge(consultaspcCollectionConsultaspc);
            }
            em.remove(consultaspctipodocumento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Consultaspctipodocumento> findConsultaspctipodocumentoEntities() {
        return findConsultaspctipodocumentoEntities(true, -1, -1);
    }

    public List<Consultaspctipodocumento> findConsultaspctipodocumentoEntities(int maxResults, int firstResult) {
        return findConsultaspctipodocumentoEntities(false, maxResults, firstResult);
    }

    private List<Consultaspctipodocumento> findConsultaspctipodocumentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Consultaspctipodocumento.class));
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

    public Consultaspctipodocumento findConsultaspctipodocumento(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Consultaspctipodocumento.class, id);
        } finally {
            em.close();
        }
    }

    public int getConsultaspctipodocumentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Consultaspctipodocumento> rt = cq.from(Consultaspctipodocumento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

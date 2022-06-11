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
import entidade.cplus.Conhecimentotransporte;
import entidade.cplus.Contratotransporte;
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
public class ContratotransporteJpaController implements Serializable {

    public ContratotransporteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Contratotransporte contratotransporte) throws PreexistingEntityException, Exception {
        if (contratotransporte.getConhecimentotransporteCollection() == null) {
            contratotransporte.setConhecimentotransporteCollection(new ArrayList<Conhecimentotransporte>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Conhecimentotransporte> attachedConhecimentotransporteCollection = new ArrayList<Conhecimentotransporte>();
            for (Conhecimentotransporte conhecimentotransporteCollectionConhecimentotransporteToAttach : contratotransporte.getConhecimentotransporteCollection()) {
                conhecimentotransporteCollectionConhecimentotransporteToAttach = em.getReference(conhecimentotransporteCollectionConhecimentotransporteToAttach.getClass(), conhecimentotransporteCollectionConhecimentotransporteToAttach.getCodconhecimentotransporte());
                attachedConhecimentotransporteCollection.add(conhecimentotransporteCollectionConhecimentotransporteToAttach);
            }
            contratotransporte.setConhecimentotransporteCollection(attachedConhecimentotransporteCollection);
            em.persist(contratotransporte);
            for (Conhecimentotransporte conhecimentotransporteCollectionConhecimentotransporte : contratotransporte.getConhecimentotransporteCollection()) {
                Contratotransporte oldCodcontratotransporteOfConhecimentotransporteCollectionConhecimentotransporte = conhecimentotransporteCollectionConhecimentotransporte.getCodcontratotransporte();
                conhecimentotransporteCollectionConhecimentotransporte.setCodcontratotransporte(contratotransporte);
                conhecimentotransporteCollectionConhecimentotransporte = em.merge(conhecimentotransporteCollectionConhecimentotransporte);
                if (oldCodcontratotransporteOfConhecimentotransporteCollectionConhecimentotransporte != null) {
                    oldCodcontratotransporteOfConhecimentotransporteCollectionConhecimentotransporte.getConhecimentotransporteCollection().remove(conhecimentotransporteCollectionConhecimentotransporte);
                    oldCodcontratotransporteOfConhecimentotransporteCollectionConhecimentotransporte = em.merge(oldCodcontratotransporteOfConhecimentotransporteCollectionConhecimentotransporte);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findContratotransporte(contratotransporte.getCodcontratotransporte()) != null) {
                throw new PreexistingEntityException("Contratotransporte " + contratotransporte + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Contratotransporte contratotransporte) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contratotransporte persistentContratotransporte = em.find(Contratotransporte.class, contratotransporte.getCodcontratotransporte());
            Collection<Conhecimentotransporte> conhecimentotransporteCollectionOld = persistentContratotransporte.getConhecimentotransporteCollection();
            Collection<Conhecimentotransporte> conhecimentotransporteCollectionNew = contratotransporte.getConhecimentotransporteCollection();
            Collection<Conhecimentotransporte> attachedConhecimentotransporteCollectionNew = new ArrayList<Conhecimentotransporte>();
            for (Conhecimentotransporte conhecimentotransporteCollectionNewConhecimentotransporteToAttach : conhecimentotransporteCollectionNew) {
                conhecimentotransporteCollectionNewConhecimentotransporteToAttach = em.getReference(conhecimentotransporteCollectionNewConhecimentotransporteToAttach.getClass(), conhecimentotransporteCollectionNewConhecimentotransporteToAttach.getCodconhecimentotransporte());
                attachedConhecimentotransporteCollectionNew.add(conhecimentotransporteCollectionNewConhecimentotransporteToAttach);
            }
            conhecimentotransporteCollectionNew = attachedConhecimentotransporteCollectionNew;
            contratotransporte.setConhecimentotransporteCollection(conhecimentotransporteCollectionNew);
            contratotransporte = em.merge(contratotransporte);
            for (Conhecimentotransporte conhecimentotransporteCollectionOldConhecimentotransporte : conhecimentotransporteCollectionOld) {
                if (!conhecimentotransporteCollectionNew.contains(conhecimentotransporteCollectionOldConhecimentotransporte)) {
                    conhecimentotransporteCollectionOldConhecimentotransporte.setCodcontratotransporte(null);
                    conhecimentotransporteCollectionOldConhecimentotransporte = em.merge(conhecimentotransporteCollectionOldConhecimentotransporte);
                }
            }
            for (Conhecimentotransporte conhecimentotransporteCollectionNewConhecimentotransporte : conhecimentotransporteCollectionNew) {
                if (!conhecimentotransporteCollectionOld.contains(conhecimentotransporteCollectionNewConhecimentotransporte)) {
                    Contratotransporte oldCodcontratotransporteOfConhecimentotransporteCollectionNewConhecimentotransporte = conhecimentotransporteCollectionNewConhecimentotransporte.getCodcontratotransporte();
                    conhecimentotransporteCollectionNewConhecimentotransporte.setCodcontratotransporte(contratotransporte);
                    conhecimentotransporteCollectionNewConhecimentotransporte = em.merge(conhecimentotransporteCollectionNewConhecimentotransporte);
                    if (oldCodcontratotransporteOfConhecimentotransporteCollectionNewConhecimentotransporte != null && !oldCodcontratotransporteOfConhecimentotransporteCollectionNewConhecimentotransporte.equals(contratotransporte)) {
                        oldCodcontratotransporteOfConhecimentotransporteCollectionNewConhecimentotransporte.getConhecimentotransporteCollection().remove(conhecimentotransporteCollectionNewConhecimentotransporte);
                        oldCodcontratotransporteOfConhecimentotransporteCollectionNewConhecimentotransporte = em.merge(oldCodcontratotransporteOfConhecimentotransporteCollectionNewConhecimentotransporte);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = contratotransporte.getCodcontratotransporte();
                if (findContratotransporte(id) == null) {
                    throw new NonexistentEntityException("The contratotransporte with id " + id + " no longer exists.");
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
            Contratotransporte contratotransporte;
            try {
                contratotransporte = em.getReference(Contratotransporte.class, id);
                contratotransporte.getCodcontratotransporte();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The contratotransporte with id " + id + " no longer exists.", enfe);
            }
            Collection<Conhecimentotransporte> conhecimentotransporteCollection = contratotransporte.getConhecimentotransporteCollection();
            for (Conhecimentotransporte conhecimentotransporteCollectionConhecimentotransporte : conhecimentotransporteCollection) {
                conhecimentotransporteCollectionConhecimentotransporte.setCodcontratotransporte(null);
                conhecimentotransporteCollectionConhecimentotransporte = em.merge(conhecimentotransporteCollectionConhecimentotransporte);
            }
            em.remove(contratotransporte);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Contratotransporte> findContratotransporteEntities() {
        return findContratotransporteEntities(true, -1, -1);
    }

    public List<Contratotransporte> findContratotransporteEntities(int maxResults, int firstResult) {
        return findContratotransporteEntities(false, maxResults, firstResult);
    }

    private List<Contratotransporte> findContratotransporteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Contratotransporte.class));
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

    public Contratotransporte findContratotransporte(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Contratotransporte.class, id);
        } finally {
            em.close();
        }
    }

    public int getContratotransporteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Contratotransporte> rt = cq.from(Contratotransporte.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

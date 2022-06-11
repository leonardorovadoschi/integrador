/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Conhecimentotransporte;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Contratotransporte;
import entidade.cplus.Contareceber;
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
public class ConhecimentotransporteJpaController implements Serializable {

    public ConhecimentotransporteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Conhecimentotransporte conhecimentotransporte) throws PreexistingEntityException, Exception {
        if (conhecimentotransporte.getContareceberCollection() == null) {
            conhecimentotransporte.setContareceberCollection(new ArrayList<Contareceber>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contratotransporte codcontratotransporte = conhecimentotransporte.getCodcontratotransporte();
            if (codcontratotransporte != null) {
                codcontratotransporte = em.getReference(codcontratotransporte.getClass(), codcontratotransporte.getCodcontratotransporte());
                conhecimentotransporte.setCodcontratotransporte(codcontratotransporte);
            }
            Collection<Contareceber> attachedContareceberCollection = new ArrayList<Contareceber>();
            for (Contareceber contareceberCollectionContareceberToAttach : conhecimentotransporte.getContareceberCollection()) {
                contareceberCollectionContareceberToAttach = em.getReference(contareceberCollectionContareceberToAttach.getClass(), contareceberCollectionContareceberToAttach.getCodcr());
                attachedContareceberCollection.add(contareceberCollectionContareceberToAttach);
            }
            conhecimentotransporte.setContareceberCollection(attachedContareceberCollection);
            em.persist(conhecimentotransporte);
            if (codcontratotransporte != null) {
                codcontratotransporte.getConhecimentotransporteCollection().add(conhecimentotransporte);
                codcontratotransporte = em.merge(codcontratotransporte);
            }
            for (Contareceber contareceberCollectionContareceber : conhecimentotransporte.getContareceberCollection()) {
                Conhecimentotransporte oldCodconhecimentotransporteOfContareceberCollectionContareceber = contareceberCollectionContareceber.getCodconhecimentotransporte();
                contareceberCollectionContareceber.setCodconhecimentotransporte(conhecimentotransporte);
                contareceberCollectionContareceber = em.merge(contareceberCollectionContareceber);
                if (oldCodconhecimentotransporteOfContareceberCollectionContareceber != null) {
                    oldCodconhecimentotransporteOfContareceberCollectionContareceber.getContareceberCollection().remove(contareceberCollectionContareceber);
                    oldCodconhecimentotransporteOfContareceberCollectionContareceber = em.merge(oldCodconhecimentotransporteOfContareceberCollectionContareceber);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConhecimentotransporte(conhecimentotransporte.getCodconhecimentotransporte()) != null) {
                throw new PreexistingEntityException("Conhecimentotransporte " + conhecimentotransporte + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Conhecimentotransporte conhecimentotransporte) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Conhecimentotransporte persistentConhecimentotransporte = em.find(Conhecimentotransporte.class, conhecimentotransporte.getCodconhecimentotransporte());
            Contratotransporte codcontratotransporteOld = persistentConhecimentotransporte.getCodcontratotransporte();
            Contratotransporte codcontratotransporteNew = conhecimentotransporte.getCodcontratotransporte();
            Collection<Contareceber> contareceberCollectionOld = persistentConhecimentotransporte.getContareceberCollection();
            Collection<Contareceber> contareceberCollectionNew = conhecimentotransporte.getContareceberCollection();
            if (codcontratotransporteNew != null) {
                codcontratotransporteNew = em.getReference(codcontratotransporteNew.getClass(), codcontratotransporteNew.getCodcontratotransporte());
                conhecimentotransporte.setCodcontratotransporte(codcontratotransporteNew);
            }
            Collection<Contareceber> attachedContareceberCollectionNew = new ArrayList<Contareceber>();
            for (Contareceber contareceberCollectionNewContareceberToAttach : contareceberCollectionNew) {
                contareceberCollectionNewContareceberToAttach = em.getReference(contareceberCollectionNewContareceberToAttach.getClass(), contareceberCollectionNewContareceberToAttach.getCodcr());
                attachedContareceberCollectionNew.add(contareceberCollectionNewContareceberToAttach);
            }
            contareceberCollectionNew = attachedContareceberCollectionNew;
            conhecimentotransporte.setContareceberCollection(contareceberCollectionNew);
            conhecimentotransporte = em.merge(conhecimentotransporte);
            if (codcontratotransporteOld != null && !codcontratotransporteOld.equals(codcontratotransporteNew)) {
                codcontratotransporteOld.getConhecimentotransporteCollection().remove(conhecimentotransporte);
                codcontratotransporteOld = em.merge(codcontratotransporteOld);
            }
            if (codcontratotransporteNew != null && !codcontratotransporteNew.equals(codcontratotransporteOld)) {
                codcontratotransporteNew.getConhecimentotransporteCollection().add(conhecimentotransporte);
                codcontratotransporteNew = em.merge(codcontratotransporteNew);
            }
            for (Contareceber contareceberCollectionOldContareceber : contareceberCollectionOld) {
                if (!contareceberCollectionNew.contains(contareceberCollectionOldContareceber)) {
                    contareceberCollectionOldContareceber.setCodconhecimentotransporte(null);
                    contareceberCollectionOldContareceber = em.merge(contareceberCollectionOldContareceber);
                }
            }
            for (Contareceber contareceberCollectionNewContareceber : contareceberCollectionNew) {
                if (!contareceberCollectionOld.contains(contareceberCollectionNewContareceber)) {
                    Conhecimentotransporte oldCodconhecimentotransporteOfContareceberCollectionNewContareceber = contareceberCollectionNewContareceber.getCodconhecimentotransporte();
                    contareceberCollectionNewContareceber.setCodconhecimentotransporte(conhecimentotransporte);
                    contareceberCollectionNewContareceber = em.merge(contareceberCollectionNewContareceber);
                    if (oldCodconhecimentotransporteOfContareceberCollectionNewContareceber != null && !oldCodconhecimentotransporteOfContareceberCollectionNewContareceber.equals(conhecimentotransporte)) {
                        oldCodconhecimentotransporteOfContareceberCollectionNewContareceber.getContareceberCollection().remove(contareceberCollectionNewContareceber);
                        oldCodconhecimentotransporteOfContareceberCollectionNewContareceber = em.merge(oldCodconhecimentotransporteOfContareceberCollectionNewContareceber);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = conhecimentotransporte.getCodconhecimentotransporte();
                if (findConhecimentotransporte(id) == null) {
                    throw new NonexistentEntityException("The conhecimentotransporte with id " + id + " no longer exists.");
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
            Conhecimentotransporte conhecimentotransporte;
            try {
                conhecimentotransporte = em.getReference(Conhecimentotransporte.class, id);
                conhecimentotransporte.getCodconhecimentotransporte();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The conhecimentotransporte with id " + id + " no longer exists.", enfe);
            }
            Contratotransporte codcontratotransporte = conhecimentotransporte.getCodcontratotransporte();
            if (codcontratotransporte != null) {
                codcontratotransporte.getConhecimentotransporteCollection().remove(conhecimentotransporte);
                codcontratotransporte = em.merge(codcontratotransporte);
            }
            Collection<Contareceber> contareceberCollection = conhecimentotransporte.getContareceberCollection();
            for (Contareceber contareceberCollectionContareceber : contareceberCollection) {
                contareceberCollectionContareceber.setCodconhecimentotransporte(null);
                contareceberCollectionContareceber = em.merge(contareceberCollectionContareceber);
            }
            em.remove(conhecimentotransporte);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Conhecimentotransporte> findConhecimentotransporteEntities() {
        return findConhecimentotransporteEntities(true, -1, -1);
    }

    public List<Conhecimentotransporte> findConhecimentotransporteEntities(int maxResults, int firstResult) {
        return findConhecimentotransporteEntities(false, maxResults, firstResult);
    }

    private List<Conhecimentotransporte> findConhecimentotransporteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Conhecimentotransporte.class));
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

    public Conhecimentotransporte findConhecimentotransporte(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Conhecimentotransporte.class, id);
        } finally {
            em.close();
        }
    }

    public int getConhecimentotransporteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Conhecimentotransporte> rt = cq.from(Conhecimentotransporte.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

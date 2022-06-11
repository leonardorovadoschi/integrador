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
import entidade.cplus.Nfceletronica;
import entidade.cplus.Nfceletronicapafecf;
import entidade.cplus.Nfceletronicapafecfprod;
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
public class NfceletronicapafecfJpaController implements Serializable {

    public NfceletronicapafecfJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Nfceletronicapafecf nfceletronicapafecf) throws PreexistingEntityException, Exception {
        if (nfceletronicapafecf.getNfceletronicapafecfprodCollection() == null) {
            nfceletronicapafecf.setNfceletronicapafecfprodCollection(new ArrayList<Nfceletronicapafecfprod>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nfceletronica codnfceletronica = nfceletronicapafecf.getCodnfceletronica();
            if (codnfceletronica != null) {
                codnfceletronica = em.getReference(codnfceletronica.getClass(), codnfceletronica.getCodnfceletronica());
                nfceletronicapafecf.setCodnfceletronica(codnfceletronica);
            }
            Collection<Nfceletronicapafecfprod> attachedNfceletronicapafecfprodCollection = new ArrayList<Nfceletronicapafecfprod>();
            for (Nfceletronicapafecfprod nfceletronicapafecfprodCollectionNfceletronicapafecfprodToAttach : nfceletronicapafecf.getNfceletronicapafecfprodCollection()) {
                nfceletronicapafecfprodCollectionNfceletronicapafecfprodToAttach = em.getReference(nfceletronicapafecfprodCollectionNfceletronicapafecfprodToAttach.getClass(), nfceletronicapafecfprodCollectionNfceletronicapafecfprodToAttach.getCodnfceletronicapafecfprod());
                attachedNfceletronicapafecfprodCollection.add(nfceletronicapafecfprodCollectionNfceletronicapafecfprodToAttach);
            }
            nfceletronicapafecf.setNfceletronicapafecfprodCollection(attachedNfceletronicapafecfprodCollection);
            em.persist(nfceletronicapafecf);
            if (codnfceletronica != null) {
                codnfceletronica.getNfceletronicapafecfCollection().add(nfceletronicapafecf);
                codnfceletronica = em.merge(codnfceletronica);
            }
            for (Nfceletronicapafecfprod nfceletronicapafecfprodCollectionNfceletronicapafecfprod : nfceletronicapafecf.getNfceletronicapafecfprodCollection()) {
                Nfceletronicapafecf oldCodnfceletronicapafecfOfNfceletronicapafecfprodCollectionNfceletronicapafecfprod = nfceletronicapafecfprodCollectionNfceletronicapafecfprod.getCodnfceletronicapafecf();
                nfceletronicapafecfprodCollectionNfceletronicapafecfprod.setCodnfceletronicapafecf(nfceletronicapafecf);
                nfceletronicapafecfprodCollectionNfceletronicapafecfprod = em.merge(nfceletronicapafecfprodCollectionNfceletronicapafecfprod);
                if (oldCodnfceletronicapafecfOfNfceletronicapafecfprodCollectionNfceletronicapafecfprod != null) {
                    oldCodnfceletronicapafecfOfNfceletronicapafecfprodCollectionNfceletronicapafecfprod.getNfceletronicapafecfprodCollection().remove(nfceletronicapafecfprodCollectionNfceletronicapafecfprod);
                    oldCodnfceletronicapafecfOfNfceletronicapafecfprodCollectionNfceletronicapafecfprod = em.merge(oldCodnfceletronicapafecfOfNfceletronicapafecfprodCollectionNfceletronicapafecfprod);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNfceletronicapafecf(nfceletronicapafecf.getCodnfceletronicapafecf()) != null) {
                throw new PreexistingEntityException("Nfceletronicapafecf " + nfceletronicapafecf + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nfceletronicapafecf nfceletronicapafecf) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nfceletronicapafecf persistentNfceletronicapafecf = em.find(Nfceletronicapafecf.class, nfceletronicapafecf.getCodnfceletronicapafecf());
            Nfceletronica codnfceletronicaOld = persistentNfceletronicapafecf.getCodnfceletronica();
            Nfceletronica codnfceletronicaNew = nfceletronicapafecf.getCodnfceletronica();
            Collection<Nfceletronicapafecfprod> nfceletronicapafecfprodCollectionOld = persistentNfceletronicapafecf.getNfceletronicapafecfprodCollection();
            Collection<Nfceletronicapafecfprod> nfceletronicapafecfprodCollectionNew = nfceletronicapafecf.getNfceletronicapafecfprodCollection();
            if (codnfceletronicaNew != null) {
                codnfceletronicaNew = em.getReference(codnfceletronicaNew.getClass(), codnfceletronicaNew.getCodnfceletronica());
                nfceletronicapafecf.setCodnfceletronica(codnfceletronicaNew);
            }
            Collection<Nfceletronicapafecfprod> attachedNfceletronicapafecfprodCollectionNew = new ArrayList<Nfceletronicapafecfprod>();
            for (Nfceletronicapafecfprod nfceletronicapafecfprodCollectionNewNfceletronicapafecfprodToAttach : nfceletronicapafecfprodCollectionNew) {
                nfceletronicapafecfprodCollectionNewNfceletronicapafecfprodToAttach = em.getReference(nfceletronicapafecfprodCollectionNewNfceletronicapafecfprodToAttach.getClass(), nfceletronicapafecfprodCollectionNewNfceletronicapafecfprodToAttach.getCodnfceletronicapafecfprod());
                attachedNfceletronicapafecfprodCollectionNew.add(nfceletronicapafecfprodCollectionNewNfceletronicapafecfprodToAttach);
            }
            nfceletronicapafecfprodCollectionNew = attachedNfceletronicapafecfprodCollectionNew;
            nfceletronicapafecf.setNfceletronicapafecfprodCollection(nfceletronicapafecfprodCollectionNew);
            nfceletronicapafecf = em.merge(nfceletronicapafecf);
            if (codnfceletronicaOld != null && !codnfceletronicaOld.equals(codnfceletronicaNew)) {
                codnfceletronicaOld.getNfceletronicapafecfCollection().remove(nfceletronicapafecf);
                codnfceletronicaOld = em.merge(codnfceletronicaOld);
            }
            if (codnfceletronicaNew != null && !codnfceletronicaNew.equals(codnfceletronicaOld)) {
                codnfceletronicaNew.getNfceletronicapafecfCollection().add(nfceletronicapafecf);
                codnfceletronicaNew = em.merge(codnfceletronicaNew);
            }
            for (Nfceletronicapafecfprod nfceletronicapafecfprodCollectionOldNfceletronicapafecfprod : nfceletronicapafecfprodCollectionOld) {
                if (!nfceletronicapafecfprodCollectionNew.contains(nfceletronicapafecfprodCollectionOldNfceletronicapafecfprod)) {
                    nfceletronicapafecfprodCollectionOldNfceletronicapafecfprod.setCodnfceletronicapafecf(null);
                    nfceletronicapafecfprodCollectionOldNfceletronicapafecfprod = em.merge(nfceletronicapafecfprodCollectionOldNfceletronicapafecfprod);
                }
            }
            for (Nfceletronicapafecfprod nfceletronicapafecfprodCollectionNewNfceletronicapafecfprod : nfceletronicapafecfprodCollectionNew) {
                if (!nfceletronicapafecfprodCollectionOld.contains(nfceletronicapafecfprodCollectionNewNfceletronicapafecfprod)) {
                    Nfceletronicapafecf oldCodnfceletronicapafecfOfNfceletronicapafecfprodCollectionNewNfceletronicapafecfprod = nfceletronicapafecfprodCollectionNewNfceletronicapafecfprod.getCodnfceletronicapafecf();
                    nfceletronicapafecfprodCollectionNewNfceletronicapafecfprod.setCodnfceletronicapafecf(nfceletronicapafecf);
                    nfceletronicapafecfprodCollectionNewNfceletronicapafecfprod = em.merge(nfceletronicapafecfprodCollectionNewNfceletronicapafecfprod);
                    if (oldCodnfceletronicapafecfOfNfceletronicapafecfprodCollectionNewNfceletronicapafecfprod != null && !oldCodnfceletronicapafecfOfNfceletronicapafecfprodCollectionNewNfceletronicapafecfprod.equals(nfceletronicapafecf)) {
                        oldCodnfceletronicapafecfOfNfceletronicapafecfprodCollectionNewNfceletronicapafecfprod.getNfceletronicapafecfprodCollection().remove(nfceletronicapafecfprodCollectionNewNfceletronicapafecfprod);
                        oldCodnfceletronicapafecfOfNfceletronicapafecfprodCollectionNewNfceletronicapafecfprod = em.merge(oldCodnfceletronicapafecfOfNfceletronicapafecfprodCollectionNewNfceletronicapafecfprod);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = nfceletronicapafecf.getCodnfceletronicapafecf();
                if (findNfceletronicapafecf(id) == null) {
                    throw new NonexistentEntityException("The nfceletronicapafecf with id " + id + " no longer exists.");
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
            Nfceletronicapafecf nfceletronicapafecf;
            try {
                nfceletronicapafecf = em.getReference(Nfceletronicapafecf.class, id);
                nfceletronicapafecf.getCodnfceletronicapafecf();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nfceletronicapafecf with id " + id + " no longer exists.", enfe);
            }
            Nfceletronica codnfceletronica = nfceletronicapafecf.getCodnfceletronica();
            if (codnfceletronica != null) {
                codnfceletronica.getNfceletronicapafecfCollection().remove(nfceletronicapafecf);
                codnfceletronica = em.merge(codnfceletronica);
            }
            Collection<Nfceletronicapafecfprod> nfceletronicapafecfprodCollection = nfceletronicapafecf.getNfceletronicapafecfprodCollection();
            for (Nfceletronicapafecfprod nfceletronicapafecfprodCollectionNfceletronicapafecfprod : nfceletronicapafecfprodCollection) {
                nfceletronicapafecfprodCollectionNfceletronicapafecfprod.setCodnfceletronicapafecf(null);
                nfceletronicapafecfprodCollectionNfceletronicapafecfprod = em.merge(nfceletronicapafecfprodCollectionNfceletronicapafecfprod);
            }
            em.remove(nfceletronicapafecf);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nfceletronicapafecf> findNfceletronicapafecfEntities() {
        return findNfceletronicapafecfEntities(true, -1, -1);
    }

    public List<Nfceletronicapafecf> findNfceletronicapafecfEntities(int maxResults, int firstResult) {
        return findNfceletronicapafecfEntities(false, maxResults, firstResult);
    }

    private List<Nfceletronicapafecf> findNfceletronicapafecfEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nfceletronicapafecf.class));
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

    public Nfceletronicapafecf findNfceletronicapafecf(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nfceletronicapafecf.class, id);
        } finally {
            em.close();
        }
    }

    public int getNfceletronicapafecfCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nfceletronicapafecf> rt = cq.from(Nfceletronicapafecf.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

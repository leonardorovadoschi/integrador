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
import entidade.cplus.Movenda;
import entidade.cplus.Nfceletronica;
import entidade.cplus.Nfceletronicapafecf;
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
public class NfceletronicaJpaController implements Serializable {

    public NfceletronicaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Nfceletronica nfceletronica) throws PreexistingEntityException, Exception {
        if (nfceletronica.getNfceletronicapafecfCollection() == null) {
            nfceletronica.setNfceletronicapafecfCollection(new ArrayList<Nfceletronicapafecf>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movenda codmovenda = nfceletronica.getCodmovenda();
            if (codmovenda != null) {
                codmovenda = em.getReference(codmovenda.getClass(), codmovenda.getCodmovenda());
                nfceletronica.setCodmovenda(codmovenda);
            }
            Collection<Nfceletronicapafecf> attachedNfceletronicapafecfCollection = new ArrayList<Nfceletronicapafecf>();
            for (Nfceletronicapafecf nfceletronicapafecfCollectionNfceletronicapafecfToAttach : nfceletronica.getNfceletronicapafecfCollection()) {
                nfceletronicapafecfCollectionNfceletronicapafecfToAttach = em.getReference(nfceletronicapafecfCollectionNfceletronicapafecfToAttach.getClass(), nfceletronicapafecfCollectionNfceletronicapafecfToAttach.getCodnfceletronicapafecf());
                attachedNfceletronicapafecfCollection.add(nfceletronicapafecfCollectionNfceletronicapafecfToAttach);
            }
            nfceletronica.setNfceletronicapafecfCollection(attachedNfceletronicapafecfCollection);
            em.persist(nfceletronica);
            if (codmovenda != null) {
                codmovenda.getNfceletronicaCollection().add(nfceletronica);
                codmovenda = em.merge(codmovenda);
            }
            for (Nfceletronicapafecf nfceletronicapafecfCollectionNfceletronicapafecf : nfceletronica.getNfceletronicapafecfCollection()) {
                Nfceletronica oldCodnfceletronicaOfNfceletronicapafecfCollectionNfceletronicapafecf = nfceletronicapafecfCollectionNfceletronicapafecf.getCodnfceletronica();
                nfceletronicapafecfCollectionNfceletronicapafecf.setCodnfceletronica(nfceletronica);
                nfceletronicapafecfCollectionNfceletronicapafecf = em.merge(nfceletronicapafecfCollectionNfceletronicapafecf);
                if (oldCodnfceletronicaOfNfceletronicapafecfCollectionNfceletronicapafecf != null) {
                    oldCodnfceletronicaOfNfceletronicapafecfCollectionNfceletronicapafecf.getNfceletronicapafecfCollection().remove(nfceletronicapafecfCollectionNfceletronicapafecf);
                    oldCodnfceletronicaOfNfceletronicapafecfCollectionNfceletronicapafecf = em.merge(oldCodnfceletronicaOfNfceletronicapafecfCollectionNfceletronicapafecf);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNfceletronica(nfceletronica.getCodnfceletronica()) != null) {
                throw new PreexistingEntityException("Nfceletronica " + nfceletronica + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nfceletronica nfceletronica) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nfceletronica persistentNfceletronica = em.find(Nfceletronica.class, nfceletronica.getCodnfceletronica());
            Movenda codmovendaOld = persistentNfceletronica.getCodmovenda();
            Movenda codmovendaNew = nfceletronica.getCodmovenda();
            Collection<Nfceletronicapafecf> nfceletronicapafecfCollectionOld = persistentNfceletronica.getNfceletronicapafecfCollection();
            Collection<Nfceletronicapafecf> nfceletronicapafecfCollectionNew = nfceletronica.getNfceletronicapafecfCollection();
            if (codmovendaNew != null) {
                codmovendaNew = em.getReference(codmovendaNew.getClass(), codmovendaNew.getCodmovenda());
                nfceletronica.setCodmovenda(codmovendaNew);
            }
            Collection<Nfceletronicapafecf> attachedNfceletronicapafecfCollectionNew = new ArrayList<Nfceletronicapafecf>();
            for (Nfceletronicapafecf nfceletronicapafecfCollectionNewNfceletronicapafecfToAttach : nfceletronicapafecfCollectionNew) {
                nfceletronicapafecfCollectionNewNfceletronicapafecfToAttach = em.getReference(nfceletronicapafecfCollectionNewNfceletronicapafecfToAttach.getClass(), nfceletronicapafecfCollectionNewNfceletronicapafecfToAttach.getCodnfceletronicapafecf());
                attachedNfceletronicapafecfCollectionNew.add(nfceletronicapafecfCollectionNewNfceletronicapafecfToAttach);
            }
            nfceletronicapafecfCollectionNew = attachedNfceletronicapafecfCollectionNew;
            nfceletronica.setNfceletronicapafecfCollection(nfceletronicapafecfCollectionNew);
            nfceletronica = em.merge(nfceletronica);
            if (codmovendaOld != null && !codmovendaOld.equals(codmovendaNew)) {
                codmovendaOld.getNfceletronicaCollection().remove(nfceletronica);
                codmovendaOld = em.merge(codmovendaOld);
            }
            if (codmovendaNew != null && !codmovendaNew.equals(codmovendaOld)) {
                codmovendaNew.getNfceletronicaCollection().add(nfceletronica);
                codmovendaNew = em.merge(codmovendaNew);
            }
            for (Nfceletronicapafecf nfceletronicapafecfCollectionOldNfceletronicapafecf : nfceletronicapafecfCollectionOld) {
                if (!nfceletronicapafecfCollectionNew.contains(nfceletronicapafecfCollectionOldNfceletronicapafecf)) {
                    nfceletronicapafecfCollectionOldNfceletronicapafecf.setCodnfceletronica(null);
                    nfceletronicapafecfCollectionOldNfceletronicapafecf = em.merge(nfceletronicapafecfCollectionOldNfceletronicapafecf);
                }
            }
            for (Nfceletronicapafecf nfceletronicapafecfCollectionNewNfceletronicapafecf : nfceletronicapafecfCollectionNew) {
                if (!nfceletronicapafecfCollectionOld.contains(nfceletronicapafecfCollectionNewNfceletronicapafecf)) {
                    Nfceletronica oldCodnfceletronicaOfNfceletronicapafecfCollectionNewNfceletronicapafecf = nfceletronicapafecfCollectionNewNfceletronicapafecf.getCodnfceletronica();
                    nfceletronicapafecfCollectionNewNfceletronicapafecf.setCodnfceletronica(nfceletronica);
                    nfceletronicapafecfCollectionNewNfceletronicapafecf = em.merge(nfceletronicapafecfCollectionNewNfceletronicapafecf);
                    if (oldCodnfceletronicaOfNfceletronicapafecfCollectionNewNfceletronicapafecf != null && !oldCodnfceletronicaOfNfceletronicapafecfCollectionNewNfceletronicapafecf.equals(nfceletronica)) {
                        oldCodnfceletronicaOfNfceletronicapafecfCollectionNewNfceletronicapafecf.getNfceletronicapafecfCollection().remove(nfceletronicapafecfCollectionNewNfceletronicapafecf);
                        oldCodnfceletronicaOfNfceletronicapafecfCollectionNewNfceletronicapafecf = em.merge(oldCodnfceletronicaOfNfceletronicapafecfCollectionNewNfceletronicapafecf);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = nfceletronica.getCodnfceletronica();
                if (findNfceletronica(id) == null) {
                    throw new NonexistentEntityException("The nfceletronica with id " + id + " no longer exists.");
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
            Nfceletronica nfceletronica;
            try {
                nfceletronica = em.getReference(Nfceletronica.class, id);
                nfceletronica.getCodnfceletronica();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nfceletronica with id " + id + " no longer exists.", enfe);
            }
            Movenda codmovenda = nfceletronica.getCodmovenda();
            if (codmovenda != null) {
                codmovenda.getNfceletronicaCollection().remove(nfceletronica);
                codmovenda = em.merge(codmovenda);
            }
            Collection<Nfceletronicapafecf> nfceletronicapafecfCollection = nfceletronica.getNfceletronicapafecfCollection();
            for (Nfceletronicapafecf nfceletronicapafecfCollectionNfceletronicapafecf : nfceletronicapafecfCollection) {
                nfceletronicapafecfCollectionNfceletronicapafecf.setCodnfceletronica(null);
                nfceletronicapafecfCollectionNfceletronicapafecf = em.merge(nfceletronicapafecfCollectionNfceletronicapafecf);
            }
            em.remove(nfceletronica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nfceletronica> findNfceletronicaEntities() {
        return findNfceletronicaEntities(true, -1, -1);
    }

    public List<Nfceletronica> findNfceletronicaEntities(int maxResults, int firstResult) {
        return findNfceletronicaEntities(false, maxResults, firstResult);
    }

    private List<Nfceletronica> findNfceletronicaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nfceletronica.class));
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

    public Nfceletronica findNfceletronica(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nfceletronica.class, id);
        } finally {
            em.close();
        }
    }

    public int getNfceletronicaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nfceletronica> rt = cq.from(Nfceletronica.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

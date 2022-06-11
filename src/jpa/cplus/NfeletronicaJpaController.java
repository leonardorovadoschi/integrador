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
import entidade.cplus.Cceletronica;
import entidade.cplus.Nfeletronica;
import java.util.ArrayList;
import java.util.Collection;
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
public class NfeletronicaJpaController implements Serializable {

    public NfeletronicaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Nfeletronica nfeletronica) throws PreexistingEntityException, Exception {
        if (nfeletronica.getCceletronicaCollection() == null) {
            nfeletronica.setCceletronicaCollection(new ArrayList<Cceletronica>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Cceletronica> attachedCceletronicaCollection = new ArrayList<Cceletronica>();
            for (Cceletronica cceletronicaCollectionCceletronicaToAttach : nfeletronica.getCceletronicaCollection()) {
                cceletronicaCollectionCceletronicaToAttach = em.getReference(cceletronicaCollectionCceletronicaToAttach.getClass(), cceletronicaCollectionCceletronicaToAttach.getCodcceletronica());
                attachedCceletronicaCollection.add(cceletronicaCollectionCceletronicaToAttach);
            }
            nfeletronica.setCceletronicaCollection(attachedCceletronicaCollection);
            em.persist(nfeletronica);
            for (Cceletronica cceletronicaCollectionCceletronica : nfeletronica.getCceletronicaCollection()) {
                Nfeletronica oldCodnfeletronicaOfCceletronicaCollectionCceletronica = cceletronicaCollectionCceletronica.getCodnfeletronica();
                cceletronicaCollectionCceletronica.setCodnfeletronica(nfeletronica);
                cceletronicaCollectionCceletronica = em.merge(cceletronicaCollectionCceletronica);
                if (oldCodnfeletronicaOfCceletronicaCollectionCceletronica != null) {
                    oldCodnfeletronicaOfCceletronicaCollectionCceletronica.getCceletronicaCollection().remove(cceletronicaCollectionCceletronica);
                    oldCodnfeletronicaOfCceletronicaCollectionCceletronica = em.merge(oldCodnfeletronicaOfCceletronicaCollectionCceletronica);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNfeletronica(nfeletronica.getCodnfeletronica()) != null) {
                throw new PreexistingEntityException("Nfeletronica " + nfeletronica + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nfeletronica nfeletronica) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nfeletronica persistentNfeletronica = em.find(Nfeletronica.class, nfeletronica.getCodnfeletronica());
            Collection<Cceletronica> cceletronicaCollectionOld = persistentNfeletronica.getCceletronicaCollection();
            Collection<Cceletronica> cceletronicaCollectionNew = nfeletronica.getCceletronicaCollection();
            List<String> illegalOrphanMessages = null;
            for (Cceletronica cceletronicaCollectionOldCceletronica : cceletronicaCollectionOld) {
                if (!cceletronicaCollectionNew.contains(cceletronicaCollectionOldCceletronica)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cceletronica " + cceletronicaCollectionOldCceletronica + " since its codnfeletronica field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Cceletronica> attachedCceletronicaCollectionNew = new ArrayList<Cceletronica>();
            for (Cceletronica cceletronicaCollectionNewCceletronicaToAttach : cceletronicaCollectionNew) {
                cceletronicaCollectionNewCceletronicaToAttach = em.getReference(cceletronicaCollectionNewCceletronicaToAttach.getClass(), cceletronicaCollectionNewCceletronicaToAttach.getCodcceletronica());
                attachedCceletronicaCollectionNew.add(cceletronicaCollectionNewCceletronicaToAttach);
            }
            cceletronicaCollectionNew = attachedCceletronicaCollectionNew;
            nfeletronica.setCceletronicaCollection(cceletronicaCollectionNew);
            nfeletronica = em.merge(nfeletronica);
            for (Cceletronica cceletronicaCollectionNewCceletronica : cceletronicaCollectionNew) {
                if (!cceletronicaCollectionOld.contains(cceletronicaCollectionNewCceletronica)) {
                    Nfeletronica oldCodnfeletronicaOfCceletronicaCollectionNewCceletronica = cceletronicaCollectionNewCceletronica.getCodnfeletronica();
                    cceletronicaCollectionNewCceletronica.setCodnfeletronica(nfeletronica);
                    cceletronicaCollectionNewCceletronica = em.merge(cceletronicaCollectionNewCceletronica);
                    if (oldCodnfeletronicaOfCceletronicaCollectionNewCceletronica != null && !oldCodnfeletronicaOfCceletronicaCollectionNewCceletronica.equals(nfeletronica)) {
                        oldCodnfeletronicaOfCceletronicaCollectionNewCceletronica.getCceletronicaCollection().remove(cceletronicaCollectionNewCceletronica);
                        oldCodnfeletronicaOfCceletronicaCollectionNewCceletronica = em.merge(oldCodnfeletronicaOfCceletronicaCollectionNewCceletronica);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = nfeletronica.getCodnfeletronica();
                if (findNfeletronica(id) == null) {
                    throw new NonexistentEntityException("The nfeletronica with id " + id + " no longer exists.");
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
            Nfeletronica nfeletronica;
            try {
                nfeletronica = em.getReference(Nfeletronica.class, id);
                nfeletronica.getCodnfeletronica();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nfeletronica with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Cceletronica> cceletronicaCollectionOrphanCheck = nfeletronica.getCceletronicaCollection();
            for (Cceletronica cceletronicaCollectionOrphanCheckCceletronica : cceletronicaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Nfeletronica (" + nfeletronica + ") cannot be destroyed since the Cceletronica " + cceletronicaCollectionOrphanCheckCceletronica + " in its cceletronicaCollection field has a non-nullable codnfeletronica field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(nfeletronica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nfeletronica> findNfeletronicaEntities() {
        return findNfeletronicaEntities(true, -1, -1);
    }

    public List<Nfeletronica> findNfeletronicaEntities(int maxResults, int firstResult) {
        return findNfeletronicaEntities(false, maxResults, firstResult);
    }

    private List<Nfeletronica> findNfeletronicaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nfeletronica.class));
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

    public Nfeletronica findNfeletronica(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nfeletronica.class, id);
        } finally {
            em.close();
        }
    }

    public int getNfeletronicaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nfeletronica> rt = cq.from(Nfeletronica.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

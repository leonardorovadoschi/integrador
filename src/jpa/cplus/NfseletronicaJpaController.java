/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Nfseletronica;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Nfseletronicaerros;
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
public class NfseletronicaJpaController implements Serializable {

    public NfseletronicaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Nfseletronica nfseletronica) throws PreexistingEntityException, Exception {
        if (nfseletronica.getNfseletronicaerrosCollection() == null) {
            nfseletronica.setNfseletronicaerrosCollection(new ArrayList<Nfseletronicaerros>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Nfseletronicaerros> attachedNfseletronicaerrosCollection = new ArrayList<Nfseletronicaerros>();
            for (Nfseletronicaerros nfseletronicaerrosCollectionNfseletronicaerrosToAttach : nfseletronica.getNfseletronicaerrosCollection()) {
                nfseletronicaerrosCollectionNfseletronicaerrosToAttach = em.getReference(nfseletronicaerrosCollectionNfseletronicaerrosToAttach.getClass(), nfseletronicaerrosCollectionNfseletronicaerrosToAttach.getCodnfseletronicaerros());
                attachedNfseletronicaerrosCollection.add(nfseletronicaerrosCollectionNfseletronicaerrosToAttach);
            }
            nfseletronica.setNfseletronicaerrosCollection(attachedNfseletronicaerrosCollection);
            em.persist(nfseletronica);
            for (Nfseletronicaerros nfseletronicaerrosCollectionNfseletronicaerros : nfseletronica.getNfseletronicaerrosCollection()) {
                Nfseletronica oldCodnfseletronicaOfNfseletronicaerrosCollectionNfseletronicaerros = nfseletronicaerrosCollectionNfseletronicaerros.getCodnfseletronica();
                nfseletronicaerrosCollectionNfseletronicaerros.setCodnfseletronica(nfseletronica);
                nfseletronicaerrosCollectionNfseletronicaerros = em.merge(nfseletronicaerrosCollectionNfseletronicaerros);
                if (oldCodnfseletronicaOfNfseletronicaerrosCollectionNfseletronicaerros != null) {
                    oldCodnfseletronicaOfNfseletronicaerrosCollectionNfseletronicaerros.getNfseletronicaerrosCollection().remove(nfseletronicaerrosCollectionNfseletronicaerros);
                    oldCodnfseletronicaOfNfseletronicaerrosCollectionNfseletronicaerros = em.merge(oldCodnfseletronicaOfNfseletronicaerrosCollectionNfseletronicaerros);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNfseletronica(nfseletronica.getCodnfseletronica()) != null) {
                throw new PreexistingEntityException("Nfseletronica " + nfseletronica + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nfseletronica nfseletronica) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nfseletronica persistentNfseletronica = em.find(Nfseletronica.class, nfseletronica.getCodnfseletronica());
            Collection<Nfseletronicaerros> nfseletronicaerrosCollectionOld = persistentNfseletronica.getNfseletronicaerrosCollection();
            Collection<Nfseletronicaerros> nfseletronicaerrosCollectionNew = nfseletronica.getNfseletronicaerrosCollection();
            List<String> illegalOrphanMessages = null;
            for (Nfseletronicaerros nfseletronicaerrosCollectionOldNfseletronicaerros : nfseletronicaerrosCollectionOld) {
                if (!nfseletronicaerrosCollectionNew.contains(nfseletronicaerrosCollectionOldNfseletronicaerros)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Nfseletronicaerros " + nfseletronicaerrosCollectionOldNfseletronicaerros + " since its codnfseletronica field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Nfseletronicaerros> attachedNfseletronicaerrosCollectionNew = new ArrayList<Nfseletronicaerros>();
            for (Nfseletronicaerros nfseletronicaerrosCollectionNewNfseletronicaerrosToAttach : nfseletronicaerrosCollectionNew) {
                nfseletronicaerrosCollectionNewNfseletronicaerrosToAttach = em.getReference(nfseletronicaerrosCollectionNewNfseletronicaerrosToAttach.getClass(), nfseletronicaerrosCollectionNewNfseletronicaerrosToAttach.getCodnfseletronicaerros());
                attachedNfseletronicaerrosCollectionNew.add(nfseletronicaerrosCollectionNewNfseletronicaerrosToAttach);
            }
            nfseletronicaerrosCollectionNew = attachedNfseletronicaerrosCollectionNew;
            nfseletronica.setNfseletronicaerrosCollection(nfseletronicaerrosCollectionNew);
            nfseletronica = em.merge(nfseletronica);
            for (Nfseletronicaerros nfseletronicaerrosCollectionNewNfseletronicaerros : nfseletronicaerrosCollectionNew) {
                if (!nfseletronicaerrosCollectionOld.contains(nfseletronicaerrosCollectionNewNfseletronicaerros)) {
                    Nfseletronica oldCodnfseletronicaOfNfseletronicaerrosCollectionNewNfseletronicaerros = nfseletronicaerrosCollectionNewNfseletronicaerros.getCodnfseletronica();
                    nfseletronicaerrosCollectionNewNfseletronicaerros.setCodnfseletronica(nfseletronica);
                    nfseletronicaerrosCollectionNewNfseletronicaerros = em.merge(nfseletronicaerrosCollectionNewNfseletronicaerros);
                    if (oldCodnfseletronicaOfNfseletronicaerrosCollectionNewNfseletronicaerros != null && !oldCodnfseletronicaOfNfseletronicaerrosCollectionNewNfseletronicaerros.equals(nfseletronica)) {
                        oldCodnfseletronicaOfNfseletronicaerrosCollectionNewNfseletronicaerros.getNfseletronicaerrosCollection().remove(nfseletronicaerrosCollectionNewNfseletronicaerros);
                        oldCodnfseletronicaOfNfseletronicaerrosCollectionNewNfseletronicaerros = em.merge(oldCodnfseletronicaOfNfseletronicaerrosCollectionNewNfseletronicaerros);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = nfseletronica.getCodnfseletronica();
                if (findNfseletronica(id) == null) {
                    throw new NonexistentEntityException("The nfseletronica with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nfseletronica nfseletronica;
            try {
                nfseletronica = em.getReference(Nfseletronica.class, id);
                nfseletronica.getCodnfseletronica();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nfseletronica with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Nfseletronicaerros> nfseletronicaerrosCollectionOrphanCheck = nfseletronica.getNfseletronicaerrosCollection();
            for (Nfseletronicaerros nfseletronicaerrosCollectionOrphanCheckNfseletronicaerros : nfseletronicaerrosCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Nfseletronica (" + nfseletronica + ") cannot be destroyed since the Nfseletronicaerros " + nfseletronicaerrosCollectionOrphanCheckNfseletronicaerros + " in its nfseletronicaerrosCollection field has a non-nullable codnfseletronica field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(nfseletronica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nfseletronica> findNfseletronicaEntities() {
        return findNfseletronicaEntities(true, -1, -1);
    }

    public List<Nfseletronica> findNfseletronicaEntities(int maxResults, int firstResult) {
        return findNfseletronicaEntities(false, maxResults, firstResult);
    }

    private List<Nfseletronica> findNfseletronicaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nfseletronica.class));
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

    public Nfseletronica findNfseletronica(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nfseletronica.class, id);
        } finally {
            em.close();
        }
    }

    public int getNfseletronicaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nfseletronica> rt = cq.from(Nfseletronica.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

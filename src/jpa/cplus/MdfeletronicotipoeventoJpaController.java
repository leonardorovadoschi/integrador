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
import entidade.cplus.Mdfeletronicoevento;
import entidade.cplus.Mdfeletronicotipoevento;
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
public class MdfeletronicotipoeventoJpaController implements Serializable {

    public MdfeletronicotipoeventoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mdfeletronicotipoevento mdfeletronicotipoevento) throws PreexistingEntityException, Exception {
        if (mdfeletronicotipoevento.getMdfeletronicoeventoCollection() == null) {
            mdfeletronicotipoevento.setMdfeletronicoeventoCollection(new ArrayList<Mdfeletronicoevento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Mdfeletronicoevento> attachedMdfeletronicoeventoCollection = new ArrayList<Mdfeletronicoevento>();
            for (Mdfeletronicoevento mdfeletronicoeventoCollectionMdfeletronicoeventoToAttach : mdfeletronicotipoevento.getMdfeletronicoeventoCollection()) {
                mdfeletronicoeventoCollectionMdfeletronicoeventoToAttach = em.getReference(mdfeletronicoeventoCollectionMdfeletronicoeventoToAttach.getClass(), mdfeletronicoeventoCollectionMdfeletronicoeventoToAttach.getCodmdfeletronicoevento());
                attachedMdfeletronicoeventoCollection.add(mdfeletronicoeventoCollectionMdfeletronicoeventoToAttach);
            }
            mdfeletronicotipoevento.setMdfeletronicoeventoCollection(attachedMdfeletronicoeventoCollection);
            em.persist(mdfeletronicotipoevento);
            for (Mdfeletronicoevento mdfeletronicoeventoCollectionMdfeletronicoevento : mdfeletronicotipoevento.getMdfeletronicoeventoCollection()) {
                Mdfeletronicotipoevento oldCodmdfeletronicotipoeventoOfMdfeletronicoeventoCollectionMdfeletronicoevento = mdfeletronicoeventoCollectionMdfeletronicoevento.getCodmdfeletronicotipoevento();
                mdfeletronicoeventoCollectionMdfeletronicoevento.setCodmdfeletronicotipoevento(mdfeletronicotipoevento);
                mdfeletronicoeventoCollectionMdfeletronicoevento = em.merge(mdfeletronicoeventoCollectionMdfeletronicoevento);
                if (oldCodmdfeletronicotipoeventoOfMdfeletronicoeventoCollectionMdfeletronicoevento != null) {
                    oldCodmdfeletronicotipoeventoOfMdfeletronicoeventoCollectionMdfeletronicoevento.getMdfeletronicoeventoCollection().remove(mdfeletronicoeventoCollectionMdfeletronicoevento);
                    oldCodmdfeletronicotipoeventoOfMdfeletronicoeventoCollectionMdfeletronicoevento = em.merge(oldCodmdfeletronicotipoeventoOfMdfeletronicoeventoCollectionMdfeletronicoevento);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMdfeletronicotipoevento(mdfeletronicotipoevento.getCodmdfeletronicotipoevento()) != null) {
                throw new PreexistingEntityException("Mdfeletronicotipoevento " + mdfeletronicotipoevento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mdfeletronicotipoevento mdfeletronicotipoevento) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mdfeletronicotipoevento persistentMdfeletronicotipoevento = em.find(Mdfeletronicotipoevento.class, mdfeletronicotipoevento.getCodmdfeletronicotipoevento());
            Collection<Mdfeletronicoevento> mdfeletronicoeventoCollectionOld = persistentMdfeletronicotipoevento.getMdfeletronicoeventoCollection();
            Collection<Mdfeletronicoevento> mdfeletronicoeventoCollectionNew = mdfeletronicotipoevento.getMdfeletronicoeventoCollection();
            List<String> illegalOrphanMessages = null;
            for (Mdfeletronicoevento mdfeletronicoeventoCollectionOldMdfeletronicoevento : mdfeletronicoeventoCollectionOld) {
                if (!mdfeletronicoeventoCollectionNew.contains(mdfeletronicoeventoCollectionOldMdfeletronicoevento)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Mdfeletronicoevento " + mdfeletronicoeventoCollectionOldMdfeletronicoevento + " since its codmdfeletronicotipoevento field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Mdfeletronicoevento> attachedMdfeletronicoeventoCollectionNew = new ArrayList<Mdfeletronicoevento>();
            for (Mdfeletronicoevento mdfeletronicoeventoCollectionNewMdfeletronicoeventoToAttach : mdfeletronicoeventoCollectionNew) {
                mdfeletronicoeventoCollectionNewMdfeletronicoeventoToAttach = em.getReference(mdfeletronicoeventoCollectionNewMdfeletronicoeventoToAttach.getClass(), mdfeletronicoeventoCollectionNewMdfeletronicoeventoToAttach.getCodmdfeletronicoevento());
                attachedMdfeletronicoeventoCollectionNew.add(mdfeletronicoeventoCollectionNewMdfeletronicoeventoToAttach);
            }
            mdfeletronicoeventoCollectionNew = attachedMdfeletronicoeventoCollectionNew;
            mdfeletronicotipoevento.setMdfeletronicoeventoCollection(mdfeletronicoeventoCollectionNew);
            mdfeletronicotipoevento = em.merge(mdfeletronicotipoevento);
            for (Mdfeletronicoevento mdfeletronicoeventoCollectionNewMdfeletronicoevento : mdfeletronicoeventoCollectionNew) {
                if (!mdfeletronicoeventoCollectionOld.contains(mdfeletronicoeventoCollectionNewMdfeletronicoevento)) {
                    Mdfeletronicotipoevento oldCodmdfeletronicotipoeventoOfMdfeletronicoeventoCollectionNewMdfeletronicoevento = mdfeletronicoeventoCollectionNewMdfeletronicoevento.getCodmdfeletronicotipoevento();
                    mdfeletronicoeventoCollectionNewMdfeletronicoevento.setCodmdfeletronicotipoevento(mdfeletronicotipoevento);
                    mdfeletronicoeventoCollectionNewMdfeletronicoevento = em.merge(mdfeletronicoeventoCollectionNewMdfeletronicoevento);
                    if (oldCodmdfeletronicotipoeventoOfMdfeletronicoeventoCollectionNewMdfeletronicoevento != null && !oldCodmdfeletronicotipoeventoOfMdfeletronicoeventoCollectionNewMdfeletronicoevento.equals(mdfeletronicotipoevento)) {
                        oldCodmdfeletronicotipoeventoOfMdfeletronicoeventoCollectionNewMdfeletronicoevento.getMdfeletronicoeventoCollection().remove(mdfeletronicoeventoCollectionNewMdfeletronicoevento);
                        oldCodmdfeletronicotipoeventoOfMdfeletronicoeventoCollectionNewMdfeletronicoevento = em.merge(oldCodmdfeletronicotipoeventoOfMdfeletronicoeventoCollectionNewMdfeletronicoevento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = mdfeletronicotipoevento.getCodmdfeletronicotipoevento();
                if (findMdfeletronicotipoevento(id) == null) {
                    throw new NonexistentEntityException("The mdfeletronicotipoevento with id " + id + " no longer exists.");
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
            Mdfeletronicotipoevento mdfeletronicotipoevento;
            try {
                mdfeletronicotipoevento = em.getReference(Mdfeletronicotipoevento.class, id);
                mdfeletronicotipoevento.getCodmdfeletronicotipoevento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mdfeletronicotipoevento with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Mdfeletronicoevento> mdfeletronicoeventoCollectionOrphanCheck = mdfeletronicotipoevento.getMdfeletronicoeventoCollection();
            for (Mdfeletronicoevento mdfeletronicoeventoCollectionOrphanCheckMdfeletronicoevento : mdfeletronicoeventoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Mdfeletronicotipoevento (" + mdfeletronicotipoevento + ") cannot be destroyed since the Mdfeletronicoevento " + mdfeletronicoeventoCollectionOrphanCheckMdfeletronicoevento + " in its mdfeletronicoeventoCollection field has a non-nullable codmdfeletronicotipoevento field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(mdfeletronicotipoevento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mdfeletronicotipoevento> findMdfeletronicotipoeventoEntities() {
        return findMdfeletronicotipoeventoEntities(true, -1, -1);
    }

    public List<Mdfeletronicotipoevento> findMdfeletronicotipoeventoEntities(int maxResults, int firstResult) {
        return findMdfeletronicotipoeventoEntities(false, maxResults, firstResult);
    }

    private List<Mdfeletronicotipoevento> findMdfeletronicotipoeventoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mdfeletronicotipoevento.class));
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

    public Mdfeletronicotipoevento findMdfeletronicotipoevento(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mdfeletronicotipoevento.class, id);
        } finally {
            em.close();
        }
    }

    public int getMdfeletronicotipoeventoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mdfeletronicotipoevento> rt = cq.from(Mdfeletronicotipoevento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

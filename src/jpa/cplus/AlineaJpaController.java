/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Alinea;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Cheques;
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
public class AlineaJpaController implements Serializable {

    public AlineaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Alinea alinea) throws PreexistingEntityException, Exception {
        if (alinea.getChequesCollection() == null) {
            alinea.setChequesCollection(new ArrayList<Cheques>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Cheques> attachedChequesCollection = new ArrayList<Cheques>();
            for (Cheques chequesCollectionChequesToAttach : alinea.getChequesCollection()) {
                chequesCollectionChequesToAttach = em.getReference(chequesCollectionChequesToAttach.getClass(), chequesCollectionChequesToAttach.getCodcheque());
                attachedChequesCollection.add(chequesCollectionChequesToAttach);
            }
            alinea.setChequesCollection(attachedChequesCollection);
            em.persist(alinea);
            for (Cheques chequesCollectionCheques : alinea.getChequesCollection()) {
                Alinea oldCodalineaOfChequesCollectionCheques = chequesCollectionCheques.getCodalinea();
                chequesCollectionCheques.setCodalinea(alinea);
                chequesCollectionCheques = em.merge(chequesCollectionCheques);
                if (oldCodalineaOfChequesCollectionCheques != null) {
                    oldCodalineaOfChequesCollectionCheques.getChequesCollection().remove(chequesCollectionCheques);
                    oldCodalineaOfChequesCollectionCheques = em.merge(oldCodalineaOfChequesCollectionCheques);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAlinea(alinea.getCodalinea()) != null) {
                throw new PreexistingEntityException("Alinea " + alinea + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Alinea alinea) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alinea persistentAlinea = em.find(Alinea.class, alinea.getCodalinea());
            Collection<Cheques> chequesCollectionOld = persistentAlinea.getChequesCollection();
            Collection<Cheques> chequesCollectionNew = alinea.getChequesCollection();
            Collection<Cheques> attachedChequesCollectionNew = new ArrayList<Cheques>();
            for (Cheques chequesCollectionNewChequesToAttach : chequesCollectionNew) {
                chequesCollectionNewChequesToAttach = em.getReference(chequesCollectionNewChequesToAttach.getClass(), chequesCollectionNewChequesToAttach.getCodcheque());
                attachedChequesCollectionNew.add(chequesCollectionNewChequesToAttach);
            }
            chequesCollectionNew = attachedChequesCollectionNew;
            alinea.setChequesCollection(chequesCollectionNew);
            alinea = em.merge(alinea);
            for (Cheques chequesCollectionOldCheques : chequesCollectionOld) {
                if (!chequesCollectionNew.contains(chequesCollectionOldCheques)) {
                    chequesCollectionOldCheques.setCodalinea(null);
                    chequesCollectionOldCheques = em.merge(chequesCollectionOldCheques);
                }
            }
            for (Cheques chequesCollectionNewCheques : chequesCollectionNew) {
                if (!chequesCollectionOld.contains(chequesCollectionNewCheques)) {
                    Alinea oldCodalineaOfChequesCollectionNewCheques = chequesCollectionNewCheques.getCodalinea();
                    chequesCollectionNewCheques.setCodalinea(alinea);
                    chequesCollectionNewCheques = em.merge(chequesCollectionNewCheques);
                    if (oldCodalineaOfChequesCollectionNewCheques != null && !oldCodalineaOfChequesCollectionNewCheques.equals(alinea)) {
                        oldCodalineaOfChequesCollectionNewCheques.getChequesCollection().remove(chequesCollectionNewCheques);
                        oldCodalineaOfChequesCollectionNewCheques = em.merge(oldCodalineaOfChequesCollectionNewCheques);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = alinea.getCodalinea();
                if (findAlinea(id) == null) {
                    throw new NonexistentEntityException("The alinea with id " + id + " no longer exists.");
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
            Alinea alinea;
            try {
                alinea = em.getReference(Alinea.class, id);
                alinea.getCodalinea();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alinea with id " + id + " no longer exists.", enfe);
            }
            Collection<Cheques> chequesCollection = alinea.getChequesCollection();
            for (Cheques chequesCollectionCheques : chequesCollection) {
                chequesCollectionCheques.setCodalinea(null);
                chequesCollectionCheques = em.merge(chequesCollectionCheques);
            }
            em.remove(alinea);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Alinea> findAlineaEntities() {
        return findAlineaEntities(true, -1, -1);
    }

    public List<Alinea> findAlineaEntities(int maxResults, int firstResult) {
        return findAlineaEntities(false, maxResults, firstResult);
    }

    private List<Alinea> findAlineaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Alinea.class));
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

    public Alinea findAlinea(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Alinea.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlineaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Alinea> rt = cq.from(Alinea.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
import entidade.cplus.Sat;
import entidade.cplus.Satmarca;
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
public class SatmarcaJpaController implements Serializable {

    public SatmarcaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Satmarca satmarca) throws PreexistingEntityException, Exception {
        if (satmarca.getSatCollection() == null) {
            satmarca.setSatCollection(new ArrayList<Sat>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Sat> attachedSatCollection = new ArrayList<Sat>();
            for (Sat satCollectionSatToAttach : satmarca.getSatCollection()) {
                satCollectionSatToAttach = em.getReference(satCollectionSatToAttach.getClass(), satCollectionSatToAttach.getCodsat());
                attachedSatCollection.add(satCollectionSatToAttach);
            }
            satmarca.setSatCollection(attachedSatCollection);
            em.persist(satmarca);
            for (Sat satCollectionSat : satmarca.getSatCollection()) {
                Satmarca oldCodsatmarcaOfSatCollectionSat = satCollectionSat.getCodsatmarca();
                satCollectionSat.setCodsatmarca(satmarca);
                satCollectionSat = em.merge(satCollectionSat);
                if (oldCodsatmarcaOfSatCollectionSat != null) {
                    oldCodsatmarcaOfSatCollectionSat.getSatCollection().remove(satCollectionSat);
                    oldCodsatmarcaOfSatCollectionSat = em.merge(oldCodsatmarcaOfSatCollectionSat);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSatmarca(satmarca.getCodsatmarca()) != null) {
                throw new PreexistingEntityException("Satmarca " + satmarca + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Satmarca satmarca) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Satmarca persistentSatmarca = em.find(Satmarca.class, satmarca.getCodsatmarca());
            Collection<Sat> satCollectionOld = persistentSatmarca.getSatCollection();
            Collection<Sat> satCollectionNew = satmarca.getSatCollection();
            Collection<Sat> attachedSatCollectionNew = new ArrayList<Sat>();
            for (Sat satCollectionNewSatToAttach : satCollectionNew) {
                satCollectionNewSatToAttach = em.getReference(satCollectionNewSatToAttach.getClass(), satCollectionNewSatToAttach.getCodsat());
                attachedSatCollectionNew.add(satCollectionNewSatToAttach);
            }
            satCollectionNew = attachedSatCollectionNew;
            satmarca.setSatCollection(satCollectionNew);
            satmarca = em.merge(satmarca);
            for (Sat satCollectionOldSat : satCollectionOld) {
                if (!satCollectionNew.contains(satCollectionOldSat)) {
                    satCollectionOldSat.setCodsatmarca(null);
                    satCollectionOldSat = em.merge(satCollectionOldSat);
                }
            }
            for (Sat satCollectionNewSat : satCollectionNew) {
                if (!satCollectionOld.contains(satCollectionNewSat)) {
                    Satmarca oldCodsatmarcaOfSatCollectionNewSat = satCollectionNewSat.getCodsatmarca();
                    satCollectionNewSat.setCodsatmarca(satmarca);
                    satCollectionNewSat = em.merge(satCollectionNewSat);
                    if (oldCodsatmarcaOfSatCollectionNewSat != null && !oldCodsatmarcaOfSatCollectionNewSat.equals(satmarca)) {
                        oldCodsatmarcaOfSatCollectionNewSat.getSatCollection().remove(satCollectionNewSat);
                        oldCodsatmarcaOfSatCollectionNewSat = em.merge(oldCodsatmarcaOfSatCollectionNewSat);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = satmarca.getCodsatmarca();
                if (findSatmarca(id) == null) {
                    throw new NonexistentEntityException("The satmarca with id " + id + " no longer exists.");
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
            Satmarca satmarca;
            try {
                satmarca = em.getReference(Satmarca.class, id);
                satmarca.getCodsatmarca();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The satmarca with id " + id + " no longer exists.", enfe);
            }
            Collection<Sat> satCollection = satmarca.getSatCollection();
            for (Sat satCollectionSat : satCollection) {
                satCollectionSat.setCodsatmarca(null);
                satCollectionSat = em.merge(satCollectionSat);
            }
            em.remove(satmarca);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Satmarca> findSatmarcaEntities() {
        return findSatmarcaEntities(true, -1, -1);
    }

    public List<Satmarca> findSatmarcaEntities(int maxResults, int firstResult) {
        return findSatmarcaEntities(false, maxResults, firstResult);
    }

    private List<Satmarca> findSatmarcaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Satmarca.class));
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

    public Satmarca findSatmarca(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Satmarca.class, id);
        } finally {
            em.close();
        }
    }

    public int getSatmarcaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Satmarca> rt = cq.from(Satmarca.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

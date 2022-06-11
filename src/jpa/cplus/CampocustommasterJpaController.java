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
import entidade.cplus.Campocustomvalor;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Campocustomlista;
import entidade.cplus.Campocustommaster;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class CampocustommasterJpaController implements Serializable {

    public CampocustommasterJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Campocustommaster campocustommaster) throws PreexistingEntityException, Exception {
        if (campocustommaster.getCampocustomvalorCollection() == null) {
            campocustommaster.setCampocustomvalorCollection(new ArrayList<Campocustomvalor>());
        }
        if (campocustommaster.getCampocustomlistaCollection() == null) {
            campocustommaster.setCampocustomlistaCollection(new ArrayList<Campocustomlista>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Campocustomvalor> attachedCampocustomvalorCollection = new ArrayList<Campocustomvalor>();
            for (Campocustomvalor campocustomvalorCollectionCampocustomvalorToAttach : campocustommaster.getCampocustomvalorCollection()) {
                campocustomvalorCollectionCampocustomvalorToAttach = em.getReference(campocustomvalorCollectionCampocustomvalorToAttach.getClass(), campocustomvalorCollectionCampocustomvalorToAttach.getCodcampocustomvalor());
                attachedCampocustomvalorCollection.add(campocustomvalorCollectionCampocustomvalorToAttach);
            }
            campocustommaster.setCampocustomvalorCollection(attachedCampocustomvalorCollection);
            Collection<Campocustomlista> attachedCampocustomlistaCollection = new ArrayList<Campocustomlista>();
            for (Campocustomlista campocustomlistaCollectionCampocustomlistaToAttach : campocustommaster.getCampocustomlistaCollection()) {
                campocustomlistaCollectionCampocustomlistaToAttach = em.getReference(campocustomlistaCollectionCampocustomlistaToAttach.getClass(), campocustomlistaCollectionCampocustomlistaToAttach.getCodcampocustomlista());
                attachedCampocustomlistaCollection.add(campocustomlistaCollectionCampocustomlistaToAttach);
            }
            campocustommaster.setCampocustomlistaCollection(attachedCampocustomlistaCollection);
            em.persist(campocustommaster);
            for (Campocustomvalor campocustomvalorCollectionCampocustomvalor : campocustommaster.getCampocustomvalorCollection()) {
                Campocustommaster oldCodcampocustommasterOfCampocustomvalorCollectionCampocustomvalor = campocustomvalorCollectionCampocustomvalor.getCodcampocustommaster();
                campocustomvalorCollectionCampocustomvalor.setCodcampocustommaster(campocustommaster);
                campocustomvalorCollectionCampocustomvalor = em.merge(campocustomvalorCollectionCampocustomvalor);
                if (oldCodcampocustommasterOfCampocustomvalorCollectionCampocustomvalor != null) {
                    oldCodcampocustommasterOfCampocustomvalorCollectionCampocustomvalor.getCampocustomvalorCollection().remove(campocustomvalorCollectionCampocustomvalor);
                    oldCodcampocustommasterOfCampocustomvalorCollectionCampocustomvalor = em.merge(oldCodcampocustommasterOfCampocustomvalorCollectionCampocustomvalor);
                }
            }
            for (Campocustomlista campocustomlistaCollectionCampocustomlista : campocustommaster.getCampocustomlistaCollection()) {
                Campocustommaster oldCodcampocustommasterOfCampocustomlistaCollectionCampocustomlista = campocustomlistaCollectionCampocustomlista.getCodcampocustommaster();
                campocustomlistaCollectionCampocustomlista.setCodcampocustommaster(campocustommaster);
                campocustomlistaCollectionCampocustomlista = em.merge(campocustomlistaCollectionCampocustomlista);
                if (oldCodcampocustommasterOfCampocustomlistaCollectionCampocustomlista != null) {
                    oldCodcampocustommasterOfCampocustomlistaCollectionCampocustomlista.getCampocustomlistaCollection().remove(campocustomlistaCollectionCampocustomlista);
                    oldCodcampocustommasterOfCampocustomlistaCollectionCampocustomlista = em.merge(oldCodcampocustommasterOfCampocustomlistaCollectionCampocustomlista);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCampocustommaster(campocustommaster.getCodcampocustommaster()) != null) {
                throw new PreexistingEntityException("Campocustommaster " + campocustommaster + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Campocustommaster campocustommaster) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Campocustommaster persistentCampocustommaster = em.find(Campocustommaster.class, campocustommaster.getCodcampocustommaster());
            Collection<Campocustomvalor> campocustomvalorCollectionOld = persistentCampocustommaster.getCampocustomvalorCollection();
            Collection<Campocustomvalor> campocustomvalorCollectionNew = campocustommaster.getCampocustomvalorCollection();
            Collection<Campocustomlista> campocustomlistaCollectionOld = persistentCampocustommaster.getCampocustomlistaCollection();
            Collection<Campocustomlista> campocustomlistaCollectionNew = campocustommaster.getCampocustomlistaCollection();
            Collection<Campocustomvalor> attachedCampocustomvalorCollectionNew = new ArrayList<Campocustomvalor>();
            for (Campocustomvalor campocustomvalorCollectionNewCampocustomvalorToAttach : campocustomvalorCollectionNew) {
                campocustomvalorCollectionNewCampocustomvalorToAttach = em.getReference(campocustomvalorCollectionNewCampocustomvalorToAttach.getClass(), campocustomvalorCollectionNewCampocustomvalorToAttach.getCodcampocustomvalor());
                attachedCampocustomvalorCollectionNew.add(campocustomvalorCollectionNewCampocustomvalorToAttach);
            }
            campocustomvalorCollectionNew = attachedCampocustomvalorCollectionNew;
            campocustommaster.setCampocustomvalorCollection(campocustomvalorCollectionNew);
            Collection<Campocustomlista> attachedCampocustomlistaCollectionNew = new ArrayList<Campocustomlista>();
            for (Campocustomlista campocustomlistaCollectionNewCampocustomlistaToAttach : campocustomlistaCollectionNew) {
                campocustomlistaCollectionNewCampocustomlistaToAttach = em.getReference(campocustomlistaCollectionNewCampocustomlistaToAttach.getClass(), campocustomlistaCollectionNewCampocustomlistaToAttach.getCodcampocustomlista());
                attachedCampocustomlistaCollectionNew.add(campocustomlistaCollectionNewCampocustomlistaToAttach);
            }
            campocustomlistaCollectionNew = attachedCampocustomlistaCollectionNew;
            campocustommaster.setCampocustomlistaCollection(campocustomlistaCollectionNew);
            campocustommaster = em.merge(campocustommaster);
            for (Campocustomvalor campocustomvalorCollectionOldCampocustomvalor : campocustomvalorCollectionOld) {
                if (!campocustomvalorCollectionNew.contains(campocustomvalorCollectionOldCampocustomvalor)) {
                    campocustomvalorCollectionOldCampocustomvalor.setCodcampocustommaster(null);
                    campocustomvalorCollectionOldCampocustomvalor = em.merge(campocustomvalorCollectionOldCampocustomvalor);
                }
            }
            for (Campocustomvalor campocustomvalorCollectionNewCampocustomvalor : campocustomvalorCollectionNew) {
                if (!campocustomvalorCollectionOld.contains(campocustomvalorCollectionNewCampocustomvalor)) {
                    Campocustommaster oldCodcampocustommasterOfCampocustomvalorCollectionNewCampocustomvalor = campocustomvalorCollectionNewCampocustomvalor.getCodcampocustommaster();
                    campocustomvalorCollectionNewCampocustomvalor.setCodcampocustommaster(campocustommaster);
                    campocustomvalorCollectionNewCampocustomvalor = em.merge(campocustomvalorCollectionNewCampocustomvalor);
                    if (oldCodcampocustommasterOfCampocustomvalorCollectionNewCampocustomvalor != null && !oldCodcampocustommasterOfCampocustomvalorCollectionNewCampocustomvalor.equals(campocustommaster)) {
                        oldCodcampocustommasterOfCampocustomvalorCollectionNewCampocustomvalor.getCampocustomvalorCollection().remove(campocustomvalorCollectionNewCampocustomvalor);
                        oldCodcampocustommasterOfCampocustomvalorCollectionNewCampocustomvalor = em.merge(oldCodcampocustommasterOfCampocustomvalorCollectionNewCampocustomvalor);
                    }
                }
            }
            for (Campocustomlista campocustomlistaCollectionOldCampocustomlista : campocustomlistaCollectionOld) {
                if (!campocustomlistaCollectionNew.contains(campocustomlistaCollectionOldCampocustomlista)) {
                    campocustomlistaCollectionOldCampocustomlista.setCodcampocustommaster(null);
                    campocustomlistaCollectionOldCampocustomlista = em.merge(campocustomlistaCollectionOldCampocustomlista);
                }
            }
            for (Campocustomlista campocustomlistaCollectionNewCampocustomlista : campocustomlistaCollectionNew) {
                if (!campocustomlistaCollectionOld.contains(campocustomlistaCollectionNewCampocustomlista)) {
                    Campocustommaster oldCodcampocustommasterOfCampocustomlistaCollectionNewCampocustomlista = campocustomlistaCollectionNewCampocustomlista.getCodcampocustommaster();
                    campocustomlistaCollectionNewCampocustomlista.setCodcampocustommaster(campocustommaster);
                    campocustomlistaCollectionNewCampocustomlista = em.merge(campocustomlistaCollectionNewCampocustomlista);
                    if (oldCodcampocustommasterOfCampocustomlistaCollectionNewCampocustomlista != null && !oldCodcampocustommasterOfCampocustomlistaCollectionNewCampocustomlista.equals(campocustommaster)) {
                        oldCodcampocustommasterOfCampocustomlistaCollectionNewCampocustomlista.getCampocustomlistaCollection().remove(campocustomlistaCollectionNewCampocustomlista);
                        oldCodcampocustommasterOfCampocustomlistaCollectionNewCampocustomlista = em.merge(oldCodcampocustommasterOfCampocustomlistaCollectionNewCampocustomlista);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = campocustommaster.getCodcampocustommaster();
                if (findCampocustommaster(id) == null) {
                    throw new NonexistentEntityException("The campocustommaster with id " + id + " no longer exists.");
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
            Campocustommaster campocustommaster;
            try {
                campocustommaster = em.getReference(Campocustommaster.class, id);
                campocustommaster.getCodcampocustommaster();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The campocustommaster with id " + id + " no longer exists.", enfe);
            }
            Collection<Campocustomvalor> campocustomvalorCollection = campocustommaster.getCampocustomvalorCollection();
            for (Campocustomvalor campocustomvalorCollectionCampocustomvalor : campocustomvalorCollection) {
                campocustomvalorCollectionCampocustomvalor.setCodcampocustommaster(null);
                campocustomvalorCollectionCampocustomvalor = em.merge(campocustomvalorCollectionCampocustomvalor);
            }
            Collection<Campocustomlista> campocustomlistaCollection = campocustommaster.getCampocustomlistaCollection();
            for (Campocustomlista campocustomlistaCollectionCampocustomlista : campocustomlistaCollection) {
                campocustomlistaCollectionCampocustomlista.setCodcampocustommaster(null);
                campocustomlistaCollectionCampocustomlista = em.merge(campocustomlistaCollectionCampocustomlista);
            }
            em.remove(campocustommaster);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Campocustommaster> findCampocustommasterEntities() {
        return findCampocustommasterEntities(true, -1, -1);
    }

    public List<Campocustommaster> findCampocustommasterEntities(int maxResults, int firstResult) {
        return findCampocustommasterEntities(false, maxResults, firstResult);
    }

    private List<Campocustommaster> findCampocustommasterEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Campocustommaster.class));
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

    public Campocustommaster findCampocustommaster(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Campocustommaster.class, id);
        } finally {
            em.close();
        }
    }

    public int getCampocustommasterCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Campocustommaster> rt = cq.from(Campocustommaster.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

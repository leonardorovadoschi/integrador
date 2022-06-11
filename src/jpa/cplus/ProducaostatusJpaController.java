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
import entidade.cplus.Producaohistorico;
import entidade.cplus.Producaostatus;
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
public class ProducaostatusJpaController implements Serializable {

    public ProducaostatusJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producaostatus producaostatus) throws PreexistingEntityException, Exception {
        if (producaostatus.getProducaohistoricoCollection() == null) {
            producaostatus.setProducaohistoricoCollection(new ArrayList<Producaohistorico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Producaohistorico> attachedProducaohistoricoCollection = new ArrayList<Producaohistorico>();
            for (Producaohistorico producaohistoricoCollectionProducaohistoricoToAttach : producaostatus.getProducaohistoricoCollection()) {
                producaohistoricoCollectionProducaohistoricoToAttach = em.getReference(producaohistoricoCollectionProducaohistoricoToAttach.getClass(), producaohistoricoCollectionProducaohistoricoToAttach.getCodproducaohistorico());
                attachedProducaohistoricoCollection.add(producaohistoricoCollectionProducaohistoricoToAttach);
            }
            producaostatus.setProducaohistoricoCollection(attachedProducaohistoricoCollection);
            em.persist(producaostatus);
            for (Producaohistorico producaohistoricoCollectionProducaohistorico : producaostatus.getProducaohistoricoCollection()) {
                Producaostatus oldCodproducaostatusOfProducaohistoricoCollectionProducaohistorico = producaohistoricoCollectionProducaohistorico.getCodproducaostatus();
                producaohistoricoCollectionProducaohistorico.setCodproducaostatus(producaostatus);
                producaohistoricoCollectionProducaohistorico = em.merge(producaohistoricoCollectionProducaohistorico);
                if (oldCodproducaostatusOfProducaohistoricoCollectionProducaohistorico != null) {
                    oldCodproducaostatusOfProducaohistoricoCollectionProducaohistorico.getProducaohistoricoCollection().remove(producaohistoricoCollectionProducaohistorico);
                    oldCodproducaostatusOfProducaohistoricoCollectionProducaohistorico = em.merge(oldCodproducaostatusOfProducaohistoricoCollectionProducaohistorico);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProducaostatus(producaostatus.getCodproducaostatus()) != null) {
                throw new PreexistingEntityException("Producaostatus " + producaostatus + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producaostatus producaostatus) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producaostatus persistentProducaostatus = em.find(Producaostatus.class, producaostatus.getCodproducaostatus());
            Collection<Producaohistorico> producaohistoricoCollectionOld = persistentProducaostatus.getProducaohistoricoCollection();
            Collection<Producaohistorico> producaohistoricoCollectionNew = producaostatus.getProducaohistoricoCollection();
            List<String> illegalOrphanMessages = null;
            for (Producaohistorico producaohistoricoCollectionOldProducaohistorico : producaohistoricoCollectionOld) {
                if (!producaohistoricoCollectionNew.contains(producaohistoricoCollectionOldProducaohistorico)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Producaohistorico " + producaohistoricoCollectionOldProducaohistorico + " since its codproducaostatus field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Producaohistorico> attachedProducaohistoricoCollectionNew = new ArrayList<Producaohistorico>();
            for (Producaohistorico producaohistoricoCollectionNewProducaohistoricoToAttach : producaohistoricoCollectionNew) {
                producaohistoricoCollectionNewProducaohistoricoToAttach = em.getReference(producaohistoricoCollectionNewProducaohistoricoToAttach.getClass(), producaohistoricoCollectionNewProducaohistoricoToAttach.getCodproducaohistorico());
                attachedProducaohistoricoCollectionNew.add(producaohistoricoCollectionNewProducaohistoricoToAttach);
            }
            producaohistoricoCollectionNew = attachedProducaohistoricoCollectionNew;
            producaostatus.setProducaohistoricoCollection(producaohistoricoCollectionNew);
            producaostatus = em.merge(producaostatus);
            for (Producaohistorico producaohistoricoCollectionNewProducaohistorico : producaohistoricoCollectionNew) {
                if (!producaohistoricoCollectionOld.contains(producaohistoricoCollectionNewProducaohistorico)) {
                    Producaostatus oldCodproducaostatusOfProducaohistoricoCollectionNewProducaohistorico = producaohistoricoCollectionNewProducaohistorico.getCodproducaostatus();
                    producaohistoricoCollectionNewProducaohistorico.setCodproducaostatus(producaostatus);
                    producaohistoricoCollectionNewProducaohistorico = em.merge(producaohistoricoCollectionNewProducaohistorico);
                    if (oldCodproducaostatusOfProducaohistoricoCollectionNewProducaohistorico != null && !oldCodproducaostatusOfProducaohistoricoCollectionNewProducaohistorico.equals(producaostatus)) {
                        oldCodproducaostatusOfProducaohistoricoCollectionNewProducaohistorico.getProducaohistoricoCollection().remove(producaohistoricoCollectionNewProducaohistorico);
                        oldCodproducaostatusOfProducaohistoricoCollectionNewProducaohistorico = em.merge(oldCodproducaostatusOfProducaohistoricoCollectionNewProducaohistorico);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = producaostatus.getCodproducaostatus();
                if (findProducaostatus(id) == null) {
                    throw new NonexistentEntityException("The producaostatus with id " + id + " no longer exists.");
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
            Producaostatus producaostatus;
            try {
                producaostatus = em.getReference(Producaostatus.class, id);
                producaostatus.getCodproducaostatus();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producaostatus with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Producaohistorico> producaohistoricoCollectionOrphanCheck = producaostatus.getProducaohistoricoCollection();
            for (Producaohistorico producaohistoricoCollectionOrphanCheckProducaohistorico : producaohistoricoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Producaostatus (" + producaostatus + ") cannot be destroyed since the Producaohistorico " + producaohistoricoCollectionOrphanCheckProducaohistorico + " in its producaohistoricoCollection field has a non-nullable codproducaostatus field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(producaostatus);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producaostatus> findProducaostatusEntities() {
        return findProducaostatusEntities(true, -1, -1);
    }

    public List<Producaostatus> findProducaostatusEntities(int maxResults, int firstResult) {
        return findProducaostatusEntities(false, maxResults, firstResult);
    }

    private List<Producaostatus> findProducaostatusEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producaostatus.class));
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

    public Producaostatus findProducaostatus(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producaostatus.class, id);
        } finally {
            em.close();
        }
    }

    public int getProducaostatusCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producaostatus> rt = cq.from(Producaostatus.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

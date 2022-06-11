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
import entidade.cplus.Bico;
import entidade.cplus.Tanque;
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
public class TanqueJpaController implements Serializable {

    public TanqueJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tanque tanque) throws PreexistingEntityException, Exception {
        if (tanque.getBicoCollection() == null) {
            tanque.setBicoCollection(new ArrayList<Bico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Bico> attachedBicoCollection = new ArrayList<Bico>();
            for (Bico bicoCollectionBicoToAttach : tanque.getBicoCollection()) {
                bicoCollectionBicoToAttach = em.getReference(bicoCollectionBicoToAttach.getClass(), bicoCollectionBicoToAttach.getCodbico());
                attachedBicoCollection.add(bicoCollectionBicoToAttach);
            }
            tanque.setBicoCollection(attachedBicoCollection);
            em.persist(tanque);
            for (Bico bicoCollectionBico : tanque.getBicoCollection()) {
                Tanque oldCodtanqueOfBicoCollectionBico = bicoCollectionBico.getCodtanque();
                bicoCollectionBico.setCodtanque(tanque);
                bicoCollectionBico = em.merge(bicoCollectionBico);
                if (oldCodtanqueOfBicoCollectionBico != null) {
                    oldCodtanqueOfBicoCollectionBico.getBicoCollection().remove(bicoCollectionBico);
                    oldCodtanqueOfBicoCollectionBico = em.merge(oldCodtanqueOfBicoCollectionBico);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTanque(tanque.getCodtanque()) != null) {
                throw new PreexistingEntityException("Tanque " + tanque + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tanque tanque) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tanque persistentTanque = em.find(Tanque.class, tanque.getCodtanque());
            Collection<Bico> bicoCollectionOld = persistentTanque.getBicoCollection();
            Collection<Bico> bicoCollectionNew = tanque.getBicoCollection();
            List<String> illegalOrphanMessages = null;
            for (Bico bicoCollectionOldBico : bicoCollectionOld) {
                if (!bicoCollectionNew.contains(bicoCollectionOldBico)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Bico " + bicoCollectionOldBico + " since its codtanque field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Bico> attachedBicoCollectionNew = new ArrayList<Bico>();
            for (Bico bicoCollectionNewBicoToAttach : bicoCollectionNew) {
                bicoCollectionNewBicoToAttach = em.getReference(bicoCollectionNewBicoToAttach.getClass(), bicoCollectionNewBicoToAttach.getCodbico());
                attachedBicoCollectionNew.add(bicoCollectionNewBicoToAttach);
            }
            bicoCollectionNew = attachedBicoCollectionNew;
            tanque.setBicoCollection(bicoCollectionNew);
            tanque = em.merge(tanque);
            for (Bico bicoCollectionNewBico : bicoCollectionNew) {
                if (!bicoCollectionOld.contains(bicoCollectionNewBico)) {
                    Tanque oldCodtanqueOfBicoCollectionNewBico = bicoCollectionNewBico.getCodtanque();
                    bicoCollectionNewBico.setCodtanque(tanque);
                    bicoCollectionNewBico = em.merge(bicoCollectionNewBico);
                    if (oldCodtanqueOfBicoCollectionNewBico != null && !oldCodtanqueOfBicoCollectionNewBico.equals(tanque)) {
                        oldCodtanqueOfBicoCollectionNewBico.getBicoCollection().remove(bicoCollectionNewBico);
                        oldCodtanqueOfBicoCollectionNewBico = em.merge(oldCodtanqueOfBicoCollectionNewBico);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tanque.getCodtanque();
                if (findTanque(id) == null) {
                    throw new NonexistentEntityException("The tanque with id " + id + " no longer exists.");
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
            Tanque tanque;
            try {
                tanque = em.getReference(Tanque.class, id);
                tanque.getCodtanque();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tanque with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Bico> bicoCollectionOrphanCheck = tanque.getBicoCollection();
            for (Bico bicoCollectionOrphanCheckBico : bicoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Tanque (" + tanque + ") cannot be destroyed since the Bico " + bicoCollectionOrphanCheckBico + " in its bicoCollection field has a non-nullable codtanque field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(tanque);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tanque> findTanqueEntities() {
        return findTanqueEntities(true, -1, -1);
    }

    public List<Tanque> findTanqueEntities(int maxResults, int firstResult) {
        return findTanqueEntities(false, maxResults, firstResult);
    }

    private List<Tanque> findTanqueEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tanque.class));
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

    public Tanque findTanque(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tanque.class, id);
        } finally {
            em.close();
        }
    }

    public int getTanqueCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tanque> rt = cq.from(Tanque.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

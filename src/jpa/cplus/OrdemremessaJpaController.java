/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Ordemremessa;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Ordemremessaprod;
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
public class OrdemremessaJpaController implements Serializable {

    public OrdemremessaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ordemremessa ordemremessa) throws PreexistingEntityException, Exception {
        if (ordemremessa.getOrdemremessaprodCollection() == null) {
            ordemremessa.setOrdemremessaprodCollection(new ArrayList<Ordemremessaprod>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Ordemremessaprod> attachedOrdemremessaprodCollection = new ArrayList<Ordemremessaprod>();
            for (Ordemremessaprod ordemremessaprodCollectionOrdemremessaprodToAttach : ordemremessa.getOrdemremessaprodCollection()) {
                ordemremessaprodCollectionOrdemremessaprodToAttach = em.getReference(ordemremessaprodCollectionOrdemremessaprodToAttach.getClass(), ordemremessaprodCollectionOrdemremessaprodToAttach.getCodordremessaprod());
                attachedOrdemremessaprodCollection.add(ordemremessaprodCollectionOrdemremessaprodToAttach);
            }
            ordemremessa.setOrdemremessaprodCollection(attachedOrdemremessaprodCollection);
            em.persist(ordemremessa);
            for (Ordemremessaprod ordemremessaprodCollectionOrdemremessaprod : ordemremessa.getOrdemremessaprodCollection()) {
                Ordemremessa oldCodordremessaOfOrdemremessaprodCollectionOrdemremessaprod = ordemremessaprodCollectionOrdemremessaprod.getCodordremessa();
                ordemremessaprodCollectionOrdemremessaprod.setCodordremessa(ordemremessa);
                ordemremessaprodCollectionOrdemremessaprod = em.merge(ordemremessaprodCollectionOrdemremessaprod);
                if (oldCodordremessaOfOrdemremessaprodCollectionOrdemremessaprod != null) {
                    oldCodordremessaOfOrdemremessaprodCollectionOrdemremessaprod.getOrdemremessaprodCollection().remove(ordemremessaprodCollectionOrdemremessaprod);
                    oldCodordremessaOfOrdemremessaprodCollectionOrdemremessaprod = em.merge(oldCodordremessaOfOrdemremessaprodCollectionOrdemremessaprod);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrdemremessa(ordemremessa.getCodordremessa()) != null) {
                throw new PreexistingEntityException("Ordemremessa " + ordemremessa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ordemremessa ordemremessa) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordemremessa persistentOrdemremessa = em.find(Ordemremessa.class, ordemremessa.getCodordremessa());
            Collection<Ordemremessaprod> ordemremessaprodCollectionOld = persistentOrdemremessa.getOrdemremessaprodCollection();
            Collection<Ordemremessaprod> ordemremessaprodCollectionNew = ordemremessa.getOrdemremessaprodCollection();
            List<String> illegalOrphanMessages = null;
            for (Ordemremessaprod ordemremessaprodCollectionOldOrdemremessaprod : ordemremessaprodCollectionOld) {
                if (!ordemremessaprodCollectionNew.contains(ordemremessaprodCollectionOldOrdemremessaprod)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ordemremessaprod " + ordemremessaprodCollectionOldOrdemremessaprod + " since its codordremessa field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Ordemremessaprod> attachedOrdemremessaprodCollectionNew = new ArrayList<Ordemremessaprod>();
            for (Ordemremessaprod ordemremessaprodCollectionNewOrdemremessaprodToAttach : ordemremessaprodCollectionNew) {
                ordemremessaprodCollectionNewOrdemremessaprodToAttach = em.getReference(ordemremessaprodCollectionNewOrdemremessaprodToAttach.getClass(), ordemremessaprodCollectionNewOrdemremessaprodToAttach.getCodordremessaprod());
                attachedOrdemremessaprodCollectionNew.add(ordemremessaprodCollectionNewOrdemremessaprodToAttach);
            }
            ordemremessaprodCollectionNew = attachedOrdemremessaprodCollectionNew;
            ordemremessa.setOrdemremessaprodCollection(ordemremessaprodCollectionNew);
            ordemremessa = em.merge(ordemremessa);
            for (Ordemremessaprod ordemremessaprodCollectionNewOrdemremessaprod : ordemremessaprodCollectionNew) {
                if (!ordemremessaprodCollectionOld.contains(ordemremessaprodCollectionNewOrdemremessaprod)) {
                    Ordemremessa oldCodordremessaOfOrdemremessaprodCollectionNewOrdemremessaprod = ordemremessaprodCollectionNewOrdemremessaprod.getCodordremessa();
                    ordemremessaprodCollectionNewOrdemremessaprod.setCodordremessa(ordemremessa);
                    ordemremessaprodCollectionNewOrdemremessaprod = em.merge(ordemremessaprodCollectionNewOrdemremessaprod);
                    if (oldCodordremessaOfOrdemremessaprodCollectionNewOrdemremessaprod != null && !oldCodordremessaOfOrdemremessaprodCollectionNewOrdemremessaprod.equals(ordemremessa)) {
                        oldCodordremessaOfOrdemremessaprodCollectionNewOrdemremessaprod.getOrdemremessaprodCollection().remove(ordemremessaprodCollectionNewOrdemremessaprod);
                        oldCodordremessaOfOrdemremessaprodCollectionNewOrdemremessaprod = em.merge(oldCodordremessaOfOrdemremessaprodCollectionNewOrdemremessaprod);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ordemremessa.getCodordremessa();
                if (findOrdemremessa(id) == null) {
                    throw new NonexistentEntityException("The ordemremessa with id " + id + " no longer exists.");
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
            Ordemremessa ordemremessa;
            try {
                ordemremessa = em.getReference(Ordemremessa.class, id);
                ordemremessa.getCodordremessa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ordemremessa with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Ordemremessaprod> ordemremessaprodCollectionOrphanCheck = ordemremessa.getOrdemremessaprodCollection();
            for (Ordemremessaprod ordemremessaprodCollectionOrphanCheckOrdemremessaprod : ordemremessaprodCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ordemremessa (" + ordemremessa + ") cannot be destroyed since the Ordemremessaprod " + ordemremessaprodCollectionOrphanCheckOrdemremessaprod + " in its ordemremessaprodCollection field has a non-nullable codordremessa field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(ordemremessa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ordemremessa> findOrdemremessaEntities() {
        return findOrdemremessaEntities(true, -1, -1);
    }

    public List<Ordemremessa> findOrdemremessaEntities(int maxResults, int firstResult) {
        return findOrdemremessaEntities(false, maxResults, firstResult);
    }

    private List<Ordemremessa> findOrdemremessaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ordemremessa.class));
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

    public Ordemremessa findOrdemremessa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ordemremessa.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrdemremessaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ordemremessa> rt = cq.from(Ordemremessa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

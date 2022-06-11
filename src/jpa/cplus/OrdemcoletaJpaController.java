/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Ordemcoleta;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Ordemcoletaprod;
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
public class OrdemcoletaJpaController implements Serializable {

    public OrdemcoletaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ordemcoleta ordemcoleta) throws PreexistingEntityException, Exception {
        if (ordemcoleta.getOrdemcoletaprodCollection() == null) {
            ordemcoleta.setOrdemcoletaprodCollection(new ArrayList<Ordemcoletaprod>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Ordemcoletaprod> attachedOrdemcoletaprodCollection = new ArrayList<Ordemcoletaprod>();
            for (Ordemcoletaprod ordemcoletaprodCollectionOrdemcoletaprodToAttach : ordemcoleta.getOrdemcoletaprodCollection()) {
                ordemcoletaprodCollectionOrdemcoletaprodToAttach = em.getReference(ordemcoletaprodCollectionOrdemcoletaprodToAttach.getClass(), ordemcoletaprodCollectionOrdemcoletaprodToAttach.getCodordcoletaprod());
                attachedOrdemcoletaprodCollection.add(ordemcoletaprodCollectionOrdemcoletaprodToAttach);
            }
            ordemcoleta.setOrdemcoletaprodCollection(attachedOrdemcoletaprodCollection);
            em.persist(ordemcoleta);
            for (Ordemcoletaprod ordemcoletaprodCollectionOrdemcoletaprod : ordemcoleta.getOrdemcoletaprodCollection()) {
                Ordemcoleta oldCodordcoletaOfOrdemcoletaprodCollectionOrdemcoletaprod = ordemcoletaprodCollectionOrdemcoletaprod.getCodordcoleta();
                ordemcoletaprodCollectionOrdemcoletaprod.setCodordcoleta(ordemcoleta);
                ordemcoletaprodCollectionOrdemcoletaprod = em.merge(ordemcoletaprodCollectionOrdemcoletaprod);
                if (oldCodordcoletaOfOrdemcoletaprodCollectionOrdemcoletaprod != null) {
                    oldCodordcoletaOfOrdemcoletaprodCollectionOrdemcoletaprod.getOrdemcoletaprodCollection().remove(ordemcoletaprodCollectionOrdemcoletaprod);
                    oldCodordcoletaOfOrdemcoletaprodCollectionOrdemcoletaprod = em.merge(oldCodordcoletaOfOrdemcoletaprodCollectionOrdemcoletaprod);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrdemcoleta(ordemcoleta.getCodordcoleta()) != null) {
                throw new PreexistingEntityException("Ordemcoleta " + ordemcoleta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ordemcoleta ordemcoleta) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordemcoleta persistentOrdemcoleta = em.find(Ordemcoleta.class, ordemcoleta.getCodordcoleta());
            Collection<Ordemcoletaprod> ordemcoletaprodCollectionOld = persistentOrdemcoleta.getOrdemcoletaprodCollection();
            Collection<Ordemcoletaprod> ordemcoletaprodCollectionNew = ordemcoleta.getOrdemcoletaprodCollection();
            List<String> illegalOrphanMessages = null;
            for (Ordemcoletaprod ordemcoletaprodCollectionOldOrdemcoletaprod : ordemcoletaprodCollectionOld) {
                if (!ordemcoletaprodCollectionNew.contains(ordemcoletaprodCollectionOldOrdemcoletaprod)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ordemcoletaprod " + ordemcoletaprodCollectionOldOrdemcoletaprod + " since its codordcoleta field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Ordemcoletaprod> attachedOrdemcoletaprodCollectionNew = new ArrayList<Ordemcoletaprod>();
            for (Ordemcoletaprod ordemcoletaprodCollectionNewOrdemcoletaprodToAttach : ordemcoletaprodCollectionNew) {
                ordemcoletaprodCollectionNewOrdemcoletaprodToAttach = em.getReference(ordemcoletaprodCollectionNewOrdemcoletaprodToAttach.getClass(), ordemcoletaprodCollectionNewOrdemcoletaprodToAttach.getCodordcoletaprod());
                attachedOrdemcoletaprodCollectionNew.add(ordemcoletaprodCollectionNewOrdemcoletaprodToAttach);
            }
            ordemcoletaprodCollectionNew = attachedOrdemcoletaprodCollectionNew;
            ordemcoleta.setOrdemcoletaprodCollection(ordemcoletaprodCollectionNew);
            ordemcoleta = em.merge(ordemcoleta);
            for (Ordemcoletaprod ordemcoletaprodCollectionNewOrdemcoletaprod : ordemcoletaprodCollectionNew) {
                if (!ordemcoletaprodCollectionOld.contains(ordemcoletaprodCollectionNewOrdemcoletaprod)) {
                    Ordemcoleta oldCodordcoletaOfOrdemcoletaprodCollectionNewOrdemcoletaprod = ordemcoletaprodCollectionNewOrdemcoletaprod.getCodordcoleta();
                    ordemcoletaprodCollectionNewOrdemcoletaprod.setCodordcoleta(ordemcoleta);
                    ordemcoletaprodCollectionNewOrdemcoletaprod = em.merge(ordemcoletaprodCollectionNewOrdemcoletaprod);
                    if (oldCodordcoletaOfOrdemcoletaprodCollectionNewOrdemcoletaprod != null && !oldCodordcoletaOfOrdemcoletaprodCollectionNewOrdemcoletaprod.equals(ordemcoleta)) {
                        oldCodordcoletaOfOrdemcoletaprodCollectionNewOrdemcoletaprod.getOrdemcoletaprodCollection().remove(ordemcoletaprodCollectionNewOrdemcoletaprod);
                        oldCodordcoletaOfOrdemcoletaprodCollectionNewOrdemcoletaprod = em.merge(oldCodordcoletaOfOrdemcoletaprodCollectionNewOrdemcoletaprod);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ordemcoleta.getCodordcoleta();
                if (findOrdemcoleta(id) == null) {
                    throw new NonexistentEntityException("The ordemcoleta with id " + id + " no longer exists.");
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
            Ordemcoleta ordemcoleta;
            try {
                ordemcoleta = em.getReference(Ordemcoleta.class, id);
                ordemcoleta.getCodordcoleta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ordemcoleta with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Ordemcoletaprod> ordemcoletaprodCollectionOrphanCheck = ordemcoleta.getOrdemcoletaprodCollection();
            for (Ordemcoletaprod ordemcoletaprodCollectionOrphanCheckOrdemcoletaprod : ordemcoletaprodCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ordemcoleta (" + ordemcoleta + ") cannot be destroyed since the Ordemcoletaprod " + ordemcoletaprodCollectionOrphanCheckOrdemcoletaprod + " in its ordemcoletaprodCollection field has a non-nullable codordcoleta field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(ordemcoleta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ordemcoleta> findOrdemcoletaEntities() {
        return findOrdemcoletaEntities(true, -1, -1);
    }

    public List<Ordemcoleta> findOrdemcoletaEntities(int maxResults, int firstResult) {
        return findOrdemcoletaEntities(false, maxResults, firstResult);
    }

    private List<Ordemcoleta> findOrdemcoletaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ordemcoleta.class));
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

    public Ordemcoleta findOrdemcoleta(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ordemcoleta.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrdemcoletaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ordemcoleta> rt = cq.from(Ordemcoleta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

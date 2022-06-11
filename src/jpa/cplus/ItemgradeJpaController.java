/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Itemgrade;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Itemgradedetalhe;
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
public class ItemgradeJpaController implements Serializable {

    public ItemgradeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Itemgrade itemgrade) throws PreexistingEntityException, Exception {
        if (itemgrade.getItemgradedetalheCollection() == null) {
            itemgrade.setItemgradedetalheCollection(new ArrayList<Itemgradedetalhe>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Itemgradedetalhe> attachedItemgradedetalheCollection = new ArrayList<Itemgradedetalhe>();
            for (Itemgradedetalhe itemgradedetalheCollectionItemgradedetalheToAttach : itemgrade.getItemgradedetalheCollection()) {
                itemgradedetalheCollectionItemgradedetalheToAttach = em.getReference(itemgradedetalheCollectionItemgradedetalheToAttach.getClass(), itemgradedetalheCollectionItemgradedetalheToAttach.getCoditemgradedetalhe());
                attachedItemgradedetalheCollection.add(itemgradedetalheCollectionItemgradedetalheToAttach);
            }
            itemgrade.setItemgradedetalheCollection(attachedItemgradedetalheCollection);
            em.persist(itemgrade);
            for (Itemgradedetalhe itemgradedetalheCollectionItemgradedetalhe : itemgrade.getItemgradedetalheCollection()) {
                Itemgrade oldCoditemgradeOfItemgradedetalheCollectionItemgradedetalhe = itemgradedetalheCollectionItemgradedetalhe.getCoditemgrade();
                itemgradedetalheCollectionItemgradedetalhe.setCoditemgrade(itemgrade);
                itemgradedetalheCollectionItemgradedetalhe = em.merge(itemgradedetalheCollectionItemgradedetalhe);
                if (oldCoditemgradeOfItemgradedetalheCollectionItemgradedetalhe != null) {
                    oldCoditemgradeOfItemgradedetalheCollectionItemgradedetalhe.getItemgradedetalheCollection().remove(itemgradedetalheCollectionItemgradedetalhe);
                    oldCoditemgradeOfItemgradedetalheCollectionItemgradedetalhe = em.merge(oldCoditemgradeOfItemgradedetalheCollectionItemgradedetalhe);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findItemgrade(itemgrade.getCoditemgrade()) != null) {
                throw new PreexistingEntityException("Itemgrade " + itemgrade + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Itemgrade itemgrade) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Itemgrade persistentItemgrade = em.find(Itemgrade.class, itemgrade.getCoditemgrade());
            Collection<Itemgradedetalhe> itemgradedetalheCollectionOld = persistentItemgrade.getItemgradedetalheCollection();
            Collection<Itemgradedetalhe> itemgradedetalheCollectionNew = itemgrade.getItemgradedetalheCollection();
            List<String> illegalOrphanMessages = null;
            for (Itemgradedetalhe itemgradedetalheCollectionOldItemgradedetalhe : itemgradedetalheCollectionOld) {
                if (!itemgradedetalheCollectionNew.contains(itemgradedetalheCollectionOldItemgradedetalhe)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Itemgradedetalhe " + itemgradedetalheCollectionOldItemgradedetalhe + " since its coditemgrade field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Itemgradedetalhe> attachedItemgradedetalheCollectionNew = new ArrayList<Itemgradedetalhe>();
            for (Itemgradedetalhe itemgradedetalheCollectionNewItemgradedetalheToAttach : itemgradedetalheCollectionNew) {
                itemgradedetalheCollectionNewItemgradedetalheToAttach = em.getReference(itemgradedetalheCollectionNewItemgradedetalheToAttach.getClass(), itemgradedetalheCollectionNewItemgradedetalheToAttach.getCoditemgradedetalhe());
                attachedItemgradedetalheCollectionNew.add(itemgradedetalheCollectionNewItemgradedetalheToAttach);
            }
            itemgradedetalheCollectionNew = attachedItemgradedetalheCollectionNew;
            itemgrade.setItemgradedetalheCollection(itemgradedetalheCollectionNew);
            itemgrade = em.merge(itemgrade);
            for (Itemgradedetalhe itemgradedetalheCollectionNewItemgradedetalhe : itemgradedetalheCollectionNew) {
                if (!itemgradedetalheCollectionOld.contains(itemgradedetalheCollectionNewItemgradedetalhe)) {
                    Itemgrade oldCoditemgradeOfItemgradedetalheCollectionNewItemgradedetalhe = itemgradedetalheCollectionNewItemgradedetalhe.getCoditemgrade();
                    itemgradedetalheCollectionNewItemgradedetalhe.setCoditemgrade(itemgrade);
                    itemgradedetalheCollectionNewItemgradedetalhe = em.merge(itemgradedetalheCollectionNewItemgradedetalhe);
                    if (oldCoditemgradeOfItemgradedetalheCollectionNewItemgradedetalhe != null && !oldCoditemgradeOfItemgradedetalheCollectionNewItemgradedetalhe.equals(itemgrade)) {
                        oldCoditemgradeOfItemgradedetalheCollectionNewItemgradedetalhe.getItemgradedetalheCollection().remove(itemgradedetalheCollectionNewItemgradedetalhe);
                        oldCoditemgradeOfItemgradedetalheCollectionNewItemgradedetalhe = em.merge(oldCoditemgradeOfItemgradedetalheCollectionNewItemgradedetalhe);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = itemgrade.getCoditemgrade();
                if (findItemgrade(id) == null) {
                    throw new NonexistentEntityException("The itemgrade with id " + id + " no longer exists.");
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
            Itemgrade itemgrade;
            try {
                itemgrade = em.getReference(Itemgrade.class, id);
                itemgrade.getCoditemgrade();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The itemgrade with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Itemgradedetalhe> itemgradedetalheCollectionOrphanCheck = itemgrade.getItemgradedetalheCollection();
            for (Itemgradedetalhe itemgradedetalheCollectionOrphanCheckItemgradedetalhe : itemgradedetalheCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Itemgrade (" + itemgrade + ") cannot be destroyed since the Itemgradedetalhe " + itemgradedetalheCollectionOrphanCheckItemgradedetalhe + " in its itemgradedetalheCollection field has a non-nullable coditemgrade field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(itemgrade);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Itemgrade> findItemgradeEntities() {
        return findItemgradeEntities(true, -1, -1);
    }

    public List<Itemgrade> findItemgradeEntities(int maxResults, int firstResult) {
        return findItemgradeEntities(false, maxResults, firstResult);
    }

    private List<Itemgrade> findItemgradeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Itemgrade.class));
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

    public Itemgrade findItemgrade(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Itemgrade.class, id);
        } finally {
            em.close();
        }
    }

    public int getItemgradeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Itemgrade> rt = cq.from(Itemgrade.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

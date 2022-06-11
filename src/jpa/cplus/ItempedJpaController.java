/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Itemped;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Pedido;
import entidade.cplus.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ItempedJpaController implements Serializable {

    public ItempedJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Itemped itemped) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido codped = itemped.getCodped();
            if (codped != null) {
                codped = em.getReference(codped.getClass(), codped.getCodped());
                itemped.setCodped(codped);
            }
            Produto codprod = itemped.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                itemped.setCodprod(codprod);
            }
            em.persist(itemped);
            if (codped != null) {
                codped.getItempedCollection().add(itemped);
                codped = em.merge(codped);
            }
            if (codprod != null) {
                codprod.getItempedCollection().add(itemped);
                codprod = em.merge(codprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findItemped(itemped.getCoditemped()) != null) {
                throw new PreexistingEntityException("Itemped " + itemped + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Itemped itemped) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Itemped persistentItemped = em.find(Itemped.class, itemped.getCoditemped());
            Pedido codpedOld = persistentItemped.getCodped();
            Pedido codpedNew = itemped.getCodped();
            Produto codprodOld = persistentItemped.getCodprod();
            Produto codprodNew = itemped.getCodprod();
            if (codpedNew != null) {
                codpedNew = em.getReference(codpedNew.getClass(), codpedNew.getCodped());
                itemped.setCodped(codpedNew);
            }
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                itemped.setCodprod(codprodNew);
            }
            itemped = em.merge(itemped);
            if (codpedOld != null && !codpedOld.equals(codpedNew)) {
                codpedOld.getItempedCollection().remove(itemped);
                codpedOld = em.merge(codpedOld);
            }
            if (codpedNew != null && !codpedNew.equals(codpedOld)) {
                codpedNew.getItempedCollection().add(itemped);
                codpedNew = em.merge(codpedNew);
            }
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getItempedCollection().remove(itemped);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getItempedCollection().add(itemped);
                codprodNew = em.merge(codprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = itemped.getCoditemped();
                if (findItemped(id) == null) {
                    throw new NonexistentEntityException("The itemped with id " + id + " no longer exists.");
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
            Itemped itemped;
            try {
                itemped = em.getReference(Itemped.class, id);
                itemped.getCoditemped();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The itemped with id " + id + " no longer exists.", enfe);
            }
            Pedido codped = itemped.getCodped();
            if (codped != null) {
                codped.getItempedCollection().remove(itemped);
                codped = em.merge(codped);
            }
            Produto codprod = itemped.getCodprod();
            if (codprod != null) {
                codprod.getItempedCollection().remove(itemped);
                codprod = em.merge(codprod);
            }
            em.remove(itemped);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Itemped> findItempedEntities() {
        return findItempedEntities(true, -1, -1);
    }

    public List<Itemped> findItempedEntities(int maxResults, int firstResult) {
        return findItempedEntities(false, maxResults, firstResult);
    }

    private List<Itemped> findItempedEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Itemped.class));
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

    public Itemped findItemped(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Itemped.class, id);
        } finally {
            em.close();
        }
    }

    public int getItempedCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Itemped> rt = cq.from(Itemped.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

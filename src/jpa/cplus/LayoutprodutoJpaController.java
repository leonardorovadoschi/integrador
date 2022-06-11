/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Layoutproduto;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Layoutprodutoitem;
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
public class LayoutprodutoJpaController implements Serializable {

    public LayoutprodutoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Layoutproduto layoutproduto) throws PreexistingEntityException, Exception {
        if (layoutproduto.getLayoutprodutoitemCollection() == null) {
            layoutproduto.setLayoutprodutoitemCollection(new ArrayList<Layoutprodutoitem>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Layoutprodutoitem> attachedLayoutprodutoitemCollection = new ArrayList<Layoutprodutoitem>();
            for (Layoutprodutoitem layoutprodutoitemCollectionLayoutprodutoitemToAttach : layoutproduto.getLayoutprodutoitemCollection()) {
                layoutprodutoitemCollectionLayoutprodutoitemToAttach = em.getReference(layoutprodutoitemCollectionLayoutprodutoitemToAttach.getClass(), layoutprodutoitemCollectionLayoutprodutoitemToAttach.getCodlayoutitem());
                attachedLayoutprodutoitemCollection.add(layoutprodutoitemCollectionLayoutprodutoitemToAttach);
            }
            layoutproduto.setLayoutprodutoitemCollection(attachedLayoutprodutoitemCollection);
            em.persist(layoutproduto);
            for (Layoutprodutoitem layoutprodutoitemCollectionLayoutprodutoitem : layoutproduto.getLayoutprodutoitemCollection()) {
                Layoutproduto oldCodlayoutprodutoOfLayoutprodutoitemCollectionLayoutprodutoitem = layoutprodutoitemCollectionLayoutprodutoitem.getCodlayoutproduto();
                layoutprodutoitemCollectionLayoutprodutoitem.setCodlayoutproduto(layoutproduto);
                layoutprodutoitemCollectionLayoutprodutoitem = em.merge(layoutprodutoitemCollectionLayoutprodutoitem);
                if (oldCodlayoutprodutoOfLayoutprodutoitemCollectionLayoutprodutoitem != null) {
                    oldCodlayoutprodutoOfLayoutprodutoitemCollectionLayoutprodutoitem.getLayoutprodutoitemCollection().remove(layoutprodutoitemCollectionLayoutprodutoitem);
                    oldCodlayoutprodutoOfLayoutprodutoitemCollectionLayoutprodutoitem = em.merge(oldCodlayoutprodutoOfLayoutprodutoitemCollectionLayoutprodutoitem);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLayoutproduto(layoutproduto.getCodlayoutproduto()) != null) {
                throw new PreexistingEntityException("Layoutproduto " + layoutproduto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Layoutproduto layoutproduto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Layoutproduto persistentLayoutproduto = em.find(Layoutproduto.class, layoutproduto.getCodlayoutproduto());
            Collection<Layoutprodutoitem> layoutprodutoitemCollectionOld = persistentLayoutproduto.getLayoutprodutoitemCollection();
            Collection<Layoutprodutoitem> layoutprodutoitemCollectionNew = layoutproduto.getLayoutprodutoitemCollection();
            Collection<Layoutprodutoitem> attachedLayoutprodutoitemCollectionNew = new ArrayList<Layoutprodutoitem>();
            for (Layoutprodutoitem layoutprodutoitemCollectionNewLayoutprodutoitemToAttach : layoutprodutoitemCollectionNew) {
                layoutprodutoitemCollectionNewLayoutprodutoitemToAttach = em.getReference(layoutprodutoitemCollectionNewLayoutprodutoitemToAttach.getClass(), layoutprodutoitemCollectionNewLayoutprodutoitemToAttach.getCodlayoutitem());
                attachedLayoutprodutoitemCollectionNew.add(layoutprodutoitemCollectionNewLayoutprodutoitemToAttach);
            }
            layoutprodutoitemCollectionNew = attachedLayoutprodutoitemCollectionNew;
            layoutproduto.setLayoutprodutoitemCollection(layoutprodutoitemCollectionNew);
            layoutproduto = em.merge(layoutproduto);
            for (Layoutprodutoitem layoutprodutoitemCollectionOldLayoutprodutoitem : layoutprodutoitemCollectionOld) {
                if (!layoutprodutoitemCollectionNew.contains(layoutprodutoitemCollectionOldLayoutprodutoitem)) {
                    layoutprodutoitemCollectionOldLayoutprodutoitem.setCodlayoutproduto(null);
                    layoutprodutoitemCollectionOldLayoutprodutoitem = em.merge(layoutprodutoitemCollectionOldLayoutprodutoitem);
                }
            }
            for (Layoutprodutoitem layoutprodutoitemCollectionNewLayoutprodutoitem : layoutprodutoitemCollectionNew) {
                if (!layoutprodutoitemCollectionOld.contains(layoutprodutoitemCollectionNewLayoutprodutoitem)) {
                    Layoutproduto oldCodlayoutprodutoOfLayoutprodutoitemCollectionNewLayoutprodutoitem = layoutprodutoitemCollectionNewLayoutprodutoitem.getCodlayoutproduto();
                    layoutprodutoitemCollectionNewLayoutprodutoitem.setCodlayoutproduto(layoutproduto);
                    layoutprodutoitemCollectionNewLayoutprodutoitem = em.merge(layoutprodutoitemCollectionNewLayoutprodutoitem);
                    if (oldCodlayoutprodutoOfLayoutprodutoitemCollectionNewLayoutprodutoitem != null && !oldCodlayoutprodutoOfLayoutprodutoitemCollectionNewLayoutprodutoitem.equals(layoutproduto)) {
                        oldCodlayoutprodutoOfLayoutprodutoitemCollectionNewLayoutprodutoitem.getLayoutprodutoitemCollection().remove(layoutprodutoitemCollectionNewLayoutprodutoitem);
                        oldCodlayoutprodutoOfLayoutprodutoitemCollectionNewLayoutprodutoitem = em.merge(oldCodlayoutprodutoOfLayoutprodutoitemCollectionNewLayoutprodutoitem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = layoutproduto.getCodlayoutproduto();
                if (findLayoutproduto(id) == null) {
                    throw new NonexistentEntityException("The layoutproduto with id " + id + " no longer exists.");
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
            Layoutproduto layoutproduto;
            try {
                layoutproduto = em.getReference(Layoutproduto.class, id);
                layoutproduto.getCodlayoutproduto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The layoutproduto with id " + id + " no longer exists.", enfe);
            }
            Collection<Layoutprodutoitem> layoutprodutoitemCollection = layoutproduto.getLayoutprodutoitemCollection();
            for (Layoutprodutoitem layoutprodutoitemCollectionLayoutprodutoitem : layoutprodutoitemCollection) {
                layoutprodutoitemCollectionLayoutprodutoitem.setCodlayoutproduto(null);
                layoutprodutoitemCollectionLayoutprodutoitem = em.merge(layoutprodutoitemCollectionLayoutprodutoitem);
            }
            em.remove(layoutproduto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Layoutproduto> findLayoutprodutoEntities() {
        return findLayoutprodutoEntities(true, -1, -1);
    }

    public List<Layoutproduto> findLayoutprodutoEntities(int maxResults, int firstResult) {
        return findLayoutprodutoEntities(false, maxResults, firstResult);
    }

    private List<Layoutproduto> findLayoutprodutoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Layoutproduto.class));
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

    public Layoutproduto findLayoutproduto(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Layoutproduto.class, id);
        } finally {
            em.close();
        }
    }

    public int getLayoutprodutoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Layoutproduto> rt = cq.from(Layoutproduto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

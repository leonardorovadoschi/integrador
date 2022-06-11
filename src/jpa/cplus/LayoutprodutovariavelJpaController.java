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
import entidade.cplus.Layoutprodutoitem;
import entidade.cplus.Layoutprodutovariavel;
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
public class LayoutprodutovariavelJpaController implements Serializable {

    public LayoutprodutovariavelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Layoutprodutovariavel layoutprodutovariavel) throws PreexistingEntityException, Exception {
        if (layoutprodutovariavel.getLayoutprodutoitemCollection() == null) {
            layoutprodutovariavel.setLayoutprodutoitemCollection(new ArrayList<Layoutprodutoitem>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Layoutprodutoitem> attachedLayoutprodutoitemCollection = new ArrayList<Layoutprodutoitem>();
            for (Layoutprodutoitem layoutprodutoitemCollectionLayoutprodutoitemToAttach : layoutprodutovariavel.getLayoutprodutoitemCollection()) {
                layoutprodutoitemCollectionLayoutprodutoitemToAttach = em.getReference(layoutprodutoitemCollectionLayoutprodutoitemToAttach.getClass(), layoutprodutoitemCollectionLayoutprodutoitemToAttach.getCodlayoutitem());
                attachedLayoutprodutoitemCollection.add(layoutprodutoitemCollectionLayoutprodutoitemToAttach);
            }
            layoutprodutovariavel.setLayoutprodutoitemCollection(attachedLayoutprodutoitemCollection);
            em.persist(layoutprodutovariavel);
            for (Layoutprodutoitem layoutprodutoitemCollectionLayoutprodutoitem : layoutprodutovariavel.getLayoutprodutoitemCollection()) {
                Layoutprodutovariavel oldCodlayoutprodutovariavelOfLayoutprodutoitemCollectionLayoutprodutoitem = layoutprodutoitemCollectionLayoutprodutoitem.getCodlayoutprodutovariavel();
                layoutprodutoitemCollectionLayoutprodutoitem.setCodlayoutprodutovariavel(layoutprodutovariavel);
                layoutprodutoitemCollectionLayoutprodutoitem = em.merge(layoutprodutoitemCollectionLayoutprodutoitem);
                if (oldCodlayoutprodutovariavelOfLayoutprodutoitemCollectionLayoutprodutoitem != null) {
                    oldCodlayoutprodutovariavelOfLayoutprodutoitemCollectionLayoutprodutoitem.getLayoutprodutoitemCollection().remove(layoutprodutoitemCollectionLayoutprodutoitem);
                    oldCodlayoutprodutovariavelOfLayoutprodutoitemCollectionLayoutprodutoitem = em.merge(oldCodlayoutprodutovariavelOfLayoutprodutoitemCollectionLayoutprodutoitem);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLayoutprodutovariavel(layoutprodutovariavel.getCodlayoutprodutovariavel()) != null) {
                throw new PreexistingEntityException("Layoutprodutovariavel " + layoutprodutovariavel + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Layoutprodutovariavel layoutprodutovariavel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Layoutprodutovariavel persistentLayoutprodutovariavel = em.find(Layoutprodutovariavel.class, layoutprodutovariavel.getCodlayoutprodutovariavel());
            Collection<Layoutprodutoitem> layoutprodutoitemCollectionOld = persistentLayoutprodutovariavel.getLayoutprodutoitemCollection();
            Collection<Layoutprodutoitem> layoutprodutoitemCollectionNew = layoutprodutovariavel.getLayoutprodutoitemCollection();
            Collection<Layoutprodutoitem> attachedLayoutprodutoitemCollectionNew = new ArrayList<Layoutprodutoitem>();
            for (Layoutprodutoitem layoutprodutoitemCollectionNewLayoutprodutoitemToAttach : layoutprodutoitemCollectionNew) {
                layoutprodutoitemCollectionNewLayoutprodutoitemToAttach = em.getReference(layoutprodutoitemCollectionNewLayoutprodutoitemToAttach.getClass(), layoutprodutoitemCollectionNewLayoutprodutoitemToAttach.getCodlayoutitem());
                attachedLayoutprodutoitemCollectionNew.add(layoutprodutoitemCollectionNewLayoutprodutoitemToAttach);
            }
            layoutprodutoitemCollectionNew = attachedLayoutprodutoitemCollectionNew;
            layoutprodutovariavel.setLayoutprodutoitemCollection(layoutprodutoitemCollectionNew);
            layoutprodutovariavel = em.merge(layoutprodutovariavel);
            for (Layoutprodutoitem layoutprodutoitemCollectionOldLayoutprodutoitem : layoutprodutoitemCollectionOld) {
                if (!layoutprodutoitemCollectionNew.contains(layoutprodutoitemCollectionOldLayoutprodutoitem)) {
                    layoutprodutoitemCollectionOldLayoutprodutoitem.setCodlayoutprodutovariavel(null);
                    layoutprodutoitemCollectionOldLayoutprodutoitem = em.merge(layoutprodutoitemCollectionOldLayoutprodutoitem);
                }
            }
            for (Layoutprodutoitem layoutprodutoitemCollectionNewLayoutprodutoitem : layoutprodutoitemCollectionNew) {
                if (!layoutprodutoitemCollectionOld.contains(layoutprodutoitemCollectionNewLayoutprodutoitem)) {
                    Layoutprodutovariavel oldCodlayoutprodutovariavelOfLayoutprodutoitemCollectionNewLayoutprodutoitem = layoutprodutoitemCollectionNewLayoutprodutoitem.getCodlayoutprodutovariavel();
                    layoutprodutoitemCollectionNewLayoutprodutoitem.setCodlayoutprodutovariavel(layoutprodutovariavel);
                    layoutprodutoitemCollectionNewLayoutprodutoitem = em.merge(layoutprodutoitemCollectionNewLayoutprodutoitem);
                    if (oldCodlayoutprodutovariavelOfLayoutprodutoitemCollectionNewLayoutprodutoitem != null && !oldCodlayoutprodutovariavelOfLayoutprodutoitemCollectionNewLayoutprodutoitem.equals(layoutprodutovariavel)) {
                        oldCodlayoutprodutovariavelOfLayoutprodutoitemCollectionNewLayoutprodutoitem.getLayoutprodutoitemCollection().remove(layoutprodutoitemCollectionNewLayoutprodutoitem);
                        oldCodlayoutprodutovariavelOfLayoutprodutoitemCollectionNewLayoutprodutoitem = em.merge(oldCodlayoutprodutovariavelOfLayoutprodutoitemCollectionNewLayoutprodutoitem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = layoutprodutovariavel.getCodlayoutprodutovariavel();
                if (findLayoutprodutovariavel(id) == null) {
                    throw new NonexistentEntityException("The layoutprodutovariavel with id " + id + " no longer exists.");
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
            Layoutprodutovariavel layoutprodutovariavel;
            try {
                layoutprodutovariavel = em.getReference(Layoutprodutovariavel.class, id);
                layoutprodutovariavel.getCodlayoutprodutovariavel();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The layoutprodutovariavel with id " + id + " no longer exists.", enfe);
            }
            Collection<Layoutprodutoitem> layoutprodutoitemCollection = layoutprodutovariavel.getLayoutprodutoitemCollection();
            for (Layoutprodutoitem layoutprodutoitemCollectionLayoutprodutoitem : layoutprodutoitemCollection) {
                layoutprodutoitemCollectionLayoutprodutoitem.setCodlayoutprodutovariavel(null);
                layoutprodutoitemCollectionLayoutprodutoitem = em.merge(layoutprodutoitemCollectionLayoutprodutoitem);
            }
            em.remove(layoutprodutovariavel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Layoutprodutovariavel> findLayoutprodutovariavelEntities() {
        return findLayoutprodutovariavelEntities(true, -1, -1);
    }

    public List<Layoutprodutovariavel> findLayoutprodutovariavelEntities(int maxResults, int firstResult) {
        return findLayoutprodutovariavelEntities(false, maxResults, firstResult);
    }

    private List<Layoutprodutovariavel> findLayoutprodutovariavelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Layoutprodutovariavel.class));
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

    public Layoutprodutovariavel findLayoutprodutovariavel(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Layoutprodutovariavel.class, id);
        } finally {
            em.close();
        }
    }

    public int getLayoutprodutovariavelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Layoutprodutovariavel> rt = cq.from(Layoutprodutovariavel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

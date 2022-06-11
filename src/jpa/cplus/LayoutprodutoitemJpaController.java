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
import entidade.cplus.Layoutproduto;
import entidade.cplus.Layoutprodutoitem;
import entidade.cplus.Layoutprodutovariavel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class LayoutprodutoitemJpaController implements Serializable {

    public LayoutprodutoitemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Layoutprodutoitem layoutprodutoitem) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Layoutproduto codlayoutproduto = layoutprodutoitem.getCodlayoutproduto();
            if (codlayoutproduto != null) {
                codlayoutproduto = em.getReference(codlayoutproduto.getClass(), codlayoutproduto.getCodlayoutproduto());
                layoutprodutoitem.setCodlayoutproduto(codlayoutproduto);
            }
            Layoutprodutovariavel codlayoutprodutovariavel = layoutprodutoitem.getCodlayoutprodutovariavel();
            if (codlayoutprodutovariavel != null) {
                codlayoutprodutovariavel = em.getReference(codlayoutprodutovariavel.getClass(), codlayoutprodutovariavel.getCodlayoutprodutovariavel());
                layoutprodutoitem.setCodlayoutprodutovariavel(codlayoutprodutovariavel);
            }
            em.persist(layoutprodutoitem);
            if (codlayoutproduto != null) {
                codlayoutproduto.getLayoutprodutoitemCollection().add(layoutprodutoitem);
                codlayoutproduto = em.merge(codlayoutproduto);
            }
            if (codlayoutprodutovariavel != null) {
                codlayoutprodutovariavel.getLayoutprodutoitemCollection().add(layoutprodutoitem);
                codlayoutprodutovariavel = em.merge(codlayoutprodutovariavel);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLayoutprodutoitem(layoutprodutoitem.getCodlayoutitem()) != null) {
                throw new PreexistingEntityException("Layoutprodutoitem " + layoutprodutoitem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Layoutprodutoitem layoutprodutoitem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Layoutprodutoitem persistentLayoutprodutoitem = em.find(Layoutprodutoitem.class, layoutprodutoitem.getCodlayoutitem());
            Layoutproduto codlayoutprodutoOld = persistentLayoutprodutoitem.getCodlayoutproduto();
            Layoutproduto codlayoutprodutoNew = layoutprodutoitem.getCodlayoutproduto();
            Layoutprodutovariavel codlayoutprodutovariavelOld = persistentLayoutprodutoitem.getCodlayoutprodutovariavel();
            Layoutprodutovariavel codlayoutprodutovariavelNew = layoutprodutoitem.getCodlayoutprodutovariavel();
            if (codlayoutprodutoNew != null) {
                codlayoutprodutoNew = em.getReference(codlayoutprodutoNew.getClass(), codlayoutprodutoNew.getCodlayoutproduto());
                layoutprodutoitem.setCodlayoutproduto(codlayoutprodutoNew);
            }
            if (codlayoutprodutovariavelNew != null) {
                codlayoutprodutovariavelNew = em.getReference(codlayoutprodutovariavelNew.getClass(), codlayoutprodutovariavelNew.getCodlayoutprodutovariavel());
                layoutprodutoitem.setCodlayoutprodutovariavel(codlayoutprodutovariavelNew);
            }
            layoutprodutoitem = em.merge(layoutprodutoitem);
            if (codlayoutprodutoOld != null && !codlayoutprodutoOld.equals(codlayoutprodutoNew)) {
                codlayoutprodutoOld.getLayoutprodutoitemCollection().remove(layoutprodutoitem);
                codlayoutprodutoOld = em.merge(codlayoutprodutoOld);
            }
            if (codlayoutprodutoNew != null && !codlayoutprodutoNew.equals(codlayoutprodutoOld)) {
                codlayoutprodutoNew.getLayoutprodutoitemCollection().add(layoutprodutoitem);
                codlayoutprodutoNew = em.merge(codlayoutprodutoNew);
            }
            if (codlayoutprodutovariavelOld != null && !codlayoutprodutovariavelOld.equals(codlayoutprodutovariavelNew)) {
                codlayoutprodutovariavelOld.getLayoutprodutoitemCollection().remove(layoutprodutoitem);
                codlayoutprodutovariavelOld = em.merge(codlayoutprodutovariavelOld);
            }
            if (codlayoutprodutovariavelNew != null && !codlayoutprodutovariavelNew.equals(codlayoutprodutovariavelOld)) {
                codlayoutprodutovariavelNew.getLayoutprodutoitemCollection().add(layoutprodutoitem);
                codlayoutprodutovariavelNew = em.merge(codlayoutprodutovariavelNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = layoutprodutoitem.getCodlayoutitem();
                if (findLayoutprodutoitem(id) == null) {
                    throw new NonexistentEntityException("The layoutprodutoitem with id " + id + " no longer exists.");
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
            Layoutprodutoitem layoutprodutoitem;
            try {
                layoutprodutoitem = em.getReference(Layoutprodutoitem.class, id);
                layoutprodutoitem.getCodlayoutitem();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The layoutprodutoitem with id " + id + " no longer exists.", enfe);
            }
            Layoutproduto codlayoutproduto = layoutprodutoitem.getCodlayoutproduto();
            if (codlayoutproduto != null) {
                codlayoutproduto.getLayoutprodutoitemCollection().remove(layoutprodutoitem);
                codlayoutproduto = em.merge(codlayoutproduto);
            }
            Layoutprodutovariavel codlayoutprodutovariavel = layoutprodutoitem.getCodlayoutprodutovariavel();
            if (codlayoutprodutovariavel != null) {
                codlayoutprodutovariavel.getLayoutprodutoitemCollection().remove(layoutprodutoitem);
                codlayoutprodutovariavel = em.merge(codlayoutprodutovariavel);
            }
            em.remove(layoutprodutoitem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Layoutprodutoitem> findLayoutprodutoitemEntities() {
        return findLayoutprodutoitemEntities(true, -1, -1);
    }

    public List<Layoutprodutoitem> findLayoutprodutoitemEntities(int maxResults, int firstResult) {
        return findLayoutprodutoitemEntities(false, maxResults, firstResult);
    }

    private List<Layoutprodutoitem> findLayoutprodutoitemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Layoutprodutoitem.class));
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

    public Layoutprodutoitem findLayoutprodutoitem(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Layoutprodutoitem.class, id);
        } finally {
            em.close();
        }
    }

    public int getLayoutprodutoitemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Layoutprodutoitem> rt = cq.from(Layoutprodutoitem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

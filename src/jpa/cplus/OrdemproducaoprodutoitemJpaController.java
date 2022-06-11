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
import entidade.cplus.Ordemproducaoproduto;
import entidade.cplus.Ordemproducaoprodutoitem;
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
public class OrdemproducaoprodutoitemJpaController implements Serializable {

    public OrdemproducaoprodutoitemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ordemproducaoprodutoitem ordemproducaoprodutoitem) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordemproducaoproduto codordemproducaoproduto = ordemproducaoprodutoitem.getCodordemproducaoproduto();
            if (codordemproducaoproduto != null) {
                codordemproducaoproduto = em.getReference(codordemproducaoproduto.getClass(), codordemproducaoproduto.getCodordemproducaoproduto());
                ordemproducaoprodutoitem.setCodordemproducaoproduto(codordemproducaoproduto);
            }
            Produto codprod = ordemproducaoprodutoitem.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                ordemproducaoprodutoitem.setCodprod(codprod);
            }
            em.persist(ordemproducaoprodutoitem);
            if (codordemproducaoproduto != null) {
                codordemproducaoproduto.getOrdemproducaoprodutoitemCollection().add(ordemproducaoprodutoitem);
                codordemproducaoproduto = em.merge(codordemproducaoproduto);
            }
            if (codprod != null) {
                codprod.getOrdemproducaoprodutoitemCollection().add(ordemproducaoprodutoitem);
                codprod = em.merge(codprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrdemproducaoprodutoitem(ordemproducaoprodutoitem.getCodordemproducaoprodutoitem()) != null) {
                throw new PreexistingEntityException("Ordemproducaoprodutoitem " + ordemproducaoprodutoitem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ordemproducaoprodutoitem ordemproducaoprodutoitem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordemproducaoprodutoitem persistentOrdemproducaoprodutoitem = em.find(Ordemproducaoprodutoitem.class, ordemproducaoprodutoitem.getCodordemproducaoprodutoitem());
            Ordemproducaoproduto codordemproducaoprodutoOld = persistentOrdemproducaoprodutoitem.getCodordemproducaoproduto();
            Ordemproducaoproduto codordemproducaoprodutoNew = ordemproducaoprodutoitem.getCodordemproducaoproduto();
            Produto codprodOld = persistentOrdemproducaoprodutoitem.getCodprod();
            Produto codprodNew = ordemproducaoprodutoitem.getCodprod();
            if (codordemproducaoprodutoNew != null) {
                codordemproducaoprodutoNew = em.getReference(codordemproducaoprodutoNew.getClass(), codordemproducaoprodutoNew.getCodordemproducaoproduto());
                ordemproducaoprodutoitem.setCodordemproducaoproduto(codordemproducaoprodutoNew);
            }
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                ordemproducaoprodutoitem.setCodprod(codprodNew);
            }
            ordemproducaoprodutoitem = em.merge(ordemproducaoprodutoitem);
            if (codordemproducaoprodutoOld != null && !codordemproducaoprodutoOld.equals(codordemproducaoprodutoNew)) {
                codordemproducaoprodutoOld.getOrdemproducaoprodutoitemCollection().remove(ordemproducaoprodutoitem);
                codordemproducaoprodutoOld = em.merge(codordemproducaoprodutoOld);
            }
            if (codordemproducaoprodutoNew != null && !codordemproducaoprodutoNew.equals(codordemproducaoprodutoOld)) {
                codordemproducaoprodutoNew.getOrdemproducaoprodutoitemCollection().add(ordemproducaoprodutoitem);
                codordemproducaoprodutoNew = em.merge(codordemproducaoprodutoNew);
            }
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getOrdemproducaoprodutoitemCollection().remove(ordemproducaoprodutoitem);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getOrdemproducaoprodutoitemCollection().add(ordemproducaoprodutoitem);
                codprodNew = em.merge(codprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ordemproducaoprodutoitem.getCodordemproducaoprodutoitem();
                if (findOrdemproducaoprodutoitem(id) == null) {
                    throw new NonexistentEntityException("The ordemproducaoprodutoitem with id " + id + " no longer exists.");
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
            Ordemproducaoprodutoitem ordemproducaoprodutoitem;
            try {
                ordemproducaoprodutoitem = em.getReference(Ordemproducaoprodutoitem.class, id);
                ordemproducaoprodutoitem.getCodordemproducaoprodutoitem();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ordemproducaoprodutoitem with id " + id + " no longer exists.", enfe);
            }
            Ordemproducaoproduto codordemproducaoproduto = ordemproducaoprodutoitem.getCodordemproducaoproduto();
            if (codordemproducaoproduto != null) {
                codordemproducaoproduto.getOrdemproducaoprodutoitemCollection().remove(ordemproducaoprodutoitem);
                codordemproducaoproduto = em.merge(codordemproducaoproduto);
            }
            Produto codprod = ordemproducaoprodutoitem.getCodprod();
            if (codprod != null) {
                codprod.getOrdemproducaoprodutoitemCollection().remove(ordemproducaoprodutoitem);
                codprod = em.merge(codprod);
            }
            em.remove(ordemproducaoprodutoitem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ordemproducaoprodutoitem> findOrdemproducaoprodutoitemEntities() {
        return findOrdemproducaoprodutoitemEntities(true, -1, -1);
    }

    public List<Ordemproducaoprodutoitem> findOrdemproducaoprodutoitemEntities(int maxResults, int firstResult) {
        return findOrdemproducaoprodutoitemEntities(false, maxResults, firstResult);
    }

    private List<Ordemproducaoprodutoitem> findOrdemproducaoprodutoitemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ordemproducaoprodutoitem.class));
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

    public Ordemproducaoprodutoitem findOrdemproducaoprodutoitem(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ordemproducaoprodutoitem.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrdemproducaoprodutoitemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ordemproducaoprodutoitem> rt = cq.from(Ordemproducaoprodutoitem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
import entidade.cplus.Produto;
import entidade.cplus.Produtohistorico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ProdutohistoricoJpaController implements Serializable {

    public ProdutohistoricoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtohistorico produtohistorico) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto codprod = produtohistorico.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                produtohistorico.setCodprod(codprod);
            }
            em.persist(produtohistorico);
            if (codprod != null) {
                codprod.getProdutohistoricoCollection().add(produtohistorico);
                codprod = em.merge(codprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProdutohistorico(produtohistorico.getCodprodutohistorico()) != null) {
                throw new PreexistingEntityException("Produtohistorico " + produtohistorico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtohistorico produtohistorico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtohistorico persistentProdutohistorico = em.find(Produtohistorico.class, produtohistorico.getCodprodutohistorico());
            Produto codprodOld = persistentProdutohistorico.getCodprod();
            Produto codprodNew = produtohistorico.getCodprod();
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                produtohistorico.setCodprod(codprodNew);
            }
            produtohistorico = em.merge(produtohistorico);
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getProdutohistoricoCollection().remove(produtohistorico);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getProdutohistoricoCollection().add(produtohistorico);
                codprodNew = em.merge(codprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = produtohistorico.getCodprodutohistorico();
                if (findProdutohistorico(id) == null) {
                    throw new NonexistentEntityException("The produtohistorico with id " + id + " no longer exists.");
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
            Produtohistorico produtohistorico;
            try {
                produtohistorico = em.getReference(Produtohistorico.class, id);
                produtohistorico.getCodprodutohistorico();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtohistorico with id " + id + " no longer exists.", enfe);
            }
            Produto codprod = produtohistorico.getCodprod();
            if (codprod != null) {
                codprod.getProdutohistoricoCollection().remove(produtohistorico);
                codprod = em.merge(codprod);
            }
            em.remove(produtohistorico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtohistorico> findProdutohistoricoEntities() {
        return findProdutohistoricoEntities(true, -1, -1);
    }

    public List<Produtohistorico> findProdutohistoricoEntities(int maxResults, int firstResult) {
        return findProdutohistoricoEntities(false, maxResults, firstResult);
    }

    private List<Produtohistorico> findProdutohistoricoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtohistorico.class));
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

    public Produtohistorico findProdutohistorico(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtohistorico.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutohistoricoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtohistorico> rt = cq.from(Produtohistorico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

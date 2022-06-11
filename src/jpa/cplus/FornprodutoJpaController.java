/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Fornproduto;
import entidade.cplus.FornprodutoPK;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class FornprodutoJpaController implements Serializable {

    public FornprodutoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Fornproduto fornproduto) throws PreexistingEntityException, Exception {
        if (fornproduto.getFornprodutoPK() == null) {
            fornproduto.setFornprodutoPK(new FornprodutoPK());
        }
        fornproduto.getFornprodutoPK().setCodprod(fornproduto.getProduto().getCodprod());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto produto = fornproduto.getProduto();
            if (produto != null) {
                produto = em.getReference(produto.getClass(), produto.getCodprod());
                fornproduto.setProduto(produto);
            }
            em.persist(fornproduto);
            if (produto != null) {
                produto.getFornprodutoCollection().add(fornproduto);
                produto = em.merge(produto);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFornproduto(fornproduto.getFornprodutoPK()) != null) {
                throw new PreexistingEntityException("Fornproduto " + fornproduto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Fornproduto fornproduto) throws NonexistentEntityException, Exception {
        fornproduto.getFornprodutoPK().setCodprod(fornproduto.getProduto().getCodprod());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Fornproduto persistentFornproduto = em.find(Fornproduto.class, fornproduto.getFornprodutoPK());
            Produto produtoOld = persistentFornproduto.getProduto();
            Produto produtoNew = fornproduto.getProduto();
            if (produtoNew != null) {
                produtoNew = em.getReference(produtoNew.getClass(), produtoNew.getCodprod());
                fornproduto.setProduto(produtoNew);
            }
            fornproduto = em.merge(fornproduto);
            if (produtoOld != null && !produtoOld.equals(produtoNew)) {
                produtoOld.getFornprodutoCollection().remove(fornproduto);
                produtoOld = em.merge(produtoOld);
            }
            if (produtoNew != null && !produtoNew.equals(produtoOld)) {
                produtoNew.getFornprodutoCollection().add(fornproduto);
                produtoNew = em.merge(produtoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                FornprodutoPK id = fornproduto.getFornprodutoPK();
                if (findFornproduto(id) == null) {
                    throw new NonexistentEntityException("The fornproduto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(FornprodutoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Fornproduto fornproduto;
            try {
                fornproduto = em.getReference(Fornproduto.class, id);
                fornproduto.getFornprodutoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The fornproduto with id " + id + " no longer exists.", enfe);
            }
            Produto produto = fornproduto.getProduto();
            if (produto != null) {
                produto.getFornprodutoCollection().remove(fornproduto);
                produto = em.merge(produto);
            }
            em.remove(fornproduto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Fornproduto> findFornprodutoEntities() {
        return findFornprodutoEntities(true, -1, -1);
    }

    public List<Fornproduto> findFornprodutoEntities(int maxResults, int firstResult) {
        return findFornprodutoEntities(false, maxResults, firstResult);
    }

    private List<Fornproduto> findFornprodutoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Fornproduto.class));
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

    public Fornproduto findFornproduto(FornprodutoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Fornproduto.class, id);
        } finally {
            em.close();
        }
    }

    public int getFornprodutoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Fornproduto> rt = cq.from(Fornproduto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.integrador;

import entidade.integrador.ProdFornecedor;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.integrador.exceptions.NonexistentEntityException;

/**
 *
 * @author leo
 */
public class ProdFornecedorJpaController implements Serializable {

    public ProdFornecedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ProdFornecedor produtoFornecedor) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(produtoFornecedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ProdFornecedor produtoFornecedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            produtoFornecedor = em.merge(produtoFornecedor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = produtoFornecedor.getIdProdutos();
                if (findProdutoFornecedor(id) == null) {
                    throw new NonexistentEntityException("The produtoFornecedor with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ProdFornecedor produtoFornecedor;
            try {
                produtoFornecedor = em.getReference(ProdFornecedor.class, id);
                produtoFornecedor.getIdProdutos();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtoFornecedor with id " + id + " no longer exists.", enfe);
            }
            em.remove(produtoFornecedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ProdFornecedor> findProdutoFornecedorEntities() {
        return findProdutoFornecedorEntities(true, -1, -1);
    }

    public List<ProdFornecedor> findProdutoFornecedorEntities(int maxResults, int firstResult) {
        return findProdutoFornecedorEntities(false, maxResults, firstResult);
    }

    private List<ProdFornecedor> findProdutoFornecedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ProdFornecedor.class));
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

    public ProdFornecedor findProdutoFornecedor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ProdFornecedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutoFornecedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ProdFornecedor> rt = cq.from(ProdFornecedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

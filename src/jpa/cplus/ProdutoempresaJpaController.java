/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Produtoempresa;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ProdutoempresaJpaController implements Serializable {

    public ProdutoempresaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtoempresa produtoempresa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(produtoempresa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProdutoempresa(produtoempresa.getCodprodutoempresa()) != null) {
                throw new PreexistingEntityException("Produtoempresa " + produtoempresa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtoempresa produtoempresa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            produtoempresa = em.merge(produtoempresa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = produtoempresa.getCodprodutoempresa();
                if (findProdutoempresa(id) == null) {
                    throw new NonexistentEntityException("The produtoempresa with id " + id + " no longer exists.");
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
            Produtoempresa produtoempresa;
            try {
                produtoempresa = em.getReference(Produtoempresa.class, id);
                produtoempresa.getCodprodutoempresa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtoempresa with id " + id + " no longer exists.", enfe);
            }
            em.remove(produtoempresa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtoempresa> findProdutoempresaEntities() {
        return findProdutoempresaEntities(true, -1, -1);
    }

    public List<Produtoempresa> findProdutoempresaEntities(int maxResults, int firstResult) {
        return findProdutoempresaEntities(false, maxResults, firstResult);
    }

    private List<Produtoempresa> findProdutoempresaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtoempresa.class));
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

    public Produtoempresa findProdutoempresa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtoempresa.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutoempresaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtoempresa> rt = cq.from(Produtoempresa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

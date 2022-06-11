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
import entidade.cplus.Produtocodigo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ProdutocodigoJpaController implements Serializable {

    public ProdutocodigoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtocodigo produtocodigo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto codprod = produtocodigo.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                produtocodigo.setCodprod(codprod);
            }
            em.persist(produtocodigo);
            if (codprod != null) {
                codprod.getProdutocodigoCollection().add(produtocodigo);
                codprod = em.merge(codprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProdutocodigo(produtocodigo.getId()) != null) {
                throw new PreexistingEntityException("Produtocodigo " + produtocodigo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtocodigo produtocodigo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtocodigo persistentProdutocodigo = em.find(Produtocodigo.class, produtocodigo.getId());
            Produto codprodOld = persistentProdutocodigo.getCodprod();
            Produto codprodNew = produtocodigo.getCodprod();
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                produtocodigo.setCodprod(codprodNew);
            }
            produtocodigo = em.merge(produtocodigo);
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getProdutocodigoCollection().remove(produtocodigo);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getProdutocodigoCollection().add(produtocodigo);
                codprodNew = em.merge(codprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = produtocodigo.getId();
                if (findProdutocodigo(id) == null) {
                    throw new NonexistentEntityException("The produtocodigo with id " + id + " no longer exists.");
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
            Produtocodigo produtocodigo;
            try {
                produtocodigo = em.getReference(Produtocodigo.class, id);
                produtocodigo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtocodigo with id " + id + " no longer exists.", enfe);
            }
            Produto codprod = produtocodigo.getCodprod();
            if (codprod != null) {
                codprod.getProdutocodigoCollection().remove(produtocodigo);
                codprod = em.merge(codprod);
            }
            em.remove(produtocodigo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtocodigo> findProdutocodigoEntities() {
        return findProdutocodigoEntities(true, -1, -1);
    }

    public List<Produtocodigo> findProdutocodigoEntities(int maxResults, int firstResult) {
        return findProdutocodigoEntities(false, maxResults, firstResult);
    }

    private List<Produtocodigo> findProdutocodigoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtocodigo.class));
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

    public Produtocodigo findProdutocodigo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtocodigo.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutocodigoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtocodigo> rt = cq.from(Produtocodigo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

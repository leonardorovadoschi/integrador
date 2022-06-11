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
import entidade.cplus.Produtoproducao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ProdutoproducaoJpaController implements Serializable {

    public ProdutoproducaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtoproducao produtoproducao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto codprod = produtoproducao.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                produtoproducao.setCodprod(codprod);
            }
            Produto codprodproducao = produtoproducao.getCodprodproducao();
            if (codprodproducao != null) {
                codprodproducao = em.getReference(codprodproducao.getClass(), codprodproducao.getCodprod());
                produtoproducao.setCodprodproducao(codprodproducao);
            }
            em.persist(produtoproducao);
            if (codprod != null) {
                codprod.getProdutoproducaoCollection().add(produtoproducao);
                codprod = em.merge(codprod);
            }
            if (codprodproducao != null) {
                codprodproducao.getProdutoproducaoCollection().add(produtoproducao);
                codprodproducao = em.merge(codprodproducao);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProdutoproducao(produtoproducao.getCodprodutoproducao()) != null) {
                throw new PreexistingEntityException("Produtoproducao " + produtoproducao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtoproducao produtoproducao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtoproducao persistentProdutoproducao = em.find(Produtoproducao.class, produtoproducao.getCodprodutoproducao());
            Produto codprodOld = persistentProdutoproducao.getCodprod();
            Produto codprodNew = produtoproducao.getCodprod();
            Produto codprodproducaoOld = persistentProdutoproducao.getCodprodproducao();
            Produto codprodproducaoNew = produtoproducao.getCodprodproducao();
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                produtoproducao.setCodprod(codprodNew);
            }
            if (codprodproducaoNew != null) {
                codprodproducaoNew = em.getReference(codprodproducaoNew.getClass(), codprodproducaoNew.getCodprod());
                produtoproducao.setCodprodproducao(codprodproducaoNew);
            }
            produtoproducao = em.merge(produtoproducao);
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getProdutoproducaoCollection().remove(produtoproducao);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getProdutoproducaoCollection().add(produtoproducao);
                codprodNew = em.merge(codprodNew);
            }
            if (codprodproducaoOld != null && !codprodproducaoOld.equals(codprodproducaoNew)) {
                codprodproducaoOld.getProdutoproducaoCollection().remove(produtoproducao);
                codprodproducaoOld = em.merge(codprodproducaoOld);
            }
            if (codprodproducaoNew != null && !codprodproducaoNew.equals(codprodproducaoOld)) {
                codprodproducaoNew.getProdutoproducaoCollection().add(produtoproducao);
                codprodproducaoNew = em.merge(codprodproducaoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = produtoproducao.getCodprodutoproducao();
                if (findProdutoproducao(id) == null) {
                    throw new NonexistentEntityException("The produtoproducao with id " + id + " no longer exists.");
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
            Produtoproducao produtoproducao;
            try {
                produtoproducao = em.getReference(Produtoproducao.class, id);
                produtoproducao.getCodprodutoproducao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtoproducao with id " + id + " no longer exists.", enfe);
            }
            Produto codprod = produtoproducao.getCodprod();
            if (codprod != null) {
                codprod.getProdutoproducaoCollection().remove(produtoproducao);
                codprod = em.merge(codprod);
            }
            Produto codprodproducao = produtoproducao.getCodprodproducao();
            if (codprodproducao != null) {
                codprodproducao.getProdutoproducaoCollection().remove(produtoproducao);
                codprodproducao = em.merge(codprodproducao);
            }
            em.remove(produtoproducao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtoproducao> findProdutoproducaoEntities() {
        return findProdutoproducaoEntities(true, -1, -1);
    }

    public List<Produtoproducao> findProdutoproducaoEntities(int maxResults, int firstResult) {
        return findProdutoproducaoEntities(false, maxResults, firstResult);
    }

    private List<Produtoproducao> findProdutoproducaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtoproducao.class));
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

    public Produtoproducao findProdutoproducao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtoproducao.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutoproducaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtoproducao> rt = cq.from(Produtoproducao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

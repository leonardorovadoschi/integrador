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
import entidade.cplus.Moeda;
import entidade.cplus.Preco;
import entidade.cplus.Produto;
import entidade.cplus.Produtopreco;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ProdutoprecoJpaController implements Serializable {

    public ProdutoprecoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtopreco produtopreco) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Moeda codmoeda = produtopreco.getCodmoeda();
            if (codmoeda != null) {
                codmoeda = em.getReference(codmoeda.getClass(), codmoeda.getCodmoeda());
                produtopreco.setCodmoeda(codmoeda);
            }
            Preco codpreco = produtopreco.getCodpreco();
            if (codpreco != null) {
                codpreco = em.getReference(codpreco.getClass(), codpreco.getCodpreco());
                produtopreco.setCodpreco(codpreco);
            }
            Produto codprod = produtopreco.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                produtopreco.setCodprod(codprod);
            }
            em.persist(produtopreco);
            if (codmoeda != null) {
                codmoeda.getProdutoprecoCollection().add(produtopreco);
                codmoeda = em.merge(codmoeda);
            }
            if (codpreco != null) {
                codpreco.getProdutoprecoCollection().add(produtopreco);
                codpreco = em.merge(codpreco);
            }
            if (codprod != null) {
                codprod.getProdutoprecoCollection().add(produtopreco);
                codprod = em.merge(codprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProdutopreco(produtopreco.getCodprodutopreco()) != null) {
                throw new PreexistingEntityException("Produtopreco " + produtopreco + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtopreco produtopreco) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtopreco persistentProdutopreco = em.find(Produtopreco.class, produtopreco.getCodprodutopreco());
            Moeda codmoedaOld = persistentProdutopreco.getCodmoeda();
            Moeda codmoedaNew = produtopreco.getCodmoeda();
            Preco codprecoOld = persistentProdutopreco.getCodpreco();
            Preco codprecoNew = produtopreco.getCodpreco();
            Produto codprodOld = persistentProdutopreco.getCodprod();
            Produto codprodNew = produtopreco.getCodprod();
            if (codmoedaNew != null) {
                codmoedaNew = em.getReference(codmoedaNew.getClass(), codmoedaNew.getCodmoeda());
                produtopreco.setCodmoeda(codmoedaNew);
            }
            if (codprecoNew != null) {
                codprecoNew = em.getReference(codprecoNew.getClass(), codprecoNew.getCodpreco());
                produtopreco.setCodpreco(codprecoNew);
            }
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                produtopreco.setCodprod(codprodNew);
            }
            produtopreco = em.merge(produtopreco);
            if (codmoedaOld != null && !codmoedaOld.equals(codmoedaNew)) {
                codmoedaOld.getProdutoprecoCollection().remove(produtopreco);
                codmoedaOld = em.merge(codmoedaOld);
            }
            if (codmoedaNew != null && !codmoedaNew.equals(codmoedaOld)) {
                codmoedaNew.getProdutoprecoCollection().add(produtopreco);
                codmoedaNew = em.merge(codmoedaNew);
            }
            if (codprecoOld != null && !codprecoOld.equals(codprecoNew)) {
                codprecoOld.getProdutoprecoCollection().remove(produtopreco);
                codprecoOld = em.merge(codprecoOld);
            }
            if (codprecoNew != null && !codprecoNew.equals(codprecoOld)) {
                codprecoNew.getProdutoprecoCollection().add(produtopreco);
                codprecoNew = em.merge(codprecoNew);
            }
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getProdutoprecoCollection().remove(produtopreco);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getProdutoprecoCollection().add(produtopreco);
                codprodNew = em.merge(codprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = produtopreco.getCodprodutopreco();
                if (findProdutopreco(id) == null) {
                    throw new NonexistentEntityException("The produtopreco with id " + id + " no longer exists.");
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
            Produtopreco produtopreco;
            try {
                produtopreco = em.getReference(Produtopreco.class, id);
                produtopreco.getCodprodutopreco();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtopreco with id " + id + " no longer exists.", enfe);
            }
            Moeda codmoeda = produtopreco.getCodmoeda();
            if (codmoeda != null) {
                codmoeda.getProdutoprecoCollection().remove(produtopreco);
                codmoeda = em.merge(codmoeda);
            }
            Preco codpreco = produtopreco.getCodpreco();
            if (codpreco != null) {
                codpreco.getProdutoprecoCollection().remove(produtopreco);
                codpreco = em.merge(codpreco);
            }
            Produto codprod = produtopreco.getCodprod();
            if (codprod != null) {
                codprod.getProdutoprecoCollection().remove(produtopreco);
                codprod = em.merge(codprod);
            }
            em.remove(produtopreco);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtopreco> findProdutoprecoEntities() {
        return findProdutoprecoEntities(true, -1, -1);
    }

    public List<Produtopreco> findProdutoprecoEntities(int maxResults, int firstResult) {
        return findProdutoprecoEntities(false, maxResults, firstResult);
    }

    private List<Produtopreco> findProdutoprecoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtopreco.class));
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

    public Produtopreco findProdutopreco(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtopreco.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutoprecoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtopreco> rt = cq.from(Produtopreco.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

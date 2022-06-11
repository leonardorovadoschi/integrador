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
import entidade.cplus.Produtoassociado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ProdutoassociadoJpaController implements Serializable {

    public ProdutoassociadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtoassociado produtoassociado) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto codprod = produtoassociado.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                produtoassociado.setCodprod(codprod);
            }
            Produto codprodassociado = produtoassociado.getCodprodassociado();
            if (codprodassociado != null) {
                codprodassociado = em.getReference(codprodassociado.getClass(), codprodassociado.getCodprod());
                produtoassociado.setCodprodassociado(codprodassociado);
            }
            em.persist(produtoassociado);
            if (codprod != null) {
                codprod.getProdutoassociadoCollection().add(produtoassociado);
                codprod = em.merge(codprod);
            }
            if (codprodassociado != null) {
                codprodassociado.getProdutoassociadoCollection().add(produtoassociado);
                codprodassociado = em.merge(codprodassociado);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProdutoassociado(produtoassociado.getId()) != null) {
                throw new PreexistingEntityException("Produtoassociado " + produtoassociado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtoassociado produtoassociado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtoassociado persistentProdutoassociado = em.find(Produtoassociado.class, produtoassociado.getId());
            Produto codprodOld = persistentProdutoassociado.getCodprod();
            Produto codprodNew = produtoassociado.getCodprod();
            Produto codprodassociadoOld = persistentProdutoassociado.getCodprodassociado();
            Produto codprodassociadoNew = produtoassociado.getCodprodassociado();
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                produtoassociado.setCodprod(codprodNew);
            }
            if (codprodassociadoNew != null) {
                codprodassociadoNew = em.getReference(codprodassociadoNew.getClass(), codprodassociadoNew.getCodprod());
                produtoassociado.setCodprodassociado(codprodassociadoNew);
            }
            produtoassociado = em.merge(produtoassociado);
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getProdutoassociadoCollection().remove(produtoassociado);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getProdutoassociadoCollection().add(produtoassociado);
                codprodNew = em.merge(codprodNew);
            }
            if (codprodassociadoOld != null && !codprodassociadoOld.equals(codprodassociadoNew)) {
                codprodassociadoOld.getProdutoassociadoCollection().remove(produtoassociado);
                codprodassociadoOld = em.merge(codprodassociadoOld);
            }
            if (codprodassociadoNew != null && !codprodassociadoNew.equals(codprodassociadoOld)) {
                codprodassociadoNew.getProdutoassociadoCollection().add(produtoassociado);
                codprodassociadoNew = em.merge(codprodassociadoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = produtoassociado.getId();
                if (findProdutoassociado(id) == null) {
                    throw new NonexistentEntityException("The produtoassociado with id " + id + " no longer exists.");
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
            Produtoassociado produtoassociado;
            try {
                produtoassociado = em.getReference(Produtoassociado.class, id);
                produtoassociado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtoassociado with id " + id + " no longer exists.", enfe);
            }
            Produto codprod = produtoassociado.getCodprod();
            if (codprod != null) {
                codprod.getProdutoassociadoCollection().remove(produtoassociado);
                codprod = em.merge(codprod);
            }
            Produto codprodassociado = produtoassociado.getCodprodassociado();
            if (codprodassociado != null) {
                codprodassociado.getProdutoassociadoCollection().remove(produtoassociado);
                codprodassociado = em.merge(codprodassociado);
            }
            em.remove(produtoassociado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtoassociado> findProdutoassociadoEntities() {
        return findProdutoassociadoEntities(true, -1, -1);
    }

    public List<Produtoassociado> findProdutoassociadoEntities(int maxResults, int firstResult) {
        return findProdutoassociadoEntities(false, maxResults, firstResult);
    }

    private List<Produtoassociado> findProdutoassociadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtoassociado.class));
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

    public Produtoassociado findProdutoassociado(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtoassociado.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutoassociadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtoassociado> rt = cq.from(Produtoassociado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
import entidade.cplus.Localizacao;
import entidade.cplus.Produto;
import entidade.cplus.Produtolocalizacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ProdutolocalizacaoJpaController implements Serializable {

    public ProdutolocalizacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtolocalizacao produtolocalizacao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Localizacao codloc = produtolocalizacao.getCodloc();
            if (codloc != null) {
                codloc = em.getReference(codloc.getClass(), codloc.getCodloc());
                produtolocalizacao.setCodloc(codloc);
            }
            Produto codprod = produtolocalizacao.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                produtolocalizacao.setCodprod(codprod);
            }
            em.persist(produtolocalizacao);
            if (codloc != null) {
                codloc.getProdutolocalizacaoCollection().add(produtolocalizacao);
                codloc = em.merge(codloc);
            }
            if (codprod != null) {
                codprod.getProdutolocalizacaoCollection().add(produtolocalizacao);
                codprod = em.merge(codprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProdutolocalizacao(produtolocalizacao.getCodprodutolocalizacao()) != null) {
                throw new PreexistingEntityException("Produtolocalizacao " + produtolocalizacao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtolocalizacao produtolocalizacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtolocalizacao persistentProdutolocalizacao = em.find(Produtolocalizacao.class, produtolocalizacao.getCodprodutolocalizacao());
            Localizacao codlocOld = persistentProdutolocalizacao.getCodloc();
            Localizacao codlocNew = produtolocalizacao.getCodloc();
            Produto codprodOld = persistentProdutolocalizacao.getCodprod();
            Produto codprodNew = produtolocalizacao.getCodprod();
            if (codlocNew != null) {
                codlocNew = em.getReference(codlocNew.getClass(), codlocNew.getCodloc());
                produtolocalizacao.setCodloc(codlocNew);
            }
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                produtolocalizacao.setCodprod(codprodNew);
            }
            produtolocalizacao = em.merge(produtolocalizacao);
            if (codlocOld != null && !codlocOld.equals(codlocNew)) {
                codlocOld.getProdutolocalizacaoCollection().remove(produtolocalizacao);
                codlocOld = em.merge(codlocOld);
            }
            if (codlocNew != null && !codlocNew.equals(codlocOld)) {
                codlocNew.getProdutolocalizacaoCollection().add(produtolocalizacao);
                codlocNew = em.merge(codlocNew);
            }
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getProdutolocalizacaoCollection().remove(produtolocalizacao);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getProdutolocalizacaoCollection().add(produtolocalizacao);
                codprodNew = em.merge(codprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = produtolocalizacao.getCodprodutolocalizacao();
                if (findProdutolocalizacao(id) == null) {
                    throw new NonexistentEntityException("The produtolocalizacao with id " + id + " no longer exists.");
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
            Produtolocalizacao produtolocalizacao;
            try {
                produtolocalizacao = em.getReference(Produtolocalizacao.class, id);
                produtolocalizacao.getCodprodutolocalizacao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtolocalizacao with id " + id + " no longer exists.", enfe);
            }
            Localizacao codloc = produtolocalizacao.getCodloc();
            if (codloc != null) {
                codloc.getProdutolocalizacaoCollection().remove(produtolocalizacao);
                codloc = em.merge(codloc);
            }
            Produto codprod = produtolocalizacao.getCodprod();
            if (codprod != null) {
                codprod.getProdutolocalizacaoCollection().remove(produtolocalizacao);
                codprod = em.merge(codprod);
            }
            em.remove(produtolocalizacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtolocalizacao> findProdutolocalizacaoEntities() {
        return findProdutolocalizacaoEntities(true, -1, -1);
    }

    public List<Produtolocalizacao> findProdutolocalizacaoEntities(int maxResults, int firstResult) {
        return findProdutolocalizacaoEntities(false, maxResults, firstResult);
    }

    private List<Produtolocalizacao> findProdutolocalizacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtolocalizacao.class));
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

    public Produtolocalizacao findProdutolocalizacao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtolocalizacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutolocalizacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtolocalizacao> rt = cq.from(Produtolocalizacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
import entidade.cplus.Empresa;
import entidade.cplus.Produtoestoquelote;
import entidade.cplus.Produtolote;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ProdutoestoqueloteJpaController implements Serializable {

    public ProdutoestoqueloteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtoestoquelote produtoestoquelote) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa codempresa = produtoestoquelote.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                produtoestoquelote.setCodempresa(codempresa);
            }
            Produtolote codprodutolote = produtoestoquelote.getCodprodutolote();
            if (codprodutolote != null) {
                codprodutolote = em.getReference(codprodutolote.getClass(), codprodutolote.getCodprodutolote());
                produtoestoquelote.setCodprodutolote(codprodutolote);
            }
            em.persist(produtoestoquelote);
            if (codempresa != null) {
                codempresa.getProdutoestoqueloteCollection().add(produtoestoquelote);
                codempresa = em.merge(codempresa);
            }
            if (codprodutolote != null) {
                codprodutolote.getProdutoestoqueloteCollection().add(produtoestoquelote);
                codprodutolote = em.merge(codprodutolote);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProdutoestoquelote(produtoestoquelote.getCodprodutoestoquelote()) != null) {
                throw new PreexistingEntityException("Produtoestoquelote " + produtoestoquelote + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtoestoquelote produtoestoquelote) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtoestoquelote persistentProdutoestoquelote = em.find(Produtoestoquelote.class, produtoestoquelote.getCodprodutoestoquelote());
            Empresa codempresaOld = persistentProdutoestoquelote.getCodempresa();
            Empresa codempresaNew = produtoestoquelote.getCodempresa();
            Produtolote codprodutoloteOld = persistentProdutoestoquelote.getCodprodutolote();
            Produtolote codprodutoloteNew = produtoestoquelote.getCodprodutolote();
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                produtoestoquelote.setCodempresa(codempresaNew);
            }
            if (codprodutoloteNew != null) {
                codprodutoloteNew = em.getReference(codprodutoloteNew.getClass(), codprodutoloteNew.getCodprodutolote());
                produtoestoquelote.setCodprodutolote(codprodutoloteNew);
            }
            produtoestoquelote = em.merge(produtoestoquelote);
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getProdutoestoqueloteCollection().remove(produtoestoquelote);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getProdutoestoqueloteCollection().add(produtoestoquelote);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codprodutoloteOld != null && !codprodutoloteOld.equals(codprodutoloteNew)) {
                codprodutoloteOld.getProdutoestoqueloteCollection().remove(produtoestoquelote);
                codprodutoloteOld = em.merge(codprodutoloteOld);
            }
            if (codprodutoloteNew != null && !codprodutoloteNew.equals(codprodutoloteOld)) {
                codprodutoloteNew.getProdutoestoqueloteCollection().add(produtoestoquelote);
                codprodutoloteNew = em.merge(codprodutoloteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = produtoestoquelote.getCodprodutoestoquelote();
                if (findProdutoestoquelote(id) == null) {
                    throw new NonexistentEntityException("The produtoestoquelote with id " + id + " no longer exists.");
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
            Produtoestoquelote produtoestoquelote;
            try {
                produtoestoquelote = em.getReference(Produtoestoquelote.class, id);
                produtoestoquelote.getCodprodutoestoquelote();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtoestoquelote with id " + id + " no longer exists.", enfe);
            }
            Empresa codempresa = produtoestoquelote.getCodempresa();
            if (codempresa != null) {
                codempresa.getProdutoestoqueloteCollection().remove(produtoestoquelote);
                codempresa = em.merge(codempresa);
            }
            Produtolote codprodutolote = produtoestoquelote.getCodprodutolote();
            if (codprodutolote != null) {
                codprodutolote.getProdutoestoqueloteCollection().remove(produtoestoquelote);
                codprodutolote = em.merge(codprodutolote);
            }
            em.remove(produtoestoquelote);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtoestoquelote> findProdutoestoqueloteEntities() {
        return findProdutoestoqueloteEntities(true, -1, -1);
    }

    public List<Produtoestoquelote> findProdutoestoqueloteEntities(int maxResults, int firstResult) {
        return findProdutoestoqueloteEntities(false, maxResults, firstResult);
    }

    private List<Produtoestoquelote> findProdutoestoqueloteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtoestoquelote.class));
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

    public Produtoestoquelote findProdutoestoquelote(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtoestoquelote.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutoestoqueloteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtoestoquelote> rt = cq.from(Produtoestoquelote.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

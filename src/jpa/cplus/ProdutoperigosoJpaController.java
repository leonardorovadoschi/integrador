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
import entidade.cplus.Produtoperigoso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ProdutoperigosoJpaController implements Serializable {

    public ProdutoperigosoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtoperigoso produtoperigoso) throws PreexistingEntityException, Exception {
        if (produtoperigoso.getProdutoCollection() == null) {
            produtoperigoso.setProdutoCollection(new ArrayList<Produto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Produto> attachedProdutoCollection = new ArrayList<Produto>();
            for (Produto produtoCollectionProdutoToAttach : produtoperigoso.getProdutoCollection()) {
                produtoCollectionProdutoToAttach = em.getReference(produtoCollectionProdutoToAttach.getClass(), produtoCollectionProdutoToAttach.getCodprod());
                attachedProdutoCollection.add(produtoCollectionProdutoToAttach);
            }
            produtoperigoso.setProdutoCollection(attachedProdutoCollection);
            em.persist(produtoperigoso);
            for (Produto produtoCollectionProduto : produtoperigoso.getProdutoCollection()) {
                Produtoperigoso oldCodprodutoperigosoOfProdutoCollectionProduto = produtoCollectionProduto.getCodprodutoperigoso();
                produtoCollectionProduto.setCodprodutoperigoso(produtoperigoso);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
                if (oldCodprodutoperigosoOfProdutoCollectionProduto != null) {
                    oldCodprodutoperigosoOfProdutoCollectionProduto.getProdutoCollection().remove(produtoCollectionProduto);
                    oldCodprodutoperigosoOfProdutoCollectionProduto = em.merge(oldCodprodutoperigosoOfProdutoCollectionProduto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProdutoperigoso(produtoperigoso.getCodprodutoperigoso()) != null) {
                throw new PreexistingEntityException("Produtoperigoso " + produtoperigoso + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtoperigoso produtoperigoso) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtoperigoso persistentProdutoperigoso = em.find(Produtoperigoso.class, produtoperigoso.getCodprodutoperigoso());
            Collection<Produto> produtoCollectionOld = persistentProdutoperigoso.getProdutoCollection();
            Collection<Produto> produtoCollectionNew = produtoperigoso.getProdutoCollection();
            Collection<Produto> attachedProdutoCollectionNew = new ArrayList<Produto>();
            for (Produto produtoCollectionNewProdutoToAttach : produtoCollectionNew) {
                produtoCollectionNewProdutoToAttach = em.getReference(produtoCollectionNewProdutoToAttach.getClass(), produtoCollectionNewProdutoToAttach.getCodprod());
                attachedProdutoCollectionNew.add(produtoCollectionNewProdutoToAttach);
            }
            produtoCollectionNew = attachedProdutoCollectionNew;
            produtoperigoso.setProdutoCollection(produtoCollectionNew);
            produtoperigoso = em.merge(produtoperigoso);
            for (Produto produtoCollectionOldProduto : produtoCollectionOld) {
                if (!produtoCollectionNew.contains(produtoCollectionOldProduto)) {
                    produtoCollectionOldProduto.setCodprodutoperigoso(null);
                    produtoCollectionOldProduto = em.merge(produtoCollectionOldProduto);
                }
            }
            for (Produto produtoCollectionNewProduto : produtoCollectionNew) {
                if (!produtoCollectionOld.contains(produtoCollectionNewProduto)) {
                    Produtoperigoso oldCodprodutoperigosoOfProdutoCollectionNewProduto = produtoCollectionNewProduto.getCodprodutoperigoso();
                    produtoCollectionNewProduto.setCodprodutoperigoso(produtoperigoso);
                    produtoCollectionNewProduto = em.merge(produtoCollectionNewProduto);
                    if (oldCodprodutoperigosoOfProdutoCollectionNewProduto != null && !oldCodprodutoperigosoOfProdutoCollectionNewProduto.equals(produtoperigoso)) {
                        oldCodprodutoperigosoOfProdutoCollectionNewProduto.getProdutoCollection().remove(produtoCollectionNewProduto);
                        oldCodprodutoperigosoOfProdutoCollectionNewProduto = em.merge(oldCodprodutoperigosoOfProdutoCollectionNewProduto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = produtoperigoso.getCodprodutoperigoso();
                if (findProdutoperigoso(id) == null) {
                    throw new NonexistentEntityException("The produtoperigoso with id " + id + " no longer exists.");
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
            Produtoperigoso produtoperigoso;
            try {
                produtoperigoso = em.getReference(Produtoperigoso.class, id);
                produtoperigoso.getCodprodutoperigoso();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtoperigoso with id " + id + " no longer exists.", enfe);
            }
            Collection<Produto> produtoCollection = produtoperigoso.getProdutoCollection();
            for (Produto produtoCollectionProduto : produtoCollection) {
                produtoCollectionProduto.setCodprodutoperigoso(null);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
            }
            em.remove(produtoperigoso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtoperigoso> findProdutoperigosoEntities() {
        return findProdutoperigosoEntities(true, -1, -1);
    }

    public List<Produtoperigoso> findProdutoperigosoEntities(int maxResults, int firstResult) {
        return findProdutoperigosoEntities(false, maxResults, firstResult);
    }

    private List<Produtoperigoso> findProdutoperigosoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtoperigoso.class));
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

    public Produtoperigoso findProdutoperigoso(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtoperigoso.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutoperigosoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtoperigoso> rt = cq.from(Produtoperigoso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

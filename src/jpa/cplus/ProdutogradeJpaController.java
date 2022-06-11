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
import entidade.cplus.Produtograde;
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
public class ProdutogradeJpaController implements Serializable {

    public ProdutogradeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtograde produtograde) throws PreexistingEntityException, Exception {
        if (produtograde.getProdutoCollection() == null) {
            produtograde.setProdutoCollection(new ArrayList<Produto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Produto> attachedProdutoCollection = new ArrayList<Produto>();
            for (Produto produtoCollectionProdutoToAttach : produtograde.getProdutoCollection()) {
                produtoCollectionProdutoToAttach = em.getReference(produtoCollectionProdutoToAttach.getClass(), produtoCollectionProdutoToAttach.getCodprod());
                attachedProdutoCollection.add(produtoCollectionProdutoToAttach);
            }
            produtograde.setProdutoCollection(attachedProdutoCollection);
            em.persist(produtograde);
            for (Produto produtoCollectionProduto : produtograde.getProdutoCollection()) {
                Produtograde oldCodprodgradeOfProdutoCollectionProduto = produtoCollectionProduto.getCodprodgrade();
                produtoCollectionProduto.setCodprodgrade(produtograde);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
                if (oldCodprodgradeOfProdutoCollectionProduto != null) {
                    oldCodprodgradeOfProdutoCollectionProduto.getProdutoCollection().remove(produtoCollectionProduto);
                    oldCodprodgradeOfProdutoCollectionProduto = em.merge(oldCodprodgradeOfProdutoCollectionProduto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProdutograde(produtograde.getCodprodgrade()) != null) {
                throw new PreexistingEntityException("Produtograde " + produtograde + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtograde produtograde) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtograde persistentProdutograde = em.find(Produtograde.class, produtograde.getCodprodgrade());
            Collection<Produto> produtoCollectionOld = persistentProdutograde.getProdutoCollection();
            Collection<Produto> produtoCollectionNew = produtograde.getProdutoCollection();
            Collection<Produto> attachedProdutoCollectionNew = new ArrayList<Produto>();
            for (Produto produtoCollectionNewProdutoToAttach : produtoCollectionNew) {
                produtoCollectionNewProdutoToAttach = em.getReference(produtoCollectionNewProdutoToAttach.getClass(), produtoCollectionNewProdutoToAttach.getCodprod());
                attachedProdutoCollectionNew.add(produtoCollectionNewProdutoToAttach);
            }
            produtoCollectionNew = attachedProdutoCollectionNew;
            produtograde.setProdutoCollection(produtoCollectionNew);
            produtograde = em.merge(produtograde);
            for (Produto produtoCollectionOldProduto : produtoCollectionOld) {
                if (!produtoCollectionNew.contains(produtoCollectionOldProduto)) {
                    produtoCollectionOldProduto.setCodprodgrade(null);
                    produtoCollectionOldProduto = em.merge(produtoCollectionOldProduto);
                }
            }
            for (Produto produtoCollectionNewProduto : produtoCollectionNew) {
                if (!produtoCollectionOld.contains(produtoCollectionNewProduto)) {
                    Produtograde oldCodprodgradeOfProdutoCollectionNewProduto = produtoCollectionNewProduto.getCodprodgrade();
                    produtoCollectionNewProduto.setCodprodgrade(produtograde);
                    produtoCollectionNewProduto = em.merge(produtoCollectionNewProduto);
                    if (oldCodprodgradeOfProdutoCollectionNewProduto != null && !oldCodprodgradeOfProdutoCollectionNewProduto.equals(produtograde)) {
                        oldCodprodgradeOfProdutoCollectionNewProduto.getProdutoCollection().remove(produtoCollectionNewProduto);
                        oldCodprodgradeOfProdutoCollectionNewProduto = em.merge(oldCodprodgradeOfProdutoCollectionNewProduto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = produtograde.getCodprodgrade();
                if (findProdutograde(id) == null) {
                    throw new NonexistentEntityException("The produtograde with id " + id + " no longer exists.");
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
            Produtograde produtograde;
            try {
                produtograde = em.getReference(Produtograde.class, id);
                produtograde.getCodprodgrade();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtograde with id " + id + " no longer exists.", enfe);
            }
            Collection<Produto> produtoCollection = produtograde.getProdutoCollection();
            for (Produto produtoCollectionProduto : produtoCollection) {
                produtoCollectionProduto.setCodprodgrade(null);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
            }
            em.remove(produtograde);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtograde> findProdutogradeEntities() {
        return findProdutogradeEntities(true, -1, -1);
    }

    public List<Produtograde> findProdutogradeEntities(int maxResults, int firstResult) {
        return findProdutogradeEntities(false, maxResults, firstResult);
    }

    private List<Produtograde> findProdutogradeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtograde.class));
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

    public Produtograde findProdutograde(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtograde.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutogradeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtograde> rt = cq.from(Produtograde.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

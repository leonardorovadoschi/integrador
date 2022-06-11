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
import entidade.cplus.Produtoanp;
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
public class ProdutoanpJpaController implements Serializable {

    public ProdutoanpJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtoanp produtoanp) throws PreexistingEntityException, Exception {
        if (produtoanp.getProdutoCollection() == null) {
            produtoanp.setProdutoCollection(new ArrayList<Produto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Produto> attachedProdutoCollection = new ArrayList<Produto>();
            for (Produto produtoCollectionProdutoToAttach : produtoanp.getProdutoCollection()) {
                produtoCollectionProdutoToAttach = em.getReference(produtoCollectionProdutoToAttach.getClass(), produtoCollectionProdutoToAttach.getCodprod());
                attachedProdutoCollection.add(produtoCollectionProdutoToAttach);
            }
            produtoanp.setProdutoCollection(attachedProdutoCollection);
            em.persist(produtoanp);
            for (Produto produtoCollectionProduto : produtoanp.getProdutoCollection()) {
                Produtoanp oldCodprodutoanpOfProdutoCollectionProduto = produtoCollectionProduto.getCodprodutoanp();
                produtoCollectionProduto.setCodprodutoanp(produtoanp);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
                if (oldCodprodutoanpOfProdutoCollectionProduto != null) {
                    oldCodprodutoanpOfProdutoCollectionProduto.getProdutoCollection().remove(produtoCollectionProduto);
                    oldCodprodutoanpOfProdutoCollectionProduto = em.merge(oldCodprodutoanpOfProdutoCollectionProduto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProdutoanp(produtoanp.getCodprodutoanp()) != null) {
                throw new PreexistingEntityException("Produtoanp " + produtoanp + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtoanp produtoanp) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtoanp persistentProdutoanp = em.find(Produtoanp.class, produtoanp.getCodprodutoanp());
            Collection<Produto> produtoCollectionOld = persistentProdutoanp.getProdutoCollection();
            Collection<Produto> produtoCollectionNew = produtoanp.getProdutoCollection();
            Collection<Produto> attachedProdutoCollectionNew = new ArrayList<Produto>();
            for (Produto produtoCollectionNewProdutoToAttach : produtoCollectionNew) {
                produtoCollectionNewProdutoToAttach = em.getReference(produtoCollectionNewProdutoToAttach.getClass(), produtoCollectionNewProdutoToAttach.getCodprod());
                attachedProdutoCollectionNew.add(produtoCollectionNewProdutoToAttach);
            }
            produtoCollectionNew = attachedProdutoCollectionNew;
            produtoanp.setProdutoCollection(produtoCollectionNew);
            produtoanp = em.merge(produtoanp);
            for (Produto produtoCollectionOldProduto : produtoCollectionOld) {
                if (!produtoCollectionNew.contains(produtoCollectionOldProduto)) {
                    produtoCollectionOldProduto.setCodprodutoanp(null);
                    produtoCollectionOldProduto = em.merge(produtoCollectionOldProduto);
                }
            }
            for (Produto produtoCollectionNewProduto : produtoCollectionNew) {
                if (!produtoCollectionOld.contains(produtoCollectionNewProduto)) {
                    Produtoanp oldCodprodutoanpOfProdutoCollectionNewProduto = produtoCollectionNewProduto.getCodprodutoanp();
                    produtoCollectionNewProduto.setCodprodutoanp(produtoanp);
                    produtoCollectionNewProduto = em.merge(produtoCollectionNewProduto);
                    if (oldCodprodutoanpOfProdutoCollectionNewProduto != null && !oldCodprodutoanpOfProdutoCollectionNewProduto.equals(produtoanp)) {
                        oldCodprodutoanpOfProdutoCollectionNewProduto.getProdutoCollection().remove(produtoCollectionNewProduto);
                        oldCodprodutoanpOfProdutoCollectionNewProduto = em.merge(oldCodprodutoanpOfProdutoCollectionNewProduto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = produtoanp.getCodprodutoanp();
                if (findProdutoanp(id) == null) {
                    throw new NonexistentEntityException("The produtoanp with id " + id + " no longer exists.");
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
            Produtoanp produtoanp;
            try {
                produtoanp = em.getReference(Produtoanp.class, id);
                produtoanp.getCodprodutoanp();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtoanp with id " + id + " no longer exists.", enfe);
            }
            Collection<Produto> produtoCollection = produtoanp.getProdutoCollection();
            for (Produto produtoCollectionProduto : produtoCollection) {
                produtoCollectionProduto.setCodprodutoanp(null);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
            }
            em.remove(produtoanp);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtoanp> findProdutoanpEntities() {
        return findProdutoanpEntities(true, -1, -1);
    }

    public List<Produtoanp> findProdutoanpEntities(int maxResults, int firstResult) {
        return findProdutoanpEntities(false, maxResults, firstResult);
    }

    private List<Produtoanp> findProdutoanpEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtoanp.class));
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

    public Produtoanp findProdutoanp(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtoanp.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutoanpCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtoanp> rt = cq.from(Produtoanp.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

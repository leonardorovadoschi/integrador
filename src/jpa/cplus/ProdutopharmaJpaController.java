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
import entidade.cplus.Produtopharma;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.IllegalOrphanException;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ProdutopharmaJpaController implements Serializable {

    public ProdutopharmaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtopharma produtopharma) throws IllegalOrphanException, PreexistingEntityException, Exception {
        List<String> illegalOrphanMessages = null;
        Produto produtoOrphanCheck = produtopharma.getProduto();
        if (produtoOrphanCheck != null) {
            Produtopharma oldProdutopharmaOfProduto = produtoOrphanCheck.getProdutopharma();
            if (oldProdutopharmaOfProduto != null) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("The Produto " + produtoOrphanCheck + " already has an item of type Produtopharma whose produto column cannot be null. Please make another selection for the produto field.");
            }
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto produto = produtopharma.getProduto();
            if (produto != null) {
                produto = em.getReference(produto.getClass(), produto.getCodprod());
                produtopharma.setProduto(produto);
            }
            em.persist(produtopharma);
            if (produto != null) {
                produto.setProdutopharma(produtopharma);
                produto = em.merge(produto);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProdutopharma(produtopharma.getCodprod()) != null) {
                throw new PreexistingEntityException("Produtopharma " + produtopharma + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtopharma produtopharma) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtopharma persistentProdutopharma = em.find(Produtopharma.class, produtopharma.getCodprod());
            Produto produtoOld = persistentProdutopharma.getProduto();
            Produto produtoNew = produtopharma.getProduto();
            List<String> illegalOrphanMessages = null;
            if (produtoNew != null && !produtoNew.equals(produtoOld)) {
                Produtopharma oldProdutopharmaOfProduto = produtoNew.getProdutopharma();
                if (oldProdutopharmaOfProduto != null) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("The Produto " + produtoNew + " already has an item of type Produtopharma whose produto column cannot be null. Please make another selection for the produto field.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (produtoNew != null) {
                produtoNew = em.getReference(produtoNew.getClass(), produtoNew.getCodprod());
                produtopharma.setProduto(produtoNew);
            }
            produtopharma = em.merge(produtopharma);
            if (produtoOld != null && !produtoOld.equals(produtoNew)) {
                produtoOld.setProdutopharma(null);
                produtoOld = em.merge(produtoOld);
            }
            if (produtoNew != null && !produtoNew.equals(produtoOld)) {
                produtoNew.setProdutopharma(produtopharma);
                produtoNew = em.merge(produtoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = produtopharma.getCodprod();
                if (findProdutopharma(id) == null) {
                    throw new NonexistentEntityException("The produtopharma with id " + id + " no longer exists.");
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
            Produtopharma produtopharma;
            try {
                produtopharma = em.getReference(Produtopharma.class, id);
                produtopharma.getCodprod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtopharma with id " + id + " no longer exists.", enfe);
            }
            Produto produto = produtopharma.getProduto();
            if (produto != null) {
                produto.setProdutopharma(null);
                produto = em.merge(produto);
            }
            em.remove(produtopharma);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtopharma> findProdutopharmaEntities() {
        return findProdutopharmaEntities(true, -1, -1);
    }

    public List<Produtopharma> findProdutopharmaEntities(int maxResults, int firstResult) {
        return findProdutopharmaEntities(false, maxResults, firstResult);
    }

    private List<Produtopharma> findProdutopharmaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtopharma.class));
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

    public Produtopharma findProdutopharma(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtopharma.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutopharmaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtopharma> rt = cq.from(Produtopharma.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

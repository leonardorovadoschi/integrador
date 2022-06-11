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
import entidade.cplus.Preco;
import entidade.cplus.Produto;
import entidade.cplus.Produtoprecoescalonado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ProdutoprecoescalonadoJpaController implements Serializable {

    public ProdutoprecoescalonadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtoprecoescalonado produtoprecoescalonado) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Preco codpreco = produtoprecoescalonado.getCodpreco();
            if (codpreco != null) {
                codpreco = em.getReference(codpreco.getClass(), codpreco.getCodpreco());
                produtoprecoescalonado.setCodpreco(codpreco);
            }
            Produto codprod = produtoprecoescalonado.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                produtoprecoescalonado.setCodprod(codprod);
            }
            em.persist(produtoprecoescalonado);
            if (codpreco != null) {
                codpreco.getProdutoprecoescalonadoCollection().add(produtoprecoescalonado);
                codpreco = em.merge(codpreco);
            }
            if (codprod != null) {
                codprod.getProdutoprecoescalonadoCollection().add(produtoprecoescalonado);
                codprod = em.merge(codprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProdutoprecoescalonado(produtoprecoescalonado.getCodprodutoprecoescalonado()) != null) {
                throw new PreexistingEntityException("Produtoprecoescalonado " + produtoprecoescalonado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtoprecoescalonado produtoprecoescalonado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtoprecoescalonado persistentProdutoprecoescalonado = em.find(Produtoprecoescalonado.class, produtoprecoescalonado.getCodprodutoprecoescalonado());
            Preco codprecoOld = persistentProdutoprecoescalonado.getCodpreco();
            Preco codprecoNew = produtoprecoescalonado.getCodpreco();
            Produto codprodOld = persistentProdutoprecoescalonado.getCodprod();
            Produto codprodNew = produtoprecoescalonado.getCodprod();
            if (codprecoNew != null) {
                codprecoNew = em.getReference(codprecoNew.getClass(), codprecoNew.getCodpreco());
                produtoprecoescalonado.setCodpreco(codprecoNew);
            }
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                produtoprecoescalonado.setCodprod(codprodNew);
            }
            produtoprecoescalonado = em.merge(produtoprecoescalonado);
            if (codprecoOld != null && !codprecoOld.equals(codprecoNew)) {
                codprecoOld.getProdutoprecoescalonadoCollection().remove(produtoprecoescalonado);
                codprecoOld = em.merge(codprecoOld);
            }
            if (codprecoNew != null && !codprecoNew.equals(codprecoOld)) {
                codprecoNew.getProdutoprecoescalonadoCollection().add(produtoprecoescalonado);
                codprecoNew = em.merge(codprecoNew);
            }
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getProdutoprecoescalonadoCollection().remove(produtoprecoescalonado);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getProdutoprecoescalonadoCollection().add(produtoprecoescalonado);
                codprodNew = em.merge(codprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = produtoprecoescalonado.getCodprodutoprecoescalonado();
                if (findProdutoprecoescalonado(id) == null) {
                    throw new NonexistentEntityException("The produtoprecoescalonado with id " + id + " no longer exists.");
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
            Produtoprecoescalonado produtoprecoescalonado;
            try {
                produtoprecoescalonado = em.getReference(Produtoprecoescalonado.class, id);
                produtoprecoescalonado.getCodprodutoprecoescalonado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtoprecoescalonado with id " + id + " no longer exists.", enfe);
            }
            Preco codpreco = produtoprecoescalonado.getCodpreco();
            if (codpreco != null) {
                codpreco.getProdutoprecoescalonadoCollection().remove(produtoprecoescalonado);
                codpreco = em.merge(codpreco);
            }
            Produto codprod = produtoprecoescalonado.getCodprod();
            if (codprod != null) {
                codprod.getProdutoprecoescalonadoCollection().remove(produtoprecoescalonado);
                codprod = em.merge(codprod);
            }
            em.remove(produtoprecoescalonado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtoprecoescalonado> findProdutoprecoescalonadoEntities() {
        return findProdutoprecoescalonadoEntities(true, -1, -1);
    }

    public List<Produtoprecoescalonado> findProdutoprecoescalonadoEntities(int maxResults, int firstResult) {
        return findProdutoprecoescalonadoEntities(false, maxResults, firstResult);
    }

    private List<Produtoprecoescalonado> findProdutoprecoescalonadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtoprecoescalonado.class));
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

    public Produtoprecoescalonado findProdutoprecoescalonado(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtoprecoescalonado.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutoprecoescalonadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtoprecoescalonado> rt = cq.from(Produtoprecoescalonado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

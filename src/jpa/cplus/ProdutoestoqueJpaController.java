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
import entidade.cplus.Produto;
import entidade.cplus.Produtoestoque;
import entidade.cplus.ProdutoestoquePK;
import entidade.cplus.Setorestoque;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ProdutoestoqueJpaController implements Serializable {

    public ProdutoestoqueJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtoestoque produtoestoque) throws PreexistingEntityException, Exception {
        if (produtoestoque.getProdutoestoquePK() == null) {
            produtoestoque.setProdutoestoquePK(new ProdutoestoquePK());
        }
        produtoestoque.getProdutoestoquePK().setCodempresa(produtoestoque.getEmpresa().getCodempresa());
        produtoestoque.getProdutoestoquePK().setCodprod(produtoestoque.getProduto().getCodprod());
        produtoestoque.getProdutoestoquePK().setCodsetorestoque(produtoestoque.getSetorestoque().getCodsetorestoque());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa empresa = produtoestoque.getEmpresa();
            if (empresa != null) {
                empresa = em.getReference(empresa.getClass(), empresa.getCodempresa());
                produtoestoque.setEmpresa(empresa);
            }
            Produto produto = produtoestoque.getProduto();
            if (produto != null) {
                produto = em.getReference(produto.getClass(), produto.getCodprod());
                produtoestoque.setProduto(produto);
            }
            Setorestoque setorestoque = produtoestoque.getSetorestoque();
            if (setorestoque != null) {
                setorestoque = em.getReference(setorestoque.getClass(), setorestoque.getCodsetorestoque());
                produtoestoque.setSetorestoque(setorestoque);
            }
            em.persist(produtoestoque);
            if (empresa != null) {
                empresa.getProdutoestoqueCollection().add(produtoestoque);
                empresa = em.merge(empresa);
            }
            if (produto != null) {
                produto.getProdutoestoqueCollection().add(produtoestoque);
                produto = em.merge(produto);
            }
            if (setorestoque != null) {
                setorestoque.getProdutoestoqueCollection().add(produtoestoque);
                setorestoque = em.merge(setorestoque);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProdutoestoque(produtoestoque.getProdutoestoquePK()) != null) {
                throw new PreexistingEntityException("Produtoestoque " + produtoestoque + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtoestoque produtoestoque) throws NonexistentEntityException, Exception {
        produtoestoque.getProdutoestoquePK().setCodempresa(produtoestoque.getEmpresa().getCodempresa());
        produtoestoque.getProdutoestoquePK().setCodprod(produtoestoque.getProduto().getCodprod());
        produtoestoque.getProdutoestoquePK().setCodsetorestoque(produtoestoque.getSetorestoque().getCodsetorestoque());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtoestoque persistentProdutoestoque = em.find(Produtoestoque.class, produtoestoque.getProdutoestoquePK());
            Empresa empresaOld = persistentProdutoestoque.getEmpresa();
            Empresa empresaNew = produtoestoque.getEmpresa();
            Produto produtoOld = persistentProdutoestoque.getProduto();
            Produto produtoNew = produtoestoque.getProduto();
            Setorestoque setorestoqueOld = persistentProdutoestoque.getSetorestoque();
            Setorestoque setorestoqueNew = produtoestoque.getSetorestoque();
            if (empresaNew != null) {
                empresaNew = em.getReference(empresaNew.getClass(), empresaNew.getCodempresa());
                produtoestoque.setEmpresa(empresaNew);
            }
            if (produtoNew != null) {
                produtoNew = em.getReference(produtoNew.getClass(), produtoNew.getCodprod());
                produtoestoque.setProduto(produtoNew);
            }
            if (setorestoqueNew != null) {
                setorestoqueNew = em.getReference(setorestoqueNew.getClass(), setorestoqueNew.getCodsetorestoque());
                produtoestoque.setSetorestoque(setorestoqueNew);
            }
            produtoestoque = em.merge(produtoestoque);
            if (empresaOld != null && !empresaOld.equals(empresaNew)) {
                empresaOld.getProdutoestoqueCollection().remove(produtoestoque);
                empresaOld = em.merge(empresaOld);
            }
            if (empresaNew != null && !empresaNew.equals(empresaOld)) {
                empresaNew.getProdutoestoqueCollection().add(produtoestoque);
                empresaNew = em.merge(empresaNew);
            }
            if (produtoOld != null && !produtoOld.equals(produtoNew)) {
                produtoOld.getProdutoestoqueCollection().remove(produtoestoque);
                produtoOld = em.merge(produtoOld);
            }
            if (produtoNew != null && !produtoNew.equals(produtoOld)) {
                produtoNew.getProdutoestoqueCollection().add(produtoestoque);
                produtoNew = em.merge(produtoNew);
            }
            if (setorestoqueOld != null && !setorestoqueOld.equals(setorestoqueNew)) {
                setorestoqueOld.getProdutoestoqueCollection().remove(produtoestoque);
                setorestoqueOld = em.merge(setorestoqueOld);
            }
            if (setorestoqueNew != null && !setorestoqueNew.equals(setorestoqueOld)) {
                setorestoqueNew.getProdutoestoqueCollection().add(produtoestoque);
                setorestoqueNew = em.merge(setorestoqueNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                ProdutoestoquePK id = produtoestoque.getProdutoestoquePK();
                if (findProdutoestoque(id) == null) {
                    throw new NonexistentEntityException("The produtoestoque with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(ProdutoestoquePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtoestoque produtoestoque;
            try {
                produtoestoque = em.getReference(Produtoestoque.class, id);
                produtoestoque.getProdutoestoquePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtoestoque with id " + id + " no longer exists.", enfe);
            }
            Empresa empresa = produtoestoque.getEmpresa();
            if (empresa != null) {
                empresa.getProdutoestoqueCollection().remove(produtoestoque);
                empresa = em.merge(empresa);
            }
            Produto produto = produtoestoque.getProduto();
            if (produto != null) {
                produto.getProdutoestoqueCollection().remove(produtoestoque);
                produto = em.merge(produto);
            }
            Setorestoque setorestoque = produtoestoque.getSetorestoque();
            if (setorestoque != null) {
                setorestoque.getProdutoestoqueCollection().remove(produtoestoque);
                setorestoque = em.merge(setorestoque);
            }
            em.remove(produtoestoque);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtoestoque> findProdutoestoqueEntities() {
        return findProdutoestoqueEntities(true, -1, -1);
    }

    public List<Produtoestoque> findProdutoestoqueEntities(int maxResults, int firstResult) {
        return findProdutoestoqueEntities(false, maxResults, firstResult);
    }

    private List<Produtoestoque> findProdutoestoqueEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtoestoque.class));
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

    public Produtoestoque findProdutoestoque(ProdutoestoquePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtoestoque.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutoestoqueCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtoestoque> rt = cq.from(Produtoestoque.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Produtofaixacomissao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ProdutofaixacomissaoJpaController implements Serializable {

    public ProdutofaixacomissaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtofaixacomissao produtofaixacomissao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(produtofaixacomissao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProdutofaixacomissao(produtofaixacomissao.getCodprodutofaixacomissao()) != null) {
                throw new PreexistingEntityException("Produtofaixacomissao " + produtofaixacomissao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtofaixacomissao produtofaixacomissao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            produtofaixacomissao = em.merge(produtofaixacomissao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = produtofaixacomissao.getCodprodutofaixacomissao();
                if (findProdutofaixacomissao(id) == null) {
                    throw new NonexistentEntityException("The produtofaixacomissao with id " + id + " no longer exists.");
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
            Produtofaixacomissao produtofaixacomissao;
            try {
                produtofaixacomissao = em.getReference(Produtofaixacomissao.class, id);
                produtofaixacomissao.getCodprodutofaixacomissao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtofaixacomissao with id " + id + " no longer exists.", enfe);
            }
            em.remove(produtofaixacomissao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtofaixacomissao> findProdutofaixacomissaoEntities() {
        return findProdutofaixacomissaoEntities(true, -1, -1);
    }

    public List<Produtofaixacomissao> findProdutofaixacomissaoEntities(int maxResults, int firstResult) {
        return findProdutofaixacomissaoEntities(false, maxResults, firstResult);
    }

    private List<Produtofaixacomissao> findProdutofaixacomissaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtofaixacomissao.class));
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

    public Produtofaixacomissao findProdutofaixacomissao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtofaixacomissao.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutofaixacomissaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtofaixacomissao> rt = cq.from(Produtofaixacomissao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

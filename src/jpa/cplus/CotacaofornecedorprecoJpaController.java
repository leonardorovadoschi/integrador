/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Cotacaofornecedorpreco;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Cotacaoproduto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class CotacaofornecedorprecoJpaController implements Serializable {

    public CotacaofornecedorprecoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cotacaofornecedorpreco cotacaofornecedorpreco) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cotacaoproduto codcotacaoproduto = cotacaofornecedorpreco.getCodcotacaoproduto();
            if (codcotacaoproduto != null) {
                codcotacaoproduto = em.getReference(codcotacaoproduto.getClass(), codcotacaoproduto.getCodcotacaoproduto());
                cotacaofornecedorpreco.setCodcotacaoproduto(codcotacaoproduto);
            }
            em.persist(cotacaofornecedorpreco);
            if (codcotacaoproduto != null) {
                codcotacaoproduto.getCotacaofornecedorprecoCollection().add(cotacaofornecedorpreco);
                codcotacaoproduto = em.merge(codcotacaoproduto);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCotacaofornecedorpreco(cotacaofornecedorpreco.getCodcotacaofornecedorpreco()) != null) {
                throw new PreexistingEntityException("Cotacaofornecedorpreco " + cotacaofornecedorpreco + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cotacaofornecedorpreco cotacaofornecedorpreco) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cotacaofornecedorpreco persistentCotacaofornecedorpreco = em.find(Cotacaofornecedorpreco.class, cotacaofornecedorpreco.getCodcotacaofornecedorpreco());
            Cotacaoproduto codcotacaoprodutoOld = persistentCotacaofornecedorpreco.getCodcotacaoproduto();
            Cotacaoproduto codcotacaoprodutoNew = cotacaofornecedorpreco.getCodcotacaoproduto();
            if (codcotacaoprodutoNew != null) {
                codcotacaoprodutoNew = em.getReference(codcotacaoprodutoNew.getClass(), codcotacaoprodutoNew.getCodcotacaoproduto());
                cotacaofornecedorpreco.setCodcotacaoproduto(codcotacaoprodutoNew);
            }
            cotacaofornecedorpreco = em.merge(cotacaofornecedorpreco);
            if (codcotacaoprodutoOld != null && !codcotacaoprodutoOld.equals(codcotacaoprodutoNew)) {
                codcotacaoprodutoOld.getCotacaofornecedorprecoCollection().remove(cotacaofornecedorpreco);
                codcotacaoprodutoOld = em.merge(codcotacaoprodutoOld);
            }
            if (codcotacaoprodutoNew != null && !codcotacaoprodutoNew.equals(codcotacaoprodutoOld)) {
                codcotacaoprodutoNew.getCotacaofornecedorprecoCollection().add(cotacaofornecedorpreco);
                codcotacaoprodutoNew = em.merge(codcotacaoprodutoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cotacaofornecedorpreco.getCodcotacaofornecedorpreco();
                if (findCotacaofornecedorpreco(id) == null) {
                    throw new NonexistentEntityException("The cotacaofornecedorpreco with id " + id + " no longer exists.");
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
            Cotacaofornecedorpreco cotacaofornecedorpreco;
            try {
                cotacaofornecedorpreco = em.getReference(Cotacaofornecedorpreco.class, id);
                cotacaofornecedorpreco.getCodcotacaofornecedorpreco();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cotacaofornecedorpreco with id " + id + " no longer exists.", enfe);
            }
            Cotacaoproduto codcotacaoproduto = cotacaofornecedorpreco.getCodcotacaoproduto();
            if (codcotacaoproduto != null) {
                codcotacaoproduto.getCotacaofornecedorprecoCollection().remove(cotacaofornecedorpreco);
                codcotacaoproduto = em.merge(codcotacaoproduto);
            }
            em.remove(cotacaofornecedorpreco);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cotacaofornecedorpreco> findCotacaofornecedorprecoEntities() {
        return findCotacaofornecedorprecoEntities(true, -1, -1);
    }

    public List<Cotacaofornecedorpreco> findCotacaofornecedorprecoEntities(int maxResults, int firstResult) {
        return findCotacaofornecedorprecoEntities(false, maxResults, firstResult);
    }

    private List<Cotacaofornecedorpreco> findCotacaofornecedorprecoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cotacaofornecedorpreco.class));
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

    public Cotacaofornecedorpreco findCotacaofornecedorpreco(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cotacaofornecedorpreco.class, id);
        } finally {
            em.close();
        }
    }

    public int getCotacaofornecedorprecoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cotacaofornecedorpreco> rt = cq.from(Cotacaofornecedorpreco.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
import entidade.cplus.Produtocaracteristica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ProdutocaracteristicaJpaController implements Serializable {

    public ProdutocaracteristicaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtocaracteristica produtocaracteristica) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
           
            em.persist(produtocaracteristica);
            
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProdutocaracteristica(produtocaracteristica.getCodprodutocaracteristica()) != null) {
                throw new PreexistingEntityException("Produtocaracteristica " + produtocaracteristica + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtocaracteristica produtocaracteristica) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
           em.merge(produtocaracteristica);
           
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = produtocaracteristica.getCodprodutocaracteristica();
                if (findProdutocaracteristica(id) == null) {
                    throw new NonexistentEntityException("The produtocaracteristica with id " + id + " no longer exists.");
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
            Produtocaracteristica produtocaracteristica;
            try {
                produtocaracteristica = em.getReference(Produtocaracteristica.class, id);
                produtocaracteristica.getCodprodutocaracteristica();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtocaracteristica with id " + id + " no longer exists.", enfe);
            }
            
            em.remove(produtocaracteristica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtocaracteristica> findProdutocaracteristicaEntities() {
        return findProdutocaracteristicaEntities(true, -1, -1);
    }

    public List<Produtocaracteristica> findProdutocaracteristicaEntities(int maxResults, int firstResult) {
        return findProdutocaracteristicaEntities(false, maxResults, firstResult);
    }

    private List<Produtocaracteristica> findProdutocaracteristicaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtocaracteristica.class));
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

    public Produtocaracteristica findProdutocaracteristica(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtocaracteristica.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutocaracteristicaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtocaracteristica> rt = cq.from(Produtocaracteristica.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

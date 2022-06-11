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
import entidade.cplus.Produtofoto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ProdutofotoJpaController implements Serializable {

    public ProdutofotoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtofoto produtofoto) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto codprod = produtofoto.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                produtofoto.setCodprod(codprod);
            }
            em.persist(produtofoto);
            if (codprod != null) {
                codprod.getProdutofotoCollection().add(produtofoto);
                codprod = em.merge(codprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProdutofoto(produtofoto.getCodprodfoto()) != null) {
                throw new PreexistingEntityException("Produtofoto " + produtofoto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtofoto produtofoto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtofoto persistentProdutofoto = em.find(Produtofoto.class, produtofoto.getCodprodfoto());
            Produto codprodOld = persistentProdutofoto.getCodprod();
            Produto codprodNew = produtofoto.getCodprod();
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                produtofoto.setCodprod(codprodNew);
            }
            produtofoto = em.merge(produtofoto);
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getProdutofotoCollection().remove(produtofoto);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getProdutofotoCollection().add(produtofoto);
                codprodNew = em.merge(codprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = produtofoto.getCodprodfoto();
                if (findProdutofoto(id) == null) {
                    throw new NonexistentEntityException("The produtofoto with id " + id + " no longer exists.");
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
            Produtofoto produtofoto;
            try {
                produtofoto = em.getReference(Produtofoto.class, id);
                produtofoto.getCodprodfoto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtofoto with id " + id + " no longer exists.", enfe);
            }
            Produto codprod = produtofoto.getCodprod();
            if (codprod != null) {
                codprod.getProdutofotoCollection().remove(produtofoto);
                codprod = em.merge(codprod);
            }
            em.remove(produtofoto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtofoto> findProdutofotoEntities() {
        return findProdutofotoEntities(true, -1, -1);
    }

    public List<Produtofoto> findProdutofotoEntities(int maxResults, int firstResult) {
        return findProdutofotoEntities(false, maxResults, firstResult);
    }

    private List<Produtofoto> findProdutofotoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtofoto.class));
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

    public Produtofoto findProdutofoto(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtofoto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutofotoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtofoto> rt = cq.from(Produtofoto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

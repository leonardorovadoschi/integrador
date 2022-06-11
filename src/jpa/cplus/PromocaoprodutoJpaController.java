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
import entidade.cplus.Promocao;
import entidade.cplus.Promocaoproduto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class PromocaoprodutoJpaController implements Serializable {

    public PromocaoprodutoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Promocaoproduto promocaoproduto) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto codprod = promocaoproduto.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                promocaoproduto.setCodprod(codprod);
            }
            Promocao codpromocao = promocaoproduto.getCodpromocao();
            if (codpromocao != null) {
                codpromocao = em.getReference(codpromocao.getClass(), codpromocao.getCodpromocao());
                promocaoproduto.setCodpromocao(codpromocao);
            }
            em.persist(promocaoproduto);
            if (codprod != null) {
                codprod.getPromocaoprodutoCollection().add(promocaoproduto);
                codprod = em.merge(codprod);
            }
            if (codpromocao != null) {
                codpromocao.getPromocaoprodutoCollection().add(promocaoproduto);
                codpromocao = em.merge(codpromocao);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPromocaoproduto(promocaoproduto.getCodpromocaoproduto()) != null) {
                throw new PreexistingEntityException("Promocaoproduto " + promocaoproduto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Promocaoproduto promocaoproduto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Promocaoproduto persistentPromocaoproduto = em.find(Promocaoproduto.class, promocaoproduto.getCodpromocaoproduto());
            Produto codprodOld = persistentPromocaoproduto.getCodprod();
            Produto codprodNew = promocaoproduto.getCodprod();
            Promocao codpromocaoOld = persistentPromocaoproduto.getCodpromocao();
            Promocao codpromocaoNew = promocaoproduto.getCodpromocao();
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                promocaoproduto.setCodprod(codprodNew);
            }
            if (codpromocaoNew != null) {
                codpromocaoNew = em.getReference(codpromocaoNew.getClass(), codpromocaoNew.getCodpromocao());
                promocaoproduto.setCodpromocao(codpromocaoNew);
            }
            promocaoproduto = em.merge(promocaoproduto);
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getPromocaoprodutoCollection().remove(promocaoproduto);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getPromocaoprodutoCollection().add(promocaoproduto);
                codprodNew = em.merge(codprodNew);
            }
            if (codpromocaoOld != null && !codpromocaoOld.equals(codpromocaoNew)) {
                codpromocaoOld.getPromocaoprodutoCollection().remove(promocaoproduto);
                codpromocaoOld = em.merge(codpromocaoOld);
            }
            if (codpromocaoNew != null && !codpromocaoNew.equals(codpromocaoOld)) {
                codpromocaoNew.getPromocaoprodutoCollection().add(promocaoproduto);
                codpromocaoNew = em.merge(codpromocaoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = promocaoproduto.getCodpromocaoproduto();
                if (findPromocaoproduto(id) == null) {
                    throw new NonexistentEntityException("The promocaoproduto with id " + id + " no longer exists.");
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
            Promocaoproduto promocaoproduto;
            try {
                promocaoproduto = em.getReference(Promocaoproduto.class, id);
                promocaoproduto.getCodpromocaoproduto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The promocaoproduto with id " + id + " no longer exists.", enfe);
            }
            Produto codprod = promocaoproduto.getCodprod();
            if (codprod != null) {
                codprod.getPromocaoprodutoCollection().remove(promocaoproduto);
                codprod = em.merge(codprod);
            }
            Promocao codpromocao = promocaoproduto.getCodpromocao();
            if (codpromocao != null) {
                codpromocao.getPromocaoprodutoCollection().remove(promocaoproduto);
                codpromocao = em.merge(codpromocao);
            }
            em.remove(promocaoproduto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Promocaoproduto> findPromocaoprodutoEntities() {
        return findPromocaoprodutoEntities(true, -1, -1);
    }

    public List<Promocaoproduto> findPromocaoprodutoEntities(int maxResults, int firstResult) {
        return findPromocaoprodutoEntities(false, maxResults, firstResult);
    }

    private List<Promocaoproduto> findPromocaoprodutoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Promocaoproduto.class));
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

    public Promocaoproduto findPromocaoproduto(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Promocaoproduto.class, id);
        } finally {
            em.close();
        }
    }

    public int getPromocaoprodutoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Promocaoproduto> rt = cq.from(Promocaoproduto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

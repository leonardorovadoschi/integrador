/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Composicao;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ComposicaoJpaController implements Serializable {

    public ComposicaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Composicao composicao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto codprod = composicao.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                composicao.setCodprod(codprod);
            }
            em.persist(composicao);
            if (codprod != null) {
                codprod.getComposicaoCollection().add(composicao);
                codprod = em.merge(codprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findComposicao(composicao.getCodcomposicao()) != null) {
                throw new PreexistingEntityException("Composicao " + composicao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Composicao composicao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Composicao persistentComposicao = em.find(Composicao.class, composicao.getCodcomposicao());
            Produto codprodOld = persistentComposicao.getCodprod();
            Produto codprodNew = composicao.getCodprod();
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                composicao.setCodprod(codprodNew);
            }
            composicao = em.merge(composicao);
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getComposicaoCollection().remove(composicao);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getComposicaoCollection().add(composicao);
                codprodNew = em.merge(codprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = composicao.getCodcomposicao();
                if (findComposicao(id) == null) {
                    throw new NonexistentEntityException("The composicao with id " + id + " no longer exists.");
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
            Composicao composicao;
            try {
                composicao = em.getReference(Composicao.class, id);
                composicao.getCodcomposicao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The composicao with id " + id + " no longer exists.", enfe);
            }
            Produto codprod = composicao.getCodprod();
            if (codprod != null) {
                codprod.getComposicaoCollection().remove(composicao);
                codprod = em.merge(codprod);
            }
            em.remove(composicao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Composicao> findComposicaoEntities() {
        return findComposicaoEntities(true, -1, -1);
    }

    public List<Composicao> findComposicaoEntities(int maxResults, int firstResult) {
        return findComposicaoEntities(false, maxResults, firstResult);
    }

    private List<Composicao> findComposicaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Composicao.class));
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

    public Composicao findComposicao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Composicao.class, id);
        } finally {
            em.close();
        }
    }

    public int getComposicaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Composicao> rt = cq.from(Composicao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

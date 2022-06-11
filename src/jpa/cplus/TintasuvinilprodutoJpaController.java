/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Tintasuvinilproduto;
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
public class TintasuvinilprodutoJpaController implements Serializable {

    public TintasuvinilprodutoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tintasuvinilproduto tintasuvinilproduto) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tintasuvinilproduto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTintasuvinilproduto(tintasuvinilproduto.getCodtintasuvinilproduto()) != null) {
                throw new PreexistingEntityException("Tintasuvinilproduto " + tintasuvinilproduto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tintasuvinilproduto tintasuvinilproduto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tintasuvinilproduto = em.merge(tintasuvinilproduto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tintasuvinilproduto.getCodtintasuvinilproduto();
                if (findTintasuvinilproduto(id) == null) {
                    throw new NonexistentEntityException("The tintasuvinilproduto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tintasuvinilproduto tintasuvinilproduto;
            try {
                tintasuvinilproduto = em.getReference(Tintasuvinilproduto.class, id);
                tintasuvinilproduto.getCodtintasuvinilproduto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tintasuvinilproduto with id " + id + " no longer exists.", enfe);
            }
            em.remove(tintasuvinilproduto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tintasuvinilproduto> findTintasuvinilprodutoEntities() {
        return findTintasuvinilprodutoEntities(true, -1, -1);
    }

    public List<Tintasuvinilproduto> findTintasuvinilprodutoEntities(int maxResults, int firstResult) {
        return findTintasuvinilprodutoEntities(false, maxResults, firstResult);
    }

    private List<Tintasuvinilproduto> findTintasuvinilprodutoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tintasuvinilproduto.class));
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

    public Tintasuvinilproduto findTintasuvinilproduto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tintasuvinilproduto.class, id);
        } finally {
            em.close();
        }
    }

    public int getTintasuvinilprodutoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tintasuvinilproduto> rt = cq.from(Tintasuvinilproduto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

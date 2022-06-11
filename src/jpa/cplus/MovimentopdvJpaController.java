/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Movimentopdv;
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
public class MovimentopdvJpaController implements Serializable {

    public MovimentopdvJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movimentopdv movimentopdv) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(movimentopdv);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovimentopdv(movimentopdv.getCodmovimentopdv()) != null) {
                throw new PreexistingEntityException("Movimentopdv " + movimentopdv + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movimentopdv movimentopdv) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            movimentopdv = em.merge(movimentopdv);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = movimentopdv.getCodmovimentopdv();
                if (findMovimentopdv(id) == null) {
                    throw new NonexistentEntityException("The movimentopdv with id " + id + " no longer exists.");
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
            Movimentopdv movimentopdv;
            try {
                movimentopdv = em.getReference(Movimentopdv.class, id);
                movimentopdv.getCodmovimentopdv();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movimentopdv with id " + id + " no longer exists.", enfe);
            }
            em.remove(movimentopdv);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movimentopdv> findMovimentopdvEntities() {
        return findMovimentopdvEntities(true, -1, -1);
    }

    public List<Movimentopdv> findMovimentopdvEntities(int maxResults, int firstResult) {
        return findMovimentopdvEntities(false, maxResults, firstResult);
    }

    private List<Movimentopdv> findMovimentopdvEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movimentopdv.class));
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

    public Movimentopdv findMovimentopdv(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movimentopdv.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovimentopdvCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movimentopdv> rt = cq.from(Movimentopdv.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

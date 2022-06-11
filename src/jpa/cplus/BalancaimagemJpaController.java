/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Balancaimagem;
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
public class BalancaimagemJpaController implements Serializable {

    public BalancaimagemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Balancaimagem balancaimagem) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(balancaimagem);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBalancaimagem(balancaimagem.getCodbalancaimagem()) != null) {
                throw new PreexistingEntityException("Balancaimagem " + balancaimagem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Balancaimagem balancaimagem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            balancaimagem = em.merge(balancaimagem);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = balancaimagem.getCodbalancaimagem();
                if (findBalancaimagem(id) == null) {
                    throw new NonexistentEntityException("The balancaimagem with id " + id + " no longer exists.");
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
            Balancaimagem balancaimagem;
            try {
                balancaimagem = em.getReference(Balancaimagem.class, id);
                balancaimagem.getCodbalancaimagem();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The balancaimagem with id " + id + " no longer exists.", enfe);
            }
            em.remove(balancaimagem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Balancaimagem> findBalancaimagemEntities() {
        return findBalancaimagemEntities(true, -1, -1);
    }

    public List<Balancaimagem> findBalancaimagemEntities(int maxResults, int firstResult) {
        return findBalancaimagemEntities(false, maxResults, firstResult);
    }

    private List<Balancaimagem> findBalancaimagemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Balancaimagem.class));
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

    public Balancaimagem findBalancaimagem(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Balancaimagem.class, id);
        } finally {
            em.close();
        }
    }

    public int getBalancaimagemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Balancaimagem> rt = cq.from(Balancaimagem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

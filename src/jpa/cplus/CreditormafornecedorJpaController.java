/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Creditormafornecedor;
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
public class CreditormafornecedorJpaController implements Serializable {

    public CreditormafornecedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Creditormafornecedor creditormafornecedor) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(creditormafornecedor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCreditormafornecedor(creditormafornecedor.getCodcrediforn()) != null) {
                throw new PreexistingEntityException("Creditormafornecedor " + creditormafornecedor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Creditormafornecedor creditormafornecedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            creditormafornecedor = em.merge(creditormafornecedor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = creditormafornecedor.getCodcrediforn();
                if (findCreditormafornecedor(id) == null) {
                    throw new NonexistentEntityException("The creditormafornecedor with id " + id + " no longer exists.");
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
            Creditormafornecedor creditormafornecedor;
            try {
                creditormafornecedor = em.getReference(Creditormafornecedor.class, id);
                creditormafornecedor.getCodcrediforn();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The creditormafornecedor with id " + id + " no longer exists.", enfe);
            }
            em.remove(creditormafornecedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Creditormafornecedor> findCreditormafornecedorEntities() {
        return findCreditormafornecedorEntities(true, -1, -1);
    }

    public List<Creditormafornecedor> findCreditormafornecedorEntities(int maxResults, int firstResult) {
        return findCreditormafornecedorEntities(false, maxResults, firstResult);
    }

    private List<Creditormafornecedor> findCreditormafornecedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Creditormafornecedor.class));
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

    public Creditormafornecedor findCreditormafornecedor(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Creditormafornecedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getCreditormafornecedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Creditormafornecedor> rt = cq.from(Creditormafornecedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

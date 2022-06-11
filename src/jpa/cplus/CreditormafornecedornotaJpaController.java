/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Creditormafornecedornota;
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
public class CreditormafornecedornotaJpaController implements Serializable {

    public CreditormafornecedornotaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Creditormafornecedornota creditormafornecedornota) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(creditormafornecedornota);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCreditormafornecedornota(creditormafornecedornota.getCodcredifornnota()) != null) {
                throw new PreexistingEntityException("Creditormafornecedornota " + creditormafornecedornota + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Creditormafornecedornota creditormafornecedornota) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            creditormafornecedornota = em.merge(creditormafornecedornota);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = creditormafornecedornota.getCodcredifornnota();
                if (findCreditormafornecedornota(id) == null) {
                    throw new NonexistentEntityException("The creditormafornecedornota with id " + id + " no longer exists.");
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
            Creditormafornecedornota creditormafornecedornota;
            try {
                creditormafornecedornota = em.getReference(Creditormafornecedornota.class, id);
                creditormafornecedornota.getCodcredifornnota();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The creditormafornecedornota with id " + id + " no longer exists.", enfe);
            }
            em.remove(creditormafornecedornota);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Creditormafornecedornota> findCreditormafornecedornotaEntities() {
        return findCreditormafornecedornotaEntities(true, -1, -1);
    }

    public List<Creditormafornecedornota> findCreditormafornecedornotaEntities(int maxResults, int firstResult) {
        return findCreditormafornecedornotaEntities(false, maxResults, firstResult);
    }

    private List<Creditormafornecedornota> findCreditormafornecedornotaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Creditormafornecedornota.class));
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

    public Creditormafornecedornota findCreditormafornecedornota(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Creditormafornecedornota.class, id);
        } finally {
            em.close();
        }
    }

    public int getCreditormafornecedornotaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Creditormafornecedornota> rt = cq.from(Creditormafornecedornota.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

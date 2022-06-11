/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsWebserviceAccount;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.prestaShop.exceptions.NonexistentEntityException;

/**
 *
 * @author leo
 */
public class PsWebserviceAccountJpaController implements Serializable {

    public PsWebserviceAccountJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsWebserviceAccount psWebserviceAccount) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psWebserviceAccount);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsWebserviceAccount psWebserviceAccount) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psWebserviceAccount = em.merge(psWebserviceAccount);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psWebserviceAccount.getIdWebserviceAccount();
                if (findPsWebserviceAccount(id) == null) {
                    throw new NonexistentEntityException("The psWebserviceAccount with id " + id + " no longer exists.");
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
            PsWebserviceAccount psWebserviceAccount;
            try {
                psWebserviceAccount = em.getReference(PsWebserviceAccount.class, id);
                psWebserviceAccount.getIdWebserviceAccount();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psWebserviceAccount with id " + id + " no longer exists.", enfe);
            }
            em.remove(psWebserviceAccount);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsWebserviceAccount> findPsWebserviceAccountEntities() {
        return findPsWebserviceAccountEntities(true, -1, -1);
    }

    public List<PsWebserviceAccount> findPsWebserviceAccountEntities(int maxResults, int firstResult) {
        return findPsWebserviceAccountEntities(false, maxResults, firstResult);
    }

    private List<PsWebserviceAccount> findPsWebserviceAccountEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsWebserviceAccount.class));
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

    public PsWebserviceAccount findPsWebserviceAccount(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsWebserviceAccount.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsWebserviceAccountCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsWebserviceAccount> rt = cq.from(PsWebserviceAccount.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

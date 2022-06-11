/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsEmailsubscription;
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
public class PsEmailsubscriptionJpaController implements Serializable {

    public PsEmailsubscriptionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsEmailsubscription psEmailsubscription) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psEmailsubscription);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsEmailsubscription psEmailsubscription) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psEmailsubscription = em.merge(psEmailsubscription);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psEmailsubscription.getId();
                if (findPsEmailsubscription(id) == null) {
                    throw new NonexistentEntityException("The psEmailsubscription with id " + id + " no longer exists.");
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
            PsEmailsubscription psEmailsubscription;
            try {
                psEmailsubscription = em.getReference(PsEmailsubscription.class, id);
                psEmailsubscription.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psEmailsubscription with id " + id + " no longer exists.", enfe);
            }
            em.remove(psEmailsubscription);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsEmailsubscription> findPsEmailsubscriptionEntities() {
        return findPsEmailsubscriptionEntities(true, -1, -1);
    }

    public List<PsEmailsubscription> findPsEmailsubscriptionEntities(int maxResults, int firstResult) {
        return findPsEmailsubscriptionEntities(false, maxResults, firstResult);
    }

    private List<PsEmailsubscription> findPsEmailsubscriptionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsEmailsubscription.class));
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

    public PsEmailsubscription findPsEmailsubscription(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsEmailsubscription.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsEmailsubscriptionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsEmailsubscription> rt = cq.from(PsEmailsubscription.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

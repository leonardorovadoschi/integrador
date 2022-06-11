/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsFeatureValue;
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
public class PsFeatureValueJpaController implements Serializable {

    public PsFeatureValueJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsFeatureValue psFeatureValue) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psFeatureValue);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsFeatureValue psFeatureValue) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psFeatureValue = em.merge(psFeatureValue);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psFeatureValue.getIdFeatureValue();
                if (findPsFeatureValue(id) == null) {
                    throw new NonexistentEntityException("The psFeatureValue with id " + id + " no longer exists.");
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
            PsFeatureValue psFeatureValue;
            try {
                psFeatureValue = em.getReference(PsFeatureValue.class, id);
                psFeatureValue.getIdFeatureValue();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psFeatureValue with id " + id + " no longer exists.", enfe);
            }
            em.remove(psFeatureValue);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsFeatureValue> findPsFeatureValueEntities() {
        return findPsFeatureValueEntities(true, -1, -1);
    }

    public List<PsFeatureValue> findPsFeatureValueEntities(int maxResults, int firstResult) {
        return findPsFeatureValueEntities(false, maxResults, firstResult);
    }

    private List<PsFeatureValue> findPsFeatureValueEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsFeatureValue.class));
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

    public PsFeatureValue findPsFeatureValue(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsFeatureValue.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsFeatureValueCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsFeatureValue> rt = cq.from(PsFeatureValue.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

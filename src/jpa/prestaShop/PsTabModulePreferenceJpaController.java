/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsTabModulePreference;
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
public class PsTabModulePreferenceJpaController implements Serializable {

    public PsTabModulePreferenceJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsTabModulePreference psTabModulePreference) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psTabModulePreference);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsTabModulePreference psTabModulePreference) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psTabModulePreference = em.merge(psTabModulePreference);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psTabModulePreference.getIdTabModulePreference();
                if (findPsTabModulePreference(id) == null) {
                    throw new NonexistentEntityException("The psTabModulePreference with id " + id + " no longer exists.");
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
            PsTabModulePreference psTabModulePreference;
            try {
                psTabModulePreference = em.getReference(PsTabModulePreference.class, id);
                psTabModulePreference.getIdTabModulePreference();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psTabModulePreference with id " + id + " no longer exists.", enfe);
            }
            em.remove(psTabModulePreference);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsTabModulePreference> findPsTabModulePreferenceEntities() {
        return findPsTabModulePreferenceEntities(true, -1, -1);
    }

    public List<PsTabModulePreference> findPsTabModulePreferenceEntities(int maxResults, int firstResult) {
        return findPsTabModulePreferenceEntities(false, maxResults, firstResult);
    }

    private List<PsTabModulePreference> findPsTabModulePreferenceEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsTabModulePreference.class));
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

    public PsTabModulePreference findPsTabModulePreference(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsTabModulePreference.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsTabModulePreferenceCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsTabModulePreference> rt = cq.from(PsTabModulePreference.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

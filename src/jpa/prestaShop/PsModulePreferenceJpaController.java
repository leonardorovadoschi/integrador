/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsModulePreference;
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
public class PsModulePreferenceJpaController implements Serializable {

    public PsModulePreferenceJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsModulePreference psModulePreference) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psModulePreference);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsModulePreference psModulePreference) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psModulePreference = em.merge(psModulePreference);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psModulePreference.getIdModulePreference();
                if (findPsModulePreference(id) == null) {
                    throw new NonexistentEntityException("The psModulePreference with id " + id + " no longer exists.");
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
            PsModulePreference psModulePreference;
            try {
                psModulePreference = em.getReference(PsModulePreference.class, id);
                psModulePreference.getIdModulePreference();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psModulePreference with id " + id + " no longer exists.", enfe);
            }
            em.remove(psModulePreference);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsModulePreference> findPsModulePreferenceEntities() {
        return findPsModulePreferenceEntities(true, -1, -1);
    }

    public List<PsModulePreference> findPsModulePreferenceEntities(int maxResults, int firstResult) {
        return findPsModulePreferenceEntities(false, maxResults, firstResult);
    }

    private List<PsModulePreference> findPsModulePreferenceEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsModulePreference.class));
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

    public PsModulePreference findPsModulePreference(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsModulePreference.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsModulePreferenceCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsModulePreference> rt = cq.from(PsModulePreference.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

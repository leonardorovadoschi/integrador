/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsConfiguration;
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
public class PsConfigurationJpaController implements Serializable {

    public PsConfigurationJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsConfiguration psConfiguration) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psConfiguration);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsConfiguration psConfiguration) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psConfiguration = em.merge(psConfiguration);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psConfiguration.getIdConfiguration();
                if (findPsConfiguration(id) == null) {
                    throw new NonexistentEntityException("The psConfiguration with id " + id + " no longer exists.");
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
            PsConfiguration psConfiguration;
            try {
                psConfiguration = em.getReference(PsConfiguration.class, id);
                psConfiguration.getIdConfiguration();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psConfiguration with id " + id + " no longer exists.", enfe);
            }
            em.remove(psConfiguration);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsConfiguration> findPsConfigurationEntities() {
        return findPsConfigurationEntities(true, -1, -1);
    }

    public List<PsConfiguration> findPsConfigurationEntities(int maxResults, int firstResult) {
        return findPsConfigurationEntities(false, maxResults, firstResult);
    }

    private List<PsConfiguration> findPsConfigurationEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsConfiguration.class));
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

    public PsConfiguration findPsConfiguration(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsConfiguration.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsConfigurationCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsConfiguration> rt = cq.from(PsConfiguration.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

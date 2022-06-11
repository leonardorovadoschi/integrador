/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsConfigurationKpi;
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
public class PsConfigurationKpiJpaController implements Serializable {

    public PsConfigurationKpiJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsConfigurationKpi psConfigurationKpi) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psConfigurationKpi);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsConfigurationKpi psConfigurationKpi) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psConfigurationKpi = em.merge(psConfigurationKpi);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psConfigurationKpi.getIdConfigurationKpi();
                if (findPsConfigurationKpi(id) == null) {
                    throw new NonexistentEntityException("The psConfigurationKpi with id " + id + " no longer exists.");
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
            PsConfigurationKpi psConfigurationKpi;
            try {
                psConfigurationKpi = em.getReference(PsConfigurationKpi.class, id);
                psConfigurationKpi.getIdConfigurationKpi();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psConfigurationKpi with id " + id + " no longer exists.", enfe);
            }
            em.remove(psConfigurationKpi);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsConfigurationKpi> findPsConfigurationKpiEntities() {
        return findPsConfigurationKpiEntities(true, -1, -1);
    }

    public List<PsConfigurationKpi> findPsConfigurationKpiEntities(int maxResults, int firstResult) {
        return findPsConfigurationKpiEntities(false, maxResults, firstResult);
    }

    private List<PsConfigurationKpi> findPsConfigurationKpiEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsConfigurationKpi.class));
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

    public PsConfigurationKpi findPsConfigurationKpi(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsConfigurationKpi.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsConfigurationKpiCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsConfigurationKpi> rt = cq.from(PsConfigurationKpi.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

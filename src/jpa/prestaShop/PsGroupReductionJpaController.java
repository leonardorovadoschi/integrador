/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsGroupReduction;
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
public class PsGroupReductionJpaController implements Serializable {

    public PsGroupReductionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsGroupReduction psGroupReduction) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psGroupReduction);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsGroupReduction psGroupReduction) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psGroupReduction = em.merge(psGroupReduction);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psGroupReduction.getIdGroupReduction();
                if (findPsGroupReduction(id) == null) {
                    throw new NonexistentEntityException("The psGroupReduction with id " + id + " no longer exists.");
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
            PsGroupReduction psGroupReduction;
            try {
                psGroupReduction = em.getReference(PsGroupReduction.class, id);
                psGroupReduction.getIdGroupReduction();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psGroupReduction with id " + id + " no longer exists.", enfe);
            }
            em.remove(psGroupReduction);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsGroupReduction> findPsGroupReductionEntities() {
        return findPsGroupReductionEntities(true, -1, -1);
    }

    public List<PsGroupReduction> findPsGroupReductionEntities(int maxResults, int firstResult) {
        return findPsGroupReductionEntities(false, maxResults, firstResult);
    }

    private List<PsGroupReduction> findPsGroupReductionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsGroupReduction.class));
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

    public PsGroupReduction findPsGroupReduction(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsGroupReduction.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsGroupReductionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsGroupReduction> rt = cq.from(PsGroupReduction.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

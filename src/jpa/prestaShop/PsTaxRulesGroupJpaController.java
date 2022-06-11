/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsTaxRulesGroup;
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
public class PsTaxRulesGroupJpaController implements Serializable {

    public PsTaxRulesGroupJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsTaxRulesGroup psTaxRulesGroup) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psTaxRulesGroup);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsTaxRulesGroup psTaxRulesGroup) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psTaxRulesGroup = em.merge(psTaxRulesGroup);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psTaxRulesGroup.getIdTaxRulesGroup();
                if (findPsTaxRulesGroup(id) == null) {
                    throw new NonexistentEntityException("The psTaxRulesGroup with id " + id + " no longer exists.");
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
            PsTaxRulesGroup psTaxRulesGroup;
            try {
                psTaxRulesGroup = em.getReference(PsTaxRulesGroup.class, id);
                psTaxRulesGroup.getIdTaxRulesGroup();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psTaxRulesGroup with id " + id + " no longer exists.", enfe);
            }
            em.remove(psTaxRulesGroup);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsTaxRulesGroup> findPsTaxRulesGroupEntities() {
        return findPsTaxRulesGroupEntities(true, -1, -1);
    }

    public List<PsTaxRulesGroup> findPsTaxRulesGroupEntities(int maxResults, int firstResult) {
        return findPsTaxRulesGroupEntities(false, maxResults, firstResult);
    }

    private List<PsTaxRulesGroup> findPsTaxRulesGroupEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsTaxRulesGroup.class));
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

    public PsTaxRulesGroup findPsTaxRulesGroup(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsTaxRulesGroup.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsTaxRulesGroupCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsTaxRulesGroup> rt = cq.from(PsTaxRulesGroup.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

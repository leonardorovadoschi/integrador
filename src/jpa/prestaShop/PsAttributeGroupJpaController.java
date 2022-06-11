/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsAttributeGroup;
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
public class PsAttributeGroupJpaController implements Serializable {

    public PsAttributeGroupJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsAttributeGroup psAttributeGroup) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psAttributeGroup);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsAttributeGroup psAttributeGroup) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psAttributeGroup = em.merge(psAttributeGroup);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psAttributeGroup.getIdAttributeGroup();
                if (findPsAttributeGroup(id) == null) {
                    throw new NonexistentEntityException("The psAttributeGroup with id " + id + " no longer exists.");
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
            PsAttributeGroup psAttributeGroup;
            try {
                psAttributeGroup = em.getReference(PsAttributeGroup.class, id);
                psAttributeGroup.getIdAttributeGroup();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psAttributeGroup with id " + id + " no longer exists.", enfe);
            }
            em.remove(psAttributeGroup);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsAttributeGroup> findPsAttributeGroupEntities() {
        return findPsAttributeGroupEntities(true, -1, -1);
    }

    public List<PsAttributeGroup> findPsAttributeGroupEntities(int maxResults, int firstResult) {
        return findPsAttributeGroupEntities(false, maxResults, firstResult);
    }

    private List<PsAttributeGroup> findPsAttributeGroupEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsAttributeGroup.class));
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

    public PsAttributeGroup findPsAttributeGroup(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsAttributeGroup.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsAttributeGroupCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsAttributeGroup> rt = cq.from(PsAttributeGroup.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

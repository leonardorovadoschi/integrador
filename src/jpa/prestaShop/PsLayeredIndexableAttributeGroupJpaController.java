/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsLayeredIndexableAttributeGroup;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.prestaShop.exceptions.NonexistentEntityException;
import jpa.prestaShop.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class PsLayeredIndexableAttributeGroupJpaController implements Serializable {

    public PsLayeredIndexableAttributeGroupJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsLayeredIndexableAttributeGroup psLayeredIndexableAttributeGroup) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psLayeredIndexableAttributeGroup);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsLayeredIndexableAttributeGroup(psLayeredIndexableAttributeGroup.getIdAttributeGroup()) != null) {
                throw new PreexistingEntityException("PsLayeredIndexableAttributeGroup " + psLayeredIndexableAttributeGroup + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsLayeredIndexableAttributeGroup psLayeredIndexableAttributeGroup) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psLayeredIndexableAttributeGroup = em.merge(psLayeredIndexableAttributeGroup);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psLayeredIndexableAttributeGroup.getIdAttributeGroup();
                if (findPsLayeredIndexableAttributeGroup(id) == null) {
                    throw new NonexistentEntityException("The psLayeredIndexableAttributeGroup with id " + id + " no longer exists.");
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
            PsLayeredIndexableAttributeGroup psLayeredIndexableAttributeGroup;
            try {
                psLayeredIndexableAttributeGroup = em.getReference(PsLayeredIndexableAttributeGroup.class, id);
                psLayeredIndexableAttributeGroup.getIdAttributeGroup();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psLayeredIndexableAttributeGroup with id " + id + " no longer exists.", enfe);
            }
            em.remove(psLayeredIndexableAttributeGroup);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsLayeredIndexableAttributeGroup> findPsLayeredIndexableAttributeGroupEntities() {
        return findPsLayeredIndexableAttributeGroupEntities(true, -1, -1);
    }

    public List<PsLayeredIndexableAttributeGroup> findPsLayeredIndexableAttributeGroupEntities(int maxResults, int firstResult) {
        return findPsLayeredIndexableAttributeGroupEntities(false, maxResults, firstResult);
    }

    private List<PsLayeredIndexableAttributeGroup> findPsLayeredIndexableAttributeGroupEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsLayeredIndexableAttributeGroup.class));
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

    public PsLayeredIndexableAttributeGroup findPsLayeredIndexableAttributeGroup(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsLayeredIndexableAttributeGroup.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsLayeredIndexableAttributeGroupCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsLayeredIndexableAttributeGroup> rt = cq.from(PsLayeredIndexableAttributeGroup.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

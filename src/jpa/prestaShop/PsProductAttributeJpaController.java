/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsProductAttribute;
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
public class PsProductAttributeJpaController implements Serializable {

    public PsProductAttributeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsProductAttribute psProductAttribute) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psProductAttribute);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsProductAttribute psProductAttribute) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psProductAttribute = em.merge(psProductAttribute);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psProductAttribute.getIdProductAttribute();
                if (findPsProductAttribute(id) == null) {
                    throw new NonexistentEntityException("The psProductAttribute with id " + id + " no longer exists.");
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
            PsProductAttribute psProductAttribute;
            try {
                psProductAttribute = em.getReference(PsProductAttribute.class, id);
                psProductAttribute.getIdProductAttribute();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psProductAttribute with id " + id + " no longer exists.", enfe);
            }
            em.remove(psProductAttribute);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsProductAttribute> findPsProductAttributeEntities() {
        return findPsProductAttributeEntities(true, -1, -1);
    }

    public List<PsProductAttribute> findPsProductAttributeEntities(int maxResults, int firstResult) {
        return findPsProductAttributeEntities(false, maxResults, firstResult);
    }

    private List<PsProductAttribute> findPsProductAttributeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsProductAttribute.class));
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

    public PsProductAttribute findPsProductAttribute(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsProductAttribute.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsProductAttributeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsProductAttribute> rt = cq.from(PsProductAttribute.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

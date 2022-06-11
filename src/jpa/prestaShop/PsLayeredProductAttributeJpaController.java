/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsLayeredProductAttribute;
import entidade.prestaShop.PsLayeredProductAttributePK;
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
public class PsLayeredProductAttributeJpaController implements Serializable {

    public PsLayeredProductAttributeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsLayeredProductAttribute psLayeredProductAttribute) throws PreexistingEntityException, Exception {
        if (psLayeredProductAttribute.getPsLayeredProductAttributePK() == null) {
            psLayeredProductAttribute.setPsLayeredProductAttributePK(new PsLayeredProductAttributePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psLayeredProductAttribute);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsLayeredProductAttribute(psLayeredProductAttribute.getPsLayeredProductAttributePK()) != null) {
                throw new PreexistingEntityException("PsLayeredProductAttribute " + psLayeredProductAttribute + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsLayeredProductAttribute psLayeredProductAttribute) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psLayeredProductAttribute = em.merge(psLayeredProductAttribute);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsLayeredProductAttributePK id = psLayeredProductAttribute.getPsLayeredProductAttributePK();
                if (findPsLayeredProductAttribute(id) == null) {
                    throw new NonexistentEntityException("The psLayeredProductAttribute with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsLayeredProductAttributePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsLayeredProductAttribute psLayeredProductAttribute;
            try {
                psLayeredProductAttribute = em.getReference(PsLayeredProductAttribute.class, id);
                psLayeredProductAttribute.getPsLayeredProductAttributePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psLayeredProductAttribute with id " + id + " no longer exists.", enfe);
            }
            em.remove(psLayeredProductAttribute);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsLayeredProductAttribute> findPsLayeredProductAttributeEntities() {
        return findPsLayeredProductAttributeEntities(true, -1, -1);
    }

    public List<PsLayeredProductAttribute> findPsLayeredProductAttributeEntities(int maxResults, int firstResult) {
        return findPsLayeredProductAttributeEntities(false, maxResults, firstResult);
    }

    private List<PsLayeredProductAttribute> findPsLayeredProductAttributeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsLayeredProductAttribute.class));
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

    public PsLayeredProductAttribute findPsLayeredProductAttribute(PsLayeredProductAttributePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsLayeredProductAttribute.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsLayeredProductAttributeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsLayeredProductAttribute> rt = cq.from(PsLayeredProductAttribute.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

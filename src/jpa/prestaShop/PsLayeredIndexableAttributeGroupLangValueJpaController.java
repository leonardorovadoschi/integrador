/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsLayeredIndexableAttributeGroupLangValue;
import entidade.prestaShop.PsLayeredIndexableAttributeGroupLangValuePK;
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
public class PsLayeredIndexableAttributeGroupLangValueJpaController implements Serializable {

    public PsLayeredIndexableAttributeGroupLangValueJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsLayeredIndexableAttributeGroupLangValue psLayeredIndexableAttributeGroupLangValue) throws PreexistingEntityException, Exception {
        if (psLayeredIndexableAttributeGroupLangValue.getPsLayeredIndexableAttributeGroupLangValuePK() == null) {
            psLayeredIndexableAttributeGroupLangValue.setPsLayeredIndexableAttributeGroupLangValuePK(new PsLayeredIndexableAttributeGroupLangValuePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psLayeredIndexableAttributeGroupLangValue);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsLayeredIndexableAttributeGroupLangValue(psLayeredIndexableAttributeGroupLangValue.getPsLayeredIndexableAttributeGroupLangValuePK()) != null) {
                throw new PreexistingEntityException("PsLayeredIndexableAttributeGroupLangValue " + psLayeredIndexableAttributeGroupLangValue + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsLayeredIndexableAttributeGroupLangValue psLayeredIndexableAttributeGroupLangValue) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psLayeredIndexableAttributeGroupLangValue = em.merge(psLayeredIndexableAttributeGroupLangValue);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsLayeredIndexableAttributeGroupLangValuePK id = psLayeredIndexableAttributeGroupLangValue.getPsLayeredIndexableAttributeGroupLangValuePK();
                if (findPsLayeredIndexableAttributeGroupLangValue(id) == null) {
                    throw new NonexistentEntityException("The psLayeredIndexableAttributeGroupLangValue with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsLayeredIndexableAttributeGroupLangValuePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsLayeredIndexableAttributeGroupLangValue psLayeredIndexableAttributeGroupLangValue;
            try {
                psLayeredIndexableAttributeGroupLangValue = em.getReference(PsLayeredIndexableAttributeGroupLangValue.class, id);
                psLayeredIndexableAttributeGroupLangValue.getPsLayeredIndexableAttributeGroupLangValuePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psLayeredIndexableAttributeGroupLangValue with id " + id + " no longer exists.", enfe);
            }
            em.remove(psLayeredIndexableAttributeGroupLangValue);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsLayeredIndexableAttributeGroupLangValue> findPsLayeredIndexableAttributeGroupLangValueEntities() {
        return findPsLayeredIndexableAttributeGroupLangValueEntities(true, -1, -1);
    }

    public List<PsLayeredIndexableAttributeGroupLangValue> findPsLayeredIndexableAttributeGroupLangValueEntities(int maxResults, int firstResult) {
        return findPsLayeredIndexableAttributeGroupLangValueEntities(false, maxResults, firstResult);
    }

    private List<PsLayeredIndexableAttributeGroupLangValue> findPsLayeredIndexableAttributeGroupLangValueEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsLayeredIndexableAttributeGroupLangValue.class));
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

    public PsLayeredIndexableAttributeGroupLangValue findPsLayeredIndexableAttributeGroupLangValue(PsLayeredIndexableAttributeGroupLangValuePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsLayeredIndexableAttributeGroupLangValue.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsLayeredIndexableAttributeGroupLangValueCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsLayeredIndexableAttributeGroupLangValue> rt = cq.from(PsLayeredIndexableAttributeGroupLangValue.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsLayeredIndexableFeatureLangValue;
import entidade.prestaShop.PsLayeredIndexableFeatureLangValuePK;
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
public class PsLayeredIndexableFeatureLangValueJpaController implements Serializable {

    public PsLayeredIndexableFeatureLangValueJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsLayeredIndexableFeatureLangValue psLayeredIndexableFeatureLangValue) throws PreexistingEntityException, Exception {
        if (psLayeredIndexableFeatureLangValue.getPsLayeredIndexableFeatureLangValuePK() == null) {
            psLayeredIndexableFeatureLangValue.setPsLayeredIndexableFeatureLangValuePK(new PsLayeredIndexableFeatureLangValuePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psLayeredIndexableFeatureLangValue);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsLayeredIndexableFeatureLangValue(psLayeredIndexableFeatureLangValue.getPsLayeredIndexableFeatureLangValuePK()) != null) {
                throw new PreexistingEntityException("PsLayeredIndexableFeatureLangValue " + psLayeredIndexableFeatureLangValue + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsLayeredIndexableFeatureLangValue psLayeredIndexableFeatureLangValue) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psLayeredIndexableFeatureLangValue = em.merge(psLayeredIndexableFeatureLangValue);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsLayeredIndexableFeatureLangValuePK id = psLayeredIndexableFeatureLangValue.getPsLayeredIndexableFeatureLangValuePK();
                if (findPsLayeredIndexableFeatureLangValue(id) == null) {
                    throw new NonexistentEntityException("The psLayeredIndexableFeatureLangValue with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsLayeredIndexableFeatureLangValuePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsLayeredIndexableFeatureLangValue psLayeredIndexableFeatureLangValue;
            try {
                psLayeredIndexableFeatureLangValue = em.getReference(PsLayeredIndexableFeatureLangValue.class, id);
                psLayeredIndexableFeatureLangValue.getPsLayeredIndexableFeatureLangValuePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psLayeredIndexableFeatureLangValue with id " + id + " no longer exists.", enfe);
            }
            em.remove(psLayeredIndexableFeatureLangValue);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsLayeredIndexableFeatureLangValue> findPsLayeredIndexableFeatureLangValueEntities() {
        return findPsLayeredIndexableFeatureLangValueEntities(true, -1, -1);
    }

    public List<PsLayeredIndexableFeatureLangValue> findPsLayeredIndexableFeatureLangValueEntities(int maxResults, int firstResult) {
        return findPsLayeredIndexableFeatureLangValueEntities(false, maxResults, firstResult);
    }

    private List<PsLayeredIndexableFeatureLangValue> findPsLayeredIndexableFeatureLangValueEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsLayeredIndexableFeatureLangValue.class));
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

    public PsLayeredIndexableFeatureLangValue findPsLayeredIndexableFeatureLangValue(PsLayeredIndexableFeatureLangValuePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsLayeredIndexableFeatureLangValue.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsLayeredIndexableFeatureLangValueCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsLayeredIndexableFeatureLangValue> rt = cq.from(PsLayeredIndexableFeatureLangValue.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

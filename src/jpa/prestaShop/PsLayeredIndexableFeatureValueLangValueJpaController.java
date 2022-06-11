/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsLayeredIndexableFeatureValueLangValue;
import entidade.prestaShop.PsLayeredIndexableFeatureValueLangValuePK;
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
public class PsLayeredIndexableFeatureValueLangValueJpaController implements Serializable {

    public PsLayeredIndexableFeatureValueLangValueJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsLayeredIndexableFeatureValueLangValue psLayeredIndexableFeatureValueLangValue) throws PreexistingEntityException, Exception {
        if (psLayeredIndexableFeatureValueLangValue.getPsLayeredIndexableFeatureValueLangValuePK() == null) {
            psLayeredIndexableFeatureValueLangValue.setPsLayeredIndexableFeatureValueLangValuePK(new PsLayeredIndexableFeatureValueLangValuePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psLayeredIndexableFeatureValueLangValue);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsLayeredIndexableFeatureValueLangValue(psLayeredIndexableFeatureValueLangValue.getPsLayeredIndexableFeatureValueLangValuePK()) != null) {
                throw new PreexistingEntityException("PsLayeredIndexableFeatureValueLangValue " + psLayeredIndexableFeatureValueLangValue + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsLayeredIndexableFeatureValueLangValue psLayeredIndexableFeatureValueLangValue) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psLayeredIndexableFeatureValueLangValue = em.merge(psLayeredIndexableFeatureValueLangValue);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsLayeredIndexableFeatureValueLangValuePK id = psLayeredIndexableFeatureValueLangValue.getPsLayeredIndexableFeatureValueLangValuePK();
                if (findPsLayeredIndexableFeatureValueLangValue(id) == null) {
                    throw new NonexistentEntityException("The psLayeredIndexableFeatureValueLangValue with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsLayeredIndexableFeatureValueLangValuePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsLayeredIndexableFeatureValueLangValue psLayeredIndexableFeatureValueLangValue;
            try {
                psLayeredIndexableFeatureValueLangValue = em.getReference(PsLayeredIndexableFeatureValueLangValue.class, id);
                psLayeredIndexableFeatureValueLangValue.getPsLayeredIndexableFeatureValueLangValuePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psLayeredIndexableFeatureValueLangValue with id " + id + " no longer exists.", enfe);
            }
            em.remove(psLayeredIndexableFeatureValueLangValue);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsLayeredIndexableFeatureValueLangValue> findPsLayeredIndexableFeatureValueLangValueEntities() {
        return findPsLayeredIndexableFeatureValueLangValueEntities(true, -1, -1);
    }

    public List<PsLayeredIndexableFeatureValueLangValue> findPsLayeredIndexableFeatureValueLangValueEntities(int maxResults, int firstResult) {
        return findPsLayeredIndexableFeatureValueLangValueEntities(false, maxResults, firstResult);
    }

    private List<PsLayeredIndexableFeatureValueLangValue> findPsLayeredIndexableFeatureValueLangValueEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsLayeredIndexableFeatureValueLangValue.class));
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

    public PsLayeredIndexableFeatureValueLangValue findPsLayeredIndexableFeatureValueLangValue(PsLayeredIndexableFeatureValueLangValuePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsLayeredIndexableFeatureValueLangValue.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsLayeredIndexableFeatureValueLangValueCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsLayeredIndexableFeatureValueLangValue> rt = cq.from(PsLayeredIndexableFeatureValueLangValue.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

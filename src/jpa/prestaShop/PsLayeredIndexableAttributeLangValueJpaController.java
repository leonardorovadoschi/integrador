/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsLayeredIndexableAttributeLangValue;
import entidade.prestaShop.PsLayeredIndexableAttributeLangValuePK;
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
public class PsLayeredIndexableAttributeLangValueJpaController implements Serializable {

    public PsLayeredIndexableAttributeLangValueJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsLayeredIndexableAttributeLangValue psLayeredIndexableAttributeLangValue) throws PreexistingEntityException, Exception {
        if (psLayeredIndexableAttributeLangValue.getPsLayeredIndexableAttributeLangValuePK() == null) {
            psLayeredIndexableAttributeLangValue.setPsLayeredIndexableAttributeLangValuePK(new PsLayeredIndexableAttributeLangValuePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psLayeredIndexableAttributeLangValue);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsLayeredIndexableAttributeLangValue(psLayeredIndexableAttributeLangValue.getPsLayeredIndexableAttributeLangValuePK()) != null) {
                throw new PreexistingEntityException("PsLayeredIndexableAttributeLangValue " + psLayeredIndexableAttributeLangValue + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsLayeredIndexableAttributeLangValue psLayeredIndexableAttributeLangValue) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psLayeredIndexableAttributeLangValue = em.merge(psLayeredIndexableAttributeLangValue);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsLayeredIndexableAttributeLangValuePK id = psLayeredIndexableAttributeLangValue.getPsLayeredIndexableAttributeLangValuePK();
                if (findPsLayeredIndexableAttributeLangValue(id) == null) {
                    throw new NonexistentEntityException("The psLayeredIndexableAttributeLangValue with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsLayeredIndexableAttributeLangValuePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsLayeredIndexableAttributeLangValue psLayeredIndexableAttributeLangValue;
            try {
                psLayeredIndexableAttributeLangValue = em.getReference(PsLayeredIndexableAttributeLangValue.class, id);
                psLayeredIndexableAttributeLangValue.getPsLayeredIndexableAttributeLangValuePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psLayeredIndexableAttributeLangValue with id " + id + " no longer exists.", enfe);
            }
            em.remove(psLayeredIndexableAttributeLangValue);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsLayeredIndexableAttributeLangValue> findPsLayeredIndexableAttributeLangValueEntities() {
        return findPsLayeredIndexableAttributeLangValueEntities(true, -1, -1);
    }

    public List<PsLayeredIndexableAttributeLangValue> findPsLayeredIndexableAttributeLangValueEntities(int maxResults, int firstResult) {
        return findPsLayeredIndexableAttributeLangValueEntities(false, maxResults, firstResult);
    }

    private List<PsLayeredIndexableAttributeLangValue> findPsLayeredIndexableAttributeLangValueEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsLayeredIndexableAttributeLangValue.class));
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

    public PsLayeredIndexableAttributeLangValue findPsLayeredIndexableAttributeLangValue(PsLayeredIndexableAttributeLangValuePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsLayeredIndexableAttributeLangValue.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsLayeredIndexableAttributeLangValueCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsLayeredIndexableAttributeLangValue> rt = cq.from(PsLayeredIndexableAttributeLangValue.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCustomization;
import entidade.prestaShop.PsCustomizationPK;
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
public class PsCustomizationJpaController implements Serializable {

    public PsCustomizationJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCustomization psCustomization) throws PreexistingEntityException, Exception {
        if (psCustomization.getPsCustomizationPK() == null) {
            psCustomization.setPsCustomizationPK(new PsCustomizationPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCustomization);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCustomization(psCustomization.getPsCustomizationPK()) != null) {
                throw new PreexistingEntityException("PsCustomization " + psCustomization + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCustomization psCustomization) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCustomization = em.merge(psCustomization);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCustomizationPK id = psCustomization.getPsCustomizationPK();
                if (findPsCustomization(id) == null) {
                    throw new NonexistentEntityException("The psCustomization with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCustomizationPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCustomization psCustomization;
            try {
                psCustomization = em.getReference(PsCustomization.class, id);
                psCustomization.getPsCustomizationPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCustomization with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCustomization);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCustomization> findPsCustomizationEntities() {
        return findPsCustomizationEntities(true, -1, -1);
    }

    public List<PsCustomization> findPsCustomizationEntities(int maxResults, int firstResult) {
        return findPsCustomizationEntities(false, maxResults, firstResult);
    }

    private List<PsCustomization> findPsCustomizationEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCustomization.class));
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

    public PsCustomization findPsCustomization(PsCustomizationPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCustomization.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCustomizationCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCustomization> rt = cq.from(PsCustomization.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

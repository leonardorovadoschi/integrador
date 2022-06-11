/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsPsgdprConsent;
import entidade.prestaShop.PsPsgdprConsentPK;
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
public class PsPsgdprConsentJpaController implements Serializable {

    public PsPsgdprConsentJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsPsgdprConsent psPsgdprConsent) throws PreexistingEntityException, Exception {
        if (psPsgdprConsent.getPsPsgdprConsentPK() == null) {
            psPsgdprConsent.setPsPsgdprConsentPK(new PsPsgdprConsentPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psPsgdprConsent);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsPsgdprConsent(psPsgdprConsent.getPsPsgdprConsentPK()) != null) {
                throw new PreexistingEntityException("PsPsgdprConsent " + psPsgdprConsent + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsPsgdprConsent psPsgdprConsent) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psPsgdprConsent = em.merge(psPsgdprConsent);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsPsgdprConsentPK id = psPsgdprConsent.getPsPsgdprConsentPK();
                if (findPsPsgdprConsent(id) == null) {
                    throw new NonexistentEntityException("The psPsgdprConsent with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsPsgdprConsentPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsPsgdprConsent psPsgdprConsent;
            try {
                psPsgdprConsent = em.getReference(PsPsgdprConsent.class, id);
                psPsgdprConsent.getPsPsgdprConsentPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psPsgdprConsent with id " + id + " no longer exists.", enfe);
            }
            em.remove(psPsgdprConsent);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsPsgdprConsent> findPsPsgdprConsentEntities() {
        return findPsPsgdprConsentEntities(true, -1, -1);
    }

    public List<PsPsgdprConsent> findPsPsgdprConsentEntities(int maxResults, int firstResult) {
        return findPsPsgdprConsentEntities(false, maxResults, firstResult);
    }

    private List<PsPsgdprConsent> findPsPsgdprConsentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsPsgdprConsent.class));
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

    public PsPsgdprConsent findPsPsgdprConsent(PsPsgdprConsentPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsPsgdprConsent.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsPsgdprConsentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsPsgdprConsent> rt = cq.from(PsPsgdprConsent.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCartRuleCarrier;
import entidade.prestaShop.PsCartRuleCarrierPK;
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
public class PsCartRuleCarrierJpaController implements Serializable {

    public PsCartRuleCarrierJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCartRuleCarrier psCartRuleCarrier) throws PreexistingEntityException, Exception {
        if (psCartRuleCarrier.getPsCartRuleCarrierPK() == null) {
            psCartRuleCarrier.setPsCartRuleCarrierPK(new PsCartRuleCarrierPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCartRuleCarrier);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCartRuleCarrier(psCartRuleCarrier.getPsCartRuleCarrierPK()) != null) {
                throw new PreexistingEntityException("PsCartRuleCarrier " + psCartRuleCarrier + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCartRuleCarrier psCartRuleCarrier) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCartRuleCarrier = em.merge(psCartRuleCarrier);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCartRuleCarrierPK id = psCartRuleCarrier.getPsCartRuleCarrierPK();
                if (findPsCartRuleCarrier(id) == null) {
                    throw new NonexistentEntityException("The psCartRuleCarrier with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCartRuleCarrierPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCartRuleCarrier psCartRuleCarrier;
            try {
                psCartRuleCarrier = em.getReference(PsCartRuleCarrier.class, id);
                psCartRuleCarrier.getPsCartRuleCarrierPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCartRuleCarrier with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCartRuleCarrier);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCartRuleCarrier> findPsCartRuleCarrierEntities() {
        return findPsCartRuleCarrierEntities(true, -1, -1);
    }

    public List<PsCartRuleCarrier> findPsCartRuleCarrierEntities(int maxResults, int firstResult) {
        return findPsCartRuleCarrierEntities(false, maxResults, firstResult);
    }

    private List<PsCartRuleCarrier> findPsCartRuleCarrierEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCartRuleCarrier.class));
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

    public PsCartRuleCarrier findPsCartRuleCarrier(PsCartRuleCarrierPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCartRuleCarrier.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCartRuleCarrierCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCartRuleCarrier> rt = cq.from(PsCartRuleCarrier.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsProductCarrier;
import entidade.prestaShop.PsProductCarrierPK;
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
public class PsProductCarrierJpaController implements Serializable {

    public PsProductCarrierJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsProductCarrier psProductCarrier) throws PreexistingEntityException, Exception {
        if (psProductCarrier.getPsProductCarrierPK() == null) {
            psProductCarrier.setPsProductCarrierPK(new PsProductCarrierPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psProductCarrier);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsProductCarrier(psProductCarrier.getPsProductCarrierPK()) != null) {
                throw new PreexistingEntityException("PsProductCarrier " + psProductCarrier + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsProductCarrier psProductCarrier) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psProductCarrier = em.merge(psProductCarrier);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsProductCarrierPK id = psProductCarrier.getPsProductCarrierPK();
                if (findPsProductCarrier(id) == null) {
                    throw new NonexistentEntityException("The psProductCarrier with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsProductCarrierPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsProductCarrier psProductCarrier;
            try {
                psProductCarrier = em.getReference(PsProductCarrier.class, id);
                psProductCarrier.getPsProductCarrierPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psProductCarrier with id " + id + " no longer exists.", enfe);
            }
            em.remove(psProductCarrier);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsProductCarrier> findPsProductCarrierEntities() {
        return findPsProductCarrierEntities(true, -1, -1);
    }

    public List<PsProductCarrier> findPsProductCarrierEntities(int maxResults, int firstResult) {
        return findPsProductCarrierEntities(false, maxResults, firstResult);
    }

    private List<PsProductCarrier> findPsProductCarrierEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsProductCarrier.class));
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

    public PsProductCarrier findPsProductCarrier(PsProductCarrierPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsProductCarrier.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsProductCarrierCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsProductCarrier> rt = cq.from(PsProductCarrier.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

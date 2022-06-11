/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsModuleCarrier;
import entidade.prestaShop.PsModuleCarrierPK;
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
public class PsModuleCarrierJpaController implements Serializable {

    public PsModuleCarrierJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsModuleCarrier psModuleCarrier) throws PreexistingEntityException, Exception {
        if (psModuleCarrier.getPsModuleCarrierPK() == null) {
            psModuleCarrier.setPsModuleCarrierPK(new PsModuleCarrierPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psModuleCarrier);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsModuleCarrier(psModuleCarrier.getPsModuleCarrierPK()) != null) {
                throw new PreexistingEntityException("PsModuleCarrier " + psModuleCarrier + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsModuleCarrier psModuleCarrier) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psModuleCarrier = em.merge(psModuleCarrier);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsModuleCarrierPK id = psModuleCarrier.getPsModuleCarrierPK();
                if (findPsModuleCarrier(id) == null) {
                    throw new NonexistentEntityException("The psModuleCarrier with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsModuleCarrierPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsModuleCarrier psModuleCarrier;
            try {
                psModuleCarrier = em.getReference(PsModuleCarrier.class, id);
                psModuleCarrier.getPsModuleCarrierPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psModuleCarrier with id " + id + " no longer exists.", enfe);
            }
            em.remove(psModuleCarrier);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsModuleCarrier> findPsModuleCarrierEntities() {
        return findPsModuleCarrierEntities(true, -1, -1);
    }

    public List<PsModuleCarrier> findPsModuleCarrierEntities(int maxResults, int firstResult) {
        return findPsModuleCarrierEntities(false, maxResults, firstResult);
    }

    private List<PsModuleCarrier> findPsModuleCarrierEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsModuleCarrier.class));
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

    public PsModuleCarrier findPsModuleCarrier(PsModuleCarrierPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsModuleCarrier.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsModuleCarrierCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsModuleCarrier> rt = cq.from(PsModuleCarrier.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

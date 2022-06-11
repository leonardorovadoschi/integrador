/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsWarehouseCarrier;
import entidade.prestaShop.PsWarehouseCarrierPK;
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
public class PsWarehouseCarrierJpaController implements Serializable {

    public PsWarehouseCarrierJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsWarehouseCarrier psWarehouseCarrier) throws PreexistingEntityException, Exception {
        if (psWarehouseCarrier.getPsWarehouseCarrierPK() == null) {
            psWarehouseCarrier.setPsWarehouseCarrierPK(new PsWarehouseCarrierPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psWarehouseCarrier);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsWarehouseCarrier(psWarehouseCarrier.getPsWarehouseCarrierPK()) != null) {
                throw new PreexistingEntityException("PsWarehouseCarrier " + psWarehouseCarrier + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsWarehouseCarrier psWarehouseCarrier) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psWarehouseCarrier = em.merge(psWarehouseCarrier);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsWarehouseCarrierPK id = psWarehouseCarrier.getPsWarehouseCarrierPK();
                if (findPsWarehouseCarrier(id) == null) {
                    throw new NonexistentEntityException("The psWarehouseCarrier with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsWarehouseCarrierPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsWarehouseCarrier psWarehouseCarrier;
            try {
                psWarehouseCarrier = em.getReference(PsWarehouseCarrier.class, id);
                psWarehouseCarrier.getPsWarehouseCarrierPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psWarehouseCarrier with id " + id + " no longer exists.", enfe);
            }
            em.remove(psWarehouseCarrier);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsWarehouseCarrier> findPsWarehouseCarrierEntities() {
        return findPsWarehouseCarrierEntities(true, -1, -1);
    }

    public List<PsWarehouseCarrier> findPsWarehouseCarrierEntities(int maxResults, int firstResult) {
        return findPsWarehouseCarrierEntities(false, maxResults, firstResult);
    }

    private List<PsWarehouseCarrier> findPsWarehouseCarrierEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsWarehouseCarrier.class));
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

    public PsWarehouseCarrier findPsWarehouseCarrier(PsWarehouseCarrierPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsWarehouseCarrier.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsWarehouseCarrierCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsWarehouseCarrier> rt = cq.from(PsWarehouseCarrier.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

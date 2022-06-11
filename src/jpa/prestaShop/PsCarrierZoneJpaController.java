/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCarrierZone;
import entidade.prestaShop.PsCarrierZonePK;
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
public class PsCarrierZoneJpaController implements Serializable {

    public PsCarrierZoneJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCarrierZone psCarrierZone) throws PreexistingEntityException, Exception {
        if (psCarrierZone.getPsCarrierZonePK() == null) {
            psCarrierZone.setPsCarrierZonePK(new PsCarrierZonePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCarrierZone);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCarrierZone(psCarrierZone.getPsCarrierZonePK()) != null) {
                throw new PreexistingEntityException("PsCarrierZone " + psCarrierZone + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCarrierZone psCarrierZone) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCarrierZone = em.merge(psCarrierZone);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCarrierZonePK id = psCarrierZone.getPsCarrierZonePK();
                if (findPsCarrierZone(id) == null) {
                    throw new NonexistentEntityException("The psCarrierZone with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCarrierZonePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCarrierZone psCarrierZone;
            try {
                psCarrierZone = em.getReference(PsCarrierZone.class, id);
                psCarrierZone.getPsCarrierZonePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCarrierZone with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCarrierZone);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCarrierZone> findPsCarrierZoneEntities() {
        return findPsCarrierZoneEntities(true, -1, -1);
    }

    public List<PsCarrierZone> findPsCarrierZoneEntities(int maxResults, int firstResult) {
        return findPsCarrierZoneEntities(false, maxResults, firstResult);
    }

    private List<PsCarrierZone> findPsCarrierZoneEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCarrierZone.class));
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

    public PsCarrierZone findPsCarrierZone(PsCarrierZonePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCarrierZone.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCarrierZoneCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCarrierZone> rt = cq.from(PsCarrierZone.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

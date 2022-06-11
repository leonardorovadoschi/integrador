/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsOrderSlip;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.prestaShop.exceptions.NonexistentEntityException;

/**
 *
 * @author leo
 */
public class PsOrderSlipJpaController implements Serializable {

    public PsOrderSlipJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsOrderSlip psOrderSlip) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psOrderSlip);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsOrderSlip psOrderSlip) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psOrderSlip = em.merge(psOrderSlip);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psOrderSlip.getIdOrderSlip();
                if (findPsOrderSlip(id) == null) {
                    throw new NonexistentEntityException("The psOrderSlip with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsOrderSlip psOrderSlip;
            try {
                psOrderSlip = em.getReference(PsOrderSlip.class, id);
                psOrderSlip.getIdOrderSlip();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psOrderSlip with id " + id + " no longer exists.", enfe);
            }
            em.remove(psOrderSlip);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsOrderSlip> findPsOrderSlipEntities() {
        return findPsOrderSlipEntities(true, -1, -1);
    }

    public List<PsOrderSlip> findPsOrderSlipEntities(int maxResults, int firstResult) {
        return findPsOrderSlipEntities(false, maxResults, firstResult);
    }

    private List<PsOrderSlip> findPsOrderSlipEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsOrderSlip.class));
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

    public PsOrderSlip findPsOrderSlip(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsOrderSlip.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsOrderSlipCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsOrderSlip> rt = cq.from(PsOrderSlip.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

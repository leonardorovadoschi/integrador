/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsOrderSlipDetail;
import entidade.prestaShop.PsOrderSlipDetailPK;
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
public class PsOrderSlipDetailJpaController implements Serializable {

    public PsOrderSlipDetailJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsOrderSlipDetail psOrderSlipDetail) throws PreexistingEntityException, Exception {
        if (psOrderSlipDetail.getPsOrderSlipDetailPK() == null) {
            psOrderSlipDetail.setPsOrderSlipDetailPK(new PsOrderSlipDetailPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psOrderSlipDetail);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsOrderSlipDetail(psOrderSlipDetail.getPsOrderSlipDetailPK()) != null) {
                throw new PreexistingEntityException("PsOrderSlipDetail " + psOrderSlipDetail + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsOrderSlipDetail psOrderSlipDetail) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psOrderSlipDetail = em.merge(psOrderSlipDetail);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsOrderSlipDetailPK id = psOrderSlipDetail.getPsOrderSlipDetailPK();
                if (findPsOrderSlipDetail(id) == null) {
                    throw new NonexistentEntityException("The psOrderSlipDetail with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsOrderSlipDetailPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsOrderSlipDetail psOrderSlipDetail;
            try {
                psOrderSlipDetail = em.getReference(PsOrderSlipDetail.class, id);
                psOrderSlipDetail.getPsOrderSlipDetailPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psOrderSlipDetail with id " + id + " no longer exists.", enfe);
            }
            em.remove(psOrderSlipDetail);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsOrderSlipDetail> findPsOrderSlipDetailEntities() {
        return findPsOrderSlipDetailEntities(true, -1, -1);
    }

    public List<PsOrderSlipDetail> findPsOrderSlipDetailEntities(int maxResults, int firstResult) {
        return findPsOrderSlipDetailEntities(false, maxResults, firstResult);
    }

    private List<PsOrderSlipDetail> findPsOrderSlipDetailEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsOrderSlipDetail.class));
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

    public PsOrderSlipDetail findPsOrderSlipDetail(PsOrderSlipDetailPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsOrderSlipDetail.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsOrderSlipDetailCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsOrderSlipDetail> rt = cq.from(PsOrderSlipDetail.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

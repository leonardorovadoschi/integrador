/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsOrderReturnDetail;
import entidade.prestaShop.PsOrderReturnDetailPK;
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
public class PsOrderReturnDetailJpaController implements Serializable {

    public PsOrderReturnDetailJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsOrderReturnDetail psOrderReturnDetail) throws PreexistingEntityException, Exception {
        if (psOrderReturnDetail.getPsOrderReturnDetailPK() == null) {
            psOrderReturnDetail.setPsOrderReturnDetailPK(new PsOrderReturnDetailPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psOrderReturnDetail);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsOrderReturnDetail(psOrderReturnDetail.getPsOrderReturnDetailPK()) != null) {
                throw new PreexistingEntityException("PsOrderReturnDetail " + psOrderReturnDetail + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsOrderReturnDetail psOrderReturnDetail) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psOrderReturnDetail = em.merge(psOrderReturnDetail);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsOrderReturnDetailPK id = psOrderReturnDetail.getPsOrderReturnDetailPK();
                if (findPsOrderReturnDetail(id) == null) {
                    throw new NonexistentEntityException("The psOrderReturnDetail with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsOrderReturnDetailPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsOrderReturnDetail psOrderReturnDetail;
            try {
                psOrderReturnDetail = em.getReference(PsOrderReturnDetail.class, id);
                psOrderReturnDetail.getPsOrderReturnDetailPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psOrderReturnDetail with id " + id + " no longer exists.", enfe);
            }
            em.remove(psOrderReturnDetail);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsOrderReturnDetail> findPsOrderReturnDetailEntities() {
        return findPsOrderReturnDetailEntities(true, -1, -1);
    }

    public List<PsOrderReturnDetail> findPsOrderReturnDetailEntities(int maxResults, int firstResult) {
        return findPsOrderReturnDetailEntities(false, maxResults, firstResult);
    }

    private List<PsOrderReturnDetail> findPsOrderReturnDetailEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsOrderReturnDetail.class));
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

    public PsOrderReturnDetail findPsOrderReturnDetail(PsOrderReturnDetailPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsOrderReturnDetail.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsOrderReturnDetailCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsOrderReturnDetail> rt = cq.from(PsOrderReturnDetail.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

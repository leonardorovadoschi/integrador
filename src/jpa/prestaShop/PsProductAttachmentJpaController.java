/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsProductAttachment;
import entidade.prestaShop.PsProductAttachmentPK;
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
public class PsProductAttachmentJpaController implements Serializable {

    public PsProductAttachmentJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsProductAttachment psProductAttachment) throws PreexistingEntityException, Exception {
        if (psProductAttachment.getPsProductAttachmentPK() == null) {
            psProductAttachment.setPsProductAttachmentPK(new PsProductAttachmentPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psProductAttachment);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsProductAttachment(psProductAttachment.getPsProductAttachmentPK()) != null) {
                throw new PreexistingEntityException("PsProductAttachment " + psProductAttachment + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsProductAttachment psProductAttachment) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psProductAttachment = em.merge(psProductAttachment);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsProductAttachmentPK id = psProductAttachment.getPsProductAttachmentPK();
                if (findPsProductAttachment(id) == null) {
                    throw new NonexistentEntityException("The psProductAttachment with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsProductAttachmentPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsProductAttachment psProductAttachment;
            try {
                psProductAttachment = em.getReference(PsProductAttachment.class, id);
                psProductAttachment.getPsProductAttachmentPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psProductAttachment with id " + id + " no longer exists.", enfe);
            }
            em.remove(psProductAttachment);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsProductAttachment> findPsProductAttachmentEntities() {
        return findPsProductAttachmentEntities(true, -1, -1);
    }

    public List<PsProductAttachment> findPsProductAttachmentEntities(int maxResults, int firstResult) {
        return findPsProductAttachmentEntities(false, maxResults, firstResult);
    }

    private List<PsProductAttachment> findPsProductAttachmentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsProductAttachment.class));
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

    public PsProductAttachment findPsProductAttachment(PsProductAttachmentPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsProductAttachment.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsProductAttachmentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsProductAttachment> rt = cq.from(PsProductAttachment.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

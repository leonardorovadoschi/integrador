/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsProductTag;
import entidade.prestaShop.PsProductTagPK;
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
public class PsProductTagJpaController implements Serializable {

    public PsProductTagJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsProductTag psProductTag) throws PreexistingEntityException, Exception {
        if (psProductTag.getPsProductTagPK() == null) {
            psProductTag.setPsProductTagPK(new PsProductTagPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psProductTag);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsProductTag(psProductTag.getPsProductTagPK()) != null) {
                throw new PreexistingEntityException("PsProductTag " + psProductTag + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsProductTag psProductTag) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psProductTag = em.merge(psProductTag);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsProductTagPK id = psProductTag.getPsProductTagPK();
                if (findPsProductTag(id) == null) {
                    throw new NonexistentEntityException("The psProductTag with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsProductTagPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsProductTag psProductTag;
            try {
                psProductTag = em.getReference(PsProductTag.class, id);
                psProductTag.getPsProductTagPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psProductTag with id " + id + " no longer exists.", enfe);
            }
            em.remove(psProductTag);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsProductTag> findPsProductTagEntities() {
        return findPsProductTagEntities(true, -1, -1);
    }

    public List<PsProductTag> findPsProductTagEntities(int maxResults, int firstResult) {
        return findPsProductTagEntities(false, maxResults, firstResult);
    }

    private List<PsProductTag> findPsProductTagEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsProductTag.class));
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

    public PsProductTag findPsProductTag(PsProductTagPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsProductTag.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsProductTagCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsProductTag> rt = cq.from(PsProductTag.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

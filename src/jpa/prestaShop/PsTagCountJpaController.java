/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsTagCount;
import entidade.prestaShop.PsTagCountPK;
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
public class PsTagCountJpaController implements Serializable {

    public PsTagCountJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsTagCount psTagCount) throws PreexistingEntityException, Exception {
        if (psTagCount.getPsTagCountPK() == null) {
            psTagCount.setPsTagCountPK(new PsTagCountPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psTagCount);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsTagCount(psTagCount.getPsTagCountPK()) != null) {
                throw new PreexistingEntityException("PsTagCount " + psTagCount + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsTagCount psTagCount) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psTagCount = em.merge(psTagCount);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsTagCountPK id = psTagCount.getPsTagCountPK();
                if (findPsTagCount(id) == null) {
                    throw new NonexistentEntityException("The psTagCount with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsTagCountPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsTagCount psTagCount;
            try {
                psTagCount = em.getReference(PsTagCount.class, id);
                psTagCount.getPsTagCountPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psTagCount with id " + id + " no longer exists.", enfe);
            }
            em.remove(psTagCount);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsTagCount> findPsTagCountEntities() {
        return findPsTagCountEntities(true, -1, -1);
    }

    public List<PsTagCount> findPsTagCountEntities(int maxResults, int firstResult) {
        return findPsTagCountEntities(false, maxResults, firstResult);
    }

    private List<PsTagCount> findPsTagCountEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsTagCount.class));
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

    public PsTagCount findPsTagCount(PsTagCountPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsTagCount.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsTagCountCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsTagCount> rt = cq.from(PsTagCount.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

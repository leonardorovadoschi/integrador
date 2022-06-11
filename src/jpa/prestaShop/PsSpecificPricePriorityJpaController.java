/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsSpecificPricePriority;
import entidade.prestaShop.PsSpecificPricePriorityPK;
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
public class PsSpecificPricePriorityJpaController implements Serializable {

    public PsSpecificPricePriorityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsSpecificPricePriority psSpecificPricePriority) throws PreexistingEntityException, Exception {
        if (psSpecificPricePriority.getPsSpecificPricePriorityPK() == null) {
            psSpecificPricePriority.setPsSpecificPricePriorityPK(new PsSpecificPricePriorityPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psSpecificPricePriority);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsSpecificPricePriority(psSpecificPricePriority.getPsSpecificPricePriorityPK()) != null) {
                throw new PreexistingEntityException("PsSpecificPricePriority " + psSpecificPricePriority + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsSpecificPricePriority psSpecificPricePriority) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psSpecificPricePriority = em.merge(psSpecificPricePriority);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsSpecificPricePriorityPK id = psSpecificPricePriority.getPsSpecificPricePriorityPK();
                if (findPsSpecificPricePriority(id) == null) {
                    throw new NonexistentEntityException("The psSpecificPricePriority with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsSpecificPricePriorityPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsSpecificPricePriority psSpecificPricePriority;
            try {
                psSpecificPricePriority = em.getReference(PsSpecificPricePriority.class, id);
                psSpecificPricePriority.getPsSpecificPricePriorityPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psSpecificPricePriority with id " + id + " no longer exists.", enfe);
            }
            em.remove(psSpecificPricePriority);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsSpecificPricePriority> findPsSpecificPricePriorityEntities() {
        return findPsSpecificPricePriorityEntities(true, -1, -1);
    }

    public List<PsSpecificPricePriority> findPsSpecificPricePriorityEntities(int maxResults, int firstResult) {
        return findPsSpecificPricePriorityEntities(false, maxResults, firstResult);
    }

    private List<PsSpecificPricePriority> findPsSpecificPricePriorityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsSpecificPricePriority.class));
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

    public PsSpecificPricePriority findPsSpecificPricePriority(PsSpecificPricePriorityPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsSpecificPricePriority.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsSpecificPricePriorityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsSpecificPricePriority> rt = cq.from(PsSpecificPricePriority.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

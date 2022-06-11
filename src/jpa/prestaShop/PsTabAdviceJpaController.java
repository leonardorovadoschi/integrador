/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsTabAdvice;
import entidade.prestaShop.PsTabAdvicePK;
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
public class PsTabAdviceJpaController implements Serializable {

    public PsTabAdviceJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsTabAdvice psTabAdvice) throws PreexistingEntityException, Exception {
        if (psTabAdvice.getPsTabAdvicePK() == null) {
            psTabAdvice.setPsTabAdvicePK(new PsTabAdvicePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psTabAdvice);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsTabAdvice(psTabAdvice.getPsTabAdvicePK()) != null) {
                throw new PreexistingEntityException("PsTabAdvice " + psTabAdvice + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsTabAdvice psTabAdvice) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psTabAdvice = em.merge(psTabAdvice);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsTabAdvicePK id = psTabAdvice.getPsTabAdvicePK();
                if (findPsTabAdvice(id) == null) {
                    throw new NonexistentEntityException("The psTabAdvice with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsTabAdvicePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsTabAdvice psTabAdvice;
            try {
                psTabAdvice = em.getReference(PsTabAdvice.class, id);
                psTabAdvice.getPsTabAdvicePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psTabAdvice with id " + id + " no longer exists.", enfe);
            }
            em.remove(psTabAdvice);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsTabAdvice> findPsTabAdviceEntities() {
        return findPsTabAdviceEntities(true, -1, -1);
    }

    public List<PsTabAdvice> findPsTabAdviceEntities(int maxResults, int firstResult) {
        return findPsTabAdviceEntities(false, maxResults, firstResult);
    }

    private List<PsTabAdvice> findPsTabAdviceEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsTabAdvice.class));
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

    public PsTabAdvice findPsTabAdvice(PsTabAdvicePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsTabAdvice.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsTabAdviceCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsTabAdvice> rt = cq.from(PsTabAdvice.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

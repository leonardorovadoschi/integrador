/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsProductAttributeCombination;
import entidade.prestaShop.PsProductAttributeCombinationPK;
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
public class PsProductAttributeCombinationJpaController implements Serializable {

    public PsProductAttributeCombinationJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsProductAttributeCombination psProductAttributeCombination) throws PreexistingEntityException, Exception {
        if (psProductAttributeCombination.getPsProductAttributeCombinationPK() == null) {
            psProductAttributeCombination.setPsProductAttributeCombinationPK(new PsProductAttributeCombinationPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psProductAttributeCombination);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsProductAttributeCombination(psProductAttributeCombination.getPsProductAttributeCombinationPK()) != null) {
                throw new PreexistingEntityException("PsProductAttributeCombination " + psProductAttributeCombination + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsProductAttributeCombination psProductAttributeCombination) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psProductAttributeCombination = em.merge(psProductAttributeCombination);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsProductAttributeCombinationPK id = psProductAttributeCombination.getPsProductAttributeCombinationPK();
                if (findPsProductAttributeCombination(id) == null) {
                    throw new NonexistentEntityException("The psProductAttributeCombination with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsProductAttributeCombinationPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsProductAttributeCombination psProductAttributeCombination;
            try {
                psProductAttributeCombination = em.getReference(PsProductAttributeCombination.class, id);
                psProductAttributeCombination.getPsProductAttributeCombinationPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psProductAttributeCombination with id " + id + " no longer exists.", enfe);
            }
            em.remove(psProductAttributeCombination);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsProductAttributeCombination> findPsProductAttributeCombinationEntities() {
        return findPsProductAttributeCombinationEntities(true, -1, -1);
    }

    public List<PsProductAttributeCombination> findPsProductAttributeCombinationEntities(int maxResults, int firstResult) {
        return findPsProductAttributeCombinationEntities(false, maxResults, firstResult);
    }

    private List<PsProductAttributeCombination> findPsProductAttributeCombinationEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsProductAttributeCombination.class));
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

    public PsProductAttributeCombination findPsProductAttributeCombination(PsProductAttributeCombinationPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsProductAttributeCombination.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsProductAttributeCombinationCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsProductAttributeCombination> rt = cq.from(PsProductAttributeCombination.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

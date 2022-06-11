/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsLayeredPriceIndex;
import entidade.prestaShop.PsLayeredPriceIndexPK;
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
public class PsLayeredPriceIndexJpaController implements Serializable {

    public PsLayeredPriceIndexJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsLayeredPriceIndex psLayeredPriceIndex) throws PreexistingEntityException, Exception {
        if (psLayeredPriceIndex.getPsLayeredPriceIndexPK() == null) {
            psLayeredPriceIndex.setPsLayeredPriceIndexPK(new PsLayeredPriceIndexPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psLayeredPriceIndex);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsLayeredPriceIndex(psLayeredPriceIndex.getPsLayeredPriceIndexPK()) != null) {
                throw new PreexistingEntityException("PsLayeredPriceIndex " + psLayeredPriceIndex + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsLayeredPriceIndex psLayeredPriceIndex) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psLayeredPriceIndex = em.merge(psLayeredPriceIndex);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsLayeredPriceIndexPK id = psLayeredPriceIndex.getPsLayeredPriceIndexPK();
                if (findPsLayeredPriceIndex(id) == null) {
                    throw new NonexistentEntityException("The psLayeredPriceIndex with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsLayeredPriceIndexPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsLayeredPriceIndex psLayeredPriceIndex;
            try {
                psLayeredPriceIndex = em.getReference(PsLayeredPriceIndex.class, id);
                psLayeredPriceIndex.getPsLayeredPriceIndexPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psLayeredPriceIndex with id " + id + " no longer exists.", enfe);
            }
            em.remove(psLayeredPriceIndex);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsLayeredPriceIndex> findPsLayeredPriceIndexEntities() {
        return findPsLayeredPriceIndexEntities(true, -1, -1);
    }

    public List<PsLayeredPriceIndex> findPsLayeredPriceIndexEntities(int maxResults, int firstResult) {
        return findPsLayeredPriceIndexEntities(false, maxResults, firstResult);
    }

    private List<PsLayeredPriceIndex> findPsLayeredPriceIndexEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsLayeredPriceIndex.class));
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

    public PsLayeredPriceIndex findPsLayeredPriceIndex(PsLayeredPriceIndexPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsLayeredPriceIndex.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsLayeredPriceIndexCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsLayeredPriceIndex> rt = cq.from(PsLayeredPriceIndex.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

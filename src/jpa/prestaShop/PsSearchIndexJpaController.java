/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsSearchIndex;
import entidade.prestaShop.PsSearchIndexPK;
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
public class PsSearchIndexJpaController implements Serializable {

    public PsSearchIndexJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsSearchIndex psSearchIndex) throws PreexistingEntityException, Exception {
        if (psSearchIndex.getPsSearchIndexPK() == null) {
            psSearchIndex.setPsSearchIndexPK(new PsSearchIndexPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psSearchIndex);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsSearchIndex(psSearchIndex.getPsSearchIndexPK()) != null) {
                throw new PreexistingEntityException("PsSearchIndex " + psSearchIndex + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsSearchIndex psSearchIndex) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psSearchIndex = em.merge(psSearchIndex);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsSearchIndexPK id = psSearchIndex.getPsSearchIndexPK();
                if (findPsSearchIndex(id) == null) {
                    throw new NonexistentEntityException("The psSearchIndex with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsSearchIndexPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsSearchIndex psSearchIndex;
            try {
                psSearchIndex = em.getReference(PsSearchIndex.class, id);
                psSearchIndex.getPsSearchIndexPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psSearchIndex with id " + id + " no longer exists.", enfe);
            }
            em.remove(psSearchIndex);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsSearchIndex> findPsSearchIndexEntities() {
        return findPsSearchIndexEntities(true, -1, -1);
    }

    public List<PsSearchIndex> findPsSearchIndexEntities(int maxResults, int firstResult) {
        return findPsSearchIndexEntities(false, maxResults, firstResult);
    }

    private List<PsSearchIndex> findPsSearchIndexEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsSearchIndex.class));
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

    public PsSearchIndex findPsSearchIndex(PsSearchIndexPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsSearchIndex.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsSearchIndexCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsSearchIndex> rt = cq.from(PsSearchIndex.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

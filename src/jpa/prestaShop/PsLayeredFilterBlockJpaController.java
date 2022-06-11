/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsLayeredFilterBlock;
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
public class PsLayeredFilterBlockJpaController implements Serializable {

    public PsLayeredFilterBlockJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsLayeredFilterBlock psLayeredFilterBlock) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psLayeredFilterBlock);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsLayeredFilterBlock(psLayeredFilterBlock.getHash()) != null) {
                throw new PreexistingEntityException("PsLayeredFilterBlock " + psLayeredFilterBlock + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsLayeredFilterBlock psLayeredFilterBlock) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psLayeredFilterBlock = em.merge(psLayeredFilterBlock);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = psLayeredFilterBlock.getHash();
                if (findPsLayeredFilterBlock(id) == null) {
                    throw new NonexistentEntityException("The psLayeredFilterBlock with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsLayeredFilterBlock psLayeredFilterBlock;
            try {
                psLayeredFilterBlock = em.getReference(PsLayeredFilterBlock.class, id);
                psLayeredFilterBlock.getHash();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psLayeredFilterBlock with id " + id + " no longer exists.", enfe);
            }
            em.remove(psLayeredFilterBlock);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsLayeredFilterBlock> findPsLayeredFilterBlockEntities() {
        return findPsLayeredFilterBlockEntities(true, -1, -1);
    }

    public List<PsLayeredFilterBlock> findPsLayeredFilterBlockEntities(int maxResults, int firstResult) {
        return findPsLayeredFilterBlockEntities(false, maxResults, firstResult);
    }

    private List<PsLayeredFilterBlock> findPsLayeredFilterBlockEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsLayeredFilterBlock.class));
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

    public PsLayeredFilterBlock findPsLayeredFilterBlock(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsLayeredFilterBlock.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsLayeredFilterBlockCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsLayeredFilterBlock> rt = cq.from(PsLayeredFilterBlock.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

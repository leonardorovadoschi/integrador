/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsLinkBlock;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.prestaShop.exceptions.NonexistentEntityException;

/**
 *
 * @author leo
 */
public class PsLinkBlockJpaController implements Serializable {

    public PsLinkBlockJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsLinkBlock psLinkBlock) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psLinkBlock);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsLinkBlock psLinkBlock) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psLinkBlock = em.merge(psLinkBlock);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psLinkBlock.getIdLinkBlock();
                if (findPsLinkBlock(id) == null) {
                    throw new NonexistentEntityException("The psLinkBlock with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsLinkBlock psLinkBlock;
            try {
                psLinkBlock = em.getReference(PsLinkBlock.class, id);
                psLinkBlock.getIdLinkBlock();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psLinkBlock with id " + id + " no longer exists.", enfe);
            }
            em.remove(psLinkBlock);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsLinkBlock> findPsLinkBlockEntities() {
        return findPsLinkBlockEntities(true, -1, -1);
    }

    public List<PsLinkBlock> findPsLinkBlockEntities(int maxResults, int firstResult) {
        return findPsLinkBlockEntities(false, maxResults, firstResult);
    }

    private List<PsLinkBlock> findPsLinkBlockEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsLinkBlock.class));
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

    public PsLinkBlock findPsLinkBlock(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsLinkBlock.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsLinkBlockCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsLinkBlock> rt = cq.from(PsLinkBlock.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsShopGroup;
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
public class PsShopGroupJpaController implements Serializable {

    public PsShopGroupJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsShopGroup psShopGroup) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psShopGroup);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsShopGroup psShopGroup) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psShopGroup = em.merge(psShopGroup);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psShopGroup.getIdShopGroup();
                if (findPsShopGroup(id) == null) {
                    throw new NonexistentEntityException("The psShopGroup with id " + id + " no longer exists.");
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
            PsShopGroup psShopGroup;
            try {
                psShopGroup = em.getReference(PsShopGroup.class, id);
                psShopGroup.getIdShopGroup();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psShopGroup with id " + id + " no longer exists.", enfe);
            }
            em.remove(psShopGroup);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsShopGroup> findPsShopGroupEntities() {
        return findPsShopGroupEntities(true, -1, -1);
    }

    public List<PsShopGroup> findPsShopGroupEntities(int maxResults, int firstResult) {
        return findPsShopGroupEntities(false, maxResults, firstResult);
    }

    private List<PsShopGroup> findPsShopGroupEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsShopGroup.class));
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

    public PsShopGroup findPsShopGroup(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsShopGroup.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsShopGroupCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsShopGroup> rt = cq.from(PsShopGroup.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

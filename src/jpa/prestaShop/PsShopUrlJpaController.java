/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsShopUrl;
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
public class PsShopUrlJpaController implements Serializable {

    public PsShopUrlJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsShopUrl psShopUrl) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psShopUrl);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsShopUrl psShopUrl) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psShopUrl = em.merge(psShopUrl);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psShopUrl.getIdShopUrl();
                if (findPsShopUrl(id) == null) {
                    throw new NonexistentEntityException("The psShopUrl with id " + id + " no longer exists.");
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
            PsShopUrl psShopUrl;
            try {
                psShopUrl = em.getReference(PsShopUrl.class, id);
                psShopUrl.getIdShopUrl();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psShopUrl with id " + id + " no longer exists.", enfe);
            }
            em.remove(psShopUrl);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsShopUrl> findPsShopUrlEntities() {
        return findPsShopUrlEntities(true, -1, -1);
    }

    public List<PsShopUrl> findPsShopUrlEntities(int maxResults, int firstResult) {
        return findPsShopUrlEntities(false, maxResults, firstResult);
    }

    private List<PsShopUrl> findPsShopUrlEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsShopUrl.class));
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

    public PsShopUrl findPsShopUrl(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsShopUrl.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsShopUrlCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsShopUrl> rt = cq.from(PsShopUrl.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

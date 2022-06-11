/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsReferrerShop;
import entidade.prestaShop.PsReferrerShopPK;
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
public class PsReferrerShopJpaController implements Serializable {

    public PsReferrerShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsReferrerShop psReferrerShop) throws PreexistingEntityException, Exception {
        if (psReferrerShop.getPsReferrerShopPK() == null) {
            psReferrerShop.setPsReferrerShopPK(new PsReferrerShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psReferrerShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsReferrerShop(psReferrerShop.getPsReferrerShopPK()) != null) {
                throw new PreexistingEntityException("PsReferrerShop " + psReferrerShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsReferrerShop psReferrerShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psReferrerShop = em.merge(psReferrerShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsReferrerShopPK id = psReferrerShop.getPsReferrerShopPK();
                if (findPsReferrerShop(id) == null) {
                    throw new NonexistentEntityException("The psReferrerShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsReferrerShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsReferrerShop psReferrerShop;
            try {
                psReferrerShop = em.getReference(PsReferrerShop.class, id);
                psReferrerShop.getPsReferrerShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psReferrerShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psReferrerShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsReferrerShop> findPsReferrerShopEntities() {
        return findPsReferrerShopEntities(true, -1, -1);
    }

    public List<PsReferrerShop> findPsReferrerShopEntities(int maxResults, int firstResult) {
        return findPsReferrerShopEntities(false, maxResults, firstResult);
    }

    private List<PsReferrerShop> findPsReferrerShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsReferrerShop.class));
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

    public PsReferrerShop findPsReferrerShop(PsReferrerShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsReferrerShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsReferrerShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsReferrerShop> rt = cq.from(PsReferrerShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

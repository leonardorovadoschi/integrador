/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsStoreShop;
import entidade.prestaShop.PsStoreShopPK;
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
public class PsStoreShopJpaController implements Serializable {

    public PsStoreShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsStoreShop psStoreShop) throws PreexistingEntityException, Exception {
        if (psStoreShop.getPsStoreShopPK() == null) {
            psStoreShop.setPsStoreShopPK(new PsStoreShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psStoreShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsStoreShop(psStoreShop.getPsStoreShopPK()) != null) {
                throw new PreexistingEntityException("PsStoreShop " + psStoreShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsStoreShop psStoreShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psStoreShop = em.merge(psStoreShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsStoreShopPK id = psStoreShop.getPsStoreShopPK();
                if (findPsStoreShop(id) == null) {
                    throw new NonexistentEntityException("The psStoreShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsStoreShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsStoreShop psStoreShop;
            try {
                psStoreShop = em.getReference(PsStoreShop.class, id);
                psStoreShop.getPsStoreShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psStoreShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psStoreShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsStoreShop> findPsStoreShopEntities() {
        return findPsStoreShopEntities(true, -1, -1);
    }

    public List<PsStoreShop> findPsStoreShopEntities(int maxResults, int firstResult) {
        return findPsStoreShopEntities(false, maxResults, firstResult);
    }

    private List<PsStoreShop> findPsStoreShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsStoreShop.class));
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

    public PsStoreShop findPsStoreShop(PsStoreShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsStoreShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsStoreShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsStoreShop> rt = cq.from(PsStoreShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

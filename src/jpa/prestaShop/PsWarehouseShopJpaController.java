/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsWarehouseShop;
import entidade.prestaShop.PsWarehouseShopPK;
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
public class PsWarehouseShopJpaController implements Serializable {

    public PsWarehouseShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsWarehouseShop psWarehouseShop) throws PreexistingEntityException, Exception {
        if (psWarehouseShop.getPsWarehouseShopPK() == null) {
            psWarehouseShop.setPsWarehouseShopPK(new PsWarehouseShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psWarehouseShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsWarehouseShop(psWarehouseShop.getPsWarehouseShopPK()) != null) {
                throw new PreexistingEntityException("PsWarehouseShop " + psWarehouseShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsWarehouseShop psWarehouseShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psWarehouseShop = em.merge(psWarehouseShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsWarehouseShopPK id = psWarehouseShop.getPsWarehouseShopPK();
                if (findPsWarehouseShop(id) == null) {
                    throw new NonexistentEntityException("The psWarehouseShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsWarehouseShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsWarehouseShop psWarehouseShop;
            try {
                psWarehouseShop = em.getReference(PsWarehouseShop.class, id);
                psWarehouseShop.getPsWarehouseShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psWarehouseShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psWarehouseShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsWarehouseShop> findPsWarehouseShopEntities() {
        return findPsWarehouseShopEntities(true, -1, -1);
    }

    public List<PsWarehouseShop> findPsWarehouseShopEntities(int maxResults, int firstResult) {
        return findPsWarehouseShopEntities(false, maxResults, firstResult);
    }

    private List<PsWarehouseShop> findPsWarehouseShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsWarehouseShop.class));
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

    public PsWarehouseShop findPsWarehouseShop(PsWarehouseShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsWarehouseShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsWarehouseShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsWarehouseShop> rt = cq.from(PsWarehouseShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

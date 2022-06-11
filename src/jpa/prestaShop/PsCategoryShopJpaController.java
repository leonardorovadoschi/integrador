/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCategoryShop;
import entidade.prestaShop.PsCategoryShopPK;
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
public class PsCategoryShopJpaController implements Serializable {

    public PsCategoryShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCategoryShop psCategoryShop) throws PreexistingEntityException, Exception {
        if (psCategoryShop.getPsCategoryShopPK() == null) {
            psCategoryShop.setPsCategoryShopPK(new PsCategoryShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCategoryShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCategoryShop(psCategoryShop.getPsCategoryShopPK()) != null) {
                throw new PreexistingEntityException("PsCategoryShop " + psCategoryShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCategoryShop psCategoryShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCategoryShop = em.merge(psCategoryShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCategoryShopPK id = psCategoryShop.getPsCategoryShopPK();
                if (findPsCategoryShop(id) == null) {
                    throw new NonexistentEntityException("The psCategoryShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCategoryShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCategoryShop psCategoryShop;
            try {
                psCategoryShop = em.getReference(PsCategoryShop.class, id);
                psCategoryShop.getPsCategoryShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCategoryShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCategoryShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCategoryShop> findPsCategoryShopEntities() {
        return findPsCategoryShopEntities(true, -1, -1);
    }

    public List<PsCategoryShop> findPsCategoryShopEntities(int maxResults, int firstResult) {
        return findPsCategoryShopEntities(false, maxResults, firstResult);
    }

    private List<PsCategoryShop> findPsCategoryShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCategoryShop.class));
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

    public PsCategoryShop findPsCategoryShop(PsCategoryShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCategoryShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCategoryShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCategoryShop> rt = cq.from(PsCategoryShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

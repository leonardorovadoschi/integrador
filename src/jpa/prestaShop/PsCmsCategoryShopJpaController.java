/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCmsCategoryShop;
import entidade.prestaShop.PsCmsCategoryShopPK;
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
public class PsCmsCategoryShopJpaController implements Serializable {

    public PsCmsCategoryShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCmsCategoryShop psCmsCategoryShop) throws PreexistingEntityException, Exception {
        if (psCmsCategoryShop.getPsCmsCategoryShopPK() == null) {
            psCmsCategoryShop.setPsCmsCategoryShopPK(new PsCmsCategoryShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCmsCategoryShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCmsCategoryShop(psCmsCategoryShop.getPsCmsCategoryShopPK()) != null) {
                throw new PreexistingEntityException("PsCmsCategoryShop " + psCmsCategoryShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCmsCategoryShop psCmsCategoryShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCmsCategoryShop = em.merge(psCmsCategoryShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCmsCategoryShopPK id = psCmsCategoryShop.getPsCmsCategoryShopPK();
                if (findPsCmsCategoryShop(id) == null) {
                    throw new NonexistentEntityException("The psCmsCategoryShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCmsCategoryShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCmsCategoryShop psCmsCategoryShop;
            try {
                psCmsCategoryShop = em.getReference(PsCmsCategoryShop.class, id);
                psCmsCategoryShop.getPsCmsCategoryShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCmsCategoryShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCmsCategoryShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCmsCategoryShop> findPsCmsCategoryShopEntities() {
        return findPsCmsCategoryShopEntities(true, -1, -1);
    }

    public List<PsCmsCategoryShop> findPsCmsCategoryShopEntities(int maxResults, int firstResult) {
        return findPsCmsCategoryShopEntities(false, maxResults, firstResult);
    }

    private List<PsCmsCategoryShop> findPsCmsCategoryShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCmsCategoryShop.class));
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

    public PsCmsCategoryShop findPsCmsCategoryShop(PsCmsCategoryShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCmsCategoryShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCmsCategoryShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCmsCategoryShop> rt = cq.from(PsCmsCategoryShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

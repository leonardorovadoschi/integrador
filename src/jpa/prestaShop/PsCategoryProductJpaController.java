/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCategoryProduct;
import entidade.prestaShop.PsCategoryProductPK;
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
public class PsCategoryProductJpaController implements Serializable {

    public PsCategoryProductJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCategoryProduct psCategoryProduct) throws PreexistingEntityException, Exception {
        if (psCategoryProduct.getPsCategoryProductPK() == null) {
            psCategoryProduct.setPsCategoryProductPK(new PsCategoryProductPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCategoryProduct);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCategoryProduct(psCategoryProduct.getPsCategoryProductPK()) != null) {
                throw new PreexistingEntityException("PsCategoryProduct " + psCategoryProduct + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCategoryProduct psCategoryProduct) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCategoryProduct = em.merge(psCategoryProduct);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCategoryProductPK id = psCategoryProduct.getPsCategoryProductPK();
                if (findPsCategoryProduct(id) == null) {
                    throw new NonexistentEntityException("The psCategoryProduct with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCategoryProductPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCategoryProduct psCategoryProduct;
            try {
                psCategoryProduct = em.getReference(PsCategoryProduct.class, id);
                psCategoryProduct.getPsCategoryProductPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCategoryProduct with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCategoryProduct);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCategoryProduct> findPsCategoryProductEntities() {
        return findPsCategoryProductEntities(true, -1, -1);
    }

    public List<PsCategoryProduct> findPsCategoryProductEntities(int maxResults, int firstResult) {
        return findPsCategoryProductEntities(false, maxResults, firstResult);
    }

    private List<PsCategoryProduct> findPsCategoryProductEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCategoryProduct.class));
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

    public PsCategoryProduct findPsCategoryProduct(PsCategoryProductPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCategoryProduct.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCategoryProductCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCategoryProduct> rt = cq.from(PsCategoryProduct.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

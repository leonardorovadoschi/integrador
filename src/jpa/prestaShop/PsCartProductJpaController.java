/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCartProduct;
import entidade.prestaShop.PsCartProductPK;
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
public class PsCartProductJpaController implements Serializable {

    public PsCartProductJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCartProduct psCartProduct) throws PreexistingEntityException, Exception {
        if (psCartProduct.getPsCartProductPK() == null) {
            psCartProduct.setPsCartProductPK(new PsCartProductPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCartProduct);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCartProduct(psCartProduct.getPsCartProductPK()) != null) {
                throw new PreexistingEntityException("PsCartProduct " + psCartProduct + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCartProduct psCartProduct) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCartProduct = em.merge(psCartProduct);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCartProductPK id = psCartProduct.getPsCartProductPK();
                if (findPsCartProduct(id) == null) {
                    throw new NonexistentEntityException("The psCartProduct with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCartProductPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCartProduct psCartProduct;
            try {
                psCartProduct = em.getReference(PsCartProduct.class, id);
                psCartProduct.getPsCartProductPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCartProduct with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCartProduct);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCartProduct> findPsCartProductEntities() {
        return findPsCartProductEntities(true, -1, -1);
    }

    public List<PsCartProduct> findPsCartProductEntities(int maxResults, int firstResult) {
        return findPsCartProductEntities(false, maxResults, firstResult);
    }

    private List<PsCartProduct> findPsCartProductEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCartProduct.class));
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

    public PsCartProduct findPsCartProduct(PsCartProductPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCartProduct.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCartProductCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCartProduct> rt = cq.from(PsCartProduct.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

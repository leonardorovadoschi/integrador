/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsFeatureProduct;
import entidade.prestaShop.PsFeatureProductPK;
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
public class PsFeatureProductJpaController implements Serializable {

    public PsFeatureProductJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsFeatureProduct psFeatureProduct) throws PreexistingEntityException, Exception {
        if (psFeatureProduct.getPsFeatureProductPK() == null) {
            psFeatureProduct.setPsFeatureProductPK(new PsFeatureProductPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psFeatureProduct);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsFeatureProduct(psFeatureProduct.getPsFeatureProductPK()) != null) {
                throw new PreexistingEntityException("PsFeatureProduct " + psFeatureProduct + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsFeatureProduct psFeatureProduct) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psFeatureProduct = em.merge(psFeatureProduct);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsFeatureProductPK id = psFeatureProduct.getPsFeatureProductPK();
                if (findPsFeatureProduct(id) == null) {
                    throw new NonexistentEntityException("The psFeatureProduct with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsFeatureProductPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsFeatureProduct psFeatureProduct;
            try {
                psFeatureProduct = em.getReference(PsFeatureProduct.class, id);
                psFeatureProduct.getPsFeatureProductPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psFeatureProduct with id " + id + " no longer exists.", enfe);
            }
            em.remove(psFeatureProduct);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsFeatureProduct> findPsFeatureProductEntities() {
        return findPsFeatureProductEntities(true, -1, -1);
    }

    public List<PsFeatureProduct> findPsFeatureProductEntities(int maxResults, int firstResult) {
        return findPsFeatureProductEntities(false, maxResults, firstResult);
    }

    private List<PsFeatureProduct> findPsFeatureProductEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsFeatureProduct.class));
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

    public PsFeatureProduct findPsFeatureProduct(PsFeatureProductPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsFeatureProduct.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsFeatureProductCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsFeatureProduct> rt = cq.from(PsFeatureProduct.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

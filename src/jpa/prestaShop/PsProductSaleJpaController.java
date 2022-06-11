/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsProductSale;
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
public class PsProductSaleJpaController implements Serializable {

    public PsProductSaleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsProductSale psProductSale) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psProductSale);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsProductSale(psProductSale.getIdProduct()) != null) {
                throw new PreexistingEntityException("PsProductSale " + psProductSale + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsProductSale psProductSale) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psProductSale = em.merge(psProductSale);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psProductSale.getIdProduct();
                if (findPsProductSale(id) == null) {
                    throw new NonexistentEntityException("The psProductSale with id " + id + " no longer exists.");
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
            PsProductSale psProductSale;
            try {
                psProductSale = em.getReference(PsProductSale.class, id);
                psProductSale.getIdProduct();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psProductSale with id " + id + " no longer exists.", enfe);
            }
            em.remove(psProductSale);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsProductSale> findPsProductSaleEntities() {
        return findPsProductSaleEntities(true, -1, -1);
    }

    public List<PsProductSale> findPsProductSaleEntities(int maxResults, int firstResult) {
        return findPsProductSaleEntities(false, maxResults, firstResult);
    }

    private List<PsProductSale> findPsProductSaleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsProductSale.class));
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

    public PsProductSale findPsProductSale(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsProductSale.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsProductSaleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsProductSale> rt = cq.from(PsProductSale.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

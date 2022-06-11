/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsProductCountryTax;
import entidade.prestaShop.PsProductCountryTaxPK;
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
public class PsProductCountryTaxJpaController implements Serializable {

    public PsProductCountryTaxJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsProductCountryTax psProductCountryTax) throws PreexistingEntityException, Exception {
        if (psProductCountryTax.getPsProductCountryTaxPK() == null) {
            psProductCountryTax.setPsProductCountryTaxPK(new PsProductCountryTaxPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psProductCountryTax);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsProductCountryTax(psProductCountryTax.getPsProductCountryTaxPK()) != null) {
                throw new PreexistingEntityException("PsProductCountryTax " + psProductCountryTax + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsProductCountryTax psProductCountryTax) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psProductCountryTax = em.merge(psProductCountryTax);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsProductCountryTaxPK id = psProductCountryTax.getPsProductCountryTaxPK();
                if (findPsProductCountryTax(id) == null) {
                    throw new NonexistentEntityException("The psProductCountryTax with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsProductCountryTaxPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsProductCountryTax psProductCountryTax;
            try {
                psProductCountryTax = em.getReference(PsProductCountryTax.class, id);
                psProductCountryTax.getPsProductCountryTaxPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psProductCountryTax with id " + id + " no longer exists.", enfe);
            }
            em.remove(psProductCountryTax);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsProductCountryTax> findPsProductCountryTaxEntities() {
        return findPsProductCountryTaxEntities(true, -1, -1);
    }

    public List<PsProductCountryTax> findPsProductCountryTaxEntities(int maxResults, int firstResult) {
        return findPsProductCountryTaxEntities(false, maxResults, firstResult);
    }

    private List<PsProductCountryTax> findPsProductCountryTaxEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsProductCountryTax.class));
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

    public PsProductCountryTax findPsProductCountryTax(PsProductCountryTaxPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsProductCountryTax.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsProductCountryTaxCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsProductCountryTax> rt = cq.from(PsProductCountryTax.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCarrierTaxRulesGroupShop;
import entidade.prestaShop.PsCarrierTaxRulesGroupShopPK;
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
public class PsCarrierTaxRulesGroupShopJpaController implements Serializable {

    public PsCarrierTaxRulesGroupShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCarrierTaxRulesGroupShop psCarrierTaxRulesGroupShop) throws PreexistingEntityException, Exception {
        if (psCarrierTaxRulesGroupShop.getPsCarrierTaxRulesGroupShopPK() == null) {
            psCarrierTaxRulesGroupShop.setPsCarrierTaxRulesGroupShopPK(new PsCarrierTaxRulesGroupShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCarrierTaxRulesGroupShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCarrierTaxRulesGroupShop(psCarrierTaxRulesGroupShop.getPsCarrierTaxRulesGroupShopPK()) != null) {
                throw new PreexistingEntityException("PsCarrierTaxRulesGroupShop " + psCarrierTaxRulesGroupShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCarrierTaxRulesGroupShop psCarrierTaxRulesGroupShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCarrierTaxRulesGroupShop = em.merge(psCarrierTaxRulesGroupShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCarrierTaxRulesGroupShopPK id = psCarrierTaxRulesGroupShop.getPsCarrierTaxRulesGroupShopPK();
                if (findPsCarrierTaxRulesGroupShop(id) == null) {
                    throw new NonexistentEntityException("The psCarrierTaxRulesGroupShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCarrierTaxRulesGroupShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCarrierTaxRulesGroupShop psCarrierTaxRulesGroupShop;
            try {
                psCarrierTaxRulesGroupShop = em.getReference(PsCarrierTaxRulesGroupShop.class, id);
                psCarrierTaxRulesGroupShop.getPsCarrierTaxRulesGroupShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCarrierTaxRulesGroupShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCarrierTaxRulesGroupShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCarrierTaxRulesGroupShop> findPsCarrierTaxRulesGroupShopEntities() {
        return findPsCarrierTaxRulesGroupShopEntities(true, -1, -1);
    }

    public List<PsCarrierTaxRulesGroupShop> findPsCarrierTaxRulesGroupShopEntities(int maxResults, int firstResult) {
        return findPsCarrierTaxRulesGroupShopEntities(false, maxResults, firstResult);
    }

    private List<PsCarrierTaxRulesGroupShop> findPsCarrierTaxRulesGroupShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCarrierTaxRulesGroupShop.class));
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

    public PsCarrierTaxRulesGroupShop findPsCarrierTaxRulesGroupShop(PsCarrierTaxRulesGroupShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCarrierTaxRulesGroupShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCarrierTaxRulesGroupShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCarrierTaxRulesGroupShop> rt = cq.from(PsCarrierTaxRulesGroupShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

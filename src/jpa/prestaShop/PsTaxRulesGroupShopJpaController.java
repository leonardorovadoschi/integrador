/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsTaxRulesGroupShop;
import entidade.prestaShop.PsTaxRulesGroupShopPK;
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
public class PsTaxRulesGroupShopJpaController implements Serializable {

    public PsTaxRulesGroupShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsTaxRulesGroupShop psTaxRulesGroupShop) throws PreexistingEntityException, Exception {
        if (psTaxRulesGroupShop.getPsTaxRulesGroupShopPK() == null) {
            psTaxRulesGroupShop.setPsTaxRulesGroupShopPK(new PsTaxRulesGroupShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psTaxRulesGroupShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsTaxRulesGroupShop(psTaxRulesGroupShop.getPsTaxRulesGroupShopPK()) != null) {
                throw new PreexistingEntityException("PsTaxRulesGroupShop " + psTaxRulesGroupShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsTaxRulesGroupShop psTaxRulesGroupShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psTaxRulesGroupShop = em.merge(psTaxRulesGroupShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsTaxRulesGroupShopPK id = psTaxRulesGroupShop.getPsTaxRulesGroupShopPK();
                if (findPsTaxRulesGroupShop(id) == null) {
                    throw new NonexistentEntityException("The psTaxRulesGroupShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsTaxRulesGroupShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsTaxRulesGroupShop psTaxRulesGroupShop;
            try {
                psTaxRulesGroupShop = em.getReference(PsTaxRulesGroupShop.class, id);
                psTaxRulesGroupShop.getPsTaxRulesGroupShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psTaxRulesGroupShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psTaxRulesGroupShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsTaxRulesGroupShop> findPsTaxRulesGroupShopEntities() {
        return findPsTaxRulesGroupShopEntities(true, -1, -1);
    }

    public List<PsTaxRulesGroupShop> findPsTaxRulesGroupShopEntities(int maxResults, int firstResult) {
        return findPsTaxRulesGroupShopEntities(false, maxResults, firstResult);
    }

    private List<PsTaxRulesGroupShop> findPsTaxRulesGroupShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsTaxRulesGroupShop.class));
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

    public PsTaxRulesGroupShop findPsTaxRulesGroupShop(PsTaxRulesGroupShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsTaxRulesGroupShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsTaxRulesGroupShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsTaxRulesGroupShop> rt = cq.from(PsTaxRulesGroupShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

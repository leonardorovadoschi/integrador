/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCartRuleShop;
import entidade.prestaShop.PsCartRuleShopPK;
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
public class PsCartRuleShopJpaController implements Serializable {

    public PsCartRuleShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCartRuleShop psCartRuleShop) throws PreexistingEntityException, Exception {
        if (psCartRuleShop.getPsCartRuleShopPK() == null) {
            psCartRuleShop.setPsCartRuleShopPK(new PsCartRuleShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCartRuleShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCartRuleShop(psCartRuleShop.getPsCartRuleShopPK()) != null) {
                throw new PreexistingEntityException("PsCartRuleShop " + psCartRuleShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCartRuleShop psCartRuleShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCartRuleShop = em.merge(psCartRuleShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCartRuleShopPK id = psCartRuleShop.getPsCartRuleShopPK();
                if (findPsCartRuleShop(id) == null) {
                    throw new NonexistentEntityException("The psCartRuleShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCartRuleShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCartRuleShop psCartRuleShop;
            try {
                psCartRuleShop = em.getReference(PsCartRuleShop.class, id);
                psCartRuleShop.getPsCartRuleShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCartRuleShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCartRuleShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCartRuleShop> findPsCartRuleShopEntities() {
        return findPsCartRuleShopEntities(true, -1, -1);
    }

    public List<PsCartRuleShop> findPsCartRuleShopEntities(int maxResults, int firstResult) {
        return findPsCartRuleShopEntities(false, maxResults, firstResult);
    }

    private List<PsCartRuleShop> findPsCartRuleShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCartRuleShop.class));
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

    public PsCartRuleShop findPsCartRuleShop(PsCartRuleShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCartRuleShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCartRuleShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCartRuleShop> rt = cq.from(PsCartRuleShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

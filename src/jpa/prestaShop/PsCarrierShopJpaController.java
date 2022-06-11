/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCarrierShop;
import entidade.prestaShop.PsCarrierShopPK;
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
public class PsCarrierShopJpaController implements Serializable {

    public PsCarrierShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCarrierShop psCarrierShop) throws PreexistingEntityException, Exception {
        if (psCarrierShop.getPsCarrierShopPK() == null) {
            psCarrierShop.setPsCarrierShopPK(new PsCarrierShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCarrierShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCarrierShop(psCarrierShop.getPsCarrierShopPK()) != null) {
                throw new PreexistingEntityException("PsCarrierShop " + psCarrierShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCarrierShop psCarrierShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCarrierShop = em.merge(psCarrierShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCarrierShopPK id = psCarrierShop.getPsCarrierShopPK();
                if (findPsCarrierShop(id) == null) {
                    throw new NonexistentEntityException("The psCarrierShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCarrierShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCarrierShop psCarrierShop;
            try {
                psCarrierShop = em.getReference(PsCarrierShop.class, id);
                psCarrierShop.getPsCarrierShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCarrierShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCarrierShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCarrierShop> findPsCarrierShopEntities() {
        return findPsCarrierShopEntities(true, -1, -1);
    }

    public List<PsCarrierShop> findPsCarrierShopEntities(int maxResults, int firstResult) {
        return findPsCarrierShopEntities(false, maxResults, firstResult);
    }

    private List<PsCarrierShop> findPsCarrierShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCarrierShop.class));
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

    public PsCarrierShop findPsCarrierShop(PsCarrierShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCarrierShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCarrierShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCarrierShop> rt = cq.from(PsCarrierShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

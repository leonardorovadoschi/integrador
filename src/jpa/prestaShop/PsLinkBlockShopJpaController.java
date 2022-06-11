/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsLinkBlockShop;
import entidade.prestaShop.PsLinkBlockShopPK;
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
public class PsLinkBlockShopJpaController implements Serializable {

    public PsLinkBlockShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsLinkBlockShop psLinkBlockShop) throws PreexistingEntityException, Exception {
        if (psLinkBlockShop.getPsLinkBlockShopPK() == null) {
            psLinkBlockShop.setPsLinkBlockShopPK(new PsLinkBlockShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psLinkBlockShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsLinkBlockShop(psLinkBlockShop.getPsLinkBlockShopPK()) != null) {
                throw new PreexistingEntityException("PsLinkBlockShop " + psLinkBlockShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsLinkBlockShop psLinkBlockShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psLinkBlockShop = em.merge(psLinkBlockShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsLinkBlockShopPK id = psLinkBlockShop.getPsLinkBlockShopPK();
                if (findPsLinkBlockShop(id) == null) {
                    throw new NonexistentEntityException("The psLinkBlockShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsLinkBlockShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsLinkBlockShop psLinkBlockShop;
            try {
                psLinkBlockShop = em.getReference(PsLinkBlockShop.class, id);
                psLinkBlockShop.getPsLinkBlockShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psLinkBlockShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psLinkBlockShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsLinkBlockShop> findPsLinkBlockShopEntities() {
        return findPsLinkBlockShopEntities(true, -1, -1);
    }

    public List<PsLinkBlockShop> findPsLinkBlockShopEntities(int maxResults, int firstResult) {
        return findPsLinkBlockShopEntities(false, maxResults, firstResult);
    }

    private List<PsLinkBlockShop> findPsLinkBlockShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsLinkBlockShop.class));
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

    public PsLinkBlockShop findPsLinkBlockShop(PsLinkBlockShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsLinkBlockShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsLinkBlockShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsLinkBlockShop> rt = cq.from(PsLinkBlockShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

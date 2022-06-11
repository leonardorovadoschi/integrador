/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsFeatureShop;
import entidade.prestaShop.PsFeatureShopPK;
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
public class PsFeatureShopJpaController implements Serializable {

    public PsFeatureShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsFeatureShop psFeatureShop) throws PreexistingEntityException, Exception {
        if (psFeatureShop.getPsFeatureShopPK() == null) {
            psFeatureShop.setPsFeatureShopPK(new PsFeatureShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psFeatureShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsFeatureShop(psFeatureShop.getPsFeatureShopPK()) != null) {
                throw new PreexistingEntityException("PsFeatureShop " + psFeatureShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsFeatureShop psFeatureShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psFeatureShop = em.merge(psFeatureShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsFeatureShopPK id = psFeatureShop.getPsFeatureShopPK();
                if (findPsFeatureShop(id) == null) {
                    throw new NonexistentEntityException("The psFeatureShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsFeatureShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsFeatureShop psFeatureShop;
            try {
                psFeatureShop = em.getReference(PsFeatureShop.class, id);
                psFeatureShop.getPsFeatureShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psFeatureShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psFeatureShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsFeatureShop> findPsFeatureShopEntities() {
        return findPsFeatureShopEntities(true, -1, -1);
    }

    public List<PsFeatureShop> findPsFeatureShopEntities(int maxResults, int firstResult) {
        return findPsFeatureShopEntities(false, maxResults, firstResult);
    }

    private List<PsFeatureShop> findPsFeatureShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsFeatureShop.class));
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

    public PsFeatureShop findPsFeatureShop(PsFeatureShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsFeatureShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsFeatureShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsFeatureShop> rt = cq.from(PsFeatureShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

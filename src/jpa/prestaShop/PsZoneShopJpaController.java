/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsZoneShop;
import entidade.prestaShop.PsZoneShopPK;
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
public class PsZoneShopJpaController implements Serializable {

    public PsZoneShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsZoneShop psZoneShop) throws PreexistingEntityException, Exception {
        if (psZoneShop.getPsZoneShopPK() == null) {
            psZoneShop.setPsZoneShopPK(new PsZoneShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psZoneShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsZoneShop(psZoneShop.getPsZoneShopPK()) != null) {
                throw new PreexistingEntityException("PsZoneShop " + psZoneShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsZoneShop psZoneShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psZoneShop = em.merge(psZoneShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsZoneShopPK id = psZoneShop.getPsZoneShopPK();
                if (findPsZoneShop(id) == null) {
                    throw new NonexistentEntityException("The psZoneShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsZoneShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsZoneShop psZoneShop;
            try {
                psZoneShop = em.getReference(PsZoneShop.class, id);
                psZoneShop.getPsZoneShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psZoneShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psZoneShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsZoneShop> findPsZoneShopEntities() {
        return findPsZoneShopEntities(true, -1, -1);
    }

    public List<PsZoneShop> findPsZoneShopEntities(int maxResults, int firstResult) {
        return findPsZoneShopEntities(false, maxResults, firstResult);
    }

    private List<PsZoneShop> findPsZoneShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsZoneShop.class));
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

    public PsZoneShop findPsZoneShop(PsZoneShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsZoneShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsZoneShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsZoneShop> rt = cq.from(PsZoneShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

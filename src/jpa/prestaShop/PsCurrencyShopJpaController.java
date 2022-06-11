/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCurrencyShop;
import entidade.prestaShop.PsCurrencyShopPK;
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
public class PsCurrencyShopJpaController implements Serializable {

    public PsCurrencyShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCurrencyShop psCurrencyShop) throws PreexistingEntityException, Exception {
        if (psCurrencyShop.getPsCurrencyShopPK() == null) {
            psCurrencyShop.setPsCurrencyShopPK(new PsCurrencyShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCurrencyShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCurrencyShop(psCurrencyShop.getPsCurrencyShopPK()) != null) {
                throw new PreexistingEntityException("PsCurrencyShop " + psCurrencyShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCurrencyShop psCurrencyShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCurrencyShop = em.merge(psCurrencyShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCurrencyShopPK id = psCurrencyShop.getPsCurrencyShopPK();
                if (findPsCurrencyShop(id) == null) {
                    throw new NonexistentEntityException("The psCurrencyShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCurrencyShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCurrencyShop psCurrencyShop;
            try {
                psCurrencyShop = em.getReference(PsCurrencyShop.class, id);
                psCurrencyShop.getPsCurrencyShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCurrencyShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCurrencyShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCurrencyShop> findPsCurrencyShopEntities() {
        return findPsCurrencyShopEntities(true, -1, -1);
    }

    public List<PsCurrencyShop> findPsCurrencyShopEntities(int maxResults, int firstResult) {
        return findPsCurrencyShopEntities(false, maxResults, firstResult);
    }

    private List<PsCurrencyShop> findPsCurrencyShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCurrencyShop.class));
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

    public PsCurrencyShop findPsCurrencyShop(PsCurrencyShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCurrencyShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCurrencyShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCurrencyShop> rt = cq.from(PsCurrencyShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

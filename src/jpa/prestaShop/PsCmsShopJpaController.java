/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCmsShop;
import entidade.prestaShop.PsCmsShopPK;
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
public class PsCmsShopJpaController implements Serializable {

    public PsCmsShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCmsShop psCmsShop) throws PreexistingEntityException, Exception {
        if (psCmsShop.getPsCmsShopPK() == null) {
            psCmsShop.setPsCmsShopPK(new PsCmsShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCmsShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCmsShop(psCmsShop.getPsCmsShopPK()) != null) {
                throw new PreexistingEntityException("PsCmsShop " + psCmsShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCmsShop psCmsShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCmsShop = em.merge(psCmsShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCmsShopPK id = psCmsShop.getPsCmsShopPK();
                if (findPsCmsShop(id) == null) {
                    throw new NonexistentEntityException("The psCmsShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCmsShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCmsShop psCmsShop;
            try {
                psCmsShop = em.getReference(PsCmsShop.class, id);
                psCmsShop.getPsCmsShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCmsShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCmsShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCmsShop> findPsCmsShopEntities() {
        return findPsCmsShopEntities(true, -1, -1);
    }

    public List<PsCmsShop> findPsCmsShopEntities(int maxResults, int firstResult) {
        return findPsCmsShopEntities(false, maxResults, firstResult);
    }

    private List<PsCmsShop> findPsCmsShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCmsShop.class));
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

    public PsCmsShop findPsCmsShop(PsCmsShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCmsShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCmsShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCmsShop> rt = cq.from(PsCmsShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

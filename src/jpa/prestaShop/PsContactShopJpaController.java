/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsContactShop;
import entidade.prestaShop.PsContactShopPK;
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
public class PsContactShopJpaController implements Serializable {

    public PsContactShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsContactShop psContactShop) throws PreexistingEntityException, Exception {
        if (psContactShop.getPsContactShopPK() == null) {
            psContactShop.setPsContactShopPK(new PsContactShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psContactShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsContactShop(psContactShop.getPsContactShopPK()) != null) {
                throw new PreexistingEntityException("PsContactShop " + psContactShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsContactShop psContactShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psContactShop = em.merge(psContactShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsContactShopPK id = psContactShop.getPsContactShopPK();
                if (findPsContactShop(id) == null) {
                    throw new NonexistentEntityException("The psContactShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsContactShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsContactShop psContactShop;
            try {
                psContactShop = em.getReference(PsContactShop.class, id);
                psContactShop.getPsContactShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psContactShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psContactShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsContactShop> findPsContactShopEntities() {
        return findPsContactShopEntities(true, -1, -1);
    }

    public List<PsContactShop> findPsContactShopEntities(int maxResults, int firstResult) {
        return findPsContactShopEntities(false, maxResults, firstResult);
    }

    private List<PsContactShop> findPsContactShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsContactShop.class));
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

    public PsContactShop findPsContactShop(PsContactShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsContactShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsContactShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsContactShop> rt = cq.from(PsContactShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

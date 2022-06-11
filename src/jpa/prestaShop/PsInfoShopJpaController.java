/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsInfoShop;
import entidade.prestaShop.PsInfoShopPK;
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
public class PsInfoShopJpaController implements Serializable {

    public PsInfoShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsInfoShop psInfoShop) throws PreexistingEntityException, Exception {
        if (psInfoShop.getPsInfoShopPK() == null) {
            psInfoShop.setPsInfoShopPK(new PsInfoShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psInfoShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsInfoShop(psInfoShop.getPsInfoShopPK()) != null) {
                throw new PreexistingEntityException("PsInfoShop " + psInfoShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsInfoShop psInfoShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psInfoShop = em.merge(psInfoShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsInfoShopPK id = psInfoShop.getPsInfoShopPK();
                if (findPsInfoShop(id) == null) {
                    throw new NonexistentEntityException("The psInfoShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsInfoShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsInfoShop psInfoShop;
            try {
                psInfoShop = em.getReference(PsInfoShop.class, id);
                psInfoShop.getPsInfoShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psInfoShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psInfoShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsInfoShop> findPsInfoShopEntities() {
        return findPsInfoShopEntities(true, -1, -1);
    }

    public List<PsInfoShop> findPsInfoShopEntities(int maxResults, int firstResult) {
        return findPsInfoShopEntities(false, maxResults, firstResult);
    }

    private List<PsInfoShop> findPsInfoShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsInfoShop.class));
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

    public PsInfoShop findPsInfoShop(PsInfoShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsInfoShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsInfoShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsInfoShop> rt = cq.from(PsInfoShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

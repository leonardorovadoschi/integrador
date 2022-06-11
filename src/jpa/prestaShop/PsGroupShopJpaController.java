/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsGroupShop;
import entidade.prestaShop.PsGroupShopPK;
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
public class PsGroupShopJpaController implements Serializable {

    public PsGroupShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsGroupShop psGroupShop) throws PreexistingEntityException, Exception {
        if (psGroupShop.getPsGroupShopPK() == null) {
            psGroupShop.setPsGroupShopPK(new PsGroupShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psGroupShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsGroupShop(psGroupShop.getPsGroupShopPK()) != null) {
                throw new PreexistingEntityException("PsGroupShop " + psGroupShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsGroupShop psGroupShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psGroupShop = em.merge(psGroupShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsGroupShopPK id = psGroupShop.getPsGroupShopPK();
                if (findPsGroupShop(id) == null) {
                    throw new NonexistentEntityException("The psGroupShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsGroupShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsGroupShop psGroupShop;
            try {
                psGroupShop = em.getReference(PsGroupShop.class, id);
                psGroupShop.getPsGroupShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psGroupShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psGroupShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsGroupShop> findPsGroupShopEntities() {
        return findPsGroupShopEntities(true, -1, -1);
    }

    public List<PsGroupShop> findPsGroupShopEntities(int maxResults, int firstResult) {
        return findPsGroupShopEntities(false, maxResults, firstResult);
    }

    private List<PsGroupShop> findPsGroupShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsGroupShop.class));
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

    public PsGroupShop findPsGroupShop(PsGroupShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsGroupShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsGroupShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsGroupShop> rt = cq.from(PsGroupShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

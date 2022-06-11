/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsProductShop;
import entidade.prestaShop.PsProductShopPK;
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
public class PsProductShopJpaController implements Serializable {

    public PsProductShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsProductShop psProductShop) throws PreexistingEntityException, Exception {
        if (psProductShop.getPsProductShopPK() == null) {
            psProductShop.setPsProductShopPK(new PsProductShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psProductShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsProductShop(psProductShop.getPsProductShopPK()) != null) {
                throw new PreexistingEntityException("PsProductShop " + psProductShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsProductShop psProductShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psProductShop = em.merge(psProductShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsProductShopPK id = psProductShop.getPsProductShopPK();
                if (findPsProductShop(id) == null) {
                    throw new NonexistentEntityException("The psProductShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsProductShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsProductShop psProductShop;
            try {
                psProductShop = em.getReference(PsProductShop.class, id);
                psProductShop.getPsProductShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psProductShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psProductShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsProductShop> findPsProductShopEntities() {
        return findPsProductShopEntities(true, -1, -1);
    }

    public List<PsProductShop> findPsProductShopEntities(int maxResults, int firstResult) {
        return findPsProductShopEntities(false, maxResults, firstResult);
    }

    private List<PsProductShop> findPsProductShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsProductShop.class));
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

    public PsProductShop findPsProductShop(PsProductShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsProductShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsProductShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsProductShop> rt = cq.from(PsProductShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsProductAttributeShop;
import entidade.prestaShop.PsProductAttributeShopPK;
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
public class PsProductAttributeShopJpaController implements Serializable {

    public PsProductAttributeShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsProductAttributeShop psProductAttributeShop) throws PreexistingEntityException, Exception {
        if (psProductAttributeShop.getPsProductAttributeShopPK() == null) {
            psProductAttributeShop.setPsProductAttributeShopPK(new PsProductAttributeShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psProductAttributeShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsProductAttributeShop(psProductAttributeShop.getPsProductAttributeShopPK()) != null) {
                throw new PreexistingEntityException("PsProductAttributeShop " + psProductAttributeShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsProductAttributeShop psProductAttributeShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psProductAttributeShop = em.merge(psProductAttributeShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsProductAttributeShopPK id = psProductAttributeShop.getPsProductAttributeShopPK();
                if (findPsProductAttributeShop(id) == null) {
                    throw new NonexistentEntityException("The psProductAttributeShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsProductAttributeShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsProductAttributeShop psProductAttributeShop;
            try {
                psProductAttributeShop = em.getReference(PsProductAttributeShop.class, id);
                psProductAttributeShop.getPsProductAttributeShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psProductAttributeShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psProductAttributeShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsProductAttributeShop> findPsProductAttributeShopEntities() {
        return findPsProductAttributeShopEntities(true, -1, -1);
    }

    public List<PsProductAttributeShop> findPsProductAttributeShopEntities(int maxResults, int firstResult) {
        return findPsProductAttributeShopEntities(false, maxResults, firstResult);
    }

    private List<PsProductAttributeShop> findPsProductAttributeShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsProductAttributeShop.class));
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

    public PsProductAttributeShop findPsProductAttributeShop(PsProductAttributeShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsProductAttributeShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsProductAttributeShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsProductAttributeShop> rt = cq.from(PsProductAttributeShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

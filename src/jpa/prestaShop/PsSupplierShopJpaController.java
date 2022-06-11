/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsSupplierShop;
import entidade.prestaShop.PsSupplierShopPK;
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
public class PsSupplierShopJpaController implements Serializable {

    public PsSupplierShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsSupplierShop psSupplierShop) throws PreexistingEntityException, Exception {
        if (psSupplierShop.getPsSupplierShopPK() == null) {
            psSupplierShop.setPsSupplierShopPK(new PsSupplierShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psSupplierShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsSupplierShop(psSupplierShop.getPsSupplierShopPK()) != null) {
                throw new PreexistingEntityException("PsSupplierShop " + psSupplierShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsSupplierShop psSupplierShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psSupplierShop = em.merge(psSupplierShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsSupplierShopPK id = psSupplierShop.getPsSupplierShopPK();
                if (findPsSupplierShop(id) == null) {
                    throw new NonexistentEntityException("The psSupplierShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsSupplierShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsSupplierShop psSupplierShop;
            try {
                psSupplierShop = em.getReference(PsSupplierShop.class, id);
                psSupplierShop.getPsSupplierShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psSupplierShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psSupplierShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsSupplierShop> findPsSupplierShopEntities() {
        return findPsSupplierShopEntities(true, -1, -1);
    }

    public List<PsSupplierShop> findPsSupplierShopEntities(int maxResults, int firstResult) {
        return findPsSupplierShopEntities(false, maxResults, firstResult);
    }

    private List<PsSupplierShop> findPsSupplierShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsSupplierShop.class));
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

    public PsSupplierShop findPsSupplierShop(PsSupplierShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsSupplierShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsSupplierShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsSupplierShop> rt = cq.from(PsSupplierShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

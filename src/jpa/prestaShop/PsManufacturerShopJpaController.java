/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsManufacturerShop;
import entidade.prestaShop.PsManufacturerShopPK;
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
public class PsManufacturerShopJpaController implements Serializable {

    public PsManufacturerShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsManufacturerShop psManufacturerShop) throws PreexistingEntityException, Exception {
        if (psManufacturerShop.getPsManufacturerShopPK() == null) {
            psManufacturerShop.setPsManufacturerShopPK(new PsManufacturerShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psManufacturerShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsManufacturerShop(psManufacturerShop.getPsManufacturerShopPK()) != null) {
                throw new PreexistingEntityException("PsManufacturerShop " + psManufacturerShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsManufacturerShop psManufacturerShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psManufacturerShop = em.merge(psManufacturerShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsManufacturerShopPK id = psManufacturerShop.getPsManufacturerShopPK();
                if (findPsManufacturerShop(id) == null) {
                    throw new NonexistentEntityException("The psManufacturerShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsManufacturerShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsManufacturerShop psManufacturerShop;
            try {
                psManufacturerShop = em.getReference(PsManufacturerShop.class, id);
                psManufacturerShop.getPsManufacturerShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psManufacturerShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psManufacturerShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsManufacturerShop> findPsManufacturerShopEntities() {
        return findPsManufacturerShopEntities(true, -1, -1);
    }

    public List<PsManufacturerShop> findPsManufacturerShopEntities(int maxResults, int firstResult) {
        return findPsManufacturerShopEntities(false, maxResults, firstResult);
    }

    private List<PsManufacturerShop> findPsManufacturerShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsManufacturerShop.class));
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

    public PsManufacturerShop findPsManufacturerShop(PsManufacturerShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsManufacturerShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsManufacturerShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsManufacturerShop> rt = cq.from(PsManufacturerShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

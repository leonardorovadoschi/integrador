/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsModuleShop;
import entidade.prestaShop.PsModuleShopPK;
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
public class PsModuleShopJpaController implements Serializable {

    public PsModuleShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsModuleShop psModuleShop) throws PreexistingEntityException, Exception {
        if (psModuleShop.getPsModuleShopPK() == null) {
            psModuleShop.setPsModuleShopPK(new PsModuleShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psModuleShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsModuleShop(psModuleShop.getPsModuleShopPK()) != null) {
                throw new PreexistingEntityException("PsModuleShop " + psModuleShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsModuleShop psModuleShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psModuleShop = em.merge(psModuleShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsModuleShopPK id = psModuleShop.getPsModuleShopPK();
                if (findPsModuleShop(id) == null) {
                    throw new NonexistentEntityException("The psModuleShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsModuleShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsModuleShop psModuleShop;
            try {
                psModuleShop = em.getReference(PsModuleShop.class, id);
                psModuleShop.getPsModuleShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psModuleShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psModuleShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsModuleShop> findPsModuleShopEntities() {
        return findPsModuleShopEntities(true, -1, -1);
    }

    public List<PsModuleShop> findPsModuleShopEntities(int maxResults, int firstResult) {
        return findPsModuleShopEntities(false, maxResults, firstResult);
    }

    private List<PsModuleShop> findPsModuleShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsModuleShop.class));
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

    public PsModuleShop findPsModuleShop(PsModuleShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsModuleShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsModuleShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsModuleShop> rt = cq.from(PsModuleShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsAttributeShop;
import entidade.prestaShop.PsAttributeShopPK;
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
public class PsAttributeShopJpaController implements Serializable {

    public PsAttributeShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsAttributeShop psAttributeShop) throws PreexistingEntityException, Exception {
        if (psAttributeShop.getPsAttributeShopPK() == null) {
            psAttributeShop.setPsAttributeShopPK(new PsAttributeShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psAttributeShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsAttributeShop(psAttributeShop.getPsAttributeShopPK()) != null) {
                throw new PreexistingEntityException("PsAttributeShop " + psAttributeShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsAttributeShop psAttributeShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psAttributeShop = em.merge(psAttributeShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsAttributeShopPK id = psAttributeShop.getPsAttributeShopPK();
                if (findPsAttributeShop(id) == null) {
                    throw new NonexistentEntityException("The psAttributeShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsAttributeShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsAttributeShop psAttributeShop;
            try {
                psAttributeShop = em.getReference(PsAttributeShop.class, id);
                psAttributeShop.getPsAttributeShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psAttributeShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psAttributeShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsAttributeShop> findPsAttributeShopEntities() {
        return findPsAttributeShopEntities(true, -1, -1);
    }

    public List<PsAttributeShop> findPsAttributeShopEntities(int maxResults, int firstResult) {
        return findPsAttributeShopEntities(false, maxResults, firstResult);
    }

    private List<PsAttributeShop> findPsAttributeShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsAttributeShop.class));
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

    public PsAttributeShop findPsAttributeShop(PsAttributeShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsAttributeShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsAttributeShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsAttributeShop> rt = cq.from(PsAttributeShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

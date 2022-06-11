/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsAttributeGroupShop;
import entidade.prestaShop.PsAttributeGroupShopPK;
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
public class PsAttributeGroupShopJpaController implements Serializable {

    public PsAttributeGroupShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsAttributeGroupShop psAttributeGroupShop) throws PreexistingEntityException, Exception {
        if (psAttributeGroupShop.getPsAttributeGroupShopPK() == null) {
            psAttributeGroupShop.setPsAttributeGroupShopPK(new PsAttributeGroupShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psAttributeGroupShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsAttributeGroupShop(psAttributeGroupShop.getPsAttributeGroupShopPK()) != null) {
                throw new PreexistingEntityException("PsAttributeGroupShop " + psAttributeGroupShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsAttributeGroupShop psAttributeGroupShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psAttributeGroupShop = em.merge(psAttributeGroupShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsAttributeGroupShopPK id = psAttributeGroupShop.getPsAttributeGroupShopPK();
                if (findPsAttributeGroupShop(id) == null) {
                    throw new NonexistentEntityException("The psAttributeGroupShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsAttributeGroupShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsAttributeGroupShop psAttributeGroupShop;
            try {
                psAttributeGroupShop = em.getReference(PsAttributeGroupShop.class, id);
                psAttributeGroupShop.getPsAttributeGroupShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psAttributeGroupShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psAttributeGroupShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsAttributeGroupShop> findPsAttributeGroupShopEntities() {
        return findPsAttributeGroupShopEntities(true, -1, -1);
    }

    public List<PsAttributeGroupShop> findPsAttributeGroupShopEntities(int maxResults, int firstResult) {
        return findPsAttributeGroupShopEntities(false, maxResults, firstResult);
    }

    private List<PsAttributeGroupShop> findPsAttributeGroupShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsAttributeGroupShop.class));
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

    public PsAttributeGroupShop findPsAttributeGroupShop(PsAttributeGroupShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsAttributeGroupShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsAttributeGroupShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsAttributeGroupShop> rt = cq.from(PsAttributeGroupShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

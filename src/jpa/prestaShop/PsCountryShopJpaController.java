/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCountryShop;
import entidade.prestaShop.PsCountryShopPK;
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
public class PsCountryShopJpaController implements Serializable {

    public PsCountryShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCountryShop psCountryShop) throws PreexistingEntityException, Exception {
        if (psCountryShop.getPsCountryShopPK() == null) {
            psCountryShop.setPsCountryShopPK(new PsCountryShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCountryShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCountryShop(psCountryShop.getPsCountryShopPK()) != null) {
                throw new PreexistingEntityException("PsCountryShop " + psCountryShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCountryShop psCountryShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCountryShop = em.merge(psCountryShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCountryShopPK id = psCountryShop.getPsCountryShopPK();
                if (findPsCountryShop(id) == null) {
                    throw new NonexistentEntityException("The psCountryShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCountryShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCountryShop psCountryShop;
            try {
                psCountryShop = em.getReference(PsCountryShop.class, id);
                psCountryShop.getPsCountryShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCountryShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCountryShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCountryShop> findPsCountryShopEntities() {
        return findPsCountryShopEntities(true, -1, -1);
    }

    public List<PsCountryShop> findPsCountryShopEntities(int maxResults, int firstResult) {
        return findPsCountryShopEntities(false, maxResults, firstResult);
    }

    private List<PsCountryShop> findPsCountryShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCountryShop.class));
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

    public PsCountryShop findPsCountryShop(PsCountryShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCountryShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCountryShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCountryShop> rt = cq.from(PsCountryShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

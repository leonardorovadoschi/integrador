/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsLangShop;
import entidade.prestaShop.PsLangShopPK;
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
public class PsLangShopJpaController implements Serializable {

    public PsLangShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsLangShop psLangShop) throws PreexistingEntityException, Exception {
        if (psLangShop.getPsLangShopPK() == null) {
            psLangShop.setPsLangShopPK(new PsLangShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psLangShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsLangShop(psLangShop.getPsLangShopPK()) != null) {
                throw new PreexistingEntityException("PsLangShop " + psLangShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsLangShop psLangShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psLangShop = em.merge(psLangShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsLangShopPK id = psLangShop.getPsLangShopPK();
                if (findPsLangShop(id) == null) {
                    throw new NonexistentEntityException("The psLangShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsLangShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsLangShop psLangShop;
            try {
                psLangShop = em.getReference(PsLangShop.class, id);
                psLangShop.getPsLangShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psLangShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psLangShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsLangShop> findPsLangShopEntities() {
        return findPsLangShopEntities(true, -1, -1);
    }

    public List<PsLangShop> findPsLangShopEntities(int maxResults, int firstResult) {
        return findPsLangShopEntities(false, maxResults, firstResult);
    }

    private List<PsLangShop> findPsLangShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsLangShop.class));
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

    public PsLangShop findPsLangShop(PsLangShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsLangShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsLangShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsLangShop> rt = cq.from(PsLangShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

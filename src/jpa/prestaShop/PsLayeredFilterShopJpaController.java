/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsLayeredFilterShop;
import entidade.prestaShop.PsLayeredFilterShopPK;
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
public class PsLayeredFilterShopJpaController implements Serializable {

    public PsLayeredFilterShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsLayeredFilterShop psLayeredFilterShop) throws PreexistingEntityException, Exception {
        if (psLayeredFilterShop.getPsLayeredFilterShopPK() == null) {
            psLayeredFilterShop.setPsLayeredFilterShopPK(new PsLayeredFilterShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psLayeredFilterShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsLayeredFilterShop(psLayeredFilterShop.getPsLayeredFilterShopPK()) != null) {
                throw new PreexistingEntityException("PsLayeredFilterShop " + psLayeredFilterShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsLayeredFilterShop psLayeredFilterShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psLayeredFilterShop = em.merge(psLayeredFilterShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsLayeredFilterShopPK id = psLayeredFilterShop.getPsLayeredFilterShopPK();
                if (findPsLayeredFilterShop(id) == null) {
                    throw new NonexistentEntityException("The psLayeredFilterShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsLayeredFilterShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsLayeredFilterShop psLayeredFilterShop;
            try {
                psLayeredFilterShop = em.getReference(PsLayeredFilterShop.class, id);
                psLayeredFilterShop.getPsLayeredFilterShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psLayeredFilterShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psLayeredFilterShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsLayeredFilterShop> findPsLayeredFilterShopEntities() {
        return findPsLayeredFilterShopEntities(true, -1, -1);
    }

    public List<PsLayeredFilterShop> findPsLayeredFilterShopEntities(int maxResults, int firstResult) {
        return findPsLayeredFilterShopEntities(false, maxResults, firstResult);
    }

    private List<PsLayeredFilterShop> findPsLayeredFilterShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsLayeredFilterShop.class));
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

    public PsLayeredFilterShop findPsLayeredFilterShop(PsLayeredFilterShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsLayeredFilterShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsLayeredFilterShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsLayeredFilterShop> rt = cq.from(PsLayeredFilterShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

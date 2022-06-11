/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsEmployeeShop;
import entidade.prestaShop.PsEmployeeShopPK;
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
public class PsEmployeeShopJpaController implements Serializable {

    public PsEmployeeShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsEmployeeShop psEmployeeShop) throws PreexistingEntityException, Exception {
        if (psEmployeeShop.getPsEmployeeShopPK() == null) {
            psEmployeeShop.setPsEmployeeShopPK(new PsEmployeeShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psEmployeeShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsEmployeeShop(psEmployeeShop.getPsEmployeeShopPK()) != null) {
                throw new PreexistingEntityException("PsEmployeeShop " + psEmployeeShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsEmployeeShop psEmployeeShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psEmployeeShop = em.merge(psEmployeeShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsEmployeeShopPK id = psEmployeeShop.getPsEmployeeShopPK();
                if (findPsEmployeeShop(id) == null) {
                    throw new NonexistentEntityException("The psEmployeeShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsEmployeeShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsEmployeeShop psEmployeeShop;
            try {
                psEmployeeShop = em.getReference(PsEmployeeShop.class, id);
                psEmployeeShop.getPsEmployeeShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psEmployeeShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psEmployeeShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsEmployeeShop> findPsEmployeeShopEntities() {
        return findPsEmployeeShopEntities(true, -1, -1);
    }

    public List<PsEmployeeShop> findPsEmployeeShopEntities(int maxResults, int firstResult) {
        return findPsEmployeeShopEntities(false, maxResults, firstResult);
    }

    private List<PsEmployeeShop> findPsEmployeeShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsEmployeeShop.class));
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

    public PsEmployeeShop findPsEmployeeShop(PsEmployeeShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsEmployeeShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsEmployeeShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsEmployeeShop> rt = cq.from(PsEmployeeShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

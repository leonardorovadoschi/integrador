/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsWebserviceAccountShop;
import entidade.prestaShop.PsWebserviceAccountShopPK;
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
public class PsWebserviceAccountShopJpaController implements Serializable {

    public PsWebserviceAccountShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsWebserviceAccountShop psWebserviceAccountShop) throws PreexistingEntityException, Exception {
        if (psWebserviceAccountShop.getPsWebserviceAccountShopPK() == null) {
            psWebserviceAccountShop.setPsWebserviceAccountShopPK(new PsWebserviceAccountShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psWebserviceAccountShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsWebserviceAccountShop(psWebserviceAccountShop.getPsWebserviceAccountShopPK()) != null) {
                throw new PreexistingEntityException("PsWebserviceAccountShop " + psWebserviceAccountShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsWebserviceAccountShop psWebserviceAccountShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psWebserviceAccountShop = em.merge(psWebserviceAccountShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsWebserviceAccountShopPK id = psWebserviceAccountShop.getPsWebserviceAccountShopPK();
                if (findPsWebserviceAccountShop(id) == null) {
                    throw new NonexistentEntityException("The psWebserviceAccountShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsWebserviceAccountShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsWebserviceAccountShop psWebserviceAccountShop;
            try {
                psWebserviceAccountShop = em.getReference(PsWebserviceAccountShop.class, id);
                psWebserviceAccountShop.getPsWebserviceAccountShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psWebserviceAccountShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psWebserviceAccountShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsWebserviceAccountShop> findPsWebserviceAccountShopEntities() {
        return findPsWebserviceAccountShopEntities(true, -1, -1);
    }

    public List<PsWebserviceAccountShop> findPsWebserviceAccountShopEntities(int maxResults, int firstResult) {
        return findPsWebserviceAccountShopEntities(false, maxResults, firstResult);
    }

    private List<PsWebserviceAccountShop> findPsWebserviceAccountShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsWebserviceAccountShop.class));
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

    public PsWebserviceAccountShop findPsWebserviceAccountShop(PsWebserviceAccountShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsWebserviceAccountShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsWebserviceAccountShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsWebserviceAccountShop> rt = cq.from(PsWebserviceAccountShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

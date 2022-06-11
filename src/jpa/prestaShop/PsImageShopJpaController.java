/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsImageShop;
import entidade.prestaShop.PsImageShopPK;
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
public class PsImageShopJpaController implements Serializable {

    public PsImageShopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsImageShop psImageShop) throws PreexistingEntityException, Exception {
        if (psImageShop.getPsImageShopPK() == null) {
            psImageShop.setPsImageShopPK(new PsImageShopPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psImageShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsImageShop(psImageShop.getPsImageShopPK()) != null) {
                throw new PreexistingEntityException("PsImageShop " + psImageShop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsImageShop psImageShop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psImageShop = em.merge(psImageShop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsImageShopPK id = psImageShop.getPsImageShopPK();
                if (findPsImageShop(id) == null) {
                    throw new NonexistentEntityException("The psImageShop with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsImageShopPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsImageShop psImageShop;
            try {
                psImageShop = em.getReference(PsImageShop.class, id);
                psImageShop.getPsImageShopPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psImageShop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psImageShop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsImageShop> findPsImageShopEntities() {
        return findPsImageShopEntities(true, -1, -1);
    }

    public List<PsImageShop> findPsImageShopEntities(int maxResults, int firstResult) {
        return findPsImageShopEntities(false, maxResults, firstResult);
    }

    private List<PsImageShop> findPsImageShopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsImageShop.class));
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

    public PsImageShop findPsImageShop(PsImageShopPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsImageShop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsImageShopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsImageShop> rt = cq.from(PsImageShop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

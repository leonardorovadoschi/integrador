/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsAccess;
import entidade.prestaShop.PsAccessPK;
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
public class PsAccessJpaController implements Serializable {

    public PsAccessJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsAccess psAccess) throws PreexistingEntityException, Exception {
        if (psAccess.getPsAccessPK() == null) {
            psAccess.setPsAccessPK(new PsAccessPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psAccess);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsAccess(psAccess.getPsAccessPK()) != null) {
                throw new PreexistingEntityException("PsAccess " + psAccess + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsAccess psAccess) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psAccess = em.merge(psAccess);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsAccessPK id = psAccess.getPsAccessPK();
                if (findPsAccess(id) == null) {
                    throw new NonexistentEntityException("The psAccess with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsAccessPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsAccess psAccess;
            try {
                psAccess = em.getReference(PsAccess.class, id);
                psAccess.getPsAccessPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psAccess with id " + id + " no longer exists.", enfe);
            }
            em.remove(psAccess);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsAccess> findPsAccessEntities() {
        return findPsAccessEntities(true, -1, -1);
    }

    public List<PsAccess> findPsAccessEntities(int maxResults, int firstResult) {
        return findPsAccessEntities(false, maxResults, firstResult);
    }

    private List<PsAccess> findPsAccessEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsAccess.class));
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

    public PsAccess findPsAccess(PsAccessPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsAccess.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsAccessCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsAccess> rt = cq.from(PsAccess.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

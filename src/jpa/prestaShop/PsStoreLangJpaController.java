/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsStoreLang;
import entidade.prestaShop.PsStoreLangPK;
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
public class PsStoreLangJpaController implements Serializable {

    public PsStoreLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsStoreLang psStoreLang) throws PreexistingEntityException, Exception {
        if (psStoreLang.getPsStoreLangPK() == null) {
            psStoreLang.setPsStoreLangPK(new PsStoreLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psStoreLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsStoreLang(psStoreLang.getPsStoreLangPK()) != null) {
                throw new PreexistingEntityException("PsStoreLang " + psStoreLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsStoreLang psStoreLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psStoreLang = em.merge(psStoreLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsStoreLangPK id = psStoreLang.getPsStoreLangPK();
                if (findPsStoreLang(id) == null) {
                    throw new NonexistentEntityException("The psStoreLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsStoreLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsStoreLang psStoreLang;
            try {
                psStoreLang = em.getReference(PsStoreLang.class, id);
                psStoreLang.getPsStoreLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psStoreLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psStoreLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsStoreLang> findPsStoreLangEntities() {
        return findPsStoreLangEntities(true, -1, -1);
    }

    public List<PsStoreLang> findPsStoreLangEntities(int maxResults, int firstResult) {
        return findPsStoreLangEntities(false, maxResults, firstResult);
    }

    private List<PsStoreLang> findPsStoreLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsStoreLang.class));
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

    public PsStoreLang findPsStoreLang(PsStoreLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsStoreLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsStoreLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsStoreLang> rt = cq.from(PsStoreLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

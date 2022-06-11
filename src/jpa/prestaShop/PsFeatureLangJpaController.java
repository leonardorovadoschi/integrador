/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsFeatureLang;
import entidade.prestaShop.PsFeatureLangPK;
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
public class PsFeatureLangJpaController implements Serializable {

    public PsFeatureLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsFeatureLang psFeatureLang) throws PreexistingEntityException, Exception {
        if (psFeatureLang.getPsFeatureLangPK() == null) {
            psFeatureLang.setPsFeatureLangPK(new PsFeatureLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psFeatureLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsFeatureLang(psFeatureLang.getPsFeatureLangPK()) != null) {
                throw new PreexistingEntityException("PsFeatureLang " + psFeatureLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsFeatureLang psFeatureLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psFeatureLang = em.merge(psFeatureLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsFeatureLangPK id = psFeatureLang.getPsFeatureLangPK();
                if (findPsFeatureLang(id) == null) {
                    throw new NonexistentEntityException("The psFeatureLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsFeatureLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsFeatureLang psFeatureLang;
            try {
                psFeatureLang = em.getReference(PsFeatureLang.class, id);
                psFeatureLang.getPsFeatureLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psFeatureLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psFeatureLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsFeatureLang> findPsFeatureLangEntities() {
        return findPsFeatureLangEntities(true, -1, -1);
    }

    public List<PsFeatureLang> findPsFeatureLangEntities(int maxResults, int firstResult) {
        return findPsFeatureLangEntities(false, maxResults, firstResult);
    }

    private List<PsFeatureLang> findPsFeatureLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsFeatureLang.class));
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

    public PsFeatureLang findPsFeatureLang(PsFeatureLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsFeatureLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsFeatureLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsFeatureLang> rt = cq.from(PsFeatureLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsQuickAccessLang;
import entidade.prestaShop.PsQuickAccessLangPK;
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
public class PsQuickAccessLangJpaController implements Serializable {

    public PsQuickAccessLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsQuickAccessLang psQuickAccessLang) throws PreexistingEntityException, Exception {
        if (psQuickAccessLang.getPsQuickAccessLangPK() == null) {
            psQuickAccessLang.setPsQuickAccessLangPK(new PsQuickAccessLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psQuickAccessLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsQuickAccessLang(psQuickAccessLang.getPsQuickAccessLangPK()) != null) {
                throw new PreexistingEntityException("PsQuickAccessLang " + psQuickAccessLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsQuickAccessLang psQuickAccessLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psQuickAccessLang = em.merge(psQuickAccessLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsQuickAccessLangPK id = psQuickAccessLang.getPsQuickAccessLangPK();
                if (findPsQuickAccessLang(id) == null) {
                    throw new NonexistentEntityException("The psQuickAccessLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsQuickAccessLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsQuickAccessLang psQuickAccessLang;
            try {
                psQuickAccessLang = em.getReference(PsQuickAccessLang.class, id);
                psQuickAccessLang.getPsQuickAccessLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psQuickAccessLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psQuickAccessLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsQuickAccessLang> findPsQuickAccessLangEntities() {
        return findPsQuickAccessLangEntities(true, -1, -1);
    }

    public List<PsQuickAccessLang> findPsQuickAccessLangEntities(int maxResults, int firstResult) {
        return findPsQuickAccessLangEntities(false, maxResults, firstResult);
    }

    private List<PsQuickAccessLang> findPsQuickAccessLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsQuickAccessLang.class));
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

    public PsQuickAccessLang findPsQuickAccessLang(PsQuickAccessLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsQuickAccessLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsQuickAccessLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsQuickAccessLang> rt = cq.from(PsQuickAccessLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

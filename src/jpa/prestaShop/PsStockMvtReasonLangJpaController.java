/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsStockMvtReasonLang;
import entidade.prestaShop.PsStockMvtReasonLangPK;
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
public class PsStockMvtReasonLangJpaController implements Serializable {

    public PsStockMvtReasonLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsStockMvtReasonLang psStockMvtReasonLang) throws PreexistingEntityException, Exception {
        if (psStockMvtReasonLang.getPsStockMvtReasonLangPK() == null) {
            psStockMvtReasonLang.setPsStockMvtReasonLangPK(new PsStockMvtReasonLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psStockMvtReasonLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsStockMvtReasonLang(psStockMvtReasonLang.getPsStockMvtReasonLangPK()) != null) {
                throw new PreexistingEntityException("PsStockMvtReasonLang " + psStockMvtReasonLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsStockMvtReasonLang psStockMvtReasonLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psStockMvtReasonLang = em.merge(psStockMvtReasonLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsStockMvtReasonLangPK id = psStockMvtReasonLang.getPsStockMvtReasonLangPK();
                if (findPsStockMvtReasonLang(id) == null) {
                    throw new NonexistentEntityException("The psStockMvtReasonLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsStockMvtReasonLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsStockMvtReasonLang psStockMvtReasonLang;
            try {
                psStockMvtReasonLang = em.getReference(PsStockMvtReasonLang.class, id);
                psStockMvtReasonLang.getPsStockMvtReasonLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psStockMvtReasonLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psStockMvtReasonLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsStockMvtReasonLang> findPsStockMvtReasonLangEntities() {
        return findPsStockMvtReasonLangEntities(true, -1, -1);
    }

    public List<PsStockMvtReasonLang> findPsStockMvtReasonLangEntities(int maxResults, int firstResult) {
        return findPsStockMvtReasonLangEntities(false, maxResults, firstResult);
    }

    private List<PsStockMvtReasonLang> findPsStockMvtReasonLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsStockMvtReasonLang.class));
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

    public PsStockMvtReasonLang findPsStockMvtReasonLang(PsStockMvtReasonLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsStockMvtReasonLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsStockMvtReasonLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsStockMvtReasonLang> rt = cq.from(PsStockMvtReasonLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsHomesliderSlidesLang;
import entidade.prestaShop.PsHomesliderSlidesLangPK;
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
public class PsHomesliderSlidesLangJpaController implements Serializable {

    public PsHomesliderSlidesLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsHomesliderSlidesLang psHomesliderSlidesLang) throws PreexistingEntityException, Exception {
        if (psHomesliderSlidesLang.getPsHomesliderSlidesLangPK() == null) {
            psHomesliderSlidesLang.setPsHomesliderSlidesLangPK(new PsHomesliderSlidesLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psHomesliderSlidesLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsHomesliderSlidesLang(psHomesliderSlidesLang.getPsHomesliderSlidesLangPK()) != null) {
                throw new PreexistingEntityException("PsHomesliderSlidesLang " + psHomesliderSlidesLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsHomesliderSlidesLang psHomesliderSlidesLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psHomesliderSlidesLang = em.merge(psHomesliderSlidesLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsHomesliderSlidesLangPK id = psHomesliderSlidesLang.getPsHomesliderSlidesLangPK();
                if (findPsHomesliderSlidesLang(id) == null) {
                    throw new NonexistentEntityException("The psHomesliderSlidesLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsHomesliderSlidesLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsHomesliderSlidesLang psHomesliderSlidesLang;
            try {
                psHomesliderSlidesLang = em.getReference(PsHomesliderSlidesLang.class, id);
                psHomesliderSlidesLang.getPsHomesliderSlidesLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psHomesliderSlidesLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psHomesliderSlidesLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsHomesliderSlidesLang> findPsHomesliderSlidesLangEntities() {
        return findPsHomesliderSlidesLangEntities(true, -1, -1);
    }

    public List<PsHomesliderSlidesLang> findPsHomesliderSlidesLangEntities(int maxResults, int firstResult) {
        return findPsHomesliderSlidesLangEntities(false, maxResults, firstResult);
    }

    private List<PsHomesliderSlidesLang> findPsHomesliderSlidesLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsHomesliderSlidesLang.class));
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

    public PsHomesliderSlidesLang findPsHomesliderSlidesLang(PsHomesliderSlidesLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsHomesliderSlidesLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsHomesliderSlidesLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsHomesliderSlidesLang> rt = cq.from(PsHomesliderSlidesLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsTabLang;
import entidade.prestaShop.PsTabLangPK;
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
public class PsTabLangJpaController implements Serializable {

    public PsTabLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsTabLang psTabLang) throws PreexistingEntityException, Exception {
        if (psTabLang.getPsTabLangPK() == null) {
            psTabLang.setPsTabLangPK(new PsTabLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psTabLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsTabLang(psTabLang.getPsTabLangPK()) != null) {
                throw new PreexistingEntityException("PsTabLang " + psTabLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsTabLang psTabLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psTabLang = em.merge(psTabLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsTabLangPK id = psTabLang.getPsTabLangPK();
                if (findPsTabLang(id) == null) {
                    throw new NonexistentEntityException("The psTabLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsTabLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsTabLang psTabLang;
            try {
                psTabLang = em.getReference(PsTabLang.class, id);
                psTabLang.getPsTabLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psTabLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psTabLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsTabLang> findPsTabLangEntities() {
        return findPsTabLangEntities(true, -1, -1);
    }

    public List<PsTabLang> findPsTabLangEntities(int maxResults, int firstResult) {
        return findPsTabLangEntities(false, maxResults, firstResult);
    }

    private List<PsTabLang> findPsTabLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsTabLang.class));
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

    public PsTabLang findPsTabLang(PsTabLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsTabLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsTabLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsTabLang> rt = cq.from(PsTabLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

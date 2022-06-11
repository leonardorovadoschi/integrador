/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsProductLang;
import entidade.prestaShop.PsProductLangPK;
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
public class PsProductLangJpaController implements Serializable {

    public PsProductLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsProductLang psProductLang) throws PreexistingEntityException, Exception {
        if (psProductLang.getPsProductLangPK() == null) {
            psProductLang.setPsProductLangPK(new PsProductLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psProductLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsProductLang(psProductLang.getPsProductLangPK()) != null) {
                throw new PreexistingEntityException("PsProductLang " + psProductLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsProductLang psProductLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psProductLang = em.merge(psProductLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsProductLangPK id = psProductLang.getPsProductLangPK();
                if (findPsProductLang(id) == null) {
                    throw new NonexistentEntityException("The psProductLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsProductLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsProductLang psProductLang;
            try {
                psProductLang = em.getReference(PsProductLang.class, id);
                psProductLang.getPsProductLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psProductLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psProductLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsProductLang> findPsProductLangEntities() {
        return findPsProductLangEntities(true, -1, -1);
    }

    public List<PsProductLang> findPsProductLangEntities(int maxResults, int firstResult) {
        return findPsProductLangEntities(false, maxResults, firstResult);
    }

    private List<PsProductLang> findPsProductLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsProductLang.class));
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

    public PsProductLang findPsProductLang(PsProductLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsProductLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsProductLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsProductLang> rt = cq.from(PsProductLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

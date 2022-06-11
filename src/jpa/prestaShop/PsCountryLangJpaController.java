/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCountryLang;
import entidade.prestaShop.PsCountryLangPK;
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
public class PsCountryLangJpaController implements Serializable {

    public PsCountryLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCountryLang psCountryLang) throws PreexistingEntityException, Exception {
        if (psCountryLang.getPsCountryLangPK() == null) {
            psCountryLang.setPsCountryLangPK(new PsCountryLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCountryLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCountryLang(psCountryLang.getPsCountryLangPK()) != null) {
                throw new PreexistingEntityException("PsCountryLang " + psCountryLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCountryLang psCountryLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCountryLang = em.merge(psCountryLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCountryLangPK id = psCountryLang.getPsCountryLangPK();
                if (findPsCountryLang(id) == null) {
                    throw new NonexistentEntityException("The psCountryLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCountryLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCountryLang psCountryLang;
            try {
                psCountryLang = em.getReference(PsCountryLang.class, id);
                psCountryLang.getPsCountryLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCountryLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCountryLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCountryLang> findPsCountryLangEntities() {
        return findPsCountryLangEntities(true, -1, -1);
    }

    public List<PsCountryLang> findPsCountryLangEntities(int maxResults, int firstResult) {
        return findPsCountryLangEntities(false, maxResults, firstResult);
    }

    private List<PsCountryLang> findPsCountryLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCountryLang.class));
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

    public PsCountryLang findPsCountryLang(PsCountryLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCountryLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCountryLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCountryLang> rt = cq.from(PsCountryLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

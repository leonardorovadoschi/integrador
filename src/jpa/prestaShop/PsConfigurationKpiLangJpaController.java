/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsConfigurationKpiLang;
import entidade.prestaShop.PsConfigurationKpiLangPK;
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
public class PsConfigurationKpiLangJpaController implements Serializable {

    public PsConfigurationKpiLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsConfigurationKpiLang psConfigurationKpiLang) throws PreexistingEntityException, Exception {
        if (psConfigurationKpiLang.getPsConfigurationKpiLangPK() == null) {
            psConfigurationKpiLang.setPsConfigurationKpiLangPK(new PsConfigurationKpiLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psConfigurationKpiLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsConfigurationKpiLang(psConfigurationKpiLang.getPsConfigurationKpiLangPK()) != null) {
                throw new PreexistingEntityException("PsConfigurationKpiLang " + psConfigurationKpiLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsConfigurationKpiLang psConfigurationKpiLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psConfigurationKpiLang = em.merge(psConfigurationKpiLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsConfigurationKpiLangPK id = psConfigurationKpiLang.getPsConfigurationKpiLangPK();
                if (findPsConfigurationKpiLang(id) == null) {
                    throw new NonexistentEntityException("The psConfigurationKpiLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsConfigurationKpiLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsConfigurationKpiLang psConfigurationKpiLang;
            try {
                psConfigurationKpiLang = em.getReference(PsConfigurationKpiLang.class, id);
                psConfigurationKpiLang.getPsConfigurationKpiLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psConfigurationKpiLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psConfigurationKpiLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsConfigurationKpiLang> findPsConfigurationKpiLangEntities() {
        return findPsConfigurationKpiLangEntities(true, -1, -1);
    }

    public List<PsConfigurationKpiLang> findPsConfigurationKpiLangEntities(int maxResults, int firstResult) {
        return findPsConfigurationKpiLangEntities(false, maxResults, firstResult);
    }

    private List<PsConfigurationKpiLang> findPsConfigurationKpiLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsConfigurationKpiLang.class));
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

    public PsConfigurationKpiLang findPsConfigurationKpiLang(PsConfigurationKpiLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsConfigurationKpiLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsConfigurationKpiLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsConfigurationKpiLang> rt = cq.from(PsConfigurationKpiLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

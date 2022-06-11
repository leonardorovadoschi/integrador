/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsConfigurationLang;
import entidade.prestaShop.PsConfigurationLangPK;
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
public class PsConfigurationLangJpaController implements Serializable {

    public PsConfigurationLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsConfigurationLang psConfigurationLang) throws PreexistingEntityException, Exception {
        if (psConfigurationLang.getPsConfigurationLangPK() == null) {
            psConfigurationLang.setPsConfigurationLangPK(new PsConfigurationLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psConfigurationLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsConfigurationLang(psConfigurationLang.getPsConfigurationLangPK()) != null) {
                throw new PreexistingEntityException("PsConfigurationLang " + psConfigurationLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsConfigurationLang psConfigurationLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psConfigurationLang = em.merge(psConfigurationLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsConfigurationLangPK id = psConfigurationLang.getPsConfigurationLangPK();
                if (findPsConfigurationLang(id) == null) {
                    throw new NonexistentEntityException("The psConfigurationLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsConfigurationLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsConfigurationLang psConfigurationLang;
            try {
                psConfigurationLang = em.getReference(PsConfigurationLang.class, id);
                psConfigurationLang.getPsConfigurationLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psConfigurationLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psConfigurationLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsConfigurationLang> findPsConfigurationLangEntities() {
        return findPsConfigurationLangEntities(true, -1, -1);
    }

    public List<PsConfigurationLang> findPsConfigurationLangEntities(int maxResults, int firstResult) {
        return findPsConfigurationLangEntities(false, maxResults, firstResult);
    }

    private List<PsConfigurationLang> findPsConfigurationLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsConfigurationLang.class));
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

    public PsConfigurationLang findPsConfigurationLang(PsConfigurationLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsConfigurationLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsConfigurationLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsConfigurationLang> rt = cq.from(PsConfigurationLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

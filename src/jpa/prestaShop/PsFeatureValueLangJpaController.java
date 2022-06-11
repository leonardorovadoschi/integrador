/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsFeatureValueLang;
import entidade.prestaShop.PsFeatureValueLangPK;
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
public class PsFeatureValueLangJpaController implements Serializable {

    public PsFeatureValueLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsFeatureValueLang psFeatureValueLang) throws PreexistingEntityException, Exception {
        if (psFeatureValueLang.getPsFeatureValueLangPK() == null) {
            psFeatureValueLang.setPsFeatureValueLangPK(new PsFeatureValueLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psFeatureValueLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsFeatureValueLang(psFeatureValueLang.getPsFeatureValueLangPK()) != null) {
                throw new PreexistingEntityException("PsFeatureValueLang " + psFeatureValueLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsFeatureValueLang psFeatureValueLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psFeatureValueLang = em.merge(psFeatureValueLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsFeatureValueLangPK id = psFeatureValueLang.getPsFeatureValueLangPK();
                if (findPsFeatureValueLang(id) == null) {
                    throw new NonexistentEntityException("The psFeatureValueLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsFeatureValueLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsFeatureValueLang psFeatureValueLang;
            try {
                psFeatureValueLang = em.getReference(PsFeatureValueLang.class, id);
                psFeatureValueLang.getPsFeatureValueLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psFeatureValueLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psFeatureValueLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsFeatureValueLang> findPsFeatureValueLangEntities() {
        return findPsFeatureValueLangEntities(true, -1, -1);
    }

    public List<PsFeatureValueLang> findPsFeatureValueLangEntities(int maxResults, int firstResult) {
        return findPsFeatureValueLangEntities(false, maxResults, firstResult);
    }

    private List<PsFeatureValueLang> findPsFeatureValueLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsFeatureValueLang.class));
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

    public PsFeatureValueLang findPsFeatureValueLang(PsFeatureValueLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsFeatureValueLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsFeatureValueLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsFeatureValueLang> rt = cq.from(PsFeatureValueLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

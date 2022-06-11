/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsRiskLang;
import entidade.prestaShop.PsRiskLangPK;
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
public class PsRiskLangJpaController implements Serializable {

    public PsRiskLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsRiskLang psRiskLang) throws PreexistingEntityException, Exception {
        if (psRiskLang.getPsRiskLangPK() == null) {
            psRiskLang.setPsRiskLangPK(new PsRiskLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psRiskLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsRiskLang(psRiskLang.getPsRiskLangPK()) != null) {
                throw new PreexistingEntityException("PsRiskLang " + psRiskLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsRiskLang psRiskLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psRiskLang = em.merge(psRiskLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsRiskLangPK id = psRiskLang.getPsRiskLangPK();
                if (findPsRiskLang(id) == null) {
                    throw new NonexistentEntityException("The psRiskLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsRiskLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsRiskLang psRiskLang;
            try {
                psRiskLang = em.getReference(PsRiskLang.class, id);
                psRiskLang.getPsRiskLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psRiskLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psRiskLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsRiskLang> findPsRiskLangEntities() {
        return findPsRiskLangEntities(true, -1, -1);
    }

    public List<PsRiskLang> findPsRiskLangEntities(int maxResults, int firstResult) {
        return findPsRiskLangEntities(false, maxResults, firstResult);
    }

    private List<PsRiskLang> findPsRiskLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsRiskLang.class));
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

    public PsRiskLang findPsRiskLang(PsRiskLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsRiskLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsRiskLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsRiskLang> rt = cq.from(PsRiskLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

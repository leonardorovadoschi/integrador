/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCustomizationFieldLang;
import entidade.prestaShop.PsCustomizationFieldLangPK;
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
public class PsCustomizationFieldLangJpaController implements Serializable {

    public PsCustomizationFieldLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCustomizationFieldLang psCustomizationFieldLang) throws PreexistingEntityException, Exception {
        if (psCustomizationFieldLang.getPsCustomizationFieldLangPK() == null) {
            psCustomizationFieldLang.setPsCustomizationFieldLangPK(new PsCustomizationFieldLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCustomizationFieldLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCustomizationFieldLang(psCustomizationFieldLang.getPsCustomizationFieldLangPK()) != null) {
                throw new PreexistingEntityException("PsCustomizationFieldLang " + psCustomizationFieldLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCustomizationFieldLang psCustomizationFieldLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCustomizationFieldLang = em.merge(psCustomizationFieldLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCustomizationFieldLangPK id = psCustomizationFieldLang.getPsCustomizationFieldLangPK();
                if (findPsCustomizationFieldLang(id) == null) {
                    throw new NonexistentEntityException("The psCustomizationFieldLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCustomizationFieldLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCustomizationFieldLang psCustomizationFieldLang;
            try {
                psCustomizationFieldLang = em.getReference(PsCustomizationFieldLang.class, id);
                psCustomizationFieldLang.getPsCustomizationFieldLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCustomizationFieldLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCustomizationFieldLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCustomizationFieldLang> findPsCustomizationFieldLangEntities() {
        return findPsCustomizationFieldLangEntities(true, -1, -1);
    }

    public List<PsCustomizationFieldLang> findPsCustomizationFieldLangEntities(int maxResults, int firstResult) {
        return findPsCustomizationFieldLangEntities(false, maxResults, firstResult);
    }

    private List<PsCustomizationFieldLang> findPsCustomizationFieldLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCustomizationFieldLang.class));
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

    public PsCustomizationFieldLang findPsCustomizationFieldLang(PsCustomizationFieldLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCustomizationFieldLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCustomizationFieldLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCustomizationFieldLang> rt = cq.from(PsCustomizationFieldLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

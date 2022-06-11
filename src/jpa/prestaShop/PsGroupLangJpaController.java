/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsGroupLang;
import entidade.prestaShop.PsGroupLangPK;
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
public class PsGroupLangJpaController implements Serializable {

    public PsGroupLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsGroupLang psGroupLang) throws PreexistingEntityException, Exception {
        if (psGroupLang.getPsGroupLangPK() == null) {
            psGroupLang.setPsGroupLangPK(new PsGroupLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psGroupLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsGroupLang(psGroupLang.getPsGroupLangPK()) != null) {
                throw new PreexistingEntityException("PsGroupLang " + psGroupLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsGroupLang psGroupLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psGroupLang = em.merge(psGroupLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsGroupLangPK id = psGroupLang.getPsGroupLangPK();
                if (findPsGroupLang(id) == null) {
                    throw new NonexistentEntityException("The psGroupLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsGroupLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsGroupLang psGroupLang;
            try {
                psGroupLang = em.getReference(PsGroupLang.class, id);
                psGroupLang.getPsGroupLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psGroupLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psGroupLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsGroupLang> findPsGroupLangEntities() {
        return findPsGroupLangEntities(true, -1, -1);
    }

    public List<PsGroupLang> findPsGroupLangEntities(int maxResults, int firstResult) {
        return findPsGroupLangEntities(false, maxResults, firstResult);
    }

    private List<PsGroupLang> findPsGroupLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsGroupLang.class));
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

    public PsGroupLang findPsGroupLang(PsGroupLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsGroupLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsGroupLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsGroupLang> rt = cq.from(PsGroupLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

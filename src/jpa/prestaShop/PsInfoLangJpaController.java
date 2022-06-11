/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsInfoLang;
import entidade.prestaShop.PsInfoLangPK;
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
public class PsInfoLangJpaController implements Serializable {

    public PsInfoLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsInfoLang psInfoLang) throws PreexistingEntityException, Exception {
        if (psInfoLang.getPsInfoLangPK() == null) {
            psInfoLang.setPsInfoLangPK(new PsInfoLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psInfoLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsInfoLang(psInfoLang.getPsInfoLangPK()) != null) {
                throw new PreexistingEntityException("PsInfoLang " + psInfoLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsInfoLang psInfoLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psInfoLang = em.merge(psInfoLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsInfoLangPK id = psInfoLang.getPsInfoLangPK();
                if (findPsInfoLang(id) == null) {
                    throw new NonexistentEntityException("The psInfoLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsInfoLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsInfoLang psInfoLang;
            try {
                psInfoLang = em.getReference(PsInfoLang.class, id);
                psInfoLang.getPsInfoLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psInfoLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psInfoLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsInfoLang> findPsInfoLangEntities() {
        return findPsInfoLangEntities(true, -1, -1);
    }

    public List<PsInfoLang> findPsInfoLangEntities(int maxResults, int firstResult) {
        return findPsInfoLangEntities(false, maxResults, firstResult);
    }

    private List<PsInfoLang> findPsInfoLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsInfoLang.class));
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

    public PsInfoLang findPsInfoLang(PsInfoLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsInfoLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsInfoLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsInfoLang> rt = cq.from(PsInfoLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

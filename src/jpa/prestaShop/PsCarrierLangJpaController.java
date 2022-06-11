/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCarrierLang;
import entidade.prestaShop.PsCarrierLangPK;
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
public class PsCarrierLangJpaController implements Serializable {

    public PsCarrierLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCarrierLang psCarrierLang) throws PreexistingEntityException, Exception {
        if (psCarrierLang.getPsCarrierLangPK() == null) {
            psCarrierLang.setPsCarrierLangPK(new PsCarrierLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCarrierLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCarrierLang(psCarrierLang.getPsCarrierLangPK()) != null) {
                throw new PreexistingEntityException("PsCarrierLang " + psCarrierLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCarrierLang psCarrierLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCarrierLang = em.merge(psCarrierLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCarrierLangPK id = psCarrierLang.getPsCarrierLangPK();
                if (findPsCarrierLang(id) == null) {
                    throw new NonexistentEntityException("The psCarrierLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCarrierLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCarrierLang psCarrierLang;
            try {
                psCarrierLang = em.getReference(PsCarrierLang.class, id);
                psCarrierLang.getPsCarrierLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCarrierLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCarrierLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCarrierLang> findPsCarrierLangEntities() {
        return findPsCarrierLangEntities(true, -1, -1);
    }

    public List<PsCarrierLang> findPsCarrierLangEntities(int maxResults, int firstResult) {
        return findPsCarrierLangEntities(false, maxResults, firstResult);
    }

    private List<PsCarrierLang> findPsCarrierLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCarrierLang.class));
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

    public PsCarrierLang findPsCarrierLang(PsCarrierLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCarrierLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCarrierLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCarrierLang> rt = cq.from(PsCarrierLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

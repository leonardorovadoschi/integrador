/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsSupplierLang;
import entidade.prestaShop.PsSupplierLangPK;
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
public class PsSupplierLangJpaController implements Serializable {

    public PsSupplierLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsSupplierLang psSupplierLang) throws PreexistingEntityException, Exception {
        if (psSupplierLang.getPsSupplierLangPK() == null) {
            psSupplierLang.setPsSupplierLangPK(new PsSupplierLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psSupplierLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsSupplierLang(psSupplierLang.getPsSupplierLangPK()) != null) {
                throw new PreexistingEntityException("PsSupplierLang " + psSupplierLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsSupplierLang psSupplierLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psSupplierLang = em.merge(psSupplierLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsSupplierLangPK id = psSupplierLang.getPsSupplierLangPK();
                if (findPsSupplierLang(id) == null) {
                    throw new NonexistentEntityException("The psSupplierLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsSupplierLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsSupplierLang psSupplierLang;
            try {
                psSupplierLang = em.getReference(PsSupplierLang.class, id);
                psSupplierLang.getPsSupplierLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psSupplierLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psSupplierLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsSupplierLang> findPsSupplierLangEntities() {
        return findPsSupplierLangEntities(true, -1, -1);
    }

    public List<PsSupplierLang> findPsSupplierLangEntities(int maxResults, int firstResult) {
        return findPsSupplierLangEntities(false, maxResults, firstResult);
    }

    private List<PsSupplierLang> findPsSupplierLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsSupplierLang.class));
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

    public PsSupplierLang findPsSupplierLang(PsSupplierLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsSupplierLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsSupplierLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsSupplierLang> rt = cq.from(PsSupplierLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

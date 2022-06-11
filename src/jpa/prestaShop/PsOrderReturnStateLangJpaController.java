/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsOrderReturnStateLang;
import entidade.prestaShop.PsOrderReturnStateLangPK;
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
public class PsOrderReturnStateLangJpaController implements Serializable {

    public PsOrderReturnStateLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsOrderReturnStateLang psOrderReturnStateLang) throws PreexistingEntityException, Exception {
        if (psOrderReturnStateLang.getPsOrderReturnStateLangPK() == null) {
            psOrderReturnStateLang.setPsOrderReturnStateLangPK(new PsOrderReturnStateLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psOrderReturnStateLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsOrderReturnStateLang(psOrderReturnStateLang.getPsOrderReturnStateLangPK()) != null) {
                throw new PreexistingEntityException("PsOrderReturnStateLang " + psOrderReturnStateLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsOrderReturnStateLang psOrderReturnStateLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psOrderReturnStateLang = em.merge(psOrderReturnStateLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsOrderReturnStateLangPK id = psOrderReturnStateLang.getPsOrderReturnStateLangPK();
                if (findPsOrderReturnStateLang(id) == null) {
                    throw new NonexistentEntityException("The psOrderReturnStateLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsOrderReturnStateLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsOrderReturnStateLang psOrderReturnStateLang;
            try {
                psOrderReturnStateLang = em.getReference(PsOrderReturnStateLang.class, id);
                psOrderReturnStateLang.getPsOrderReturnStateLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psOrderReturnStateLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psOrderReturnStateLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsOrderReturnStateLang> findPsOrderReturnStateLangEntities() {
        return findPsOrderReturnStateLangEntities(true, -1, -1);
    }

    public List<PsOrderReturnStateLang> findPsOrderReturnStateLangEntities(int maxResults, int firstResult) {
        return findPsOrderReturnStateLangEntities(false, maxResults, firstResult);
    }

    private List<PsOrderReturnStateLang> findPsOrderReturnStateLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsOrderReturnStateLang.class));
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

    public PsOrderReturnStateLang findPsOrderReturnStateLang(PsOrderReturnStateLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsOrderReturnStateLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsOrderReturnStateLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsOrderReturnStateLang> rt = cq.from(PsOrderReturnStateLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

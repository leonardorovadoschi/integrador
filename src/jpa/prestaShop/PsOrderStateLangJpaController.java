/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsOrderStateLang;
import entidade.prestaShop.PsOrderStateLangPK;
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
public class PsOrderStateLangJpaController implements Serializable {

    public PsOrderStateLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsOrderStateLang psOrderStateLang) throws PreexistingEntityException, Exception {
        if (psOrderStateLang.getPsOrderStateLangPK() == null) {
            psOrderStateLang.setPsOrderStateLangPK(new PsOrderStateLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psOrderStateLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsOrderStateLang(psOrderStateLang.getPsOrderStateLangPK()) != null) {
                throw new PreexistingEntityException("PsOrderStateLang " + psOrderStateLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsOrderStateLang psOrderStateLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psOrderStateLang = em.merge(psOrderStateLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsOrderStateLangPK id = psOrderStateLang.getPsOrderStateLangPK();
                if (findPsOrderStateLang(id) == null) {
                    throw new NonexistentEntityException("The psOrderStateLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsOrderStateLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsOrderStateLang psOrderStateLang;
            try {
                psOrderStateLang = em.getReference(PsOrderStateLang.class, id);
                psOrderStateLang.getPsOrderStateLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psOrderStateLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psOrderStateLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsOrderStateLang> findPsOrderStateLangEntities() {
        return findPsOrderStateLangEntities(true, -1, -1);
    }

    public List<PsOrderStateLang> findPsOrderStateLangEntities(int maxResults, int firstResult) {
        return findPsOrderStateLangEntities(false, maxResults, firstResult);
    }

    private List<PsOrderStateLang> findPsOrderStateLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsOrderStateLang.class));
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

    public PsOrderStateLang findPsOrderStateLang(PsOrderStateLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsOrderStateLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsOrderStateLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsOrderStateLang> rt = cq.from(PsOrderStateLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

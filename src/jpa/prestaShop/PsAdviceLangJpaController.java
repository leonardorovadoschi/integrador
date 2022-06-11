/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsAdviceLang;
import entidade.prestaShop.PsAdviceLangPK;
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
public class PsAdviceLangJpaController implements Serializable {

    public PsAdviceLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsAdviceLang psAdviceLang) throws PreexistingEntityException, Exception {
        if (psAdviceLang.getPsAdviceLangPK() == null) {
            psAdviceLang.setPsAdviceLangPK(new PsAdviceLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psAdviceLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsAdviceLang(psAdviceLang.getPsAdviceLangPK()) != null) {
                throw new PreexistingEntityException("PsAdviceLang " + psAdviceLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsAdviceLang psAdviceLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psAdviceLang = em.merge(psAdviceLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsAdviceLangPK id = psAdviceLang.getPsAdviceLangPK();
                if (findPsAdviceLang(id) == null) {
                    throw new NonexistentEntityException("The psAdviceLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsAdviceLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsAdviceLang psAdviceLang;
            try {
                psAdviceLang = em.getReference(PsAdviceLang.class, id);
                psAdviceLang.getPsAdviceLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psAdviceLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psAdviceLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsAdviceLang> findPsAdviceLangEntities() {
        return findPsAdviceLangEntities(true, -1, -1);
    }

    public List<PsAdviceLang> findPsAdviceLangEntities(int maxResults, int firstResult) {
        return findPsAdviceLangEntities(false, maxResults, firstResult);
    }

    private List<PsAdviceLang> findPsAdviceLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsAdviceLang.class));
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

    public PsAdviceLang findPsAdviceLang(PsAdviceLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsAdviceLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsAdviceLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsAdviceLang> rt = cq.from(PsAdviceLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

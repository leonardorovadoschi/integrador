/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsBadgeLang;
import entidade.prestaShop.PsBadgeLangPK;
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
public class PsBadgeLangJpaController implements Serializable {

    public PsBadgeLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsBadgeLang psBadgeLang) throws PreexistingEntityException, Exception {
        if (psBadgeLang.getPsBadgeLangPK() == null) {
            psBadgeLang.setPsBadgeLangPK(new PsBadgeLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psBadgeLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsBadgeLang(psBadgeLang.getPsBadgeLangPK()) != null) {
                throw new PreexistingEntityException("PsBadgeLang " + psBadgeLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsBadgeLang psBadgeLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psBadgeLang = em.merge(psBadgeLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsBadgeLangPK id = psBadgeLang.getPsBadgeLangPK();
                if (findPsBadgeLang(id) == null) {
                    throw new NonexistentEntityException("The psBadgeLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsBadgeLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsBadgeLang psBadgeLang;
            try {
                psBadgeLang = em.getReference(PsBadgeLang.class, id);
                psBadgeLang.getPsBadgeLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psBadgeLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psBadgeLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsBadgeLang> findPsBadgeLangEntities() {
        return findPsBadgeLangEntities(true, -1, -1);
    }

    public List<PsBadgeLang> findPsBadgeLangEntities(int maxResults, int firstResult) {
        return findPsBadgeLangEntities(false, maxResults, firstResult);
    }

    private List<PsBadgeLang> findPsBadgeLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsBadgeLang.class));
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

    public PsBadgeLang findPsBadgeLang(PsBadgeLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsBadgeLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsBadgeLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsBadgeLang> rt = cq.from(PsBadgeLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

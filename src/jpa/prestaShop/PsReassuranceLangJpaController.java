/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsReassuranceLang;
import entidade.prestaShop.PsReassuranceLangPK;
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
public class PsReassuranceLangJpaController implements Serializable {

    public PsReassuranceLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsReassuranceLang psReassuranceLang) throws PreexistingEntityException, Exception {
        if (psReassuranceLang.getPsReassuranceLangPK() == null) {
            psReassuranceLang.setPsReassuranceLangPK(new PsReassuranceLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psReassuranceLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsReassuranceLang(psReassuranceLang.getPsReassuranceLangPK()) != null) {
                throw new PreexistingEntityException("PsReassuranceLang " + psReassuranceLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsReassuranceLang psReassuranceLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psReassuranceLang = em.merge(psReassuranceLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsReassuranceLangPK id = psReassuranceLang.getPsReassuranceLangPK();
                if (findPsReassuranceLang(id) == null) {
                    throw new NonexistentEntityException("The psReassuranceLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsReassuranceLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsReassuranceLang psReassuranceLang;
            try {
                psReassuranceLang = em.getReference(PsReassuranceLang.class, id);
                psReassuranceLang.getPsReassuranceLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psReassuranceLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psReassuranceLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsReassuranceLang> findPsReassuranceLangEntities() {
        return findPsReassuranceLangEntities(true, -1, -1);
    }

    public List<PsReassuranceLang> findPsReassuranceLangEntities(int maxResults, int firstResult) {
        return findPsReassuranceLangEntities(false, maxResults, firstResult);
    }

    private List<PsReassuranceLang> findPsReassuranceLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsReassuranceLang.class));
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

    public PsReassuranceLang findPsReassuranceLang(PsReassuranceLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsReassuranceLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsReassuranceLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsReassuranceLang> rt = cq.from(PsReassuranceLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

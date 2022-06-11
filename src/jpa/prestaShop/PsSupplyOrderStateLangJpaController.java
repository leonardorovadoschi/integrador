/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsSupplyOrderStateLang;
import entidade.prestaShop.PsSupplyOrderStateLangPK;
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
public class PsSupplyOrderStateLangJpaController implements Serializable {

    public PsSupplyOrderStateLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsSupplyOrderStateLang psSupplyOrderStateLang) throws PreexistingEntityException, Exception {
        if (psSupplyOrderStateLang.getPsSupplyOrderStateLangPK() == null) {
            psSupplyOrderStateLang.setPsSupplyOrderStateLangPK(new PsSupplyOrderStateLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psSupplyOrderStateLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsSupplyOrderStateLang(psSupplyOrderStateLang.getPsSupplyOrderStateLangPK()) != null) {
                throw new PreexistingEntityException("PsSupplyOrderStateLang " + psSupplyOrderStateLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsSupplyOrderStateLang psSupplyOrderStateLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psSupplyOrderStateLang = em.merge(psSupplyOrderStateLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsSupplyOrderStateLangPK id = psSupplyOrderStateLang.getPsSupplyOrderStateLangPK();
                if (findPsSupplyOrderStateLang(id) == null) {
                    throw new NonexistentEntityException("The psSupplyOrderStateLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsSupplyOrderStateLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsSupplyOrderStateLang psSupplyOrderStateLang;
            try {
                psSupplyOrderStateLang = em.getReference(PsSupplyOrderStateLang.class, id);
                psSupplyOrderStateLang.getPsSupplyOrderStateLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psSupplyOrderStateLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psSupplyOrderStateLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsSupplyOrderStateLang> findPsSupplyOrderStateLangEntities() {
        return findPsSupplyOrderStateLangEntities(true, -1, -1);
    }

    public List<PsSupplyOrderStateLang> findPsSupplyOrderStateLangEntities(int maxResults, int firstResult) {
        return findPsSupplyOrderStateLangEntities(false, maxResults, firstResult);
    }

    private List<PsSupplyOrderStateLang> findPsSupplyOrderStateLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsSupplyOrderStateLang.class));
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

    public PsSupplyOrderStateLang findPsSupplyOrderStateLang(PsSupplyOrderStateLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsSupplyOrderStateLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsSupplyOrderStateLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsSupplyOrderStateLang> rt = cq.from(PsSupplyOrderStateLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCartRuleLang;
import entidade.prestaShop.PsCartRuleLangPK;
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
public class PsCartRuleLangJpaController implements Serializable {

    public PsCartRuleLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCartRuleLang psCartRuleLang) throws PreexistingEntityException, Exception {
        if (psCartRuleLang.getPsCartRuleLangPK() == null) {
            psCartRuleLang.setPsCartRuleLangPK(new PsCartRuleLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCartRuleLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCartRuleLang(psCartRuleLang.getPsCartRuleLangPK()) != null) {
                throw new PreexistingEntityException("PsCartRuleLang " + psCartRuleLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCartRuleLang psCartRuleLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCartRuleLang = em.merge(psCartRuleLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCartRuleLangPK id = psCartRuleLang.getPsCartRuleLangPK();
                if (findPsCartRuleLang(id) == null) {
                    throw new NonexistentEntityException("The psCartRuleLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCartRuleLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCartRuleLang psCartRuleLang;
            try {
                psCartRuleLang = em.getReference(PsCartRuleLang.class, id);
                psCartRuleLang.getPsCartRuleLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCartRuleLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCartRuleLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCartRuleLang> findPsCartRuleLangEntities() {
        return findPsCartRuleLangEntities(true, -1, -1);
    }

    public List<PsCartRuleLang> findPsCartRuleLangEntities(int maxResults, int firstResult) {
        return findPsCartRuleLangEntities(false, maxResults, firstResult);
    }

    private List<PsCartRuleLang> findPsCartRuleLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCartRuleLang.class));
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

    public PsCartRuleLang findPsCartRuleLang(PsCartRuleLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCartRuleLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCartRuleLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCartRuleLang> rt = cq.from(PsCartRuleLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

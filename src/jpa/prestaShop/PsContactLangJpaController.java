/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsContactLang;
import entidade.prestaShop.PsContactLangPK;
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
public class PsContactLangJpaController implements Serializable {

    public PsContactLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsContactLang psContactLang) throws PreexistingEntityException, Exception {
        if (psContactLang.getPsContactLangPK() == null) {
            psContactLang.setPsContactLangPK(new PsContactLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psContactLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsContactLang(psContactLang.getPsContactLangPK()) != null) {
                throw new PreexistingEntityException("PsContactLang " + psContactLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsContactLang psContactLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psContactLang = em.merge(psContactLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsContactLangPK id = psContactLang.getPsContactLangPK();
                if (findPsContactLang(id) == null) {
                    throw new NonexistentEntityException("The psContactLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsContactLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsContactLang psContactLang;
            try {
                psContactLang = em.getReference(PsContactLang.class, id);
                psContactLang.getPsContactLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psContactLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psContactLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsContactLang> findPsContactLangEntities() {
        return findPsContactLangEntities(true, -1, -1);
    }

    public List<PsContactLang> findPsContactLangEntities(int maxResults, int firstResult) {
        return findPsContactLangEntities(false, maxResults, firstResult);
    }

    private List<PsContactLang> findPsContactLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsContactLang.class));
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

    public PsContactLang findPsContactLang(PsContactLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsContactLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsContactLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsContactLang> rt = cq.from(PsContactLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

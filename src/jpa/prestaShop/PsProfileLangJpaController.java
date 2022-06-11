/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsProfileLang;
import entidade.prestaShop.PsProfileLangPK;
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
public class PsProfileLangJpaController implements Serializable {

    public PsProfileLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsProfileLang psProfileLang) throws PreexistingEntityException, Exception {
        if (psProfileLang.getPsProfileLangPK() == null) {
            psProfileLang.setPsProfileLangPK(new PsProfileLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psProfileLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsProfileLang(psProfileLang.getPsProfileLangPK()) != null) {
                throw new PreexistingEntityException("PsProfileLang " + psProfileLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsProfileLang psProfileLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psProfileLang = em.merge(psProfileLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsProfileLangPK id = psProfileLang.getPsProfileLangPK();
                if (findPsProfileLang(id) == null) {
                    throw new NonexistentEntityException("The psProfileLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsProfileLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsProfileLang psProfileLang;
            try {
                psProfileLang = em.getReference(PsProfileLang.class, id);
                psProfileLang.getPsProfileLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psProfileLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psProfileLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsProfileLang> findPsProfileLangEntities() {
        return findPsProfileLangEntities(true, -1, -1);
    }

    public List<PsProfileLang> findPsProfileLangEntities(int maxResults, int firstResult) {
        return findPsProfileLangEntities(false, maxResults, firstResult);
    }

    private List<PsProfileLang> findPsProfileLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsProfileLang.class));
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

    public PsProfileLang findPsProfileLang(PsProfileLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsProfileLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsProfileLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsProfileLang> rt = cq.from(PsProfileLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

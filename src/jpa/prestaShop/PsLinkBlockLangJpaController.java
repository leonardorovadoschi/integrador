/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsLinkBlockLang;
import entidade.prestaShop.PsLinkBlockLangPK;
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
public class PsLinkBlockLangJpaController implements Serializable {

    public PsLinkBlockLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsLinkBlockLang psLinkBlockLang) throws PreexistingEntityException, Exception {
        if (psLinkBlockLang.getPsLinkBlockLangPK() == null) {
            psLinkBlockLang.setPsLinkBlockLangPK(new PsLinkBlockLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psLinkBlockLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsLinkBlockLang(psLinkBlockLang.getPsLinkBlockLangPK()) != null) {
                throw new PreexistingEntityException("PsLinkBlockLang " + psLinkBlockLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsLinkBlockLang psLinkBlockLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psLinkBlockLang = em.merge(psLinkBlockLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsLinkBlockLangPK id = psLinkBlockLang.getPsLinkBlockLangPK();
                if (findPsLinkBlockLang(id) == null) {
                    throw new NonexistentEntityException("The psLinkBlockLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsLinkBlockLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsLinkBlockLang psLinkBlockLang;
            try {
                psLinkBlockLang = em.getReference(PsLinkBlockLang.class, id);
                psLinkBlockLang.getPsLinkBlockLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psLinkBlockLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psLinkBlockLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsLinkBlockLang> findPsLinkBlockLangEntities() {
        return findPsLinkBlockLangEntities(true, -1, -1);
    }

    public List<PsLinkBlockLang> findPsLinkBlockLangEntities(int maxResults, int firstResult) {
        return findPsLinkBlockLangEntities(false, maxResults, firstResult);
    }

    private List<PsLinkBlockLang> findPsLinkBlockLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsLinkBlockLang.class));
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

    public PsLinkBlockLang findPsLinkBlockLang(PsLinkBlockLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsLinkBlockLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsLinkBlockLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsLinkBlockLang> rt = cq.from(PsLinkBlockLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

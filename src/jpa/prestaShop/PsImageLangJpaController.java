/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsImageLang;
import entidade.prestaShop.PsImageLangPK;
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
public class PsImageLangJpaController implements Serializable {

    public PsImageLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsImageLang psImageLang) throws PreexistingEntityException, Exception {
        if (psImageLang.getPsImageLangPK() == null) {
            psImageLang.setPsImageLangPK(new PsImageLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psImageLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsImageLang(psImageLang.getPsImageLangPK()) != null) {
                throw new PreexistingEntityException("PsImageLang " + psImageLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsImageLang psImageLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psImageLang = em.merge(psImageLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsImageLangPK id = psImageLang.getPsImageLangPK();
                if (findPsImageLang(id) == null) {
                    throw new NonexistentEntityException("The psImageLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsImageLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsImageLang psImageLang;
            try {
                psImageLang = em.getReference(PsImageLang.class, id);
                psImageLang.getPsImageLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psImageLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psImageLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsImageLang> findPsImageLangEntities() {
        return findPsImageLangEntities(true, -1, -1);
    }

    public List<PsImageLang> findPsImageLangEntities(int maxResults, int firstResult) {
        return findPsImageLangEntities(false, maxResults, firstResult);
    }

    private List<PsImageLang> findPsImageLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsImageLang.class));
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

    public PsImageLang findPsImageLang(PsImageLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsImageLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsImageLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsImageLang> rt = cq.from(PsImageLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

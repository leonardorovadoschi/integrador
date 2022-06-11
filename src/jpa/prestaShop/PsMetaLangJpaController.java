/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsMetaLang;
import entidade.prestaShop.PsMetaLangPK;
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
public class PsMetaLangJpaController implements Serializable {

    public PsMetaLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsMetaLang psMetaLang) throws PreexistingEntityException, Exception {
        if (psMetaLang.getPsMetaLangPK() == null) {
            psMetaLang.setPsMetaLangPK(new PsMetaLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psMetaLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsMetaLang(psMetaLang.getPsMetaLangPK()) != null) {
                throw new PreexistingEntityException("PsMetaLang " + psMetaLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsMetaLang psMetaLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psMetaLang = em.merge(psMetaLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsMetaLangPK id = psMetaLang.getPsMetaLangPK();
                if (findPsMetaLang(id) == null) {
                    throw new NonexistentEntityException("The psMetaLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsMetaLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsMetaLang psMetaLang;
            try {
                psMetaLang = em.getReference(PsMetaLang.class, id);
                psMetaLang.getPsMetaLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psMetaLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psMetaLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsMetaLang> findPsMetaLangEntities() {
        return findPsMetaLangEntities(true, -1, -1);
    }

    public List<PsMetaLang> findPsMetaLangEntities(int maxResults, int firstResult) {
        return findPsMetaLangEntities(false, maxResults, firstResult);
    }

    private List<PsMetaLang> findPsMetaLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsMetaLang.class));
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

    public PsMetaLang findPsMetaLang(PsMetaLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsMetaLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsMetaLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsMetaLang> rt = cq.from(PsMetaLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

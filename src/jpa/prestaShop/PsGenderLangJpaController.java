/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsGenderLang;
import entidade.prestaShop.PsGenderLangPK;
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
public class PsGenderLangJpaController implements Serializable {

    public PsGenderLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsGenderLang psGenderLang) throws PreexistingEntityException, Exception {
        if (psGenderLang.getPsGenderLangPK() == null) {
            psGenderLang.setPsGenderLangPK(new PsGenderLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psGenderLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsGenderLang(psGenderLang.getPsGenderLangPK()) != null) {
                throw new PreexistingEntityException("PsGenderLang " + psGenderLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsGenderLang psGenderLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psGenderLang = em.merge(psGenderLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsGenderLangPK id = psGenderLang.getPsGenderLangPK();
                if (findPsGenderLang(id) == null) {
                    throw new NonexistentEntityException("The psGenderLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsGenderLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsGenderLang psGenderLang;
            try {
                psGenderLang = em.getReference(PsGenderLang.class, id);
                psGenderLang.getPsGenderLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psGenderLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psGenderLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsGenderLang> findPsGenderLangEntities() {
        return findPsGenderLangEntities(true, -1, -1);
    }

    public List<PsGenderLang> findPsGenderLangEntities(int maxResults, int firstResult) {
        return findPsGenderLangEntities(false, maxResults, firstResult);
    }

    private List<PsGenderLang> findPsGenderLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsGenderLang.class));
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

    public PsGenderLang findPsGenderLang(PsGenderLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsGenderLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsGenderLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsGenderLang> rt = cq.from(PsGenderLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

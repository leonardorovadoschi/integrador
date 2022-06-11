/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCmsCategoryLang;
import entidade.prestaShop.PsCmsCategoryLangPK;
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
public class PsCmsCategoryLangJpaController implements Serializable {

    public PsCmsCategoryLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCmsCategoryLang psCmsCategoryLang) throws PreexistingEntityException, Exception {
        if (psCmsCategoryLang.getPsCmsCategoryLangPK() == null) {
            psCmsCategoryLang.setPsCmsCategoryLangPK(new PsCmsCategoryLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCmsCategoryLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCmsCategoryLang(psCmsCategoryLang.getPsCmsCategoryLangPK()) != null) {
                throw new PreexistingEntityException("PsCmsCategoryLang " + psCmsCategoryLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCmsCategoryLang psCmsCategoryLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCmsCategoryLang = em.merge(psCmsCategoryLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCmsCategoryLangPK id = psCmsCategoryLang.getPsCmsCategoryLangPK();
                if (findPsCmsCategoryLang(id) == null) {
                    throw new NonexistentEntityException("The psCmsCategoryLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCmsCategoryLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCmsCategoryLang psCmsCategoryLang;
            try {
                psCmsCategoryLang = em.getReference(PsCmsCategoryLang.class, id);
                psCmsCategoryLang.getPsCmsCategoryLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCmsCategoryLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCmsCategoryLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCmsCategoryLang> findPsCmsCategoryLangEntities() {
        return findPsCmsCategoryLangEntities(true, -1, -1);
    }

    public List<PsCmsCategoryLang> findPsCmsCategoryLangEntities(int maxResults, int firstResult) {
        return findPsCmsCategoryLangEntities(false, maxResults, firstResult);
    }

    private List<PsCmsCategoryLang> findPsCmsCategoryLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCmsCategoryLang.class));
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

    public PsCmsCategoryLang findPsCmsCategoryLang(PsCmsCategoryLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCmsCategoryLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCmsCategoryLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCmsCategoryLang> rt = cq.from(PsCmsCategoryLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

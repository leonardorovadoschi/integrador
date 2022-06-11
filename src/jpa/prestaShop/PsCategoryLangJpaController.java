/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCategoryLang;
import entidade.prestaShop.PsCategoryLangPK;
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
public class PsCategoryLangJpaController implements Serializable {

    public PsCategoryLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCategoryLang psCategoryLang) throws PreexistingEntityException, Exception {
        if (psCategoryLang.getPsCategoryLangPK() == null) {
            psCategoryLang.setPsCategoryLangPK(new PsCategoryLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCategoryLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCategoryLang(psCategoryLang.getPsCategoryLangPK()) != null) {
                throw new PreexistingEntityException("PsCategoryLang " + psCategoryLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCategoryLang psCategoryLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCategoryLang = em.merge(psCategoryLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCategoryLangPK id = psCategoryLang.getPsCategoryLangPK();
                if (findPsCategoryLang(id) == null) {
                    throw new NonexistentEntityException("The psCategoryLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCategoryLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCategoryLang psCategoryLang;
            try {
                psCategoryLang = em.getReference(PsCategoryLang.class, id);
                psCategoryLang.getPsCategoryLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCategoryLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCategoryLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCategoryLang> findPsCategoryLangEntities() {
        return findPsCategoryLangEntities(true, -1, -1);
    }

    public List<PsCategoryLang> findPsCategoryLangEntities(int maxResults, int firstResult) {
        return findPsCategoryLangEntities(false, maxResults, firstResult);
    }

    private List<PsCategoryLang> findPsCategoryLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCategoryLang.class));
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

    public PsCategoryLang findPsCategoryLang(PsCategoryLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCategoryLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCategoryLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCategoryLang> rt = cq.from(PsCategoryLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

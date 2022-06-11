/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCurrencyLang;
import entidade.prestaShop.PsCurrencyLangPK;
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
public class PsCurrencyLangJpaController implements Serializable {

    public PsCurrencyLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCurrencyLang psCurrencyLang) throws PreexistingEntityException, Exception {
        if (psCurrencyLang.getPsCurrencyLangPK() == null) {
            psCurrencyLang.setPsCurrencyLangPK(new PsCurrencyLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCurrencyLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCurrencyLang(psCurrencyLang.getPsCurrencyLangPK()) != null) {
                throw new PreexistingEntityException("PsCurrencyLang " + psCurrencyLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCurrencyLang psCurrencyLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCurrencyLang = em.merge(psCurrencyLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCurrencyLangPK id = psCurrencyLang.getPsCurrencyLangPK();
                if (findPsCurrencyLang(id) == null) {
                    throw new NonexistentEntityException("The psCurrencyLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCurrencyLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCurrencyLang psCurrencyLang;
            try {
                psCurrencyLang = em.getReference(PsCurrencyLang.class, id);
                psCurrencyLang.getPsCurrencyLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCurrencyLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCurrencyLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCurrencyLang> findPsCurrencyLangEntities() {
        return findPsCurrencyLangEntities(true, -1, -1);
    }

    public List<PsCurrencyLang> findPsCurrencyLangEntities(int maxResults, int firstResult) {
        return findPsCurrencyLangEntities(false, maxResults, firstResult);
    }

    private List<PsCurrencyLang> findPsCurrencyLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCurrencyLang.class));
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

    public PsCurrencyLang findPsCurrencyLang(PsCurrencyLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCurrencyLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCurrencyLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCurrencyLang> rt = cq.from(PsCurrencyLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsPsgdprConsentLang;
import entidade.prestaShop.PsPsgdprConsentLangPK;
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
public class PsPsgdprConsentLangJpaController implements Serializable {

    public PsPsgdprConsentLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsPsgdprConsentLang psPsgdprConsentLang) throws PreexistingEntityException, Exception {
        if (psPsgdprConsentLang.getPsPsgdprConsentLangPK() == null) {
            psPsgdprConsentLang.setPsPsgdprConsentLangPK(new PsPsgdprConsentLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psPsgdprConsentLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsPsgdprConsentLang(psPsgdprConsentLang.getPsPsgdprConsentLangPK()) != null) {
                throw new PreexistingEntityException("PsPsgdprConsentLang " + psPsgdprConsentLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsPsgdprConsentLang psPsgdprConsentLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psPsgdprConsentLang = em.merge(psPsgdprConsentLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsPsgdprConsentLangPK id = psPsgdprConsentLang.getPsPsgdprConsentLangPK();
                if (findPsPsgdprConsentLang(id) == null) {
                    throw new NonexistentEntityException("The psPsgdprConsentLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsPsgdprConsentLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsPsgdprConsentLang psPsgdprConsentLang;
            try {
                psPsgdprConsentLang = em.getReference(PsPsgdprConsentLang.class, id);
                psPsgdprConsentLang.getPsPsgdprConsentLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psPsgdprConsentLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psPsgdprConsentLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsPsgdprConsentLang> findPsPsgdprConsentLangEntities() {
        return findPsPsgdprConsentLangEntities(true, -1, -1);
    }

    public List<PsPsgdprConsentLang> findPsPsgdprConsentLangEntities(int maxResults, int firstResult) {
        return findPsPsgdprConsentLangEntities(false, maxResults, firstResult);
    }

    private List<PsPsgdprConsentLang> findPsPsgdprConsentLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsPsgdprConsentLang.class));
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

    public PsPsgdprConsentLang findPsPsgdprConsentLang(PsPsgdprConsentLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsPsgdprConsentLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsPsgdprConsentLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsPsgdprConsentLang> rt = cq.from(PsPsgdprConsentLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

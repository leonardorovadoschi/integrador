/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCmsLang;
import entidade.prestaShop.PsCmsLangPK;
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
public class PsCmsLangJpaController implements Serializable {

    public PsCmsLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCmsLang psCmsLang) throws PreexistingEntityException, Exception {
        if (psCmsLang.getPsCmsLangPK() == null) {
            psCmsLang.setPsCmsLangPK(new PsCmsLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCmsLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCmsLang(psCmsLang.getPsCmsLangPK()) != null) {
                throw new PreexistingEntityException("PsCmsLang " + psCmsLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCmsLang psCmsLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCmsLang = em.merge(psCmsLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCmsLangPK id = psCmsLang.getPsCmsLangPK();
                if (findPsCmsLang(id) == null) {
                    throw new NonexistentEntityException("The psCmsLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCmsLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCmsLang psCmsLang;
            try {
                psCmsLang = em.getReference(PsCmsLang.class, id);
                psCmsLang.getPsCmsLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCmsLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCmsLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCmsLang> findPsCmsLangEntities() {
        return findPsCmsLangEntities(true, -1, -1);
    }

    public List<PsCmsLang> findPsCmsLangEntities(int maxResults, int firstResult) {
        return findPsCmsLangEntities(false, maxResults, firstResult);
    }

    private List<PsCmsLang> findPsCmsLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCmsLang.class));
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

    public PsCmsLang findPsCmsLang(PsCmsLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCmsLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCmsLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCmsLang> rt = cq.from(PsCmsLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

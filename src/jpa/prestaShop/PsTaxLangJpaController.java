/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsTaxLang;
import entidade.prestaShop.PsTaxLangPK;
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
public class PsTaxLangJpaController implements Serializable {

    public PsTaxLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsTaxLang psTaxLang) throws PreexistingEntityException, Exception {
        if (psTaxLang.getPsTaxLangPK() == null) {
            psTaxLang.setPsTaxLangPK(new PsTaxLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psTaxLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsTaxLang(psTaxLang.getPsTaxLangPK()) != null) {
                throw new PreexistingEntityException("PsTaxLang " + psTaxLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsTaxLang psTaxLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psTaxLang = em.merge(psTaxLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsTaxLangPK id = psTaxLang.getPsTaxLangPK();
                if (findPsTaxLang(id) == null) {
                    throw new NonexistentEntityException("The psTaxLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsTaxLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsTaxLang psTaxLang;
            try {
                psTaxLang = em.getReference(PsTaxLang.class, id);
                psTaxLang.getPsTaxLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psTaxLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psTaxLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsTaxLang> findPsTaxLangEntities() {
        return findPsTaxLangEntities(true, -1, -1);
    }

    public List<PsTaxLang> findPsTaxLangEntities(int maxResults, int firstResult) {
        return findPsTaxLangEntities(false, maxResults, firstResult);
    }

    private List<PsTaxLang> findPsTaxLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsTaxLang.class));
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

    public PsTaxLang findPsTaxLang(PsTaxLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsTaxLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsTaxLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsTaxLang> rt = cq.from(PsTaxLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

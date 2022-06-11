/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsOrderMessageLang;
import entidade.prestaShop.PsOrderMessageLangPK;
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
public class PsOrderMessageLangJpaController implements Serializable {

    public PsOrderMessageLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsOrderMessageLang psOrderMessageLang) throws PreexistingEntityException, Exception {
        if (psOrderMessageLang.getPsOrderMessageLangPK() == null) {
            psOrderMessageLang.setPsOrderMessageLangPK(new PsOrderMessageLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psOrderMessageLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsOrderMessageLang(psOrderMessageLang.getPsOrderMessageLangPK()) != null) {
                throw new PreexistingEntityException("PsOrderMessageLang " + psOrderMessageLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsOrderMessageLang psOrderMessageLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psOrderMessageLang = em.merge(psOrderMessageLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsOrderMessageLangPK id = psOrderMessageLang.getPsOrderMessageLangPK();
                if (findPsOrderMessageLang(id) == null) {
                    throw new NonexistentEntityException("The psOrderMessageLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsOrderMessageLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsOrderMessageLang psOrderMessageLang;
            try {
                psOrderMessageLang = em.getReference(PsOrderMessageLang.class, id);
                psOrderMessageLang.getPsOrderMessageLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psOrderMessageLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psOrderMessageLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsOrderMessageLang> findPsOrderMessageLangEntities() {
        return findPsOrderMessageLangEntities(true, -1, -1);
    }

    public List<PsOrderMessageLang> findPsOrderMessageLangEntities(int maxResults, int firstResult) {
        return findPsOrderMessageLangEntities(false, maxResults, firstResult);
    }

    private List<PsOrderMessageLang> findPsOrderMessageLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsOrderMessageLang.class));
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

    public PsOrderMessageLang findPsOrderMessageLang(PsOrderMessageLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsOrderMessageLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsOrderMessageLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsOrderMessageLang> rt = cq.from(PsOrderMessageLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsAttributeGroupLang;
import entidade.prestaShop.PsAttributeGroupLangPK;
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
public class PsAttributeGroupLangJpaController implements Serializable {

    public PsAttributeGroupLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsAttributeGroupLang psAttributeGroupLang) throws PreexistingEntityException, Exception {
        if (psAttributeGroupLang.getPsAttributeGroupLangPK() == null) {
            psAttributeGroupLang.setPsAttributeGroupLangPK(new PsAttributeGroupLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psAttributeGroupLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsAttributeGroupLang(psAttributeGroupLang.getPsAttributeGroupLangPK()) != null) {
                throw new PreexistingEntityException("PsAttributeGroupLang " + psAttributeGroupLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsAttributeGroupLang psAttributeGroupLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psAttributeGroupLang = em.merge(psAttributeGroupLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsAttributeGroupLangPK id = psAttributeGroupLang.getPsAttributeGroupLangPK();
                if (findPsAttributeGroupLang(id) == null) {
                    throw new NonexistentEntityException("The psAttributeGroupLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsAttributeGroupLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsAttributeGroupLang psAttributeGroupLang;
            try {
                psAttributeGroupLang = em.getReference(PsAttributeGroupLang.class, id);
                psAttributeGroupLang.getPsAttributeGroupLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psAttributeGroupLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psAttributeGroupLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsAttributeGroupLang> findPsAttributeGroupLangEntities() {
        return findPsAttributeGroupLangEntities(true, -1, -1);
    }

    public List<PsAttributeGroupLang> findPsAttributeGroupLangEntities(int maxResults, int firstResult) {
        return findPsAttributeGroupLangEntities(false, maxResults, firstResult);
    }

    private List<PsAttributeGroupLang> findPsAttributeGroupLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsAttributeGroupLang.class));
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

    public PsAttributeGroupLang findPsAttributeGroupLang(PsAttributeGroupLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsAttributeGroupLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsAttributeGroupLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsAttributeGroupLang> rt = cq.from(PsAttributeGroupLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

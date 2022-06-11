/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsAttachmentLang;
import entidade.prestaShop.PsAttachmentLangPK;
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
public class PsAttachmentLangJpaController implements Serializable {

    public PsAttachmentLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsAttachmentLang psAttachmentLang) throws PreexistingEntityException, Exception {
        if (psAttachmentLang.getPsAttachmentLangPK() == null) {
            psAttachmentLang.setPsAttachmentLangPK(new PsAttachmentLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psAttachmentLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsAttachmentLang(psAttachmentLang.getPsAttachmentLangPK()) != null) {
                throw new PreexistingEntityException("PsAttachmentLang " + psAttachmentLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsAttachmentLang psAttachmentLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psAttachmentLang = em.merge(psAttachmentLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsAttachmentLangPK id = psAttachmentLang.getPsAttachmentLangPK();
                if (findPsAttachmentLang(id) == null) {
                    throw new NonexistentEntityException("The psAttachmentLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsAttachmentLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsAttachmentLang psAttachmentLang;
            try {
                psAttachmentLang = em.getReference(PsAttachmentLang.class, id);
                psAttachmentLang.getPsAttachmentLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psAttachmentLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psAttachmentLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsAttachmentLang> findPsAttachmentLangEntities() {
        return findPsAttachmentLangEntities(true, -1, -1);
    }

    public List<PsAttachmentLang> findPsAttachmentLangEntities(int maxResults, int firstResult) {
        return findPsAttachmentLangEntities(false, maxResults, firstResult);
    }

    private List<PsAttachmentLang> findPsAttachmentLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsAttachmentLang.class));
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

    public PsAttachmentLang findPsAttachmentLang(PsAttachmentLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsAttachmentLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsAttachmentLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsAttachmentLang> rt = cq.from(PsAttachmentLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

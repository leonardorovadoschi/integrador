/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsAttributeLang;
import entidade.prestaShop.PsAttributeLangPK;
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
public class PsAttributeLangJpaController implements Serializable {

    public PsAttributeLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsAttributeLang psAttributeLang) throws PreexistingEntityException, Exception {
        if (psAttributeLang.getPsAttributeLangPK() == null) {
            psAttributeLang.setPsAttributeLangPK(new PsAttributeLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psAttributeLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsAttributeLang(psAttributeLang.getPsAttributeLangPK()) != null) {
                throw new PreexistingEntityException("PsAttributeLang " + psAttributeLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsAttributeLang psAttributeLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psAttributeLang = em.merge(psAttributeLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsAttributeLangPK id = psAttributeLang.getPsAttributeLangPK();
                if (findPsAttributeLang(id) == null) {
                    throw new NonexistentEntityException("The psAttributeLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsAttributeLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsAttributeLang psAttributeLang;
            try {
                psAttributeLang = em.getReference(PsAttributeLang.class, id);
                psAttributeLang.getPsAttributeLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psAttributeLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psAttributeLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsAttributeLang> findPsAttributeLangEntities() {
        return findPsAttributeLangEntities(true, -1, -1);
    }

    public List<PsAttributeLang> findPsAttributeLangEntities(int maxResults, int firstResult) {
        return findPsAttributeLangEntities(false, maxResults, firstResult);
    }

    private List<PsAttributeLang> findPsAttributeLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsAttributeLang.class));
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

    public PsAttributeLang findPsAttributeLang(PsAttributeLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsAttributeLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsAttributeLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsAttributeLang> rt = cq.from(PsAttributeLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

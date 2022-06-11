/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCmsRoleLang;
import entidade.prestaShop.PsCmsRoleLangPK;
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
public class PsCmsRoleLangJpaController implements Serializable {

    public PsCmsRoleLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCmsRoleLang psCmsRoleLang) throws PreexistingEntityException, Exception {
        if (psCmsRoleLang.getPsCmsRoleLangPK() == null) {
            psCmsRoleLang.setPsCmsRoleLangPK(new PsCmsRoleLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCmsRoleLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCmsRoleLang(psCmsRoleLang.getPsCmsRoleLangPK()) != null) {
                throw new PreexistingEntityException("PsCmsRoleLang " + psCmsRoleLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCmsRoleLang psCmsRoleLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCmsRoleLang = em.merge(psCmsRoleLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCmsRoleLangPK id = psCmsRoleLang.getPsCmsRoleLangPK();
                if (findPsCmsRoleLang(id) == null) {
                    throw new NonexistentEntityException("The psCmsRoleLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCmsRoleLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCmsRoleLang psCmsRoleLang;
            try {
                psCmsRoleLang = em.getReference(PsCmsRoleLang.class, id);
                psCmsRoleLang.getPsCmsRoleLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCmsRoleLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCmsRoleLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCmsRoleLang> findPsCmsRoleLangEntities() {
        return findPsCmsRoleLangEntities(true, -1, -1);
    }

    public List<PsCmsRoleLang> findPsCmsRoleLangEntities(int maxResults, int firstResult) {
        return findPsCmsRoleLangEntities(false, maxResults, firstResult);
    }

    private List<PsCmsRoleLang> findPsCmsRoleLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCmsRoleLang.class));
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

    public PsCmsRoleLang findPsCmsRoleLang(PsCmsRoleLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCmsRoleLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCmsRoleLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCmsRoleLang> rt = cq.from(PsCmsRoleLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

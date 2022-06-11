/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsManufacturerLang;
import entidade.prestaShop.PsManufacturerLangPK;
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
public class PsManufacturerLangJpaController implements Serializable {

    public PsManufacturerLangJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsManufacturerLang psManufacturerLang) throws PreexistingEntityException, Exception {
        if (psManufacturerLang.getPsManufacturerLangPK() == null) {
            psManufacturerLang.setPsManufacturerLangPK(new PsManufacturerLangPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psManufacturerLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsManufacturerLang(psManufacturerLang.getPsManufacturerLangPK()) != null) {
                throw new PreexistingEntityException("PsManufacturerLang " + psManufacturerLang + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsManufacturerLang psManufacturerLang) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psManufacturerLang = em.merge(psManufacturerLang);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsManufacturerLangPK id = psManufacturerLang.getPsManufacturerLangPK();
                if (findPsManufacturerLang(id) == null) {
                    throw new NonexistentEntityException("The psManufacturerLang with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsManufacturerLangPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsManufacturerLang psManufacturerLang;
            try {
                psManufacturerLang = em.getReference(PsManufacturerLang.class, id);
                psManufacturerLang.getPsManufacturerLangPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psManufacturerLang with id " + id + " no longer exists.", enfe);
            }
            em.remove(psManufacturerLang);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsManufacturerLang> findPsManufacturerLangEntities() {
        return findPsManufacturerLangEntities(true, -1, -1);
    }

    public List<PsManufacturerLang> findPsManufacturerLangEntities(int maxResults, int firstResult) {
        return findPsManufacturerLangEntities(false, maxResults, firstResult);
    }

    private List<PsManufacturerLang> findPsManufacturerLangEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsManufacturerLang.class));
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

    public PsManufacturerLang findPsManufacturerLang(PsManufacturerLangPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsManufacturerLang.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsManufacturerLangCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsManufacturerLang> rt = cq.from(PsManufacturerLang.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

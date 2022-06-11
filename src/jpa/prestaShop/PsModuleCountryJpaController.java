/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsModuleCountry;
import entidade.prestaShop.PsModuleCountryPK;
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
public class PsModuleCountryJpaController implements Serializable {

    public PsModuleCountryJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsModuleCountry psModuleCountry) throws PreexistingEntityException, Exception {
        if (psModuleCountry.getPsModuleCountryPK() == null) {
            psModuleCountry.setPsModuleCountryPK(new PsModuleCountryPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psModuleCountry);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsModuleCountry(psModuleCountry.getPsModuleCountryPK()) != null) {
                throw new PreexistingEntityException("PsModuleCountry " + psModuleCountry + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsModuleCountry psModuleCountry) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psModuleCountry = em.merge(psModuleCountry);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsModuleCountryPK id = psModuleCountry.getPsModuleCountryPK();
                if (findPsModuleCountry(id) == null) {
                    throw new NonexistentEntityException("The psModuleCountry with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsModuleCountryPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsModuleCountry psModuleCountry;
            try {
                psModuleCountry = em.getReference(PsModuleCountry.class, id);
                psModuleCountry.getPsModuleCountryPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psModuleCountry with id " + id + " no longer exists.", enfe);
            }
            em.remove(psModuleCountry);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsModuleCountry> findPsModuleCountryEntities() {
        return findPsModuleCountryEntities(true, -1, -1);
    }

    public List<PsModuleCountry> findPsModuleCountryEntities(int maxResults, int firstResult) {
        return findPsModuleCountryEntities(false, maxResults, firstResult);
    }

    private List<PsModuleCountry> findPsModuleCountryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsModuleCountry.class));
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

    public PsModuleCountry findPsModuleCountry(PsModuleCountryPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsModuleCountry.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsModuleCountryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsModuleCountry> rt = cq.from(PsModuleCountry.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCartRuleCountry;
import entidade.prestaShop.PsCartRuleCountryPK;
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
public class PsCartRuleCountryJpaController implements Serializable {

    public PsCartRuleCountryJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCartRuleCountry psCartRuleCountry) throws PreexistingEntityException, Exception {
        if (psCartRuleCountry.getPsCartRuleCountryPK() == null) {
            psCartRuleCountry.setPsCartRuleCountryPK(new PsCartRuleCountryPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCartRuleCountry);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCartRuleCountry(psCartRuleCountry.getPsCartRuleCountryPK()) != null) {
                throw new PreexistingEntityException("PsCartRuleCountry " + psCartRuleCountry + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCartRuleCountry psCartRuleCountry) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCartRuleCountry = em.merge(psCartRuleCountry);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCartRuleCountryPK id = psCartRuleCountry.getPsCartRuleCountryPK();
                if (findPsCartRuleCountry(id) == null) {
                    throw new NonexistentEntityException("The psCartRuleCountry with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCartRuleCountryPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCartRuleCountry psCartRuleCountry;
            try {
                psCartRuleCountry = em.getReference(PsCartRuleCountry.class, id);
                psCartRuleCountry.getPsCartRuleCountryPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCartRuleCountry with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCartRuleCountry);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCartRuleCountry> findPsCartRuleCountryEntities() {
        return findPsCartRuleCountryEntities(true, -1, -1);
    }

    public List<PsCartRuleCountry> findPsCartRuleCountryEntities(int maxResults, int firstResult) {
        return findPsCartRuleCountryEntities(false, maxResults, firstResult);
    }

    private List<PsCartRuleCountry> findPsCartRuleCountryEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCartRuleCountry.class));
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

    public PsCartRuleCountry findPsCartRuleCountry(PsCartRuleCountryPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCartRuleCountry.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCartRuleCountryCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCartRuleCountry> rt = cq.from(PsCartRuleCountry.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

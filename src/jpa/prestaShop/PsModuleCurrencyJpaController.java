/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsModuleCurrency;
import entidade.prestaShop.PsModuleCurrencyPK;
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
public class PsModuleCurrencyJpaController implements Serializable {

    public PsModuleCurrencyJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsModuleCurrency psModuleCurrency) throws PreexistingEntityException, Exception {
        if (psModuleCurrency.getPsModuleCurrencyPK() == null) {
            psModuleCurrency.setPsModuleCurrencyPK(new PsModuleCurrencyPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psModuleCurrency);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsModuleCurrency(psModuleCurrency.getPsModuleCurrencyPK()) != null) {
                throw new PreexistingEntityException("PsModuleCurrency " + psModuleCurrency + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsModuleCurrency psModuleCurrency) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psModuleCurrency = em.merge(psModuleCurrency);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsModuleCurrencyPK id = psModuleCurrency.getPsModuleCurrencyPK();
                if (findPsModuleCurrency(id) == null) {
                    throw new NonexistentEntityException("The psModuleCurrency with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsModuleCurrencyPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsModuleCurrency psModuleCurrency;
            try {
                psModuleCurrency = em.getReference(PsModuleCurrency.class, id);
                psModuleCurrency.getPsModuleCurrencyPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psModuleCurrency with id " + id + " no longer exists.", enfe);
            }
            em.remove(psModuleCurrency);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsModuleCurrency> findPsModuleCurrencyEntities() {
        return findPsModuleCurrencyEntities(true, -1, -1);
    }

    public List<PsModuleCurrency> findPsModuleCurrencyEntities(int maxResults, int firstResult) {
        return findPsModuleCurrencyEntities(false, maxResults, firstResult);
    }

    private List<PsModuleCurrency> findPsModuleCurrencyEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsModuleCurrency.class));
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

    public PsModuleCurrency findPsModuleCurrency(PsModuleCurrencyPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsModuleCurrency.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsModuleCurrencyCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsModuleCurrency> rt = cq.from(PsModuleCurrency.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

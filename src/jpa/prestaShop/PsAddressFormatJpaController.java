/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsAddressFormat;
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
public class PsAddressFormatJpaController implements Serializable {

    public PsAddressFormatJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsAddressFormat psAddressFormat) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psAddressFormat);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsAddressFormat(psAddressFormat.getIdCountry()) != null) {
                throw new PreexistingEntityException("PsAddressFormat " + psAddressFormat + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsAddressFormat psAddressFormat) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psAddressFormat = em.merge(psAddressFormat);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psAddressFormat.getIdCountry();
                if (findPsAddressFormat(id) == null) {
                    throw new NonexistentEntityException("The psAddressFormat with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsAddressFormat psAddressFormat;
            try {
                psAddressFormat = em.getReference(PsAddressFormat.class, id);
                psAddressFormat.getIdCountry();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psAddressFormat with id " + id + " no longer exists.", enfe);
            }
            em.remove(psAddressFormat);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsAddressFormat> findPsAddressFormatEntities() {
        return findPsAddressFormatEntities(true, -1, -1);
    }

    public List<PsAddressFormat> findPsAddressFormatEntities(int maxResults, int firstResult) {
        return findPsAddressFormatEntities(false, maxResults, firstResult);
    }

    private List<PsAddressFormat> findPsAddressFormatEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsAddressFormat.class));
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

    public PsAddressFormat findPsAddressFormat(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsAddressFormat.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsAddressFormatCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsAddressFormat> rt = cq.from(PsAddressFormat.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

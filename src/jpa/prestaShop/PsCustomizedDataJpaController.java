/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCustomizedData;
import entidade.prestaShop.PsCustomizedDataPK;
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
public class PsCustomizedDataJpaController implements Serializable {

    public PsCustomizedDataJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCustomizedData psCustomizedData) throws PreexistingEntityException, Exception {
        if (psCustomizedData.getPsCustomizedDataPK() == null) {
            psCustomizedData.setPsCustomizedDataPK(new PsCustomizedDataPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCustomizedData);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCustomizedData(psCustomizedData.getPsCustomizedDataPK()) != null) {
                throw new PreexistingEntityException("PsCustomizedData " + psCustomizedData + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCustomizedData psCustomizedData) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCustomizedData = em.merge(psCustomizedData);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCustomizedDataPK id = psCustomizedData.getPsCustomizedDataPK();
                if (findPsCustomizedData(id) == null) {
                    throw new NonexistentEntityException("The psCustomizedData with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCustomizedDataPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCustomizedData psCustomizedData;
            try {
                psCustomizedData = em.getReference(PsCustomizedData.class, id);
                psCustomizedData.getPsCustomizedDataPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCustomizedData with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCustomizedData);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCustomizedData> findPsCustomizedDataEntities() {
        return findPsCustomizedDataEntities(true, -1, -1);
    }

    public List<PsCustomizedData> findPsCustomizedDataEntities(int maxResults, int firstResult) {
        return findPsCustomizedDataEntities(false, maxResults, firstResult);
    }

    private List<PsCustomizedData> findPsCustomizedDataEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCustomizedData.class));
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

    public PsCustomizedData findPsCustomizedData(PsCustomizedDataPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCustomizedData.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCustomizedDataCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCustomizedData> rt = cq.from(PsCustomizedData.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

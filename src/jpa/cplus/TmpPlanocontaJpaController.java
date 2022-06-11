/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpPlanoconta;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class TmpPlanocontaJpaController implements Serializable {

    public TmpPlanocontaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpPlanoconta tmpPlanoconta) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpPlanoconta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpPlanoconta(tmpPlanoconta.getId()) != null) {
                throw new PreexistingEntityException("TmpPlanoconta " + tmpPlanoconta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpPlanoconta tmpPlanoconta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpPlanoconta = em.merge(tmpPlanoconta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpPlanoconta.getId();
                if (findTmpPlanoconta(id) == null) {
                    throw new NonexistentEntityException("The tmpPlanoconta with id " + id + " no longer exists.");
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
            TmpPlanoconta tmpPlanoconta;
            try {
                tmpPlanoconta = em.getReference(TmpPlanoconta.class, id);
                tmpPlanoconta.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpPlanoconta with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpPlanoconta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpPlanoconta> findTmpPlanocontaEntities() {
        return findTmpPlanocontaEntities(true, -1, -1);
    }

    public List<TmpPlanoconta> findTmpPlanocontaEntities(int maxResults, int firstResult) {
        return findTmpPlanocontaEntities(false, maxResults, firstResult);
    }

    private List<TmpPlanoconta> findTmpPlanocontaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpPlanoconta.class));
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

    public TmpPlanoconta findTmpPlanoconta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpPlanoconta.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpPlanocontaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpPlanoconta> rt = cq.from(TmpPlanoconta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

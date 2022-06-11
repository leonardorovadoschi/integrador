/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Relatoriojoin;
import entidade.cplus.RelatoriojoinPK;
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
public class RelatoriojoinJpaController implements Serializable {

    public RelatoriojoinJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Relatoriojoin relatoriojoin) throws PreexistingEntityException, Exception {
        if (relatoriojoin.getRelatoriojoinPK() == null) {
            relatoriojoin.setRelatoriojoinPK(new RelatoriojoinPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(relatoriojoin);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRelatoriojoin(relatoriojoin.getRelatoriojoinPK()) != null) {
                throw new PreexistingEntityException("Relatoriojoin " + relatoriojoin + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Relatoriojoin relatoriojoin) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            relatoriojoin = em.merge(relatoriojoin);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                RelatoriojoinPK id = relatoriojoin.getRelatoriojoinPK();
                if (findRelatoriojoin(id) == null) {
                    throw new NonexistentEntityException("The relatoriojoin with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(RelatoriojoinPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Relatoriojoin relatoriojoin;
            try {
                relatoriojoin = em.getReference(Relatoriojoin.class, id);
                relatoriojoin.getRelatoriojoinPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The relatoriojoin with id " + id + " no longer exists.", enfe);
            }
            em.remove(relatoriojoin);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Relatoriojoin> findRelatoriojoinEntities() {
        return findRelatoriojoinEntities(true, -1, -1);
    }

    public List<Relatoriojoin> findRelatoriojoinEntities(int maxResults, int firstResult) {
        return findRelatoriojoinEntities(false, maxResults, firstResult);
    }

    private List<Relatoriojoin> findRelatoriojoinEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Relatoriojoin.class));
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

    public Relatoriojoin findRelatoriojoin(RelatoriojoinPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Relatoriojoin.class, id);
        } finally {
            em.close();
        }
    }

    public int getRelatoriojoinCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Relatoriojoin> rt = cq.from(Relatoriojoin.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

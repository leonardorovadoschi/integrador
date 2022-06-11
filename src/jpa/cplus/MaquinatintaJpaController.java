/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Maquinatinta;
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
public class MaquinatintaJpaController implements Serializable {

    public MaquinatintaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Maquinatinta maquinatinta) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(maquinatinta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMaquinatinta(maquinatinta.getCodmaquinatinta()) != null) {
                throw new PreexistingEntityException("Maquinatinta " + maquinatinta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Maquinatinta maquinatinta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            maquinatinta = em.merge(maquinatinta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = maquinatinta.getCodmaquinatinta();
                if (findMaquinatinta(id) == null) {
                    throw new NonexistentEntityException("The maquinatinta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Maquinatinta maquinatinta;
            try {
                maquinatinta = em.getReference(Maquinatinta.class, id);
                maquinatinta.getCodmaquinatinta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The maquinatinta with id " + id + " no longer exists.", enfe);
            }
            em.remove(maquinatinta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Maquinatinta> findMaquinatintaEntities() {
        return findMaquinatintaEntities(true, -1, -1);
    }

    public List<Maquinatinta> findMaquinatintaEntities(int maxResults, int firstResult) {
        return findMaquinatintaEntities(false, maxResults, firstResult);
    }

    private List<Maquinatinta> findMaquinatintaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Maquinatinta.class));
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

    public Maquinatinta findMaquinatinta(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Maquinatinta.class, id);
        } finally {
            em.close();
        }
    }

    public int getMaquinatintaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Maquinatinta> rt = cq.from(Maquinatinta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

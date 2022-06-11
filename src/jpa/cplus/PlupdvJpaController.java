/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Plupdv;
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
public class PlupdvJpaController implements Serializable {

    public PlupdvJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Plupdv plupdv) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(plupdv);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPlupdv(plupdv.getCodplupdv()) != null) {
                throw new PreexistingEntityException("Plupdv " + plupdv + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Plupdv plupdv) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            plupdv = em.merge(plupdv);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = plupdv.getCodplupdv();
                if (findPlupdv(id) == null) {
                    throw new NonexistentEntityException("The plupdv with id " + id + " no longer exists.");
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
            Plupdv plupdv;
            try {
                plupdv = em.getReference(Plupdv.class, id);
                plupdv.getCodplupdv();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The plupdv with id " + id + " no longer exists.", enfe);
            }
            em.remove(plupdv);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Plupdv> findPlupdvEntities() {
        return findPlupdvEntities(true, -1, -1);
    }

    public List<Plupdv> findPlupdvEntities(int maxResults, int firstResult) {
        return findPlupdvEntities(false, maxResults, firstResult);
    }

    private List<Plupdv> findPlupdvEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Plupdv.class));
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

    public Plupdv findPlupdv(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Plupdv.class, id);
        } finally {
            em.close();
        }
    }

    public int getPlupdvCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Plupdv> rt = cq.from(Plupdv.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

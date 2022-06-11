/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Nfeletronicalog;
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
public class NfeletronicalogJpaController implements Serializable {

    public NfeletronicalogJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Nfeletronicalog nfeletronicalog) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(nfeletronicalog);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNfeletronicalog(nfeletronicalog.getIdnfeletronicalog()) != null) {
                throw new PreexistingEntityException("Nfeletronicalog " + nfeletronicalog + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nfeletronicalog nfeletronicalog) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            nfeletronicalog = em.merge(nfeletronicalog);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = nfeletronicalog.getIdnfeletronicalog();
                if (findNfeletronicalog(id) == null) {
                    throw new NonexistentEntityException("The nfeletronicalog with id " + id + " no longer exists.");
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
            Nfeletronicalog nfeletronicalog;
            try {
                nfeletronicalog = em.getReference(Nfeletronicalog.class, id);
                nfeletronicalog.getIdnfeletronicalog();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nfeletronicalog with id " + id + " no longer exists.", enfe);
            }
            em.remove(nfeletronicalog);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nfeletronicalog> findNfeletronicalogEntities() {
        return findNfeletronicalogEntities(true, -1, -1);
    }

    public List<Nfeletronicalog> findNfeletronicalogEntities(int maxResults, int firstResult) {
        return findNfeletronicalogEntities(false, maxResults, firstResult);
    }

    private List<Nfeletronicalog> findNfeletronicalogEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nfeletronicalog.class));
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

    public Nfeletronicalog findNfeletronicalog(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nfeletronicalog.class, id);
        } finally {
            em.close();
        }
    }

    public int getNfeletronicalogCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nfeletronicalog> rt = cq.from(Nfeletronicalog.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

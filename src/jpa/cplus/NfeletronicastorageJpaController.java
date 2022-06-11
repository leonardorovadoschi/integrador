/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Nfeletronicastorage;
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
public class NfeletronicastorageJpaController implements Serializable {

    public NfeletronicastorageJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Nfeletronicastorage nfeletronicastorage) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(nfeletronicastorage);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNfeletronicastorage(nfeletronicastorage.getChaveacesso()) != null) {
                throw new PreexistingEntityException("Nfeletronicastorage " + nfeletronicastorage + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nfeletronicastorage nfeletronicastorage) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            nfeletronicastorage = em.merge(nfeletronicastorage);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = nfeletronicastorage.getChaveacesso();
                if (findNfeletronicastorage(id) == null) {
                    throw new NonexistentEntityException("The nfeletronicastorage with id " + id + " no longer exists.");
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
            Nfeletronicastorage nfeletronicastorage;
            try {
                nfeletronicastorage = em.getReference(Nfeletronicastorage.class, id);
                nfeletronicastorage.getChaveacesso();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nfeletronicastorage with id " + id + " no longer exists.", enfe);
            }
            em.remove(nfeletronicastorage);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nfeletronicastorage> findNfeletronicastorageEntities() {
        return findNfeletronicastorageEntities(true, -1, -1);
    }

    public List<Nfeletronicastorage> findNfeletronicastorageEntities(int maxResults, int firstResult) {
        return findNfeletronicastorageEntities(false, maxResults, firstResult);
    }

    private List<Nfeletronicastorage> findNfeletronicastorageEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nfeletronicastorage.class));
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

    public Nfeletronicastorage findNfeletronicastorage(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nfeletronicastorage.class, id);
        } finally {
            em.close();
        }
    }

    public int getNfeletronicastorageCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nfeletronicastorage> rt = cq.from(Nfeletronicastorage.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Historicoextratoserasa;
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
public class HistoricoextratoserasaJpaController implements Serializable {

    public HistoricoextratoserasaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Historicoextratoserasa historicoextratoserasa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(historicoextratoserasa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHistoricoextratoserasa(historicoextratoserasa.getCodhistoricoextratoserasa()) != null) {
                throw new PreexistingEntityException("Historicoextratoserasa " + historicoextratoserasa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Historicoextratoserasa historicoextratoserasa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            historicoextratoserasa = em.merge(historicoextratoserasa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = historicoextratoserasa.getCodhistoricoextratoserasa();
                if (findHistoricoextratoserasa(id) == null) {
                    throw new NonexistentEntityException("The historicoextratoserasa with id " + id + " no longer exists.");
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
            Historicoextratoserasa historicoextratoserasa;
            try {
                historicoextratoserasa = em.getReference(Historicoextratoserasa.class, id);
                historicoextratoserasa.getCodhistoricoextratoserasa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The historicoextratoserasa with id " + id + " no longer exists.", enfe);
            }
            em.remove(historicoextratoserasa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Historicoextratoserasa> findHistoricoextratoserasaEntities() {
        return findHistoricoextratoserasaEntities(true, -1, -1);
    }

    public List<Historicoextratoserasa> findHistoricoextratoserasaEntities(int maxResults, int firstResult) {
        return findHistoricoextratoserasaEntities(false, maxResults, firstResult);
    }

    private List<Historicoextratoserasa> findHistoricoextratoserasaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Historicoextratoserasa.class));
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

    public Historicoextratoserasa findHistoricoextratoserasa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Historicoextratoserasa.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistoricoextratoserasaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Historicoextratoserasa> rt = cq.from(Historicoextratoserasa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

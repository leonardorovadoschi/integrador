/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Logexportacaosngpc;
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
public class LogexportacaosngpcJpaController implements Serializable {

    public LogexportacaosngpcJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Logexportacaosngpc logexportacaosngpc) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(logexportacaosngpc);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLogexportacaosngpc(logexportacaosngpc.getCodlogexportacaosngpc()) != null) {
                throw new PreexistingEntityException("Logexportacaosngpc " + logexportacaosngpc + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Logexportacaosngpc logexportacaosngpc) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            logexportacaosngpc = em.merge(logexportacaosngpc);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = logexportacaosngpc.getCodlogexportacaosngpc();
                if (findLogexportacaosngpc(id) == null) {
                    throw new NonexistentEntityException("The logexportacaosngpc with id " + id + " no longer exists.");
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
            Logexportacaosngpc logexportacaosngpc;
            try {
                logexportacaosngpc = em.getReference(Logexportacaosngpc.class, id);
                logexportacaosngpc.getCodlogexportacaosngpc();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The logexportacaosngpc with id " + id + " no longer exists.", enfe);
            }
            em.remove(logexportacaosngpc);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Logexportacaosngpc> findLogexportacaosngpcEntities() {
        return findLogexportacaosngpcEntities(true, -1, -1);
    }

    public List<Logexportacaosngpc> findLogexportacaosngpcEntities(int maxResults, int firstResult) {
        return findLogexportacaosngpcEntities(false, maxResults, firstResult);
    }

    private List<Logexportacaosngpc> findLogexportacaosngpcEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Logexportacaosngpc.class));
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

    public Logexportacaosngpc findLogexportacaosngpc(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Logexportacaosngpc.class, id);
        } finally {
            em.close();
        }
    }

    public int getLogexportacaosngpcCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Logexportacaosngpc> rt = cq.from(Logexportacaosngpc.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

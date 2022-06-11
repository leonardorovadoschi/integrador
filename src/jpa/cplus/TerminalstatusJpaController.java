/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Terminalstatus;
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
public class TerminalstatusJpaController implements Serializable {

    public TerminalstatusJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Terminalstatus terminalstatus) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(terminalstatus);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTerminalstatus(terminalstatus.getCodterminal()) != null) {
                throw new PreexistingEntityException("Terminalstatus " + terminalstatus + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Terminalstatus terminalstatus) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            terminalstatus = em.merge(terminalstatus);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = terminalstatus.getCodterminal();
                if (findTerminalstatus(id) == null) {
                    throw new NonexistentEntityException("The terminalstatus with id " + id + " no longer exists.");
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
            Terminalstatus terminalstatus;
            try {
                terminalstatus = em.getReference(Terminalstatus.class, id);
                terminalstatus.getCodterminal();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The terminalstatus with id " + id + " no longer exists.", enfe);
            }
            em.remove(terminalstatus);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Terminalstatus> findTerminalstatusEntities() {
        return findTerminalstatusEntities(true, -1, -1);
    }

    public List<Terminalstatus> findTerminalstatusEntities(int maxResults, int firstResult) {
        return findTerminalstatusEntities(false, maxResults, firstResult);
    }

    private List<Terminalstatus> findTerminalstatusEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Terminalstatus.class));
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

    public Terminalstatus findTerminalstatus(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Terminalstatus.class, id);
        } finally {
            em.close();
        }
    }

    public int getTerminalstatusCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Terminalstatus> rt = cq.from(Terminalstatus.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

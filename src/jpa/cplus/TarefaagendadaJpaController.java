/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Tarefaagendada;
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
public class TarefaagendadaJpaController implements Serializable {

    public TarefaagendadaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tarefaagendada tarefaagendada) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tarefaagendada);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTarefaagendada(tarefaagendada.getCodtarefaagendada()) != null) {
                throw new PreexistingEntityException("Tarefaagendada " + tarefaagendada + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tarefaagendada tarefaagendada) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tarefaagendada = em.merge(tarefaagendada);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tarefaagendada.getCodtarefaagendada();
                if (findTarefaagendada(id) == null) {
                    throw new NonexistentEntityException("The tarefaagendada with id " + id + " no longer exists.");
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
            Tarefaagendada tarefaagendada;
            try {
                tarefaagendada = em.getReference(Tarefaagendada.class, id);
                tarefaagendada.getCodtarefaagendada();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tarefaagendada with id " + id + " no longer exists.", enfe);
            }
            em.remove(tarefaagendada);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tarefaagendada> findTarefaagendadaEntities() {
        return findTarefaagendadaEntities(true, -1, -1);
    }

    public List<Tarefaagendada> findTarefaagendadaEntities(int maxResults, int firstResult) {
        return findTarefaagendadaEntities(false, maxResults, firstResult);
    }

    private List<Tarefaagendada> findTarefaagendadaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tarefaagendada.class));
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

    public Tarefaagendada findTarefaagendada(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tarefaagendada.class, id);
        } finally {
            em.close();
        }
    }

    public int getTarefaagendadaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tarefaagendada> rt = cq.from(Tarefaagendada.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

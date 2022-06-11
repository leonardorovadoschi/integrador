/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Relatoriocenario;
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
public class RelatoriocenarioJpaController implements Serializable {

    public RelatoriocenarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Relatoriocenario relatoriocenario) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(relatoriocenario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRelatoriocenario(relatoriocenario.getCodrelatoriocenario()) != null) {
                throw new PreexistingEntityException("Relatoriocenario " + relatoriocenario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Relatoriocenario relatoriocenario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            relatoriocenario = em.merge(relatoriocenario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = relatoriocenario.getCodrelatoriocenario();
                if (findRelatoriocenario(id) == null) {
                    throw new NonexistentEntityException("The relatoriocenario with id " + id + " no longer exists.");
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
            Relatoriocenario relatoriocenario;
            try {
                relatoriocenario = em.getReference(Relatoriocenario.class, id);
                relatoriocenario.getCodrelatoriocenario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The relatoriocenario with id " + id + " no longer exists.", enfe);
            }
            em.remove(relatoriocenario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Relatoriocenario> findRelatoriocenarioEntities() {
        return findRelatoriocenarioEntities(true, -1, -1);
    }

    public List<Relatoriocenario> findRelatoriocenarioEntities(int maxResults, int firstResult) {
        return findRelatoriocenarioEntities(false, maxResults, firstResult);
    }

    private List<Relatoriocenario> findRelatoriocenarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Relatoriocenario.class));
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

    public Relatoriocenario findRelatoriocenario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Relatoriocenario.class, id);
        } finally {
            em.close();
        }
    }

    public int getRelatoriocenarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Relatoriocenario> rt = cq.from(Relatoriocenario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

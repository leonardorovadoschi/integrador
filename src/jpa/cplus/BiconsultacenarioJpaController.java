/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Biconsultacenario;
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
public class BiconsultacenarioJpaController implements Serializable {

    public BiconsultacenarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Biconsultacenario biconsultacenario) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(biconsultacenario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBiconsultacenario(biconsultacenario.getCodbiconsultacenario()) != null) {
                throw new PreexistingEntityException("Biconsultacenario " + biconsultacenario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Biconsultacenario biconsultacenario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            biconsultacenario = em.merge(biconsultacenario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = biconsultacenario.getCodbiconsultacenario();
                if (findBiconsultacenario(id) == null) {
                    throw new NonexistentEntityException("The biconsultacenario with id " + id + " no longer exists.");
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
            Biconsultacenario biconsultacenario;
            try {
                biconsultacenario = em.getReference(Biconsultacenario.class, id);
                biconsultacenario.getCodbiconsultacenario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The biconsultacenario with id " + id + " no longer exists.", enfe);
            }
            em.remove(biconsultacenario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Biconsultacenario> findBiconsultacenarioEntities() {
        return findBiconsultacenarioEntities(true, -1, -1);
    }

    public List<Biconsultacenario> findBiconsultacenarioEntities(int maxResults, int firstResult) {
        return findBiconsultacenarioEntities(false, maxResults, firstResult);
    }

    private List<Biconsultacenario> findBiconsultacenarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Biconsultacenario.class));
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

    public Biconsultacenario findBiconsultacenario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Biconsultacenario.class, id);
        } finally {
            em.close();
        }
    }

    public int getBiconsultacenarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Biconsultacenario> rt = cq.from(Biconsultacenario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

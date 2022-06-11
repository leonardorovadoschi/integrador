/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Nutricional;
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
public class NutricionalJpaController implements Serializable {

    public NutricionalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Nutricional nutricional) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(nutricional);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNutricional(nutricional.getCodnutricional()) != null) {
                throw new PreexistingEntityException("Nutricional " + nutricional + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nutricional nutricional) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            nutricional = em.merge(nutricional);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = nutricional.getCodnutricional();
                if (findNutricional(id) == null) {
                    throw new NonexistentEntityException("The nutricional with id " + id + " no longer exists.");
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
            Nutricional nutricional;
            try {
                nutricional = em.getReference(Nutricional.class, id);
                nutricional.getCodnutricional();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nutricional with id " + id + " no longer exists.", enfe);
            }
            em.remove(nutricional);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nutricional> findNutricionalEntities() {
        return findNutricionalEntities(true, -1, -1);
    }

    public List<Nutricional> findNutricionalEntities(int maxResults, int firstResult) {
        return findNutricionalEntities(false, maxResults, firstResult);
    }

    private List<Nutricional> findNutricionalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nutricional.class));
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

    public Nutricional findNutricional(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nutricional.class, id);
        } finally {
            em.close();
        }
    }

    public int getNutricionalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nutricional> rt = cq.from(Nutricional.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

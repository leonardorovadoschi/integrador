/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Extratobancario;
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
public class ExtratobancarioJpaController implements Serializable {

    public ExtratobancarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Extratobancario extratobancario) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(extratobancario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findExtratobancario(extratobancario.getCodextratobancario()) != null) {
                throw new PreexistingEntityException("Extratobancario " + extratobancario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Extratobancario extratobancario) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            extratobancario = em.merge(extratobancario);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = extratobancario.getCodextratobancario();
                if (findExtratobancario(id) == null) {
                    throw new NonexistentEntityException("The extratobancario with id " + id + " no longer exists.");
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
            Extratobancario extratobancario;
            try {
                extratobancario = em.getReference(Extratobancario.class, id);
                extratobancario.getCodextratobancario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The extratobancario with id " + id + " no longer exists.", enfe);
            }
            em.remove(extratobancario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Extratobancario> findExtratobancarioEntities() {
        return findExtratobancarioEntities(true, -1, -1);
    }

    public List<Extratobancario> findExtratobancarioEntities(int maxResults, int firstResult) {
        return findExtratobancarioEntities(false, maxResults, firstResult);
    }

    private List<Extratobancario> findExtratobancarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Extratobancario.class));
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

    public Extratobancario findExtratobancario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Extratobancario.class, id);
        } finally {
            em.close();
        }
    }

    public int getExtratobancarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Extratobancario> rt = cq.from(Extratobancario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

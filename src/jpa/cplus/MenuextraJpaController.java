/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Menuextra;
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
public class MenuextraJpaController implements Serializable {

    public MenuextraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Menuextra menuextra) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(menuextra);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMenuextra(menuextra.getCodmenuextra()) != null) {
                throw new PreexistingEntityException("Menuextra " + menuextra + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Menuextra menuextra) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            menuextra = em.merge(menuextra);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = menuextra.getCodmenuextra();
                if (findMenuextra(id) == null) {
                    throw new NonexistentEntityException("The menuextra with id " + id + " no longer exists.");
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
            Menuextra menuextra;
            try {
                menuextra = em.getReference(Menuextra.class, id);
                menuextra.getCodmenuextra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The menuextra with id " + id + " no longer exists.", enfe);
            }
            em.remove(menuextra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Menuextra> findMenuextraEntities() {
        return findMenuextraEntities(true, -1, -1);
    }

    public List<Menuextra> findMenuextraEntities(int maxResults, int firstResult) {
        return findMenuextraEntities(false, maxResults, firstResult);
    }

    private List<Menuextra> findMenuextraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Menuextra.class));
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

    public Menuextra findMenuextra(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Menuextra.class, id);
        } finally {
            em.close();
        }
    }

    public int getMenuextraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Menuextra> rt = cq.from(Menuextra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

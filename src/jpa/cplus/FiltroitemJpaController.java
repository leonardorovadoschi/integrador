/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Filtroitem;
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
public class FiltroitemJpaController implements Serializable {

    public FiltroitemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Filtroitem filtroitem) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(filtroitem);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFiltroitem(filtroitem.getCodfiltroitem()) != null) {
                throw new PreexistingEntityException("Filtroitem " + filtroitem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Filtroitem filtroitem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            filtroitem = em.merge(filtroitem);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = filtroitem.getCodfiltroitem();
                if (findFiltroitem(id) == null) {
                    throw new NonexistentEntityException("The filtroitem with id " + id + " no longer exists.");
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
            Filtroitem filtroitem;
            try {
                filtroitem = em.getReference(Filtroitem.class, id);
                filtroitem.getCodfiltroitem();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The filtroitem with id " + id + " no longer exists.", enfe);
            }
            em.remove(filtroitem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Filtroitem> findFiltroitemEntities() {
        return findFiltroitemEntities(true, -1, -1);
    }

    public List<Filtroitem> findFiltroitemEntities(int maxResults, int firstResult) {
        return findFiltroitemEntities(false, maxResults, firstResult);
    }

    private List<Filtroitem> findFiltroitemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Filtroitem.class));
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

    public Filtroitem findFiltroitem(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Filtroitem.class, id);
        } finally {
            em.close();
        }
    }

    public int getFiltroitemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Filtroitem> rt = cq.from(Filtroitem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

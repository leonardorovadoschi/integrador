/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Comissaotecnico;
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
public class ComissaotecnicoJpaController implements Serializable {

    public ComissaotecnicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Comissaotecnico comissaotecnico) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(comissaotecnico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findComissaotecnico(comissaotecnico.getCodcomissaotecnico()) != null) {
                throw new PreexistingEntityException("Comissaotecnico " + comissaotecnico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Comissaotecnico comissaotecnico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            comissaotecnico = em.merge(comissaotecnico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = comissaotecnico.getCodcomissaotecnico();
                if (findComissaotecnico(id) == null) {
                    throw new NonexistentEntityException("The comissaotecnico with id " + id + " no longer exists.");
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
            Comissaotecnico comissaotecnico;
            try {
                comissaotecnico = em.getReference(Comissaotecnico.class, id);
                comissaotecnico.getCodcomissaotecnico();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The comissaotecnico with id " + id + " no longer exists.", enfe);
            }
            em.remove(comissaotecnico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Comissaotecnico> findComissaotecnicoEntities() {
        return findComissaotecnicoEntities(true, -1, -1);
    }

    public List<Comissaotecnico> findComissaotecnicoEntities(int maxResults, int firstResult) {
        return findComissaotecnicoEntities(false, maxResults, firstResult);
    }

    private List<Comissaotecnico> findComissaotecnicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Comissaotecnico.class));
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

    public Comissaotecnico findComissaotecnico(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Comissaotecnico.class, id);
        } finally {
            em.close();
        }
    }

    public int getComissaotecnicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Comissaotecnico> rt = cq.from(Comissaotecnico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

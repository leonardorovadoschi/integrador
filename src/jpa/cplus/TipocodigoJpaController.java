/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Tipocodigo;
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
public class TipocodigoJpaController implements Serializable {

    public TipocodigoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipocodigo tipocodigo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipocodigo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipocodigo(tipocodigo.getCodtipocodigo()) != null) {
                throw new PreexistingEntityException("Tipocodigo " + tipocodigo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipocodigo tipocodigo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipocodigo = em.merge(tipocodigo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tipocodigo.getCodtipocodigo();
                if (findTipocodigo(id) == null) {
                    throw new NonexistentEntityException("The tipocodigo with id " + id + " no longer exists.");
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
            Tipocodigo tipocodigo;
            try {
                tipocodigo = em.getReference(Tipocodigo.class, id);
                tipocodigo.getCodtipocodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipocodigo with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipocodigo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipocodigo> findTipocodigoEntities() {
        return findTipocodigoEntities(true, -1, -1);
    }

    public List<Tipocodigo> findTipocodigoEntities(int maxResults, int firstResult) {
        return findTipocodigoEntities(false, maxResults, firstResult);
    }

    private List<Tipocodigo> findTipocodigoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipocodigo.class));
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

    public Tipocodigo findTipocodigo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipocodigo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipocodigoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipocodigo> rt = cq.from(Tipocodigo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

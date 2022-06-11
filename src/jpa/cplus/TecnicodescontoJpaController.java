/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Tecnicodesconto;
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
public class TecnicodescontoJpaController implements Serializable {

    public TecnicodescontoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tecnicodesconto tecnicodesconto) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tecnicodesconto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTecnicodesconto(tecnicodesconto.getCodtecnicodesconto()) != null) {
                throw new PreexistingEntityException("Tecnicodesconto " + tecnicodesconto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tecnicodesconto tecnicodesconto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tecnicodesconto = em.merge(tecnicodesconto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tecnicodesconto.getCodtecnicodesconto();
                if (findTecnicodesconto(id) == null) {
                    throw new NonexistentEntityException("The tecnicodesconto with id " + id + " no longer exists.");
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
            Tecnicodesconto tecnicodesconto;
            try {
                tecnicodesconto = em.getReference(Tecnicodesconto.class, id);
                tecnicodesconto.getCodtecnicodesconto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tecnicodesconto with id " + id + " no longer exists.", enfe);
            }
            em.remove(tecnicodesconto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tecnicodesconto> findTecnicodescontoEntities() {
        return findTecnicodescontoEntities(true, -1, -1);
    }

    public List<Tecnicodesconto> findTecnicodescontoEntities(int maxResults, int firstResult) {
        return findTecnicodescontoEntities(false, maxResults, firstResult);
    }

    private List<Tecnicodesconto> findTecnicodescontoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tecnicodesconto.class));
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

    public Tecnicodesconto findTecnicodesconto(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tecnicodesconto.class, id);
        } finally {
            em.close();
        }
    }

    public int getTecnicodescontoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tecnicodesconto> rt = cq.from(Tecnicodesconto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

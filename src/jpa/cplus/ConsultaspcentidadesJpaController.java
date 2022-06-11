/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Consultaspcentidades;
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
public class ConsultaspcentidadesJpaController implements Serializable {

    public ConsultaspcentidadesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Consultaspcentidades consultaspcentidades) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(consultaspcentidades);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConsultaspcentidades(consultaspcentidades.getCodentidades()) != null) {
                throw new PreexistingEntityException("Consultaspcentidades " + consultaspcentidades + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Consultaspcentidades consultaspcentidades) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            consultaspcentidades = em.merge(consultaspcentidades);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = consultaspcentidades.getCodentidades();
                if (findConsultaspcentidades(id) == null) {
                    throw new NonexistentEntityException("The consultaspcentidades with id " + id + " no longer exists.");
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
            Consultaspcentidades consultaspcentidades;
            try {
                consultaspcentidades = em.getReference(Consultaspcentidades.class, id);
                consultaspcentidades.getCodentidades();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The consultaspcentidades with id " + id + " no longer exists.", enfe);
            }
            em.remove(consultaspcentidades);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Consultaspcentidades> findConsultaspcentidadesEntities() {
        return findConsultaspcentidadesEntities(true, -1, -1);
    }

    public List<Consultaspcentidades> findConsultaspcentidadesEntities(int maxResults, int firstResult) {
        return findConsultaspcentidadesEntities(false, maxResults, firstResult);
    }

    private List<Consultaspcentidades> findConsultaspcentidadesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Consultaspcentidades.class));
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

    public Consultaspcentidades findConsultaspcentidades(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Consultaspcentidades.class, id);
        } finally {
            em.close();
        }
    }

    public int getConsultaspcentidadesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Consultaspcentidades> rt = cq.from(Consultaspcentidades.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

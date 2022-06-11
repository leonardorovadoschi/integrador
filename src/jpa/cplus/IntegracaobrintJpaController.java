/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Integracaobrint;
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
public class IntegracaobrintJpaController implements Serializable {

    public IntegracaobrintJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Integracaobrint integracaobrint) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(integracaobrint);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findIntegracaobrint(integracaobrint.getCodintegracao()) != null) {
                throw new PreexistingEntityException("Integracaobrint " + integracaobrint + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Integracaobrint integracaobrint) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            integracaobrint = em.merge(integracaobrint);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = integracaobrint.getCodintegracao();
                if (findIntegracaobrint(id) == null) {
                    throw new NonexistentEntityException("The integracaobrint with id " + id + " no longer exists.");
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
            Integracaobrint integracaobrint;
            try {
                integracaobrint = em.getReference(Integracaobrint.class, id);
                integracaobrint.getCodintegracao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The integracaobrint with id " + id + " no longer exists.", enfe);
            }
            em.remove(integracaobrint);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Integracaobrint> findIntegracaobrintEntities() {
        return findIntegracaobrintEntities(true, -1, -1);
    }

    public List<Integracaobrint> findIntegracaobrintEntities(int maxResults, int firstResult) {
        return findIntegracaobrintEntities(false, maxResults, firstResult);
    }

    private List<Integracaobrint> findIntegracaobrintEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Integracaobrint.class));
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

    public Integracaobrint findIntegracaobrint(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Integracaobrint.class, id);
        } finally {
            em.close();
        }
    }

    public int getIntegracaobrintCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Integracaobrint> rt = cq.from(Integracaobrint.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

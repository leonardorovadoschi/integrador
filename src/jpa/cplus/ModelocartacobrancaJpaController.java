/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Modelocartacobranca;
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
public class ModelocartacobrancaJpaController implements Serializable {

    public ModelocartacobrancaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Modelocartacobranca modelocartacobranca) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(modelocartacobranca);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findModelocartacobranca(modelocartacobranca.getCodmodelocartacobranca()) != null) {
                throw new PreexistingEntityException("Modelocartacobranca " + modelocartacobranca + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Modelocartacobranca modelocartacobranca) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            modelocartacobranca = em.merge(modelocartacobranca);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = modelocartacobranca.getCodmodelocartacobranca();
                if (findModelocartacobranca(id) == null) {
                    throw new NonexistentEntityException("The modelocartacobranca with id " + id + " no longer exists.");
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
            Modelocartacobranca modelocartacobranca;
            try {
                modelocartacobranca = em.getReference(Modelocartacobranca.class, id);
                modelocartacobranca.getCodmodelocartacobranca();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The modelocartacobranca with id " + id + " no longer exists.", enfe);
            }
            em.remove(modelocartacobranca);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Modelocartacobranca> findModelocartacobrancaEntities() {
        return findModelocartacobrancaEntities(true, -1, -1);
    }

    public List<Modelocartacobranca> findModelocartacobrancaEntities(int maxResults, int firstResult) {
        return findModelocartacobrancaEntities(false, maxResults, firstResult);
    }

    private List<Modelocartacobranca> findModelocartacobrancaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Modelocartacobranca.class));
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

    public Modelocartacobranca findModelocartacobranca(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Modelocartacobranca.class, id);
        } finally {
            em.close();
        }
    }

    public int getModelocartacobrancaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Modelocartacobranca> rt = cq.from(Modelocartacobranca.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

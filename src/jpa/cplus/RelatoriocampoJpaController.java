/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Relatoriocampo;
import entidade.cplus.RelatoriocampoPK;
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
public class RelatoriocampoJpaController implements Serializable {

    public RelatoriocampoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Relatoriocampo relatoriocampo) throws PreexistingEntityException, Exception {
        if (relatoriocampo.getRelatoriocampoPK() == null) {
            relatoriocampo.setRelatoriocampoPK(new RelatoriocampoPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(relatoriocampo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRelatoriocampo(relatoriocampo.getRelatoriocampoPK()) != null) {
                throw new PreexistingEntityException("Relatoriocampo " + relatoriocampo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Relatoriocampo relatoriocampo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            relatoriocampo = em.merge(relatoriocampo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                RelatoriocampoPK id = relatoriocampo.getRelatoriocampoPK();
                if (findRelatoriocampo(id) == null) {
                    throw new NonexistentEntityException("The relatoriocampo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(RelatoriocampoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Relatoriocampo relatoriocampo;
            try {
                relatoriocampo = em.getReference(Relatoriocampo.class, id);
                relatoriocampo.getRelatoriocampoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The relatoriocampo with id " + id + " no longer exists.", enfe);
            }
            em.remove(relatoriocampo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Relatoriocampo> findRelatoriocampoEntities() {
        return findRelatoriocampoEntities(true, -1, -1);
    }

    public List<Relatoriocampo> findRelatoriocampoEntities(int maxResults, int firstResult) {
        return findRelatoriocampoEntities(false, maxResults, firstResult);
    }

    private List<Relatoriocampo> findRelatoriocampoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Relatoriocampo.class));
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

    public Relatoriocampo findRelatoriocampo(RelatoriocampoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Relatoriocampo.class, id);
        } finally {
            em.close();
        }
    }

    public int getRelatoriocampoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Relatoriocampo> rt = cq.from(Relatoriocampo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

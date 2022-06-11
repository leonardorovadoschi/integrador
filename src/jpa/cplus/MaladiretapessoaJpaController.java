/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Maladiretapessoa;
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
public class MaladiretapessoaJpaController implements Serializable {

    public MaladiretapessoaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Maladiretapessoa maladiretapessoa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(maladiretapessoa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMaladiretapessoa(maladiretapessoa.getCodmaladiretapessoa()) != null) {
                throw new PreexistingEntityException("Maladiretapessoa " + maladiretapessoa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Maladiretapessoa maladiretapessoa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            maladiretapessoa = em.merge(maladiretapessoa);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = maladiretapessoa.getCodmaladiretapessoa();
                if (findMaladiretapessoa(id) == null) {
                    throw new NonexistentEntityException("The maladiretapessoa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Maladiretapessoa maladiretapessoa;
            try {
                maladiretapessoa = em.getReference(Maladiretapessoa.class, id);
                maladiretapessoa.getCodmaladiretapessoa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The maladiretapessoa with id " + id + " no longer exists.", enfe);
            }
            em.remove(maladiretapessoa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Maladiretapessoa> findMaladiretapessoaEntities() {
        return findMaladiretapessoaEntities(true, -1, -1);
    }

    public List<Maladiretapessoa> findMaladiretapessoaEntities(int maxResults, int firstResult) {
        return findMaladiretapessoaEntities(false, maxResults, firstResult);
    }

    private List<Maladiretapessoa> findMaladiretapessoaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Maladiretapessoa.class));
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

    public Maladiretapessoa findMaladiretapessoa(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Maladiretapessoa.class, id);
        } finally {
            em.close();
        }
    }

    public int getMaladiretapessoaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Maladiretapessoa> rt = cq.from(Maladiretapessoa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

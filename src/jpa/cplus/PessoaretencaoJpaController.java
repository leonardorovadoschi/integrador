/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Pessoaretencao;
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
public class PessoaretencaoJpaController implements Serializable {

    public PessoaretencaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pessoaretencao pessoaretencao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pessoaretencao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPessoaretencao(pessoaretencao.getCodpessoaretencao()) != null) {
                throw new PreexistingEntityException("Pessoaretencao " + pessoaretencao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pessoaretencao pessoaretencao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pessoaretencao = em.merge(pessoaretencao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = pessoaretencao.getCodpessoaretencao();
                if (findPessoaretencao(id) == null) {
                    throw new NonexistentEntityException("The pessoaretencao with id " + id + " no longer exists.");
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
            Pessoaretencao pessoaretencao;
            try {
                pessoaretencao = em.getReference(Pessoaretencao.class, id);
                pessoaretencao.getCodpessoaretencao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pessoaretencao with id " + id + " no longer exists.", enfe);
            }
            em.remove(pessoaretencao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pessoaretencao> findPessoaretencaoEntities() {
        return findPessoaretencaoEntities(true, -1, -1);
    }

    public List<Pessoaretencao> findPessoaretencaoEntities(int maxResults, int firstResult) {
        return findPessoaretencaoEntities(false, maxResults, firstResult);
    }

    private List<Pessoaretencao> findPessoaretencaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pessoaretencao.class));
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

    public Pessoaretencao findPessoaretencao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pessoaretencao.class, id);
        } finally {
            em.close();
        }
    }

    public int getPessoaretencaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pessoaretencao> rt = cq.from(Pessoaretencao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

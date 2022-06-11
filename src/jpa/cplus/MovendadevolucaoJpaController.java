/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Movendadevolucao;
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
public class MovendadevolucaoJpaController implements Serializable {

    public MovendadevolucaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movendadevolucao movendadevolucao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(movendadevolucao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovendadevolucao(movendadevolucao.getCodmovendadevolucao()) != null) {
                throw new PreexistingEntityException("Movendadevolucao " + movendadevolucao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movendadevolucao movendadevolucao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            movendadevolucao = em.merge(movendadevolucao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = movendadevolucao.getCodmovendadevolucao();
                if (findMovendadevolucao(id) == null) {
                    throw new NonexistentEntityException("The movendadevolucao with id " + id + " no longer exists.");
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
            Movendadevolucao movendadevolucao;
            try {
                movendadevolucao = em.getReference(Movendadevolucao.class, id);
                movendadevolucao.getCodmovendadevolucao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movendadevolucao with id " + id + " no longer exists.", enfe);
            }
            em.remove(movendadevolucao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movendadevolucao> findMovendadevolucaoEntities() {
        return findMovendadevolucaoEntities(true, -1, -1);
    }

    public List<Movendadevolucao> findMovendadevolucaoEntities(int maxResults, int firstResult) {
        return findMovendadevolucaoEntities(false, maxResults, firstResult);
    }

    private List<Movendadevolucao> findMovendadevolucaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movendadevolucao.class));
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

    public Movendadevolucao findMovendadevolucao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movendadevolucao.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovendadevolucaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movendadevolucao> rt = cq.from(Movendadevolucao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

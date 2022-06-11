/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Credenciadascartao;
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
public class CredenciadascartaoJpaController implements Serializable {

    public CredenciadascartaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Credenciadascartao credenciadascartao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(credenciadascartao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCredenciadascartao(credenciadascartao.getCodcredenciadascartao()) != null) {
                throw new PreexistingEntityException("Credenciadascartao " + credenciadascartao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Credenciadascartao credenciadascartao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            credenciadascartao = em.merge(credenciadascartao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = credenciadascartao.getCodcredenciadascartao();
                if (findCredenciadascartao(id) == null) {
                    throw new NonexistentEntityException("The credenciadascartao with id " + id + " no longer exists.");
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
            Credenciadascartao credenciadascartao;
            try {
                credenciadascartao = em.getReference(Credenciadascartao.class, id);
                credenciadascartao.getCodcredenciadascartao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The credenciadascartao with id " + id + " no longer exists.", enfe);
            }
            em.remove(credenciadascartao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Credenciadascartao> findCredenciadascartaoEntities() {
        return findCredenciadascartaoEntities(true, -1, -1);
    }

    public List<Credenciadascartao> findCredenciadascartaoEntities(int maxResults, int firstResult) {
        return findCredenciadascartaoEntities(false, maxResults, firstResult);
    }

    private List<Credenciadascartao> findCredenciadascartaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Credenciadascartao.class));
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

    public Credenciadascartao findCredenciadascartao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Credenciadascartao.class, id);
        } finally {
            em.close();
        }
    }

    public int getCredenciadascartaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Credenciadascartao> rt = cq.from(Credenciadascartao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

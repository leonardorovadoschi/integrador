/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Afvsincronizacao;
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
public class AfvsincronizacaoJpaController implements Serializable {

    public AfvsincronizacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Afvsincronizacao afvsincronizacao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(afvsincronizacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAfvsincronizacao(afvsincronizacao.getId()) != null) {
                throw new PreexistingEntityException("Afvsincronizacao " + afvsincronizacao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Afvsincronizacao afvsincronizacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            afvsincronizacao = em.merge(afvsincronizacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = afvsincronizacao.getId();
                if (findAfvsincronizacao(id) == null) {
                    throw new NonexistentEntityException("The afvsincronizacao with id " + id + " no longer exists.");
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
            Afvsincronizacao afvsincronizacao;
            try {
                afvsincronizacao = em.getReference(Afvsincronizacao.class, id);
                afvsincronizacao.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The afvsincronizacao with id " + id + " no longer exists.", enfe);
            }
            em.remove(afvsincronizacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Afvsincronizacao> findAfvsincronizacaoEntities() {
        return findAfvsincronizacaoEntities(true, -1, -1);
    }

    public List<Afvsincronizacao> findAfvsincronizacaoEntities(int maxResults, int firstResult) {
        return findAfvsincronizacaoEntities(false, maxResults, firstResult);
    }

    private List<Afvsincronizacao> findAfvsincronizacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Afvsincronizacao.class));
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

    public Afvsincronizacao findAfvsincronizacao(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Afvsincronizacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getAfvsincronizacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Afvsincronizacao> rt = cq.from(Afvsincronizacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

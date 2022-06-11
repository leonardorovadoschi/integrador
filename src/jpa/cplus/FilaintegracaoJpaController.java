/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Filaintegracao;
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
public class FilaintegracaoJpaController implements Serializable {

    public FilaintegracaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Filaintegracao filaintegracao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(filaintegracao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFilaintegracao(filaintegracao.getId()) != null) {
                throw new PreexistingEntityException("Filaintegracao " + filaintegracao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Filaintegracao filaintegracao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            filaintegracao = em.merge(filaintegracao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = filaintegracao.getId();
                if (findFilaintegracao(id) == null) {
                    throw new NonexistentEntityException("The filaintegracao with id " + id + " no longer exists.");
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
            Filaintegracao filaintegracao;
            try {
                filaintegracao = em.getReference(Filaintegracao.class, id);
                filaintegracao.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The filaintegracao with id " + id + " no longer exists.", enfe);
            }
            em.remove(filaintegracao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Filaintegracao> findFilaintegracaoEntities() {
        return findFilaintegracaoEntities(true, -1, -1);
    }

    public List<Filaintegracao> findFilaintegracaoEntities(int maxResults, int firstResult) {
        return findFilaintegracaoEntities(false, maxResults, firstResult);
    }

    private List<Filaintegracao> findFilaintegracaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Filaintegracao.class));
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

    public Filaintegracao findFilaintegracao(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Filaintegracao.class, id);
        } finally {
            em.close();
        }
    }

    public int getFilaintegracaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Filaintegracao> rt = cq.from(Filaintegracao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

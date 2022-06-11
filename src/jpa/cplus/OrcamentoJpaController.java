/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Orcamento;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.IllegalOrphanException;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class OrcamentoJpaController implements Serializable {

    public OrcamentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Orcamento orcamento) throws PreexistingEntityException, Exception {
        
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
            em.persist(orcamento);
            
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrcamento(orcamento.getCodorc()) != null) {
                throw new PreexistingEntityException("Orcamento " + orcamento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Orcamento orcamento) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
           
            em.merge(orcamento);
            
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = orcamento.getCodorc();
                if (findOrcamento(id) == null) {
                    throw new NonexistentEntityException("The orcamento with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Orcamento orcamento;
            try {
                orcamento = em.getReference(Orcamento.class, id);
                orcamento.getCodorc();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The orcamento with id " + id + " no longer exists.", enfe);
            }
           
            em.remove(orcamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Orcamento> findOrcamentoEntities() {
        return findOrcamentoEntities(true, -1, -1);
    }

    public List<Orcamento> findOrcamentoEntities(int maxResults, int firstResult) {
        return findOrcamentoEntities(false, maxResults, firstResult);
    }

    private List<Orcamento> findOrcamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Orcamento.class));
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

    public Orcamento findOrcamento(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Orcamento.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrcamentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Orcamento> rt = cq.from(Orcamento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

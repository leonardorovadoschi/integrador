/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.OsLocalequipamento;
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
public class OsLocalequipamentoJpaController implements Serializable {

    public OsLocalequipamentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OsLocalequipamento osLocalequipamento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(osLocalequipamento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOsLocalequipamento(osLocalequipamento.getCodle()) != null) {
                throw new PreexistingEntityException("OsLocalequipamento " + osLocalequipamento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OsLocalequipamento osLocalequipamento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            osLocalequipamento = em.merge(osLocalequipamento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = osLocalequipamento.getCodle();
                if (findOsLocalequipamento(id) == null) {
                    throw new NonexistentEntityException("The osLocalequipamento with id " + id + " no longer exists.");
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
            OsLocalequipamento osLocalequipamento;
            try {
                osLocalequipamento = em.getReference(OsLocalequipamento.class, id);
                osLocalequipamento.getCodle();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The osLocalequipamento with id " + id + " no longer exists.", enfe);
            }
            em.remove(osLocalequipamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OsLocalequipamento> findOsLocalequipamentoEntities() {
        return findOsLocalequipamentoEntities(true, -1, -1);
    }

    public List<OsLocalequipamento> findOsLocalequipamentoEntities(int maxResults, int firstResult) {
        return findOsLocalequipamentoEntities(false, maxResults, firstResult);
    }

    private List<OsLocalequipamento> findOsLocalequipamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OsLocalequipamento.class));
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

    public OsLocalequipamento findOsLocalequipamento(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OsLocalequipamento.class, id);
        } finally {
            em.close();
        }
    }

    public int getOsLocalequipamentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OsLocalequipamento> rt = cq.from(OsLocalequipamento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

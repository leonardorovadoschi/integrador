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
import entidade.cplus.Sistema;
import entidade.cplus.Sistemaacesso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class SistemaacessoJpaController implements Serializable {

    public SistemaacessoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sistemaacesso sistemaacesso) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sistema codsistema = sistemaacesso.getCodsistema();
            if (codsistema != null) {
                codsistema = em.getReference(codsistema.getClass(), codsistema.getCodsistema());
                sistemaacesso.setCodsistema(codsistema);
            }
            em.persist(sistemaacesso);
            if (codsistema != null) {
                codsistema.getSistemaacessoCollection().add(sistemaacesso);
                codsistema = em.merge(codsistema);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSistemaacesso(sistemaacesso.getCodsistemaacesso()) != null) {
                throw new PreexistingEntityException("Sistemaacesso " + sistemaacesso + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sistemaacesso sistemaacesso) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sistemaacesso persistentSistemaacesso = em.find(Sistemaacesso.class, sistemaacesso.getCodsistemaacesso());
            Sistema codsistemaOld = persistentSistemaacesso.getCodsistema();
            Sistema codsistemaNew = sistemaacesso.getCodsistema();
            if (codsistemaNew != null) {
                codsistemaNew = em.getReference(codsistemaNew.getClass(), codsistemaNew.getCodsistema());
                sistemaacesso.setCodsistema(codsistemaNew);
            }
            sistemaacesso = em.merge(sistemaacesso);
            if (codsistemaOld != null && !codsistemaOld.equals(codsistemaNew)) {
                codsistemaOld.getSistemaacessoCollection().remove(sistemaacesso);
                codsistemaOld = em.merge(codsistemaOld);
            }
            if (codsistemaNew != null && !codsistemaNew.equals(codsistemaOld)) {
                codsistemaNew.getSistemaacessoCollection().add(sistemaacesso);
                codsistemaNew = em.merge(codsistemaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = sistemaacesso.getCodsistemaacesso();
                if (findSistemaacesso(id) == null) {
                    throw new NonexistentEntityException("The sistemaacesso with id " + id + " no longer exists.");
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
            Sistemaacesso sistemaacesso;
            try {
                sistemaacesso = em.getReference(Sistemaacesso.class, id);
                sistemaacesso.getCodsistemaacesso();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sistemaacesso with id " + id + " no longer exists.", enfe);
            }
            Sistema codsistema = sistemaacesso.getCodsistema();
            if (codsistema != null) {
                codsistema.getSistemaacessoCollection().remove(sistemaacesso);
                codsistema = em.merge(codsistema);
            }
            em.remove(sistemaacesso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sistemaacesso> findSistemaacessoEntities() {
        return findSistemaacessoEntities(true, -1, -1);
    }

    public List<Sistemaacesso> findSistemaacessoEntities(int maxResults, int firstResult) {
        return findSistemaacessoEntities(false, maxResults, firstResult);
    }

    private List<Sistemaacesso> findSistemaacessoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sistemaacesso.class));
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

    public Sistemaacesso findSistemaacesso(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sistemaacesso.class, id);
        } finally {
            em.close();
        }
    }

    public int getSistemaacessoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sistemaacesso> rt = cq.from(Sistemaacesso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

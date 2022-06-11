/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Cfgcenariogrid;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Sistema;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class CfgcenariogridJpaController implements Serializable {

    public CfgcenariogridJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cfgcenariogrid cfgcenariogrid) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sistema codsistema = cfgcenariogrid.getCodsistema();
            if (codsistema != null) {
                codsistema = em.getReference(codsistema.getClass(), codsistema.getCodsistema());
                cfgcenariogrid.setCodsistema(codsistema);
            }
            em.persist(cfgcenariogrid);
            if (codsistema != null) {
                codsistema.getCfgcenariogridCollection().add(cfgcenariogrid);
                codsistema = em.merge(codsistema);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCfgcenariogrid(cfgcenariogrid.getCodcfgcenariogrid()) != null) {
                throw new PreexistingEntityException("Cfgcenariogrid " + cfgcenariogrid + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cfgcenariogrid cfgcenariogrid) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cfgcenariogrid persistentCfgcenariogrid = em.find(Cfgcenariogrid.class, cfgcenariogrid.getCodcfgcenariogrid());
            Sistema codsistemaOld = persistentCfgcenariogrid.getCodsistema();
            Sistema codsistemaNew = cfgcenariogrid.getCodsistema();
            if (codsistemaNew != null) {
                codsistemaNew = em.getReference(codsistemaNew.getClass(), codsistemaNew.getCodsistema());
                cfgcenariogrid.setCodsistema(codsistemaNew);
            }
            cfgcenariogrid = em.merge(cfgcenariogrid);
            if (codsistemaOld != null && !codsistemaOld.equals(codsistemaNew)) {
                codsistemaOld.getCfgcenariogridCollection().remove(cfgcenariogrid);
                codsistemaOld = em.merge(codsistemaOld);
            }
            if (codsistemaNew != null && !codsistemaNew.equals(codsistemaOld)) {
                codsistemaNew.getCfgcenariogridCollection().add(cfgcenariogrid);
                codsistemaNew = em.merge(codsistemaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cfgcenariogrid.getCodcfgcenariogrid();
                if (findCfgcenariogrid(id) == null) {
                    throw new NonexistentEntityException("The cfgcenariogrid with id " + id + " no longer exists.");
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
            Cfgcenariogrid cfgcenariogrid;
            try {
                cfgcenariogrid = em.getReference(Cfgcenariogrid.class, id);
                cfgcenariogrid.getCodcfgcenariogrid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cfgcenariogrid with id " + id + " no longer exists.", enfe);
            }
            Sistema codsistema = cfgcenariogrid.getCodsistema();
            if (codsistema != null) {
                codsistema.getCfgcenariogridCollection().remove(cfgcenariogrid);
                codsistema = em.merge(codsistema);
            }
            em.remove(cfgcenariogrid);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cfgcenariogrid> findCfgcenariogridEntities() {
        return findCfgcenariogridEntities(true, -1, -1);
    }

    public List<Cfgcenariogrid> findCfgcenariogridEntities(int maxResults, int firstResult) {
        return findCfgcenariogridEntities(false, maxResults, firstResult);
    }

    private List<Cfgcenariogrid> findCfgcenariogridEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cfgcenariogrid.class));
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

    public Cfgcenariogrid findCfgcenariogrid(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cfgcenariogrid.class, id);
        } finally {
            em.close();
        }
    }

    public int getCfgcenariogridCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cfgcenariogrid> rt = cq.from(Cfgcenariogrid.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

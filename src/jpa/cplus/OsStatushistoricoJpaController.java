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
import entidade.cplus.OsOrdemservico;
import entidade.cplus.OsStatus;
import entidade.cplus.OsStatushistorico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class OsStatushistoricoJpaController implements Serializable {

    public OsStatushistoricoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OsStatushistorico osStatushistorico) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsOrdemservico codos = osStatushistorico.getCodos();
            if (codos != null) {
                codos = em.getReference(codos.getClass(), codos.getCodos());
                osStatushistorico.setCodos(codos);
            }
            OsStatus codstatus = osStatushistorico.getCodstatus();
            if (codstatus != null) {
                codstatus = em.getReference(codstatus.getClass(), codstatus.getCodstatus());
                osStatushistorico.setCodstatus(codstatus);
            }
            em.persist(osStatushistorico);
            if (codos != null) {
                codos.getOsStatushistoricoCollection().add(osStatushistorico);
                codos = em.merge(codos);
            }
            if (codstatus != null) {
                codstatus.getOsStatushistoricoCollection().add(osStatushistorico);
                codstatus = em.merge(codstatus);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOsStatushistorico(osStatushistorico.getCodstatushistorico()) != null) {
                throw new PreexistingEntityException("OsStatushistorico " + osStatushistorico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OsStatushistorico osStatushistorico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsStatushistorico persistentOsStatushistorico = em.find(OsStatushistorico.class, osStatushistorico.getCodstatushistorico());
            OsOrdemservico codosOld = persistentOsStatushistorico.getCodos();
            OsOrdemservico codosNew = osStatushistorico.getCodos();
            OsStatus codstatusOld = persistentOsStatushistorico.getCodstatus();
            OsStatus codstatusNew = osStatushistorico.getCodstatus();
            if (codosNew != null) {
                codosNew = em.getReference(codosNew.getClass(), codosNew.getCodos());
                osStatushistorico.setCodos(codosNew);
            }
            if (codstatusNew != null) {
                codstatusNew = em.getReference(codstatusNew.getClass(), codstatusNew.getCodstatus());
                osStatushistorico.setCodstatus(codstatusNew);
            }
            osStatushistorico = em.merge(osStatushistorico);
            if (codosOld != null && !codosOld.equals(codosNew)) {
                codosOld.getOsStatushistoricoCollection().remove(osStatushistorico);
                codosOld = em.merge(codosOld);
            }
            if (codosNew != null && !codosNew.equals(codosOld)) {
                codosNew.getOsStatushistoricoCollection().add(osStatushistorico);
                codosNew = em.merge(codosNew);
            }
            if (codstatusOld != null && !codstatusOld.equals(codstatusNew)) {
                codstatusOld.getOsStatushistoricoCollection().remove(osStatushistorico);
                codstatusOld = em.merge(codstatusOld);
            }
            if (codstatusNew != null && !codstatusNew.equals(codstatusOld)) {
                codstatusNew.getOsStatushistoricoCollection().add(osStatushistorico);
                codstatusNew = em.merge(codstatusNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = osStatushistorico.getCodstatushistorico();
                if (findOsStatushistorico(id) == null) {
                    throw new NonexistentEntityException("The osStatushistorico with id " + id + " no longer exists.");
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
            OsStatushistorico osStatushistorico;
            try {
                osStatushistorico = em.getReference(OsStatushistorico.class, id);
                osStatushistorico.getCodstatushistorico();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The osStatushistorico with id " + id + " no longer exists.", enfe);
            }
            OsOrdemservico codos = osStatushistorico.getCodos();
            if (codos != null) {
                codos.getOsStatushistoricoCollection().remove(osStatushistorico);
                codos = em.merge(codos);
            }
            OsStatus codstatus = osStatushistorico.getCodstatus();
            if (codstatus != null) {
                codstatus.getOsStatushistoricoCollection().remove(osStatushistorico);
                codstatus = em.merge(codstatus);
            }
            em.remove(osStatushistorico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OsStatushistorico> findOsStatushistoricoEntities() {
        return findOsStatushistoricoEntities(true, -1, -1);
    }

    public List<OsStatushistorico> findOsStatushistoricoEntities(int maxResults, int firstResult) {
        return findOsStatushistoricoEntities(false, maxResults, firstResult);
    }

    private List<OsStatushistorico> findOsStatushistoricoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OsStatushistorico.class));
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

    public OsStatushistorico findOsStatushistorico(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OsStatushistorico.class, id);
        } finally {
            em.close();
        }
    }

    public int getOsStatushistoricoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OsStatushistorico> rt = cq.from(OsStatushistorico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

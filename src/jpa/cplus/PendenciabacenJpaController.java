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
import entidade.cplus.Consultaserasa;
import entidade.cplus.Pendenciabacen;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class PendenciabacenJpaController implements Serializable {

    public PendenciabacenJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pendenciabacen pendenciabacen) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consultaserasa codconsultaserasa = pendenciabacen.getCodconsultaserasa();
            if (codconsultaserasa != null) {
                codconsultaserasa = em.getReference(codconsultaserasa.getClass(), codconsultaserasa.getCodconsultaserasa());
                pendenciabacen.setCodconsultaserasa(codconsultaserasa);
            }
            em.persist(pendenciabacen);
            if (codconsultaserasa != null) {
                codconsultaserasa.getPendenciabacenCollection().add(pendenciabacen);
                codconsultaserasa = em.merge(codconsultaserasa);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPendenciabacen(pendenciabacen.getCodpendenciabacen()) != null) {
                throw new PreexistingEntityException("Pendenciabacen " + pendenciabacen + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pendenciabacen pendenciabacen) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pendenciabacen persistentPendenciabacen = em.find(Pendenciabacen.class, pendenciabacen.getCodpendenciabacen());
            Consultaserasa codconsultaserasaOld = persistentPendenciabacen.getCodconsultaserasa();
            Consultaserasa codconsultaserasaNew = pendenciabacen.getCodconsultaserasa();
            if (codconsultaserasaNew != null) {
                codconsultaserasaNew = em.getReference(codconsultaserasaNew.getClass(), codconsultaserasaNew.getCodconsultaserasa());
                pendenciabacen.setCodconsultaserasa(codconsultaserasaNew);
            }
            pendenciabacen = em.merge(pendenciabacen);
            if (codconsultaserasaOld != null && !codconsultaserasaOld.equals(codconsultaserasaNew)) {
                codconsultaserasaOld.getPendenciabacenCollection().remove(pendenciabacen);
                codconsultaserasaOld = em.merge(codconsultaserasaOld);
            }
            if (codconsultaserasaNew != null && !codconsultaserasaNew.equals(codconsultaserasaOld)) {
                codconsultaserasaNew.getPendenciabacenCollection().add(pendenciabacen);
                codconsultaserasaNew = em.merge(codconsultaserasaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = pendenciabacen.getCodpendenciabacen();
                if (findPendenciabacen(id) == null) {
                    throw new NonexistentEntityException("The pendenciabacen with id " + id + " no longer exists.");
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
            Pendenciabacen pendenciabacen;
            try {
                pendenciabacen = em.getReference(Pendenciabacen.class, id);
                pendenciabacen.getCodpendenciabacen();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pendenciabacen with id " + id + " no longer exists.", enfe);
            }
            Consultaserasa codconsultaserasa = pendenciabacen.getCodconsultaserasa();
            if (codconsultaserasa != null) {
                codconsultaserasa.getPendenciabacenCollection().remove(pendenciabacen);
                codconsultaserasa = em.merge(codconsultaserasa);
            }
            em.remove(pendenciabacen);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pendenciabacen> findPendenciabacenEntities() {
        return findPendenciabacenEntities(true, -1, -1);
    }

    public List<Pendenciabacen> findPendenciabacenEntities(int maxResults, int firstResult) {
        return findPendenciabacenEntities(false, maxResults, firstResult);
    }

    private List<Pendenciabacen> findPendenciabacenEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pendenciabacen.class));
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

    public Pendenciabacen findPendenciabacen(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pendenciabacen.class, id);
        } finally {
            em.close();
        }
    }

    public int getPendenciabacenCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pendenciabacen> rt = cq.from(Pendenciabacen.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

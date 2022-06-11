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
import entidade.cplus.Pendenciasinternas;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class PendenciasinternasJpaController implements Serializable {

    public PendenciasinternasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pendenciasinternas pendenciasinternas) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consultaserasa codconsultaserasa = pendenciasinternas.getCodconsultaserasa();
            if (codconsultaserasa != null) {
                codconsultaserasa = em.getReference(codconsultaserasa.getClass(), codconsultaserasa.getCodconsultaserasa());
                pendenciasinternas.setCodconsultaserasa(codconsultaserasa);
            }
            em.persist(pendenciasinternas);
            if (codconsultaserasa != null) {
                codconsultaserasa.getPendenciasinternasCollection().add(pendenciasinternas);
                codconsultaserasa = em.merge(codconsultaserasa);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPendenciasinternas(pendenciasinternas.getCodpendenciainternas()) != null) {
                throw new PreexistingEntityException("Pendenciasinternas " + pendenciasinternas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pendenciasinternas pendenciasinternas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pendenciasinternas persistentPendenciasinternas = em.find(Pendenciasinternas.class, pendenciasinternas.getCodpendenciainternas());
            Consultaserasa codconsultaserasaOld = persistentPendenciasinternas.getCodconsultaserasa();
            Consultaserasa codconsultaserasaNew = pendenciasinternas.getCodconsultaserasa();
            if (codconsultaserasaNew != null) {
                codconsultaserasaNew = em.getReference(codconsultaserasaNew.getClass(), codconsultaserasaNew.getCodconsultaserasa());
                pendenciasinternas.setCodconsultaserasa(codconsultaserasaNew);
            }
            pendenciasinternas = em.merge(pendenciasinternas);
            if (codconsultaserasaOld != null && !codconsultaserasaOld.equals(codconsultaserasaNew)) {
                codconsultaserasaOld.getPendenciasinternasCollection().remove(pendenciasinternas);
                codconsultaserasaOld = em.merge(codconsultaserasaOld);
            }
            if (codconsultaserasaNew != null && !codconsultaserasaNew.equals(codconsultaserasaOld)) {
                codconsultaserasaNew.getPendenciasinternasCollection().add(pendenciasinternas);
                codconsultaserasaNew = em.merge(codconsultaserasaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = pendenciasinternas.getCodpendenciainternas();
                if (findPendenciasinternas(id) == null) {
                    throw new NonexistentEntityException("The pendenciasinternas with id " + id + " no longer exists.");
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
            Pendenciasinternas pendenciasinternas;
            try {
                pendenciasinternas = em.getReference(Pendenciasinternas.class, id);
                pendenciasinternas.getCodpendenciainternas();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pendenciasinternas with id " + id + " no longer exists.", enfe);
            }
            Consultaserasa codconsultaserasa = pendenciasinternas.getCodconsultaserasa();
            if (codconsultaserasa != null) {
                codconsultaserasa.getPendenciasinternasCollection().remove(pendenciasinternas);
                codconsultaserasa = em.merge(codconsultaserasa);
            }
            em.remove(pendenciasinternas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pendenciasinternas> findPendenciasinternasEntities() {
        return findPendenciasinternasEntities(true, -1, -1);
    }

    public List<Pendenciasinternas> findPendenciasinternasEntities(int maxResults, int firstResult) {
        return findPendenciasinternasEntities(false, maxResults, firstResult);
    }

    private List<Pendenciasinternas> findPendenciasinternasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pendenciasinternas.class));
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

    public Pendenciasinternas findPendenciasinternas(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pendenciasinternas.class, id);
        } finally {
            em.close();
        }
    }

    public int getPendenciasinternasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pendenciasinternas> rt = cq.from(Pendenciasinternas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

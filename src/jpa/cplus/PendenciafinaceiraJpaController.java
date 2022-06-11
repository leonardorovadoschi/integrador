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
import entidade.cplus.Pendenciafinaceira;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class PendenciafinaceiraJpaController implements Serializable {

    public PendenciafinaceiraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pendenciafinaceira pendenciafinaceira) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consultaserasa codconsultaserasa = pendenciafinaceira.getCodconsultaserasa();
            if (codconsultaserasa != null) {
                codconsultaserasa = em.getReference(codconsultaserasa.getClass(), codconsultaserasa.getCodconsultaserasa());
                pendenciafinaceira.setCodconsultaserasa(codconsultaserasa);
            }
            em.persist(pendenciafinaceira);
            if (codconsultaserasa != null) {
                codconsultaserasa.getPendenciafinaceiraCollection().add(pendenciafinaceira);
                codconsultaserasa = em.merge(codconsultaserasa);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPendenciafinaceira(pendenciafinaceira.getCodpendenciafinaceira()) != null) {
                throw new PreexistingEntityException("Pendenciafinaceira " + pendenciafinaceira + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pendenciafinaceira pendenciafinaceira) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pendenciafinaceira persistentPendenciafinaceira = em.find(Pendenciafinaceira.class, pendenciafinaceira.getCodpendenciafinaceira());
            Consultaserasa codconsultaserasaOld = persistentPendenciafinaceira.getCodconsultaserasa();
            Consultaserasa codconsultaserasaNew = pendenciafinaceira.getCodconsultaserasa();
            if (codconsultaserasaNew != null) {
                codconsultaserasaNew = em.getReference(codconsultaserasaNew.getClass(), codconsultaserasaNew.getCodconsultaserasa());
                pendenciafinaceira.setCodconsultaserasa(codconsultaserasaNew);
            }
            pendenciafinaceira = em.merge(pendenciafinaceira);
            if (codconsultaserasaOld != null && !codconsultaserasaOld.equals(codconsultaserasaNew)) {
                codconsultaserasaOld.getPendenciafinaceiraCollection().remove(pendenciafinaceira);
                codconsultaserasaOld = em.merge(codconsultaserasaOld);
            }
            if (codconsultaserasaNew != null && !codconsultaserasaNew.equals(codconsultaserasaOld)) {
                codconsultaserasaNew.getPendenciafinaceiraCollection().add(pendenciafinaceira);
                codconsultaserasaNew = em.merge(codconsultaserasaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = pendenciafinaceira.getCodpendenciafinaceira();
                if (findPendenciafinaceira(id) == null) {
                    throw new NonexistentEntityException("The pendenciafinaceira with id " + id + " no longer exists.");
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
            Pendenciafinaceira pendenciafinaceira;
            try {
                pendenciafinaceira = em.getReference(Pendenciafinaceira.class, id);
                pendenciafinaceira.getCodpendenciafinaceira();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pendenciafinaceira with id " + id + " no longer exists.", enfe);
            }
            Consultaserasa codconsultaserasa = pendenciafinaceira.getCodconsultaserasa();
            if (codconsultaserasa != null) {
                codconsultaserasa.getPendenciafinaceiraCollection().remove(pendenciafinaceira);
                codconsultaserasa = em.merge(codconsultaserasa);
            }
            em.remove(pendenciafinaceira);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pendenciafinaceira> findPendenciafinaceiraEntities() {
        return findPendenciafinaceiraEntities(true, -1, -1);
    }

    public List<Pendenciafinaceira> findPendenciafinaceiraEntities(int maxResults, int firstResult) {
        return findPendenciafinaceiraEntities(false, maxResults, firstResult);
    }

    private List<Pendenciafinaceira> findPendenciafinaceiraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pendenciafinaceira.class));
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

    public Pendenciafinaceira findPendenciafinaceira(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pendenciafinaceira.class, id);
        } finally {
            em.close();
        }
    }

    public int getPendenciafinaceiraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pendenciafinaceira> rt = cq.from(Pendenciafinaceira.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

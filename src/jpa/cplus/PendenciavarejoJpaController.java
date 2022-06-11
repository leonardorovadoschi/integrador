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
import entidade.cplus.Pendenciavarejo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class PendenciavarejoJpaController implements Serializable {

    public PendenciavarejoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pendenciavarejo pendenciavarejo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consultaserasa codconsultaserasa = pendenciavarejo.getCodconsultaserasa();
            if (codconsultaserasa != null) {
                codconsultaserasa = em.getReference(codconsultaserasa.getClass(), codconsultaserasa.getCodconsultaserasa());
                pendenciavarejo.setCodconsultaserasa(codconsultaserasa);
            }
            em.persist(pendenciavarejo);
            if (codconsultaserasa != null) {
                codconsultaserasa.getPendenciavarejoCollection().add(pendenciavarejo);
                codconsultaserasa = em.merge(codconsultaserasa);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPendenciavarejo(pendenciavarejo.getCodpendenciavarejo()) != null) {
                throw new PreexistingEntityException("Pendenciavarejo " + pendenciavarejo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pendenciavarejo pendenciavarejo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pendenciavarejo persistentPendenciavarejo = em.find(Pendenciavarejo.class, pendenciavarejo.getCodpendenciavarejo());
            Consultaserasa codconsultaserasaOld = persistentPendenciavarejo.getCodconsultaserasa();
            Consultaserasa codconsultaserasaNew = pendenciavarejo.getCodconsultaserasa();
            if (codconsultaserasaNew != null) {
                codconsultaserasaNew = em.getReference(codconsultaserasaNew.getClass(), codconsultaserasaNew.getCodconsultaserasa());
                pendenciavarejo.setCodconsultaserasa(codconsultaserasaNew);
            }
            pendenciavarejo = em.merge(pendenciavarejo);
            if (codconsultaserasaOld != null && !codconsultaserasaOld.equals(codconsultaserasaNew)) {
                codconsultaserasaOld.getPendenciavarejoCollection().remove(pendenciavarejo);
                codconsultaserasaOld = em.merge(codconsultaserasaOld);
            }
            if (codconsultaserasaNew != null && !codconsultaserasaNew.equals(codconsultaserasaOld)) {
                codconsultaserasaNew.getPendenciavarejoCollection().add(pendenciavarejo);
                codconsultaserasaNew = em.merge(codconsultaserasaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = pendenciavarejo.getCodpendenciavarejo();
                if (findPendenciavarejo(id) == null) {
                    throw new NonexistentEntityException("The pendenciavarejo with id " + id + " no longer exists.");
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
            Pendenciavarejo pendenciavarejo;
            try {
                pendenciavarejo = em.getReference(Pendenciavarejo.class, id);
                pendenciavarejo.getCodpendenciavarejo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pendenciavarejo with id " + id + " no longer exists.", enfe);
            }
            Consultaserasa codconsultaserasa = pendenciavarejo.getCodconsultaserasa();
            if (codconsultaserasa != null) {
                codconsultaserasa.getPendenciavarejoCollection().remove(pendenciavarejo);
                codconsultaserasa = em.merge(codconsultaserasa);
            }
            em.remove(pendenciavarejo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pendenciavarejo> findPendenciavarejoEntities() {
        return findPendenciavarejoEntities(true, -1, -1);
    }

    public List<Pendenciavarejo> findPendenciavarejoEntities(int maxResults, int firstResult) {
        return findPendenciavarejoEntities(false, maxResults, firstResult);
    }

    private List<Pendenciavarejo> findPendenciavarejoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pendenciavarejo.class));
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

    public Pendenciavarejo findPendenciavarejo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pendenciavarejo.class, id);
        } finally {
            em.close();
        }
    }

    public int getPendenciavarejoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pendenciavarejo> rt = cq.from(Pendenciavarejo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
import entidade.cplus.Historicoserasa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class HistoricoserasaJpaController implements Serializable {

    public HistoricoserasaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Historicoserasa historicoserasa) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consultaserasa codconsultaserasa = historicoserasa.getCodconsultaserasa();
            if (codconsultaserasa != null) {
                codconsultaserasa = em.getReference(codconsultaserasa.getClass(), codconsultaserasa.getCodconsultaserasa());
                historicoserasa.setCodconsultaserasa(codconsultaserasa);
            }
            em.persist(historicoserasa);
            if (codconsultaserasa != null) {
                codconsultaserasa.getHistoricoserasaCollection().add(historicoserasa);
                codconsultaserasa = em.merge(codconsultaserasa);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHistoricoserasa(historicoserasa.getCodhistoricoserasa()) != null) {
                throw new PreexistingEntityException("Historicoserasa " + historicoserasa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Historicoserasa historicoserasa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Historicoserasa persistentHistoricoserasa = em.find(Historicoserasa.class, historicoserasa.getCodhistoricoserasa());
            Consultaserasa codconsultaserasaOld = persistentHistoricoserasa.getCodconsultaserasa();
            Consultaserasa codconsultaserasaNew = historicoserasa.getCodconsultaserasa();
            if (codconsultaserasaNew != null) {
                codconsultaserasaNew = em.getReference(codconsultaserasaNew.getClass(), codconsultaserasaNew.getCodconsultaserasa());
                historicoserasa.setCodconsultaserasa(codconsultaserasaNew);
            }
            historicoserasa = em.merge(historicoserasa);
            if (codconsultaserasaOld != null && !codconsultaserasaOld.equals(codconsultaserasaNew)) {
                codconsultaserasaOld.getHistoricoserasaCollection().remove(historicoserasa);
                codconsultaserasaOld = em.merge(codconsultaserasaOld);
            }
            if (codconsultaserasaNew != null && !codconsultaserasaNew.equals(codconsultaserasaOld)) {
                codconsultaserasaNew.getHistoricoserasaCollection().add(historicoserasa);
                codconsultaserasaNew = em.merge(codconsultaserasaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = historicoserasa.getCodhistoricoserasa();
                if (findHistoricoserasa(id) == null) {
                    throw new NonexistentEntityException("The historicoserasa with id " + id + " no longer exists.");
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
            Historicoserasa historicoserasa;
            try {
                historicoserasa = em.getReference(Historicoserasa.class, id);
                historicoserasa.getCodhistoricoserasa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The historicoserasa with id " + id + " no longer exists.", enfe);
            }
            Consultaserasa codconsultaserasa = historicoserasa.getCodconsultaserasa();
            if (codconsultaserasa != null) {
                codconsultaserasa.getHistoricoserasaCollection().remove(historicoserasa);
                codconsultaserasa = em.merge(codconsultaserasa);
            }
            em.remove(historicoserasa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Historicoserasa> findHistoricoserasaEntities() {
        return findHistoricoserasaEntities(true, -1, -1);
    }

    public List<Historicoserasa> findHistoricoserasaEntities(int maxResults, int firstResult) {
        return findHistoricoserasaEntities(false, maxResults, firstResult);
    }

    private List<Historicoserasa> findHistoricoserasaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Historicoserasa.class));
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

    public Historicoserasa findHistoricoserasa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Historicoserasa.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistoricoserasaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Historicoserasa> rt = cq.from(Historicoserasa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

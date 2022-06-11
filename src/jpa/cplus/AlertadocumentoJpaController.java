/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Alertadocumento;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Consultaserasa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class AlertadocumentoJpaController implements Serializable {

    public AlertadocumentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Alertadocumento alertadocumento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consultaserasa codconsultaserasa = alertadocumento.getCodconsultaserasa();
            if (codconsultaserasa != null) {
                codconsultaserasa = em.getReference(codconsultaserasa.getClass(), codconsultaserasa.getCodconsultaserasa());
                alertadocumento.setCodconsultaserasa(codconsultaserasa);
            }
            em.persist(alertadocumento);
            if (codconsultaserasa != null) {
                codconsultaserasa.getAlertadocumentoCollection().add(alertadocumento);
                codconsultaserasa = em.merge(codconsultaserasa);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAlertadocumento(alertadocumento.getCodalertadocumento()) != null) {
                throw new PreexistingEntityException("Alertadocumento " + alertadocumento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Alertadocumento alertadocumento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alertadocumento persistentAlertadocumento = em.find(Alertadocumento.class, alertadocumento.getCodalertadocumento());
            Consultaserasa codconsultaserasaOld = persistentAlertadocumento.getCodconsultaserasa();
            Consultaserasa codconsultaserasaNew = alertadocumento.getCodconsultaserasa();
            if (codconsultaserasaNew != null) {
                codconsultaserasaNew = em.getReference(codconsultaserasaNew.getClass(), codconsultaserasaNew.getCodconsultaserasa());
                alertadocumento.setCodconsultaserasa(codconsultaserasaNew);
            }
            alertadocumento = em.merge(alertadocumento);
            if (codconsultaserasaOld != null && !codconsultaserasaOld.equals(codconsultaserasaNew)) {
                codconsultaserasaOld.getAlertadocumentoCollection().remove(alertadocumento);
                codconsultaserasaOld = em.merge(codconsultaserasaOld);
            }
            if (codconsultaserasaNew != null && !codconsultaserasaNew.equals(codconsultaserasaOld)) {
                codconsultaserasaNew.getAlertadocumentoCollection().add(alertadocumento);
                codconsultaserasaNew = em.merge(codconsultaserasaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = alertadocumento.getCodalertadocumento();
                if (findAlertadocumento(id) == null) {
                    throw new NonexistentEntityException("The alertadocumento with id " + id + " no longer exists.");
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
            Alertadocumento alertadocumento;
            try {
                alertadocumento = em.getReference(Alertadocumento.class, id);
                alertadocumento.getCodalertadocumento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The alertadocumento with id " + id + " no longer exists.", enfe);
            }
            Consultaserasa codconsultaserasa = alertadocumento.getCodconsultaserasa();
            if (codconsultaserasa != null) {
                codconsultaserasa.getAlertadocumentoCollection().remove(alertadocumento);
                codconsultaserasa = em.merge(codconsultaserasa);
            }
            em.remove(alertadocumento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Alertadocumento> findAlertadocumentoEntities() {
        return findAlertadocumentoEntities(true, -1, -1);
    }

    public List<Alertadocumento> findAlertadocumentoEntities(int maxResults, int firstResult) {
        return findAlertadocumentoEntities(false, maxResults, firstResult);
    }

    private List<Alertadocumento> findAlertadocumentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Alertadocumento.class));
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

    public Alertadocumento findAlertadocumento(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Alertadocumento.class, id);
        } finally {
            em.close();
        }
    }

    public int getAlertadocumentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Alertadocumento> rt = cq.from(Alertadocumento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

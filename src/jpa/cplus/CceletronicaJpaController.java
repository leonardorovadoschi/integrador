/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Cceletronica;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Nfeletronica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class CceletronicaJpaController implements Serializable {

    public CceletronicaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cceletronica cceletronica) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nfeletronica codnfeletronica = cceletronica.getCodnfeletronica();
            if (codnfeletronica != null) {
                codnfeletronica = em.getReference(codnfeletronica.getClass(), codnfeletronica.getCodnfeletronica());
                cceletronica.setCodnfeletronica(codnfeletronica);
            }
            em.persist(cceletronica);
            if (codnfeletronica != null) {
                codnfeletronica.getCceletronicaCollection().add(cceletronica);
                codnfeletronica = em.merge(codnfeletronica);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCceletronica(cceletronica.getCodcceletronica()) != null) {
                throw new PreexistingEntityException("Cceletronica " + cceletronica + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cceletronica cceletronica) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cceletronica persistentCceletronica = em.find(Cceletronica.class, cceletronica.getCodcceletronica());
            Nfeletronica codnfeletronicaOld = persistentCceletronica.getCodnfeletronica();
            Nfeletronica codnfeletronicaNew = cceletronica.getCodnfeletronica();
            if (codnfeletronicaNew != null) {
                codnfeletronicaNew = em.getReference(codnfeletronicaNew.getClass(), codnfeletronicaNew.getCodnfeletronica());
                cceletronica.setCodnfeletronica(codnfeletronicaNew);
            }
            cceletronica = em.merge(cceletronica);
            if (codnfeletronicaOld != null && !codnfeletronicaOld.equals(codnfeletronicaNew)) {
                codnfeletronicaOld.getCceletronicaCollection().remove(cceletronica);
                codnfeletronicaOld = em.merge(codnfeletronicaOld);
            }
            if (codnfeletronicaNew != null && !codnfeletronicaNew.equals(codnfeletronicaOld)) {
                codnfeletronicaNew.getCceletronicaCollection().add(cceletronica);
                codnfeletronicaNew = em.merge(codnfeletronicaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cceletronica.getCodcceletronica();
                if (findCceletronica(id) == null) {
                    throw new NonexistentEntityException("The cceletronica with id " + id + " no longer exists.");
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
            Cceletronica cceletronica;
            try {
                cceletronica = em.getReference(Cceletronica.class, id);
                cceletronica.getCodcceletronica();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cceletronica with id " + id + " no longer exists.", enfe);
            }
            Nfeletronica codnfeletronica = cceletronica.getCodnfeletronica();
            if (codnfeletronica != null) {
                codnfeletronica.getCceletronicaCollection().remove(cceletronica);
                codnfeletronica = em.merge(codnfeletronica);
            }
            em.remove(cceletronica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cceletronica> findCceletronicaEntities() {
        return findCceletronicaEntities(true, -1, -1);
    }

    public List<Cceletronica> findCceletronicaEntities(int maxResults, int firstResult) {
        return findCceletronicaEntities(false, maxResults, firstResult);
    }

    private List<Cceletronica> findCceletronicaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cceletronica.class));
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

    public Cceletronica findCceletronica(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cceletronica.class, id);
        } finally {
            em.close();
        }
    }

    public int getCceletronicaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cceletronica> rt = cq.from(Cceletronica.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Nfceletronicalote;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class NfceletronicaloteJpaController implements Serializable {

    public NfceletronicaloteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Nfceletronicalote nfceletronicalote) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(nfceletronicalote);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNfceletronicalote(nfceletronicalote.getCodnfceletronicalote()) != null) {
                throw new PreexistingEntityException("Nfceletronicalote " + nfceletronicalote + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nfceletronicalote nfceletronicalote) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            nfceletronicalote = em.merge(nfceletronicalote);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = nfceletronicalote.getCodnfceletronicalote();
                if (findNfceletronicalote(id) == null) {
                    throw new NonexistentEntityException("The nfceletronicalote with id " + id + " no longer exists.");
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
            Nfceletronicalote nfceletronicalote;
            try {
                nfceletronicalote = em.getReference(Nfceletronicalote.class, id);
                nfceletronicalote.getCodnfceletronicalote();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nfceletronicalote with id " + id + " no longer exists.", enfe);
            }
            em.remove(nfceletronicalote);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nfceletronicalote> findNfceletronicaloteEntities() {
        return findNfceletronicaloteEntities(true, -1, -1);
    }

    public List<Nfceletronicalote> findNfceletronicaloteEntities(int maxResults, int firstResult) {
        return findNfceletronicaloteEntities(false, maxResults, firstResult);
    }

    private List<Nfceletronicalote> findNfceletronicaloteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nfceletronicalote.class));
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

    public Nfceletronicalote findNfceletronicalote(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nfceletronicalote.class, id);
        } finally {
            em.close();
        }
    }

    public int getNfceletronicaloteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nfceletronicalote> rt = cq.from(Nfceletronicalote.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

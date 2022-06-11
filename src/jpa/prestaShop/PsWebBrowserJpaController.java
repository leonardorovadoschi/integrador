/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsWebBrowser;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.prestaShop.exceptions.NonexistentEntityException;

/**
 *
 * @author leo
 */
public class PsWebBrowserJpaController implements Serializable {

    public PsWebBrowserJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsWebBrowser psWebBrowser) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psWebBrowser);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsWebBrowser psWebBrowser) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psWebBrowser = em.merge(psWebBrowser);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psWebBrowser.getIdWebBrowser();
                if (findPsWebBrowser(id) == null) {
                    throw new NonexistentEntityException("The psWebBrowser with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsWebBrowser psWebBrowser;
            try {
                psWebBrowser = em.getReference(PsWebBrowser.class, id);
                psWebBrowser.getIdWebBrowser();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psWebBrowser with id " + id + " no longer exists.", enfe);
            }
            em.remove(psWebBrowser);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsWebBrowser> findPsWebBrowserEntities() {
        return findPsWebBrowserEntities(true, -1, -1);
    }

    public List<PsWebBrowser> findPsWebBrowserEntities(int maxResults, int firstResult) {
        return findPsWebBrowserEntities(false, maxResults, firstResult);
    }

    private List<PsWebBrowser> findPsWebBrowserEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsWebBrowser.class));
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

    public PsWebBrowser findPsWebBrowser(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsWebBrowser.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsWebBrowserCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsWebBrowser> rt = cq.from(PsWebBrowser.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

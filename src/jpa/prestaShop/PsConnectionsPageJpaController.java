/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsConnectionsPage;
import entidade.prestaShop.PsConnectionsPagePK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.prestaShop.exceptions.NonexistentEntityException;
import jpa.prestaShop.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class PsConnectionsPageJpaController implements Serializable {

    public PsConnectionsPageJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsConnectionsPage psConnectionsPage) throws PreexistingEntityException, Exception {
        if (psConnectionsPage.getPsConnectionsPagePK() == null) {
            psConnectionsPage.setPsConnectionsPagePK(new PsConnectionsPagePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psConnectionsPage);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsConnectionsPage(psConnectionsPage.getPsConnectionsPagePK()) != null) {
                throw new PreexistingEntityException("PsConnectionsPage " + psConnectionsPage + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsConnectionsPage psConnectionsPage) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psConnectionsPage = em.merge(psConnectionsPage);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsConnectionsPagePK id = psConnectionsPage.getPsConnectionsPagePK();
                if (findPsConnectionsPage(id) == null) {
                    throw new NonexistentEntityException("The psConnectionsPage with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsConnectionsPagePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsConnectionsPage psConnectionsPage;
            try {
                psConnectionsPage = em.getReference(PsConnectionsPage.class, id);
                psConnectionsPage.getPsConnectionsPagePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psConnectionsPage with id " + id + " no longer exists.", enfe);
            }
            em.remove(psConnectionsPage);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsConnectionsPage> findPsConnectionsPageEntities() {
        return findPsConnectionsPageEntities(true, -1, -1);
    }

    public List<PsConnectionsPage> findPsConnectionsPageEntities(int maxResults, int firstResult) {
        return findPsConnectionsPageEntities(false, maxResults, firstResult);
    }

    private List<PsConnectionsPage> findPsConnectionsPageEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsConnectionsPage.class));
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

    public PsConnectionsPage findPsConnectionsPage(PsConnectionsPagePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsConnectionsPage.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsConnectionsPageCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsConnectionsPage> rt = cq.from(PsConnectionsPage.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

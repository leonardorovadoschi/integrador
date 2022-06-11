/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsSmartyLastFlush;
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
public class PsSmartyLastFlushJpaController implements Serializable {

    public PsSmartyLastFlushJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsSmartyLastFlush psSmartyLastFlush) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psSmartyLastFlush);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsSmartyLastFlush(psSmartyLastFlush.getType()) != null) {
                throw new PreexistingEntityException("PsSmartyLastFlush " + psSmartyLastFlush + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsSmartyLastFlush psSmartyLastFlush) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psSmartyLastFlush = em.merge(psSmartyLastFlush);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = psSmartyLastFlush.getType();
                if (findPsSmartyLastFlush(id) == null) {
                    throw new NonexistentEntityException("The psSmartyLastFlush with id " + id + " no longer exists.");
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
            PsSmartyLastFlush psSmartyLastFlush;
            try {
                psSmartyLastFlush = em.getReference(PsSmartyLastFlush.class, id);
                psSmartyLastFlush.getType();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psSmartyLastFlush with id " + id + " no longer exists.", enfe);
            }
            em.remove(psSmartyLastFlush);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsSmartyLastFlush> findPsSmartyLastFlushEntities() {
        return findPsSmartyLastFlushEntities(true, -1, -1);
    }

    public List<PsSmartyLastFlush> findPsSmartyLastFlushEntities(int maxResults, int firstResult) {
        return findPsSmartyLastFlushEntities(false, maxResults, firstResult);
    }

    private List<PsSmartyLastFlush> findPsSmartyLastFlushEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsSmartyLastFlush.class));
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

    public PsSmartyLastFlush findPsSmartyLastFlush(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsSmartyLastFlush.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsSmartyLastFlushCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsSmartyLastFlush> rt = cq.from(PsSmartyLastFlush.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

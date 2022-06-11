/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsMessageReaded;
import entidade.prestaShop.PsMessageReadedPK;
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
public class PsMessageReadedJpaController implements Serializable {

    public PsMessageReadedJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsMessageReaded psMessageReaded) throws PreexistingEntityException, Exception {
        if (psMessageReaded.getPsMessageReadedPK() == null) {
            psMessageReaded.setPsMessageReadedPK(new PsMessageReadedPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psMessageReaded);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsMessageReaded(psMessageReaded.getPsMessageReadedPK()) != null) {
                throw new PreexistingEntityException("PsMessageReaded " + psMessageReaded + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsMessageReaded psMessageReaded) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psMessageReaded = em.merge(psMessageReaded);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsMessageReadedPK id = psMessageReaded.getPsMessageReadedPK();
                if (findPsMessageReaded(id) == null) {
                    throw new NonexistentEntityException("The psMessageReaded with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsMessageReadedPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsMessageReaded psMessageReaded;
            try {
                psMessageReaded = em.getReference(PsMessageReaded.class, id);
                psMessageReaded.getPsMessageReadedPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psMessageReaded with id " + id + " no longer exists.", enfe);
            }
            em.remove(psMessageReaded);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsMessageReaded> findPsMessageReadedEntities() {
        return findPsMessageReadedEntities(true, -1, -1);
    }

    public List<PsMessageReaded> findPsMessageReadedEntities(int maxResults, int firstResult) {
        return findPsMessageReadedEntities(false, maxResults, firstResult);
    }

    private List<PsMessageReaded> findPsMessageReadedEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsMessageReaded.class));
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

    public PsMessageReaded findPsMessageReaded(PsMessageReadedPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsMessageReaded.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsMessageReadedCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsMessageReaded> rt = cq.from(PsMessageReaded.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

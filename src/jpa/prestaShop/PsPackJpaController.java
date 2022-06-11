/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsPack;
import entidade.prestaShop.PsPackPK;
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
public class PsPackJpaController implements Serializable {

    public PsPackJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsPack psPack) throws PreexistingEntityException, Exception {
        if (psPack.getPsPackPK() == null) {
            psPack.setPsPackPK(new PsPackPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psPack);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsPack(psPack.getPsPackPK()) != null) {
                throw new PreexistingEntityException("PsPack " + psPack + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsPack psPack) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psPack = em.merge(psPack);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsPackPK id = psPack.getPsPackPK();
                if (findPsPack(id) == null) {
                    throw new NonexistentEntityException("The psPack with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsPackPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsPack psPack;
            try {
                psPack = em.getReference(PsPack.class, id);
                psPack.getPsPackPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psPack with id " + id + " no longer exists.", enfe);
            }
            em.remove(psPack);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsPack> findPsPackEntities() {
        return findPsPackEntities(true, -1, -1);
    }

    public List<PsPack> findPsPackEntities(int maxResults, int firstResult) {
        return findPsPackEntities(false, maxResults, firstResult);
    }

    private List<PsPack> findPsPackEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsPack.class));
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

    public PsPack findPsPack(PsPackPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsPack.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsPackCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsPack> rt = cq.from(PsPack.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

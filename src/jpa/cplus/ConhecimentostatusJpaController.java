/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Conhecimentostatus;
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
public class ConhecimentostatusJpaController implements Serializable {

    public ConhecimentostatusJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Conhecimentostatus conhecimentostatus) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(conhecimentostatus);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConhecimentostatus(conhecimentostatus.getCodconhecimentostatus()) != null) {
                throw new PreexistingEntityException("Conhecimentostatus " + conhecimentostatus + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Conhecimentostatus conhecimentostatus) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            conhecimentostatus = em.merge(conhecimentostatus);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = conhecimentostatus.getCodconhecimentostatus();
                if (findConhecimentostatus(id) == null) {
                    throw new NonexistentEntityException("The conhecimentostatus with id " + id + " no longer exists.");
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
            Conhecimentostatus conhecimentostatus;
            try {
                conhecimentostatus = em.getReference(Conhecimentostatus.class, id);
                conhecimentostatus.getCodconhecimentostatus();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The conhecimentostatus with id " + id + " no longer exists.", enfe);
            }
            em.remove(conhecimentostatus);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Conhecimentostatus> findConhecimentostatusEntities() {
        return findConhecimentostatusEntities(true, -1, -1);
    }

    public List<Conhecimentostatus> findConhecimentostatusEntities(int maxResults, int firstResult) {
        return findConhecimentostatusEntities(false, maxResults, firstResult);
    }

    private List<Conhecimentostatus> findConhecimentostatusEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Conhecimentostatus.class));
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

    public Conhecimentostatus findConhecimentostatus(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Conhecimentostatus.class, id);
        } finally {
            em.close();
        }
    }

    public int getConhecimentostatusCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Conhecimentostatus> rt = cq.from(Conhecimentostatus.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

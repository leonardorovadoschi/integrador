/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Senharemota;
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
public class SenharemotaJpaController implements Serializable {

    public SenharemotaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Senharemota senharemota) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(senharemota);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSenharemota(senharemota.getIdsenharemota()) != null) {
                throw new PreexistingEntityException("Senharemota " + senharemota + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Senharemota senharemota) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            senharemota = em.merge(senharemota);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = senharemota.getIdsenharemota();
                if (findSenharemota(id) == null) {
                    throw new NonexistentEntityException("The senharemota with id " + id + " no longer exists.");
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
            Senharemota senharemota;
            try {
                senharemota = em.getReference(Senharemota.class, id);
                senharemota.getIdsenharemota();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The senharemota with id " + id + " no longer exists.", enfe);
            }
            em.remove(senharemota);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Senharemota> findSenharemotaEntities() {
        return findSenharemotaEntities(true, -1, -1);
    }

    public List<Senharemota> findSenharemotaEntities(int maxResults, int firstResult) {
        return findSenharemotaEntities(false, maxResults, firstResult);
    }

    private List<Senharemota> findSenharemotaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Senharemota.class));
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

    public Senharemota findSenharemota(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Senharemota.class, id);
        } finally {
            em.close();
        }
    }

    public int getSenharemotaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Senharemota> rt = cq.from(Senharemota.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

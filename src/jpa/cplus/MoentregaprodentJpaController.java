/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Moentregaprodent;
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
public class MoentregaprodentJpaController implements Serializable {

    public MoentregaprodentJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Moentregaprodent moentregaprodent) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(moentregaprodent);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMoentregaprodent(moentregaprodent.getId()) != null) {
                throw new PreexistingEntityException("Moentregaprodent " + moentregaprodent + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Moentregaprodent moentregaprodent) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            moentregaprodent = em.merge(moentregaprodent);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = moentregaprodent.getId();
                if (findMoentregaprodent(id) == null) {
                    throw new NonexistentEntityException("The moentregaprodent with id " + id + " no longer exists.");
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
            Moentregaprodent moentregaprodent;
            try {
                moentregaprodent = em.getReference(Moentregaprodent.class, id);
                moentregaprodent.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The moentregaprodent with id " + id + " no longer exists.", enfe);
            }
            em.remove(moentregaprodent);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Moentregaprodent> findMoentregaprodentEntities() {
        return findMoentregaprodentEntities(true, -1, -1);
    }

    public List<Moentregaprodent> findMoentregaprodentEntities(int maxResults, int firstResult) {
        return findMoentregaprodentEntities(false, maxResults, firstResult);
    }

    private List<Moentregaprodent> findMoentregaprodentEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Moentregaprodent.class));
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

    public Moentregaprodent findMoentregaprodent(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Moentregaprodent.class, id);
        } finally {
            em.close();
        }
    }

    public int getMoentregaprodentCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Moentregaprodent> rt = cq.from(Moentregaprodent.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

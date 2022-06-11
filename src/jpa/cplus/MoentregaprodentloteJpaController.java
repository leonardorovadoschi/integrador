/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Moentregaprodentlote;
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
public class MoentregaprodentloteJpaController implements Serializable {

    public MoentregaprodentloteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Moentregaprodentlote moentregaprodentlote) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(moentregaprodentlote);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMoentregaprodentlote(moentregaprodentlote.getId()) != null) {
                throw new PreexistingEntityException("Moentregaprodentlote " + moentregaprodentlote + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Moentregaprodentlote moentregaprodentlote) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            moentregaprodentlote = em.merge(moentregaprodentlote);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = moentregaprodentlote.getId();
                if (findMoentregaprodentlote(id) == null) {
                    throw new NonexistentEntityException("The moentregaprodentlote with id " + id + " no longer exists.");
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
            Moentregaprodentlote moentregaprodentlote;
            try {
                moentregaprodentlote = em.getReference(Moentregaprodentlote.class, id);
                moentregaprodentlote.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The moentregaprodentlote with id " + id + " no longer exists.", enfe);
            }
            em.remove(moentregaprodentlote);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Moentregaprodentlote> findMoentregaprodentloteEntities() {
        return findMoentregaprodentloteEntities(true, -1, -1);
    }

    public List<Moentregaprodentlote> findMoentregaprodentloteEntities(int maxResults, int firstResult) {
        return findMoentregaprodentloteEntities(false, maxResults, firstResult);
    }

    private List<Moentregaprodentlote> findMoentregaprodentloteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Moentregaprodentlote.class));
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

    public Moentregaprodentlote findMoentregaprodentlote(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Moentregaprodentlote.class, id);
        } finally {
            em.close();
        }
    }

    public int getMoentregaprodentloteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Moentregaprodentlote> rt = cq.from(Moentregaprodentlote.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

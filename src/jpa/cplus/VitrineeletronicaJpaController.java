/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Vitrineeletronica;
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
public class VitrineeletronicaJpaController implements Serializable {

    public VitrineeletronicaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vitrineeletronica vitrineeletronica) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(vitrineeletronica);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVitrineeletronica(vitrineeletronica.getCodvitrineeletronica()) != null) {
                throw new PreexistingEntityException("Vitrineeletronica " + vitrineeletronica + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vitrineeletronica vitrineeletronica) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            vitrineeletronica = em.merge(vitrineeletronica);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = vitrineeletronica.getCodvitrineeletronica();
                if (findVitrineeletronica(id) == null) {
                    throw new NonexistentEntityException("The vitrineeletronica with id " + id + " no longer exists.");
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
            Vitrineeletronica vitrineeletronica;
            try {
                vitrineeletronica = em.getReference(Vitrineeletronica.class, id);
                vitrineeletronica.getCodvitrineeletronica();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vitrineeletronica with id " + id + " no longer exists.", enfe);
            }
            em.remove(vitrineeletronica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vitrineeletronica> findVitrineeletronicaEntities() {
        return findVitrineeletronicaEntities(true, -1, -1);
    }

    public List<Vitrineeletronica> findVitrineeletronicaEntities(int maxResults, int firstResult) {
        return findVitrineeletronicaEntities(false, maxResults, firstResult);
    }

    private List<Vitrineeletronica> findVitrineeletronicaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vitrineeletronica.class));
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

    public Vitrineeletronica findVitrineeletronica(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vitrineeletronica.class, id);
        } finally {
            em.close();
        }
    }

    public int getVitrineeletronicaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vitrineeletronica> rt = cq.from(Vitrineeletronica.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

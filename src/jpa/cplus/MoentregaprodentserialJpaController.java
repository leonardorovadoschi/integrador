/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Moentregaprodentserial;
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
public class MoentregaprodentserialJpaController implements Serializable {

    public MoentregaprodentserialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Moentregaprodentserial moentregaprodentserial) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(moentregaprodentserial);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMoentregaprodentserial(moentregaprodentserial.getId()) != null) {
                throw new PreexistingEntityException("Moentregaprodentserial " + moentregaprodentserial + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Moentregaprodentserial moentregaprodentserial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            moentregaprodentserial = em.merge(moentregaprodentserial);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = moentregaprodentserial.getId();
                if (findMoentregaprodentserial(id) == null) {
                    throw new NonexistentEntityException("The moentregaprodentserial with id " + id + " no longer exists.");
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
            Moentregaprodentserial moentregaprodentserial;
            try {
                moentregaprodentserial = em.getReference(Moentregaprodentserial.class, id);
                moentregaprodentserial.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The moentregaprodentserial with id " + id + " no longer exists.", enfe);
            }
            em.remove(moentregaprodentserial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Moentregaprodentserial> findMoentregaprodentserialEntities() {
        return findMoentregaprodentserialEntities(true, -1, -1);
    }

    public List<Moentregaprodentserial> findMoentregaprodentserialEntities(int maxResults, int firstResult) {
        return findMoentregaprodentserialEntities(false, maxResults, firstResult);
    }

    private List<Moentregaprodentserial> findMoentregaprodentserialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Moentregaprodentserial.class));
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

    public Moentregaprodentserial findMoentregaprodentserial(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Moentregaprodentserial.class, id);
        } finally {
            em.close();
        }
    }

    public int getMoentregaprodentserialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Moentregaprodentserial> rt = cq.from(Moentregaprodentserial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

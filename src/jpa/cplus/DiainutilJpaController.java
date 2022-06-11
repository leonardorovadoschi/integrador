/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Diainutil;
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
public class DiainutilJpaController implements Serializable {

    public DiainutilJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Diainutil diainutil) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(diainutil);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDiainutil(diainutil.getCoddiainutil()) != null) {
                throw new PreexistingEntityException("Diainutil " + diainutil + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Diainutil diainutil) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            diainutil = em.merge(diainutil);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = diainutil.getCoddiainutil();
                if (findDiainutil(id) == null) {
                    throw new NonexistentEntityException("The diainutil with id " + id + " no longer exists.");
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
            Diainutil diainutil;
            try {
                diainutil = em.getReference(Diainutil.class, id);
                diainutil.getCoddiainutil();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The diainutil with id " + id + " no longer exists.", enfe);
            }
            em.remove(diainutil);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Diainutil> findDiainutilEntities() {
        return findDiainutilEntities(true, -1, -1);
    }

    public List<Diainutil> findDiainutilEntities(int maxResults, int firstResult) {
        return findDiainutilEntities(false, maxResults, firstResult);
    }

    private List<Diainutil> findDiainutilEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Diainutil.class));
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

    public Diainutil findDiainutil(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Diainutil.class, id);
        } finally {
            em.close();
        }
    }

    public int getDiainutilCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Diainutil> rt = cq.from(Diainutil.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

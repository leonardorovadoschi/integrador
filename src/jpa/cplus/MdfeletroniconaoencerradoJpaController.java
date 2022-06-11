/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Mdfeletroniconaoencerrado;
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
public class MdfeletroniconaoencerradoJpaController implements Serializable {

    public MdfeletroniconaoencerradoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mdfeletroniconaoencerrado mdfeletroniconaoencerrado) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mdfeletroniconaoencerrado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMdfeletroniconaoencerrado(mdfeletroniconaoencerrado.getCodmdfeletroniconaoencerrado()) != null) {
                throw new PreexistingEntityException("Mdfeletroniconaoencerrado " + mdfeletroniconaoencerrado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mdfeletroniconaoencerrado mdfeletroniconaoencerrado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mdfeletroniconaoencerrado = em.merge(mdfeletroniconaoencerrado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = mdfeletroniconaoencerrado.getCodmdfeletroniconaoencerrado();
                if (findMdfeletroniconaoencerrado(id) == null) {
                    throw new NonexistentEntityException("The mdfeletroniconaoencerrado with id " + id + " no longer exists.");
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
            Mdfeletroniconaoencerrado mdfeletroniconaoencerrado;
            try {
                mdfeletroniconaoencerrado = em.getReference(Mdfeletroniconaoencerrado.class, id);
                mdfeletroniconaoencerrado.getCodmdfeletroniconaoencerrado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mdfeletroniconaoencerrado with id " + id + " no longer exists.", enfe);
            }
            em.remove(mdfeletroniconaoencerrado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mdfeletroniconaoencerrado> findMdfeletroniconaoencerradoEntities() {
        return findMdfeletroniconaoencerradoEntities(true, -1, -1);
    }

    public List<Mdfeletroniconaoencerrado> findMdfeletroniconaoencerradoEntities(int maxResults, int firstResult) {
        return findMdfeletroniconaoencerradoEntities(false, maxResults, firstResult);
    }

    private List<Mdfeletroniconaoencerrado> findMdfeletroniconaoencerradoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mdfeletroniconaoencerrado.class));
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

    public Mdfeletroniconaoencerrado findMdfeletroniconaoencerrado(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mdfeletroniconaoencerrado.class, id);
        } finally {
            em.close();
        }
    }

    public int getMdfeletroniconaoencerradoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mdfeletroniconaoencerrado> rt = cq.from(Mdfeletroniconaoencerrado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

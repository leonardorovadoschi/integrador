/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Diainutilmovel;
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
public class DiainutilmovelJpaController implements Serializable {

    public DiainutilmovelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Diainutilmovel diainutilmovel) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(diainutilmovel);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDiainutilmovel(diainutilmovel.getCoddiainutilmovel()) != null) {
                throw new PreexistingEntityException("Diainutilmovel " + diainutilmovel + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Diainutilmovel diainutilmovel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            diainutilmovel = em.merge(diainutilmovel);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = diainutilmovel.getCoddiainutilmovel();
                if (findDiainutilmovel(id) == null) {
                    throw new NonexistentEntityException("The diainutilmovel with id " + id + " no longer exists.");
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
            Diainutilmovel diainutilmovel;
            try {
                diainutilmovel = em.getReference(Diainutilmovel.class, id);
                diainutilmovel.getCoddiainutilmovel();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The diainutilmovel with id " + id + " no longer exists.", enfe);
            }
            em.remove(diainutilmovel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Diainutilmovel> findDiainutilmovelEntities() {
        return findDiainutilmovelEntities(true, -1, -1);
    }

    public List<Diainutilmovel> findDiainutilmovelEntities(int maxResults, int firstResult) {
        return findDiainutilmovelEntities(false, maxResults, firstResult);
    }

    private List<Diainutilmovel> findDiainutilmovelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Diainutilmovel.class));
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

    public Diainutilmovel findDiainutilmovel(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Diainutilmovel.class, id);
        } finally {
            em.close();
        }
    }

    public int getDiainutilmovelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Diainutilmovel> rt = cq.from(Diainutilmovel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

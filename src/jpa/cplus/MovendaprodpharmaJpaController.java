/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Movendaprod;
import entidade.cplus.Movendaprodpharma;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MovendaprodpharmaJpaController implements Serializable {

    public MovendaprodpharmaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movendaprodpharma movendaprodpharma) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movendaprod codmovprod = movendaprodpharma.getCodmovprod();
            if (codmovprod != null) {
                codmovprod = em.getReference(codmovprod.getClass(), codmovprod.getCodmovprod());
                movendaprodpharma.setCodmovprod(codmovprod);
            }
            em.persist(movendaprodpharma);
            if (codmovprod != null) {
                codmovprod.getMovendaprodpharmaCollection().add(movendaprodpharma);
                codmovprod = em.merge(codmovprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovendaprodpharma(movendaprodpharma.getCodmovprodpharma()) != null) {
                throw new PreexistingEntityException("Movendaprodpharma " + movendaprodpharma + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movendaprodpharma movendaprodpharma) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movendaprodpharma persistentMovendaprodpharma = em.find(Movendaprodpharma.class, movendaprodpharma.getCodmovprodpharma());
            Movendaprod codmovprodOld = persistentMovendaprodpharma.getCodmovprod();
            Movendaprod codmovprodNew = movendaprodpharma.getCodmovprod();
            if (codmovprodNew != null) {
                codmovprodNew = em.getReference(codmovprodNew.getClass(), codmovprodNew.getCodmovprod());
                movendaprodpharma.setCodmovprod(codmovprodNew);
            }
            movendaprodpharma = em.merge(movendaprodpharma);
            if (codmovprodOld != null && !codmovprodOld.equals(codmovprodNew)) {
                codmovprodOld.getMovendaprodpharmaCollection().remove(movendaprodpharma);
                codmovprodOld = em.merge(codmovprodOld);
            }
            if (codmovprodNew != null && !codmovprodNew.equals(codmovprodOld)) {
                codmovprodNew.getMovendaprodpharmaCollection().add(movendaprodpharma);
                codmovprodNew = em.merge(codmovprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = movendaprodpharma.getCodmovprodpharma();
                if (findMovendaprodpharma(id) == null) {
                    throw new NonexistentEntityException("The movendaprodpharma with id " + id + " no longer exists.");
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
            Movendaprodpharma movendaprodpharma;
            try {
                movendaprodpharma = em.getReference(Movendaprodpharma.class, id);
                movendaprodpharma.getCodmovprodpharma();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movendaprodpharma with id " + id + " no longer exists.", enfe);
            }
            Movendaprod codmovprod = movendaprodpharma.getCodmovprod();
            if (codmovprod != null) {
                codmovprod.getMovendaprodpharmaCollection().remove(movendaprodpharma);
                codmovprod = em.merge(codmovprod);
            }
            em.remove(movendaprodpharma);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movendaprodpharma> findMovendaprodpharmaEntities() {
        return findMovendaprodpharmaEntities(true, -1, -1);
    }

    public List<Movendaprodpharma> findMovendaprodpharmaEntities(int maxResults, int firstResult) {
        return findMovendaprodpharmaEntities(false, maxResults, firstResult);
    }

    private List<Movendaprodpharma> findMovendaprodpharmaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movendaprodpharma.class));
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

    public Movendaprodpharma findMovendaprodpharma(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movendaprodpharma.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovendaprodpharmaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movendaprodpharma> rt = cq.from(Movendaprodpharma.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

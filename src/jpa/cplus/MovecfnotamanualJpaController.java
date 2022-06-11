/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Movecfnotamanual;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Movenda;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MovecfnotamanualJpaController implements Serializable {

    public MovecfnotamanualJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movecfnotamanual movecfnotamanual) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movenda codmovenda = movecfnotamanual.getCodmovenda();
            if (codmovenda != null) {
                codmovenda = em.getReference(codmovenda.getClass(), codmovenda.getCodmovenda());
                movecfnotamanual.setCodmovenda(codmovenda);
            }
            em.persist(movecfnotamanual);
            if (codmovenda != null) {
                codmovenda.getMovecfnotamanualCollection().add(movecfnotamanual);
                codmovenda = em.merge(codmovenda);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovecfnotamanual(movecfnotamanual.getCodmovecfnotamanual()) != null) {
                throw new PreexistingEntityException("Movecfnotamanual " + movecfnotamanual + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movecfnotamanual movecfnotamanual) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movecfnotamanual persistentMovecfnotamanual = em.find(Movecfnotamanual.class, movecfnotamanual.getCodmovecfnotamanual());
            Movenda codmovendaOld = persistentMovecfnotamanual.getCodmovenda();
            Movenda codmovendaNew = movecfnotamanual.getCodmovenda();
            if (codmovendaNew != null) {
                codmovendaNew = em.getReference(codmovendaNew.getClass(), codmovendaNew.getCodmovenda());
                movecfnotamanual.setCodmovenda(codmovendaNew);
            }
            movecfnotamanual = em.merge(movecfnotamanual);
            if (codmovendaOld != null && !codmovendaOld.equals(codmovendaNew)) {
                codmovendaOld.getMovecfnotamanualCollection().remove(movecfnotamanual);
                codmovendaOld = em.merge(codmovendaOld);
            }
            if (codmovendaNew != null && !codmovendaNew.equals(codmovendaOld)) {
                codmovendaNew.getMovecfnotamanualCollection().add(movecfnotamanual);
                codmovendaNew = em.merge(codmovendaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = movecfnotamanual.getCodmovecfnotamanual();
                if (findMovecfnotamanual(id) == null) {
                    throw new NonexistentEntityException("The movecfnotamanual with id " + id + " no longer exists.");
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
            Movecfnotamanual movecfnotamanual;
            try {
                movecfnotamanual = em.getReference(Movecfnotamanual.class, id);
                movecfnotamanual.getCodmovecfnotamanual();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movecfnotamanual with id " + id + " no longer exists.", enfe);
            }
            Movenda codmovenda = movecfnotamanual.getCodmovenda();
            if (codmovenda != null) {
                codmovenda.getMovecfnotamanualCollection().remove(movecfnotamanual);
                codmovenda = em.merge(codmovenda);
            }
            em.remove(movecfnotamanual);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movecfnotamanual> findMovecfnotamanualEntities() {
        return findMovecfnotamanualEntities(true, -1, -1);
    }

    public List<Movecfnotamanual> findMovecfnotamanualEntities(int maxResults, int firstResult) {
        return findMovecfnotamanualEntities(false, maxResults, firstResult);
    }

    private List<Movecfnotamanual> findMovecfnotamanualEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movecfnotamanual.class));
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

    public Movecfnotamanual findMovecfnotamanual(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movecfnotamanual.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovecfnotamanualCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movecfnotamanual> rt = cq.from(Movecfnotamanual.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

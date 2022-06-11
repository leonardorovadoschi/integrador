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
import entidade.cplus.Movenda;
import entidade.cplus.Moventrada;
import entidade.cplus.Moventradadocref;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MoventradadocrefJpaController implements Serializable {

    public MoventradadocrefJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Moventradadocref moventradadocref) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movenda codmovenda = moventradadocref.getCodmovenda();
            if (codmovenda != null) {
                codmovenda = em.getReference(codmovenda.getClass(), codmovenda.getCodmovenda());
                moventradadocref.setCodmovenda(codmovenda);
            }
            Moventrada codmoventr = moventradadocref.getCodmoventr();
            if (codmoventr != null) {
                codmoventr = em.getReference(codmoventr.getClass(), codmoventr.getCodmoventr());
                moventradadocref.setCodmoventr(codmoventr);
            }
            em.persist(moventradadocref);
            if (codmovenda != null) {
                codmovenda.getMoventradadocrefCollection().add(moventradadocref);
                codmovenda = em.merge(codmovenda);
            }
            if (codmoventr != null) {
                codmoventr.getMoventradadocrefCollection().add(moventradadocref);
                codmoventr = em.merge(codmoventr);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMoventradadocref(moventradadocref.getCodmoventradadocref()) != null) {
                throw new PreexistingEntityException("Moventradadocref " + moventradadocref + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Moventradadocref moventradadocref) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Moventradadocref persistentMoventradadocref = em.find(Moventradadocref.class, moventradadocref.getCodmoventradadocref());
            Movenda codmovendaOld = persistentMoventradadocref.getCodmovenda();
            Movenda codmovendaNew = moventradadocref.getCodmovenda();
            Moventrada codmoventrOld = persistentMoventradadocref.getCodmoventr();
            Moventrada codmoventrNew = moventradadocref.getCodmoventr();
            if (codmovendaNew != null) {
                codmovendaNew = em.getReference(codmovendaNew.getClass(), codmovendaNew.getCodmovenda());
                moventradadocref.setCodmovenda(codmovendaNew);
            }
            if (codmoventrNew != null) {
                codmoventrNew = em.getReference(codmoventrNew.getClass(), codmoventrNew.getCodmoventr());
                moventradadocref.setCodmoventr(codmoventrNew);
            }
            moventradadocref = em.merge(moventradadocref);
            if (codmovendaOld != null && !codmovendaOld.equals(codmovendaNew)) {
                codmovendaOld.getMoventradadocrefCollection().remove(moventradadocref);
                codmovendaOld = em.merge(codmovendaOld);
            }
            if (codmovendaNew != null && !codmovendaNew.equals(codmovendaOld)) {
                codmovendaNew.getMoventradadocrefCollection().add(moventradadocref);
                codmovendaNew = em.merge(codmovendaNew);
            }
            if (codmoventrOld != null && !codmoventrOld.equals(codmoventrNew)) {
                codmoventrOld.getMoventradadocrefCollection().remove(moventradadocref);
                codmoventrOld = em.merge(codmoventrOld);
            }
            if (codmoventrNew != null && !codmoventrNew.equals(codmoventrOld)) {
                codmoventrNew.getMoventradadocrefCollection().add(moventradadocref);
                codmoventrNew = em.merge(codmoventrNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = moventradadocref.getCodmoventradadocref();
                if (findMoventradadocref(id) == null) {
                    throw new NonexistentEntityException("The moventradadocref with id " + id + " no longer exists.");
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
            Moventradadocref moventradadocref;
            try {
                moventradadocref = em.getReference(Moventradadocref.class, id);
                moventradadocref.getCodmoventradadocref();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The moventradadocref with id " + id + " no longer exists.", enfe);
            }
            Movenda codmovenda = moventradadocref.getCodmovenda();
            if (codmovenda != null) {
                codmovenda.getMoventradadocrefCollection().remove(moventradadocref);
                codmovenda = em.merge(codmovenda);
            }
            Moventrada codmoventr = moventradadocref.getCodmoventr();
            if (codmoventr != null) {
                codmoventr.getMoventradadocrefCollection().remove(moventradadocref);
                codmoventr = em.merge(codmoventr);
            }
            em.remove(moventradadocref);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Moventradadocref> findMoventradadocrefEntities() {
        return findMoventradadocrefEntities(true, -1, -1);
    }

    public List<Moventradadocref> findMoventradadocrefEntities(int maxResults, int firstResult) {
        return findMoventradadocrefEntities(false, maxResults, firstResult);
    }

    private List<Moventradadocref> findMoventradadocrefEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Moventradadocref.class));
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

    public Moventradadocref findMoventradadocref(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Moventradadocref.class, id);
        } finally {
            em.close();
        }
    }

    public int getMoventradadocrefCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Moventradadocref> rt = cq.from(Moventradadocref.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

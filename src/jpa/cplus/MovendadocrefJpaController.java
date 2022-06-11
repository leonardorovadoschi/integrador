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
import entidade.cplus.Movendadocref;
import entidade.cplus.Moventrada;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MovendadocrefJpaController implements Serializable {

    public MovendadocrefJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movendadocref movendadocref) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movenda codmovenda = movendadocref.getCodmovenda();
            if (codmovenda != null) {
                codmovenda = em.getReference(codmovenda.getClass(), codmovenda.getCodmovenda());
                movendadocref.setCodmovenda(codmovenda);
            }
            Moventrada codmoventr = movendadocref.getCodmoventr();
            if (codmoventr != null) {
                codmoventr = em.getReference(codmoventr.getClass(), codmoventr.getCodmoventr());
                movendadocref.setCodmoventr(codmoventr);
            }
            em.persist(movendadocref);
            if (codmovenda != null) {
                codmovenda.getMovendadocrefCollection().add(movendadocref);
                codmovenda = em.merge(codmovenda);
            }
            if (codmoventr != null) {
                codmoventr.getMovendadocrefCollection().add(movendadocref);
                codmoventr = em.merge(codmoventr);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovendadocref(movendadocref.getCodmovendadocref()) != null) {
                throw new PreexistingEntityException("Movendadocref " + movendadocref + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movendadocref movendadocref) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movendadocref persistentMovendadocref = em.find(Movendadocref.class, movendadocref.getCodmovendadocref());
            Movenda codmovendaOld = persistentMovendadocref.getCodmovenda();
            Movenda codmovendaNew = movendadocref.getCodmovenda();
            Moventrada codmoventrOld = persistentMovendadocref.getCodmoventr();
            Moventrada codmoventrNew = movendadocref.getCodmoventr();
            if (codmovendaNew != null) {
                codmovendaNew = em.getReference(codmovendaNew.getClass(), codmovendaNew.getCodmovenda());
                movendadocref.setCodmovenda(codmovendaNew);
            }
            if (codmoventrNew != null) {
                codmoventrNew = em.getReference(codmoventrNew.getClass(), codmoventrNew.getCodmoventr());
                movendadocref.setCodmoventr(codmoventrNew);
            }
            movendadocref = em.merge(movendadocref);
            if (codmovendaOld != null && !codmovendaOld.equals(codmovendaNew)) {
                codmovendaOld.getMovendadocrefCollection().remove(movendadocref);
                codmovendaOld = em.merge(codmovendaOld);
            }
            if (codmovendaNew != null && !codmovendaNew.equals(codmovendaOld)) {
                codmovendaNew.getMovendadocrefCollection().add(movendadocref);
                codmovendaNew = em.merge(codmovendaNew);
            }
            if (codmoventrOld != null && !codmoventrOld.equals(codmoventrNew)) {
                codmoventrOld.getMovendadocrefCollection().remove(movendadocref);
                codmoventrOld = em.merge(codmoventrOld);
            }
            if (codmoventrNew != null && !codmoventrNew.equals(codmoventrOld)) {
                codmoventrNew.getMovendadocrefCollection().add(movendadocref);
                codmoventrNew = em.merge(codmoventrNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = movendadocref.getCodmovendadocref();
                if (findMovendadocref(id) == null) {
                    throw new NonexistentEntityException("The movendadocref with id " + id + " no longer exists.");
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
            Movendadocref movendadocref;
            try {
                movendadocref = em.getReference(Movendadocref.class, id);
                movendadocref.getCodmovendadocref();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movendadocref with id " + id + " no longer exists.", enfe);
            }
            Movenda codmovenda = movendadocref.getCodmovenda();
            if (codmovenda != null) {
                codmovenda.getMovendadocrefCollection().remove(movendadocref);
                codmovenda = em.merge(codmovenda);
            }
            Moventrada codmoventr = movendadocref.getCodmoventr();
            if (codmoventr != null) {
                codmoventr.getMovendadocrefCollection().remove(movendadocref);
                codmoventr = em.merge(codmoventr);
            }
            em.remove(movendadocref);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movendadocref> findMovendadocrefEntities() {
        return findMovendadocrefEntities(true, -1, -1);
    }

    public List<Movendadocref> findMovendadocrefEntities(int maxResults, int firstResult) {
        return findMovendadocrefEntities(false, maxResults, firstResult);
    }

    private List<Movendadocref> findMovendadocrefEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movendadocref.class));
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

    public Movendadocref findMovendadocref(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movendadocref.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovendadocrefCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movendadocref> rt = cq.from(Movendadocref.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

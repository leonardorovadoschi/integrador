/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Movcfesat;
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
public class MovcfesatJpaController implements Serializable {

    public MovcfesatJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movcfesat movcfesat) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movenda codmovenda = movcfesat.getCodmovenda();
            if (codmovenda != null) {
                codmovenda = em.getReference(codmovenda.getClass(), codmovenda.getCodmovenda());
                movcfesat.setCodmovenda(codmovenda);
            }
            em.persist(movcfesat);
            if (codmovenda != null) {
                codmovenda.getMovcfesatCollection().add(movcfesat);
                codmovenda = em.merge(codmovenda);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovcfesat(movcfesat.getCodmovcfesat()) != null) {
                throw new PreexistingEntityException("Movcfesat " + movcfesat + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movcfesat movcfesat) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movcfesat persistentMovcfesat = em.find(Movcfesat.class, movcfesat.getCodmovcfesat());
            Movenda codmovendaOld = persistentMovcfesat.getCodmovenda();
            Movenda codmovendaNew = movcfesat.getCodmovenda();
            if (codmovendaNew != null) {
                codmovendaNew = em.getReference(codmovendaNew.getClass(), codmovendaNew.getCodmovenda());
                movcfesat.setCodmovenda(codmovendaNew);
            }
            movcfesat = em.merge(movcfesat);
            if (codmovendaOld != null && !codmovendaOld.equals(codmovendaNew)) {
                codmovendaOld.getMovcfesatCollection().remove(movcfesat);
                codmovendaOld = em.merge(codmovendaOld);
            }
            if (codmovendaNew != null && !codmovendaNew.equals(codmovendaOld)) {
                codmovendaNew.getMovcfesatCollection().add(movcfesat);
                codmovendaNew = em.merge(codmovendaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = movcfesat.getCodmovcfesat();
                if (findMovcfesat(id) == null) {
                    throw new NonexistentEntityException("The movcfesat with id " + id + " no longer exists.");
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
            Movcfesat movcfesat;
            try {
                movcfesat = em.getReference(Movcfesat.class, id);
                movcfesat.getCodmovcfesat();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movcfesat with id " + id + " no longer exists.", enfe);
            }
            Movenda codmovenda = movcfesat.getCodmovenda();
            if (codmovenda != null) {
                codmovenda.getMovcfesatCollection().remove(movcfesat);
                codmovenda = em.merge(codmovenda);
            }
            em.remove(movcfesat);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movcfesat> findMovcfesatEntities() {
        return findMovcfesatEntities(true, -1, -1);
    }

    public List<Movcfesat> findMovcfesatEntities(int maxResults, int firstResult) {
        return findMovcfesatEntities(false, maxResults, firstResult);
    }

    private List<Movcfesat> findMovcfesatEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movcfesat.class));
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

    public Movcfesat findMovcfesat(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movcfesat.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovcfesatCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movcfesat> rt = cq.from(Movcfesat.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

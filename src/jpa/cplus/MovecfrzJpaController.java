/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Movecfrz;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Movecfrzitem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MovecfrzJpaController implements Serializable {

    public MovecfrzJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movecfrz movecfrz) throws PreexistingEntityException, Exception {
        if (movecfrz.getMovecfrzitemCollection() == null) {
            movecfrz.setMovecfrzitemCollection(new ArrayList<Movecfrzitem>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Movecfrzitem> attachedMovecfrzitemCollection = new ArrayList<Movecfrzitem>();
            for (Movecfrzitem movecfrzitemCollectionMovecfrzitemToAttach : movecfrz.getMovecfrzitemCollection()) {
                movecfrzitemCollectionMovecfrzitemToAttach = em.getReference(movecfrzitemCollectionMovecfrzitemToAttach.getClass(), movecfrzitemCollectionMovecfrzitemToAttach.getCodmovecfrzitem());
                attachedMovecfrzitemCollection.add(movecfrzitemCollectionMovecfrzitemToAttach);
            }
            movecfrz.setMovecfrzitemCollection(attachedMovecfrzitemCollection);
            em.persist(movecfrz);
            for (Movecfrzitem movecfrzitemCollectionMovecfrzitem : movecfrz.getMovecfrzitemCollection()) {
                Movecfrz oldCodmovecfrzOfMovecfrzitemCollectionMovecfrzitem = movecfrzitemCollectionMovecfrzitem.getCodmovecfrz();
                movecfrzitemCollectionMovecfrzitem.setCodmovecfrz(movecfrz);
                movecfrzitemCollectionMovecfrzitem = em.merge(movecfrzitemCollectionMovecfrzitem);
                if (oldCodmovecfrzOfMovecfrzitemCollectionMovecfrzitem != null) {
                    oldCodmovecfrzOfMovecfrzitemCollectionMovecfrzitem.getMovecfrzitemCollection().remove(movecfrzitemCollectionMovecfrzitem);
                    oldCodmovecfrzOfMovecfrzitemCollectionMovecfrzitem = em.merge(oldCodmovecfrzOfMovecfrzitemCollectionMovecfrzitem);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovecfrz(movecfrz.getCodmovecfrz()) != null) {
                throw new PreexistingEntityException("Movecfrz " + movecfrz + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movecfrz movecfrz) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movecfrz persistentMovecfrz = em.find(Movecfrz.class, movecfrz.getCodmovecfrz());
            Collection<Movecfrzitem> movecfrzitemCollectionOld = persistentMovecfrz.getMovecfrzitemCollection();
            Collection<Movecfrzitem> movecfrzitemCollectionNew = movecfrz.getMovecfrzitemCollection();
            Collection<Movecfrzitem> attachedMovecfrzitemCollectionNew = new ArrayList<Movecfrzitem>();
            for (Movecfrzitem movecfrzitemCollectionNewMovecfrzitemToAttach : movecfrzitemCollectionNew) {
                movecfrzitemCollectionNewMovecfrzitemToAttach = em.getReference(movecfrzitemCollectionNewMovecfrzitemToAttach.getClass(), movecfrzitemCollectionNewMovecfrzitemToAttach.getCodmovecfrzitem());
                attachedMovecfrzitemCollectionNew.add(movecfrzitemCollectionNewMovecfrzitemToAttach);
            }
            movecfrzitemCollectionNew = attachedMovecfrzitemCollectionNew;
            movecfrz.setMovecfrzitemCollection(movecfrzitemCollectionNew);
            movecfrz = em.merge(movecfrz);
            for (Movecfrzitem movecfrzitemCollectionOldMovecfrzitem : movecfrzitemCollectionOld) {
                if (!movecfrzitemCollectionNew.contains(movecfrzitemCollectionOldMovecfrzitem)) {
                    movecfrzitemCollectionOldMovecfrzitem.setCodmovecfrz(null);
                    movecfrzitemCollectionOldMovecfrzitem = em.merge(movecfrzitemCollectionOldMovecfrzitem);
                }
            }
            for (Movecfrzitem movecfrzitemCollectionNewMovecfrzitem : movecfrzitemCollectionNew) {
                if (!movecfrzitemCollectionOld.contains(movecfrzitemCollectionNewMovecfrzitem)) {
                    Movecfrz oldCodmovecfrzOfMovecfrzitemCollectionNewMovecfrzitem = movecfrzitemCollectionNewMovecfrzitem.getCodmovecfrz();
                    movecfrzitemCollectionNewMovecfrzitem.setCodmovecfrz(movecfrz);
                    movecfrzitemCollectionNewMovecfrzitem = em.merge(movecfrzitemCollectionNewMovecfrzitem);
                    if (oldCodmovecfrzOfMovecfrzitemCollectionNewMovecfrzitem != null && !oldCodmovecfrzOfMovecfrzitemCollectionNewMovecfrzitem.equals(movecfrz)) {
                        oldCodmovecfrzOfMovecfrzitemCollectionNewMovecfrzitem.getMovecfrzitemCollection().remove(movecfrzitemCollectionNewMovecfrzitem);
                        oldCodmovecfrzOfMovecfrzitemCollectionNewMovecfrzitem = em.merge(oldCodmovecfrzOfMovecfrzitemCollectionNewMovecfrzitem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = movecfrz.getCodmovecfrz();
                if (findMovecfrz(id) == null) {
                    throw new NonexistentEntityException("The movecfrz with id " + id + " no longer exists.");
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
            Movecfrz movecfrz;
            try {
                movecfrz = em.getReference(Movecfrz.class, id);
                movecfrz.getCodmovecfrz();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movecfrz with id " + id + " no longer exists.", enfe);
            }
            Collection<Movecfrzitem> movecfrzitemCollection = movecfrz.getMovecfrzitemCollection();
            for (Movecfrzitem movecfrzitemCollectionMovecfrzitem : movecfrzitemCollection) {
                movecfrzitemCollectionMovecfrzitem.setCodmovecfrz(null);
                movecfrzitemCollectionMovecfrzitem = em.merge(movecfrzitemCollectionMovecfrzitem);
            }
            em.remove(movecfrz);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movecfrz> findMovecfrzEntities() {
        return findMovecfrzEntities(true, -1, -1);
    }

    public List<Movecfrz> findMovecfrzEntities(int maxResults, int firstResult) {
        return findMovecfrzEntities(false, maxResults, firstResult);
    }

    private List<Movecfrz> findMovecfrzEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movecfrz.class));
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

    public Movecfrz findMovecfrz(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movecfrz.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovecfrzCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movecfrz> rt = cq.from(Movecfrz.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

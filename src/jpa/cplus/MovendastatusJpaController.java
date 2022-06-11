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
import entidade.cplus.Movendastatus;
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
public class MovendastatusJpaController implements Serializable {

    public MovendastatusJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movendastatus movendastatus) throws PreexistingEntityException, Exception {
        if (movendastatus.getMovendaCollection() == null) {
            movendastatus.setMovendaCollection(new ArrayList<Movenda>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Movenda> attachedMovendaCollection = new ArrayList<Movenda>();
            for (Movenda movendaCollectionMovendaToAttach : movendastatus.getMovendaCollection()) {
                movendaCollectionMovendaToAttach = em.getReference(movendaCollectionMovendaToAttach.getClass(), movendaCollectionMovendaToAttach.getCodmovenda());
                attachedMovendaCollection.add(movendaCollectionMovendaToAttach);
            }
            movendastatus.setMovendaCollection(attachedMovendaCollection);
            em.persist(movendastatus);
            for (Movenda movendaCollectionMovenda : movendastatus.getMovendaCollection()) {
                Movendastatus oldCodmovendastatusOfMovendaCollectionMovenda = movendaCollectionMovenda.getCodmovendastatus();
                movendaCollectionMovenda.setCodmovendastatus(movendastatus);
                movendaCollectionMovenda = em.merge(movendaCollectionMovenda);
                if (oldCodmovendastatusOfMovendaCollectionMovenda != null) {
                    oldCodmovendastatusOfMovendaCollectionMovenda.getMovendaCollection().remove(movendaCollectionMovenda);
                    oldCodmovendastatusOfMovendaCollectionMovenda = em.merge(oldCodmovendastatusOfMovendaCollectionMovenda);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovendastatus(movendastatus.getCodmovendastatus()) != null) {
                throw new PreexistingEntityException("Movendastatus " + movendastatus + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movendastatus movendastatus) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movendastatus persistentMovendastatus = em.find(Movendastatus.class, movendastatus.getCodmovendastatus());
            Collection<Movenda> movendaCollectionOld = persistentMovendastatus.getMovendaCollection();
            Collection<Movenda> movendaCollectionNew = movendastatus.getMovendaCollection();
            Collection<Movenda> attachedMovendaCollectionNew = new ArrayList<Movenda>();
            for (Movenda movendaCollectionNewMovendaToAttach : movendaCollectionNew) {
                movendaCollectionNewMovendaToAttach = em.getReference(movendaCollectionNewMovendaToAttach.getClass(), movendaCollectionNewMovendaToAttach.getCodmovenda());
                attachedMovendaCollectionNew.add(movendaCollectionNewMovendaToAttach);
            }
            movendaCollectionNew = attachedMovendaCollectionNew;
            movendastatus.setMovendaCollection(movendaCollectionNew);
            movendastatus = em.merge(movendastatus);
            for (Movenda movendaCollectionOldMovenda : movendaCollectionOld) {
                if (!movendaCollectionNew.contains(movendaCollectionOldMovenda)) {
                    movendaCollectionOldMovenda.setCodmovendastatus(null);
                    movendaCollectionOldMovenda = em.merge(movendaCollectionOldMovenda);
                }
            }
            for (Movenda movendaCollectionNewMovenda : movendaCollectionNew) {
                if (!movendaCollectionOld.contains(movendaCollectionNewMovenda)) {
                    Movendastatus oldCodmovendastatusOfMovendaCollectionNewMovenda = movendaCollectionNewMovenda.getCodmovendastatus();
                    movendaCollectionNewMovenda.setCodmovendastatus(movendastatus);
                    movendaCollectionNewMovenda = em.merge(movendaCollectionNewMovenda);
                    if (oldCodmovendastatusOfMovendaCollectionNewMovenda != null && !oldCodmovendastatusOfMovendaCollectionNewMovenda.equals(movendastatus)) {
                        oldCodmovendastatusOfMovendaCollectionNewMovenda.getMovendaCollection().remove(movendaCollectionNewMovenda);
                        oldCodmovendastatusOfMovendaCollectionNewMovenda = em.merge(oldCodmovendastatusOfMovendaCollectionNewMovenda);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = movendastatus.getCodmovendastatus();
                if (findMovendastatus(id) == null) {
                    throw new NonexistentEntityException("The movendastatus with id " + id + " no longer exists.");
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
            Movendastatus movendastatus;
            try {
                movendastatus = em.getReference(Movendastatus.class, id);
                movendastatus.getCodmovendastatus();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movendastatus with id " + id + " no longer exists.", enfe);
            }
            Collection<Movenda> movendaCollection = movendastatus.getMovendaCollection();
            for (Movenda movendaCollectionMovenda : movendaCollection) {
                movendaCollectionMovenda.setCodmovendastatus(null);
                movendaCollectionMovenda = em.merge(movendaCollectionMovenda);
            }
            em.remove(movendastatus);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movendastatus> findMovendastatusEntities() {
        return findMovendastatusEntities(true, -1, -1);
    }

    public List<Movendastatus> findMovendastatusEntities(int maxResults, int firstResult) {
        return findMovendastatusEntities(false, maxResults, firstResult);
    }

    private List<Movendastatus> findMovendastatusEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movendastatus.class));
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

    public Movendastatus findMovendastatus(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movendastatus.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovendastatusCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movendastatus> rt = cq.from(Movendastatus.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

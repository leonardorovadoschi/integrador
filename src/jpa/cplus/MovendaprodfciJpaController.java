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
import entidade.cplus.Movendaprodfci;
import entidade.cplus.Produtofci;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MovendaprodfciJpaController implements Serializable {

    public MovendaprodfciJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movendaprodfci movendaprodfci) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movendaprod codmovprod = movendaprodfci.getCodmovprod();
            if (codmovprod != null) {
                codmovprod = em.getReference(codmovprod.getClass(), codmovprod.getCodmovprod());
                movendaprodfci.setCodmovprod(codmovprod);
            }
            Produtofci codprodutofci = movendaprodfci.getCodprodutofci();
            if (codprodutofci != null) {
                codprodutofci = em.getReference(codprodutofci.getClass(), codprodutofci.getCodprodutofci());
                movendaprodfci.setCodprodutofci(codprodutofci);
            }
            em.persist(movendaprodfci);
            if (codmovprod != null) {
                codmovprod.getMovendaprodfciCollection().add(movendaprodfci);
                codmovprod = em.merge(codmovprod);
            }
            if (codprodutofci != null) {
                codprodutofci.getMovendaprodfciCollection().add(movendaprodfci);
                codprodutofci = em.merge(codprodutofci);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovendaprodfci(movendaprodfci.getCodmovendaprodfci()) != null) {
                throw new PreexistingEntityException("Movendaprodfci " + movendaprodfci + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movendaprodfci movendaprodfci) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movendaprodfci persistentMovendaprodfci = em.find(Movendaprodfci.class, movendaprodfci.getCodmovendaprodfci());
            Movendaprod codmovprodOld = persistentMovendaprodfci.getCodmovprod();
            Movendaprod codmovprodNew = movendaprodfci.getCodmovprod();
            Produtofci codprodutofciOld = persistentMovendaprodfci.getCodprodutofci();
            Produtofci codprodutofciNew = movendaprodfci.getCodprodutofci();
            if (codmovprodNew != null) {
                codmovprodNew = em.getReference(codmovprodNew.getClass(), codmovprodNew.getCodmovprod());
                movendaprodfci.setCodmovprod(codmovprodNew);
            }
            if (codprodutofciNew != null) {
                codprodutofciNew = em.getReference(codprodutofciNew.getClass(), codprodutofciNew.getCodprodutofci());
                movendaprodfci.setCodprodutofci(codprodutofciNew);
            }
            movendaprodfci = em.merge(movendaprodfci);
            if (codmovprodOld != null && !codmovprodOld.equals(codmovprodNew)) {
                codmovprodOld.getMovendaprodfciCollection().remove(movendaprodfci);
                codmovprodOld = em.merge(codmovprodOld);
            }
            if (codmovprodNew != null && !codmovprodNew.equals(codmovprodOld)) {
                codmovprodNew.getMovendaprodfciCollection().add(movendaprodfci);
                codmovprodNew = em.merge(codmovprodNew);
            }
            if (codprodutofciOld != null && !codprodutofciOld.equals(codprodutofciNew)) {
                codprodutofciOld.getMovendaprodfciCollection().remove(movendaprodfci);
                codprodutofciOld = em.merge(codprodutofciOld);
            }
            if (codprodutofciNew != null && !codprodutofciNew.equals(codprodutofciOld)) {
                codprodutofciNew.getMovendaprodfciCollection().add(movendaprodfci);
                codprodutofciNew = em.merge(codprodutofciNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = movendaprodfci.getCodmovendaprodfci();
                if (findMovendaprodfci(id) == null) {
                    throw new NonexistentEntityException("The movendaprodfci with id " + id + " no longer exists.");
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
            Movendaprodfci movendaprodfci;
            try {
                movendaprodfci = em.getReference(Movendaprodfci.class, id);
                movendaprodfci.getCodmovendaprodfci();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movendaprodfci with id " + id + " no longer exists.", enfe);
            }
            Movendaprod codmovprod = movendaprodfci.getCodmovprod();
            if (codmovprod != null) {
                codmovprod.getMovendaprodfciCollection().remove(movendaprodfci);
                codmovprod = em.merge(codmovprod);
            }
            Produtofci codprodutofci = movendaprodfci.getCodprodutofci();
            if (codprodutofci != null) {
                codprodutofci.getMovendaprodfciCollection().remove(movendaprodfci);
                codprodutofci = em.merge(codprodutofci);
            }
            em.remove(movendaprodfci);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movendaprodfci> findMovendaprodfciEntities() {
        return findMovendaprodfciEntities(true, -1, -1);
    }

    public List<Movendaprodfci> findMovendaprodfciEntities(int maxResults, int firstResult) {
        return findMovendaprodfciEntities(false, maxResults, firstResult);
    }

    private List<Movendaprodfci> findMovendaprodfciEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movendaprodfci.class));
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

    public Movendaprodfci findMovendaprodfci(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movendaprodfci.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovendaprodfciCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movendaprodfci> rt = cq.from(Movendaprodfci.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
import entidade.cplus.Movendaprodcomp;
import entidade.cplus.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MovendaprodcompJpaController implements Serializable {

    public MovendaprodcompJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movendaprodcomp movendaprodcomp) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movendaprod codmovprod = movendaprodcomp.getCodmovprod();
            if (codmovprod != null) {
                codmovprod = em.getReference(codmovprod.getClass(), codmovprod.getCodmovprod());
                movendaprodcomp.setCodmovprod(codmovprod);
            }
            Produto codprod = movendaprodcomp.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                movendaprodcomp.setCodprod(codprod);
            }
            em.persist(movendaprodcomp);
            if (codmovprod != null) {
                codmovprod.getMovendaprodcompCollection().add(movendaprodcomp);
                codmovprod = em.merge(codmovprod);
            }
            if (codprod != null) {
                codprod.getMovendaprodcompCollection().add(movendaprodcomp);
                codprod = em.merge(codprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovendaprodcomp(movendaprodcomp.getCodmovendaprodcomp()) != null) {
                throw new PreexistingEntityException("Movendaprodcomp " + movendaprodcomp + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movendaprodcomp movendaprodcomp) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movendaprodcomp persistentMovendaprodcomp = em.find(Movendaprodcomp.class, movendaprodcomp.getCodmovendaprodcomp());
            Movendaprod codmovprodOld = persistentMovendaprodcomp.getCodmovprod();
            Movendaprod codmovprodNew = movendaprodcomp.getCodmovprod();
            Produto codprodOld = persistentMovendaprodcomp.getCodprod();
            Produto codprodNew = movendaprodcomp.getCodprod();
            if (codmovprodNew != null) {
                codmovprodNew = em.getReference(codmovprodNew.getClass(), codmovprodNew.getCodmovprod());
                movendaprodcomp.setCodmovprod(codmovprodNew);
            }
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                movendaprodcomp.setCodprod(codprodNew);
            }
            movendaprodcomp = em.merge(movendaprodcomp);
            if (codmovprodOld != null && !codmovprodOld.equals(codmovprodNew)) {
                codmovprodOld.getMovendaprodcompCollection().remove(movendaprodcomp);
                codmovprodOld = em.merge(codmovprodOld);
            }
            if (codmovprodNew != null && !codmovprodNew.equals(codmovprodOld)) {
                codmovprodNew.getMovendaprodcompCollection().add(movendaprodcomp);
                codmovprodNew = em.merge(codmovprodNew);
            }
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getMovendaprodcompCollection().remove(movendaprodcomp);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getMovendaprodcompCollection().add(movendaprodcomp);
                codprodNew = em.merge(codprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = movendaprodcomp.getCodmovendaprodcomp();
                if (findMovendaprodcomp(id) == null) {
                    throw new NonexistentEntityException("The movendaprodcomp with id " + id + " no longer exists.");
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
            Movendaprodcomp movendaprodcomp;
            try {
                movendaprodcomp = em.getReference(Movendaprodcomp.class, id);
                movendaprodcomp.getCodmovendaprodcomp();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movendaprodcomp with id " + id + " no longer exists.", enfe);
            }
            Movendaprod codmovprod = movendaprodcomp.getCodmovprod();
            if (codmovprod != null) {
                codmovprod.getMovendaprodcompCollection().remove(movendaprodcomp);
                codmovprod = em.merge(codmovprod);
            }
            Produto codprod = movendaprodcomp.getCodprod();
            if (codprod != null) {
                codprod.getMovendaprodcompCollection().remove(movendaprodcomp);
                codprod = em.merge(codprod);
            }
            em.remove(movendaprodcomp);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movendaprodcomp> findMovendaprodcompEntities() {
        return findMovendaprodcompEntities(true, -1, -1);
    }

    public List<Movendaprodcomp> findMovendaprodcompEntities(int maxResults, int firstResult) {
        return findMovendaprodcompEntities(false, maxResults, firstResult);
    }

    private List<Movendaprodcomp> findMovendaprodcompEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movendaprodcomp.class));
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

    public Movendaprodcomp findMovendaprodcomp(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movendaprodcomp.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovendaprodcompCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movendaprodcomp> rt = cq.from(Movendaprodcomp.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
import entidade.cplus.Moventradaprod;
import entidade.cplus.Moventradaprodcomp;
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
public class MoventradaprodcompJpaController implements Serializable {

    public MoventradaprodcompJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Moventradaprodcomp moventradaprodcomp) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Moventradaprod codmoveprod = moventradaprodcomp.getCodmoveprod();
            if (codmoveprod != null) {
                codmoveprod = em.getReference(codmoveprod.getClass(), codmoveprod.getCodmoveprod());
                moventradaprodcomp.setCodmoveprod(codmoveprod);
            }
            Produto codprod = moventradaprodcomp.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                moventradaprodcomp.setCodprod(codprod);
            }
            em.persist(moventradaprodcomp);
            if (codmoveprod != null) {
                codmoveprod.getMoventradaprodcompCollection().add(moventradaprodcomp);
                codmoveprod = em.merge(codmoveprod);
            }
            if (codprod != null) {
                codprod.getMoventradaprodcompCollection().add(moventradaprodcomp);
                codprod = em.merge(codprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMoventradaprodcomp(moventradaprodcomp.getCodmoventradaprodcomp()) != null) {
                throw new PreexistingEntityException("Moventradaprodcomp " + moventradaprodcomp + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Moventradaprodcomp moventradaprodcomp) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Moventradaprodcomp persistentMoventradaprodcomp = em.find(Moventradaprodcomp.class, moventradaprodcomp.getCodmoventradaprodcomp());
            Moventradaprod codmoveprodOld = persistentMoventradaprodcomp.getCodmoveprod();
            Moventradaprod codmoveprodNew = moventradaprodcomp.getCodmoveprod();
            Produto codprodOld = persistentMoventradaprodcomp.getCodprod();
            Produto codprodNew = moventradaprodcomp.getCodprod();
            if (codmoveprodNew != null) {
                codmoveprodNew = em.getReference(codmoveprodNew.getClass(), codmoveprodNew.getCodmoveprod());
                moventradaprodcomp.setCodmoveprod(codmoveprodNew);
            }
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                moventradaprodcomp.setCodprod(codprodNew);
            }
            moventradaprodcomp = em.merge(moventradaprodcomp);
            if (codmoveprodOld != null && !codmoveprodOld.equals(codmoveprodNew)) {
                codmoveprodOld.getMoventradaprodcompCollection().remove(moventradaprodcomp);
                codmoveprodOld = em.merge(codmoveprodOld);
            }
            if (codmoveprodNew != null && !codmoveprodNew.equals(codmoveprodOld)) {
                codmoveprodNew.getMoventradaprodcompCollection().add(moventradaprodcomp);
                codmoveprodNew = em.merge(codmoveprodNew);
            }
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getMoventradaprodcompCollection().remove(moventradaprodcomp);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getMoventradaprodcompCollection().add(moventradaprodcomp);
                codprodNew = em.merge(codprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = moventradaprodcomp.getCodmoventradaprodcomp();
                if (findMoventradaprodcomp(id) == null) {
                    throw new NonexistentEntityException("The moventradaprodcomp with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Moventradaprodcomp moventradaprodcomp;
            try {
                moventradaprodcomp = em.getReference(Moventradaprodcomp.class, id);
                moventradaprodcomp.getCodmoventradaprodcomp();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The moventradaprodcomp with id " + id + " no longer exists.", enfe);
            }
            Moventradaprod codmoveprod = moventradaprodcomp.getCodmoveprod();
            if (codmoveprod != null) {
                codmoveprod.getMoventradaprodcompCollection().remove(moventradaprodcomp);
                codmoveprod = em.merge(codmoveprod);
            }
            Produto codprod = moventradaprodcomp.getCodprod();
            if (codprod != null) {
                codprod.getMoventradaprodcompCollection().remove(moventradaprodcomp);
                codprod = em.merge(codprod);
            }
            em.remove(moventradaprodcomp);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Moventradaprodcomp> findMoventradaprodcompEntities() {
        return findMoventradaprodcompEntities(true, -1, -1);
    }

    public List<Moventradaprodcomp> findMoventradaprodcompEntities(int maxResults, int firstResult) {
        return findMoventradaprodcompEntities(false, maxResults, firstResult);
    }

    private List<Moventradaprodcomp> findMoventradaprodcompEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Moventradaprodcomp.class));
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

    public Moventradaprodcomp findMoventradaprodcomp(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Moventradaprodcomp.class, id);
        } finally {
            em.close();
        }
    }

    public int getMoventradaprodcompCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Moventradaprodcomp> rt = cq.from(Moventradaprodcomp.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

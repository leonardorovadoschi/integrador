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
import entidade.cplus.Ordemremessa;
import entidade.cplus.Ordemremessaprod;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class OrdemremessaprodJpaController implements Serializable {

    public OrdemremessaprodJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ordemremessaprod ordemremessaprod) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordemremessa codordremessa = ordemremessaprod.getCodordremessa();
            if (codordremessa != null) {
                codordremessa = em.getReference(codordremessa.getClass(), codordremessa.getCodordremessa());
                ordemremessaprod.setCodordremessa(codordremessa);
            }
            em.persist(ordemremessaprod);
            if (codordremessa != null) {
                codordremessa.getOrdemremessaprodCollection().add(ordemremessaprod);
                codordremessa = em.merge(codordremessa);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrdemremessaprod(ordemremessaprod.getCodordremessaprod()) != null) {
                throw new PreexistingEntityException("Ordemremessaprod " + ordemremessaprod + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ordemremessaprod ordemremessaprod) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordemremessaprod persistentOrdemremessaprod = em.find(Ordemremessaprod.class, ordemremessaprod.getCodordremessaprod());
            Ordemremessa codordremessaOld = persistentOrdemremessaprod.getCodordremessa();
            Ordemremessa codordremessaNew = ordemremessaprod.getCodordremessa();
            if (codordremessaNew != null) {
                codordremessaNew = em.getReference(codordremessaNew.getClass(), codordremessaNew.getCodordremessa());
                ordemremessaprod.setCodordremessa(codordremessaNew);
            }
            ordemremessaprod = em.merge(ordemremessaprod);
            if (codordremessaOld != null && !codordremessaOld.equals(codordremessaNew)) {
                codordremessaOld.getOrdemremessaprodCollection().remove(ordemremessaprod);
                codordremessaOld = em.merge(codordremessaOld);
            }
            if (codordremessaNew != null && !codordremessaNew.equals(codordremessaOld)) {
                codordremessaNew.getOrdemremessaprodCollection().add(ordemremessaprod);
                codordremessaNew = em.merge(codordremessaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ordemremessaprod.getCodordremessaprod();
                if (findOrdemremessaprod(id) == null) {
                    throw new NonexistentEntityException("The ordemremessaprod with id " + id + " no longer exists.");
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
            Ordemremessaprod ordemremessaprod;
            try {
                ordemremessaprod = em.getReference(Ordemremessaprod.class, id);
                ordemremessaprod.getCodordremessaprod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ordemremessaprod with id " + id + " no longer exists.", enfe);
            }
            Ordemremessa codordremessa = ordemremessaprod.getCodordremessa();
            if (codordremessa != null) {
                codordremessa.getOrdemremessaprodCollection().remove(ordemremessaprod);
                codordremessa = em.merge(codordremessa);
            }
            em.remove(ordemremessaprod);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ordemremessaprod> findOrdemremessaprodEntities() {
        return findOrdemremessaprodEntities(true, -1, -1);
    }

    public List<Ordemremessaprod> findOrdemremessaprodEntities(int maxResults, int firstResult) {
        return findOrdemremessaprodEntities(false, maxResults, firstResult);
    }

    private List<Ordemremessaprod> findOrdemremessaprodEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ordemremessaprod.class));
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

    public Ordemremessaprod findOrdemremessaprod(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ordemremessaprod.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrdemremessaprodCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ordemremessaprod> rt = cq.from(Ordemremessaprod.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

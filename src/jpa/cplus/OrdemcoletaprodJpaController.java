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
import entidade.cplus.Ordemcoleta;
import entidade.cplus.Ordemcoletaprod;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class OrdemcoletaprodJpaController implements Serializable {

    public OrdemcoletaprodJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ordemcoletaprod ordemcoletaprod) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordemcoleta codordcoleta = ordemcoletaprod.getCodordcoleta();
            if (codordcoleta != null) {
                codordcoleta = em.getReference(codordcoleta.getClass(), codordcoleta.getCodordcoleta());
                ordemcoletaprod.setCodordcoleta(codordcoleta);
            }
            em.persist(ordemcoletaprod);
            if (codordcoleta != null) {
                codordcoleta.getOrdemcoletaprodCollection().add(ordemcoletaprod);
                codordcoleta = em.merge(codordcoleta);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrdemcoletaprod(ordemcoletaprod.getCodordcoletaprod()) != null) {
                throw new PreexistingEntityException("Ordemcoletaprod " + ordemcoletaprod + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ordemcoletaprod ordemcoletaprod) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordemcoletaprod persistentOrdemcoletaprod = em.find(Ordemcoletaprod.class, ordemcoletaprod.getCodordcoletaprod());
            Ordemcoleta codordcoletaOld = persistentOrdemcoletaprod.getCodordcoleta();
            Ordemcoleta codordcoletaNew = ordemcoletaprod.getCodordcoleta();
            if (codordcoletaNew != null) {
                codordcoletaNew = em.getReference(codordcoletaNew.getClass(), codordcoletaNew.getCodordcoleta());
                ordemcoletaprod.setCodordcoleta(codordcoletaNew);
            }
            ordemcoletaprod = em.merge(ordemcoletaprod);
            if (codordcoletaOld != null && !codordcoletaOld.equals(codordcoletaNew)) {
                codordcoletaOld.getOrdemcoletaprodCollection().remove(ordemcoletaprod);
                codordcoletaOld = em.merge(codordcoletaOld);
            }
            if (codordcoletaNew != null && !codordcoletaNew.equals(codordcoletaOld)) {
                codordcoletaNew.getOrdemcoletaprodCollection().add(ordemcoletaprod);
                codordcoletaNew = em.merge(codordcoletaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ordemcoletaprod.getCodordcoletaprod();
                if (findOrdemcoletaprod(id) == null) {
                    throw new NonexistentEntityException("The ordemcoletaprod with id " + id + " no longer exists.");
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
            Ordemcoletaprod ordemcoletaprod;
            try {
                ordemcoletaprod = em.getReference(Ordemcoletaprod.class, id);
                ordemcoletaprod.getCodordcoletaprod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ordemcoletaprod with id " + id + " no longer exists.", enfe);
            }
            Ordemcoleta codordcoleta = ordemcoletaprod.getCodordcoleta();
            if (codordcoleta != null) {
                codordcoleta.getOrdemcoletaprodCollection().remove(ordemcoletaprod);
                codordcoleta = em.merge(codordcoleta);
            }
            em.remove(ordemcoletaprod);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ordemcoletaprod> findOrdemcoletaprodEntities() {
        return findOrdemcoletaprodEntities(true, -1, -1);
    }

    public List<Ordemcoletaprod> findOrdemcoletaprodEntities(int maxResults, int firstResult) {
        return findOrdemcoletaprodEntities(false, maxResults, firstResult);
    }

    private List<Ordemcoletaprod> findOrdemcoletaprodEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ordemcoletaprod.class));
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

    public Ordemcoletaprod findOrdemcoletaprod(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ordemcoletaprod.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrdemcoletaprodCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ordemcoletaprod> rt = cq.from(Ordemcoletaprod.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

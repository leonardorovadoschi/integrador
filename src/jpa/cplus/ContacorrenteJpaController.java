/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Contacorrente;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ContacorrenteJpaController implements Serializable {

    public ContacorrenteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Contacorrente contacorrente) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(contacorrente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findContacorrente(contacorrente.getCodcontacorrente()) != null) {
                throw new PreexistingEntityException("Contacorrente " + contacorrente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Contacorrente contacorrente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            contacorrente = em.merge(contacorrente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = contacorrente.getCodcontacorrente();
                if (findContacorrente(id) == null) {
                    throw new NonexistentEntityException("The contacorrente with id " + id + " no longer exists.");
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
            Contacorrente contacorrente;
            try {
                contacorrente = em.getReference(Contacorrente.class, id);
                contacorrente.getCodcontacorrente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The contacorrente with id " + id + " no longer exists.", enfe);
            }
            em.remove(contacorrente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Contacorrente> findContacorrenteEntities() {
        return findContacorrenteEntities(true, -1, -1);
    }

    public List<Contacorrente> findContacorrenteEntities(int maxResults, int firstResult) {
        return findContacorrenteEntities(false, maxResults, firstResult);
    }

    private List<Contacorrente> findContacorrenteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Contacorrente.class));
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

    public Contacorrente findContacorrente(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Contacorrente.class, id);
        } finally {
            em.close();
        }
    }

    public int getContacorrenteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Contacorrente> rt = cq.from(Contacorrente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

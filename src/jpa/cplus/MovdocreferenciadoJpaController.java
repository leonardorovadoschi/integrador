/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Movdocreferenciado;
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
public class MovdocreferenciadoJpaController implements Serializable {

    public MovdocreferenciadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movdocreferenciado movdocreferenciado) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(movdocreferenciado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovdocreferenciado(movdocreferenciado.getCodmovdocreferenciado()) != null) {
                throw new PreexistingEntityException("Movdocreferenciado " + movdocreferenciado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movdocreferenciado movdocreferenciado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            movdocreferenciado = em.merge(movdocreferenciado);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = movdocreferenciado.getCodmovdocreferenciado();
                if (findMovdocreferenciado(id) == null) {
                    throw new NonexistentEntityException("The movdocreferenciado with id " + id + " no longer exists.");
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
            Movdocreferenciado movdocreferenciado;
            try {
                movdocreferenciado = em.getReference(Movdocreferenciado.class, id);
                movdocreferenciado.getCodmovdocreferenciado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movdocreferenciado with id " + id + " no longer exists.", enfe);
            }
            em.remove(movdocreferenciado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movdocreferenciado> findMovdocreferenciadoEntities() {
        return findMovdocreferenciadoEntities(true, -1, -1);
    }

    public List<Movdocreferenciado> findMovdocreferenciadoEntities(int maxResults, int firstResult) {
        return findMovdocreferenciadoEntities(false, maxResults, firstResult);
    }

    private List<Movdocreferenciado> findMovdocreferenciadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movdocreferenciado.class));
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

    public Movdocreferenciado findMovdocreferenciado(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movdocreferenciado.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovdocreferenciadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movdocreferenciado> rt = cq.from(Movdocreferenciado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

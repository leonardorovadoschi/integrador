/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Movimentopdverro;
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
public class MovimentopdverroJpaController implements Serializable {

    public MovimentopdverroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movimentopdverro movimentopdverro) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(movimentopdverro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovimentopdverro(movimentopdverro.getCodmovimentopdverro()) != null) {
                throw new PreexistingEntityException("Movimentopdverro " + movimentopdverro + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movimentopdverro movimentopdverro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            movimentopdverro = em.merge(movimentopdverro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = movimentopdverro.getCodmovimentopdverro();
                if (findMovimentopdverro(id) == null) {
                    throw new NonexistentEntityException("The movimentopdverro with id " + id + " no longer exists.");
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
            Movimentopdverro movimentopdverro;
            try {
                movimentopdverro = em.getReference(Movimentopdverro.class, id);
                movimentopdverro.getCodmovimentopdverro();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movimentopdverro with id " + id + " no longer exists.", enfe);
            }
            em.remove(movimentopdverro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movimentopdverro> findMovimentopdverroEntities() {
        return findMovimentopdverroEntities(true, -1, -1);
    }

    public List<Movimentopdverro> findMovimentopdverroEntities(int maxResults, int firstResult) {
        return findMovimentopdverroEntities(false, maxResults, firstResult);
    }

    private List<Movimentopdverro> findMovimentopdverroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movimentopdverro.class));
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

    public Movimentopdverro findMovimentopdverro(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movimentopdverro.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovimentopdverroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movimentopdverro> rt = cq.from(Movimentopdverro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

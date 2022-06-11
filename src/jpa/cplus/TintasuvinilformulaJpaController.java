/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Tintasuvinilformula;
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
public class TintasuvinilformulaJpaController implements Serializable {

    public TintasuvinilformulaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tintasuvinilformula tintasuvinilformula) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tintasuvinilformula);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTintasuvinilformula(tintasuvinilformula.getCodtintasuvinilformula()) != null) {
                throw new PreexistingEntityException("Tintasuvinilformula " + tintasuvinilformula + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tintasuvinilformula tintasuvinilformula) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tintasuvinilformula = em.merge(tintasuvinilformula);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tintasuvinilformula.getCodtintasuvinilformula();
                if (findTintasuvinilformula(id) == null) {
                    throw new NonexistentEntityException("The tintasuvinilformula with id " + id + " no longer exists.");
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
            Tintasuvinilformula tintasuvinilformula;
            try {
                tintasuvinilformula = em.getReference(Tintasuvinilformula.class, id);
                tintasuvinilformula.getCodtintasuvinilformula();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tintasuvinilformula with id " + id + " no longer exists.", enfe);
            }
            em.remove(tintasuvinilformula);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tintasuvinilformula> findTintasuvinilformulaEntities() {
        return findTintasuvinilformulaEntities(true, -1, -1);
    }

    public List<Tintasuvinilformula> findTintasuvinilformulaEntities(int maxResults, int firstResult) {
        return findTintasuvinilformulaEntities(false, maxResults, firstResult);
    }

    private List<Tintasuvinilformula> findTintasuvinilformulaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tintasuvinilformula.class));
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

    public Tintasuvinilformula findTintasuvinilformula(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tintasuvinilformula.class, id);
        } finally {
            em.close();
        }
    }

    public int getTintasuvinilformulaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tintasuvinilformula> rt = cq.from(Tintasuvinilformula.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

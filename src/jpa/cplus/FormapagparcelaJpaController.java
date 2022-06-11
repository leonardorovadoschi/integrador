/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Formapagparcela;
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
public class FormapagparcelaJpaController implements Serializable {

    public FormapagparcelaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Formapagparcela formapagparcela) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(formapagparcela);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFormapagparcela(formapagparcela.getCodformapagparcela()) != null) {
                throw new PreexistingEntityException("Formapagparcela " + formapagparcela + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Formapagparcela formapagparcela) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            formapagparcela = em.merge(formapagparcela);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = formapagparcela.getCodformapagparcela();
                if (findFormapagparcela(id) == null) {
                    throw new NonexistentEntityException("The formapagparcela with id " + id + " no longer exists.");
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
            Formapagparcela formapagparcela;
            try {
                formapagparcela = em.getReference(Formapagparcela.class, id);
                formapagparcela.getCodformapagparcela();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The formapagparcela with id " + id + " no longer exists.", enfe);
            }
            em.remove(formapagparcela);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Formapagparcela> findFormapagparcelaEntities() {
        return findFormapagparcelaEntities(true, -1, -1);
    }

    public List<Formapagparcela> findFormapagparcelaEntities(int maxResults, int firstResult) {
        return findFormapagparcelaEntities(false, maxResults, firstResult);
    }

    private List<Formapagparcela> findFormapagparcelaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Formapagparcela.class));
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

    public Formapagparcela findFormapagparcela(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Formapagparcela.class, id);
        } finally {
            em.close();
        }
    }

    public int getFormapagparcelaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Formapagparcela> rt = cq.from(Formapagparcela.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

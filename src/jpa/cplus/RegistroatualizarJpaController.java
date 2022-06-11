/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Registroatualizar;
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
public class RegistroatualizarJpaController implements Serializable {

    public RegistroatualizarJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Registroatualizar registroatualizar) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(registroatualizar);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRegistroatualizar(registroatualizar.getCodregistroatualizar()) != null) {
                throw new PreexistingEntityException("Registroatualizar " + registroatualizar + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Registroatualizar registroatualizar) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            registroatualizar = em.merge(registroatualizar);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = registroatualizar.getCodregistroatualizar();
                if (findRegistroatualizar(id) == null) {
                    throw new NonexistentEntityException("The registroatualizar with id " + id + " no longer exists.");
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
            Registroatualizar registroatualizar;
            try {
                registroatualizar = em.getReference(Registroatualizar.class, id);
                registroatualizar.getCodregistroatualizar();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The registroatualizar with id " + id + " no longer exists.", enfe);
            }
            em.remove(registroatualizar);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Registroatualizar> findRegistroatualizarEntities() {
        return findRegistroatualizarEntities(true, -1, -1);
    }

    public List<Registroatualizar> findRegistroatualizarEntities(int maxResults, int firstResult) {
        return findRegistroatualizarEntities(false, maxResults, firstResult);
    }

    private List<Registroatualizar> findRegistroatualizarEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Registroatualizar.class));
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

    public Registroatualizar findRegistroatualizar(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Registroatualizar.class, id);
        } finally {
            em.close();
        }
    }

    public int getRegistroatualizarCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Registroatualizar> rt = cq.from(Registroatualizar.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

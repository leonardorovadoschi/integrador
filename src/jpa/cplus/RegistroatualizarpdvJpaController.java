/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Registroatualizarpdv;
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
public class RegistroatualizarpdvJpaController implements Serializable {

    public RegistroatualizarpdvJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Registroatualizarpdv registroatualizarpdv) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(registroatualizarpdv);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRegistroatualizarpdv(registroatualizarpdv.getCodregistroatualizarpdv()) != null) {
                throw new PreexistingEntityException("Registroatualizarpdv " + registroatualizarpdv + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Registroatualizarpdv registroatualizarpdv) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            registroatualizarpdv = em.merge(registroatualizarpdv);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = registroatualizarpdv.getCodregistroatualizarpdv();
                if (findRegistroatualizarpdv(id) == null) {
                    throw new NonexistentEntityException("The registroatualizarpdv with id " + id + " no longer exists.");
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
            Registroatualizarpdv registroatualizarpdv;
            try {
                registroatualizarpdv = em.getReference(Registroatualizarpdv.class, id);
                registroatualizarpdv.getCodregistroatualizarpdv();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The registroatualizarpdv with id " + id + " no longer exists.", enfe);
            }
            em.remove(registroatualizarpdv);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Registroatualizarpdv> findRegistroatualizarpdvEntities() {
        return findRegistroatualizarpdvEntities(true, -1, -1);
    }

    public List<Registroatualizarpdv> findRegistroatualizarpdvEntities(int maxResults, int firstResult) {
        return findRegistroatualizarpdvEntities(false, maxResults, firstResult);
    }

    private List<Registroatualizarpdv> findRegistroatualizarpdvEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Registroatualizarpdv.class));
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

    public Registroatualizarpdv findRegistroatualizarpdv(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Registroatualizarpdv.class, id);
        } finally {
            em.close();
        }
    }

    public int getRegistroatualizarpdvCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Registroatualizarpdv> rt = cq.from(Registroatualizarpdv.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Registroexcluir;
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
public class RegistroexcluirJpaController implements Serializable {

    public RegistroexcluirJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Registroexcluir registroexcluir) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(registroexcluir);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRegistroexcluir(registroexcluir.getCodregistroexcluir()) != null) {
                throw new PreexistingEntityException("Registroexcluir " + registroexcluir + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Registroexcluir registroexcluir) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            registroexcluir = em.merge(registroexcluir);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = registroexcluir.getCodregistroexcluir();
                if (findRegistroexcluir(id) == null) {
                    throw new NonexistentEntityException("The registroexcluir with id " + id + " no longer exists.");
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
            Registroexcluir registroexcluir;
            try {
                registroexcluir = em.getReference(Registroexcluir.class, id);
                registroexcluir.getCodregistroexcluir();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The registroexcluir with id " + id + " no longer exists.", enfe);
            }
            em.remove(registroexcluir);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Registroexcluir> findRegistroexcluirEntities() {
        return findRegistroexcluirEntities(true, -1, -1);
    }

    public List<Registroexcluir> findRegistroexcluirEntities(int maxResults, int firstResult) {
        return findRegistroexcluirEntities(false, maxResults, firstResult);
    }

    private List<Registroexcluir> findRegistroexcluirEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Registroexcluir.class));
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

    public Registroexcluir findRegistroexcluir(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Registroexcluir.class, id);
        } finally {
            em.close();
        }
    }

    public int getRegistroexcluirCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Registroexcluir> rt = cq.from(Registroexcluir.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

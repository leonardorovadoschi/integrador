/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Tipocontato;
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
public class TipocontatoJpaController implements Serializable {

    public TipocontatoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipocontato tipocontato) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipocontato);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipocontato(tipocontato.getCodtipocontato()) != null) {
                throw new PreexistingEntityException("Tipocontato " + tipocontato + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipocontato tipocontato) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipocontato = em.merge(tipocontato);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tipocontato.getCodtipocontato();
                if (findTipocontato(id) == null) {
                    throw new NonexistentEntityException("The tipocontato with id " + id + " no longer exists.");
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
            Tipocontato tipocontato;
            try {
                tipocontato = em.getReference(Tipocontato.class, id);
                tipocontato.getCodtipocontato();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipocontato with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipocontato);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipocontato> findTipocontatoEntities() {
        return findTipocontatoEntities(true, -1, -1);
    }

    public List<Tipocontato> findTipocontatoEntities(int maxResults, int firstResult) {
        return findTipocontatoEntities(false, maxResults, firstResult);
    }

    private List<Tipocontato> findTipocontatoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipocontato.class));
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

    public Tipocontato findTipocontato(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipocontato.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipocontatoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipocontato> rt = cq.from(Tipocontato.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

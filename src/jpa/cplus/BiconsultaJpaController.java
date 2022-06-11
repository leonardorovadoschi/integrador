/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Biconsulta;
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
public class BiconsultaJpaController implements Serializable {

    public BiconsultaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Biconsulta biconsulta) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(biconsulta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBiconsulta(biconsulta.getCodbiconsulta()) != null) {
                throw new PreexistingEntityException("Biconsulta " + biconsulta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Biconsulta biconsulta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            biconsulta = em.merge(biconsulta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = biconsulta.getCodbiconsulta();
                if (findBiconsulta(id) == null) {
                    throw new NonexistentEntityException("The biconsulta with id " + id + " no longer exists.");
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
            Biconsulta biconsulta;
            try {
                biconsulta = em.getReference(Biconsulta.class, id);
                biconsulta.getCodbiconsulta();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The biconsulta with id " + id + " no longer exists.", enfe);
            }
            em.remove(biconsulta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Biconsulta> findBiconsultaEntities() {
        return findBiconsultaEntities(true, -1, -1);
    }

    public List<Biconsulta> findBiconsultaEntities(int maxResults, int firstResult) {
        return findBiconsultaEntities(false, maxResults, firstResult);
    }

    private List<Biconsulta> findBiconsultaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Biconsulta.class));
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

    public Biconsulta findBiconsulta(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Biconsulta.class, id);
        } finally {
            em.close();
        }
    }

    public int getBiconsultaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Biconsulta> rt = cq.from(Biconsulta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

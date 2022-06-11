/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Enquadramentoipi;
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
public class EnquadramentoipiJpaController implements Serializable {

    public EnquadramentoipiJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Enquadramentoipi enquadramentoipi) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(enquadramentoipi);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEnquadramentoipi(enquadramentoipi.getCodenquadramentoipi()) != null) {
                throw new PreexistingEntityException("Enquadramentoipi " + enquadramentoipi + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Enquadramentoipi enquadramentoipi) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            enquadramentoipi = em.merge(enquadramentoipi);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = enquadramentoipi.getCodenquadramentoipi();
                if (findEnquadramentoipi(id) == null) {
                    throw new NonexistentEntityException("The enquadramentoipi with id " + id + " no longer exists.");
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
            Enquadramentoipi enquadramentoipi;
            try {
                enquadramentoipi = em.getReference(Enquadramentoipi.class, id);
                enquadramentoipi.getCodenquadramentoipi();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The enquadramentoipi with id " + id + " no longer exists.", enfe);
            }
            em.remove(enquadramentoipi);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Enquadramentoipi> findEnquadramentoipiEntities() {
        return findEnquadramentoipiEntities(true, -1, -1);
    }

    public List<Enquadramentoipi> findEnquadramentoipiEntities(int maxResults, int firstResult) {
        return findEnquadramentoipiEntities(false, maxResults, firstResult);
    }

    private List<Enquadramentoipi> findEnquadramentoipiEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Enquadramentoipi.class));
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

    public Enquadramentoipi findEnquadramentoipi(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Enquadramentoipi.class, id);
        } finally {
            em.close();
        }
    }

    public int getEnquadramentoipiCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Enquadramentoipi> rt = cq.from(Enquadramentoipi.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

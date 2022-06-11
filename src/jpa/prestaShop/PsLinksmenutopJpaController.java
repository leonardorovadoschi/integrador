/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsLinksmenutop;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.prestaShop.exceptions.NonexistentEntityException;

/**
 *
 * @author leo
 */
public class PsLinksmenutopJpaController implements Serializable {

    public PsLinksmenutopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsLinksmenutop psLinksmenutop) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psLinksmenutop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsLinksmenutop psLinksmenutop) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psLinksmenutop = em.merge(psLinksmenutop);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psLinksmenutop.getIdLinksmenutop();
                if (findPsLinksmenutop(id) == null) {
                    throw new NonexistentEntityException("The psLinksmenutop with id " + id + " no longer exists.");
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
            PsLinksmenutop psLinksmenutop;
            try {
                psLinksmenutop = em.getReference(PsLinksmenutop.class, id);
                psLinksmenutop.getIdLinksmenutop();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psLinksmenutop with id " + id + " no longer exists.", enfe);
            }
            em.remove(psLinksmenutop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsLinksmenutop> findPsLinksmenutopEntities() {
        return findPsLinksmenutopEntities(true, -1, -1);
    }

    public List<PsLinksmenutop> findPsLinksmenutopEntities(int maxResults, int firstResult) {
        return findPsLinksmenutopEntities(false, maxResults, firstResult);
    }

    private List<PsLinksmenutop> findPsLinksmenutopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsLinksmenutop.class));
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

    public PsLinksmenutop findPsLinksmenutop(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsLinksmenutop.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsLinksmenutopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsLinksmenutop> rt = cq.from(PsLinksmenutop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsSekeyword;
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
public class PsSekeywordJpaController implements Serializable {

    public PsSekeywordJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsSekeyword psSekeyword) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psSekeyword);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsSekeyword psSekeyword) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psSekeyword = em.merge(psSekeyword);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psSekeyword.getIdSekeyword();
                if (findPsSekeyword(id) == null) {
                    throw new NonexistentEntityException("The psSekeyword with id " + id + " no longer exists.");
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
            PsSekeyword psSekeyword;
            try {
                psSekeyword = em.getReference(PsSekeyword.class, id);
                psSekeyword.getIdSekeyword();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psSekeyword with id " + id + " no longer exists.", enfe);
            }
            em.remove(psSekeyword);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsSekeyword> findPsSekeywordEntities() {
        return findPsSekeywordEntities(true, -1, -1);
    }

    public List<PsSekeyword> findPsSekeywordEntities(int maxResults, int firstResult) {
        return findPsSekeywordEntities(false, maxResults, firstResult);
    }

    private List<PsSekeyword> findPsSekeywordEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsSekeyword.class));
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

    public PsSekeyword findPsSekeyword(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsSekeyword.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsSekeywordCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsSekeyword> rt = cq.from(PsSekeyword.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

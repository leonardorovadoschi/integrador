/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsRequiredField;
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
public class PsRequiredFieldJpaController implements Serializable {

    public PsRequiredFieldJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsRequiredField psRequiredField) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psRequiredField);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsRequiredField psRequiredField) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psRequiredField = em.merge(psRequiredField);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psRequiredField.getIdRequiredField();
                if (findPsRequiredField(id) == null) {
                    throw new NonexistentEntityException("The psRequiredField with id " + id + " no longer exists.");
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
            PsRequiredField psRequiredField;
            try {
                psRequiredField = em.getReference(PsRequiredField.class, id);
                psRequiredField.getIdRequiredField();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psRequiredField with id " + id + " no longer exists.", enfe);
            }
            em.remove(psRequiredField);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsRequiredField> findPsRequiredFieldEntities() {
        return findPsRequiredFieldEntities(true, -1, -1);
    }

    public List<PsRequiredField> findPsRequiredFieldEntities(int maxResults, int firstResult) {
        return findPsRequiredFieldEntities(false, maxResults, firstResult);
    }

    private List<PsRequiredField> findPsRequiredFieldEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsRequiredField.class));
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

    public PsRequiredField findPsRequiredField(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsRequiredField.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsRequiredFieldCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsRequiredField> rt = cq.from(PsRequiredField.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

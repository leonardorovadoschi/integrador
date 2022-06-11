/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCustomizationField;
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
public class PsCustomizationFieldJpaController implements Serializable {

    public PsCustomizationFieldJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCustomizationField psCustomizationField) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCustomizationField);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCustomizationField psCustomizationField) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCustomizationField = em.merge(psCustomizationField);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psCustomizationField.getIdCustomizationField();
                if (findPsCustomizationField(id) == null) {
                    throw new NonexistentEntityException("The psCustomizationField with id " + id + " no longer exists.");
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
            PsCustomizationField psCustomizationField;
            try {
                psCustomizationField = em.getReference(PsCustomizationField.class, id);
                psCustomizationField.getIdCustomizationField();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCustomizationField with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCustomizationField);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCustomizationField> findPsCustomizationFieldEntities() {
        return findPsCustomizationFieldEntities(true, -1, -1);
    }

    public List<PsCustomizationField> findPsCustomizationFieldEntities(int maxResults, int firstResult) {
        return findPsCustomizationFieldEntities(false, maxResults, firstResult);
    }

    private List<PsCustomizationField> findPsCustomizationFieldEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCustomizationField.class));
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

    public PsCustomizationField findPsCustomizationField(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCustomizationField.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCustomizationFieldCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCustomizationField> rt = cq.from(PsCustomizationField.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

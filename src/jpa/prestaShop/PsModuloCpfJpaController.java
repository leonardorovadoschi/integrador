/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsModuloCpf;
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
public class PsModuloCpfJpaController implements Serializable {

    public PsModuloCpfJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsModuloCpf psModuloCpf) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psModuloCpf);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsModuloCpf psModuloCpf) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psModuloCpf = em.merge(psModuloCpf);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psModuloCpf.getId();
                if (findPsModuloCpf(id) == null) {
                    throw new NonexistentEntityException("The psModuloCpf with id " + id + " no longer exists.");
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
            PsModuloCpf psModuloCpf;
            try {
                psModuloCpf = em.getReference(PsModuloCpf.class, id);
                psModuloCpf.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psModuloCpf with id " + id + " no longer exists.", enfe);
            }
            em.remove(psModuloCpf);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsModuloCpf> findPsModuloCpfEntities() {
        return findPsModuloCpfEntities(true, -1, -1);
    }

    public List<PsModuloCpf> findPsModuloCpfEntities(int maxResults, int firstResult) {
        return findPsModuloCpfEntities(false, maxResults, firstResult);
    }

    private List<PsModuloCpf> findPsModuloCpfEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsModuloCpf.class));
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

    public PsModuloCpf findPsModuloCpf(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsModuloCpf.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsModuloCpfCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsModuloCpf> rt = cq.from(PsModuloCpf.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCustomerGroup;
import entidade.prestaShop.PsCustomerGroupPK;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.prestaShop.exceptions.NonexistentEntityException;
import jpa.prestaShop.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class PsCustomerGroupJpaController implements Serializable {

    public PsCustomerGroupJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCustomerGroup psCustomerGroup) throws PreexistingEntityException, Exception {
        if (psCustomerGroup.getPsCustomerGroupPK() == null) {
            psCustomerGroup.setPsCustomerGroupPK(new PsCustomerGroupPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCustomerGroup);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCustomerGroup(psCustomerGroup.getPsCustomerGroupPK()) != null) {
                throw new PreexistingEntityException("PsCustomerGroup " + psCustomerGroup + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCustomerGroup psCustomerGroup) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCustomerGroup = em.merge(psCustomerGroup);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCustomerGroupPK id = psCustomerGroup.getPsCustomerGroupPK();
                if (findPsCustomerGroup(id) == null) {
                    throw new NonexistentEntityException("The psCustomerGroup with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCustomerGroupPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCustomerGroup psCustomerGroup;
            try {
                psCustomerGroup = em.getReference(PsCustomerGroup.class, id);
                psCustomerGroup.getPsCustomerGroupPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCustomerGroup with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCustomerGroup);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCustomerGroup> findPsCustomerGroupEntities() {
        return findPsCustomerGroupEntities(true, -1, -1);
    }

    public List<PsCustomerGroup> findPsCustomerGroupEntities(int maxResults, int firstResult) {
        return findPsCustomerGroupEntities(false, maxResults, firstResult);
    }

    private List<PsCustomerGroup> findPsCustomerGroupEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCustomerGroup.class));
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

    public PsCustomerGroup findPsCustomerGroup(PsCustomerGroupPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCustomerGroup.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCustomerGroupCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCustomerGroup> rt = cq.from(PsCustomerGroup.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCmsRole;
import entidade.prestaShop.PsCmsRolePK;
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
public class PsCmsRoleJpaController implements Serializable {

    public PsCmsRoleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCmsRole psCmsRole) throws PreexistingEntityException, Exception {
        if (psCmsRole.getPsCmsRolePK() == null) {
            psCmsRole.setPsCmsRolePK(new PsCmsRolePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCmsRole);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCmsRole(psCmsRole.getPsCmsRolePK()) != null) {
                throw new PreexistingEntityException("PsCmsRole " + psCmsRole + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCmsRole psCmsRole) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCmsRole = em.merge(psCmsRole);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCmsRolePK id = psCmsRole.getPsCmsRolePK();
                if (findPsCmsRole(id) == null) {
                    throw new NonexistentEntityException("The psCmsRole with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCmsRolePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCmsRole psCmsRole;
            try {
                psCmsRole = em.getReference(PsCmsRole.class, id);
                psCmsRole.getPsCmsRolePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCmsRole with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCmsRole);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCmsRole> findPsCmsRoleEntities() {
        return findPsCmsRoleEntities(true, -1, -1);
    }

    public List<PsCmsRole> findPsCmsRoleEntities(int maxResults, int firstResult) {
        return findPsCmsRoleEntities(false, maxResults, firstResult);
    }

    private List<PsCmsRole> findPsCmsRoleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCmsRole.class));
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

    public PsCmsRole findPsCmsRole(PsCmsRolePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCmsRole.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCmsRoleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCmsRole> rt = cq.from(PsCmsRole.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

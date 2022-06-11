/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsModuleGroup;
import entidade.prestaShop.PsModuleGroupPK;
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
public class PsModuleGroupJpaController implements Serializable {

    public PsModuleGroupJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsModuleGroup psModuleGroup) throws PreexistingEntityException, Exception {
        if (psModuleGroup.getPsModuleGroupPK() == null) {
            psModuleGroup.setPsModuleGroupPK(new PsModuleGroupPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psModuleGroup);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsModuleGroup(psModuleGroup.getPsModuleGroupPK()) != null) {
                throw new PreexistingEntityException("PsModuleGroup " + psModuleGroup + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsModuleGroup psModuleGroup) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psModuleGroup = em.merge(psModuleGroup);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsModuleGroupPK id = psModuleGroup.getPsModuleGroupPK();
                if (findPsModuleGroup(id) == null) {
                    throw new NonexistentEntityException("The psModuleGroup with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsModuleGroupPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsModuleGroup psModuleGroup;
            try {
                psModuleGroup = em.getReference(PsModuleGroup.class, id);
                psModuleGroup.getPsModuleGroupPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psModuleGroup with id " + id + " no longer exists.", enfe);
            }
            em.remove(psModuleGroup);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsModuleGroup> findPsModuleGroupEntities() {
        return findPsModuleGroupEntities(true, -1, -1);
    }

    public List<PsModuleGroup> findPsModuleGroupEntities(int maxResults, int firstResult) {
        return findPsModuleGroupEntities(false, maxResults, firstResult);
    }

    private List<PsModuleGroup> findPsModuleGroupEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsModuleGroup.class));
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

    public PsModuleGroup findPsModuleGroup(PsModuleGroupPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsModuleGroup.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsModuleGroupCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsModuleGroup> rt = cq.from(PsModuleGroup.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

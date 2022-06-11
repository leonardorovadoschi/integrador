/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCarrierGroup;
import entidade.prestaShop.PsCarrierGroupPK;
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
public class PsCarrierGroupJpaController implements Serializable {

    public PsCarrierGroupJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCarrierGroup psCarrierGroup) throws PreexistingEntityException, Exception {
        if (psCarrierGroup.getPsCarrierGroupPK() == null) {
            psCarrierGroup.setPsCarrierGroupPK(new PsCarrierGroupPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCarrierGroup);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCarrierGroup(psCarrierGroup.getPsCarrierGroupPK()) != null) {
                throw new PreexistingEntityException("PsCarrierGroup " + psCarrierGroup + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCarrierGroup psCarrierGroup) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCarrierGroup = em.merge(psCarrierGroup);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCarrierGroupPK id = psCarrierGroup.getPsCarrierGroupPK();
                if (findPsCarrierGroup(id) == null) {
                    throw new NonexistentEntityException("The psCarrierGroup with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCarrierGroupPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCarrierGroup psCarrierGroup;
            try {
                psCarrierGroup = em.getReference(PsCarrierGroup.class, id);
                psCarrierGroup.getPsCarrierGroupPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCarrierGroup with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCarrierGroup);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCarrierGroup> findPsCarrierGroupEntities() {
        return findPsCarrierGroupEntities(true, -1, -1);
    }

    public List<PsCarrierGroup> findPsCarrierGroupEntities(int maxResults, int firstResult) {
        return findPsCarrierGroupEntities(false, maxResults, firstResult);
    }

    private List<PsCarrierGroup> findPsCarrierGroupEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCarrierGroup.class));
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

    public PsCarrierGroup findPsCarrierGroup(PsCarrierGroupPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCarrierGroup.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCarrierGroupCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCarrierGroup> rt = cq.from(PsCarrierGroup.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

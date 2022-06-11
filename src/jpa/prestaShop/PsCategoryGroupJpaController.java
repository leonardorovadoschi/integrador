/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsCategoryGroup;
import entidade.prestaShop.PsCategoryGroupPK;
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
public class PsCategoryGroupJpaController implements Serializable {

    public PsCategoryGroupJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsCategoryGroup psCategoryGroup) throws PreexistingEntityException, Exception {
        if (psCategoryGroup.getPsCategoryGroupPK() == null) {
            psCategoryGroup.setPsCategoryGroupPK(new PsCategoryGroupPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psCategoryGroup);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsCategoryGroup(psCategoryGroup.getPsCategoryGroupPK()) != null) {
                throw new PreexistingEntityException("PsCategoryGroup " + psCategoryGroup + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsCategoryGroup psCategoryGroup) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psCategoryGroup = em.merge(psCategoryGroup);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsCategoryGroupPK id = psCategoryGroup.getPsCategoryGroupPK();
                if (findPsCategoryGroup(id) == null) {
                    throw new NonexistentEntityException("The psCategoryGroup with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsCategoryGroupPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsCategoryGroup psCategoryGroup;
            try {
                psCategoryGroup = em.getReference(PsCategoryGroup.class, id);
                psCategoryGroup.getPsCategoryGroupPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psCategoryGroup with id " + id + " no longer exists.", enfe);
            }
            em.remove(psCategoryGroup);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsCategoryGroup> findPsCategoryGroupEntities() {
        return findPsCategoryGroupEntities(true, -1, -1);
    }

    public List<PsCategoryGroup> findPsCategoryGroupEntities(int maxResults, int firstResult) {
        return findPsCategoryGroupEntities(false, maxResults, firstResult);
    }

    private List<PsCategoryGroup> findPsCategoryGroupEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsCategoryGroup.class));
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

    public PsCategoryGroup findPsCategoryGroup(PsCategoryGroupPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsCategoryGroup.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsCategoryGroupCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsCategoryGroup> rt = cq.from(PsCategoryGroup.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

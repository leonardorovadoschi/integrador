/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsModuleAccess;
import entidade.prestaShop.PsModuleAccessPK;
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
public class PsModuleAccessJpaController implements Serializable {

    public PsModuleAccessJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsModuleAccess psModuleAccess) throws PreexistingEntityException, Exception {
        if (psModuleAccess.getPsModuleAccessPK() == null) {
            psModuleAccess.setPsModuleAccessPK(new PsModuleAccessPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psModuleAccess);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsModuleAccess(psModuleAccess.getPsModuleAccessPK()) != null) {
                throw new PreexistingEntityException("PsModuleAccess " + psModuleAccess + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsModuleAccess psModuleAccess) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psModuleAccess = em.merge(psModuleAccess);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsModuleAccessPK id = psModuleAccess.getPsModuleAccessPK();
                if (findPsModuleAccess(id) == null) {
                    throw new NonexistentEntityException("The psModuleAccess with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsModuleAccessPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsModuleAccess psModuleAccess;
            try {
                psModuleAccess = em.getReference(PsModuleAccess.class, id);
                psModuleAccess.getPsModuleAccessPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psModuleAccess with id " + id + " no longer exists.", enfe);
            }
            em.remove(psModuleAccess);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsModuleAccess> findPsModuleAccessEntities() {
        return findPsModuleAccessEntities(true, -1, -1);
    }

    public List<PsModuleAccess> findPsModuleAccessEntities(int maxResults, int firstResult) {
        return findPsModuleAccessEntities(false, maxResults, firstResult);
    }

    private List<PsModuleAccess> findPsModuleAccessEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsModuleAccess.class));
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

    public PsModuleAccess findPsModuleAccess(PsModuleAccessPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsModuleAccess.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsModuleAccessCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsModuleAccess> rt = cq.from(PsModuleAccess.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

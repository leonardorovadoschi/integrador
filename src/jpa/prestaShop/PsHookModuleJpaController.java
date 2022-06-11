/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsHookModule;
import entidade.prestaShop.PsHookModulePK;
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
public class PsHookModuleJpaController implements Serializable {

    public PsHookModuleJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsHookModule psHookModule) throws PreexistingEntityException, Exception {
        if (psHookModule.getPsHookModulePK() == null) {
            psHookModule.setPsHookModulePK(new PsHookModulePK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psHookModule);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPsHookModule(psHookModule.getPsHookModulePK()) != null) {
                throw new PreexistingEntityException("PsHookModule " + psHookModule + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsHookModule psHookModule) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psHookModule = em.merge(psHookModule);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                PsHookModulePK id = psHookModule.getPsHookModulePK();
                if (findPsHookModule(id) == null) {
                    throw new NonexistentEntityException("The psHookModule with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(PsHookModulePK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PsHookModule psHookModule;
            try {
                psHookModule = em.getReference(PsHookModule.class, id);
                psHookModule.getPsHookModulePK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psHookModule with id " + id + " no longer exists.", enfe);
            }
            em.remove(psHookModule);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsHookModule> findPsHookModuleEntities() {
        return findPsHookModuleEntities(true, -1, -1);
    }

    public List<PsHookModule> findPsHookModuleEntities(int maxResults, int firstResult) {
        return findPsHookModuleEntities(false, maxResults, firstResult);
    }

    private List<PsHookModule> findPsHookModuleEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsHookModule.class));
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

    public PsHookModule findPsHookModule(PsHookModulePK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsHookModule.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsHookModuleCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsHookModule> rt = cq.from(PsHookModule.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

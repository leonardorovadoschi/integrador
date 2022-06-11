/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.OsTipoecf;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class OsTipoecfJpaController implements Serializable {

    public OsTipoecfJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OsTipoecf osTipoecf) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(osTipoecf);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOsTipoecf(osTipoecf.getCodtipoecf()) != null) {
                throw new PreexistingEntityException("OsTipoecf " + osTipoecf + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OsTipoecf osTipoecf) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            osTipoecf = em.merge(osTipoecf);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = osTipoecf.getCodtipoecf();
                if (findOsTipoecf(id) == null) {
                    throw new NonexistentEntityException("The osTipoecf with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsTipoecf osTipoecf;
            try {
                osTipoecf = em.getReference(OsTipoecf.class, id);
                osTipoecf.getCodtipoecf();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The osTipoecf with id " + id + " no longer exists.", enfe);
            }
            em.remove(osTipoecf);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OsTipoecf> findOsTipoecfEntities() {
        return findOsTipoecfEntities(true, -1, -1);
    }

    public List<OsTipoecf> findOsTipoecfEntities(int maxResults, int firstResult) {
        return findOsTipoecfEntities(false, maxResults, firstResult);
    }

    private List<OsTipoecf> findOsTipoecfEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OsTipoecf.class));
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

    public OsTipoecf findOsTipoecf(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OsTipoecf.class, id);
        } finally {
            em.close();
        }
    }

    public int getOsTipoecfCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OsTipoecf> rt = cq.from(OsTipoecf.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Sat;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Satmarca;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class SatJpaController implements Serializable {

    public SatJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sat sat) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Satmarca codsatmarca = sat.getCodsatmarca();
            if (codsatmarca != null) {
                codsatmarca = em.getReference(codsatmarca.getClass(), codsatmarca.getCodsatmarca());
                sat.setCodsatmarca(codsatmarca);
            }
            em.persist(sat);
            if (codsatmarca != null) {
                codsatmarca.getSatCollection().add(sat);
                codsatmarca = em.merge(codsatmarca);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSat(sat.getCodsat()) != null) {
                throw new PreexistingEntityException("Sat " + sat + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sat sat) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sat persistentSat = em.find(Sat.class, sat.getCodsat());
            Satmarca codsatmarcaOld = persistentSat.getCodsatmarca();
            Satmarca codsatmarcaNew = sat.getCodsatmarca();
            if (codsatmarcaNew != null) {
                codsatmarcaNew = em.getReference(codsatmarcaNew.getClass(), codsatmarcaNew.getCodsatmarca());
                sat.setCodsatmarca(codsatmarcaNew);
            }
            sat = em.merge(sat);
            if (codsatmarcaOld != null && !codsatmarcaOld.equals(codsatmarcaNew)) {
                codsatmarcaOld.getSatCollection().remove(sat);
                codsatmarcaOld = em.merge(codsatmarcaOld);
            }
            if (codsatmarcaNew != null && !codsatmarcaNew.equals(codsatmarcaOld)) {
                codsatmarcaNew.getSatCollection().add(sat);
                codsatmarcaNew = em.merge(codsatmarcaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = sat.getCodsat();
                if (findSat(id) == null) {
                    throw new NonexistentEntityException("The sat with id " + id + " no longer exists.");
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
            Sat sat;
            try {
                sat = em.getReference(Sat.class, id);
                sat.getCodsat();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sat with id " + id + " no longer exists.", enfe);
            }
            Satmarca codsatmarca = sat.getCodsatmarca();
            if (codsatmarca != null) {
                codsatmarca.getSatCollection().remove(sat);
                codsatmarca = em.merge(codsatmarca);
            }
            em.remove(sat);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sat> findSatEntities() {
        return findSatEntities(true, -1, -1);
    }

    public List<Sat> findSatEntities(int maxResults, int firstResult) {
        return findSatEntities(false, maxResults, firstResult);
    }

    private List<Sat> findSatEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sat.class));
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

    public Sat findSat(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sat.class, id);
        } finally {
            em.close();
        }
    }

    public int getSatCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sat> rt = cq.from(Sat.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

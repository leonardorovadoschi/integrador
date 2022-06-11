/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Cesticms;
import entidade.cplus.Cesticmsclassificacaofiscal;
import entidade.cplus.CesticmsclassificacaofiscalPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class CesticmsclassificacaofiscalJpaController implements Serializable {

    public CesticmsclassificacaofiscalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cesticmsclassificacaofiscal cesticmsclassificacaofiscal) throws PreexistingEntityException, Exception {
        if (cesticmsclassificacaofiscal.getCesticmsclassificacaofiscalPK() == null) {
            cesticmsclassificacaofiscal.setCesticmsclassificacaofiscalPK(new CesticmsclassificacaofiscalPK());
        }
        cesticmsclassificacaofiscal.getCesticmsclassificacaofiscalPK().setCodcesticms(cesticmsclassificacaofiscal.getCesticms().getCodcesticms());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cesticms cesticms = cesticmsclassificacaofiscal.getCesticms();
            if (cesticms != null) {
                cesticms = em.getReference(cesticms.getClass(), cesticms.getCodcesticms());
                cesticmsclassificacaofiscal.setCesticms(cesticms);
            }
            em.persist(cesticmsclassificacaofiscal);
            if (cesticms != null) {
                cesticms.getCesticmsclassificacaofiscalCollection().add(cesticmsclassificacaofiscal);
                cesticms = em.merge(cesticms);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCesticmsclassificacaofiscal(cesticmsclassificacaofiscal.getCesticmsclassificacaofiscalPK()) != null) {
                throw new PreexistingEntityException("Cesticmsclassificacaofiscal " + cesticmsclassificacaofiscal + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cesticmsclassificacaofiscal cesticmsclassificacaofiscal) throws NonexistentEntityException, Exception {
        cesticmsclassificacaofiscal.getCesticmsclassificacaofiscalPK().setCodcesticms(cesticmsclassificacaofiscal.getCesticms().getCodcesticms());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cesticmsclassificacaofiscal persistentCesticmsclassificacaofiscal = em.find(Cesticmsclassificacaofiscal.class, cesticmsclassificacaofiscal.getCesticmsclassificacaofiscalPK());
            Cesticms cesticmsOld = persistentCesticmsclassificacaofiscal.getCesticms();
            Cesticms cesticmsNew = cesticmsclassificacaofiscal.getCesticms();
            if (cesticmsNew != null) {
                cesticmsNew = em.getReference(cesticmsNew.getClass(), cesticmsNew.getCodcesticms());
                cesticmsclassificacaofiscal.setCesticms(cesticmsNew);
            }
            cesticmsclassificacaofiscal = em.merge(cesticmsclassificacaofiscal);
            if (cesticmsOld != null && !cesticmsOld.equals(cesticmsNew)) {
                cesticmsOld.getCesticmsclassificacaofiscalCollection().remove(cesticmsclassificacaofiscal);
                cesticmsOld = em.merge(cesticmsOld);
            }
            if (cesticmsNew != null && !cesticmsNew.equals(cesticmsOld)) {
                cesticmsNew.getCesticmsclassificacaofiscalCollection().add(cesticmsclassificacaofiscal);
                cesticmsNew = em.merge(cesticmsNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                CesticmsclassificacaofiscalPK id = cesticmsclassificacaofiscal.getCesticmsclassificacaofiscalPK();
                if (findCesticmsclassificacaofiscal(id) == null) {
                    throw new NonexistentEntityException("The cesticmsclassificacaofiscal with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(CesticmsclassificacaofiscalPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cesticmsclassificacaofiscal cesticmsclassificacaofiscal;
            try {
                cesticmsclassificacaofiscal = em.getReference(Cesticmsclassificacaofiscal.class, id);
                cesticmsclassificacaofiscal.getCesticmsclassificacaofiscalPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cesticmsclassificacaofiscal with id " + id + " no longer exists.", enfe);
            }
            Cesticms cesticms = cesticmsclassificacaofiscal.getCesticms();
            if (cesticms != null) {
                cesticms.getCesticmsclassificacaofiscalCollection().remove(cesticmsclassificacaofiscal);
                cesticms = em.merge(cesticms);
            }
            em.remove(cesticmsclassificacaofiscal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cesticmsclassificacaofiscal> findCesticmsclassificacaofiscalEntities() {
        return findCesticmsclassificacaofiscalEntities(true, -1, -1);
    }

    public List<Cesticmsclassificacaofiscal> findCesticmsclassificacaofiscalEntities(int maxResults, int firstResult) {
        return findCesticmsclassificacaofiscalEntities(false, maxResults, firstResult);
    }

    private List<Cesticmsclassificacaofiscal> findCesticmsclassificacaofiscalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cesticmsclassificacaofiscal.class));
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

    public Cesticmsclassificacaofiscal findCesticmsclassificacaofiscal(CesticmsclassificacaofiscalPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cesticmsclassificacaofiscal.class, id);
        } finally {
            em.close();
        }
    }

    public int getCesticmsclassificacaofiscalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cesticmsclassificacaofiscal> rt = cq.from(Cesticmsclassificacaofiscal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

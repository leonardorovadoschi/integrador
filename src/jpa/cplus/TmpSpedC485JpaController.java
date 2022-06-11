/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpSpedC485;
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
public class TmpSpedC485JpaController implements Serializable {

    public TmpSpedC485JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpSpedC485 tmpSpedC485) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpSpedC485);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpSpedC485(tmpSpedC485.getCodtmpSpedC485()) != null) {
                throw new PreexistingEntityException("TmpSpedC485 " + tmpSpedC485 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpSpedC485 tmpSpedC485) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpSpedC485 = em.merge(tmpSpedC485);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpSpedC485.getCodtmpSpedC485();
                if (findTmpSpedC485(id) == null) {
                    throw new NonexistentEntityException("The tmpSpedC485 with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TmpSpedC485 tmpSpedC485;
            try {
                tmpSpedC485 = em.getReference(TmpSpedC485.class, id);
                tmpSpedC485.getCodtmpSpedC485();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpSpedC485 with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpSpedC485);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpSpedC485> findTmpSpedC485Entities() {
        return findTmpSpedC485Entities(true, -1, -1);
    }

    public List<TmpSpedC485> findTmpSpedC485Entities(int maxResults, int firstResult) {
        return findTmpSpedC485Entities(false, maxResults, firstResult);
    }

    private List<TmpSpedC485> findTmpSpedC485Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpSpedC485.class));
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

    public TmpSpedC485 findTmpSpedC485(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpSpedC485.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpSpedC485Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpSpedC485> rt = cq.from(TmpSpedC485.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

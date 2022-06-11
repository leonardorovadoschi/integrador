/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpSpedC175;
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
public class TmpSpedC175JpaController implements Serializable {

    public TmpSpedC175JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpSpedC175 tmpSpedC175) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpSpedC175);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpSpedC175(tmpSpedC175.getCodtmpSpedC175()) != null) {
                throw new PreexistingEntityException("TmpSpedC175 " + tmpSpedC175 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpSpedC175 tmpSpedC175) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpSpedC175 = em.merge(tmpSpedC175);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpSpedC175.getCodtmpSpedC175();
                if (findTmpSpedC175(id) == null) {
                    throw new NonexistentEntityException("The tmpSpedC175 with id " + id + " no longer exists.");
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
            TmpSpedC175 tmpSpedC175;
            try {
                tmpSpedC175 = em.getReference(TmpSpedC175.class, id);
                tmpSpedC175.getCodtmpSpedC175();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpSpedC175 with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpSpedC175);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpSpedC175> findTmpSpedC175Entities() {
        return findTmpSpedC175Entities(true, -1, -1);
    }

    public List<TmpSpedC175> findTmpSpedC175Entities(int maxResults, int firstResult) {
        return findTmpSpedC175Entities(false, maxResults, firstResult);
    }

    private List<TmpSpedC175> findTmpSpedC175Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpSpedC175.class));
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

    public TmpSpedC175 findTmpSpedC175(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpSpedC175.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpSpedC175Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpSpedC175> rt = cq.from(TmpSpedC175.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

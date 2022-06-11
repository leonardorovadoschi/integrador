/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpSpedC170;
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
public class TmpSpedC170JpaController implements Serializable {

    public TmpSpedC170JpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpSpedC170 tmpSpedC170) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpSpedC170);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpSpedC170(tmpSpedC170.getCodtmpSpedC170()) != null) {
                throw new PreexistingEntityException("TmpSpedC170 " + tmpSpedC170 + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpSpedC170 tmpSpedC170) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpSpedC170 = em.merge(tmpSpedC170);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tmpSpedC170.getCodtmpSpedC170();
                if (findTmpSpedC170(id) == null) {
                    throw new NonexistentEntityException("The tmpSpedC170 with id " + id + " no longer exists.");
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
            TmpSpedC170 tmpSpedC170;
            try {
                tmpSpedC170 = em.getReference(TmpSpedC170.class, id);
                tmpSpedC170.getCodtmpSpedC170();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpSpedC170 with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpSpedC170);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpSpedC170> findTmpSpedC170Entities() {
        return findTmpSpedC170Entities(true, -1, -1);
    }

    public List<TmpSpedC170> findTmpSpedC170Entities(int maxResults, int firstResult) {
        return findTmpSpedC170Entities(false, maxResults, firstResult);
    }

    private List<TmpSpedC170> findTmpSpedC170Entities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpSpedC170.class));
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

    public TmpSpedC170 findTmpSpedC170(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpSpedC170.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpSpedC170Count() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpSpedC170> rt = cq.from(TmpSpedC170.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

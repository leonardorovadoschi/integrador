/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpSpedUnidade;
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
public class TmpSpedUnidadeJpaController implements Serializable {

    public TmpSpedUnidadeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpSpedUnidade tmpSpedUnidade) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpSpedUnidade);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpSpedUnidade(tmpSpedUnidade.getUnidade()) != null) {
                throw new PreexistingEntityException("TmpSpedUnidade " + tmpSpedUnidade + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpSpedUnidade tmpSpedUnidade) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpSpedUnidade = em.merge(tmpSpedUnidade);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tmpSpedUnidade.getUnidade();
                if (findTmpSpedUnidade(id) == null) {
                    throw new NonexistentEntityException("The tmpSpedUnidade with id " + id + " no longer exists.");
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
            TmpSpedUnidade tmpSpedUnidade;
            try {
                tmpSpedUnidade = em.getReference(TmpSpedUnidade.class, id);
                tmpSpedUnidade.getUnidade();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpSpedUnidade with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpSpedUnidade);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpSpedUnidade> findTmpSpedUnidadeEntities() {
        return findTmpSpedUnidadeEntities(true, -1, -1);
    }

    public List<TmpSpedUnidade> findTmpSpedUnidadeEntities(int maxResults, int firstResult) {
        return findTmpSpedUnidadeEntities(false, maxResults, firstResult);
    }

    private List<TmpSpedUnidade> findTmpSpedUnidadeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpSpedUnidade.class));
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

    public TmpSpedUnidade findTmpSpedUnidade(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpSpedUnidade.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpSpedUnidadeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpSpedUnidade> rt = cq.from(TmpSpedUnidade.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

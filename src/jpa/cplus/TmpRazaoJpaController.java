/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpRazao;
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
public class TmpRazaoJpaController implements Serializable {

    public TmpRazaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpRazao tmpRazao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpRazao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpRazao(tmpRazao.getCodcli()) != null) {
                throw new PreexistingEntityException("TmpRazao " + tmpRazao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpRazao tmpRazao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpRazao = em.merge(tmpRazao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tmpRazao.getCodcli();
                if (findTmpRazao(id) == null) {
                    throw new NonexistentEntityException("The tmpRazao with id " + id + " no longer exists.");
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
            TmpRazao tmpRazao;
            try {
                tmpRazao = em.getReference(TmpRazao.class, id);
                tmpRazao.getCodcli();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpRazao with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpRazao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpRazao> findTmpRazaoEntities() {
        return findTmpRazaoEntities(true, -1, -1);
    }

    public List<TmpRazao> findTmpRazaoEntities(int maxResults, int firstResult) {
        return findTmpRazaoEntities(false, maxResults, firstResult);
    }

    private List<TmpRazao> findTmpRazaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpRazao.class));
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

    public TmpRazao findTmpRazao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpRazao.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpRazaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpRazao> rt = cq.from(TmpRazao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpAssistentecompraproduto;
import entidade.cplus.TmpAssistentecompraprodutoPK;
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
public class TmpAssistentecompraprodutoJpaController implements Serializable {

    public TmpAssistentecompraprodutoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpAssistentecompraproduto tmpAssistentecompraproduto) throws PreexistingEntityException, Exception {
        if (tmpAssistentecompraproduto.getTmpAssistentecompraprodutoPK() == null) {
            tmpAssistentecompraproduto.setTmpAssistentecompraprodutoPK(new TmpAssistentecompraprodutoPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpAssistentecompraproduto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpAssistentecompraproduto(tmpAssistentecompraproduto.getTmpAssistentecompraprodutoPK()) != null) {
                throw new PreexistingEntityException("TmpAssistentecompraproduto " + tmpAssistentecompraproduto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpAssistentecompraproduto tmpAssistentecompraproduto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpAssistentecompraproduto = em.merge(tmpAssistentecompraproduto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                TmpAssistentecompraprodutoPK id = tmpAssistentecompraproduto.getTmpAssistentecompraprodutoPK();
                if (findTmpAssistentecompraproduto(id) == null) {
                    throw new NonexistentEntityException("The tmpAssistentecompraproduto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(TmpAssistentecompraprodutoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TmpAssistentecompraproduto tmpAssistentecompraproduto;
            try {
                tmpAssistentecompraproduto = em.getReference(TmpAssistentecompraproduto.class, id);
                tmpAssistentecompraproduto.getTmpAssistentecompraprodutoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpAssistentecompraproduto with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpAssistentecompraproduto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpAssistentecompraproduto> findTmpAssistentecompraprodutoEntities() {
        return findTmpAssistentecompraprodutoEntities(true, -1, -1);
    }

    public List<TmpAssistentecompraproduto> findTmpAssistentecompraprodutoEntities(int maxResults, int firstResult) {
        return findTmpAssistentecompraprodutoEntities(false, maxResults, firstResult);
    }

    private List<TmpAssistentecompraproduto> findTmpAssistentecompraprodutoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpAssistentecompraproduto.class));
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

    public TmpAssistentecompraproduto findTmpAssistentecompraproduto(TmpAssistentecompraprodutoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpAssistentecompraproduto.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpAssistentecompraprodutoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpAssistentecompraproduto> rt = cq.from(TmpAssistentecompraproduto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

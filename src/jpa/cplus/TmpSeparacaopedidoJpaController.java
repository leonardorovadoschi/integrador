/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpSeparacaopedido;
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
public class TmpSeparacaopedidoJpaController implements Serializable {

    public TmpSeparacaopedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpSeparacaopedido tmpSeparacaopedido) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpSeparacaopedido);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpSeparacaopedido(tmpSeparacaopedido.getCodmovprod()) != null) {
                throw new PreexistingEntityException("TmpSeparacaopedido " + tmpSeparacaopedido + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpSeparacaopedido tmpSeparacaopedido) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpSeparacaopedido = em.merge(tmpSeparacaopedido);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tmpSeparacaopedido.getCodmovprod();
                if (findTmpSeparacaopedido(id) == null) {
                    throw new NonexistentEntityException("The tmpSeparacaopedido with id " + id + " no longer exists.");
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
            TmpSeparacaopedido tmpSeparacaopedido;
            try {
                tmpSeparacaopedido = em.getReference(TmpSeparacaopedido.class, id);
                tmpSeparacaopedido.getCodmovprod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpSeparacaopedido with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpSeparacaopedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpSeparacaopedido> findTmpSeparacaopedidoEntities() {
        return findTmpSeparacaopedidoEntities(true, -1, -1);
    }

    public List<TmpSeparacaopedido> findTmpSeparacaopedidoEntities(int maxResults, int firstResult) {
        return findTmpSeparacaopedidoEntities(false, maxResults, firstResult);
    }

    private List<TmpSeparacaopedido> findTmpSeparacaopedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpSeparacaopedido.class));
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

    public TmpSeparacaopedido findTmpSeparacaopedido(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpSeparacaopedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpSeparacaopedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpSeparacaopedido> rt = cq.from(TmpSeparacaopedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

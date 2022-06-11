/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Tipogradedetalhe;
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
public class TipogradedetalheJpaController implements Serializable {

    public TipogradedetalheJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipogradedetalhe tipogradedetalhe) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipogradedetalhe);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipogradedetalhe(tipogradedetalhe.getCodgradedetalhe()) != null) {
                throw new PreexistingEntityException("Tipogradedetalhe " + tipogradedetalhe + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipogradedetalhe tipogradedetalhe) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipogradedetalhe = em.merge(tipogradedetalhe);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tipogradedetalhe.getCodgradedetalhe();
                if (findTipogradedetalhe(id) == null) {
                    throw new NonexistentEntityException("The tipogradedetalhe with id " + id + " no longer exists.");
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
            Tipogradedetalhe tipogradedetalhe;
            try {
                tipogradedetalhe = em.getReference(Tipogradedetalhe.class, id);
                tipogradedetalhe.getCodgradedetalhe();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipogradedetalhe with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipogradedetalhe);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipogradedetalhe> findTipogradedetalheEntities() {
        return findTipogradedetalheEntities(true, -1, -1);
    }

    public List<Tipogradedetalhe> findTipogradedetalheEntities(int maxResults, int firstResult) {
        return findTipogradedetalheEntities(false, maxResults, firstResult);
    }

    private List<Tipogradedetalhe> findTipogradedetalheEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipogradedetalhe.class));
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

    public Tipogradedetalhe findTipogradedetalhe(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipogradedetalhe.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipogradedetalheCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipogradedetalhe> rt = cq.from(Tipogradedetalhe.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

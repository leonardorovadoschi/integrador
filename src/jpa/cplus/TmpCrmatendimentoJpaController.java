/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.TmpCrmatendimento;
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
public class TmpCrmatendimentoJpaController implements Serializable {

    public TmpCrmatendimentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TmpCrmatendimento tmpCrmatendimento) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tmpCrmatendimento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTmpCrmatendimento(tmpCrmatendimento.getCodatend()) != null) {
                throw new PreexistingEntityException("TmpCrmatendimento " + tmpCrmatendimento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TmpCrmatendimento tmpCrmatendimento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tmpCrmatendimento = em.merge(tmpCrmatendimento);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tmpCrmatendimento.getCodatend();
                if (findTmpCrmatendimento(id) == null) {
                    throw new NonexistentEntityException("The tmpCrmatendimento with id " + id + " no longer exists.");
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
            TmpCrmatendimento tmpCrmatendimento;
            try {
                tmpCrmatendimento = em.getReference(TmpCrmatendimento.class, id);
                tmpCrmatendimento.getCodatend();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tmpCrmatendimento with id " + id + " no longer exists.", enfe);
            }
            em.remove(tmpCrmatendimento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TmpCrmatendimento> findTmpCrmatendimentoEntities() {
        return findTmpCrmatendimentoEntities(true, -1, -1);
    }

    public List<TmpCrmatendimento> findTmpCrmatendimentoEntities(int maxResults, int firstResult) {
        return findTmpCrmatendimentoEntities(false, maxResults, firstResult);
    }

    private List<TmpCrmatendimento> findTmpCrmatendimentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TmpCrmatendimento.class));
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

    public TmpCrmatendimento findTmpCrmatendimento(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TmpCrmatendimento.class, id);
        } finally {
            em.close();
        }
    }

    public int getTmpCrmatendimentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TmpCrmatendimento> rt = cq.from(TmpCrmatendimento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

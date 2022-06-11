/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Tipotransacao;
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
public class TipotransacaoJpaController implements Serializable {

    public TipotransacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipotransacao tipotransacao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipotransacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipotransacao(tipotransacao.getCodtipotransacao()) != null) {
                throw new PreexistingEntityException("Tipotransacao " + tipotransacao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipotransacao tipotransacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipotransacao = em.merge(tipotransacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Short id = tipotransacao.getCodtipotransacao();
                if (findTipotransacao(id) == null) {
                    throw new NonexistentEntityException("The tipotransacao with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Short id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipotransacao tipotransacao;
            try {
                tipotransacao = em.getReference(Tipotransacao.class, id);
                tipotransacao.getCodtipotransacao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipotransacao with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipotransacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipotransacao> findTipotransacaoEntities() {
        return findTipotransacaoEntities(true, -1, -1);
    }

    public List<Tipotransacao> findTipotransacaoEntities(int maxResults, int firstResult) {
        return findTipotransacaoEntities(false, maxResults, firstResult);
    }

    private List<Tipotransacao> findTipotransacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipotransacao.class));
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

    public Tipotransacao findTipotransacao(Short id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipotransacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipotransacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipotransacao> rt = cq.from(Tipotransacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

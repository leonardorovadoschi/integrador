/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Contareceber;
import entidade.cplus.Historicocobranca;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class HistoricocobrancaJpaController implements Serializable {

    public HistoricocobrancaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Historicocobranca historicocobranca) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contareceber codcr = historicocobranca.getCodcr();
            if (codcr != null) {
                codcr = em.getReference(codcr.getClass(), codcr.getCodcr());
                historicocobranca.setCodcr(codcr);
            }
            em.persist(historicocobranca);
            if (codcr != null) {
                codcr.getHistoricocobrancaCollection().add(historicocobranca);
                codcr = em.merge(codcr);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHistoricocobranca(historicocobranca.getCodhistoricocobranca()) != null) {
                throw new PreexistingEntityException("Historicocobranca " + historicocobranca + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Historicocobranca historicocobranca) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Historicocobranca persistentHistoricocobranca = em.find(Historicocobranca.class, historicocobranca.getCodhistoricocobranca());
            Contareceber codcrOld = persistentHistoricocobranca.getCodcr();
            Contareceber codcrNew = historicocobranca.getCodcr();
            if (codcrNew != null) {
                codcrNew = em.getReference(codcrNew.getClass(), codcrNew.getCodcr());
                historicocobranca.setCodcr(codcrNew);
            }
            historicocobranca = em.merge(historicocobranca);
            if (codcrOld != null && !codcrOld.equals(codcrNew)) {
                codcrOld.getHistoricocobrancaCollection().remove(historicocobranca);
                codcrOld = em.merge(codcrOld);
            }
            if (codcrNew != null && !codcrNew.equals(codcrOld)) {
                codcrNew.getHistoricocobrancaCollection().add(historicocobranca);
                codcrNew = em.merge(codcrNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = historicocobranca.getCodhistoricocobranca();
                if (findHistoricocobranca(id) == null) {
                    throw new NonexistentEntityException("The historicocobranca with id " + id + " no longer exists.");
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
            Historicocobranca historicocobranca;
            try {
                historicocobranca = em.getReference(Historicocobranca.class, id);
                historicocobranca.getCodhistoricocobranca();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The historicocobranca with id " + id + " no longer exists.", enfe);
            }
            Contareceber codcr = historicocobranca.getCodcr();
            if (codcr != null) {
                codcr.getHistoricocobrancaCollection().remove(historicocobranca);
                codcr = em.merge(codcr);
            }
            em.remove(historicocobranca);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Historicocobranca> findHistoricocobrancaEntities() {
        return findHistoricocobrancaEntities(true, -1, -1);
    }

    public List<Historicocobranca> findHistoricocobrancaEntities(int maxResults, int firstResult) {
        return findHistoricocobrancaEntities(false, maxResults, firstResult);
    }

    private List<Historicocobranca> findHistoricocobrancaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Historicocobranca.class));
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

    public Historicocobranca findHistoricocobranca(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Historicocobranca.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistoricocobrancaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Historicocobranca> rt = cq.from(Historicocobranca.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Nfeletronicaexcecao;
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
public class NfeletronicaexcecaoJpaController implements Serializable {

    public NfeletronicaexcecaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Nfeletronicaexcecao nfeletronicaexcecao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(nfeletronicaexcecao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNfeletronicaexcecao(nfeletronicaexcecao.getCodigo()) != null) {
                throw new PreexistingEntityException("Nfeletronicaexcecao " + nfeletronicaexcecao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nfeletronicaexcecao nfeletronicaexcecao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            nfeletronicaexcecao = em.merge(nfeletronicaexcecao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = nfeletronicaexcecao.getCodigo();
                if (findNfeletronicaexcecao(id) == null) {
                    throw new NonexistentEntityException("The nfeletronicaexcecao with id " + id + " no longer exists.");
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
            Nfeletronicaexcecao nfeletronicaexcecao;
            try {
                nfeletronicaexcecao = em.getReference(Nfeletronicaexcecao.class, id);
                nfeletronicaexcecao.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nfeletronicaexcecao with id " + id + " no longer exists.", enfe);
            }
            em.remove(nfeletronicaexcecao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nfeletronicaexcecao> findNfeletronicaexcecaoEntities() {
        return findNfeletronicaexcecaoEntities(true, -1, -1);
    }

    public List<Nfeletronicaexcecao> findNfeletronicaexcecaoEntities(int maxResults, int firstResult) {
        return findNfeletronicaexcecaoEntities(false, maxResults, firstResult);
    }

    private List<Nfeletronicaexcecao> findNfeletronicaexcecaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nfeletronicaexcecao.class));
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

    public Nfeletronicaexcecao findNfeletronicaexcecao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nfeletronicaexcecao.class, id);
        } finally {
            em.close();
        }
    }

    public int getNfeletronicaexcecaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nfeletronicaexcecao> rt = cq.from(Nfeletronicaexcecao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Nfeletronicainutilizacao;
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
public class NfeletronicainutilizacaoJpaController implements Serializable {

    public NfeletronicainutilizacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Nfeletronicainutilizacao nfeletronicainutilizacao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(nfeletronicainutilizacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNfeletronicainutilizacao(nfeletronicainutilizacao.getCodnfeletronicainutilizacao()) != null) {
                throw new PreexistingEntityException("Nfeletronicainutilizacao " + nfeletronicainutilizacao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nfeletronicainutilizacao nfeletronicainutilizacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            nfeletronicainutilizacao = em.merge(nfeletronicainutilizacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = nfeletronicainutilizacao.getCodnfeletronicainutilizacao();
                if (findNfeletronicainutilizacao(id) == null) {
                    throw new NonexistentEntityException("The nfeletronicainutilizacao with id " + id + " no longer exists.");
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
            Nfeletronicainutilizacao nfeletronicainutilizacao;
            try {
                nfeletronicainutilizacao = em.getReference(Nfeletronicainutilizacao.class, id);
                nfeletronicainutilizacao.getCodnfeletronicainutilizacao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nfeletronicainutilizacao with id " + id + " no longer exists.", enfe);
            }
            em.remove(nfeletronicainutilizacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nfeletronicainutilizacao> findNfeletronicainutilizacaoEntities() {
        return findNfeletronicainutilizacaoEntities(true, -1, -1);
    }

    public List<Nfeletronicainutilizacao> findNfeletronicainutilizacaoEntities(int maxResults, int firstResult) {
        return findNfeletronicainutilizacaoEntities(false, maxResults, firstResult);
    }

    private List<Nfeletronicainutilizacao> findNfeletronicainutilizacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nfeletronicainutilizacao.class));
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

    public Nfeletronicainutilizacao findNfeletronicainutilizacao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nfeletronicainutilizacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getNfeletronicainutilizacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nfeletronicainutilizacao> rt = cq.from(Nfeletronicainutilizacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

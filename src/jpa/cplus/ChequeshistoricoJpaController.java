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
import entidade.cplus.Cheques;
import entidade.cplus.Chequeshistorico;
import entidade.cplus.Vendedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ChequeshistoricoJpaController implements Serializable {

    public ChequeshistoricoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Chequeshistorico chequeshistorico) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cheques codcheque = chequeshistorico.getCodcheque();
            if (codcheque != null) {
                codcheque = em.getReference(codcheque.getClass(), codcheque.getCodcheque());
                chequeshistorico.setCodcheque(codcheque);
            }
            Vendedor codvendedrenegociacao = chequeshistorico.getCodvendedrenegociacao();
            if (codvendedrenegociacao != null) {
                codvendedrenegociacao = em.getReference(codvendedrenegociacao.getClass(), codvendedrenegociacao.getCodvended());
                chequeshistorico.setCodvendedrenegociacao(codvendedrenegociacao);
            }
            em.persist(chequeshistorico);
            if (codcheque != null) {
                codcheque.getChequeshistoricoCollection().add(chequeshistorico);
                codcheque = em.merge(codcheque);
            }
            if (codvendedrenegociacao != null) {
                codvendedrenegociacao.getChequeshistoricoCollection().add(chequeshistorico);
                codvendedrenegociacao = em.merge(codvendedrenegociacao);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findChequeshistorico(chequeshistorico.getCodchequeshistorico()) != null) {
                throw new PreexistingEntityException("Chequeshistorico " + chequeshistorico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Chequeshistorico chequeshistorico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Chequeshistorico persistentChequeshistorico = em.find(Chequeshistorico.class, chequeshistorico.getCodchequeshistorico());
            Cheques codchequeOld = persistentChequeshistorico.getCodcheque();
            Cheques codchequeNew = chequeshistorico.getCodcheque();
            Vendedor codvendedrenegociacaoOld = persistentChequeshistorico.getCodvendedrenegociacao();
            Vendedor codvendedrenegociacaoNew = chequeshistorico.getCodvendedrenegociacao();
            if (codchequeNew != null) {
                codchequeNew = em.getReference(codchequeNew.getClass(), codchequeNew.getCodcheque());
                chequeshistorico.setCodcheque(codchequeNew);
            }
            if (codvendedrenegociacaoNew != null) {
                codvendedrenegociacaoNew = em.getReference(codvendedrenegociacaoNew.getClass(), codvendedrenegociacaoNew.getCodvended());
                chequeshistorico.setCodvendedrenegociacao(codvendedrenegociacaoNew);
            }
            chequeshistorico = em.merge(chequeshistorico);
            if (codchequeOld != null && !codchequeOld.equals(codchequeNew)) {
                codchequeOld.getChequeshistoricoCollection().remove(chequeshistorico);
                codchequeOld = em.merge(codchequeOld);
            }
            if (codchequeNew != null && !codchequeNew.equals(codchequeOld)) {
                codchequeNew.getChequeshistoricoCollection().add(chequeshistorico);
                codchequeNew = em.merge(codchequeNew);
            }
            if (codvendedrenegociacaoOld != null && !codvendedrenegociacaoOld.equals(codvendedrenegociacaoNew)) {
                codvendedrenegociacaoOld.getChequeshistoricoCollection().remove(chequeshistorico);
                codvendedrenegociacaoOld = em.merge(codvendedrenegociacaoOld);
            }
            if (codvendedrenegociacaoNew != null && !codvendedrenegociacaoNew.equals(codvendedrenegociacaoOld)) {
                codvendedrenegociacaoNew.getChequeshistoricoCollection().add(chequeshistorico);
                codvendedrenegociacaoNew = em.merge(codvendedrenegociacaoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = chequeshistorico.getCodchequeshistorico();
                if (findChequeshistorico(id) == null) {
                    throw new NonexistentEntityException("The chequeshistorico with id " + id + " no longer exists.");
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
            Chequeshistorico chequeshistorico;
            try {
                chequeshistorico = em.getReference(Chequeshistorico.class, id);
                chequeshistorico.getCodchequeshistorico();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The chequeshistorico with id " + id + " no longer exists.", enfe);
            }
            Cheques codcheque = chequeshistorico.getCodcheque();
            if (codcheque != null) {
                codcheque.getChequeshistoricoCollection().remove(chequeshistorico);
                codcheque = em.merge(codcheque);
            }
            Vendedor codvendedrenegociacao = chequeshistorico.getCodvendedrenegociacao();
            if (codvendedrenegociacao != null) {
                codvendedrenegociacao.getChequeshistoricoCollection().remove(chequeshistorico);
                codvendedrenegociacao = em.merge(codvendedrenegociacao);
            }
            em.remove(chequeshistorico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Chequeshistorico> findChequeshistoricoEntities() {
        return findChequeshistoricoEntities(true, -1, -1);
    }

    public List<Chequeshistorico> findChequeshistoricoEntities(int maxResults, int firstResult) {
        return findChequeshistoricoEntities(false, maxResults, firstResult);
    }

    private List<Chequeshistorico> findChequeshistoricoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Chequeshistorico.class));
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

    public Chequeshistorico findChequeshistorico(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Chequeshistorico.class, id);
        } finally {
            em.close();
        }
    }

    public int getChequeshistoricoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Chequeshistorico> rt = cq.from(Chequeshistorico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

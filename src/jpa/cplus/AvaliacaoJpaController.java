/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Avaliacao;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Funcionario;
import entidade.cplus.Tipoavaliacao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class AvaliacaoJpaController implements Serializable {

    public AvaliacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Avaliacao avaliacao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Funcionario codfunc = avaliacao.getCodfunc();
            if (codfunc != null) {
                codfunc = em.getReference(codfunc.getClass(), codfunc.getCodfuncionario());
                avaliacao.setCodfunc(codfunc);
            }
            Tipoavaliacao codtipoavaliacao = avaliacao.getCodtipoavaliacao();
            if (codtipoavaliacao != null) {
                codtipoavaliacao = em.getReference(codtipoavaliacao.getClass(), codtipoavaliacao.getCodtipoavaliacao());
                avaliacao.setCodtipoavaliacao(codtipoavaliacao);
            }
            em.persist(avaliacao);
            if (codfunc != null) {
                codfunc.getAvaliacaoCollection().add(avaliacao);
                codfunc = em.merge(codfunc);
            }
            if (codtipoavaliacao != null) {
                codtipoavaliacao.getAvaliacaoCollection().add(avaliacao);
                codtipoavaliacao = em.merge(codtipoavaliacao);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAvaliacao(avaliacao.getCodavaliacao()) != null) {
                throw new PreexistingEntityException("Avaliacao " + avaliacao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Avaliacao avaliacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Avaliacao persistentAvaliacao = em.find(Avaliacao.class, avaliacao.getCodavaliacao());
            Funcionario codfuncOld = persistentAvaliacao.getCodfunc();
            Funcionario codfuncNew = avaliacao.getCodfunc();
            Tipoavaliacao codtipoavaliacaoOld = persistentAvaliacao.getCodtipoavaliacao();
            Tipoavaliacao codtipoavaliacaoNew = avaliacao.getCodtipoavaliacao();
            if (codfuncNew != null) {
                codfuncNew = em.getReference(codfuncNew.getClass(), codfuncNew.getCodfuncionario());
                avaliacao.setCodfunc(codfuncNew);
            }
            if (codtipoavaliacaoNew != null) {
                codtipoavaliacaoNew = em.getReference(codtipoavaliacaoNew.getClass(), codtipoavaliacaoNew.getCodtipoavaliacao());
                avaliacao.setCodtipoavaliacao(codtipoavaliacaoNew);
            }
            avaliacao = em.merge(avaliacao);
            if (codfuncOld != null && !codfuncOld.equals(codfuncNew)) {
                codfuncOld.getAvaliacaoCollection().remove(avaliacao);
                codfuncOld = em.merge(codfuncOld);
            }
            if (codfuncNew != null && !codfuncNew.equals(codfuncOld)) {
                codfuncNew.getAvaliacaoCollection().add(avaliacao);
                codfuncNew = em.merge(codfuncNew);
            }
            if (codtipoavaliacaoOld != null && !codtipoavaliacaoOld.equals(codtipoavaliacaoNew)) {
                codtipoavaliacaoOld.getAvaliacaoCollection().remove(avaliacao);
                codtipoavaliacaoOld = em.merge(codtipoavaliacaoOld);
            }
            if (codtipoavaliacaoNew != null && !codtipoavaliacaoNew.equals(codtipoavaliacaoOld)) {
                codtipoavaliacaoNew.getAvaliacaoCollection().add(avaliacao);
                codtipoavaliacaoNew = em.merge(codtipoavaliacaoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = avaliacao.getCodavaliacao();
                if (findAvaliacao(id) == null) {
                    throw new NonexistentEntityException("The avaliacao with id " + id + " no longer exists.");
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
            Avaliacao avaliacao;
            try {
                avaliacao = em.getReference(Avaliacao.class, id);
                avaliacao.getCodavaliacao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The avaliacao with id " + id + " no longer exists.", enfe);
            }
            Funcionario codfunc = avaliacao.getCodfunc();
            if (codfunc != null) {
                codfunc.getAvaliacaoCollection().remove(avaliacao);
                codfunc = em.merge(codfunc);
            }
            Tipoavaliacao codtipoavaliacao = avaliacao.getCodtipoavaliacao();
            if (codtipoavaliacao != null) {
                codtipoavaliacao.getAvaliacaoCollection().remove(avaliacao);
                codtipoavaliacao = em.merge(codtipoavaliacao);
            }
            em.remove(avaliacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Avaliacao> findAvaliacaoEntities() {
        return findAvaliacaoEntities(true, -1, -1);
    }

    public List<Avaliacao> findAvaliacaoEntities(int maxResults, int firstResult) {
        return findAvaliacaoEntities(false, maxResults, firstResult);
    }

    private List<Avaliacao> findAvaliacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Avaliacao.class));
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

    public Avaliacao findAvaliacao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Avaliacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getAvaliacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Avaliacao> rt = cq.from(Avaliacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

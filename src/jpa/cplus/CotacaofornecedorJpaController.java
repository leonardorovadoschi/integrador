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
import entidade.cplus.Cotacao;
import entidade.cplus.Cotacaofornecedor;
import entidade.cplus.Fornecedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class CotacaofornecedorJpaController implements Serializable {

    public CotacaofornecedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cotacaofornecedor cotacaofornecedor) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cotacao codcotacao = cotacaofornecedor.getCodcotacao();
            if (codcotacao != null) {
                codcotacao = em.getReference(codcotacao.getClass(), codcotacao.getCodcotacao());
                cotacaofornecedor.setCodcotacao(codcotacao);
            }
            Fornecedor codforn = cotacaofornecedor.getCodforn();
            if (codforn != null) {
                codforn = em.getReference(codforn.getClass(), codforn.getCodforn());
                cotacaofornecedor.setCodforn(codforn);
            }
            em.persist(cotacaofornecedor);
            if (codcotacao != null) {
                codcotacao.getCotacaofornecedorCollection().add(cotacaofornecedor);
                codcotacao = em.merge(codcotacao);
            }
            if (codforn != null) {
                codforn.getCotacaofornecedorCollection().add(cotacaofornecedor);
                codforn = em.merge(codforn);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCotacaofornecedor(cotacaofornecedor.getCodcotacaofornecedor()) != null) {
                throw new PreexistingEntityException("Cotacaofornecedor " + cotacaofornecedor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cotacaofornecedor cotacaofornecedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cotacaofornecedor persistentCotacaofornecedor = em.find(Cotacaofornecedor.class, cotacaofornecedor.getCodcotacaofornecedor());
            Cotacao codcotacaoOld = persistentCotacaofornecedor.getCodcotacao();
            Cotacao codcotacaoNew = cotacaofornecedor.getCodcotacao();
            Fornecedor codfornOld = persistentCotacaofornecedor.getCodforn();
            Fornecedor codfornNew = cotacaofornecedor.getCodforn();
            if (codcotacaoNew != null) {
                codcotacaoNew = em.getReference(codcotacaoNew.getClass(), codcotacaoNew.getCodcotacao());
                cotacaofornecedor.setCodcotacao(codcotacaoNew);
            }
            if (codfornNew != null) {
                codfornNew = em.getReference(codfornNew.getClass(), codfornNew.getCodforn());
                cotacaofornecedor.setCodforn(codfornNew);
            }
            cotacaofornecedor = em.merge(cotacaofornecedor);
            if (codcotacaoOld != null && !codcotacaoOld.equals(codcotacaoNew)) {
                codcotacaoOld.getCotacaofornecedorCollection().remove(cotacaofornecedor);
                codcotacaoOld = em.merge(codcotacaoOld);
            }
            if (codcotacaoNew != null && !codcotacaoNew.equals(codcotacaoOld)) {
                codcotacaoNew.getCotacaofornecedorCollection().add(cotacaofornecedor);
                codcotacaoNew = em.merge(codcotacaoNew);
            }
            if (codfornOld != null && !codfornOld.equals(codfornNew)) {
                codfornOld.getCotacaofornecedorCollection().remove(cotacaofornecedor);
                codfornOld = em.merge(codfornOld);
            }
            if (codfornNew != null && !codfornNew.equals(codfornOld)) {
                codfornNew.getCotacaofornecedorCollection().add(cotacaofornecedor);
                codfornNew = em.merge(codfornNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cotacaofornecedor.getCodcotacaofornecedor();
                if (findCotacaofornecedor(id) == null) {
                    throw new NonexistentEntityException("The cotacaofornecedor with id " + id + " no longer exists.");
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
            Cotacaofornecedor cotacaofornecedor;
            try {
                cotacaofornecedor = em.getReference(Cotacaofornecedor.class, id);
                cotacaofornecedor.getCodcotacaofornecedor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cotacaofornecedor with id " + id + " no longer exists.", enfe);
            }
            Cotacao codcotacao = cotacaofornecedor.getCodcotacao();
            if (codcotacao != null) {
                codcotacao.getCotacaofornecedorCollection().remove(cotacaofornecedor);
                codcotacao = em.merge(codcotacao);
            }
            Fornecedor codforn = cotacaofornecedor.getCodforn();
            if (codforn != null) {
                codforn.getCotacaofornecedorCollection().remove(cotacaofornecedor);
                codforn = em.merge(codforn);
            }
            em.remove(cotacaofornecedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cotacaofornecedor> findCotacaofornecedorEntities() {
        return findCotacaofornecedorEntities(true, -1, -1);
    }

    public List<Cotacaofornecedor> findCotacaofornecedorEntities(int maxResults, int firstResult) {
        return findCotacaofornecedorEntities(false, maxResults, firstResult);
    }

    private List<Cotacaofornecedor> findCotacaofornecedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cotacaofornecedor.class));
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

    public Cotacaofornecedor findCotacaofornecedor(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cotacaofornecedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getCotacaofornecedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cotacaofornecedor> rt = cq.from(Cotacaofornecedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

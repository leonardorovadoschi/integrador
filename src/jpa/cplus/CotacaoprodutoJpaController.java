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
import entidade.cplus.Produto;
import entidade.cplus.Cotacaofornecedorpreco;
import entidade.cplus.Cotacaoproduto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class CotacaoprodutoJpaController implements Serializable {

    public CotacaoprodutoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cotacaoproduto cotacaoproduto) throws PreexistingEntityException, Exception {
        if (cotacaoproduto.getCotacaofornecedorprecoCollection() == null) {
            cotacaoproduto.setCotacaofornecedorprecoCollection(new ArrayList<Cotacaofornecedorpreco>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cotacao codcotacao = cotacaoproduto.getCodcotacao();
            if (codcotacao != null) {
                codcotacao = em.getReference(codcotacao.getClass(), codcotacao.getCodcotacao());
                cotacaoproduto.setCodcotacao(codcotacao);
            }
            Produto codprod = cotacaoproduto.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                cotacaoproduto.setCodprod(codprod);
            }
            Collection<Cotacaofornecedorpreco> attachedCotacaofornecedorprecoCollection = new ArrayList<Cotacaofornecedorpreco>();
            for (Cotacaofornecedorpreco cotacaofornecedorprecoCollectionCotacaofornecedorprecoToAttach : cotacaoproduto.getCotacaofornecedorprecoCollection()) {
                cotacaofornecedorprecoCollectionCotacaofornecedorprecoToAttach = em.getReference(cotacaofornecedorprecoCollectionCotacaofornecedorprecoToAttach.getClass(), cotacaofornecedorprecoCollectionCotacaofornecedorprecoToAttach.getCodcotacaofornecedorpreco());
                attachedCotacaofornecedorprecoCollection.add(cotacaofornecedorprecoCollectionCotacaofornecedorprecoToAttach);
            }
            cotacaoproduto.setCotacaofornecedorprecoCollection(attachedCotacaofornecedorprecoCollection);
            em.persist(cotacaoproduto);
            if (codcotacao != null) {
                codcotacao.getCotacaoprodutoCollection().add(cotacaoproduto);
                codcotacao = em.merge(codcotacao);
            }
            if (codprod != null) {
                codprod.getCotacaoprodutoCollection().add(cotacaoproduto);
                codprod = em.merge(codprod);
            }
            for (Cotacaofornecedorpreco cotacaofornecedorprecoCollectionCotacaofornecedorpreco : cotacaoproduto.getCotacaofornecedorprecoCollection()) {
                Cotacaoproduto oldCodcotacaoprodutoOfCotacaofornecedorprecoCollectionCotacaofornecedorpreco = cotacaofornecedorprecoCollectionCotacaofornecedorpreco.getCodcotacaoproduto();
                cotacaofornecedorprecoCollectionCotacaofornecedorpreco.setCodcotacaoproduto(cotacaoproduto);
                cotacaofornecedorprecoCollectionCotacaofornecedorpreco = em.merge(cotacaofornecedorprecoCollectionCotacaofornecedorpreco);
                if (oldCodcotacaoprodutoOfCotacaofornecedorprecoCollectionCotacaofornecedorpreco != null) {
                    oldCodcotacaoprodutoOfCotacaofornecedorprecoCollectionCotacaofornecedorpreco.getCotacaofornecedorprecoCollection().remove(cotacaofornecedorprecoCollectionCotacaofornecedorpreco);
                    oldCodcotacaoprodutoOfCotacaofornecedorprecoCollectionCotacaofornecedorpreco = em.merge(oldCodcotacaoprodutoOfCotacaofornecedorprecoCollectionCotacaofornecedorpreco);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCotacaoproduto(cotacaoproduto.getCodcotacaoproduto()) != null) {
                throw new PreexistingEntityException("Cotacaoproduto " + cotacaoproduto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cotacaoproduto cotacaoproduto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cotacaoproduto persistentCotacaoproduto = em.find(Cotacaoproduto.class, cotacaoproduto.getCodcotacaoproduto());
            Cotacao codcotacaoOld = persistentCotacaoproduto.getCodcotacao();
            Cotacao codcotacaoNew = cotacaoproduto.getCodcotacao();
            Produto codprodOld = persistentCotacaoproduto.getCodprod();
            Produto codprodNew = cotacaoproduto.getCodprod();
            Collection<Cotacaofornecedorpreco> cotacaofornecedorprecoCollectionOld = persistentCotacaoproduto.getCotacaofornecedorprecoCollection();
            Collection<Cotacaofornecedorpreco> cotacaofornecedorprecoCollectionNew = cotacaoproduto.getCotacaofornecedorprecoCollection();
            if (codcotacaoNew != null) {
                codcotacaoNew = em.getReference(codcotacaoNew.getClass(), codcotacaoNew.getCodcotacao());
                cotacaoproduto.setCodcotacao(codcotacaoNew);
            }
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                cotacaoproduto.setCodprod(codprodNew);
            }
            Collection<Cotacaofornecedorpreco> attachedCotacaofornecedorprecoCollectionNew = new ArrayList<Cotacaofornecedorpreco>();
            for (Cotacaofornecedorpreco cotacaofornecedorprecoCollectionNewCotacaofornecedorprecoToAttach : cotacaofornecedorprecoCollectionNew) {
                cotacaofornecedorprecoCollectionNewCotacaofornecedorprecoToAttach = em.getReference(cotacaofornecedorprecoCollectionNewCotacaofornecedorprecoToAttach.getClass(), cotacaofornecedorprecoCollectionNewCotacaofornecedorprecoToAttach.getCodcotacaofornecedorpreco());
                attachedCotacaofornecedorprecoCollectionNew.add(cotacaofornecedorprecoCollectionNewCotacaofornecedorprecoToAttach);
            }
            cotacaofornecedorprecoCollectionNew = attachedCotacaofornecedorprecoCollectionNew;
            cotacaoproduto.setCotacaofornecedorprecoCollection(cotacaofornecedorprecoCollectionNew);
            cotacaoproduto = em.merge(cotacaoproduto);
            if (codcotacaoOld != null && !codcotacaoOld.equals(codcotacaoNew)) {
                codcotacaoOld.getCotacaoprodutoCollection().remove(cotacaoproduto);
                codcotacaoOld = em.merge(codcotacaoOld);
            }
            if (codcotacaoNew != null && !codcotacaoNew.equals(codcotacaoOld)) {
                codcotacaoNew.getCotacaoprodutoCollection().add(cotacaoproduto);
                codcotacaoNew = em.merge(codcotacaoNew);
            }
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getCotacaoprodutoCollection().remove(cotacaoproduto);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getCotacaoprodutoCollection().add(cotacaoproduto);
                codprodNew = em.merge(codprodNew);
            }
            for (Cotacaofornecedorpreco cotacaofornecedorprecoCollectionOldCotacaofornecedorpreco : cotacaofornecedorprecoCollectionOld) {
                if (!cotacaofornecedorprecoCollectionNew.contains(cotacaofornecedorprecoCollectionOldCotacaofornecedorpreco)) {
                    cotacaofornecedorprecoCollectionOldCotacaofornecedorpreco.setCodcotacaoproduto(null);
                    cotacaofornecedorprecoCollectionOldCotacaofornecedorpreco = em.merge(cotacaofornecedorprecoCollectionOldCotacaofornecedorpreco);
                }
            }
            for (Cotacaofornecedorpreco cotacaofornecedorprecoCollectionNewCotacaofornecedorpreco : cotacaofornecedorprecoCollectionNew) {
                if (!cotacaofornecedorprecoCollectionOld.contains(cotacaofornecedorprecoCollectionNewCotacaofornecedorpreco)) {
                    Cotacaoproduto oldCodcotacaoprodutoOfCotacaofornecedorprecoCollectionNewCotacaofornecedorpreco = cotacaofornecedorprecoCollectionNewCotacaofornecedorpreco.getCodcotacaoproduto();
                    cotacaofornecedorprecoCollectionNewCotacaofornecedorpreco.setCodcotacaoproduto(cotacaoproduto);
                    cotacaofornecedorprecoCollectionNewCotacaofornecedorpreco = em.merge(cotacaofornecedorprecoCollectionNewCotacaofornecedorpreco);
                    if (oldCodcotacaoprodutoOfCotacaofornecedorprecoCollectionNewCotacaofornecedorpreco != null && !oldCodcotacaoprodutoOfCotacaofornecedorprecoCollectionNewCotacaofornecedorpreco.equals(cotacaoproduto)) {
                        oldCodcotacaoprodutoOfCotacaofornecedorprecoCollectionNewCotacaofornecedorpreco.getCotacaofornecedorprecoCollection().remove(cotacaofornecedorprecoCollectionNewCotacaofornecedorpreco);
                        oldCodcotacaoprodutoOfCotacaofornecedorprecoCollectionNewCotacaofornecedorpreco = em.merge(oldCodcotacaoprodutoOfCotacaofornecedorprecoCollectionNewCotacaofornecedorpreco);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cotacaoproduto.getCodcotacaoproduto();
                if (findCotacaoproduto(id) == null) {
                    throw new NonexistentEntityException("The cotacaoproduto with id " + id + " no longer exists.");
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
            Cotacaoproduto cotacaoproduto;
            try {
                cotacaoproduto = em.getReference(Cotacaoproduto.class, id);
                cotacaoproduto.getCodcotacaoproduto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cotacaoproduto with id " + id + " no longer exists.", enfe);
            }
            Cotacao codcotacao = cotacaoproduto.getCodcotacao();
            if (codcotacao != null) {
                codcotacao.getCotacaoprodutoCollection().remove(cotacaoproduto);
                codcotacao = em.merge(codcotacao);
            }
            Produto codprod = cotacaoproduto.getCodprod();
            if (codprod != null) {
                codprod.getCotacaoprodutoCollection().remove(cotacaoproduto);
                codprod = em.merge(codprod);
            }
            Collection<Cotacaofornecedorpreco> cotacaofornecedorprecoCollection = cotacaoproduto.getCotacaofornecedorprecoCollection();
            for (Cotacaofornecedorpreco cotacaofornecedorprecoCollectionCotacaofornecedorpreco : cotacaofornecedorprecoCollection) {
                cotacaofornecedorprecoCollectionCotacaofornecedorpreco.setCodcotacaoproduto(null);
                cotacaofornecedorprecoCollectionCotacaofornecedorpreco = em.merge(cotacaofornecedorprecoCollectionCotacaofornecedorpreco);
            }
            em.remove(cotacaoproduto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cotacaoproduto> findCotacaoprodutoEntities() {
        return findCotacaoprodutoEntities(true, -1, -1);
    }

    public List<Cotacaoproduto> findCotacaoprodutoEntities(int maxResults, int firstResult) {
        return findCotacaoprodutoEntities(false, maxResults, firstResult);
    }

    private List<Cotacaoproduto> findCotacaoprodutoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cotacaoproduto.class));
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

    public Cotacaoproduto findCotacaoproduto(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cotacaoproduto.class, id);
        } finally {
            em.close();
        }
    }

    public int getCotacaoprodutoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cotacaoproduto> rt = cq.from(Cotacaoproduto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

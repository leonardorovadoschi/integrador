/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Cotacao;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Empresa;
import entidade.cplus.Cotacaoproduto;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Cotacaofornecedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class CotacaoJpaController implements Serializable {

    public CotacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cotacao cotacao) throws PreexistingEntityException, Exception {
        if (cotacao.getCotacaoprodutoCollection() == null) {
            cotacao.setCotacaoprodutoCollection(new ArrayList<Cotacaoproduto>());
        }
        if (cotacao.getCotacaofornecedorCollection() == null) {
            cotacao.setCotacaofornecedorCollection(new ArrayList<Cotacaofornecedor>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa codempresa = cotacao.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                cotacao.setCodempresa(codempresa);
            }
            Collection<Cotacaoproduto> attachedCotacaoprodutoCollection = new ArrayList<Cotacaoproduto>();
            for (Cotacaoproduto cotacaoprodutoCollectionCotacaoprodutoToAttach : cotacao.getCotacaoprodutoCollection()) {
                cotacaoprodutoCollectionCotacaoprodutoToAttach = em.getReference(cotacaoprodutoCollectionCotacaoprodutoToAttach.getClass(), cotacaoprodutoCollectionCotacaoprodutoToAttach.getCodcotacaoproduto());
                attachedCotacaoprodutoCollection.add(cotacaoprodutoCollectionCotacaoprodutoToAttach);
            }
            cotacao.setCotacaoprodutoCollection(attachedCotacaoprodutoCollection);
            Collection<Cotacaofornecedor> attachedCotacaofornecedorCollection = new ArrayList<Cotacaofornecedor>();
            for (Cotacaofornecedor cotacaofornecedorCollectionCotacaofornecedorToAttach : cotacao.getCotacaofornecedorCollection()) {
                cotacaofornecedorCollectionCotacaofornecedorToAttach = em.getReference(cotacaofornecedorCollectionCotacaofornecedorToAttach.getClass(), cotacaofornecedorCollectionCotacaofornecedorToAttach.getCodcotacaofornecedor());
                attachedCotacaofornecedorCollection.add(cotacaofornecedorCollectionCotacaofornecedorToAttach);
            }
            cotacao.setCotacaofornecedorCollection(attachedCotacaofornecedorCollection);
            em.persist(cotacao);
            if (codempresa != null) {
                codempresa.getCotacaoCollection().add(cotacao);
                codempresa = em.merge(codempresa);
            }
            for (Cotacaoproduto cotacaoprodutoCollectionCotacaoproduto : cotacao.getCotacaoprodutoCollection()) {
                Cotacao oldCodcotacaoOfCotacaoprodutoCollectionCotacaoproduto = cotacaoprodutoCollectionCotacaoproduto.getCodcotacao();
                cotacaoprodutoCollectionCotacaoproduto.setCodcotacao(cotacao);
                cotacaoprodutoCollectionCotacaoproduto = em.merge(cotacaoprodutoCollectionCotacaoproduto);
                if (oldCodcotacaoOfCotacaoprodutoCollectionCotacaoproduto != null) {
                    oldCodcotacaoOfCotacaoprodutoCollectionCotacaoproduto.getCotacaoprodutoCollection().remove(cotacaoprodutoCollectionCotacaoproduto);
                    oldCodcotacaoOfCotacaoprodutoCollectionCotacaoproduto = em.merge(oldCodcotacaoOfCotacaoprodutoCollectionCotacaoproduto);
                }
            }
            for (Cotacaofornecedor cotacaofornecedorCollectionCotacaofornecedor : cotacao.getCotacaofornecedorCollection()) {
                Cotacao oldCodcotacaoOfCotacaofornecedorCollectionCotacaofornecedor = cotacaofornecedorCollectionCotacaofornecedor.getCodcotacao();
                cotacaofornecedorCollectionCotacaofornecedor.setCodcotacao(cotacao);
                cotacaofornecedorCollectionCotacaofornecedor = em.merge(cotacaofornecedorCollectionCotacaofornecedor);
                if (oldCodcotacaoOfCotacaofornecedorCollectionCotacaofornecedor != null) {
                    oldCodcotacaoOfCotacaofornecedorCollectionCotacaofornecedor.getCotacaofornecedorCollection().remove(cotacaofornecedorCollectionCotacaofornecedor);
                    oldCodcotacaoOfCotacaofornecedorCollectionCotacaofornecedor = em.merge(oldCodcotacaoOfCotacaofornecedorCollectionCotacaofornecedor);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCotacao(cotacao.getCodcotacao()) != null) {
                throw new PreexistingEntityException("Cotacao " + cotacao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cotacao cotacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cotacao persistentCotacao = em.find(Cotacao.class, cotacao.getCodcotacao());
            Empresa codempresaOld = persistentCotacao.getCodempresa();
            Empresa codempresaNew = cotacao.getCodempresa();
            Collection<Cotacaoproduto> cotacaoprodutoCollectionOld = persistentCotacao.getCotacaoprodutoCollection();
            Collection<Cotacaoproduto> cotacaoprodutoCollectionNew = cotacao.getCotacaoprodutoCollection();
            Collection<Cotacaofornecedor> cotacaofornecedorCollectionOld = persistentCotacao.getCotacaofornecedorCollection();
            Collection<Cotacaofornecedor> cotacaofornecedorCollectionNew = cotacao.getCotacaofornecedorCollection();
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                cotacao.setCodempresa(codempresaNew);
            }
            Collection<Cotacaoproduto> attachedCotacaoprodutoCollectionNew = new ArrayList<Cotacaoproduto>();
            for (Cotacaoproduto cotacaoprodutoCollectionNewCotacaoprodutoToAttach : cotacaoprodutoCollectionNew) {
                cotacaoprodutoCollectionNewCotacaoprodutoToAttach = em.getReference(cotacaoprodutoCollectionNewCotacaoprodutoToAttach.getClass(), cotacaoprodutoCollectionNewCotacaoprodutoToAttach.getCodcotacaoproduto());
                attachedCotacaoprodutoCollectionNew.add(cotacaoprodutoCollectionNewCotacaoprodutoToAttach);
            }
            cotacaoprodutoCollectionNew = attachedCotacaoprodutoCollectionNew;
            cotacao.setCotacaoprodutoCollection(cotacaoprodutoCollectionNew);
            Collection<Cotacaofornecedor> attachedCotacaofornecedorCollectionNew = new ArrayList<Cotacaofornecedor>();
            for (Cotacaofornecedor cotacaofornecedorCollectionNewCotacaofornecedorToAttach : cotacaofornecedorCollectionNew) {
                cotacaofornecedorCollectionNewCotacaofornecedorToAttach = em.getReference(cotacaofornecedorCollectionNewCotacaofornecedorToAttach.getClass(), cotacaofornecedorCollectionNewCotacaofornecedorToAttach.getCodcotacaofornecedor());
                attachedCotacaofornecedorCollectionNew.add(cotacaofornecedorCollectionNewCotacaofornecedorToAttach);
            }
            cotacaofornecedorCollectionNew = attachedCotacaofornecedorCollectionNew;
            cotacao.setCotacaofornecedorCollection(cotacaofornecedorCollectionNew);
            cotacao = em.merge(cotacao);
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getCotacaoCollection().remove(cotacao);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getCotacaoCollection().add(cotacao);
                codempresaNew = em.merge(codempresaNew);
            }
            for (Cotacaoproduto cotacaoprodutoCollectionOldCotacaoproduto : cotacaoprodutoCollectionOld) {
                if (!cotacaoprodutoCollectionNew.contains(cotacaoprodutoCollectionOldCotacaoproduto)) {
                    cotacaoprodutoCollectionOldCotacaoproduto.setCodcotacao(null);
                    cotacaoprodutoCollectionOldCotacaoproduto = em.merge(cotacaoprodutoCollectionOldCotacaoproduto);
                }
            }
            for (Cotacaoproduto cotacaoprodutoCollectionNewCotacaoproduto : cotacaoprodutoCollectionNew) {
                if (!cotacaoprodutoCollectionOld.contains(cotacaoprodutoCollectionNewCotacaoproduto)) {
                    Cotacao oldCodcotacaoOfCotacaoprodutoCollectionNewCotacaoproduto = cotacaoprodutoCollectionNewCotacaoproduto.getCodcotacao();
                    cotacaoprodutoCollectionNewCotacaoproduto.setCodcotacao(cotacao);
                    cotacaoprodutoCollectionNewCotacaoproduto = em.merge(cotacaoprodutoCollectionNewCotacaoproduto);
                    if (oldCodcotacaoOfCotacaoprodutoCollectionNewCotacaoproduto != null && !oldCodcotacaoOfCotacaoprodutoCollectionNewCotacaoproduto.equals(cotacao)) {
                        oldCodcotacaoOfCotacaoprodutoCollectionNewCotacaoproduto.getCotacaoprodutoCollection().remove(cotacaoprodutoCollectionNewCotacaoproduto);
                        oldCodcotacaoOfCotacaoprodutoCollectionNewCotacaoproduto = em.merge(oldCodcotacaoOfCotacaoprodutoCollectionNewCotacaoproduto);
                    }
                }
            }
            for (Cotacaofornecedor cotacaofornecedorCollectionOldCotacaofornecedor : cotacaofornecedorCollectionOld) {
                if (!cotacaofornecedorCollectionNew.contains(cotacaofornecedorCollectionOldCotacaofornecedor)) {
                    cotacaofornecedorCollectionOldCotacaofornecedor.setCodcotacao(null);
                    cotacaofornecedorCollectionOldCotacaofornecedor = em.merge(cotacaofornecedorCollectionOldCotacaofornecedor);
                }
            }
            for (Cotacaofornecedor cotacaofornecedorCollectionNewCotacaofornecedor : cotacaofornecedorCollectionNew) {
                if (!cotacaofornecedorCollectionOld.contains(cotacaofornecedorCollectionNewCotacaofornecedor)) {
                    Cotacao oldCodcotacaoOfCotacaofornecedorCollectionNewCotacaofornecedor = cotacaofornecedorCollectionNewCotacaofornecedor.getCodcotacao();
                    cotacaofornecedorCollectionNewCotacaofornecedor.setCodcotacao(cotacao);
                    cotacaofornecedorCollectionNewCotacaofornecedor = em.merge(cotacaofornecedorCollectionNewCotacaofornecedor);
                    if (oldCodcotacaoOfCotacaofornecedorCollectionNewCotacaofornecedor != null && !oldCodcotacaoOfCotacaofornecedorCollectionNewCotacaofornecedor.equals(cotacao)) {
                        oldCodcotacaoOfCotacaofornecedorCollectionNewCotacaofornecedor.getCotacaofornecedorCollection().remove(cotacaofornecedorCollectionNewCotacaofornecedor);
                        oldCodcotacaoOfCotacaofornecedorCollectionNewCotacaofornecedor = em.merge(oldCodcotacaoOfCotacaofornecedorCollectionNewCotacaofornecedor);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cotacao.getCodcotacao();
                if (findCotacao(id) == null) {
                    throw new NonexistentEntityException("The cotacao with id " + id + " no longer exists.");
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
            Cotacao cotacao;
            try {
                cotacao = em.getReference(Cotacao.class, id);
                cotacao.getCodcotacao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cotacao with id " + id + " no longer exists.", enfe);
            }
            Empresa codempresa = cotacao.getCodempresa();
            if (codempresa != null) {
                codempresa.getCotacaoCollection().remove(cotacao);
                codempresa = em.merge(codempresa);
            }
            Collection<Cotacaoproduto> cotacaoprodutoCollection = cotacao.getCotacaoprodutoCollection();
            for (Cotacaoproduto cotacaoprodutoCollectionCotacaoproduto : cotacaoprodutoCollection) {
                cotacaoprodutoCollectionCotacaoproduto.setCodcotacao(null);
                cotacaoprodutoCollectionCotacaoproduto = em.merge(cotacaoprodutoCollectionCotacaoproduto);
            }
            Collection<Cotacaofornecedor> cotacaofornecedorCollection = cotacao.getCotacaofornecedorCollection();
            for (Cotacaofornecedor cotacaofornecedorCollectionCotacaofornecedor : cotacaofornecedorCollection) {
                cotacaofornecedorCollectionCotacaofornecedor.setCodcotacao(null);
                cotacaofornecedorCollectionCotacaofornecedor = em.merge(cotacaofornecedorCollectionCotacaofornecedor);
            }
            em.remove(cotacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cotacao> findCotacaoEntities() {
        return findCotacaoEntities(true, -1, -1);
    }

    public List<Cotacao> findCotacaoEntities(int maxResults, int firstResult) {
        return findCotacaoEntities(false, maxResults, firstResult);
    }

    private List<Cotacao> findCotacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cotacao.class));
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

    public Cotacao findCotacao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cotacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getCotacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cotacao> rt = cq.from(Cotacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

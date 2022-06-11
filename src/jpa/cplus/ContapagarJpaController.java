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
import entidade.cplus.Banco;
import entidade.cplus.Caixa;
import entidade.cplus.Caixas;
import entidade.cplus.Centrocusto;
import entidade.cplus.Cliente;
import entidade.cplus.Contapagar;
import entidade.cplus.Empresa;
import entidade.cplus.Fornecedor;
import entidade.cplus.Moventrada;
import entidade.cplus.Planoconta;
import entidade.cplus.Situacaoadministrativa;
import entidade.cplus.Contapagarpag;
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
public class ContapagarJpaController implements Serializable {

    public ContapagarJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Contapagar contapagar) throws PreexistingEntityException, Exception {
        if (contapagar.getContapagarpagCollection() == null) {
            contapagar.setContapagarpagCollection(new ArrayList<Contapagarpag>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Banco codbanco = contapagar.getCodbanco();
            if (codbanco != null) {
                codbanco = em.getReference(codbanco.getClass(), codbanco.getCodbanco());
                contapagar.setCodbanco(codbanco);
            }
            Caixa codcaixa = contapagar.getCodcaixa();
            if (codcaixa != null) {
                codcaixa = em.getReference(codcaixa.getClass(), codcaixa.getCodcaixa());
                contapagar.setCodcaixa(codcaixa);
            }
            Caixas codcaixas = contapagar.getCodcaixas();
            if (codcaixas != null) {
                codcaixas = em.getReference(codcaixas.getClass(), codcaixas.getCodcaixas());
                contapagar.setCodcaixas(codcaixas);
            }
            Centrocusto codcentrocusto = contapagar.getCodcentrocusto();
            if (codcentrocusto != null) {
                codcentrocusto = em.getReference(codcentrocusto.getClass(), codcentrocusto.getCodcentrocusto());
                contapagar.setCodcentrocusto(codcentrocusto);
            }
            Cliente codclirevenda = contapagar.getCodclirevenda();
            if (codclirevenda != null) {
                codclirevenda = em.getReference(codclirevenda.getClass(), codclirevenda.getCodcli());
                contapagar.setCodclirevenda(codclirevenda);
            }
            Empresa codempresa = contapagar.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                contapagar.setCodempresa(codempresa);
            }
            Fornecedor codforn = contapagar.getCodforn();
            if (codforn != null) {
                codforn = em.getReference(codforn.getClass(), codforn.getCodforn());
                contapagar.setCodforn(codforn);
            }
            Moventrada codmoventr = contapagar.getCodmoventr();
            if (codmoventr != null) {
                codmoventr = em.getReference(codmoventr.getClass(), codmoventr.getCodmoventr());
                contapagar.setCodmoventr(codmoventr);
            }
            Planoconta codpc = contapagar.getCodpc();
            if (codpc != null) {
                codpc = em.getReference(codpc.getClass(), codpc.getCodpc());
                contapagar.setCodpc(codpc);
            }
            Situacaoadministrativa codsituacaoadministrativa = contapagar.getCodsituacaoadministrativa();
            if (codsituacaoadministrativa != null) {
                codsituacaoadministrativa = em.getReference(codsituacaoadministrativa.getClass(), codsituacaoadministrativa.getCodsituacaoadministrativa());
                contapagar.setCodsituacaoadministrativa(codsituacaoadministrativa);
            }
            Collection<Contapagarpag> attachedContapagarpagCollection = new ArrayList<Contapagarpag>();
            for (Contapagarpag contapagarpagCollectionContapagarpagToAttach : contapagar.getContapagarpagCollection()) {
                contapagarpagCollectionContapagarpagToAttach = em.getReference(contapagarpagCollectionContapagarpagToAttach.getClass(), contapagarpagCollectionContapagarpagToAttach.getId());
                attachedContapagarpagCollection.add(contapagarpagCollectionContapagarpagToAttach);
            }
            contapagar.setContapagarpagCollection(attachedContapagarpagCollection);
            em.persist(contapagar);
            if (codbanco != null) {
                codbanco.getContapagarCollection().add(contapagar);
                codbanco = em.merge(codbanco);
            }
            if (codcaixa != null) {
                codcaixa.getContapagarCollection().add(contapagar);
                codcaixa = em.merge(codcaixa);
            }
            if (codcaixas != null) {
                codcaixas.getContapagarCollection().add(contapagar);
                codcaixas = em.merge(codcaixas);
            }
            if (codcentrocusto != null) {
                codcentrocusto.getContapagarCollection().add(contapagar);
                codcentrocusto = em.merge(codcentrocusto);
            }
            if (codclirevenda != null) {
                codclirevenda.getContapagarCollection().add(contapagar);
                codclirevenda = em.merge(codclirevenda);
            }
            if (codempresa != null) {
                codempresa.getContapagarCollection().add(contapagar);
                codempresa = em.merge(codempresa);
            }
            if (codforn != null) {
                codforn.getContapagarCollection().add(contapagar);
                codforn = em.merge(codforn);
            }
            if (codmoventr != null) {
                codmoventr.getContapagarCollection().add(contapagar);
                codmoventr = em.merge(codmoventr);
            }
            if (codpc != null) {
                codpc.getContapagarCollection().add(contapagar);
                codpc = em.merge(codpc);
            }
            if (codsituacaoadministrativa != null) {
                codsituacaoadministrativa.getContapagarCollection().add(contapagar);
                codsituacaoadministrativa = em.merge(codsituacaoadministrativa);
            }
            for (Contapagarpag contapagarpagCollectionContapagarpag : contapagar.getContapagarpagCollection()) {
                Contapagar oldCodcpOfContapagarpagCollectionContapagarpag = contapagarpagCollectionContapagarpag.getCodcp();
                contapagarpagCollectionContapagarpag.setCodcp(contapagar);
                contapagarpagCollectionContapagarpag = em.merge(contapagarpagCollectionContapagarpag);
                if (oldCodcpOfContapagarpagCollectionContapagarpag != null) {
                    oldCodcpOfContapagarpagCollectionContapagarpag.getContapagarpagCollection().remove(contapagarpagCollectionContapagarpag);
                    oldCodcpOfContapagarpagCollectionContapagarpag = em.merge(oldCodcpOfContapagarpagCollectionContapagarpag);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findContapagar(contapagar.getCodcp()) != null) {
                throw new PreexistingEntityException("Contapagar " + contapagar + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Contapagar contapagar) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contapagar persistentContapagar = em.find(Contapagar.class, contapagar.getCodcp());
            Banco codbancoOld = persistentContapagar.getCodbanco();
            Banco codbancoNew = contapagar.getCodbanco();
            Caixa codcaixaOld = persistentContapagar.getCodcaixa();
            Caixa codcaixaNew = contapagar.getCodcaixa();
            Caixas codcaixasOld = persistentContapagar.getCodcaixas();
            Caixas codcaixasNew = contapagar.getCodcaixas();
            Centrocusto codcentrocustoOld = persistentContapagar.getCodcentrocusto();
            Centrocusto codcentrocustoNew = contapagar.getCodcentrocusto();
            Cliente codclirevendaOld = persistentContapagar.getCodclirevenda();
            Cliente codclirevendaNew = contapagar.getCodclirevenda();
            Empresa codempresaOld = persistentContapagar.getCodempresa();
            Empresa codempresaNew = contapagar.getCodempresa();
            Fornecedor codfornOld = persistentContapagar.getCodforn();
            Fornecedor codfornNew = contapagar.getCodforn();
            Moventrada codmoventrOld = persistentContapagar.getCodmoventr();
            Moventrada codmoventrNew = contapagar.getCodmoventr();
            Planoconta codpcOld = persistentContapagar.getCodpc();
            Planoconta codpcNew = contapagar.getCodpc();
            Situacaoadministrativa codsituacaoadministrativaOld = persistentContapagar.getCodsituacaoadministrativa();
            Situacaoadministrativa codsituacaoadministrativaNew = contapagar.getCodsituacaoadministrativa();
            Collection<Contapagarpag> contapagarpagCollectionOld = persistentContapagar.getContapagarpagCollection();
            Collection<Contapagarpag> contapagarpagCollectionNew = contapagar.getContapagarpagCollection();
            if (codbancoNew != null) {
                codbancoNew = em.getReference(codbancoNew.getClass(), codbancoNew.getCodbanco());
                contapagar.setCodbanco(codbancoNew);
            }
            if (codcaixaNew != null) {
                codcaixaNew = em.getReference(codcaixaNew.getClass(), codcaixaNew.getCodcaixa());
                contapagar.setCodcaixa(codcaixaNew);
            }
            if (codcaixasNew != null) {
                codcaixasNew = em.getReference(codcaixasNew.getClass(), codcaixasNew.getCodcaixas());
                contapagar.setCodcaixas(codcaixasNew);
            }
            if (codcentrocustoNew != null) {
                codcentrocustoNew = em.getReference(codcentrocustoNew.getClass(), codcentrocustoNew.getCodcentrocusto());
                contapagar.setCodcentrocusto(codcentrocustoNew);
            }
            if (codclirevendaNew != null) {
                codclirevendaNew = em.getReference(codclirevendaNew.getClass(), codclirevendaNew.getCodcli());
                contapagar.setCodclirevenda(codclirevendaNew);
            }
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                contapagar.setCodempresa(codempresaNew);
            }
            if (codfornNew != null) {
                codfornNew = em.getReference(codfornNew.getClass(), codfornNew.getCodforn());
                contapagar.setCodforn(codfornNew);
            }
            if (codmoventrNew != null) {
                codmoventrNew = em.getReference(codmoventrNew.getClass(), codmoventrNew.getCodmoventr());
                contapagar.setCodmoventr(codmoventrNew);
            }
            if (codpcNew != null) {
                codpcNew = em.getReference(codpcNew.getClass(), codpcNew.getCodpc());
                contapagar.setCodpc(codpcNew);
            }
            if (codsituacaoadministrativaNew != null) {
                codsituacaoadministrativaNew = em.getReference(codsituacaoadministrativaNew.getClass(), codsituacaoadministrativaNew.getCodsituacaoadministrativa());
                contapagar.setCodsituacaoadministrativa(codsituacaoadministrativaNew);
            }
            Collection<Contapagarpag> attachedContapagarpagCollectionNew = new ArrayList<Contapagarpag>();
            for (Contapagarpag contapagarpagCollectionNewContapagarpagToAttach : contapagarpagCollectionNew) {
                contapagarpagCollectionNewContapagarpagToAttach = em.getReference(contapagarpagCollectionNewContapagarpagToAttach.getClass(), contapagarpagCollectionNewContapagarpagToAttach.getId());
                attachedContapagarpagCollectionNew.add(contapagarpagCollectionNewContapagarpagToAttach);
            }
            contapagarpagCollectionNew = attachedContapagarpagCollectionNew;
            contapagar.setContapagarpagCollection(contapagarpagCollectionNew);
            contapagar = em.merge(contapagar);
            if (codbancoOld != null && !codbancoOld.equals(codbancoNew)) {
                codbancoOld.getContapagarCollection().remove(contapagar);
                codbancoOld = em.merge(codbancoOld);
            }
            if (codbancoNew != null && !codbancoNew.equals(codbancoOld)) {
                codbancoNew.getContapagarCollection().add(contapagar);
                codbancoNew = em.merge(codbancoNew);
            }
            if (codcaixaOld != null && !codcaixaOld.equals(codcaixaNew)) {
                codcaixaOld.getContapagarCollection().remove(contapagar);
                codcaixaOld = em.merge(codcaixaOld);
            }
            if (codcaixaNew != null && !codcaixaNew.equals(codcaixaOld)) {
                codcaixaNew.getContapagarCollection().add(contapagar);
                codcaixaNew = em.merge(codcaixaNew);
            }
            if (codcaixasOld != null && !codcaixasOld.equals(codcaixasNew)) {
                codcaixasOld.getContapagarCollection().remove(contapagar);
                codcaixasOld = em.merge(codcaixasOld);
            }
            if (codcaixasNew != null && !codcaixasNew.equals(codcaixasOld)) {
                codcaixasNew.getContapagarCollection().add(contapagar);
                codcaixasNew = em.merge(codcaixasNew);
            }
            if (codcentrocustoOld != null && !codcentrocustoOld.equals(codcentrocustoNew)) {
                codcentrocustoOld.getContapagarCollection().remove(contapagar);
                codcentrocustoOld = em.merge(codcentrocustoOld);
            }
            if (codcentrocustoNew != null && !codcentrocustoNew.equals(codcentrocustoOld)) {
                codcentrocustoNew.getContapagarCollection().add(contapagar);
                codcentrocustoNew = em.merge(codcentrocustoNew);
            }
            if (codclirevendaOld != null && !codclirevendaOld.equals(codclirevendaNew)) {
                codclirevendaOld.getContapagarCollection().remove(contapagar);
                codclirevendaOld = em.merge(codclirevendaOld);
            }
            if (codclirevendaNew != null && !codclirevendaNew.equals(codclirevendaOld)) {
                codclirevendaNew.getContapagarCollection().add(contapagar);
                codclirevendaNew = em.merge(codclirevendaNew);
            }
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getContapagarCollection().remove(contapagar);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getContapagarCollection().add(contapagar);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codfornOld != null && !codfornOld.equals(codfornNew)) {
                codfornOld.getContapagarCollection().remove(contapagar);
                codfornOld = em.merge(codfornOld);
            }
            if (codfornNew != null && !codfornNew.equals(codfornOld)) {
                codfornNew.getContapagarCollection().add(contapagar);
                codfornNew = em.merge(codfornNew);
            }
            if (codmoventrOld != null && !codmoventrOld.equals(codmoventrNew)) {
                codmoventrOld.getContapagarCollection().remove(contapagar);
                codmoventrOld = em.merge(codmoventrOld);
            }
            if (codmoventrNew != null && !codmoventrNew.equals(codmoventrOld)) {
                codmoventrNew.getContapagarCollection().add(contapagar);
                codmoventrNew = em.merge(codmoventrNew);
            }
            if (codpcOld != null && !codpcOld.equals(codpcNew)) {
                codpcOld.getContapagarCollection().remove(contapagar);
                codpcOld = em.merge(codpcOld);
            }
            if (codpcNew != null && !codpcNew.equals(codpcOld)) {
                codpcNew.getContapagarCollection().add(contapagar);
                codpcNew = em.merge(codpcNew);
            }
            if (codsituacaoadministrativaOld != null && !codsituacaoadministrativaOld.equals(codsituacaoadministrativaNew)) {
                codsituacaoadministrativaOld.getContapagarCollection().remove(contapagar);
                codsituacaoadministrativaOld = em.merge(codsituacaoadministrativaOld);
            }
            if (codsituacaoadministrativaNew != null && !codsituacaoadministrativaNew.equals(codsituacaoadministrativaOld)) {
                codsituacaoadministrativaNew.getContapagarCollection().add(contapagar);
                codsituacaoadministrativaNew = em.merge(codsituacaoadministrativaNew);
            }
            for (Contapagarpag contapagarpagCollectionOldContapagarpag : contapagarpagCollectionOld) {
                if (!contapagarpagCollectionNew.contains(contapagarpagCollectionOldContapagarpag)) {
                    contapagarpagCollectionOldContapagarpag.setCodcp(null);
                    contapagarpagCollectionOldContapagarpag = em.merge(contapagarpagCollectionOldContapagarpag);
                }
            }
            for (Contapagarpag contapagarpagCollectionNewContapagarpag : contapagarpagCollectionNew) {
                if (!contapagarpagCollectionOld.contains(contapagarpagCollectionNewContapagarpag)) {
                    Contapagar oldCodcpOfContapagarpagCollectionNewContapagarpag = contapagarpagCollectionNewContapagarpag.getCodcp();
                    contapagarpagCollectionNewContapagarpag.setCodcp(contapagar);
                    contapagarpagCollectionNewContapagarpag = em.merge(contapagarpagCollectionNewContapagarpag);
                    if (oldCodcpOfContapagarpagCollectionNewContapagarpag != null && !oldCodcpOfContapagarpagCollectionNewContapagarpag.equals(contapagar)) {
                        oldCodcpOfContapagarpagCollectionNewContapagarpag.getContapagarpagCollection().remove(contapagarpagCollectionNewContapagarpag);
                        oldCodcpOfContapagarpagCollectionNewContapagarpag = em.merge(oldCodcpOfContapagarpagCollectionNewContapagarpag);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = contapagar.getCodcp();
                if (findContapagar(id) == null) {
                    throw new NonexistentEntityException("The contapagar with id " + id + " no longer exists.");
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
            Contapagar contapagar;
            try {
                contapagar = em.getReference(Contapagar.class, id);
                contapagar.getCodcp();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The contapagar with id " + id + " no longer exists.", enfe);
            }
            Banco codbanco = contapagar.getCodbanco();
            if (codbanco != null) {
                codbanco.getContapagarCollection().remove(contapagar);
                codbanco = em.merge(codbanco);
            }
            Caixa codcaixa = contapagar.getCodcaixa();
            if (codcaixa != null) {
                codcaixa.getContapagarCollection().remove(contapagar);
                codcaixa = em.merge(codcaixa);
            }
            Caixas codcaixas = contapagar.getCodcaixas();
            if (codcaixas != null) {
                codcaixas.getContapagarCollection().remove(contapagar);
                codcaixas = em.merge(codcaixas);
            }
            Centrocusto codcentrocusto = contapagar.getCodcentrocusto();
            if (codcentrocusto != null) {
                codcentrocusto.getContapagarCollection().remove(contapagar);
                codcentrocusto = em.merge(codcentrocusto);
            }
            Cliente codclirevenda = contapagar.getCodclirevenda();
            if (codclirevenda != null) {
                codclirevenda.getContapagarCollection().remove(contapagar);
                codclirevenda = em.merge(codclirevenda);
            }
            Empresa codempresa = contapagar.getCodempresa();
            if (codempresa != null) {
                codempresa.getContapagarCollection().remove(contapagar);
                codempresa = em.merge(codempresa);
            }
            Fornecedor codforn = contapagar.getCodforn();
            if (codforn != null) {
                codforn.getContapagarCollection().remove(contapagar);
                codforn = em.merge(codforn);
            }
            Moventrada codmoventr = contapagar.getCodmoventr();
            if (codmoventr != null) {
                codmoventr.getContapagarCollection().remove(contapagar);
                codmoventr = em.merge(codmoventr);
            }
            Planoconta codpc = contapagar.getCodpc();
            if (codpc != null) {
                codpc.getContapagarCollection().remove(contapagar);
                codpc = em.merge(codpc);
            }
            Situacaoadministrativa codsituacaoadministrativa = contapagar.getCodsituacaoadministrativa();
            if (codsituacaoadministrativa != null) {
                codsituacaoadministrativa.getContapagarCollection().remove(contapagar);
                codsituacaoadministrativa = em.merge(codsituacaoadministrativa);
            }
            Collection<Contapagarpag> contapagarpagCollection = contapagar.getContapagarpagCollection();
            for (Contapagarpag contapagarpagCollectionContapagarpag : contapagarpagCollection) {
                contapagarpagCollectionContapagarpag.setCodcp(null);
                contapagarpagCollectionContapagarpag = em.merge(contapagarpagCollectionContapagarpag);
            }
            em.remove(contapagar);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Contapagar> findContapagarEntities() {
        return findContapagarEntities(true, -1, -1);
    }

    public List<Contapagar> findContapagarEntities(int maxResults, int firstResult) {
        return findContapagarEntities(false, maxResults, firstResult);
    }

    private List<Contapagar> findContapagarEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Contapagar.class));
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

    public Contapagar findContapagar(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Contapagar.class, id);
        } finally {
            em.close();
        }
    }

    public int getContapagarCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Contapagar> rt = cq.from(Contapagar.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

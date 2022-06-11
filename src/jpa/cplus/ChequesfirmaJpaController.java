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
import entidade.cplus.Caixa;
import entidade.cplus.Caixas;
import entidade.cplus.Centrocusto;
import entidade.cplus.Chequesfirma;
import entidade.cplus.Contabancaria;
import entidade.cplus.Empresa;
import entidade.cplus.Fornecedor;
import entidade.cplus.Planoconta;
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
public class ChequesfirmaJpaController implements Serializable {

    public ChequesfirmaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Chequesfirma chequesfirma) throws PreexistingEntityException, Exception {
        if (chequesfirma.getContapagarpagCollection() == null) {
            chequesfirma.setContapagarpagCollection(new ArrayList<Contapagarpag>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Caixa codcaixa = chequesfirma.getCodcaixa();
            if (codcaixa != null) {
                codcaixa = em.getReference(codcaixa.getClass(), codcaixa.getCodcaixa());
                chequesfirma.setCodcaixa(codcaixa);
            }
            Caixas codcaixas = chequesfirma.getCodcaixas();
            if (codcaixas != null) {
                codcaixas = em.getReference(codcaixas.getClass(), codcaixas.getCodcaixas());
                chequesfirma.setCodcaixas(codcaixas);
            }
            Centrocusto codcentrocusto = chequesfirma.getCodcentrocusto();
            if (codcentrocusto != null) {
                codcentrocusto = em.getReference(codcentrocusto.getClass(), codcentrocusto.getCodcentrocusto());
                chequesfirma.setCodcentrocusto(codcentrocusto);
            }
            Contabancaria codcontabancaria = chequesfirma.getCodcontabancaria();
            if (codcontabancaria != null) {
                codcontabancaria = em.getReference(codcontabancaria.getClass(), codcontabancaria.getCodcontabancaria());
                chequesfirma.setCodcontabancaria(codcontabancaria);
            }
            Empresa codempresa = chequesfirma.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                chequesfirma.setCodempresa(codempresa);
            }
            Fornecedor codforn = chequesfirma.getCodforn();
            if (codforn != null) {
                codforn = em.getReference(codforn.getClass(), codforn.getCodforn());
                chequesfirma.setCodforn(codforn);
            }
            Planoconta codpc = chequesfirma.getCodpc();
            if (codpc != null) {
                codpc = em.getReference(codpc.getClass(), codpc.getCodpc());
                chequesfirma.setCodpc(codpc);
            }
            Collection<Contapagarpag> attachedContapagarpagCollection = new ArrayList<Contapagarpag>();
            for (Contapagarpag contapagarpagCollectionContapagarpagToAttach : chequesfirma.getContapagarpagCollection()) {
                contapagarpagCollectionContapagarpagToAttach = em.getReference(contapagarpagCollectionContapagarpagToAttach.getClass(), contapagarpagCollectionContapagarpagToAttach.getId());
                attachedContapagarpagCollection.add(contapagarpagCollectionContapagarpagToAttach);
            }
            chequesfirma.setContapagarpagCollection(attachedContapagarpagCollection);
            em.persist(chequesfirma);
            if (codcaixa != null) {
                codcaixa.getChequesfirmaCollection().add(chequesfirma);
                codcaixa = em.merge(codcaixa);
            }
            if (codcaixas != null) {
                codcaixas.getChequesfirmaCollection().add(chequesfirma);
                codcaixas = em.merge(codcaixas);
            }
            if (codcentrocusto != null) {
                codcentrocusto.getChequesfirmaCollection().add(chequesfirma);
                codcentrocusto = em.merge(codcentrocusto);
            }
            if (codcontabancaria != null) {
                codcontabancaria.getChequesfirmaCollection().add(chequesfirma);
                codcontabancaria = em.merge(codcontabancaria);
            }
            if (codempresa != null) {
                codempresa.getChequesfirmaCollection().add(chequesfirma);
                codempresa = em.merge(codempresa);
            }
            if (codforn != null) {
                codforn.getChequesfirmaCollection().add(chequesfirma);
                codforn = em.merge(codforn);
            }
            if (codpc != null) {
                codpc.getChequesfirmaCollection().add(chequesfirma);
                codpc = em.merge(codpc);
            }
            for (Contapagarpag contapagarpagCollectionContapagarpag : chequesfirma.getContapagarpagCollection()) {
                Chequesfirma oldCodchequefirmaOfContapagarpagCollectionContapagarpag = contapagarpagCollectionContapagarpag.getCodchequefirma();
                contapagarpagCollectionContapagarpag.setCodchequefirma(chequesfirma);
                contapagarpagCollectionContapagarpag = em.merge(contapagarpagCollectionContapagarpag);
                if (oldCodchequefirmaOfContapagarpagCollectionContapagarpag != null) {
                    oldCodchequefirmaOfContapagarpagCollectionContapagarpag.getContapagarpagCollection().remove(contapagarpagCollectionContapagarpag);
                    oldCodchequefirmaOfContapagarpagCollectionContapagarpag = em.merge(oldCodchequefirmaOfContapagarpagCollectionContapagarpag);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findChequesfirma(chequesfirma.getCodchequefirma()) != null) {
                throw new PreexistingEntityException("Chequesfirma " + chequesfirma + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Chequesfirma chequesfirma) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Chequesfirma persistentChequesfirma = em.find(Chequesfirma.class, chequesfirma.getCodchequefirma());
            Caixa codcaixaOld = persistentChequesfirma.getCodcaixa();
            Caixa codcaixaNew = chequesfirma.getCodcaixa();
            Caixas codcaixasOld = persistentChequesfirma.getCodcaixas();
            Caixas codcaixasNew = chequesfirma.getCodcaixas();
            Centrocusto codcentrocustoOld = persistentChequesfirma.getCodcentrocusto();
            Centrocusto codcentrocustoNew = chequesfirma.getCodcentrocusto();
            Contabancaria codcontabancariaOld = persistentChequesfirma.getCodcontabancaria();
            Contabancaria codcontabancariaNew = chequesfirma.getCodcontabancaria();
            Empresa codempresaOld = persistentChequesfirma.getCodempresa();
            Empresa codempresaNew = chequesfirma.getCodempresa();
            Fornecedor codfornOld = persistentChequesfirma.getCodforn();
            Fornecedor codfornNew = chequesfirma.getCodforn();
            Planoconta codpcOld = persistentChequesfirma.getCodpc();
            Planoconta codpcNew = chequesfirma.getCodpc();
            Collection<Contapagarpag> contapagarpagCollectionOld = persistentChequesfirma.getContapagarpagCollection();
            Collection<Contapagarpag> contapagarpagCollectionNew = chequesfirma.getContapagarpagCollection();
            if (codcaixaNew != null) {
                codcaixaNew = em.getReference(codcaixaNew.getClass(), codcaixaNew.getCodcaixa());
                chequesfirma.setCodcaixa(codcaixaNew);
            }
            if (codcaixasNew != null) {
                codcaixasNew = em.getReference(codcaixasNew.getClass(), codcaixasNew.getCodcaixas());
                chequesfirma.setCodcaixas(codcaixasNew);
            }
            if (codcentrocustoNew != null) {
                codcentrocustoNew = em.getReference(codcentrocustoNew.getClass(), codcentrocustoNew.getCodcentrocusto());
                chequesfirma.setCodcentrocusto(codcentrocustoNew);
            }
            if (codcontabancariaNew != null) {
                codcontabancariaNew = em.getReference(codcontabancariaNew.getClass(), codcontabancariaNew.getCodcontabancaria());
                chequesfirma.setCodcontabancaria(codcontabancariaNew);
            }
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                chequesfirma.setCodempresa(codempresaNew);
            }
            if (codfornNew != null) {
                codfornNew = em.getReference(codfornNew.getClass(), codfornNew.getCodforn());
                chequesfirma.setCodforn(codfornNew);
            }
            if (codpcNew != null) {
                codpcNew = em.getReference(codpcNew.getClass(), codpcNew.getCodpc());
                chequesfirma.setCodpc(codpcNew);
            }
            Collection<Contapagarpag> attachedContapagarpagCollectionNew = new ArrayList<Contapagarpag>();
            for (Contapagarpag contapagarpagCollectionNewContapagarpagToAttach : contapagarpagCollectionNew) {
                contapagarpagCollectionNewContapagarpagToAttach = em.getReference(contapagarpagCollectionNewContapagarpagToAttach.getClass(), contapagarpagCollectionNewContapagarpagToAttach.getId());
                attachedContapagarpagCollectionNew.add(contapagarpagCollectionNewContapagarpagToAttach);
            }
            contapagarpagCollectionNew = attachedContapagarpagCollectionNew;
            chequesfirma.setContapagarpagCollection(contapagarpagCollectionNew);
            chequesfirma = em.merge(chequesfirma);
            if (codcaixaOld != null && !codcaixaOld.equals(codcaixaNew)) {
                codcaixaOld.getChequesfirmaCollection().remove(chequesfirma);
                codcaixaOld = em.merge(codcaixaOld);
            }
            if (codcaixaNew != null && !codcaixaNew.equals(codcaixaOld)) {
                codcaixaNew.getChequesfirmaCollection().add(chequesfirma);
                codcaixaNew = em.merge(codcaixaNew);
            }
            if (codcaixasOld != null && !codcaixasOld.equals(codcaixasNew)) {
                codcaixasOld.getChequesfirmaCollection().remove(chequesfirma);
                codcaixasOld = em.merge(codcaixasOld);
            }
            if (codcaixasNew != null && !codcaixasNew.equals(codcaixasOld)) {
                codcaixasNew.getChequesfirmaCollection().add(chequesfirma);
                codcaixasNew = em.merge(codcaixasNew);
            }
            if (codcentrocustoOld != null && !codcentrocustoOld.equals(codcentrocustoNew)) {
                codcentrocustoOld.getChequesfirmaCollection().remove(chequesfirma);
                codcentrocustoOld = em.merge(codcentrocustoOld);
            }
            if (codcentrocustoNew != null && !codcentrocustoNew.equals(codcentrocustoOld)) {
                codcentrocustoNew.getChequesfirmaCollection().add(chequesfirma);
                codcentrocustoNew = em.merge(codcentrocustoNew);
            }
            if (codcontabancariaOld != null && !codcontabancariaOld.equals(codcontabancariaNew)) {
                codcontabancariaOld.getChequesfirmaCollection().remove(chequesfirma);
                codcontabancariaOld = em.merge(codcontabancariaOld);
            }
            if (codcontabancariaNew != null && !codcontabancariaNew.equals(codcontabancariaOld)) {
                codcontabancariaNew.getChequesfirmaCollection().add(chequesfirma);
                codcontabancariaNew = em.merge(codcontabancariaNew);
            }
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getChequesfirmaCollection().remove(chequesfirma);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getChequesfirmaCollection().add(chequesfirma);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codfornOld != null && !codfornOld.equals(codfornNew)) {
                codfornOld.getChequesfirmaCollection().remove(chequesfirma);
                codfornOld = em.merge(codfornOld);
            }
            if (codfornNew != null && !codfornNew.equals(codfornOld)) {
                codfornNew.getChequesfirmaCollection().add(chequesfirma);
                codfornNew = em.merge(codfornNew);
            }
            if (codpcOld != null && !codpcOld.equals(codpcNew)) {
                codpcOld.getChequesfirmaCollection().remove(chequesfirma);
                codpcOld = em.merge(codpcOld);
            }
            if (codpcNew != null && !codpcNew.equals(codpcOld)) {
                codpcNew.getChequesfirmaCollection().add(chequesfirma);
                codpcNew = em.merge(codpcNew);
            }
            for (Contapagarpag contapagarpagCollectionOldContapagarpag : contapagarpagCollectionOld) {
                if (!contapagarpagCollectionNew.contains(contapagarpagCollectionOldContapagarpag)) {
                    contapagarpagCollectionOldContapagarpag.setCodchequefirma(null);
                    contapagarpagCollectionOldContapagarpag = em.merge(contapagarpagCollectionOldContapagarpag);
                }
            }
            for (Contapagarpag contapagarpagCollectionNewContapagarpag : contapagarpagCollectionNew) {
                if (!contapagarpagCollectionOld.contains(contapagarpagCollectionNewContapagarpag)) {
                    Chequesfirma oldCodchequefirmaOfContapagarpagCollectionNewContapagarpag = contapagarpagCollectionNewContapagarpag.getCodchequefirma();
                    contapagarpagCollectionNewContapagarpag.setCodchequefirma(chequesfirma);
                    contapagarpagCollectionNewContapagarpag = em.merge(contapagarpagCollectionNewContapagarpag);
                    if (oldCodchequefirmaOfContapagarpagCollectionNewContapagarpag != null && !oldCodchequefirmaOfContapagarpagCollectionNewContapagarpag.equals(chequesfirma)) {
                        oldCodchequefirmaOfContapagarpagCollectionNewContapagarpag.getContapagarpagCollection().remove(contapagarpagCollectionNewContapagarpag);
                        oldCodchequefirmaOfContapagarpagCollectionNewContapagarpag = em.merge(oldCodchequefirmaOfContapagarpagCollectionNewContapagarpag);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = chequesfirma.getCodchequefirma();
                if (findChequesfirma(id) == null) {
                    throw new NonexistentEntityException("The chequesfirma with id " + id + " no longer exists.");
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
            Chequesfirma chequesfirma;
            try {
                chequesfirma = em.getReference(Chequesfirma.class, id);
                chequesfirma.getCodchequefirma();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The chequesfirma with id " + id + " no longer exists.", enfe);
            }
            Caixa codcaixa = chequesfirma.getCodcaixa();
            if (codcaixa != null) {
                codcaixa.getChequesfirmaCollection().remove(chequesfirma);
                codcaixa = em.merge(codcaixa);
            }
            Caixas codcaixas = chequesfirma.getCodcaixas();
            if (codcaixas != null) {
                codcaixas.getChequesfirmaCollection().remove(chequesfirma);
                codcaixas = em.merge(codcaixas);
            }
            Centrocusto codcentrocusto = chequesfirma.getCodcentrocusto();
            if (codcentrocusto != null) {
                codcentrocusto.getChequesfirmaCollection().remove(chequesfirma);
                codcentrocusto = em.merge(codcentrocusto);
            }
            Contabancaria codcontabancaria = chequesfirma.getCodcontabancaria();
            if (codcontabancaria != null) {
                codcontabancaria.getChequesfirmaCollection().remove(chequesfirma);
                codcontabancaria = em.merge(codcontabancaria);
            }
            Empresa codempresa = chequesfirma.getCodempresa();
            if (codempresa != null) {
                codempresa.getChequesfirmaCollection().remove(chequesfirma);
                codempresa = em.merge(codempresa);
            }
            Fornecedor codforn = chequesfirma.getCodforn();
            if (codforn != null) {
                codforn.getChequesfirmaCollection().remove(chequesfirma);
                codforn = em.merge(codforn);
            }
            Planoconta codpc = chequesfirma.getCodpc();
            if (codpc != null) {
                codpc.getChequesfirmaCollection().remove(chequesfirma);
                codpc = em.merge(codpc);
            }
            Collection<Contapagarpag> contapagarpagCollection = chequesfirma.getContapagarpagCollection();
            for (Contapagarpag contapagarpagCollectionContapagarpag : contapagarpagCollection) {
                contapagarpagCollectionContapagarpag.setCodchequefirma(null);
                contapagarpagCollectionContapagarpag = em.merge(contapagarpagCollectionContapagarpag);
            }
            em.remove(chequesfirma);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Chequesfirma> findChequesfirmaEntities() {
        return findChequesfirmaEntities(true, -1, -1);
    }

    public List<Chequesfirma> findChequesfirmaEntities(int maxResults, int firstResult) {
        return findChequesfirmaEntities(false, maxResults, firstResult);
    }

    private List<Chequesfirma> findChequesfirmaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Chequesfirma.class));
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

    public Chequesfirma findChequesfirma(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Chequesfirma.class, id);
        } finally {
            em.close();
        }
    }

    public int getChequesfirmaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Chequesfirma> rt = cq.from(Chequesfirma.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

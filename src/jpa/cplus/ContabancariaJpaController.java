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
import entidade.cplus.Caixas;
import entidade.cplus.Calculodv;
import entidade.cplus.Empresa;
import entidade.cplus.Planoconta;
import entidade.cplus.Chequesfirma;
import entidade.cplus.Contabancaria;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Contapagarpag;
import entidade.cplus.Contareceberfixa;
import entidade.cplus.Recebimento;
import entidade.cplus.Contareceber;
import entidade.cplus.Contratocobranca;
import entidade.cplus.Orcamento;
import entidade.cplus.Historicocarteira;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.IllegalOrphanException;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ContabancariaJpaController implements Serializable {

    public ContabancariaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Contabancaria contabancaria) throws PreexistingEntityException, Exception {
        if (contabancaria.getChequesfirmaCollection() == null) {
            contabancaria.setChequesfirmaCollection(new ArrayList<Chequesfirma>());
        }
        if (contabancaria.getContapagarpagCollection() == null) {
            contabancaria.setContapagarpagCollection(new ArrayList<Contapagarpag>());
        }
        if (contabancaria.getContareceberfixaCollection() == null) {
            contabancaria.setContareceberfixaCollection(new ArrayList<Contareceberfixa>());
        }
        if (contabancaria.getRecebimentoCollection() == null) {
            contabancaria.setRecebimentoCollection(new ArrayList<Recebimento>());
        }
        if (contabancaria.getContareceberCollection() == null) {
            contabancaria.setContareceberCollection(new ArrayList<Contareceber>());
        }
        if (contabancaria.getContratocobrancaCollection() == null) {
            contabancaria.setContratocobrancaCollection(new ArrayList<Contratocobranca>());
        }
        if (contabancaria.getOrcamentoCollection() == null) {
            contabancaria.setOrcamentoCollection(new ArrayList<Orcamento>());
        }
        if (contabancaria.getHistoricocarteiraCollection() == null) {
            contabancaria.setHistoricocarteiraCollection(new ArrayList<Historicocarteira>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Banco codbanco = contabancaria.getCodbanco();
            if (codbanco != null) {
                codbanco = em.getReference(codbanco.getClass(), codbanco.getCodbanco());
                contabancaria.setCodbanco(codbanco);
            }
            Caixas codcaixas = contabancaria.getCodcaixas();
            if (codcaixas != null) {
                codcaixas = em.getReference(codcaixas.getClass(), codcaixas.getCodcaixas());
                contabancaria.setCodcaixas(codcaixas);
            }
            Calculodv codcalculodv = contabancaria.getCodcalculodv();
            if (codcalculodv != null) {
                codcalculodv = em.getReference(codcalculodv.getClass(), codcalculodv.getCodcalculodv());
                contabancaria.setCodcalculodv(codcalculodv);
            }
            Empresa codempresa = contabancaria.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                contabancaria.setCodempresa(codempresa);
            }
            Planoconta codpc = contabancaria.getCodpc();
            if (codpc != null) {
                codpc = em.getReference(codpc.getClass(), codpc.getCodpc());
                contabancaria.setCodpc(codpc);
            }
            Collection<Chequesfirma> attachedChequesfirmaCollection = new ArrayList<Chequesfirma>();
            for (Chequesfirma chequesfirmaCollectionChequesfirmaToAttach : contabancaria.getChequesfirmaCollection()) {
                chequesfirmaCollectionChequesfirmaToAttach = em.getReference(chequesfirmaCollectionChequesfirmaToAttach.getClass(), chequesfirmaCollectionChequesfirmaToAttach.getCodchequefirma());
                attachedChequesfirmaCollection.add(chequesfirmaCollectionChequesfirmaToAttach);
            }
            contabancaria.setChequesfirmaCollection(attachedChequesfirmaCollection);
            Collection<Contapagarpag> attachedContapagarpagCollection = new ArrayList<Contapagarpag>();
            for (Contapagarpag contapagarpagCollectionContapagarpagToAttach : contabancaria.getContapagarpagCollection()) {
                contapagarpagCollectionContapagarpagToAttach = em.getReference(contapagarpagCollectionContapagarpagToAttach.getClass(), contapagarpagCollectionContapagarpagToAttach.getId());
                attachedContapagarpagCollection.add(contapagarpagCollectionContapagarpagToAttach);
            }
            contabancaria.setContapagarpagCollection(attachedContapagarpagCollection);
            Collection<Contareceberfixa> attachedContareceberfixaCollection = new ArrayList<Contareceberfixa>();
            for (Contareceberfixa contareceberfixaCollectionContareceberfixaToAttach : contabancaria.getContareceberfixaCollection()) {
                contareceberfixaCollectionContareceberfixaToAttach = em.getReference(contareceberfixaCollectionContareceberfixaToAttach.getClass(), contareceberfixaCollectionContareceberfixaToAttach.getCodcrfixa());
                attachedContareceberfixaCollection.add(contareceberfixaCollectionContareceberfixaToAttach);
            }
            contabancaria.setContareceberfixaCollection(attachedContareceberfixaCollection);
            Collection<Recebimento> attachedRecebimentoCollection = new ArrayList<Recebimento>();
            for (Recebimento recebimentoCollectionRecebimentoToAttach : contabancaria.getRecebimentoCollection()) {
                recebimentoCollectionRecebimentoToAttach = em.getReference(recebimentoCollectionRecebimentoToAttach.getClass(), recebimentoCollectionRecebimentoToAttach.getCodrec());
                attachedRecebimentoCollection.add(recebimentoCollectionRecebimentoToAttach);
            }
            contabancaria.setRecebimentoCollection(attachedRecebimentoCollection);
            Collection<Contareceber> attachedContareceberCollection = new ArrayList<Contareceber>();
            for (Contareceber contareceberCollectionContareceberToAttach : contabancaria.getContareceberCollection()) {
                contareceberCollectionContareceberToAttach = em.getReference(contareceberCollectionContareceberToAttach.getClass(), contareceberCollectionContareceberToAttach.getCodcr());
                attachedContareceberCollection.add(contareceberCollectionContareceberToAttach);
            }
            contabancaria.setContareceberCollection(attachedContareceberCollection);
            Collection<Contratocobranca> attachedContratocobrancaCollection = new ArrayList<Contratocobranca>();
            for (Contratocobranca contratocobrancaCollectionContratocobrancaToAttach : contabancaria.getContratocobrancaCollection()) {
                contratocobrancaCollectionContratocobrancaToAttach = em.getReference(contratocobrancaCollectionContratocobrancaToAttach.getClass(), contratocobrancaCollectionContratocobrancaToAttach.getCodcontratocobranca());
                attachedContratocobrancaCollection.add(contratocobrancaCollectionContratocobrancaToAttach);
            }
            contabancaria.setContratocobrancaCollection(attachedContratocobrancaCollection);
            Collection<Orcamento> attachedOrcamentoCollection = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollectionOrcamentoToAttach : contabancaria.getOrcamentoCollection()) {
                orcamentoCollectionOrcamentoToAttach = em.getReference(orcamentoCollectionOrcamentoToAttach.getClass(), orcamentoCollectionOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollection.add(orcamentoCollectionOrcamentoToAttach);
            }
            contabancaria.setOrcamentoCollection(attachedOrcamentoCollection);
            Collection<Historicocarteira> attachedHistoricocarteiraCollection = new ArrayList<Historicocarteira>();
            for (Historicocarteira historicocarteiraCollectionHistoricocarteiraToAttach : contabancaria.getHistoricocarteiraCollection()) {
                historicocarteiraCollectionHistoricocarteiraToAttach = em.getReference(historicocarteiraCollectionHistoricocarteiraToAttach.getClass(), historicocarteiraCollectionHistoricocarteiraToAttach.getCodhistoricocarteira());
                attachedHistoricocarteiraCollection.add(historicocarteiraCollectionHistoricocarteiraToAttach);
            }
            contabancaria.setHistoricocarteiraCollection(attachedHistoricocarteiraCollection);
            em.persist(contabancaria);
            if (codbanco != null) {
                codbanco.getContabancariaCollection().add(contabancaria);
                codbanco = em.merge(codbanco);
            }
            if (codcaixas != null) {
                codcaixas.getContabancariaCollection().add(contabancaria);
                codcaixas = em.merge(codcaixas);
            }
            if (codcalculodv != null) {
                codcalculodv.getContabancariaCollection().add(contabancaria);
                codcalculodv = em.merge(codcalculodv);
            }
            if (codempresa != null) {
                codempresa.getContabancariaCollection().add(contabancaria);
                codempresa = em.merge(codempresa);
            }
            if (codpc != null) {
                codpc.getContabancariaCollection().add(contabancaria);
                codpc = em.merge(codpc);
            }
            for (Chequesfirma chequesfirmaCollectionChequesfirma : contabancaria.getChequesfirmaCollection()) {
                Contabancaria oldCodcontabancariaOfChequesfirmaCollectionChequesfirma = chequesfirmaCollectionChequesfirma.getCodcontabancaria();
                chequesfirmaCollectionChequesfirma.setCodcontabancaria(contabancaria);
                chequesfirmaCollectionChequesfirma = em.merge(chequesfirmaCollectionChequesfirma);
                if (oldCodcontabancariaOfChequesfirmaCollectionChequesfirma != null) {
                    oldCodcontabancariaOfChequesfirmaCollectionChequesfirma.getChequesfirmaCollection().remove(chequesfirmaCollectionChequesfirma);
                    oldCodcontabancariaOfChequesfirmaCollectionChequesfirma = em.merge(oldCodcontabancariaOfChequesfirmaCollectionChequesfirma);
                }
            }
            for (Contapagarpag contapagarpagCollectionContapagarpag : contabancaria.getContapagarpagCollection()) {
                Contabancaria oldCodcontabancariaOfContapagarpagCollectionContapagarpag = contapagarpagCollectionContapagarpag.getCodcontabancaria();
                contapagarpagCollectionContapagarpag.setCodcontabancaria(contabancaria);
                contapagarpagCollectionContapagarpag = em.merge(contapagarpagCollectionContapagarpag);
                if (oldCodcontabancariaOfContapagarpagCollectionContapagarpag != null) {
                    oldCodcontabancariaOfContapagarpagCollectionContapagarpag.getContapagarpagCollection().remove(contapagarpagCollectionContapagarpag);
                    oldCodcontabancariaOfContapagarpagCollectionContapagarpag = em.merge(oldCodcontabancariaOfContapagarpagCollectionContapagarpag);
                }
            }
            for (Contareceberfixa contareceberfixaCollectionContareceberfixa : contabancaria.getContareceberfixaCollection()) {
                Contabancaria oldCodcontabancariaOfContareceberfixaCollectionContareceberfixa = contareceberfixaCollectionContareceberfixa.getCodcontabancaria();
                contareceberfixaCollectionContareceberfixa.setCodcontabancaria(contabancaria);
                contareceberfixaCollectionContareceberfixa = em.merge(contareceberfixaCollectionContareceberfixa);
                if (oldCodcontabancariaOfContareceberfixaCollectionContareceberfixa != null) {
                    oldCodcontabancariaOfContareceberfixaCollectionContareceberfixa.getContareceberfixaCollection().remove(contareceberfixaCollectionContareceberfixa);
                    oldCodcontabancariaOfContareceberfixaCollectionContareceberfixa = em.merge(oldCodcontabancariaOfContareceberfixaCollectionContareceberfixa);
                }
            }
            for (Recebimento recebimentoCollectionRecebimento : contabancaria.getRecebimentoCollection()) {
                Contabancaria oldCodcontabancariaOfRecebimentoCollectionRecebimento = recebimentoCollectionRecebimento.getCodcontabancaria();
                recebimentoCollectionRecebimento.setCodcontabancaria(contabancaria);
                recebimentoCollectionRecebimento = em.merge(recebimentoCollectionRecebimento);
                if (oldCodcontabancariaOfRecebimentoCollectionRecebimento != null) {
                    oldCodcontabancariaOfRecebimentoCollectionRecebimento.getRecebimentoCollection().remove(recebimentoCollectionRecebimento);
                    oldCodcontabancariaOfRecebimentoCollectionRecebimento = em.merge(oldCodcontabancariaOfRecebimentoCollectionRecebimento);
                }
            }
            for (Contareceber contareceberCollectionContareceber : contabancaria.getContareceberCollection()) {
                Contabancaria oldCodcontabancariaOfContareceberCollectionContareceber = contareceberCollectionContareceber.getCodcontabancaria();
                contareceberCollectionContareceber.setCodcontabancaria(contabancaria);
                contareceberCollectionContareceber = em.merge(contareceberCollectionContareceber);
                if (oldCodcontabancariaOfContareceberCollectionContareceber != null) {
                    oldCodcontabancariaOfContareceberCollectionContareceber.getContareceberCollection().remove(contareceberCollectionContareceber);
                    oldCodcontabancariaOfContareceberCollectionContareceber = em.merge(oldCodcontabancariaOfContareceberCollectionContareceber);
                }
            }
            for (Contratocobranca contratocobrancaCollectionContratocobranca : contabancaria.getContratocobrancaCollection()) {
                Contabancaria oldCodcontabancariaOfContratocobrancaCollectionContratocobranca = contratocobrancaCollectionContratocobranca.getCodcontabancaria();
                contratocobrancaCollectionContratocobranca.setCodcontabancaria(contabancaria);
                contratocobrancaCollectionContratocobranca = em.merge(contratocobrancaCollectionContratocobranca);
                if (oldCodcontabancariaOfContratocobrancaCollectionContratocobranca != null) {
                    oldCodcontabancariaOfContratocobrancaCollectionContratocobranca.getContratocobrancaCollection().remove(contratocobrancaCollectionContratocobranca);
                    oldCodcontabancariaOfContratocobrancaCollectionContratocobranca = em.merge(oldCodcontabancariaOfContratocobrancaCollectionContratocobranca);
                }
            }
            for (Orcamento orcamentoCollectionOrcamento : contabancaria.getOrcamentoCollection()) {
                Contabancaria oldCodcontabancariaOfOrcamentoCollectionOrcamento = orcamentoCollectionOrcamento.getCodcontabancaria();
                orcamentoCollectionOrcamento.setCodcontabancaria(contabancaria);
                orcamentoCollectionOrcamento = em.merge(orcamentoCollectionOrcamento);
                if (oldCodcontabancariaOfOrcamentoCollectionOrcamento != null) {
                    oldCodcontabancariaOfOrcamentoCollectionOrcamento.getOrcamentoCollection().remove(orcamentoCollectionOrcamento);
                    oldCodcontabancariaOfOrcamentoCollectionOrcamento = em.merge(oldCodcontabancariaOfOrcamentoCollectionOrcamento);
                }
            }
            for (Historicocarteira historicocarteiraCollectionHistoricocarteira : contabancaria.getHistoricocarteiraCollection()) {
                Contabancaria oldCodcontabancariaOfHistoricocarteiraCollectionHistoricocarteira = historicocarteiraCollectionHistoricocarteira.getCodcontabancaria();
                historicocarteiraCollectionHistoricocarteira.setCodcontabancaria(contabancaria);
                historicocarteiraCollectionHistoricocarteira = em.merge(historicocarteiraCollectionHistoricocarteira);
                if (oldCodcontabancariaOfHistoricocarteiraCollectionHistoricocarteira != null) {
                    oldCodcontabancariaOfHistoricocarteiraCollectionHistoricocarteira.getHistoricocarteiraCollection().remove(historicocarteiraCollectionHistoricocarteira);
                    oldCodcontabancariaOfHistoricocarteiraCollectionHistoricocarteira = em.merge(oldCodcontabancariaOfHistoricocarteiraCollectionHistoricocarteira);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findContabancaria(contabancaria.getCodcontabancaria()) != null) {
                throw new PreexistingEntityException("Contabancaria " + contabancaria + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Contabancaria contabancaria) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contabancaria persistentContabancaria = em.find(Contabancaria.class, contabancaria.getCodcontabancaria());
            Banco codbancoOld = persistentContabancaria.getCodbanco();
            Banco codbancoNew = contabancaria.getCodbanco();
            Caixas codcaixasOld = persistentContabancaria.getCodcaixas();
            Caixas codcaixasNew = contabancaria.getCodcaixas();
            Calculodv codcalculodvOld = persistentContabancaria.getCodcalculodv();
            Calculodv codcalculodvNew = contabancaria.getCodcalculodv();
            Empresa codempresaOld = persistentContabancaria.getCodempresa();
            Empresa codempresaNew = contabancaria.getCodempresa();
            Planoconta codpcOld = persistentContabancaria.getCodpc();
            Planoconta codpcNew = contabancaria.getCodpc();
            Collection<Chequesfirma> chequesfirmaCollectionOld = persistentContabancaria.getChequesfirmaCollection();
            Collection<Chequesfirma> chequesfirmaCollectionNew = contabancaria.getChequesfirmaCollection();
            Collection<Contapagarpag> contapagarpagCollectionOld = persistentContabancaria.getContapagarpagCollection();
            Collection<Contapagarpag> contapagarpagCollectionNew = contabancaria.getContapagarpagCollection();
            Collection<Contareceberfixa> contareceberfixaCollectionOld = persistentContabancaria.getContareceberfixaCollection();
            Collection<Contareceberfixa> contareceberfixaCollectionNew = contabancaria.getContareceberfixaCollection();
            Collection<Recebimento> recebimentoCollectionOld = persistentContabancaria.getRecebimentoCollection();
            Collection<Recebimento> recebimentoCollectionNew = contabancaria.getRecebimentoCollection();
            Collection<Contareceber> contareceberCollectionOld = persistentContabancaria.getContareceberCollection();
            Collection<Contareceber> contareceberCollectionNew = contabancaria.getContareceberCollection();
            Collection<Contratocobranca> contratocobrancaCollectionOld = persistentContabancaria.getContratocobrancaCollection();
            Collection<Contratocobranca> contratocobrancaCollectionNew = contabancaria.getContratocobrancaCollection();
            Collection<Orcamento> orcamentoCollectionOld = persistentContabancaria.getOrcamentoCollection();
            Collection<Orcamento> orcamentoCollectionNew = contabancaria.getOrcamentoCollection();
            Collection<Historicocarteira> historicocarteiraCollectionOld = persistentContabancaria.getHistoricocarteiraCollection();
            Collection<Historicocarteira> historicocarteiraCollectionNew = contabancaria.getHistoricocarteiraCollection();
            List<String> illegalOrphanMessages = null;
            for (Historicocarteira historicocarteiraCollectionOldHistoricocarteira : historicocarteiraCollectionOld) {
                if (!historicocarteiraCollectionNew.contains(historicocarteiraCollectionOldHistoricocarteira)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Historicocarteira " + historicocarteiraCollectionOldHistoricocarteira + " since its codcontabancaria field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codbancoNew != null) {
                codbancoNew = em.getReference(codbancoNew.getClass(), codbancoNew.getCodbanco());
                contabancaria.setCodbanco(codbancoNew);
            }
            if (codcaixasNew != null) {
                codcaixasNew = em.getReference(codcaixasNew.getClass(), codcaixasNew.getCodcaixas());
                contabancaria.setCodcaixas(codcaixasNew);
            }
            if (codcalculodvNew != null) {
                codcalculodvNew = em.getReference(codcalculodvNew.getClass(), codcalculodvNew.getCodcalculodv());
                contabancaria.setCodcalculodv(codcalculodvNew);
            }
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                contabancaria.setCodempresa(codempresaNew);
            }
            if (codpcNew != null) {
                codpcNew = em.getReference(codpcNew.getClass(), codpcNew.getCodpc());
                contabancaria.setCodpc(codpcNew);
            }
            Collection<Chequesfirma> attachedChequesfirmaCollectionNew = new ArrayList<Chequesfirma>();
            for (Chequesfirma chequesfirmaCollectionNewChequesfirmaToAttach : chequesfirmaCollectionNew) {
                chequesfirmaCollectionNewChequesfirmaToAttach = em.getReference(chequesfirmaCollectionNewChequesfirmaToAttach.getClass(), chequesfirmaCollectionNewChequesfirmaToAttach.getCodchequefirma());
                attachedChequesfirmaCollectionNew.add(chequesfirmaCollectionNewChequesfirmaToAttach);
            }
            chequesfirmaCollectionNew = attachedChequesfirmaCollectionNew;
            contabancaria.setChequesfirmaCollection(chequesfirmaCollectionNew);
            Collection<Contapagarpag> attachedContapagarpagCollectionNew = new ArrayList<Contapagarpag>();
            for (Contapagarpag contapagarpagCollectionNewContapagarpagToAttach : contapagarpagCollectionNew) {
                contapagarpagCollectionNewContapagarpagToAttach = em.getReference(contapagarpagCollectionNewContapagarpagToAttach.getClass(), contapagarpagCollectionNewContapagarpagToAttach.getId());
                attachedContapagarpagCollectionNew.add(contapagarpagCollectionNewContapagarpagToAttach);
            }
            contapagarpagCollectionNew = attachedContapagarpagCollectionNew;
            contabancaria.setContapagarpagCollection(contapagarpagCollectionNew);
            Collection<Contareceberfixa> attachedContareceberfixaCollectionNew = new ArrayList<Contareceberfixa>();
            for (Contareceberfixa contareceberfixaCollectionNewContareceberfixaToAttach : contareceberfixaCollectionNew) {
                contareceberfixaCollectionNewContareceberfixaToAttach = em.getReference(contareceberfixaCollectionNewContareceberfixaToAttach.getClass(), contareceberfixaCollectionNewContareceberfixaToAttach.getCodcrfixa());
                attachedContareceberfixaCollectionNew.add(contareceberfixaCollectionNewContareceberfixaToAttach);
            }
            contareceberfixaCollectionNew = attachedContareceberfixaCollectionNew;
            contabancaria.setContareceberfixaCollection(contareceberfixaCollectionNew);
            Collection<Recebimento> attachedRecebimentoCollectionNew = new ArrayList<Recebimento>();
            for (Recebimento recebimentoCollectionNewRecebimentoToAttach : recebimentoCollectionNew) {
                recebimentoCollectionNewRecebimentoToAttach = em.getReference(recebimentoCollectionNewRecebimentoToAttach.getClass(), recebimentoCollectionNewRecebimentoToAttach.getCodrec());
                attachedRecebimentoCollectionNew.add(recebimentoCollectionNewRecebimentoToAttach);
            }
            recebimentoCollectionNew = attachedRecebimentoCollectionNew;
            contabancaria.setRecebimentoCollection(recebimentoCollectionNew);
            Collection<Contareceber> attachedContareceberCollectionNew = new ArrayList<Contareceber>();
            for (Contareceber contareceberCollectionNewContareceberToAttach : contareceberCollectionNew) {
                contareceberCollectionNewContareceberToAttach = em.getReference(contareceberCollectionNewContareceberToAttach.getClass(), contareceberCollectionNewContareceberToAttach.getCodcr());
                attachedContareceberCollectionNew.add(contareceberCollectionNewContareceberToAttach);
            }
            contareceberCollectionNew = attachedContareceberCollectionNew;
            contabancaria.setContareceberCollection(contareceberCollectionNew);
            Collection<Contratocobranca> attachedContratocobrancaCollectionNew = new ArrayList<Contratocobranca>();
            for (Contratocobranca contratocobrancaCollectionNewContratocobrancaToAttach : contratocobrancaCollectionNew) {
                contratocobrancaCollectionNewContratocobrancaToAttach = em.getReference(contratocobrancaCollectionNewContratocobrancaToAttach.getClass(), contratocobrancaCollectionNewContratocobrancaToAttach.getCodcontratocobranca());
                attachedContratocobrancaCollectionNew.add(contratocobrancaCollectionNewContratocobrancaToAttach);
            }
            contratocobrancaCollectionNew = attachedContratocobrancaCollectionNew;
            contabancaria.setContratocobrancaCollection(contratocobrancaCollectionNew);
            Collection<Orcamento> attachedOrcamentoCollectionNew = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollectionNewOrcamentoToAttach : orcamentoCollectionNew) {
                orcamentoCollectionNewOrcamentoToAttach = em.getReference(orcamentoCollectionNewOrcamentoToAttach.getClass(), orcamentoCollectionNewOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollectionNew.add(orcamentoCollectionNewOrcamentoToAttach);
            }
            orcamentoCollectionNew = attachedOrcamentoCollectionNew;
            contabancaria.setOrcamentoCollection(orcamentoCollectionNew);
            Collection<Historicocarteira> attachedHistoricocarteiraCollectionNew = new ArrayList<Historicocarteira>();
            for (Historicocarteira historicocarteiraCollectionNewHistoricocarteiraToAttach : historicocarteiraCollectionNew) {
                historicocarteiraCollectionNewHistoricocarteiraToAttach = em.getReference(historicocarteiraCollectionNewHistoricocarteiraToAttach.getClass(), historicocarteiraCollectionNewHistoricocarteiraToAttach.getCodhistoricocarteira());
                attachedHistoricocarteiraCollectionNew.add(historicocarteiraCollectionNewHistoricocarteiraToAttach);
            }
            historicocarteiraCollectionNew = attachedHistoricocarteiraCollectionNew;
            contabancaria.setHistoricocarteiraCollection(historicocarteiraCollectionNew);
            contabancaria = em.merge(contabancaria);
            if (codbancoOld != null && !codbancoOld.equals(codbancoNew)) {
                codbancoOld.getContabancariaCollection().remove(contabancaria);
                codbancoOld = em.merge(codbancoOld);
            }
            if (codbancoNew != null && !codbancoNew.equals(codbancoOld)) {
                codbancoNew.getContabancariaCollection().add(contabancaria);
                codbancoNew = em.merge(codbancoNew);
            }
            if (codcaixasOld != null && !codcaixasOld.equals(codcaixasNew)) {
                codcaixasOld.getContabancariaCollection().remove(contabancaria);
                codcaixasOld = em.merge(codcaixasOld);
            }
            if (codcaixasNew != null && !codcaixasNew.equals(codcaixasOld)) {
                codcaixasNew.getContabancariaCollection().add(contabancaria);
                codcaixasNew = em.merge(codcaixasNew);
            }
            if (codcalculodvOld != null && !codcalculodvOld.equals(codcalculodvNew)) {
                codcalculodvOld.getContabancariaCollection().remove(contabancaria);
                codcalculodvOld = em.merge(codcalculodvOld);
            }
            if (codcalculodvNew != null && !codcalculodvNew.equals(codcalculodvOld)) {
                codcalculodvNew.getContabancariaCollection().add(contabancaria);
                codcalculodvNew = em.merge(codcalculodvNew);
            }
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getContabancariaCollection().remove(contabancaria);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getContabancariaCollection().add(contabancaria);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codpcOld != null && !codpcOld.equals(codpcNew)) {
                codpcOld.getContabancariaCollection().remove(contabancaria);
                codpcOld = em.merge(codpcOld);
            }
            if (codpcNew != null && !codpcNew.equals(codpcOld)) {
                codpcNew.getContabancariaCollection().add(contabancaria);
                codpcNew = em.merge(codpcNew);
            }
            for (Chequesfirma chequesfirmaCollectionOldChequesfirma : chequesfirmaCollectionOld) {
                if (!chequesfirmaCollectionNew.contains(chequesfirmaCollectionOldChequesfirma)) {
                    chequesfirmaCollectionOldChequesfirma.setCodcontabancaria(null);
                    chequesfirmaCollectionOldChequesfirma = em.merge(chequesfirmaCollectionOldChequesfirma);
                }
            }
            for (Chequesfirma chequesfirmaCollectionNewChequesfirma : chequesfirmaCollectionNew) {
                if (!chequesfirmaCollectionOld.contains(chequesfirmaCollectionNewChequesfirma)) {
                    Contabancaria oldCodcontabancariaOfChequesfirmaCollectionNewChequesfirma = chequesfirmaCollectionNewChequesfirma.getCodcontabancaria();
                    chequesfirmaCollectionNewChequesfirma.setCodcontabancaria(contabancaria);
                    chequesfirmaCollectionNewChequesfirma = em.merge(chequesfirmaCollectionNewChequesfirma);
                    if (oldCodcontabancariaOfChequesfirmaCollectionNewChequesfirma != null && !oldCodcontabancariaOfChequesfirmaCollectionNewChequesfirma.equals(contabancaria)) {
                        oldCodcontabancariaOfChequesfirmaCollectionNewChequesfirma.getChequesfirmaCollection().remove(chequesfirmaCollectionNewChequesfirma);
                        oldCodcontabancariaOfChequesfirmaCollectionNewChequesfirma = em.merge(oldCodcontabancariaOfChequesfirmaCollectionNewChequesfirma);
                    }
                }
            }
            for (Contapagarpag contapagarpagCollectionOldContapagarpag : contapagarpagCollectionOld) {
                if (!contapagarpagCollectionNew.contains(contapagarpagCollectionOldContapagarpag)) {
                    contapagarpagCollectionOldContapagarpag.setCodcontabancaria(null);
                    contapagarpagCollectionOldContapagarpag = em.merge(contapagarpagCollectionOldContapagarpag);
                }
            }
            for (Contapagarpag contapagarpagCollectionNewContapagarpag : contapagarpagCollectionNew) {
                if (!contapagarpagCollectionOld.contains(contapagarpagCollectionNewContapagarpag)) {
                    Contabancaria oldCodcontabancariaOfContapagarpagCollectionNewContapagarpag = contapagarpagCollectionNewContapagarpag.getCodcontabancaria();
                    contapagarpagCollectionNewContapagarpag.setCodcontabancaria(contabancaria);
                    contapagarpagCollectionNewContapagarpag = em.merge(contapagarpagCollectionNewContapagarpag);
                    if (oldCodcontabancariaOfContapagarpagCollectionNewContapagarpag != null && !oldCodcontabancariaOfContapagarpagCollectionNewContapagarpag.equals(contabancaria)) {
                        oldCodcontabancariaOfContapagarpagCollectionNewContapagarpag.getContapagarpagCollection().remove(contapagarpagCollectionNewContapagarpag);
                        oldCodcontabancariaOfContapagarpagCollectionNewContapagarpag = em.merge(oldCodcontabancariaOfContapagarpagCollectionNewContapagarpag);
                    }
                }
            }
            for (Contareceberfixa contareceberfixaCollectionOldContareceberfixa : contareceberfixaCollectionOld) {
                if (!contareceberfixaCollectionNew.contains(contareceberfixaCollectionOldContareceberfixa)) {
                    contareceberfixaCollectionOldContareceberfixa.setCodcontabancaria(null);
                    contareceberfixaCollectionOldContareceberfixa = em.merge(contareceberfixaCollectionOldContareceberfixa);
                }
            }
            for (Contareceberfixa contareceberfixaCollectionNewContareceberfixa : contareceberfixaCollectionNew) {
                if (!contareceberfixaCollectionOld.contains(contareceberfixaCollectionNewContareceberfixa)) {
                    Contabancaria oldCodcontabancariaOfContareceberfixaCollectionNewContareceberfixa = contareceberfixaCollectionNewContareceberfixa.getCodcontabancaria();
                    contareceberfixaCollectionNewContareceberfixa.setCodcontabancaria(contabancaria);
                    contareceberfixaCollectionNewContareceberfixa = em.merge(contareceberfixaCollectionNewContareceberfixa);
                    if (oldCodcontabancariaOfContareceberfixaCollectionNewContareceberfixa != null && !oldCodcontabancariaOfContareceberfixaCollectionNewContareceberfixa.equals(contabancaria)) {
                        oldCodcontabancariaOfContareceberfixaCollectionNewContareceberfixa.getContareceberfixaCollection().remove(contareceberfixaCollectionNewContareceberfixa);
                        oldCodcontabancariaOfContareceberfixaCollectionNewContareceberfixa = em.merge(oldCodcontabancariaOfContareceberfixaCollectionNewContareceberfixa);
                    }
                }
            }
            for (Recebimento recebimentoCollectionOldRecebimento : recebimentoCollectionOld) {
                if (!recebimentoCollectionNew.contains(recebimentoCollectionOldRecebimento)) {
                    recebimentoCollectionOldRecebimento.setCodcontabancaria(null);
                    recebimentoCollectionOldRecebimento = em.merge(recebimentoCollectionOldRecebimento);
                }
            }
            for (Recebimento recebimentoCollectionNewRecebimento : recebimentoCollectionNew) {
                if (!recebimentoCollectionOld.contains(recebimentoCollectionNewRecebimento)) {
                    Contabancaria oldCodcontabancariaOfRecebimentoCollectionNewRecebimento = recebimentoCollectionNewRecebimento.getCodcontabancaria();
                    recebimentoCollectionNewRecebimento.setCodcontabancaria(contabancaria);
                    recebimentoCollectionNewRecebimento = em.merge(recebimentoCollectionNewRecebimento);
                    if (oldCodcontabancariaOfRecebimentoCollectionNewRecebimento != null && !oldCodcontabancariaOfRecebimentoCollectionNewRecebimento.equals(contabancaria)) {
                        oldCodcontabancariaOfRecebimentoCollectionNewRecebimento.getRecebimentoCollection().remove(recebimentoCollectionNewRecebimento);
                        oldCodcontabancariaOfRecebimentoCollectionNewRecebimento = em.merge(oldCodcontabancariaOfRecebimentoCollectionNewRecebimento);
                    }
                }
            }
            for (Contareceber contareceberCollectionOldContareceber : contareceberCollectionOld) {
                if (!contareceberCollectionNew.contains(contareceberCollectionOldContareceber)) {
                    contareceberCollectionOldContareceber.setCodcontabancaria(null);
                    contareceberCollectionOldContareceber = em.merge(contareceberCollectionOldContareceber);
                }
            }
            for (Contareceber contareceberCollectionNewContareceber : contareceberCollectionNew) {
                if (!contareceberCollectionOld.contains(contareceberCollectionNewContareceber)) {
                    Contabancaria oldCodcontabancariaOfContareceberCollectionNewContareceber = contareceberCollectionNewContareceber.getCodcontabancaria();
                    contareceberCollectionNewContareceber.setCodcontabancaria(contabancaria);
                    contareceberCollectionNewContareceber = em.merge(contareceberCollectionNewContareceber);
                    if (oldCodcontabancariaOfContareceberCollectionNewContareceber != null && !oldCodcontabancariaOfContareceberCollectionNewContareceber.equals(contabancaria)) {
                        oldCodcontabancariaOfContareceberCollectionNewContareceber.getContareceberCollection().remove(contareceberCollectionNewContareceber);
                        oldCodcontabancariaOfContareceberCollectionNewContareceber = em.merge(oldCodcontabancariaOfContareceberCollectionNewContareceber);
                    }
                }
            }
            for (Contratocobranca contratocobrancaCollectionOldContratocobranca : contratocobrancaCollectionOld) {
                if (!contratocobrancaCollectionNew.contains(contratocobrancaCollectionOldContratocobranca)) {
                    contratocobrancaCollectionOldContratocobranca.setCodcontabancaria(null);
                    contratocobrancaCollectionOldContratocobranca = em.merge(contratocobrancaCollectionOldContratocobranca);
                }
            }
            for (Contratocobranca contratocobrancaCollectionNewContratocobranca : contratocobrancaCollectionNew) {
                if (!contratocobrancaCollectionOld.contains(contratocobrancaCollectionNewContratocobranca)) {
                    Contabancaria oldCodcontabancariaOfContratocobrancaCollectionNewContratocobranca = contratocobrancaCollectionNewContratocobranca.getCodcontabancaria();
                    contratocobrancaCollectionNewContratocobranca.setCodcontabancaria(contabancaria);
                    contratocobrancaCollectionNewContratocobranca = em.merge(contratocobrancaCollectionNewContratocobranca);
                    if (oldCodcontabancariaOfContratocobrancaCollectionNewContratocobranca != null && !oldCodcontabancariaOfContratocobrancaCollectionNewContratocobranca.equals(contabancaria)) {
                        oldCodcontabancariaOfContratocobrancaCollectionNewContratocobranca.getContratocobrancaCollection().remove(contratocobrancaCollectionNewContratocobranca);
                        oldCodcontabancariaOfContratocobrancaCollectionNewContratocobranca = em.merge(oldCodcontabancariaOfContratocobrancaCollectionNewContratocobranca);
                    }
                }
            }
            for (Orcamento orcamentoCollectionOldOrcamento : orcamentoCollectionOld) {
                if (!orcamentoCollectionNew.contains(orcamentoCollectionOldOrcamento)) {
                    orcamentoCollectionOldOrcamento.setCodcontabancaria(null);
                    orcamentoCollectionOldOrcamento = em.merge(orcamentoCollectionOldOrcamento);
                }
            }
            for (Orcamento orcamentoCollectionNewOrcamento : orcamentoCollectionNew) {
                if (!orcamentoCollectionOld.contains(orcamentoCollectionNewOrcamento)) {
                    Contabancaria oldCodcontabancariaOfOrcamentoCollectionNewOrcamento = orcamentoCollectionNewOrcamento.getCodcontabancaria();
                    orcamentoCollectionNewOrcamento.setCodcontabancaria(contabancaria);
                    orcamentoCollectionNewOrcamento = em.merge(orcamentoCollectionNewOrcamento);
                    if (oldCodcontabancariaOfOrcamentoCollectionNewOrcamento != null && !oldCodcontabancariaOfOrcamentoCollectionNewOrcamento.equals(contabancaria)) {
                        oldCodcontabancariaOfOrcamentoCollectionNewOrcamento.getOrcamentoCollection().remove(orcamentoCollectionNewOrcamento);
                        oldCodcontabancariaOfOrcamentoCollectionNewOrcamento = em.merge(oldCodcontabancariaOfOrcamentoCollectionNewOrcamento);
                    }
                }
            }
            for (Historicocarteira historicocarteiraCollectionNewHistoricocarteira : historicocarteiraCollectionNew) {
                if (!historicocarteiraCollectionOld.contains(historicocarteiraCollectionNewHistoricocarteira)) {
                    Contabancaria oldCodcontabancariaOfHistoricocarteiraCollectionNewHistoricocarteira = historicocarteiraCollectionNewHistoricocarteira.getCodcontabancaria();
                    historicocarteiraCollectionNewHistoricocarteira.setCodcontabancaria(contabancaria);
                    historicocarteiraCollectionNewHistoricocarteira = em.merge(historicocarteiraCollectionNewHistoricocarteira);
                    if (oldCodcontabancariaOfHistoricocarteiraCollectionNewHistoricocarteira != null && !oldCodcontabancariaOfHistoricocarteiraCollectionNewHistoricocarteira.equals(contabancaria)) {
                        oldCodcontabancariaOfHistoricocarteiraCollectionNewHistoricocarteira.getHistoricocarteiraCollection().remove(historicocarteiraCollectionNewHistoricocarteira);
                        oldCodcontabancariaOfHistoricocarteiraCollectionNewHistoricocarteira = em.merge(oldCodcontabancariaOfHistoricocarteiraCollectionNewHistoricocarteira);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = contabancaria.getCodcontabancaria();
                if (findContabancaria(id) == null) {
                    throw new NonexistentEntityException("The contabancaria with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contabancaria contabancaria;
            try {
                contabancaria = em.getReference(Contabancaria.class, id);
                contabancaria.getCodcontabancaria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The contabancaria with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Historicocarteira> historicocarteiraCollectionOrphanCheck = contabancaria.getHistoricocarteiraCollection();
            for (Historicocarteira historicocarteiraCollectionOrphanCheckHistoricocarteira : historicocarteiraCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Contabancaria (" + contabancaria + ") cannot be destroyed since the Historicocarteira " + historicocarteiraCollectionOrphanCheckHistoricocarteira + " in its historicocarteiraCollection field has a non-nullable codcontabancaria field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Banco codbanco = contabancaria.getCodbanco();
            if (codbanco != null) {
                codbanco.getContabancariaCollection().remove(contabancaria);
                codbanco = em.merge(codbanco);
            }
            Caixas codcaixas = contabancaria.getCodcaixas();
            if (codcaixas != null) {
                codcaixas.getContabancariaCollection().remove(contabancaria);
                codcaixas = em.merge(codcaixas);
            }
            Calculodv codcalculodv = contabancaria.getCodcalculodv();
            if (codcalculodv != null) {
                codcalculodv.getContabancariaCollection().remove(contabancaria);
                codcalculodv = em.merge(codcalculodv);
            }
            Empresa codempresa = contabancaria.getCodempresa();
            if (codempresa != null) {
                codempresa.getContabancariaCollection().remove(contabancaria);
                codempresa = em.merge(codempresa);
            }
            Planoconta codpc = contabancaria.getCodpc();
            if (codpc != null) {
                codpc.getContabancariaCollection().remove(contabancaria);
                codpc = em.merge(codpc);
            }
            Collection<Chequesfirma> chequesfirmaCollection = contabancaria.getChequesfirmaCollection();
            for (Chequesfirma chequesfirmaCollectionChequesfirma : chequesfirmaCollection) {
                chequesfirmaCollectionChequesfirma.setCodcontabancaria(null);
                chequesfirmaCollectionChequesfirma = em.merge(chequesfirmaCollectionChequesfirma);
            }
            Collection<Contapagarpag> contapagarpagCollection = contabancaria.getContapagarpagCollection();
            for (Contapagarpag contapagarpagCollectionContapagarpag : contapagarpagCollection) {
                contapagarpagCollectionContapagarpag.setCodcontabancaria(null);
                contapagarpagCollectionContapagarpag = em.merge(contapagarpagCollectionContapagarpag);
            }
            Collection<Contareceberfixa> contareceberfixaCollection = contabancaria.getContareceberfixaCollection();
            for (Contareceberfixa contareceberfixaCollectionContareceberfixa : contareceberfixaCollection) {
                contareceberfixaCollectionContareceberfixa.setCodcontabancaria(null);
                contareceberfixaCollectionContareceberfixa = em.merge(contareceberfixaCollectionContareceberfixa);
            }
            Collection<Recebimento> recebimentoCollection = contabancaria.getRecebimentoCollection();
            for (Recebimento recebimentoCollectionRecebimento : recebimentoCollection) {
                recebimentoCollectionRecebimento.setCodcontabancaria(null);
                recebimentoCollectionRecebimento = em.merge(recebimentoCollectionRecebimento);
            }
            Collection<Contareceber> contareceberCollection = contabancaria.getContareceberCollection();
            for (Contareceber contareceberCollectionContareceber : contareceberCollection) {
                contareceberCollectionContareceber.setCodcontabancaria(null);
                contareceberCollectionContareceber = em.merge(contareceberCollectionContareceber);
            }
            Collection<Contratocobranca> contratocobrancaCollection = contabancaria.getContratocobrancaCollection();
            for (Contratocobranca contratocobrancaCollectionContratocobranca : contratocobrancaCollection) {
                contratocobrancaCollectionContratocobranca.setCodcontabancaria(null);
                contratocobrancaCollectionContratocobranca = em.merge(contratocobrancaCollectionContratocobranca);
            }
            Collection<Orcamento> orcamentoCollection = contabancaria.getOrcamentoCollection();
            for (Orcamento orcamentoCollectionOrcamento : orcamentoCollection) {
                orcamentoCollectionOrcamento.setCodcontabancaria(null);
                orcamentoCollectionOrcamento = em.merge(orcamentoCollectionOrcamento);
            }
            em.remove(contabancaria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Contabancaria> findContabancariaEntities() {
        return findContabancariaEntities(true, -1, -1);
    }

    public List<Contabancaria> findContabancariaEntities(int maxResults, int firstResult) {
        return findContabancariaEntities(false, maxResults, firstResult);
    }

    private List<Contabancaria> findContabancariaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Contabancaria.class));
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

    public Contabancaria findContabancaria(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Contabancaria.class, id);
        } finally {
            em.close();
        }
    }

    public int getContabancariaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Contabancaria> rt = cq.from(Contabancaria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

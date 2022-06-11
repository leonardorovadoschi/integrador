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
import entidade.cplus.Cliente;
import entidade.cplus.Atendimento;
import entidade.cplus.Caixas;
import entidade.cplus.Centrocusto;
import entidade.cplus.Conhecimentotransporte;
import entidade.cplus.Contabancaria;
import entidade.cplus.Contareceber;
import entidade.cplus.Contareceberfixa;
import entidade.cplus.Empresa;
import entidade.cplus.Planoconta;
import entidade.cplus.Renegociacao;
import entidade.cplus.Situacaoadministrativa;
import entidade.cplus.Historicocobranca;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Recebimentos;
import entidade.cplus.Contareceberrec;
import entidade.cplus.Lancacartao;
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
public class ContareceberJpaController implements Serializable {

    public ContareceberJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Contareceber contareceber) throws PreexistingEntityException, Exception {
        if (contareceber.getHistoricocobrancaCollection() == null) {
            contareceber.setHistoricocobrancaCollection(new ArrayList<Historicocobranca>());
        }
        if (contareceber.getRecebimentosCollection() == null) {
            contareceber.setRecebimentosCollection(new ArrayList<Recebimentos>());
        }
        if (contareceber.getContareceberrecCollection() == null) {
            contareceber.setContareceberrecCollection(new ArrayList<Contareceberrec>());
        }
        if (contareceber.getLancacartaoCollection() == null) {
            contareceber.setLancacartaoCollection(new ArrayList<Lancacartao>());
        }
        if (contareceber.getHistoricocarteiraCollection() == null) {
            contareceber.setHistoricocarteiraCollection(new ArrayList<Historicocarteira>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente codcli = contareceber.getCodcli();
            if (codcli != null) {
                codcli = em.getReference(codcli.getClass(), codcli.getCodcli());
                contareceber.setCodcli(codcli);
            }
            Atendimento codatend = contareceber.getCodatend();
            if (codatend != null) {
                codatend = em.getReference(codatend.getClass(), codatend.getCodatend());
                contareceber.setCodatend(codatend);
            }
            Caixas codcaixas = contareceber.getCodcaixas();
            if (codcaixas != null) {
                codcaixas = em.getReference(codcaixas.getClass(), codcaixas.getCodcaixas());
                contareceber.setCodcaixas(codcaixas);
            }
            Centrocusto codcentrocusto = contareceber.getCodcentrocusto();
            if (codcentrocusto != null) {
                codcentrocusto = em.getReference(codcentrocusto.getClass(), codcentrocusto.getCodcentrocusto());
                contareceber.setCodcentrocusto(codcentrocusto);
            }
            Cliente codclivenda = contareceber.getCodclivenda();
            if (codclivenda != null) {
                codclivenda = em.getReference(codclivenda.getClass(), codclivenda.getCodcli());
                contareceber.setCodclivenda(codclivenda);
            }
            Conhecimentotransporte codconhecimentotransporte = contareceber.getCodconhecimentotransporte();
            if (codconhecimentotransporte != null) {
                codconhecimentotransporte = em.getReference(codconhecimentotransporte.getClass(), codconhecimentotransporte.getCodconhecimentotransporte());
                contareceber.setCodconhecimentotransporte(codconhecimentotransporte);
            }
            Contabancaria codcontabancaria = contareceber.getCodcontabancaria();
            if (codcontabancaria != null) {
                codcontabancaria = em.getReference(codcontabancaria.getClass(), codcontabancaria.getCodcontabancaria());
                contareceber.setCodcontabancaria(codcontabancaria);
            }
            Contareceberfixa codcrfixa = contareceber.getCodcrfixa();
            if (codcrfixa != null) {
                codcrfixa = em.getReference(codcrfixa.getClass(), codcrfixa.getCodcrfixa());
                contareceber.setCodcrfixa(codcrfixa);
            }
            Empresa codempresa = contareceber.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                contareceber.setCodempresa(codempresa);
            }
            Planoconta codpc = contareceber.getCodpc();
            if (codpc != null) {
                codpc = em.getReference(codpc.getClass(), codpc.getCodpc());
                contareceber.setCodpc(codpc);
            }
            Renegociacao codrenegociacao = contareceber.getCodrenegociacao();
            if (codrenegociacao != null) {
                codrenegociacao = em.getReference(codrenegociacao.getClass(), codrenegociacao.getCodrenegociacao());
                contareceber.setCodrenegociacao(codrenegociacao);
            }
            Situacaoadministrativa codsituacaoadministrativa = contareceber.getCodsituacaoadministrativa();
            if (codsituacaoadministrativa != null) {
                codsituacaoadministrativa = em.getReference(codsituacaoadministrativa.getClass(), codsituacaoadministrativa.getCodsituacaoadministrativa());
                contareceber.setCodsituacaoadministrativa(codsituacaoadministrativa);
            }
            Collection<Historicocobranca> attachedHistoricocobrancaCollection = new ArrayList<Historicocobranca>();
            for (Historicocobranca historicocobrancaCollectionHistoricocobrancaToAttach : contareceber.getHistoricocobrancaCollection()) {
                historicocobrancaCollectionHistoricocobrancaToAttach = em.getReference(historicocobrancaCollectionHistoricocobrancaToAttach.getClass(), historicocobrancaCollectionHistoricocobrancaToAttach.getCodhistoricocobranca());
                attachedHistoricocobrancaCollection.add(historicocobrancaCollectionHistoricocobrancaToAttach);
            }
            contareceber.setHistoricocobrancaCollection(attachedHistoricocobrancaCollection);
            Collection<Recebimentos> attachedRecebimentosCollection = new ArrayList<Recebimentos>();
            for (Recebimentos recebimentosCollectionRecebimentosToAttach : contareceber.getRecebimentosCollection()) {
                recebimentosCollectionRecebimentosToAttach = em.getReference(recebimentosCollectionRecebimentosToAttach.getClass(), recebimentosCollectionRecebimentosToAttach.getId());
                attachedRecebimentosCollection.add(recebimentosCollectionRecebimentosToAttach);
            }
            contareceber.setRecebimentosCollection(attachedRecebimentosCollection);
            Collection<Contareceberrec> attachedContareceberrecCollection = new ArrayList<Contareceberrec>();
            for (Contareceberrec contareceberrecCollectionContareceberrecToAttach : contareceber.getContareceberrecCollection()) {
                contareceberrecCollectionContareceberrecToAttach = em.getReference(contareceberrecCollectionContareceberrecToAttach.getClass(), contareceberrecCollectionContareceberrecToAttach.getId());
                attachedContareceberrecCollection.add(contareceberrecCollectionContareceberrecToAttach);
            }
            contareceber.setContareceberrecCollection(attachedContareceberrecCollection);
            Collection<Lancacartao> attachedLancacartaoCollection = new ArrayList<Lancacartao>();
            for (Lancacartao lancacartaoCollectionLancacartaoToAttach : contareceber.getLancacartaoCollection()) {
                lancacartaoCollectionLancacartaoToAttach = em.getReference(lancacartaoCollectionLancacartaoToAttach.getClass(), lancacartaoCollectionLancacartaoToAttach.getCodlcar());
                attachedLancacartaoCollection.add(lancacartaoCollectionLancacartaoToAttach);
            }
            contareceber.setLancacartaoCollection(attachedLancacartaoCollection);
            Collection<Historicocarteira> attachedHistoricocarteiraCollection = new ArrayList<Historicocarteira>();
            for (Historicocarteira historicocarteiraCollectionHistoricocarteiraToAttach : contareceber.getHistoricocarteiraCollection()) {
                historicocarteiraCollectionHistoricocarteiraToAttach = em.getReference(historicocarteiraCollectionHistoricocarteiraToAttach.getClass(), historicocarteiraCollectionHistoricocarteiraToAttach.getCodhistoricocarteira());
                attachedHistoricocarteiraCollection.add(historicocarteiraCollectionHistoricocarteiraToAttach);
            }
            contareceber.setHistoricocarteiraCollection(attachedHistoricocarteiraCollection);
            em.persist(contareceber);
            if (codcli != null) {
                codcli.getContareceberCollection().add(contareceber);
                codcli = em.merge(codcli);
            }
            if (codatend != null) {
                codatend.getContareceberCollection().add(contareceber);
                codatend = em.merge(codatend);
            }
            if (codcaixas != null) {
                codcaixas.getContareceberCollection().add(contareceber);
                codcaixas = em.merge(codcaixas);
            }
            if (codcentrocusto != null) {
                codcentrocusto.getContareceberCollection().add(contareceber);
                codcentrocusto = em.merge(codcentrocusto);
            }
            if (codclivenda != null) {
                codclivenda.getContareceberCollection().add(contareceber);
                codclivenda = em.merge(codclivenda);
            }
            if (codconhecimentotransporte != null) {
                codconhecimentotransporte.getContareceberCollection().add(contareceber);
                codconhecimentotransporte = em.merge(codconhecimentotransporte);
            }
            if (codcontabancaria != null) {
                codcontabancaria.getContareceberCollection().add(contareceber);
                codcontabancaria = em.merge(codcontabancaria);
            }
            if (codcrfixa != null) {
                codcrfixa.getContareceberCollection().add(contareceber);
                codcrfixa = em.merge(codcrfixa);
            }
            if (codempresa != null) {
                codempresa.getContareceberCollection().add(contareceber);
                codempresa = em.merge(codempresa);
            }
            if (codpc != null) {
                codpc.getContareceberCollection().add(contareceber);
                codpc = em.merge(codpc);
            }
            if (codrenegociacao != null) {
                codrenegociacao.getContareceberCollection().add(contareceber);
                codrenegociacao = em.merge(codrenegociacao);
            }
            if (codsituacaoadministrativa != null) {
                codsituacaoadministrativa.getContareceberCollection().add(contareceber);
                codsituacaoadministrativa = em.merge(codsituacaoadministrativa);
            }
            for (Historicocobranca historicocobrancaCollectionHistoricocobranca : contareceber.getHistoricocobrancaCollection()) {
                Contareceber oldCodcrOfHistoricocobrancaCollectionHistoricocobranca = historicocobrancaCollectionHistoricocobranca.getCodcr();
                historicocobrancaCollectionHistoricocobranca.setCodcr(contareceber);
                historicocobrancaCollectionHistoricocobranca = em.merge(historicocobrancaCollectionHistoricocobranca);
                if (oldCodcrOfHistoricocobrancaCollectionHistoricocobranca != null) {
                    oldCodcrOfHistoricocobrancaCollectionHistoricocobranca.getHistoricocobrancaCollection().remove(historicocobrancaCollectionHistoricocobranca);
                    oldCodcrOfHistoricocobrancaCollectionHistoricocobranca = em.merge(oldCodcrOfHistoricocobrancaCollectionHistoricocobranca);
                }
            }
            for (Recebimentos recebimentosCollectionRecebimentos : contareceber.getRecebimentosCollection()) {
                Contareceber oldCodcrOfRecebimentosCollectionRecebimentos = recebimentosCollectionRecebimentos.getCodcr();
                recebimentosCollectionRecebimentos.setCodcr(contareceber);
                recebimentosCollectionRecebimentos = em.merge(recebimentosCollectionRecebimentos);
                if (oldCodcrOfRecebimentosCollectionRecebimentos != null) {
                    oldCodcrOfRecebimentosCollectionRecebimentos.getRecebimentosCollection().remove(recebimentosCollectionRecebimentos);
                    oldCodcrOfRecebimentosCollectionRecebimentos = em.merge(oldCodcrOfRecebimentosCollectionRecebimentos);
                }
            }
            for (Contareceberrec contareceberrecCollectionContareceberrec : contareceber.getContareceberrecCollection()) {
                Contareceber oldCodcrOfContareceberrecCollectionContareceberrec = contareceberrecCollectionContareceberrec.getCodcr();
                contareceberrecCollectionContareceberrec.setCodcr(contareceber);
                contareceberrecCollectionContareceberrec = em.merge(contareceberrecCollectionContareceberrec);
                if (oldCodcrOfContareceberrecCollectionContareceberrec != null) {
                    oldCodcrOfContareceberrecCollectionContareceberrec.getContareceberrecCollection().remove(contareceberrecCollectionContareceberrec);
                    oldCodcrOfContareceberrecCollectionContareceberrec = em.merge(oldCodcrOfContareceberrecCollectionContareceberrec);
                }
            }
            for (Lancacartao lancacartaoCollectionLancacartao : contareceber.getLancacartaoCollection()) {
                Contareceber oldCodcrOfLancacartaoCollectionLancacartao = lancacartaoCollectionLancacartao.getCodcr();
                lancacartaoCollectionLancacartao.setCodcr(contareceber);
                lancacartaoCollectionLancacartao = em.merge(lancacartaoCollectionLancacartao);
                if (oldCodcrOfLancacartaoCollectionLancacartao != null) {
                    oldCodcrOfLancacartaoCollectionLancacartao.getLancacartaoCollection().remove(lancacartaoCollectionLancacartao);
                    oldCodcrOfLancacartaoCollectionLancacartao = em.merge(oldCodcrOfLancacartaoCollectionLancacartao);
                }
            }
            for (Historicocarteira historicocarteiraCollectionHistoricocarteira : contareceber.getHistoricocarteiraCollection()) {
                Contareceber oldCodcrOfHistoricocarteiraCollectionHistoricocarteira = historicocarteiraCollectionHistoricocarteira.getCodcr();
                historicocarteiraCollectionHistoricocarteira.setCodcr(contareceber);
                historicocarteiraCollectionHistoricocarteira = em.merge(historicocarteiraCollectionHistoricocarteira);
                if (oldCodcrOfHistoricocarteiraCollectionHistoricocarteira != null) {
                    oldCodcrOfHistoricocarteiraCollectionHistoricocarteira.getHistoricocarteiraCollection().remove(historicocarteiraCollectionHistoricocarteira);
                    oldCodcrOfHistoricocarteiraCollectionHistoricocarteira = em.merge(oldCodcrOfHistoricocarteiraCollectionHistoricocarteira);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findContareceber(contareceber.getCodcr()) != null) {
                throw new PreexistingEntityException("Contareceber " + contareceber + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Contareceber contareceber) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contareceber persistentContareceber = em.find(Contareceber.class, contareceber.getCodcr());
            Cliente codcliOld = persistentContareceber.getCodcli();
            Cliente codcliNew = contareceber.getCodcli();
            Atendimento codatendOld = persistentContareceber.getCodatend();
            Atendimento codatendNew = contareceber.getCodatend();
            Caixas codcaixasOld = persistentContareceber.getCodcaixas();
            Caixas codcaixasNew = contareceber.getCodcaixas();
            Centrocusto codcentrocustoOld = persistentContareceber.getCodcentrocusto();
            Centrocusto codcentrocustoNew = contareceber.getCodcentrocusto();
            Cliente codclivendaOld = persistentContareceber.getCodclivenda();
            Cliente codclivendaNew = contareceber.getCodclivenda();
            Conhecimentotransporte codconhecimentotransporteOld = persistentContareceber.getCodconhecimentotransporte();
            Conhecimentotransporte codconhecimentotransporteNew = contareceber.getCodconhecimentotransporte();
            Contabancaria codcontabancariaOld = persistentContareceber.getCodcontabancaria();
            Contabancaria codcontabancariaNew = contareceber.getCodcontabancaria();
            Contareceberfixa codcrfixaOld = persistentContareceber.getCodcrfixa();
            Contareceberfixa codcrfixaNew = contareceber.getCodcrfixa();
            Empresa codempresaOld = persistentContareceber.getCodempresa();
            Empresa codempresaNew = contareceber.getCodempresa();
            Planoconta codpcOld = persistentContareceber.getCodpc();
            Planoconta codpcNew = contareceber.getCodpc();
            Renegociacao codrenegociacaoOld = persistentContareceber.getCodrenegociacao();
            Renegociacao codrenegociacaoNew = contareceber.getCodrenegociacao();
            Situacaoadministrativa codsituacaoadministrativaOld = persistentContareceber.getCodsituacaoadministrativa();
            Situacaoadministrativa codsituacaoadministrativaNew = contareceber.getCodsituacaoadministrativa();
            Collection<Historicocobranca> historicocobrancaCollectionOld = persistentContareceber.getHistoricocobrancaCollection();
            Collection<Historicocobranca> historicocobrancaCollectionNew = contareceber.getHistoricocobrancaCollection();
            Collection<Recebimentos> recebimentosCollectionOld = persistentContareceber.getRecebimentosCollection();
            Collection<Recebimentos> recebimentosCollectionNew = contareceber.getRecebimentosCollection();
            Collection<Contareceberrec> contareceberrecCollectionOld = persistentContareceber.getContareceberrecCollection();
            Collection<Contareceberrec> contareceberrecCollectionNew = contareceber.getContareceberrecCollection();
            Collection<Lancacartao> lancacartaoCollectionOld = persistentContareceber.getLancacartaoCollection();
            Collection<Lancacartao> lancacartaoCollectionNew = contareceber.getLancacartaoCollection();
            Collection<Historicocarteira> historicocarteiraCollectionOld = persistentContareceber.getHistoricocarteiraCollection();
            Collection<Historicocarteira> historicocarteiraCollectionNew = contareceber.getHistoricocarteiraCollection();
            List<String> illegalOrphanMessages = null;
            for (Historicocarteira historicocarteiraCollectionOldHistoricocarteira : historicocarteiraCollectionOld) {
                if (!historicocarteiraCollectionNew.contains(historicocarteiraCollectionOldHistoricocarteira)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Historicocarteira " + historicocarteiraCollectionOldHistoricocarteira + " since its codcr field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codcliNew != null) {
                codcliNew = em.getReference(codcliNew.getClass(), codcliNew.getCodcli());
                contareceber.setCodcli(codcliNew);
            }
            if (codatendNew != null) {
                codatendNew = em.getReference(codatendNew.getClass(), codatendNew.getCodatend());
                contareceber.setCodatend(codatendNew);
            }
            if (codcaixasNew != null) {
                codcaixasNew = em.getReference(codcaixasNew.getClass(), codcaixasNew.getCodcaixas());
                contareceber.setCodcaixas(codcaixasNew);
            }
            if (codcentrocustoNew != null) {
                codcentrocustoNew = em.getReference(codcentrocustoNew.getClass(), codcentrocustoNew.getCodcentrocusto());
                contareceber.setCodcentrocusto(codcentrocustoNew);
            }
            if (codclivendaNew != null) {
                codclivendaNew = em.getReference(codclivendaNew.getClass(), codclivendaNew.getCodcli());
                contareceber.setCodclivenda(codclivendaNew);
            }
            if (codconhecimentotransporteNew != null) {
                codconhecimentotransporteNew = em.getReference(codconhecimentotransporteNew.getClass(), codconhecimentotransporteNew.getCodconhecimentotransporte());
                contareceber.setCodconhecimentotransporte(codconhecimentotransporteNew);
            }
            if (codcontabancariaNew != null) {
                codcontabancariaNew = em.getReference(codcontabancariaNew.getClass(), codcontabancariaNew.getCodcontabancaria());
                contareceber.setCodcontabancaria(codcontabancariaNew);
            }
            if (codcrfixaNew != null) {
                codcrfixaNew = em.getReference(codcrfixaNew.getClass(), codcrfixaNew.getCodcrfixa());
                contareceber.setCodcrfixa(codcrfixaNew);
            }
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                contareceber.setCodempresa(codempresaNew);
            }
            if (codpcNew != null) {
                codpcNew = em.getReference(codpcNew.getClass(), codpcNew.getCodpc());
                contareceber.setCodpc(codpcNew);
            }
            if (codrenegociacaoNew != null) {
                codrenegociacaoNew = em.getReference(codrenegociacaoNew.getClass(), codrenegociacaoNew.getCodrenegociacao());
                contareceber.setCodrenegociacao(codrenegociacaoNew);
            }
            if (codsituacaoadministrativaNew != null) {
                codsituacaoadministrativaNew = em.getReference(codsituacaoadministrativaNew.getClass(), codsituacaoadministrativaNew.getCodsituacaoadministrativa());
                contareceber.setCodsituacaoadministrativa(codsituacaoadministrativaNew);
            }
            Collection<Historicocobranca> attachedHistoricocobrancaCollectionNew = new ArrayList<Historicocobranca>();
            for (Historicocobranca historicocobrancaCollectionNewHistoricocobrancaToAttach : historicocobrancaCollectionNew) {
                historicocobrancaCollectionNewHistoricocobrancaToAttach = em.getReference(historicocobrancaCollectionNewHistoricocobrancaToAttach.getClass(), historicocobrancaCollectionNewHistoricocobrancaToAttach.getCodhistoricocobranca());
                attachedHistoricocobrancaCollectionNew.add(historicocobrancaCollectionNewHistoricocobrancaToAttach);
            }
            historicocobrancaCollectionNew = attachedHistoricocobrancaCollectionNew;
            contareceber.setHistoricocobrancaCollection(historicocobrancaCollectionNew);
            Collection<Recebimentos> attachedRecebimentosCollectionNew = new ArrayList<Recebimentos>();
            for (Recebimentos recebimentosCollectionNewRecebimentosToAttach : recebimentosCollectionNew) {
                recebimentosCollectionNewRecebimentosToAttach = em.getReference(recebimentosCollectionNewRecebimentosToAttach.getClass(), recebimentosCollectionNewRecebimentosToAttach.getId());
                attachedRecebimentosCollectionNew.add(recebimentosCollectionNewRecebimentosToAttach);
            }
            recebimentosCollectionNew = attachedRecebimentosCollectionNew;
            contareceber.setRecebimentosCollection(recebimentosCollectionNew);
            Collection<Contareceberrec> attachedContareceberrecCollectionNew = new ArrayList<Contareceberrec>();
            for (Contareceberrec contareceberrecCollectionNewContareceberrecToAttach : contareceberrecCollectionNew) {
                contareceberrecCollectionNewContareceberrecToAttach = em.getReference(contareceberrecCollectionNewContareceberrecToAttach.getClass(), contareceberrecCollectionNewContareceberrecToAttach.getId());
                attachedContareceberrecCollectionNew.add(contareceberrecCollectionNewContareceberrecToAttach);
            }
            contareceberrecCollectionNew = attachedContareceberrecCollectionNew;
            contareceber.setContareceberrecCollection(contareceberrecCollectionNew);
            Collection<Lancacartao> attachedLancacartaoCollectionNew = new ArrayList<Lancacartao>();
            for (Lancacartao lancacartaoCollectionNewLancacartaoToAttach : lancacartaoCollectionNew) {
                lancacartaoCollectionNewLancacartaoToAttach = em.getReference(lancacartaoCollectionNewLancacartaoToAttach.getClass(), lancacartaoCollectionNewLancacartaoToAttach.getCodlcar());
                attachedLancacartaoCollectionNew.add(lancacartaoCollectionNewLancacartaoToAttach);
            }
            lancacartaoCollectionNew = attachedLancacartaoCollectionNew;
            contareceber.setLancacartaoCollection(lancacartaoCollectionNew);
            Collection<Historicocarteira> attachedHistoricocarteiraCollectionNew = new ArrayList<Historicocarteira>();
            for (Historicocarteira historicocarteiraCollectionNewHistoricocarteiraToAttach : historicocarteiraCollectionNew) {
                historicocarteiraCollectionNewHistoricocarteiraToAttach = em.getReference(historicocarteiraCollectionNewHistoricocarteiraToAttach.getClass(), historicocarteiraCollectionNewHistoricocarteiraToAttach.getCodhistoricocarteira());
                attachedHistoricocarteiraCollectionNew.add(historicocarteiraCollectionNewHistoricocarteiraToAttach);
            }
            historicocarteiraCollectionNew = attachedHistoricocarteiraCollectionNew;
            contareceber.setHistoricocarteiraCollection(historicocarteiraCollectionNew);
            contareceber = em.merge(contareceber);
            if (codcliOld != null && !codcliOld.equals(codcliNew)) {
                codcliOld.getContareceberCollection().remove(contareceber);
                codcliOld = em.merge(codcliOld);
            }
            if (codcliNew != null && !codcliNew.equals(codcliOld)) {
                codcliNew.getContareceberCollection().add(contareceber);
                codcliNew = em.merge(codcliNew);
            }
            if (codatendOld != null && !codatendOld.equals(codatendNew)) {
                codatendOld.getContareceberCollection().remove(contareceber);
                codatendOld = em.merge(codatendOld);
            }
            if (codatendNew != null && !codatendNew.equals(codatendOld)) {
                codatendNew.getContareceberCollection().add(contareceber);
                codatendNew = em.merge(codatendNew);
            }
            if (codcaixasOld != null && !codcaixasOld.equals(codcaixasNew)) {
                codcaixasOld.getContareceberCollection().remove(contareceber);
                codcaixasOld = em.merge(codcaixasOld);
            }
            if (codcaixasNew != null && !codcaixasNew.equals(codcaixasOld)) {
                codcaixasNew.getContareceberCollection().add(contareceber);
                codcaixasNew = em.merge(codcaixasNew);
            }
            if (codcentrocustoOld != null && !codcentrocustoOld.equals(codcentrocustoNew)) {
                codcentrocustoOld.getContareceberCollection().remove(contareceber);
                codcentrocustoOld = em.merge(codcentrocustoOld);
            }
            if (codcentrocustoNew != null && !codcentrocustoNew.equals(codcentrocustoOld)) {
                codcentrocustoNew.getContareceberCollection().add(contareceber);
                codcentrocustoNew = em.merge(codcentrocustoNew);
            }
            if (codclivendaOld != null && !codclivendaOld.equals(codclivendaNew)) {
                codclivendaOld.getContareceberCollection().remove(contareceber);
                codclivendaOld = em.merge(codclivendaOld);
            }
            if (codclivendaNew != null && !codclivendaNew.equals(codclivendaOld)) {
                codclivendaNew.getContareceberCollection().add(contareceber);
                codclivendaNew = em.merge(codclivendaNew);
            }
            if (codconhecimentotransporteOld != null && !codconhecimentotransporteOld.equals(codconhecimentotransporteNew)) {
                codconhecimentotransporteOld.getContareceberCollection().remove(contareceber);
                codconhecimentotransporteOld = em.merge(codconhecimentotransporteOld);
            }
            if (codconhecimentotransporteNew != null && !codconhecimentotransporteNew.equals(codconhecimentotransporteOld)) {
                codconhecimentotransporteNew.getContareceberCollection().add(contareceber);
                codconhecimentotransporteNew = em.merge(codconhecimentotransporteNew);
            }
            if (codcontabancariaOld != null && !codcontabancariaOld.equals(codcontabancariaNew)) {
                codcontabancariaOld.getContareceberCollection().remove(contareceber);
                codcontabancariaOld = em.merge(codcontabancariaOld);
            }
            if (codcontabancariaNew != null && !codcontabancariaNew.equals(codcontabancariaOld)) {
                codcontabancariaNew.getContareceberCollection().add(contareceber);
                codcontabancariaNew = em.merge(codcontabancariaNew);
            }
            if (codcrfixaOld != null && !codcrfixaOld.equals(codcrfixaNew)) {
                codcrfixaOld.getContareceberCollection().remove(contareceber);
                codcrfixaOld = em.merge(codcrfixaOld);
            }
            if (codcrfixaNew != null && !codcrfixaNew.equals(codcrfixaOld)) {
                codcrfixaNew.getContareceberCollection().add(contareceber);
                codcrfixaNew = em.merge(codcrfixaNew);
            }
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getContareceberCollection().remove(contareceber);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getContareceberCollection().add(contareceber);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codpcOld != null && !codpcOld.equals(codpcNew)) {
                codpcOld.getContareceberCollection().remove(contareceber);
                codpcOld = em.merge(codpcOld);
            }
            if (codpcNew != null && !codpcNew.equals(codpcOld)) {
                codpcNew.getContareceberCollection().add(contareceber);
                codpcNew = em.merge(codpcNew);
            }
            if (codrenegociacaoOld != null && !codrenegociacaoOld.equals(codrenegociacaoNew)) {
                codrenegociacaoOld.getContareceberCollection().remove(contareceber);
                codrenegociacaoOld = em.merge(codrenegociacaoOld);
            }
            if (codrenegociacaoNew != null && !codrenegociacaoNew.equals(codrenegociacaoOld)) {
                codrenegociacaoNew.getContareceberCollection().add(contareceber);
                codrenegociacaoNew = em.merge(codrenegociacaoNew);
            }
            if (codsituacaoadministrativaOld != null && !codsituacaoadministrativaOld.equals(codsituacaoadministrativaNew)) {
                codsituacaoadministrativaOld.getContareceberCollection().remove(contareceber);
                codsituacaoadministrativaOld = em.merge(codsituacaoadministrativaOld);
            }
            if (codsituacaoadministrativaNew != null && !codsituacaoadministrativaNew.equals(codsituacaoadministrativaOld)) {
                codsituacaoadministrativaNew.getContareceberCollection().add(contareceber);
                codsituacaoadministrativaNew = em.merge(codsituacaoadministrativaNew);
            }
            for (Historicocobranca historicocobrancaCollectionOldHistoricocobranca : historicocobrancaCollectionOld) {
                if (!historicocobrancaCollectionNew.contains(historicocobrancaCollectionOldHistoricocobranca)) {
                    historicocobrancaCollectionOldHistoricocobranca.setCodcr(null);
                    historicocobrancaCollectionOldHistoricocobranca = em.merge(historicocobrancaCollectionOldHistoricocobranca);
                }
            }
            for (Historicocobranca historicocobrancaCollectionNewHistoricocobranca : historicocobrancaCollectionNew) {
                if (!historicocobrancaCollectionOld.contains(historicocobrancaCollectionNewHistoricocobranca)) {
                    Contareceber oldCodcrOfHistoricocobrancaCollectionNewHistoricocobranca = historicocobrancaCollectionNewHistoricocobranca.getCodcr();
                    historicocobrancaCollectionNewHistoricocobranca.setCodcr(contareceber);
                    historicocobrancaCollectionNewHistoricocobranca = em.merge(historicocobrancaCollectionNewHistoricocobranca);
                    if (oldCodcrOfHistoricocobrancaCollectionNewHistoricocobranca != null && !oldCodcrOfHistoricocobrancaCollectionNewHistoricocobranca.equals(contareceber)) {
                        oldCodcrOfHistoricocobrancaCollectionNewHistoricocobranca.getHistoricocobrancaCollection().remove(historicocobrancaCollectionNewHistoricocobranca);
                        oldCodcrOfHistoricocobrancaCollectionNewHistoricocobranca = em.merge(oldCodcrOfHistoricocobrancaCollectionNewHistoricocobranca);
                    }
                }
            }
            for (Recebimentos recebimentosCollectionOldRecebimentos : recebimentosCollectionOld) {
                if (!recebimentosCollectionNew.contains(recebimentosCollectionOldRecebimentos)) {
                    recebimentosCollectionOldRecebimentos.setCodcr(null);
                    recebimentosCollectionOldRecebimentos = em.merge(recebimentosCollectionOldRecebimentos);
                }
            }
            for (Recebimentos recebimentosCollectionNewRecebimentos : recebimentosCollectionNew) {
                if (!recebimentosCollectionOld.contains(recebimentosCollectionNewRecebimentos)) {
                    Contareceber oldCodcrOfRecebimentosCollectionNewRecebimentos = recebimentosCollectionNewRecebimentos.getCodcr();
                    recebimentosCollectionNewRecebimentos.setCodcr(contareceber);
                    recebimentosCollectionNewRecebimentos = em.merge(recebimentosCollectionNewRecebimentos);
                    if (oldCodcrOfRecebimentosCollectionNewRecebimentos != null && !oldCodcrOfRecebimentosCollectionNewRecebimentos.equals(contareceber)) {
                        oldCodcrOfRecebimentosCollectionNewRecebimentos.getRecebimentosCollection().remove(recebimentosCollectionNewRecebimentos);
                        oldCodcrOfRecebimentosCollectionNewRecebimentos = em.merge(oldCodcrOfRecebimentosCollectionNewRecebimentos);
                    }
                }
            }
            for (Contareceberrec contareceberrecCollectionOldContareceberrec : contareceberrecCollectionOld) {
                if (!contareceberrecCollectionNew.contains(contareceberrecCollectionOldContareceberrec)) {
                    contareceberrecCollectionOldContareceberrec.setCodcr(null);
                    contareceberrecCollectionOldContareceberrec = em.merge(contareceberrecCollectionOldContareceberrec);
                }
            }
            for (Contareceberrec contareceberrecCollectionNewContareceberrec : contareceberrecCollectionNew) {
                if (!contareceberrecCollectionOld.contains(contareceberrecCollectionNewContareceberrec)) {
                    Contareceber oldCodcrOfContareceberrecCollectionNewContareceberrec = contareceberrecCollectionNewContareceberrec.getCodcr();
                    contareceberrecCollectionNewContareceberrec.setCodcr(contareceber);
                    contareceberrecCollectionNewContareceberrec = em.merge(contareceberrecCollectionNewContareceberrec);
                    if (oldCodcrOfContareceberrecCollectionNewContareceberrec != null && !oldCodcrOfContareceberrecCollectionNewContareceberrec.equals(contareceber)) {
                        oldCodcrOfContareceberrecCollectionNewContareceberrec.getContareceberrecCollection().remove(contareceberrecCollectionNewContareceberrec);
                        oldCodcrOfContareceberrecCollectionNewContareceberrec = em.merge(oldCodcrOfContareceberrecCollectionNewContareceberrec);
                    }
                }
            }
            for (Lancacartao lancacartaoCollectionOldLancacartao : lancacartaoCollectionOld) {
                if (!lancacartaoCollectionNew.contains(lancacartaoCollectionOldLancacartao)) {
                    lancacartaoCollectionOldLancacartao.setCodcr(null);
                    lancacartaoCollectionOldLancacartao = em.merge(lancacartaoCollectionOldLancacartao);
                }
            }
            for (Lancacartao lancacartaoCollectionNewLancacartao : lancacartaoCollectionNew) {
                if (!lancacartaoCollectionOld.contains(lancacartaoCollectionNewLancacartao)) {
                    Contareceber oldCodcrOfLancacartaoCollectionNewLancacartao = lancacartaoCollectionNewLancacartao.getCodcr();
                    lancacartaoCollectionNewLancacartao.setCodcr(contareceber);
                    lancacartaoCollectionNewLancacartao = em.merge(lancacartaoCollectionNewLancacartao);
                    if (oldCodcrOfLancacartaoCollectionNewLancacartao != null && !oldCodcrOfLancacartaoCollectionNewLancacartao.equals(contareceber)) {
                        oldCodcrOfLancacartaoCollectionNewLancacartao.getLancacartaoCollection().remove(lancacartaoCollectionNewLancacartao);
                        oldCodcrOfLancacartaoCollectionNewLancacartao = em.merge(oldCodcrOfLancacartaoCollectionNewLancacartao);
                    }
                }
            }
            for (Historicocarteira historicocarteiraCollectionNewHistoricocarteira : historicocarteiraCollectionNew) {
                if (!historicocarteiraCollectionOld.contains(historicocarteiraCollectionNewHistoricocarteira)) {
                    Contareceber oldCodcrOfHistoricocarteiraCollectionNewHistoricocarteira = historicocarteiraCollectionNewHistoricocarteira.getCodcr();
                    historicocarteiraCollectionNewHistoricocarteira.setCodcr(contareceber);
                    historicocarteiraCollectionNewHistoricocarteira = em.merge(historicocarteiraCollectionNewHistoricocarteira);
                    if (oldCodcrOfHistoricocarteiraCollectionNewHistoricocarteira != null && !oldCodcrOfHistoricocarteiraCollectionNewHistoricocarteira.equals(contareceber)) {
                        oldCodcrOfHistoricocarteiraCollectionNewHistoricocarteira.getHistoricocarteiraCollection().remove(historicocarteiraCollectionNewHistoricocarteira);
                        oldCodcrOfHistoricocarteiraCollectionNewHistoricocarteira = em.merge(oldCodcrOfHistoricocarteiraCollectionNewHistoricocarteira);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = contareceber.getCodcr();
                if (findContareceber(id) == null) {
                    throw new NonexistentEntityException("The contareceber with id " + id + " no longer exists.");
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
            Contareceber contareceber;
            try {
                contareceber = em.getReference(Contareceber.class, id);
                contareceber.getCodcr();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The contareceber with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Historicocarteira> historicocarteiraCollectionOrphanCheck = contareceber.getHistoricocarteiraCollection();
            for (Historicocarteira historicocarteiraCollectionOrphanCheckHistoricocarteira : historicocarteiraCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Contareceber (" + contareceber + ") cannot be destroyed since the Historicocarteira " + historicocarteiraCollectionOrphanCheckHistoricocarteira + " in its historicocarteiraCollection field has a non-nullable codcr field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cliente codcli = contareceber.getCodcli();
            if (codcli != null) {
                codcli.getContareceberCollection().remove(contareceber);
                codcli = em.merge(codcli);
            }
            Atendimento codatend = contareceber.getCodatend();
            if (codatend != null) {
                codatend.getContareceberCollection().remove(contareceber);
                codatend = em.merge(codatend);
            }
            Caixas codcaixas = contareceber.getCodcaixas();
            if (codcaixas != null) {
                codcaixas.getContareceberCollection().remove(contareceber);
                codcaixas = em.merge(codcaixas);
            }
            Centrocusto codcentrocusto = contareceber.getCodcentrocusto();
            if (codcentrocusto != null) {
                codcentrocusto.getContareceberCollection().remove(contareceber);
                codcentrocusto = em.merge(codcentrocusto);
            }
            Cliente codclivenda = contareceber.getCodclivenda();
            if (codclivenda != null) {
                codclivenda.getContareceberCollection().remove(contareceber);
                codclivenda = em.merge(codclivenda);
            }
            Conhecimentotransporte codconhecimentotransporte = contareceber.getCodconhecimentotransporte();
            if (codconhecimentotransporte != null) {
                codconhecimentotransporte.getContareceberCollection().remove(contareceber);
                codconhecimentotransporte = em.merge(codconhecimentotransporte);
            }
            Contabancaria codcontabancaria = contareceber.getCodcontabancaria();
            if (codcontabancaria != null) {
                codcontabancaria.getContareceberCollection().remove(contareceber);
                codcontabancaria = em.merge(codcontabancaria);
            }
            Contareceberfixa codcrfixa = contareceber.getCodcrfixa();
            if (codcrfixa != null) {
                codcrfixa.getContareceberCollection().remove(contareceber);
                codcrfixa = em.merge(codcrfixa);
            }
            Empresa codempresa = contareceber.getCodempresa();
            if (codempresa != null) {
                codempresa.getContareceberCollection().remove(contareceber);
                codempresa = em.merge(codempresa);
            }
            Planoconta codpc = contareceber.getCodpc();
            if (codpc != null) {
                codpc.getContareceberCollection().remove(contareceber);
                codpc = em.merge(codpc);
            }
            Renegociacao codrenegociacao = contareceber.getCodrenegociacao();
            if (codrenegociacao != null) {
                codrenegociacao.getContareceberCollection().remove(contareceber);
                codrenegociacao = em.merge(codrenegociacao);
            }
            Situacaoadministrativa codsituacaoadministrativa = contareceber.getCodsituacaoadministrativa();
            if (codsituacaoadministrativa != null) {
                codsituacaoadministrativa.getContareceberCollection().remove(contareceber);
                codsituacaoadministrativa = em.merge(codsituacaoadministrativa);
            }
            Collection<Historicocobranca> historicocobrancaCollection = contareceber.getHistoricocobrancaCollection();
            for (Historicocobranca historicocobrancaCollectionHistoricocobranca : historicocobrancaCollection) {
                historicocobrancaCollectionHistoricocobranca.setCodcr(null);
                historicocobrancaCollectionHistoricocobranca = em.merge(historicocobrancaCollectionHistoricocobranca);
            }
            Collection<Recebimentos> recebimentosCollection = contareceber.getRecebimentosCollection();
            for (Recebimentos recebimentosCollectionRecebimentos : recebimentosCollection) {
                recebimentosCollectionRecebimentos.setCodcr(null);
                recebimentosCollectionRecebimentos = em.merge(recebimentosCollectionRecebimentos);
            }
            Collection<Contareceberrec> contareceberrecCollection = contareceber.getContareceberrecCollection();
            for (Contareceberrec contareceberrecCollectionContareceberrec : contareceberrecCollection) {
                contareceberrecCollectionContareceberrec.setCodcr(null);
                contareceberrecCollectionContareceberrec = em.merge(contareceberrecCollectionContareceberrec);
            }
            Collection<Lancacartao> lancacartaoCollection = contareceber.getLancacartaoCollection();
            for (Lancacartao lancacartaoCollectionLancacartao : lancacartaoCollection) {
                lancacartaoCollectionLancacartao.setCodcr(null);
                lancacartaoCollectionLancacartao = em.merge(lancacartaoCollectionLancacartao);
            }
            em.remove(contareceber);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Contareceber> findContareceberEntities() {
        return findContareceberEntities(true, -1, -1);
    }

    public List<Contareceber> findContareceberEntities(int maxResults, int firstResult) {
        return findContareceberEntities(false, maxResults, firstResult);
    }

    private List<Contareceber> findContareceberEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Contareceber.class));
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

    public Contareceber findContareceber(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Contareceber.class, id);
        } finally {
            em.close();
        }
    }

    public int getContareceberCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Contareceber> rt = cq.from(Contareceber.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

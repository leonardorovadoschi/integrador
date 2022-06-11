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
import entidade.cplus.Chequesfirma;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Moventrada;
import entidade.cplus.Caixa;
import entidade.cplus.Manifestacaodestinatario;
import entidade.cplus.Recibo;
import entidade.cplus.Moconvenio;
import entidade.cplus.Empresauf;
import entidade.cplus.Movecfrzitem;
import entidade.cplus.Lancafinanceira;
import entidade.cplus.Documento;
import entidade.cplus.Contapagarpag;
import entidade.cplus.Contapagar;
import entidade.cplus.Contareceberrec;
import entidade.cplus.Produtoestoque;
import entidade.cplus.Atendimento;
import entidade.cplus.Cheques;
import entidade.cplus.Acerto;
import entidade.cplus.Usuario;
import entidade.cplus.Movecfdocumentocaixa;
import entidade.cplus.Contareceber;
import entidade.cplus.Veiculos;
import entidade.cplus.Lancacartao;
import entidade.cplus.Movecfdocumento;
import entidade.cplus.Contratocobranca;
import entidade.cplus.OsOrdemservico;
import entidade.cplus.Produtoestoquelote;
import entidade.cplus.Cotacao;
import entidade.cplus.Orcamento;
import entidade.cplus.Movenda;
import entidade.cplus.Pedido;
import entidade.cplus.Contabancaria;
import entidade.cplus.Orcamentoprod;
import entidade.cplus.AcertoProdlote;
import entidade.cplus.Loteentrega;
import entidade.cplus.AcertoProdfci;
import entidade.cplus.Empresatipodocumento;
import entidade.cplus.Cliente;
import entidade.cplus.Empresa;
import entidade.cplus.Mdfeletronico;
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
public class EmpresaJpaController implements Serializable {

    public EmpresaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empresa empresa) throws PreexistingEntityException, Exception {
        if (empresa.getChequesfirmaCollection() == null) {
            empresa.setChequesfirmaCollection(new ArrayList<Chequesfirma>());
        }
        if (empresa.getMoventradaCollection() == null) {
            empresa.setMoventradaCollection(new ArrayList<Moventrada>());
        }
        if (empresa.getCaixaCollection() == null) {
            empresa.setCaixaCollection(new ArrayList<Caixa>());
        }
        if (empresa.getManifestacaodestinatarioCollection() == null) {
            empresa.setManifestacaodestinatarioCollection(new ArrayList<Manifestacaodestinatario>());
        }
        if (empresa.getReciboCollection() == null) {
            empresa.setReciboCollection(new ArrayList<Recibo>());
        }
        if (empresa.getMoconvenioCollection() == null) {
            empresa.setMoconvenioCollection(new ArrayList<Moconvenio>());
        }
        if (empresa.getEmpresaufCollection() == null) {
            empresa.setEmpresaufCollection(new ArrayList<Empresauf>());
        }
        if (empresa.getMovecfrzitemCollection() == null) {
            empresa.setMovecfrzitemCollection(new ArrayList<Movecfrzitem>());
        }
        if (empresa.getLancafinanceiraCollection() == null) {
            empresa.setLancafinanceiraCollection(new ArrayList<Lancafinanceira>());
        }
        if (empresa.getDocumentoCollection() == null) {
            empresa.setDocumentoCollection(new ArrayList<Documento>());
        }
        if (empresa.getContapagarpagCollection() == null) {
            empresa.setContapagarpagCollection(new ArrayList<Contapagarpag>());
        }
        if (empresa.getContapagarCollection() == null) {
            empresa.setContapagarCollection(new ArrayList<Contapagar>());
        }
        if (empresa.getContareceberrecCollection() == null) {
            empresa.setContareceberrecCollection(new ArrayList<Contareceberrec>());
        }
        if (empresa.getProdutoestoqueCollection() == null) {
            empresa.setProdutoestoqueCollection(new ArrayList<Produtoestoque>());
        }
        if (empresa.getAtendimentoCollection() == null) {
            empresa.setAtendimentoCollection(new ArrayList<Atendimento>());
        }
        if (empresa.getChequesCollection() == null) {
            empresa.setChequesCollection(new ArrayList<Cheques>());
        }
        if (empresa.getAcertoCollection() == null) {
            empresa.setAcertoCollection(new ArrayList<Acerto>());
        }
        if (empresa.getUsuarioCollection() == null) {
            empresa.setUsuarioCollection(new ArrayList<Usuario>());
        }
        if (empresa.getMovecfdocumentocaixaCollection() == null) {
            empresa.setMovecfdocumentocaixaCollection(new ArrayList<Movecfdocumentocaixa>());
        }
        if (empresa.getContareceberCollection() == null) {
            empresa.setContareceberCollection(new ArrayList<Contareceber>());
        }
        if (empresa.getVeiculosCollection() == null) {
            empresa.setVeiculosCollection(new ArrayList<Veiculos>());
        }
        if (empresa.getLancacartaoCollection() == null) {
            empresa.setLancacartaoCollection(new ArrayList<Lancacartao>());
        }
        if (empresa.getMovecfdocumentoCollection() == null) {
            empresa.setMovecfdocumentoCollection(new ArrayList<Movecfdocumento>());
        }
        if (empresa.getContratocobrancaCollection() == null) {
            empresa.setContratocobrancaCollection(new ArrayList<Contratocobranca>());
        }
        if (empresa.getOsOrdemservicoCollection() == null) {
            empresa.setOsOrdemservicoCollection(new ArrayList<OsOrdemservico>());
        }
        if (empresa.getProdutoestoqueloteCollection() == null) {
            empresa.setProdutoestoqueloteCollection(new ArrayList<Produtoestoquelote>());
        }
        if (empresa.getCotacaoCollection() == null) {
            empresa.setCotacaoCollection(new ArrayList<Cotacao>());
        }
        if (empresa.getOrcamentoCollection() == null) {
            empresa.setOrcamentoCollection(new ArrayList<Orcamento>());
        }
        if (empresa.getMovendaCollection() == null) {
            empresa.setMovendaCollection(new ArrayList<Movenda>());
        }
        if (empresa.getPedidoCollection() == null) {
            empresa.setPedidoCollection(new ArrayList<Pedido>());
        }
        if (empresa.getContabancariaCollection() == null) {
            empresa.setContabancariaCollection(new ArrayList<Contabancaria>());
        }
        if (empresa.getOrcamentoprodCollection() == null) {
            empresa.setOrcamentoprodCollection(new ArrayList<Orcamentoprod>());
        }
        if (empresa.getOrcamentoprodCollection1() == null) {
            empresa.setOrcamentoprodCollection1(new ArrayList<Orcamentoprod>());
        }
        if (empresa.getAcertoProdloteCollection() == null) {
            empresa.setAcertoProdloteCollection(new ArrayList<AcertoProdlote>());
        }
        if (empresa.getLoteentregaCollection() == null) {
            empresa.setLoteentregaCollection(new ArrayList<Loteentrega>());
        }
        if (empresa.getAcertoProdfciCollection() == null) {
            empresa.setAcertoProdfciCollection(new ArrayList<AcertoProdfci>());
        }
        if (empresa.getEmpresatipodocumentoCollection() == null) {
            empresa.setEmpresatipodocumentoCollection(new ArrayList<Empresatipodocumento>());
        }
        if (empresa.getClienteCollection() == null) {
            empresa.setClienteCollection(new ArrayList<Cliente>());
        }
        if (empresa.getMdfeletronicoCollection() == null) {
            empresa.setMdfeletronicoCollection(new ArrayList<Mdfeletronico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Chequesfirma> attachedChequesfirmaCollection = new ArrayList<Chequesfirma>();
            for (Chequesfirma chequesfirmaCollectionChequesfirmaToAttach : empresa.getChequesfirmaCollection()) {
                chequesfirmaCollectionChequesfirmaToAttach = em.getReference(chequesfirmaCollectionChequesfirmaToAttach.getClass(), chequesfirmaCollectionChequesfirmaToAttach.getCodchequefirma());
                attachedChequesfirmaCollection.add(chequesfirmaCollectionChequesfirmaToAttach);
            }
            empresa.setChequesfirmaCollection(attachedChequesfirmaCollection);
            Collection<Moventrada> attachedMoventradaCollection = new ArrayList<Moventrada>();
            for (Moventrada moventradaCollectionMoventradaToAttach : empresa.getMoventradaCollection()) {
                moventradaCollectionMoventradaToAttach = em.getReference(moventradaCollectionMoventradaToAttach.getClass(), moventradaCollectionMoventradaToAttach.getCodmoventr());
                attachedMoventradaCollection.add(moventradaCollectionMoventradaToAttach);
            }
            empresa.setMoventradaCollection(attachedMoventradaCollection);
            Collection<Caixa> attachedCaixaCollection = new ArrayList<Caixa>();
            for (Caixa caixaCollectionCaixaToAttach : empresa.getCaixaCollection()) {
                caixaCollectionCaixaToAttach = em.getReference(caixaCollectionCaixaToAttach.getClass(), caixaCollectionCaixaToAttach.getCodcaixa());
                attachedCaixaCollection.add(caixaCollectionCaixaToAttach);
            }
            empresa.setCaixaCollection(attachedCaixaCollection);
            Collection<Manifestacaodestinatario> attachedManifestacaodestinatarioCollection = new ArrayList<Manifestacaodestinatario>();
            for (Manifestacaodestinatario manifestacaodestinatarioCollectionManifestacaodestinatarioToAttach : empresa.getManifestacaodestinatarioCollection()) {
                manifestacaodestinatarioCollectionManifestacaodestinatarioToAttach = em.getReference(manifestacaodestinatarioCollectionManifestacaodestinatarioToAttach.getClass(), manifestacaodestinatarioCollectionManifestacaodestinatarioToAttach.getCodmanifestacaodestinatario());
                attachedManifestacaodestinatarioCollection.add(manifestacaodestinatarioCollectionManifestacaodestinatarioToAttach);
            }
            empresa.setManifestacaodestinatarioCollection(attachedManifestacaodestinatarioCollection);
            Collection<Recibo> attachedReciboCollection = new ArrayList<Recibo>();
            for (Recibo reciboCollectionReciboToAttach : empresa.getReciboCollection()) {
                reciboCollectionReciboToAttach = em.getReference(reciboCollectionReciboToAttach.getClass(), reciboCollectionReciboToAttach.getId());
                attachedReciboCollection.add(reciboCollectionReciboToAttach);
            }
            empresa.setReciboCollection(attachedReciboCollection);
            Collection<Moconvenio> attachedMoconvenioCollection = new ArrayList<Moconvenio>();
            for (Moconvenio moconvenioCollectionMoconvenioToAttach : empresa.getMoconvenioCollection()) {
                moconvenioCollectionMoconvenioToAttach = em.getReference(moconvenioCollectionMoconvenioToAttach.getClass(), moconvenioCollectionMoconvenioToAttach.getCodmoconvenio());
                attachedMoconvenioCollection.add(moconvenioCollectionMoconvenioToAttach);
            }
            empresa.setMoconvenioCollection(attachedMoconvenioCollection);
            Collection<Empresauf> attachedEmpresaufCollection = new ArrayList<Empresauf>();
            for (Empresauf empresaufCollectionEmpresaufToAttach : empresa.getEmpresaufCollection()) {
                empresaufCollectionEmpresaufToAttach = em.getReference(empresaufCollectionEmpresaufToAttach.getClass(), empresaufCollectionEmpresaufToAttach.getCodempresauf());
                attachedEmpresaufCollection.add(empresaufCollectionEmpresaufToAttach);
            }
            empresa.setEmpresaufCollection(attachedEmpresaufCollection);
            Collection<Movecfrzitem> attachedMovecfrzitemCollection = new ArrayList<Movecfrzitem>();
            for (Movecfrzitem movecfrzitemCollectionMovecfrzitemToAttach : empresa.getMovecfrzitemCollection()) {
                movecfrzitemCollectionMovecfrzitemToAttach = em.getReference(movecfrzitemCollectionMovecfrzitemToAttach.getClass(), movecfrzitemCollectionMovecfrzitemToAttach.getCodmovecfrzitem());
                attachedMovecfrzitemCollection.add(movecfrzitemCollectionMovecfrzitemToAttach);
            }
            empresa.setMovecfrzitemCollection(attachedMovecfrzitemCollection);
            Collection<Lancafinanceira> attachedLancafinanceiraCollection = new ArrayList<Lancafinanceira>();
            for (Lancafinanceira lancafinanceiraCollectionLancafinanceiraToAttach : empresa.getLancafinanceiraCollection()) {
                lancafinanceiraCollectionLancafinanceiraToAttach = em.getReference(lancafinanceiraCollectionLancafinanceiraToAttach.getClass(), lancafinanceiraCollectionLancafinanceiraToAttach.getCodlfin());
                attachedLancafinanceiraCollection.add(lancafinanceiraCollectionLancafinanceiraToAttach);
            }
            empresa.setLancafinanceiraCollection(attachedLancafinanceiraCollection);
            Collection<Documento> attachedDocumentoCollection = new ArrayList<Documento>();
            for (Documento documentoCollectionDocumentoToAttach : empresa.getDocumentoCollection()) {
                documentoCollectionDocumentoToAttach = em.getReference(documentoCollectionDocumentoToAttach.getClass(), documentoCollectionDocumentoToAttach.getCoddocumento());
                attachedDocumentoCollection.add(documentoCollectionDocumentoToAttach);
            }
            empresa.setDocumentoCollection(attachedDocumentoCollection);
            Collection<Contapagarpag> attachedContapagarpagCollection = new ArrayList<Contapagarpag>();
            for (Contapagarpag contapagarpagCollectionContapagarpagToAttach : empresa.getContapagarpagCollection()) {
                contapagarpagCollectionContapagarpagToAttach = em.getReference(contapagarpagCollectionContapagarpagToAttach.getClass(), contapagarpagCollectionContapagarpagToAttach.getId());
                attachedContapagarpagCollection.add(contapagarpagCollectionContapagarpagToAttach);
            }
            empresa.setContapagarpagCollection(attachedContapagarpagCollection);
            Collection<Contapagar> attachedContapagarCollection = new ArrayList<Contapagar>();
            for (Contapagar contapagarCollectionContapagarToAttach : empresa.getContapagarCollection()) {
                contapagarCollectionContapagarToAttach = em.getReference(contapagarCollectionContapagarToAttach.getClass(), contapagarCollectionContapagarToAttach.getCodcp());
                attachedContapagarCollection.add(contapagarCollectionContapagarToAttach);
            }
            empresa.setContapagarCollection(attachedContapagarCollection);
            Collection<Contareceberrec> attachedContareceberrecCollection = new ArrayList<Contareceberrec>();
            for (Contareceberrec contareceberrecCollectionContareceberrecToAttach : empresa.getContareceberrecCollection()) {
                contareceberrecCollectionContareceberrecToAttach = em.getReference(contareceberrecCollectionContareceberrecToAttach.getClass(), contareceberrecCollectionContareceberrecToAttach.getId());
                attachedContareceberrecCollection.add(contareceberrecCollectionContareceberrecToAttach);
            }
            empresa.setContareceberrecCollection(attachedContareceberrecCollection);
            Collection<Produtoestoque> attachedProdutoestoqueCollection = new ArrayList<Produtoestoque>();
            for (Produtoestoque produtoestoqueCollectionProdutoestoqueToAttach : empresa.getProdutoestoqueCollection()) {
                produtoestoqueCollectionProdutoestoqueToAttach = em.getReference(produtoestoqueCollectionProdutoestoqueToAttach.getClass(), produtoestoqueCollectionProdutoestoqueToAttach.getProdutoestoquePK());
                attachedProdutoestoqueCollection.add(produtoestoqueCollectionProdutoestoqueToAttach);
            }
            empresa.setProdutoestoqueCollection(attachedProdutoestoqueCollection);
            Collection<Atendimento> attachedAtendimentoCollection = new ArrayList<Atendimento>();
            for (Atendimento atendimentoCollectionAtendimentoToAttach : empresa.getAtendimentoCollection()) {
                atendimentoCollectionAtendimentoToAttach = em.getReference(atendimentoCollectionAtendimentoToAttach.getClass(), atendimentoCollectionAtendimentoToAttach.getCodatend());
                attachedAtendimentoCollection.add(atendimentoCollectionAtendimentoToAttach);
            }
            empresa.setAtendimentoCollection(attachedAtendimentoCollection);
            Collection<Cheques> attachedChequesCollection = new ArrayList<Cheques>();
            for (Cheques chequesCollectionChequesToAttach : empresa.getChequesCollection()) {
                chequesCollectionChequesToAttach = em.getReference(chequesCollectionChequesToAttach.getClass(), chequesCollectionChequesToAttach.getCodcheque());
                attachedChequesCollection.add(chequesCollectionChequesToAttach);
            }
            empresa.setChequesCollection(attachedChequesCollection);
            Collection<Acerto> attachedAcertoCollection = new ArrayList<Acerto>();
            for (Acerto acertoCollectionAcertoToAttach : empresa.getAcertoCollection()) {
                acertoCollectionAcertoToAttach = em.getReference(acertoCollectionAcertoToAttach.getClass(), acertoCollectionAcertoToAttach.getCodacerto());
                attachedAcertoCollection.add(acertoCollectionAcertoToAttach);
            }
            empresa.setAcertoCollection(attachedAcertoCollection);
            Collection<Usuario> attachedUsuarioCollection = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionUsuarioToAttach : empresa.getUsuarioCollection()) {
                usuarioCollectionUsuarioToAttach = em.getReference(usuarioCollectionUsuarioToAttach.getClass(), usuarioCollectionUsuarioToAttach.getCoduser());
                attachedUsuarioCollection.add(usuarioCollectionUsuarioToAttach);
            }
            empresa.setUsuarioCollection(attachedUsuarioCollection);
            Collection<Movecfdocumentocaixa> attachedMovecfdocumentocaixaCollection = new ArrayList<Movecfdocumentocaixa>();
            for (Movecfdocumentocaixa movecfdocumentocaixaCollectionMovecfdocumentocaixaToAttach : empresa.getMovecfdocumentocaixaCollection()) {
                movecfdocumentocaixaCollectionMovecfdocumentocaixaToAttach = em.getReference(movecfdocumentocaixaCollectionMovecfdocumentocaixaToAttach.getClass(), movecfdocumentocaixaCollectionMovecfdocumentocaixaToAttach.getCodmovecfdocumentocaixa());
                attachedMovecfdocumentocaixaCollection.add(movecfdocumentocaixaCollectionMovecfdocumentocaixaToAttach);
            }
            empresa.setMovecfdocumentocaixaCollection(attachedMovecfdocumentocaixaCollection);
            Collection<Contareceber> attachedContareceberCollection = new ArrayList<Contareceber>();
            for (Contareceber contareceberCollectionContareceberToAttach : empresa.getContareceberCollection()) {
                contareceberCollectionContareceberToAttach = em.getReference(contareceberCollectionContareceberToAttach.getClass(), contareceberCollectionContareceberToAttach.getCodcr());
                attachedContareceberCollection.add(contareceberCollectionContareceberToAttach);
            }
            empresa.setContareceberCollection(attachedContareceberCollection);
            Collection<Veiculos> attachedVeiculosCollection = new ArrayList<Veiculos>();
            for (Veiculos veiculosCollectionVeiculosToAttach : empresa.getVeiculosCollection()) {
                veiculosCollectionVeiculosToAttach = em.getReference(veiculosCollectionVeiculosToAttach.getClass(), veiculosCollectionVeiculosToAttach.getCodveiculo());
                attachedVeiculosCollection.add(veiculosCollectionVeiculosToAttach);
            }
            empresa.setVeiculosCollection(attachedVeiculosCollection);
            Collection<Lancacartao> attachedLancacartaoCollection = new ArrayList<Lancacartao>();
            for (Lancacartao lancacartaoCollectionLancacartaoToAttach : empresa.getLancacartaoCollection()) {
                lancacartaoCollectionLancacartaoToAttach = em.getReference(lancacartaoCollectionLancacartaoToAttach.getClass(), lancacartaoCollectionLancacartaoToAttach.getCodlcar());
                attachedLancacartaoCollection.add(lancacartaoCollectionLancacartaoToAttach);
            }
            empresa.setLancacartaoCollection(attachedLancacartaoCollection);
            Collection<Movecfdocumento> attachedMovecfdocumentoCollection = new ArrayList<Movecfdocumento>();
            for (Movecfdocumento movecfdocumentoCollectionMovecfdocumentoToAttach : empresa.getMovecfdocumentoCollection()) {
                movecfdocumentoCollectionMovecfdocumentoToAttach = em.getReference(movecfdocumentoCollectionMovecfdocumentoToAttach.getClass(), movecfdocumentoCollectionMovecfdocumentoToAttach.getCodmovecfdocumento());
                attachedMovecfdocumentoCollection.add(movecfdocumentoCollectionMovecfdocumentoToAttach);
            }
            empresa.setMovecfdocumentoCollection(attachedMovecfdocumentoCollection);
            Collection<Contratocobranca> attachedContratocobrancaCollection = new ArrayList<Contratocobranca>();
            for (Contratocobranca contratocobrancaCollectionContratocobrancaToAttach : empresa.getContratocobrancaCollection()) {
                contratocobrancaCollectionContratocobrancaToAttach = em.getReference(contratocobrancaCollectionContratocobrancaToAttach.getClass(), contratocobrancaCollectionContratocobrancaToAttach.getCodcontratocobranca());
                attachedContratocobrancaCollection.add(contratocobrancaCollectionContratocobrancaToAttach);
            }
            empresa.setContratocobrancaCollection(attachedContratocobrancaCollection);
            Collection<OsOrdemservico> attachedOsOrdemservicoCollection = new ArrayList<OsOrdemservico>();
            for (OsOrdemservico osOrdemservicoCollectionOsOrdemservicoToAttach : empresa.getOsOrdemservicoCollection()) {
                osOrdemservicoCollectionOsOrdemservicoToAttach = em.getReference(osOrdemservicoCollectionOsOrdemservicoToAttach.getClass(), osOrdemservicoCollectionOsOrdemservicoToAttach.getCodos());
                attachedOsOrdemservicoCollection.add(osOrdemservicoCollectionOsOrdemservicoToAttach);
            }
            empresa.setOsOrdemservicoCollection(attachedOsOrdemservicoCollection);
            Collection<Produtoestoquelote> attachedProdutoestoqueloteCollection = new ArrayList<Produtoestoquelote>();
            for (Produtoestoquelote produtoestoqueloteCollectionProdutoestoqueloteToAttach : empresa.getProdutoestoqueloteCollection()) {
                produtoestoqueloteCollectionProdutoestoqueloteToAttach = em.getReference(produtoestoqueloteCollectionProdutoestoqueloteToAttach.getClass(), produtoestoqueloteCollectionProdutoestoqueloteToAttach.getCodprodutoestoquelote());
                attachedProdutoestoqueloteCollection.add(produtoestoqueloteCollectionProdutoestoqueloteToAttach);
            }
            empresa.setProdutoestoqueloteCollection(attachedProdutoestoqueloteCollection);
            Collection<Cotacao> attachedCotacaoCollection = new ArrayList<Cotacao>();
            for (Cotacao cotacaoCollectionCotacaoToAttach : empresa.getCotacaoCollection()) {
                cotacaoCollectionCotacaoToAttach = em.getReference(cotacaoCollectionCotacaoToAttach.getClass(), cotacaoCollectionCotacaoToAttach.getCodcotacao());
                attachedCotacaoCollection.add(cotacaoCollectionCotacaoToAttach);
            }
            empresa.setCotacaoCollection(attachedCotacaoCollection);
            Collection<Orcamento> attachedOrcamentoCollection = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollectionOrcamentoToAttach : empresa.getOrcamentoCollection()) {
                orcamentoCollectionOrcamentoToAttach = em.getReference(orcamentoCollectionOrcamentoToAttach.getClass(), orcamentoCollectionOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollection.add(orcamentoCollectionOrcamentoToAttach);
            }
            empresa.setOrcamentoCollection(attachedOrcamentoCollection);
            Collection<Movenda> attachedMovendaCollection = new ArrayList<Movenda>();
            for (Movenda movendaCollectionMovendaToAttach : empresa.getMovendaCollection()) {
                movendaCollectionMovendaToAttach = em.getReference(movendaCollectionMovendaToAttach.getClass(), movendaCollectionMovendaToAttach.getCodmovenda());
                attachedMovendaCollection.add(movendaCollectionMovendaToAttach);
            }
            empresa.setMovendaCollection(attachedMovendaCollection);
            Collection<Pedido> attachedPedidoCollection = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionPedidoToAttach : empresa.getPedidoCollection()) {
                pedidoCollectionPedidoToAttach = em.getReference(pedidoCollectionPedidoToAttach.getClass(), pedidoCollectionPedidoToAttach.getCodped());
                attachedPedidoCollection.add(pedidoCollectionPedidoToAttach);
            }
            empresa.setPedidoCollection(attachedPedidoCollection);
            Collection<Contabancaria> attachedContabancariaCollection = new ArrayList<Contabancaria>();
            for (Contabancaria contabancariaCollectionContabancariaToAttach : empresa.getContabancariaCollection()) {
                contabancariaCollectionContabancariaToAttach = em.getReference(contabancariaCollectionContabancariaToAttach.getClass(), contabancariaCollectionContabancariaToAttach.getCodcontabancaria());
                attachedContabancariaCollection.add(contabancariaCollectionContabancariaToAttach);
            }
            empresa.setContabancariaCollection(attachedContabancariaCollection);
            Collection<Orcamentoprod> attachedOrcamentoprodCollection = new ArrayList<Orcamentoprod>();
            for (Orcamentoprod orcamentoprodCollectionOrcamentoprodToAttach : empresa.getOrcamentoprodCollection()) {
                orcamentoprodCollectionOrcamentoprodToAttach = em.getReference(orcamentoprodCollectionOrcamentoprodToAttach.getClass(), orcamentoprodCollectionOrcamentoprodToAttach.getCodorcprod());
                attachedOrcamentoprodCollection.add(orcamentoprodCollectionOrcamentoprodToAttach);
            }
            empresa.setOrcamentoprodCollection(attachedOrcamentoprodCollection);
            Collection<Orcamentoprod> attachedOrcamentoprodCollection1 = new ArrayList<Orcamentoprod>();
            for (Orcamentoprod orcamentoprodCollection1OrcamentoprodToAttach : empresa.getOrcamentoprodCollection1()) {
                orcamentoprodCollection1OrcamentoprodToAttach = em.getReference(orcamentoprodCollection1OrcamentoprodToAttach.getClass(), orcamentoprodCollection1OrcamentoprodToAttach.getCodorcprod());
                attachedOrcamentoprodCollection1.add(orcamentoprodCollection1OrcamentoprodToAttach);
            }
            empresa.setOrcamentoprodCollection1(attachedOrcamentoprodCollection1);
            Collection<AcertoProdlote> attachedAcertoProdloteCollection = new ArrayList<AcertoProdlote>();
            for (AcertoProdlote acertoProdloteCollectionAcertoProdloteToAttach : empresa.getAcertoProdloteCollection()) {
                acertoProdloteCollectionAcertoProdloteToAttach = em.getReference(acertoProdloteCollectionAcertoProdloteToAttach.getClass(), acertoProdloteCollectionAcertoProdloteToAttach.getCodacertoProdlote());
                attachedAcertoProdloteCollection.add(acertoProdloteCollectionAcertoProdloteToAttach);
            }
            empresa.setAcertoProdloteCollection(attachedAcertoProdloteCollection);
            Collection<Loteentrega> attachedLoteentregaCollection = new ArrayList<Loteentrega>();
            for (Loteentrega loteentregaCollectionLoteentregaToAttach : empresa.getLoteentregaCollection()) {
                loteentregaCollectionLoteentregaToAttach = em.getReference(loteentregaCollectionLoteentregaToAttach.getClass(), loteentregaCollectionLoteentregaToAttach.getCodloteentrega());
                attachedLoteentregaCollection.add(loteentregaCollectionLoteentregaToAttach);
            }
            empresa.setLoteentregaCollection(attachedLoteentregaCollection);
            Collection<AcertoProdfci> attachedAcertoProdfciCollection = new ArrayList<AcertoProdfci>();
            for (AcertoProdfci acertoProdfciCollectionAcertoProdfciToAttach : empresa.getAcertoProdfciCollection()) {
                acertoProdfciCollectionAcertoProdfciToAttach = em.getReference(acertoProdfciCollectionAcertoProdfciToAttach.getClass(), acertoProdfciCollectionAcertoProdfciToAttach.getCodacertoProdfci());
                attachedAcertoProdfciCollection.add(acertoProdfciCollectionAcertoProdfciToAttach);
            }
            empresa.setAcertoProdfciCollection(attachedAcertoProdfciCollection);
            Collection<Empresatipodocumento> attachedEmpresatipodocumentoCollection = new ArrayList<Empresatipodocumento>();
            for (Empresatipodocumento empresatipodocumentoCollectionEmpresatipodocumentoToAttach : empresa.getEmpresatipodocumentoCollection()) {
                empresatipodocumentoCollectionEmpresatipodocumentoToAttach = em.getReference(empresatipodocumentoCollectionEmpresatipodocumentoToAttach.getClass(), empresatipodocumentoCollectionEmpresatipodocumentoToAttach.getCodempresatipodocumento());
                attachedEmpresatipodocumentoCollection.add(empresatipodocumentoCollectionEmpresatipodocumentoToAttach);
            }
            empresa.setEmpresatipodocumentoCollection(attachedEmpresatipodocumentoCollection);
            Collection<Cliente> attachedClienteCollection = new ArrayList<Cliente>();
            for (Cliente clienteCollectionClienteToAttach : empresa.getClienteCollection()) {
                clienteCollectionClienteToAttach = em.getReference(clienteCollectionClienteToAttach.getClass(), clienteCollectionClienteToAttach.getCodcli());
                attachedClienteCollection.add(clienteCollectionClienteToAttach);
            }
            empresa.setClienteCollection(attachedClienteCollection);
            Collection<Mdfeletronico> attachedMdfeletronicoCollection = new ArrayList<Mdfeletronico>();
            for (Mdfeletronico mdfeletronicoCollectionMdfeletronicoToAttach : empresa.getMdfeletronicoCollection()) {
                mdfeletronicoCollectionMdfeletronicoToAttach = em.getReference(mdfeletronicoCollectionMdfeletronicoToAttach.getClass(), mdfeletronicoCollectionMdfeletronicoToAttach.getCodmdfeletronico());
                attachedMdfeletronicoCollection.add(mdfeletronicoCollectionMdfeletronicoToAttach);
            }
            empresa.setMdfeletronicoCollection(attachedMdfeletronicoCollection);
            em.persist(empresa);
            for (Chequesfirma chequesfirmaCollectionChequesfirma : empresa.getChequesfirmaCollection()) {
                Empresa oldCodempresaOfChequesfirmaCollectionChequesfirma = chequesfirmaCollectionChequesfirma.getCodempresa();
                chequesfirmaCollectionChequesfirma.setCodempresa(empresa);
                chequesfirmaCollectionChequesfirma = em.merge(chequesfirmaCollectionChequesfirma);
                if (oldCodempresaOfChequesfirmaCollectionChequesfirma != null) {
                    oldCodempresaOfChequesfirmaCollectionChequesfirma.getChequesfirmaCollection().remove(chequesfirmaCollectionChequesfirma);
                    oldCodempresaOfChequesfirmaCollectionChequesfirma = em.merge(oldCodempresaOfChequesfirmaCollectionChequesfirma);
                }
            }
            for (Moventrada moventradaCollectionMoventrada : empresa.getMoventradaCollection()) {
                Empresa oldCodempresaOfMoventradaCollectionMoventrada = moventradaCollectionMoventrada.getCodempresa();
                moventradaCollectionMoventrada.setCodempresa(empresa);
                moventradaCollectionMoventrada = em.merge(moventradaCollectionMoventrada);
                if (oldCodempresaOfMoventradaCollectionMoventrada != null) {
                    oldCodempresaOfMoventradaCollectionMoventrada.getMoventradaCollection().remove(moventradaCollectionMoventrada);
                    oldCodempresaOfMoventradaCollectionMoventrada = em.merge(oldCodempresaOfMoventradaCollectionMoventrada);
                }
            }
            for (Caixa caixaCollectionCaixa : empresa.getCaixaCollection()) {
                Empresa oldCodempresaOfCaixaCollectionCaixa = caixaCollectionCaixa.getCodempresa();
                caixaCollectionCaixa.setCodempresa(empresa);
                caixaCollectionCaixa = em.merge(caixaCollectionCaixa);
                if (oldCodempresaOfCaixaCollectionCaixa != null) {
                    oldCodempresaOfCaixaCollectionCaixa.getCaixaCollection().remove(caixaCollectionCaixa);
                    oldCodempresaOfCaixaCollectionCaixa = em.merge(oldCodempresaOfCaixaCollectionCaixa);
                }
            }
            for (Manifestacaodestinatario manifestacaodestinatarioCollectionManifestacaodestinatario : empresa.getManifestacaodestinatarioCollection()) {
                Empresa oldCodempresaOfManifestacaodestinatarioCollectionManifestacaodestinatario = manifestacaodestinatarioCollectionManifestacaodestinatario.getCodempresa();
                manifestacaodestinatarioCollectionManifestacaodestinatario.setCodempresa(empresa);
                manifestacaodestinatarioCollectionManifestacaodestinatario = em.merge(manifestacaodestinatarioCollectionManifestacaodestinatario);
                if (oldCodempresaOfManifestacaodestinatarioCollectionManifestacaodestinatario != null) {
                    oldCodempresaOfManifestacaodestinatarioCollectionManifestacaodestinatario.getManifestacaodestinatarioCollection().remove(manifestacaodestinatarioCollectionManifestacaodestinatario);
                    oldCodempresaOfManifestacaodestinatarioCollectionManifestacaodestinatario = em.merge(oldCodempresaOfManifestacaodestinatarioCollectionManifestacaodestinatario);
                }
            }
            for (Recibo reciboCollectionRecibo : empresa.getReciboCollection()) {
                Empresa oldCodempresaOfReciboCollectionRecibo = reciboCollectionRecibo.getCodempresa();
                reciboCollectionRecibo.setCodempresa(empresa);
                reciboCollectionRecibo = em.merge(reciboCollectionRecibo);
                if (oldCodempresaOfReciboCollectionRecibo != null) {
                    oldCodempresaOfReciboCollectionRecibo.getReciboCollection().remove(reciboCollectionRecibo);
                    oldCodempresaOfReciboCollectionRecibo = em.merge(oldCodempresaOfReciboCollectionRecibo);
                }
            }
            for (Moconvenio moconvenioCollectionMoconvenio : empresa.getMoconvenioCollection()) {
                Empresa oldCodempresaOfMoconvenioCollectionMoconvenio = moconvenioCollectionMoconvenio.getCodempresa();
                moconvenioCollectionMoconvenio.setCodempresa(empresa);
                moconvenioCollectionMoconvenio = em.merge(moconvenioCollectionMoconvenio);
                if (oldCodempresaOfMoconvenioCollectionMoconvenio != null) {
                    oldCodempresaOfMoconvenioCollectionMoconvenio.getMoconvenioCollection().remove(moconvenioCollectionMoconvenio);
                    oldCodempresaOfMoconvenioCollectionMoconvenio = em.merge(oldCodempresaOfMoconvenioCollectionMoconvenio);
                }
            }
            for (Empresauf empresaufCollectionEmpresauf : empresa.getEmpresaufCollection()) {
                Empresa oldCodempresaOfEmpresaufCollectionEmpresauf = empresaufCollectionEmpresauf.getCodempresa();
                empresaufCollectionEmpresauf.setCodempresa(empresa);
                empresaufCollectionEmpresauf = em.merge(empresaufCollectionEmpresauf);
                if (oldCodempresaOfEmpresaufCollectionEmpresauf != null) {
                    oldCodempresaOfEmpresaufCollectionEmpresauf.getEmpresaufCollection().remove(empresaufCollectionEmpresauf);
                    oldCodempresaOfEmpresaufCollectionEmpresauf = em.merge(oldCodempresaOfEmpresaufCollectionEmpresauf);
                }
            }
            for (Movecfrzitem movecfrzitemCollectionMovecfrzitem : empresa.getMovecfrzitemCollection()) {
                Empresa oldCodempresaOfMovecfrzitemCollectionMovecfrzitem = movecfrzitemCollectionMovecfrzitem.getCodempresa();
                movecfrzitemCollectionMovecfrzitem.setCodempresa(empresa);
                movecfrzitemCollectionMovecfrzitem = em.merge(movecfrzitemCollectionMovecfrzitem);
                if (oldCodempresaOfMovecfrzitemCollectionMovecfrzitem != null) {
                    oldCodempresaOfMovecfrzitemCollectionMovecfrzitem.getMovecfrzitemCollection().remove(movecfrzitemCollectionMovecfrzitem);
                    oldCodempresaOfMovecfrzitemCollectionMovecfrzitem = em.merge(oldCodempresaOfMovecfrzitemCollectionMovecfrzitem);
                }
            }
            for (Lancafinanceira lancafinanceiraCollectionLancafinanceira : empresa.getLancafinanceiraCollection()) {
                Empresa oldCodempresaOfLancafinanceiraCollectionLancafinanceira = lancafinanceiraCollectionLancafinanceira.getCodempresa();
                lancafinanceiraCollectionLancafinanceira.setCodempresa(empresa);
                lancafinanceiraCollectionLancafinanceira = em.merge(lancafinanceiraCollectionLancafinanceira);
                if (oldCodempresaOfLancafinanceiraCollectionLancafinanceira != null) {
                    oldCodempresaOfLancafinanceiraCollectionLancafinanceira.getLancafinanceiraCollection().remove(lancafinanceiraCollectionLancafinanceira);
                    oldCodempresaOfLancafinanceiraCollectionLancafinanceira = em.merge(oldCodempresaOfLancafinanceiraCollectionLancafinanceira);
                }
            }
            for (Documento documentoCollectionDocumento : empresa.getDocumentoCollection()) {
                Empresa oldCodempresaOfDocumentoCollectionDocumento = documentoCollectionDocumento.getCodempresa();
                documentoCollectionDocumento.setCodempresa(empresa);
                documentoCollectionDocumento = em.merge(documentoCollectionDocumento);
                if (oldCodempresaOfDocumentoCollectionDocumento != null) {
                    oldCodempresaOfDocumentoCollectionDocumento.getDocumentoCollection().remove(documentoCollectionDocumento);
                    oldCodempresaOfDocumentoCollectionDocumento = em.merge(oldCodempresaOfDocumentoCollectionDocumento);
                }
            }
            for (Contapagarpag contapagarpagCollectionContapagarpag : empresa.getContapagarpagCollection()) {
                Empresa oldCodempresaOfContapagarpagCollectionContapagarpag = contapagarpagCollectionContapagarpag.getCodempresa();
                contapagarpagCollectionContapagarpag.setCodempresa(empresa);
                contapagarpagCollectionContapagarpag = em.merge(contapagarpagCollectionContapagarpag);
                if (oldCodempresaOfContapagarpagCollectionContapagarpag != null) {
                    oldCodempresaOfContapagarpagCollectionContapagarpag.getContapagarpagCollection().remove(contapagarpagCollectionContapagarpag);
                    oldCodempresaOfContapagarpagCollectionContapagarpag = em.merge(oldCodempresaOfContapagarpagCollectionContapagarpag);
                }
            }
            for (Contapagar contapagarCollectionContapagar : empresa.getContapagarCollection()) {
                Empresa oldCodempresaOfContapagarCollectionContapagar = contapagarCollectionContapagar.getCodempresa();
                contapagarCollectionContapagar.setCodempresa(empresa);
                contapagarCollectionContapagar = em.merge(contapagarCollectionContapagar);
                if (oldCodempresaOfContapagarCollectionContapagar != null) {
                    oldCodempresaOfContapagarCollectionContapagar.getContapagarCollection().remove(contapagarCollectionContapagar);
                    oldCodempresaOfContapagarCollectionContapagar = em.merge(oldCodempresaOfContapagarCollectionContapagar);
                }
            }
            for (Contareceberrec contareceberrecCollectionContareceberrec : empresa.getContareceberrecCollection()) {
                Empresa oldCodempresaOfContareceberrecCollectionContareceberrec = contareceberrecCollectionContareceberrec.getCodempresa();
                contareceberrecCollectionContareceberrec.setCodempresa(empresa);
                contareceberrecCollectionContareceberrec = em.merge(contareceberrecCollectionContareceberrec);
                if (oldCodempresaOfContareceberrecCollectionContareceberrec != null) {
                    oldCodempresaOfContareceberrecCollectionContareceberrec.getContareceberrecCollection().remove(contareceberrecCollectionContareceberrec);
                    oldCodempresaOfContareceberrecCollectionContareceberrec = em.merge(oldCodempresaOfContareceberrecCollectionContareceberrec);
                }
            }
            for (Produtoestoque produtoestoqueCollectionProdutoestoque : empresa.getProdutoestoqueCollection()) {
                Empresa oldEmpresaOfProdutoestoqueCollectionProdutoestoque = produtoestoqueCollectionProdutoestoque.getEmpresa();
                produtoestoqueCollectionProdutoestoque.setEmpresa(empresa);
                produtoestoqueCollectionProdutoestoque = em.merge(produtoestoqueCollectionProdutoestoque);
                if (oldEmpresaOfProdutoestoqueCollectionProdutoestoque != null) {
                    oldEmpresaOfProdutoestoqueCollectionProdutoestoque.getProdutoestoqueCollection().remove(produtoestoqueCollectionProdutoestoque);
                    oldEmpresaOfProdutoestoqueCollectionProdutoestoque = em.merge(oldEmpresaOfProdutoestoqueCollectionProdutoestoque);
                }
            }
            for (Atendimento atendimentoCollectionAtendimento : empresa.getAtendimentoCollection()) {
                Empresa oldCodempresaOfAtendimentoCollectionAtendimento = atendimentoCollectionAtendimento.getCodempresa();
                atendimentoCollectionAtendimento.setCodempresa(empresa);
                atendimentoCollectionAtendimento = em.merge(atendimentoCollectionAtendimento);
                if (oldCodempresaOfAtendimentoCollectionAtendimento != null) {
                    oldCodempresaOfAtendimentoCollectionAtendimento.getAtendimentoCollection().remove(atendimentoCollectionAtendimento);
                    oldCodempresaOfAtendimentoCollectionAtendimento = em.merge(oldCodempresaOfAtendimentoCollectionAtendimento);
                }
            }
            for (Cheques chequesCollectionCheques : empresa.getChequesCollection()) {
                Empresa oldCodempresaOfChequesCollectionCheques = chequesCollectionCheques.getCodempresa();
                chequesCollectionCheques.setCodempresa(empresa);
                chequesCollectionCheques = em.merge(chequesCollectionCheques);
                if (oldCodempresaOfChequesCollectionCheques != null) {
                    oldCodempresaOfChequesCollectionCheques.getChequesCollection().remove(chequesCollectionCheques);
                    oldCodempresaOfChequesCollectionCheques = em.merge(oldCodempresaOfChequesCollectionCheques);
                }
            }
            for (Acerto acertoCollectionAcerto : empresa.getAcertoCollection()) {
                Empresa oldCodempresaOfAcertoCollectionAcerto = acertoCollectionAcerto.getCodempresa();
                acertoCollectionAcerto.setCodempresa(empresa);
                acertoCollectionAcerto = em.merge(acertoCollectionAcerto);
                if (oldCodempresaOfAcertoCollectionAcerto != null) {
                    oldCodempresaOfAcertoCollectionAcerto.getAcertoCollection().remove(acertoCollectionAcerto);
                    oldCodempresaOfAcertoCollectionAcerto = em.merge(oldCodempresaOfAcertoCollectionAcerto);
                }
            }
            for (Usuario usuarioCollectionUsuario : empresa.getUsuarioCollection()) {
                Empresa oldCodempresaOfUsuarioCollectionUsuario = usuarioCollectionUsuario.getCodempresa();
                usuarioCollectionUsuario.setCodempresa(empresa);
                usuarioCollectionUsuario = em.merge(usuarioCollectionUsuario);
                if (oldCodempresaOfUsuarioCollectionUsuario != null) {
                    oldCodempresaOfUsuarioCollectionUsuario.getUsuarioCollection().remove(usuarioCollectionUsuario);
                    oldCodempresaOfUsuarioCollectionUsuario = em.merge(oldCodempresaOfUsuarioCollectionUsuario);
                }
            }
            for (Movecfdocumentocaixa movecfdocumentocaixaCollectionMovecfdocumentocaixa : empresa.getMovecfdocumentocaixaCollection()) {
                Empresa oldCodempresaOfMovecfdocumentocaixaCollectionMovecfdocumentocaixa = movecfdocumentocaixaCollectionMovecfdocumentocaixa.getCodempresa();
                movecfdocumentocaixaCollectionMovecfdocumentocaixa.setCodempresa(empresa);
                movecfdocumentocaixaCollectionMovecfdocumentocaixa = em.merge(movecfdocumentocaixaCollectionMovecfdocumentocaixa);
                if (oldCodempresaOfMovecfdocumentocaixaCollectionMovecfdocumentocaixa != null) {
                    oldCodempresaOfMovecfdocumentocaixaCollectionMovecfdocumentocaixa.getMovecfdocumentocaixaCollection().remove(movecfdocumentocaixaCollectionMovecfdocumentocaixa);
                    oldCodempresaOfMovecfdocumentocaixaCollectionMovecfdocumentocaixa = em.merge(oldCodempresaOfMovecfdocumentocaixaCollectionMovecfdocumentocaixa);
                }
            }
            for (Contareceber contareceberCollectionContareceber : empresa.getContareceberCollection()) {
                Empresa oldCodempresaOfContareceberCollectionContareceber = contareceberCollectionContareceber.getCodempresa();
                contareceberCollectionContareceber.setCodempresa(empresa);
                contareceberCollectionContareceber = em.merge(contareceberCollectionContareceber);
                if (oldCodempresaOfContareceberCollectionContareceber != null) {
                    oldCodempresaOfContareceberCollectionContareceber.getContareceberCollection().remove(contareceberCollectionContareceber);
                    oldCodempresaOfContareceberCollectionContareceber = em.merge(oldCodempresaOfContareceberCollectionContareceber);
                }
            }
            for (Veiculos veiculosCollectionVeiculos : empresa.getVeiculosCollection()) {
                Empresa oldCodempresaOfVeiculosCollectionVeiculos = veiculosCollectionVeiculos.getCodempresa();
                veiculosCollectionVeiculos.setCodempresa(empresa);
                veiculosCollectionVeiculos = em.merge(veiculosCollectionVeiculos);
                if (oldCodempresaOfVeiculosCollectionVeiculos != null) {
                    oldCodempresaOfVeiculosCollectionVeiculos.getVeiculosCollection().remove(veiculosCollectionVeiculos);
                    oldCodempresaOfVeiculosCollectionVeiculos = em.merge(oldCodempresaOfVeiculosCollectionVeiculos);
                }
            }
            for (Lancacartao lancacartaoCollectionLancacartao : empresa.getLancacartaoCollection()) {
                Empresa oldCodempresaOfLancacartaoCollectionLancacartao = lancacartaoCollectionLancacartao.getCodempresa();
                lancacartaoCollectionLancacartao.setCodempresa(empresa);
                lancacartaoCollectionLancacartao = em.merge(lancacartaoCollectionLancacartao);
                if (oldCodempresaOfLancacartaoCollectionLancacartao != null) {
                    oldCodempresaOfLancacartaoCollectionLancacartao.getLancacartaoCollection().remove(lancacartaoCollectionLancacartao);
                    oldCodempresaOfLancacartaoCollectionLancacartao = em.merge(oldCodempresaOfLancacartaoCollectionLancacartao);
                }
            }
            for (Movecfdocumento movecfdocumentoCollectionMovecfdocumento : empresa.getMovecfdocumentoCollection()) {
                Empresa oldCodempresaOfMovecfdocumentoCollectionMovecfdocumento = movecfdocumentoCollectionMovecfdocumento.getCodempresa();
                movecfdocumentoCollectionMovecfdocumento.setCodempresa(empresa);
                movecfdocumentoCollectionMovecfdocumento = em.merge(movecfdocumentoCollectionMovecfdocumento);
                if (oldCodempresaOfMovecfdocumentoCollectionMovecfdocumento != null) {
                    oldCodempresaOfMovecfdocumentoCollectionMovecfdocumento.getMovecfdocumentoCollection().remove(movecfdocumentoCollectionMovecfdocumento);
                    oldCodempresaOfMovecfdocumentoCollectionMovecfdocumento = em.merge(oldCodempresaOfMovecfdocumentoCollectionMovecfdocumento);
                }
            }
            for (Contratocobranca contratocobrancaCollectionContratocobranca : empresa.getContratocobrancaCollection()) {
                Empresa oldCodempresaOfContratocobrancaCollectionContratocobranca = contratocobrancaCollectionContratocobranca.getCodempresa();
                contratocobrancaCollectionContratocobranca.setCodempresa(empresa);
                contratocobrancaCollectionContratocobranca = em.merge(contratocobrancaCollectionContratocobranca);
                if (oldCodempresaOfContratocobrancaCollectionContratocobranca != null) {
                    oldCodempresaOfContratocobrancaCollectionContratocobranca.getContratocobrancaCollection().remove(contratocobrancaCollectionContratocobranca);
                    oldCodempresaOfContratocobrancaCollectionContratocobranca = em.merge(oldCodempresaOfContratocobrancaCollectionContratocobranca);
                }
            }
            for (OsOrdemservico osOrdemservicoCollectionOsOrdemservico : empresa.getOsOrdemservicoCollection()) {
                Empresa oldCodempresaOfOsOrdemservicoCollectionOsOrdemservico = osOrdemservicoCollectionOsOrdemservico.getCodempresa();
                osOrdemservicoCollectionOsOrdemservico.setCodempresa(empresa);
                osOrdemservicoCollectionOsOrdemservico = em.merge(osOrdemservicoCollectionOsOrdemservico);
                if (oldCodempresaOfOsOrdemservicoCollectionOsOrdemservico != null) {
                    oldCodempresaOfOsOrdemservicoCollectionOsOrdemservico.getOsOrdemservicoCollection().remove(osOrdemservicoCollectionOsOrdemservico);
                    oldCodempresaOfOsOrdemservicoCollectionOsOrdemservico = em.merge(oldCodempresaOfOsOrdemservicoCollectionOsOrdemservico);
                }
            }
            for (Produtoestoquelote produtoestoqueloteCollectionProdutoestoquelote : empresa.getProdutoestoqueloteCollection()) {
                Empresa oldCodempresaOfProdutoestoqueloteCollectionProdutoestoquelote = produtoestoqueloteCollectionProdutoestoquelote.getCodempresa();
                produtoestoqueloteCollectionProdutoestoquelote.setCodempresa(empresa);
                produtoestoqueloteCollectionProdutoestoquelote = em.merge(produtoestoqueloteCollectionProdutoestoquelote);
                if (oldCodempresaOfProdutoestoqueloteCollectionProdutoestoquelote != null) {
                    oldCodempresaOfProdutoestoqueloteCollectionProdutoestoquelote.getProdutoestoqueloteCollection().remove(produtoestoqueloteCollectionProdutoestoquelote);
                    oldCodempresaOfProdutoestoqueloteCollectionProdutoestoquelote = em.merge(oldCodempresaOfProdutoestoqueloteCollectionProdutoestoquelote);
                }
            }
            for (Cotacao cotacaoCollectionCotacao : empresa.getCotacaoCollection()) {
                Empresa oldCodempresaOfCotacaoCollectionCotacao = cotacaoCollectionCotacao.getCodempresa();
                cotacaoCollectionCotacao.setCodempresa(empresa);
                cotacaoCollectionCotacao = em.merge(cotacaoCollectionCotacao);
                if (oldCodempresaOfCotacaoCollectionCotacao != null) {
                    oldCodempresaOfCotacaoCollectionCotacao.getCotacaoCollection().remove(cotacaoCollectionCotacao);
                    oldCodempresaOfCotacaoCollectionCotacao = em.merge(oldCodempresaOfCotacaoCollectionCotacao);
                }
            }
            for (Orcamento orcamentoCollectionOrcamento : empresa.getOrcamentoCollection()) {
                Empresa oldCodempresaOfOrcamentoCollectionOrcamento = orcamentoCollectionOrcamento.getCodempresa();
                orcamentoCollectionOrcamento.setCodempresa(empresa);
                orcamentoCollectionOrcamento = em.merge(orcamentoCollectionOrcamento);
                if (oldCodempresaOfOrcamentoCollectionOrcamento != null) {
                    oldCodempresaOfOrcamentoCollectionOrcamento.getOrcamentoCollection().remove(orcamentoCollectionOrcamento);
                    oldCodempresaOfOrcamentoCollectionOrcamento = em.merge(oldCodempresaOfOrcamentoCollectionOrcamento);
                }
            }
            for (Movenda movendaCollectionMovenda : empresa.getMovendaCollection()) {
                Empresa oldCodempresaOfMovendaCollectionMovenda = movendaCollectionMovenda.getCodempresa();
                movendaCollectionMovenda.setCodempresa(empresa);
                movendaCollectionMovenda = em.merge(movendaCollectionMovenda);
                if (oldCodempresaOfMovendaCollectionMovenda != null) {
                    oldCodempresaOfMovendaCollectionMovenda.getMovendaCollection().remove(movendaCollectionMovenda);
                    oldCodempresaOfMovendaCollectionMovenda = em.merge(oldCodempresaOfMovendaCollectionMovenda);
                }
            }
            for (Pedido pedidoCollectionPedido : empresa.getPedidoCollection()) {
                Empresa oldCodempresaOfPedidoCollectionPedido = pedidoCollectionPedido.getCodempresa();
                pedidoCollectionPedido.setCodempresa(empresa);
                pedidoCollectionPedido = em.merge(pedidoCollectionPedido);
                if (oldCodempresaOfPedidoCollectionPedido != null) {
                    oldCodempresaOfPedidoCollectionPedido.getPedidoCollection().remove(pedidoCollectionPedido);
                    oldCodempresaOfPedidoCollectionPedido = em.merge(oldCodempresaOfPedidoCollectionPedido);
                }
            }
            for (Contabancaria contabancariaCollectionContabancaria : empresa.getContabancariaCollection()) {
                Empresa oldCodempresaOfContabancariaCollectionContabancaria = contabancariaCollectionContabancaria.getCodempresa();
                contabancariaCollectionContabancaria.setCodempresa(empresa);
                contabancariaCollectionContabancaria = em.merge(contabancariaCollectionContabancaria);
                if (oldCodempresaOfContabancariaCollectionContabancaria != null) {
                    oldCodempresaOfContabancariaCollectionContabancaria.getContabancariaCollection().remove(contabancariaCollectionContabancaria);
                    oldCodempresaOfContabancariaCollectionContabancaria = em.merge(oldCodempresaOfContabancariaCollectionContabancaria);
                }
            }
            for (Orcamentoprod orcamentoprodCollectionOrcamentoprod : empresa.getOrcamentoprodCollection()) {
                Empresa oldCodempresaOfOrcamentoprodCollectionOrcamentoprod = orcamentoprodCollectionOrcamentoprod.getCodempresa();
                orcamentoprodCollectionOrcamentoprod.setCodempresa(empresa);
                orcamentoprodCollectionOrcamentoprod = em.merge(orcamentoprodCollectionOrcamentoprod);
                if (oldCodempresaOfOrcamentoprodCollectionOrcamentoprod != null) {
                    oldCodempresaOfOrcamentoprodCollectionOrcamentoprod.getOrcamentoprodCollection().remove(orcamentoprodCollectionOrcamentoprod);
                    oldCodempresaOfOrcamentoprodCollectionOrcamentoprod = em.merge(oldCodempresaOfOrcamentoprodCollectionOrcamentoprod);
                }
            }
            for (Orcamentoprod orcamentoprodCollection1Orcamentoprod : empresa.getOrcamentoprodCollection1()) {
                Empresa oldCodempresaestoqueOfOrcamentoprodCollection1Orcamentoprod = orcamentoprodCollection1Orcamentoprod.getCodempresaestoque();
                orcamentoprodCollection1Orcamentoprod.setCodempresaestoque(empresa);
                orcamentoprodCollection1Orcamentoprod = em.merge(orcamentoprodCollection1Orcamentoprod);
                if (oldCodempresaestoqueOfOrcamentoprodCollection1Orcamentoprod != null) {
                    oldCodempresaestoqueOfOrcamentoprodCollection1Orcamentoprod.getOrcamentoprodCollection1().remove(orcamentoprodCollection1Orcamentoprod);
                    oldCodempresaestoqueOfOrcamentoprodCollection1Orcamentoprod = em.merge(oldCodempresaestoqueOfOrcamentoprodCollection1Orcamentoprod);
                }
            }
            for (AcertoProdlote acertoProdloteCollectionAcertoProdlote : empresa.getAcertoProdloteCollection()) {
                Empresa oldCodempresaOfAcertoProdloteCollectionAcertoProdlote = acertoProdloteCollectionAcertoProdlote.getCodempresa();
                acertoProdloteCollectionAcertoProdlote.setCodempresa(empresa);
                acertoProdloteCollectionAcertoProdlote = em.merge(acertoProdloteCollectionAcertoProdlote);
                if (oldCodempresaOfAcertoProdloteCollectionAcertoProdlote != null) {
                    oldCodempresaOfAcertoProdloteCollectionAcertoProdlote.getAcertoProdloteCollection().remove(acertoProdloteCollectionAcertoProdlote);
                    oldCodempresaOfAcertoProdloteCollectionAcertoProdlote = em.merge(oldCodempresaOfAcertoProdloteCollectionAcertoProdlote);
                }
            }
            for (Loteentrega loteentregaCollectionLoteentrega : empresa.getLoteentregaCollection()) {
                Empresa oldCodempresaOfLoteentregaCollectionLoteentrega = loteentregaCollectionLoteentrega.getCodempresa();
                loteentregaCollectionLoteentrega.setCodempresa(empresa);
                loteentregaCollectionLoteentrega = em.merge(loteentregaCollectionLoteentrega);
                if (oldCodempresaOfLoteentregaCollectionLoteentrega != null) {
                    oldCodempresaOfLoteentregaCollectionLoteentrega.getLoteentregaCollection().remove(loteentregaCollectionLoteentrega);
                    oldCodempresaOfLoteentregaCollectionLoteentrega = em.merge(oldCodempresaOfLoteentregaCollectionLoteentrega);
                }
            }
            for (AcertoProdfci acertoProdfciCollectionAcertoProdfci : empresa.getAcertoProdfciCollection()) {
                Empresa oldCodempresaOfAcertoProdfciCollectionAcertoProdfci = acertoProdfciCollectionAcertoProdfci.getCodempresa();
                acertoProdfciCollectionAcertoProdfci.setCodempresa(empresa);
                acertoProdfciCollectionAcertoProdfci = em.merge(acertoProdfciCollectionAcertoProdfci);
                if (oldCodempresaOfAcertoProdfciCollectionAcertoProdfci != null) {
                    oldCodempresaOfAcertoProdfciCollectionAcertoProdfci.getAcertoProdfciCollection().remove(acertoProdfciCollectionAcertoProdfci);
                    oldCodempresaOfAcertoProdfciCollectionAcertoProdfci = em.merge(oldCodempresaOfAcertoProdfciCollectionAcertoProdfci);
                }
            }
            for (Empresatipodocumento empresatipodocumentoCollectionEmpresatipodocumento : empresa.getEmpresatipodocumentoCollection()) {
                Empresa oldCodempresaOfEmpresatipodocumentoCollectionEmpresatipodocumento = empresatipodocumentoCollectionEmpresatipodocumento.getCodempresa();
                empresatipodocumentoCollectionEmpresatipodocumento.setCodempresa(empresa);
                empresatipodocumentoCollectionEmpresatipodocumento = em.merge(empresatipodocumentoCollectionEmpresatipodocumento);
                if (oldCodempresaOfEmpresatipodocumentoCollectionEmpresatipodocumento != null) {
                    oldCodempresaOfEmpresatipodocumentoCollectionEmpresatipodocumento.getEmpresatipodocumentoCollection().remove(empresatipodocumentoCollectionEmpresatipodocumento);
                    oldCodempresaOfEmpresatipodocumentoCollectionEmpresatipodocumento = em.merge(oldCodempresaOfEmpresatipodocumentoCollectionEmpresatipodocumento);
                }
            }
            for (Cliente clienteCollectionCliente : empresa.getClienteCollection()) {
                Empresa oldCodempresaOfClienteCollectionCliente = clienteCollectionCliente.getCodempresa();
                clienteCollectionCliente.setCodempresa(empresa);
                clienteCollectionCliente = em.merge(clienteCollectionCliente);
                if (oldCodempresaOfClienteCollectionCliente != null) {
                    oldCodempresaOfClienteCollectionCliente.getClienteCollection().remove(clienteCollectionCliente);
                    oldCodempresaOfClienteCollectionCliente = em.merge(oldCodempresaOfClienteCollectionCliente);
                }
            }
            for (Mdfeletronico mdfeletronicoCollectionMdfeletronico : empresa.getMdfeletronicoCollection()) {
                Empresa oldCodempresaOfMdfeletronicoCollectionMdfeletronico = mdfeletronicoCollectionMdfeletronico.getCodempresa();
                mdfeletronicoCollectionMdfeletronico.setCodempresa(empresa);
                mdfeletronicoCollectionMdfeletronico = em.merge(mdfeletronicoCollectionMdfeletronico);
                if (oldCodempresaOfMdfeletronicoCollectionMdfeletronico != null) {
                    oldCodempresaOfMdfeletronicoCollectionMdfeletronico.getMdfeletronicoCollection().remove(mdfeletronicoCollectionMdfeletronico);
                    oldCodempresaOfMdfeletronicoCollectionMdfeletronico = em.merge(oldCodempresaOfMdfeletronicoCollectionMdfeletronico);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmpresa(empresa.getCodempresa()) != null) {
                throw new PreexistingEntityException("Empresa " + empresa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empresa empresa) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa persistentEmpresa = em.find(Empresa.class, empresa.getCodempresa());
            Collection<Chequesfirma> chequesfirmaCollectionOld = persistentEmpresa.getChequesfirmaCollection();
            Collection<Chequesfirma> chequesfirmaCollectionNew = empresa.getChequesfirmaCollection();
            Collection<Moventrada> moventradaCollectionOld = persistentEmpresa.getMoventradaCollection();
            Collection<Moventrada> moventradaCollectionNew = empresa.getMoventradaCollection();
            Collection<Caixa> caixaCollectionOld = persistentEmpresa.getCaixaCollection();
            Collection<Caixa> caixaCollectionNew = empresa.getCaixaCollection();
            Collection<Manifestacaodestinatario> manifestacaodestinatarioCollectionOld = persistentEmpresa.getManifestacaodestinatarioCollection();
            Collection<Manifestacaodestinatario> manifestacaodestinatarioCollectionNew = empresa.getManifestacaodestinatarioCollection();
            Collection<Recibo> reciboCollectionOld = persistentEmpresa.getReciboCollection();
            Collection<Recibo> reciboCollectionNew = empresa.getReciboCollection();
            Collection<Moconvenio> moconvenioCollectionOld = persistentEmpresa.getMoconvenioCollection();
            Collection<Moconvenio> moconvenioCollectionNew = empresa.getMoconvenioCollection();
            Collection<Empresauf> empresaufCollectionOld = persistentEmpresa.getEmpresaufCollection();
            Collection<Empresauf> empresaufCollectionNew = empresa.getEmpresaufCollection();
            Collection<Movecfrzitem> movecfrzitemCollectionOld = persistentEmpresa.getMovecfrzitemCollection();
            Collection<Movecfrzitem> movecfrzitemCollectionNew = empresa.getMovecfrzitemCollection();
            Collection<Lancafinanceira> lancafinanceiraCollectionOld = persistentEmpresa.getLancafinanceiraCollection();
            Collection<Lancafinanceira> lancafinanceiraCollectionNew = empresa.getLancafinanceiraCollection();
            Collection<Documento> documentoCollectionOld = persistentEmpresa.getDocumentoCollection();
            Collection<Documento> documentoCollectionNew = empresa.getDocumentoCollection();
            Collection<Contapagarpag> contapagarpagCollectionOld = persistentEmpresa.getContapagarpagCollection();
            Collection<Contapagarpag> contapagarpagCollectionNew = empresa.getContapagarpagCollection();
            Collection<Contapagar> contapagarCollectionOld = persistentEmpresa.getContapagarCollection();
            Collection<Contapagar> contapagarCollectionNew = empresa.getContapagarCollection();
            Collection<Contareceberrec> contareceberrecCollectionOld = persistentEmpresa.getContareceberrecCollection();
            Collection<Contareceberrec> contareceberrecCollectionNew = empresa.getContareceberrecCollection();
            Collection<Produtoestoque> produtoestoqueCollectionOld = persistentEmpresa.getProdutoestoqueCollection();
            Collection<Produtoestoque> produtoestoqueCollectionNew = empresa.getProdutoestoqueCollection();
            Collection<Atendimento> atendimentoCollectionOld = persistentEmpresa.getAtendimentoCollection();
            Collection<Atendimento> atendimentoCollectionNew = empresa.getAtendimentoCollection();
            Collection<Cheques> chequesCollectionOld = persistentEmpresa.getChequesCollection();
            Collection<Cheques> chequesCollectionNew = empresa.getChequesCollection();
            Collection<Acerto> acertoCollectionOld = persistentEmpresa.getAcertoCollection();
            Collection<Acerto> acertoCollectionNew = empresa.getAcertoCollection();
            Collection<Usuario> usuarioCollectionOld = persistentEmpresa.getUsuarioCollection();
            Collection<Usuario> usuarioCollectionNew = empresa.getUsuarioCollection();
            Collection<Movecfdocumentocaixa> movecfdocumentocaixaCollectionOld = persistentEmpresa.getMovecfdocumentocaixaCollection();
            Collection<Movecfdocumentocaixa> movecfdocumentocaixaCollectionNew = empresa.getMovecfdocumentocaixaCollection();
            Collection<Contareceber> contareceberCollectionOld = persistentEmpresa.getContareceberCollection();
            Collection<Contareceber> contareceberCollectionNew = empresa.getContareceberCollection();
            Collection<Veiculos> veiculosCollectionOld = persistentEmpresa.getVeiculosCollection();
            Collection<Veiculos> veiculosCollectionNew = empresa.getVeiculosCollection();
            Collection<Lancacartao> lancacartaoCollectionOld = persistentEmpresa.getLancacartaoCollection();
            Collection<Lancacartao> lancacartaoCollectionNew = empresa.getLancacartaoCollection();
            Collection<Movecfdocumento> movecfdocumentoCollectionOld = persistentEmpresa.getMovecfdocumentoCollection();
            Collection<Movecfdocumento> movecfdocumentoCollectionNew = empresa.getMovecfdocumentoCollection();
            Collection<Contratocobranca> contratocobrancaCollectionOld = persistentEmpresa.getContratocobrancaCollection();
            Collection<Contratocobranca> contratocobrancaCollectionNew = empresa.getContratocobrancaCollection();
            Collection<OsOrdemservico> osOrdemservicoCollectionOld = persistentEmpresa.getOsOrdemservicoCollection();
            Collection<OsOrdemservico> osOrdemservicoCollectionNew = empresa.getOsOrdemservicoCollection();
            Collection<Produtoestoquelote> produtoestoqueloteCollectionOld = persistentEmpresa.getProdutoestoqueloteCollection();
            Collection<Produtoestoquelote> produtoestoqueloteCollectionNew = empresa.getProdutoestoqueloteCollection();
            Collection<Cotacao> cotacaoCollectionOld = persistentEmpresa.getCotacaoCollection();
            Collection<Cotacao> cotacaoCollectionNew = empresa.getCotacaoCollection();
            Collection<Orcamento> orcamentoCollectionOld = persistentEmpresa.getOrcamentoCollection();
            Collection<Orcamento> orcamentoCollectionNew = empresa.getOrcamentoCollection();
            Collection<Movenda> movendaCollectionOld = persistentEmpresa.getMovendaCollection();
            Collection<Movenda> movendaCollectionNew = empresa.getMovendaCollection();
            Collection<Pedido> pedidoCollectionOld = persistentEmpresa.getPedidoCollection();
            Collection<Pedido> pedidoCollectionNew = empresa.getPedidoCollection();
            Collection<Contabancaria> contabancariaCollectionOld = persistentEmpresa.getContabancariaCollection();
            Collection<Contabancaria> contabancariaCollectionNew = empresa.getContabancariaCollection();
            Collection<Orcamentoprod> orcamentoprodCollectionOld = persistentEmpresa.getOrcamentoprodCollection();
            Collection<Orcamentoprod> orcamentoprodCollectionNew = empresa.getOrcamentoprodCollection();
            Collection<Orcamentoprod> orcamentoprodCollection1Old = persistentEmpresa.getOrcamentoprodCollection1();
            Collection<Orcamentoprod> orcamentoprodCollection1New = empresa.getOrcamentoprodCollection1();
            Collection<AcertoProdlote> acertoProdloteCollectionOld = persistentEmpresa.getAcertoProdloteCollection();
            Collection<AcertoProdlote> acertoProdloteCollectionNew = empresa.getAcertoProdloteCollection();
            Collection<Loteentrega> loteentregaCollectionOld = persistentEmpresa.getLoteentregaCollection();
            Collection<Loteentrega> loteentregaCollectionNew = empresa.getLoteentregaCollection();
            Collection<AcertoProdfci> acertoProdfciCollectionOld = persistentEmpresa.getAcertoProdfciCollection();
            Collection<AcertoProdfci> acertoProdfciCollectionNew = empresa.getAcertoProdfciCollection();
            Collection<Empresatipodocumento> empresatipodocumentoCollectionOld = persistentEmpresa.getEmpresatipodocumentoCollection();
            Collection<Empresatipodocumento> empresatipodocumentoCollectionNew = empresa.getEmpresatipodocumentoCollection();
            Collection<Cliente> clienteCollectionOld = persistentEmpresa.getClienteCollection();
            Collection<Cliente> clienteCollectionNew = empresa.getClienteCollection();
            Collection<Mdfeletronico> mdfeletronicoCollectionOld = persistentEmpresa.getMdfeletronicoCollection();
            Collection<Mdfeletronico> mdfeletronicoCollectionNew = empresa.getMdfeletronicoCollection();
            List<String> illegalOrphanMessages = null;
            for (Chequesfirma chequesfirmaCollectionOldChequesfirma : chequesfirmaCollectionOld) {
                if (!chequesfirmaCollectionNew.contains(chequesfirmaCollectionOldChequesfirma)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Chequesfirma " + chequesfirmaCollectionOldChequesfirma + " since its codempresa field is not nullable.");
                }
            }
            for (Moventrada moventradaCollectionOldMoventrada : moventradaCollectionOld) {
                if (!moventradaCollectionNew.contains(moventradaCollectionOldMoventrada)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Moventrada " + moventradaCollectionOldMoventrada + " since its codempresa field is not nullable.");
                }
            }
            for (Caixa caixaCollectionOldCaixa : caixaCollectionOld) {
                if (!caixaCollectionNew.contains(caixaCollectionOldCaixa)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Caixa " + caixaCollectionOldCaixa + " since its codempresa field is not nullable.");
                }
            }
            for (Empresauf empresaufCollectionOldEmpresauf : empresaufCollectionOld) {
                if (!empresaufCollectionNew.contains(empresaufCollectionOldEmpresauf)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Empresauf " + empresaufCollectionOldEmpresauf + " since its codempresa field is not nullable.");
                }
            }
            for (Lancafinanceira lancafinanceiraCollectionOldLancafinanceira : lancafinanceiraCollectionOld) {
                if (!lancafinanceiraCollectionNew.contains(lancafinanceiraCollectionOldLancafinanceira)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Lancafinanceira " + lancafinanceiraCollectionOldLancafinanceira + " since its codempresa field is not nullable.");
                }
            }
            for (Contapagarpag contapagarpagCollectionOldContapagarpag : contapagarpagCollectionOld) {
                if (!contapagarpagCollectionNew.contains(contapagarpagCollectionOldContapagarpag)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Contapagarpag " + contapagarpagCollectionOldContapagarpag + " since its codempresa field is not nullable.");
                }
            }
            for (Contapagar contapagarCollectionOldContapagar : contapagarCollectionOld) {
                if (!contapagarCollectionNew.contains(contapagarCollectionOldContapagar)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Contapagar " + contapagarCollectionOldContapagar + " since its codempresa field is not nullable.");
                }
            }
            for (Contareceberrec contareceberrecCollectionOldContareceberrec : contareceberrecCollectionOld) {
                if (!contareceberrecCollectionNew.contains(contareceberrecCollectionOldContareceberrec)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Contareceberrec " + contareceberrecCollectionOldContareceberrec + " since its codempresa field is not nullable.");
                }
            }
            for (Produtoestoque produtoestoqueCollectionOldProdutoestoque : produtoestoqueCollectionOld) {
                if (!produtoestoqueCollectionNew.contains(produtoestoqueCollectionOldProdutoestoque)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Produtoestoque " + produtoestoqueCollectionOldProdutoestoque + " since its empresa field is not nullable.");
                }
            }
            for (Atendimento atendimentoCollectionOldAtendimento : atendimentoCollectionOld) {
                if (!atendimentoCollectionNew.contains(atendimentoCollectionOldAtendimento)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Atendimento " + atendimentoCollectionOldAtendimento + " since its codempresa field is not nullable.");
                }
            }
            for (Cheques chequesCollectionOldCheques : chequesCollectionOld) {
                if (!chequesCollectionNew.contains(chequesCollectionOldCheques)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cheques " + chequesCollectionOldCheques + " since its codempresa field is not nullable.");
                }
            }
            for (Acerto acertoCollectionOldAcerto : acertoCollectionOld) {
                if (!acertoCollectionNew.contains(acertoCollectionOldAcerto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Acerto " + acertoCollectionOldAcerto + " since its codempresa field is not nullable.");
                }
            }
            for (Lancacartao lancacartaoCollectionOldLancacartao : lancacartaoCollectionOld) {
                if (!lancacartaoCollectionNew.contains(lancacartaoCollectionOldLancacartao)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Lancacartao " + lancacartaoCollectionOldLancacartao + " since its codempresa field is not nullable.");
                }
            }
            for (OsOrdemservico osOrdemservicoCollectionOldOsOrdemservico : osOrdemservicoCollectionOld) {
                if (!osOrdemservicoCollectionNew.contains(osOrdemservicoCollectionOldOsOrdemservico)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain OsOrdemservico " + osOrdemservicoCollectionOldOsOrdemservico + " since its codempresa field is not nullable.");
                }
            }
            for (Movenda movendaCollectionOldMovenda : movendaCollectionOld) {
                if (!movendaCollectionNew.contains(movendaCollectionOldMovenda)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Movenda " + movendaCollectionOldMovenda + " since its codempresa field is not nullable.");
                }
            }
            for (Pedido pedidoCollectionOldPedido : pedidoCollectionOld) {
                if (!pedidoCollectionNew.contains(pedidoCollectionOldPedido)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pedido " + pedidoCollectionOldPedido + " since its codempresa field is not nullable.");
                }
            }
            for (Orcamentoprod orcamentoprodCollectionOldOrcamentoprod : orcamentoprodCollectionOld) {
                if (!orcamentoprodCollectionNew.contains(orcamentoprodCollectionOldOrcamentoprod)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Orcamentoprod " + orcamentoprodCollectionOldOrcamentoprod + " since its codempresa field is not nullable.");
                }
            }
            for (Empresatipodocumento empresatipodocumentoCollectionOldEmpresatipodocumento : empresatipodocumentoCollectionOld) {
                if (!empresatipodocumentoCollectionNew.contains(empresatipodocumentoCollectionOldEmpresatipodocumento)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Empresatipodocumento " + empresatipodocumentoCollectionOldEmpresatipodocumento + " since its codempresa field is not nullable.");
                }
            }
            for (Mdfeletronico mdfeletronicoCollectionOldMdfeletronico : mdfeletronicoCollectionOld) {
                if (!mdfeletronicoCollectionNew.contains(mdfeletronicoCollectionOldMdfeletronico)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Mdfeletronico " + mdfeletronicoCollectionOldMdfeletronico + " since its codempresa field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Chequesfirma> attachedChequesfirmaCollectionNew = new ArrayList<Chequesfirma>();
            for (Chequesfirma chequesfirmaCollectionNewChequesfirmaToAttach : chequesfirmaCollectionNew) {
                chequesfirmaCollectionNewChequesfirmaToAttach = em.getReference(chequesfirmaCollectionNewChequesfirmaToAttach.getClass(), chequesfirmaCollectionNewChequesfirmaToAttach.getCodchequefirma());
                attachedChequesfirmaCollectionNew.add(chequesfirmaCollectionNewChequesfirmaToAttach);
            }
            chequesfirmaCollectionNew = attachedChequesfirmaCollectionNew;
            empresa.setChequesfirmaCollection(chequesfirmaCollectionNew);
            Collection<Moventrada> attachedMoventradaCollectionNew = new ArrayList<Moventrada>();
            for (Moventrada moventradaCollectionNewMoventradaToAttach : moventradaCollectionNew) {
                moventradaCollectionNewMoventradaToAttach = em.getReference(moventradaCollectionNewMoventradaToAttach.getClass(), moventradaCollectionNewMoventradaToAttach.getCodmoventr());
                attachedMoventradaCollectionNew.add(moventradaCollectionNewMoventradaToAttach);
            }
            moventradaCollectionNew = attachedMoventradaCollectionNew;
            empresa.setMoventradaCollection(moventradaCollectionNew);
            Collection<Caixa> attachedCaixaCollectionNew = new ArrayList<Caixa>();
            for (Caixa caixaCollectionNewCaixaToAttach : caixaCollectionNew) {
                caixaCollectionNewCaixaToAttach = em.getReference(caixaCollectionNewCaixaToAttach.getClass(), caixaCollectionNewCaixaToAttach.getCodcaixa());
                attachedCaixaCollectionNew.add(caixaCollectionNewCaixaToAttach);
            }
            caixaCollectionNew = attachedCaixaCollectionNew;
            empresa.setCaixaCollection(caixaCollectionNew);
            Collection<Manifestacaodestinatario> attachedManifestacaodestinatarioCollectionNew = new ArrayList<Manifestacaodestinatario>();
            for (Manifestacaodestinatario manifestacaodestinatarioCollectionNewManifestacaodestinatarioToAttach : manifestacaodestinatarioCollectionNew) {
                manifestacaodestinatarioCollectionNewManifestacaodestinatarioToAttach = em.getReference(manifestacaodestinatarioCollectionNewManifestacaodestinatarioToAttach.getClass(), manifestacaodestinatarioCollectionNewManifestacaodestinatarioToAttach.getCodmanifestacaodestinatario());
                attachedManifestacaodestinatarioCollectionNew.add(manifestacaodestinatarioCollectionNewManifestacaodestinatarioToAttach);
            }
            manifestacaodestinatarioCollectionNew = attachedManifestacaodestinatarioCollectionNew;
            empresa.setManifestacaodestinatarioCollection(manifestacaodestinatarioCollectionNew);
            Collection<Recibo> attachedReciboCollectionNew = new ArrayList<Recibo>();
            for (Recibo reciboCollectionNewReciboToAttach : reciboCollectionNew) {
                reciboCollectionNewReciboToAttach = em.getReference(reciboCollectionNewReciboToAttach.getClass(), reciboCollectionNewReciboToAttach.getId());
                attachedReciboCollectionNew.add(reciboCollectionNewReciboToAttach);
            }
            reciboCollectionNew = attachedReciboCollectionNew;
            empresa.setReciboCollection(reciboCollectionNew);
            Collection<Moconvenio> attachedMoconvenioCollectionNew = new ArrayList<Moconvenio>();
            for (Moconvenio moconvenioCollectionNewMoconvenioToAttach : moconvenioCollectionNew) {
                moconvenioCollectionNewMoconvenioToAttach = em.getReference(moconvenioCollectionNewMoconvenioToAttach.getClass(), moconvenioCollectionNewMoconvenioToAttach.getCodmoconvenio());
                attachedMoconvenioCollectionNew.add(moconvenioCollectionNewMoconvenioToAttach);
            }
            moconvenioCollectionNew = attachedMoconvenioCollectionNew;
            empresa.setMoconvenioCollection(moconvenioCollectionNew);
            Collection<Empresauf> attachedEmpresaufCollectionNew = new ArrayList<Empresauf>();
            for (Empresauf empresaufCollectionNewEmpresaufToAttach : empresaufCollectionNew) {
                empresaufCollectionNewEmpresaufToAttach = em.getReference(empresaufCollectionNewEmpresaufToAttach.getClass(), empresaufCollectionNewEmpresaufToAttach.getCodempresauf());
                attachedEmpresaufCollectionNew.add(empresaufCollectionNewEmpresaufToAttach);
            }
            empresaufCollectionNew = attachedEmpresaufCollectionNew;
            empresa.setEmpresaufCollection(empresaufCollectionNew);
            Collection<Movecfrzitem> attachedMovecfrzitemCollectionNew = new ArrayList<Movecfrzitem>();
            for (Movecfrzitem movecfrzitemCollectionNewMovecfrzitemToAttach : movecfrzitemCollectionNew) {
                movecfrzitemCollectionNewMovecfrzitemToAttach = em.getReference(movecfrzitemCollectionNewMovecfrzitemToAttach.getClass(), movecfrzitemCollectionNewMovecfrzitemToAttach.getCodmovecfrzitem());
                attachedMovecfrzitemCollectionNew.add(movecfrzitemCollectionNewMovecfrzitemToAttach);
            }
            movecfrzitemCollectionNew = attachedMovecfrzitemCollectionNew;
            empresa.setMovecfrzitemCollection(movecfrzitemCollectionNew);
            Collection<Lancafinanceira> attachedLancafinanceiraCollectionNew = new ArrayList<Lancafinanceira>();
            for (Lancafinanceira lancafinanceiraCollectionNewLancafinanceiraToAttach : lancafinanceiraCollectionNew) {
                lancafinanceiraCollectionNewLancafinanceiraToAttach = em.getReference(lancafinanceiraCollectionNewLancafinanceiraToAttach.getClass(), lancafinanceiraCollectionNewLancafinanceiraToAttach.getCodlfin());
                attachedLancafinanceiraCollectionNew.add(lancafinanceiraCollectionNewLancafinanceiraToAttach);
            }
            lancafinanceiraCollectionNew = attachedLancafinanceiraCollectionNew;
            empresa.setLancafinanceiraCollection(lancafinanceiraCollectionNew);
            Collection<Documento> attachedDocumentoCollectionNew = new ArrayList<Documento>();
            for (Documento documentoCollectionNewDocumentoToAttach : documentoCollectionNew) {
                documentoCollectionNewDocumentoToAttach = em.getReference(documentoCollectionNewDocumentoToAttach.getClass(), documentoCollectionNewDocumentoToAttach.getCoddocumento());
                attachedDocumentoCollectionNew.add(documentoCollectionNewDocumentoToAttach);
            }
            documentoCollectionNew = attachedDocumentoCollectionNew;
            empresa.setDocumentoCollection(documentoCollectionNew);
            Collection<Contapagarpag> attachedContapagarpagCollectionNew = new ArrayList<Contapagarpag>();
            for (Contapagarpag contapagarpagCollectionNewContapagarpagToAttach : contapagarpagCollectionNew) {
                contapagarpagCollectionNewContapagarpagToAttach = em.getReference(contapagarpagCollectionNewContapagarpagToAttach.getClass(), contapagarpagCollectionNewContapagarpagToAttach.getId());
                attachedContapagarpagCollectionNew.add(contapagarpagCollectionNewContapagarpagToAttach);
            }
            contapagarpagCollectionNew = attachedContapagarpagCollectionNew;
            empresa.setContapagarpagCollection(contapagarpagCollectionNew);
            Collection<Contapagar> attachedContapagarCollectionNew = new ArrayList<Contapagar>();
            for (Contapagar contapagarCollectionNewContapagarToAttach : contapagarCollectionNew) {
                contapagarCollectionNewContapagarToAttach = em.getReference(contapagarCollectionNewContapagarToAttach.getClass(), contapagarCollectionNewContapagarToAttach.getCodcp());
                attachedContapagarCollectionNew.add(contapagarCollectionNewContapagarToAttach);
            }
            contapagarCollectionNew = attachedContapagarCollectionNew;
            empresa.setContapagarCollection(contapagarCollectionNew);
            Collection<Contareceberrec> attachedContareceberrecCollectionNew = new ArrayList<Contareceberrec>();
            for (Contareceberrec contareceberrecCollectionNewContareceberrecToAttach : contareceberrecCollectionNew) {
                contareceberrecCollectionNewContareceberrecToAttach = em.getReference(contareceberrecCollectionNewContareceberrecToAttach.getClass(), contareceberrecCollectionNewContareceberrecToAttach.getId());
                attachedContareceberrecCollectionNew.add(contareceberrecCollectionNewContareceberrecToAttach);
            }
            contareceberrecCollectionNew = attachedContareceberrecCollectionNew;
            empresa.setContareceberrecCollection(contareceberrecCollectionNew);
            Collection<Produtoestoque> attachedProdutoestoqueCollectionNew = new ArrayList<Produtoestoque>();
            for (Produtoestoque produtoestoqueCollectionNewProdutoestoqueToAttach : produtoestoqueCollectionNew) {
                produtoestoqueCollectionNewProdutoestoqueToAttach = em.getReference(produtoestoqueCollectionNewProdutoestoqueToAttach.getClass(), produtoestoqueCollectionNewProdutoestoqueToAttach.getProdutoestoquePK());
                attachedProdutoestoqueCollectionNew.add(produtoestoqueCollectionNewProdutoestoqueToAttach);
            }
            produtoestoqueCollectionNew = attachedProdutoestoqueCollectionNew;
            empresa.setProdutoestoqueCollection(produtoestoqueCollectionNew);
            Collection<Atendimento> attachedAtendimentoCollectionNew = new ArrayList<Atendimento>();
            for (Atendimento atendimentoCollectionNewAtendimentoToAttach : atendimentoCollectionNew) {
                atendimentoCollectionNewAtendimentoToAttach = em.getReference(atendimentoCollectionNewAtendimentoToAttach.getClass(), atendimentoCollectionNewAtendimentoToAttach.getCodatend());
                attachedAtendimentoCollectionNew.add(atendimentoCollectionNewAtendimentoToAttach);
            }
            atendimentoCollectionNew = attachedAtendimentoCollectionNew;
            empresa.setAtendimentoCollection(atendimentoCollectionNew);
            Collection<Cheques> attachedChequesCollectionNew = new ArrayList<Cheques>();
            for (Cheques chequesCollectionNewChequesToAttach : chequesCollectionNew) {
                chequesCollectionNewChequesToAttach = em.getReference(chequesCollectionNewChequesToAttach.getClass(), chequesCollectionNewChequesToAttach.getCodcheque());
                attachedChequesCollectionNew.add(chequesCollectionNewChequesToAttach);
            }
            chequesCollectionNew = attachedChequesCollectionNew;
            empresa.setChequesCollection(chequesCollectionNew);
            Collection<Acerto> attachedAcertoCollectionNew = new ArrayList<Acerto>();
            for (Acerto acertoCollectionNewAcertoToAttach : acertoCollectionNew) {
                acertoCollectionNewAcertoToAttach = em.getReference(acertoCollectionNewAcertoToAttach.getClass(), acertoCollectionNewAcertoToAttach.getCodacerto());
                attachedAcertoCollectionNew.add(acertoCollectionNewAcertoToAttach);
            }
            acertoCollectionNew = attachedAcertoCollectionNew;
            empresa.setAcertoCollection(acertoCollectionNew);
            Collection<Usuario> attachedUsuarioCollectionNew = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionNewUsuarioToAttach : usuarioCollectionNew) {
                usuarioCollectionNewUsuarioToAttach = em.getReference(usuarioCollectionNewUsuarioToAttach.getClass(), usuarioCollectionNewUsuarioToAttach.getCoduser());
                attachedUsuarioCollectionNew.add(usuarioCollectionNewUsuarioToAttach);
            }
            usuarioCollectionNew = attachedUsuarioCollectionNew;
            empresa.setUsuarioCollection(usuarioCollectionNew);
            Collection<Movecfdocumentocaixa> attachedMovecfdocumentocaixaCollectionNew = new ArrayList<Movecfdocumentocaixa>();
            for (Movecfdocumentocaixa movecfdocumentocaixaCollectionNewMovecfdocumentocaixaToAttach : movecfdocumentocaixaCollectionNew) {
                movecfdocumentocaixaCollectionNewMovecfdocumentocaixaToAttach = em.getReference(movecfdocumentocaixaCollectionNewMovecfdocumentocaixaToAttach.getClass(), movecfdocumentocaixaCollectionNewMovecfdocumentocaixaToAttach.getCodmovecfdocumentocaixa());
                attachedMovecfdocumentocaixaCollectionNew.add(movecfdocumentocaixaCollectionNewMovecfdocumentocaixaToAttach);
            }
            movecfdocumentocaixaCollectionNew = attachedMovecfdocumentocaixaCollectionNew;
            empresa.setMovecfdocumentocaixaCollection(movecfdocumentocaixaCollectionNew);
            Collection<Contareceber> attachedContareceberCollectionNew = new ArrayList<Contareceber>();
            for (Contareceber contareceberCollectionNewContareceberToAttach : contareceberCollectionNew) {
                contareceberCollectionNewContareceberToAttach = em.getReference(contareceberCollectionNewContareceberToAttach.getClass(), contareceberCollectionNewContareceberToAttach.getCodcr());
                attachedContareceberCollectionNew.add(contareceberCollectionNewContareceberToAttach);
            }
            contareceberCollectionNew = attachedContareceberCollectionNew;
            empresa.setContareceberCollection(contareceberCollectionNew);
            Collection<Veiculos> attachedVeiculosCollectionNew = new ArrayList<Veiculos>();
            for (Veiculos veiculosCollectionNewVeiculosToAttach : veiculosCollectionNew) {
                veiculosCollectionNewVeiculosToAttach = em.getReference(veiculosCollectionNewVeiculosToAttach.getClass(), veiculosCollectionNewVeiculosToAttach.getCodveiculo());
                attachedVeiculosCollectionNew.add(veiculosCollectionNewVeiculosToAttach);
            }
            veiculosCollectionNew = attachedVeiculosCollectionNew;
            empresa.setVeiculosCollection(veiculosCollectionNew);
            Collection<Lancacartao> attachedLancacartaoCollectionNew = new ArrayList<Lancacartao>();
            for (Lancacartao lancacartaoCollectionNewLancacartaoToAttach : lancacartaoCollectionNew) {
                lancacartaoCollectionNewLancacartaoToAttach = em.getReference(lancacartaoCollectionNewLancacartaoToAttach.getClass(), lancacartaoCollectionNewLancacartaoToAttach.getCodlcar());
                attachedLancacartaoCollectionNew.add(lancacartaoCollectionNewLancacartaoToAttach);
            }
            lancacartaoCollectionNew = attachedLancacartaoCollectionNew;
            empresa.setLancacartaoCollection(lancacartaoCollectionNew);
            Collection<Movecfdocumento> attachedMovecfdocumentoCollectionNew = new ArrayList<Movecfdocumento>();
            for (Movecfdocumento movecfdocumentoCollectionNewMovecfdocumentoToAttach : movecfdocumentoCollectionNew) {
                movecfdocumentoCollectionNewMovecfdocumentoToAttach = em.getReference(movecfdocumentoCollectionNewMovecfdocumentoToAttach.getClass(), movecfdocumentoCollectionNewMovecfdocumentoToAttach.getCodmovecfdocumento());
                attachedMovecfdocumentoCollectionNew.add(movecfdocumentoCollectionNewMovecfdocumentoToAttach);
            }
            movecfdocumentoCollectionNew = attachedMovecfdocumentoCollectionNew;
            empresa.setMovecfdocumentoCollection(movecfdocumentoCollectionNew);
            Collection<Contratocobranca> attachedContratocobrancaCollectionNew = new ArrayList<Contratocobranca>();
            for (Contratocobranca contratocobrancaCollectionNewContratocobrancaToAttach : contratocobrancaCollectionNew) {
                contratocobrancaCollectionNewContratocobrancaToAttach = em.getReference(contratocobrancaCollectionNewContratocobrancaToAttach.getClass(), contratocobrancaCollectionNewContratocobrancaToAttach.getCodcontratocobranca());
                attachedContratocobrancaCollectionNew.add(contratocobrancaCollectionNewContratocobrancaToAttach);
            }
            contratocobrancaCollectionNew = attachedContratocobrancaCollectionNew;
            empresa.setContratocobrancaCollection(contratocobrancaCollectionNew);
            Collection<OsOrdemservico> attachedOsOrdemservicoCollectionNew = new ArrayList<OsOrdemservico>();
            for (OsOrdemservico osOrdemservicoCollectionNewOsOrdemservicoToAttach : osOrdemservicoCollectionNew) {
                osOrdemservicoCollectionNewOsOrdemservicoToAttach = em.getReference(osOrdemservicoCollectionNewOsOrdemservicoToAttach.getClass(), osOrdemservicoCollectionNewOsOrdemservicoToAttach.getCodos());
                attachedOsOrdemservicoCollectionNew.add(osOrdemservicoCollectionNewOsOrdemservicoToAttach);
            }
            osOrdemservicoCollectionNew = attachedOsOrdemservicoCollectionNew;
            empresa.setOsOrdemservicoCollection(osOrdemservicoCollectionNew);
            Collection<Produtoestoquelote> attachedProdutoestoqueloteCollectionNew = new ArrayList<Produtoestoquelote>();
            for (Produtoestoquelote produtoestoqueloteCollectionNewProdutoestoqueloteToAttach : produtoestoqueloteCollectionNew) {
                produtoestoqueloteCollectionNewProdutoestoqueloteToAttach = em.getReference(produtoestoqueloteCollectionNewProdutoestoqueloteToAttach.getClass(), produtoestoqueloteCollectionNewProdutoestoqueloteToAttach.getCodprodutoestoquelote());
                attachedProdutoestoqueloteCollectionNew.add(produtoestoqueloteCollectionNewProdutoestoqueloteToAttach);
            }
            produtoestoqueloteCollectionNew = attachedProdutoestoqueloteCollectionNew;
            empresa.setProdutoestoqueloteCollection(produtoestoqueloteCollectionNew);
            Collection<Cotacao> attachedCotacaoCollectionNew = new ArrayList<Cotacao>();
            for (Cotacao cotacaoCollectionNewCotacaoToAttach : cotacaoCollectionNew) {
                cotacaoCollectionNewCotacaoToAttach = em.getReference(cotacaoCollectionNewCotacaoToAttach.getClass(), cotacaoCollectionNewCotacaoToAttach.getCodcotacao());
                attachedCotacaoCollectionNew.add(cotacaoCollectionNewCotacaoToAttach);
            }
            cotacaoCollectionNew = attachedCotacaoCollectionNew;
            empresa.setCotacaoCollection(cotacaoCollectionNew);
            Collection<Orcamento> attachedOrcamentoCollectionNew = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollectionNewOrcamentoToAttach : orcamentoCollectionNew) {
                orcamentoCollectionNewOrcamentoToAttach = em.getReference(orcamentoCollectionNewOrcamentoToAttach.getClass(), orcamentoCollectionNewOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollectionNew.add(orcamentoCollectionNewOrcamentoToAttach);
            }
            orcamentoCollectionNew = attachedOrcamentoCollectionNew;
            empresa.setOrcamentoCollection(orcamentoCollectionNew);
            Collection<Movenda> attachedMovendaCollectionNew = new ArrayList<Movenda>();
            for (Movenda movendaCollectionNewMovendaToAttach : movendaCollectionNew) {
                movendaCollectionNewMovendaToAttach = em.getReference(movendaCollectionNewMovendaToAttach.getClass(), movendaCollectionNewMovendaToAttach.getCodmovenda());
                attachedMovendaCollectionNew.add(movendaCollectionNewMovendaToAttach);
            }
            movendaCollectionNew = attachedMovendaCollectionNew;
            empresa.setMovendaCollection(movendaCollectionNew);
            Collection<Pedido> attachedPedidoCollectionNew = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionNewPedidoToAttach : pedidoCollectionNew) {
                pedidoCollectionNewPedidoToAttach = em.getReference(pedidoCollectionNewPedidoToAttach.getClass(), pedidoCollectionNewPedidoToAttach.getCodped());
                attachedPedidoCollectionNew.add(pedidoCollectionNewPedidoToAttach);
            }
            pedidoCollectionNew = attachedPedidoCollectionNew;
            empresa.setPedidoCollection(pedidoCollectionNew);
            Collection<Contabancaria> attachedContabancariaCollectionNew = new ArrayList<Contabancaria>();
            for (Contabancaria contabancariaCollectionNewContabancariaToAttach : contabancariaCollectionNew) {
                contabancariaCollectionNewContabancariaToAttach = em.getReference(contabancariaCollectionNewContabancariaToAttach.getClass(), contabancariaCollectionNewContabancariaToAttach.getCodcontabancaria());
                attachedContabancariaCollectionNew.add(contabancariaCollectionNewContabancariaToAttach);
            }
            contabancariaCollectionNew = attachedContabancariaCollectionNew;
            empresa.setContabancariaCollection(contabancariaCollectionNew);
            Collection<Orcamentoprod> attachedOrcamentoprodCollectionNew = new ArrayList<Orcamentoprod>();
            for (Orcamentoprod orcamentoprodCollectionNewOrcamentoprodToAttach : orcamentoprodCollectionNew) {
                orcamentoprodCollectionNewOrcamentoprodToAttach = em.getReference(orcamentoprodCollectionNewOrcamentoprodToAttach.getClass(), orcamentoprodCollectionNewOrcamentoprodToAttach.getCodorcprod());
                attachedOrcamentoprodCollectionNew.add(orcamentoprodCollectionNewOrcamentoprodToAttach);
            }
            orcamentoprodCollectionNew = attachedOrcamentoprodCollectionNew;
            empresa.setOrcamentoprodCollection(orcamentoprodCollectionNew);
            Collection<Orcamentoprod> attachedOrcamentoprodCollection1New = new ArrayList<Orcamentoprod>();
            for (Orcamentoprod orcamentoprodCollection1NewOrcamentoprodToAttach : orcamentoprodCollection1New) {
                orcamentoprodCollection1NewOrcamentoprodToAttach = em.getReference(orcamentoprodCollection1NewOrcamentoprodToAttach.getClass(), orcamentoprodCollection1NewOrcamentoprodToAttach.getCodorcprod());
                attachedOrcamentoprodCollection1New.add(orcamentoprodCollection1NewOrcamentoprodToAttach);
            }
            orcamentoprodCollection1New = attachedOrcamentoprodCollection1New;
            empresa.setOrcamentoprodCollection1(orcamentoprodCollection1New);
            Collection<AcertoProdlote> attachedAcertoProdloteCollectionNew = new ArrayList<AcertoProdlote>();
            for (AcertoProdlote acertoProdloteCollectionNewAcertoProdloteToAttach : acertoProdloteCollectionNew) {
                acertoProdloteCollectionNewAcertoProdloteToAttach = em.getReference(acertoProdloteCollectionNewAcertoProdloteToAttach.getClass(), acertoProdloteCollectionNewAcertoProdloteToAttach.getCodacertoProdlote());
                attachedAcertoProdloteCollectionNew.add(acertoProdloteCollectionNewAcertoProdloteToAttach);
            }
            acertoProdloteCollectionNew = attachedAcertoProdloteCollectionNew;
            empresa.setAcertoProdloteCollection(acertoProdloteCollectionNew);
            Collection<Loteentrega> attachedLoteentregaCollectionNew = new ArrayList<Loteentrega>();
            for (Loteentrega loteentregaCollectionNewLoteentregaToAttach : loteentregaCollectionNew) {
                loteentregaCollectionNewLoteentregaToAttach = em.getReference(loteentregaCollectionNewLoteentregaToAttach.getClass(), loteentregaCollectionNewLoteentregaToAttach.getCodloteentrega());
                attachedLoteentregaCollectionNew.add(loteentregaCollectionNewLoteentregaToAttach);
            }
            loteentregaCollectionNew = attachedLoteentregaCollectionNew;
            empresa.setLoteentregaCollection(loteentregaCollectionNew);
            Collection<AcertoProdfci> attachedAcertoProdfciCollectionNew = new ArrayList<AcertoProdfci>();
            for (AcertoProdfci acertoProdfciCollectionNewAcertoProdfciToAttach : acertoProdfciCollectionNew) {
                acertoProdfciCollectionNewAcertoProdfciToAttach = em.getReference(acertoProdfciCollectionNewAcertoProdfciToAttach.getClass(), acertoProdfciCollectionNewAcertoProdfciToAttach.getCodacertoProdfci());
                attachedAcertoProdfciCollectionNew.add(acertoProdfciCollectionNewAcertoProdfciToAttach);
            }
            acertoProdfciCollectionNew = attachedAcertoProdfciCollectionNew;
            empresa.setAcertoProdfciCollection(acertoProdfciCollectionNew);
            Collection<Empresatipodocumento> attachedEmpresatipodocumentoCollectionNew = new ArrayList<Empresatipodocumento>();
            for (Empresatipodocumento empresatipodocumentoCollectionNewEmpresatipodocumentoToAttach : empresatipodocumentoCollectionNew) {
                empresatipodocumentoCollectionNewEmpresatipodocumentoToAttach = em.getReference(empresatipodocumentoCollectionNewEmpresatipodocumentoToAttach.getClass(), empresatipodocumentoCollectionNewEmpresatipodocumentoToAttach.getCodempresatipodocumento());
                attachedEmpresatipodocumentoCollectionNew.add(empresatipodocumentoCollectionNewEmpresatipodocumentoToAttach);
            }
            empresatipodocumentoCollectionNew = attachedEmpresatipodocumentoCollectionNew;
            empresa.setEmpresatipodocumentoCollection(empresatipodocumentoCollectionNew);
            Collection<Cliente> attachedClienteCollectionNew = new ArrayList<Cliente>();
            for (Cliente clienteCollectionNewClienteToAttach : clienteCollectionNew) {
                clienteCollectionNewClienteToAttach = em.getReference(clienteCollectionNewClienteToAttach.getClass(), clienteCollectionNewClienteToAttach.getCodcli());
                attachedClienteCollectionNew.add(clienteCollectionNewClienteToAttach);
            }
            clienteCollectionNew = attachedClienteCollectionNew;
            empresa.setClienteCollection(clienteCollectionNew);
            Collection<Mdfeletronico> attachedMdfeletronicoCollectionNew = new ArrayList<Mdfeletronico>();
            for (Mdfeletronico mdfeletronicoCollectionNewMdfeletronicoToAttach : mdfeletronicoCollectionNew) {
                mdfeletronicoCollectionNewMdfeletronicoToAttach = em.getReference(mdfeletronicoCollectionNewMdfeletronicoToAttach.getClass(), mdfeletronicoCollectionNewMdfeletronicoToAttach.getCodmdfeletronico());
                attachedMdfeletronicoCollectionNew.add(mdfeletronicoCollectionNewMdfeletronicoToAttach);
            }
            mdfeletronicoCollectionNew = attachedMdfeletronicoCollectionNew;
            empresa.setMdfeletronicoCollection(mdfeletronicoCollectionNew);
            empresa = em.merge(empresa);
            for (Chequesfirma chequesfirmaCollectionNewChequesfirma : chequesfirmaCollectionNew) {
                if (!chequesfirmaCollectionOld.contains(chequesfirmaCollectionNewChequesfirma)) {
                    Empresa oldCodempresaOfChequesfirmaCollectionNewChequesfirma = chequesfirmaCollectionNewChequesfirma.getCodempresa();
                    chequesfirmaCollectionNewChequesfirma.setCodempresa(empresa);
                    chequesfirmaCollectionNewChequesfirma = em.merge(chequesfirmaCollectionNewChequesfirma);
                    if (oldCodempresaOfChequesfirmaCollectionNewChequesfirma != null && !oldCodempresaOfChequesfirmaCollectionNewChequesfirma.equals(empresa)) {
                        oldCodempresaOfChequesfirmaCollectionNewChequesfirma.getChequesfirmaCollection().remove(chequesfirmaCollectionNewChequesfirma);
                        oldCodempresaOfChequesfirmaCollectionNewChequesfirma = em.merge(oldCodempresaOfChequesfirmaCollectionNewChequesfirma);
                    }
                }
            }
            for (Moventrada moventradaCollectionNewMoventrada : moventradaCollectionNew) {
                if (!moventradaCollectionOld.contains(moventradaCollectionNewMoventrada)) {
                    Empresa oldCodempresaOfMoventradaCollectionNewMoventrada = moventradaCollectionNewMoventrada.getCodempresa();
                    moventradaCollectionNewMoventrada.setCodempresa(empresa);
                    moventradaCollectionNewMoventrada = em.merge(moventradaCollectionNewMoventrada);
                    if (oldCodempresaOfMoventradaCollectionNewMoventrada != null && !oldCodempresaOfMoventradaCollectionNewMoventrada.equals(empresa)) {
                        oldCodempresaOfMoventradaCollectionNewMoventrada.getMoventradaCollection().remove(moventradaCollectionNewMoventrada);
                        oldCodempresaOfMoventradaCollectionNewMoventrada = em.merge(oldCodempresaOfMoventradaCollectionNewMoventrada);
                    }
                }
            }
            for (Caixa caixaCollectionNewCaixa : caixaCollectionNew) {
                if (!caixaCollectionOld.contains(caixaCollectionNewCaixa)) {
                    Empresa oldCodempresaOfCaixaCollectionNewCaixa = caixaCollectionNewCaixa.getCodempresa();
                    caixaCollectionNewCaixa.setCodempresa(empresa);
                    caixaCollectionNewCaixa = em.merge(caixaCollectionNewCaixa);
                    if (oldCodempresaOfCaixaCollectionNewCaixa != null && !oldCodempresaOfCaixaCollectionNewCaixa.equals(empresa)) {
                        oldCodempresaOfCaixaCollectionNewCaixa.getCaixaCollection().remove(caixaCollectionNewCaixa);
                        oldCodempresaOfCaixaCollectionNewCaixa = em.merge(oldCodempresaOfCaixaCollectionNewCaixa);
                    }
                }
            }
            for (Manifestacaodestinatario manifestacaodestinatarioCollectionOldManifestacaodestinatario : manifestacaodestinatarioCollectionOld) {
                if (!manifestacaodestinatarioCollectionNew.contains(manifestacaodestinatarioCollectionOldManifestacaodestinatario)) {
                    manifestacaodestinatarioCollectionOldManifestacaodestinatario.setCodempresa(null);
                    manifestacaodestinatarioCollectionOldManifestacaodestinatario = em.merge(manifestacaodestinatarioCollectionOldManifestacaodestinatario);
                }
            }
            for (Manifestacaodestinatario manifestacaodestinatarioCollectionNewManifestacaodestinatario : manifestacaodestinatarioCollectionNew) {
                if (!manifestacaodestinatarioCollectionOld.contains(manifestacaodestinatarioCollectionNewManifestacaodestinatario)) {
                    Empresa oldCodempresaOfManifestacaodestinatarioCollectionNewManifestacaodestinatario = manifestacaodestinatarioCollectionNewManifestacaodestinatario.getCodempresa();
                    manifestacaodestinatarioCollectionNewManifestacaodestinatario.setCodempresa(empresa);
                    manifestacaodestinatarioCollectionNewManifestacaodestinatario = em.merge(manifestacaodestinatarioCollectionNewManifestacaodestinatario);
                    if (oldCodempresaOfManifestacaodestinatarioCollectionNewManifestacaodestinatario != null && !oldCodempresaOfManifestacaodestinatarioCollectionNewManifestacaodestinatario.equals(empresa)) {
                        oldCodempresaOfManifestacaodestinatarioCollectionNewManifestacaodestinatario.getManifestacaodestinatarioCollection().remove(manifestacaodestinatarioCollectionNewManifestacaodestinatario);
                        oldCodempresaOfManifestacaodestinatarioCollectionNewManifestacaodestinatario = em.merge(oldCodempresaOfManifestacaodestinatarioCollectionNewManifestacaodestinatario);
                    }
                }
            }
            for (Recibo reciboCollectionOldRecibo : reciboCollectionOld) {
                if (!reciboCollectionNew.contains(reciboCollectionOldRecibo)) {
                    reciboCollectionOldRecibo.setCodempresa(null);
                    reciboCollectionOldRecibo = em.merge(reciboCollectionOldRecibo);
                }
            }
            for (Recibo reciboCollectionNewRecibo : reciboCollectionNew) {
                if (!reciboCollectionOld.contains(reciboCollectionNewRecibo)) {
                    Empresa oldCodempresaOfReciboCollectionNewRecibo = reciboCollectionNewRecibo.getCodempresa();
                    reciboCollectionNewRecibo.setCodempresa(empresa);
                    reciboCollectionNewRecibo = em.merge(reciboCollectionNewRecibo);
                    if (oldCodempresaOfReciboCollectionNewRecibo != null && !oldCodempresaOfReciboCollectionNewRecibo.equals(empresa)) {
                        oldCodempresaOfReciboCollectionNewRecibo.getReciboCollection().remove(reciboCollectionNewRecibo);
                        oldCodempresaOfReciboCollectionNewRecibo = em.merge(oldCodempresaOfReciboCollectionNewRecibo);
                    }
                }
            }
            for (Moconvenio moconvenioCollectionOldMoconvenio : moconvenioCollectionOld) {
                if (!moconvenioCollectionNew.contains(moconvenioCollectionOldMoconvenio)) {
                    moconvenioCollectionOldMoconvenio.setCodempresa(null);
                    moconvenioCollectionOldMoconvenio = em.merge(moconvenioCollectionOldMoconvenio);
                }
            }
            for (Moconvenio moconvenioCollectionNewMoconvenio : moconvenioCollectionNew) {
                if (!moconvenioCollectionOld.contains(moconvenioCollectionNewMoconvenio)) {
                    Empresa oldCodempresaOfMoconvenioCollectionNewMoconvenio = moconvenioCollectionNewMoconvenio.getCodempresa();
                    moconvenioCollectionNewMoconvenio.setCodempresa(empresa);
                    moconvenioCollectionNewMoconvenio = em.merge(moconvenioCollectionNewMoconvenio);
                    if (oldCodempresaOfMoconvenioCollectionNewMoconvenio != null && !oldCodempresaOfMoconvenioCollectionNewMoconvenio.equals(empresa)) {
                        oldCodempresaOfMoconvenioCollectionNewMoconvenio.getMoconvenioCollection().remove(moconvenioCollectionNewMoconvenio);
                        oldCodempresaOfMoconvenioCollectionNewMoconvenio = em.merge(oldCodempresaOfMoconvenioCollectionNewMoconvenio);
                    }
                }
            }
            for (Empresauf empresaufCollectionNewEmpresauf : empresaufCollectionNew) {
                if (!empresaufCollectionOld.contains(empresaufCollectionNewEmpresauf)) {
                    Empresa oldCodempresaOfEmpresaufCollectionNewEmpresauf = empresaufCollectionNewEmpresauf.getCodempresa();
                    empresaufCollectionNewEmpresauf.setCodempresa(empresa);
                    empresaufCollectionNewEmpresauf = em.merge(empresaufCollectionNewEmpresauf);
                    if (oldCodempresaOfEmpresaufCollectionNewEmpresauf != null && !oldCodempresaOfEmpresaufCollectionNewEmpresauf.equals(empresa)) {
                        oldCodempresaOfEmpresaufCollectionNewEmpresauf.getEmpresaufCollection().remove(empresaufCollectionNewEmpresauf);
                        oldCodempresaOfEmpresaufCollectionNewEmpresauf = em.merge(oldCodempresaOfEmpresaufCollectionNewEmpresauf);
                    }
                }
            }
            for (Movecfrzitem movecfrzitemCollectionOldMovecfrzitem : movecfrzitemCollectionOld) {
                if (!movecfrzitemCollectionNew.contains(movecfrzitemCollectionOldMovecfrzitem)) {
                    movecfrzitemCollectionOldMovecfrzitem.setCodempresa(null);
                    movecfrzitemCollectionOldMovecfrzitem = em.merge(movecfrzitemCollectionOldMovecfrzitem);
                }
            }
            for (Movecfrzitem movecfrzitemCollectionNewMovecfrzitem : movecfrzitemCollectionNew) {
                if (!movecfrzitemCollectionOld.contains(movecfrzitemCollectionNewMovecfrzitem)) {
                    Empresa oldCodempresaOfMovecfrzitemCollectionNewMovecfrzitem = movecfrzitemCollectionNewMovecfrzitem.getCodempresa();
                    movecfrzitemCollectionNewMovecfrzitem.setCodempresa(empresa);
                    movecfrzitemCollectionNewMovecfrzitem = em.merge(movecfrzitemCollectionNewMovecfrzitem);
                    if (oldCodempresaOfMovecfrzitemCollectionNewMovecfrzitem != null && !oldCodempresaOfMovecfrzitemCollectionNewMovecfrzitem.equals(empresa)) {
                        oldCodempresaOfMovecfrzitemCollectionNewMovecfrzitem.getMovecfrzitemCollection().remove(movecfrzitemCollectionNewMovecfrzitem);
                        oldCodempresaOfMovecfrzitemCollectionNewMovecfrzitem = em.merge(oldCodempresaOfMovecfrzitemCollectionNewMovecfrzitem);
                    }
                }
            }
            for (Lancafinanceira lancafinanceiraCollectionNewLancafinanceira : lancafinanceiraCollectionNew) {
                if (!lancafinanceiraCollectionOld.contains(lancafinanceiraCollectionNewLancafinanceira)) {
                    Empresa oldCodempresaOfLancafinanceiraCollectionNewLancafinanceira = lancafinanceiraCollectionNewLancafinanceira.getCodempresa();
                    lancafinanceiraCollectionNewLancafinanceira.setCodempresa(empresa);
                    lancafinanceiraCollectionNewLancafinanceira = em.merge(lancafinanceiraCollectionNewLancafinanceira);
                    if (oldCodempresaOfLancafinanceiraCollectionNewLancafinanceira != null && !oldCodempresaOfLancafinanceiraCollectionNewLancafinanceira.equals(empresa)) {
                        oldCodempresaOfLancafinanceiraCollectionNewLancafinanceira.getLancafinanceiraCollection().remove(lancafinanceiraCollectionNewLancafinanceira);
                        oldCodempresaOfLancafinanceiraCollectionNewLancafinanceira = em.merge(oldCodempresaOfLancafinanceiraCollectionNewLancafinanceira);
                    }
                }
            }
            for (Documento documentoCollectionOldDocumento : documentoCollectionOld) {
                if (!documentoCollectionNew.contains(documentoCollectionOldDocumento)) {
                    documentoCollectionOldDocumento.setCodempresa(null);
                    documentoCollectionOldDocumento = em.merge(documentoCollectionOldDocumento);
                }
            }
            for (Documento documentoCollectionNewDocumento : documentoCollectionNew) {
                if (!documentoCollectionOld.contains(documentoCollectionNewDocumento)) {
                    Empresa oldCodempresaOfDocumentoCollectionNewDocumento = documentoCollectionNewDocumento.getCodempresa();
                    documentoCollectionNewDocumento.setCodempresa(empresa);
                    documentoCollectionNewDocumento = em.merge(documentoCollectionNewDocumento);
                    if (oldCodempresaOfDocumentoCollectionNewDocumento != null && !oldCodempresaOfDocumentoCollectionNewDocumento.equals(empresa)) {
                        oldCodempresaOfDocumentoCollectionNewDocumento.getDocumentoCollection().remove(documentoCollectionNewDocumento);
                        oldCodempresaOfDocumentoCollectionNewDocumento = em.merge(oldCodempresaOfDocumentoCollectionNewDocumento);
                    }
                }
            }
            for (Contapagarpag contapagarpagCollectionNewContapagarpag : contapagarpagCollectionNew) {
                if (!contapagarpagCollectionOld.contains(contapagarpagCollectionNewContapagarpag)) {
                    Empresa oldCodempresaOfContapagarpagCollectionNewContapagarpag = contapagarpagCollectionNewContapagarpag.getCodempresa();
                    contapagarpagCollectionNewContapagarpag.setCodempresa(empresa);
                    contapagarpagCollectionNewContapagarpag = em.merge(contapagarpagCollectionNewContapagarpag);
                    if (oldCodempresaOfContapagarpagCollectionNewContapagarpag != null && !oldCodempresaOfContapagarpagCollectionNewContapagarpag.equals(empresa)) {
                        oldCodempresaOfContapagarpagCollectionNewContapagarpag.getContapagarpagCollection().remove(contapagarpagCollectionNewContapagarpag);
                        oldCodempresaOfContapagarpagCollectionNewContapagarpag = em.merge(oldCodempresaOfContapagarpagCollectionNewContapagarpag);
                    }
                }
            }
            for (Contapagar contapagarCollectionNewContapagar : contapagarCollectionNew) {
                if (!contapagarCollectionOld.contains(contapagarCollectionNewContapagar)) {
                    Empresa oldCodempresaOfContapagarCollectionNewContapagar = contapagarCollectionNewContapagar.getCodempresa();
                    contapagarCollectionNewContapagar.setCodempresa(empresa);
                    contapagarCollectionNewContapagar = em.merge(contapagarCollectionNewContapagar);
                    if (oldCodempresaOfContapagarCollectionNewContapagar != null && !oldCodempresaOfContapagarCollectionNewContapagar.equals(empresa)) {
                        oldCodempresaOfContapagarCollectionNewContapagar.getContapagarCollection().remove(contapagarCollectionNewContapagar);
                        oldCodempresaOfContapagarCollectionNewContapagar = em.merge(oldCodempresaOfContapagarCollectionNewContapagar);
                    }
                }
            }
            for (Contareceberrec contareceberrecCollectionNewContareceberrec : contareceberrecCollectionNew) {
                if (!contareceberrecCollectionOld.contains(contareceberrecCollectionNewContareceberrec)) {
                    Empresa oldCodempresaOfContareceberrecCollectionNewContareceberrec = contareceberrecCollectionNewContareceberrec.getCodempresa();
                    contareceberrecCollectionNewContareceberrec.setCodempresa(empresa);
                    contareceberrecCollectionNewContareceberrec = em.merge(contareceberrecCollectionNewContareceberrec);
                    if (oldCodempresaOfContareceberrecCollectionNewContareceberrec != null && !oldCodempresaOfContareceberrecCollectionNewContareceberrec.equals(empresa)) {
                        oldCodempresaOfContareceberrecCollectionNewContareceberrec.getContareceberrecCollection().remove(contareceberrecCollectionNewContareceberrec);
                        oldCodempresaOfContareceberrecCollectionNewContareceberrec = em.merge(oldCodempresaOfContareceberrecCollectionNewContareceberrec);
                    }
                }
            }
            for (Produtoestoque produtoestoqueCollectionNewProdutoestoque : produtoestoqueCollectionNew) {
                if (!produtoestoqueCollectionOld.contains(produtoestoqueCollectionNewProdutoestoque)) {
                    Empresa oldEmpresaOfProdutoestoqueCollectionNewProdutoestoque = produtoestoqueCollectionNewProdutoestoque.getEmpresa();
                    produtoestoqueCollectionNewProdutoestoque.setEmpresa(empresa);
                    produtoestoqueCollectionNewProdutoestoque = em.merge(produtoestoqueCollectionNewProdutoestoque);
                    if (oldEmpresaOfProdutoestoqueCollectionNewProdutoestoque != null && !oldEmpresaOfProdutoestoqueCollectionNewProdutoestoque.equals(empresa)) {
                        oldEmpresaOfProdutoestoqueCollectionNewProdutoestoque.getProdutoestoqueCollection().remove(produtoestoqueCollectionNewProdutoestoque);
                        oldEmpresaOfProdutoestoqueCollectionNewProdutoestoque = em.merge(oldEmpresaOfProdutoestoqueCollectionNewProdutoestoque);
                    }
                }
            }
            for (Atendimento atendimentoCollectionNewAtendimento : atendimentoCollectionNew) {
                if (!atendimentoCollectionOld.contains(atendimentoCollectionNewAtendimento)) {
                    Empresa oldCodempresaOfAtendimentoCollectionNewAtendimento = atendimentoCollectionNewAtendimento.getCodempresa();
                    atendimentoCollectionNewAtendimento.setCodempresa(empresa);
                    atendimentoCollectionNewAtendimento = em.merge(atendimentoCollectionNewAtendimento);
                    if (oldCodempresaOfAtendimentoCollectionNewAtendimento != null && !oldCodempresaOfAtendimentoCollectionNewAtendimento.equals(empresa)) {
                        oldCodempresaOfAtendimentoCollectionNewAtendimento.getAtendimentoCollection().remove(atendimentoCollectionNewAtendimento);
                        oldCodempresaOfAtendimentoCollectionNewAtendimento = em.merge(oldCodempresaOfAtendimentoCollectionNewAtendimento);
                    }
                }
            }
            for (Cheques chequesCollectionNewCheques : chequesCollectionNew) {
                if (!chequesCollectionOld.contains(chequesCollectionNewCheques)) {
                    Empresa oldCodempresaOfChequesCollectionNewCheques = chequesCollectionNewCheques.getCodempresa();
                    chequesCollectionNewCheques.setCodempresa(empresa);
                    chequesCollectionNewCheques = em.merge(chequesCollectionNewCheques);
                    if (oldCodempresaOfChequesCollectionNewCheques != null && !oldCodempresaOfChequesCollectionNewCheques.equals(empresa)) {
                        oldCodempresaOfChequesCollectionNewCheques.getChequesCollection().remove(chequesCollectionNewCheques);
                        oldCodempresaOfChequesCollectionNewCheques = em.merge(oldCodempresaOfChequesCollectionNewCheques);
                    }
                }
            }
            for (Acerto acertoCollectionNewAcerto : acertoCollectionNew) {
                if (!acertoCollectionOld.contains(acertoCollectionNewAcerto)) {
                    Empresa oldCodempresaOfAcertoCollectionNewAcerto = acertoCollectionNewAcerto.getCodempresa();
                    acertoCollectionNewAcerto.setCodempresa(empresa);
                    acertoCollectionNewAcerto = em.merge(acertoCollectionNewAcerto);
                    if (oldCodempresaOfAcertoCollectionNewAcerto != null && !oldCodempresaOfAcertoCollectionNewAcerto.equals(empresa)) {
                        oldCodempresaOfAcertoCollectionNewAcerto.getAcertoCollection().remove(acertoCollectionNewAcerto);
                        oldCodempresaOfAcertoCollectionNewAcerto = em.merge(oldCodempresaOfAcertoCollectionNewAcerto);
                    }
                }
            }
            for (Usuario usuarioCollectionOldUsuario : usuarioCollectionOld) {
                if (!usuarioCollectionNew.contains(usuarioCollectionOldUsuario)) {
                    usuarioCollectionOldUsuario.setCodempresa(null);
                    usuarioCollectionOldUsuario = em.merge(usuarioCollectionOldUsuario);
                }
            }
            for (Usuario usuarioCollectionNewUsuario : usuarioCollectionNew) {
                if (!usuarioCollectionOld.contains(usuarioCollectionNewUsuario)) {
                    Empresa oldCodempresaOfUsuarioCollectionNewUsuario = usuarioCollectionNewUsuario.getCodempresa();
                    usuarioCollectionNewUsuario.setCodempresa(empresa);
                    usuarioCollectionNewUsuario = em.merge(usuarioCollectionNewUsuario);
                    if (oldCodempresaOfUsuarioCollectionNewUsuario != null && !oldCodempresaOfUsuarioCollectionNewUsuario.equals(empresa)) {
                        oldCodempresaOfUsuarioCollectionNewUsuario.getUsuarioCollection().remove(usuarioCollectionNewUsuario);
                        oldCodempresaOfUsuarioCollectionNewUsuario = em.merge(oldCodempresaOfUsuarioCollectionNewUsuario);
                    }
                }
            }
            for (Movecfdocumentocaixa movecfdocumentocaixaCollectionOldMovecfdocumentocaixa : movecfdocumentocaixaCollectionOld) {
                if (!movecfdocumentocaixaCollectionNew.contains(movecfdocumentocaixaCollectionOldMovecfdocumentocaixa)) {
                    movecfdocumentocaixaCollectionOldMovecfdocumentocaixa.setCodempresa(null);
                    movecfdocumentocaixaCollectionOldMovecfdocumentocaixa = em.merge(movecfdocumentocaixaCollectionOldMovecfdocumentocaixa);
                }
            }
            for (Movecfdocumentocaixa movecfdocumentocaixaCollectionNewMovecfdocumentocaixa : movecfdocumentocaixaCollectionNew) {
                if (!movecfdocumentocaixaCollectionOld.contains(movecfdocumentocaixaCollectionNewMovecfdocumentocaixa)) {
                    Empresa oldCodempresaOfMovecfdocumentocaixaCollectionNewMovecfdocumentocaixa = movecfdocumentocaixaCollectionNewMovecfdocumentocaixa.getCodempresa();
                    movecfdocumentocaixaCollectionNewMovecfdocumentocaixa.setCodempresa(empresa);
                    movecfdocumentocaixaCollectionNewMovecfdocumentocaixa = em.merge(movecfdocumentocaixaCollectionNewMovecfdocumentocaixa);
                    if (oldCodempresaOfMovecfdocumentocaixaCollectionNewMovecfdocumentocaixa != null && !oldCodempresaOfMovecfdocumentocaixaCollectionNewMovecfdocumentocaixa.equals(empresa)) {
                        oldCodempresaOfMovecfdocumentocaixaCollectionNewMovecfdocumentocaixa.getMovecfdocumentocaixaCollection().remove(movecfdocumentocaixaCollectionNewMovecfdocumentocaixa);
                        oldCodempresaOfMovecfdocumentocaixaCollectionNewMovecfdocumentocaixa = em.merge(oldCodempresaOfMovecfdocumentocaixaCollectionNewMovecfdocumentocaixa);
                    }
                }
            }
            for (Contareceber contareceberCollectionOldContareceber : contareceberCollectionOld) {
                if (!contareceberCollectionNew.contains(contareceberCollectionOldContareceber)) {
                    contareceberCollectionOldContareceber.setCodempresa(null);
                    contareceberCollectionOldContareceber = em.merge(contareceberCollectionOldContareceber);
                }
            }
            for (Contareceber contareceberCollectionNewContareceber : contareceberCollectionNew) {
                if (!contareceberCollectionOld.contains(contareceberCollectionNewContareceber)) {
                    Empresa oldCodempresaOfContareceberCollectionNewContareceber = contareceberCollectionNewContareceber.getCodempresa();
                    contareceberCollectionNewContareceber.setCodempresa(empresa);
                    contareceberCollectionNewContareceber = em.merge(contareceberCollectionNewContareceber);
                    if (oldCodempresaOfContareceberCollectionNewContareceber != null && !oldCodempresaOfContareceberCollectionNewContareceber.equals(empresa)) {
                        oldCodempresaOfContareceberCollectionNewContareceber.getContareceberCollection().remove(contareceberCollectionNewContareceber);
                        oldCodempresaOfContareceberCollectionNewContareceber = em.merge(oldCodempresaOfContareceberCollectionNewContareceber);
                    }
                }
            }
            for (Veiculos veiculosCollectionOldVeiculos : veiculosCollectionOld) {
                if (!veiculosCollectionNew.contains(veiculosCollectionOldVeiculos)) {
                    veiculosCollectionOldVeiculos.setCodempresa(null);
                    veiculosCollectionOldVeiculos = em.merge(veiculosCollectionOldVeiculos);
                }
            }
            for (Veiculos veiculosCollectionNewVeiculos : veiculosCollectionNew) {
                if (!veiculosCollectionOld.contains(veiculosCollectionNewVeiculos)) {
                    Empresa oldCodempresaOfVeiculosCollectionNewVeiculos = veiculosCollectionNewVeiculos.getCodempresa();
                    veiculosCollectionNewVeiculos.setCodempresa(empresa);
                    veiculosCollectionNewVeiculos = em.merge(veiculosCollectionNewVeiculos);
                    if (oldCodempresaOfVeiculosCollectionNewVeiculos != null && !oldCodempresaOfVeiculosCollectionNewVeiculos.equals(empresa)) {
                        oldCodempresaOfVeiculosCollectionNewVeiculos.getVeiculosCollection().remove(veiculosCollectionNewVeiculos);
                        oldCodempresaOfVeiculosCollectionNewVeiculos = em.merge(oldCodempresaOfVeiculosCollectionNewVeiculos);
                    }
                }
            }
            for (Lancacartao lancacartaoCollectionNewLancacartao : lancacartaoCollectionNew) {
                if (!lancacartaoCollectionOld.contains(lancacartaoCollectionNewLancacartao)) {
                    Empresa oldCodempresaOfLancacartaoCollectionNewLancacartao = lancacartaoCollectionNewLancacartao.getCodempresa();
                    lancacartaoCollectionNewLancacartao.setCodempresa(empresa);
                    lancacartaoCollectionNewLancacartao = em.merge(lancacartaoCollectionNewLancacartao);
                    if (oldCodempresaOfLancacartaoCollectionNewLancacartao != null && !oldCodempresaOfLancacartaoCollectionNewLancacartao.equals(empresa)) {
                        oldCodempresaOfLancacartaoCollectionNewLancacartao.getLancacartaoCollection().remove(lancacartaoCollectionNewLancacartao);
                        oldCodempresaOfLancacartaoCollectionNewLancacartao = em.merge(oldCodempresaOfLancacartaoCollectionNewLancacartao);
                    }
                }
            }
            for (Movecfdocumento movecfdocumentoCollectionOldMovecfdocumento : movecfdocumentoCollectionOld) {
                if (!movecfdocumentoCollectionNew.contains(movecfdocumentoCollectionOldMovecfdocumento)) {
                    movecfdocumentoCollectionOldMovecfdocumento.setCodempresa(null);
                    movecfdocumentoCollectionOldMovecfdocumento = em.merge(movecfdocumentoCollectionOldMovecfdocumento);
                }
            }
            for (Movecfdocumento movecfdocumentoCollectionNewMovecfdocumento : movecfdocumentoCollectionNew) {
                if (!movecfdocumentoCollectionOld.contains(movecfdocumentoCollectionNewMovecfdocumento)) {
                    Empresa oldCodempresaOfMovecfdocumentoCollectionNewMovecfdocumento = movecfdocumentoCollectionNewMovecfdocumento.getCodempresa();
                    movecfdocumentoCollectionNewMovecfdocumento.setCodempresa(empresa);
                    movecfdocumentoCollectionNewMovecfdocumento = em.merge(movecfdocumentoCollectionNewMovecfdocumento);
                    if (oldCodempresaOfMovecfdocumentoCollectionNewMovecfdocumento != null && !oldCodempresaOfMovecfdocumentoCollectionNewMovecfdocumento.equals(empresa)) {
                        oldCodempresaOfMovecfdocumentoCollectionNewMovecfdocumento.getMovecfdocumentoCollection().remove(movecfdocumentoCollectionNewMovecfdocumento);
                        oldCodempresaOfMovecfdocumentoCollectionNewMovecfdocumento = em.merge(oldCodempresaOfMovecfdocumentoCollectionNewMovecfdocumento);
                    }
                }
            }
            for (Contratocobranca contratocobrancaCollectionOldContratocobranca : contratocobrancaCollectionOld) {
                if (!contratocobrancaCollectionNew.contains(contratocobrancaCollectionOldContratocobranca)) {
                    contratocobrancaCollectionOldContratocobranca.setCodempresa(null);
                    contratocobrancaCollectionOldContratocobranca = em.merge(contratocobrancaCollectionOldContratocobranca);
                }
            }
            for (Contratocobranca contratocobrancaCollectionNewContratocobranca : contratocobrancaCollectionNew) {
                if (!contratocobrancaCollectionOld.contains(contratocobrancaCollectionNewContratocobranca)) {
                    Empresa oldCodempresaOfContratocobrancaCollectionNewContratocobranca = contratocobrancaCollectionNewContratocobranca.getCodempresa();
                    contratocobrancaCollectionNewContratocobranca.setCodempresa(empresa);
                    contratocobrancaCollectionNewContratocobranca = em.merge(contratocobrancaCollectionNewContratocobranca);
                    if (oldCodempresaOfContratocobrancaCollectionNewContratocobranca != null && !oldCodempresaOfContratocobrancaCollectionNewContratocobranca.equals(empresa)) {
                        oldCodempresaOfContratocobrancaCollectionNewContratocobranca.getContratocobrancaCollection().remove(contratocobrancaCollectionNewContratocobranca);
                        oldCodempresaOfContratocobrancaCollectionNewContratocobranca = em.merge(oldCodempresaOfContratocobrancaCollectionNewContratocobranca);
                    }
                }
            }
            for (OsOrdemservico osOrdemservicoCollectionNewOsOrdemservico : osOrdemservicoCollectionNew) {
                if (!osOrdemservicoCollectionOld.contains(osOrdemservicoCollectionNewOsOrdemservico)) {
                    Empresa oldCodempresaOfOsOrdemservicoCollectionNewOsOrdemservico = osOrdemservicoCollectionNewOsOrdemservico.getCodempresa();
                    osOrdemservicoCollectionNewOsOrdemservico.setCodempresa(empresa);
                    osOrdemservicoCollectionNewOsOrdemservico = em.merge(osOrdemservicoCollectionNewOsOrdemservico);
                    if (oldCodempresaOfOsOrdemservicoCollectionNewOsOrdemservico != null && !oldCodempresaOfOsOrdemservicoCollectionNewOsOrdemservico.equals(empresa)) {
                        oldCodempresaOfOsOrdemservicoCollectionNewOsOrdemservico.getOsOrdemservicoCollection().remove(osOrdemservicoCollectionNewOsOrdemservico);
                        oldCodempresaOfOsOrdemservicoCollectionNewOsOrdemservico = em.merge(oldCodempresaOfOsOrdemservicoCollectionNewOsOrdemservico);
                    }
                }
            }
            for (Produtoestoquelote produtoestoqueloteCollectionOldProdutoestoquelote : produtoestoqueloteCollectionOld) {
                if (!produtoestoqueloteCollectionNew.contains(produtoestoqueloteCollectionOldProdutoestoquelote)) {
                    produtoestoqueloteCollectionOldProdutoestoquelote.setCodempresa(null);
                    produtoestoqueloteCollectionOldProdutoestoquelote = em.merge(produtoestoqueloteCollectionOldProdutoestoquelote);
                }
            }
            for (Produtoestoquelote produtoestoqueloteCollectionNewProdutoestoquelote : produtoestoqueloteCollectionNew) {
                if (!produtoestoqueloteCollectionOld.contains(produtoestoqueloteCollectionNewProdutoestoquelote)) {
                    Empresa oldCodempresaOfProdutoestoqueloteCollectionNewProdutoestoquelote = produtoestoqueloteCollectionNewProdutoestoquelote.getCodempresa();
                    produtoestoqueloteCollectionNewProdutoestoquelote.setCodempresa(empresa);
                    produtoestoqueloteCollectionNewProdutoestoquelote = em.merge(produtoestoqueloteCollectionNewProdutoestoquelote);
                    if (oldCodempresaOfProdutoestoqueloteCollectionNewProdutoestoquelote != null && !oldCodempresaOfProdutoestoqueloteCollectionNewProdutoestoquelote.equals(empresa)) {
                        oldCodempresaOfProdutoestoqueloteCollectionNewProdutoestoquelote.getProdutoestoqueloteCollection().remove(produtoestoqueloteCollectionNewProdutoestoquelote);
                        oldCodempresaOfProdutoestoqueloteCollectionNewProdutoestoquelote = em.merge(oldCodempresaOfProdutoestoqueloteCollectionNewProdutoestoquelote);
                    }
                }
            }
            for (Cotacao cotacaoCollectionOldCotacao : cotacaoCollectionOld) {
                if (!cotacaoCollectionNew.contains(cotacaoCollectionOldCotacao)) {
                    cotacaoCollectionOldCotacao.setCodempresa(null);
                    cotacaoCollectionOldCotacao = em.merge(cotacaoCollectionOldCotacao);
                }
            }
            for (Cotacao cotacaoCollectionNewCotacao : cotacaoCollectionNew) {
                if (!cotacaoCollectionOld.contains(cotacaoCollectionNewCotacao)) {
                    Empresa oldCodempresaOfCotacaoCollectionNewCotacao = cotacaoCollectionNewCotacao.getCodempresa();
                    cotacaoCollectionNewCotacao.setCodempresa(empresa);
                    cotacaoCollectionNewCotacao = em.merge(cotacaoCollectionNewCotacao);
                    if (oldCodempresaOfCotacaoCollectionNewCotacao != null && !oldCodempresaOfCotacaoCollectionNewCotacao.equals(empresa)) {
                        oldCodempresaOfCotacaoCollectionNewCotacao.getCotacaoCollection().remove(cotacaoCollectionNewCotacao);
                        oldCodempresaOfCotacaoCollectionNewCotacao = em.merge(oldCodempresaOfCotacaoCollectionNewCotacao);
                    }
                }
            }
            for (Orcamento orcamentoCollectionOldOrcamento : orcamentoCollectionOld) {
                if (!orcamentoCollectionNew.contains(orcamentoCollectionOldOrcamento)) {
                    orcamentoCollectionOldOrcamento.setCodempresa(null);
                    orcamentoCollectionOldOrcamento = em.merge(orcamentoCollectionOldOrcamento);
                }
            }
            for (Orcamento orcamentoCollectionNewOrcamento : orcamentoCollectionNew) {
                if (!orcamentoCollectionOld.contains(orcamentoCollectionNewOrcamento)) {
                    Empresa oldCodempresaOfOrcamentoCollectionNewOrcamento = orcamentoCollectionNewOrcamento.getCodempresa();
                    orcamentoCollectionNewOrcamento.setCodempresa(empresa);
                    orcamentoCollectionNewOrcamento = em.merge(orcamentoCollectionNewOrcamento);
                    if (oldCodempresaOfOrcamentoCollectionNewOrcamento != null && !oldCodempresaOfOrcamentoCollectionNewOrcamento.equals(empresa)) {
                        oldCodempresaOfOrcamentoCollectionNewOrcamento.getOrcamentoCollection().remove(orcamentoCollectionNewOrcamento);
                        oldCodempresaOfOrcamentoCollectionNewOrcamento = em.merge(oldCodempresaOfOrcamentoCollectionNewOrcamento);
                    }
                }
            }
            for (Movenda movendaCollectionNewMovenda : movendaCollectionNew) {
                if (!movendaCollectionOld.contains(movendaCollectionNewMovenda)) {
                    Empresa oldCodempresaOfMovendaCollectionNewMovenda = movendaCollectionNewMovenda.getCodempresa();
                    movendaCollectionNewMovenda.setCodempresa(empresa);
                    movendaCollectionNewMovenda = em.merge(movendaCollectionNewMovenda);
                    if (oldCodempresaOfMovendaCollectionNewMovenda != null && !oldCodempresaOfMovendaCollectionNewMovenda.equals(empresa)) {
                        oldCodempresaOfMovendaCollectionNewMovenda.getMovendaCollection().remove(movendaCollectionNewMovenda);
                        oldCodempresaOfMovendaCollectionNewMovenda = em.merge(oldCodempresaOfMovendaCollectionNewMovenda);
                    }
                }
            }
            for (Pedido pedidoCollectionNewPedido : pedidoCollectionNew) {
                if (!pedidoCollectionOld.contains(pedidoCollectionNewPedido)) {
                    Empresa oldCodempresaOfPedidoCollectionNewPedido = pedidoCollectionNewPedido.getCodempresa();
                    pedidoCollectionNewPedido.setCodempresa(empresa);
                    pedidoCollectionNewPedido = em.merge(pedidoCollectionNewPedido);
                    if (oldCodempresaOfPedidoCollectionNewPedido != null && !oldCodempresaOfPedidoCollectionNewPedido.equals(empresa)) {
                        oldCodempresaOfPedidoCollectionNewPedido.getPedidoCollection().remove(pedidoCollectionNewPedido);
                        oldCodempresaOfPedidoCollectionNewPedido = em.merge(oldCodempresaOfPedidoCollectionNewPedido);
                    }
                }
            }
            for (Contabancaria contabancariaCollectionOldContabancaria : contabancariaCollectionOld) {
                if (!contabancariaCollectionNew.contains(contabancariaCollectionOldContabancaria)) {
                    contabancariaCollectionOldContabancaria.setCodempresa(null);
                    contabancariaCollectionOldContabancaria = em.merge(contabancariaCollectionOldContabancaria);
                }
            }
            for (Contabancaria contabancariaCollectionNewContabancaria : contabancariaCollectionNew) {
                if (!contabancariaCollectionOld.contains(contabancariaCollectionNewContabancaria)) {
                    Empresa oldCodempresaOfContabancariaCollectionNewContabancaria = contabancariaCollectionNewContabancaria.getCodempresa();
                    contabancariaCollectionNewContabancaria.setCodempresa(empresa);
                    contabancariaCollectionNewContabancaria = em.merge(contabancariaCollectionNewContabancaria);
                    if (oldCodempresaOfContabancariaCollectionNewContabancaria != null && !oldCodempresaOfContabancariaCollectionNewContabancaria.equals(empresa)) {
                        oldCodempresaOfContabancariaCollectionNewContabancaria.getContabancariaCollection().remove(contabancariaCollectionNewContabancaria);
                        oldCodempresaOfContabancariaCollectionNewContabancaria = em.merge(oldCodempresaOfContabancariaCollectionNewContabancaria);
                    }
                }
            }
            for (Orcamentoprod orcamentoprodCollectionNewOrcamentoprod : orcamentoprodCollectionNew) {
                if (!orcamentoprodCollectionOld.contains(orcamentoprodCollectionNewOrcamentoprod)) {
                    Empresa oldCodempresaOfOrcamentoprodCollectionNewOrcamentoprod = orcamentoprodCollectionNewOrcamentoprod.getCodempresa();
                    orcamentoprodCollectionNewOrcamentoprod.setCodempresa(empresa);
                    orcamentoprodCollectionNewOrcamentoprod = em.merge(orcamentoprodCollectionNewOrcamentoprod);
                    if (oldCodempresaOfOrcamentoprodCollectionNewOrcamentoprod != null && !oldCodempresaOfOrcamentoprodCollectionNewOrcamentoprod.equals(empresa)) {
                        oldCodempresaOfOrcamentoprodCollectionNewOrcamentoprod.getOrcamentoprodCollection().remove(orcamentoprodCollectionNewOrcamentoprod);
                        oldCodempresaOfOrcamentoprodCollectionNewOrcamentoprod = em.merge(oldCodempresaOfOrcamentoprodCollectionNewOrcamentoprod);
                    }
                }
            }
            for (Orcamentoprod orcamentoprodCollection1OldOrcamentoprod : orcamentoprodCollection1Old) {
                if (!orcamentoprodCollection1New.contains(orcamentoprodCollection1OldOrcamentoprod)) {
                    orcamentoprodCollection1OldOrcamentoprod.setCodempresaestoque(null);
                    orcamentoprodCollection1OldOrcamentoprod = em.merge(orcamentoprodCollection1OldOrcamentoprod);
                }
            }
            for (Orcamentoprod orcamentoprodCollection1NewOrcamentoprod : orcamentoprodCollection1New) {
                if (!orcamentoprodCollection1Old.contains(orcamentoprodCollection1NewOrcamentoprod)) {
                    Empresa oldCodempresaestoqueOfOrcamentoprodCollection1NewOrcamentoprod = orcamentoprodCollection1NewOrcamentoprod.getCodempresaestoque();
                    orcamentoprodCollection1NewOrcamentoprod.setCodempresaestoque(empresa);
                    orcamentoprodCollection1NewOrcamentoprod = em.merge(orcamentoprodCollection1NewOrcamentoprod);
                    if (oldCodempresaestoqueOfOrcamentoprodCollection1NewOrcamentoprod != null && !oldCodempresaestoqueOfOrcamentoprodCollection1NewOrcamentoprod.equals(empresa)) {
                        oldCodempresaestoqueOfOrcamentoprodCollection1NewOrcamentoprod.getOrcamentoprodCollection1().remove(orcamentoprodCollection1NewOrcamentoprod);
                        oldCodempresaestoqueOfOrcamentoprodCollection1NewOrcamentoprod = em.merge(oldCodempresaestoqueOfOrcamentoprodCollection1NewOrcamentoprod);
                    }
                }
            }
            for (AcertoProdlote acertoProdloteCollectionOldAcertoProdlote : acertoProdloteCollectionOld) {
                if (!acertoProdloteCollectionNew.contains(acertoProdloteCollectionOldAcertoProdlote)) {
                    acertoProdloteCollectionOldAcertoProdlote.setCodempresa(null);
                    acertoProdloteCollectionOldAcertoProdlote = em.merge(acertoProdloteCollectionOldAcertoProdlote);
                }
            }
            for (AcertoProdlote acertoProdloteCollectionNewAcertoProdlote : acertoProdloteCollectionNew) {
                if (!acertoProdloteCollectionOld.contains(acertoProdloteCollectionNewAcertoProdlote)) {
                    Empresa oldCodempresaOfAcertoProdloteCollectionNewAcertoProdlote = acertoProdloteCollectionNewAcertoProdlote.getCodempresa();
                    acertoProdloteCollectionNewAcertoProdlote.setCodempresa(empresa);
                    acertoProdloteCollectionNewAcertoProdlote = em.merge(acertoProdloteCollectionNewAcertoProdlote);
                    if (oldCodempresaOfAcertoProdloteCollectionNewAcertoProdlote != null && !oldCodempresaOfAcertoProdloteCollectionNewAcertoProdlote.equals(empresa)) {
                        oldCodempresaOfAcertoProdloteCollectionNewAcertoProdlote.getAcertoProdloteCollection().remove(acertoProdloteCollectionNewAcertoProdlote);
                        oldCodempresaOfAcertoProdloteCollectionNewAcertoProdlote = em.merge(oldCodempresaOfAcertoProdloteCollectionNewAcertoProdlote);
                    }
                }
            }
            for (Loteentrega loteentregaCollectionOldLoteentrega : loteentregaCollectionOld) {
                if (!loteentregaCollectionNew.contains(loteentregaCollectionOldLoteentrega)) {
                    loteentregaCollectionOldLoteentrega.setCodempresa(null);
                    loteentregaCollectionOldLoteentrega = em.merge(loteentregaCollectionOldLoteentrega);
                }
            }
            for (Loteentrega loteentregaCollectionNewLoteentrega : loteentregaCollectionNew) {
                if (!loteentregaCollectionOld.contains(loteentregaCollectionNewLoteentrega)) {
                    Empresa oldCodempresaOfLoteentregaCollectionNewLoteentrega = loteentregaCollectionNewLoteentrega.getCodempresa();
                    loteentregaCollectionNewLoteentrega.setCodempresa(empresa);
                    loteentregaCollectionNewLoteentrega = em.merge(loteentregaCollectionNewLoteentrega);
                    if (oldCodempresaOfLoteentregaCollectionNewLoteentrega != null && !oldCodempresaOfLoteentregaCollectionNewLoteentrega.equals(empresa)) {
                        oldCodempresaOfLoteentregaCollectionNewLoteentrega.getLoteentregaCollection().remove(loteentregaCollectionNewLoteentrega);
                        oldCodempresaOfLoteentregaCollectionNewLoteentrega = em.merge(oldCodempresaOfLoteentregaCollectionNewLoteentrega);
                    }
                }
            }
            for (AcertoProdfci acertoProdfciCollectionOldAcertoProdfci : acertoProdfciCollectionOld) {
                if (!acertoProdfciCollectionNew.contains(acertoProdfciCollectionOldAcertoProdfci)) {
                    acertoProdfciCollectionOldAcertoProdfci.setCodempresa(null);
                    acertoProdfciCollectionOldAcertoProdfci = em.merge(acertoProdfciCollectionOldAcertoProdfci);
                }
            }
            for (AcertoProdfci acertoProdfciCollectionNewAcertoProdfci : acertoProdfciCollectionNew) {
                if (!acertoProdfciCollectionOld.contains(acertoProdfciCollectionNewAcertoProdfci)) {
                    Empresa oldCodempresaOfAcertoProdfciCollectionNewAcertoProdfci = acertoProdfciCollectionNewAcertoProdfci.getCodempresa();
                    acertoProdfciCollectionNewAcertoProdfci.setCodempresa(empresa);
                    acertoProdfciCollectionNewAcertoProdfci = em.merge(acertoProdfciCollectionNewAcertoProdfci);
                    if (oldCodempresaOfAcertoProdfciCollectionNewAcertoProdfci != null && !oldCodempresaOfAcertoProdfciCollectionNewAcertoProdfci.equals(empresa)) {
                        oldCodempresaOfAcertoProdfciCollectionNewAcertoProdfci.getAcertoProdfciCollection().remove(acertoProdfciCollectionNewAcertoProdfci);
                        oldCodempresaOfAcertoProdfciCollectionNewAcertoProdfci = em.merge(oldCodempresaOfAcertoProdfciCollectionNewAcertoProdfci);
                    }
                }
            }
            for (Empresatipodocumento empresatipodocumentoCollectionNewEmpresatipodocumento : empresatipodocumentoCollectionNew) {
                if (!empresatipodocumentoCollectionOld.contains(empresatipodocumentoCollectionNewEmpresatipodocumento)) {
                    Empresa oldCodempresaOfEmpresatipodocumentoCollectionNewEmpresatipodocumento = empresatipodocumentoCollectionNewEmpresatipodocumento.getCodempresa();
                    empresatipodocumentoCollectionNewEmpresatipodocumento.setCodempresa(empresa);
                    empresatipodocumentoCollectionNewEmpresatipodocumento = em.merge(empresatipodocumentoCollectionNewEmpresatipodocumento);
                    if (oldCodempresaOfEmpresatipodocumentoCollectionNewEmpresatipodocumento != null && !oldCodempresaOfEmpresatipodocumentoCollectionNewEmpresatipodocumento.equals(empresa)) {
                        oldCodempresaOfEmpresatipodocumentoCollectionNewEmpresatipodocumento.getEmpresatipodocumentoCollection().remove(empresatipodocumentoCollectionNewEmpresatipodocumento);
                        oldCodempresaOfEmpresatipodocumentoCollectionNewEmpresatipodocumento = em.merge(oldCodempresaOfEmpresatipodocumentoCollectionNewEmpresatipodocumento);
                    }
                }
            }
            for (Cliente clienteCollectionOldCliente : clienteCollectionOld) {
                if (!clienteCollectionNew.contains(clienteCollectionOldCliente)) {
                    clienteCollectionOldCliente.setCodempresa(null);
                    clienteCollectionOldCliente = em.merge(clienteCollectionOldCliente);
                }
            }
            for (Cliente clienteCollectionNewCliente : clienteCollectionNew) {
                if (!clienteCollectionOld.contains(clienteCollectionNewCliente)) {
                    Empresa oldCodempresaOfClienteCollectionNewCliente = clienteCollectionNewCliente.getCodempresa();
                    clienteCollectionNewCliente.setCodempresa(empresa);
                    clienteCollectionNewCliente = em.merge(clienteCollectionNewCliente);
                    if (oldCodempresaOfClienteCollectionNewCliente != null && !oldCodempresaOfClienteCollectionNewCliente.equals(empresa)) {
                        oldCodempresaOfClienteCollectionNewCliente.getClienteCollection().remove(clienteCollectionNewCliente);
                        oldCodempresaOfClienteCollectionNewCliente = em.merge(oldCodempresaOfClienteCollectionNewCliente);
                    }
                }
            }
            for (Mdfeletronico mdfeletronicoCollectionNewMdfeletronico : mdfeletronicoCollectionNew) {
                if (!mdfeletronicoCollectionOld.contains(mdfeletronicoCollectionNewMdfeletronico)) {
                    Empresa oldCodempresaOfMdfeletronicoCollectionNewMdfeletronico = mdfeletronicoCollectionNewMdfeletronico.getCodempresa();
                    mdfeletronicoCollectionNewMdfeletronico.setCodempresa(empresa);
                    mdfeletronicoCollectionNewMdfeletronico = em.merge(mdfeletronicoCollectionNewMdfeletronico);
                    if (oldCodempresaOfMdfeletronicoCollectionNewMdfeletronico != null && !oldCodempresaOfMdfeletronicoCollectionNewMdfeletronico.equals(empresa)) {
                        oldCodempresaOfMdfeletronicoCollectionNewMdfeletronico.getMdfeletronicoCollection().remove(mdfeletronicoCollectionNewMdfeletronico);
                        oldCodempresaOfMdfeletronicoCollectionNewMdfeletronico = em.merge(oldCodempresaOfMdfeletronicoCollectionNewMdfeletronico);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = empresa.getCodempresa();
                if (findEmpresa(id) == null) {
                    throw new NonexistentEntityException("The empresa with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa empresa;
            try {
                empresa = em.getReference(Empresa.class, id);
                empresa.getCodempresa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empresa with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Chequesfirma> chequesfirmaCollectionOrphanCheck = empresa.getChequesfirmaCollection();
            for (Chequesfirma chequesfirmaCollectionOrphanCheckChequesfirma : chequesfirmaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Chequesfirma " + chequesfirmaCollectionOrphanCheckChequesfirma + " in its chequesfirmaCollection field has a non-nullable codempresa field.");
            }
            Collection<Moventrada> moventradaCollectionOrphanCheck = empresa.getMoventradaCollection();
            for (Moventrada moventradaCollectionOrphanCheckMoventrada : moventradaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Moventrada " + moventradaCollectionOrphanCheckMoventrada + " in its moventradaCollection field has a non-nullable codempresa field.");
            }
            Collection<Caixa> caixaCollectionOrphanCheck = empresa.getCaixaCollection();
            for (Caixa caixaCollectionOrphanCheckCaixa : caixaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Caixa " + caixaCollectionOrphanCheckCaixa + " in its caixaCollection field has a non-nullable codempresa field.");
            }
            Collection<Empresauf> empresaufCollectionOrphanCheck = empresa.getEmpresaufCollection();
            for (Empresauf empresaufCollectionOrphanCheckEmpresauf : empresaufCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Empresauf " + empresaufCollectionOrphanCheckEmpresauf + " in its empresaufCollection field has a non-nullable codempresa field.");
            }
            Collection<Lancafinanceira> lancafinanceiraCollectionOrphanCheck = empresa.getLancafinanceiraCollection();
            for (Lancafinanceira lancafinanceiraCollectionOrphanCheckLancafinanceira : lancafinanceiraCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Lancafinanceira " + lancafinanceiraCollectionOrphanCheckLancafinanceira + " in its lancafinanceiraCollection field has a non-nullable codempresa field.");
            }
            Collection<Contapagarpag> contapagarpagCollectionOrphanCheck = empresa.getContapagarpagCollection();
            for (Contapagarpag contapagarpagCollectionOrphanCheckContapagarpag : contapagarpagCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Contapagarpag " + contapagarpagCollectionOrphanCheckContapagarpag + " in its contapagarpagCollection field has a non-nullable codempresa field.");
            }
            Collection<Contapagar> contapagarCollectionOrphanCheck = empresa.getContapagarCollection();
            for (Contapagar contapagarCollectionOrphanCheckContapagar : contapagarCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Contapagar " + contapagarCollectionOrphanCheckContapagar + " in its contapagarCollection field has a non-nullable codempresa field.");
            }
            Collection<Contareceberrec> contareceberrecCollectionOrphanCheck = empresa.getContareceberrecCollection();
            for (Contareceberrec contareceberrecCollectionOrphanCheckContareceberrec : contareceberrecCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Contareceberrec " + contareceberrecCollectionOrphanCheckContareceberrec + " in its contareceberrecCollection field has a non-nullable codempresa field.");
            }
            Collection<Produtoestoque> produtoestoqueCollectionOrphanCheck = empresa.getProdutoestoqueCollection();
            for (Produtoestoque produtoestoqueCollectionOrphanCheckProdutoestoque : produtoestoqueCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Produtoestoque " + produtoestoqueCollectionOrphanCheckProdutoestoque + " in its produtoestoqueCollection field has a non-nullable empresa field.");
            }
            Collection<Atendimento> atendimentoCollectionOrphanCheck = empresa.getAtendimentoCollection();
            for (Atendimento atendimentoCollectionOrphanCheckAtendimento : atendimentoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Atendimento " + atendimentoCollectionOrphanCheckAtendimento + " in its atendimentoCollection field has a non-nullable codempresa field.");
            }
            Collection<Cheques> chequesCollectionOrphanCheck = empresa.getChequesCollection();
            for (Cheques chequesCollectionOrphanCheckCheques : chequesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Cheques " + chequesCollectionOrphanCheckCheques + " in its chequesCollection field has a non-nullable codempresa field.");
            }
            Collection<Acerto> acertoCollectionOrphanCheck = empresa.getAcertoCollection();
            for (Acerto acertoCollectionOrphanCheckAcerto : acertoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Acerto " + acertoCollectionOrphanCheckAcerto + " in its acertoCollection field has a non-nullable codempresa field.");
            }
            Collection<Lancacartao> lancacartaoCollectionOrphanCheck = empresa.getLancacartaoCollection();
            for (Lancacartao lancacartaoCollectionOrphanCheckLancacartao : lancacartaoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Lancacartao " + lancacartaoCollectionOrphanCheckLancacartao + " in its lancacartaoCollection field has a non-nullable codempresa field.");
            }
            Collection<OsOrdemservico> osOrdemservicoCollectionOrphanCheck = empresa.getOsOrdemservicoCollection();
            for (OsOrdemservico osOrdemservicoCollectionOrphanCheckOsOrdemservico : osOrdemservicoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the OsOrdemservico " + osOrdemservicoCollectionOrphanCheckOsOrdemservico + " in its osOrdemservicoCollection field has a non-nullable codempresa field.");
            }
            Collection<Movenda> movendaCollectionOrphanCheck = empresa.getMovendaCollection();
            for (Movenda movendaCollectionOrphanCheckMovenda : movendaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Movenda " + movendaCollectionOrphanCheckMovenda + " in its movendaCollection field has a non-nullable codempresa field.");
            }
            Collection<Pedido> pedidoCollectionOrphanCheck = empresa.getPedidoCollection();
            for (Pedido pedidoCollectionOrphanCheckPedido : pedidoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Pedido " + pedidoCollectionOrphanCheckPedido + " in its pedidoCollection field has a non-nullable codempresa field.");
            }
            Collection<Orcamentoprod> orcamentoprodCollectionOrphanCheck = empresa.getOrcamentoprodCollection();
            for (Orcamentoprod orcamentoprodCollectionOrphanCheckOrcamentoprod : orcamentoprodCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Orcamentoprod " + orcamentoprodCollectionOrphanCheckOrcamentoprod + " in its orcamentoprodCollection field has a non-nullable codempresa field.");
            }
            Collection<Empresatipodocumento> empresatipodocumentoCollectionOrphanCheck = empresa.getEmpresatipodocumentoCollection();
            for (Empresatipodocumento empresatipodocumentoCollectionOrphanCheckEmpresatipodocumento : empresatipodocumentoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Empresatipodocumento " + empresatipodocumentoCollectionOrphanCheckEmpresatipodocumento + " in its empresatipodocumentoCollection field has a non-nullable codempresa field.");
            }
            Collection<Mdfeletronico> mdfeletronicoCollectionOrphanCheck = empresa.getMdfeletronicoCollection();
            for (Mdfeletronico mdfeletronicoCollectionOrphanCheckMdfeletronico : mdfeletronicoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Mdfeletronico " + mdfeletronicoCollectionOrphanCheckMdfeletronico + " in its mdfeletronicoCollection field has a non-nullable codempresa field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Manifestacaodestinatario> manifestacaodestinatarioCollection = empresa.getManifestacaodestinatarioCollection();
            for (Manifestacaodestinatario manifestacaodestinatarioCollectionManifestacaodestinatario : manifestacaodestinatarioCollection) {
                manifestacaodestinatarioCollectionManifestacaodestinatario.setCodempresa(null);
                manifestacaodestinatarioCollectionManifestacaodestinatario = em.merge(manifestacaodestinatarioCollectionManifestacaodestinatario);
            }
            Collection<Recibo> reciboCollection = empresa.getReciboCollection();
            for (Recibo reciboCollectionRecibo : reciboCollection) {
                reciboCollectionRecibo.setCodempresa(null);
                reciboCollectionRecibo = em.merge(reciboCollectionRecibo);
            }
            Collection<Moconvenio> moconvenioCollection = empresa.getMoconvenioCollection();
            for (Moconvenio moconvenioCollectionMoconvenio : moconvenioCollection) {
                moconvenioCollectionMoconvenio.setCodempresa(null);
                moconvenioCollectionMoconvenio = em.merge(moconvenioCollectionMoconvenio);
            }
            Collection<Movecfrzitem> movecfrzitemCollection = empresa.getMovecfrzitemCollection();
            for (Movecfrzitem movecfrzitemCollectionMovecfrzitem : movecfrzitemCollection) {
                movecfrzitemCollectionMovecfrzitem.setCodempresa(null);
                movecfrzitemCollectionMovecfrzitem = em.merge(movecfrzitemCollectionMovecfrzitem);
            }
            Collection<Documento> documentoCollection = empresa.getDocumentoCollection();
            for (Documento documentoCollectionDocumento : documentoCollection) {
                documentoCollectionDocumento.setCodempresa(null);
                documentoCollectionDocumento = em.merge(documentoCollectionDocumento);
            }
            Collection<Usuario> usuarioCollection = empresa.getUsuarioCollection();
            for (Usuario usuarioCollectionUsuario : usuarioCollection) {
                usuarioCollectionUsuario.setCodempresa(null);
                usuarioCollectionUsuario = em.merge(usuarioCollectionUsuario);
            }
            Collection<Movecfdocumentocaixa> movecfdocumentocaixaCollection = empresa.getMovecfdocumentocaixaCollection();
            for (Movecfdocumentocaixa movecfdocumentocaixaCollectionMovecfdocumentocaixa : movecfdocumentocaixaCollection) {
                movecfdocumentocaixaCollectionMovecfdocumentocaixa.setCodempresa(null);
                movecfdocumentocaixaCollectionMovecfdocumentocaixa = em.merge(movecfdocumentocaixaCollectionMovecfdocumentocaixa);
            }
            Collection<Contareceber> contareceberCollection = empresa.getContareceberCollection();
            for (Contareceber contareceberCollectionContareceber : contareceberCollection) {
                contareceberCollectionContareceber.setCodempresa(null);
                contareceberCollectionContareceber = em.merge(contareceberCollectionContareceber);
            }
            Collection<Veiculos> veiculosCollection = empresa.getVeiculosCollection();
            for (Veiculos veiculosCollectionVeiculos : veiculosCollection) {
                veiculosCollectionVeiculos.setCodempresa(null);
                veiculosCollectionVeiculos = em.merge(veiculosCollectionVeiculos);
            }
            Collection<Movecfdocumento> movecfdocumentoCollection = empresa.getMovecfdocumentoCollection();
            for (Movecfdocumento movecfdocumentoCollectionMovecfdocumento : movecfdocumentoCollection) {
                movecfdocumentoCollectionMovecfdocumento.setCodempresa(null);
                movecfdocumentoCollectionMovecfdocumento = em.merge(movecfdocumentoCollectionMovecfdocumento);
            }
            Collection<Contratocobranca> contratocobrancaCollection = empresa.getContratocobrancaCollection();
            for (Contratocobranca contratocobrancaCollectionContratocobranca : contratocobrancaCollection) {
                contratocobrancaCollectionContratocobranca.setCodempresa(null);
                contratocobrancaCollectionContratocobranca = em.merge(contratocobrancaCollectionContratocobranca);
            }
            Collection<Produtoestoquelote> produtoestoqueloteCollection = empresa.getProdutoestoqueloteCollection();
            for (Produtoestoquelote produtoestoqueloteCollectionProdutoestoquelote : produtoestoqueloteCollection) {
                produtoestoqueloteCollectionProdutoestoquelote.setCodempresa(null);
                produtoestoqueloteCollectionProdutoestoquelote = em.merge(produtoestoqueloteCollectionProdutoestoquelote);
            }
            Collection<Cotacao> cotacaoCollection = empresa.getCotacaoCollection();
            for (Cotacao cotacaoCollectionCotacao : cotacaoCollection) {
                cotacaoCollectionCotacao.setCodempresa(null);
                cotacaoCollectionCotacao = em.merge(cotacaoCollectionCotacao);
            }
            Collection<Orcamento> orcamentoCollection = empresa.getOrcamentoCollection();
            for (Orcamento orcamentoCollectionOrcamento : orcamentoCollection) {
                orcamentoCollectionOrcamento.setCodempresa(null);
                orcamentoCollectionOrcamento = em.merge(orcamentoCollectionOrcamento);
            }
            Collection<Contabancaria> contabancariaCollection = empresa.getContabancariaCollection();
            for (Contabancaria contabancariaCollectionContabancaria : contabancariaCollection) {
                contabancariaCollectionContabancaria.setCodempresa(null);
                contabancariaCollectionContabancaria = em.merge(contabancariaCollectionContabancaria);
            }
            Collection<Orcamentoprod> orcamentoprodCollection1 = empresa.getOrcamentoprodCollection1();
            for (Orcamentoprod orcamentoprodCollection1Orcamentoprod : orcamentoprodCollection1) {
                orcamentoprodCollection1Orcamentoprod.setCodempresaestoque(null);
                orcamentoprodCollection1Orcamentoprod = em.merge(orcamentoprodCollection1Orcamentoprod);
            }
            Collection<AcertoProdlote> acertoProdloteCollection = empresa.getAcertoProdloteCollection();
            for (AcertoProdlote acertoProdloteCollectionAcertoProdlote : acertoProdloteCollection) {
                acertoProdloteCollectionAcertoProdlote.setCodempresa(null);
                acertoProdloteCollectionAcertoProdlote = em.merge(acertoProdloteCollectionAcertoProdlote);
            }
            Collection<Loteentrega> loteentregaCollection = empresa.getLoteentregaCollection();
            for (Loteentrega loteentregaCollectionLoteentrega : loteentregaCollection) {
                loteentregaCollectionLoteentrega.setCodempresa(null);
                loteentregaCollectionLoteentrega = em.merge(loteentregaCollectionLoteentrega);
            }
            Collection<AcertoProdfci> acertoProdfciCollection = empresa.getAcertoProdfciCollection();
            for (AcertoProdfci acertoProdfciCollectionAcertoProdfci : acertoProdfciCollection) {
                acertoProdfciCollectionAcertoProdfci.setCodempresa(null);
                acertoProdfciCollectionAcertoProdfci = em.merge(acertoProdfciCollectionAcertoProdfci);
            }
            Collection<Cliente> clienteCollection = empresa.getClienteCollection();
            for (Cliente clienteCollectionCliente : clienteCollection) {
                clienteCollectionCliente.setCodempresa(null);
                clienteCollectionCliente = em.merge(clienteCollectionCliente);
            }
            em.remove(empresa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empresa> findEmpresaEntities() {
        return findEmpresaEntities(true, -1, -1);
    }

    public List<Empresa> findEmpresaEntities(int maxResults, int firstResult) {
        return findEmpresaEntities(false, maxResults, firstResult);
    }

    private List<Empresa> findEmpresaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empresa.class));
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

    public Empresa findEmpresa(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empresa.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpresaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empresa> rt = cq.from(Empresa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

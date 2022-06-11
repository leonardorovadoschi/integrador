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
import entidade.cplus.Vendedor;
import entidade.cplus.Moventrada;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Moventradaprod;
import entidade.cplus.OsTecnico;
import entidade.cplus.Documento;
import entidade.cplus.Cheques;
import entidade.cplus.Rma;
import entidade.cplus.Vendedorsecao;
import entidade.cplus.Usuario;
import entidade.cplus.Movendaprod;
import entidade.cplus.Chequeshistorico;
import entidade.cplus.Vendedorcaracteristica;
import entidade.cplus.Orcamento;
import entidade.cplus.Movenda;
import entidade.cplus.Orcamentoprod;
import entidade.cplus.Cliente;
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
public class VendedorJpaController implements Serializable {

    public VendedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vendedor vendedor) throws PreexistingEntityException, Exception {
        if (vendedor.getMoventradaCollection() == null) {
            vendedor.setMoventradaCollection(new ArrayList<Moventrada>());
        }
        if (vendedor.getMoventradaprodCollection() == null) {
            vendedor.setMoventradaprodCollection(new ArrayList<Moventradaprod>());
        }
        if (vendedor.getVendedorCollection() == null) {
            vendedor.setVendedorCollection(new ArrayList<Vendedor>());
        }
        if (vendedor.getOsTecnicoCollection() == null) {
            vendedor.setOsTecnicoCollection(new ArrayList<OsTecnico>());
        }
        if (vendedor.getDocumentoCollection() == null) {
            vendedor.setDocumentoCollection(new ArrayList<Documento>());
        }
        if (vendedor.getDocumentoCollection1() == null) {
            vendedor.setDocumentoCollection1(new ArrayList<Documento>());
        }
        if (vendedor.getChequesCollection() == null) {
            vendedor.setChequesCollection(new ArrayList<Cheques>());
        }
        if (vendedor.getRmaCollection() == null) {
            vendedor.setRmaCollection(new ArrayList<Rma>());
        }
        if (vendedor.getVendedorsecaoCollection() == null) {
            vendedor.setVendedorsecaoCollection(new ArrayList<Vendedorsecao>());
        }
        if (vendedor.getUsuarioCollection() == null) {
            vendedor.setUsuarioCollection(new ArrayList<Usuario>());
        }
        if (vendedor.getMovendaprodCollection() == null) {
            vendedor.setMovendaprodCollection(new ArrayList<Movendaprod>());
        }
        if (vendedor.getChequeshistoricoCollection() == null) {
            vendedor.setChequeshistoricoCollection(new ArrayList<Chequeshistorico>());
        }
        if (vendedor.getVendedorcaracteristicaCollection() == null) {
            vendedor.setVendedorcaracteristicaCollection(new ArrayList<Vendedorcaracteristica>());
        }
        if (vendedor.getOrcamentoCollection() == null) {
            vendedor.setOrcamentoCollection(new ArrayList<Orcamento>());
        }
        if (vendedor.getOrcamentoCollection1() == null) {
            vendedor.setOrcamentoCollection1(new ArrayList<Orcamento>());
        }
        if (vendedor.getMovendaCollection() == null) {
            vendedor.setMovendaCollection(new ArrayList<Movenda>());
        }
        if (vendedor.getMovendaCollection1() == null) {
            vendedor.setMovendaCollection1(new ArrayList<Movenda>());
        }
        if (vendedor.getOrcamentoprodCollection() == null) {
            vendedor.setOrcamentoprodCollection(new ArrayList<Orcamentoprod>());
        }
        if (vendedor.getClienteCollection() == null) {
            vendedor.setClienteCollection(new ArrayList<Cliente>());
        }
        if (vendedor.getClienteCollection1() == null) {
            vendedor.setClienteCollection1(new ArrayList<Cliente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vendedor codvendedsupervisor = vendedor.getCodvendedsupervisor();
            if (codvendedsupervisor != null) {
                codvendedsupervisor = em.getReference(codvendedsupervisor.getClass(), codvendedsupervisor.getCodvended());
                vendedor.setCodvendedsupervisor(codvendedsupervisor);
            }
            Collection<Moventrada> attachedMoventradaCollection = new ArrayList<Moventrada>();
            for (Moventrada moventradaCollectionMoventradaToAttach : vendedor.getMoventradaCollection()) {
                moventradaCollectionMoventradaToAttach = em.getReference(moventradaCollectionMoventradaToAttach.getClass(), moventradaCollectionMoventradaToAttach.getCodmoventr());
                attachedMoventradaCollection.add(moventradaCollectionMoventradaToAttach);
            }
            vendedor.setMoventradaCollection(attachedMoventradaCollection);
            Collection<Moventradaprod> attachedMoventradaprodCollection = new ArrayList<Moventradaprod>();
            for (Moventradaprod moventradaprodCollectionMoventradaprodToAttach : vendedor.getMoventradaprodCollection()) {
                moventradaprodCollectionMoventradaprodToAttach = em.getReference(moventradaprodCollectionMoventradaprodToAttach.getClass(), moventradaprodCollectionMoventradaprodToAttach.getCodmoveprod());
                attachedMoventradaprodCollection.add(moventradaprodCollectionMoventradaprodToAttach);
            }
            vendedor.setMoventradaprodCollection(attachedMoventradaprodCollection);
            Collection<Vendedor> attachedVendedorCollection = new ArrayList<Vendedor>();
            for (Vendedor vendedorCollectionVendedorToAttach : vendedor.getVendedorCollection()) {
                vendedorCollectionVendedorToAttach = em.getReference(vendedorCollectionVendedorToAttach.getClass(), vendedorCollectionVendedorToAttach.getCodvended());
                attachedVendedorCollection.add(vendedorCollectionVendedorToAttach);
            }
            vendedor.setVendedorCollection(attachedVendedorCollection);
            Collection<OsTecnico> attachedOsTecnicoCollection = new ArrayList<OsTecnico>();
            for (OsTecnico osTecnicoCollectionOsTecnicoToAttach : vendedor.getOsTecnicoCollection()) {
                osTecnicoCollectionOsTecnicoToAttach = em.getReference(osTecnicoCollectionOsTecnicoToAttach.getClass(), osTecnicoCollectionOsTecnicoToAttach.getCodtec());
                attachedOsTecnicoCollection.add(osTecnicoCollectionOsTecnicoToAttach);
            }
            vendedor.setOsTecnicoCollection(attachedOsTecnicoCollection);
            Collection<Documento> attachedDocumentoCollection = new ArrayList<Documento>();
            for (Documento documentoCollectionDocumentoToAttach : vendedor.getDocumentoCollection()) {
                documentoCollectionDocumentoToAttach = em.getReference(documentoCollectionDocumentoToAttach.getClass(), documentoCollectionDocumentoToAttach.getCoddocumento());
                attachedDocumentoCollection.add(documentoCollectionDocumentoToAttach);
            }
            vendedor.setDocumentoCollection(attachedDocumentoCollection);
            Collection<Documento> attachedDocumentoCollection1 = new ArrayList<Documento>();
            for (Documento documentoCollection1DocumentoToAttach : vendedor.getDocumentoCollection1()) {
                documentoCollection1DocumentoToAttach = em.getReference(documentoCollection1DocumentoToAttach.getClass(), documentoCollection1DocumentoToAttach.getCoddocumento());
                attachedDocumentoCollection1.add(documentoCollection1DocumentoToAttach);
            }
            vendedor.setDocumentoCollection1(attachedDocumentoCollection1);
            Collection<Cheques> attachedChequesCollection = new ArrayList<Cheques>();
            for (Cheques chequesCollectionChequesToAttach : vendedor.getChequesCollection()) {
                chequesCollectionChequesToAttach = em.getReference(chequesCollectionChequesToAttach.getClass(), chequesCollectionChequesToAttach.getCodcheque());
                attachedChequesCollection.add(chequesCollectionChequesToAttach);
            }
            vendedor.setChequesCollection(attachedChequesCollection);
            Collection<Rma> attachedRmaCollection = new ArrayList<Rma>();
            for (Rma rmaCollectionRmaToAttach : vendedor.getRmaCollection()) {
                rmaCollectionRmaToAttach = em.getReference(rmaCollectionRmaToAttach.getClass(), rmaCollectionRmaToAttach.getCodrma());
                attachedRmaCollection.add(rmaCollectionRmaToAttach);
            }
            vendedor.setRmaCollection(attachedRmaCollection);
            Collection<Vendedorsecao> attachedVendedorsecaoCollection = new ArrayList<Vendedorsecao>();
            for (Vendedorsecao vendedorsecaoCollectionVendedorsecaoToAttach : vendedor.getVendedorsecaoCollection()) {
                vendedorsecaoCollectionVendedorsecaoToAttach = em.getReference(vendedorsecaoCollectionVendedorsecaoToAttach.getClass(), vendedorsecaoCollectionVendedorsecaoToAttach.getCodvendedorsecao());
                attachedVendedorsecaoCollection.add(vendedorsecaoCollectionVendedorsecaoToAttach);
            }
            vendedor.setVendedorsecaoCollection(attachedVendedorsecaoCollection);
            Collection<Usuario> attachedUsuarioCollection = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionUsuarioToAttach : vendedor.getUsuarioCollection()) {
                usuarioCollectionUsuarioToAttach = em.getReference(usuarioCollectionUsuarioToAttach.getClass(), usuarioCollectionUsuarioToAttach.getCoduser());
                attachedUsuarioCollection.add(usuarioCollectionUsuarioToAttach);
            }
            vendedor.setUsuarioCollection(attachedUsuarioCollection);
            Collection<Movendaprod> attachedMovendaprodCollection = new ArrayList<Movendaprod>();
            for (Movendaprod movendaprodCollectionMovendaprodToAttach : vendedor.getMovendaprodCollection()) {
                movendaprodCollectionMovendaprodToAttach = em.getReference(movendaprodCollectionMovendaprodToAttach.getClass(), movendaprodCollectionMovendaprodToAttach.getCodmovprod());
                attachedMovendaprodCollection.add(movendaprodCollectionMovendaprodToAttach);
            }
            vendedor.setMovendaprodCollection(attachedMovendaprodCollection);
            Collection<Chequeshistorico> attachedChequeshistoricoCollection = new ArrayList<Chequeshistorico>();
            for (Chequeshistorico chequeshistoricoCollectionChequeshistoricoToAttach : vendedor.getChequeshistoricoCollection()) {
                chequeshistoricoCollectionChequeshistoricoToAttach = em.getReference(chequeshistoricoCollectionChequeshistoricoToAttach.getClass(), chequeshistoricoCollectionChequeshistoricoToAttach.getCodchequeshistorico());
                attachedChequeshistoricoCollection.add(chequeshistoricoCollectionChequeshistoricoToAttach);
            }
            vendedor.setChequeshistoricoCollection(attachedChequeshistoricoCollection);
            Collection<Vendedorcaracteristica> attachedVendedorcaracteristicaCollection = new ArrayList<Vendedorcaracteristica>();
            for (Vendedorcaracteristica vendedorcaracteristicaCollectionVendedorcaracteristicaToAttach : vendedor.getVendedorcaracteristicaCollection()) {
                vendedorcaracteristicaCollectionVendedorcaracteristicaToAttach = em.getReference(vendedorcaracteristicaCollectionVendedorcaracteristicaToAttach.getClass(), vendedorcaracteristicaCollectionVendedorcaracteristicaToAttach.getCodvendedorcaracteristica());
                attachedVendedorcaracteristicaCollection.add(vendedorcaracteristicaCollectionVendedorcaracteristicaToAttach);
            }
            vendedor.setVendedorcaracteristicaCollection(attachedVendedorcaracteristicaCollection);
            Collection<Orcamento> attachedOrcamentoCollection = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollectionOrcamentoToAttach : vendedor.getOrcamentoCollection()) {
                orcamentoCollectionOrcamentoToAttach = em.getReference(orcamentoCollectionOrcamentoToAttach.getClass(), orcamentoCollectionOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollection.add(orcamentoCollectionOrcamentoToAttach);
            }
            vendedor.setOrcamentoCollection(attachedOrcamentoCollection);
            Collection<Orcamento> attachedOrcamentoCollection1 = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollection1OrcamentoToAttach : vendedor.getOrcamentoCollection1()) {
                orcamentoCollection1OrcamentoToAttach = em.getReference(orcamentoCollection1OrcamentoToAttach.getClass(), orcamentoCollection1OrcamentoToAttach.getCodorc());
                attachedOrcamentoCollection1.add(orcamentoCollection1OrcamentoToAttach);
            }
            vendedor.setOrcamentoCollection1(attachedOrcamentoCollection1);
            Collection<Movenda> attachedMovendaCollection = new ArrayList<Movenda>();
            for (Movenda movendaCollectionMovendaToAttach : vendedor.getMovendaCollection()) {
                movendaCollectionMovendaToAttach = em.getReference(movendaCollectionMovendaToAttach.getClass(), movendaCollectionMovendaToAttach.getCodmovenda());
                attachedMovendaCollection.add(movendaCollectionMovendaToAttach);
            }
            vendedor.setMovendaCollection(attachedMovendaCollection);
            Collection<Movenda> attachedMovendaCollection1 = new ArrayList<Movenda>();
            for (Movenda movendaCollection1MovendaToAttach : vendedor.getMovendaCollection1()) {
                movendaCollection1MovendaToAttach = em.getReference(movendaCollection1MovendaToAttach.getClass(), movendaCollection1MovendaToAttach.getCodmovenda());
                attachedMovendaCollection1.add(movendaCollection1MovendaToAttach);
            }
            vendedor.setMovendaCollection1(attachedMovendaCollection1);
            Collection<Orcamentoprod> attachedOrcamentoprodCollection = new ArrayList<Orcamentoprod>();
            for (Orcamentoprod orcamentoprodCollectionOrcamentoprodToAttach : vendedor.getOrcamentoprodCollection()) {
                orcamentoprodCollectionOrcamentoprodToAttach = em.getReference(orcamentoprodCollectionOrcamentoprodToAttach.getClass(), orcamentoprodCollectionOrcamentoprodToAttach.getCodorcprod());
                attachedOrcamentoprodCollection.add(orcamentoprodCollectionOrcamentoprodToAttach);
            }
            vendedor.setOrcamentoprodCollection(attachedOrcamentoprodCollection);
            Collection<Cliente> attachedClienteCollection = new ArrayList<Cliente>();
            for (Cliente clienteCollectionClienteToAttach : vendedor.getClienteCollection()) {
                clienteCollectionClienteToAttach = em.getReference(clienteCollectionClienteToAttach.getClass(), clienteCollectionClienteToAttach.getCodcli());
                attachedClienteCollection.add(clienteCollectionClienteToAttach);
            }
            vendedor.setClienteCollection(attachedClienteCollection);
            Collection<Cliente> attachedClienteCollection1 = new ArrayList<Cliente>();
            for (Cliente clienteCollection1ClienteToAttach : vendedor.getClienteCollection1()) {
                clienteCollection1ClienteToAttach = em.getReference(clienteCollection1ClienteToAttach.getClass(), clienteCollection1ClienteToAttach.getCodcli());
                attachedClienteCollection1.add(clienteCollection1ClienteToAttach);
            }
            vendedor.setClienteCollection1(attachedClienteCollection1);
            em.persist(vendedor);
            if (codvendedsupervisor != null) {
                codvendedsupervisor.getVendedorCollection().add(vendedor);
                codvendedsupervisor = em.merge(codvendedsupervisor);
            }
            for (Moventrada moventradaCollectionMoventrada : vendedor.getMoventradaCollection()) {
                Vendedor oldCodvendedOfMoventradaCollectionMoventrada = moventradaCollectionMoventrada.getCodvended();
                moventradaCollectionMoventrada.setCodvended(vendedor);
                moventradaCollectionMoventrada = em.merge(moventradaCollectionMoventrada);
                if (oldCodvendedOfMoventradaCollectionMoventrada != null) {
                    oldCodvendedOfMoventradaCollectionMoventrada.getMoventradaCollection().remove(moventradaCollectionMoventrada);
                    oldCodvendedOfMoventradaCollectionMoventrada = em.merge(oldCodvendedOfMoventradaCollectionMoventrada);
                }
            }
            for (Moventradaprod moventradaprodCollectionMoventradaprod : vendedor.getMoventradaprodCollection()) {
                Vendedor oldCodvendedOfMoventradaprodCollectionMoventradaprod = moventradaprodCollectionMoventradaprod.getCodvended();
                moventradaprodCollectionMoventradaprod.setCodvended(vendedor);
                moventradaprodCollectionMoventradaprod = em.merge(moventradaprodCollectionMoventradaprod);
                if (oldCodvendedOfMoventradaprodCollectionMoventradaprod != null) {
                    oldCodvendedOfMoventradaprodCollectionMoventradaprod.getMoventradaprodCollection().remove(moventradaprodCollectionMoventradaprod);
                    oldCodvendedOfMoventradaprodCollectionMoventradaprod = em.merge(oldCodvendedOfMoventradaprodCollectionMoventradaprod);
                }
            }
            for (Vendedor vendedorCollectionVendedor : vendedor.getVendedorCollection()) {
                Vendedor oldCodvendedsupervisorOfVendedorCollectionVendedor = vendedorCollectionVendedor.getCodvendedsupervisor();
                vendedorCollectionVendedor.setCodvendedsupervisor(vendedor);
                vendedorCollectionVendedor = em.merge(vendedorCollectionVendedor);
                if (oldCodvendedsupervisorOfVendedorCollectionVendedor != null) {
                    oldCodvendedsupervisorOfVendedorCollectionVendedor.getVendedorCollection().remove(vendedorCollectionVendedor);
                    oldCodvendedsupervisorOfVendedorCollectionVendedor = em.merge(oldCodvendedsupervisorOfVendedorCollectionVendedor);
                }
            }
            for (OsTecnico osTecnicoCollectionOsTecnico : vendedor.getOsTecnicoCollection()) {
                Vendedor oldCodvendedOfOsTecnicoCollectionOsTecnico = osTecnicoCollectionOsTecnico.getCodvended();
                osTecnicoCollectionOsTecnico.setCodvended(vendedor);
                osTecnicoCollectionOsTecnico = em.merge(osTecnicoCollectionOsTecnico);
                if (oldCodvendedOfOsTecnicoCollectionOsTecnico != null) {
                    oldCodvendedOfOsTecnicoCollectionOsTecnico.getOsTecnicoCollection().remove(osTecnicoCollectionOsTecnico);
                    oldCodvendedOfOsTecnicoCollectionOsTecnico = em.merge(oldCodvendedOfOsTecnicoCollectionOsTecnico);
                }
            }
            for (Documento documentoCollectionDocumento : vendedor.getDocumentoCollection()) {
                Vendedor oldCodvendedOfDocumentoCollectionDocumento = documentoCollectionDocumento.getCodvended();
                documentoCollectionDocumento.setCodvended(vendedor);
                documentoCollectionDocumento = em.merge(documentoCollectionDocumento);
                if (oldCodvendedOfDocumentoCollectionDocumento != null) {
                    oldCodvendedOfDocumentoCollectionDocumento.getDocumentoCollection().remove(documentoCollectionDocumento);
                    oldCodvendedOfDocumentoCollectionDocumento = em.merge(oldCodvendedOfDocumentoCollectionDocumento);
                }
            }
            for (Documento documentoCollection1Documento : vendedor.getDocumentoCollection1()) {
                Vendedor oldCodvendedextOfDocumentoCollection1Documento = documentoCollection1Documento.getCodvendedext();
                documentoCollection1Documento.setCodvendedext(vendedor);
                documentoCollection1Documento = em.merge(documentoCollection1Documento);
                if (oldCodvendedextOfDocumentoCollection1Documento != null) {
                    oldCodvendedextOfDocumentoCollection1Documento.getDocumentoCollection1().remove(documentoCollection1Documento);
                    oldCodvendedextOfDocumentoCollection1Documento = em.merge(oldCodvendedextOfDocumentoCollection1Documento);
                }
            }
            for (Cheques chequesCollectionCheques : vendedor.getChequesCollection()) {
                Vendedor oldCodvendedrenegociacaoOfChequesCollectionCheques = chequesCollectionCheques.getCodvendedrenegociacao();
                chequesCollectionCheques.setCodvendedrenegociacao(vendedor);
                chequesCollectionCheques = em.merge(chequesCollectionCheques);
                if (oldCodvendedrenegociacaoOfChequesCollectionCheques != null) {
                    oldCodvendedrenegociacaoOfChequesCollectionCheques.getChequesCollection().remove(chequesCollectionCheques);
                    oldCodvendedrenegociacaoOfChequesCollectionCheques = em.merge(oldCodvendedrenegociacaoOfChequesCollectionCheques);
                }
            }
            for (Rma rmaCollectionRma : vendedor.getRmaCollection()) {
                Vendedor oldCodvendedOfRmaCollectionRma = rmaCollectionRma.getCodvended();
                rmaCollectionRma.setCodvended(vendedor);
                rmaCollectionRma = em.merge(rmaCollectionRma);
                if (oldCodvendedOfRmaCollectionRma != null) {
                    oldCodvendedOfRmaCollectionRma.getRmaCollection().remove(rmaCollectionRma);
                    oldCodvendedOfRmaCollectionRma = em.merge(oldCodvendedOfRmaCollectionRma);
                }
            }
            for (Vendedorsecao vendedorsecaoCollectionVendedorsecao : vendedor.getVendedorsecaoCollection()) {
                Vendedor oldCodvendedOfVendedorsecaoCollectionVendedorsecao = vendedorsecaoCollectionVendedorsecao.getCodvended();
                vendedorsecaoCollectionVendedorsecao.setCodvended(vendedor);
                vendedorsecaoCollectionVendedorsecao = em.merge(vendedorsecaoCollectionVendedorsecao);
                if (oldCodvendedOfVendedorsecaoCollectionVendedorsecao != null) {
                    oldCodvendedOfVendedorsecaoCollectionVendedorsecao.getVendedorsecaoCollection().remove(vendedorsecaoCollectionVendedorsecao);
                    oldCodvendedOfVendedorsecaoCollectionVendedorsecao = em.merge(oldCodvendedOfVendedorsecaoCollectionVendedorsecao);
                }
            }
            for (Usuario usuarioCollectionUsuario : vendedor.getUsuarioCollection()) {
                Vendedor oldCodvendedOfUsuarioCollectionUsuario = usuarioCollectionUsuario.getCodvended();
                usuarioCollectionUsuario.setCodvended(vendedor);
                usuarioCollectionUsuario = em.merge(usuarioCollectionUsuario);
                if (oldCodvendedOfUsuarioCollectionUsuario != null) {
                    oldCodvendedOfUsuarioCollectionUsuario.getUsuarioCollection().remove(usuarioCollectionUsuario);
                    oldCodvendedOfUsuarioCollectionUsuario = em.merge(oldCodvendedOfUsuarioCollectionUsuario);
                }
            }
            for (Movendaprod movendaprodCollectionMovendaprod : vendedor.getMovendaprodCollection()) {
                Vendedor oldCodvendedOfMovendaprodCollectionMovendaprod = movendaprodCollectionMovendaprod.getCodvended();
                movendaprodCollectionMovendaprod.setCodvended(vendedor);
                movendaprodCollectionMovendaprod = em.merge(movendaprodCollectionMovendaprod);
                if (oldCodvendedOfMovendaprodCollectionMovendaprod != null) {
                    oldCodvendedOfMovendaprodCollectionMovendaprod.getMovendaprodCollection().remove(movendaprodCollectionMovendaprod);
                    oldCodvendedOfMovendaprodCollectionMovendaprod = em.merge(oldCodvendedOfMovendaprodCollectionMovendaprod);
                }
            }
            for (Chequeshistorico chequeshistoricoCollectionChequeshistorico : vendedor.getChequeshistoricoCollection()) {
                Vendedor oldCodvendedrenegociacaoOfChequeshistoricoCollectionChequeshistorico = chequeshistoricoCollectionChequeshistorico.getCodvendedrenegociacao();
                chequeshistoricoCollectionChequeshistorico.setCodvendedrenegociacao(vendedor);
                chequeshistoricoCollectionChequeshistorico = em.merge(chequeshistoricoCollectionChequeshistorico);
                if (oldCodvendedrenegociacaoOfChequeshistoricoCollectionChequeshistorico != null) {
                    oldCodvendedrenegociacaoOfChequeshistoricoCollectionChequeshistorico.getChequeshistoricoCollection().remove(chequeshistoricoCollectionChequeshistorico);
                    oldCodvendedrenegociacaoOfChequeshistoricoCollectionChequeshistorico = em.merge(oldCodvendedrenegociacaoOfChequeshistoricoCollectionChequeshistorico);
                }
            }
            for (Vendedorcaracteristica vendedorcaracteristicaCollectionVendedorcaracteristica : vendedor.getVendedorcaracteristicaCollection()) {
                Vendedor oldCodvendedOfVendedorcaracteristicaCollectionVendedorcaracteristica = vendedorcaracteristicaCollectionVendedorcaracteristica.getCodvended();
                vendedorcaracteristicaCollectionVendedorcaracteristica.setCodvended(vendedor);
                vendedorcaracteristicaCollectionVendedorcaracteristica = em.merge(vendedorcaracteristicaCollectionVendedorcaracteristica);
                if (oldCodvendedOfVendedorcaracteristicaCollectionVendedorcaracteristica != null) {
                    oldCodvendedOfVendedorcaracteristicaCollectionVendedorcaracteristica.getVendedorcaracteristicaCollection().remove(vendedorcaracteristicaCollectionVendedorcaracteristica);
                    oldCodvendedOfVendedorcaracteristicaCollectionVendedorcaracteristica = em.merge(oldCodvendedOfVendedorcaracteristicaCollectionVendedorcaracteristica);
                }
            }
            for (Orcamento orcamentoCollectionOrcamento : vendedor.getOrcamentoCollection()) {
                Vendedor oldCodvendedOfOrcamentoCollectionOrcamento = orcamentoCollectionOrcamento.getCodvended();
                orcamentoCollectionOrcamento.setCodvended(vendedor);
                orcamentoCollectionOrcamento = em.merge(orcamentoCollectionOrcamento);
                if (oldCodvendedOfOrcamentoCollectionOrcamento != null) {
                    oldCodvendedOfOrcamentoCollectionOrcamento.getOrcamentoCollection().remove(orcamentoCollectionOrcamento);
                    oldCodvendedOfOrcamentoCollectionOrcamento = em.merge(oldCodvendedOfOrcamentoCollectionOrcamento);
                }
            }
            for (Orcamento orcamentoCollection1Orcamento : vendedor.getOrcamentoCollection1()) {
                Vendedor oldCodvendedextOfOrcamentoCollection1Orcamento = orcamentoCollection1Orcamento.getCodvendedext();
                orcamentoCollection1Orcamento.setCodvendedext(vendedor);
                orcamentoCollection1Orcamento = em.merge(orcamentoCollection1Orcamento);
                if (oldCodvendedextOfOrcamentoCollection1Orcamento != null) {
                    oldCodvendedextOfOrcamentoCollection1Orcamento.getOrcamentoCollection1().remove(orcamentoCollection1Orcamento);
                    oldCodvendedextOfOrcamentoCollection1Orcamento = em.merge(oldCodvendedextOfOrcamentoCollection1Orcamento);
                }
            }
            for (Movenda movendaCollectionMovenda : vendedor.getMovendaCollection()) {
                Vendedor oldCodvendedOfMovendaCollectionMovenda = movendaCollectionMovenda.getCodvended();
                movendaCollectionMovenda.setCodvended(vendedor);
                movendaCollectionMovenda = em.merge(movendaCollectionMovenda);
                if (oldCodvendedOfMovendaCollectionMovenda != null) {
                    oldCodvendedOfMovendaCollectionMovenda.getMovendaCollection().remove(movendaCollectionMovenda);
                    oldCodvendedOfMovendaCollectionMovenda = em.merge(oldCodvendedOfMovendaCollectionMovenda);
                }
            }
            for (Movenda movendaCollection1Movenda : vendedor.getMovendaCollection1()) {
                Vendedor oldCodvendedextOfMovendaCollection1Movenda = movendaCollection1Movenda.getCodvendedext();
                movendaCollection1Movenda.setCodvendedext(vendedor);
                movendaCollection1Movenda = em.merge(movendaCollection1Movenda);
                if (oldCodvendedextOfMovendaCollection1Movenda != null) {
                    oldCodvendedextOfMovendaCollection1Movenda.getMovendaCollection1().remove(movendaCollection1Movenda);
                    oldCodvendedextOfMovendaCollection1Movenda = em.merge(oldCodvendedextOfMovendaCollection1Movenda);
                }
            }
            for (Orcamentoprod orcamentoprodCollectionOrcamentoprod : vendedor.getOrcamentoprodCollection()) {
                Vendedor oldCodvendedOfOrcamentoprodCollectionOrcamentoprod = orcamentoprodCollectionOrcamentoprod.getCodvended();
                orcamentoprodCollectionOrcamentoprod.setCodvended(vendedor);
                orcamentoprodCollectionOrcamentoprod = em.merge(orcamentoprodCollectionOrcamentoprod);
                if (oldCodvendedOfOrcamentoprodCollectionOrcamentoprod != null) {
                    oldCodvendedOfOrcamentoprodCollectionOrcamentoprod.getOrcamentoprodCollection().remove(orcamentoprodCollectionOrcamentoprod);
                    oldCodvendedOfOrcamentoprodCollectionOrcamentoprod = em.merge(oldCodvendedOfOrcamentoprodCollectionOrcamentoprod);
                }
            }
            for (Cliente clienteCollectionCliente : vendedor.getClienteCollection()) {
                Vendedor oldCodvendedOfClienteCollectionCliente = clienteCollectionCliente.getCodvended();
                clienteCollectionCliente.setCodvended(vendedor);
                clienteCollectionCliente = em.merge(clienteCollectionCliente);
                if (oldCodvendedOfClienteCollectionCliente != null) {
                    oldCodvendedOfClienteCollectionCliente.getClienteCollection().remove(clienteCollectionCliente);
                    oldCodvendedOfClienteCollectionCliente = em.merge(oldCodvendedOfClienteCollectionCliente);
                }
            }
            for (Cliente clienteCollection1Cliente : vendedor.getClienteCollection1()) {
                Vendedor oldCodvendedextOfClienteCollection1Cliente = clienteCollection1Cliente.getCodvendedext();
                clienteCollection1Cliente.setCodvendedext(vendedor);
                clienteCollection1Cliente = em.merge(clienteCollection1Cliente);
                if (oldCodvendedextOfClienteCollection1Cliente != null) {
                    oldCodvendedextOfClienteCollection1Cliente.getClienteCollection1().remove(clienteCollection1Cliente);
                    oldCodvendedextOfClienteCollection1Cliente = em.merge(oldCodvendedextOfClienteCollection1Cliente);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVendedor(vendedor.getCodvended()) != null) {
                throw new PreexistingEntityException("Vendedor " + vendedor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vendedor vendedor) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vendedor persistentVendedor = em.find(Vendedor.class, vendedor.getCodvended());
            Vendedor codvendedsupervisorOld = persistentVendedor.getCodvendedsupervisor();
            Vendedor codvendedsupervisorNew = vendedor.getCodvendedsupervisor();
            Collection<Moventrada> moventradaCollectionOld = persistentVendedor.getMoventradaCollection();
            Collection<Moventrada> moventradaCollectionNew = vendedor.getMoventradaCollection();
            Collection<Moventradaprod> moventradaprodCollectionOld = persistentVendedor.getMoventradaprodCollection();
            Collection<Moventradaprod> moventradaprodCollectionNew = vendedor.getMoventradaprodCollection();
            Collection<Vendedor> vendedorCollectionOld = persistentVendedor.getVendedorCollection();
            Collection<Vendedor> vendedorCollectionNew = vendedor.getVendedorCollection();
            Collection<OsTecnico> osTecnicoCollectionOld = persistentVendedor.getOsTecnicoCollection();
            Collection<OsTecnico> osTecnicoCollectionNew = vendedor.getOsTecnicoCollection();
            Collection<Documento> documentoCollectionOld = persistentVendedor.getDocumentoCollection();
            Collection<Documento> documentoCollectionNew = vendedor.getDocumentoCollection();
            Collection<Documento> documentoCollection1Old = persistentVendedor.getDocumentoCollection1();
            Collection<Documento> documentoCollection1New = vendedor.getDocumentoCollection1();
            Collection<Cheques> chequesCollectionOld = persistentVendedor.getChequesCollection();
            Collection<Cheques> chequesCollectionNew = vendedor.getChequesCollection();
            Collection<Rma> rmaCollectionOld = persistentVendedor.getRmaCollection();
            Collection<Rma> rmaCollectionNew = vendedor.getRmaCollection();
            Collection<Vendedorsecao> vendedorsecaoCollectionOld = persistentVendedor.getVendedorsecaoCollection();
            Collection<Vendedorsecao> vendedorsecaoCollectionNew = vendedor.getVendedorsecaoCollection();
            Collection<Usuario> usuarioCollectionOld = persistentVendedor.getUsuarioCollection();
            Collection<Usuario> usuarioCollectionNew = vendedor.getUsuarioCollection();
            Collection<Movendaprod> movendaprodCollectionOld = persistentVendedor.getMovendaprodCollection();
            Collection<Movendaprod> movendaprodCollectionNew = vendedor.getMovendaprodCollection();
            Collection<Chequeshistorico> chequeshistoricoCollectionOld = persistentVendedor.getChequeshistoricoCollection();
            Collection<Chequeshistorico> chequeshistoricoCollectionNew = vendedor.getChequeshistoricoCollection();
            Collection<Vendedorcaracteristica> vendedorcaracteristicaCollectionOld = persistentVendedor.getVendedorcaracteristicaCollection();
            Collection<Vendedorcaracteristica> vendedorcaracteristicaCollectionNew = vendedor.getVendedorcaracteristicaCollection();
            Collection<Orcamento> orcamentoCollectionOld = persistentVendedor.getOrcamentoCollection();
            Collection<Orcamento> orcamentoCollectionNew = vendedor.getOrcamentoCollection();
            Collection<Orcamento> orcamentoCollection1Old = persistentVendedor.getOrcamentoCollection1();
            Collection<Orcamento> orcamentoCollection1New = vendedor.getOrcamentoCollection1();
            Collection<Movenda> movendaCollectionOld = persistentVendedor.getMovendaCollection();
            Collection<Movenda> movendaCollectionNew = vendedor.getMovendaCollection();
            Collection<Movenda> movendaCollection1Old = persistentVendedor.getMovendaCollection1();
            Collection<Movenda> movendaCollection1New = vendedor.getMovendaCollection1();
            Collection<Orcamentoprod> orcamentoprodCollectionOld = persistentVendedor.getOrcamentoprodCollection();
            Collection<Orcamentoprod> orcamentoprodCollectionNew = vendedor.getOrcamentoprodCollection();
            Collection<Cliente> clienteCollectionOld = persistentVendedor.getClienteCollection();
            Collection<Cliente> clienteCollectionNew = vendedor.getClienteCollection();
            Collection<Cliente> clienteCollection1Old = persistentVendedor.getClienteCollection1();
            Collection<Cliente> clienteCollection1New = vendedor.getClienteCollection1();
            List<String> illegalOrphanMessages = null;
            for (Vendedorsecao vendedorsecaoCollectionOldVendedorsecao : vendedorsecaoCollectionOld) {
                if (!vendedorsecaoCollectionNew.contains(vendedorsecaoCollectionOldVendedorsecao)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Vendedorsecao " + vendedorsecaoCollectionOldVendedorsecao + " since its codvended field is not nullable.");
                }
            }
            for (Vendedorcaracteristica vendedorcaracteristicaCollectionOldVendedorcaracteristica : vendedorcaracteristicaCollectionOld) {
                if (!vendedorcaracteristicaCollectionNew.contains(vendedorcaracteristicaCollectionOldVendedorcaracteristica)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Vendedorcaracteristica " + vendedorcaracteristicaCollectionOldVendedorcaracteristica + " since its codvended field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codvendedsupervisorNew != null) {
                codvendedsupervisorNew = em.getReference(codvendedsupervisorNew.getClass(), codvendedsupervisorNew.getCodvended());
                vendedor.setCodvendedsupervisor(codvendedsupervisorNew);
            }
            Collection<Moventrada> attachedMoventradaCollectionNew = new ArrayList<Moventrada>();
            for (Moventrada moventradaCollectionNewMoventradaToAttach : moventradaCollectionNew) {
                moventradaCollectionNewMoventradaToAttach = em.getReference(moventradaCollectionNewMoventradaToAttach.getClass(), moventradaCollectionNewMoventradaToAttach.getCodmoventr());
                attachedMoventradaCollectionNew.add(moventradaCollectionNewMoventradaToAttach);
            }
            moventradaCollectionNew = attachedMoventradaCollectionNew;
            vendedor.setMoventradaCollection(moventradaCollectionNew);
            Collection<Moventradaprod> attachedMoventradaprodCollectionNew = new ArrayList<Moventradaprod>();
            for (Moventradaprod moventradaprodCollectionNewMoventradaprodToAttach : moventradaprodCollectionNew) {
                moventradaprodCollectionNewMoventradaprodToAttach = em.getReference(moventradaprodCollectionNewMoventradaprodToAttach.getClass(), moventradaprodCollectionNewMoventradaprodToAttach.getCodmoveprod());
                attachedMoventradaprodCollectionNew.add(moventradaprodCollectionNewMoventradaprodToAttach);
            }
            moventradaprodCollectionNew = attachedMoventradaprodCollectionNew;
            vendedor.setMoventradaprodCollection(moventradaprodCollectionNew);
            Collection<Vendedor> attachedVendedorCollectionNew = new ArrayList<Vendedor>();
            for (Vendedor vendedorCollectionNewVendedorToAttach : vendedorCollectionNew) {
                vendedorCollectionNewVendedorToAttach = em.getReference(vendedorCollectionNewVendedorToAttach.getClass(), vendedorCollectionNewVendedorToAttach.getCodvended());
                attachedVendedorCollectionNew.add(vendedorCollectionNewVendedorToAttach);
            }
            vendedorCollectionNew = attachedVendedorCollectionNew;
            vendedor.setVendedorCollection(vendedorCollectionNew);
            Collection<OsTecnico> attachedOsTecnicoCollectionNew = new ArrayList<OsTecnico>();
            for (OsTecnico osTecnicoCollectionNewOsTecnicoToAttach : osTecnicoCollectionNew) {
                osTecnicoCollectionNewOsTecnicoToAttach = em.getReference(osTecnicoCollectionNewOsTecnicoToAttach.getClass(), osTecnicoCollectionNewOsTecnicoToAttach.getCodtec());
                attachedOsTecnicoCollectionNew.add(osTecnicoCollectionNewOsTecnicoToAttach);
            }
            osTecnicoCollectionNew = attachedOsTecnicoCollectionNew;
            vendedor.setOsTecnicoCollection(osTecnicoCollectionNew);
            Collection<Documento> attachedDocumentoCollectionNew = new ArrayList<Documento>();
            for (Documento documentoCollectionNewDocumentoToAttach : documentoCollectionNew) {
                documentoCollectionNewDocumentoToAttach = em.getReference(documentoCollectionNewDocumentoToAttach.getClass(), documentoCollectionNewDocumentoToAttach.getCoddocumento());
                attachedDocumentoCollectionNew.add(documentoCollectionNewDocumentoToAttach);
            }
            documentoCollectionNew = attachedDocumentoCollectionNew;
            vendedor.setDocumentoCollection(documentoCollectionNew);
            Collection<Documento> attachedDocumentoCollection1New = new ArrayList<Documento>();
            for (Documento documentoCollection1NewDocumentoToAttach : documentoCollection1New) {
                documentoCollection1NewDocumentoToAttach = em.getReference(documentoCollection1NewDocumentoToAttach.getClass(), documentoCollection1NewDocumentoToAttach.getCoddocumento());
                attachedDocumentoCollection1New.add(documentoCollection1NewDocumentoToAttach);
            }
            documentoCollection1New = attachedDocumentoCollection1New;
            vendedor.setDocumentoCollection1(documentoCollection1New);
            Collection<Cheques> attachedChequesCollectionNew = new ArrayList<Cheques>();
            for (Cheques chequesCollectionNewChequesToAttach : chequesCollectionNew) {
                chequesCollectionNewChequesToAttach = em.getReference(chequesCollectionNewChequesToAttach.getClass(), chequesCollectionNewChequesToAttach.getCodcheque());
                attachedChequesCollectionNew.add(chequesCollectionNewChequesToAttach);
            }
            chequesCollectionNew = attachedChequesCollectionNew;
            vendedor.setChequesCollection(chequesCollectionNew);
            Collection<Rma> attachedRmaCollectionNew = new ArrayList<Rma>();
            for (Rma rmaCollectionNewRmaToAttach : rmaCollectionNew) {
                rmaCollectionNewRmaToAttach = em.getReference(rmaCollectionNewRmaToAttach.getClass(), rmaCollectionNewRmaToAttach.getCodrma());
                attachedRmaCollectionNew.add(rmaCollectionNewRmaToAttach);
            }
            rmaCollectionNew = attachedRmaCollectionNew;
            vendedor.setRmaCollection(rmaCollectionNew);
            Collection<Vendedorsecao> attachedVendedorsecaoCollectionNew = new ArrayList<Vendedorsecao>();
            for (Vendedorsecao vendedorsecaoCollectionNewVendedorsecaoToAttach : vendedorsecaoCollectionNew) {
                vendedorsecaoCollectionNewVendedorsecaoToAttach = em.getReference(vendedorsecaoCollectionNewVendedorsecaoToAttach.getClass(), vendedorsecaoCollectionNewVendedorsecaoToAttach.getCodvendedorsecao());
                attachedVendedorsecaoCollectionNew.add(vendedorsecaoCollectionNewVendedorsecaoToAttach);
            }
            vendedorsecaoCollectionNew = attachedVendedorsecaoCollectionNew;
            vendedor.setVendedorsecaoCollection(vendedorsecaoCollectionNew);
            Collection<Usuario> attachedUsuarioCollectionNew = new ArrayList<Usuario>();
            for (Usuario usuarioCollectionNewUsuarioToAttach : usuarioCollectionNew) {
                usuarioCollectionNewUsuarioToAttach = em.getReference(usuarioCollectionNewUsuarioToAttach.getClass(), usuarioCollectionNewUsuarioToAttach.getCoduser());
                attachedUsuarioCollectionNew.add(usuarioCollectionNewUsuarioToAttach);
            }
            usuarioCollectionNew = attachedUsuarioCollectionNew;
            vendedor.setUsuarioCollection(usuarioCollectionNew);
            Collection<Movendaprod> attachedMovendaprodCollectionNew = new ArrayList<Movendaprod>();
            for (Movendaprod movendaprodCollectionNewMovendaprodToAttach : movendaprodCollectionNew) {
                movendaprodCollectionNewMovendaprodToAttach = em.getReference(movendaprodCollectionNewMovendaprodToAttach.getClass(), movendaprodCollectionNewMovendaprodToAttach.getCodmovprod());
                attachedMovendaprodCollectionNew.add(movendaprodCollectionNewMovendaprodToAttach);
            }
            movendaprodCollectionNew = attachedMovendaprodCollectionNew;
            vendedor.setMovendaprodCollection(movendaprodCollectionNew);
            Collection<Chequeshistorico> attachedChequeshistoricoCollectionNew = new ArrayList<Chequeshistorico>();
            for (Chequeshistorico chequeshistoricoCollectionNewChequeshistoricoToAttach : chequeshistoricoCollectionNew) {
                chequeshistoricoCollectionNewChequeshistoricoToAttach = em.getReference(chequeshistoricoCollectionNewChequeshistoricoToAttach.getClass(), chequeshistoricoCollectionNewChequeshistoricoToAttach.getCodchequeshistorico());
                attachedChequeshistoricoCollectionNew.add(chequeshistoricoCollectionNewChequeshistoricoToAttach);
            }
            chequeshistoricoCollectionNew = attachedChequeshistoricoCollectionNew;
            vendedor.setChequeshistoricoCollection(chequeshistoricoCollectionNew);
            Collection<Vendedorcaracteristica> attachedVendedorcaracteristicaCollectionNew = new ArrayList<Vendedorcaracteristica>();
            for (Vendedorcaracteristica vendedorcaracteristicaCollectionNewVendedorcaracteristicaToAttach : vendedorcaracteristicaCollectionNew) {
                vendedorcaracteristicaCollectionNewVendedorcaracteristicaToAttach = em.getReference(vendedorcaracteristicaCollectionNewVendedorcaracteristicaToAttach.getClass(), vendedorcaracteristicaCollectionNewVendedorcaracteristicaToAttach.getCodvendedorcaracteristica());
                attachedVendedorcaracteristicaCollectionNew.add(vendedorcaracteristicaCollectionNewVendedorcaracteristicaToAttach);
            }
            vendedorcaracteristicaCollectionNew = attachedVendedorcaracteristicaCollectionNew;
            vendedor.setVendedorcaracteristicaCollection(vendedorcaracteristicaCollectionNew);
            Collection<Orcamento> attachedOrcamentoCollectionNew = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollectionNewOrcamentoToAttach : orcamentoCollectionNew) {
                orcamentoCollectionNewOrcamentoToAttach = em.getReference(orcamentoCollectionNewOrcamentoToAttach.getClass(), orcamentoCollectionNewOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollectionNew.add(orcamentoCollectionNewOrcamentoToAttach);
            }
            orcamentoCollectionNew = attachedOrcamentoCollectionNew;
            vendedor.setOrcamentoCollection(orcamentoCollectionNew);
            Collection<Orcamento> attachedOrcamentoCollection1New = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollection1NewOrcamentoToAttach : orcamentoCollection1New) {
                orcamentoCollection1NewOrcamentoToAttach = em.getReference(orcamentoCollection1NewOrcamentoToAttach.getClass(), orcamentoCollection1NewOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollection1New.add(orcamentoCollection1NewOrcamentoToAttach);
            }
            orcamentoCollection1New = attachedOrcamentoCollection1New;
            vendedor.setOrcamentoCollection1(orcamentoCollection1New);
            Collection<Movenda> attachedMovendaCollectionNew = new ArrayList<Movenda>();
            for (Movenda movendaCollectionNewMovendaToAttach : movendaCollectionNew) {
                movendaCollectionNewMovendaToAttach = em.getReference(movendaCollectionNewMovendaToAttach.getClass(), movendaCollectionNewMovendaToAttach.getCodmovenda());
                attachedMovendaCollectionNew.add(movendaCollectionNewMovendaToAttach);
            }
            movendaCollectionNew = attachedMovendaCollectionNew;
            vendedor.setMovendaCollection(movendaCollectionNew);
            Collection<Movenda> attachedMovendaCollection1New = new ArrayList<Movenda>();
            for (Movenda movendaCollection1NewMovendaToAttach : movendaCollection1New) {
                movendaCollection1NewMovendaToAttach = em.getReference(movendaCollection1NewMovendaToAttach.getClass(), movendaCollection1NewMovendaToAttach.getCodmovenda());
                attachedMovendaCollection1New.add(movendaCollection1NewMovendaToAttach);
            }
            movendaCollection1New = attachedMovendaCollection1New;
            vendedor.setMovendaCollection1(movendaCollection1New);
            Collection<Orcamentoprod> attachedOrcamentoprodCollectionNew = new ArrayList<Orcamentoprod>();
            for (Orcamentoprod orcamentoprodCollectionNewOrcamentoprodToAttach : orcamentoprodCollectionNew) {
                orcamentoprodCollectionNewOrcamentoprodToAttach = em.getReference(orcamentoprodCollectionNewOrcamentoprodToAttach.getClass(), orcamentoprodCollectionNewOrcamentoprodToAttach.getCodorcprod());
                attachedOrcamentoprodCollectionNew.add(orcamentoprodCollectionNewOrcamentoprodToAttach);
            }
            orcamentoprodCollectionNew = attachedOrcamentoprodCollectionNew;
            vendedor.setOrcamentoprodCollection(orcamentoprodCollectionNew);
            Collection<Cliente> attachedClienteCollectionNew = new ArrayList<Cliente>();
            for (Cliente clienteCollectionNewClienteToAttach : clienteCollectionNew) {
                clienteCollectionNewClienteToAttach = em.getReference(clienteCollectionNewClienteToAttach.getClass(), clienteCollectionNewClienteToAttach.getCodcli());
                attachedClienteCollectionNew.add(clienteCollectionNewClienteToAttach);
            }
            clienteCollectionNew = attachedClienteCollectionNew;
            vendedor.setClienteCollection(clienteCollectionNew);
            Collection<Cliente> attachedClienteCollection1New = new ArrayList<Cliente>();
            for (Cliente clienteCollection1NewClienteToAttach : clienteCollection1New) {
                clienteCollection1NewClienteToAttach = em.getReference(clienteCollection1NewClienteToAttach.getClass(), clienteCollection1NewClienteToAttach.getCodcli());
                attachedClienteCollection1New.add(clienteCollection1NewClienteToAttach);
            }
            clienteCollection1New = attachedClienteCollection1New;
            vendedor.setClienteCollection1(clienteCollection1New);
            vendedor = em.merge(vendedor);
            if (codvendedsupervisorOld != null && !codvendedsupervisorOld.equals(codvendedsupervisorNew)) {
                codvendedsupervisorOld.getVendedorCollection().remove(vendedor);
                codvendedsupervisorOld = em.merge(codvendedsupervisorOld);
            }
            if (codvendedsupervisorNew != null && !codvendedsupervisorNew.equals(codvendedsupervisorOld)) {
                codvendedsupervisorNew.getVendedorCollection().add(vendedor);
                codvendedsupervisorNew = em.merge(codvendedsupervisorNew);
            }
            for (Moventrada moventradaCollectionOldMoventrada : moventradaCollectionOld) {
                if (!moventradaCollectionNew.contains(moventradaCollectionOldMoventrada)) {
                    moventradaCollectionOldMoventrada.setCodvended(null);
                    moventradaCollectionOldMoventrada = em.merge(moventradaCollectionOldMoventrada);
                }
            }
            for (Moventrada moventradaCollectionNewMoventrada : moventradaCollectionNew) {
                if (!moventradaCollectionOld.contains(moventradaCollectionNewMoventrada)) {
                    Vendedor oldCodvendedOfMoventradaCollectionNewMoventrada = moventradaCollectionNewMoventrada.getCodvended();
                    moventradaCollectionNewMoventrada.setCodvended(vendedor);
                    moventradaCollectionNewMoventrada = em.merge(moventradaCollectionNewMoventrada);
                    if (oldCodvendedOfMoventradaCollectionNewMoventrada != null && !oldCodvendedOfMoventradaCollectionNewMoventrada.equals(vendedor)) {
                        oldCodvendedOfMoventradaCollectionNewMoventrada.getMoventradaCollection().remove(moventradaCollectionNewMoventrada);
                        oldCodvendedOfMoventradaCollectionNewMoventrada = em.merge(oldCodvendedOfMoventradaCollectionNewMoventrada);
                    }
                }
            }
            for (Moventradaprod moventradaprodCollectionOldMoventradaprod : moventradaprodCollectionOld) {
                if (!moventradaprodCollectionNew.contains(moventradaprodCollectionOldMoventradaprod)) {
                    moventradaprodCollectionOldMoventradaprod.setCodvended(null);
                    moventradaprodCollectionOldMoventradaprod = em.merge(moventradaprodCollectionOldMoventradaprod);
                }
            }
            for (Moventradaprod moventradaprodCollectionNewMoventradaprod : moventradaprodCollectionNew) {
                if (!moventradaprodCollectionOld.contains(moventradaprodCollectionNewMoventradaprod)) {
                    Vendedor oldCodvendedOfMoventradaprodCollectionNewMoventradaprod = moventradaprodCollectionNewMoventradaprod.getCodvended();
                    moventradaprodCollectionNewMoventradaprod.setCodvended(vendedor);
                    moventradaprodCollectionNewMoventradaprod = em.merge(moventradaprodCollectionNewMoventradaprod);
                    if (oldCodvendedOfMoventradaprodCollectionNewMoventradaprod != null && !oldCodvendedOfMoventradaprodCollectionNewMoventradaprod.equals(vendedor)) {
                        oldCodvendedOfMoventradaprodCollectionNewMoventradaprod.getMoventradaprodCollection().remove(moventradaprodCollectionNewMoventradaprod);
                        oldCodvendedOfMoventradaprodCollectionNewMoventradaprod = em.merge(oldCodvendedOfMoventradaprodCollectionNewMoventradaprod);
                    }
                }
            }
            for (Vendedor vendedorCollectionOldVendedor : vendedorCollectionOld) {
                if (!vendedorCollectionNew.contains(vendedorCollectionOldVendedor)) {
                    vendedorCollectionOldVendedor.setCodvendedsupervisor(null);
                    vendedorCollectionOldVendedor = em.merge(vendedorCollectionOldVendedor);
                }
            }
            for (Vendedor vendedorCollectionNewVendedor : vendedorCollectionNew) {
                if (!vendedorCollectionOld.contains(vendedorCollectionNewVendedor)) {
                    Vendedor oldCodvendedsupervisorOfVendedorCollectionNewVendedor = vendedorCollectionNewVendedor.getCodvendedsupervisor();
                    vendedorCollectionNewVendedor.setCodvendedsupervisor(vendedor);
                    vendedorCollectionNewVendedor = em.merge(vendedorCollectionNewVendedor);
                    if (oldCodvendedsupervisorOfVendedorCollectionNewVendedor != null && !oldCodvendedsupervisorOfVendedorCollectionNewVendedor.equals(vendedor)) {
                        oldCodvendedsupervisorOfVendedorCollectionNewVendedor.getVendedorCollection().remove(vendedorCollectionNewVendedor);
                        oldCodvendedsupervisorOfVendedorCollectionNewVendedor = em.merge(oldCodvendedsupervisorOfVendedorCollectionNewVendedor);
                    }
                }
            }
            for (OsTecnico osTecnicoCollectionOldOsTecnico : osTecnicoCollectionOld) {
                if (!osTecnicoCollectionNew.contains(osTecnicoCollectionOldOsTecnico)) {
                    osTecnicoCollectionOldOsTecnico.setCodvended(null);
                    osTecnicoCollectionOldOsTecnico = em.merge(osTecnicoCollectionOldOsTecnico);
                }
            }
            for (OsTecnico osTecnicoCollectionNewOsTecnico : osTecnicoCollectionNew) {
                if (!osTecnicoCollectionOld.contains(osTecnicoCollectionNewOsTecnico)) {
                    Vendedor oldCodvendedOfOsTecnicoCollectionNewOsTecnico = osTecnicoCollectionNewOsTecnico.getCodvended();
                    osTecnicoCollectionNewOsTecnico.setCodvended(vendedor);
                    osTecnicoCollectionNewOsTecnico = em.merge(osTecnicoCollectionNewOsTecnico);
                    if (oldCodvendedOfOsTecnicoCollectionNewOsTecnico != null && !oldCodvendedOfOsTecnicoCollectionNewOsTecnico.equals(vendedor)) {
                        oldCodvendedOfOsTecnicoCollectionNewOsTecnico.getOsTecnicoCollection().remove(osTecnicoCollectionNewOsTecnico);
                        oldCodvendedOfOsTecnicoCollectionNewOsTecnico = em.merge(oldCodvendedOfOsTecnicoCollectionNewOsTecnico);
                    }
                }
            }
            for (Documento documentoCollectionOldDocumento : documentoCollectionOld) {
                if (!documentoCollectionNew.contains(documentoCollectionOldDocumento)) {
                    documentoCollectionOldDocumento.setCodvended(null);
                    documentoCollectionOldDocumento = em.merge(documentoCollectionOldDocumento);
                }
            }
            for (Documento documentoCollectionNewDocumento : documentoCollectionNew) {
                if (!documentoCollectionOld.contains(documentoCollectionNewDocumento)) {
                    Vendedor oldCodvendedOfDocumentoCollectionNewDocumento = documentoCollectionNewDocumento.getCodvended();
                    documentoCollectionNewDocumento.setCodvended(vendedor);
                    documentoCollectionNewDocumento = em.merge(documentoCollectionNewDocumento);
                    if (oldCodvendedOfDocumentoCollectionNewDocumento != null && !oldCodvendedOfDocumentoCollectionNewDocumento.equals(vendedor)) {
                        oldCodvendedOfDocumentoCollectionNewDocumento.getDocumentoCollection().remove(documentoCollectionNewDocumento);
                        oldCodvendedOfDocumentoCollectionNewDocumento = em.merge(oldCodvendedOfDocumentoCollectionNewDocumento);
                    }
                }
            }
            for (Documento documentoCollection1OldDocumento : documentoCollection1Old) {
                if (!documentoCollection1New.contains(documentoCollection1OldDocumento)) {
                    documentoCollection1OldDocumento.setCodvendedext(null);
                    documentoCollection1OldDocumento = em.merge(documentoCollection1OldDocumento);
                }
            }
            for (Documento documentoCollection1NewDocumento : documentoCollection1New) {
                if (!documentoCollection1Old.contains(documentoCollection1NewDocumento)) {
                    Vendedor oldCodvendedextOfDocumentoCollection1NewDocumento = documentoCollection1NewDocumento.getCodvendedext();
                    documentoCollection1NewDocumento.setCodvendedext(vendedor);
                    documentoCollection1NewDocumento = em.merge(documentoCollection1NewDocumento);
                    if (oldCodvendedextOfDocumentoCollection1NewDocumento != null && !oldCodvendedextOfDocumentoCollection1NewDocumento.equals(vendedor)) {
                        oldCodvendedextOfDocumentoCollection1NewDocumento.getDocumentoCollection1().remove(documentoCollection1NewDocumento);
                        oldCodvendedextOfDocumentoCollection1NewDocumento = em.merge(oldCodvendedextOfDocumentoCollection1NewDocumento);
                    }
                }
            }
            for (Cheques chequesCollectionOldCheques : chequesCollectionOld) {
                if (!chequesCollectionNew.contains(chequesCollectionOldCheques)) {
                    chequesCollectionOldCheques.setCodvendedrenegociacao(null);
                    chequesCollectionOldCheques = em.merge(chequesCollectionOldCheques);
                }
            }
            for (Cheques chequesCollectionNewCheques : chequesCollectionNew) {
                if (!chequesCollectionOld.contains(chequesCollectionNewCheques)) {
                    Vendedor oldCodvendedrenegociacaoOfChequesCollectionNewCheques = chequesCollectionNewCheques.getCodvendedrenegociacao();
                    chequesCollectionNewCheques.setCodvendedrenegociacao(vendedor);
                    chequesCollectionNewCheques = em.merge(chequesCollectionNewCheques);
                    if (oldCodvendedrenegociacaoOfChequesCollectionNewCheques != null && !oldCodvendedrenegociacaoOfChequesCollectionNewCheques.equals(vendedor)) {
                        oldCodvendedrenegociacaoOfChequesCollectionNewCheques.getChequesCollection().remove(chequesCollectionNewCheques);
                        oldCodvendedrenegociacaoOfChequesCollectionNewCheques = em.merge(oldCodvendedrenegociacaoOfChequesCollectionNewCheques);
                    }
                }
            }
            for (Rma rmaCollectionOldRma : rmaCollectionOld) {
                if (!rmaCollectionNew.contains(rmaCollectionOldRma)) {
                    rmaCollectionOldRma.setCodvended(null);
                    rmaCollectionOldRma = em.merge(rmaCollectionOldRma);
                }
            }
            for (Rma rmaCollectionNewRma : rmaCollectionNew) {
                if (!rmaCollectionOld.contains(rmaCollectionNewRma)) {
                    Vendedor oldCodvendedOfRmaCollectionNewRma = rmaCollectionNewRma.getCodvended();
                    rmaCollectionNewRma.setCodvended(vendedor);
                    rmaCollectionNewRma = em.merge(rmaCollectionNewRma);
                    if (oldCodvendedOfRmaCollectionNewRma != null && !oldCodvendedOfRmaCollectionNewRma.equals(vendedor)) {
                        oldCodvendedOfRmaCollectionNewRma.getRmaCollection().remove(rmaCollectionNewRma);
                        oldCodvendedOfRmaCollectionNewRma = em.merge(oldCodvendedOfRmaCollectionNewRma);
                    }
                }
            }
            for (Vendedorsecao vendedorsecaoCollectionNewVendedorsecao : vendedorsecaoCollectionNew) {
                if (!vendedorsecaoCollectionOld.contains(vendedorsecaoCollectionNewVendedorsecao)) {
                    Vendedor oldCodvendedOfVendedorsecaoCollectionNewVendedorsecao = vendedorsecaoCollectionNewVendedorsecao.getCodvended();
                    vendedorsecaoCollectionNewVendedorsecao.setCodvended(vendedor);
                    vendedorsecaoCollectionNewVendedorsecao = em.merge(vendedorsecaoCollectionNewVendedorsecao);
                    if (oldCodvendedOfVendedorsecaoCollectionNewVendedorsecao != null && !oldCodvendedOfVendedorsecaoCollectionNewVendedorsecao.equals(vendedor)) {
                        oldCodvendedOfVendedorsecaoCollectionNewVendedorsecao.getVendedorsecaoCollection().remove(vendedorsecaoCollectionNewVendedorsecao);
                        oldCodvendedOfVendedorsecaoCollectionNewVendedorsecao = em.merge(oldCodvendedOfVendedorsecaoCollectionNewVendedorsecao);
                    }
                }
            }
            for (Usuario usuarioCollectionOldUsuario : usuarioCollectionOld) {
                if (!usuarioCollectionNew.contains(usuarioCollectionOldUsuario)) {
                    usuarioCollectionOldUsuario.setCodvended(null);
                    usuarioCollectionOldUsuario = em.merge(usuarioCollectionOldUsuario);
                }
            }
            for (Usuario usuarioCollectionNewUsuario : usuarioCollectionNew) {
                if (!usuarioCollectionOld.contains(usuarioCollectionNewUsuario)) {
                    Vendedor oldCodvendedOfUsuarioCollectionNewUsuario = usuarioCollectionNewUsuario.getCodvended();
                    usuarioCollectionNewUsuario.setCodvended(vendedor);
                    usuarioCollectionNewUsuario = em.merge(usuarioCollectionNewUsuario);
                    if (oldCodvendedOfUsuarioCollectionNewUsuario != null && !oldCodvendedOfUsuarioCollectionNewUsuario.equals(vendedor)) {
                        oldCodvendedOfUsuarioCollectionNewUsuario.getUsuarioCollection().remove(usuarioCollectionNewUsuario);
                        oldCodvendedOfUsuarioCollectionNewUsuario = em.merge(oldCodvendedOfUsuarioCollectionNewUsuario);
                    }
                }
            }
            for (Movendaprod movendaprodCollectionOldMovendaprod : movendaprodCollectionOld) {
                if (!movendaprodCollectionNew.contains(movendaprodCollectionOldMovendaprod)) {
                    movendaprodCollectionOldMovendaprod.setCodvended(null);
                    movendaprodCollectionOldMovendaprod = em.merge(movendaprodCollectionOldMovendaprod);
                }
            }
            for (Movendaprod movendaprodCollectionNewMovendaprod : movendaprodCollectionNew) {
                if (!movendaprodCollectionOld.contains(movendaprodCollectionNewMovendaprod)) {
                    Vendedor oldCodvendedOfMovendaprodCollectionNewMovendaprod = movendaprodCollectionNewMovendaprod.getCodvended();
                    movendaprodCollectionNewMovendaprod.setCodvended(vendedor);
                    movendaprodCollectionNewMovendaprod = em.merge(movendaprodCollectionNewMovendaprod);
                    if (oldCodvendedOfMovendaprodCollectionNewMovendaprod != null && !oldCodvendedOfMovendaprodCollectionNewMovendaprod.equals(vendedor)) {
                        oldCodvendedOfMovendaprodCollectionNewMovendaprod.getMovendaprodCollection().remove(movendaprodCollectionNewMovendaprod);
                        oldCodvendedOfMovendaprodCollectionNewMovendaprod = em.merge(oldCodvendedOfMovendaprodCollectionNewMovendaprod);
                    }
                }
            }
            for (Chequeshistorico chequeshistoricoCollectionOldChequeshistorico : chequeshistoricoCollectionOld) {
                if (!chequeshistoricoCollectionNew.contains(chequeshistoricoCollectionOldChequeshistorico)) {
                    chequeshistoricoCollectionOldChequeshistorico.setCodvendedrenegociacao(null);
                    chequeshistoricoCollectionOldChequeshistorico = em.merge(chequeshistoricoCollectionOldChequeshistorico);
                }
            }
            for (Chequeshistorico chequeshistoricoCollectionNewChequeshistorico : chequeshistoricoCollectionNew) {
                if (!chequeshistoricoCollectionOld.contains(chequeshistoricoCollectionNewChequeshistorico)) {
                    Vendedor oldCodvendedrenegociacaoOfChequeshistoricoCollectionNewChequeshistorico = chequeshistoricoCollectionNewChequeshistorico.getCodvendedrenegociacao();
                    chequeshistoricoCollectionNewChequeshistorico.setCodvendedrenegociacao(vendedor);
                    chequeshistoricoCollectionNewChequeshistorico = em.merge(chequeshistoricoCollectionNewChequeshistorico);
                    if (oldCodvendedrenegociacaoOfChequeshistoricoCollectionNewChequeshistorico != null && !oldCodvendedrenegociacaoOfChequeshistoricoCollectionNewChequeshistorico.equals(vendedor)) {
                        oldCodvendedrenegociacaoOfChequeshistoricoCollectionNewChequeshistorico.getChequeshistoricoCollection().remove(chequeshistoricoCollectionNewChequeshistorico);
                        oldCodvendedrenegociacaoOfChequeshistoricoCollectionNewChequeshistorico = em.merge(oldCodvendedrenegociacaoOfChequeshistoricoCollectionNewChequeshistorico);
                    }
                }
            }
            for (Vendedorcaracteristica vendedorcaracteristicaCollectionNewVendedorcaracteristica : vendedorcaracteristicaCollectionNew) {
                if (!vendedorcaracteristicaCollectionOld.contains(vendedorcaracteristicaCollectionNewVendedorcaracteristica)) {
                    Vendedor oldCodvendedOfVendedorcaracteristicaCollectionNewVendedorcaracteristica = vendedorcaracteristicaCollectionNewVendedorcaracteristica.getCodvended();
                    vendedorcaracteristicaCollectionNewVendedorcaracteristica.setCodvended(vendedor);
                    vendedorcaracteristicaCollectionNewVendedorcaracteristica = em.merge(vendedorcaracteristicaCollectionNewVendedorcaracteristica);
                    if (oldCodvendedOfVendedorcaracteristicaCollectionNewVendedorcaracteristica != null && !oldCodvendedOfVendedorcaracteristicaCollectionNewVendedorcaracteristica.equals(vendedor)) {
                        oldCodvendedOfVendedorcaracteristicaCollectionNewVendedorcaracteristica.getVendedorcaracteristicaCollection().remove(vendedorcaracteristicaCollectionNewVendedorcaracteristica);
                        oldCodvendedOfVendedorcaracteristicaCollectionNewVendedorcaracteristica = em.merge(oldCodvendedOfVendedorcaracteristicaCollectionNewVendedorcaracteristica);
                    }
                }
            }
            for (Orcamento orcamentoCollectionOldOrcamento : orcamentoCollectionOld) {
                if (!orcamentoCollectionNew.contains(orcamentoCollectionOldOrcamento)) {
                    orcamentoCollectionOldOrcamento.setCodvended(null);
                    orcamentoCollectionOldOrcamento = em.merge(orcamentoCollectionOldOrcamento);
                }
            }
            for (Orcamento orcamentoCollectionNewOrcamento : orcamentoCollectionNew) {
                if (!orcamentoCollectionOld.contains(orcamentoCollectionNewOrcamento)) {
                    Vendedor oldCodvendedOfOrcamentoCollectionNewOrcamento = orcamentoCollectionNewOrcamento.getCodvended();
                    orcamentoCollectionNewOrcamento.setCodvended(vendedor);
                    orcamentoCollectionNewOrcamento = em.merge(orcamentoCollectionNewOrcamento);
                    if (oldCodvendedOfOrcamentoCollectionNewOrcamento != null && !oldCodvendedOfOrcamentoCollectionNewOrcamento.equals(vendedor)) {
                        oldCodvendedOfOrcamentoCollectionNewOrcamento.getOrcamentoCollection().remove(orcamentoCollectionNewOrcamento);
                        oldCodvendedOfOrcamentoCollectionNewOrcamento = em.merge(oldCodvendedOfOrcamentoCollectionNewOrcamento);
                    }
                }
            }
            for (Orcamento orcamentoCollection1OldOrcamento : orcamentoCollection1Old) {
                if (!orcamentoCollection1New.contains(orcamentoCollection1OldOrcamento)) {
                    orcamentoCollection1OldOrcamento.setCodvendedext(null);
                    orcamentoCollection1OldOrcamento = em.merge(orcamentoCollection1OldOrcamento);
                }
            }
            for (Orcamento orcamentoCollection1NewOrcamento : orcamentoCollection1New) {
                if (!orcamentoCollection1Old.contains(orcamentoCollection1NewOrcamento)) {
                    Vendedor oldCodvendedextOfOrcamentoCollection1NewOrcamento = orcamentoCollection1NewOrcamento.getCodvendedext();
                    orcamentoCollection1NewOrcamento.setCodvendedext(vendedor);
                    orcamentoCollection1NewOrcamento = em.merge(orcamentoCollection1NewOrcamento);
                    if (oldCodvendedextOfOrcamentoCollection1NewOrcamento != null && !oldCodvendedextOfOrcamentoCollection1NewOrcamento.equals(vendedor)) {
                        oldCodvendedextOfOrcamentoCollection1NewOrcamento.getOrcamentoCollection1().remove(orcamentoCollection1NewOrcamento);
                        oldCodvendedextOfOrcamentoCollection1NewOrcamento = em.merge(oldCodvendedextOfOrcamentoCollection1NewOrcamento);
                    }
                }
            }
            for (Movenda movendaCollectionOldMovenda : movendaCollectionOld) {
                if (!movendaCollectionNew.contains(movendaCollectionOldMovenda)) {
                    movendaCollectionOldMovenda.setCodvended(null);
                    movendaCollectionOldMovenda = em.merge(movendaCollectionOldMovenda);
                }
            }
            for (Movenda movendaCollectionNewMovenda : movendaCollectionNew) {
                if (!movendaCollectionOld.contains(movendaCollectionNewMovenda)) {
                    Vendedor oldCodvendedOfMovendaCollectionNewMovenda = movendaCollectionNewMovenda.getCodvended();
                    movendaCollectionNewMovenda.setCodvended(vendedor);
                    movendaCollectionNewMovenda = em.merge(movendaCollectionNewMovenda);
                    if (oldCodvendedOfMovendaCollectionNewMovenda != null && !oldCodvendedOfMovendaCollectionNewMovenda.equals(vendedor)) {
                        oldCodvendedOfMovendaCollectionNewMovenda.getMovendaCollection().remove(movendaCollectionNewMovenda);
                        oldCodvendedOfMovendaCollectionNewMovenda = em.merge(oldCodvendedOfMovendaCollectionNewMovenda);
                    }
                }
            }
            for (Movenda movendaCollection1OldMovenda : movendaCollection1Old) {
                if (!movendaCollection1New.contains(movendaCollection1OldMovenda)) {
                    movendaCollection1OldMovenda.setCodvendedext(null);
                    movendaCollection1OldMovenda = em.merge(movendaCollection1OldMovenda);
                }
            }
            for (Movenda movendaCollection1NewMovenda : movendaCollection1New) {
                if (!movendaCollection1Old.contains(movendaCollection1NewMovenda)) {
                    Vendedor oldCodvendedextOfMovendaCollection1NewMovenda = movendaCollection1NewMovenda.getCodvendedext();
                    movendaCollection1NewMovenda.setCodvendedext(vendedor);
                    movendaCollection1NewMovenda = em.merge(movendaCollection1NewMovenda);
                    if (oldCodvendedextOfMovendaCollection1NewMovenda != null && !oldCodvendedextOfMovendaCollection1NewMovenda.equals(vendedor)) {
                        oldCodvendedextOfMovendaCollection1NewMovenda.getMovendaCollection1().remove(movendaCollection1NewMovenda);
                        oldCodvendedextOfMovendaCollection1NewMovenda = em.merge(oldCodvendedextOfMovendaCollection1NewMovenda);
                    }
                }
            }
            for (Orcamentoprod orcamentoprodCollectionOldOrcamentoprod : orcamentoprodCollectionOld) {
                if (!orcamentoprodCollectionNew.contains(orcamentoprodCollectionOldOrcamentoprod)) {
                    orcamentoprodCollectionOldOrcamentoprod.setCodvended(null);
                    orcamentoprodCollectionOldOrcamentoprod = em.merge(orcamentoprodCollectionOldOrcamentoprod);
                }
            }
            for (Orcamentoprod orcamentoprodCollectionNewOrcamentoprod : orcamentoprodCollectionNew) {
                if (!orcamentoprodCollectionOld.contains(orcamentoprodCollectionNewOrcamentoprod)) {
                    Vendedor oldCodvendedOfOrcamentoprodCollectionNewOrcamentoprod = orcamentoprodCollectionNewOrcamentoprod.getCodvended();
                    orcamentoprodCollectionNewOrcamentoprod.setCodvended(vendedor);
                    orcamentoprodCollectionNewOrcamentoprod = em.merge(orcamentoprodCollectionNewOrcamentoprod);
                    if (oldCodvendedOfOrcamentoprodCollectionNewOrcamentoprod != null && !oldCodvendedOfOrcamentoprodCollectionNewOrcamentoprod.equals(vendedor)) {
                        oldCodvendedOfOrcamentoprodCollectionNewOrcamentoprod.getOrcamentoprodCollection().remove(orcamentoprodCollectionNewOrcamentoprod);
                        oldCodvendedOfOrcamentoprodCollectionNewOrcamentoprod = em.merge(oldCodvendedOfOrcamentoprodCollectionNewOrcamentoprod);
                    }
                }
            }
            for (Cliente clienteCollectionOldCliente : clienteCollectionOld) {
                if (!clienteCollectionNew.contains(clienteCollectionOldCliente)) {
                    clienteCollectionOldCliente.setCodvended(null);
                    clienteCollectionOldCliente = em.merge(clienteCollectionOldCliente);
                }
            }
            for (Cliente clienteCollectionNewCliente : clienteCollectionNew) {
                if (!clienteCollectionOld.contains(clienteCollectionNewCliente)) {
                    Vendedor oldCodvendedOfClienteCollectionNewCliente = clienteCollectionNewCliente.getCodvended();
                    clienteCollectionNewCliente.setCodvended(vendedor);
                    clienteCollectionNewCliente = em.merge(clienteCollectionNewCliente);
                    if (oldCodvendedOfClienteCollectionNewCliente != null && !oldCodvendedOfClienteCollectionNewCliente.equals(vendedor)) {
                        oldCodvendedOfClienteCollectionNewCliente.getClienteCollection().remove(clienteCollectionNewCliente);
                        oldCodvendedOfClienteCollectionNewCliente = em.merge(oldCodvendedOfClienteCollectionNewCliente);
                    }
                }
            }
            for (Cliente clienteCollection1OldCliente : clienteCollection1Old) {
                if (!clienteCollection1New.contains(clienteCollection1OldCliente)) {
                    clienteCollection1OldCliente.setCodvendedext(null);
                    clienteCollection1OldCliente = em.merge(clienteCollection1OldCliente);
                }
            }
            for (Cliente clienteCollection1NewCliente : clienteCollection1New) {
                if (!clienteCollection1Old.contains(clienteCollection1NewCliente)) {
                    Vendedor oldCodvendedextOfClienteCollection1NewCliente = clienteCollection1NewCliente.getCodvendedext();
                    clienteCollection1NewCliente.setCodvendedext(vendedor);
                    clienteCollection1NewCliente = em.merge(clienteCollection1NewCliente);
                    if (oldCodvendedextOfClienteCollection1NewCliente != null && !oldCodvendedextOfClienteCollection1NewCliente.equals(vendedor)) {
                        oldCodvendedextOfClienteCollection1NewCliente.getClienteCollection1().remove(clienteCollection1NewCliente);
                        oldCodvendedextOfClienteCollection1NewCliente = em.merge(oldCodvendedextOfClienteCollection1NewCliente);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = vendedor.getCodvended();
                if (findVendedor(id) == null) {
                    throw new NonexistentEntityException("The vendedor with id " + id + " no longer exists.");
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
            Vendedor vendedor;
            try {
                vendedor = em.getReference(Vendedor.class, id);
                vendedor.getCodvended();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vendedor with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Vendedorsecao> vendedorsecaoCollectionOrphanCheck = vendedor.getVendedorsecaoCollection();
            for (Vendedorsecao vendedorsecaoCollectionOrphanCheckVendedorsecao : vendedorsecaoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Vendedor (" + vendedor + ") cannot be destroyed since the Vendedorsecao " + vendedorsecaoCollectionOrphanCheckVendedorsecao + " in its vendedorsecaoCollection field has a non-nullable codvended field.");
            }
            Collection<Vendedorcaracteristica> vendedorcaracteristicaCollectionOrphanCheck = vendedor.getVendedorcaracteristicaCollection();
            for (Vendedorcaracteristica vendedorcaracteristicaCollectionOrphanCheckVendedorcaracteristica : vendedorcaracteristicaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Vendedor (" + vendedor + ") cannot be destroyed since the Vendedorcaracteristica " + vendedorcaracteristicaCollectionOrphanCheckVendedorcaracteristica + " in its vendedorcaracteristicaCollection field has a non-nullable codvended field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Vendedor codvendedsupervisor = vendedor.getCodvendedsupervisor();
            if (codvendedsupervisor != null) {
                codvendedsupervisor.getVendedorCollection().remove(vendedor);
                codvendedsupervisor = em.merge(codvendedsupervisor);
            }
            Collection<Moventrada> moventradaCollection = vendedor.getMoventradaCollection();
            for (Moventrada moventradaCollectionMoventrada : moventradaCollection) {
                moventradaCollectionMoventrada.setCodvended(null);
                moventradaCollectionMoventrada = em.merge(moventradaCollectionMoventrada);
            }
            Collection<Moventradaprod> moventradaprodCollection = vendedor.getMoventradaprodCollection();
            for (Moventradaprod moventradaprodCollectionMoventradaprod : moventradaprodCollection) {
                moventradaprodCollectionMoventradaprod.setCodvended(null);
                moventradaprodCollectionMoventradaprod = em.merge(moventradaprodCollectionMoventradaprod);
            }
            Collection<Vendedor> vendedorCollection = vendedor.getVendedorCollection();
            for (Vendedor vendedorCollectionVendedor : vendedorCollection) {
                vendedorCollectionVendedor.setCodvendedsupervisor(null);
                vendedorCollectionVendedor = em.merge(vendedorCollectionVendedor);
            }
            Collection<OsTecnico> osTecnicoCollection = vendedor.getOsTecnicoCollection();
            for (OsTecnico osTecnicoCollectionOsTecnico : osTecnicoCollection) {
                osTecnicoCollectionOsTecnico.setCodvended(null);
                osTecnicoCollectionOsTecnico = em.merge(osTecnicoCollectionOsTecnico);
            }
            Collection<Documento> documentoCollection = vendedor.getDocumentoCollection();
            for (Documento documentoCollectionDocumento : documentoCollection) {
                documentoCollectionDocumento.setCodvended(null);
                documentoCollectionDocumento = em.merge(documentoCollectionDocumento);
            }
            Collection<Documento> documentoCollection1 = vendedor.getDocumentoCollection1();
            for (Documento documentoCollection1Documento : documentoCollection1) {
                documentoCollection1Documento.setCodvendedext(null);
                documentoCollection1Documento = em.merge(documentoCollection1Documento);
            }
            Collection<Cheques> chequesCollection = vendedor.getChequesCollection();
            for (Cheques chequesCollectionCheques : chequesCollection) {
                chequesCollectionCheques.setCodvendedrenegociacao(null);
                chequesCollectionCheques = em.merge(chequesCollectionCheques);
            }
            Collection<Rma> rmaCollection = vendedor.getRmaCollection();
            for (Rma rmaCollectionRma : rmaCollection) {
                rmaCollectionRma.setCodvended(null);
                rmaCollectionRma = em.merge(rmaCollectionRma);
            }
            Collection<Usuario> usuarioCollection = vendedor.getUsuarioCollection();
            for (Usuario usuarioCollectionUsuario : usuarioCollection) {
                usuarioCollectionUsuario.setCodvended(null);
                usuarioCollectionUsuario = em.merge(usuarioCollectionUsuario);
            }
            Collection<Movendaprod> movendaprodCollection = vendedor.getMovendaprodCollection();
            for (Movendaprod movendaprodCollectionMovendaprod : movendaprodCollection) {
                movendaprodCollectionMovendaprod.setCodvended(null);
                movendaprodCollectionMovendaprod = em.merge(movendaprodCollectionMovendaprod);
            }
            Collection<Chequeshistorico> chequeshistoricoCollection = vendedor.getChequeshistoricoCollection();
            for (Chequeshistorico chequeshistoricoCollectionChequeshistorico : chequeshistoricoCollection) {
                chequeshistoricoCollectionChequeshistorico.setCodvendedrenegociacao(null);
                chequeshistoricoCollectionChequeshistorico = em.merge(chequeshistoricoCollectionChequeshistorico);
            }
            Collection<Orcamento> orcamentoCollection = vendedor.getOrcamentoCollection();
            for (Orcamento orcamentoCollectionOrcamento : orcamentoCollection) {
                orcamentoCollectionOrcamento.setCodvended(null);
                orcamentoCollectionOrcamento = em.merge(orcamentoCollectionOrcamento);
            }
            Collection<Orcamento> orcamentoCollection1 = vendedor.getOrcamentoCollection1();
            for (Orcamento orcamentoCollection1Orcamento : orcamentoCollection1) {
                orcamentoCollection1Orcamento.setCodvendedext(null);
                orcamentoCollection1Orcamento = em.merge(orcamentoCollection1Orcamento);
            }
            Collection<Movenda> movendaCollection = vendedor.getMovendaCollection();
            for (Movenda movendaCollectionMovenda : movendaCollection) {
                movendaCollectionMovenda.setCodvended(null);
                movendaCollectionMovenda = em.merge(movendaCollectionMovenda);
            }
            Collection<Movenda> movendaCollection1 = vendedor.getMovendaCollection1();
            for (Movenda movendaCollection1Movenda : movendaCollection1) {
                movendaCollection1Movenda.setCodvendedext(null);
                movendaCollection1Movenda = em.merge(movendaCollection1Movenda);
            }
            Collection<Orcamentoprod> orcamentoprodCollection = vendedor.getOrcamentoprodCollection();
            for (Orcamentoprod orcamentoprodCollectionOrcamentoprod : orcamentoprodCollection) {
                orcamentoprodCollectionOrcamentoprod.setCodvended(null);
                orcamentoprodCollectionOrcamentoprod = em.merge(orcamentoprodCollectionOrcamentoprod);
            }
            Collection<Cliente> clienteCollection = vendedor.getClienteCollection();
            for (Cliente clienteCollectionCliente : clienteCollection) {
                clienteCollectionCliente.setCodvended(null);
                clienteCollectionCliente = em.merge(clienteCollectionCliente);
            }
            Collection<Cliente> clienteCollection1 = vendedor.getClienteCollection1();
            for (Cliente clienteCollection1Cliente : clienteCollection1) {
                clienteCollection1Cliente.setCodvendedext(null);
                clienteCollection1Cliente = em.merge(clienteCollection1Cliente);
            }
            em.remove(vendedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vendedor> findVendedorEntities() {
        return findVendedorEntities(true, -1, -1);
    }

    public List<Vendedor> findVendedorEntities(int maxResults, int firstResult) {
        return findVendedorEntities(false, maxResults, firstResult);
    }

    private List<Vendedor> findVendedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vendedor.class));
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

    public Vendedor findVendedor(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vendedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getVendedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vendedor> rt = cq.from(Vendedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

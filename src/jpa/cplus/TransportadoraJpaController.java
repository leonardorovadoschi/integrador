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
import entidade.cplus.Documento;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Veiculos;
import entidade.cplus.Fornecedor;
import entidade.cplus.Moentrega;
import entidade.cplus.Orcamento;
import entidade.cplus.Movenda;
import entidade.cplus.Pedido;
import entidade.cplus.Cliente;
import entidade.cplus.Transportadora;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class TransportadoraJpaController implements Serializable {

    public TransportadoraJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Transportadora transportadora) throws PreexistingEntityException, Exception {
        if (transportadora.getDocumentoCollection() == null) {
            transportadora.setDocumentoCollection(new ArrayList<Documento>());
        }
        if (transportadora.getVeiculosCollection() == null) {
            transportadora.setVeiculosCollection(new ArrayList<Veiculos>());
        }
        if (transportadora.getFornecedorCollection() == null) {
            transportadora.setFornecedorCollection(new ArrayList<Fornecedor>());
        }
        if (transportadora.getMoentregaCollection() == null) {
            transportadora.setMoentregaCollection(new ArrayList<Moentrega>());
        }
        if (transportadora.getOrcamentoCollection() == null) {
            transportadora.setOrcamentoCollection(new ArrayList<Orcamento>());
        }
        if (transportadora.getMovendaCollection() == null) {
            transportadora.setMovendaCollection(new ArrayList<Movenda>());
        }
        if (transportadora.getPedidoCollection() == null) {
            transportadora.setPedidoCollection(new ArrayList<Pedido>());
        }
        if (transportadora.getClienteCollection() == null) {
            transportadora.setClienteCollection(new ArrayList<Cliente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Documento> attachedDocumentoCollection = new ArrayList<Documento>();
            for (Documento documentoCollectionDocumentoToAttach : transportadora.getDocumentoCollection()) {
                documentoCollectionDocumentoToAttach = em.getReference(documentoCollectionDocumentoToAttach.getClass(), documentoCollectionDocumentoToAttach.getCoddocumento());
                attachedDocumentoCollection.add(documentoCollectionDocumentoToAttach);
            }
            transportadora.setDocumentoCollection(attachedDocumentoCollection);
            Collection<Veiculos> attachedVeiculosCollection = new ArrayList<Veiculos>();
            for (Veiculos veiculosCollectionVeiculosToAttach : transportadora.getVeiculosCollection()) {
                veiculosCollectionVeiculosToAttach = em.getReference(veiculosCollectionVeiculosToAttach.getClass(), veiculosCollectionVeiculosToAttach.getCodveiculo());
                attachedVeiculosCollection.add(veiculosCollectionVeiculosToAttach);
            }
            transportadora.setVeiculosCollection(attachedVeiculosCollection);
            Collection<Fornecedor> attachedFornecedorCollection = new ArrayList<Fornecedor>();
            for (Fornecedor fornecedorCollectionFornecedorToAttach : transportadora.getFornecedorCollection()) {
                fornecedorCollectionFornecedorToAttach = em.getReference(fornecedorCollectionFornecedorToAttach.getClass(), fornecedorCollectionFornecedorToAttach.getCodforn());
                attachedFornecedorCollection.add(fornecedorCollectionFornecedorToAttach);
            }
            transportadora.setFornecedorCollection(attachedFornecedorCollection);
            Collection<Moentrega> attachedMoentregaCollection = new ArrayList<Moentrega>();
            for (Moentrega moentregaCollectionMoentregaToAttach : transportadora.getMoentregaCollection()) {
                moentregaCollectionMoentregaToAttach = em.getReference(moentregaCollectionMoentregaToAttach.getClass(), moentregaCollectionMoentregaToAttach.getCodmovenda());
                attachedMoentregaCollection.add(moentregaCollectionMoentregaToAttach);
            }
            transportadora.setMoentregaCollection(attachedMoentregaCollection);
            Collection<Orcamento> attachedOrcamentoCollection = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollectionOrcamentoToAttach : transportadora.getOrcamentoCollection()) {
                orcamentoCollectionOrcamentoToAttach = em.getReference(orcamentoCollectionOrcamentoToAttach.getClass(), orcamentoCollectionOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollection.add(orcamentoCollectionOrcamentoToAttach);
            }
            transportadora.setOrcamentoCollection(attachedOrcamentoCollection);
            Collection<Movenda> attachedMovendaCollection = new ArrayList<Movenda>();
            for (Movenda movendaCollectionMovendaToAttach : transportadora.getMovendaCollection()) {
                movendaCollectionMovendaToAttach = em.getReference(movendaCollectionMovendaToAttach.getClass(), movendaCollectionMovendaToAttach.getCodmovenda());
                attachedMovendaCollection.add(movendaCollectionMovendaToAttach);
            }
            transportadora.setMovendaCollection(attachedMovendaCollection);
            Collection<Pedido> attachedPedidoCollection = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionPedidoToAttach : transportadora.getPedidoCollection()) {
                pedidoCollectionPedidoToAttach = em.getReference(pedidoCollectionPedidoToAttach.getClass(), pedidoCollectionPedidoToAttach.getCodped());
                attachedPedidoCollection.add(pedidoCollectionPedidoToAttach);
            }
            transportadora.setPedidoCollection(attachedPedidoCollection);
            Collection<Cliente> attachedClienteCollection = new ArrayList<Cliente>();
            for (Cliente clienteCollectionClienteToAttach : transportadora.getClienteCollection()) {
                clienteCollectionClienteToAttach = em.getReference(clienteCollectionClienteToAttach.getClass(), clienteCollectionClienteToAttach.getCodcli());
                attachedClienteCollection.add(clienteCollectionClienteToAttach);
            }
            transportadora.setClienteCollection(attachedClienteCollection);
            em.persist(transportadora);
            for (Documento documentoCollectionDocumento : transportadora.getDocumentoCollection()) {
                Transportadora oldCodtransOfDocumentoCollectionDocumento = documentoCollectionDocumento.getCodtrans();
                documentoCollectionDocumento.setCodtrans(transportadora);
                documentoCollectionDocumento = em.merge(documentoCollectionDocumento);
                if (oldCodtransOfDocumentoCollectionDocumento != null) {
                    oldCodtransOfDocumentoCollectionDocumento.getDocumentoCollection().remove(documentoCollectionDocumento);
                    oldCodtransOfDocumentoCollectionDocumento = em.merge(oldCodtransOfDocumentoCollectionDocumento);
                }
            }
            for (Veiculos veiculosCollectionVeiculos : transportadora.getVeiculosCollection()) {
                Transportadora oldCodtransOfVeiculosCollectionVeiculos = veiculosCollectionVeiculos.getCodtrans();
                veiculosCollectionVeiculos.setCodtrans(transportadora);
                veiculosCollectionVeiculos = em.merge(veiculosCollectionVeiculos);
                if (oldCodtransOfVeiculosCollectionVeiculos != null) {
                    oldCodtransOfVeiculosCollectionVeiculos.getVeiculosCollection().remove(veiculosCollectionVeiculos);
                    oldCodtransOfVeiculosCollectionVeiculos = em.merge(oldCodtransOfVeiculosCollectionVeiculos);
                }
            }
            for (Fornecedor fornecedorCollectionFornecedor : transportadora.getFornecedorCollection()) {
                Transportadora oldCodtransOfFornecedorCollectionFornecedor = fornecedorCollectionFornecedor.getCodtrans();
                fornecedorCollectionFornecedor.setCodtrans(transportadora);
                fornecedorCollectionFornecedor = em.merge(fornecedorCollectionFornecedor);
                if (oldCodtransOfFornecedorCollectionFornecedor != null) {
                    oldCodtransOfFornecedorCollectionFornecedor.getFornecedorCollection().remove(fornecedorCollectionFornecedor);
                    oldCodtransOfFornecedorCollectionFornecedor = em.merge(oldCodtransOfFornecedorCollectionFornecedor);
                }
            }
            for (Moentrega moentregaCollectionMoentrega : transportadora.getMoentregaCollection()) {
                Transportadora oldCodtransOfMoentregaCollectionMoentrega = moentregaCollectionMoentrega.getCodtrans();
                moentregaCollectionMoentrega.setCodtrans(transportadora);
                moentregaCollectionMoentrega = em.merge(moentregaCollectionMoentrega);
                if (oldCodtransOfMoentregaCollectionMoentrega != null) {
                    oldCodtransOfMoentregaCollectionMoentrega.getMoentregaCollection().remove(moentregaCollectionMoentrega);
                    oldCodtransOfMoentregaCollectionMoentrega = em.merge(oldCodtransOfMoentregaCollectionMoentrega);
                }
            }
            for (Orcamento orcamentoCollectionOrcamento : transportadora.getOrcamentoCollection()) {
                Transportadora oldCodtransOfOrcamentoCollectionOrcamento = orcamentoCollectionOrcamento.getCodtrans();
                orcamentoCollectionOrcamento.setCodtrans(transportadora);
                orcamentoCollectionOrcamento = em.merge(orcamentoCollectionOrcamento);
                if (oldCodtransOfOrcamentoCollectionOrcamento != null) {
                    oldCodtransOfOrcamentoCollectionOrcamento.getOrcamentoCollection().remove(orcamentoCollectionOrcamento);
                    oldCodtransOfOrcamentoCollectionOrcamento = em.merge(oldCodtransOfOrcamentoCollectionOrcamento);
                }
            }
            for (Movenda movendaCollectionMovenda : transportadora.getMovendaCollection()) {
                Transportadora oldCodtransOfMovendaCollectionMovenda = movendaCollectionMovenda.getCodtrans();
                movendaCollectionMovenda.setCodtrans(transportadora);
                movendaCollectionMovenda = em.merge(movendaCollectionMovenda);
                if (oldCodtransOfMovendaCollectionMovenda != null) {
                    oldCodtransOfMovendaCollectionMovenda.getMovendaCollection().remove(movendaCollectionMovenda);
                    oldCodtransOfMovendaCollectionMovenda = em.merge(oldCodtransOfMovendaCollectionMovenda);
                }
            }
            for (Pedido pedidoCollectionPedido : transportadora.getPedidoCollection()) {
                Transportadora oldCodtransOfPedidoCollectionPedido = pedidoCollectionPedido.getCodtrans();
                pedidoCollectionPedido.setCodtrans(transportadora);
                pedidoCollectionPedido = em.merge(pedidoCollectionPedido);
                if (oldCodtransOfPedidoCollectionPedido != null) {
                    oldCodtransOfPedidoCollectionPedido.getPedidoCollection().remove(pedidoCollectionPedido);
                    oldCodtransOfPedidoCollectionPedido = em.merge(oldCodtransOfPedidoCollectionPedido);
                }
            }
            for (Cliente clienteCollectionCliente : transportadora.getClienteCollection()) {
                Transportadora oldCodtransOfClienteCollectionCliente = clienteCollectionCliente.getCodtrans();
                clienteCollectionCliente.setCodtrans(transportadora);
                clienteCollectionCliente = em.merge(clienteCollectionCliente);
                if (oldCodtransOfClienteCollectionCliente != null) {
                    oldCodtransOfClienteCollectionCliente.getClienteCollection().remove(clienteCollectionCliente);
                    oldCodtransOfClienteCollectionCliente = em.merge(oldCodtransOfClienteCollectionCliente);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTransportadora(transportadora.getCodtrans()) != null) {
                throw new PreexistingEntityException("Transportadora " + transportadora + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Transportadora transportadora) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Transportadora persistentTransportadora = em.find(Transportadora.class, transportadora.getCodtrans());
            Collection<Documento> documentoCollectionOld = persistentTransportadora.getDocumentoCollection();
            Collection<Documento> documentoCollectionNew = transportadora.getDocumentoCollection();
            Collection<Veiculos> veiculosCollectionOld = persistentTransportadora.getVeiculosCollection();
            Collection<Veiculos> veiculosCollectionNew = transportadora.getVeiculosCollection();
            Collection<Fornecedor> fornecedorCollectionOld = persistentTransportadora.getFornecedorCollection();
            Collection<Fornecedor> fornecedorCollectionNew = transportadora.getFornecedorCollection();
            Collection<Moentrega> moentregaCollectionOld = persistentTransportadora.getMoentregaCollection();
            Collection<Moentrega> moentregaCollectionNew = transportadora.getMoentregaCollection();
            Collection<Orcamento> orcamentoCollectionOld = persistentTransportadora.getOrcamentoCollection();
            Collection<Orcamento> orcamentoCollectionNew = transportadora.getOrcamentoCollection();
            Collection<Movenda> movendaCollectionOld = persistentTransportadora.getMovendaCollection();
            Collection<Movenda> movendaCollectionNew = transportadora.getMovendaCollection();
            Collection<Pedido> pedidoCollectionOld = persistentTransportadora.getPedidoCollection();
            Collection<Pedido> pedidoCollectionNew = transportadora.getPedidoCollection();
            Collection<Cliente> clienteCollectionOld = persistentTransportadora.getClienteCollection();
            Collection<Cliente> clienteCollectionNew = transportadora.getClienteCollection();
            Collection<Documento> attachedDocumentoCollectionNew = new ArrayList<Documento>();
            for (Documento documentoCollectionNewDocumentoToAttach : documentoCollectionNew) {
                documentoCollectionNewDocumentoToAttach = em.getReference(documentoCollectionNewDocumentoToAttach.getClass(), documentoCollectionNewDocumentoToAttach.getCoddocumento());
                attachedDocumentoCollectionNew.add(documentoCollectionNewDocumentoToAttach);
            }
            documentoCollectionNew = attachedDocumentoCollectionNew;
            transportadora.setDocumentoCollection(documentoCollectionNew);
            Collection<Veiculos> attachedVeiculosCollectionNew = new ArrayList<Veiculos>();
            for (Veiculos veiculosCollectionNewVeiculosToAttach : veiculosCollectionNew) {
                veiculosCollectionNewVeiculosToAttach = em.getReference(veiculosCollectionNewVeiculosToAttach.getClass(), veiculosCollectionNewVeiculosToAttach.getCodveiculo());
                attachedVeiculosCollectionNew.add(veiculosCollectionNewVeiculosToAttach);
            }
            veiculosCollectionNew = attachedVeiculosCollectionNew;
            transportadora.setVeiculosCollection(veiculosCollectionNew);
            Collection<Fornecedor> attachedFornecedorCollectionNew = new ArrayList<Fornecedor>();
            for (Fornecedor fornecedorCollectionNewFornecedorToAttach : fornecedorCollectionNew) {
                fornecedorCollectionNewFornecedorToAttach = em.getReference(fornecedorCollectionNewFornecedorToAttach.getClass(), fornecedorCollectionNewFornecedorToAttach.getCodforn());
                attachedFornecedorCollectionNew.add(fornecedorCollectionNewFornecedorToAttach);
            }
            fornecedorCollectionNew = attachedFornecedorCollectionNew;
            transportadora.setFornecedorCollection(fornecedorCollectionNew);
            Collection<Moentrega> attachedMoentregaCollectionNew = new ArrayList<Moentrega>();
            for (Moentrega moentregaCollectionNewMoentregaToAttach : moentregaCollectionNew) {
                moentregaCollectionNewMoentregaToAttach = em.getReference(moentregaCollectionNewMoentregaToAttach.getClass(), moentregaCollectionNewMoentregaToAttach.getCodmovenda());
                attachedMoentregaCollectionNew.add(moentregaCollectionNewMoentregaToAttach);
            }
            moentregaCollectionNew = attachedMoentregaCollectionNew;
            transportadora.setMoentregaCollection(moentregaCollectionNew);
            Collection<Orcamento> attachedOrcamentoCollectionNew = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollectionNewOrcamentoToAttach : orcamentoCollectionNew) {
                orcamentoCollectionNewOrcamentoToAttach = em.getReference(orcamentoCollectionNewOrcamentoToAttach.getClass(), orcamentoCollectionNewOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollectionNew.add(orcamentoCollectionNewOrcamentoToAttach);
            }
            orcamentoCollectionNew = attachedOrcamentoCollectionNew;
            transportadora.setOrcamentoCollection(orcamentoCollectionNew);
            Collection<Movenda> attachedMovendaCollectionNew = new ArrayList<Movenda>();
            for (Movenda movendaCollectionNewMovendaToAttach : movendaCollectionNew) {
                movendaCollectionNewMovendaToAttach = em.getReference(movendaCollectionNewMovendaToAttach.getClass(), movendaCollectionNewMovendaToAttach.getCodmovenda());
                attachedMovendaCollectionNew.add(movendaCollectionNewMovendaToAttach);
            }
            movendaCollectionNew = attachedMovendaCollectionNew;
            transportadora.setMovendaCollection(movendaCollectionNew);
            Collection<Pedido> attachedPedidoCollectionNew = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionNewPedidoToAttach : pedidoCollectionNew) {
                pedidoCollectionNewPedidoToAttach = em.getReference(pedidoCollectionNewPedidoToAttach.getClass(), pedidoCollectionNewPedidoToAttach.getCodped());
                attachedPedidoCollectionNew.add(pedidoCollectionNewPedidoToAttach);
            }
            pedidoCollectionNew = attachedPedidoCollectionNew;
            transportadora.setPedidoCollection(pedidoCollectionNew);
            Collection<Cliente> attachedClienteCollectionNew = new ArrayList<Cliente>();
            for (Cliente clienteCollectionNewClienteToAttach : clienteCollectionNew) {
                clienteCollectionNewClienteToAttach = em.getReference(clienteCollectionNewClienteToAttach.getClass(), clienteCollectionNewClienteToAttach.getCodcli());
                attachedClienteCollectionNew.add(clienteCollectionNewClienteToAttach);
            }
            clienteCollectionNew = attachedClienteCollectionNew;
            transportadora.setClienteCollection(clienteCollectionNew);
            transportadora = em.merge(transportadora);
            for (Documento documentoCollectionOldDocumento : documentoCollectionOld) {
                if (!documentoCollectionNew.contains(documentoCollectionOldDocumento)) {
                    documentoCollectionOldDocumento.setCodtrans(null);
                    documentoCollectionOldDocumento = em.merge(documentoCollectionOldDocumento);
                }
            }
            for (Documento documentoCollectionNewDocumento : documentoCollectionNew) {
                if (!documentoCollectionOld.contains(documentoCollectionNewDocumento)) {
                    Transportadora oldCodtransOfDocumentoCollectionNewDocumento = documentoCollectionNewDocumento.getCodtrans();
                    documentoCollectionNewDocumento.setCodtrans(transportadora);
                    documentoCollectionNewDocumento = em.merge(documentoCollectionNewDocumento);
                    if (oldCodtransOfDocumentoCollectionNewDocumento != null && !oldCodtransOfDocumentoCollectionNewDocumento.equals(transportadora)) {
                        oldCodtransOfDocumentoCollectionNewDocumento.getDocumentoCollection().remove(documentoCollectionNewDocumento);
                        oldCodtransOfDocumentoCollectionNewDocumento = em.merge(oldCodtransOfDocumentoCollectionNewDocumento);
                    }
                }
            }
            for (Veiculos veiculosCollectionOldVeiculos : veiculosCollectionOld) {
                if (!veiculosCollectionNew.contains(veiculosCollectionOldVeiculos)) {
                    veiculosCollectionOldVeiculos.setCodtrans(null);
                    veiculosCollectionOldVeiculos = em.merge(veiculosCollectionOldVeiculos);
                }
            }
            for (Veiculos veiculosCollectionNewVeiculos : veiculosCollectionNew) {
                if (!veiculosCollectionOld.contains(veiculosCollectionNewVeiculos)) {
                    Transportadora oldCodtransOfVeiculosCollectionNewVeiculos = veiculosCollectionNewVeiculos.getCodtrans();
                    veiculosCollectionNewVeiculos.setCodtrans(transportadora);
                    veiculosCollectionNewVeiculos = em.merge(veiculosCollectionNewVeiculos);
                    if (oldCodtransOfVeiculosCollectionNewVeiculos != null && !oldCodtransOfVeiculosCollectionNewVeiculos.equals(transportadora)) {
                        oldCodtransOfVeiculosCollectionNewVeiculos.getVeiculosCollection().remove(veiculosCollectionNewVeiculos);
                        oldCodtransOfVeiculosCollectionNewVeiculos = em.merge(oldCodtransOfVeiculosCollectionNewVeiculos);
                    }
                }
            }
            for (Fornecedor fornecedorCollectionOldFornecedor : fornecedorCollectionOld) {
                if (!fornecedorCollectionNew.contains(fornecedorCollectionOldFornecedor)) {
                    fornecedorCollectionOldFornecedor.setCodtrans(null);
                    fornecedorCollectionOldFornecedor = em.merge(fornecedorCollectionOldFornecedor);
                }
            }
            for (Fornecedor fornecedorCollectionNewFornecedor : fornecedorCollectionNew) {
                if (!fornecedorCollectionOld.contains(fornecedorCollectionNewFornecedor)) {
                    Transportadora oldCodtransOfFornecedorCollectionNewFornecedor = fornecedorCollectionNewFornecedor.getCodtrans();
                    fornecedorCollectionNewFornecedor.setCodtrans(transportadora);
                    fornecedorCollectionNewFornecedor = em.merge(fornecedorCollectionNewFornecedor);
                    if (oldCodtransOfFornecedorCollectionNewFornecedor != null && !oldCodtransOfFornecedorCollectionNewFornecedor.equals(transportadora)) {
                        oldCodtransOfFornecedorCollectionNewFornecedor.getFornecedorCollection().remove(fornecedorCollectionNewFornecedor);
                        oldCodtransOfFornecedorCollectionNewFornecedor = em.merge(oldCodtransOfFornecedorCollectionNewFornecedor);
                    }
                }
            }
            for (Moentrega moentregaCollectionOldMoentrega : moentregaCollectionOld) {
                if (!moentregaCollectionNew.contains(moentregaCollectionOldMoentrega)) {
                    moentregaCollectionOldMoentrega.setCodtrans(null);
                    moentregaCollectionOldMoentrega = em.merge(moentregaCollectionOldMoentrega);
                }
            }
            for (Moentrega moentregaCollectionNewMoentrega : moentregaCollectionNew) {
                if (!moentregaCollectionOld.contains(moentregaCollectionNewMoentrega)) {
                    Transportadora oldCodtransOfMoentregaCollectionNewMoentrega = moentregaCollectionNewMoentrega.getCodtrans();
                    moentregaCollectionNewMoentrega.setCodtrans(transportadora);
                    moentregaCollectionNewMoentrega = em.merge(moentregaCollectionNewMoentrega);
                    if (oldCodtransOfMoentregaCollectionNewMoentrega != null && !oldCodtransOfMoentregaCollectionNewMoentrega.equals(transportadora)) {
                        oldCodtransOfMoentregaCollectionNewMoentrega.getMoentregaCollection().remove(moentregaCollectionNewMoentrega);
                        oldCodtransOfMoentregaCollectionNewMoentrega = em.merge(oldCodtransOfMoentregaCollectionNewMoentrega);
                    }
                }
            }
            for (Orcamento orcamentoCollectionOldOrcamento : orcamentoCollectionOld) {
                if (!orcamentoCollectionNew.contains(orcamentoCollectionOldOrcamento)) {
                    orcamentoCollectionOldOrcamento.setCodtrans(null);
                    orcamentoCollectionOldOrcamento = em.merge(orcamentoCollectionOldOrcamento);
                }
            }
            for (Orcamento orcamentoCollectionNewOrcamento : orcamentoCollectionNew) {
                if (!orcamentoCollectionOld.contains(orcamentoCollectionNewOrcamento)) {
                    Transportadora oldCodtransOfOrcamentoCollectionNewOrcamento = orcamentoCollectionNewOrcamento.getCodtrans();
                    orcamentoCollectionNewOrcamento.setCodtrans(transportadora);
                    orcamentoCollectionNewOrcamento = em.merge(orcamentoCollectionNewOrcamento);
                    if (oldCodtransOfOrcamentoCollectionNewOrcamento != null && !oldCodtransOfOrcamentoCollectionNewOrcamento.equals(transportadora)) {
                        oldCodtransOfOrcamentoCollectionNewOrcamento.getOrcamentoCollection().remove(orcamentoCollectionNewOrcamento);
                        oldCodtransOfOrcamentoCollectionNewOrcamento = em.merge(oldCodtransOfOrcamentoCollectionNewOrcamento);
                    }
                }
            }
            for (Movenda movendaCollectionOldMovenda : movendaCollectionOld) {
                if (!movendaCollectionNew.contains(movendaCollectionOldMovenda)) {
                    movendaCollectionOldMovenda.setCodtrans(null);
                    movendaCollectionOldMovenda = em.merge(movendaCollectionOldMovenda);
                }
            }
            for (Movenda movendaCollectionNewMovenda : movendaCollectionNew) {
                if (!movendaCollectionOld.contains(movendaCollectionNewMovenda)) {
                    Transportadora oldCodtransOfMovendaCollectionNewMovenda = movendaCollectionNewMovenda.getCodtrans();
                    movendaCollectionNewMovenda.setCodtrans(transportadora);
                    movendaCollectionNewMovenda = em.merge(movendaCollectionNewMovenda);
                    if (oldCodtransOfMovendaCollectionNewMovenda != null && !oldCodtransOfMovendaCollectionNewMovenda.equals(transportadora)) {
                        oldCodtransOfMovendaCollectionNewMovenda.getMovendaCollection().remove(movendaCollectionNewMovenda);
                        oldCodtransOfMovendaCollectionNewMovenda = em.merge(oldCodtransOfMovendaCollectionNewMovenda);
                    }
                }
            }
            for (Pedido pedidoCollectionOldPedido : pedidoCollectionOld) {
                if (!pedidoCollectionNew.contains(pedidoCollectionOldPedido)) {
                    pedidoCollectionOldPedido.setCodtrans(null);
                    pedidoCollectionOldPedido = em.merge(pedidoCollectionOldPedido);
                }
            }
            for (Pedido pedidoCollectionNewPedido : pedidoCollectionNew) {
                if (!pedidoCollectionOld.contains(pedidoCollectionNewPedido)) {
                    Transportadora oldCodtransOfPedidoCollectionNewPedido = pedidoCollectionNewPedido.getCodtrans();
                    pedidoCollectionNewPedido.setCodtrans(transportadora);
                    pedidoCollectionNewPedido = em.merge(pedidoCollectionNewPedido);
                    if (oldCodtransOfPedidoCollectionNewPedido != null && !oldCodtransOfPedidoCollectionNewPedido.equals(transportadora)) {
                        oldCodtransOfPedidoCollectionNewPedido.getPedidoCollection().remove(pedidoCollectionNewPedido);
                        oldCodtransOfPedidoCollectionNewPedido = em.merge(oldCodtransOfPedidoCollectionNewPedido);
                    }
                }
            }
            for (Cliente clienteCollectionOldCliente : clienteCollectionOld) {
                if (!clienteCollectionNew.contains(clienteCollectionOldCliente)) {
                    clienteCollectionOldCliente.setCodtrans(null);
                    clienteCollectionOldCliente = em.merge(clienteCollectionOldCliente);
                }
            }
            for (Cliente clienteCollectionNewCliente : clienteCollectionNew) {
                if (!clienteCollectionOld.contains(clienteCollectionNewCliente)) {
                    Transportadora oldCodtransOfClienteCollectionNewCliente = clienteCollectionNewCliente.getCodtrans();
                    clienteCollectionNewCliente.setCodtrans(transportadora);
                    clienteCollectionNewCliente = em.merge(clienteCollectionNewCliente);
                    if (oldCodtransOfClienteCollectionNewCliente != null && !oldCodtransOfClienteCollectionNewCliente.equals(transportadora)) {
                        oldCodtransOfClienteCollectionNewCliente.getClienteCollection().remove(clienteCollectionNewCliente);
                        oldCodtransOfClienteCollectionNewCliente = em.merge(oldCodtransOfClienteCollectionNewCliente);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = transportadora.getCodtrans();
                if (findTransportadora(id) == null) {
                    throw new NonexistentEntityException("The transportadora with id " + id + " no longer exists.");
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
            Transportadora transportadora;
            try {
                transportadora = em.getReference(Transportadora.class, id);
                transportadora.getCodtrans();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The transportadora with id " + id + " no longer exists.", enfe);
            }
            Collection<Documento> documentoCollection = transportadora.getDocumentoCollection();
            for (Documento documentoCollectionDocumento : documentoCollection) {
                documentoCollectionDocumento.setCodtrans(null);
                documentoCollectionDocumento = em.merge(documentoCollectionDocumento);
            }
            Collection<Veiculos> veiculosCollection = transportadora.getVeiculosCollection();
            for (Veiculos veiculosCollectionVeiculos : veiculosCollection) {
                veiculosCollectionVeiculos.setCodtrans(null);
                veiculosCollectionVeiculos = em.merge(veiculosCollectionVeiculos);
            }
            Collection<Fornecedor> fornecedorCollection = transportadora.getFornecedorCollection();
            for (Fornecedor fornecedorCollectionFornecedor : fornecedorCollection) {
                fornecedorCollectionFornecedor.setCodtrans(null);
                fornecedorCollectionFornecedor = em.merge(fornecedorCollectionFornecedor);
            }
            Collection<Moentrega> moentregaCollection = transportadora.getMoentregaCollection();
            for (Moentrega moentregaCollectionMoentrega : moentregaCollection) {
                moentregaCollectionMoentrega.setCodtrans(null);
                moentregaCollectionMoentrega = em.merge(moentregaCollectionMoentrega);
            }
            Collection<Orcamento> orcamentoCollection = transportadora.getOrcamentoCollection();
            for (Orcamento orcamentoCollectionOrcamento : orcamentoCollection) {
                orcamentoCollectionOrcamento.setCodtrans(null);
                orcamentoCollectionOrcamento = em.merge(orcamentoCollectionOrcamento);
            }
            Collection<Movenda> movendaCollection = transportadora.getMovendaCollection();
            for (Movenda movendaCollectionMovenda : movendaCollection) {
                movendaCollectionMovenda.setCodtrans(null);
                movendaCollectionMovenda = em.merge(movendaCollectionMovenda);
            }
            Collection<Pedido> pedidoCollection = transportadora.getPedidoCollection();
            for (Pedido pedidoCollectionPedido : pedidoCollection) {
                pedidoCollectionPedido.setCodtrans(null);
                pedidoCollectionPedido = em.merge(pedidoCollectionPedido);
            }
            Collection<Cliente> clienteCollection = transportadora.getClienteCollection();
            for (Cliente clienteCollectionCliente : clienteCollection) {
                clienteCollectionCliente.setCodtrans(null);
                clienteCollectionCliente = em.merge(clienteCollectionCliente);
            }
            em.remove(transportadora);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Transportadora> findTransportadoraEntities() {
        return findTransportadoraEntities(true, -1, -1);
    }

    public List<Transportadora> findTransportadoraEntities(int maxResults, int firstResult) {
        return findTransportadoraEntities(false, maxResults, firstResult);
    }

    private List<Transportadora> findTransportadoraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Transportadora.class));
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

    public Transportadora findTransportadora(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Transportadora.class, id);
        } finally {
            em.close();
        }
    }

    public int getTransportadoraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Transportadora> rt = cq.from(Transportadora.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

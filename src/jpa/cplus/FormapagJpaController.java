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
import entidade.cplus.Fornecedor;
import entidade.cplus.Contratocobranca;
import entidade.cplus.Orcamento;
import entidade.cplus.Promocao;
import entidade.cplus.Pedido;
import entidade.cplus.Cliente;
import entidade.cplus.Formapag;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class FormapagJpaController implements Serializable {

    public FormapagJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Formapag formapag) throws PreexistingEntityException, Exception {
        if (formapag.getDocumentoCollection() == null) {
            formapag.setDocumentoCollection(new ArrayList<Documento>());
        }
        if (formapag.getFornecedorCollection() == null) {
            formapag.setFornecedorCollection(new ArrayList<Fornecedor>());
        }
        if (formapag.getContratocobrancaCollection() == null) {
            formapag.setContratocobrancaCollection(new ArrayList<Contratocobranca>());
        }
        if (formapag.getOrcamentoCollection() == null) {
            formapag.setOrcamentoCollection(new ArrayList<Orcamento>());
        }
        if (formapag.getPromocaoCollection() == null) {
            formapag.setPromocaoCollection(new ArrayList<Promocao>());
        }
        if (formapag.getPedidoCollection() == null) {
            formapag.setPedidoCollection(new ArrayList<Pedido>());
        }
        if (formapag.getClienteCollection() == null) {
            formapag.setClienteCollection(new ArrayList<Cliente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Documento> attachedDocumentoCollection = new ArrayList<Documento>();
            for (Documento documentoCollectionDocumentoToAttach : formapag.getDocumentoCollection()) {
                documentoCollectionDocumentoToAttach = em.getReference(documentoCollectionDocumentoToAttach.getClass(), documentoCollectionDocumentoToAttach.getCoddocumento());
                attachedDocumentoCollection.add(documentoCollectionDocumentoToAttach);
            }
            formapag.setDocumentoCollection(attachedDocumentoCollection);
            Collection<Fornecedor> attachedFornecedorCollection = new ArrayList<Fornecedor>();
            for (Fornecedor fornecedorCollectionFornecedorToAttach : formapag.getFornecedorCollection()) {
                fornecedorCollectionFornecedorToAttach = em.getReference(fornecedorCollectionFornecedorToAttach.getClass(), fornecedorCollectionFornecedorToAttach.getCodforn());
                attachedFornecedorCollection.add(fornecedorCollectionFornecedorToAttach);
            }
            formapag.setFornecedorCollection(attachedFornecedorCollection);
            Collection<Contratocobranca> attachedContratocobrancaCollection = new ArrayList<Contratocobranca>();
            for (Contratocobranca contratocobrancaCollectionContratocobrancaToAttach : formapag.getContratocobrancaCollection()) {
                contratocobrancaCollectionContratocobrancaToAttach = em.getReference(contratocobrancaCollectionContratocobrancaToAttach.getClass(), contratocobrancaCollectionContratocobrancaToAttach.getCodcontratocobranca());
                attachedContratocobrancaCollection.add(contratocobrancaCollectionContratocobrancaToAttach);
            }
            formapag.setContratocobrancaCollection(attachedContratocobrancaCollection);
            Collection<Orcamento> attachedOrcamentoCollection = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollectionOrcamentoToAttach : formapag.getOrcamentoCollection()) {
                orcamentoCollectionOrcamentoToAttach = em.getReference(orcamentoCollectionOrcamentoToAttach.getClass(), orcamentoCollectionOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollection.add(orcamentoCollectionOrcamentoToAttach);
            }
            formapag.setOrcamentoCollection(attachedOrcamentoCollection);
            Collection<Promocao> attachedPromocaoCollection = new ArrayList<Promocao>();
            for (Promocao promocaoCollectionPromocaoToAttach : formapag.getPromocaoCollection()) {
                promocaoCollectionPromocaoToAttach = em.getReference(promocaoCollectionPromocaoToAttach.getClass(), promocaoCollectionPromocaoToAttach.getCodpromocao());
                attachedPromocaoCollection.add(promocaoCollectionPromocaoToAttach);
            }
            formapag.setPromocaoCollection(attachedPromocaoCollection);
            Collection<Pedido> attachedPedidoCollection = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionPedidoToAttach : formapag.getPedidoCollection()) {
                pedidoCollectionPedidoToAttach = em.getReference(pedidoCollectionPedidoToAttach.getClass(), pedidoCollectionPedidoToAttach.getCodped());
                attachedPedidoCollection.add(pedidoCollectionPedidoToAttach);
            }
            formapag.setPedidoCollection(attachedPedidoCollection);
            Collection<Cliente> attachedClienteCollection = new ArrayList<Cliente>();
            for (Cliente clienteCollectionClienteToAttach : formapag.getClienteCollection()) {
                clienteCollectionClienteToAttach = em.getReference(clienteCollectionClienteToAttach.getClass(), clienteCollectionClienteToAttach.getCodcli());
                attachedClienteCollection.add(clienteCollectionClienteToAttach);
            }
            formapag.setClienteCollection(attachedClienteCollection);
            em.persist(formapag);
            for (Documento documentoCollectionDocumento : formapag.getDocumentoCollection()) {
                Formapag oldCodfpOfDocumentoCollectionDocumento = documentoCollectionDocumento.getCodfp();
                documentoCollectionDocumento.setCodfp(formapag);
                documentoCollectionDocumento = em.merge(documentoCollectionDocumento);
                if (oldCodfpOfDocumentoCollectionDocumento != null) {
                    oldCodfpOfDocumentoCollectionDocumento.getDocumentoCollection().remove(documentoCollectionDocumento);
                    oldCodfpOfDocumentoCollectionDocumento = em.merge(oldCodfpOfDocumentoCollectionDocumento);
                }
            }
            for (Fornecedor fornecedorCollectionFornecedor : formapag.getFornecedorCollection()) {
                Formapag oldCodfpOfFornecedorCollectionFornecedor = fornecedorCollectionFornecedor.getCodfp();
                fornecedorCollectionFornecedor.setCodfp(formapag);
                fornecedorCollectionFornecedor = em.merge(fornecedorCollectionFornecedor);
                if (oldCodfpOfFornecedorCollectionFornecedor != null) {
                    oldCodfpOfFornecedorCollectionFornecedor.getFornecedorCollection().remove(fornecedorCollectionFornecedor);
                    oldCodfpOfFornecedorCollectionFornecedor = em.merge(oldCodfpOfFornecedorCollectionFornecedor);
                }
            }
            for (Contratocobranca contratocobrancaCollectionContratocobranca : formapag.getContratocobrancaCollection()) {
                Formapag oldCodfpOfContratocobrancaCollectionContratocobranca = contratocobrancaCollectionContratocobranca.getCodfp();
                contratocobrancaCollectionContratocobranca.setCodfp(formapag);
                contratocobrancaCollectionContratocobranca = em.merge(contratocobrancaCollectionContratocobranca);
                if (oldCodfpOfContratocobrancaCollectionContratocobranca != null) {
                    oldCodfpOfContratocobrancaCollectionContratocobranca.getContratocobrancaCollection().remove(contratocobrancaCollectionContratocobranca);
                    oldCodfpOfContratocobrancaCollectionContratocobranca = em.merge(oldCodfpOfContratocobrancaCollectionContratocobranca);
                }
            }
            for (Orcamento orcamentoCollectionOrcamento : formapag.getOrcamentoCollection()) {
                Formapag oldCodfpOfOrcamentoCollectionOrcamento = orcamentoCollectionOrcamento.getCodfp();
                orcamentoCollectionOrcamento.setCodfp(formapag);
                orcamentoCollectionOrcamento = em.merge(orcamentoCollectionOrcamento);
                if (oldCodfpOfOrcamentoCollectionOrcamento != null) {
                    oldCodfpOfOrcamentoCollectionOrcamento.getOrcamentoCollection().remove(orcamentoCollectionOrcamento);
                    oldCodfpOfOrcamentoCollectionOrcamento = em.merge(oldCodfpOfOrcamentoCollectionOrcamento);
                }
            }
            for (Promocao promocaoCollectionPromocao : formapag.getPromocaoCollection()) {
                Formapag oldCodfpOfPromocaoCollectionPromocao = promocaoCollectionPromocao.getCodfp();
                promocaoCollectionPromocao.setCodfp(formapag);
                promocaoCollectionPromocao = em.merge(promocaoCollectionPromocao);
                if (oldCodfpOfPromocaoCollectionPromocao != null) {
                    oldCodfpOfPromocaoCollectionPromocao.getPromocaoCollection().remove(promocaoCollectionPromocao);
                    oldCodfpOfPromocaoCollectionPromocao = em.merge(oldCodfpOfPromocaoCollectionPromocao);
                }
            }
            for (Pedido pedidoCollectionPedido : formapag.getPedidoCollection()) {
                Formapag oldCodfpOfPedidoCollectionPedido = pedidoCollectionPedido.getCodfp();
                pedidoCollectionPedido.setCodfp(formapag);
                pedidoCollectionPedido = em.merge(pedidoCollectionPedido);
                if (oldCodfpOfPedidoCollectionPedido != null) {
                    oldCodfpOfPedidoCollectionPedido.getPedidoCollection().remove(pedidoCollectionPedido);
                    oldCodfpOfPedidoCollectionPedido = em.merge(oldCodfpOfPedidoCollectionPedido);
                }
            }
            for (Cliente clienteCollectionCliente : formapag.getClienteCollection()) {
                Formapag oldCodfpOfClienteCollectionCliente = clienteCollectionCliente.getCodfp();
                clienteCollectionCliente.setCodfp(formapag);
                clienteCollectionCliente = em.merge(clienteCollectionCliente);
                if (oldCodfpOfClienteCollectionCliente != null) {
                    oldCodfpOfClienteCollectionCliente.getClienteCollection().remove(clienteCollectionCliente);
                    oldCodfpOfClienteCollectionCliente = em.merge(oldCodfpOfClienteCollectionCliente);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFormapag(formapag.getCodfp()) != null) {
                throw new PreexistingEntityException("Formapag " + formapag + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Formapag formapag) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Formapag persistentFormapag = em.find(Formapag.class, formapag.getCodfp());
            Collection<Documento> documentoCollectionOld = persistentFormapag.getDocumentoCollection();
            Collection<Documento> documentoCollectionNew = formapag.getDocumentoCollection();
            Collection<Fornecedor> fornecedorCollectionOld = persistentFormapag.getFornecedorCollection();
            Collection<Fornecedor> fornecedorCollectionNew = formapag.getFornecedorCollection();
            Collection<Contratocobranca> contratocobrancaCollectionOld = persistentFormapag.getContratocobrancaCollection();
            Collection<Contratocobranca> contratocobrancaCollectionNew = formapag.getContratocobrancaCollection();
            Collection<Orcamento> orcamentoCollectionOld = persistentFormapag.getOrcamentoCollection();
            Collection<Orcamento> orcamentoCollectionNew = formapag.getOrcamentoCollection();
            Collection<Promocao> promocaoCollectionOld = persistentFormapag.getPromocaoCollection();
            Collection<Promocao> promocaoCollectionNew = formapag.getPromocaoCollection();
            Collection<Pedido> pedidoCollectionOld = persistentFormapag.getPedidoCollection();
            Collection<Pedido> pedidoCollectionNew = formapag.getPedidoCollection();
            Collection<Cliente> clienteCollectionOld = persistentFormapag.getClienteCollection();
            Collection<Cliente> clienteCollectionNew = formapag.getClienteCollection();
            Collection<Documento> attachedDocumentoCollectionNew = new ArrayList<Documento>();
            for (Documento documentoCollectionNewDocumentoToAttach : documentoCollectionNew) {
                documentoCollectionNewDocumentoToAttach = em.getReference(documentoCollectionNewDocumentoToAttach.getClass(), documentoCollectionNewDocumentoToAttach.getCoddocumento());
                attachedDocumentoCollectionNew.add(documentoCollectionNewDocumentoToAttach);
            }
            documentoCollectionNew = attachedDocumentoCollectionNew;
            formapag.setDocumentoCollection(documentoCollectionNew);
            Collection<Fornecedor> attachedFornecedorCollectionNew = new ArrayList<Fornecedor>();
            for (Fornecedor fornecedorCollectionNewFornecedorToAttach : fornecedorCollectionNew) {
                fornecedorCollectionNewFornecedorToAttach = em.getReference(fornecedorCollectionNewFornecedorToAttach.getClass(), fornecedorCollectionNewFornecedorToAttach.getCodforn());
                attachedFornecedorCollectionNew.add(fornecedorCollectionNewFornecedorToAttach);
            }
            fornecedorCollectionNew = attachedFornecedorCollectionNew;
            formapag.setFornecedorCollection(fornecedorCollectionNew);
            Collection<Contratocobranca> attachedContratocobrancaCollectionNew = new ArrayList<Contratocobranca>();
            for (Contratocobranca contratocobrancaCollectionNewContratocobrancaToAttach : contratocobrancaCollectionNew) {
                contratocobrancaCollectionNewContratocobrancaToAttach = em.getReference(contratocobrancaCollectionNewContratocobrancaToAttach.getClass(), contratocobrancaCollectionNewContratocobrancaToAttach.getCodcontratocobranca());
                attachedContratocobrancaCollectionNew.add(contratocobrancaCollectionNewContratocobrancaToAttach);
            }
            contratocobrancaCollectionNew = attachedContratocobrancaCollectionNew;
            formapag.setContratocobrancaCollection(contratocobrancaCollectionNew);
            Collection<Orcamento> attachedOrcamentoCollectionNew = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollectionNewOrcamentoToAttach : orcamentoCollectionNew) {
                orcamentoCollectionNewOrcamentoToAttach = em.getReference(orcamentoCollectionNewOrcamentoToAttach.getClass(), orcamentoCollectionNewOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollectionNew.add(orcamentoCollectionNewOrcamentoToAttach);
            }
            orcamentoCollectionNew = attachedOrcamentoCollectionNew;
            formapag.setOrcamentoCollection(orcamentoCollectionNew);
            Collection<Promocao> attachedPromocaoCollectionNew = new ArrayList<Promocao>();
            for (Promocao promocaoCollectionNewPromocaoToAttach : promocaoCollectionNew) {
                promocaoCollectionNewPromocaoToAttach = em.getReference(promocaoCollectionNewPromocaoToAttach.getClass(), promocaoCollectionNewPromocaoToAttach.getCodpromocao());
                attachedPromocaoCollectionNew.add(promocaoCollectionNewPromocaoToAttach);
            }
            promocaoCollectionNew = attachedPromocaoCollectionNew;
            formapag.setPromocaoCollection(promocaoCollectionNew);
            Collection<Pedido> attachedPedidoCollectionNew = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionNewPedidoToAttach : pedidoCollectionNew) {
                pedidoCollectionNewPedidoToAttach = em.getReference(pedidoCollectionNewPedidoToAttach.getClass(), pedidoCollectionNewPedidoToAttach.getCodped());
                attachedPedidoCollectionNew.add(pedidoCollectionNewPedidoToAttach);
            }
            pedidoCollectionNew = attachedPedidoCollectionNew;
            formapag.setPedidoCollection(pedidoCollectionNew);
            Collection<Cliente> attachedClienteCollectionNew = new ArrayList<Cliente>();
            for (Cliente clienteCollectionNewClienteToAttach : clienteCollectionNew) {
                clienteCollectionNewClienteToAttach = em.getReference(clienteCollectionNewClienteToAttach.getClass(), clienteCollectionNewClienteToAttach.getCodcli());
                attachedClienteCollectionNew.add(clienteCollectionNewClienteToAttach);
            }
            clienteCollectionNew = attachedClienteCollectionNew;
            formapag.setClienteCollection(clienteCollectionNew);
            formapag = em.merge(formapag);
            for (Documento documentoCollectionOldDocumento : documentoCollectionOld) {
                if (!documentoCollectionNew.contains(documentoCollectionOldDocumento)) {
                    documentoCollectionOldDocumento.setCodfp(null);
                    documentoCollectionOldDocumento = em.merge(documentoCollectionOldDocumento);
                }
            }
            for (Documento documentoCollectionNewDocumento : documentoCollectionNew) {
                if (!documentoCollectionOld.contains(documentoCollectionNewDocumento)) {
                    Formapag oldCodfpOfDocumentoCollectionNewDocumento = documentoCollectionNewDocumento.getCodfp();
                    documentoCollectionNewDocumento.setCodfp(formapag);
                    documentoCollectionNewDocumento = em.merge(documentoCollectionNewDocumento);
                    if (oldCodfpOfDocumentoCollectionNewDocumento != null && !oldCodfpOfDocumentoCollectionNewDocumento.equals(formapag)) {
                        oldCodfpOfDocumentoCollectionNewDocumento.getDocumentoCollection().remove(documentoCollectionNewDocumento);
                        oldCodfpOfDocumentoCollectionNewDocumento = em.merge(oldCodfpOfDocumentoCollectionNewDocumento);
                    }
                }
            }
            for (Fornecedor fornecedorCollectionOldFornecedor : fornecedorCollectionOld) {
                if (!fornecedorCollectionNew.contains(fornecedorCollectionOldFornecedor)) {
                    fornecedorCollectionOldFornecedor.setCodfp(null);
                    fornecedorCollectionOldFornecedor = em.merge(fornecedorCollectionOldFornecedor);
                }
            }
            for (Fornecedor fornecedorCollectionNewFornecedor : fornecedorCollectionNew) {
                if (!fornecedorCollectionOld.contains(fornecedorCollectionNewFornecedor)) {
                    Formapag oldCodfpOfFornecedorCollectionNewFornecedor = fornecedorCollectionNewFornecedor.getCodfp();
                    fornecedorCollectionNewFornecedor.setCodfp(formapag);
                    fornecedorCollectionNewFornecedor = em.merge(fornecedorCollectionNewFornecedor);
                    if (oldCodfpOfFornecedorCollectionNewFornecedor != null && !oldCodfpOfFornecedorCollectionNewFornecedor.equals(formapag)) {
                        oldCodfpOfFornecedorCollectionNewFornecedor.getFornecedorCollection().remove(fornecedorCollectionNewFornecedor);
                        oldCodfpOfFornecedorCollectionNewFornecedor = em.merge(oldCodfpOfFornecedorCollectionNewFornecedor);
                    }
                }
            }
            for (Contratocobranca contratocobrancaCollectionOldContratocobranca : contratocobrancaCollectionOld) {
                if (!contratocobrancaCollectionNew.contains(contratocobrancaCollectionOldContratocobranca)) {
                    contratocobrancaCollectionOldContratocobranca.setCodfp(null);
                    contratocobrancaCollectionOldContratocobranca = em.merge(contratocobrancaCollectionOldContratocobranca);
                }
            }
            for (Contratocobranca contratocobrancaCollectionNewContratocobranca : contratocobrancaCollectionNew) {
                if (!contratocobrancaCollectionOld.contains(contratocobrancaCollectionNewContratocobranca)) {
                    Formapag oldCodfpOfContratocobrancaCollectionNewContratocobranca = contratocobrancaCollectionNewContratocobranca.getCodfp();
                    contratocobrancaCollectionNewContratocobranca.setCodfp(formapag);
                    contratocobrancaCollectionNewContratocobranca = em.merge(contratocobrancaCollectionNewContratocobranca);
                    if (oldCodfpOfContratocobrancaCollectionNewContratocobranca != null && !oldCodfpOfContratocobrancaCollectionNewContratocobranca.equals(formapag)) {
                        oldCodfpOfContratocobrancaCollectionNewContratocobranca.getContratocobrancaCollection().remove(contratocobrancaCollectionNewContratocobranca);
                        oldCodfpOfContratocobrancaCollectionNewContratocobranca = em.merge(oldCodfpOfContratocobrancaCollectionNewContratocobranca);
                    }
                }
            }
            for (Orcamento orcamentoCollectionOldOrcamento : orcamentoCollectionOld) {
                if (!orcamentoCollectionNew.contains(orcamentoCollectionOldOrcamento)) {
                    orcamentoCollectionOldOrcamento.setCodfp(null);
                    orcamentoCollectionOldOrcamento = em.merge(orcamentoCollectionOldOrcamento);
                }
            }
            for (Orcamento orcamentoCollectionNewOrcamento : orcamentoCollectionNew) {
                if (!orcamentoCollectionOld.contains(orcamentoCollectionNewOrcamento)) {
                    Formapag oldCodfpOfOrcamentoCollectionNewOrcamento = orcamentoCollectionNewOrcamento.getCodfp();
                    orcamentoCollectionNewOrcamento.setCodfp(formapag);
                    orcamentoCollectionNewOrcamento = em.merge(orcamentoCollectionNewOrcamento);
                    if (oldCodfpOfOrcamentoCollectionNewOrcamento != null && !oldCodfpOfOrcamentoCollectionNewOrcamento.equals(formapag)) {
                        oldCodfpOfOrcamentoCollectionNewOrcamento.getOrcamentoCollection().remove(orcamentoCollectionNewOrcamento);
                        oldCodfpOfOrcamentoCollectionNewOrcamento = em.merge(oldCodfpOfOrcamentoCollectionNewOrcamento);
                    }
                }
            }
            for (Promocao promocaoCollectionOldPromocao : promocaoCollectionOld) {
                if (!promocaoCollectionNew.contains(promocaoCollectionOldPromocao)) {
                    promocaoCollectionOldPromocao.setCodfp(null);
                    promocaoCollectionOldPromocao = em.merge(promocaoCollectionOldPromocao);
                }
            }
            for (Promocao promocaoCollectionNewPromocao : promocaoCollectionNew) {
                if (!promocaoCollectionOld.contains(promocaoCollectionNewPromocao)) {
                    Formapag oldCodfpOfPromocaoCollectionNewPromocao = promocaoCollectionNewPromocao.getCodfp();
                    promocaoCollectionNewPromocao.setCodfp(formapag);
                    promocaoCollectionNewPromocao = em.merge(promocaoCollectionNewPromocao);
                    if (oldCodfpOfPromocaoCollectionNewPromocao != null && !oldCodfpOfPromocaoCollectionNewPromocao.equals(formapag)) {
                        oldCodfpOfPromocaoCollectionNewPromocao.getPromocaoCollection().remove(promocaoCollectionNewPromocao);
                        oldCodfpOfPromocaoCollectionNewPromocao = em.merge(oldCodfpOfPromocaoCollectionNewPromocao);
                    }
                }
            }
            for (Pedido pedidoCollectionOldPedido : pedidoCollectionOld) {
                if (!pedidoCollectionNew.contains(pedidoCollectionOldPedido)) {
                    pedidoCollectionOldPedido.setCodfp(null);
                    pedidoCollectionOldPedido = em.merge(pedidoCollectionOldPedido);
                }
            }
            for (Pedido pedidoCollectionNewPedido : pedidoCollectionNew) {
                if (!pedidoCollectionOld.contains(pedidoCollectionNewPedido)) {
                    Formapag oldCodfpOfPedidoCollectionNewPedido = pedidoCollectionNewPedido.getCodfp();
                    pedidoCollectionNewPedido.setCodfp(formapag);
                    pedidoCollectionNewPedido = em.merge(pedidoCollectionNewPedido);
                    if (oldCodfpOfPedidoCollectionNewPedido != null && !oldCodfpOfPedidoCollectionNewPedido.equals(formapag)) {
                        oldCodfpOfPedidoCollectionNewPedido.getPedidoCollection().remove(pedidoCollectionNewPedido);
                        oldCodfpOfPedidoCollectionNewPedido = em.merge(oldCodfpOfPedidoCollectionNewPedido);
                    }
                }
            }
            for (Cliente clienteCollectionOldCliente : clienteCollectionOld) {
                if (!clienteCollectionNew.contains(clienteCollectionOldCliente)) {
                    clienteCollectionOldCliente.setCodfp(null);
                    clienteCollectionOldCliente = em.merge(clienteCollectionOldCliente);
                }
            }
            for (Cliente clienteCollectionNewCliente : clienteCollectionNew) {
                if (!clienteCollectionOld.contains(clienteCollectionNewCliente)) {
                    Formapag oldCodfpOfClienteCollectionNewCliente = clienteCollectionNewCliente.getCodfp();
                    clienteCollectionNewCliente.setCodfp(formapag);
                    clienteCollectionNewCliente = em.merge(clienteCollectionNewCliente);
                    if (oldCodfpOfClienteCollectionNewCliente != null && !oldCodfpOfClienteCollectionNewCliente.equals(formapag)) {
                        oldCodfpOfClienteCollectionNewCliente.getClienteCollection().remove(clienteCollectionNewCliente);
                        oldCodfpOfClienteCollectionNewCliente = em.merge(oldCodfpOfClienteCollectionNewCliente);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = formapag.getCodfp();
                if (findFormapag(id) == null) {
                    throw new NonexistentEntityException("The formapag with id " + id + " no longer exists.");
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
            Formapag formapag;
            try {
                formapag = em.getReference(Formapag.class, id);
                formapag.getCodfp();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The formapag with id " + id + " no longer exists.", enfe);
            }
            Collection<Documento> documentoCollection = formapag.getDocumentoCollection();
            for (Documento documentoCollectionDocumento : documentoCollection) {
                documentoCollectionDocumento.setCodfp(null);
                documentoCollectionDocumento = em.merge(documentoCollectionDocumento);
            }
            Collection<Fornecedor> fornecedorCollection = formapag.getFornecedorCollection();
            for (Fornecedor fornecedorCollectionFornecedor : fornecedorCollection) {
                fornecedorCollectionFornecedor.setCodfp(null);
                fornecedorCollectionFornecedor = em.merge(fornecedorCollectionFornecedor);
            }
            Collection<Contratocobranca> contratocobrancaCollection = formapag.getContratocobrancaCollection();
            for (Contratocobranca contratocobrancaCollectionContratocobranca : contratocobrancaCollection) {
                contratocobrancaCollectionContratocobranca.setCodfp(null);
                contratocobrancaCollectionContratocobranca = em.merge(contratocobrancaCollectionContratocobranca);
            }
            Collection<Orcamento> orcamentoCollection = formapag.getOrcamentoCollection();
            for (Orcamento orcamentoCollectionOrcamento : orcamentoCollection) {
                orcamentoCollectionOrcamento.setCodfp(null);
                orcamentoCollectionOrcamento = em.merge(orcamentoCollectionOrcamento);
            }
            Collection<Promocao> promocaoCollection = formapag.getPromocaoCollection();
            for (Promocao promocaoCollectionPromocao : promocaoCollection) {
                promocaoCollectionPromocao.setCodfp(null);
                promocaoCollectionPromocao = em.merge(promocaoCollectionPromocao);
            }
            Collection<Pedido> pedidoCollection = formapag.getPedidoCollection();
            for (Pedido pedidoCollectionPedido : pedidoCollection) {
                pedidoCollectionPedido.setCodfp(null);
                pedidoCollectionPedido = em.merge(pedidoCollectionPedido);
            }
            Collection<Cliente> clienteCollection = formapag.getClienteCollection();
            for (Cliente clienteCollectionCliente : clienteCollection) {
                clienteCollectionCliente.setCodfp(null);
                clienteCollectionCliente = em.merge(clienteCollectionCliente);
            }
            em.remove(formapag);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Formapag> findFormapagEntities() {
        return findFormapagEntities(true, -1, -1);
    }

    public List<Formapag> findFormapagEntities(int maxResults, int firstResult) {
        return findFormapagEntities(false, maxResults, firstResult);
    }

    private List<Formapag> findFormapagEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Formapag.class));
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

    public Formapag findFormapag(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Formapag.class, id);
        } finally {
            em.close();
        }
    }

    public int getFormapagCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Formapag> rt = cq.from(Formapag.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
import entidade.cplus.Empresa;
import entidade.cplus.Funcionario;
import entidade.cplus.Situacaoadministrativa;
import entidade.cplus.Vendedor;
import entidade.cplus.Producaohistorico;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Documento;
import entidade.cplus.Rma;
import entidade.cplus.Etiquetaendereco;
import entidade.cplus.Usuariopreco;
import entidade.cplus.Pedido;
import entidade.cplus.Movendaproddevolucaocompra;
import entidade.cplus.Cliente;
import entidade.cplus.Usuario;
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
public class UsuarioJpaController implements Serializable {

    public UsuarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Usuario usuario) throws PreexistingEntityException, Exception {
        if (usuario.getProducaohistoricoCollection() == null) {
            usuario.setProducaohistoricoCollection(new ArrayList<Producaohistorico>());
        }
        if (usuario.getDocumentoCollection() == null) {
            usuario.setDocumentoCollection(new ArrayList<Documento>());
        }
        if (usuario.getRmaCollection() == null) {
            usuario.setRmaCollection(new ArrayList<Rma>());
        }
        if (usuario.getEtiquetaenderecoCollection() == null) {
            usuario.setEtiquetaenderecoCollection(new ArrayList<Etiquetaendereco>());
        }
        if (usuario.getUsuarioprecoCollection() == null) {
            usuario.setUsuarioprecoCollection(new ArrayList<Usuariopreco>());
        }
        if (usuario.getPedidoCollection() == null) {
            usuario.setPedidoCollection(new ArrayList<Pedido>());
        }
        if (usuario.getMovendaproddevolucaocompraCollection() == null) {
            usuario.setMovendaproddevolucaocompraCollection(new ArrayList<Movendaproddevolucaocompra>());
        }
        if (usuario.getClienteCollection() == null) {
            usuario.setClienteCollection(new ArrayList<Cliente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa codempresa = usuario.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                usuario.setCodempresa(codempresa);
            }
            Funcionario codfuncionario = usuario.getCodfuncionario();
            if (codfuncionario != null) {
                codfuncionario = em.getReference(codfuncionario.getClass(), codfuncionario.getCodfuncionario());
                usuario.setCodfuncionario(codfuncionario);
            }
            Situacaoadministrativa codsituacaoadministrativa = usuario.getCodsituacaoadministrativa();
            if (codsituacaoadministrativa != null) {
                codsituacaoadministrativa = em.getReference(codsituacaoadministrativa.getClass(), codsituacaoadministrativa.getCodsituacaoadministrativa());
                usuario.setCodsituacaoadministrativa(codsituacaoadministrativa);
            }
            Vendedor codvended = usuario.getCodvended();
            if (codvended != null) {
                codvended = em.getReference(codvended.getClass(), codvended.getCodvended());
                usuario.setCodvended(codvended);
            }
            Collection<Producaohistorico> attachedProducaohistoricoCollection = new ArrayList<Producaohistorico>();
            for (Producaohistorico producaohistoricoCollectionProducaohistoricoToAttach : usuario.getProducaohistoricoCollection()) {
                producaohistoricoCollectionProducaohistoricoToAttach = em.getReference(producaohistoricoCollectionProducaohistoricoToAttach.getClass(), producaohistoricoCollectionProducaohistoricoToAttach.getCodproducaohistorico());
                attachedProducaohistoricoCollection.add(producaohistoricoCollectionProducaohistoricoToAttach);
            }
            usuario.setProducaohistoricoCollection(attachedProducaohistoricoCollection);
            Collection<Documento> attachedDocumentoCollection = new ArrayList<Documento>();
            for (Documento documentoCollectionDocumentoToAttach : usuario.getDocumentoCollection()) {
                documentoCollectionDocumentoToAttach = em.getReference(documentoCollectionDocumentoToAttach.getClass(), documentoCollectionDocumentoToAttach.getCoddocumento());
                attachedDocumentoCollection.add(documentoCollectionDocumentoToAttach);
            }
            usuario.setDocumentoCollection(attachedDocumentoCollection);
            Collection<Rma> attachedRmaCollection = new ArrayList<Rma>();
            for (Rma rmaCollectionRmaToAttach : usuario.getRmaCollection()) {
                rmaCollectionRmaToAttach = em.getReference(rmaCollectionRmaToAttach.getClass(), rmaCollectionRmaToAttach.getCodrma());
                attachedRmaCollection.add(rmaCollectionRmaToAttach);
            }
            usuario.setRmaCollection(attachedRmaCollection);
            Collection<Etiquetaendereco> attachedEtiquetaenderecoCollection = new ArrayList<Etiquetaendereco>();
            for (Etiquetaendereco etiquetaenderecoCollectionEtiquetaenderecoToAttach : usuario.getEtiquetaenderecoCollection()) {
                etiquetaenderecoCollectionEtiquetaenderecoToAttach = em.getReference(etiquetaenderecoCollectionEtiquetaenderecoToAttach.getClass(), etiquetaenderecoCollectionEtiquetaenderecoToAttach.getCodetiquetaendereco());
                attachedEtiquetaenderecoCollection.add(etiquetaenderecoCollectionEtiquetaenderecoToAttach);
            }
            usuario.setEtiquetaenderecoCollection(attachedEtiquetaenderecoCollection);
            Collection<Usuariopreco> attachedUsuarioprecoCollection = new ArrayList<Usuariopreco>();
            for (Usuariopreco usuarioprecoCollectionUsuarioprecoToAttach : usuario.getUsuarioprecoCollection()) {
                usuarioprecoCollectionUsuarioprecoToAttach = em.getReference(usuarioprecoCollectionUsuarioprecoToAttach.getClass(), usuarioprecoCollectionUsuarioprecoToAttach.getCodusuariopreco());
                attachedUsuarioprecoCollection.add(usuarioprecoCollectionUsuarioprecoToAttach);
            }
            usuario.setUsuarioprecoCollection(attachedUsuarioprecoCollection);
            Collection<Pedido> attachedPedidoCollection = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionPedidoToAttach : usuario.getPedidoCollection()) {
                pedidoCollectionPedidoToAttach = em.getReference(pedidoCollectionPedidoToAttach.getClass(), pedidoCollectionPedidoToAttach.getCodped());
                attachedPedidoCollection.add(pedidoCollectionPedidoToAttach);
            }
            usuario.setPedidoCollection(attachedPedidoCollection);
            Collection<Movendaproddevolucaocompra> attachedMovendaproddevolucaocompraCollection = new ArrayList<Movendaproddevolucaocompra>();
            for (Movendaproddevolucaocompra movendaproddevolucaocompraCollectionMovendaproddevolucaocompraToAttach : usuario.getMovendaproddevolucaocompraCollection()) {
                movendaproddevolucaocompraCollectionMovendaproddevolucaocompraToAttach = em.getReference(movendaproddevolucaocompraCollectionMovendaproddevolucaocompraToAttach.getClass(), movendaproddevolucaocompraCollectionMovendaproddevolucaocompraToAttach.getCodmovendaproddevolucaocompra());
                attachedMovendaproddevolucaocompraCollection.add(movendaproddevolucaocompraCollectionMovendaproddevolucaocompraToAttach);
            }
            usuario.setMovendaproddevolucaocompraCollection(attachedMovendaproddevolucaocompraCollection);
            Collection<Cliente> attachedClienteCollection = new ArrayList<Cliente>();
            for (Cliente clienteCollectionClienteToAttach : usuario.getClienteCollection()) {
                clienteCollectionClienteToAttach = em.getReference(clienteCollectionClienteToAttach.getClass(), clienteCollectionClienteToAttach.getCodcli());
                attachedClienteCollection.add(clienteCollectionClienteToAttach);
            }
            usuario.setClienteCollection(attachedClienteCollection);
            em.persist(usuario);
            if (codempresa != null) {
                codempresa.getUsuarioCollection().add(usuario);
                codempresa = em.merge(codempresa);
            }
            if (codfuncionario != null) {
                codfuncionario.getUsuarioCollection().add(usuario);
                codfuncionario = em.merge(codfuncionario);
            }
            if (codsituacaoadministrativa != null) {
                codsituacaoadministrativa.getUsuarioCollection().add(usuario);
                codsituacaoadministrativa = em.merge(codsituacaoadministrativa);
            }
            if (codvended != null) {
                codvended.getUsuarioCollection().add(usuario);
                codvended = em.merge(codvended);
            }
            for (Producaohistorico producaohistoricoCollectionProducaohistorico : usuario.getProducaohistoricoCollection()) {
                Usuario oldCoduserOfProducaohistoricoCollectionProducaohistorico = producaohistoricoCollectionProducaohistorico.getCoduser();
                producaohistoricoCollectionProducaohistorico.setCoduser(usuario);
                producaohistoricoCollectionProducaohistorico = em.merge(producaohistoricoCollectionProducaohistorico);
                if (oldCoduserOfProducaohistoricoCollectionProducaohistorico != null) {
                    oldCoduserOfProducaohistoricoCollectionProducaohistorico.getProducaohistoricoCollection().remove(producaohistoricoCollectionProducaohistorico);
                    oldCoduserOfProducaohistoricoCollectionProducaohistorico = em.merge(oldCoduserOfProducaohistoricoCollectionProducaohistorico);
                }
            }
            for (Documento documentoCollectionDocumento : usuario.getDocumentoCollection()) {
                Usuario oldCoduserOfDocumentoCollectionDocumento = documentoCollectionDocumento.getCoduser();
                documentoCollectionDocumento.setCoduser(usuario);
                documentoCollectionDocumento = em.merge(documentoCollectionDocumento);
                if (oldCoduserOfDocumentoCollectionDocumento != null) {
                    oldCoduserOfDocumentoCollectionDocumento.getDocumentoCollection().remove(documentoCollectionDocumento);
                    oldCoduserOfDocumentoCollectionDocumento = em.merge(oldCoduserOfDocumentoCollectionDocumento);
                }
            }
            for (Rma rmaCollectionRma : usuario.getRmaCollection()) {
                Usuario oldCoduserOfRmaCollectionRma = rmaCollectionRma.getCoduser();
                rmaCollectionRma.setCoduser(usuario);
                rmaCollectionRma = em.merge(rmaCollectionRma);
                if (oldCoduserOfRmaCollectionRma != null) {
                    oldCoduserOfRmaCollectionRma.getRmaCollection().remove(rmaCollectionRma);
                    oldCoduserOfRmaCollectionRma = em.merge(oldCoduserOfRmaCollectionRma);
                }
            }
            for (Etiquetaendereco etiquetaenderecoCollectionEtiquetaendereco : usuario.getEtiquetaenderecoCollection()) {
                Usuario oldCoduserOfEtiquetaenderecoCollectionEtiquetaendereco = etiquetaenderecoCollectionEtiquetaendereco.getCoduser();
                etiquetaenderecoCollectionEtiquetaendereco.setCoduser(usuario);
                etiquetaenderecoCollectionEtiquetaendereco = em.merge(etiquetaenderecoCollectionEtiquetaendereco);
                if (oldCoduserOfEtiquetaenderecoCollectionEtiquetaendereco != null) {
                    oldCoduserOfEtiquetaenderecoCollectionEtiquetaendereco.getEtiquetaenderecoCollection().remove(etiquetaenderecoCollectionEtiquetaendereco);
                    oldCoduserOfEtiquetaenderecoCollectionEtiquetaendereco = em.merge(oldCoduserOfEtiquetaenderecoCollectionEtiquetaendereco);
                }
            }
            for (Usuariopreco usuarioprecoCollectionUsuariopreco : usuario.getUsuarioprecoCollection()) {
                Usuario oldCoduserOfUsuarioprecoCollectionUsuariopreco = usuarioprecoCollectionUsuariopreco.getCoduser();
                usuarioprecoCollectionUsuariopreco.setCoduser(usuario);
                usuarioprecoCollectionUsuariopreco = em.merge(usuarioprecoCollectionUsuariopreco);
                if (oldCoduserOfUsuarioprecoCollectionUsuariopreco != null) {
                    oldCoduserOfUsuarioprecoCollectionUsuariopreco.getUsuarioprecoCollection().remove(usuarioprecoCollectionUsuariopreco);
                    oldCoduserOfUsuarioprecoCollectionUsuariopreco = em.merge(oldCoduserOfUsuarioprecoCollectionUsuariopreco);
                }
            }
            for (Pedido pedidoCollectionPedido : usuario.getPedidoCollection()) {
                Usuario oldCoduserOfPedidoCollectionPedido = pedidoCollectionPedido.getCoduser();
                pedidoCollectionPedido.setCoduser(usuario);
                pedidoCollectionPedido = em.merge(pedidoCollectionPedido);
                if (oldCoduserOfPedidoCollectionPedido != null) {
                    oldCoduserOfPedidoCollectionPedido.getPedidoCollection().remove(pedidoCollectionPedido);
                    oldCoduserOfPedidoCollectionPedido = em.merge(oldCoduserOfPedidoCollectionPedido);
                }
            }
            for (Movendaproddevolucaocompra movendaproddevolucaocompraCollectionMovendaproddevolucaocompra : usuario.getMovendaproddevolucaocompraCollection()) {
                Usuario oldCoduserOfMovendaproddevolucaocompraCollectionMovendaproddevolucaocompra = movendaproddevolucaocompraCollectionMovendaproddevolucaocompra.getCoduser();
                movendaproddevolucaocompraCollectionMovendaproddevolucaocompra.setCoduser(usuario);
                movendaproddevolucaocompraCollectionMovendaproddevolucaocompra = em.merge(movendaproddevolucaocompraCollectionMovendaproddevolucaocompra);
                if (oldCoduserOfMovendaproddevolucaocompraCollectionMovendaproddevolucaocompra != null) {
                    oldCoduserOfMovendaproddevolucaocompraCollectionMovendaproddevolucaocompra.getMovendaproddevolucaocompraCollection().remove(movendaproddevolucaocompraCollectionMovendaproddevolucaocompra);
                    oldCoduserOfMovendaproddevolucaocompraCollectionMovendaproddevolucaocompra = em.merge(oldCoduserOfMovendaproddevolucaocompraCollectionMovendaproddevolucaocompra);
                }
            }
            for (Cliente clienteCollectionCliente : usuario.getClienteCollection()) {
                Usuario oldCoduserOfClienteCollectionCliente = clienteCollectionCliente.getCoduser();
                clienteCollectionCliente.setCoduser(usuario);
                clienteCollectionCliente = em.merge(clienteCollectionCliente);
                if (oldCoduserOfClienteCollectionCliente != null) {
                    oldCoduserOfClienteCollectionCliente.getClienteCollection().remove(clienteCollectionCliente);
                    oldCoduserOfClienteCollectionCliente = em.merge(oldCoduserOfClienteCollectionCliente);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsuario(usuario.getCoduser()) != null) {
                throw new PreexistingEntityException("Usuario " + usuario + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Usuario usuario) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Usuario persistentUsuario = em.find(Usuario.class, usuario.getCoduser());
            Empresa codempresaOld = persistentUsuario.getCodempresa();
            Empresa codempresaNew = usuario.getCodempresa();
            Funcionario codfuncionarioOld = persistentUsuario.getCodfuncionario();
            Funcionario codfuncionarioNew = usuario.getCodfuncionario();
            Situacaoadministrativa codsituacaoadministrativaOld = persistentUsuario.getCodsituacaoadministrativa();
            Situacaoadministrativa codsituacaoadministrativaNew = usuario.getCodsituacaoadministrativa();
            Vendedor codvendedOld = persistentUsuario.getCodvended();
            Vendedor codvendedNew = usuario.getCodvended();
            Collection<Producaohistorico> producaohistoricoCollectionOld = persistentUsuario.getProducaohistoricoCollection();
            Collection<Producaohistorico> producaohistoricoCollectionNew = usuario.getProducaohistoricoCollection();
            Collection<Documento> documentoCollectionOld = persistentUsuario.getDocumentoCollection();
            Collection<Documento> documentoCollectionNew = usuario.getDocumentoCollection();
            Collection<Rma> rmaCollectionOld = persistentUsuario.getRmaCollection();
            Collection<Rma> rmaCollectionNew = usuario.getRmaCollection();
            Collection<Etiquetaendereco> etiquetaenderecoCollectionOld = persistentUsuario.getEtiquetaenderecoCollection();
            Collection<Etiquetaendereco> etiquetaenderecoCollectionNew = usuario.getEtiquetaenderecoCollection();
            Collection<Usuariopreco> usuarioprecoCollectionOld = persistentUsuario.getUsuarioprecoCollection();
            Collection<Usuariopreco> usuarioprecoCollectionNew = usuario.getUsuarioprecoCollection();
            Collection<Pedido> pedidoCollectionOld = persistentUsuario.getPedidoCollection();
            Collection<Pedido> pedidoCollectionNew = usuario.getPedidoCollection();
            Collection<Movendaproddevolucaocompra> movendaproddevolucaocompraCollectionOld = persistentUsuario.getMovendaproddevolucaocompraCollection();
            Collection<Movendaproddevolucaocompra> movendaproddevolucaocompraCollectionNew = usuario.getMovendaproddevolucaocompraCollection();
            Collection<Cliente> clienteCollectionOld = persistentUsuario.getClienteCollection();
            Collection<Cliente> clienteCollectionNew = usuario.getClienteCollection();
            List<String> illegalOrphanMessages = null;
            for (Producaohistorico producaohistoricoCollectionOldProducaohistorico : producaohistoricoCollectionOld) {
                if (!producaohistoricoCollectionNew.contains(producaohistoricoCollectionOldProducaohistorico)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Producaohistorico " + producaohistoricoCollectionOldProducaohistorico + " since its coduser field is not nullable.");
                }
            }
            for (Etiquetaendereco etiquetaenderecoCollectionOldEtiquetaendereco : etiquetaenderecoCollectionOld) {
                if (!etiquetaenderecoCollectionNew.contains(etiquetaenderecoCollectionOldEtiquetaendereco)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Etiquetaendereco " + etiquetaenderecoCollectionOldEtiquetaendereco + " since its coduser field is not nullable.");
                }
            }
            for (Usuariopreco usuarioprecoCollectionOldUsuariopreco : usuarioprecoCollectionOld) {
                if (!usuarioprecoCollectionNew.contains(usuarioprecoCollectionOldUsuariopreco)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Usuariopreco " + usuarioprecoCollectionOldUsuariopreco + " since its coduser field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                usuario.setCodempresa(codempresaNew);
            }
            if (codfuncionarioNew != null) {
                codfuncionarioNew = em.getReference(codfuncionarioNew.getClass(), codfuncionarioNew.getCodfuncionario());
                usuario.setCodfuncionario(codfuncionarioNew);
            }
            if (codsituacaoadministrativaNew != null) {
                codsituacaoadministrativaNew = em.getReference(codsituacaoadministrativaNew.getClass(), codsituacaoadministrativaNew.getCodsituacaoadministrativa());
                usuario.setCodsituacaoadministrativa(codsituacaoadministrativaNew);
            }
            if (codvendedNew != null) {
                codvendedNew = em.getReference(codvendedNew.getClass(), codvendedNew.getCodvended());
                usuario.setCodvended(codvendedNew);
            }
            Collection<Producaohistorico> attachedProducaohistoricoCollectionNew = new ArrayList<Producaohistorico>();
            for (Producaohistorico producaohistoricoCollectionNewProducaohistoricoToAttach : producaohistoricoCollectionNew) {
                producaohistoricoCollectionNewProducaohistoricoToAttach = em.getReference(producaohistoricoCollectionNewProducaohistoricoToAttach.getClass(), producaohistoricoCollectionNewProducaohistoricoToAttach.getCodproducaohistorico());
                attachedProducaohistoricoCollectionNew.add(producaohistoricoCollectionNewProducaohistoricoToAttach);
            }
            producaohistoricoCollectionNew = attachedProducaohistoricoCollectionNew;
            usuario.setProducaohistoricoCollection(producaohistoricoCollectionNew);
            Collection<Documento> attachedDocumentoCollectionNew = new ArrayList<Documento>();
            for (Documento documentoCollectionNewDocumentoToAttach : documentoCollectionNew) {
                documentoCollectionNewDocumentoToAttach = em.getReference(documentoCollectionNewDocumentoToAttach.getClass(), documentoCollectionNewDocumentoToAttach.getCoddocumento());
                attachedDocumentoCollectionNew.add(documentoCollectionNewDocumentoToAttach);
            }
            documentoCollectionNew = attachedDocumentoCollectionNew;
            usuario.setDocumentoCollection(documentoCollectionNew);
            Collection<Rma> attachedRmaCollectionNew = new ArrayList<Rma>();
            for (Rma rmaCollectionNewRmaToAttach : rmaCollectionNew) {
                rmaCollectionNewRmaToAttach = em.getReference(rmaCollectionNewRmaToAttach.getClass(), rmaCollectionNewRmaToAttach.getCodrma());
                attachedRmaCollectionNew.add(rmaCollectionNewRmaToAttach);
            }
            rmaCollectionNew = attachedRmaCollectionNew;
            usuario.setRmaCollection(rmaCollectionNew);
            Collection<Etiquetaendereco> attachedEtiquetaenderecoCollectionNew = new ArrayList<Etiquetaendereco>();
            for (Etiquetaendereco etiquetaenderecoCollectionNewEtiquetaenderecoToAttach : etiquetaenderecoCollectionNew) {
                etiquetaenderecoCollectionNewEtiquetaenderecoToAttach = em.getReference(etiquetaenderecoCollectionNewEtiquetaenderecoToAttach.getClass(), etiquetaenderecoCollectionNewEtiquetaenderecoToAttach.getCodetiquetaendereco());
                attachedEtiquetaenderecoCollectionNew.add(etiquetaenderecoCollectionNewEtiquetaenderecoToAttach);
            }
            etiquetaenderecoCollectionNew = attachedEtiquetaenderecoCollectionNew;
            usuario.setEtiquetaenderecoCollection(etiquetaenderecoCollectionNew);
            Collection<Usuariopreco> attachedUsuarioprecoCollectionNew = new ArrayList<Usuariopreco>();
            for (Usuariopreco usuarioprecoCollectionNewUsuarioprecoToAttach : usuarioprecoCollectionNew) {
                usuarioprecoCollectionNewUsuarioprecoToAttach = em.getReference(usuarioprecoCollectionNewUsuarioprecoToAttach.getClass(), usuarioprecoCollectionNewUsuarioprecoToAttach.getCodusuariopreco());
                attachedUsuarioprecoCollectionNew.add(usuarioprecoCollectionNewUsuarioprecoToAttach);
            }
            usuarioprecoCollectionNew = attachedUsuarioprecoCollectionNew;
            usuario.setUsuarioprecoCollection(usuarioprecoCollectionNew);
            Collection<Pedido> attachedPedidoCollectionNew = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionNewPedidoToAttach : pedidoCollectionNew) {
                pedidoCollectionNewPedidoToAttach = em.getReference(pedidoCollectionNewPedidoToAttach.getClass(), pedidoCollectionNewPedidoToAttach.getCodped());
                attachedPedidoCollectionNew.add(pedidoCollectionNewPedidoToAttach);
            }
            pedidoCollectionNew = attachedPedidoCollectionNew;
            usuario.setPedidoCollection(pedidoCollectionNew);
            Collection<Movendaproddevolucaocompra> attachedMovendaproddevolucaocompraCollectionNew = new ArrayList<Movendaproddevolucaocompra>();
            for (Movendaproddevolucaocompra movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompraToAttach : movendaproddevolucaocompraCollectionNew) {
                movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompraToAttach = em.getReference(movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompraToAttach.getClass(), movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompraToAttach.getCodmovendaproddevolucaocompra());
                attachedMovendaproddevolucaocompraCollectionNew.add(movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompraToAttach);
            }
            movendaproddevolucaocompraCollectionNew = attachedMovendaproddevolucaocompraCollectionNew;
            usuario.setMovendaproddevolucaocompraCollection(movendaproddevolucaocompraCollectionNew);
            Collection<Cliente> attachedClienteCollectionNew = new ArrayList<Cliente>();
            for (Cliente clienteCollectionNewClienteToAttach : clienteCollectionNew) {
                clienteCollectionNewClienteToAttach = em.getReference(clienteCollectionNewClienteToAttach.getClass(), clienteCollectionNewClienteToAttach.getCodcli());
                attachedClienteCollectionNew.add(clienteCollectionNewClienteToAttach);
            }
            clienteCollectionNew = attachedClienteCollectionNew;
            usuario.setClienteCollection(clienteCollectionNew);
            usuario = em.merge(usuario);
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getUsuarioCollection().remove(usuario);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getUsuarioCollection().add(usuario);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codfuncionarioOld != null && !codfuncionarioOld.equals(codfuncionarioNew)) {
                codfuncionarioOld.getUsuarioCollection().remove(usuario);
                codfuncionarioOld = em.merge(codfuncionarioOld);
            }
            if (codfuncionarioNew != null && !codfuncionarioNew.equals(codfuncionarioOld)) {
                codfuncionarioNew.getUsuarioCollection().add(usuario);
                codfuncionarioNew = em.merge(codfuncionarioNew);
            }
            if (codsituacaoadministrativaOld != null && !codsituacaoadministrativaOld.equals(codsituacaoadministrativaNew)) {
                codsituacaoadministrativaOld.getUsuarioCollection().remove(usuario);
                codsituacaoadministrativaOld = em.merge(codsituacaoadministrativaOld);
            }
            if (codsituacaoadministrativaNew != null && !codsituacaoadministrativaNew.equals(codsituacaoadministrativaOld)) {
                codsituacaoadministrativaNew.getUsuarioCollection().add(usuario);
                codsituacaoadministrativaNew = em.merge(codsituacaoadministrativaNew);
            }
            if (codvendedOld != null && !codvendedOld.equals(codvendedNew)) {
                codvendedOld.getUsuarioCollection().remove(usuario);
                codvendedOld = em.merge(codvendedOld);
            }
            if (codvendedNew != null && !codvendedNew.equals(codvendedOld)) {
                codvendedNew.getUsuarioCollection().add(usuario);
                codvendedNew = em.merge(codvendedNew);
            }
            for (Producaohistorico producaohistoricoCollectionNewProducaohistorico : producaohistoricoCollectionNew) {
                if (!producaohistoricoCollectionOld.contains(producaohistoricoCollectionNewProducaohistorico)) {
                    Usuario oldCoduserOfProducaohistoricoCollectionNewProducaohistorico = producaohistoricoCollectionNewProducaohistorico.getCoduser();
                    producaohistoricoCollectionNewProducaohistorico.setCoduser(usuario);
                    producaohistoricoCollectionNewProducaohistorico = em.merge(producaohistoricoCollectionNewProducaohistorico);
                    if (oldCoduserOfProducaohistoricoCollectionNewProducaohistorico != null && !oldCoduserOfProducaohistoricoCollectionNewProducaohistorico.equals(usuario)) {
                        oldCoduserOfProducaohistoricoCollectionNewProducaohistorico.getProducaohistoricoCollection().remove(producaohistoricoCollectionNewProducaohistorico);
                        oldCoduserOfProducaohistoricoCollectionNewProducaohistorico = em.merge(oldCoduserOfProducaohistoricoCollectionNewProducaohistorico);
                    }
                }
            }
            for (Documento documentoCollectionOldDocumento : documentoCollectionOld) {
                if (!documentoCollectionNew.contains(documentoCollectionOldDocumento)) {
                    documentoCollectionOldDocumento.setCoduser(null);
                    documentoCollectionOldDocumento = em.merge(documentoCollectionOldDocumento);
                }
            }
            for (Documento documentoCollectionNewDocumento : documentoCollectionNew) {
                if (!documentoCollectionOld.contains(documentoCollectionNewDocumento)) {
                    Usuario oldCoduserOfDocumentoCollectionNewDocumento = documentoCollectionNewDocumento.getCoduser();
                    documentoCollectionNewDocumento.setCoduser(usuario);
                    documentoCollectionNewDocumento = em.merge(documentoCollectionNewDocumento);
                    if (oldCoduserOfDocumentoCollectionNewDocumento != null && !oldCoduserOfDocumentoCollectionNewDocumento.equals(usuario)) {
                        oldCoduserOfDocumentoCollectionNewDocumento.getDocumentoCollection().remove(documentoCollectionNewDocumento);
                        oldCoduserOfDocumentoCollectionNewDocumento = em.merge(oldCoduserOfDocumentoCollectionNewDocumento);
                    }
                }
            }
            for (Rma rmaCollectionOldRma : rmaCollectionOld) {
                if (!rmaCollectionNew.contains(rmaCollectionOldRma)) {
                    rmaCollectionOldRma.setCoduser(null);
                    rmaCollectionOldRma = em.merge(rmaCollectionOldRma);
                }
            }
            for (Rma rmaCollectionNewRma : rmaCollectionNew) {
                if (!rmaCollectionOld.contains(rmaCollectionNewRma)) {
                    Usuario oldCoduserOfRmaCollectionNewRma = rmaCollectionNewRma.getCoduser();
                    rmaCollectionNewRma.setCoduser(usuario);
                    rmaCollectionNewRma = em.merge(rmaCollectionNewRma);
                    if (oldCoduserOfRmaCollectionNewRma != null && !oldCoduserOfRmaCollectionNewRma.equals(usuario)) {
                        oldCoduserOfRmaCollectionNewRma.getRmaCollection().remove(rmaCollectionNewRma);
                        oldCoduserOfRmaCollectionNewRma = em.merge(oldCoduserOfRmaCollectionNewRma);
                    }
                }
            }
            for (Etiquetaendereco etiquetaenderecoCollectionNewEtiquetaendereco : etiquetaenderecoCollectionNew) {
                if (!etiquetaenderecoCollectionOld.contains(etiquetaenderecoCollectionNewEtiquetaendereco)) {
                    Usuario oldCoduserOfEtiquetaenderecoCollectionNewEtiquetaendereco = etiquetaenderecoCollectionNewEtiquetaendereco.getCoduser();
                    etiquetaenderecoCollectionNewEtiquetaendereco.setCoduser(usuario);
                    etiquetaenderecoCollectionNewEtiquetaendereco = em.merge(etiquetaenderecoCollectionNewEtiquetaendereco);
                    if (oldCoduserOfEtiquetaenderecoCollectionNewEtiquetaendereco != null && !oldCoduserOfEtiquetaenderecoCollectionNewEtiquetaendereco.equals(usuario)) {
                        oldCoduserOfEtiquetaenderecoCollectionNewEtiquetaendereco.getEtiquetaenderecoCollection().remove(etiquetaenderecoCollectionNewEtiquetaendereco);
                        oldCoduserOfEtiquetaenderecoCollectionNewEtiquetaendereco = em.merge(oldCoduserOfEtiquetaenderecoCollectionNewEtiquetaendereco);
                    }
                }
            }
            for (Usuariopreco usuarioprecoCollectionNewUsuariopreco : usuarioprecoCollectionNew) {
                if (!usuarioprecoCollectionOld.contains(usuarioprecoCollectionNewUsuariopreco)) {
                    Usuario oldCoduserOfUsuarioprecoCollectionNewUsuariopreco = usuarioprecoCollectionNewUsuariopreco.getCoduser();
                    usuarioprecoCollectionNewUsuariopreco.setCoduser(usuario);
                    usuarioprecoCollectionNewUsuariopreco = em.merge(usuarioprecoCollectionNewUsuariopreco);
                    if (oldCoduserOfUsuarioprecoCollectionNewUsuariopreco != null && !oldCoduserOfUsuarioprecoCollectionNewUsuariopreco.equals(usuario)) {
                        oldCoduserOfUsuarioprecoCollectionNewUsuariopreco.getUsuarioprecoCollection().remove(usuarioprecoCollectionNewUsuariopreco);
                        oldCoduserOfUsuarioprecoCollectionNewUsuariopreco = em.merge(oldCoduserOfUsuarioprecoCollectionNewUsuariopreco);
                    }
                }
            }
            for (Pedido pedidoCollectionOldPedido : pedidoCollectionOld) {
                if (!pedidoCollectionNew.contains(pedidoCollectionOldPedido)) {
                    pedidoCollectionOldPedido.setCoduser(null);
                    pedidoCollectionOldPedido = em.merge(pedidoCollectionOldPedido);
                }
            }
            for (Pedido pedidoCollectionNewPedido : pedidoCollectionNew) {
                if (!pedidoCollectionOld.contains(pedidoCollectionNewPedido)) {
                    Usuario oldCoduserOfPedidoCollectionNewPedido = pedidoCollectionNewPedido.getCoduser();
                    pedidoCollectionNewPedido.setCoduser(usuario);
                    pedidoCollectionNewPedido = em.merge(pedidoCollectionNewPedido);
                    if (oldCoduserOfPedidoCollectionNewPedido != null && !oldCoduserOfPedidoCollectionNewPedido.equals(usuario)) {
                        oldCoduserOfPedidoCollectionNewPedido.getPedidoCollection().remove(pedidoCollectionNewPedido);
                        oldCoduserOfPedidoCollectionNewPedido = em.merge(oldCoduserOfPedidoCollectionNewPedido);
                    }
                }
            }
            for (Movendaproddevolucaocompra movendaproddevolucaocompraCollectionOldMovendaproddevolucaocompra : movendaproddevolucaocompraCollectionOld) {
                if (!movendaproddevolucaocompraCollectionNew.contains(movendaproddevolucaocompraCollectionOldMovendaproddevolucaocompra)) {
                    movendaproddevolucaocompraCollectionOldMovendaproddevolucaocompra.setCoduser(null);
                    movendaproddevolucaocompraCollectionOldMovendaproddevolucaocompra = em.merge(movendaproddevolucaocompraCollectionOldMovendaproddevolucaocompra);
                }
            }
            for (Movendaproddevolucaocompra movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra : movendaproddevolucaocompraCollectionNew) {
                if (!movendaproddevolucaocompraCollectionOld.contains(movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra)) {
                    Usuario oldCoduserOfMovendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra = movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra.getCoduser();
                    movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra.setCoduser(usuario);
                    movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra = em.merge(movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra);
                    if (oldCoduserOfMovendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra != null && !oldCoduserOfMovendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra.equals(usuario)) {
                        oldCoduserOfMovendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra.getMovendaproddevolucaocompraCollection().remove(movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra);
                        oldCoduserOfMovendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra = em.merge(oldCoduserOfMovendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra);
                    }
                }
            }
            for (Cliente clienteCollectionOldCliente : clienteCollectionOld) {
                if (!clienteCollectionNew.contains(clienteCollectionOldCliente)) {
                    clienteCollectionOldCliente.setCoduser(null);
                    clienteCollectionOldCliente = em.merge(clienteCollectionOldCliente);
                }
            }
            for (Cliente clienteCollectionNewCliente : clienteCollectionNew) {
                if (!clienteCollectionOld.contains(clienteCollectionNewCliente)) {
                    Usuario oldCoduserOfClienteCollectionNewCliente = clienteCollectionNewCliente.getCoduser();
                    clienteCollectionNewCliente.setCoduser(usuario);
                    clienteCollectionNewCliente = em.merge(clienteCollectionNewCliente);
                    if (oldCoduserOfClienteCollectionNewCliente != null && !oldCoduserOfClienteCollectionNewCliente.equals(usuario)) {
                        oldCoduserOfClienteCollectionNewCliente.getClienteCollection().remove(clienteCollectionNewCliente);
                        oldCoduserOfClienteCollectionNewCliente = em.merge(oldCoduserOfClienteCollectionNewCliente);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = usuario.getCoduser();
                if (findUsuario(id) == null) {
                    throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.");
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
            Usuario usuario;
            try {
                usuario = em.getReference(Usuario.class, id);
                usuario.getCoduser();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuario with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Producaohistorico> producaohistoricoCollectionOrphanCheck = usuario.getProducaohistoricoCollection();
            for (Producaohistorico producaohistoricoCollectionOrphanCheckProducaohistorico : producaohistoricoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Producaohistorico " + producaohistoricoCollectionOrphanCheckProducaohistorico + " in its producaohistoricoCollection field has a non-nullable coduser field.");
            }
            Collection<Etiquetaendereco> etiquetaenderecoCollectionOrphanCheck = usuario.getEtiquetaenderecoCollection();
            for (Etiquetaendereco etiquetaenderecoCollectionOrphanCheckEtiquetaendereco : etiquetaenderecoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Etiquetaendereco " + etiquetaenderecoCollectionOrphanCheckEtiquetaendereco + " in its etiquetaenderecoCollection field has a non-nullable coduser field.");
            }
            Collection<Usuariopreco> usuarioprecoCollectionOrphanCheck = usuario.getUsuarioprecoCollection();
            for (Usuariopreco usuarioprecoCollectionOrphanCheckUsuariopreco : usuarioprecoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Usuario (" + usuario + ") cannot be destroyed since the Usuariopreco " + usuarioprecoCollectionOrphanCheckUsuariopreco + " in its usuarioprecoCollection field has a non-nullable coduser field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Empresa codempresa = usuario.getCodempresa();
            if (codempresa != null) {
                codempresa.getUsuarioCollection().remove(usuario);
                codempresa = em.merge(codempresa);
            }
            Funcionario codfuncionario = usuario.getCodfuncionario();
            if (codfuncionario != null) {
                codfuncionario.getUsuarioCollection().remove(usuario);
                codfuncionario = em.merge(codfuncionario);
            }
            Situacaoadministrativa codsituacaoadministrativa = usuario.getCodsituacaoadministrativa();
            if (codsituacaoadministrativa != null) {
                codsituacaoadministrativa.getUsuarioCollection().remove(usuario);
                codsituacaoadministrativa = em.merge(codsituacaoadministrativa);
            }
            Vendedor codvended = usuario.getCodvended();
            if (codvended != null) {
                codvended.getUsuarioCollection().remove(usuario);
                codvended = em.merge(codvended);
            }
            Collection<Documento> documentoCollection = usuario.getDocumentoCollection();
            for (Documento documentoCollectionDocumento : documentoCollection) {
                documentoCollectionDocumento.setCoduser(null);
                documentoCollectionDocumento = em.merge(documentoCollectionDocumento);
            }
            Collection<Rma> rmaCollection = usuario.getRmaCollection();
            for (Rma rmaCollectionRma : rmaCollection) {
                rmaCollectionRma.setCoduser(null);
                rmaCollectionRma = em.merge(rmaCollectionRma);
            }
            Collection<Pedido> pedidoCollection = usuario.getPedidoCollection();
            for (Pedido pedidoCollectionPedido : pedidoCollection) {
                pedidoCollectionPedido.setCoduser(null);
                pedidoCollectionPedido = em.merge(pedidoCollectionPedido);
            }
            Collection<Movendaproddevolucaocompra> movendaproddevolucaocompraCollection = usuario.getMovendaproddevolucaocompraCollection();
            for (Movendaproddevolucaocompra movendaproddevolucaocompraCollectionMovendaproddevolucaocompra : movendaproddevolucaocompraCollection) {
                movendaproddevolucaocompraCollectionMovendaproddevolucaocompra.setCoduser(null);
                movendaproddevolucaocompraCollectionMovendaproddevolucaocompra = em.merge(movendaproddevolucaocompraCollectionMovendaproddevolucaocompra);
            }
            Collection<Cliente> clienteCollection = usuario.getClienteCollection();
            for (Cliente clienteCollectionCliente : clienteCollection) {
                clienteCollectionCliente.setCoduser(null);
                clienteCollectionCliente = em.merge(clienteCollectionCliente);
            }
            em.remove(usuario);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Usuario> findUsuarioEntities() {
        return findUsuarioEntities(true, -1, -1);
    }

    public List<Usuario> findUsuarioEntities(int maxResults, int firstResult) {
        return findUsuarioEntities(false, maxResults, firstResult);
    }

    private List<Usuario> findUsuarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Usuario.class));
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

    public Usuario findUsuario(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Usuario.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Usuario> rt = cq.from(Usuario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
import entidade.cplus.Moventrada;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Moventradaprod;
import entidade.cplus.Ordemproducao;
import entidade.cplus.Documento;
import entidade.cplus.Produtoestoque;
import entidade.cplus.Acerto;
import entidade.cplus.Orcamento;
import entidade.cplus.Movenda;
import entidade.cplus.Pedido;
import entidade.cplus.Orcamentoprod;
import entidade.cplus.AcertoProdlote;
import entidade.cplus.AcertoProdfci;
import entidade.cplus.Setorestoque;
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
public class SetorestoqueJpaController implements Serializable {

    public SetorestoqueJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Setorestoque setorestoque) throws PreexistingEntityException, Exception {
        if (setorestoque.getMoventradaCollection() == null) {
            setorestoque.setMoventradaCollection(new ArrayList<Moventrada>());
        }
        if (setorestoque.getMoventradaprodCollection() == null) {
            setorestoque.setMoventradaprodCollection(new ArrayList<Moventradaprod>());
        }
        if (setorestoque.getOrdemproducaoCollection() == null) {
            setorestoque.setOrdemproducaoCollection(new ArrayList<Ordemproducao>());
        }
        if (setorestoque.getDocumentoCollection() == null) {
            setorestoque.setDocumentoCollection(new ArrayList<Documento>());
        }
        if (setorestoque.getProdutoestoqueCollection() == null) {
            setorestoque.setProdutoestoqueCollection(new ArrayList<Produtoestoque>());
        }
        if (setorestoque.getAcertoCollection() == null) {
            setorestoque.setAcertoCollection(new ArrayList<Acerto>());
        }
        if (setorestoque.getOrcamentoCollection() == null) {
            setorestoque.setOrcamentoCollection(new ArrayList<Orcamento>());
        }
        if (setorestoque.getMovendaCollection() == null) {
            setorestoque.setMovendaCollection(new ArrayList<Movenda>());
        }
        if (setorestoque.getPedidoCollection() == null) {
            setorestoque.setPedidoCollection(new ArrayList<Pedido>());
        }
        if (setorestoque.getOrcamentoprodCollection() == null) {
            setorestoque.setOrcamentoprodCollection(new ArrayList<Orcamentoprod>());
        }
        if (setorestoque.getAcertoProdloteCollection() == null) {
            setorestoque.setAcertoProdloteCollection(new ArrayList<AcertoProdlote>());
        }
        if (setorestoque.getAcertoProdfciCollection() == null) {
            setorestoque.setAcertoProdfciCollection(new ArrayList<AcertoProdfci>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Moventrada> attachedMoventradaCollection = new ArrayList<Moventrada>();
            for (Moventrada moventradaCollectionMoventradaToAttach : setorestoque.getMoventradaCollection()) {
                moventradaCollectionMoventradaToAttach = em.getReference(moventradaCollectionMoventradaToAttach.getClass(), moventradaCollectionMoventradaToAttach.getCodmoventr());
                attachedMoventradaCollection.add(moventradaCollectionMoventradaToAttach);
            }
            setorestoque.setMoventradaCollection(attachedMoventradaCollection);
            Collection<Moventradaprod> attachedMoventradaprodCollection = new ArrayList<Moventradaprod>();
            for (Moventradaprod moventradaprodCollectionMoventradaprodToAttach : setorestoque.getMoventradaprodCollection()) {
                moventradaprodCollectionMoventradaprodToAttach = em.getReference(moventradaprodCollectionMoventradaprodToAttach.getClass(), moventradaprodCollectionMoventradaprodToAttach.getCodmoveprod());
                attachedMoventradaprodCollection.add(moventradaprodCollectionMoventradaprodToAttach);
            }
            setorestoque.setMoventradaprodCollection(attachedMoventradaprodCollection);
            Collection<Ordemproducao> attachedOrdemproducaoCollection = new ArrayList<Ordemproducao>();
            for (Ordemproducao ordemproducaoCollectionOrdemproducaoToAttach : setorestoque.getOrdemproducaoCollection()) {
                ordemproducaoCollectionOrdemproducaoToAttach = em.getReference(ordemproducaoCollectionOrdemproducaoToAttach.getClass(), ordemproducaoCollectionOrdemproducaoToAttach.getCodordemproducao());
                attachedOrdemproducaoCollection.add(ordemproducaoCollectionOrdemproducaoToAttach);
            }
            setorestoque.setOrdemproducaoCollection(attachedOrdemproducaoCollection);
            Collection<Documento> attachedDocumentoCollection = new ArrayList<Documento>();
            for (Documento documentoCollectionDocumentoToAttach : setorestoque.getDocumentoCollection()) {
                documentoCollectionDocumentoToAttach = em.getReference(documentoCollectionDocumentoToAttach.getClass(), documentoCollectionDocumentoToAttach.getCoddocumento());
                attachedDocumentoCollection.add(documentoCollectionDocumentoToAttach);
            }
            setorestoque.setDocumentoCollection(attachedDocumentoCollection);
            Collection<Produtoestoque> attachedProdutoestoqueCollection = new ArrayList<Produtoestoque>();
            for (Produtoestoque produtoestoqueCollectionProdutoestoqueToAttach : setorestoque.getProdutoestoqueCollection()) {
                produtoestoqueCollectionProdutoestoqueToAttach = em.getReference(produtoestoqueCollectionProdutoestoqueToAttach.getClass(), produtoestoqueCollectionProdutoestoqueToAttach.getProdutoestoquePK());
                attachedProdutoestoqueCollection.add(produtoestoqueCollectionProdutoestoqueToAttach);
            }
            setorestoque.setProdutoestoqueCollection(attachedProdutoestoqueCollection);
            Collection<Acerto> attachedAcertoCollection = new ArrayList<Acerto>();
            for (Acerto acertoCollectionAcertoToAttach : setorestoque.getAcertoCollection()) {
                acertoCollectionAcertoToAttach = em.getReference(acertoCollectionAcertoToAttach.getClass(), acertoCollectionAcertoToAttach.getCodacerto());
                attachedAcertoCollection.add(acertoCollectionAcertoToAttach);
            }
            setorestoque.setAcertoCollection(attachedAcertoCollection);
            Collection<Orcamento> attachedOrcamentoCollection = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollectionOrcamentoToAttach : setorestoque.getOrcamentoCollection()) {
                orcamentoCollectionOrcamentoToAttach = em.getReference(orcamentoCollectionOrcamentoToAttach.getClass(), orcamentoCollectionOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollection.add(orcamentoCollectionOrcamentoToAttach);
            }
            setorestoque.setOrcamentoCollection(attachedOrcamentoCollection);
            Collection<Movenda> attachedMovendaCollection = new ArrayList<Movenda>();
            for (Movenda movendaCollectionMovendaToAttach : setorestoque.getMovendaCollection()) {
                movendaCollectionMovendaToAttach = em.getReference(movendaCollectionMovendaToAttach.getClass(), movendaCollectionMovendaToAttach.getCodmovenda());
                attachedMovendaCollection.add(movendaCollectionMovendaToAttach);
            }
            setorestoque.setMovendaCollection(attachedMovendaCollection);
            Collection<Pedido> attachedPedidoCollection = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionPedidoToAttach : setorestoque.getPedidoCollection()) {
                pedidoCollectionPedidoToAttach = em.getReference(pedidoCollectionPedidoToAttach.getClass(), pedidoCollectionPedidoToAttach.getCodped());
                attachedPedidoCollection.add(pedidoCollectionPedidoToAttach);
            }
            setorestoque.setPedidoCollection(attachedPedidoCollection);
            Collection<Orcamentoprod> attachedOrcamentoprodCollection = new ArrayList<Orcamentoprod>();
            for (Orcamentoprod orcamentoprodCollectionOrcamentoprodToAttach : setorestoque.getOrcamentoprodCollection()) {
                orcamentoprodCollectionOrcamentoprodToAttach = em.getReference(orcamentoprodCollectionOrcamentoprodToAttach.getClass(), orcamentoprodCollectionOrcamentoprodToAttach.getCodorcprod());
                attachedOrcamentoprodCollection.add(orcamentoprodCollectionOrcamentoprodToAttach);
            }
            setorestoque.setOrcamentoprodCollection(attachedOrcamentoprodCollection);
            Collection<AcertoProdlote> attachedAcertoProdloteCollection = new ArrayList<AcertoProdlote>();
            for (AcertoProdlote acertoProdloteCollectionAcertoProdloteToAttach : setorestoque.getAcertoProdloteCollection()) {
                acertoProdloteCollectionAcertoProdloteToAttach = em.getReference(acertoProdloteCollectionAcertoProdloteToAttach.getClass(), acertoProdloteCollectionAcertoProdloteToAttach.getCodacertoProdlote());
                attachedAcertoProdloteCollection.add(acertoProdloteCollectionAcertoProdloteToAttach);
            }
            setorestoque.setAcertoProdloteCollection(attachedAcertoProdloteCollection);
            Collection<AcertoProdfci> attachedAcertoProdfciCollection = new ArrayList<AcertoProdfci>();
            for (AcertoProdfci acertoProdfciCollectionAcertoProdfciToAttach : setorestoque.getAcertoProdfciCollection()) {
                acertoProdfciCollectionAcertoProdfciToAttach = em.getReference(acertoProdfciCollectionAcertoProdfciToAttach.getClass(), acertoProdfciCollectionAcertoProdfciToAttach.getCodacertoProdfci());
                attachedAcertoProdfciCollection.add(acertoProdfciCollectionAcertoProdfciToAttach);
            }
            setorestoque.setAcertoProdfciCollection(attachedAcertoProdfciCollection);
            em.persist(setorestoque);
            for (Moventrada moventradaCollectionMoventrada : setorestoque.getMoventradaCollection()) {
                Setorestoque oldCodsetorestoqueOfMoventradaCollectionMoventrada = moventradaCollectionMoventrada.getCodsetorestoque();
                moventradaCollectionMoventrada.setCodsetorestoque(setorestoque);
                moventradaCollectionMoventrada = em.merge(moventradaCollectionMoventrada);
                if (oldCodsetorestoqueOfMoventradaCollectionMoventrada != null) {
                    oldCodsetorestoqueOfMoventradaCollectionMoventrada.getMoventradaCollection().remove(moventradaCollectionMoventrada);
                    oldCodsetorestoqueOfMoventradaCollectionMoventrada = em.merge(oldCodsetorestoqueOfMoventradaCollectionMoventrada);
                }
            }
            for (Moventradaprod moventradaprodCollectionMoventradaprod : setorestoque.getMoventradaprodCollection()) {
                Setorestoque oldCodsetorestoqueOfMoventradaprodCollectionMoventradaprod = moventradaprodCollectionMoventradaprod.getCodsetorestoque();
                moventradaprodCollectionMoventradaprod.setCodsetorestoque(setorestoque);
                moventradaprodCollectionMoventradaprod = em.merge(moventradaprodCollectionMoventradaprod);
                if (oldCodsetorestoqueOfMoventradaprodCollectionMoventradaprod != null) {
                    oldCodsetorestoqueOfMoventradaprodCollectionMoventradaprod.getMoventradaprodCollection().remove(moventradaprodCollectionMoventradaprod);
                    oldCodsetorestoqueOfMoventradaprodCollectionMoventradaprod = em.merge(oldCodsetorestoqueOfMoventradaprodCollectionMoventradaprod);
                }
            }
            for (Ordemproducao ordemproducaoCollectionOrdemproducao : setorestoque.getOrdemproducaoCollection()) {
                Setorestoque oldCodsetorestoqueentradaOfOrdemproducaoCollectionOrdemproducao = ordemproducaoCollectionOrdemproducao.getCodsetorestoqueentrada();
                ordemproducaoCollectionOrdemproducao.setCodsetorestoqueentrada(setorestoque);
                ordemproducaoCollectionOrdemproducao = em.merge(ordemproducaoCollectionOrdemproducao);
                if (oldCodsetorestoqueentradaOfOrdemproducaoCollectionOrdemproducao != null) {
                    oldCodsetorestoqueentradaOfOrdemproducaoCollectionOrdemproducao.getOrdemproducaoCollection().remove(ordemproducaoCollectionOrdemproducao);
                    oldCodsetorestoqueentradaOfOrdemproducaoCollectionOrdemproducao = em.merge(oldCodsetorestoqueentradaOfOrdemproducaoCollectionOrdemproducao);
                }
            }
            for (Documento documentoCollectionDocumento : setorestoque.getDocumentoCollection()) {
                Setorestoque oldCodsetorestoqueOfDocumentoCollectionDocumento = documentoCollectionDocumento.getCodsetorestoque();
                documentoCollectionDocumento.setCodsetorestoque(setorestoque);
                documentoCollectionDocumento = em.merge(documentoCollectionDocumento);
                if (oldCodsetorestoqueOfDocumentoCollectionDocumento != null) {
                    oldCodsetorestoqueOfDocumentoCollectionDocumento.getDocumentoCollection().remove(documentoCollectionDocumento);
                    oldCodsetorestoqueOfDocumentoCollectionDocumento = em.merge(oldCodsetorestoqueOfDocumentoCollectionDocumento);
                }
            }
            for (Produtoestoque produtoestoqueCollectionProdutoestoque : setorestoque.getProdutoestoqueCollection()) {
                Setorestoque oldSetorestoqueOfProdutoestoqueCollectionProdutoestoque = produtoestoqueCollectionProdutoestoque.getSetorestoque();
                produtoestoqueCollectionProdutoestoque.setSetorestoque(setorestoque);
                produtoestoqueCollectionProdutoestoque = em.merge(produtoestoqueCollectionProdutoestoque);
                if (oldSetorestoqueOfProdutoestoqueCollectionProdutoestoque != null) {
                    oldSetorestoqueOfProdutoestoqueCollectionProdutoestoque.getProdutoestoqueCollection().remove(produtoestoqueCollectionProdutoestoque);
                    oldSetorestoqueOfProdutoestoqueCollectionProdutoestoque = em.merge(oldSetorestoqueOfProdutoestoqueCollectionProdutoestoque);
                }
            }
            for (Acerto acertoCollectionAcerto : setorestoque.getAcertoCollection()) {
                Setorestoque oldCodsetorestoqueOfAcertoCollectionAcerto = acertoCollectionAcerto.getCodsetorestoque();
                acertoCollectionAcerto.setCodsetorestoque(setorestoque);
                acertoCollectionAcerto = em.merge(acertoCollectionAcerto);
                if (oldCodsetorestoqueOfAcertoCollectionAcerto != null) {
                    oldCodsetorestoqueOfAcertoCollectionAcerto.getAcertoCollection().remove(acertoCollectionAcerto);
                    oldCodsetorestoqueOfAcertoCollectionAcerto = em.merge(oldCodsetorestoqueOfAcertoCollectionAcerto);
                }
            }
            for (Orcamento orcamentoCollectionOrcamento : setorestoque.getOrcamentoCollection()) {
                Setorestoque oldCodsetorestoqueOfOrcamentoCollectionOrcamento = orcamentoCollectionOrcamento.getCodsetorestoque();
                orcamentoCollectionOrcamento.setCodsetorestoque(setorestoque);
                orcamentoCollectionOrcamento = em.merge(orcamentoCollectionOrcamento);
                if (oldCodsetorestoqueOfOrcamentoCollectionOrcamento != null) {
                    oldCodsetorestoqueOfOrcamentoCollectionOrcamento.getOrcamentoCollection().remove(orcamentoCollectionOrcamento);
                    oldCodsetorestoqueOfOrcamentoCollectionOrcamento = em.merge(oldCodsetorestoqueOfOrcamentoCollectionOrcamento);
                }
            }
            for (Movenda movendaCollectionMovenda : setorestoque.getMovendaCollection()) {
                Setorestoque oldCodsetorestoqueOfMovendaCollectionMovenda = movendaCollectionMovenda.getCodsetorestoque();
                movendaCollectionMovenda.setCodsetorestoque(setorestoque);
                movendaCollectionMovenda = em.merge(movendaCollectionMovenda);
                if (oldCodsetorestoqueOfMovendaCollectionMovenda != null) {
                    oldCodsetorestoqueOfMovendaCollectionMovenda.getMovendaCollection().remove(movendaCollectionMovenda);
                    oldCodsetorestoqueOfMovendaCollectionMovenda = em.merge(oldCodsetorestoqueOfMovendaCollectionMovenda);
                }
            }
            for (Pedido pedidoCollectionPedido : setorestoque.getPedidoCollection()) {
                Setorestoque oldCodsetorestoqueOfPedidoCollectionPedido = pedidoCollectionPedido.getCodsetorestoque();
                pedidoCollectionPedido.setCodsetorestoque(setorestoque);
                pedidoCollectionPedido = em.merge(pedidoCollectionPedido);
                if (oldCodsetorestoqueOfPedidoCollectionPedido != null) {
                    oldCodsetorestoqueOfPedidoCollectionPedido.getPedidoCollection().remove(pedidoCollectionPedido);
                    oldCodsetorestoqueOfPedidoCollectionPedido = em.merge(oldCodsetorestoqueOfPedidoCollectionPedido);
                }
            }
            for (Orcamentoprod orcamentoprodCollectionOrcamentoprod : setorestoque.getOrcamentoprodCollection()) {
                Setorestoque oldCodsetorestoqueOfOrcamentoprodCollectionOrcamentoprod = orcamentoprodCollectionOrcamentoprod.getCodsetorestoque();
                orcamentoprodCollectionOrcamentoprod.setCodsetorestoque(setorestoque);
                orcamentoprodCollectionOrcamentoprod = em.merge(orcamentoprodCollectionOrcamentoprod);
                if (oldCodsetorestoqueOfOrcamentoprodCollectionOrcamentoprod != null) {
                    oldCodsetorestoqueOfOrcamentoprodCollectionOrcamentoprod.getOrcamentoprodCollection().remove(orcamentoprodCollectionOrcamentoprod);
                    oldCodsetorestoqueOfOrcamentoprodCollectionOrcamentoprod = em.merge(oldCodsetorestoqueOfOrcamentoprodCollectionOrcamentoprod);
                }
            }
            for (AcertoProdlote acertoProdloteCollectionAcertoProdlote : setorestoque.getAcertoProdloteCollection()) {
                Setorestoque oldCodsetorestoqueOfAcertoProdloteCollectionAcertoProdlote = acertoProdloteCollectionAcertoProdlote.getCodsetorestoque();
                acertoProdloteCollectionAcertoProdlote.setCodsetorestoque(setorestoque);
                acertoProdloteCollectionAcertoProdlote = em.merge(acertoProdloteCollectionAcertoProdlote);
                if (oldCodsetorestoqueOfAcertoProdloteCollectionAcertoProdlote != null) {
                    oldCodsetorestoqueOfAcertoProdloteCollectionAcertoProdlote.getAcertoProdloteCollection().remove(acertoProdloteCollectionAcertoProdlote);
                    oldCodsetorestoqueOfAcertoProdloteCollectionAcertoProdlote = em.merge(oldCodsetorestoqueOfAcertoProdloteCollectionAcertoProdlote);
                }
            }
            for (AcertoProdfci acertoProdfciCollectionAcertoProdfci : setorestoque.getAcertoProdfciCollection()) {
                Setorestoque oldCodsetorestoqueOfAcertoProdfciCollectionAcertoProdfci = acertoProdfciCollectionAcertoProdfci.getCodsetorestoque();
                acertoProdfciCollectionAcertoProdfci.setCodsetorestoque(setorestoque);
                acertoProdfciCollectionAcertoProdfci = em.merge(acertoProdfciCollectionAcertoProdfci);
                if (oldCodsetorestoqueOfAcertoProdfciCollectionAcertoProdfci != null) {
                    oldCodsetorestoqueOfAcertoProdfciCollectionAcertoProdfci.getAcertoProdfciCollection().remove(acertoProdfciCollectionAcertoProdfci);
                    oldCodsetorestoqueOfAcertoProdfciCollectionAcertoProdfci = em.merge(oldCodsetorestoqueOfAcertoProdfciCollectionAcertoProdfci);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSetorestoque(setorestoque.getCodsetorestoque()) != null) {
                throw new PreexistingEntityException("Setorestoque " + setorestoque + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Setorestoque setorestoque) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Setorestoque persistentSetorestoque = em.find(Setorestoque.class, setorestoque.getCodsetorestoque());
            Collection<Moventrada> moventradaCollectionOld = persistentSetorestoque.getMoventradaCollection();
            Collection<Moventrada> moventradaCollectionNew = setorestoque.getMoventradaCollection();
            Collection<Moventradaprod> moventradaprodCollectionOld = persistentSetorestoque.getMoventradaprodCollection();
            Collection<Moventradaprod> moventradaprodCollectionNew = setorestoque.getMoventradaprodCollection();
            Collection<Ordemproducao> ordemproducaoCollectionOld = persistentSetorestoque.getOrdemproducaoCollection();
            Collection<Ordemproducao> ordemproducaoCollectionNew = setorestoque.getOrdemproducaoCollection();
            Collection<Documento> documentoCollectionOld = persistentSetorestoque.getDocumentoCollection();
            Collection<Documento> documentoCollectionNew = setorestoque.getDocumentoCollection();
            Collection<Produtoestoque> produtoestoqueCollectionOld = persistentSetorestoque.getProdutoestoqueCollection();
            Collection<Produtoestoque> produtoestoqueCollectionNew = setorestoque.getProdutoestoqueCollection();
            Collection<Acerto> acertoCollectionOld = persistentSetorestoque.getAcertoCollection();
            Collection<Acerto> acertoCollectionNew = setorestoque.getAcertoCollection();
            Collection<Orcamento> orcamentoCollectionOld = persistentSetorestoque.getOrcamentoCollection();
            Collection<Orcamento> orcamentoCollectionNew = setorestoque.getOrcamentoCollection();
            Collection<Movenda> movendaCollectionOld = persistentSetorestoque.getMovendaCollection();
            Collection<Movenda> movendaCollectionNew = setorestoque.getMovendaCollection();
            Collection<Pedido> pedidoCollectionOld = persistentSetorestoque.getPedidoCollection();
            Collection<Pedido> pedidoCollectionNew = setorestoque.getPedidoCollection();
            Collection<Orcamentoprod> orcamentoprodCollectionOld = persistentSetorestoque.getOrcamentoprodCollection();
            Collection<Orcamentoprod> orcamentoprodCollectionNew = setorestoque.getOrcamentoprodCollection();
            Collection<AcertoProdlote> acertoProdloteCollectionOld = persistentSetorestoque.getAcertoProdloteCollection();
            Collection<AcertoProdlote> acertoProdloteCollectionNew = setorestoque.getAcertoProdloteCollection();
            Collection<AcertoProdfci> acertoProdfciCollectionOld = persistentSetorestoque.getAcertoProdfciCollection();
            Collection<AcertoProdfci> acertoProdfciCollectionNew = setorestoque.getAcertoProdfciCollection();
            List<String> illegalOrphanMessages = null;
            for (Moventrada moventradaCollectionOldMoventrada : moventradaCollectionOld) {
                if (!moventradaCollectionNew.contains(moventradaCollectionOldMoventrada)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Moventrada " + moventradaCollectionOldMoventrada + " since its codsetorestoque field is not nullable.");
                }
            }
            for (Produtoestoque produtoestoqueCollectionOldProdutoestoque : produtoestoqueCollectionOld) {
                if (!produtoestoqueCollectionNew.contains(produtoestoqueCollectionOldProdutoestoque)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Produtoestoque " + produtoestoqueCollectionOldProdutoestoque + " since its setorestoque field is not nullable.");
                }
            }
            for (Acerto acertoCollectionOldAcerto : acertoCollectionOld) {
                if (!acertoCollectionNew.contains(acertoCollectionOldAcerto)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Acerto " + acertoCollectionOldAcerto + " since its codsetorestoque field is not nullable.");
                }
            }
            for (AcertoProdlote acertoProdloteCollectionOldAcertoProdlote : acertoProdloteCollectionOld) {
                if (!acertoProdloteCollectionNew.contains(acertoProdloteCollectionOldAcertoProdlote)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain AcertoProdlote " + acertoProdloteCollectionOldAcertoProdlote + " since its codsetorestoque field is not nullable.");
                }
            }
            for (AcertoProdfci acertoProdfciCollectionOldAcertoProdfci : acertoProdfciCollectionOld) {
                if (!acertoProdfciCollectionNew.contains(acertoProdfciCollectionOldAcertoProdfci)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain AcertoProdfci " + acertoProdfciCollectionOldAcertoProdfci + " since its codsetorestoque field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Moventrada> attachedMoventradaCollectionNew = new ArrayList<Moventrada>();
            for (Moventrada moventradaCollectionNewMoventradaToAttach : moventradaCollectionNew) {
                moventradaCollectionNewMoventradaToAttach = em.getReference(moventradaCollectionNewMoventradaToAttach.getClass(), moventradaCollectionNewMoventradaToAttach.getCodmoventr());
                attachedMoventradaCollectionNew.add(moventradaCollectionNewMoventradaToAttach);
            }
            moventradaCollectionNew = attachedMoventradaCollectionNew;
            setorestoque.setMoventradaCollection(moventradaCollectionNew);
            Collection<Moventradaprod> attachedMoventradaprodCollectionNew = new ArrayList<Moventradaprod>();
            for (Moventradaprod moventradaprodCollectionNewMoventradaprodToAttach : moventradaprodCollectionNew) {
                moventradaprodCollectionNewMoventradaprodToAttach = em.getReference(moventradaprodCollectionNewMoventradaprodToAttach.getClass(), moventradaprodCollectionNewMoventradaprodToAttach.getCodmoveprod());
                attachedMoventradaprodCollectionNew.add(moventradaprodCollectionNewMoventradaprodToAttach);
            }
            moventradaprodCollectionNew = attachedMoventradaprodCollectionNew;
            setorestoque.setMoventradaprodCollection(moventradaprodCollectionNew);
            Collection<Ordemproducao> attachedOrdemproducaoCollectionNew = new ArrayList<Ordemproducao>();
            for (Ordemproducao ordemproducaoCollectionNewOrdemproducaoToAttach : ordemproducaoCollectionNew) {
                ordemproducaoCollectionNewOrdemproducaoToAttach = em.getReference(ordemproducaoCollectionNewOrdemproducaoToAttach.getClass(), ordemproducaoCollectionNewOrdemproducaoToAttach.getCodordemproducao());
                attachedOrdemproducaoCollectionNew.add(ordemproducaoCollectionNewOrdemproducaoToAttach);
            }
            ordemproducaoCollectionNew = attachedOrdemproducaoCollectionNew;
            setorestoque.setOrdemproducaoCollection(ordemproducaoCollectionNew);
            Collection<Documento> attachedDocumentoCollectionNew = new ArrayList<Documento>();
            for (Documento documentoCollectionNewDocumentoToAttach : documentoCollectionNew) {
                documentoCollectionNewDocumentoToAttach = em.getReference(documentoCollectionNewDocumentoToAttach.getClass(), documentoCollectionNewDocumentoToAttach.getCoddocumento());
                attachedDocumentoCollectionNew.add(documentoCollectionNewDocumentoToAttach);
            }
            documentoCollectionNew = attachedDocumentoCollectionNew;
            setorestoque.setDocumentoCollection(documentoCollectionNew);
            Collection<Produtoestoque> attachedProdutoestoqueCollectionNew = new ArrayList<Produtoestoque>();
            for (Produtoestoque produtoestoqueCollectionNewProdutoestoqueToAttach : produtoestoqueCollectionNew) {
                produtoestoqueCollectionNewProdutoestoqueToAttach = em.getReference(produtoestoqueCollectionNewProdutoestoqueToAttach.getClass(), produtoestoqueCollectionNewProdutoestoqueToAttach.getProdutoestoquePK());
                attachedProdutoestoqueCollectionNew.add(produtoestoqueCollectionNewProdutoestoqueToAttach);
            }
            produtoestoqueCollectionNew = attachedProdutoestoqueCollectionNew;
            setorestoque.setProdutoestoqueCollection(produtoestoqueCollectionNew);
            Collection<Acerto> attachedAcertoCollectionNew = new ArrayList<Acerto>();
            for (Acerto acertoCollectionNewAcertoToAttach : acertoCollectionNew) {
                acertoCollectionNewAcertoToAttach = em.getReference(acertoCollectionNewAcertoToAttach.getClass(), acertoCollectionNewAcertoToAttach.getCodacerto());
                attachedAcertoCollectionNew.add(acertoCollectionNewAcertoToAttach);
            }
            acertoCollectionNew = attachedAcertoCollectionNew;
            setorestoque.setAcertoCollection(acertoCollectionNew);
            Collection<Orcamento> attachedOrcamentoCollectionNew = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollectionNewOrcamentoToAttach : orcamentoCollectionNew) {
                orcamentoCollectionNewOrcamentoToAttach = em.getReference(orcamentoCollectionNewOrcamentoToAttach.getClass(), orcamentoCollectionNewOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollectionNew.add(orcamentoCollectionNewOrcamentoToAttach);
            }
            orcamentoCollectionNew = attachedOrcamentoCollectionNew;
            setorestoque.setOrcamentoCollection(orcamentoCollectionNew);
            Collection<Movenda> attachedMovendaCollectionNew = new ArrayList<Movenda>();
            for (Movenda movendaCollectionNewMovendaToAttach : movendaCollectionNew) {
                movendaCollectionNewMovendaToAttach = em.getReference(movendaCollectionNewMovendaToAttach.getClass(), movendaCollectionNewMovendaToAttach.getCodmovenda());
                attachedMovendaCollectionNew.add(movendaCollectionNewMovendaToAttach);
            }
            movendaCollectionNew = attachedMovendaCollectionNew;
            setorestoque.setMovendaCollection(movendaCollectionNew);
            Collection<Pedido> attachedPedidoCollectionNew = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionNewPedidoToAttach : pedidoCollectionNew) {
                pedidoCollectionNewPedidoToAttach = em.getReference(pedidoCollectionNewPedidoToAttach.getClass(), pedidoCollectionNewPedidoToAttach.getCodped());
                attachedPedidoCollectionNew.add(pedidoCollectionNewPedidoToAttach);
            }
            pedidoCollectionNew = attachedPedidoCollectionNew;
            setorestoque.setPedidoCollection(pedidoCollectionNew);
            Collection<Orcamentoprod> attachedOrcamentoprodCollectionNew = new ArrayList<Orcamentoprod>();
            for (Orcamentoprod orcamentoprodCollectionNewOrcamentoprodToAttach : orcamentoprodCollectionNew) {
                orcamentoprodCollectionNewOrcamentoprodToAttach = em.getReference(orcamentoprodCollectionNewOrcamentoprodToAttach.getClass(), orcamentoprodCollectionNewOrcamentoprodToAttach.getCodorcprod());
                attachedOrcamentoprodCollectionNew.add(orcamentoprodCollectionNewOrcamentoprodToAttach);
            }
            orcamentoprodCollectionNew = attachedOrcamentoprodCollectionNew;
            setorestoque.setOrcamentoprodCollection(orcamentoprodCollectionNew);
            Collection<AcertoProdlote> attachedAcertoProdloteCollectionNew = new ArrayList<AcertoProdlote>();
            for (AcertoProdlote acertoProdloteCollectionNewAcertoProdloteToAttach : acertoProdloteCollectionNew) {
                acertoProdloteCollectionNewAcertoProdloteToAttach = em.getReference(acertoProdloteCollectionNewAcertoProdloteToAttach.getClass(), acertoProdloteCollectionNewAcertoProdloteToAttach.getCodacertoProdlote());
                attachedAcertoProdloteCollectionNew.add(acertoProdloteCollectionNewAcertoProdloteToAttach);
            }
            acertoProdloteCollectionNew = attachedAcertoProdloteCollectionNew;
            setorestoque.setAcertoProdloteCollection(acertoProdloteCollectionNew);
            Collection<AcertoProdfci> attachedAcertoProdfciCollectionNew = new ArrayList<AcertoProdfci>();
            for (AcertoProdfci acertoProdfciCollectionNewAcertoProdfciToAttach : acertoProdfciCollectionNew) {
                acertoProdfciCollectionNewAcertoProdfciToAttach = em.getReference(acertoProdfciCollectionNewAcertoProdfciToAttach.getClass(), acertoProdfciCollectionNewAcertoProdfciToAttach.getCodacertoProdfci());
                attachedAcertoProdfciCollectionNew.add(acertoProdfciCollectionNewAcertoProdfciToAttach);
            }
            acertoProdfciCollectionNew = attachedAcertoProdfciCollectionNew;
            setorestoque.setAcertoProdfciCollection(acertoProdfciCollectionNew);
            setorestoque = em.merge(setorestoque);
            for (Moventrada moventradaCollectionNewMoventrada : moventradaCollectionNew) {
                if (!moventradaCollectionOld.contains(moventradaCollectionNewMoventrada)) {
                    Setorestoque oldCodsetorestoqueOfMoventradaCollectionNewMoventrada = moventradaCollectionNewMoventrada.getCodsetorestoque();
                    moventradaCollectionNewMoventrada.setCodsetorestoque(setorestoque);
                    moventradaCollectionNewMoventrada = em.merge(moventradaCollectionNewMoventrada);
                    if (oldCodsetorestoqueOfMoventradaCollectionNewMoventrada != null && !oldCodsetorestoqueOfMoventradaCollectionNewMoventrada.equals(setorestoque)) {
                        oldCodsetorestoqueOfMoventradaCollectionNewMoventrada.getMoventradaCollection().remove(moventradaCollectionNewMoventrada);
                        oldCodsetorestoqueOfMoventradaCollectionNewMoventrada = em.merge(oldCodsetorestoqueOfMoventradaCollectionNewMoventrada);
                    }
                }
            }
            for (Moventradaprod moventradaprodCollectionOldMoventradaprod : moventradaprodCollectionOld) {
                if (!moventradaprodCollectionNew.contains(moventradaprodCollectionOldMoventradaprod)) {
                    moventradaprodCollectionOldMoventradaprod.setCodsetorestoque(null);
                    moventradaprodCollectionOldMoventradaprod = em.merge(moventradaprodCollectionOldMoventradaprod);
                }
            }
            for (Moventradaprod moventradaprodCollectionNewMoventradaprod : moventradaprodCollectionNew) {
                if (!moventradaprodCollectionOld.contains(moventradaprodCollectionNewMoventradaprod)) {
                    Setorestoque oldCodsetorestoqueOfMoventradaprodCollectionNewMoventradaprod = moventradaprodCollectionNewMoventradaprod.getCodsetorestoque();
                    moventradaprodCollectionNewMoventradaprod.setCodsetorestoque(setorestoque);
                    moventradaprodCollectionNewMoventradaprod = em.merge(moventradaprodCollectionNewMoventradaprod);
                    if (oldCodsetorestoqueOfMoventradaprodCollectionNewMoventradaprod != null && !oldCodsetorestoqueOfMoventradaprodCollectionNewMoventradaprod.equals(setorestoque)) {
                        oldCodsetorestoqueOfMoventradaprodCollectionNewMoventradaprod.getMoventradaprodCollection().remove(moventradaprodCollectionNewMoventradaprod);
                        oldCodsetorestoqueOfMoventradaprodCollectionNewMoventradaprod = em.merge(oldCodsetorestoqueOfMoventradaprodCollectionNewMoventradaprod);
                    }
                }
            }
            for (Ordemproducao ordemproducaoCollectionOldOrdemproducao : ordemproducaoCollectionOld) {
                if (!ordemproducaoCollectionNew.contains(ordemproducaoCollectionOldOrdemproducao)) {
                    ordemproducaoCollectionOldOrdemproducao.setCodsetorestoqueentrada(null);
                    ordemproducaoCollectionOldOrdemproducao = em.merge(ordemproducaoCollectionOldOrdemproducao);
                }
            }
            for (Ordemproducao ordemproducaoCollectionNewOrdemproducao : ordemproducaoCollectionNew) {
                if (!ordemproducaoCollectionOld.contains(ordemproducaoCollectionNewOrdemproducao)) {
                    Setorestoque oldCodsetorestoqueentradaOfOrdemproducaoCollectionNewOrdemproducao = ordemproducaoCollectionNewOrdemproducao.getCodsetorestoqueentrada();
                    ordemproducaoCollectionNewOrdemproducao.setCodsetorestoqueentrada(setorestoque);
                    ordemproducaoCollectionNewOrdemproducao = em.merge(ordemproducaoCollectionNewOrdemproducao);
                    if (oldCodsetorestoqueentradaOfOrdemproducaoCollectionNewOrdemproducao != null && !oldCodsetorestoqueentradaOfOrdemproducaoCollectionNewOrdemproducao.equals(setorestoque)) {
                        oldCodsetorestoqueentradaOfOrdemproducaoCollectionNewOrdemproducao.getOrdemproducaoCollection().remove(ordemproducaoCollectionNewOrdemproducao);
                        oldCodsetorestoqueentradaOfOrdemproducaoCollectionNewOrdemproducao = em.merge(oldCodsetorestoqueentradaOfOrdemproducaoCollectionNewOrdemproducao);
                    }
                }
            }
            for (Documento documentoCollectionOldDocumento : documentoCollectionOld) {
                if (!documentoCollectionNew.contains(documentoCollectionOldDocumento)) {
                    documentoCollectionOldDocumento.setCodsetorestoque(null);
                    documentoCollectionOldDocumento = em.merge(documentoCollectionOldDocumento);
                }
            }
            for (Documento documentoCollectionNewDocumento : documentoCollectionNew) {
                if (!documentoCollectionOld.contains(documentoCollectionNewDocumento)) {
                    Setorestoque oldCodsetorestoqueOfDocumentoCollectionNewDocumento = documentoCollectionNewDocumento.getCodsetorestoque();
                    documentoCollectionNewDocumento.setCodsetorestoque(setorestoque);
                    documentoCollectionNewDocumento = em.merge(documentoCollectionNewDocumento);
                    if (oldCodsetorestoqueOfDocumentoCollectionNewDocumento != null && !oldCodsetorestoqueOfDocumentoCollectionNewDocumento.equals(setorestoque)) {
                        oldCodsetorestoqueOfDocumentoCollectionNewDocumento.getDocumentoCollection().remove(documentoCollectionNewDocumento);
                        oldCodsetorestoqueOfDocumentoCollectionNewDocumento = em.merge(oldCodsetorestoqueOfDocumentoCollectionNewDocumento);
                    }
                }
            }
            for (Produtoestoque produtoestoqueCollectionNewProdutoestoque : produtoestoqueCollectionNew) {
                if (!produtoestoqueCollectionOld.contains(produtoestoqueCollectionNewProdutoestoque)) {
                    Setorestoque oldSetorestoqueOfProdutoestoqueCollectionNewProdutoestoque = produtoestoqueCollectionNewProdutoestoque.getSetorestoque();
                    produtoestoqueCollectionNewProdutoestoque.setSetorestoque(setorestoque);
                    produtoestoqueCollectionNewProdutoestoque = em.merge(produtoestoqueCollectionNewProdutoestoque);
                    if (oldSetorestoqueOfProdutoestoqueCollectionNewProdutoestoque != null && !oldSetorestoqueOfProdutoestoqueCollectionNewProdutoestoque.equals(setorestoque)) {
                        oldSetorestoqueOfProdutoestoqueCollectionNewProdutoestoque.getProdutoestoqueCollection().remove(produtoestoqueCollectionNewProdutoestoque);
                        oldSetorestoqueOfProdutoestoqueCollectionNewProdutoestoque = em.merge(oldSetorestoqueOfProdutoestoqueCollectionNewProdutoestoque);
                    }
                }
            }
            for (Acerto acertoCollectionNewAcerto : acertoCollectionNew) {
                if (!acertoCollectionOld.contains(acertoCollectionNewAcerto)) {
                    Setorestoque oldCodsetorestoqueOfAcertoCollectionNewAcerto = acertoCollectionNewAcerto.getCodsetorestoque();
                    acertoCollectionNewAcerto.setCodsetorestoque(setorestoque);
                    acertoCollectionNewAcerto = em.merge(acertoCollectionNewAcerto);
                    if (oldCodsetorestoqueOfAcertoCollectionNewAcerto != null && !oldCodsetorestoqueOfAcertoCollectionNewAcerto.equals(setorestoque)) {
                        oldCodsetorestoqueOfAcertoCollectionNewAcerto.getAcertoCollection().remove(acertoCollectionNewAcerto);
                        oldCodsetorestoqueOfAcertoCollectionNewAcerto = em.merge(oldCodsetorestoqueOfAcertoCollectionNewAcerto);
                    }
                }
            }
            for (Orcamento orcamentoCollectionOldOrcamento : orcamentoCollectionOld) {
                if (!orcamentoCollectionNew.contains(orcamentoCollectionOldOrcamento)) {
                    orcamentoCollectionOldOrcamento.setCodsetorestoque(null);
                    orcamentoCollectionOldOrcamento = em.merge(orcamentoCollectionOldOrcamento);
                }
            }
            for (Orcamento orcamentoCollectionNewOrcamento : orcamentoCollectionNew) {
                if (!orcamentoCollectionOld.contains(orcamentoCollectionNewOrcamento)) {
                    Setorestoque oldCodsetorestoqueOfOrcamentoCollectionNewOrcamento = orcamentoCollectionNewOrcamento.getCodsetorestoque();
                    orcamentoCollectionNewOrcamento.setCodsetorestoque(setorestoque);
                    orcamentoCollectionNewOrcamento = em.merge(orcamentoCollectionNewOrcamento);
                    if (oldCodsetorestoqueOfOrcamentoCollectionNewOrcamento != null && !oldCodsetorestoqueOfOrcamentoCollectionNewOrcamento.equals(setorestoque)) {
                        oldCodsetorestoqueOfOrcamentoCollectionNewOrcamento.getOrcamentoCollection().remove(orcamentoCollectionNewOrcamento);
                        oldCodsetorestoqueOfOrcamentoCollectionNewOrcamento = em.merge(oldCodsetorestoqueOfOrcamentoCollectionNewOrcamento);
                    }
                }
            }
            for (Movenda movendaCollectionOldMovenda : movendaCollectionOld) {
                if (!movendaCollectionNew.contains(movendaCollectionOldMovenda)) {
                    movendaCollectionOldMovenda.setCodsetorestoque(null);
                    movendaCollectionOldMovenda = em.merge(movendaCollectionOldMovenda);
                }
            }
            for (Movenda movendaCollectionNewMovenda : movendaCollectionNew) {
                if (!movendaCollectionOld.contains(movendaCollectionNewMovenda)) {
                    Setorestoque oldCodsetorestoqueOfMovendaCollectionNewMovenda = movendaCollectionNewMovenda.getCodsetorestoque();
                    movendaCollectionNewMovenda.setCodsetorestoque(setorestoque);
                    movendaCollectionNewMovenda = em.merge(movendaCollectionNewMovenda);
                    if (oldCodsetorestoqueOfMovendaCollectionNewMovenda != null && !oldCodsetorestoqueOfMovendaCollectionNewMovenda.equals(setorestoque)) {
                        oldCodsetorestoqueOfMovendaCollectionNewMovenda.getMovendaCollection().remove(movendaCollectionNewMovenda);
                        oldCodsetorestoqueOfMovendaCollectionNewMovenda = em.merge(oldCodsetorestoqueOfMovendaCollectionNewMovenda);
                    }
                }
            }
            for (Pedido pedidoCollectionOldPedido : pedidoCollectionOld) {
                if (!pedidoCollectionNew.contains(pedidoCollectionOldPedido)) {
                    pedidoCollectionOldPedido.setCodsetorestoque(null);
                    pedidoCollectionOldPedido = em.merge(pedidoCollectionOldPedido);
                }
            }
            for (Pedido pedidoCollectionNewPedido : pedidoCollectionNew) {
                if (!pedidoCollectionOld.contains(pedidoCollectionNewPedido)) {
                    Setorestoque oldCodsetorestoqueOfPedidoCollectionNewPedido = pedidoCollectionNewPedido.getCodsetorestoque();
                    pedidoCollectionNewPedido.setCodsetorestoque(setorestoque);
                    pedidoCollectionNewPedido = em.merge(pedidoCollectionNewPedido);
                    if (oldCodsetorestoqueOfPedidoCollectionNewPedido != null && !oldCodsetorestoqueOfPedidoCollectionNewPedido.equals(setorestoque)) {
                        oldCodsetorestoqueOfPedidoCollectionNewPedido.getPedidoCollection().remove(pedidoCollectionNewPedido);
                        oldCodsetorestoqueOfPedidoCollectionNewPedido = em.merge(oldCodsetorestoqueOfPedidoCollectionNewPedido);
                    }
                }
            }
            for (Orcamentoprod orcamentoprodCollectionOldOrcamentoprod : orcamentoprodCollectionOld) {
                if (!orcamentoprodCollectionNew.contains(orcamentoprodCollectionOldOrcamentoprod)) {
                    orcamentoprodCollectionOldOrcamentoprod.setCodsetorestoque(null);
                    orcamentoprodCollectionOldOrcamentoprod = em.merge(orcamentoprodCollectionOldOrcamentoprod);
                }
            }
            for (Orcamentoprod orcamentoprodCollectionNewOrcamentoprod : orcamentoprodCollectionNew) {
                if (!orcamentoprodCollectionOld.contains(orcamentoprodCollectionNewOrcamentoprod)) {
                    Setorestoque oldCodsetorestoqueOfOrcamentoprodCollectionNewOrcamentoprod = orcamentoprodCollectionNewOrcamentoprod.getCodsetorestoque();
                    orcamentoprodCollectionNewOrcamentoprod.setCodsetorestoque(setorestoque);
                    orcamentoprodCollectionNewOrcamentoprod = em.merge(orcamentoprodCollectionNewOrcamentoprod);
                    if (oldCodsetorestoqueOfOrcamentoprodCollectionNewOrcamentoprod != null && !oldCodsetorestoqueOfOrcamentoprodCollectionNewOrcamentoprod.equals(setorestoque)) {
                        oldCodsetorestoqueOfOrcamentoprodCollectionNewOrcamentoprod.getOrcamentoprodCollection().remove(orcamentoprodCollectionNewOrcamentoprod);
                        oldCodsetorestoqueOfOrcamentoprodCollectionNewOrcamentoprod = em.merge(oldCodsetorestoqueOfOrcamentoprodCollectionNewOrcamentoprod);
                    }
                }
            }
            for (AcertoProdlote acertoProdloteCollectionNewAcertoProdlote : acertoProdloteCollectionNew) {
                if (!acertoProdloteCollectionOld.contains(acertoProdloteCollectionNewAcertoProdlote)) {
                    Setorestoque oldCodsetorestoqueOfAcertoProdloteCollectionNewAcertoProdlote = acertoProdloteCollectionNewAcertoProdlote.getCodsetorestoque();
                    acertoProdloteCollectionNewAcertoProdlote.setCodsetorestoque(setorestoque);
                    acertoProdloteCollectionNewAcertoProdlote = em.merge(acertoProdloteCollectionNewAcertoProdlote);
                    if (oldCodsetorestoqueOfAcertoProdloteCollectionNewAcertoProdlote != null && !oldCodsetorestoqueOfAcertoProdloteCollectionNewAcertoProdlote.equals(setorestoque)) {
                        oldCodsetorestoqueOfAcertoProdloteCollectionNewAcertoProdlote.getAcertoProdloteCollection().remove(acertoProdloteCollectionNewAcertoProdlote);
                        oldCodsetorestoqueOfAcertoProdloteCollectionNewAcertoProdlote = em.merge(oldCodsetorestoqueOfAcertoProdloteCollectionNewAcertoProdlote);
                    }
                }
            }
            for (AcertoProdfci acertoProdfciCollectionNewAcertoProdfci : acertoProdfciCollectionNew) {
                if (!acertoProdfciCollectionOld.contains(acertoProdfciCollectionNewAcertoProdfci)) {
                    Setorestoque oldCodsetorestoqueOfAcertoProdfciCollectionNewAcertoProdfci = acertoProdfciCollectionNewAcertoProdfci.getCodsetorestoque();
                    acertoProdfciCollectionNewAcertoProdfci.setCodsetorestoque(setorestoque);
                    acertoProdfciCollectionNewAcertoProdfci = em.merge(acertoProdfciCollectionNewAcertoProdfci);
                    if (oldCodsetorestoqueOfAcertoProdfciCollectionNewAcertoProdfci != null && !oldCodsetorestoqueOfAcertoProdfciCollectionNewAcertoProdfci.equals(setorestoque)) {
                        oldCodsetorestoqueOfAcertoProdfciCollectionNewAcertoProdfci.getAcertoProdfciCollection().remove(acertoProdfciCollectionNewAcertoProdfci);
                        oldCodsetorestoqueOfAcertoProdfciCollectionNewAcertoProdfci = em.merge(oldCodsetorestoqueOfAcertoProdfciCollectionNewAcertoProdfci);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = setorestoque.getCodsetorestoque();
                if (findSetorestoque(id) == null) {
                    throw new NonexistentEntityException("The setorestoque with id " + id + " no longer exists.");
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
            Setorestoque setorestoque;
            try {
                setorestoque = em.getReference(Setorestoque.class, id);
                setorestoque.getCodsetorestoque();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The setorestoque with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Moventrada> moventradaCollectionOrphanCheck = setorestoque.getMoventradaCollection();
            for (Moventrada moventradaCollectionOrphanCheckMoventrada : moventradaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Setorestoque (" + setorestoque + ") cannot be destroyed since the Moventrada " + moventradaCollectionOrphanCheckMoventrada + " in its moventradaCollection field has a non-nullable codsetorestoque field.");
            }
            Collection<Produtoestoque> produtoestoqueCollectionOrphanCheck = setorestoque.getProdutoestoqueCollection();
            for (Produtoestoque produtoestoqueCollectionOrphanCheckProdutoestoque : produtoestoqueCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Setorestoque (" + setorestoque + ") cannot be destroyed since the Produtoestoque " + produtoestoqueCollectionOrphanCheckProdutoestoque + " in its produtoestoqueCollection field has a non-nullable setorestoque field.");
            }
            Collection<Acerto> acertoCollectionOrphanCheck = setorestoque.getAcertoCollection();
            for (Acerto acertoCollectionOrphanCheckAcerto : acertoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Setorestoque (" + setorestoque + ") cannot be destroyed since the Acerto " + acertoCollectionOrphanCheckAcerto + " in its acertoCollection field has a non-nullable codsetorestoque field.");
            }
            Collection<AcertoProdlote> acertoProdloteCollectionOrphanCheck = setorestoque.getAcertoProdloteCollection();
            for (AcertoProdlote acertoProdloteCollectionOrphanCheckAcertoProdlote : acertoProdloteCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Setorestoque (" + setorestoque + ") cannot be destroyed since the AcertoProdlote " + acertoProdloteCollectionOrphanCheckAcertoProdlote + " in its acertoProdloteCollection field has a non-nullable codsetorestoque field.");
            }
            Collection<AcertoProdfci> acertoProdfciCollectionOrphanCheck = setorestoque.getAcertoProdfciCollection();
            for (AcertoProdfci acertoProdfciCollectionOrphanCheckAcertoProdfci : acertoProdfciCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Setorestoque (" + setorestoque + ") cannot be destroyed since the AcertoProdfci " + acertoProdfciCollectionOrphanCheckAcertoProdfci + " in its acertoProdfciCollection field has a non-nullable codsetorestoque field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Moventradaprod> moventradaprodCollection = setorestoque.getMoventradaprodCollection();
            for (Moventradaprod moventradaprodCollectionMoventradaprod : moventradaprodCollection) {
                moventradaprodCollectionMoventradaprod.setCodsetorestoque(null);
                moventradaprodCollectionMoventradaprod = em.merge(moventradaprodCollectionMoventradaprod);
            }
            Collection<Ordemproducao> ordemproducaoCollection = setorestoque.getOrdemproducaoCollection();
            for (Ordemproducao ordemproducaoCollectionOrdemproducao : ordemproducaoCollection) {
                ordemproducaoCollectionOrdemproducao.setCodsetorestoqueentrada(null);
                ordemproducaoCollectionOrdemproducao = em.merge(ordemproducaoCollectionOrdemproducao);
            }
            Collection<Documento> documentoCollection = setorestoque.getDocumentoCollection();
            for (Documento documentoCollectionDocumento : documentoCollection) {
                documentoCollectionDocumento.setCodsetorestoque(null);
                documentoCollectionDocumento = em.merge(documentoCollectionDocumento);
            }
            Collection<Orcamento> orcamentoCollection = setorestoque.getOrcamentoCollection();
            for (Orcamento orcamentoCollectionOrcamento : orcamentoCollection) {
                orcamentoCollectionOrcamento.setCodsetorestoque(null);
                orcamentoCollectionOrcamento = em.merge(orcamentoCollectionOrcamento);
            }
            Collection<Movenda> movendaCollection = setorestoque.getMovendaCollection();
            for (Movenda movendaCollectionMovenda : movendaCollection) {
                movendaCollectionMovenda.setCodsetorestoque(null);
                movendaCollectionMovenda = em.merge(movendaCollectionMovenda);
            }
            Collection<Pedido> pedidoCollection = setorestoque.getPedidoCollection();
            for (Pedido pedidoCollectionPedido : pedidoCollection) {
                pedidoCollectionPedido.setCodsetorestoque(null);
                pedidoCollectionPedido = em.merge(pedidoCollectionPedido);
            }
            Collection<Orcamentoprod> orcamentoprodCollection = setorestoque.getOrcamentoprodCollection();
            for (Orcamentoprod orcamentoprodCollectionOrcamentoprod : orcamentoprodCollection) {
                orcamentoprodCollectionOrcamentoprod.setCodsetorestoque(null);
                orcamentoprodCollectionOrcamentoprod = em.merge(orcamentoprodCollectionOrcamentoprod);
            }
            em.remove(setorestoque);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Setorestoque> findSetorestoqueEntities() {
        return findSetorestoqueEntities(true, -1, -1);
    }

    public List<Setorestoque> findSetorestoqueEntities(int maxResults, int firstResult) {
        return findSetorestoqueEntities(false, maxResults, firstResult);
    }

    private List<Setorestoque> findSetorestoqueEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Setorestoque.class));
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

    public Setorestoque findSetorestoque(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Setorestoque.class, id);
        } finally {
            em.close();
        }
    }

    public int getSetorestoqueCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Setorestoque> rt = cq.from(Setorestoque.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
import entidade.cplus.Calculoicmsestado;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Produtopreco;
import entidade.cplus.OsProdserv;
import entidade.cplus.Reajusteprodutopreco;
import entidade.cplus.Movendaprod;
import entidade.cplus.OsOrdemservico;
import entidade.cplus.Usuariopreco;
import entidade.cplus.Orcamento;
import entidade.cplus.Produtoprecoescalonado;
import entidade.cplus.Orcamentoprod;
import entidade.cplus.Clienteproduto;
import entidade.cplus.Cliente;
import entidade.cplus.Preco;
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
public class PrecoJpaController implements Serializable {

    public PrecoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Preco preco) throws PreexistingEntityException, Exception {
        if (preco.getCalculoicmsestadoCollection() == null) {
            preco.setCalculoicmsestadoCollection(new ArrayList<Calculoicmsestado>());
        }
        if (preco.getCalculoicmsestadoCollection1() == null) {
            preco.setCalculoicmsestadoCollection1(new ArrayList<Calculoicmsestado>());
        }
        if (preco.getProdutoprecoCollection() == null) {
            preco.setProdutoprecoCollection(new ArrayList<Produtopreco>());
        }
        if (preco.getOsProdservCollection() == null) {
            preco.setOsProdservCollection(new ArrayList<OsProdserv>());
        }
        if (preco.getReajusteprodutoprecoCollection() == null) {
            preco.setReajusteprodutoprecoCollection(new ArrayList<Reajusteprodutopreco>());
        }
        if (preco.getMovendaprodCollection() == null) {
            preco.setMovendaprodCollection(new ArrayList<Movendaprod>());
        }
        if (preco.getOsOrdemservicoCollection() == null) {
            preco.setOsOrdemservicoCollection(new ArrayList<OsOrdemservico>());
        }
        if (preco.getUsuarioprecoCollection() == null) {
            preco.setUsuarioprecoCollection(new ArrayList<Usuariopreco>());
        }
        if (preco.getOrcamentoCollection() == null) {
            preco.setOrcamentoCollection(new ArrayList<Orcamento>());
        }
        if (preco.getProdutoprecoescalonadoCollection() == null) {
            preco.setProdutoprecoescalonadoCollection(new ArrayList<Produtoprecoescalonado>());
        }
        if (preco.getOrcamentoprodCollection() == null) {
            preco.setOrcamentoprodCollection(new ArrayList<Orcamentoprod>());
        }
        if (preco.getClienteprodutoCollection() == null) {
            preco.setClienteprodutoCollection(new ArrayList<Clienteproduto>());
        }
        if (preco.getClienteCollection() == null) {
            preco.setClienteCollection(new ArrayList<Cliente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Calculoicmsestado> attachedCalculoicmsestadoCollection = new ArrayList<Calculoicmsestado>();
            for (Calculoicmsestado calculoicmsestadoCollectionCalculoicmsestadoToAttach : preco.getCalculoicmsestadoCollection()) {
                calculoicmsestadoCollectionCalculoicmsestadoToAttach = em.getReference(calculoicmsestadoCollectionCalculoicmsestadoToAttach.getClass(), calculoicmsestadoCollectionCalculoicmsestadoToAttach.getCodcalculoicmsestado());
                attachedCalculoicmsestadoCollection.add(calculoicmsestadoCollectionCalculoicmsestadoToAttach);
            }
            preco.setCalculoicmsestadoCollection(attachedCalculoicmsestadoCollection);
            Collection<Calculoicmsestado> attachedCalculoicmsestadoCollection1 = new ArrayList<Calculoicmsestado>();
            for (Calculoicmsestado calculoicmsestadoCollection1CalculoicmsestadoToAttach : preco.getCalculoicmsestadoCollection1()) {
                calculoicmsestadoCollection1CalculoicmsestadoToAttach = em.getReference(calculoicmsestadoCollection1CalculoicmsestadoToAttach.getClass(), calculoicmsestadoCollection1CalculoicmsestadoToAttach.getCodcalculoicmsestado());
                attachedCalculoicmsestadoCollection1.add(calculoicmsestadoCollection1CalculoicmsestadoToAttach);
            }
            preco.setCalculoicmsestadoCollection1(attachedCalculoicmsestadoCollection1);
            Collection<Produtopreco> attachedProdutoprecoCollection = new ArrayList<Produtopreco>();
            for (Produtopreco produtoprecoCollectionProdutoprecoToAttach : preco.getProdutoprecoCollection()) {
                produtoprecoCollectionProdutoprecoToAttach = em.getReference(produtoprecoCollectionProdutoprecoToAttach.getClass(), produtoprecoCollectionProdutoprecoToAttach.getCodprodutopreco());
                attachedProdutoprecoCollection.add(produtoprecoCollectionProdutoprecoToAttach);
            }
            preco.setProdutoprecoCollection(attachedProdutoprecoCollection);
            Collection<OsProdserv> attachedOsProdservCollection = new ArrayList<OsProdserv>();
            for (OsProdserv osProdservCollectionOsProdservToAttach : preco.getOsProdservCollection()) {
                osProdservCollectionOsProdservToAttach = em.getReference(osProdservCollectionOsProdservToAttach.getClass(), osProdservCollectionOsProdservToAttach.getCodprodserv());
                attachedOsProdservCollection.add(osProdservCollectionOsProdservToAttach);
            }
            preco.setOsProdservCollection(attachedOsProdservCollection);
            Collection<Reajusteprodutopreco> attachedReajusteprodutoprecoCollection = new ArrayList<Reajusteprodutopreco>();
            for (Reajusteprodutopreco reajusteprodutoprecoCollectionReajusteprodutoprecoToAttach : preco.getReajusteprodutoprecoCollection()) {
                reajusteprodutoprecoCollectionReajusteprodutoprecoToAttach = em.getReference(reajusteprodutoprecoCollectionReajusteprodutoprecoToAttach.getClass(), reajusteprodutoprecoCollectionReajusteprodutoprecoToAttach.getCodreajusteprodutopreco());
                attachedReajusteprodutoprecoCollection.add(reajusteprodutoprecoCollectionReajusteprodutoprecoToAttach);
            }
            preco.setReajusteprodutoprecoCollection(attachedReajusteprodutoprecoCollection);
            Collection<Movendaprod> attachedMovendaprodCollection = new ArrayList<Movendaprod>();
            for (Movendaprod movendaprodCollectionMovendaprodToAttach : preco.getMovendaprodCollection()) {
                movendaprodCollectionMovendaprodToAttach = em.getReference(movendaprodCollectionMovendaprodToAttach.getClass(), movendaprodCollectionMovendaprodToAttach.getCodmovprod());
                attachedMovendaprodCollection.add(movendaprodCollectionMovendaprodToAttach);
            }
            preco.setMovendaprodCollection(attachedMovendaprodCollection);
            Collection<OsOrdemservico> attachedOsOrdemservicoCollection = new ArrayList<OsOrdemservico>();
            for (OsOrdemservico osOrdemservicoCollectionOsOrdemservicoToAttach : preco.getOsOrdemservicoCollection()) {
                osOrdemservicoCollectionOsOrdemservicoToAttach = em.getReference(osOrdemservicoCollectionOsOrdemservicoToAttach.getClass(), osOrdemservicoCollectionOsOrdemservicoToAttach.getCodos());
                attachedOsOrdemservicoCollection.add(osOrdemservicoCollectionOsOrdemservicoToAttach);
            }
            preco.setOsOrdemservicoCollection(attachedOsOrdemservicoCollection);
            Collection<Usuariopreco> attachedUsuarioprecoCollection = new ArrayList<Usuariopreco>();
            for (Usuariopreco usuarioprecoCollectionUsuarioprecoToAttach : preco.getUsuarioprecoCollection()) {
                usuarioprecoCollectionUsuarioprecoToAttach = em.getReference(usuarioprecoCollectionUsuarioprecoToAttach.getClass(), usuarioprecoCollectionUsuarioprecoToAttach.getCodusuariopreco());
                attachedUsuarioprecoCollection.add(usuarioprecoCollectionUsuarioprecoToAttach);
            }
            preco.setUsuarioprecoCollection(attachedUsuarioprecoCollection);
            Collection<Orcamento> attachedOrcamentoCollection = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollectionOrcamentoToAttach : preco.getOrcamentoCollection()) {
                orcamentoCollectionOrcamentoToAttach = em.getReference(orcamentoCollectionOrcamentoToAttach.getClass(), orcamentoCollectionOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollection.add(orcamentoCollectionOrcamentoToAttach);
            }
            preco.setOrcamentoCollection(attachedOrcamentoCollection);
            Collection<Produtoprecoescalonado> attachedProdutoprecoescalonadoCollection = new ArrayList<Produtoprecoescalonado>();
            for (Produtoprecoescalonado produtoprecoescalonadoCollectionProdutoprecoescalonadoToAttach : preco.getProdutoprecoescalonadoCollection()) {
                produtoprecoescalonadoCollectionProdutoprecoescalonadoToAttach = em.getReference(produtoprecoescalonadoCollectionProdutoprecoescalonadoToAttach.getClass(), produtoprecoescalonadoCollectionProdutoprecoescalonadoToAttach.getCodprodutoprecoescalonado());
                attachedProdutoprecoescalonadoCollection.add(produtoprecoescalonadoCollectionProdutoprecoescalonadoToAttach);
            }
            preco.setProdutoprecoescalonadoCollection(attachedProdutoprecoescalonadoCollection);
            Collection<Orcamentoprod> attachedOrcamentoprodCollection = new ArrayList<Orcamentoprod>();
            for (Orcamentoprod orcamentoprodCollectionOrcamentoprodToAttach : preco.getOrcamentoprodCollection()) {
                orcamentoprodCollectionOrcamentoprodToAttach = em.getReference(orcamentoprodCollectionOrcamentoprodToAttach.getClass(), orcamentoprodCollectionOrcamentoprodToAttach.getCodorcprod());
                attachedOrcamentoprodCollection.add(orcamentoprodCollectionOrcamentoprodToAttach);
            }
            preco.setOrcamentoprodCollection(attachedOrcamentoprodCollection);
            Collection<Clienteproduto> attachedClienteprodutoCollection = new ArrayList<Clienteproduto>();
            for (Clienteproduto clienteprodutoCollectionClienteprodutoToAttach : preco.getClienteprodutoCollection()) {
                clienteprodutoCollectionClienteprodutoToAttach = em.getReference(clienteprodutoCollectionClienteprodutoToAttach.getClass(), clienteprodutoCollectionClienteprodutoToAttach.getCodcliprod());
                attachedClienteprodutoCollection.add(clienteprodutoCollectionClienteprodutoToAttach);
            }
            preco.setClienteprodutoCollection(attachedClienteprodutoCollection);
            Collection<Cliente> attachedClienteCollection = new ArrayList<Cliente>();
            for (Cliente clienteCollectionClienteToAttach : preco.getClienteCollection()) {
                clienteCollectionClienteToAttach = em.getReference(clienteCollectionClienteToAttach.getClass(), clienteCollectionClienteToAttach.getCodcli());
                attachedClienteCollection.add(clienteCollectionClienteToAttach);
            }
            preco.setClienteCollection(attachedClienteCollection);
            em.persist(preco);
            for (Calculoicmsestado calculoicmsestadoCollectionCalculoicmsestado : preco.getCalculoicmsestadoCollection()) {
                Preco oldCodprecoOfCalculoicmsestadoCollectionCalculoicmsestado = calculoicmsestadoCollectionCalculoicmsestado.getCodpreco();
                calculoicmsestadoCollectionCalculoicmsestado.setCodpreco(preco);
                calculoicmsestadoCollectionCalculoicmsestado = em.merge(calculoicmsestadoCollectionCalculoicmsestado);
                if (oldCodprecoOfCalculoicmsestadoCollectionCalculoicmsestado != null) {
                    oldCodprecoOfCalculoicmsestadoCollectionCalculoicmsestado.getCalculoicmsestadoCollection().remove(calculoicmsestadoCollectionCalculoicmsestado);
                    oldCodprecoOfCalculoicmsestadoCollectionCalculoicmsestado = em.merge(oldCodprecoOfCalculoicmsestadoCollectionCalculoicmsestado);
                }
            }
            for (Calculoicmsestado calculoicmsestadoCollection1Calculoicmsestado : preco.getCalculoicmsestadoCollection1()) {
                Preco oldCodprecodistribuidorOfCalculoicmsestadoCollection1Calculoicmsestado = calculoicmsestadoCollection1Calculoicmsestado.getCodprecodistribuidor();
                calculoicmsestadoCollection1Calculoicmsestado.setCodprecodistribuidor(preco);
                calculoicmsestadoCollection1Calculoicmsestado = em.merge(calculoicmsestadoCollection1Calculoicmsestado);
                if (oldCodprecodistribuidorOfCalculoicmsestadoCollection1Calculoicmsestado != null) {
                    oldCodprecodistribuidorOfCalculoicmsestadoCollection1Calculoicmsestado.getCalculoicmsestadoCollection1().remove(calculoicmsestadoCollection1Calculoicmsestado);
                    oldCodprecodistribuidorOfCalculoicmsestadoCollection1Calculoicmsestado = em.merge(oldCodprecodistribuidorOfCalculoicmsestadoCollection1Calculoicmsestado);
                }
            }
            for (Produtopreco produtoprecoCollectionProdutopreco : preco.getProdutoprecoCollection()) {
                Preco oldCodprecoOfProdutoprecoCollectionProdutopreco = produtoprecoCollectionProdutopreco.getCodpreco();
                produtoprecoCollectionProdutopreco.setCodpreco(preco);
                produtoprecoCollectionProdutopreco = em.merge(produtoprecoCollectionProdutopreco);
                if (oldCodprecoOfProdutoprecoCollectionProdutopreco != null) {
                    oldCodprecoOfProdutoprecoCollectionProdutopreco.getProdutoprecoCollection().remove(produtoprecoCollectionProdutopreco);
                    oldCodprecoOfProdutoprecoCollectionProdutopreco = em.merge(oldCodprecoOfProdutoprecoCollectionProdutopreco);
                }
            }
            for (OsProdserv osProdservCollectionOsProdserv : preco.getOsProdservCollection()) {
                Preco oldCodprecoOfOsProdservCollectionOsProdserv = osProdservCollectionOsProdserv.getCodpreco();
                osProdservCollectionOsProdserv.setCodpreco(preco);
                osProdservCollectionOsProdserv = em.merge(osProdservCollectionOsProdserv);
                if (oldCodprecoOfOsProdservCollectionOsProdserv != null) {
                    oldCodprecoOfOsProdservCollectionOsProdserv.getOsProdservCollection().remove(osProdservCollectionOsProdserv);
                    oldCodprecoOfOsProdservCollectionOsProdserv = em.merge(oldCodprecoOfOsProdservCollectionOsProdserv);
                }
            }
            for (Reajusteprodutopreco reajusteprodutoprecoCollectionReajusteprodutopreco : preco.getReajusteprodutoprecoCollection()) {
                Preco oldCodprecoOfReajusteprodutoprecoCollectionReajusteprodutopreco = reajusteprodutoprecoCollectionReajusteprodutopreco.getCodpreco();
                reajusteprodutoprecoCollectionReajusteprodutopreco.setCodpreco(preco);
                reajusteprodutoprecoCollectionReajusteprodutopreco = em.merge(reajusteprodutoprecoCollectionReajusteprodutopreco);
                if (oldCodprecoOfReajusteprodutoprecoCollectionReajusteprodutopreco != null) {
                    oldCodprecoOfReajusteprodutoprecoCollectionReajusteprodutopreco.getReajusteprodutoprecoCollection().remove(reajusteprodutoprecoCollectionReajusteprodutopreco);
                    oldCodprecoOfReajusteprodutoprecoCollectionReajusteprodutopreco = em.merge(oldCodprecoOfReajusteprodutoprecoCollectionReajusteprodutopreco);
                }
            }
            for (Movendaprod movendaprodCollectionMovendaprod : preco.getMovendaprodCollection()) {
                Preco oldCodprecoOfMovendaprodCollectionMovendaprod = movendaprodCollectionMovendaprod.getCodpreco();
                movendaprodCollectionMovendaprod.setCodpreco(preco);
                movendaprodCollectionMovendaprod = em.merge(movendaprodCollectionMovendaprod);
                if (oldCodprecoOfMovendaprodCollectionMovendaprod != null) {
                    oldCodprecoOfMovendaprodCollectionMovendaprod.getMovendaprodCollection().remove(movendaprodCollectionMovendaprod);
                    oldCodprecoOfMovendaprodCollectionMovendaprod = em.merge(oldCodprecoOfMovendaprodCollectionMovendaprod);
                }
            }
            for (OsOrdemservico osOrdemservicoCollectionOsOrdemservico : preco.getOsOrdemservicoCollection()) {
                Preco oldCodprecoOfOsOrdemservicoCollectionOsOrdemservico = osOrdemservicoCollectionOsOrdemservico.getCodpreco();
                osOrdemservicoCollectionOsOrdemservico.setCodpreco(preco);
                osOrdemservicoCollectionOsOrdemservico = em.merge(osOrdemservicoCollectionOsOrdemservico);
                if (oldCodprecoOfOsOrdemservicoCollectionOsOrdemservico != null) {
                    oldCodprecoOfOsOrdemservicoCollectionOsOrdemservico.getOsOrdemservicoCollection().remove(osOrdemservicoCollectionOsOrdemservico);
                    oldCodprecoOfOsOrdemservicoCollectionOsOrdemservico = em.merge(oldCodprecoOfOsOrdemservicoCollectionOsOrdemservico);
                }
            }
            for (Usuariopreco usuarioprecoCollectionUsuariopreco : preco.getUsuarioprecoCollection()) {
                Preco oldCodprecoOfUsuarioprecoCollectionUsuariopreco = usuarioprecoCollectionUsuariopreco.getCodpreco();
                usuarioprecoCollectionUsuariopreco.setCodpreco(preco);
                usuarioprecoCollectionUsuariopreco = em.merge(usuarioprecoCollectionUsuariopreco);
                if (oldCodprecoOfUsuarioprecoCollectionUsuariopreco != null) {
                    oldCodprecoOfUsuarioprecoCollectionUsuariopreco.getUsuarioprecoCollection().remove(usuarioprecoCollectionUsuariopreco);
                    oldCodprecoOfUsuarioprecoCollectionUsuariopreco = em.merge(oldCodprecoOfUsuarioprecoCollectionUsuariopreco);
                }
            }
            for (Orcamento orcamentoCollectionOrcamento : preco.getOrcamentoCollection()) {
                Preco oldCodprecoOfOrcamentoCollectionOrcamento = orcamentoCollectionOrcamento.getCodpreco();
                orcamentoCollectionOrcamento.setCodpreco(preco);
                orcamentoCollectionOrcamento = em.merge(orcamentoCollectionOrcamento);
                if (oldCodprecoOfOrcamentoCollectionOrcamento != null) {
                    oldCodprecoOfOrcamentoCollectionOrcamento.getOrcamentoCollection().remove(orcamentoCollectionOrcamento);
                    oldCodprecoOfOrcamentoCollectionOrcamento = em.merge(oldCodprecoOfOrcamentoCollectionOrcamento);
                }
            }
            for (Produtoprecoescalonado produtoprecoescalonadoCollectionProdutoprecoescalonado : preco.getProdutoprecoescalonadoCollection()) {
                Preco oldCodprecoOfProdutoprecoescalonadoCollectionProdutoprecoescalonado = produtoprecoescalonadoCollectionProdutoprecoescalonado.getCodpreco();
                produtoprecoescalonadoCollectionProdutoprecoescalonado.setCodpreco(preco);
                produtoprecoescalonadoCollectionProdutoprecoescalonado = em.merge(produtoprecoescalonadoCollectionProdutoprecoescalonado);
                if (oldCodprecoOfProdutoprecoescalonadoCollectionProdutoprecoescalonado != null) {
                    oldCodprecoOfProdutoprecoescalonadoCollectionProdutoprecoescalonado.getProdutoprecoescalonadoCollection().remove(produtoprecoescalonadoCollectionProdutoprecoescalonado);
                    oldCodprecoOfProdutoprecoescalonadoCollectionProdutoprecoescalonado = em.merge(oldCodprecoOfProdutoprecoescalonadoCollectionProdutoprecoescalonado);
                }
            }
            for (Orcamentoprod orcamentoprodCollectionOrcamentoprod : preco.getOrcamentoprodCollection()) {
                Preco oldCodprecoOfOrcamentoprodCollectionOrcamentoprod = orcamentoprodCollectionOrcamentoprod.getCodpreco();
                orcamentoprodCollectionOrcamentoprod.setCodpreco(preco);
                orcamentoprodCollectionOrcamentoprod = em.merge(orcamentoprodCollectionOrcamentoprod);
                if (oldCodprecoOfOrcamentoprodCollectionOrcamentoprod != null) {
                    oldCodprecoOfOrcamentoprodCollectionOrcamentoprod.getOrcamentoprodCollection().remove(orcamentoprodCollectionOrcamentoprod);
                    oldCodprecoOfOrcamentoprodCollectionOrcamentoprod = em.merge(oldCodprecoOfOrcamentoprodCollectionOrcamentoprod);
                }
            }
            for (Clienteproduto clienteprodutoCollectionClienteproduto : preco.getClienteprodutoCollection()) {
                Preco oldCodprecoOfClienteprodutoCollectionClienteproduto = clienteprodutoCollectionClienteproduto.getCodpreco();
                clienteprodutoCollectionClienteproduto.setCodpreco(preco);
                clienteprodutoCollectionClienteproduto = em.merge(clienteprodutoCollectionClienteproduto);
                if (oldCodprecoOfClienteprodutoCollectionClienteproduto != null) {
                    oldCodprecoOfClienteprodutoCollectionClienteproduto.getClienteprodutoCollection().remove(clienteprodutoCollectionClienteproduto);
                    oldCodprecoOfClienteprodutoCollectionClienteproduto = em.merge(oldCodprecoOfClienteprodutoCollectionClienteproduto);
                }
            }
            for (Cliente clienteCollectionCliente : preco.getClienteCollection()) {
                Preco oldCodprecoOfClienteCollectionCliente = clienteCollectionCliente.getCodpreco();
                clienteCollectionCliente.setCodpreco(preco);
                clienteCollectionCliente = em.merge(clienteCollectionCliente);
                if (oldCodprecoOfClienteCollectionCliente != null) {
                    oldCodprecoOfClienteCollectionCliente.getClienteCollection().remove(clienteCollectionCliente);
                    oldCodprecoOfClienteCollectionCliente = em.merge(oldCodprecoOfClienteCollectionCliente);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPreco(preco.getCodpreco()) != null) {
                throw new PreexistingEntityException("Preco " + preco + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Preco preco) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Preco persistentPreco = em.find(Preco.class, preco.getCodpreco());
            Collection<Calculoicmsestado> calculoicmsestadoCollectionOld = persistentPreco.getCalculoicmsestadoCollection();
            Collection<Calculoicmsestado> calculoicmsestadoCollectionNew = preco.getCalculoicmsestadoCollection();
            Collection<Calculoicmsestado> calculoicmsestadoCollection1Old = persistentPreco.getCalculoicmsestadoCollection1();
            Collection<Calculoicmsestado> calculoicmsestadoCollection1New = preco.getCalculoicmsestadoCollection1();
            Collection<Produtopreco> produtoprecoCollectionOld = persistentPreco.getProdutoprecoCollection();
            Collection<Produtopreco> produtoprecoCollectionNew = preco.getProdutoprecoCollection();
            Collection<OsProdserv> osProdservCollectionOld = persistentPreco.getOsProdservCollection();
            Collection<OsProdserv> osProdservCollectionNew = preco.getOsProdservCollection();
            Collection<Reajusteprodutopreco> reajusteprodutoprecoCollectionOld = persistentPreco.getReajusteprodutoprecoCollection();
            Collection<Reajusteprodutopreco> reajusteprodutoprecoCollectionNew = preco.getReajusteprodutoprecoCollection();
            Collection<Movendaprod> movendaprodCollectionOld = persistentPreco.getMovendaprodCollection();
            Collection<Movendaprod> movendaprodCollectionNew = preco.getMovendaprodCollection();
            Collection<OsOrdemservico> osOrdemservicoCollectionOld = persistentPreco.getOsOrdemservicoCollection();
            Collection<OsOrdemservico> osOrdemservicoCollectionNew = preco.getOsOrdemservicoCollection();
            Collection<Usuariopreco> usuarioprecoCollectionOld = persistentPreco.getUsuarioprecoCollection();
            Collection<Usuariopreco> usuarioprecoCollectionNew = preco.getUsuarioprecoCollection();
            Collection<Orcamento> orcamentoCollectionOld = persistentPreco.getOrcamentoCollection();
            Collection<Orcamento> orcamentoCollectionNew = preco.getOrcamentoCollection();
            Collection<Produtoprecoescalonado> produtoprecoescalonadoCollectionOld = persistentPreco.getProdutoprecoescalonadoCollection();
            Collection<Produtoprecoescalonado> produtoprecoescalonadoCollectionNew = preco.getProdutoprecoescalonadoCollection();
            Collection<Orcamentoprod> orcamentoprodCollectionOld = persistentPreco.getOrcamentoprodCollection();
            Collection<Orcamentoprod> orcamentoprodCollectionNew = preco.getOrcamentoprodCollection();
            Collection<Clienteproduto> clienteprodutoCollectionOld = persistentPreco.getClienteprodutoCollection();
            Collection<Clienteproduto> clienteprodutoCollectionNew = preco.getClienteprodutoCollection();
            Collection<Cliente> clienteCollectionOld = persistentPreco.getClienteCollection();
            Collection<Cliente> clienteCollectionNew = preco.getClienteCollection();
            List<String> illegalOrphanMessages = null;
            for (Produtopreco produtoprecoCollectionOldProdutopreco : produtoprecoCollectionOld) {
                if (!produtoprecoCollectionNew.contains(produtoprecoCollectionOldProdutopreco)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Produtopreco " + produtoprecoCollectionOldProdutopreco + " since its codpreco field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Calculoicmsestado> attachedCalculoicmsestadoCollectionNew = new ArrayList<Calculoicmsestado>();
            for (Calculoicmsestado calculoicmsestadoCollectionNewCalculoicmsestadoToAttach : calculoicmsestadoCollectionNew) {
                calculoicmsestadoCollectionNewCalculoicmsestadoToAttach = em.getReference(calculoicmsestadoCollectionNewCalculoicmsestadoToAttach.getClass(), calculoicmsestadoCollectionNewCalculoicmsestadoToAttach.getCodcalculoicmsestado());
                attachedCalculoicmsestadoCollectionNew.add(calculoicmsestadoCollectionNewCalculoicmsestadoToAttach);
            }
            calculoicmsestadoCollectionNew = attachedCalculoicmsestadoCollectionNew;
            preco.setCalculoicmsestadoCollection(calculoicmsestadoCollectionNew);
            Collection<Calculoicmsestado> attachedCalculoicmsestadoCollection1New = new ArrayList<Calculoicmsestado>();
            for (Calculoicmsestado calculoicmsestadoCollection1NewCalculoicmsestadoToAttach : calculoicmsestadoCollection1New) {
                calculoicmsestadoCollection1NewCalculoicmsestadoToAttach = em.getReference(calculoicmsestadoCollection1NewCalculoicmsestadoToAttach.getClass(), calculoicmsestadoCollection1NewCalculoicmsestadoToAttach.getCodcalculoicmsestado());
                attachedCalculoicmsestadoCollection1New.add(calculoicmsestadoCollection1NewCalculoicmsestadoToAttach);
            }
            calculoicmsestadoCollection1New = attachedCalculoicmsestadoCollection1New;
            preco.setCalculoicmsestadoCollection1(calculoicmsestadoCollection1New);
            Collection<Produtopreco> attachedProdutoprecoCollectionNew = new ArrayList<Produtopreco>();
            for (Produtopreco produtoprecoCollectionNewProdutoprecoToAttach : produtoprecoCollectionNew) {
                produtoprecoCollectionNewProdutoprecoToAttach = em.getReference(produtoprecoCollectionNewProdutoprecoToAttach.getClass(), produtoprecoCollectionNewProdutoprecoToAttach.getCodprodutopreco());
                attachedProdutoprecoCollectionNew.add(produtoprecoCollectionNewProdutoprecoToAttach);
            }
            produtoprecoCollectionNew = attachedProdutoprecoCollectionNew;
            preco.setProdutoprecoCollection(produtoprecoCollectionNew);
            Collection<OsProdserv> attachedOsProdservCollectionNew = new ArrayList<OsProdserv>();
            for (OsProdserv osProdservCollectionNewOsProdservToAttach : osProdservCollectionNew) {
                osProdservCollectionNewOsProdservToAttach = em.getReference(osProdservCollectionNewOsProdservToAttach.getClass(), osProdservCollectionNewOsProdservToAttach.getCodprodserv());
                attachedOsProdservCollectionNew.add(osProdservCollectionNewOsProdservToAttach);
            }
            osProdservCollectionNew = attachedOsProdservCollectionNew;
            preco.setOsProdservCollection(osProdservCollectionNew);
            Collection<Reajusteprodutopreco> attachedReajusteprodutoprecoCollectionNew = new ArrayList<Reajusteprodutopreco>();
            for (Reajusteprodutopreco reajusteprodutoprecoCollectionNewReajusteprodutoprecoToAttach : reajusteprodutoprecoCollectionNew) {
                reajusteprodutoprecoCollectionNewReajusteprodutoprecoToAttach = em.getReference(reajusteprodutoprecoCollectionNewReajusteprodutoprecoToAttach.getClass(), reajusteprodutoprecoCollectionNewReajusteprodutoprecoToAttach.getCodreajusteprodutopreco());
                attachedReajusteprodutoprecoCollectionNew.add(reajusteprodutoprecoCollectionNewReajusteprodutoprecoToAttach);
            }
            reajusteprodutoprecoCollectionNew = attachedReajusteprodutoprecoCollectionNew;
            preco.setReajusteprodutoprecoCollection(reajusteprodutoprecoCollectionNew);
            Collection<Movendaprod> attachedMovendaprodCollectionNew = new ArrayList<Movendaprod>();
            for (Movendaprod movendaprodCollectionNewMovendaprodToAttach : movendaprodCollectionNew) {
                movendaprodCollectionNewMovendaprodToAttach = em.getReference(movendaprodCollectionNewMovendaprodToAttach.getClass(), movendaprodCollectionNewMovendaprodToAttach.getCodmovprod());
                attachedMovendaprodCollectionNew.add(movendaprodCollectionNewMovendaprodToAttach);
            }
            movendaprodCollectionNew = attachedMovendaprodCollectionNew;
            preco.setMovendaprodCollection(movendaprodCollectionNew);
            Collection<OsOrdemservico> attachedOsOrdemservicoCollectionNew = new ArrayList<OsOrdemservico>();
            for (OsOrdemservico osOrdemservicoCollectionNewOsOrdemservicoToAttach : osOrdemservicoCollectionNew) {
                osOrdemservicoCollectionNewOsOrdemservicoToAttach = em.getReference(osOrdemservicoCollectionNewOsOrdemservicoToAttach.getClass(), osOrdemservicoCollectionNewOsOrdemservicoToAttach.getCodos());
                attachedOsOrdemservicoCollectionNew.add(osOrdemservicoCollectionNewOsOrdemservicoToAttach);
            }
            osOrdemservicoCollectionNew = attachedOsOrdemservicoCollectionNew;
            preco.setOsOrdemservicoCollection(osOrdemservicoCollectionNew);
            Collection<Usuariopreco> attachedUsuarioprecoCollectionNew = new ArrayList<Usuariopreco>();
            for (Usuariopreco usuarioprecoCollectionNewUsuarioprecoToAttach : usuarioprecoCollectionNew) {
                usuarioprecoCollectionNewUsuarioprecoToAttach = em.getReference(usuarioprecoCollectionNewUsuarioprecoToAttach.getClass(), usuarioprecoCollectionNewUsuarioprecoToAttach.getCodusuariopreco());
                attachedUsuarioprecoCollectionNew.add(usuarioprecoCollectionNewUsuarioprecoToAttach);
            }
            usuarioprecoCollectionNew = attachedUsuarioprecoCollectionNew;
            preco.setUsuarioprecoCollection(usuarioprecoCollectionNew);
            Collection<Orcamento> attachedOrcamentoCollectionNew = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollectionNewOrcamentoToAttach : orcamentoCollectionNew) {
                orcamentoCollectionNewOrcamentoToAttach = em.getReference(orcamentoCollectionNewOrcamentoToAttach.getClass(), orcamentoCollectionNewOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollectionNew.add(orcamentoCollectionNewOrcamentoToAttach);
            }
            orcamentoCollectionNew = attachedOrcamentoCollectionNew;
            preco.setOrcamentoCollection(orcamentoCollectionNew);
            Collection<Produtoprecoescalonado> attachedProdutoprecoescalonadoCollectionNew = new ArrayList<Produtoprecoescalonado>();
            for (Produtoprecoescalonado produtoprecoescalonadoCollectionNewProdutoprecoescalonadoToAttach : produtoprecoescalonadoCollectionNew) {
                produtoprecoescalonadoCollectionNewProdutoprecoescalonadoToAttach = em.getReference(produtoprecoescalonadoCollectionNewProdutoprecoescalonadoToAttach.getClass(), produtoprecoescalonadoCollectionNewProdutoprecoescalonadoToAttach.getCodprodutoprecoescalonado());
                attachedProdutoprecoescalonadoCollectionNew.add(produtoprecoescalonadoCollectionNewProdutoprecoescalonadoToAttach);
            }
            produtoprecoescalonadoCollectionNew = attachedProdutoprecoescalonadoCollectionNew;
            preco.setProdutoprecoescalonadoCollection(produtoprecoescalonadoCollectionNew);
            Collection<Orcamentoprod> attachedOrcamentoprodCollectionNew = new ArrayList<Orcamentoprod>();
            for (Orcamentoprod orcamentoprodCollectionNewOrcamentoprodToAttach : orcamentoprodCollectionNew) {
                orcamentoprodCollectionNewOrcamentoprodToAttach = em.getReference(orcamentoprodCollectionNewOrcamentoprodToAttach.getClass(), orcamentoprodCollectionNewOrcamentoprodToAttach.getCodorcprod());
                attachedOrcamentoprodCollectionNew.add(orcamentoprodCollectionNewOrcamentoprodToAttach);
            }
            orcamentoprodCollectionNew = attachedOrcamentoprodCollectionNew;
            preco.setOrcamentoprodCollection(orcamentoprodCollectionNew);
            Collection<Clienteproduto> attachedClienteprodutoCollectionNew = new ArrayList<Clienteproduto>();
            for (Clienteproduto clienteprodutoCollectionNewClienteprodutoToAttach : clienteprodutoCollectionNew) {
                clienteprodutoCollectionNewClienteprodutoToAttach = em.getReference(clienteprodutoCollectionNewClienteprodutoToAttach.getClass(), clienteprodutoCollectionNewClienteprodutoToAttach.getCodcliprod());
                attachedClienteprodutoCollectionNew.add(clienteprodutoCollectionNewClienteprodutoToAttach);
            }
            clienteprodutoCollectionNew = attachedClienteprodutoCollectionNew;
            preco.setClienteprodutoCollection(clienteprodutoCollectionNew);
            Collection<Cliente> attachedClienteCollectionNew = new ArrayList<Cliente>();
            for (Cliente clienteCollectionNewClienteToAttach : clienteCollectionNew) {
                clienteCollectionNewClienteToAttach = em.getReference(clienteCollectionNewClienteToAttach.getClass(), clienteCollectionNewClienteToAttach.getCodcli());
                attachedClienteCollectionNew.add(clienteCollectionNewClienteToAttach);
            }
            clienteCollectionNew = attachedClienteCollectionNew;
            preco.setClienteCollection(clienteCollectionNew);
            preco = em.merge(preco);
            for (Calculoicmsestado calculoicmsestadoCollectionOldCalculoicmsestado : calculoicmsestadoCollectionOld) {
                if (!calculoicmsestadoCollectionNew.contains(calculoicmsestadoCollectionOldCalculoicmsestado)) {
                    calculoicmsestadoCollectionOldCalculoicmsestado.setCodpreco(null);
                    calculoicmsestadoCollectionOldCalculoicmsestado = em.merge(calculoicmsestadoCollectionOldCalculoicmsestado);
                }
            }
            for (Calculoicmsestado calculoicmsestadoCollectionNewCalculoicmsestado : calculoicmsestadoCollectionNew) {
                if (!calculoicmsestadoCollectionOld.contains(calculoicmsestadoCollectionNewCalculoicmsestado)) {
                    Preco oldCodprecoOfCalculoicmsestadoCollectionNewCalculoicmsestado = calculoicmsestadoCollectionNewCalculoicmsestado.getCodpreco();
                    calculoicmsestadoCollectionNewCalculoicmsestado.setCodpreco(preco);
                    calculoicmsestadoCollectionNewCalculoicmsestado = em.merge(calculoicmsestadoCollectionNewCalculoicmsestado);
                    if (oldCodprecoOfCalculoicmsestadoCollectionNewCalculoicmsestado != null && !oldCodprecoOfCalculoicmsestadoCollectionNewCalculoicmsestado.equals(preco)) {
                        oldCodprecoOfCalculoicmsestadoCollectionNewCalculoicmsestado.getCalculoicmsestadoCollection().remove(calculoicmsestadoCollectionNewCalculoicmsestado);
                        oldCodprecoOfCalculoicmsestadoCollectionNewCalculoicmsestado = em.merge(oldCodprecoOfCalculoicmsestadoCollectionNewCalculoicmsestado);
                    }
                }
            }
            for (Calculoicmsestado calculoicmsestadoCollection1OldCalculoicmsestado : calculoicmsestadoCollection1Old) {
                if (!calculoicmsestadoCollection1New.contains(calculoicmsestadoCollection1OldCalculoicmsestado)) {
                    calculoicmsestadoCollection1OldCalculoicmsestado.setCodprecodistribuidor(null);
                    calculoicmsestadoCollection1OldCalculoicmsestado = em.merge(calculoicmsestadoCollection1OldCalculoicmsestado);
                }
            }
            for (Calculoicmsestado calculoicmsestadoCollection1NewCalculoicmsestado : calculoicmsestadoCollection1New) {
                if (!calculoicmsestadoCollection1Old.contains(calculoicmsestadoCollection1NewCalculoicmsestado)) {
                    Preco oldCodprecodistribuidorOfCalculoicmsestadoCollection1NewCalculoicmsestado = calculoicmsestadoCollection1NewCalculoicmsestado.getCodprecodistribuidor();
                    calculoicmsestadoCollection1NewCalculoicmsestado.setCodprecodistribuidor(preco);
                    calculoicmsestadoCollection1NewCalculoicmsestado = em.merge(calculoicmsestadoCollection1NewCalculoicmsestado);
                    if (oldCodprecodistribuidorOfCalculoicmsestadoCollection1NewCalculoicmsestado != null && !oldCodprecodistribuidorOfCalculoicmsestadoCollection1NewCalculoicmsestado.equals(preco)) {
                        oldCodprecodistribuidorOfCalculoicmsestadoCollection1NewCalculoicmsestado.getCalculoicmsestadoCollection1().remove(calculoicmsestadoCollection1NewCalculoicmsestado);
                        oldCodprecodistribuidorOfCalculoicmsestadoCollection1NewCalculoicmsestado = em.merge(oldCodprecodistribuidorOfCalculoicmsestadoCollection1NewCalculoicmsestado);
                    }
                }
            }
            for (Produtopreco produtoprecoCollectionNewProdutopreco : produtoprecoCollectionNew) {
                if (!produtoprecoCollectionOld.contains(produtoprecoCollectionNewProdutopreco)) {
                    Preco oldCodprecoOfProdutoprecoCollectionNewProdutopreco = produtoprecoCollectionNewProdutopreco.getCodpreco();
                    produtoprecoCollectionNewProdutopreco.setCodpreco(preco);
                    produtoprecoCollectionNewProdutopreco = em.merge(produtoprecoCollectionNewProdutopreco);
                    if (oldCodprecoOfProdutoprecoCollectionNewProdutopreco != null && !oldCodprecoOfProdutoprecoCollectionNewProdutopreco.equals(preco)) {
                        oldCodprecoOfProdutoprecoCollectionNewProdutopreco.getProdutoprecoCollection().remove(produtoprecoCollectionNewProdutopreco);
                        oldCodprecoOfProdutoprecoCollectionNewProdutopreco = em.merge(oldCodprecoOfProdutoprecoCollectionNewProdutopreco);
                    }
                }
            }
            for (OsProdserv osProdservCollectionOldOsProdserv : osProdservCollectionOld) {
                if (!osProdservCollectionNew.contains(osProdservCollectionOldOsProdserv)) {
                    osProdservCollectionOldOsProdserv.setCodpreco(null);
                    osProdservCollectionOldOsProdserv = em.merge(osProdservCollectionOldOsProdserv);
                }
            }
            for (OsProdserv osProdservCollectionNewOsProdserv : osProdservCollectionNew) {
                if (!osProdservCollectionOld.contains(osProdservCollectionNewOsProdserv)) {
                    Preco oldCodprecoOfOsProdservCollectionNewOsProdserv = osProdservCollectionNewOsProdserv.getCodpreco();
                    osProdservCollectionNewOsProdserv.setCodpreco(preco);
                    osProdservCollectionNewOsProdserv = em.merge(osProdservCollectionNewOsProdserv);
                    if (oldCodprecoOfOsProdservCollectionNewOsProdserv != null && !oldCodprecoOfOsProdservCollectionNewOsProdserv.equals(preco)) {
                        oldCodprecoOfOsProdservCollectionNewOsProdserv.getOsProdservCollection().remove(osProdservCollectionNewOsProdserv);
                        oldCodprecoOfOsProdservCollectionNewOsProdserv = em.merge(oldCodprecoOfOsProdservCollectionNewOsProdserv);
                    }
                }
            }
            for (Reajusteprodutopreco reajusteprodutoprecoCollectionOldReajusteprodutopreco : reajusteprodutoprecoCollectionOld) {
                if (!reajusteprodutoprecoCollectionNew.contains(reajusteprodutoprecoCollectionOldReajusteprodutopreco)) {
                    reajusteprodutoprecoCollectionOldReajusteprodutopreco.setCodpreco(null);
                    reajusteprodutoprecoCollectionOldReajusteprodutopreco = em.merge(reajusteprodutoprecoCollectionOldReajusteprodutopreco);
                }
            }
            for (Reajusteprodutopreco reajusteprodutoprecoCollectionNewReajusteprodutopreco : reajusteprodutoprecoCollectionNew) {
                if (!reajusteprodutoprecoCollectionOld.contains(reajusteprodutoprecoCollectionNewReajusteprodutopreco)) {
                    Preco oldCodprecoOfReajusteprodutoprecoCollectionNewReajusteprodutopreco = reajusteprodutoprecoCollectionNewReajusteprodutopreco.getCodpreco();
                    reajusteprodutoprecoCollectionNewReajusteprodutopreco.setCodpreco(preco);
                    reajusteprodutoprecoCollectionNewReajusteprodutopreco = em.merge(reajusteprodutoprecoCollectionNewReajusteprodutopreco);
                    if (oldCodprecoOfReajusteprodutoprecoCollectionNewReajusteprodutopreco != null && !oldCodprecoOfReajusteprodutoprecoCollectionNewReajusteprodutopreco.equals(preco)) {
                        oldCodprecoOfReajusteprodutoprecoCollectionNewReajusteprodutopreco.getReajusteprodutoprecoCollection().remove(reajusteprodutoprecoCollectionNewReajusteprodutopreco);
                        oldCodprecoOfReajusteprodutoprecoCollectionNewReajusteprodutopreco = em.merge(oldCodprecoOfReajusteprodutoprecoCollectionNewReajusteprodutopreco);
                    }
                }
            }
            for (Movendaprod movendaprodCollectionOldMovendaprod : movendaprodCollectionOld) {
                if (!movendaprodCollectionNew.contains(movendaprodCollectionOldMovendaprod)) {
                    movendaprodCollectionOldMovendaprod.setCodpreco(null);
                    movendaprodCollectionOldMovendaprod = em.merge(movendaprodCollectionOldMovendaprod);
                }
            }
            for (Movendaprod movendaprodCollectionNewMovendaprod : movendaprodCollectionNew) {
                if (!movendaprodCollectionOld.contains(movendaprodCollectionNewMovendaprod)) {
                    Preco oldCodprecoOfMovendaprodCollectionNewMovendaprod = movendaprodCollectionNewMovendaprod.getCodpreco();
                    movendaprodCollectionNewMovendaprod.setCodpreco(preco);
                    movendaprodCollectionNewMovendaprod = em.merge(movendaprodCollectionNewMovendaprod);
                    if (oldCodprecoOfMovendaprodCollectionNewMovendaprod != null && !oldCodprecoOfMovendaprodCollectionNewMovendaprod.equals(preco)) {
                        oldCodprecoOfMovendaprodCollectionNewMovendaprod.getMovendaprodCollection().remove(movendaprodCollectionNewMovendaprod);
                        oldCodprecoOfMovendaprodCollectionNewMovendaprod = em.merge(oldCodprecoOfMovendaprodCollectionNewMovendaprod);
                    }
                }
            }
            for (OsOrdemservico osOrdemservicoCollectionOldOsOrdemservico : osOrdemservicoCollectionOld) {
                if (!osOrdemservicoCollectionNew.contains(osOrdemservicoCollectionOldOsOrdemservico)) {
                    osOrdemservicoCollectionOldOsOrdemservico.setCodpreco(null);
                    osOrdemservicoCollectionOldOsOrdemservico = em.merge(osOrdemservicoCollectionOldOsOrdemservico);
                }
            }
            for (OsOrdemservico osOrdemservicoCollectionNewOsOrdemservico : osOrdemservicoCollectionNew) {
                if (!osOrdemservicoCollectionOld.contains(osOrdemservicoCollectionNewOsOrdemservico)) {
                    Preco oldCodprecoOfOsOrdemservicoCollectionNewOsOrdemservico = osOrdemservicoCollectionNewOsOrdemservico.getCodpreco();
                    osOrdemservicoCollectionNewOsOrdemservico.setCodpreco(preco);
                    osOrdemservicoCollectionNewOsOrdemservico = em.merge(osOrdemservicoCollectionNewOsOrdemservico);
                    if (oldCodprecoOfOsOrdemservicoCollectionNewOsOrdemservico != null && !oldCodprecoOfOsOrdemservicoCollectionNewOsOrdemservico.equals(preco)) {
                        oldCodprecoOfOsOrdemservicoCollectionNewOsOrdemservico.getOsOrdemservicoCollection().remove(osOrdemservicoCollectionNewOsOrdemservico);
                        oldCodprecoOfOsOrdemservicoCollectionNewOsOrdemservico = em.merge(oldCodprecoOfOsOrdemservicoCollectionNewOsOrdemservico);
                    }
                }
            }
            for (Usuariopreco usuarioprecoCollectionOldUsuariopreco : usuarioprecoCollectionOld) {
                if (!usuarioprecoCollectionNew.contains(usuarioprecoCollectionOldUsuariopreco)) {
                    usuarioprecoCollectionOldUsuariopreco.setCodpreco(null);
                    usuarioprecoCollectionOldUsuariopreco = em.merge(usuarioprecoCollectionOldUsuariopreco);
                }
            }
            for (Usuariopreco usuarioprecoCollectionNewUsuariopreco : usuarioprecoCollectionNew) {
                if (!usuarioprecoCollectionOld.contains(usuarioprecoCollectionNewUsuariopreco)) {
                    Preco oldCodprecoOfUsuarioprecoCollectionNewUsuariopreco = usuarioprecoCollectionNewUsuariopreco.getCodpreco();
                    usuarioprecoCollectionNewUsuariopreco.setCodpreco(preco);
                    usuarioprecoCollectionNewUsuariopreco = em.merge(usuarioprecoCollectionNewUsuariopreco);
                    if (oldCodprecoOfUsuarioprecoCollectionNewUsuariopreco != null && !oldCodprecoOfUsuarioprecoCollectionNewUsuariopreco.equals(preco)) {
                        oldCodprecoOfUsuarioprecoCollectionNewUsuariopreco.getUsuarioprecoCollection().remove(usuarioprecoCollectionNewUsuariopreco);
                        oldCodprecoOfUsuarioprecoCollectionNewUsuariopreco = em.merge(oldCodprecoOfUsuarioprecoCollectionNewUsuariopreco);
                    }
                }
            }
            for (Orcamento orcamentoCollectionOldOrcamento : orcamentoCollectionOld) {
                if (!orcamentoCollectionNew.contains(orcamentoCollectionOldOrcamento)) {
                    orcamentoCollectionOldOrcamento.setCodpreco(null);
                    orcamentoCollectionOldOrcamento = em.merge(orcamentoCollectionOldOrcamento);
                }
            }
            for (Orcamento orcamentoCollectionNewOrcamento : orcamentoCollectionNew) {
                if (!orcamentoCollectionOld.contains(orcamentoCollectionNewOrcamento)) {
                    Preco oldCodprecoOfOrcamentoCollectionNewOrcamento = orcamentoCollectionNewOrcamento.getCodpreco();
                    orcamentoCollectionNewOrcamento.setCodpreco(preco);
                    orcamentoCollectionNewOrcamento = em.merge(orcamentoCollectionNewOrcamento);
                    if (oldCodprecoOfOrcamentoCollectionNewOrcamento != null && !oldCodprecoOfOrcamentoCollectionNewOrcamento.equals(preco)) {
                        oldCodprecoOfOrcamentoCollectionNewOrcamento.getOrcamentoCollection().remove(orcamentoCollectionNewOrcamento);
                        oldCodprecoOfOrcamentoCollectionNewOrcamento = em.merge(oldCodprecoOfOrcamentoCollectionNewOrcamento);
                    }
                }
            }
            for (Produtoprecoescalonado produtoprecoescalonadoCollectionOldProdutoprecoescalonado : produtoprecoescalonadoCollectionOld) {
                if (!produtoprecoescalonadoCollectionNew.contains(produtoprecoescalonadoCollectionOldProdutoprecoescalonado)) {
                    produtoprecoescalonadoCollectionOldProdutoprecoescalonado.setCodpreco(null);
                    produtoprecoescalonadoCollectionOldProdutoprecoescalonado = em.merge(produtoprecoescalonadoCollectionOldProdutoprecoescalonado);
                }
            }
            for (Produtoprecoescalonado produtoprecoescalonadoCollectionNewProdutoprecoescalonado : produtoprecoescalonadoCollectionNew) {
                if (!produtoprecoescalonadoCollectionOld.contains(produtoprecoescalonadoCollectionNewProdutoprecoescalonado)) {
                    Preco oldCodprecoOfProdutoprecoescalonadoCollectionNewProdutoprecoescalonado = produtoprecoescalonadoCollectionNewProdutoprecoescalonado.getCodpreco();
                    produtoprecoescalonadoCollectionNewProdutoprecoescalonado.setCodpreco(preco);
                    produtoprecoescalonadoCollectionNewProdutoprecoescalonado = em.merge(produtoprecoescalonadoCollectionNewProdutoprecoescalonado);
                    if (oldCodprecoOfProdutoprecoescalonadoCollectionNewProdutoprecoescalonado != null && !oldCodprecoOfProdutoprecoescalonadoCollectionNewProdutoprecoescalonado.equals(preco)) {
                        oldCodprecoOfProdutoprecoescalonadoCollectionNewProdutoprecoescalonado.getProdutoprecoescalonadoCollection().remove(produtoprecoescalonadoCollectionNewProdutoprecoescalonado);
                        oldCodprecoOfProdutoprecoescalonadoCollectionNewProdutoprecoescalonado = em.merge(oldCodprecoOfProdutoprecoescalonadoCollectionNewProdutoprecoescalonado);
                    }
                }
            }
            for (Orcamentoprod orcamentoprodCollectionOldOrcamentoprod : orcamentoprodCollectionOld) {
                if (!orcamentoprodCollectionNew.contains(orcamentoprodCollectionOldOrcamentoprod)) {
                    orcamentoprodCollectionOldOrcamentoprod.setCodpreco(null);
                    orcamentoprodCollectionOldOrcamentoprod = em.merge(orcamentoprodCollectionOldOrcamentoprod);
                }
            }
            for (Orcamentoprod orcamentoprodCollectionNewOrcamentoprod : orcamentoprodCollectionNew) {
                if (!orcamentoprodCollectionOld.contains(orcamentoprodCollectionNewOrcamentoprod)) {
                    Preco oldCodprecoOfOrcamentoprodCollectionNewOrcamentoprod = orcamentoprodCollectionNewOrcamentoprod.getCodpreco();
                    orcamentoprodCollectionNewOrcamentoprod.setCodpreco(preco);
                    orcamentoprodCollectionNewOrcamentoprod = em.merge(orcamentoprodCollectionNewOrcamentoprod);
                    if (oldCodprecoOfOrcamentoprodCollectionNewOrcamentoprod != null && !oldCodprecoOfOrcamentoprodCollectionNewOrcamentoprod.equals(preco)) {
                        oldCodprecoOfOrcamentoprodCollectionNewOrcamentoprod.getOrcamentoprodCollection().remove(orcamentoprodCollectionNewOrcamentoprod);
                        oldCodprecoOfOrcamentoprodCollectionNewOrcamentoprod = em.merge(oldCodprecoOfOrcamentoprodCollectionNewOrcamentoprod);
                    }
                }
            }
            for (Clienteproduto clienteprodutoCollectionOldClienteproduto : clienteprodutoCollectionOld) {
                if (!clienteprodutoCollectionNew.contains(clienteprodutoCollectionOldClienteproduto)) {
                    clienteprodutoCollectionOldClienteproduto.setCodpreco(null);
                    clienteprodutoCollectionOldClienteproduto = em.merge(clienteprodutoCollectionOldClienteproduto);
                }
            }
            for (Clienteproduto clienteprodutoCollectionNewClienteproduto : clienteprodutoCollectionNew) {
                if (!clienteprodutoCollectionOld.contains(clienteprodutoCollectionNewClienteproduto)) {
                    Preco oldCodprecoOfClienteprodutoCollectionNewClienteproduto = clienteprodutoCollectionNewClienteproduto.getCodpreco();
                    clienteprodutoCollectionNewClienteproduto.setCodpreco(preco);
                    clienteprodutoCollectionNewClienteproduto = em.merge(clienteprodutoCollectionNewClienteproduto);
                    if (oldCodprecoOfClienteprodutoCollectionNewClienteproduto != null && !oldCodprecoOfClienteprodutoCollectionNewClienteproduto.equals(preco)) {
                        oldCodprecoOfClienteprodutoCollectionNewClienteproduto.getClienteprodutoCollection().remove(clienteprodutoCollectionNewClienteproduto);
                        oldCodprecoOfClienteprodutoCollectionNewClienteproduto = em.merge(oldCodprecoOfClienteprodutoCollectionNewClienteproduto);
                    }
                }
            }
            for (Cliente clienteCollectionOldCliente : clienteCollectionOld) {
                if (!clienteCollectionNew.contains(clienteCollectionOldCliente)) {
                    clienteCollectionOldCliente.setCodpreco(null);
                    clienteCollectionOldCliente = em.merge(clienteCollectionOldCliente);
                }
            }
            for (Cliente clienteCollectionNewCliente : clienteCollectionNew) {
                if (!clienteCollectionOld.contains(clienteCollectionNewCliente)) {
                    Preco oldCodprecoOfClienteCollectionNewCliente = clienteCollectionNewCliente.getCodpreco();
                    clienteCollectionNewCliente.setCodpreco(preco);
                    clienteCollectionNewCliente = em.merge(clienteCollectionNewCliente);
                    if (oldCodprecoOfClienteCollectionNewCliente != null && !oldCodprecoOfClienteCollectionNewCliente.equals(preco)) {
                        oldCodprecoOfClienteCollectionNewCliente.getClienteCollection().remove(clienteCollectionNewCliente);
                        oldCodprecoOfClienteCollectionNewCliente = em.merge(oldCodprecoOfClienteCollectionNewCliente);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = preco.getCodpreco();
                if (findPreco(id) == null) {
                    throw new NonexistentEntityException("The preco with id " + id + " no longer exists.");
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
            Preco preco;
            try {
                preco = em.getReference(Preco.class, id);
                preco.getCodpreco();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The preco with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Produtopreco> produtoprecoCollectionOrphanCheck = preco.getProdutoprecoCollection();
            for (Produtopreco produtoprecoCollectionOrphanCheckProdutopreco : produtoprecoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Preco (" + preco + ") cannot be destroyed since the Produtopreco " + produtoprecoCollectionOrphanCheckProdutopreco + " in its produtoprecoCollection field has a non-nullable codpreco field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Calculoicmsestado> calculoicmsestadoCollection = preco.getCalculoicmsestadoCollection();
            for (Calculoicmsestado calculoicmsestadoCollectionCalculoicmsestado : calculoicmsestadoCollection) {
                calculoicmsestadoCollectionCalculoicmsestado.setCodpreco(null);
                calculoicmsestadoCollectionCalculoicmsestado = em.merge(calculoicmsestadoCollectionCalculoicmsestado);
            }
            Collection<Calculoicmsestado> calculoicmsestadoCollection1 = preco.getCalculoicmsestadoCollection1();
            for (Calculoicmsestado calculoicmsestadoCollection1Calculoicmsestado : calculoicmsestadoCollection1) {
                calculoicmsestadoCollection1Calculoicmsestado.setCodprecodistribuidor(null);
                calculoicmsestadoCollection1Calculoicmsestado = em.merge(calculoicmsestadoCollection1Calculoicmsestado);
            }
            Collection<OsProdserv> osProdservCollection = preco.getOsProdservCollection();
            for (OsProdserv osProdservCollectionOsProdserv : osProdservCollection) {
                osProdservCollectionOsProdserv.setCodpreco(null);
                osProdservCollectionOsProdserv = em.merge(osProdservCollectionOsProdserv);
            }
            Collection<Reajusteprodutopreco> reajusteprodutoprecoCollection = preco.getReajusteprodutoprecoCollection();
            for (Reajusteprodutopreco reajusteprodutoprecoCollectionReajusteprodutopreco : reajusteprodutoprecoCollection) {
                reajusteprodutoprecoCollectionReajusteprodutopreco.setCodpreco(null);
                reajusteprodutoprecoCollectionReajusteprodutopreco = em.merge(reajusteprodutoprecoCollectionReajusteprodutopreco);
            }
            Collection<Movendaprod> movendaprodCollection = preco.getMovendaprodCollection();
            for (Movendaprod movendaprodCollectionMovendaprod : movendaprodCollection) {
                movendaprodCollectionMovendaprod.setCodpreco(null);
                movendaprodCollectionMovendaprod = em.merge(movendaprodCollectionMovendaprod);
            }
            Collection<OsOrdemservico> osOrdemservicoCollection = preco.getOsOrdemservicoCollection();
            for (OsOrdemservico osOrdemservicoCollectionOsOrdemservico : osOrdemservicoCollection) {
                osOrdemservicoCollectionOsOrdemservico.setCodpreco(null);
                osOrdemservicoCollectionOsOrdemservico = em.merge(osOrdemservicoCollectionOsOrdemservico);
            }
            Collection<Usuariopreco> usuarioprecoCollection = preco.getUsuarioprecoCollection();
            for (Usuariopreco usuarioprecoCollectionUsuariopreco : usuarioprecoCollection) {
                usuarioprecoCollectionUsuariopreco.setCodpreco(null);
                usuarioprecoCollectionUsuariopreco = em.merge(usuarioprecoCollectionUsuariopreco);
            }
            Collection<Orcamento> orcamentoCollection = preco.getOrcamentoCollection();
            for (Orcamento orcamentoCollectionOrcamento : orcamentoCollection) {
                orcamentoCollectionOrcamento.setCodpreco(null);
                orcamentoCollectionOrcamento = em.merge(orcamentoCollectionOrcamento);
            }
            Collection<Produtoprecoescalonado> produtoprecoescalonadoCollection = preco.getProdutoprecoescalonadoCollection();
            for (Produtoprecoescalonado produtoprecoescalonadoCollectionProdutoprecoescalonado : produtoprecoescalonadoCollection) {
                produtoprecoescalonadoCollectionProdutoprecoescalonado.setCodpreco(null);
                produtoprecoescalonadoCollectionProdutoprecoescalonado = em.merge(produtoprecoescalonadoCollectionProdutoprecoescalonado);
            }
            Collection<Orcamentoprod> orcamentoprodCollection = preco.getOrcamentoprodCollection();
            for (Orcamentoprod orcamentoprodCollectionOrcamentoprod : orcamentoprodCollection) {
                orcamentoprodCollectionOrcamentoprod.setCodpreco(null);
                orcamentoprodCollectionOrcamentoprod = em.merge(orcamentoprodCollectionOrcamentoprod);
            }
            Collection<Clienteproduto> clienteprodutoCollection = preco.getClienteprodutoCollection();
            for (Clienteproduto clienteprodutoCollectionClienteproduto : clienteprodutoCollection) {
                clienteprodutoCollectionClienteproduto.setCodpreco(null);
                clienteprodutoCollectionClienteproduto = em.merge(clienteprodutoCollectionClienteproduto);
            }
            Collection<Cliente> clienteCollection = preco.getClienteCollection();
            for (Cliente clienteCollectionCliente : clienteCollection) {
                clienteCollectionCliente.setCodpreco(null);
                clienteCollectionCliente = em.merge(clienteCollectionCliente);
            }
            em.remove(preco);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Preco> findPrecoEntities() {
        return findPrecoEntities(true, -1, -1);
    }

    public List<Preco> findPrecoEntities(int maxResults, int firstResult) {
        return findPrecoEntities(false, maxResults, firstResult);
    }

    private List<Preco> findPrecoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Preco.class));
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

    public Preco findPreco(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Preco.class, id);
        } finally {
            em.close();
        }
    }

    public int getPrecoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Preco> rt = cq.from(Preco.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

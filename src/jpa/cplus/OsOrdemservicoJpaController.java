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
import entidade.cplus.Clienteendereco;
import entidade.cplus.Clienteequipamento;
import entidade.cplus.Empresa;
import entidade.cplus.Moventradaprod;
import entidade.cplus.Preco;
import entidade.cplus.OsLaudo;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.OsProdserv;
import entidade.cplus.OsStatushistorico;
import entidade.cplus.OsImagens;
import entidade.cplus.OsPesquisa;
import entidade.cplus.Orcamento;
import entidade.cplus.OsOrdemservico;
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
public class OsOrdemservicoJpaController implements Serializable {

    public OsOrdemservicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OsOrdemservico osOrdemservico) throws PreexistingEntityException, Exception {
        if (osOrdemservico.getOsLaudoCollection() == null) {
            osOrdemservico.setOsLaudoCollection(new ArrayList<OsLaudo>());
        }
        if (osOrdemservico.getOsProdservCollection() == null) {
            osOrdemservico.setOsProdservCollection(new ArrayList<OsProdserv>());
        }
        if (osOrdemservico.getOsStatushistoricoCollection() == null) {
            osOrdemservico.setOsStatushistoricoCollection(new ArrayList<OsStatushistorico>());
        }
        if (osOrdemservico.getOsImagensCollection() == null) {
            osOrdemservico.setOsImagensCollection(new ArrayList<OsImagens>());
        }
        if (osOrdemservico.getOsPesquisaCollection() == null) {
            osOrdemservico.setOsPesquisaCollection(new ArrayList<OsPesquisa>());
        }
        if (osOrdemservico.getOrcamentoCollection() == null) {
            osOrdemservico.setOrcamentoCollection(new ArrayList<Orcamento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente codcli = osOrdemservico.getCodcli();
            if (codcli != null) {
                codcli = em.getReference(codcli.getClass(), codcli.getCodcli());
                osOrdemservico.setCodcli(codcli);
            }
            Clienteendereco codclienteendereco = osOrdemservico.getCodclienteendereco();
            if (codclienteendereco != null) {
                codclienteendereco = em.getReference(codclienteendereco.getClass(), codclienteendereco.getCodclienteendereco());
                osOrdemservico.setCodclienteendereco(codclienteendereco);
            }
            Clienteequipamento codclienteequipamento = osOrdemservico.getCodclienteequipamento();
            if (codclienteequipamento != null) {
                codclienteequipamento = em.getReference(codclienteequipamento.getClass(), codclienteequipamento.getCodclienteequipamento());
                osOrdemservico.setCodclienteequipamento(codclienteequipamento);
            }
            Empresa codempresa = osOrdemservico.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                osOrdemservico.setCodempresa(codempresa);
            }
            Moventradaprod codmoveprod = osOrdemservico.getCodmoveprod();
            if (codmoveprod != null) {
                codmoveprod = em.getReference(codmoveprod.getClass(), codmoveprod.getCodmoveprod());
                osOrdemservico.setCodmoveprod(codmoveprod);
            }
            Preco codpreco = osOrdemservico.getCodpreco();
            if (codpreco != null) {
                codpreco = em.getReference(codpreco.getClass(), codpreco.getCodpreco());
                osOrdemservico.setCodpreco(codpreco);
            }
            Collection<OsLaudo> attachedOsLaudoCollection = new ArrayList<OsLaudo>();
            for (OsLaudo osLaudoCollectionOsLaudoToAttach : osOrdemservico.getOsLaudoCollection()) {
                osLaudoCollectionOsLaudoToAttach = em.getReference(osLaudoCollectionOsLaudoToAttach.getClass(), osLaudoCollectionOsLaudoToAttach.getCodlaudo());
                attachedOsLaudoCollection.add(osLaudoCollectionOsLaudoToAttach);
            }
            osOrdemservico.setOsLaudoCollection(attachedOsLaudoCollection);
            Collection<OsProdserv> attachedOsProdservCollection = new ArrayList<OsProdserv>();
            for (OsProdserv osProdservCollectionOsProdservToAttach : osOrdemservico.getOsProdservCollection()) {
                osProdservCollectionOsProdservToAttach = em.getReference(osProdservCollectionOsProdservToAttach.getClass(), osProdservCollectionOsProdservToAttach.getCodprodserv());
                attachedOsProdservCollection.add(osProdservCollectionOsProdservToAttach);
            }
            osOrdemservico.setOsProdservCollection(attachedOsProdservCollection);
            Collection<OsStatushistorico> attachedOsStatushistoricoCollection = new ArrayList<OsStatushistorico>();
            for (OsStatushistorico osStatushistoricoCollectionOsStatushistoricoToAttach : osOrdemservico.getOsStatushistoricoCollection()) {
                osStatushistoricoCollectionOsStatushistoricoToAttach = em.getReference(osStatushistoricoCollectionOsStatushistoricoToAttach.getClass(), osStatushistoricoCollectionOsStatushistoricoToAttach.getCodstatushistorico());
                attachedOsStatushistoricoCollection.add(osStatushistoricoCollectionOsStatushistoricoToAttach);
            }
            osOrdemservico.setOsStatushistoricoCollection(attachedOsStatushistoricoCollection);
            Collection<OsImagens> attachedOsImagensCollection = new ArrayList<OsImagens>();
            for (OsImagens osImagensCollectionOsImagensToAttach : osOrdemservico.getOsImagensCollection()) {
                osImagensCollectionOsImagensToAttach = em.getReference(osImagensCollectionOsImagensToAttach.getClass(), osImagensCollectionOsImagensToAttach.getCodimgos());
                attachedOsImagensCollection.add(osImagensCollectionOsImagensToAttach);
            }
            osOrdemservico.setOsImagensCollection(attachedOsImagensCollection);
            Collection<OsPesquisa> attachedOsPesquisaCollection = new ArrayList<OsPesquisa>();
            for (OsPesquisa osPesquisaCollectionOsPesquisaToAttach : osOrdemservico.getOsPesquisaCollection()) {
                osPesquisaCollectionOsPesquisaToAttach = em.getReference(osPesquisaCollectionOsPesquisaToAttach.getClass(), osPesquisaCollectionOsPesquisaToAttach.getCodospesquisa());
                attachedOsPesquisaCollection.add(osPesquisaCollectionOsPesquisaToAttach);
            }
            osOrdemservico.setOsPesquisaCollection(attachedOsPesquisaCollection);
            Collection<Orcamento> attachedOrcamentoCollection = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollectionOrcamentoToAttach : osOrdemservico.getOrcamentoCollection()) {
                orcamentoCollectionOrcamentoToAttach = em.getReference(orcamentoCollectionOrcamentoToAttach.getClass(), orcamentoCollectionOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollection.add(orcamentoCollectionOrcamentoToAttach);
            }
            osOrdemservico.setOrcamentoCollection(attachedOrcamentoCollection);
            em.persist(osOrdemservico);
            if (codcli != null) {
                codcli.getOsOrdemservicoCollection().add(osOrdemservico);
                codcli = em.merge(codcli);
            }
            if (codclienteendereco != null) {
                codclienteendereco.getOsOrdemservicoCollection().add(osOrdemservico);
                codclienteendereco = em.merge(codclienteendereco);
            }
            if (codclienteequipamento != null) {
                codclienteequipamento.getOsOrdemservicoCollection().add(osOrdemservico);
                codclienteequipamento = em.merge(codclienteequipamento);
            }
            if (codempresa != null) {
                codempresa.getOsOrdemservicoCollection().add(osOrdemservico);
                codempresa = em.merge(codempresa);
            }
            if (codmoveprod != null) {
                codmoveprod.getOsOrdemservicoCollection().add(osOrdemservico);
                codmoveprod = em.merge(codmoveprod);
            }
            if (codpreco != null) {
                codpreco.getOsOrdemservicoCollection().add(osOrdemservico);
                codpreco = em.merge(codpreco);
            }
            for (OsLaudo osLaudoCollectionOsLaudo : osOrdemservico.getOsLaudoCollection()) {
                OsOrdemservico oldCodosOfOsLaudoCollectionOsLaudo = osLaudoCollectionOsLaudo.getCodos();
                osLaudoCollectionOsLaudo.setCodos(osOrdemservico);
                osLaudoCollectionOsLaudo = em.merge(osLaudoCollectionOsLaudo);
                if (oldCodosOfOsLaudoCollectionOsLaudo != null) {
                    oldCodosOfOsLaudoCollectionOsLaudo.getOsLaudoCollection().remove(osLaudoCollectionOsLaudo);
                    oldCodosOfOsLaudoCollectionOsLaudo = em.merge(oldCodosOfOsLaudoCollectionOsLaudo);
                }
            }
            for (OsProdserv osProdservCollectionOsProdserv : osOrdemservico.getOsProdservCollection()) {
                OsOrdemservico oldCodosOfOsProdservCollectionOsProdserv = osProdservCollectionOsProdserv.getCodos();
                osProdservCollectionOsProdserv.setCodos(osOrdemservico);
                osProdservCollectionOsProdserv = em.merge(osProdservCollectionOsProdserv);
                if (oldCodosOfOsProdservCollectionOsProdserv != null) {
                    oldCodosOfOsProdservCollectionOsProdserv.getOsProdservCollection().remove(osProdservCollectionOsProdserv);
                    oldCodosOfOsProdservCollectionOsProdserv = em.merge(oldCodosOfOsProdservCollectionOsProdserv);
                }
            }
            for (OsStatushistorico osStatushistoricoCollectionOsStatushistorico : osOrdemservico.getOsStatushistoricoCollection()) {
                OsOrdemservico oldCodosOfOsStatushistoricoCollectionOsStatushistorico = osStatushistoricoCollectionOsStatushistorico.getCodos();
                osStatushistoricoCollectionOsStatushistorico.setCodos(osOrdemservico);
                osStatushistoricoCollectionOsStatushistorico = em.merge(osStatushistoricoCollectionOsStatushistorico);
                if (oldCodosOfOsStatushistoricoCollectionOsStatushistorico != null) {
                    oldCodosOfOsStatushistoricoCollectionOsStatushistorico.getOsStatushistoricoCollection().remove(osStatushistoricoCollectionOsStatushistorico);
                    oldCodosOfOsStatushistoricoCollectionOsStatushistorico = em.merge(oldCodosOfOsStatushistoricoCollectionOsStatushistorico);
                }
            }
            for (OsImagens osImagensCollectionOsImagens : osOrdemservico.getOsImagensCollection()) {
                OsOrdemservico oldCodosOfOsImagensCollectionOsImagens = osImagensCollectionOsImagens.getCodos();
                osImagensCollectionOsImagens.setCodos(osOrdemservico);
                osImagensCollectionOsImagens = em.merge(osImagensCollectionOsImagens);
                if (oldCodosOfOsImagensCollectionOsImagens != null) {
                    oldCodosOfOsImagensCollectionOsImagens.getOsImagensCollection().remove(osImagensCollectionOsImagens);
                    oldCodosOfOsImagensCollectionOsImagens = em.merge(oldCodosOfOsImagensCollectionOsImagens);
                }
            }
            for (OsPesquisa osPesquisaCollectionOsPesquisa : osOrdemservico.getOsPesquisaCollection()) {
                OsOrdemservico oldCodosOfOsPesquisaCollectionOsPesquisa = osPesquisaCollectionOsPesquisa.getCodos();
                osPesquisaCollectionOsPesquisa.setCodos(osOrdemservico);
                osPesquisaCollectionOsPesquisa = em.merge(osPesquisaCollectionOsPesquisa);
                if (oldCodosOfOsPesquisaCollectionOsPesquisa != null) {
                    oldCodosOfOsPesquisaCollectionOsPesquisa.getOsPesquisaCollection().remove(osPesquisaCollectionOsPesquisa);
                    oldCodosOfOsPesquisaCollectionOsPesquisa = em.merge(oldCodosOfOsPesquisaCollectionOsPesquisa);
                }
            }
            for (Orcamento orcamentoCollectionOrcamento : osOrdemservico.getOrcamentoCollection()) {
                OsOrdemservico oldCodosOfOrcamentoCollectionOrcamento = orcamentoCollectionOrcamento.getCodos();
                orcamentoCollectionOrcamento.setCodos(osOrdemservico);
                orcamentoCollectionOrcamento = em.merge(orcamentoCollectionOrcamento);
                if (oldCodosOfOrcamentoCollectionOrcamento != null) {
                    oldCodosOfOrcamentoCollectionOrcamento.getOrcamentoCollection().remove(orcamentoCollectionOrcamento);
                    oldCodosOfOrcamentoCollectionOrcamento = em.merge(oldCodosOfOrcamentoCollectionOrcamento);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOsOrdemservico(osOrdemservico.getCodos()) != null) {
                throw new PreexistingEntityException("OsOrdemservico " + osOrdemservico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OsOrdemservico osOrdemservico) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsOrdemservico persistentOsOrdemservico = em.find(OsOrdemservico.class, osOrdemservico.getCodos());
            Cliente codcliOld = persistentOsOrdemservico.getCodcli();
            Cliente codcliNew = osOrdemservico.getCodcli();
            Clienteendereco codclienteenderecoOld = persistentOsOrdemservico.getCodclienteendereco();
            Clienteendereco codclienteenderecoNew = osOrdemservico.getCodclienteendereco();
            Clienteequipamento codclienteequipamentoOld = persistentOsOrdemservico.getCodclienteequipamento();
            Clienteequipamento codclienteequipamentoNew = osOrdemservico.getCodclienteequipamento();
            Empresa codempresaOld = persistentOsOrdemservico.getCodempresa();
            Empresa codempresaNew = osOrdemservico.getCodempresa();
            Moventradaprod codmoveprodOld = persistentOsOrdemservico.getCodmoveprod();
            Moventradaprod codmoveprodNew = osOrdemservico.getCodmoveprod();
            Preco codprecoOld = persistentOsOrdemservico.getCodpreco();
            Preco codprecoNew = osOrdemservico.getCodpreco();
            Collection<OsLaudo> osLaudoCollectionOld = persistentOsOrdemservico.getOsLaudoCollection();
            Collection<OsLaudo> osLaudoCollectionNew = osOrdemservico.getOsLaudoCollection();
            Collection<OsProdserv> osProdservCollectionOld = persistentOsOrdemservico.getOsProdservCollection();
            Collection<OsProdserv> osProdservCollectionNew = osOrdemservico.getOsProdservCollection();
            Collection<OsStatushistorico> osStatushistoricoCollectionOld = persistentOsOrdemservico.getOsStatushistoricoCollection();
            Collection<OsStatushistorico> osStatushistoricoCollectionNew = osOrdemservico.getOsStatushistoricoCollection();
            Collection<OsImagens> osImagensCollectionOld = persistentOsOrdemservico.getOsImagensCollection();
            Collection<OsImagens> osImagensCollectionNew = osOrdemservico.getOsImagensCollection();
            Collection<OsPesquisa> osPesquisaCollectionOld = persistentOsOrdemservico.getOsPesquisaCollection();
            Collection<OsPesquisa> osPesquisaCollectionNew = osOrdemservico.getOsPesquisaCollection();
            Collection<Orcamento> orcamentoCollectionOld = persistentOsOrdemservico.getOrcamentoCollection();
            Collection<Orcamento> orcamentoCollectionNew = osOrdemservico.getOrcamentoCollection();
            List<String> illegalOrphanMessages = null;
            for (OsProdserv osProdservCollectionOldOsProdserv : osProdservCollectionOld) {
                if (!osProdservCollectionNew.contains(osProdservCollectionOldOsProdserv)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain OsProdserv " + osProdservCollectionOldOsProdserv + " since its codos field is not nullable.");
                }
            }
            for (OsStatushistorico osStatushistoricoCollectionOldOsStatushistorico : osStatushistoricoCollectionOld) {
                if (!osStatushistoricoCollectionNew.contains(osStatushistoricoCollectionOldOsStatushistorico)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain OsStatushistorico " + osStatushistoricoCollectionOldOsStatushistorico + " since its codos field is not nullable.");
                }
            }
            for (OsPesquisa osPesquisaCollectionOldOsPesquisa : osPesquisaCollectionOld) {
                if (!osPesquisaCollectionNew.contains(osPesquisaCollectionOldOsPesquisa)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain OsPesquisa " + osPesquisaCollectionOldOsPesquisa + " since its codos field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codcliNew != null) {
                codcliNew = em.getReference(codcliNew.getClass(), codcliNew.getCodcli());
                osOrdemservico.setCodcli(codcliNew);
            }
            if (codclienteenderecoNew != null) {
                codclienteenderecoNew = em.getReference(codclienteenderecoNew.getClass(), codclienteenderecoNew.getCodclienteendereco());
                osOrdemservico.setCodclienteendereco(codclienteenderecoNew);
            }
            if (codclienteequipamentoNew != null) {
                codclienteequipamentoNew = em.getReference(codclienteequipamentoNew.getClass(), codclienteequipamentoNew.getCodclienteequipamento());
                osOrdemservico.setCodclienteequipamento(codclienteequipamentoNew);
            }
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                osOrdemservico.setCodempresa(codempresaNew);
            }
            if (codmoveprodNew != null) {
                codmoveprodNew = em.getReference(codmoveprodNew.getClass(), codmoveprodNew.getCodmoveprod());
                osOrdemservico.setCodmoveprod(codmoveprodNew);
            }
            if (codprecoNew != null) {
                codprecoNew = em.getReference(codprecoNew.getClass(), codprecoNew.getCodpreco());
                osOrdemservico.setCodpreco(codprecoNew);
            }
            Collection<OsLaudo> attachedOsLaudoCollectionNew = new ArrayList<OsLaudo>();
            for (OsLaudo osLaudoCollectionNewOsLaudoToAttach : osLaudoCollectionNew) {
                osLaudoCollectionNewOsLaudoToAttach = em.getReference(osLaudoCollectionNewOsLaudoToAttach.getClass(), osLaudoCollectionNewOsLaudoToAttach.getCodlaudo());
                attachedOsLaudoCollectionNew.add(osLaudoCollectionNewOsLaudoToAttach);
            }
            osLaudoCollectionNew = attachedOsLaudoCollectionNew;
            osOrdemservico.setOsLaudoCollection(osLaudoCollectionNew);
            Collection<OsProdserv> attachedOsProdservCollectionNew = new ArrayList<OsProdserv>();
            for (OsProdserv osProdservCollectionNewOsProdservToAttach : osProdservCollectionNew) {
                osProdservCollectionNewOsProdservToAttach = em.getReference(osProdservCollectionNewOsProdservToAttach.getClass(), osProdservCollectionNewOsProdservToAttach.getCodprodserv());
                attachedOsProdservCollectionNew.add(osProdservCollectionNewOsProdservToAttach);
            }
            osProdservCollectionNew = attachedOsProdservCollectionNew;
            osOrdemservico.setOsProdservCollection(osProdservCollectionNew);
            Collection<OsStatushistorico> attachedOsStatushistoricoCollectionNew = new ArrayList<OsStatushistorico>();
            for (OsStatushistorico osStatushistoricoCollectionNewOsStatushistoricoToAttach : osStatushistoricoCollectionNew) {
                osStatushistoricoCollectionNewOsStatushistoricoToAttach = em.getReference(osStatushistoricoCollectionNewOsStatushistoricoToAttach.getClass(), osStatushistoricoCollectionNewOsStatushistoricoToAttach.getCodstatushistorico());
                attachedOsStatushistoricoCollectionNew.add(osStatushistoricoCollectionNewOsStatushistoricoToAttach);
            }
            osStatushistoricoCollectionNew = attachedOsStatushistoricoCollectionNew;
            osOrdemservico.setOsStatushistoricoCollection(osStatushistoricoCollectionNew);
            Collection<OsImagens> attachedOsImagensCollectionNew = new ArrayList<OsImagens>();
            for (OsImagens osImagensCollectionNewOsImagensToAttach : osImagensCollectionNew) {
                osImagensCollectionNewOsImagensToAttach = em.getReference(osImagensCollectionNewOsImagensToAttach.getClass(), osImagensCollectionNewOsImagensToAttach.getCodimgos());
                attachedOsImagensCollectionNew.add(osImagensCollectionNewOsImagensToAttach);
            }
            osImagensCollectionNew = attachedOsImagensCollectionNew;
            osOrdemservico.setOsImagensCollection(osImagensCollectionNew);
            Collection<OsPesquisa> attachedOsPesquisaCollectionNew = new ArrayList<OsPesquisa>();
            for (OsPesquisa osPesquisaCollectionNewOsPesquisaToAttach : osPesquisaCollectionNew) {
                osPesquisaCollectionNewOsPesquisaToAttach = em.getReference(osPesquisaCollectionNewOsPesquisaToAttach.getClass(), osPesquisaCollectionNewOsPesquisaToAttach.getCodospesquisa());
                attachedOsPesquisaCollectionNew.add(osPesquisaCollectionNewOsPesquisaToAttach);
            }
            osPesquisaCollectionNew = attachedOsPesquisaCollectionNew;
            osOrdemservico.setOsPesquisaCollection(osPesquisaCollectionNew);
            Collection<Orcamento> attachedOrcamentoCollectionNew = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollectionNewOrcamentoToAttach : orcamentoCollectionNew) {
                orcamentoCollectionNewOrcamentoToAttach = em.getReference(orcamentoCollectionNewOrcamentoToAttach.getClass(), orcamentoCollectionNewOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollectionNew.add(orcamentoCollectionNewOrcamentoToAttach);
            }
            orcamentoCollectionNew = attachedOrcamentoCollectionNew;
            osOrdemservico.setOrcamentoCollection(orcamentoCollectionNew);
            osOrdemservico = em.merge(osOrdemservico);
            if (codcliOld != null && !codcliOld.equals(codcliNew)) {
                codcliOld.getOsOrdemservicoCollection().remove(osOrdemservico);
                codcliOld = em.merge(codcliOld);
            }
            if (codcliNew != null && !codcliNew.equals(codcliOld)) {
                codcliNew.getOsOrdemservicoCollection().add(osOrdemservico);
                codcliNew = em.merge(codcliNew);
            }
            if (codclienteenderecoOld != null && !codclienteenderecoOld.equals(codclienteenderecoNew)) {
                codclienteenderecoOld.getOsOrdemservicoCollection().remove(osOrdemservico);
                codclienteenderecoOld = em.merge(codclienteenderecoOld);
            }
            if (codclienteenderecoNew != null && !codclienteenderecoNew.equals(codclienteenderecoOld)) {
                codclienteenderecoNew.getOsOrdemservicoCollection().add(osOrdemservico);
                codclienteenderecoNew = em.merge(codclienteenderecoNew);
            }
            if (codclienteequipamentoOld != null && !codclienteequipamentoOld.equals(codclienteequipamentoNew)) {
                codclienteequipamentoOld.getOsOrdemservicoCollection().remove(osOrdemservico);
                codclienteequipamentoOld = em.merge(codclienteequipamentoOld);
            }
            if (codclienteequipamentoNew != null && !codclienteequipamentoNew.equals(codclienteequipamentoOld)) {
                codclienteequipamentoNew.getOsOrdemservicoCollection().add(osOrdemservico);
                codclienteequipamentoNew = em.merge(codclienteequipamentoNew);
            }
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getOsOrdemservicoCollection().remove(osOrdemservico);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getOsOrdemservicoCollection().add(osOrdemservico);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codmoveprodOld != null && !codmoveprodOld.equals(codmoveprodNew)) {
                codmoveprodOld.getOsOrdemservicoCollection().remove(osOrdemservico);
                codmoveprodOld = em.merge(codmoveprodOld);
            }
            if (codmoveprodNew != null && !codmoveprodNew.equals(codmoveprodOld)) {
                codmoveprodNew.getOsOrdemservicoCollection().add(osOrdemservico);
                codmoveprodNew = em.merge(codmoveprodNew);
            }
            if (codprecoOld != null && !codprecoOld.equals(codprecoNew)) {
                codprecoOld.getOsOrdemservicoCollection().remove(osOrdemservico);
                codprecoOld = em.merge(codprecoOld);
            }
            if (codprecoNew != null && !codprecoNew.equals(codprecoOld)) {
                codprecoNew.getOsOrdemservicoCollection().add(osOrdemservico);
                codprecoNew = em.merge(codprecoNew);
            }
            for (OsLaudo osLaudoCollectionOldOsLaudo : osLaudoCollectionOld) {
                if (!osLaudoCollectionNew.contains(osLaudoCollectionOldOsLaudo)) {
                    osLaudoCollectionOldOsLaudo.setCodos(null);
                    osLaudoCollectionOldOsLaudo = em.merge(osLaudoCollectionOldOsLaudo);
                }
            }
            for (OsLaudo osLaudoCollectionNewOsLaudo : osLaudoCollectionNew) {
                if (!osLaudoCollectionOld.contains(osLaudoCollectionNewOsLaudo)) {
                    OsOrdemservico oldCodosOfOsLaudoCollectionNewOsLaudo = osLaudoCollectionNewOsLaudo.getCodos();
                    osLaudoCollectionNewOsLaudo.setCodos(osOrdemservico);
                    osLaudoCollectionNewOsLaudo = em.merge(osLaudoCollectionNewOsLaudo);
                    if (oldCodosOfOsLaudoCollectionNewOsLaudo != null && !oldCodosOfOsLaudoCollectionNewOsLaudo.equals(osOrdemservico)) {
                        oldCodosOfOsLaudoCollectionNewOsLaudo.getOsLaudoCollection().remove(osLaudoCollectionNewOsLaudo);
                        oldCodosOfOsLaudoCollectionNewOsLaudo = em.merge(oldCodosOfOsLaudoCollectionNewOsLaudo);
                    }
                }
            }
            for (OsProdserv osProdservCollectionNewOsProdserv : osProdservCollectionNew) {
                if (!osProdservCollectionOld.contains(osProdservCollectionNewOsProdserv)) {
                    OsOrdemservico oldCodosOfOsProdservCollectionNewOsProdserv = osProdservCollectionNewOsProdserv.getCodos();
                    osProdservCollectionNewOsProdserv.setCodos(osOrdemservico);
                    osProdservCollectionNewOsProdserv = em.merge(osProdservCollectionNewOsProdserv);
                    if (oldCodosOfOsProdservCollectionNewOsProdserv != null && !oldCodosOfOsProdservCollectionNewOsProdserv.equals(osOrdemservico)) {
                        oldCodosOfOsProdservCollectionNewOsProdserv.getOsProdservCollection().remove(osProdservCollectionNewOsProdserv);
                        oldCodosOfOsProdservCollectionNewOsProdserv = em.merge(oldCodosOfOsProdservCollectionNewOsProdserv);
                    }
                }
            }
            for (OsStatushistorico osStatushistoricoCollectionNewOsStatushistorico : osStatushistoricoCollectionNew) {
                if (!osStatushistoricoCollectionOld.contains(osStatushistoricoCollectionNewOsStatushistorico)) {
                    OsOrdemservico oldCodosOfOsStatushistoricoCollectionNewOsStatushistorico = osStatushistoricoCollectionNewOsStatushistorico.getCodos();
                    osStatushistoricoCollectionNewOsStatushistorico.setCodos(osOrdemservico);
                    osStatushistoricoCollectionNewOsStatushistorico = em.merge(osStatushistoricoCollectionNewOsStatushistorico);
                    if (oldCodosOfOsStatushistoricoCollectionNewOsStatushistorico != null && !oldCodosOfOsStatushistoricoCollectionNewOsStatushistorico.equals(osOrdemservico)) {
                        oldCodosOfOsStatushistoricoCollectionNewOsStatushistorico.getOsStatushistoricoCollection().remove(osStatushistoricoCollectionNewOsStatushistorico);
                        oldCodosOfOsStatushistoricoCollectionNewOsStatushistorico = em.merge(oldCodosOfOsStatushistoricoCollectionNewOsStatushistorico);
                    }
                }
            }
            for (OsImagens osImagensCollectionOldOsImagens : osImagensCollectionOld) {
                if (!osImagensCollectionNew.contains(osImagensCollectionOldOsImagens)) {
                    osImagensCollectionOldOsImagens.setCodos(null);
                    osImagensCollectionOldOsImagens = em.merge(osImagensCollectionOldOsImagens);
                }
            }
            for (OsImagens osImagensCollectionNewOsImagens : osImagensCollectionNew) {
                if (!osImagensCollectionOld.contains(osImagensCollectionNewOsImagens)) {
                    OsOrdemservico oldCodosOfOsImagensCollectionNewOsImagens = osImagensCollectionNewOsImagens.getCodos();
                    osImagensCollectionNewOsImagens.setCodos(osOrdemservico);
                    osImagensCollectionNewOsImagens = em.merge(osImagensCollectionNewOsImagens);
                    if (oldCodosOfOsImagensCollectionNewOsImagens != null && !oldCodosOfOsImagensCollectionNewOsImagens.equals(osOrdemservico)) {
                        oldCodosOfOsImagensCollectionNewOsImagens.getOsImagensCollection().remove(osImagensCollectionNewOsImagens);
                        oldCodosOfOsImagensCollectionNewOsImagens = em.merge(oldCodosOfOsImagensCollectionNewOsImagens);
                    }
                }
            }
            for (OsPesquisa osPesquisaCollectionNewOsPesquisa : osPesquisaCollectionNew) {
                if (!osPesquisaCollectionOld.contains(osPesquisaCollectionNewOsPesquisa)) {
                    OsOrdemservico oldCodosOfOsPesquisaCollectionNewOsPesquisa = osPesquisaCollectionNewOsPesquisa.getCodos();
                    osPesquisaCollectionNewOsPesquisa.setCodos(osOrdemservico);
                    osPesquisaCollectionNewOsPesquisa = em.merge(osPesquisaCollectionNewOsPesquisa);
                    if (oldCodosOfOsPesquisaCollectionNewOsPesquisa != null && !oldCodosOfOsPesquisaCollectionNewOsPesquisa.equals(osOrdemservico)) {
                        oldCodosOfOsPesquisaCollectionNewOsPesquisa.getOsPesquisaCollection().remove(osPesquisaCollectionNewOsPesquisa);
                        oldCodosOfOsPesquisaCollectionNewOsPesquisa = em.merge(oldCodosOfOsPesquisaCollectionNewOsPesquisa);
                    }
                }
            }
            for (Orcamento orcamentoCollectionOldOrcamento : orcamentoCollectionOld) {
                if (!orcamentoCollectionNew.contains(orcamentoCollectionOldOrcamento)) {
                    orcamentoCollectionOldOrcamento.setCodos(null);
                    orcamentoCollectionOldOrcamento = em.merge(orcamentoCollectionOldOrcamento);
                }
            }
            for (Orcamento orcamentoCollectionNewOrcamento : orcamentoCollectionNew) {
                if (!orcamentoCollectionOld.contains(orcamentoCollectionNewOrcamento)) {
                    OsOrdemservico oldCodosOfOrcamentoCollectionNewOrcamento = orcamentoCollectionNewOrcamento.getCodos();
                    orcamentoCollectionNewOrcamento.setCodos(osOrdemservico);
                    orcamentoCollectionNewOrcamento = em.merge(orcamentoCollectionNewOrcamento);
                    if (oldCodosOfOrcamentoCollectionNewOrcamento != null && !oldCodosOfOrcamentoCollectionNewOrcamento.equals(osOrdemservico)) {
                        oldCodosOfOrcamentoCollectionNewOrcamento.getOrcamentoCollection().remove(orcamentoCollectionNewOrcamento);
                        oldCodosOfOrcamentoCollectionNewOrcamento = em.merge(oldCodosOfOrcamentoCollectionNewOrcamento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = osOrdemservico.getCodos();
                if (findOsOrdemservico(id) == null) {
                    throw new NonexistentEntityException("The osOrdemservico with id " + id + " no longer exists.");
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
            OsOrdemservico osOrdemservico;
            try {
                osOrdemservico = em.getReference(OsOrdemservico.class, id);
                osOrdemservico.getCodos();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The osOrdemservico with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<OsProdserv> osProdservCollectionOrphanCheck = osOrdemservico.getOsProdservCollection();
            for (OsProdserv osProdservCollectionOrphanCheckOsProdserv : osProdservCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This OsOrdemservico (" + osOrdemservico + ") cannot be destroyed since the OsProdserv " + osProdservCollectionOrphanCheckOsProdserv + " in its osProdservCollection field has a non-nullable codos field.");
            }
            Collection<OsStatushistorico> osStatushistoricoCollectionOrphanCheck = osOrdemservico.getOsStatushistoricoCollection();
            for (OsStatushistorico osStatushistoricoCollectionOrphanCheckOsStatushistorico : osStatushistoricoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This OsOrdemservico (" + osOrdemservico + ") cannot be destroyed since the OsStatushistorico " + osStatushistoricoCollectionOrphanCheckOsStatushistorico + " in its osStatushistoricoCollection field has a non-nullable codos field.");
            }
            Collection<OsPesquisa> osPesquisaCollectionOrphanCheck = osOrdemservico.getOsPesquisaCollection();
            for (OsPesquisa osPesquisaCollectionOrphanCheckOsPesquisa : osPesquisaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This OsOrdemservico (" + osOrdemservico + ") cannot be destroyed since the OsPesquisa " + osPesquisaCollectionOrphanCheckOsPesquisa + " in its osPesquisaCollection field has a non-nullable codos field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cliente codcli = osOrdemservico.getCodcli();
            if (codcli != null) {
                codcli.getOsOrdemservicoCollection().remove(osOrdemservico);
                codcli = em.merge(codcli);
            }
            Clienteendereco codclienteendereco = osOrdemservico.getCodclienteendereco();
            if (codclienteendereco != null) {
                codclienteendereco.getOsOrdemservicoCollection().remove(osOrdemservico);
                codclienteendereco = em.merge(codclienteendereco);
            }
            Clienteequipamento codclienteequipamento = osOrdemservico.getCodclienteequipamento();
            if (codclienteequipamento != null) {
                codclienteequipamento.getOsOrdemservicoCollection().remove(osOrdemservico);
                codclienteequipamento = em.merge(codclienteequipamento);
            }
            Empresa codempresa = osOrdemservico.getCodempresa();
            if (codempresa != null) {
                codempresa.getOsOrdemservicoCollection().remove(osOrdemservico);
                codempresa = em.merge(codempresa);
            }
            Moventradaprod codmoveprod = osOrdemservico.getCodmoveprod();
            if (codmoveprod != null) {
                codmoveprod.getOsOrdemservicoCollection().remove(osOrdemservico);
                codmoveprod = em.merge(codmoveprod);
            }
            Preco codpreco = osOrdemservico.getCodpreco();
            if (codpreco != null) {
                codpreco.getOsOrdemservicoCollection().remove(osOrdemservico);
                codpreco = em.merge(codpreco);
            }
            Collection<OsLaudo> osLaudoCollection = osOrdemservico.getOsLaudoCollection();
            for (OsLaudo osLaudoCollectionOsLaudo : osLaudoCollection) {
                osLaudoCollectionOsLaudo.setCodos(null);
                osLaudoCollectionOsLaudo = em.merge(osLaudoCollectionOsLaudo);
            }
            Collection<OsImagens> osImagensCollection = osOrdemservico.getOsImagensCollection();
            for (OsImagens osImagensCollectionOsImagens : osImagensCollection) {
                osImagensCollectionOsImagens.setCodos(null);
                osImagensCollectionOsImagens = em.merge(osImagensCollectionOsImagens);
            }
            Collection<Orcamento> orcamentoCollection = osOrdemservico.getOrcamentoCollection();
            for (Orcamento orcamentoCollectionOrcamento : orcamentoCollection) {
                orcamentoCollectionOrcamento.setCodos(null);
                orcamentoCollectionOrcamento = em.merge(orcamentoCollectionOrcamento);
            }
            em.remove(osOrdemservico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OsOrdemservico> findOsOrdemservicoEntities() {
        return findOsOrdemservicoEntities(true, -1, -1);
    }

    public List<OsOrdemservico> findOsOrdemservicoEntities(int maxResults, int firstResult) {
        return findOsOrdemservicoEntities(false, maxResults, firstResult);
    }

    private List<OsOrdemservico> findOsOrdemservicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OsOrdemservico.class));
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

    public OsOrdemservico findOsOrdemservico(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OsOrdemservico.class, id);
        } finally {
            em.close();
        }
    }

    public int getOsOrdemservicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OsOrdemservico> rt = cq.from(OsOrdemservico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

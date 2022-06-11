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
import entidade.cplus.Caixa;
import entidade.cplus.Contapagar;
import entidade.cplus.Cheques;
import entidade.cplus.Contareceberfixa;
import entidade.cplus.Recebimento;
import entidade.cplus.Contareceber;
import entidade.cplus.Terminal;
import entidade.cplus.Contapagarfixa;
import entidade.cplus.Contabancaria;
import entidade.cplus.Cliente;
import entidade.cplus.Planoconta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class PlanocontaJpaController implements Serializable {

    public PlanocontaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Planoconta planoconta) throws PreexistingEntityException, Exception {
        if (planoconta.getChequesfirmaCollection() == null) {
            planoconta.setChequesfirmaCollection(new ArrayList<Chequesfirma>());
        }
        if (planoconta.getCaixaCollection() == null) {
            planoconta.setCaixaCollection(new ArrayList<Caixa>());
        }
        if (planoconta.getContapagarCollection() == null) {
            planoconta.setContapagarCollection(new ArrayList<Contapagar>());
        }
        if (planoconta.getChequesCollection() == null) {
            planoconta.setChequesCollection(new ArrayList<Cheques>());
        }
        if (planoconta.getContareceberfixaCollection() == null) {
            planoconta.setContareceberfixaCollection(new ArrayList<Contareceberfixa>());
        }
        if (planoconta.getRecebimentoCollection() == null) {
            planoconta.setRecebimentoCollection(new ArrayList<Recebimento>());
        }
        if (planoconta.getContareceberCollection() == null) {
            planoconta.setContareceberCollection(new ArrayList<Contareceber>());
        }
        if (planoconta.getTerminalCollection() == null) {
            planoconta.setTerminalCollection(new ArrayList<Terminal>());
        }
        if (planoconta.getContapagarfixaCollection() == null) {
            planoconta.setContapagarfixaCollection(new ArrayList<Contapagarfixa>());
        }
        if (planoconta.getContabancariaCollection() == null) {
            planoconta.setContabancariaCollection(new ArrayList<Contabancaria>());
        }
        if (planoconta.getClienteCollection() == null) {
            planoconta.setClienteCollection(new ArrayList<Cliente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Chequesfirma> attachedChequesfirmaCollection = new ArrayList<Chequesfirma>();
            for (Chequesfirma chequesfirmaCollectionChequesfirmaToAttach : planoconta.getChequesfirmaCollection()) {
                chequesfirmaCollectionChequesfirmaToAttach = em.getReference(chequesfirmaCollectionChequesfirmaToAttach.getClass(), chequesfirmaCollectionChequesfirmaToAttach.getCodchequefirma());
                attachedChequesfirmaCollection.add(chequesfirmaCollectionChequesfirmaToAttach);
            }
            planoconta.setChequesfirmaCollection(attachedChequesfirmaCollection);
            Collection<Caixa> attachedCaixaCollection = new ArrayList<Caixa>();
            for (Caixa caixaCollectionCaixaToAttach : planoconta.getCaixaCollection()) {
                caixaCollectionCaixaToAttach = em.getReference(caixaCollectionCaixaToAttach.getClass(), caixaCollectionCaixaToAttach.getCodcaixa());
                attachedCaixaCollection.add(caixaCollectionCaixaToAttach);
            }
            planoconta.setCaixaCollection(attachedCaixaCollection);
            Collection<Contapagar> attachedContapagarCollection = new ArrayList<Contapagar>();
            for (Contapagar contapagarCollectionContapagarToAttach : planoconta.getContapagarCollection()) {
                contapagarCollectionContapagarToAttach = em.getReference(contapagarCollectionContapagarToAttach.getClass(), contapagarCollectionContapagarToAttach.getCodcp());
                attachedContapagarCollection.add(contapagarCollectionContapagarToAttach);
            }
            planoconta.setContapagarCollection(attachedContapagarCollection);
            Collection<Cheques> attachedChequesCollection = new ArrayList<Cheques>();
            for (Cheques chequesCollectionChequesToAttach : planoconta.getChequesCollection()) {
                chequesCollectionChequesToAttach = em.getReference(chequesCollectionChequesToAttach.getClass(), chequesCollectionChequesToAttach.getCodcheque());
                attachedChequesCollection.add(chequesCollectionChequesToAttach);
            }
            planoconta.setChequesCollection(attachedChequesCollection);
            Collection<Contareceberfixa> attachedContareceberfixaCollection = new ArrayList<Contareceberfixa>();
            for (Contareceberfixa contareceberfixaCollectionContareceberfixaToAttach : planoconta.getContareceberfixaCollection()) {
                contareceberfixaCollectionContareceberfixaToAttach = em.getReference(contareceberfixaCollectionContareceberfixaToAttach.getClass(), contareceberfixaCollectionContareceberfixaToAttach.getCodcrfixa());
                attachedContareceberfixaCollection.add(contareceberfixaCollectionContareceberfixaToAttach);
            }
            planoconta.setContareceberfixaCollection(attachedContareceberfixaCollection);
            Collection<Recebimento> attachedRecebimentoCollection = new ArrayList<Recebimento>();
            for (Recebimento recebimentoCollectionRecebimentoToAttach : planoconta.getRecebimentoCollection()) {
                recebimentoCollectionRecebimentoToAttach = em.getReference(recebimentoCollectionRecebimentoToAttach.getClass(), recebimentoCollectionRecebimentoToAttach.getCodrec());
                attachedRecebimentoCollection.add(recebimentoCollectionRecebimentoToAttach);
            }
            planoconta.setRecebimentoCollection(attachedRecebimentoCollection);
            Collection<Contareceber> attachedContareceberCollection = new ArrayList<Contareceber>();
            for (Contareceber contareceberCollectionContareceberToAttach : planoconta.getContareceberCollection()) {
                contareceberCollectionContareceberToAttach = em.getReference(contareceberCollectionContareceberToAttach.getClass(), contareceberCollectionContareceberToAttach.getCodcr());
                attachedContareceberCollection.add(contareceberCollectionContareceberToAttach);
            }
            planoconta.setContareceberCollection(attachedContareceberCollection);
            Collection<Terminal> attachedTerminalCollection = new ArrayList<Terminal>();
            for (Terminal terminalCollectionTerminalToAttach : planoconta.getTerminalCollection()) {
                terminalCollectionTerminalToAttach = em.getReference(terminalCollectionTerminalToAttach.getClass(), terminalCollectionTerminalToAttach.getCodterminal());
                attachedTerminalCollection.add(terminalCollectionTerminalToAttach);
            }
            planoconta.setTerminalCollection(attachedTerminalCollection);
            Collection<Contapagarfixa> attachedContapagarfixaCollection = new ArrayList<Contapagarfixa>();
            for (Contapagarfixa contapagarfixaCollectionContapagarfixaToAttach : planoconta.getContapagarfixaCollection()) {
                contapagarfixaCollectionContapagarfixaToAttach = em.getReference(contapagarfixaCollectionContapagarfixaToAttach.getClass(), contapagarfixaCollectionContapagarfixaToAttach.getCodcpfixa());
                attachedContapagarfixaCollection.add(contapagarfixaCollectionContapagarfixaToAttach);
            }
            planoconta.setContapagarfixaCollection(attachedContapagarfixaCollection);
            Collection<Contabancaria> attachedContabancariaCollection = new ArrayList<Contabancaria>();
            for (Contabancaria contabancariaCollectionContabancariaToAttach : planoconta.getContabancariaCollection()) {
                contabancariaCollectionContabancariaToAttach = em.getReference(contabancariaCollectionContabancariaToAttach.getClass(), contabancariaCollectionContabancariaToAttach.getCodcontabancaria());
                attachedContabancariaCollection.add(contabancariaCollectionContabancariaToAttach);
            }
            planoconta.setContabancariaCollection(attachedContabancariaCollection);
            Collection<Cliente> attachedClienteCollection = new ArrayList<Cliente>();
            for (Cliente clienteCollectionClienteToAttach : planoconta.getClienteCollection()) {
                clienteCollectionClienteToAttach = em.getReference(clienteCollectionClienteToAttach.getClass(), clienteCollectionClienteToAttach.getCodcli());
                attachedClienteCollection.add(clienteCollectionClienteToAttach);
            }
            planoconta.setClienteCollection(attachedClienteCollection);
            em.persist(planoconta);
            for (Chequesfirma chequesfirmaCollectionChequesfirma : planoconta.getChequesfirmaCollection()) {
                Planoconta oldCodpcOfChequesfirmaCollectionChequesfirma = chequesfirmaCollectionChequesfirma.getCodpc();
                chequesfirmaCollectionChequesfirma.setCodpc(planoconta);
                chequesfirmaCollectionChequesfirma = em.merge(chequesfirmaCollectionChequesfirma);
                if (oldCodpcOfChequesfirmaCollectionChequesfirma != null) {
                    oldCodpcOfChequesfirmaCollectionChequesfirma.getChequesfirmaCollection().remove(chequesfirmaCollectionChequesfirma);
                    oldCodpcOfChequesfirmaCollectionChequesfirma = em.merge(oldCodpcOfChequesfirmaCollectionChequesfirma);
                }
            }
            for (Caixa caixaCollectionCaixa : planoconta.getCaixaCollection()) {
                Planoconta oldCodpcOfCaixaCollectionCaixa = caixaCollectionCaixa.getCodpc();
                caixaCollectionCaixa.setCodpc(planoconta);
                caixaCollectionCaixa = em.merge(caixaCollectionCaixa);
                if (oldCodpcOfCaixaCollectionCaixa != null) {
                    oldCodpcOfCaixaCollectionCaixa.getCaixaCollection().remove(caixaCollectionCaixa);
                    oldCodpcOfCaixaCollectionCaixa = em.merge(oldCodpcOfCaixaCollectionCaixa);
                }
            }
            for (Contapagar contapagarCollectionContapagar : planoconta.getContapagarCollection()) {
                Planoconta oldCodpcOfContapagarCollectionContapagar = contapagarCollectionContapagar.getCodpc();
                contapagarCollectionContapagar.setCodpc(planoconta);
                contapagarCollectionContapagar = em.merge(contapagarCollectionContapagar);
                if (oldCodpcOfContapagarCollectionContapagar != null) {
                    oldCodpcOfContapagarCollectionContapagar.getContapagarCollection().remove(contapagarCollectionContapagar);
                    oldCodpcOfContapagarCollectionContapagar = em.merge(oldCodpcOfContapagarCollectionContapagar);
                }
            }
            for (Cheques chequesCollectionCheques : planoconta.getChequesCollection()) {
                Planoconta oldCodpcOfChequesCollectionCheques = chequesCollectionCheques.getCodpc();
                chequesCollectionCheques.setCodpc(planoconta);
                chequesCollectionCheques = em.merge(chequesCollectionCheques);
                if (oldCodpcOfChequesCollectionCheques != null) {
                    oldCodpcOfChequesCollectionCheques.getChequesCollection().remove(chequesCollectionCheques);
                    oldCodpcOfChequesCollectionCheques = em.merge(oldCodpcOfChequesCollectionCheques);
                }
            }
            for (Contareceberfixa contareceberfixaCollectionContareceberfixa : planoconta.getContareceberfixaCollection()) {
                Planoconta oldCodpcOfContareceberfixaCollectionContareceberfixa = contareceberfixaCollectionContareceberfixa.getCodpc();
                contareceberfixaCollectionContareceberfixa.setCodpc(planoconta);
                contareceberfixaCollectionContareceberfixa = em.merge(contareceberfixaCollectionContareceberfixa);
                if (oldCodpcOfContareceberfixaCollectionContareceberfixa != null) {
                    oldCodpcOfContareceberfixaCollectionContareceberfixa.getContareceberfixaCollection().remove(contareceberfixaCollectionContareceberfixa);
                    oldCodpcOfContareceberfixaCollectionContareceberfixa = em.merge(oldCodpcOfContareceberfixaCollectionContareceberfixa);
                }
            }
            for (Recebimento recebimentoCollectionRecebimento : planoconta.getRecebimentoCollection()) {
                Planoconta oldCodpcOfRecebimentoCollectionRecebimento = recebimentoCollectionRecebimento.getCodpc();
                recebimentoCollectionRecebimento.setCodpc(planoconta);
                recebimentoCollectionRecebimento = em.merge(recebimentoCollectionRecebimento);
                if (oldCodpcOfRecebimentoCollectionRecebimento != null) {
                    oldCodpcOfRecebimentoCollectionRecebimento.getRecebimentoCollection().remove(recebimentoCollectionRecebimento);
                    oldCodpcOfRecebimentoCollectionRecebimento = em.merge(oldCodpcOfRecebimentoCollectionRecebimento);
                }
            }
            for (Contareceber contareceberCollectionContareceber : planoconta.getContareceberCollection()) {
                Planoconta oldCodpcOfContareceberCollectionContareceber = contareceberCollectionContareceber.getCodpc();
                contareceberCollectionContareceber.setCodpc(planoconta);
                contareceberCollectionContareceber = em.merge(contareceberCollectionContareceber);
                if (oldCodpcOfContareceberCollectionContareceber != null) {
                    oldCodpcOfContareceberCollectionContareceber.getContareceberCollection().remove(contareceberCollectionContareceber);
                    oldCodpcOfContareceberCollectionContareceber = em.merge(oldCodpcOfContareceberCollectionContareceber);
                }
            }
            for (Terminal terminalCollectionTerminal : planoconta.getTerminalCollection()) {
                Planoconta oldCodpcOfTerminalCollectionTerminal = terminalCollectionTerminal.getCodpc();
                terminalCollectionTerminal.setCodpc(planoconta);
                terminalCollectionTerminal = em.merge(terminalCollectionTerminal);
                if (oldCodpcOfTerminalCollectionTerminal != null) {
                    oldCodpcOfTerminalCollectionTerminal.getTerminalCollection().remove(terminalCollectionTerminal);
                    oldCodpcOfTerminalCollectionTerminal = em.merge(oldCodpcOfTerminalCollectionTerminal);
                }
            }
            for (Contapagarfixa contapagarfixaCollectionContapagarfixa : planoconta.getContapagarfixaCollection()) {
                Planoconta oldCodpcOfContapagarfixaCollectionContapagarfixa = contapagarfixaCollectionContapagarfixa.getCodpc();
                contapagarfixaCollectionContapagarfixa.setCodpc(planoconta);
                contapagarfixaCollectionContapagarfixa = em.merge(contapagarfixaCollectionContapagarfixa);
                if (oldCodpcOfContapagarfixaCollectionContapagarfixa != null) {
                    oldCodpcOfContapagarfixaCollectionContapagarfixa.getContapagarfixaCollection().remove(contapagarfixaCollectionContapagarfixa);
                    oldCodpcOfContapagarfixaCollectionContapagarfixa = em.merge(oldCodpcOfContapagarfixaCollectionContapagarfixa);
                }
            }
            for (Contabancaria contabancariaCollectionContabancaria : planoconta.getContabancariaCollection()) {
                Planoconta oldCodpcOfContabancariaCollectionContabancaria = contabancariaCollectionContabancaria.getCodpc();
                contabancariaCollectionContabancaria.setCodpc(planoconta);
                contabancariaCollectionContabancaria = em.merge(contabancariaCollectionContabancaria);
                if (oldCodpcOfContabancariaCollectionContabancaria != null) {
                    oldCodpcOfContabancariaCollectionContabancaria.getContabancariaCollection().remove(contabancariaCollectionContabancaria);
                    oldCodpcOfContabancariaCollectionContabancaria = em.merge(oldCodpcOfContabancariaCollectionContabancaria);
                }
            }
            for (Cliente clienteCollectionCliente : planoconta.getClienteCollection()) {
                Planoconta oldCodpcOfClienteCollectionCliente = clienteCollectionCliente.getCodpc();
                clienteCollectionCliente.setCodpc(planoconta);
                clienteCollectionCliente = em.merge(clienteCollectionCliente);
                if (oldCodpcOfClienteCollectionCliente != null) {
                    oldCodpcOfClienteCollectionCliente.getClienteCollection().remove(clienteCollectionCliente);
                    oldCodpcOfClienteCollectionCliente = em.merge(oldCodpcOfClienteCollectionCliente);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPlanoconta(planoconta.getCodpc()) != null) {
                throw new PreexistingEntityException("Planoconta " + planoconta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Planoconta planoconta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Planoconta persistentPlanoconta = em.find(Planoconta.class, planoconta.getCodpc());
            Collection<Chequesfirma> chequesfirmaCollectionOld = persistentPlanoconta.getChequesfirmaCollection();
            Collection<Chequesfirma> chequesfirmaCollectionNew = planoconta.getChequesfirmaCollection();
            Collection<Caixa> caixaCollectionOld = persistentPlanoconta.getCaixaCollection();
            Collection<Caixa> caixaCollectionNew = planoconta.getCaixaCollection();
            Collection<Contapagar> contapagarCollectionOld = persistentPlanoconta.getContapagarCollection();
            Collection<Contapagar> contapagarCollectionNew = planoconta.getContapagarCollection();
            Collection<Cheques> chequesCollectionOld = persistentPlanoconta.getChequesCollection();
            Collection<Cheques> chequesCollectionNew = planoconta.getChequesCollection();
            Collection<Contareceberfixa> contareceberfixaCollectionOld = persistentPlanoconta.getContareceberfixaCollection();
            Collection<Contareceberfixa> contareceberfixaCollectionNew = planoconta.getContareceberfixaCollection();
            Collection<Recebimento> recebimentoCollectionOld = persistentPlanoconta.getRecebimentoCollection();
            Collection<Recebimento> recebimentoCollectionNew = planoconta.getRecebimentoCollection();
            Collection<Contareceber> contareceberCollectionOld = persistentPlanoconta.getContareceberCollection();
            Collection<Contareceber> contareceberCollectionNew = planoconta.getContareceberCollection();
            Collection<Terminal> terminalCollectionOld = persistentPlanoconta.getTerminalCollection();
            Collection<Terminal> terminalCollectionNew = planoconta.getTerminalCollection();
            Collection<Contapagarfixa> contapagarfixaCollectionOld = persistentPlanoconta.getContapagarfixaCollection();
            Collection<Contapagarfixa> contapagarfixaCollectionNew = planoconta.getContapagarfixaCollection();
            Collection<Contabancaria> contabancariaCollectionOld = persistentPlanoconta.getContabancariaCollection();
            Collection<Contabancaria> contabancariaCollectionNew = planoconta.getContabancariaCollection();
            Collection<Cliente> clienteCollectionOld = persistentPlanoconta.getClienteCollection();
            Collection<Cliente> clienteCollectionNew = planoconta.getClienteCollection();
            Collection<Chequesfirma> attachedChequesfirmaCollectionNew = new ArrayList<Chequesfirma>();
            for (Chequesfirma chequesfirmaCollectionNewChequesfirmaToAttach : chequesfirmaCollectionNew) {
                chequesfirmaCollectionNewChequesfirmaToAttach = em.getReference(chequesfirmaCollectionNewChequesfirmaToAttach.getClass(), chequesfirmaCollectionNewChequesfirmaToAttach.getCodchequefirma());
                attachedChequesfirmaCollectionNew.add(chequesfirmaCollectionNewChequesfirmaToAttach);
            }
            chequesfirmaCollectionNew = attachedChequesfirmaCollectionNew;
            planoconta.setChequesfirmaCollection(chequesfirmaCollectionNew);
            Collection<Caixa> attachedCaixaCollectionNew = new ArrayList<Caixa>();
            for (Caixa caixaCollectionNewCaixaToAttach : caixaCollectionNew) {
                caixaCollectionNewCaixaToAttach = em.getReference(caixaCollectionNewCaixaToAttach.getClass(), caixaCollectionNewCaixaToAttach.getCodcaixa());
                attachedCaixaCollectionNew.add(caixaCollectionNewCaixaToAttach);
            }
            caixaCollectionNew = attachedCaixaCollectionNew;
            planoconta.setCaixaCollection(caixaCollectionNew);
            Collection<Contapagar> attachedContapagarCollectionNew = new ArrayList<Contapagar>();
            for (Contapagar contapagarCollectionNewContapagarToAttach : contapagarCollectionNew) {
                contapagarCollectionNewContapagarToAttach = em.getReference(contapagarCollectionNewContapagarToAttach.getClass(), contapagarCollectionNewContapagarToAttach.getCodcp());
                attachedContapagarCollectionNew.add(contapagarCollectionNewContapagarToAttach);
            }
            contapagarCollectionNew = attachedContapagarCollectionNew;
            planoconta.setContapagarCollection(contapagarCollectionNew);
            Collection<Cheques> attachedChequesCollectionNew = new ArrayList<Cheques>();
            for (Cheques chequesCollectionNewChequesToAttach : chequesCollectionNew) {
                chequesCollectionNewChequesToAttach = em.getReference(chequesCollectionNewChequesToAttach.getClass(), chequesCollectionNewChequesToAttach.getCodcheque());
                attachedChequesCollectionNew.add(chequesCollectionNewChequesToAttach);
            }
            chequesCollectionNew = attachedChequesCollectionNew;
            planoconta.setChequesCollection(chequesCollectionNew);
            Collection<Contareceberfixa> attachedContareceberfixaCollectionNew = new ArrayList<Contareceberfixa>();
            for (Contareceberfixa contareceberfixaCollectionNewContareceberfixaToAttach : contareceberfixaCollectionNew) {
                contareceberfixaCollectionNewContareceberfixaToAttach = em.getReference(contareceberfixaCollectionNewContareceberfixaToAttach.getClass(), contareceberfixaCollectionNewContareceberfixaToAttach.getCodcrfixa());
                attachedContareceberfixaCollectionNew.add(contareceberfixaCollectionNewContareceberfixaToAttach);
            }
            contareceberfixaCollectionNew = attachedContareceberfixaCollectionNew;
            planoconta.setContareceberfixaCollection(contareceberfixaCollectionNew);
            Collection<Recebimento> attachedRecebimentoCollectionNew = new ArrayList<Recebimento>();
            for (Recebimento recebimentoCollectionNewRecebimentoToAttach : recebimentoCollectionNew) {
                recebimentoCollectionNewRecebimentoToAttach = em.getReference(recebimentoCollectionNewRecebimentoToAttach.getClass(), recebimentoCollectionNewRecebimentoToAttach.getCodrec());
                attachedRecebimentoCollectionNew.add(recebimentoCollectionNewRecebimentoToAttach);
            }
            recebimentoCollectionNew = attachedRecebimentoCollectionNew;
            planoconta.setRecebimentoCollection(recebimentoCollectionNew);
            Collection<Contareceber> attachedContareceberCollectionNew = new ArrayList<Contareceber>();
            for (Contareceber contareceberCollectionNewContareceberToAttach : contareceberCollectionNew) {
                contareceberCollectionNewContareceberToAttach = em.getReference(contareceberCollectionNewContareceberToAttach.getClass(), contareceberCollectionNewContareceberToAttach.getCodcr());
                attachedContareceberCollectionNew.add(contareceberCollectionNewContareceberToAttach);
            }
            contareceberCollectionNew = attachedContareceberCollectionNew;
            planoconta.setContareceberCollection(contareceberCollectionNew);
            Collection<Terminal> attachedTerminalCollectionNew = new ArrayList<Terminal>();
            for (Terminal terminalCollectionNewTerminalToAttach : terminalCollectionNew) {
                terminalCollectionNewTerminalToAttach = em.getReference(terminalCollectionNewTerminalToAttach.getClass(), terminalCollectionNewTerminalToAttach.getCodterminal());
                attachedTerminalCollectionNew.add(terminalCollectionNewTerminalToAttach);
            }
            terminalCollectionNew = attachedTerminalCollectionNew;
            planoconta.setTerminalCollection(terminalCollectionNew);
            Collection<Contapagarfixa> attachedContapagarfixaCollectionNew = new ArrayList<Contapagarfixa>();
            for (Contapagarfixa contapagarfixaCollectionNewContapagarfixaToAttach : contapagarfixaCollectionNew) {
                contapagarfixaCollectionNewContapagarfixaToAttach = em.getReference(contapagarfixaCollectionNewContapagarfixaToAttach.getClass(), contapagarfixaCollectionNewContapagarfixaToAttach.getCodcpfixa());
                attachedContapagarfixaCollectionNew.add(contapagarfixaCollectionNewContapagarfixaToAttach);
            }
            contapagarfixaCollectionNew = attachedContapagarfixaCollectionNew;
            planoconta.setContapagarfixaCollection(contapagarfixaCollectionNew);
            Collection<Contabancaria> attachedContabancariaCollectionNew = new ArrayList<Contabancaria>();
            for (Contabancaria contabancariaCollectionNewContabancariaToAttach : contabancariaCollectionNew) {
                contabancariaCollectionNewContabancariaToAttach = em.getReference(contabancariaCollectionNewContabancariaToAttach.getClass(), contabancariaCollectionNewContabancariaToAttach.getCodcontabancaria());
                attachedContabancariaCollectionNew.add(contabancariaCollectionNewContabancariaToAttach);
            }
            contabancariaCollectionNew = attachedContabancariaCollectionNew;
            planoconta.setContabancariaCollection(contabancariaCollectionNew);
            Collection<Cliente> attachedClienteCollectionNew = new ArrayList<Cliente>();
            for (Cliente clienteCollectionNewClienteToAttach : clienteCollectionNew) {
                clienteCollectionNewClienteToAttach = em.getReference(clienteCollectionNewClienteToAttach.getClass(), clienteCollectionNewClienteToAttach.getCodcli());
                attachedClienteCollectionNew.add(clienteCollectionNewClienteToAttach);
            }
            clienteCollectionNew = attachedClienteCollectionNew;
            planoconta.setClienteCollection(clienteCollectionNew);
            planoconta = em.merge(planoconta);
            for (Chequesfirma chequesfirmaCollectionOldChequesfirma : chequesfirmaCollectionOld) {
                if (!chequesfirmaCollectionNew.contains(chequesfirmaCollectionOldChequesfirma)) {
                    chequesfirmaCollectionOldChequesfirma.setCodpc(null);
                    chequesfirmaCollectionOldChequesfirma = em.merge(chequesfirmaCollectionOldChequesfirma);
                }
            }
            for (Chequesfirma chequesfirmaCollectionNewChequesfirma : chequesfirmaCollectionNew) {
                if (!chequesfirmaCollectionOld.contains(chequesfirmaCollectionNewChequesfirma)) {
                    Planoconta oldCodpcOfChequesfirmaCollectionNewChequesfirma = chequesfirmaCollectionNewChequesfirma.getCodpc();
                    chequesfirmaCollectionNewChequesfirma.setCodpc(planoconta);
                    chequesfirmaCollectionNewChequesfirma = em.merge(chequesfirmaCollectionNewChequesfirma);
                    if (oldCodpcOfChequesfirmaCollectionNewChequesfirma != null && !oldCodpcOfChequesfirmaCollectionNewChequesfirma.equals(planoconta)) {
                        oldCodpcOfChequesfirmaCollectionNewChequesfirma.getChequesfirmaCollection().remove(chequesfirmaCollectionNewChequesfirma);
                        oldCodpcOfChequesfirmaCollectionNewChequesfirma = em.merge(oldCodpcOfChequesfirmaCollectionNewChequesfirma);
                    }
                }
            }
            for (Caixa caixaCollectionOldCaixa : caixaCollectionOld) {
                if (!caixaCollectionNew.contains(caixaCollectionOldCaixa)) {
                    caixaCollectionOldCaixa.setCodpc(null);
                    caixaCollectionOldCaixa = em.merge(caixaCollectionOldCaixa);
                }
            }
            for (Caixa caixaCollectionNewCaixa : caixaCollectionNew) {
                if (!caixaCollectionOld.contains(caixaCollectionNewCaixa)) {
                    Planoconta oldCodpcOfCaixaCollectionNewCaixa = caixaCollectionNewCaixa.getCodpc();
                    caixaCollectionNewCaixa.setCodpc(planoconta);
                    caixaCollectionNewCaixa = em.merge(caixaCollectionNewCaixa);
                    if (oldCodpcOfCaixaCollectionNewCaixa != null && !oldCodpcOfCaixaCollectionNewCaixa.equals(planoconta)) {
                        oldCodpcOfCaixaCollectionNewCaixa.getCaixaCollection().remove(caixaCollectionNewCaixa);
                        oldCodpcOfCaixaCollectionNewCaixa = em.merge(oldCodpcOfCaixaCollectionNewCaixa);
                    }
                }
            }
            for (Contapagar contapagarCollectionOldContapagar : contapagarCollectionOld) {
                if (!contapagarCollectionNew.contains(contapagarCollectionOldContapagar)) {
                    contapagarCollectionOldContapagar.setCodpc(null);
                    contapagarCollectionOldContapagar = em.merge(contapagarCollectionOldContapagar);
                }
            }
            for (Contapagar contapagarCollectionNewContapagar : contapagarCollectionNew) {
                if (!contapagarCollectionOld.contains(contapagarCollectionNewContapagar)) {
                    Planoconta oldCodpcOfContapagarCollectionNewContapagar = contapagarCollectionNewContapagar.getCodpc();
                    contapagarCollectionNewContapagar.setCodpc(planoconta);
                    contapagarCollectionNewContapagar = em.merge(contapagarCollectionNewContapagar);
                    if (oldCodpcOfContapagarCollectionNewContapagar != null && !oldCodpcOfContapagarCollectionNewContapagar.equals(planoconta)) {
                        oldCodpcOfContapagarCollectionNewContapagar.getContapagarCollection().remove(contapagarCollectionNewContapagar);
                        oldCodpcOfContapagarCollectionNewContapagar = em.merge(oldCodpcOfContapagarCollectionNewContapagar);
                    }
                }
            }
            for (Cheques chequesCollectionOldCheques : chequesCollectionOld) {
                if (!chequesCollectionNew.contains(chequesCollectionOldCheques)) {
                    chequesCollectionOldCheques.setCodpc(null);
                    chequesCollectionOldCheques = em.merge(chequesCollectionOldCheques);
                }
            }
            for (Cheques chequesCollectionNewCheques : chequesCollectionNew) {
                if (!chequesCollectionOld.contains(chequesCollectionNewCheques)) {
                    Planoconta oldCodpcOfChequesCollectionNewCheques = chequesCollectionNewCheques.getCodpc();
                    chequesCollectionNewCheques.setCodpc(planoconta);
                    chequesCollectionNewCheques = em.merge(chequesCollectionNewCheques);
                    if (oldCodpcOfChequesCollectionNewCheques != null && !oldCodpcOfChequesCollectionNewCheques.equals(planoconta)) {
                        oldCodpcOfChequesCollectionNewCheques.getChequesCollection().remove(chequesCollectionNewCheques);
                        oldCodpcOfChequesCollectionNewCheques = em.merge(oldCodpcOfChequesCollectionNewCheques);
                    }
                }
            }
            for (Contareceberfixa contareceberfixaCollectionOldContareceberfixa : contareceberfixaCollectionOld) {
                if (!contareceberfixaCollectionNew.contains(contareceberfixaCollectionOldContareceberfixa)) {
                    contareceberfixaCollectionOldContareceberfixa.setCodpc(null);
                    contareceberfixaCollectionOldContareceberfixa = em.merge(contareceberfixaCollectionOldContareceberfixa);
                }
            }
            for (Contareceberfixa contareceberfixaCollectionNewContareceberfixa : contareceberfixaCollectionNew) {
                if (!contareceberfixaCollectionOld.contains(contareceberfixaCollectionNewContareceberfixa)) {
                    Planoconta oldCodpcOfContareceberfixaCollectionNewContareceberfixa = contareceberfixaCollectionNewContareceberfixa.getCodpc();
                    contareceberfixaCollectionNewContareceberfixa.setCodpc(planoconta);
                    contareceberfixaCollectionNewContareceberfixa = em.merge(contareceberfixaCollectionNewContareceberfixa);
                    if (oldCodpcOfContareceberfixaCollectionNewContareceberfixa != null && !oldCodpcOfContareceberfixaCollectionNewContareceberfixa.equals(planoconta)) {
                        oldCodpcOfContareceberfixaCollectionNewContareceberfixa.getContareceberfixaCollection().remove(contareceberfixaCollectionNewContareceberfixa);
                        oldCodpcOfContareceberfixaCollectionNewContareceberfixa = em.merge(oldCodpcOfContareceberfixaCollectionNewContareceberfixa);
                    }
                }
            }
            for (Recebimento recebimentoCollectionOldRecebimento : recebimentoCollectionOld) {
                if (!recebimentoCollectionNew.contains(recebimentoCollectionOldRecebimento)) {
                    recebimentoCollectionOldRecebimento.setCodpc(null);
                    recebimentoCollectionOldRecebimento = em.merge(recebimentoCollectionOldRecebimento);
                }
            }
            for (Recebimento recebimentoCollectionNewRecebimento : recebimentoCollectionNew) {
                if (!recebimentoCollectionOld.contains(recebimentoCollectionNewRecebimento)) {
                    Planoconta oldCodpcOfRecebimentoCollectionNewRecebimento = recebimentoCollectionNewRecebimento.getCodpc();
                    recebimentoCollectionNewRecebimento.setCodpc(planoconta);
                    recebimentoCollectionNewRecebimento = em.merge(recebimentoCollectionNewRecebimento);
                    if (oldCodpcOfRecebimentoCollectionNewRecebimento != null && !oldCodpcOfRecebimentoCollectionNewRecebimento.equals(planoconta)) {
                        oldCodpcOfRecebimentoCollectionNewRecebimento.getRecebimentoCollection().remove(recebimentoCollectionNewRecebimento);
                        oldCodpcOfRecebimentoCollectionNewRecebimento = em.merge(oldCodpcOfRecebimentoCollectionNewRecebimento);
                    }
                }
            }
            for (Contareceber contareceberCollectionOldContareceber : contareceberCollectionOld) {
                if (!contareceberCollectionNew.contains(contareceberCollectionOldContareceber)) {
                    contareceberCollectionOldContareceber.setCodpc(null);
                    contareceberCollectionOldContareceber = em.merge(contareceberCollectionOldContareceber);
                }
            }
            for (Contareceber contareceberCollectionNewContareceber : contareceberCollectionNew) {
                if (!contareceberCollectionOld.contains(contareceberCollectionNewContareceber)) {
                    Planoconta oldCodpcOfContareceberCollectionNewContareceber = contareceberCollectionNewContareceber.getCodpc();
                    contareceberCollectionNewContareceber.setCodpc(planoconta);
                    contareceberCollectionNewContareceber = em.merge(contareceberCollectionNewContareceber);
                    if (oldCodpcOfContareceberCollectionNewContareceber != null && !oldCodpcOfContareceberCollectionNewContareceber.equals(planoconta)) {
                        oldCodpcOfContareceberCollectionNewContareceber.getContareceberCollection().remove(contareceberCollectionNewContareceber);
                        oldCodpcOfContareceberCollectionNewContareceber = em.merge(oldCodpcOfContareceberCollectionNewContareceber);
                    }
                }
            }
            for (Terminal terminalCollectionOldTerminal : terminalCollectionOld) {
                if (!terminalCollectionNew.contains(terminalCollectionOldTerminal)) {
                    terminalCollectionOldTerminal.setCodpc(null);
                    terminalCollectionOldTerminal = em.merge(terminalCollectionOldTerminal);
                }
            }
            for (Terminal terminalCollectionNewTerminal : terminalCollectionNew) {
                if (!terminalCollectionOld.contains(terminalCollectionNewTerminal)) {
                    Planoconta oldCodpcOfTerminalCollectionNewTerminal = terminalCollectionNewTerminal.getCodpc();
                    terminalCollectionNewTerminal.setCodpc(planoconta);
                    terminalCollectionNewTerminal = em.merge(terminalCollectionNewTerminal);
                    if (oldCodpcOfTerminalCollectionNewTerminal != null && !oldCodpcOfTerminalCollectionNewTerminal.equals(planoconta)) {
                        oldCodpcOfTerminalCollectionNewTerminal.getTerminalCollection().remove(terminalCollectionNewTerminal);
                        oldCodpcOfTerminalCollectionNewTerminal = em.merge(oldCodpcOfTerminalCollectionNewTerminal);
                    }
                }
            }
            for (Contapagarfixa contapagarfixaCollectionOldContapagarfixa : contapagarfixaCollectionOld) {
                if (!contapagarfixaCollectionNew.contains(contapagarfixaCollectionOldContapagarfixa)) {
                    contapagarfixaCollectionOldContapagarfixa.setCodpc(null);
                    contapagarfixaCollectionOldContapagarfixa = em.merge(contapagarfixaCollectionOldContapagarfixa);
                }
            }
            for (Contapagarfixa contapagarfixaCollectionNewContapagarfixa : contapagarfixaCollectionNew) {
                if (!contapagarfixaCollectionOld.contains(contapagarfixaCollectionNewContapagarfixa)) {
                    Planoconta oldCodpcOfContapagarfixaCollectionNewContapagarfixa = contapagarfixaCollectionNewContapagarfixa.getCodpc();
                    contapagarfixaCollectionNewContapagarfixa.setCodpc(planoconta);
                    contapagarfixaCollectionNewContapagarfixa = em.merge(contapagarfixaCollectionNewContapagarfixa);
                    if (oldCodpcOfContapagarfixaCollectionNewContapagarfixa != null && !oldCodpcOfContapagarfixaCollectionNewContapagarfixa.equals(planoconta)) {
                        oldCodpcOfContapagarfixaCollectionNewContapagarfixa.getContapagarfixaCollection().remove(contapagarfixaCollectionNewContapagarfixa);
                        oldCodpcOfContapagarfixaCollectionNewContapagarfixa = em.merge(oldCodpcOfContapagarfixaCollectionNewContapagarfixa);
                    }
                }
            }
            for (Contabancaria contabancariaCollectionOldContabancaria : contabancariaCollectionOld) {
                if (!contabancariaCollectionNew.contains(contabancariaCollectionOldContabancaria)) {
                    contabancariaCollectionOldContabancaria.setCodpc(null);
                    contabancariaCollectionOldContabancaria = em.merge(contabancariaCollectionOldContabancaria);
                }
            }
            for (Contabancaria contabancariaCollectionNewContabancaria : contabancariaCollectionNew) {
                if (!contabancariaCollectionOld.contains(contabancariaCollectionNewContabancaria)) {
                    Planoconta oldCodpcOfContabancariaCollectionNewContabancaria = contabancariaCollectionNewContabancaria.getCodpc();
                    contabancariaCollectionNewContabancaria.setCodpc(planoconta);
                    contabancariaCollectionNewContabancaria = em.merge(contabancariaCollectionNewContabancaria);
                    if (oldCodpcOfContabancariaCollectionNewContabancaria != null && !oldCodpcOfContabancariaCollectionNewContabancaria.equals(planoconta)) {
                        oldCodpcOfContabancariaCollectionNewContabancaria.getContabancariaCollection().remove(contabancariaCollectionNewContabancaria);
                        oldCodpcOfContabancariaCollectionNewContabancaria = em.merge(oldCodpcOfContabancariaCollectionNewContabancaria);
                    }
                }
            }
            for (Cliente clienteCollectionOldCliente : clienteCollectionOld) {
                if (!clienteCollectionNew.contains(clienteCollectionOldCliente)) {
                    clienteCollectionOldCliente.setCodpc(null);
                    clienteCollectionOldCliente = em.merge(clienteCollectionOldCliente);
                }
            }
            for (Cliente clienteCollectionNewCliente : clienteCollectionNew) {
                if (!clienteCollectionOld.contains(clienteCollectionNewCliente)) {
                    Planoconta oldCodpcOfClienteCollectionNewCliente = clienteCollectionNewCliente.getCodpc();
                    clienteCollectionNewCliente.setCodpc(planoconta);
                    clienteCollectionNewCliente = em.merge(clienteCollectionNewCliente);
                    if (oldCodpcOfClienteCollectionNewCliente != null && !oldCodpcOfClienteCollectionNewCliente.equals(planoconta)) {
                        oldCodpcOfClienteCollectionNewCliente.getClienteCollection().remove(clienteCollectionNewCliente);
                        oldCodpcOfClienteCollectionNewCliente = em.merge(oldCodpcOfClienteCollectionNewCliente);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = planoconta.getCodpc();
                if (findPlanoconta(id) == null) {
                    throw new NonexistentEntityException("The planoconta with id " + id + " no longer exists.");
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
            Planoconta planoconta;
            try {
                planoconta = em.getReference(Planoconta.class, id);
                planoconta.getCodpc();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The planoconta with id " + id + " no longer exists.", enfe);
            }
            Collection<Chequesfirma> chequesfirmaCollection = planoconta.getChequesfirmaCollection();
            for (Chequesfirma chequesfirmaCollectionChequesfirma : chequesfirmaCollection) {
                chequesfirmaCollectionChequesfirma.setCodpc(null);
                chequesfirmaCollectionChequesfirma = em.merge(chequesfirmaCollectionChequesfirma);
            }
            Collection<Caixa> caixaCollection = planoconta.getCaixaCollection();
            for (Caixa caixaCollectionCaixa : caixaCollection) {
                caixaCollectionCaixa.setCodpc(null);
                caixaCollectionCaixa = em.merge(caixaCollectionCaixa);
            }
            Collection<Contapagar> contapagarCollection = planoconta.getContapagarCollection();
            for (Contapagar contapagarCollectionContapagar : contapagarCollection) {
                contapagarCollectionContapagar.setCodpc(null);
                contapagarCollectionContapagar = em.merge(contapagarCollectionContapagar);
            }
            Collection<Cheques> chequesCollection = planoconta.getChequesCollection();
            for (Cheques chequesCollectionCheques : chequesCollection) {
                chequesCollectionCheques.setCodpc(null);
                chequesCollectionCheques = em.merge(chequesCollectionCheques);
            }
            Collection<Contareceberfixa> contareceberfixaCollection = planoconta.getContareceberfixaCollection();
            for (Contareceberfixa contareceberfixaCollectionContareceberfixa : contareceberfixaCollection) {
                contareceberfixaCollectionContareceberfixa.setCodpc(null);
                contareceberfixaCollectionContareceberfixa = em.merge(contareceberfixaCollectionContareceberfixa);
            }
            Collection<Recebimento> recebimentoCollection = planoconta.getRecebimentoCollection();
            for (Recebimento recebimentoCollectionRecebimento : recebimentoCollection) {
                recebimentoCollectionRecebimento.setCodpc(null);
                recebimentoCollectionRecebimento = em.merge(recebimentoCollectionRecebimento);
            }
            Collection<Contareceber> contareceberCollection = planoconta.getContareceberCollection();
            for (Contareceber contareceberCollectionContareceber : contareceberCollection) {
                contareceberCollectionContareceber.setCodpc(null);
                contareceberCollectionContareceber = em.merge(contareceberCollectionContareceber);
            }
            Collection<Terminal> terminalCollection = planoconta.getTerminalCollection();
            for (Terminal terminalCollectionTerminal : terminalCollection) {
                terminalCollectionTerminal.setCodpc(null);
                terminalCollectionTerminal = em.merge(terminalCollectionTerminal);
            }
            Collection<Contapagarfixa> contapagarfixaCollection = planoconta.getContapagarfixaCollection();
            for (Contapagarfixa contapagarfixaCollectionContapagarfixa : contapagarfixaCollection) {
                contapagarfixaCollectionContapagarfixa.setCodpc(null);
                contapagarfixaCollectionContapagarfixa = em.merge(contapagarfixaCollectionContapagarfixa);
            }
            Collection<Contabancaria> contabancariaCollection = planoconta.getContabancariaCollection();
            for (Contabancaria contabancariaCollectionContabancaria : contabancariaCollection) {
                contabancariaCollectionContabancaria.setCodpc(null);
                contabancariaCollectionContabancaria = em.merge(contabancariaCollectionContabancaria);
            }
            Collection<Cliente> clienteCollection = planoconta.getClienteCollection();
            for (Cliente clienteCollectionCliente : clienteCollection) {
                clienteCollectionCliente.setCodpc(null);
                clienteCollectionCliente = em.merge(clienteCollectionCliente);
            }
            em.remove(planoconta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Planoconta> findPlanocontaEntities() {
        return findPlanocontaEntities(true, -1, -1);
    }

    public List<Planoconta> findPlanocontaEntities(int maxResults, int firstResult) {
        return findPlanocontaEntities(false, maxResults, firstResult);
    }

    private List<Planoconta> findPlanocontaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Planoconta.class));
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

    public Planoconta findPlanoconta(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Planoconta.class, id);
        } finally {
            em.close();
        }
    }

    public int getPlanocontaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Planoconta> rt = cq.from(Planoconta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

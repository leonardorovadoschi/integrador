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
import entidade.cplus.Caixas;
import entidade.cplus.Contapagar;
import entidade.cplus.Cheques;
import entidade.cplus.Contareceber;
import entidade.cplus.Terminal;
import entidade.cplus.Contapagarfixa;
import entidade.cplus.Contabancaria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class CaixasJpaController implements Serializable {

    public CaixasJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Caixas caixas) throws PreexistingEntityException, Exception {
        if (caixas.getChequesfirmaCollection() == null) {
            caixas.setChequesfirmaCollection(new ArrayList<Chequesfirma>());
        }
        if (caixas.getCaixaCollection() == null) {
            caixas.setCaixaCollection(new ArrayList<Caixa>());
        }
        if (caixas.getContapagarCollection() == null) {
            caixas.setContapagarCollection(new ArrayList<Contapagar>());
        }
        if (caixas.getChequesCollection() == null) {
            caixas.setChequesCollection(new ArrayList<Cheques>());
        }
        if (caixas.getContareceberCollection() == null) {
            caixas.setContareceberCollection(new ArrayList<Contareceber>());
        }
        if (caixas.getTerminalCollection() == null) {
            caixas.setTerminalCollection(new ArrayList<Terminal>());
        }
        if (caixas.getContapagarfixaCollection() == null) {
            caixas.setContapagarfixaCollection(new ArrayList<Contapagarfixa>());
        }
        if (caixas.getContabancariaCollection() == null) {
            caixas.setContabancariaCollection(new ArrayList<Contabancaria>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Chequesfirma> attachedChequesfirmaCollection = new ArrayList<Chequesfirma>();
            for (Chequesfirma chequesfirmaCollectionChequesfirmaToAttach : caixas.getChequesfirmaCollection()) {
                chequesfirmaCollectionChequesfirmaToAttach = em.getReference(chequesfirmaCollectionChequesfirmaToAttach.getClass(), chequesfirmaCollectionChequesfirmaToAttach.getCodchequefirma());
                attachedChequesfirmaCollection.add(chequesfirmaCollectionChequesfirmaToAttach);
            }
            caixas.setChequesfirmaCollection(attachedChequesfirmaCollection);
            Collection<Caixa> attachedCaixaCollection = new ArrayList<Caixa>();
            for (Caixa caixaCollectionCaixaToAttach : caixas.getCaixaCollection()) {
                caixaCollectionCaixaToAttach = em.getReference(caixaCollectionCaixaToAttach.getClass(), caixaCollectionCaixaToAttach.getCodcaixa());
                attachedCaixaCollection.add(caixaCollectionCaixaToAttach);
            }
            caixas.setCaixaCollection(attachedCaixaCollection);
            Collection<Contapagar> attachedContapagarCollection = new ArrayList<Contapagar>();
            for (Contapagar contapagarCollectionContapagarToAttach : caixas.getContapagarCollection()) {
                contapagarCollectionContapagarToAttach = em.getReference(contapagarCollectionContapagarToAttach.getClass(), contapagarCollectionContapagarToAttach.getCodcp());
                attachedContapagarCollection.add(contapagarCollectionContapagarToAttach);
            }
            caixas.setContapagarCollection(attachedContapagarCollection);
            Collection<Cheques> attachedChequesCollection = new ArrayList<Cheques>();
            for (Cheques chequesCollectionChequesToAttach : caixas.getChequesCollection()) {
                chequesCollectionChequesToAttach = em.getReference(chequesCollectionChequesToAttach.getClass(), chequesCollectionChequesToAttach.getCodcheque());
                attachedChequesCollection.add(chequesCollectionChequesToAttach);
            }
            caixas.setChequesCollection(attachedChequesCollection);
            Collection<Contareceber> attachedContareceberCollection = new ArrayList<Contareceber>();
            for (Contareceber contareceberCollectionContareceberToAttach : caixas.getContareceberCollection()) {
                contareceberCollectionContareceberToAttach = em.getReference(contareceberCollectionContareceberToAttach.getClass(), contareceberCollectionContareceberToAttach.getCodcr());
                attachedContareceberCollection.add(contareceberCollectionContareceberToAttach);
            }
            caixas.setContareceberCollection(attachedContareceberCollection);
            Collection<Terminal> attachedTerminalCollection = new ArrayList<Terminal>();
            for (Terminal terminalCollectionTerminalToAttach : caixas.getTerminalCollection()) {
                terminalCollectionTerminalToAttach = em.getReference(terminalCollectionTerminalToAttach.getClass(), terminalCollectionTerminalToAttach.getCodterminal());
                attachedTerminalCollection.add(terminalCollectionTerminalToAttach);
            }
            caixas.setTerminalCollection(attachedTerminalCollection);
            Collection<Contapagarfixa> attachedContapagarfixaCollection = new ArrayList<Contapagarfixa>();
            for (Contapagarfixa contapagarfixaCollectionContapagarfixaToAttach : caixas.getContapagarfixaCollection()) {
                contapagarfixaCollectionContapagarfixaToAttach = em.getReference(contapagarfixaCollectionContapagarfixaToAttach.getClass(), contapagarfixaCollectionContapagarfixaToAttach.getCodcpfixa());
                attachedContapagarfixaCollection.add(contapagarfixaCollectionContapagarfixaToAttach);
            }
            caixas.setContapagarfixaCollection(attachedContapagarfixaCollection);
            Collection<Contabancaria> attachedContabancariaCollection = new ArrayList<Contabancaria>();
            for (Contabancaria contabancariaCollectionContabancariaToAttach : caixas.getContabancariaCollection()) {
                contabancariaCollectionContabancariaToAttach = em.getReference(contabancariaCollectionContabancariaToAttach.getClass(), contabancariaCollectionContabancariaToAttach.getCodcontabancaria());
                attachedContabancariaCollection.add(contabancariaCollectionContabancariaToAttach);
            }
            caixas.setContabancariaCollection(attachedContabancariaCollection);
            em.persist(caixas);
            for (Chequesfirma chequesfirmaCollectionChequesfirma : caixas.getChequesfirmaCollection()) {
                Caixas oldCodcaixasOfChequesfirmaCollectionChequesfirma = chequesfirmaCollectionChequesfirma.getCodcaixas();
                chequesfirmaCollectionChequesfirma.setCodcaixas(caixas);
                chequesfirmaCollectionChequesfirma = em.merge(chequesfirmaCollectionChequesfirma);
                if (oldCodcaixasOfChequesfirmaCollectionChequesfirma != null) {
                    oldCodcaixasOfChequesfirmaCollectionChequesfirma.getChequesfirmaCollection().remove(chequesfirmaCollectionChequesfirma);
                    oldCodcaixasOfChequesfirmaCollectionChequesfirma = em.merge(oldCodcaixasOfChequesfirmaCollectionChequesfirma);
                }
            }
            for (Caixa caixaCollectionCaixa : caixas.getCaixaCollection()) {
                Caixas oldCodcaixasOfCaixaCollectionCaixa = caixaCollectionCaixa.getCodcaixas();
                caixaCollectionCaixa.setCodcaixas(caixas);
                caixaCollectionCaixa = em.merge(caixaCollectionCaixa);
                if (oldCodcaixasOfCaixaCollectionCaixa != null) {
                    oldCodcaixasOfCaixaCollectionCaixa.getCaixaCollection().remove(caixaCollectionCaixa);
                    oldCodcaixasOfCaixaCollectionCaixa = em.merge(oldCodcaixasOfCaixaCollectionCaixa);
                }
            }
            for (Contapagar contapagarCollectionContapagar : caixas.getContapagarCollection()) {
                Caixas oldCodcaixasOfContapagarCollectionContapagar = contapagarCollectionContapagar.getCodcaixas();
                contapagarCollectionContapagar.setCodcaixas(caixas);
                contapagarCollectionContapagar = em.merge(contapagarCollectionContapagar);
                if (oldCodcaixasOfContapagarCollectionContapagar != null) {
                    oldCodcaixasOfContapagarCollectionContapagar.getContapagarCollection().remove(contapagarCollectionContapagar);
                    oldCodcaixasOfContapagarCollectionContapagar = em.merge(oldCodcaixasOfContapagarCollectionContapagar);
                }
            }
            for (Cheques chequesCollectionCheques : caixas.getChequesCollection()) {
                Caixas oldCodcaixasOfChequesCollectionCheques = chequesCollectionCheques.getCodcaixas();
                chequesCollectionCheques.setCodcaixas(caixas);
                chequesCollectionCheques = em.merge(chequesCollectionCheques);
                if (oldCodcaixasOfChequesCollectionCheques != null) {
                    oldCodcaixasOfChequesCollectionCheques.getChequesCollection().remove(chequesCollectionCheques);
                    oldCodcaixasOfChequesCollectionCheques = em.merge(oldCodcaixasOfChequesCollectionCheques);
                }
            }
            for (Contareceber contareceberCollectionContareceber : caixas.getContareceberCollection()) {
                Caixas oldCodcaixasOfContareceberCollectionContareceber = contareceberCollectionContareceber.getCodcaixas();
                contareceberCollectionContareceber.setCodcaixas(caixas);
                contareceberCollectionContareceber = em.merge(contareceberCollectionContareceber);
                if (oldCodcaixasOfContareceberCollectionContareceber != null) {
                    oldCodcaixasOfContareceberCollectionContareceber.getContareceberCollection().remove(contareceberCollectionContareceber);
                    oldCodcaixasOfContareceberCollectionContareceber = em.merge(oldCodcaixasOfContareceberCollectionContareceber);
                }
            }
            for (Terminal terminalCollectionTerminal : caixas.getTerminalCollection()) {
                Caixas oldCodcaixasOfTerminalCollectionTerminal = terminalCollectionTerminal.getCodcaixas();
                terminalCollectionTerminal.setCodcaixas(caixas);
                terminalCollectionTerminal = em.merge(terminalCollectionTerminal);
                if (oldCodcaixasOfTerminalCollectionTerminal != null) {
                    oldCodcaixasOfTerminalCollectionTerminal.getTerminalCollection().remove(terminalCollectionTerminal);
                    oldCodcaixasOfTerminalCollectionTerminal = em.merge(oldCodcaixasOfTerminalCollectionTerminal);
                }
            }
            for (Contapagarfixa contapagarfixaCollectionContapagarfixa : caixas.getContapagarfixaCollection()) {
                Caixas oldCodcaixasOfContapagarfixaCollectionContapagarfixa = contapagarfixaCollectionContapagarfixa.getCodcaixas();
                contapagarfixaCollectionContapagarfixa.setCodcaixas(caixas);
                contapagarfixaCollectionContapagarfixa = em.merge(contapagarfixaCollectionContapagarfixa);
                if (oldCodcaixasOfContapagarfixaCollectionContapagarfixa != null) {
                    oldCodcaixasOfContapagarfixaCollectionContapagarfixa.getContapagarfixaCollection().remove(contapagarfixaCollectionContapagarfixa);
                    oldCodcaixasOfContapagarfixaCollectionContapagarfixa = em.merge(oldCodcaixasOfContapagarfixaCollectionContapagarfixa);
                }
            }
            for (Contabancaria contabancariaCollectionContabancaria : caixas.getContabancariaCollection()) {
                Caixas oldCodcaixasOfContabancariaCollectionContabancaria = contabancariaCollectionContabancaria.getCodcaixas();
                contabancariaCollectionContabancaria.setCodcaixas(caixas);
                contabancariaCollectionContabancaria = em.merge(contabancariaCollectionContabancaria);
                if (oldCodcaixasOfContabancariaCollectionContabancaria != null) {
                    oldCodcaixasOfContabancariaCollectionContabancaria.getContabancariaCollection().remove(contabancariaCollectionContabancaria);
                    oldCodcaixasOfContabancariaCollectionContabancaria = em.merge(oldCodcaixasOfContabancariaCollectionContabancaria);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCaixas(caixas.getCodcaixas()) != null) {
                throw new PreexistingEntityException("Caixas " + caixas + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Caixas caixas) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Caixas persistentCaixas = em.find(Caixas.class, caixas.getCodcaixas());
            Collection<Chequesfirma> chequesfirmaCollectionOld = persistentCaixas.getChequesfirmaCollection();
            Collection<Chequesfirma> chequesfirmaCollectionNew = caixas.getChequesfirmaCollection();
            Collection<Caixa> caixaCollectionOld = persistentCaixas.getCaixaCollection();
            Collection<Caixa> caixaCollectionNew = caixas.getCaixaCollection();
            Collection<Contapagar> contapagarCollectionOld = persistentCaixas.getContapagarCollection();
            Collection<Contapagar> contapagarCollectionNew = caixas.getContapagarCollection();
            Collection<Cheques> chequesCollectionOld = persistentCaixas.getChequesCollection();
            Collection<Cheques> chequesCollectionNew = caixas.getChequesCollection();
            Collection<Contareceber> contareceberCollectionOld = persistentCaixas.getContareceberCollection();
            Collection<Contareceber> contareceberCollectionNew = caixas.getContareceberCollection();
            Collection<Terminal> terminalCollectionOld = persistentCaixas.getTerminalCollection();
            Collection<Terminal> terminalCollectionNew = caixas.getTerminalCollection();
            Collection<Contapagarfixa> contapagarfixaCollectionOld = persistentCaixas.getContapagarfixaCollection();
            Collection<Contapagarfixa> contapagarfixaCollectionNew = caixas.getContapagarfixaCollection();
            Collection<Contabancaria> contabancariaCollectionOld = persistentCaixas.getContabancariaCollection();
            Collection<Contabancaria> contabancariaCollectionNew = caixas.getContabancariaCollection();
            Collection<Chequesfirma> attachedChequesfirmaCollectionNew = new ArrayList<Chequesfirma>();
            for (Chequesfirma chequesfirmaCollectionNewChequesfirmaToAttach : chequesfirmaCollectionNew) {
                chequesfirmaCollectionNewChequesfirmaToAttach = em.getReference(chequesfirmaCollectionNewChequesfirmaToAttach.getClass(), chequesfirmaCollectionNewChequesfirmaToAttach.getCodchequefirma());
                attachedChequesfirmaCollectionNew.add(chequesfirmaCollectionNewChequesfirmaToAttach);
            }
            chequesfirmaCollectionNew = attachedChequesfirmaCollectionNew;
            caixas.setChequesfirmaCollection(chequesfirmaCollectionNew);
            Collection<Caixa> attachedCaixaCollectionNew = new ArrayList<Caixa>();
            for (Caixa caixaCollectionNewCaixaToAttach : caixaCollectionNew) {
                caixaCollectionNewCaixaToAttach = em.getReference(caixaCollectionNewCaixaToAttach.getClass(), caixaCollectionNewCaixaToAttach.getCodcaixa());
                attachedCaixaCollectionNew.add(caixaCollectionNewCaixaToAttach);
            }
            caixaCollectionNew = attachedCaixaCollectionNew;
            caixas.setCaixaCollection(caixaCollectionNew);
            Collection<Contapagar> attachedContapagarCollectionNew = new ArrayList<Contapagar>();
            for (Contapagar contapagarCollectionNewContapagarToAttach : contapagarCollectionNew) {
                contapagarCollectionNewContapagarToAttach = em.getReference(contapagarCollectionNewContapagarToAttach.getClass(), contapagarCollectionNewContapagarToAttach.getCodcp());
                attachedContapagarCollectionNew.add(contapagarCollectionNewContapagarToAttach);
            }
            contapagarCollectionNew = attachedContapagarCollectionNew;
            caixas.setContapagarCollection(contapagarCollectionNew);
            Collection<Cheques> attachedChequesCollectionNew = new ArrayList<Cheques>();
            for (Cheques chequesCollectionNewChequesToAttach : chequesCollectionNew) {
                chequesCollectionNewChequesToAttach = em.getReference(chequesCollectionNewChequesToAttach.getClass(), chequesCollectionNewChequesToAttach.getCodcheque());
                attachedChequesCollectionNew.add(chequesCollectionNewChequesToAttach);
            }
            chequesCollectionNew = attachedChequesCollectionNew;
            caixas.setChequesCollection(chequesCollectionNew);
            Collection<Contareceber> attachedContareceberCollectionNew = new ArrayList<Contareceber>();
            for (Contareceber contareceberCollectionNewContareceberToAttach : contareceberCollectionNew) {
                contareceberCollectionNewContareceberToAttach = em.getReference(contareceberCollectionNewContareceberToAttach.getClass(), contareceberCollectionNewContareceberToAttach.getCodcr());
                attachedContareceberCollectionNew.add(contareceberCollectionNewContareceberToAttach);
            }
            contareceberCollectionNew = attachedContareceberCollectionNew;
            caixas.setContareceberCollection(contareceberCollectionNew);
            Collection<Terminal> attachedTerminalCollectionNew = new ArrayList<Terminal>();
            for (Terminal terminalCollectionNewTerminalToAttach : terminalCollectionNew) {
                terminalCollectionNewTerminalToAttach = em.getReference(terminalCollectionNewTerminalToAttach.getClass(), terminalCollectionNewTerminalToAttach.getCodterminal());
                attachedTerminalCollectionNew.add(terminalCollectionNewTerminalToAttach);
            }
            terminalCollectionNew = attachedTerminalCollectionNew;
            caixas.setTerminalCollection(terminalCollectionNew);
            Collection<Contapagarfixa> attachedContapagarfixaCollectionNew = new ArrayList<Contapagarfixa>();
            for (Contapagarfixa contapagarfixaCollectionNewContapagarfixaToAttach : contapagarfixaCollectionNew) {
                contapagarfixaCollectionNewContapagarfixaToAttach = em.getReference(contapagarfixaCollectionNewContapagarfixaToAttach.getClass(), contapagarfixaCollectionNewContapagarfixaToAttach.getCodcpfixa());
                attachedContapagarfixaCollectionNew.add(contapagarfixaCollectionNewContapagarfixaToAttach);
            }
            contapagarfixaCollectionNew = attachedContapagarfixaCollectionNew;
            caixas.setContapagarfixaCollection(contapagarfixaCollectionNew);
            Collection<Contabancaria> attachedContabancariaCollectionNew = new ArrayList<Contabancaria>();
            for (Contabancaria contabancariaCollectionNewContabancariaToAttach : contabancariaCollectionNew) {
                contabancariaCollectionNewContabancariaToAttach = em.getReference(contabancariaCollectionNewContabancariaToAttach.getClass(), contabancariaCollectionNewContabancariaToAttach.getCodcontabancaria());
                attachedContabancariaCollectionNew.add(contabancariaCollectionNewContabancariaToAttach);
            }
            contabancariaCollectionNew = attachedContabancariaCollectionNew;
            caixas.setContabancariaCollection(contabancariaCollectionNew);
            caixas = em.merge(caixas);
            for (Chequesfirma chequesfirmaCollectionOldChequesfirma : chequesfirmaCollectionOld) {
                if (!chequesfirmaCollectionNew.contains(chequesfirmaCollectionOldChequesfirma)) {
                    chequesfirmaCollectionOldChequesfirma.setCodcaixas(null);
                    chequesfirmaCollectionOldChequesfirma = em.merge(chequesfirmaCollectionOldChequesfirma);
                }
            }
            for (Chequesfirma chequesfirmaCollectionNewChequesfirma : chequesfirmaCollectionNew) {
                if (!chequesfirmaCollectionOld.contains(chequesfirmaCollectionNewChequesfirma)) {
                    Caixas oldCodcaixasOfChequesfirmaCollectionNewChequesfirma = chequesfirmaCollectionNewChequesfirma.getCodcaixas();
                    chequesfirmaCollectionNewChequesfirma.setCodcaixas(caixas);
                    chequesfirmaCollectionNewChequesfirma = em.merge(chequesfirmaCollectionNewChequesfirma);
                    if (oldCodcaixasOfChequesfirmaCollectionNewChequesfirma != null && !oldCodcaixasOfChequesfirmaCollectionNewChequesfirma.equals(caixas)) {
                        oldCodcaixasOfChequesfirmaCollectionNewChequesfirma.getChequesfirmaCollection().remove(chequesfirmaCollectionNewChequesfirma);
                        oldCodcaixasOfChequesfirmaCollectionNewChequesfirma = em.merge(oldCodcaixasOfChequesfirmaCollectionNewChequesfirma);
                    }
                }
            }
            for (Caixa caixaCollectionOldCaixa : caixaCollectionOld) {
                if (!caixaCollectionNew.contains(caixaCollectionOldCaixa)) {
                    caixaCollectionOldCaixa.setCodcaixas(null);
                    caixaCollectionOldCaixa = em.merge(caixaCollectionOldCaixa);
                }
            }
            for (Caixa caixaCollectionNewCaixa : caixaCollectionNew) {
                if (!caixaCollectionOld.contains(caixaCollectionNewCaixa)) {
                    Caixas oldCodcaixasOfCaixaCollectionNewCaixa = caixaCollectionNewCaixa.getCodcaixas();
                    caixaCollectionNewCaixa.setCodcaixas(caixas);
                    caixaCollectionNewCaixa = em.merge(caixaCollectionNewCaixa);
                    if (oldCodcaixasOfCaixaCollectionNewCaixa != null && !oldCodcaixasOfCaixaCollectionNewCaixa.equals(caixas)) {
                        oldCodcaixasOfCaixaCollectionNewCaixa.getCaixaCollection().remove(caixaCollectionNewCaixa);
                        oldCodcaixasOfCaixaCollectionNewCaixa = em.merge(oldCodcaixasOfCaixaCollectionNewCaixa);
                    }
                }
            }
            for (Contapagar contapagarCollectionOldContapagar : contapagarCollectionOld) {
                if (!contapagarCollectionNew.contains(contapagarCollectionOldContapagar)) {
                    contapagarCollectionOldContapagar.setCodcaixas(null);
                    contapagarCollectionOldContapagar = em.merge(contapagarCollectionOldContapagar);
                }
            }
            for (Contapagar contapagarCollectionNewContapagar : contapagarCollectionNew) {
                if (!contapagarCollectionOld.contains(contapagarCollectionNewContapagar)) {
                    Caixas oldCodcaixasOfContapagarCollectionNewContapagar = contapagarCollectionNewContapagar.getCodcaixas();
                    contapagarCollectionNewContapagar.setCodcaixas(caixas);
                    contapagarCollectionNewContapagar = em.merge(contapagarCollectionNewContapagar);
                    if (oldCodcaixasOfContapagarCollectionNewContapagar != null && !oldCodcaixasOfContapagarCollectionNewContapagar.equals(caixas)) {
                        oldCodcaixasOfContapagarCollectionNewContapagar.getContapagarCollection().remove(contapagarCollectionNewContapagar);
                        oldCodcaixasOfContapagarCollectionNewContapagar = em.merge(oldCodcaixasOfContapagarCollectionNewContapagar);
                    }
                }
            }
            for (Cheques chequesCollectionOldCheques : chequesCollectionOld) {
                if (!chequesCollectionNew.contains(chequesCollectionOldCheques)) {
                    chequesCollectionOldCheques.setCodcaixas(null);
                    chequesCollectionOldCheques = em.merge(chequesCollectionOldCheques);
                }
            }
            for (Cheques chequesCollectionNewCheques : chequesCollectionNew) {
                if (!chequesCollectionOld.contains(chequesCollectionNewCheques)) {
                    Caixas oldCodcaixasOfChequesCollectionNewCheques = chequesCollectionNewCheques.getCodcaixas();
                    chequesCollectionNewCheques.setCodcaixas(caixas);
                    chequesCollectionNewCheques = em.merge(chequesCollectionNewCheques);
                    if (oldCodcaixasOfChequesCollectionNewCheques != null && !oldCodcaixasOfChequesCollectionNewCheques.equals(caixas)) {
                        oldCodcaixasOfChequesCollectionNewCheques.getChequesCollection().remove(chequesCollectionNewCheques);
                        oldCodcaixasOfChequesCollectionNewCheques = em.merge(oldCodcaixasOfChequesCollectionNewCheques);
                    }
                }
            }
            for (Contareceber contareceberCollectionOldContareceber : contareceberCollectionOld) {
                if (!contareceberCollectionNew.contains(contareceberCollectionOldContareceber)) {
                    contareceberCollectionOldContareceber.setCodcaixas(null);
                    contareceberCollectionOldContareceber = em.merge(contareceberCollectionOldContareceber);
                }
            }
            for (Contareceber contareceberCollectionNewContareceber : contareceberCollectionNew) {
                if (!contareceberCollectionOld.contains(contareceberCollectionNewContareceber)) {
                    Caixas oldCodcaixasOfContareceberCollectionNewContareceber = contareceberCollectionNewContareceber.getCodcaixas();
                    contareceberCollectionNewContareceber.setCodcaixas(caixas);
                    contareceberCollectionNewContareceber = em.merge(contareceberCollectionNewContareceber);
                    if (oldCodcaixasOfContareceberCollectionNewContareceber != null && !oldCodcaixasOfContareceberCollectionNewContareceber.equals(caixas)) {
                        oldCodcaixasOfContareceberCollectionNewContareceber.getContareceberCollection().remove(contareceberCollectionNewContareceber);
                        oldCodcaixasOfContareceberCollectionNewContareceber = em.merge(oldCodcaixasOfContareceberCollectionNewContareceber);
                    }
                }
            }
            for (Terminal terminalCollectionOldTerminal : terminalCollectionOld) {
                if (!terminalCollectionNew.contains(terminalCollectionOldTerminal)) {
                    terminalCollectionOldTerminal.setCodcaixas(null);
                    terminalCollectionOldTerminal = em.merge(terminalCollectionOldTerminal);
                }
            }
            for (Terminal terminalCollectionNewTerminal : terminalCollectionNew) {
                if (!terminalCollectionOld.contains(terminalCollectionNewTerminal)) {
                    Caixas oldCodcaixasOfTerminalCollectionNewTerminal = terminalCollectionNewTerminal.getCodcaixas();
                    terminalCollectionNewTerminal.setCodcaixas(caixas);
                    terminalCollectionNewTerminal = em.merge(terminalCollectionNewTerminal);
                    if (oldCodcaixasOfTerminalCollectionNewTerminal != null && !oldCodcaixasOfTerminalCollectionNewTerminal.equals(caixas)) {
                        oldCodcaixasOfTerminalCollectionNewTerminal.getTerminalCollection().remove(terminalCollectionNewTerminal);
                        oldCodcaixasOfTerminalCollectionNewTerminal = em.merge(oldCodcaixasOfTerminalCollectionNewTerminal);
                    }
                }
            }
            for (Contapagarfixa contapagarfixaCollectionOldContapagarfixa : contapagarfixaCollectionOld) {
                if (!contapagarfixaCollectionNew.contains(contapagarfixaCollectionOldContapagarfixa)) {
                    contapagarfixaCollectionOldContapagarfixa.setCodcaixas(null);
                    contapagarfixaCollectionOldContapagarfixa = em.merge(contapagarfixaCollectionOldContapagarfixa);
                }
            }
            for (Contapagarfixa contapagarfixaCollectionNewContapagarfixa : contapagarfixaCollectionNew) {
                if (!contapagarfixaCollectionOld.contains(contapagarfixaCollectionNewContapagarfixa)) {
                    Caixas oldCodcaixasOfContapagarfixaCollectionNewContapagarfixa = contapagarfixaCollectionNewContapagarfixa.getCodcaixas();
                    contapagarfixaCollectionNewContapagarfixa.setCodcaixas(caixas);
                    contapagarfixaCollectionNewContapagarfixa = em.merge(contapagarfixaCollectionNewContapagarfixa);
                    if (oldCodcaixasOfContapagarfixaCollectionNewContapagarfixa != null && !oldCodcaixasOfContapagarfixaCollectionNewContapagarfixa.equals(caixas)) {
                        oldCodcaixasOfContapagarfixaCollectionNewContapagarfixa.getContapagarfixaCollection().remove(contapagarfixaCollectionNewContapagarfixa);
                        oldCodcaixasOfContapagarfixaCollectionNewContapagarfixa = em.merge(oldCodcaixasOfContapagarfixaCollectionNewContapagarfixa);
                    }
                }
            }
            for (Contabancaria contabancariaCollectionOldContabancaria : contabancariaCollectionOld) {
                if (!contabancariaCollectionNew.contains(contabancariaCollectionOldContabancaria)) {
                    contabancariaCollectionOldContabancaria.setCodcaixas(null);
                    contabancariaCollectionOldContabancaria = em.merge(contabancariaCollectionOldContabancaria);
                }
            }
            for (Contabancaria contabancariaCollectionNewContabancaria : contabancariaCollectionNew) {
                if (!contabancariaCollectionOld.contains(contabancariaCollectionNewContabancaria)) {
                    Caixas oldCodcaixasOfContabancariaCollectionNewContabancaria = contabancariaCollectionNewContabancaria.getCodcaixas();
                    contabancariaCollectionNewContabancaria.setCodcaixas(caixas);
                    contabancariaCollectionNewContabancaria = em.merge(contabancariaCollectionNewContabancaria);
                    if (oldCodcaixasOfContabancariaCollectionNewContabancaria != null && !oldCodcaixasOfContabancariaCollectionNewContabancaria.equals(caixas)) {
                        oldCodcaixasOfContabancariaCollectionNewContabancaria.getContabancariaCollection().remove(contabancariaCollectionNewContabancaria);
                        oldCodcaixasOfContabancariaCollectionNewContabancaria = em.merge(oldCodcaixasOfContabancariaCollectionNewContabancaria);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = caixas.getCodcaixas();
                if (findCaixas(id) == null) {
                    throw new NonexistentEntityException("The caixas with id " + id + " no longer exists.");
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
            Caixas caixas;
            try {
                caixas = em.getReference(Caixas.class, id);
                caixas.getCodcaixas();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The caixas with id " + id + " no longer exists.", enfe);
            }
            Collection<Chequesfirma> chequesfirmaCollection = caixas.getChequesfirmaCollection();
            for (Chequesfirma chequesfirmaCollectionChequesfirma : chequesfirmaCollection) {
                chequesfirmaCollectionChequesfirma.setCodcaixas(null);
                chequesfirmaCollectionChequesfirma = em.merge(chequesfirmaCollectionChequesfirma);
            }
            Collection<Caixa> caixaCollection = caixas.getCaixaCollection();
            for (Caixa caixaCollectionCaixa : caixaCollection) {
                caixaCollectionCaixa.setCodcaixas(null);
                caixaCollectionCaixa = em.merge(caixaCollectionCaixa);
            }
            Collection<Contapagar> contapagarCollection = caixas.getContapagarCollection();
            for (Contapagar contapagarCollectionContapagar : contapagarCollection) {
                contapagarCollectionContapagar.setCodcaixas(null);
                contapagarCollectionContapagar = em.merge(contapagarCollectionContapagar);
            }
            Collection<Cheques> chequesCollection = caixas.getChequesCollection();
            for (Cheques chequesCollectionCheques : chequesCollection) {
                chequesCollectionCheques.setCodcaixas(null);
                chequesCollectionCheques = em.merge(chequesCollectionCheques);
            }
            Collection<Contareceber> contareceberCollection = caixas.getContareceberCollection();
            for (Contareceber contareceberCollectionContareceber : contareceberCollection) {
                contareceberCollectionContareceber.setCodcaixas(null);
                contareceberCollectionContareceber = em.merge(contareceberCollectionContareceber);
            }
            Collection<Terminal> terminalCollection = caixas.getTerminalCollection();
            for (Terminal terminalCollectionTerminal : terminalCollection) {
                terminalCollectionTerminal.setCodcaixas(null);
                terminalCollectionTerminal = em.merge(terminalCollectionTerminal);
            }
            Collection<Contapagarfixa> contapagarfixaCollection = caixas.getContapagarfixaCollection();
            for (Contapagarfixa contapagarfixaCollectionContapagarfixa : contapagarfixaCollection) {
                contapagarfixaCollectionContapagarfixa.setCodcaixas(null);
                contapagarfixaCollectionContapagarfixa = em.merge(contapagarfixaCollectionContapagarfixa);
            }
            Collection<Contabancaria> contabancariaCollection = caixas.getContabancariaCollection();
            for (Contabancaria contabancariaCollectionContabancaria : contabancariaCollection) {
                contabancariaCollectionContabancaria.setCodcaixas(null);
                contabancariaCollectionContabancaria = em.merge(contabancariaCollectionContabancaria);
            }
            em.remove(caixas);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Caixas> findCaixasEntities() {
        return findCaixasEntities(true, -1, -1);
    }

    public List<Caixas> findCaixasEntities(int maxResults, int firstResult) {
        return findCaixasEntities(false, maxResults, firstResult);
    }

    private List<Caixas> findCaixasEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Caixas.class));
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

    public Caixas findCaixas(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Caixas.class, id);
        } finally {
            em.close();
        }
    }

    public int getCaixasCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Caixas> rt = cq.from(Caixas.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

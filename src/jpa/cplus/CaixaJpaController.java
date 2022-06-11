/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Caixa;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Caixas;
import entidade.cplus.Cliente;
import entidade.cplus.Empresa;
import entidade.cplus.Planoconta;
import entidade.cplus.Chequesfirma;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Contapagarpag;
import entidade.cplus.Contapagar;
import entidade.cplus.Contareceberrec;
import entidade.cplus.Cheques;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class CaixaJpaController implements Serializable {

    public CaixaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Caixa caixa) throws PreexistingEntityException, Exception {
        if (caixa.getChequesfirmaCollection() == null) {
            caixa.setChequesfirmaCollection(new ArrayList<Chequesfirma>());
        }
        if (caixa.getContapagarpagCollection() == null) {
            caixa.setContapagarpagCollection(new ArrayList<Contapagarpag>());
        }
        if (caixa.getContapagarCollection() == null) {
            caixa.setContapagarCollection(new ArrayList<Contapagar>());
        }
        if (caixa.getContareceberrecCollection() == null) {
            caixa.setContareceberrecCollection(new ArrayList<Contareceberrec>());
        }
        if (caixa.getChequesCollection() == null) {
            caixa.setChequesCollection(new ArrayList<Cheques>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Caixas codcaixas = caixa.getCodcaixas();
            if (codcaixas != null) {
                codcaixas = em.getReference(codcaixas.getClass(), codcaixas.getCodcaixas());
                caixa.setCodcaixas(codcaixas);
            }
            Cliente codcli = caixa.getCodcli();
            if (codcli != null) {
                codcli = em.getReference(codcli.getClass(), codcli.getCodcli());
                caixa.setCodcli(codcli);
            }
            Empresa codempresa = caixa.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                caixa.setCodempresa(codempresa);
            }
            Planoconta codpc = caixa.getCodpc();
            if (codpc != null) {
                codpc = em.getReference(codpc.getClass(), codpc.getCodpc());
                caixa.setCodpc(codpc);
            }
            Collection<Chequesfirma> attachedChequesfirmaCollection = new ArrayList<Chequesfirma>();
            for (Chequesfirma chequesfirmaCollectionChequesfirmaToAttach : caixa.getChequesfirmaCollection()) {
                chequesfirmaCollectionChequesfirmaToAttach = em.getReference(chequesfirmaCollectionChequesfirmaToAttach.getClass(), chequesfirmaCollectionChequesfirmaToAttach.getCodchequefirma());
                attachedChequesfirmaCollection.add(chequesfirmaCollectionChequesfirmaToAttach);
            }
            caixa.setChequesfirmaCollection(attachedChequesfirmaCollection);
            Collection<Contapagarpag> attachedContapagarpagCollection = new ArrayList<Contapagarpag>();
            for (Contapagarpag contapagarpagCollectionContapagarpagToAttach : caixa.getContapagarpagCollection()) {
                contapagarpagCollectionContapagarpagToAttach = em.getReference(contapagarpagCollectionContapagarpagToAttach.getClass(), contapagarpagCollectionContapagarpagToAttach.getId());
                attachedContapagarpagCollection.add(contapagarpagCollectionContapagarpagToAttach);
            }
            caixa.setContapagarpagCollection(attachedContapagarpagCollection);
            Collection<Contapagar> attachedContapagarCollection = new ArrayList<Contapagar>();
            for (Contapagar contapagarCollectionContapagarToAttach : caixa.getContapagarCollection()) {
                contapagarCollectionContapagarToAttach = em.getReference(contapagarCollectionContapagarToAttach.getClass(), contapagarCollectionContapagarToAttach.getCodcp());
                attachedContapagarCollection.add(contapagarCollectionContapagarToAttach);
            }
            caixa.setContapagarCollection(attachedContapagarCollection);
            Collection<Contareceberrec> attachedContareceberrecCollection = new ArrayList<Contareceberrec>();
            for (Contareceberrec contareceberrecCollectionContareceberrecToAttach : caixa.getContareceberrecCollection()) {
                contareceberrecCollectionContareceberrecToAttach = em.getReference(contareceberrecCollectionContareceberrecToAttach.getClass(), contareceberrecCollectionContareceberrecToAttach.getId());
                attachedContareceberrecCollection.add(contareceberrecCollectionContareceberrecToAttach);
            }
            caixa.setContareceberrecCollection(attachedContareceberrecCollection);
            Collection<Cheques> attachedChequesCollection = new ArrayList<Cheques>();
            for (Cheques chequesCollectionChequesToAttach : caixa.getChequesCollection()) {
                chequesCollectionChequesToAttach = em.getReference(chequesCollectionChequesToAttach.getClass(), chequesCollectionChequesToAttach.getCodcheque());
                attachedChequesCollection.add(chequesCollectionChequesToAttach);
            }
            caixa.setChequesCollection(attachedChequesCollection);
            em.persist(caixa);
            if (codcaixas != null) {
                codcaixas.getCaixaCollection().add(caixa);
                codcaixas = em.merge(codcaixas);
            }
            if (codcli != null) {
                codcli.getCaixaCollection().add(caixa);
                codcli = em.merge(codcli);
            }
            if (codempresa != null) {
                codempresa.getCaixaCollection().add(caixa);
                codempresa = em.merge(codempresa);
            }
            if (codpc != null) {
                codpc.getCaixaCollection().add(caixa);
                codpc = em.merge(codpc);
            }
            for (Chequesfirma chequesfirmaCollectionChequesfirma : caixa.getChequesfirmaCollection()) {
                Caixa oldCodcaixaOfChequesfirmaCollectionChequesfirma = chequesfirmaCollectionChequesfirma.getCodcaixa();
                chequesfirmaCollectionChequesfirma.setCodcaixa(caixa);
                chequesfirmaCollectionChequesfirma = em.merge(chequesfirmaCollectionChequesfirma);
                if (oldCodcaixaOfChequesfirmaCollectionChequesfirma != null) {
                    oldCodcaixaOfChequesfirmaCollectionChequesfirma.getChequesfirmaCollection().remove(chequesfirmaCollectionChequesfirma);
                    oldCodcaixaOfChequesfirmaCollectionChequesfirma = em.merge(oldCodcaixaOfChequesfirmaCollectionChequesfirma);
                }
            }
            for (Contapagarpag contapagarpagCollectionContapagarpag : caixa.getContapagarpagCollection()) {
                Caixa oldCodcaixaOfContapagarpagCollectionContapagarpag = contapagarpagCollectionContapagarpag.getCodcaixa();
                contapagarpagCollectionContapagarpag.setCodcaixa(caixa);
                contapagarpagCollectionContapagarpag = em.merge(contapagarpagCollectionContapagarpag);
                if (oldCodcaixaOfContapagarpagCollectionContapagarpag != null) {
                    oldCodcaixaOfContapagarpagCollectionContapagarpag.getContapagarpagCollection().remove(contapagarpagCollectionContapagarpag);
                    oldCodcaixaOfContapagarpagCollectionContapagarpag = em.merge(oldCodcaixaOfContapagarpagCollectionContapagarpag);
                }
            }
            for (Contapagar contapagarCollectionContapagar : caixa.getContapagarCollection()) {
                Caixa oldCodcaixaOfContapagarCollectionContapagar = contapagarCollectionContapagar.getCodcaixa();
                contapagarCollectionContapagar.setCodcaixa(caixa);
                contapagarCollectionContapagar = em.merge(contapagarCollectionContapagar);
                if (oldCodcaixaOfContapagarCollectionContapagar != null) {
                    oldCodcaixaOfContapagarCollectionContapagar.getContapagarCollection().remove(contapagarCollectionContapagar);
                    oldCodcaixaOfContapagarCollectionContapagar = em.merge(oldCodcaixaOfContapagarCollectionContapagar);
                }
            }
            for (Contareceberrec contareceberrecCollectionContareceberrec : caixa.getContareceberrecCollection()) {
                Caixa oldCodcaixaOfContareceberrecCollectionContareceberrec = contareceberrecCollectionContareceberrec.getCodcaixa();
                contareceberrecCollectionContareceberrec.setCodcaixa(caixa);
                contareceberrecCollectionContareceberrec = em.merge(contareceberrecCollectionContareceberrec);
                if (oldCodcaixaOfContareceberrecCollectionContareceberrec != null) {
                    oldCodcaixaOfContareceberrecCollectionContareceberrec.getContareceberrecCollection().remove(contareceberrecCollectionContareceberrec);
                    oldCodcaixaOfContareceberrecCollectionContareceberrec = em.merge(oldCodcaixaOfContareceberrecCollectionContareceberrec);
                }
            }
            for (Cheques chequesCollectionCheques : caixa.getChequesCollection()) {
                Caixa oldCodcaixaOfChequesCollectionCheques = chequesCollectionCheques.getCodcaixa();
                chequesCollectionCheques.setCodcaixa(caixa);
                chequesCollectionCheques = em.merge(chequesCollectionCheques);
                if (oldCodcaixaOfChequesCollectionCheques != null) {
                    oldCodcaixaOfChequesCollectionCheques.getChequesCollection().remove(chequesCollectionCheques);
                    oldCodcaixaOfChequesCollectionCheques = em.merge(oldCodcaixaOfChequesCollectionCheques);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCaixa(caixa.getCodcaixa()) != null) {
                throw new PreexistingEntityException("Caixa " + caixa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Caixa caixa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Caixa persistentCaixa = em.find(Caixa.class, caixa.getCodcaixa());
            Caixas codcaixasOld = persistentCaixa.getCodcaixas();
            Caixas codcaixasNew = caixa.getCodcaixas();
            Cliente codcliOld = persistentCaixa.getCodcli();
            Cliente codcliNew = caixa.getCodcli();
            Empresa codempresaOld = persistentCaixa.getCodempresa();
            Empresa codempresaNew = caixa.getCodempresa();
            Planoconta codpcOld = persistentCaixa.getCodpc();
            Planoconta codpcNew = caixa.getCodpc();
            Collection<Chequesfirma> chequesfirmaCollectionOld = persistentCaixa.getChequesfirmaCollection();
            Collection<Chequesfirma> chequesfirmaCollectionNew = caixa.getChequesfirmaCollection();
            Collection<Contapagarpag> contapagarpagCollectionOld = persistentCaixa.getContapagarpagCollection();
            Collection<Contapagarpag> contapagarpagCollectionNew = caixa.getContapagarpagCollection();
            Collection<Contapagar> contapagarCollectionOld = persistentCaixa.getContapagarCollection();
            Collection<Contapagar> contapagarCollectionNew = caixa.getContapagarCollection();
            Collection<Contareceberrec> contareceberrecCollectionOld = persistentCaixa.getContareceberrecCollection();
            Collection<Contareceberrec> contareceberrecCollectionNew = caixa.getContareceberrecCollection();
            Collection<Cheques> chequesCollectionOld = persistentCaixa.getChequesCollection();
            Collection<Cheques> chequesCollectionNew = caixa.getChequesCollection();
            if (codcaixasNew != null) {
                codcaixasNew = em.getReference(codcaixasNew.getClass(), codcaixasNew.getCodcaixas());
                caixa.setCodcaixas(codcaixasNew);
            }
            if (codcliNew != null) {
                codcliNew = em.getReference(codcliNew.getClass(), codcliNew.getCodcli());
                caixa.setCodcli(codcliNew);
            }
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                caixa.setCodempresa(codempresaNew);
            }
            if (codpcNew != null) {
                codpcNew = em.getReference(codpcNew.getClass(), codpcNew.getCodpc());
                caixa.setCodpc(codpcNew);
            }
            Collection<Chequesfirma> attachedChequesfirmaCollectionNew = new ArrayList<Chequesfirma>();
            for (Chequesfirma chequesfirmaCollectionNewChequesfirmaToAttach : chequesfirmaCollectionNew) {
                chequesfirmaCollectionNewChequesfirmaToAttach = em.getReference(chequesfirmaCollectionNewChequesfirmaToAttach.getClass(), chequesfirmaCollectionNewChequesfirmaToAttach.getCodchequefirma());
                attachedChequesfirmaCollectionNew.add(chequesfirmaCollectionNewChequesfirmaToAttach);
            }
            chequesfirmaCollectionNew = attachedChequesfirmaCollectionNew;
            caixa.setChequesfirmaCollection(chequesfirmaCollectionNew);
            Collection<Contapagarpag> attachedContapagarpagCollectionNew = new ArrayList<Contapagarpag>();
            for (Contapagarpag contapagarpagCollectionNewContapagarpagToAttach : contapagarpagCollectionNew) {
                contapagarpagCollectionNewContapagarpagToAttach = em.getReference(contapagarpagCollectionNewContapagarpagToAttach.getClass(), contapagarpagCollectionNewContapagarpagToAttach.getId());
                attachedContapagarpagCollectionNew.add(contapagarpagCollectionNewContapagarpagToAttach);
            }
            contapagarpagCollectionNew = attachedContapagarpagCollectionNew;
            caixa.setContapagarpagCollection(contapagarpagCollectionNew);
            Collection<Contapagar> attachedContapagarCollectionNew = new ArrayList<Contapagar>();
            for (Contapagar contapagarCollectionNewContapagarToAttach : contapagarCollectionNew) {
                contapagarCollectionNewContapagarToAttach = em.getReference(contapagarCollectionNewContapagarToAttach.getClass(), contapagarCollectionNewContapagarToAttach.getCodcp());
                attachedContapagarCollectionNew.add(contapagarCollectionNewContapagarToAttach);
            }
            contapagarCollectionNew = attachedContapagarCollectionNew;
            caixa.setContapagarCollection(contapagarCollectionNew);
            Collection<Contareceberrec> attachedContareceberrecCollectionNew = new ArrayList<Contareceberrec>();
            for (Contareceberrec contareceberrecCollectionNewContareceberrecToAttach : contareceberrecCollectionNew) {
                contareceberrecCollectionNewContareceberrecToAttach = em.getReference(contareceberrecCollectionNewContareceberrecToAttach.getClass(), contareceberrecCollectionNewContareceberrecToAttach.getId());
                attachedContareceberrecCollectionNew.add(contareceberrecCollectionNewContareceberrecToAttach);
            }
            contareceberrecCollectionNew = attachedContareceberrecCollectionNew;
            caixa.setContareceberrecCollection(contareceberrecCollectionNew);
            Collection<Cheques> attachedChequesCollectionNew = new ArrayList<Cheques>();
            for (Cheques chequesCollectionNewChequesToAttach : chequesCollectionNew) {
                chequesCollectionNewChequesToAttach = em.getReference(chequesCollectionNewChequesToAttach.getClass(), chequesCollectionNewChequesToAttach.getCodcheque());
                attachedChequesCollectionNew.add(chequesCollectionNewChequesToAttach);
            }
            chequesCollectionNew = attachedChequesCollectionNew;
            caixa.setChequesCollection(chequesCollectionNew);
            caixa = em.merge(caixa);
            if (codcaixasOld != null && !codcaixasOld.equals(codcaixasNew)) {
                codcaixasOld.getCaixaCollection().remove(caixa);
                codcaixasOld = em.merge(codcaixasOld);
            }
            if (codcaixasNew != null && !codcaixasNew.equals(codcaixasOld)) {
                codcaixasNew.getCaixaCollection().add(caixa);
                codcaixasNew = em.merge(codcaixasNew);
            }
            if (codcliOld != null && !codcliOld.equals(codcliNew)) {
                codcliOld.getCaixaCollection().remove(caixa);
                codcliOld = em.merge(codcliOld);
            }
            if (codcliNew != null && !codcliNew.equals(codcliOld)) {
                codcliNew.getCaixaCollection().add(caixa);
                codcliNew = em.merge(codcliNew);
            }
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getCaixaCollection().remove(caixa);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getCaixaCollection().add(caixa);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codpcOld != null && !codpcOld.equals(codpcNew)) {
                codpcOld.getCaixaCollection().remove(caixa);
                codpcOld = em.merge(codpcOld);
            }
            if (codpcNew != null && !codpcNew.equals(codpcOld)) {
                codpcNew.getCaixaCollection().add(caixa);
                codpcNew = em.merge(codpcNew);
            }
            for (Chequesfirma chequesfirmaCollectionOldChequesfirma : chequesfirmaCollectionOld) {
                if (!chequesfirmaCollectionNew.contains(chequesfirmaCollectionOldChequesfirma)) {
                    chequesfirmaCollectionOldChequesfirma.setCodcaixa(null);
                    chequesfirmaCollectionOldChequesfirma = em.merge(chequesfirmaCollectionOldChequesfirma);
                }
            }
            for (Chequesfirma chequesfirmaCollectionNewChequesfirma : chequesfirmaCollectionNew) {
                if (!chequesfirmaCollectionOld.contains(chequesfirmaCollectionNewChequesfirma)) {
                    Caixa oldCodcaixaOfChequesfirmaCollectionNewChequesfirma = chequesfirmaCollectionNewChequesfirma.getCodcaixa();
                    chequesfirmaCollectionNewChequesfirma.setCodcaixa(caixa);
                    chequesfirmaCollectionNewChequesfirma = em.merge(chequesfirmaCollectionNewChequesfirma);
                    if (oldCodcaixaOfChequesfirmaCollectionNewChequesfirma != null && !oldCodcaixaOfChequesfirmaCollectionNewChequesfirma.equals(caixa)) {
                        oldCodcaixaOfChequesfirmaCollectionNewChequesfirma.getChequesfirmaCollection().remove(chequesfirmaCollectionNewChequesfirma);
                        oldCodcaixaOfChequesfirmaCollectionNewChequesfirma = em.merge(oldCodcaixaOfChequesfirmaCollectionNewChequesfirma);
                    }
                }
            }
            for (Contapagarpag contapagarpagCollectionOldContapagarpag : contapagarpagCollectionOld) {
                if (!contapagarpagCollectionNew.contains(contapagarpagCollectionOldContapagarpag)) {
                    contapagarpagCollectionOldContapagarpag.setCodcaixa(null);
                    contapagarpagCollectionOldContapagarpag = em.merge(contapagarpagCollectionOldContapagarpag);
                }
            }
            for (Contapagarpag contapagarpagCollectionNewContapagarpag : contapagarpagCollectionNew) {
                if (!contapagarpagCollectionOld.contains(contapagarpagCollectionNewContapagarpag)) {
                    Caixa oldCodcaixaOfContapagarpagCollectionNewContapagarpag = contapagarpagCollectionNewContapagarpag.getCodcaixa();
                    contapagarpagCollectionNewContapagarpag.setCodcaixa(caixa);
                    contapagarpagCollectionNewContapagarpag = em.merge(contapagarpagCollectionNewContapagarpag);
                    if (oldCodcaixaOfContapagarpagCollectionNewContapagarpag != null && !oldCodcaixaOfContapagarpagCollectionNewContapagarpag.equals(caixa)) {
                        oldCodcaixaOfContapagarpagCollectionNewContapagarpag.getContapagarpagCollection().remove(contapagarpagCollectionNewContapagarpag);
                        oldCodcaixaOfContapagarpagCollectionNewContapagarpag = em.merge(oldCodcaixaOfContapagarpagCollectionNewContapagarpag);
                    }
                }
            }
            for (Contapagar contapagarCollectionOldContapagar : contapagarCollectionOld) {
                if (!contapagarCollectionNew.contains(contapagarCollectionOldContapagar)) {
                    contapagarCollectionOldContapagar.setCodcaixa(null);
                    contapagarCollectionOldContapagar = em.merge(contapagarCollectionOldContapagar);
                }
            }
            for (Contapagar contapagarCollectionNewContapagar : contapagarCollectionNew) {
                if (!contapagarCollectionOld.contains(contapagarCollectionNewContapagar)) {
                    Caixa oldCodcaixaOfContapagarCollectionNewContapagar = contapagarCollectionNewContapagar.getCodcaixa();
                    contapagarCollectionNewContapagar.setCodcaixa(caixa);
                    contapagarCollectionNewContapagar = em.merge(contapagarCollectionNewContapagar);
                    if (oldCodcaixaOfContapagarCollectionNewContapagar != null && !oldCodcaixaOfContapagarCollectionNewContapagar.equals(caixa)) {
                        oldCodcaixaOfContapagarCollectionNewContapagar.getContapagarCollection().remove(contapagarCollectionNewContapagar);
                        oldCodcaixaOfContapagarCollectionNewContapagar = em.merge(oldCodcaixaOfContapagarCollectionNewContapagar);
                    }
                }
            }
            for (Contareceberrec contareceberrecCollectionOldContareceberrec : contareceberrecCollectionOld) {
                if (!contareceberrecCollectionNew.contains(contareceberrecCollectionOldContareceberrec)) {
                    contareceberrecCollectionOldContareceberrec.setCodcaixa(null);
                    contareceberrecCollectionOldContareceberrec = em.merge(contareceberrecCollectionOldContareceberrec);
                }
            }
            for (Contareceberrec contareceberrecCollectionNewContareceberrec : contareceberrecCollectionNew) {
                if (!contareceberrecCollectionOld.contains(contareceberrecCollectionNewContareceberrec)) {
                    Caixa oldCodcaixaOfContareceberrecCollectionNewContareceberrec = contareceberrecCollectionNewContareceberrec.getCodcaixa();
                    contareceberrecCollectionNewContareceberrec.setCodcaixa(caixa);
                    contareceberrecCollectionNewContareceberrec = em.merge(contareceberrecCollectionNewContareceberrec);
                    if (oldCodcaixaOfContareceberrecCollectionNewContareceberrec != null && !oldCodcaixaOfContareceberrecCollectionNewContareceberrec.equals(caixa)) {
                        oldCodcaixaOfContareceberrecCollectionNewContareceberrec.getContareceberrecCollection().remove(contareceberrecCollectionNewContareceberrec);
                        oldCodcaixaOfContareceberrecCollectionNewContareceberrec = em.merge(oldCodcaixaOfContareceberrecCollectionNewContareceberrec);
                    }
                }
            }
            for (Cheques chequesCollectionOldCheques : chequesCollectionOld) {
                if (!chequesCollectionNew.contains(chequesCollectionOldCheques)) {
                    chequesCollectionOldCheques.setCodcaixa(null);
                    chequesCollectionOldCheques = em.merge(chequesCollectionOldCheques);
                }
            }
            for (Cheques chequesCollectionNewCheques : chequesCollectionNew) {
                if (!chequesCollectionOld.contains(chequesCollectionNewCheques)) {
                    Caixa oldCodcaixaOfChequesCollectionNewCheques = chequesCollectionNewCheques.getCodcaixa();
                    chequesCollectionNewCheques.setCodcaixa(caixa);
                    chequesCollectionNewCheques = em.merge(chequesCollectionNewCheques);
                    if (oldCodcaixaOfChequesCollectionNewCheques != null && !oldCodcaixaOfChequesCollectionNewCheques.equals(caixa)) {
                        oldCodcaixaOfChequesCollectionNewCheques.getChequesCollection().remove(chequesCollectionNewCheques);
                        oldCodcaixaOfChequesCollectionNewCheques = em.merge(oldCodcaixaOfChequesCollectionNewCheques);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = caixa.getCodcaixa();
                if (findCaixa(id) == null) {
                    throw new NonexistentEntityException("The caixa with id " + id + " no longer exists.");
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
            Caixa caixa;
            try {
                caixa = em.getReference(Caixa.class, id);
                caixa.getCodcaixa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The caixa with id " + id + " no longer exists.", enfe);
            }
            Caixas codcaixas = caixa.getCodcaixas();
            if (codcaixas != null) {
                codcaixas.getCaixaCollection().remove(caixa);
                codcaixas = em.merge(codcaixas);
            }
            Cliente codcli = caixa.getCodcli();
            if (codcli != null) {
                codcli.getCaixaCollection().remove(caixa);
                codcli = em.merge(codcli);
            }
            Empresa codempresa = caixa.getCodempresa();
            if (codempresa != null) {
                codempresa.getCaixaCollection().remove(caixa);
                codempresa = em.merge(codempresa);
            }
            Planoconta codpc = caixa.getCodpc();
            if (codpc != null) {
                codpc.getCaixaCollection().remove(caixa);
                codpc = em.merge(codpc);
            }
            Collection<Chequesfirma> chequesfirmaCollection = caixa.getChequesfirmaCollection();
            for (Chequesfirma chequesfirmaCollectionChequesfirma : chequesfirmaCollection) {
                chequesfirmaCollectionChequesfirma.setCodcaixa(null);
                chequesfirmaCollectionChequesfirma = em.merge(chequesfirmaCollectionChequesfirma);
            }
            Collection<Contapagarpag> contapagarpagCollection = caixa.getContapagarpagCollection();
            for (Contapagarpag contapagarpagCollectionContapagarpag : contapagarpagCollection) {
                contapagarpagCollectionContapagarpag.setCodcaixa(null);
                contapagarpagCollectionContapagarpag = em.merge(contapagarpagCollectionContapagarpag);
            }
            Collection<Contapagar> contapagarCollection = caixa.getContapagarCollection();
            for (Contapagar contapagarCollectionContapagar : contapagarCollection) {
                contapagarCollectionContapagar.setCodcaixa(null);
                contapagarCollectionContapagar = em.merge(contapagarCollectionContapagar);
            }
            Collection<Contareceberrec> contareceberrecCollection = caixa.getContareceberrecCollection();
            for (Contareceberrec contareceberrecCollectionContareceberrec : contareceberrecCollection) {
                contareceberrecCollectionContareceberrec.setCodcaixa(null);
                contareceberrecCollectionContareceberrec = em.merge(contareceberrecCollectionContareceberrec);
            }
            Collection<Cheques> chequesCollection = caixa.getChequesCollection();
            for (Cheques chequesCollectionCheques : chequesCollection) {
                chequesCollectionCheques.setCodcaixa(null);
                chequesCollectionCheques = em.merge(chequesCollectionCheques);
            }
            em.remove(caixa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Caixa> findCaixaEntities() {
        return findCaixaEntities(true, -1, -1);
    }

    public List<Caixa> findCaixaEntities(int maxResults, int firstResult) {
        return findCaixaEntities(false, maxResults, firstResult);
    }

    private List<Caixa> findCaixaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Caixa.class));
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

    public Caixa findCaixa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Caixa.class, id);
        } finally {
            em.close();
        }
    }

    public int getCaixaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Caixa> rt = cq.from(Caixa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

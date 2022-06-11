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
import entidade.cplus.Formapag;
import entidade.cplus.Transportadora;
import entidade.cplus.Chequesfirma;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Contapagar;
import entidade.cplus.Cheques;
import entidade.cplus.Contatosforn;
import entidade.cplus.Contapagarfixa;
import entidade.cplus.Produto;
import entidade.cplus.Cotacaofornecedor;
import entidade.cplus.Fornecedor;
import entidade.cplus.Movendaproddevolucaocompra;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class FornecedorJpaController implements Serializable {

    public FornecedorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Fornecedor fornecedor) throws PreexistingEntityException, Exception {
        if (fornecedor.getChequesfirmaCollection() == null) {
            fornecedor.setChequesfirmaCollection(new ArrayList<Chequesfirma>());
        }
        if (fornecedor.getContapagarCollection() == null) {
            fornecedor.setContapagarCollection(new ArrayList<Contapagar>());
        }
        if (fornecedor.getChequesCollection() == null) {
            fornecedor.setChequesCollection(new ArrayList<Cheques>());
        }
        if (fornecedor.getContatosfornCollection() == null) {
            fornecedor.setContatosfornCollection(new ArrayList<Contatosforn>());
        }
        if (fornecedor.getContapagarfixaCollection() == null) {
            fornecedor.setContapagarfixaCollection(new ArrayList<Contapagarfixa>());
        }
        if (fornecedor.getProdutoCollection() == null) {
            fornecedor.setProdutoCollection(new ArrayList<Produto>());
        }
        if (fornecedor.getCotacaofornecedorCollection() == null) {
            fornecedor.setCotacaofornecedorCollection(new ArrayList<Cotacaofornecedor>());
        }
        if (fornecedor.getMovendaproddevolucaocompraCollection() == null) {
            fornecedor.setMovendaproddevolucaocompraCollection(new ArrayList<Movendaproddevolucaocompra>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Formapag codfp = fornecedor.getCodfp();
            if (codfp != null) {
                codfp = em.getReference(codfp.getClass(), codfp.getCodfp());
                fornecedor.setCodfp(codfp);
            }
            Transportadora codtrans = fornecedor.getCodtrans();
            if (codtrans != null) {
                codtrans = em.getReference(codtrans.getClass(), codtrans.getCodtrans());
                fornecedor.setCodtrans(codtrans);
            }
            Collection<Chequesfirma> attachedChequesfirmaCollection = new ArrayList<Chequesfirma>();
            for (Chequesfirma chequesfirmaCollectionChequesfirmaToAttach : fornecedor.getChequesfirmaCollection()) {
                chequesfirmaCollectionChequesfirmaToAttach = em.getReference(chequesfirmaCollectionChequesfirmaToAttach.getClass(), chequesfirmaCollectionChequesfirmaToAttach.getCodchequefirma());
                attachedChequesfirmaCollection.add(chequesfirmaCollectionChequesfirmaToAttach);
            }
            fornecedor.setChequesfirmaCollection(attachedChequesfirmaCollection);
            Collection<Contapagar> attachedContapagarCollection = new ArrayList<Contapagar>();
            for (Contapagar contapagarCollectionContapagarToAttach : fornecedor.getContapagarCollection()) {
                contapagarCollectionContapagarToAttach = em.getReference(contapagarCollectionContapagarToAttach.getClass(), contapagarCollectionContapagarToAttach.getCodcp());
                attachedContapagarCollection.add(contapagarCollectionContapagarToAttach);
            }
            fornecedor.setContapagarCollection(attachedContapagarCollection);
            Collection<Cheques> attachedChequesCollection = new ArrayList<Cheques>();
            for (Cheques chequesCollectionChequesToAttach : fornecedor.getChequesCollection()) {
                chequesCollectionChequesToAttach = em.getReference(chequesCollectionChequesToAttach.getClass(), chequesCollectionChequesToAttach.getCodcheque());
                attachedChequesCollection.add(chequesCollectionChequesToAttach);
            }
            fornecedor.setChequesCollection(attachedChequesCollection);
            Collection<Contatosforn> attachedContatosfornCollection = new ArrayList<Contatosforn>();
            for (Contatosforn contatosfornCollectionContatosfornToAttach : fornecedor.getContatosfornCollection()) {
                contatosfornCollectionContatosfornToAttach = em.getReference(contatosfornCollectionContatosfornToAttach.getClass(), contatosfornCollectionContatosfornToAttach.getCodcf());
                attachedContatosfornCollection.add(contatosfornCollectionContatosfornToAttach);
            }
            fornecedor.setContatosfornCollection(attachedContatosfornCollection);
            Collection<Contapagarfixa> attachedContapagarfixaCollection = new ArrayList<Contapagarfixa>();
            for (Contapagarfixa contapagarfixaCollectionContapagarfixaToAttach : fornecedor.getContapagarfixaCollection()) {
                contapagarfixaCollectionContapagarfixaToAttach = em.getReference(contapagarfixaCollectionContapagarfixaToAttach.getClass(), contapagarfixaCollectionContapagarfixaToAttach.getCodcpfixa());
                attachedContapagarfixaCollection.add(contapagarfixaCollectionContapagarfixaToAttach);
            }
            fornecedor.setContapagarfixaCollection(attachedContapagarfixaCollection);
            Collection<Produto> attachedProdutoCollection = new ArrayList<Produto>();
            for (Produto produtoCollectionProdutoToAttach : fornecedor.getProdutoCollection()) {
                produtoCollectionProdutoToAttach = em.getReference(produtoCollectionProdutoToAttach.getClass(), produtoCollectionProdutoToAttach.getCodprod());
                attachedProdutoCollection.add(produtoCollectionProdutoToAttach);
            }
            fornecedor.setProdutoCollection(attachedProdutoCollection);
            Collection<Cotacaofornecedor> attachedCotacaofornecedorCollection = new ArrayList<Cotacaofornecedor>();
            for (Cotacaofornecedor cotacaofornecedorCollectionCotacaofornecedorToAttach : fornecedor.getCotacaofornecedorCollection()) {
                cotacaofornecedorCollectionCotacaofornecedorToAttach = em.getReference(cotacaofornecedorCollectionCotacaofornecedorToAttach.getClass(), cotacaofornecedorCollectionCotacaofornecedorToAttach.getCodcotacaofornecedor());
                attachedCotacaofornecedorCollection.add(cotacaofornecedorCollectionCotacaofornecedorToAttach);
            }
            fornecedor.setCotacaofornecedorCollection(attachedCotacaofornecedorCollection);
            Collection<Movendaproddevolucaocompra> attachedMovendaproddevolucaocompraCollection = new ArrayList<Movendaproddevolucaocompra>();
            for (Movendaproddevolucaocompra movendaproddevolucaocompraCollectionMovendaproddevolucaocompraToAttach : fornecedor.getMovendaproddevolucaocompraCollection()) {
                movendaproddevolucaocompraCollectionMovendaproddevolucaocompraToAttach = em.getReference(movendaproddevolucaocompraCollectionMovendaproddevolucaocompraToAttach.getClass(), movendaproddevolucaocompraCollectionMovendaproddevolucaocompraToAttach.getCodmovendaproddevolucaocompra());
                attachedMovendaproddevolucaocompraCollection.add(movendaproddevolucaocompraCollectionMovendaproddevolucaocompraToAttach);
            }
            fornecedor.setMovendaproddevolucaocompraCollection(attachedMovendaproddevolucaocompraCollection);
            em.persist(fornecedor);
            if (codfp != null) {
                codfp.getFornecedorCollection().add(fornecedor);
                codfp = em.merge(codfp);
            }
            if (codtrans != null) {
                codtrans.getFornecedorCollection().add(fornecedor);
                codtrans = em.merge(codtrans);
            }
            for (Chequesfirma chequesfirmaCollectionChequesfirma : fornecedor.getChequesfirmaCollection()) {
                Fornecedor oldCodfornOfChequesfirmaCollectionChequesfirma = chequesfirmaCollectionChequesfirma.getCodforn();
                chequesfirmaCollectionChequesfirma.setCodforn(fornecedor);
                chequesfirmaCollectionChequesfirma = em.merge(chequesfirmaCollectionChequesfirma);
                if (oldCodfornOfChequesfirmaCollectionChequesfirma != null) {
                    oldCodfornOfChequesfirmaCollectionChequesfirma.getChequesfirmaCollection().remove(chequesfirmaCollectionChequesfirma);
                    oldCodfornOfChequesfirmaCollectionChequesfirma = em.merge(oldCodfornOfChequesfirmaCollectionChequesfirma);
                }
            }
            for (Contapagar contapagarCollectionContapagar : fornecedor.getContapagarCollection()) {
                Fornecedor oldCodfornOfContapagarCollectionContapagar = contapagarCollectionContapagar.getCodforn();
                contapagarCollectionContapagar.setCodforn(fornecedor);
                contapagarCollectionContapagar = em.merge(contapagarCollectionContapagar);
                if (oldCodfornOfContapagarCollectionContapagar != null) {
                    oldCodfornOfContapagarCollectionContapagar.getContapagarCollection().remove(contapagarCollectionContapagar);
                    oldCodfornOfContapagarCollectionContapagar = em.merge(oldCodfornOfContapagarCollectionContapagar);
                }
            }
            for (Cheques chequesCollectionCheques : fornecedor.getChequesCollection()) {
                Fornecedor oldCodfornOfChequesCollectionCheques = chequesCollectionCheques.getCodforn();
                chequesCollectionCheques.setCodforn(fornecedor);
                chequesCollectionCheques = em.merge(chequesCollectionCheques);
                if (oldCodfornOfChequesCollectionCheques != null) {
                    oldCodfornOfChequesCollectionCheques.getChequesCollection().remove(chequesCollectionCheques);
                    oldCodfornOfChequesCollectionCheques = em.merge(oldCodfornOfChequesCollectionCheques);
                }
            }
            for (Contatosforn contatosfornCollectionContatosforn : fornecedor.getContatosfornCollection()) {
                Fornecedor oldCodfornOfContatosfornCollectionContatosforn = contatosfornCollectionContatosforn.getCodforn();
                contatosfornCollectionContatosforn.setCodforn(fornecedor);
                contatosfornCollectionContatosforn = em.merge(contatosfornCollectionContatosforn);
                if (oldCodfornOfContatosfornCollectionContatosforn != null) {
                    oldCodfornOfContatosfornCollectionContatosforn.getContatosfornCollection().remove(contatosfornCollectionContatosforn);
                    oldCodfornOfContatosfornCollectionContatosforn = em.merge(oldCodfornOfContatosfornCollectionContatosforn);
                }
            }
            for (Contapagarfixa contapagarfixaCollectionContapagarfixa : fornecedor.getContapagarfixaCollection()) {
                Fornecedor oldCodfornOfContapagarfixaCollectionContapagarfixa = contapagarfixaCollectionContapagarfixa.getCodforn();
                contapagarfixaCollectionContapagarfixa.setCodforn(fornecedor);
                contapagarfixaCollectionContapagarfixa = em.merge(contapagarfixaCollectionContapagarfixa);
                if (oldCodfornOfContapagarfixaCollectionContapagarfixa != null) {
                    oldCodfornOfContapagarfixaCollectionContapagarfixa.getContapagarfixaCollection().remove(contapagarfixaCollectionContapagarfixa);
                    oldCodfornOfContapagarfixaCollectionContapagarfixa = em.merge(oldCodfornOfContapagarfixaCollectionContapagarfixa);
                }
            }
            for (Produto produtoCollectionProduto : fornecedor.getProdutoCollection()) {
                Fornecedor oldCodfornOfProdutoCollectionProduto = produtoCollectionProduto.getCodforn();
                produtoCollectionProduto.setCodforn(fornecedor);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
                if (oldCodfornOfProdutoCollectionProduto != null) {
                    oldCodfornOfProdutoCollectionProduto.getProdutoCollection().remove(produtoCollectionProduto);
                    oldCodfornOfProdutoCollectionProduto = em.merge(oldCodfornOfProdutoCollectionProduto);
                }
            }
            for (Cotacaofornecedor cotacaofornecedorCollectionCotacaofornecedor : fornecedor.getCotacaofornecedorCollection()) {
                Fornecedor oldCodfornOfCotacaofornecedorCollectionCotacaofornecedor = cotacaofornecedorCollectionCotacaofornecedor.getCodforn();
                cotacaofornecedorCollectionCotacaofornecedor.setCodforn(fornecedor);
                cotacaofornecedorCollectionCotacaofornecedor = em.merge(cotacaofornecedorCollectionCotacaofornecedor);
                if (oldCodfornOfCotacaofornecedorCollectionCotacaofornecedor != null) {
                    oldCodfornOfCotacaofornecedorCollectionCotacaofornecedor.getCotacaofornecedorCollection().remove(cotacaofornecedorCollectionCotacaofornecedor);
                    oldCodfornOfCotacaofornecedorCollectionCotacaofornecedor = em.merge(oldCodfornOfCotacaofornecedorCollectionCotacaofornecedor);
                }
            }
            for (Movendaproddevolucaocompra movendaproddevolucaocompraCollectionMovendaproddevolucaocompra : fornecedor.getMovendaproddevolucaocompraCollection()) {
                Fornecedor oldCodfornOfMovendaproddevolucaocompraCollectionMovendaproddevolucaocompra = movendaproddevolucaocompraCollectionMovendaproddevolucaocompra.getCodforn();
                movendaproddevolucaocompraCollectionMovendaproddevolucaocompra.setCodforn(fornecedor);
                movendaproddevolucaocompraCollectionMovendaproddevolucaocompra = em.merge(movendaproddevolucaocompraCollectionMovendaproddevolucaocompra);
                if (oldCodfornOfMovendaproddevolucaocompraCollectionMovendaproddevolucaocompra != null) {
                    oldCodfornOfMovendaproddevolucaocompraCollectionMovendaproddevolucaocompra.getMovendaproddevolucaocompraCollection().remove(movendaproddevolucaocompraCollectionMovendaproddevolucaocompra);
                    oldCodfornOfMovendaproddevolucaocompraCollectionMovendaproddevolucaocompra = em.merge(oldCodfornOfMovendaproddevolucaocompraCollectionMovendaproddevolucaocompra);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFornecedor(fornecedor.getCodforn()) != null) {
                throw new PreexistingEntityException("Fornecedor " + fornecedor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Fornecedor fornecedor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Fornecedor persistentFornecedor = em.find(Fornecedor.class, fornecedor.getCodforn());
            Formapag codfpOld = persistentFornecedor.getCodfp();
            Formapag codfpNew = fornecedor.getCodfp();
            Transportadora codtransOld = persistentFornecedor.getCodtrans();
            Transportadora codtransNew = fornecedor.getCodtrans();
            Collection<Chequesfirma> chequesfirmaCollectionOld = persistentFornecedor.getChequesfirmaCollection();
            Collection<Chequesfirma> chequesfirmaCollectionNew = fornecedor.getChequesfirmaCollection();
            Collection<Contapagar> contapagarCollectionOld = persistentFornecedor.getContapagarCollection();
            Collection<Contapagar> contapagarCollectionNew = fornecedor.getContapagarCollection();
            Collection<Cheques> chequesCollectionOld = persistentFornecedor.getChequesCollection();
            Collection<Cheques> chequesCollectionNew = fornecedor.getChequesCollection();
            Collection<Contatosforn> contatosfornCollectionOld = persistentFornecedor.getContatosfornCollection();
            Collection<Contatosforn> contatosfornCollectionNew = fornecedor.getContatosfornCollection();
            Collection<Contapagarfixa> contapagarfixaCollectionOld = persistentFornecedor.getContapagarfixaCollection();
            Collection<Contapagarfixa> contapagarfixaCollectionNew = fornecedor.getContapagarfixaCollection();
            Collection<Produto> produtoCollectionOld = persistentFornecedor.getProdutoCollection();
            Collection<Produto> produtoCollectionNew = fornecedor.getProdutoCollection();
            Collection<Cotacaofornecedor> cotacaofornecedorCollectionOld = persistentFornecedor.getCotacaofornecedorCollection();
            Collection<Cotacaofornecedor> cotacaofornecedorCollectionNew = fornecedor.getCotacaofornecedorCollection();
            Collection<Movendaproddevolucaocompra> movendaproddevolucaocompraCollectionOld = persistentFornecedor.getMovendaproddevolucaocompraCollection();
            Collection<Movendaproddevolucaocompra> movendaproddevolucaocompraCollectionNew = fornecedor.getMovendaproddevolucaocompraCollection();
            if (codfpNew != null) {
                codfpNew = em.getReference(codfpNew.getClass(), codfpNew.getCodfp());
                fornecedor.setCodfp(codfpNew);
            }
            if (codtransNew != null) {
                codtransNew = em.getReference(codtransNew.getClass(), codtransNew.getCodtrans());
                fornecedor.setCodtrans(codtransNew);
            }
            Collection<Chequesfirma> attachedChequesfirmaCollectionNew = new ArrayList<Chequesfirma>();
            for (Chequesfirma chequesfirmaCollectionNewChequesfirmaToAttach : chequesfirmaCollectionNew) {
                chequesfirmaCollectionNewChequesfirmaToAttach = em.getReference(chequesfirmaCollectionNewChequesfirmaToAttach.getClass(), chequesfirmaCollectionNewChequesfirmaToAttach.getCodchequefirma());
                attachedChequesfirmaCollectionNew.add(chequesfirmaCollectionNewChequesfirmaToAttach);
            }
            chequesfirmaCollectionNew = attachedChequesfirmaCollectionNew;
            fornecedor.setChequesfirmaCollection(chequesfirmaCollectionNew);
            Collection<Contapagar> attachedContapagarCollectionNew = new ArrayList<Contapagar>();
            for (Contapagar contapagarCollectionNewContapagarToAttach : contapagarCollectionNew) {
                contapagarCollectionNewContapagarToAttach = em.getReference(contapagarCollectionNewContapagarToAttach.getClass(), contapagarCollectionNewContapagarToAttach.getCodcp());
                attachedContapagarCollectionNew.add(contapagarCollectionNewContapagarToAttach);
            }
            contapagarCollectionNew = attachedContapagarCollectionNew;
            fornecedor.setContapagarCollection(contapagarCollectionNew);
            Collection<Cheques> attachedChequesCollectionNew = new ArrayList<Cheques>();
            for (Cheques chequesCollectionNewChequesToAttach : chequesCollectionNew) {
                chequesCollectionNewChequesToAttach = em.getReference(chequesCollectionNewChequesToAttach.getClass(), chequesCollectionNewChequesToAttach.getCodcheque());
                attachedChequesCollectionNew.add(chequesCollectionNewChequesToAttach);
            }
            chequesCollectionNew = attachedChequesCollectionNew;
            fornecedor.setChequesCollection(chequesCollectionNew);
            Collection<Contatosforn> attachedContatosfornCollectionNew = new ArrayList<Contatosforn>();
            for (Contatosforn contatosfornCollectionNewContatosfornToAttach : contatosfornCollectionNew) {
                contatosfornCollectionNewContatosfornToAttach = em.getReference(contatosfornCollectionNewContatosfornToAttach.getClass(), contatosfornCollectionNewContatosfornToAttach.getCodcf());
                attachedContatosfornCollectionNew.add(contatosfornCollectionNewContatosfornToAttach);
            }
            contatosfornCollectionNew = attachedContatosfornCollectionNew;
            fornecedor.setContatosfornCollection(contatosfornCollectionNew);
            Collection<Contapagarfixa> attachedContapagarfixaCollectionNew = new ArrayList<Contapagarfixa>();
            for (Contapagarfixa contapagarfixaCollectionNewContapagarfixaToAttach : contapagarfixaCollectionNew) {
                contapagarfixaCollectionNewContapagarfixaToAttach = em.getReference(contapagarfixaCollectionNewContapagarfixaToAttach.getClass(), contapagarfixaCollectionNewContapagarfixaToAttach.getCodcpfixa());
                attachedContapagarfixaCollectionNew.add(contapagarfixaCollectionNewContapagarfixaToAttach);
            }
            contapagarfixaCollectionNew = attachedContapagarfixaCollectionNew;
            fornecedor.setContapagarfixaCollection(contapagarfixaCollectionNew);
            Collection<Produto> attachedProdutoCollectionNew = new ArrayList<Produto>();
            for (Produto produtoCollectionNewProdutoToAttach : produtoCollectionNew) {
                produtoCollectionNewProdutoToAttach = em.getReference(produtoCollectionNewProdutoToAttach.getClass(), produtoCollectionNewProdutoToAttach.getCodprod());
                attachedProdutoCollectionNew.add(produtoCollectionNewProdutoToAttach);
            }
            produtoCollectionNew = attachedProdutoCollectionNew;
            fornecedor.setProdutoCollection(produtoCollectionNew);
            Collection<Cotacaofornecedor> attachedCotacaofornecedorCollectionNew = new ArrayList<Cotacaofornecedor>();
            for (Cotacaofornecedor cotacaofornecedorCollectionNewCotacaofornecedorToAttach : cotacaofornecedorCollectionNew) {
                cotacaofornecedorCollectionNewCotacaofornecedorToAttach = em.getReference(cotacaofornecedorCollectionNewCotacaofornecedorToAttach.getClass(), cotacaofornecedorCollectionNewCotacaofornecedorToAttach.getCodcotacaofornecedor());
                attachedCotacaofornecedorCollectionNew.add(cotacaofornecedorCollectionNewCotacaofornecedorToAttach);
            }
            cotacaofornecedorCollectionNew = attachedCotacaofornecedorCollectionNew;
            fornecedor.setCotacaofornecedorCollection(cotacaofornecedorCollectionNew);
            Collection<Movendaproddevolucaocompra> attachedMovendaproddevolucaocompraCollectionNew = new ArrayList<Movendaproddevolucaocompra>();
            for (Movendaproddevolucaocompra movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompraToAttach : movendaproddevolucaocompraCollectionNew) {
                movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompraToAttach = em.getReference(movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompraToAttach.getClass(), movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompraToAttach.getCodmovendaproddevolucaocompra());
                attachedMovendaproddevolucaocompraCollectionNew.add(movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompraToAttach);
            }
            movendaproddevolucaocompraCollectionNew = attachedMovendaproddevolucaocompraCollectionNew;
            fornecedor.setMovendaproddevolucaocompraCollection(movendaproddevolucaocompraCollectionNew);
            fornecedor = em.merge(fornecedor);
            if (codfpOld != null && !codfpOld.equals(codfpNew)) {
                codfpOld.getFornecedorCollection().remove(fornecedor);
                codfpOld = em.merge(codfpOld);
            }
            if (codfpNew != null && !codfpNew.equals(codfpOld)) {
                codfpNew.getFornecedorCollection().add(fornecedor);
                codfpNew = em.merge(codfpNew);
            }
            if (codtransOld != null && !codtransOld.equals(codtransNew)) {
                codtransOld.getFornecedorCollection().remove(fornecedor);
                codtransOld = em.merge(codtransOld);
            }
            if (codtransNew != null && !codtransNew.equals(codtransOld)) {
                codtransNew.getFornecedorCollection().add(fornecedor);
                codtransNew = em.merge(codtransNew);
            }
            for (Chequesfirma chequesfirmaCollectionOldChequesfirma : chequesfirmaCollectionOld) {
                if (!chequesfirmaCollectionNew.contains(chequesfirmaCollectionOldChequesfirma)) {
                    chequesfirmaCollectionOldChequesfirma.setCodforn(null);
                    chequesfirmaCollectionOldChequesfirma = em.merge(chequesfirmaCollectionOldChequesfirma);
                }
            }
            for (Chequesfirma chequesfirmaCollectionNewChequesfirma : chequesfirmaCollectionNew) {
                if (!chequesfirmaCollectionOld.contains(chequesfirmaCollectionNewChequesfirma)) {
                    Fornecedor oldCodfornOfChequesfirmaCollectionNewChequesfirma = chequesfirmaCollectionNewChequesfirma.getCodforn();
                    chequesfirmaCollectionNewChequesfirma.setCodforn(fornecedor);
                    chequesfirmaCollectionNewChequesfirma = em.merge(chequesfirmaCollectionNewChequesfirma);
                    if (oldCodfornOfChequesfirmaCollectionNewChequesfirma != null && !oldCodfornOfChequesfirmaCollectionNewChequesfirma.equals(fornecedor)) {
                        oldCodfornOfChequesfirmaCollectionNewChequesfirma.getChequesfirmaCollection().remove(chequesfirmaCollectionNewChequesfirma);
                        oldCodfornOfChequesfirmaCollectionNewChequesfirma = em.merge(oldCodfornOfChequesfirmaCollectionNewChequesfirma);
                    }
                }
            }
            for (Contapagar contapagarCollectionOldContapagar : contapagarCollectionOld) {
                if (!contapagarCollectionNew.contains(contapagarCollectionOldContapagar)) {
                    contapagarCollectionOldContapagar.setCodforn(null);
                    contapagarCollectionOldContapagar = em.merge(contapagarCollectionOldContapagar);
                }
            }
            for (Contapagar contapagarCollectionNewContapagar : contapagarCollectionNew) {
                if (!contapagarCollectionOld.contains(contapagarCollectionNewContapagar)) {
                    Fornecedor oldCodfornOfContapagarCollectionNewContapagar = contapagarCollectionNewContapagar.getCodforn();
                    contapagarCollectionNewContapagar.setCodforn(fornecedor);
                    contapagarCollectionNewContapagar = em.merge(contapagarCollectionNewContapagar);
                    if (oldCodfornOfContapagarCollectionNewContapagar != null && !oldCodfornOfContapagarCollectionNewContapagar.equals(fornecedor)) {
                        oldCodfornOfContapagarCollectionNewContapagar.getContapagarCollection().remove(contapagarCollectionNewContapagar);
                        oldCodfornOfContapagarCollectionNewContapagar = em.merge(oldCodfornOfContapagarCollectionNewContapagar);
                    }
                }
            }
            for (Cheques chequesCollectionOldCheques : chequesCollectionOld) {
                if (!chequesCollectionNew.contains(chequesCollectionOldCheques)) {
                    chequesCollectionOldCheques.setCodforn(null);
                    chequesCollectionOldCheques = em.merge(chequesCollectionOldCheques);
                }
            }
            for (Cheques chequesCollectionNewCheques : chequesCollectionNew) {
                if (!chequesCollectionOld.contains(chequesCollectionNewCheques)) {
                    Fornecedor oldCodfornOfChequesCollectionNewCheques = chequesCollectionNewCheques.getCodforn();
                    chequesCollectionNewCheques.setCodforn(fornecedor);
                    chequesCollectionNewCheques = em.merge(chequesCollectionNewCheques);
                    if (oldCodfornOfChequesCollectionNewCheques != null && !oldCodfornOfChequesCollectionNewCheques.equals(fornecedor)) {
                        oldCodfornOfChequesCollectionNewCheques.getChequesCollection().remove(chequesCollectionNewCheques);
                        oldCodfornOfChequesCollectionNewCheques = em.merge(oldCodfornOfChequesCollectionNewCheques);
                    }
                }
            }
            for (Contatosforn contatosfornCollectionOldContatosforn : contatosfornCollectionOld) {
                if (!contatosfornCollectionNew.contains(contatosfornCollectionOldContatosforn)) {
                    contatosfornCollectionOldContatosforn.setCodforn(null);
                    contatosfornCollectionOldContatosforn = em.merge(contatosfornCollectionOldContatosforn);
                }
            }
            for (Contatosforn contatosfornCollectionNewContatosforn : contatosfornCollectionNew) {
                if (!contatosfornCollectionOld.contains(contatosfornCollectionNewContatosforn)) {
                    Fornecedor oldCodfornOfContatosfornCollectionNewContatosforn = contatosfornCollectionNewContatosforn.getCodforn();
                    contatosfornCollectionNewContatosforn.setCodforn(fornecedor);
                    contatosfornCollectionNewContatosforn = em.merge(contatosfornCollectionNewContatosforn);
                    if (oldCodfornOfContatosfornCollectionNewContatosforn != null && !oldCodfornOfContatosfornCollectionNewContatosforn.equals(fornecedor)) {
                        oldCodfornOfContatosfornCollectionNewContatosforn.getContatosfornCollection().remove(contatosfornCollectionNewContatosforn);
                        oldCodfornOfContatosfornCollectionNewContatosforn = em.merge(oldCodfornOfContatosfornCollectionNewContatosforn);
                    }
                }
            }
            for (Contapagarfixa contapagarfixaCollectionOldContapagarfixa : contapagarfixaCollectionOld) {
                if (!contapagarfixaCollectionNew.contains(contapagarfixaCollectionOldContapagarfixa)) {
                    contapagarfixaCollectionOldContapagarfixa.setCodforn(null);
                    contapagarfixaCollectionOldContapagarfixa = em.merge(contapagarfixaCollectionOldContapagarfixa);
                }
            }
            for (Contapagarfixa contapagarfixaCollectionNewContapagarfixa : contapagarfixaCollectionNew) {
                if (!contapagarfixaCollectionOld.contains(contapagarfixaCollectionNewContapagarfixa)) {
                    Fornecedor oldCodfornOfContapagarfixaCollectionNewContapagarfixa = contapagarfixaCollectionNewContapagarfixa.getCodforn();
                    contapagarfixaCollectionNewContapagarfixa.setCodforn(fornecedor);
                    contapagarfixaCollectionNewContapagarfixa = em.merge(contapagarfixaCollectionNewContapagarfixa);
                    if (oldCodfornOfContapagarfixaCollectionNewContapagarfixa != null && !oldCodfornOfContapagarfixaCollectionNewContapagarfixa.equals(fornecedor)) {
                        oldCodfornOfContapagarfixaCollectionNewContapagarfixa.getContapagarfixaCollection().remove(contapagarfixaCollectionNewContapagarfixa);
                        oldCodfornOfContapagarfixaCollectionNewContapagarfixa = em.merge(oldCodfornOfContapagarfixaCollectionNewContapagarfixa);
                    }
                }
            }
            for (Produto produtoCollectionOldProduto : produtoCollectionOld) {
                if (!produtoCollectionNew.contains(produtoCollectionOldProduto)) {
                    produtoCollectionOldProduto.setCodforn(null);
                    produtoCollectionOldProduto = em.merge(produtoCollectionOldProduto);
                }
            }
            for (Produto produtoCollectionNewProduto : produtoCollectionNew) {
                if (!produtoCollectionOld.contains(produtoCollectionNewProduto)) {
                    Fornecedor oldCodfornOfProdutoCollectionNewProduto = produtoCollectionNewProduto.getCodforn();
                    produtoCollectionNewProduto.setCodforn(fornecedor);
                    produtoCollectionNewProduto = em.merge(produtoCollectionNewProduto);
                    if (oldCodfornOfProdutoCollectionNewProduto != null && !oldCodfornOfProdutoCollectionNewProduto.equals(fornecedor)) {
                        oldCodfornOfProdutoCollectionNewProduto.getProdutoCollection().remove(produtoCollectionNewProduto);
                        oldCodfornOfProdutoCollectionNewProduto = em.merge(oldCodfornOfProdutoCollectionNewProduto);
                    }
                }
            }
            for (Cotacaofornecedor cotacaofornecedorCollectionOldCotacaofornecedor : cotacaofornecedorCollectionOld) {
                if (!cotacaofornecedorCollectionNew.contains(cotacaofornecedorCollectionOldCotacaofornecedor)) {
                    cotacaofornecedorCollectionOldCotacaofornecedor.setCodforn(null);
                    cotacaofornecedorCollectionOldCotacaofornecedor = em.merge(cotacaofornecedorCollectionOldCotacaofornecedor);
                }
            }
            for (Cotacaofornecedor cotacaofornecedorCollectionNewCotacaofornecedor : cotacaofornecedorCollectionNew) {
                if (!cotacaofornecedorCollectionOld.contains(cotacaofornecedorCollectionNewCotacaofornecedor)) {
                    Fornecedor oldCodfornOfCotacaofornecedorCollectionNewCotacaofornecedor = cotacaofornecedorCollectionNewCotacaofornecedor.getCodforn();
                    cotacaofornecedorCollectionNewCotacaofornecedor.setCodforn(fornecedor);
                    cotacaofornecedorCollectionNewCotacaofornecedor = em.merge(cotacaofornecedorCollectionNewCotacaofornecedor);
                    if (oldCodfornOfCotacaofornecedorCollectionNewCotacaofornecedor != null && !oldCodfornOfCotacaofornecedorCollectionNewCotacaofornecedor.equals(fornecedor)) {
                        oldCodfornOfCotacaofornecedorCollectionNewCotacaofornecedor.getCotacaofornecedorCollection().remove(cotacaofornecedorCollectionNewCotacaofornecedor);
                        oldCodfornOfCotacaofornecedorCollectionNewCotacaofornecedor = em.merge(oldCodfornOfCotacaofornecedorCollectionNewCotacaofornecedor);
                    }
                }
            }
            for (Movendaproddevolucaocompra movendaproddevolucaocompraCollectionOldMovendaproddevolucaocompra : movendaproddevolucaocompraCollectionOld) {
                if (!movendaproddevolucaocompraCollectionNew.contains(movendaproddevolucaocompraCollectionOldMovendaproddevolucaocompra)) {
                    movendaproddevolucaocompraCollectionOldMovendaproddevolucaocompra.setCodforn(null);
                    movendaproddevolucaocompraCollectionOldMovendaproddevolucaocompra = em.merge(movendaproddevolucaocompraCollectionOldMovendaproddevolucaocompra);
                }
            }
            for (Movendaproddevolucaocompra movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra : movendaproddevolucaocompraCollectionNew) {
                if (!movendaproddevolucaocompraCollectionOld.contains(movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra)) {
                    Fornecedor oldCodfornOfMovendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra = movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra.getCodforn();
                    movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra.setCodforn(fornecedor);
                    movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra = em.merge(movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra);
                    if (oldCodfornOfMovendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra != null && !oldCodfornOfMovendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra.equals(fornecedor)) {
                        oldCodfornOfMovendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra.getMovendaproddevolucaocompraCollection().remove(movendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra);
                        oldCodfornOfMovendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra = em.merge(oldCodfornOfMovendaproddevolucaocompraCollectionNewMovendaproddevolucaocompra);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = fornecedor.getCodforn();
                if (findFornecedor(id) == null) {
                    throw new NonexistentEntityException("The fornecedor with id " + id + " no longer exists.");
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
            Fornecedor fornecedor;
            try {
                fornecedor = em.getReference(Fornecedor.class, id);
                fornecedor.getCodforn();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The fornecedor with id " + id + " no longer exists.", enfe);
            }
            Formapag codfp = fornecedor.getCodfp();
            if (codfp != null) {
                codfp.getFornecedorCollection().remove(fornecedor);
                codfp = em.merge(codfp);
            }
            Transportadora codtrans = fornecedor.getCodtrans();
            if (codtrans != null) {
                codtrans.getFornecedorCollection().remove(fornecedor);
                codtrans = em.merge(codtrans);
            }
            Collection<Chequesfirma> chequesfirmaCollection = fornecedor.getChequesfirmaCollection();
            for (Chequesfirma chequesfirmaCollectionChequesfirma : chequesfirmaCollection) {
                chequesfirmaCollectionChequesfirma.setCodforn(null);
                chequesfirmaCollectionChequesfirma = em.merge(chequesfirmaCollectionChequesfirma);
            }
            Collection<Contapagar> contapagarCollection = fornecedor.getContapagarCollection();
            for (Contapagar contapagarCollectionContapagar : contapagarCollection) {
                contapagarCollectionContapagar.setCodforn(null);
                contapagarCollectionContapagar = em.merge(contapagarCollectionContapagar);
            }
            Collection<Cheques> chequesCollection = fornecedor.getChequesCollection();
            for (Cheques chequesCollectionCheques : chequesCollection) {
                chequesCollectionCheques.setCodforn(null);
                chequesCollectionCheques = em.merge(chequesCollectionCheques);
            }
            Collection<Contatosforn> contatosfornCollection = fornecedor.getContatosfornCollection();
            for (Contatosforn contatosfornCollectionContatosforn : contatosfornCollection) {
                contatosfornCollectionContatosforn.setCodforn(null);
                contatosfornCollectionContatosforn = em.merge(contatosfornCollectionContatosforn);
            }
            Collection<Contapagarfixa> contapagarfixaCollection = fornecedor.getContapagarfixaCollection();
            for (Contapagarfixa contapagarfixaCollectionContapagarfixa : contapagarfixaCollection) {
                contapagarfixaCollectionContapagarfixa.setCodforn(null);
                contapagarfixaCollectionContapagarfixa = em.merge(contapagarfixaCollectionContapagarfixa);
            }
            Collection<Produto> produtoCollection = fornecedor.getProdutoCollection();
            for (Produto produtoCollectionProduto : produtoCollection) {
                produtoCollectionProduto.setCodforn(null);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
            }
            Collection<Cotacaofornecedor> cotacaofornecedorCollection = fornecedor.getCotacaofornecedorCollection();
            for (Cotacaofornecedor cotacaofornecedorCollectionCotacaofornecedor : cotacaofornecedorCollection) {
                cotacaofornecedorCollectionCotacaofornecedor.setCodforn(null);
                cotacaofornecedorCollectionCotacaofornecedor = em.merge(cotacaofornecedorCollectionCotacaofornecedor);
            }
            Collection<Movendaproddevolucaocompra> movendaproddevolucaocompraCollection = fornecedor.getMovendaproddevolucaocompraCollection();
            for (Movendaproddevolucaocompra movendaproddevolucaocompraCollectionMovendaproddevolucaocompra : movendaproddevolucaocompraCollection) {
                movendaproddevolucaocompraCollectionMovendaproddevolucaocompra.setCodforn(null);
                movendaproddevolucaocompraCollectionMovendaproddevolucaocompra = em.merge(movendaproddevolucaocompraCollectionMovendaproddevolucaocompra);
            }
            em.remove(fornecedor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Fornecedor> findFornecedorEntities() {
        return findFornecedorEntities(true, -1, -1);
    }

    public List<Fornecedor> findFornecedorEntities(int maxResults, int firstResult) {
        return findFornecedorEntities(false, maxResults, firstResult);
    }

    private List<Fornecedor> findFornecedorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Fornecedor.class));
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

    public Fornecedor findFornecedor(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Fornecedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getFornecedorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Fornecedor> rt = cq.from(Fornecedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Centrocusto;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Chequesfirma;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Moventrada;
import entidade.cplus.Contapagar;
import entidade.cplus.Cheques;
import entidade.cplus.Recebimento;
import entidade.cplus.Contareceber;
import entidade.cplus.Contapagarfixa;
import entidade.cplus.Pedido;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class CentrocustoJpaController implements Serializable {

    public CentrocustoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Centrocusto centrocusto) throws PreexistingEntityException, Exception {
        if (centrocusto.getChequesfirmaCollection() == null) {
            centrocusto.setChequesfirmaCollection(new ArrayList<Chequesfirma>());
        }
        if (centrocusto.getMoventradaCollection() == null) {
            centrocusto.setMoventradaCollection(new ArrayList<Moventrada>());
        }
        if (centrocusto.getContapagarCollection() == null) {
            centrocusto.setContapagarCollection(new ArrayList<Contapagar>());
        }
        if (centrocusto.getChequesCollection() == null) {
            centrocusto.setChequesCollection(new ArrayList<Cheques>());
        }
        if (centrocusto.getRecebimentoCollection() == null) {
            centrocusto.setRecebimentoCollection(new ArrayList<Recebimento>());
        }
        if (centrocusto.getContareceberCollection() == null) {
            centrocusto.setContareceberCollection(new ArrayList<Contareceber>());
        }
        if (centrocusto.getContapagarfixaCollection() == null) {
            centrocusto.setContapagarfixaCollection(new ArrayList<Contapagarfixa>());
        }
        if (centrocusto.getPedidoCollection() == null) {
            centrocusto.setPedidoCollection(new ArrayList<Pedido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Chequesfirma> attachedChequesfirmaCollection = new ArrayList<Chequesfirma>();
            for (Chequesfirma chequesfirmaCollectionChequesfirmaToAttach : centrocusto.getChequesfirmaCollection()) {
                chequesfirmaCollectionChequesfirmaToAttach = em.getReference(chequesfirmaCollectionChequesfirmaToAttach.getClass(), chequesfirmaCollectionChequesfirmaToAttach.getCodchequefirma());
                attachedChequesfirmaCollection.add(chequesfirmaCollectionChequesfirmaToAttach);
            }
            centrocusto.setChequesfirmaCollection(attachedChequesfirmaCollection);
            Collection<Moventrada> attachedMoventradaCollection = new ArrayList<Moventrada>();
            for (Moventrada moventradaCollectionMoventradaToAttach : centrocusto.getMoventradaCollection()) {
                moventradaCollectionMoventradaToAttach = em.getReference(moventradaCollectionMoventradaToAttach.getClass(), moventradaCollectionMoventradaToAttach.getCodmoventr());
                attachedMoventradaCollection.add(moventradaCollectionMoventradaToAttach);
            }
            centrocusto.setMoventradaCollection(attachedMoventradaCollection);
            Collection<Contapagar> attachedContapagarCollection = new ArrayList<Contapagar>();
            for (Contapagar contapagarCollectionContapagarToAttach : centrocusto.getContapagarCollection()) {
                contapagarCollectionContapagarToAttach = em.getReference(contapagarCollectionContapagarToAttach.getClass(), contapagarCollectionContapagarToAttach.getCodcp());
                attachedContapagarCollection.add(contapagarCollectionContapagarToAttach);
            }
            centrocusto.setContapagarCollection(attachedContapagarCollection);
            Collection<Cheques> attachedChequesCollection = new ArrayList<Cheques>();
            for (Cheques chequesCollectionChequesToAttach : centrocusto.getChequesCollection()) {
                chequesCollectionChequesToAttach = em.getReference(chequesCollectionChequesToAttach.getClass(), chequesCollectionChequesToAttach.getCodcheque());
                attachedChequesCollection.add(chequesCollectionChequesToAttach);
            }
            centrocusto.setChequesCollection(attachedChequesCollection);
            Collection<Recebimento> attachedRecebimentoCollection = new ArrayList<Recebimento>();
            for (Recebimento recebimentoCollectionRecebimentoToAttach : centrocusto.getRecebimentoCollection()) {
                recebimentoCollectionRecebimentoToAttach = em.getReference(recebimentoCollectionRecebimentoToAttach.getClass(), recebimentoCollectionRecebimentoToAttach.getCodrec());
                attachedRecebimentoCollection.add(recebimentoCollectionRecebimentoToAttach);
            }
            centrocusto.setRecebimentoCollection(attachedRecebimentoCollection);
            Collection<Contareceber> attachedContareceberCollection = new ArrayList<Contareceber>();
            for (Contareceber contareceberCollectionContareceberToAttach : centrocusto.getContareceberCollection()) {
                contareceberCollectionContareceberToAttach = em.getReference(contareceberCollectionContareceberToAttach.getClass(), contareceberCollectionContareceberToAttach.getCodcr());
                attachedContareceberCollection.add(contareceberCollectionContareceberToAttach);
            }
            centrocusto.setContareceberCollection(attachedContareceberCollection);
            Collection<Contapagarfixa> attachedContapagarfixaCollection = new ArrayList<Contapagarfixa>();
            for (Contapagarfixa contapagarfixaCollectionContapagarfixaToAttach : centrocusto.getContapagarfixaCollection()) {
                contapagarfixaCollectionContapagarfixaToAttach = em.getReference(contapagarfixaCollectionContapagarfixaToAttach.getClass(), contapagarfixaCollectionContapagarfixaToAttach.getCodcpfixa());
                attachedContapagarfixaCollection.add(contapagarfixaCollectionContapagarfixaToAttach);
            }
            centrocusto.setContapagarfixaCollection(attachedContapagarfixaCollection);
            Collection<Pedido> attachedPedidoCollection = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionPedidoToAttach : centrocusto.getPedidoCollection()) {
                pedidoCollectionPedidoToAttach = em.getReference(pedidoCollectionPedidoToAttach.getClass(), pedidoCollectionPedidoToAttach.getCodped());
                attachedPedidoCollection.add(pedidoCollectionPedidoToAttach);
            }
            centrocusto.setPedidoCollection(attachedPedidoCollection);
            em.persist(centrocusto);
            for (Chequesfirma chequesfirmaCollectionChequesfirma : centrocusto.getChequesfirmaCollection()) {
                Centrocusto oldCodcentrocustoOfChequesfirmaCollectionChequesfirma = chequesfirmaCollectionChequesfirma.getCodcentrocusto();
                chequesfirmaCollectionChequesfirma.setCodcentrocusto(centrocusto);
                chequesfirmaCollectionChequesfirma = em.merge(chequesfirmaCollectionChequesfirma);
                if (oldCodcentrocustoOfChequesfirmaCollectionChequesfirma != null) {
                    oldCodcentrocustoOfChequesfirmaCollectionChequesfirma.getChequesfirmaCollection().remove(chequesfirmaCollectionChequesfirma);
                    oldCodcentrocustoOfChequesfirmaCollectionChequesfirma = em.merge(oldCodcentrocustoOfChequesfirmaCollectionChequesfirma);
                }
            }
            for (Moventrada moventradaCollectionMoventrada : centrocusto.getMoventradaCollection()) {
                Centrocusto oldCodcentrocustoOfMoventradaCollectionMoventrada = moventradaCollectionMoventrada.getCodcentrocusto();
                moventradaCollectionMoventrada.setCodcentrocusto(centrocusto);
                moventradaCollectionMoventrada = em.merge(moventradaCollectionMoventrada);
                if (oldCodcentrocustoOfMoventradaCollectionMoventrada != null) {
                    oldCodcentrocustoOfMoventradaCollectionMoventrada.getMoventradaCollection().remove(moventradaCollectionMoventrada);
                    oldCodcentrocustoOfMoventradaCollectionMoventrada = em.merge(oldCodcentrocustoOfMoventradaCollectionMoventrada);
                }
            }
            for (Contapagar contapagarCollectionContapagar : centrocusto.getContapagarCollection()) {
                Centrocusto oldCodcentrocustoOfContapagarCollectionContapagar = contapagarCollectionContapagar.getCodcentrocusto();
                contapagarCollectionContapagar.setCodcentrocusto(centrocusto);
                contapagarCollectionContapagar = em.merge(contapagarCollectionContapagar);
                if (oldCodcentrocustoOfContapagarCollectionContapagar != null) {
                    oldCodcentrocustoOfContapagarCollectionContapagar.getContapagarCollection().remove(contapagarCollectionContapagar);
                    oldCodcentrocustoOfContapagarCollectionContapagar = em.merge(oldCodcentrocustoOfContapagarCollectionContapagar);
                }
            }
            for (Cheques chequesCollectionCheques : centrocusto.getChequesCollection()) {
                Centrocusto oldCodcentrocustoOfChequesCollectionCheques = chequesCollectionCheques.getCodcentrocusto();
                chequesCollectionCheques.setCodcentrocusto(centrocusto);
                chequesCollectionCheques = em.merge(chequesCollectionCheques);
                if (oldCodcentrocustoOfChequesCollectionCheques != null) {
                    oldCodcentrocustoOfChequesCollectionCheques.getChequesCollection().remove(chequesCollectionCheques);
                    oldCodcentrocustoOfChequesCollectionCheques = em.merge(oldCodcentrocustoOfChequesCollectionCheques);
                }
            }
            for (Recebimento recebimentoCollectionRecebimento : centrocusto.getRecebimentoCollection()) {
                Centrocusto oldCodcentrocustoOfRecebimentoCollectionRecebimento = recebimentoCollectionRecebimento.getCodcentrocusto();
                recebimentoCollectionRecebimento.setCodcentrocusto(centrocusto);
                recebimentoCollectionRecebimento = em.merge(recebimentoCollectionRecebimento);
                if (oldCodcentrocustoOfRecebimentoCollectionRecebimento != null) {
                    oldCodcentrocustoOfRecebimentoCollectionRecebimento.getRecebimentoCollection().remove(recebimentoCollectionRecebimento);
                    oldCodcentrocustoOfRecebimentoCollectionRecebimento = em.merge(oldCodcentrocustoOfRecebimentoCollectionRecebimento);
                }
            }
            for (Contareceber contareceberCollectionContareceber : centrocusto.getContareceberCollection()) {
                Centrocusto oldCodcentrocustoOfContareceberCollectionContareceber = contareceberCollectionContareceber.getCodcentrocusto();
                contareceberCollectionContareceber.setCodcentrocusto(centrocusto);
                contareceberCollectionContareceber = em.merge(contareceberCollectionContareceber);
                if (oldCodcentrocustoOfContareceberCollectionContareceber != null) {
                    oldCodcentrocustoOfContareceberCollectionContareceber.getContareceberCollection().remove(contareceberCollectionContareceber);
                    oldCodcentrocustoOfContareceberCollectionContareceber = em.merge(oldCodcentrocustoOfContareceberCollectionContareceber);
                }
            }
            for (Contapagarfixa contapagarfixaCollectionContapagarfixa : centrocusto.getContapagarfixaCollection()) {
                Centrocusto oldCodcentrocustoOfContapagarfixaCollectionContapagarfixa = contapagarfixaCollectionContapagarfixa.getCodcentrocusto();
                contapagarfixaCollectionContapagarfixa.setCodcentrocusto(centrocusto);
                contapagarfixaCollectionContapagarfixa = em.merge(contapagarfixaCollectionContapagarfixa);
                if (oldCodcentrocustoOfContapagarfixaCollectionContapagarfixa != null) {
                    oldCodcentrocustoOfContapagarfixaCollectionContapagarfixa.getContapagarfixaCollection().remove(contapagarfixaCollectionContapagarfixa);
                    oldCodcentrocustoOfContapagarfixaCollectionContapagarfixa = em.merge(oldCodcentrocustoOfContapagarfixaCollectionContapagarfixa);
                }
            }
            for (Pedido pedidoCollectionPedido : centrocusto.getPedidoCollection()) {
                Centrocusto oldCodcentrocustoOfPedidoCollectionPedido = pedidoCollectionPedido.getCodcentrocusto();
                pedidoCollectionPedido.setCodcentrocusto(centrocusto);
                pedidoCollectionPedido = em.merge(pedidoCollectionPedido);
                if (oldCodcentrocustoOfPedidoCollectionPedido != null) {
                    oldCodcentrocustoOfPedidoCollectionPedido.getPedidoCollection().remove(pedidoCollectionPedido);
                    oldCodcentrocustoOfPedidoCollectionPedido = em.merge(oldCodcentrocustoOfPedidoCollectionPedido);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCentrocusto(centrocusto.getCodcentrocusto()) != null) {
                throw new PreexistingEntityException("Centrocusto " + centrocusto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Centrocusto centrocusto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Centrocusto persistentCentrocusto = em.find(Centrocusto.class, centrocusto.getCodcentrocusto());
            Collection<Chequesfirma> chequesfirmaCollectionOld = persistentCentrocusto.getChequesfirmaCollection();
            Collection<Chequesfirma> chequesfirmaCollectionNew = centrocusto.getChequesfirmaCollection();
            Collection<Moventrada> moventradaCollectionOld = persistentCentrocusto.getMoventradaCollection();
            Collection<Moventrada> moventradaCollectionNew = centrocusto.getMoventradaCollection();
            Collection<Contapagar> contapagarCollectionOld = persistentCentrocusto.getContapagarCollection();
            Collection<Contapagar> contapagarCollectionNew = centrocusto.getContapagarCollection();
            Collection<Cheques> chequesCollectionOld = persistentCentrocusto.getChequesCollection();
            Collection<Cheques> chequesCollectionNew = centrocusto.getChequesCollection();
            Collection<Recebimento> recebimentoCollectionOld = persistentCentrocusto.getRecebimentoCollection();
            Collection<Recebimento> recebimentoCollectionNew = centrocusto.getRecebimentoCollection();
            Collection<Contareceber> contareceberCollectionOld = persistentCentrocusto.getContareceberCollection();
            Collection<Contareceber> contareceberCollectionNew = centrocusto.getContareceberCollection();
            Collection<Contapagarfixa> contapagarfixaCollectionOld = persistentCentrocusto.getContapagarfixaCollection();
            Collection<Contapagarfixa> contapagarfixaCollectionNew = centrocusto.getContapagarfixaCollection();
            Collection<Pedido> pedidoCollectionOld = persistentCentrocusto.getPedidoCollection();
            Collection<Pedido> pedidoCollectionNew = centrocusto.getPedidoCollection();
            Collection<Chequesfirma> attachedChequesfirmaCollectionNew = new ArrayList<Chequesfirma>();
            for (Chequesfirma chequesfirmaCollectionNewChequesfirmaToAttach : chequesfirmaCollectionNew) {
                chequesfirmaCollectionNewChequesfirmaToAttach = em.getReference(chequesfirmaCollectionNewChequesfirmaToAttach.getClass(), chequesfirmaCollectionNewChequesfirmaToAttach.getCodchequefirma());
                attachedChequesfirmaCollectionNew.add(chequesfirmaCollectionNewChequesfirmaToAttach);
            }
            chequesfirmaCollectionNew = attachedChequesfirmaCollectionNew;
            centrocusto.setChequesfirmaCollection(chequesfirmaCollectionNew);
            Collection<Moventrada> attachedMoventradaCollectionNew = new ArrayList<Moventrada>();
            for (Moventrada moventradaCollectionNewMoventradaToAttach : moventradaCollectionNew) {
                moventradaCollectionNewMoventradaToAttach = em.getReference(moventradaCollectionNewMoventradaToAttach.getClass(), moventradaCollectionNewMoventradaToAttach.getCodmoventr());
                attachedMoventradaCollectionNew.add(moventradaCollectionNewMoventradaToAttach);
            }
            moventradaCollectionNew = attachedMoventradaCollectionNew;
            centrocusto.setMoventradaCollection(moventradaCollectionNew);
            Collection<Contapagar> attachedContapagarCollectionNew = new ArrayList<Contapagar>();
            for (Contapagar contapagarCollectionNewContapagarToAttach : contapagarCollectionNew) {
                contapagarCollectionNewContapagarToAttach = em.getReference(contapagarCollectionNewContapagarToAttach.getClass(), contapagarCollectionNewContapagarToAttach.getCodcp());
                attachedContapagarCollectionNew.add(contapagarCollectionNewContapagarToAttach);
            }
            contapagarCollectionNew = attachedContapagarCollectionNew;
            centrocusto.setContapagarCollection(contapagarCollectionNew);
            Collection<Cheques> attachedChequesCollectionNew = new ArrayList<Cheques>();
            for (Cheques chequesCollectionNewChequesToAttach : chequesCollectionNew) {
                chequesCollectionNewChequesToAttach = em.getReference(chequesCollectionNewChequesToAttach.getClass(), chequesCollectionNewChequesToAttach.getCodcheque());
                attachedChequesCollectionNew.add(chequesCollectionNewChequesToAttach);
            }
            chequesCollectionNew = attachedChequesCollectionNew;
            centrocusto.setChequesCollection(chequesCollectionNew);
            Collection<Recebimento> attachedRecebimentoCollectionNew = new ArrayList<Recebimento>();
            for (Recebimento recebimentoCollectionNewRecebimentoToAttach : recebimentoCollectionNew) {
                recebimentoCollectionNewRecebimentoToAttach = em.getReference(recebimentoCollectionNewRecebimentoToAttach.getClass(), recebimentoCollectionNewRecebimentoToAttach.getCodrec());
                attachedRecebimentoCollectionNew.add(recebimentoCollectionNewRecebimentoToAttach);
            }
            recebimentoCollectionNew = attachedRecebimentoCollectionNew;
            centrocusto.setRecebimentoCollection(recebimentoCollectionNew);
            Collection<Contareceber> attachedContareceberCollectionNew = new ArrayList<Contareceber>();
            for (Contareceber contareceberCollectionNewContareceberToAttach : contareceberCollectionNew) {
                contareceberCollectionNewContareceberToAttach = em.getReference(contareceberCollectionNewContareceberToAttach.getClass(), contareceberCollectionNewContareceberToAttach.getCodcr());
                attachedContareceberCollectionNew.add(contareceberCollectionNewContareceberToAttach);
            }
            contareceberCollectionNew = attachedContareceberCollectionNew;
            centrocusto.setContareceberCollection(contareceberCollectionNew);
            Collection<Contapagarfixa> attachedContapagarfixaCollectionNew = new ArrayList<Contapagarfixa>();
            for (Contapagarfixa contapagarfixaCollectionNewContapagarfixaToAttach : contapagarfixaCollectionNew) {
                contapagarfixaCollectionNewContapagarfixaToAttach = em.getReference(contapagarfixaCollectionNewContapagarfixaToAttach.getClass(), contapagarfixaCollectionNewContapagarfixaToAttach.getCodcpfixa());
                attachedContapagarfixaCollectionNew.add(contapagarfixaCollectionNewContapagarfixaToAttach);
            }
            contapagarfixaCollectionNew = attachedContapagarfixaCollectionNew;
            centrocusto.setContapagarfixaCollection(contapagarfixaCollectionNew);
            Collection<Pedido> attachedPedidoCollectionNew = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionNewPedidoToAttach : pedidoCollectionNew) {
                pedidoCollectionNewPedidoToAttach = em.getReference(pedidoCollectionNewPedidoToAttach.getClass(), pedidoCollectionNewPedidoToAttach.getCodped());
                attachedPedidoCollectionNew.add(pedidoCollectionNewPedidoToAttach);
            }
            pedidoCollectionNew = attachedPedidoCollectionNew;
            centrocusto.setPedidoCollection(pedidoCollectionNew);
            centrocusto = em.merge(centrocusto);
            for (Chequesfirma chequesfirmaCollectionOldChequesfirma : chequesfirmaCollectionOld) {
                if (!chequesfirmaCollectionNew.contains(chequesfirmaCollectionOldChequesfirma)) {
                    chequesfirmaCollectionOldChequesfirma.setCodcentrocusto(null);
                    chequesfirmaCollectionOldChequesfirma = em.merge(chequesfirmaCollectionOldChequesfirma);
                }
            }
            for (Chequesfirma chequesfirmaCollectionNewChequesfirma : chequesfirmaCollectionNew) {
                if (!chequesfirmaCollectionOld.contains(chequesfirmaCollectionNewChequesfirma)) {
                    Centrocusto oldCodcentrocustoOfChequesfirmaCollectionNewChequesfirma = chequesfirmaCollectionNewChequesfirma.getCodcentrocusto();
                    chequesfirmaCollectionNewChequesfirma.setCodcentrocusto(centrocusto);
                    chequesfirmaCollectionNewChequesfirma = em.merge(chequesfirmaCollectionNewChequesfirma);
                    if (oldCodcentrocustoOfChequesfirmaCollectionNewChequesfirma != null && !oldCodcentrocustoOfChequesfirmaCollectionNewChequesfirma.equals(centrocusto)) {
                        oldCodcentrocustoOfChequesfirmaCollectionNewChequesfirma.getChequesfirmaCollection().remove(chequesfirmaCollectionNewChequesfirma);
                        oldCodcentrocustoOfChequesfirmaCollectionNewChequesfirma = em.merge(oldCodcentrocustoOfChequesfirmaCollectionNewChequesfirma);
                    }
                }
            }
            for (Moventrada moventradaCollectionOldMoventrada : moventradaCollectionOld) {
                if (!moventradaCollectionNew.contains(moventradaCollectionOldMoventrada)) {
                    moventradaCollectionOldMoventrada.setCodcentrocusto(null);
                    moventradaCollectionOldMoventrada = em.merge(moventradaCollectionOldMoventrada);
                }
            }
            for (Moventrada moventradaCollectionNewMoventrada : moventradaCollectionNew) {
                if (!moventradaCollectionOld.contains(moventradaCollectionNewMoventrada)) {
                    Centrocusto oldCodcentrocustoOfMoventradaCollectionNewMoventrada = moventradaCollectionNewMoventrada.getCodcentrocusto();
                    moventradaCollectionNewMoventrada.setCodcentrocusto(centrocusto);
                    moventradaCollectionNewMoventrada = em.merge(moventradaCollectionNewMoventrada);
                    if (oldCodcentrocustoOfMoventradaCollectionNewMoventrada != null && !oldCodcentrocustoOfMoventradaCollectionNewMoventrada.equals(centrocusto)) {
                        oldCodcentrocustoOfMoventradaCollectionNewMoventrada.getMoventradaCollection().remove(moventradaCollectionNewMoventrada);
                        oldCodcentrocustoOfMoventradaCollectionNewMoventrada = em.merge(oldCodcentrocustoOfMoventradaCollectionNewMoventrada);
                    }
                }
            }
            for (Contapagar contapagarCollectionOldContapagar : contapagarCollectionOld) {
                if (!contapagarCollectionNew.contains(contapagarCollectionOldContapagar)) {
                    contapagarCollectionOldContapagar.setCodcentrocusto(null);
                    contapagarCollectionOldContapagar = em.merge(contapagarCollectionOldContapagar);
                }
            }
            for (Contapagar contapagarCollectionNewContapagar : contapagarCollectionNew) {
                if (!contapagarCollectionOld.contains(contapagarCollectionNewContapagar)) {
                    Centrocusto oldCodcentrocustoOfContapagarCollectionNewContapagar = contapagarCollectionNewContapagar.getCodcentrocusto();
                    contapagarCollectionNewContapagar.setCodcentrocusto(centrocusto);
                    contapagarCollectionNewContapagar = em.merge(contapagarCollectionNewContapagar);
                    if (oldCodcentrocustoOfContapagarCollectionNewContapagar != null && !oldCodcentrocustoOfContapagarCollectionNewContapagar.equals(centrocusto)) {
                        oldCodcentrocustoOfContapagarCollectionNewContapagar.getContapagarCollection().remove(contapagarCollectionNewContapagar);
                        oldCodcentrocustoOfContapagarCollectionNewContapagar = em.merge(oldCodcentrocustoOfContapagarCollectionNewContapagar);
                    }
                }
            }
            for (Cheques chequesCollectionOldCheques : chequesCollectionOld) {
                if (!chequesCollectionNew.contains(chequesCollectionOldCheques)) {
                    chequesCollectionOldCheques.setCodcentrocusto(null);
                    chequesCollectionOldCheques = em.merge(chequesCollectionOldCheques);
                }
            }
            for (Cheques chequesCollectionNewCheques : chequesCollectionNew) {
                if (!chequesCollectionOld.contains(chequesCollectionNewCheques)) {
                    Centrocusto oldCodcentrocustoOfChequesCollectionNewCheques = chequesCollectionNewCheques.getCodcentrocusto();
                    chequesCollectionNewCheques.setCodcentrocusto(centrocusto);
                    chequesCollectionNewCheques = em.merge(chequesCollectionNewCheques);
                    if (oldCodcentrocustoOfChequesCollectionNewCheques != null && !oldCodcentrocustoOfChequesCollectionNewCheques.equals(centrocusto)) {
                        oldCodcentrocustoOfChequesCollectionNewCheques.getChequesCollection().remove(chequesCollectionNewCheques);
                        oldCodcentrocustoOfChequesCollectionNewCheques = em.merge(oldCodcentrocustoOfChequesCollectionNewCheques);
                    }
                }
            }
            for (Recebimento recebimentoCollectionOldRecebimento : recebimentoCollectionOld) {
                if (!recebimentoCollectionNew.contains(recebimentoCollectionOldRecebimento)) {
                    recebimentoCollectionOldRecebimento.setCodcentrocusto(null);
                    recebimentoCollectionOldRecebimento = em.merge(recebimentoCollectionOldRecebimento);
                }
            }
            for (Recebimento recebimentoCollectionNewRecebimento : recebimentoCollectionNew) {
                if (!recebimentoCollectionOld.contains(recebimentoCollectionNewRecebimento)) {
                    Centrocusto oldCodcentrocustoOfRecebimentoCollectionNewRecebimento = recebimentoCollectionNewRecebimento.getCodcentrocusto();
                    recebimentoCollectionNewRecebimento.setCodcentrocusto(centrocusto);
                    recebimentoCollectionNewRecebimento = em.merge(recebimentoCollectionNewRecebimento);
                    if (oldCodcentrocustoOfRecebimentoCollectionNewRecebimento != null && !oldCodcentrocustoOfRecebimentoCollectionNewRecebimento.equals(centrocusto)) {
                        oldCodcentrocustoOfRecebimentoCollectionNewRecebimento.getRecebimentoCollection().remove(recebimentoCollectionNewRecebimento);
                        oldCodcentrocustoOfRecebimentoCollectionNewRecebimento = em.merge(oldCodcentrocustoOfRecebimentoCollectionNewRecebimento);
                    }
                }
            }
            for (Contareceber contareceberCollectionOldContareceber : contareceberCollectionOld) {
                if (!contareceberCollectionNew.contains(contareceberCollectionOldContareceber)) {
                    contareceberCollectionOldContareceber.setCodcentrocusto(null);
                    contareceberCollectionOldContareceber = em.merge(contareceberCollectionOldContareceber);
                }
            }
            for (Contareceber contareceberCollectionNewContareceber : contareceberCollectionNew) {
                if (!contareceberCollectionOld.contains(contareceberCollectionNewContareceber)) {
                    Centrocusto oldCodcentrocustoOfContareceberCollectionNewContareceber = contareceberCollectionNewContareceber.getCodcentrocusto();
                    contareceberCollectionNewContareceber.setCodcentrocusto(centrocusto);
                    contareceberCollectionNewContareceber = em.merge(contareceberCollectionNewContareceber);
                    if (oldCodcentrocustoOfContareceberCollectionNewContareceber != null && !oldCodcentrocustoOfContareceberCollectionNewContareceber.equals(centrocusto)) {
                        oldCodcentrocustoOfContareceberCollectionNewContareceber.getContareceberCollection().remove(contareceberCollectionNewContareceber);
                        oldCodcentrocustoOfContareceberCollectionNewContareceber = em.merge(oldCodcentrocustoOfContareceberCollectionNewContareceber);
                    }
                }
            }
            for (Contapagarfixa contapagarfixaCollectionOldContapagarfixa : contapagarfixaCollectionOld) {
                if (!contapagarfixaCollectionNew.contains(contapagarfixaCollectionOldContapagarfixa)) {
                    contapagarfixaCollectionOldContapagarfixa.setCodcentrocusto(null);
                    contapagarfixaCollectionOldContapagarfixa = em.merge(contapagarfixaCollectionOldContapagarfixa);
                }
            }
            for (Contapagarfixa contapagarfixaCollectionNewContapagarfixa : contapagarfixaCollectionNew) {
                if (!contapagarfixaCollectionOld.contains(contapagarfixaCollectionNewContapagarfixa)) {
                    Centrocusto oldCodcentrocustoOfContapagarfixaCollectionNewContapagarfixa = contapagarfixaCollectionNewContapagarfixa.getCodcentrocusto();
                    contapagarfixaCollectionNewContapagarfixa.setCodcentrocusto(centrocusto);
                    contapagarfixaCollectionNewContapagarfixa = em.merge(contapagarfixaCollectionNewContapagarfixa);
                    if (oldCodcentrocustoOfContapagarfixaCollectionNewContapagarfixa != null && !oldCodcentrocustoOfContapagarfixaCollectionNewContapagarfixa.equals(centrocusto)) {
                        oldCodcentrocustoOfContapagarfixaCollectionNewContapagarfixa.getContapagarfixaCollection().remove(contapagarfixaCollectionNewContapagarfixa);
                        oldCodcentrocustoOfContapagarfixaCollectionNewContapagarfixa = em.merge(oldCodcentrocustoOfContapagarfixaCollectionNewContapagarfixa);
                    }
                }
            }
            for (Pedido pedidoCollectionOldPedido : pedidoCollectionOld) {
                if (!pedidoCollectionNew.contains(pedidoCollectionOldPedido)) {
                    pedidoCollectionOldPedido.setCodcentrocusto(null);
                    pedidoCollectionOldPedido = em.merge(pedidoCollectionOldPedido);
                }
            }
            for (Pedido pedidoCollectionNewPedido : pedidoCollectionNew) {
                if (!pedidoCollectionOld.contains(pedidoCollectionNewPedido)) {
                    Centrocusto oldCodcentrocustoOfPedidoCollectionNewPedido = pedidoCollectionNewPedido.getCodcentrocusto();
                    pedidoCollectionNewPedido.setCodcentrocusto(centrocusto);
                    pedidoCollectionNewPedido = em.merge(pedidoCollectionNewPedido);
                    if (oldCodcentrocustoOfPedidoCollectionNewPedido != null && !oldCodcentrocustoOfPedidoCollectionNewPedido.equals(centrocusto)) {
                        oldCodcentrocustoOfPedidoCollectionNewPedido.getPedidoCollection().remove(pedidoCollectionNewPedido);
                        oldCodcentrocustoOfPedidoCollectionNewPedido = em.merge(oldCodcentrocustoOfPedidoCollectionNewPedido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = centrocusto.getCodcentrocusto();
                if (findCentrocusto(id) == null) {
                    throw new NonexistentEntityException("The centrocusto with id " + id + " no longer exists.");
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
            Centrocusto centrocusto;
            try {
                centrocusto = em.getReference(Centrocusto.class, id);
                centrocusto.getCodcentrocusto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The centrocusto with id " + id + " no longer exists.", enfe);
            }
            Collection<Chequesfirma> chequesfirmaCollection = centrocusto.getChequesfirmaCollection();
            for (Chequesfirma chequesfirmaCollectionChequesfirma : chequesfirmaCollection) {
                chequesfirmaCollectionChequesfirma.setCodcentrocusto(null);
                chequesfirmaCollectionChequesfirma = em.merge(chequesfirmaCollectionChequesfirma);
            }
            Collection<Moventrada> moventradaCollection = centrocusto.getMoventradaCollection();
            for (Moventrada moventradaCollectionMoventrada : moventradaCollection) {
                moventradaCollectionMoventrada.setCodcentrocusto(null);
                moventradaCollectionMoventrada = em.merge(moventradaCollectionMoventrada);
            }
            Collection<Contapagar> contapagarCollection = centrocusto.getContapagarCollection();
            for (Contapagar contapagarCollectionContapagar : contapagarCollection) {
                contapagarCollectionContapagar.setCodcentrocusto(null);
                contapagarCollectionContapagar = em.merge(contapagarCollectionContapagar);
            }
            Collection<Cheques> chequesCollection = centrocusto.getChequesCollection();
            for (Cheques chequesCollectionCheques : chequesCollection) {
                chequesCollectionCheques.setCodcentrocusto(null);
                chequesCollectionCheques = em.merge(chequesCollectionCheques);
            }
            Collection<Recebimento> recebimentoCollection = centrocusto.getRecebimentoCollection();
            for (Recebimento recebimentoCollectionRecebimento : recebimentoCollection) {
                recebimentoCollectionRecebimento.setCodcentrocusto(null);
                recebimentoCollectionRecebimento = em.merge(recebimentoCollectionRecebimento);
            }
            Collection<Contareceber> contareceberCollection = centrocusto.getContareceberCollection();
            for (Contareceber contareceberCollectionContareceber : contareceberCollection) {
                contareceberCollectionContareceber.setCodcentrocusto(null);
                contareceberCollectionContareceber = em.merge(contareceberCollectionContareceber);
            }
            Collection<Contapagarfixa> contapagarfixaCollection = centrocusto.getContapagarfixaCollection();
            for (Contapagarfixa contapagarfixaCollectionContapagarfixa : contapagarfixaCollection) {
                contapagarfixaCollectionContapagarfixa.setCodcentrocusto(null);
                contapagarfixaCollectionContapagarfixa = em.merge(contapagarfixaCollectionContapagarfixa);
            }
            Collection<Pedido> pedidoCollection = centrocusto.getPedidoCollection();
            for (Pedido pedidoCollectionPedido : pedidoCollection) {
                pedidoCollectionPedido.setCodcentrocusto(null);
                pedidoCollectionPedido = em.merge(pedidoCollectionPedido);
            }
            em.remove(centrocusto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Centrocusto> findCentrocustoEntities() {
        return findCentrocustoEntities(true, -1, -1);
    }

    public List<Centrocusto> findCentrocustoEntities(int maxResults, int firstResult) {
        return findCentrocustoEntities(false, maxResults, firstResult);
    }

    private List<Centrocusto> findCentrocustoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Centrocusto.class));
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

    public Centrocusto findCentrocusto(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Centrocusto.class, id);
        } finally {
            em.close();
        }
    }

    public int getCentrocustoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Centrocusto> rt = cq.from(Centrocusto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

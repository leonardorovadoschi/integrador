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
import entidade.cplus.Centrocusto;
import entidade.cplus.Contabancaria;
import entidade.cplus.Planoconta;
import entidade.cplus.Orcamentorec;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Rma;
import entidade.cplus.Movendarec;
import entidade.cplus.Caixausuario;
import entidade.cplus.Conferenciacaixaitem;
import entidade.cplus.Movimentocaixa;
import entidade.cplus.Recebimento;
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
public class RecebimentoJpaController implements Serializable {

    public RecebimentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Recebimento recebimento) throws PreexistingEntityException, Exception {
        if (recebimento.getOrcamentorecCollection() == null) {
            recebimento.setOrcamentorecCollection(new ArrayList<Orcamentorec>());
        }
        if (recebimento.getRmaCollection() == null) {
            recebimento.setRmaCollection(new ArrayList<Rma>());
        }
        if (recebimento.getMovendarecCollection() == null) {
            recebimento.setMovendarecCollection(new ArrayList<Movendarec>());
        }
        if (recebimento.getCaixausuarioCollection() == null) {
            recebimento.setCaixausuarioCollection(new ArrayList<Caixausuario>());
        }
        if (recebimento.getConferenciacaixaitemCollection() == null) {
            recebimento.setConferenciacaixaitemCollection(new ArrayList<Conferenciacaixaitem>());
        }
        if (recebimento.getMovimentocaixaCollection() == null) {
            recebimento.setMovimentocaixaCollection(new ArrayList<Movimentocaixa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Centrocusto codcentrocusto = recebimento.getCodcentrocusto();
            if (codcentrocusto != null) {
                codcentrocusto = em.getReference(codcentrocusto.getClass(), codcentrocusto.getCodcentrocusto());
                recebimento.setCodcentrocusto(codcentrocusto);
            }
            Contabancaria codcontabancaria = recebimento.getCodcontabancaria();
            if (codcontabancaria != null) {
                codcontabancaria = em.getReference(codcontabancaria.getClass(), codcontabancaria.getCodcontabancaria());
                recebimento.setCodcontabancaria(codcontabancaria);
            }
            Planoconta codpc = recebimento.getCodpc();
            if (codpc != null) {
                codpc = em.getReference(codpc.getClass(), codpc.getCodpc());
                recebimento.setCodpc(codpc);
            }
            Collection<Orcamentorec> attachedOrcamentorecCollection = new ArrayList<Orcamentorec>();
            for (Orcamentorec orcamentorecCollectionOrcamentorecToAttach : recebimento.getOrcamentorecCollection()) {
                orcamentorecCollectionOrcamentorecToAttach = em.getReference(orcamentorecCollectionOrcamentorecToAttach.getClass(), orcamentorecCollectionOrcamentorecToAttach.getCodorcamentorec());
                attachedOrcamentorecCollection.add(orcamentorecCollectionOrcamentorecToAttach);
            }
            recebimento.setOrcamentorecCollection(attachedOrcamentorecCollection);
            Collection<Rma> attachedRmaCollection = new ArrayList<Rma>();
            for (Rma rmaCollectionRmaToAttach : recebimento.getRmaCollection()) {
                rmaCollectionRmaToAttach = em.getReference(rmaCollectionRmaToAttach.getClass(), rmaCollectionRmaToAttach.getCodrma());
                attachedRmaCollection.add(rmaCollectionRmaToAttach);
            }
            recebimento.setRmaCollection(attachedRmaCollection);
            Collection<Movendarec> attachedMovendarecCollection = new ArrayList<Movendarec>();
            for (Movendarec movendarecCollectionMovendarecToAttach : recebimento.getMovendarecCollection()) {
                movendarecCollectionMovendarecToAttach = em.getReference(movendarecCollectionMovendarecToAttach.getClass(), movendarecCollectionMovendarecToAttach.getId());
                attachedMovendarecCollection.add(movendarecCollectionMovendarecToAttach);
            }
            recebimento.setMovendarecCollection(attachedMovendarecCollection);
            Collection<Caixausuario> attachedCaixausuarioCollection = new ArrayList<Caixausuario>();
            for (Caixausuario caixausuarioCollectionCaixausuarioToAttach : recebimento.getCaixausuarioCollection()) {
                caixausuarioCollectionCaixausuarioToAttach = em.getReference(caixausuarioCollectionCaixausuarioToAttach.getClass(), caixausuarioCollectionCaixausuarioToAttach.getCodcaixausuario());
                attachedCaixausuarioCollection.add(caixausuarioCollectionCaixausuarioToAttach);
            }
            recebimento.setCaixausuarioCollection(attachedCaixausuarioCollection);
            Collection<Conferenciacaixaitem> attachedConferenciacaixaitemCollection = new ArrayList<Conferenciacaixaitem>();
            for (Conferenciacaixaitem conferenciacaixaitemCollectionConferenciacaixaitemToAttach : recebimento.getConferenciacaixaitemCollection()) {
                conferenciacaixaitemCollectionConferenciacaixaitemToAttach = em.getReference(conferenciacaixaitemCollectionConferenciacaixaitemToAttach.getClass(), conferenciacaixaitemCollectionConferenciacaixaitemToAttach.getCodconferenciacaixaitem());
                attachedConferenciacaixaitemCollection.add(conferenciacaixaitemCollectionConferenciacaixaitemToAttach);
            }
            recebimento.setConferenciacaixaitemCollection(attachedConferenciacaixaitemCollection);
            Collection<Movimentocaixa> attachedMovimentocaixaCollection = new ArrayList<Movimentocaixa>();
            for (Movimentocaixa movimentocaixaCollectionMovimentocaixaToAttach : recebimento.getMovimentocaixaCollection()) {
                movimentocaixaCollectionMovimentocaixaToAttach = em.getReference(movimentocaixaCollectionMovimentocaixaToAttach.getClass(), movimentocaixaCollectionMovimentocaixaToAttach.getCodmovimentocaixa());
                attachedMovimentocaixaCollection.add(movimentocaixaCollectionMovimentocaixaToAttach);
            }
            recebimento.setMovimentocaixaCollection(attachedMovimentocaixaCollection);
            em.persist(recebimento);
            if (codcentrocusto != null) {
                codcentrocusto.getRecebimentoCollection().add(recebimento);
                codcentrocusto = em.merge(codcentrocusto);
            }
            if (codcontabancaria != null) {
                codcontabancaria.getRecebimentoCollection().add(recebimento);
                codcontabancaria = em.merge(codcontabancaria);
            }
            if (codpc != null) {
                codpc.getRecebimentoCollection().add(recebimento);
                codpc = em.merge(codpc);
            }
            for (Orcamentorec orcamentorecCollectionOrcamentorec : recebimento.getOrcamentorecCollection()) {
                Recebimento oldCodrecOfOrcamentorecCollectionOrcamentorec = orcamentorecCollectionOrcamentorec.getCodrec();
                orcamentorecCollectionOrcamentorec.setCodrec(recebimento);
                orcamentorecCollectionOrcamentorec = em.merge(orcamentorecCollectionOrcamentorec);
                if (oldCodrecOfOrcamentorecCollectionOrcamentorec != null) {
                    oldCodrecOfOrcamentorecCollectionOrcamentorec.getOrcamentorecCollection().remove(orcamentorecCollectionOrcamentorec);
                    oldCodrecOfOrcamentorecCollectionOrcamentorec = em.merge(oldCodrecOfOrcamentorecCollectionOrcamentorec);
                }
            }
            for (Rma rmaCollectionRma : recebimento.getRmaCollection()) {
                Recebimento oldCodrecOfRmaCollectionRma = rmaCollectionRma.getCodrec();
                rmaCollectionRma.setCodrec(recebimento);
                rmaCollectionRma = em.merge(rmaCollectionRma);
                if (oldCodrecOfRmaCollectionRma != null) {
                    oldCodrecOfRmaCollectionRma.getRmaCollection().remove(rmaCollectionRma);
                    oldCodrecOfRmaCollectionRma = em.merge(oldCodrecOfRmaCollectionRma);
                }
            }
            for (Movendarec movendarecCollectionMovendarec : recebimento.getMovendarecCollection()) {
                Recebimento oldCodrecOfMovendarecCollectionMovendarec = movendarecCollectionMovendarec.getCodrec();
                movendarecCollectionMovendarec.setCodrec(recebimento);
                movendarecCollectionMovendarec = em.merge(movendarecCollectionMovendarec);
                if (oldCodrecOfMovendarecCollectionMovendarec != null) {
                    oldCodrecOfMovendarecCollectionMovendarec.getMovendarecCollection().remove(movendarecCollectionMovendarec);
                    oldCodrecOfMovendarecCollectionMovendarec = em.merge(oldCodrecOfMovendarecCollectionMovendarec);
                }
            }
            for (Caixausuario caixausuarioCollectionCaixausuario : recebimento.getCaixausuarioCollection()) {
                Recebimento oldCodrecOfCaixausuarioCollectionCaixausuario = caixausuarioCollectionCaixausuario.getCodrec();
                caixausuarioCollectionCaixausuario.setCodrec(recebimento);
                caixausuarioCollectionCaixausuario = em.merge(caixausuarioCollectionCaixausuario);
                if (oldCodrecOfCaixausuarioCollectionCaixausuario != null) {
                    oldCodrecOfCaixausuarioCollectionCaixausuario.getCaixausuarioCollection().remove(caixausuarioCollectionCaixausuario);
                    oldCodrecOfCaixausuarioCollectionCaixausuario = em.merge(oldCodrecOfCaixausuarioCollectionCaixausuario);
                }
            }
            for (Conferenciacaixaitem conferenciacaixaitemCollectionConferenciacaixaitem : recebimento.getConferenciacaixaitemCollection()) {
                Recebimento oldCodrecOfConferenciacaixaitemCollectionConferenciacaixaitem = conferenciacaixaitemCollectionConferenciacaixaitem.getCodrec();
                conferenciacaixaitemCollectionConferenciacaixaitem.setCodrec(recebimento);
                conferenciacaixaitemCollectionConferenciacaixaitem = em.merge(conferenciacaixaitemCollectionConferenciacaixaitem);
                if (oldCodrecOfConferenciacaixaitemCollectionConferenciacaixaitem != null) {
                    oldCodrecOfConferenciacaixaitemCollectionConferenciacaixaitem.getConferenciacaixaitemCollection().remove(conferenciacaixaitemCollectionConferenciacaixaitem);
                    oldCodrecOfConferenciacaixaitemCollectionConferenciacaixaitem = em.merge(oldCodrecOfConferenciacaixaitemCollectionConferenciacaixaitem);
                }
            }
            for (Movimentocaixa movimentocaixaCollectionMovimentocaixa : recebimento.getMovimentocaixaCollection()) {
                Recebimento oldCodrecOfMovimentocaixaCollectionMovimentocaixa = movimentocaixaCollectionMovimentocaixa.getCodrec();
                movimentocaixaCollectionMovimentocaixa.setCodrec(recebimento);
                movimentocaixaCollectionMovimentocaixa = em.merge(movimentocaixaCollectionMovimentocaixa);
                if (oldCodrecOfMovimentocaixaCollectionMovimentocaixa != null) {
                    oldCodrecOfMovimentocaixaCollectionMovimentocaixa.getMovimentocaixaCollection().remove(movimentocaixaCollectionMovimentocaixa);
                    oldCodrecOfMovimentocaixaCollectionMovimentocaixa = em.merge(oldCodrecOfMovimentocaixaCollectionMovimentocaixa);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRecebimento(recebimento.getCodrec()) != null) {
                throw new PreexistingEntityException("Recebimento " + recebimento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Recebimento recebimento) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Recebimento persistentRecebimento = em.find(Recebimento.class, recebimento.getCodrec());
            Centrocusto codcentrocustoOld = persistentRecebimento.getCodcentrocusto();
            Centrocusto codcentrocustoNew = recebimento.getCodcentrocusto();
            Contabancaria codcontabancariaOld = persistentRecebimento.getCodcontabancaria();
            Contabancaria codcontabancariaNew = recebimento.getCodcontabancaria();
            Planoconta codpcOld = persistentRecebimento.getCodpc();
            Planoconta codpcNew = recebimento.getCodpc();
            Collection<Orcamentorec> orcamentorecCollectionOld = persistentRecebimento.getOrcamentorecCollection();
            Collection<Orcamentorec> orcamentorecCollectionNew = recebimento.getOrcamentorecCollection();
            Collection<Rma> rmaCollectionOld = persistentRecebimento.getRmaCollection();
            Collection<Rma> rmaCollectionNew = recebimento.getRmaCollection();
            Collection<Movendarec> movendarecCollectionOld = persistentRecebimento.getMovendarecCollection();
            Collection<Movendarec> movendarecCollectionNew = recebimento.getMovendarecCollection();
            Collection<Caixausuario> caixausuarioCollectionOld = persistentRecebimento.getCaixausuarioCollection();
            Collection<Caixausuario> caixausuarioCollectionNew = recebimento.getCaixausuarioCollection();
            Collection<Conferenciacaixaitem> conferenciacaixaitemCollectionOld = persistentRecebimento.getConferenciacaixaitemCollection();
            Collection<Conferenciacaixaitem> conferenciacaixaitemCollectionNew = recebimento.getConferenciacaixaitemCollection();
            Collection<Movimentocaixa> movimentocaixaCollectionOld = persistentRecebimento.getMovimentocaixaCollection();
            Collection<Movimentocaixa> movimentocaixaCollectionNew = recebimento.getMovimentocaixaCollection();
            List<String> illegalOrphanMessages = null;
            for (Orcamentorec orcamentorecCollectionOldOrcamentorec : orcamentorecCollectionOld) {
                if (!orcamentorecCollectionNew.contains(orcamentorecCollectionOldOrcamentorec)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Orcamentorec " + orcamentorecCollectionOldOrcamentorec + " since its codrec field is not nullable.");
                }
            }
            for (Movendarec movendarecCollectionOldMovendarec : movendarecCollectionOld) {
                if (!movendarecCollectionNew.contains(movendarecCollectionOldMovendarec)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Movendarec " + movendarecCollectionOldMovendarec + " since its codrec field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codcentrocustoNew != null) {
                codcentrocustoNew = em.getReference(codcentrocustoNew.getClass(), codcentrocustoNew.getCodcentrocusto());
                recebimento.setCodcentrocusto(codcentrocustoNew);
            }
            if (codcontabancariaNew != null) {
                codcontabancariaNew = em.getReference(codcontabancariaNew.getClass(), codcontabancariaNew.getCodcontabancaria());
                recebimento.setCodcontabancaria(codcontabancariaNew);
            }
            if (codpcNew != null) {
                codpcNew = em.getReference(codpcNew.getClass(), codpcNew.getCodpc());
                recebimento.setCodpc(codpcNew);
            }
            Collection<Orcamentorec> attachedOrcamentorecCollectionNew = new ArrayList<Orcamentorec>();
            for (Orcamentorec orcamentorecCollectionNewOrcamentorecToAttach : orcamentorecCollectionNew) {
                orcamentorecCollectionNewOrcamentorecToAttach = em.getReference(orcamentorecCollectionNewOrcamentorecToAttach.getClass(), orcamentorecCollectionNewOrcamentorecToAttach.getCodorcamentorec());
                attachedOrcamentorecCollectionNew.add(orcamentorecCollectionNewOrcamentorecToAttach);
            }
            orcamentorecCollectionNew = attachedOrcamentorecCollectionNew;
            recebimento.setOrcamentorecCollection(orcamentorecCollectionNew);
            Collection<Rma> attachedRmaCollectionNew = new ArrayList<Rma>();
            for (Rma rmaCollectionNewRmaToAttach : rmaCollectionNew) {
                rmaCollectionNewRmaToAttach = em.getReference(rmaCollectionNewRmaToAttach.getClass(), rmaCollectionNewRmaToAttach.getCodrma());
                attachedRmaCollectionNew.add(rmaCollectionNewRmaToAttach);
            }
            rmaCollectionNew = attachedRmaCollectionNew;
            recebimento.setRmaCollection(rmaCollectionNew);
            Collection<Movendarec> attachedMovendarecCollectionNew = new ArrayList<Movendarec>();
            for (Movendarec movendarecCollectionNewMovendarecToAttach : movendarecCollectionNew) {
                movendarecCollectionNewMovendarecToAttach = em.getReference(movendarecCollectionNewMovendarecToAttach.getClass(), movendarecCollectionNewMovendarecToAttach.getId());
                attachedMovendarecCollectionNew.add(movendarecCollectionNewMovendarecToAttach);
            }
            movendarecCollectionNew = attachedMovendarecCollectionNew;
            recebimento.setMovendarecCollection(movendarecCollectionNew);
            Collection<Caixausuario> attachedCaixausuarioCollectionNew = new ArrayList<Caixausuario>();
            for (Caixausuario caixausuarioCollectionNewCaixausuarioToAttach : caixausuarioCollectionNew) {
                caixausuarioCollectionNewCaixausuarioToAttach = em.getReference(caixausuarioCollectionNewCaixausuarioToAttach.getClass(), caixausuarioCollectionNewCaixausuarioToAttach.getCodcaixausuario());
                attachedCaixausuarioCollectionNew.add(caixausuarioCollectionNewCaixausuarioToAttach);
            }
            caixausuarioCollectionNew = attachedCaixausuarioCollectionNew;
            recebimento.setCaixausuarioCollection(caixausuarioCollectionNew);
            Collection<Conferenciacaixaitem> attachedConferenciacaixaitemCollectionNew = new ArrayList<Conferenciacaixaitem>();
            for (Conferenciacaixaitem conferenciacaixaitemCollectionNewConferenciacaixaitemToAttach : conferenciacaixaitemCollectionNew) {
                conferenciacaixaitemCollectionNewConferenciacaixaitemToAttach = em.getReference(conferenciacaixaitemCollectionNewConferenciacaixaitemToAttach.getClass(), conferenciacaixaitemCollectionNewConferenciacaixaitemToAttach.getCodconferenciacaixaitem());
                attachedConferenciacaixaitemCollectionNew.add(conferenciacaixaitemCollectionNewConferenciacaixaitemToAttach);
            }
            conferenciacaixaitemCollectionNew = attachedConferenciacaixaitemCollectionNew;
            recebimento.setConferenciacaixaitemCollection(conferenciacaixaitemCollectionNew);
            Collection<Movimentocaixa> attachedMovimentocaixaCollectionNew = new ArrayList<Movimentocaixa>();
            for (Movimentocaixa movimentocaixaCollectionNewMovimentocaixaToAttach : movimentocaixaCollectionNew) {
                movimentocaixaCollectionNewMovimentocaixaToAttach = em.getReference(movimentocaixaCollectionNewMovimentocaixaToAttach.getClass(), movimentocaixaCollectionNewMovimentocaixaToAttach.getCodmovimentocaixa());
                attachedMovimentocaixaCollectionNew.add(movimentocaixaCollectionNewMovimentocaixaToAttach);
            }
            movimentocaixaCollectionNew = attachedMovimentocaixaCollectionNew;
            recebimento.setMovimentocaixaCollection(movimentocaixaCollectionNew);
            recebimento = em.merge(recebimento);
            if (codcentrocustoOld != null && !codcentrocustoOld.equals(codcentrocustoNew)) {
                codcentrocustoOld.getRecebimentoCollection().remove(recebimento);
                codcentrocustoOld = em.merge(codcentrocustoOld);
            }
            if (codcentrocustoNew != null && !codcentrocustoNew.equals(codcentrocustoOld)) {
                codcentrocustoNew.getRecebimentoCollection().add(recebimento);
                codcentrocustoNew = em.merge(codcentrocustoNew);
            }
            if (codcontabancariaOld != null && !codcontabancariaOld.equals(codcontabancariaNew)) {
                codcontabancariaOld.getRecebimentoCollection().remove(recebimento);
                codcontabancariaOld = em.merge(codcontabancariaOld);
            }
            if (codcontabancariaNew != null && !codcontabancariaNew.equals(codcontabancariaOld)) {
                codcontabancariaNew.getRecebimentoCollection().add(recebimento);
                codcontabancariaNew = em.merge(codcontabancariaNew);
            }
            if (codpcOld != null && !codpcOld.equals(codpcNew)) {
                codpcOld.getRecebimentoCollection().remove(recebimento);
                codpcOld = em.merge(codpcOld);
            }
            if (codpcNew != null && !codpcNew.equals(codpcOld)) {
                codpcNew.getRecebimentoCollection().add(recebimento);
                codpcNew = em.merge(codpcNew);
            }
            for (Orcamentorec orcamentorecCollectionNewOrcamentorec : orcamentorecCollectionNew) {
                if (!orcamentorecCollectionOld.contains(orcamentorecCollectionNewOrcamentorec)) {
                    Recebimento oldCodrecOfOrcamentorecCollectionNewOrcamentorec = orcamentorecCollectionNewOrcamentorec.getCodrec();
                    orcamentorecCollectionNewOrcamentorec.setCodrec(recebimento);
                    orcamentorecCollectionNewOrcamentorec = em.merge(orcamentorecCollectionNewOrcamentorec);
                    if (oldCodrecOfOrcamentorecCollectionNewOrcamentorec != null && !oldCodrecOfOrcamentorecCollectionNewOrcamentorec.equals(recebimento)) {
                        oldCodrecOfOrcamentorecCollectionNewOrcamentorec.getOrcamentorecCollection().remove(orcamentorecCollectionNewOrcamentorec);
                        oldCodrecOfOrcamentorecCollectionNewOrcamentorec = em.merge(oldCodrecOfOrcamentorecCollectionNewOrcamentorec);
                    }
                }
            }
            for (Rma rmaCollectionOldRma : rmaCollectionOld) {
                if (!rmaCollectionNew.contains(rmaCollectionOldRma)) {
                    rmaCollectionOldRma.setCodrec(null);
                    rmaCollectionOldRma = em.merge(rmaCollectionOldRma);
                }
            }
            for (Rma rmaCollectionNewRma : rmaCollectionNew) {
                if (!rmaCollectionOld.contains(rmaCollectionNewRma)) {
                    Recebimento oldCodrecOfRmaCollectionNewRma = rmaCollectionNewRma.getCodrec();
                    rmaCollectionNewRma.setCodrec(recebimento);
                    rmaCollectionNewRma = em.merge(rmaCollectionNewRma);
                    if (oldCodrecOfRmaCollectionNewRma != null && !oldCodrecOfRmaCollectionNewRma.equals(recebimento)) {
                        oldCodrecOfRmaCollectionNewRma.getRmaCollection().remove(rmaCollectionNewRma);
                        oldCodrecOfRmaCollectionNewRma = em.merge(oldCodrecOfRmaCollectionNewRma);
                    }
                }
            }
            for (Movendarec movendarecCollectionNewMovendarec : movendarecCollectionNew) {
                if (!movendarecCollectionOld.contains(movendarecCollectionNewMovendarec)) {
                    Recebimento oldCodrecOfMovendarecCollectionNewMovendarec = movendarecCollectionNewMovendarec.getCodrec();
                    movendarecCollectionNewMovendarec.setCodrec(recebimento);
                    movendarecCollectionNewMovendarec = em.merge(movendarecCollectionNewMovendarec);
                    if (oldCodrecOfMovendarecCollectionNewMovendarec != null && !oldCodrecOfMovendarecCollectionNewMovendarec.equals(recebimento)) {
                        oldCodrecOfMovendarecCollectionNewMovendarec.getMovendarecCollection().remove(movendarecCollectionNewMovendarec);
                        oldCodrecOfMovendarecCollectionNewMovendarec = em.merge(oldCodrecOfMovendarecCollectionNewMovendarec);
                    }
                }
            }
            for (Caixausuario caixausuarioCollectionOldCaixausuario : caixausuarioCollectionOld) {
                if (!caixausuarioCollectionNew.contains(caixausuarioCollectionOldCaixausuario)) {
                    caixausuarioCollectionOldCaixausuario.setCodrec(null);
                    caixausuarioCollectionOldCaixausuario = em.merge(caixausuarioCollectionOldCaixausuario);
                }
            }
            for (Caixausuario caixausuarioCollectionNewCaixausuario : caixausuarioCollectionNew) {
                if (!caixausuarioCollectionOld.contains(caixausuarioCollectionNewCaixausuario)) {
                    Recebimento oldCodrecOfCaixausuarioCollectionNewCaixausuario = caixausuarioCollectionNewCaixausuario.getCodrec();
                    caixausuarioCollectionNewCaixausuario.setCodrec(recebimento);
                    caixausuarioCollectionNewCaixausuario = em.merge(caixausuarioCollectionNewCaixausuario);
                    if (oldCodrecOfCaixausuarioCollectionNewCaixausuario != null && !oldCodrecOfCaixausuarioCollectionNewCaixausuario.equals(recebimento)) {
                        oldCodrecOfCaixausuarioCollectionNewCaixausuario.getCaixausuarioCollection().remove(caixausuarioCollectionNewCaixausuario);
                        oldCodrecOfCaixausuarioCollectionNewCaixausuario = em.merge(oldCodrecOfCaixausuarioCollectionNewCaixausuario);
                    }
                }
            }
            for (Conferenciacaixaitem conferenciacaixaitemCollectionOldConferenciacaixaitem : conferenciacaixaitemCollectionOld) {
                if (!conferenciacaixaitemCollectionNew.contains(conferenciacaixaitemCollectionOldConferenciacaixaitem)) {
                    conferenciacaixaitemCollectionOldConferenciacaixaitem.setCodrec(null);
                    conferenciacaixaitemCollectionOldConferenciacaixaitem = em.merge(conferenciacaixaitemCollectionOldConferenciacaixaitem);
                }
            }
            for (Conferenciacaixaitem conferenciacaixaitemCollectionNewConferenciacaixaitem : conferenciacaixaitemCollectionNew) {
                if (!conferenciacaixaitemCollectionOld.contains(conferenciacaixaitemCollectionNewConferenciacaixaitem)) {
                    Recebimento oldCodrecOfConferenciacaixaitemCollectionNewConferenciacaixaitem = conferenciacaixaitemCollectionNewConferenciacaixaitem.getCodrec();
                    conferenciacaixaitemCollectionNewConferenciacaixaitem.setCodrec(recebimento);
                    conferenciacaixaitemCollectionNewConferenciacaixaitem = em.merge(conferenciacaixaitemCollectionNewConferenciacaixaitem);
                    if (oldCodrecOfConferenciacaixaitemCollectionNewConferenciacaixaitem != null && !oldCodrecOfConferenciacaixaitemCollectionNewConferenciacaixaitem.equals(recebimento)) {
                        oldCodrecOfConferenciacaixaitemCollectionNewConferenciacaixaitem.getConferenciacaixaitemCollection().remove(conferenciacaixaitemCollectionNewConferenciacaixaitem);
                        oldCodrecOfConferenciacaixaitemCollectionNewConferenciacaixaitem = em.merge(oldCodrecOfConferenciacaixaitemCollectionNewConferenciacaixaitem);
                    }
                }
            }
            for (Movimentocaixa movimentocaixaCollectionOldMovimentocaixa : movimentocaixaCollectionOld) {
                if (!movimentocaixaCollectionNew.contains(movimentocaixaCollectionOldMovimentocaixa)) {
                    movimentocaixaCollectionOldMovimentocaixa.setCodrec(null);
                    movimentocaixaCollectionOldMovimentocaixa = em.merge(movimentocaixaCollectionOldMovimentocaixa);
                }
            }
            for (Movimentocaixa movimentocaixaCollectionNewMovimentocaixa : movimentocaixaCollectionNew) {
                if (!movimentocaixaCollectionOld.contains(movimentocaixaCollectionNewMovimentocaixa)) {
                    Recebimento oldCodrecOfMovimentocaixaCollectionNewMovimentocaixa = movimentocaixaCollectionNewMovimentocaixa.getCodrec();
                    movimentocaixaCollectionNewMovimentocaixa.setCodrec(recebimento);
                    movimentocaixaCollectionNewMovimentocaixa = em.merge(movimentocaixaCollectionNewMovimentocaixa);
                    if (oldCodrecOfMovimentocaixaCollectionNewMovimentocaixa != null && !oldCodrecOfMovimentocaixaCollectionNewMovimentocaixa.equals(recebimento)) {
                        oldCodrecOfMovimentocaixaCollectionNewMovimentocaixa.getMovimentocaixaCollection().remove(movimentocaixaCollectionNewMovimentocaixa);
                        oldCodrecOfMovimentocaixaCollectionNewMovimentocaixa = em.merge(oldCodrecOfMovimentocaixaCollectionNewMovimentocaixa);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = recebimento.getCodrec();
                if (findRecebimento(id) == null) {
                    throw new NonexistentEntityException("The recebimento with id " + id + " no longer exists.");
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
            Recebimento recebimento;
            try {
                recebimento = em.getReference(Recebimento.class, id);
                recebimento.getCodrec();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The recebimento with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Orcamentorec> orcamentorecCollectionOrphanCheck = recebimento.getOrcamentorecCollection();
            for (Orcamentorec orcamentorecCollectionOrphanCheckOrcamentorec : orcamentorecCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Recebimento (" + recebimento + ") cannot be destroyed since the Orcamentorec " + orcamentorecCollectionOrphanCheckOrcamentorec + " in its orcamentorecCollection field has a non-nullable codrec field.");
            }
            Collection<Movendarec> movendarecCollectionOrphanCheck = recebimento.getMovendarecCollection();
            for (Movendarec movendarecCollectionOrphanCheckMovendarec : movendarecCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Recebimento (" + recebimento + ") cannot be destroyed since the Movendarec " + movendarecCollectionOrphanCheckMovendarec + " in its movendarecCollection field has a non-nullable codrec field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Centrocusto codcentrocusto = recebimento.getCodcentrocusto();
            if (codcentrocusto != null) {
                codcentrocusto.getRecebimentoCollection().remove(recebimento);
                codcentrocusto = em.merge(codcentrocusto);
            }
            Contabancaria codcontabancaria = recebimento.getCodcontabancaria();
            if (codcontabancaria != null) {
                codcontabancaria.getRecebimentoCollection().remove(recebimento);
                codcontabancaria = em.merge(codcontabancaria);
            }
            Planoconta codpc = recebimento.getCodpc();
            if (codpc != null) {
                codpc.getRecebimentoCollection().remove(recebimento);
                codpc = em.merge(codpc);
            }
            Collection<Rma> rmaCollection = recebimento.getRmaCollection();
            for (Rma rmaCollectionRma : rmaCollection) {
                rmaCollectionRma.setCodrec(null);
                rmaCollectionRma = em.merge(rmaCollectionRma);
            }
            Collection<Caixausuario> caixausuarioCollection = recebimento.getCaixausuarioCollection();
            for (Caixausuario caixausuarioCollectionCaixausuario : caixausuarioCollection) {
                caixausuarioCollectionCaixausuario.setCodrec(null);
                caixausuarioCollectionCaixausuario = em.merge(caixausuarioCollectionCaixausuario);
            }
            Collection<Conferenciacaixaitem> conferenciacaixaitemCollection = recebimento.getConferenciacaixaitemCollection();
            for (Conferenciacaixaitem conferenciacaixaitemCollectionConferenciacaixaitem : conferenciacaixaitemCollection) {
                conferenciacaixaitemCollectionConferenciacaixaitem.setCodrec(null);
                conferenciacaixaitemCollectionConferenciacaixaitem = em.merge(conferenciacaixaitemCollectionConferenciacaixaitem);
            }
            Collection<Movimentocaixa> movimentocaixaCollection = recebimento.getMovimentocaixaCollection();
            for (Movimentocaixa movimentocaixaCollectionMovimentocaixa : movimentocaixaCollection) {
                movimentocaixaCollectionMovimentocaixa.setCodrec(null);
                movimentocaixaCollectionMovimentocaixa = em.merge(movimentocaixaCollectionMovimentocaixa);
            }
            em.remove(recebimento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Recebimento> findRecebimentoEntities() {
        return findRecebimentoEntities(true, -1, -1);
    }

    public List<Recebimento> findRecebimentoEntities(int maxResults, int firstResult) {
        return findRecebimentoEntities(false, maxResults, firstResult);
    }

    private List<Recebimento> findRecebimentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Recebimento.class));
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

    public Recebimento findRecebimento(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Recebimento.class, id);
        } finally {
            em.close();
        }
    }

    public int getRecebimentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Recebimento> rt = cq.from(Recebimento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

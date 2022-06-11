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
import entidade.cplus.Alinea;
import entidade.cplus.Caixa;
import entidade.cplus.Caixas;
import entidade.cplus.Centrocusto;
import entidade.cplus.Cheques;
import entidade.cplus.Cliente;
import entidade.cplus.Empresa;
import entidade.cplus.Fornecedor;
import entidade.cplus.Planoconta;
import entidade.cplus.Vendedor;
import entidade.cplus.Chequeshistorico;
import java.util.ArrayList;
import java.util.Collection;
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
public class ChequesJpaController implements Serializable {

    public ChequesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cheques cheques) throws PreexistingEntityException, Exception {
        if (cheques.getChequeshistoricoCollection() == null) {
            cheques.setChequeshistoricoCollection(new ArrayList<Chequeshistorico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Alinea codalinea = cheques.getCodalinea();
            if (codalinea != null) {
                codalinea = em.getReference(codalinea.getClass(), codalinea.getCodalinea());
                cheques.setCodalinea(codalinea);
            }
            Caixa codcaixa = cheques.getCodcaixa();
            if (codcaixa != null) {
                codcaixa = em.getReference(codcaixa.getClass(), codcaixa.getCodcaixa());
                cheques.setCodcaixa(codcaixa);
            }
            Caixas codcaixas = cheques.getCodcaixas();
            if (codcaixas != null) {
                codcaixas = em.getReference(codcaixas.getClass(), codcaixas.getCodcaixas());
                cheques.setCodcaixas(codcaixas);
            }
            Centrocusto codcentrocusto = cheques.getCodcentrocusto();
            if (codcentrocusto != null) {
                codcentrocusto = em.getReference(codcentrocusto.getClass(), codcentrocusto.getCodcentrocusto());
                cheques.setCodcentrocusto(codcentrocusto);
            }
            Cliente codcli = cheques.getCodcli();
            if (codcli != null) {
                codcli = em.getReference(codcli.getClass(), codcli.getCodcli());
                cheques.setCodcli(codcli);
            }
            Empresa codempresa = cheques.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                cheques.setCodempresa(codempresa);
            }
            Fornecedor codforn = cheques.getCodforn();
            if (codforn != null) {
                codforn = em.getReference(codforn.getClass(), codforn.getCodforn());
                cheques.setCodforn(codforn);
            }
            Planoconta codpc = cheques.getCodpc();
            if (codpc != null) {
                codpc = em.getReference(codpc.getClass(), codpc.getCodpc());
                cheques.setCodpc(codpc);
            }
            Vendedor codvendedrenegociacao = cheques.getCodvendedrenegociacao();
            if (codvendedrenegociacao != null) {
                codvendedrenegociacao = em.getReference(codvendedrenegociacao.getClass(), codvendedrenegociacao.getCodvended());
                cheques.setCodvendedrenegociacao(codvendedrenegociacao);
            }
            Collection<Chequeshistorico> attachedChequeshistoricoCollection = new ArrayList<Chequeshistorico>();
            for (Chequeshistorico chequeshistoricoCollectionChequeshistoricoToAttach : cheques.getChequeshistoricoCollection()) {
                chequeshistoricoCollectionChequeshistoricoToAttach = em.getReference(chequeshistoricoCollectionChequeshistoricoToAttach.getClass(), chequeshistoricoCollectionChequeshistoricoToAttach.getCodchequeshistorico());
                attachedChequeshistoricoCollection.add(chequeshistoricoCollectionChequeshistoricoToAttach);
            }
            cheques.setChequeshistoricoCollection(attachedChequeshistoricoCollection);
            em.persist(cheques);
            if (codalinea != null) {
                codalinea.getChequesCollection().add(cheques);
                codalinea = em.merge(codalinea);
            }
            if (codcaixa != null) {
                codcaixa.getChequesCollection().add(cheques);
                codcaixa = em.merge(codcaixa);
            }
            if (codcaixas != null) {
                codcaixas.getChequesCollection().add(cheques);
                codcaixas = em.merge(codcaixas);
            }
            if (codcentrocusto != null) {
                codcentrocusto.getChequesCollection().add(cheques);
                codcentrocusto = em.merge(codcentrocusto);
            }
            if (codcli != null) {
                codcli.getChequesCollection().add(cheques);
                codcli = em.merge(codcli);
            }
            if (codempresa != null) {
                codempresa.getChequesCollection().add(cheques);
                codempresa = em.merge(codempresa);
            }
            if (codforn != null) {
                codforn.getChequesCollection().add(cheques);
                codforn = em.merge(codforn);
            }
            if (codpc != null) {
                codpc.getChequesCollection().add(cheques);
                codpc = em.merge(codpc);
            }
            if (codvendedrenegociacao != null) {
                codvendedrenegociacao.getChequesCollection().add(cheques);
                codvendedrenegociacao = em.merge(codvendedrenegociacao);
            }
            for (Chequeshistorico chequeshistoricoCollectionChequeshistorico : cheques.getChequeshistoricoCollection()) {
                Cheques oldCodchequeOfChequeshistoricoCollectionChequeshistorico = chequeshistoricoCollectionChequeshistorico.getCodcheque();
                chequeshistoricoCollectionChequeshistorico.setCodcheque(cheques);
                chequeshistoricoCollectionChequeshistorico = em.merge(chequeshistoricoCollectionChequeshistorico);
                if (oldCodchequeOfChequeshistoricoCollectionChequeshistorico != null) {
                    oldCodchequeOfChequeshistoricoCollectionChequeshistorico.getChequeshistoricoCollection().remove(chequeshistoricoCollectionChequeshistorico);
                    oldCodchequeOfChequeshistoricoCollectionChequeshistorico = em.merge(oldCodchequeOfChequeshistoricoCollectionChequeshistorico);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCheques(cheques.getCodcheque()) != null) {
                throw new PreexistingEntityException("Cheques " + cheques + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cheques cheques) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cheques persistentCheques = em.find(Cheques.class, cheques.getCodcheque());
            Alinea codalineaOld = persistentCheques.getCodalinea();
            Alinea codalineaNew = cheques.getCodalinea();
            Caixa codcaixaOld = persistentCheques.getCodcaixa();
            Caixa codcaixaNew = cheques.getCodcaixa();
            Caixas codcaixasOld = persistentCheques.getCodcaixas();
            Caixas codcaixasNew = cheques.getCodcaixas();
            Centrocusto codcentrocustoOld = persistentCheques.getCodcentrocusto();
            Centrocusto codcentrocustoNew = cheques.getCodcentrocusto();
            Cliente codcliOld = persistentCheques.getCodcli();
            Cliente codcliNew = cheques.getCodcli();
            Empresa codempresaOld = persistentCheques.getCodempresa();
            Empresa codempresaNew = cheques.getCodempresa();
            Fornecedor codfornOld = persistentCheques.getCodforn();
            Fornecedor codfornNew = cheques.getCodforn();
            Planoconta codpcOld = persistentCheques.getCodpc();
            Planoconta codpcNew = cheques.getCodpc();
            Vendedor codvendedrenegociacaoOld = persistentCheques.getCodvendedrenegociacao();
            Vendedor codvendedrenegociacaoNew = cheques.getCodvendedrenegociacao();
            Collection<Chequeshistorico> chequeshistoricoCollectionOld = persistentCheques.getChequeshistoricoCollection();
            Collection<Chequeshistorico> chequeshistoricoCollectionNew = cheques.getChequeshistoricoCollection();
            List<String> illegalOrphanMessages = null;
            for (Chequeshistorico chequeshistoricoCollectionOldChequeshistorico : chequeshistoricoCollectionOld) {
                if (!chequeshistoricoCollectionNew.contains(chequeshistoricoCollectionOldChequeshistorico)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Chequeshistorico " + chequeshistoricoCollectionOldChequeshistorico + " since its codcheque field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codalineaNew != null) {
                codalineaNew = em.getReference(codalineaNew.getClass(), codalineaNew.getCodalinea());
                cheques.setCodalinea(codalineaNew);
            }
            if (codcaixaNew != null) {
                codcaixaNew = em.getReference(codcaixaNew.getClass(), codcaixaNew.getCodcaixa());
                cheques.setCodcaixa(codcaixaNew);
            }
            if (codcaixasNew != null) {
                codcaixasNew = em.getReference(codcaixasNew.getClass(), codcaixasNew.getCodcaixas());
                cheques.setCodcaixas(codcaixasNew);
            }
            if (codcentrocustoNew != null) {
                codcentrocustoNew = em.getReference(codcentrocustoNew.getClass(), codcentrocustoNew.getCodcentrocusto());
                cheques.setCodcentrocusto(codcentrocustoNew);
            }
            if (codcliNew != null) {
                codcliNew = em.getReference(codcliNew.getClass(), codcliNew.getCodcli());
                cheques.setCodcli(codcliNew);
            }
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                cheques.setCodempresa(codempresaNew);
            }
            if (codfornNew != null) {
                codfornNew = em.getReference(codfornNew.getClass(), codfornNew.getCodforn());
                cheques.setCodforn(codfornNew);
            }
            if (codpcNew != null) {
                codpcNew = em.getReference(codpcNew.getClass(), codpcNew.getCodpc());
                cheques.setCodpc(codpcNew);
            }
            if (codvendedrenegociacaoNew != null) {
                codvendedrenegociacaoNew = em.getReference(codvendedrenegociacaoNew.getClass(), codvendedrenegociacaoNew.getCodvended());
                cheques.setCodvendedrenegociacao(codvendedrenegociacaoNew);
            }
            Collection<Chequeshistorico> attachedChequeshistoricoCollectionNew = new ArrayList<Chequeshistorico>();
            for (Chequeshistorico chequeshistoricoCollectionNewChequeshistoricoToAttach : chequeshistoricoCollectionNew) {
                chequeshistoricoCollectionNewChequeshistoricoToAttach = em.getReference(chequeshistoricoCollectionNewChequeshistoricoToAttach.getClass(), chequeshistoricoCollectionNewChequeshistoricoToAttach.getCodchequeshistorico());
                attachedChequeshistoricoCollectionNew.add(chequeshistoricoCollectionNewChequeshistoricoToAttach);
            }
            chequeshistoricoCollectionNew = attachedChequeshistoricoCollectionNew;
            cheques.setChequeshistoricoCollection(chequeshistoricoCollectionNew);
            cheques = em.merge(cheques);
            if (codalineaOld != null && !codalineaOld.equals(codalineaNew)) {
                codalineaOld.getChequesCollection().remove(cheques);
                codalineaOld = em.merge(codalineaOld);
            }
            if (codalineaNew != null && !codalineaNew.equals(codalineaOld)) {
                codalineaNew.getChequesCollection().add(cheques);
                codalineaNew = em.merge(codalineaNew);
            }
            if (codcaixaOld != null && !codcaixaOld.equals(codcaixaNew)) {
                codcaixaOld.getChequesCollection().remove(cheques);
                codcaixaOld = em.merge(codcaixaOld);
            }
            if (codcaixaNew != null && !codcaixaNew.equals(codcaixaOld)) {
                codcaixaNew.getChequesCollection().add(cheques);
                codcaixaNew = em.merge(codcaixaNew);
            }
            if (codcaixasOld != null && !codcaixasOld.equals(codcaixasNew)) {
                codcaixasOld.getChequesCollection().remove(cheques);
                codcaixasOld = em.merge(codcaixasOld);
            }
            if (codcaixasNew != null && !codcaixasNew.equals(codcaixasOld)) {
                codcaixasNew.getChequesCollection().add(cheques);
                codcaixasNew = em.merge(codcaixasNew);
            }
            if (codcentrocustoOld != null && !codcentrocustoOld.equals(codcentrocustoNew)) {
                codcentrocustoOld.getChequesCollection().remove(cheques);
                codcentrocustoOld = em.merge(codcentrocustoOld);
            }
            if (codcentrocustoNew != null && !codcentrocustoNew.equals(codcentrocustoOld)) {
                codcentrocustoNew.getChequesCollection().add(cheques);
                codcentrocustoNew = em.merge(codcentrocustoNew);
            }
            if (codcliOld != null && !codcliOld.equals(codcliNew)) {
                codcliOld.getChequesCollection().remove(cheques);
                codcliOld = em.merge(codcliOld);
            }
            if (codcliNew != null && !codcliNew.equals(codcliOld)) {
                codcliNew.getChequesCollection().add(cheques);
                codcliNew = em.merge(codcliNew);
            }
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getChequesCollection().remove(cheques);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getChequesCollection().add(cheques);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codfornOld != null && !codfornOld.equals(codfornNew)) {
                codfornOld.getChequesCollection().remove(cheques);
                codfornOld = em.merge(codfornOld);
            }
            if (codfornNew != null && !codfornNew.equals(codfornOld)) {
                codfornNew.getChequesCollection().add(cheques);
                codfornNew = em.merge(codfornNew);
            }
            if (codpcOld != null && !codpcOld.equals(codpcNew)) {
                codpcOld.getChequesCollection().remove(cheques);
                codpcOld = em.merge(codpcOld);
            }
            if (codpcNew != null && !codpcNew.equals(codpcOld)) {
                codpcNew.getChequesCollection().add(cheques);
                codpcNew = em.merge(codpcNew);
            }
            if (codvendedrenegociacaoOld != null && !codvendedrenegociacaoOld.equals(codvendedrenegociacaoNew)) {
                codvendedrenegociacaoOld.getChequesCollection().remove(cheques);
                codvendedrenegociacaoOld = em.merge(codvendedrenegociacaoOld);
            }
            if (codvendedrenegociacaoNew != null && !codvendedrenegociacaoNew.equals(codvendedrenegociacaoOld)) {
                codvendedrenegociacaoNew.getChequesCollection().add(cheques);
                codvendedrenegociacaoNew = em.merge(codvendedrenegociacaoNew);
            }
            for (Chequeshistorico chequeshistoricoCollectionNewChequeshistorico : chequeshistoricoCollectionNew) {
                if (!chequeshistoricoCollectionOld.contains(chequeshistoricoCollectionNewChequeshistorico)) {
                    Cheques oldCodchequeOfChequeshistoricoCollectionNewChequeshistorico = chequeshistoricoCollectionNewChequeshistorico.getCodcheque();
                    chequeshistoricoCollectionNewChequeshistorico.setCodcheque(cheques);
                    chequeshistoricoCollectionNewChequeshistorico = em.merge(chequeshistoricoCollectionNewChequeshistorico);
                    if (oldCodchequeOfChequeshistoricoCollectionNewChequeshistorico != null && !oldCodchequeOfChequeshistoricoCollectionNewChequeshistorico.equals(cheques)) {
                        oldCodchequeOfChequeshistoricoCollectionNewChequeshistorico.getChequeshistoricoCollection().remove(chequeshistoricoCollectionNewChequeshistorico);
                        oldCodchequeOfChequeshistoricoCollectionNewChequeshistorico = em.merge(oldCodchequeOfChequeshistoricoCollectionNewChequeshistorico);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cheques.getCodcheque();
                if (findCheques(id) == null) {
                    throw new NonexistentEntityException("The cheques with id " + id + " no longer exists.");
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
            Cheques cheques;
            try {
                cheques = em.getReference(Cheques.class, id);
                cheques.getCodcheque();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cheques with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Chequeshistorico> chequeshistoricoCollectionOrphanCheck = cheques.getChequeshistoricoCollection();
            for (Chequeshistorico chequeshistoricoCollectionOrphanCheckChequeshistorico : chequeshistoricoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cheques (" + cheques + ") cannot be destroyed since the Chequeshistorico " + chequeshistoricoCollectionOrphanCheckChequeshistorico + " in its chequeshistoricoCollection field has a non-nullable codcheque field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Alinea codalinea = cheques.getCodalinea();
            if (codalinea != null) {
                codalinea.getChequesCollection().remove(cheques);
                codalinea = em.merge(codalinea);
            }
            Caixa codcaixa = cheques.getCodcaixa();
            if (codcaixa != null) {
                codcaixa.getChequesCollection().remove(cheques);
                codcaixa = em.merge(codcaixa);
            }
            Caixas codcaixas = cheques.getCodcaixas();
            if (codcaixas != null) {
                codcaixas.getChequesCollection().remove(cheques);
                codcaixas = em.merge(codcaixas);
            }
            Centrocusto codcentrocusto = cheques.getCodcentrocusto();
            if (codcentrocusto != null) {
                codcentrocusto.getChequesCollection().remove(cheques);
                codcentrocusto = em.merge(codcentrocusto);
            }
            Cliente codcli = cheques.getCodcli();
            if (codcli != null) {
                codcli.getChequesCollection().remove(cheques);
                codcli = em.merge(codcli);
            }
            Empresa codempresa = cheques.getCodempresa();
            if (codempresa != null) {
                codempresa.getChequesCollection().remove(cheques);
                codempresa = em.merge(codempresa);
            }
            Fornecedor codforn = cheques.getCodforn();
            if (codforn != null) {
                codforn.getChequesCollection().remove(cheques);
                codforn = em.merge(codforn);
            }
            Planoconta codpc = cheques.getCodpc();
            if (codpc != null) {
                codpc.getChequesCollection().remove(cheques);
                codpc = em.merge(codpc);
            }
            Vendedor codvendedrenegociacao = cheques.getCodvendedrenegociacao();
            if (codvendedrenegociacao != null) {
                codvendedrenegociacao.getChequesCollection().remove(cheques);
                codvendedrenegociacao = em.merge(codvendedrenegociacao);
            }
            em.remove(cheques);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cheques> findChequesEntities() {
        return findChequesEntities(true, -1, -1);
    }

    public List<Cheques> findChequesEntities(int maxResults, int firstResult) {
        return findChequesEntities(false, maxResults, firstResult);
    }

    private List<Cheques> findChequesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cheques.class));
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

    public Cheques findCheques(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cheques.class, id);
        } finally {
            em.close();
        }
    }

    public int getChequesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cheques> rt = cq.from(Cheques.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
import entidade.cplus.Empresa;
import entidade.cplus.Transportadora;
import entidade.cplus.Uf;
import entidade.cplus.Mdfeletronicoveiculo;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Orcamento;
import entidade.cplus.Movenda;
import entidade.cplus.Loteentrega;
import entidade.cplus.Veiculos;
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
public class VeiculosJpaController implements Serializable {

    public VeiculosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Veiculos veiculos) throws PreexistingEntityException, Exception {
        if (veiculos.getMdfeletronicoveiculoCollection() == null) {
            veiculos.setMdfeletronicoveiculoCollection(new ArrayList<Mdfeletronicoveiculo>());
        }
        if (veiculos.getOrcamentoCollection() == null) {
            veiculos.setOrcamentoCollection(new ArrayList<Orcamento>());
        }
        if (veiculos.getMovendaCollection() == null) {
            veiculos.setMovendaCollection(new ArrayList<Movenda>());
        }
        if (veiculos.getLoteentregaCollection() == null) {
            veiculos.setLoteentregaCollection(new ArrayList<Loteentrega>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa codempresa = veiculos.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                veiculos.setCodempresa(codempresa);
            }
            Transportadora codtrans = veiculos.getCodtrans();
            if (codtrans != null) {
                codtrans = em.getReference(codtrans.getClass(), codtrans.getCodtrans());
                veiculos.setCodtrans(codtrans);
            }
            Uf coduf = veiculos.getCoduf();
            if (coduf != null) {
                coduf = em.getReference(coduf.getClass(), coduf.getCoduf());
                veiculos.setCoduf(coduf);
            }
            Collection<Mdfeletronicoveiculo> attachedMdfeletronicoveiculoCollection = new ArrayList<Mdfeletronicoveiculo>();
            for (Mdfeletronicoveiculo mdfeletronicoveiculoCollectionMdfeletronicoveiculoToAttach : veiculos.getMdfeletronicoveiculoCollection()) {
                mdfeletronicoveiculoCollectionMdfeletronicoveiculoToAttach = em.getReference(mdfeletronicoveiculoCollectionMdfeletronicoveiculoToAttach.getClass(), mdfeletronicoveiculoCollectionMdfeletronicoveiculoToAttach.getCodmdfeletronicoveiculo());
                attachedMdfeletronicoveiculoCollection.add(mdfeletronicoveiculoCollectionMdfeletronicoveiculoToAttach);
            }
            veiculos.setMdfeletronicoveiculoCollection(attachedMdfeletronicoveiculoCollection);
            Collection<Orcamento> attachedOrcamentoCollection = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollectionOrcamentoToAttach : veiculos.getOrcamentoCollection()) {
                orcamentoCollectionOrcamentoToAttach = em.getReference(orcamentoCollectionOrcamentoToAttach.getClass(), orcamentoCollectionOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollection.add(orcamentoCollectionOrcamentoToAttach);
            }
            veiculos.setOrcamentoCollection(attachedOrcamentoCollection);
            Collection<Movenda> attachedMovendaCollection = new ArrayList<Movenda>();
            for (Movenda movendaCollectionMovendaToAttach : veiculos.getMovendaCollection()) {
                movendaCollectionMovendaToAttach = em.getReference(movendaCollectionMovendaToAttach.getClass(), movendaCollectionMovendaToAttach.getCodmovenda());
                attachedMovendaCollection.add(movendaCollectionMovendaToAttach);
            }
            veiculos.setMovendaCollection(attachedMovendaCollection);
            Collection<Loteentrega> attachedLoteentregaCollection = new ArrayList<Loteentrega>();
            for (Loteentrega loteentregaCollectionLoteentregaToAttach : veiculos.getLoteentregaCollection()) {
                loteentregaCollectionLoteentregaToAttach = em.getReference(loteentregaCollectionLoteentregaToAttach.getClass(), loteentregaCollectionLoteentregaToAttach.getCodloteentrega());
                attachedLoteentregaCollection.add(loteentregaCollectionLoteentregaToAttach);
            }
            veiculos.setLoteentregaCollection(attachedLoteentregaCollection);
            em.persist(veiculos);
            if (codempresa != null) {
                codempresa.getVeiculosCollection().add(veiculos);
                codempresa = em.merge(codempresa);
            }
            if (codtrans != null) {
                codtrans.getVeiculosCollection().add(veiculos);
                codtrans = em.merge(codtrans);
            }
            if (coduf != null) {
                coduf.getVeiculosCollection().add(veiculos);
                coduf = em.merge(coduf);
            }
            for (Mdfeletronicoveiculo mdfeletronicoveiculoCollectionMdfeletronicoveiculo : veiculos.getMdfeletronicoveiculoCollection()) {
                Veiculos oldCodveiculoOfMdfeletronicoveiculoCollectionMdfeletronicoveiculo = mdfeletronicoveiculoCollectionMdfeletronicoveiculo.getCodveiculo();
                mdfeletronicoveiculoCollectionMdfeletronicoveiculo.setCodveiculo(veiculos);
                mdfeletronicoveiculoCollectionMdfeletronicoveiculo = em.merge(mdfeletronicoveiculoCollectionMdfeletronicoveiculo);
                if (oldCodveiculoOfMdfeletronicoveiculoCollectionMdfeletronicoveiculo != null) {
                    oldCodveiculoOfMdfeletronicoveiculoCollectionMdfeletronicoveiculo.getMdfeletronicoveiculoCollection().remove(mdfeletronicoveiculoCollectionMdfeletronicoveiculo);
                    oldCodveiculoOfMdfeletronicoveiculoCollectionMdfeletronicoveiculo = em.merge(oldCodveiculoOfMdfeletronicoveiculoCollectionMdfeletronicoveiculo);
                }
            }
            for (Orcamento orcamentoCollectionOrcamento : veiculos.getOrcamentoCollection()) {
                Veiculos oldCodveiculoOfOrcamentoCollectionOrcamento = orcamentoCollectionOrcamento.getCodveiculo();
                orcamentoCollectionOrcamento.setCodveiculo(veiculos);
                orcamentoCollectionOrcamento = em.merge(orcamentoCollectionOrcamento);
                if (oldCodveiculoOfOrcamentoCollectionOrcamento != null) {
                    oldCodveiculoOfOrcamentoCollectionOrcamento.getOrcamentoCollection().remove(orcamentoCollectionOrcamento);
                    oldCodveiculoOfOrcamentoCollectionOrcamento = em.merge(oldCodveiculoOfOrcamentoCollectionOrcamento);
                }
            }
            for (Movenda movendaCollectionMovenda : veiculos.getMovendaCollection()) {
                Veiculos oldCodveiculoOfMovendaCollectionMovenda = movendaCollectionMovenda.getCodveiculo();
                movendaCollectionMovenda.setCodveiculo(veiculos);
                movendaCollectionMovenda = em.merge(movendaCollectionMovenda);
                if (oldCodveiculoOfMovendaCollectionMovenda != null) {
                    oldCodveiculoOfMovendaCollectionMovenda.getMovendaCollection().remove(movendaCollectionMovenda);
                    oldCodveiculoOfMovendaCollectionMovenda = em.merge(oldCodveiculoOfMovendaCollectionMovenda);
                }
            }
            for (Loteentrega loteentregaCollectionLoteentrega : veiculos.getLoteentregaCollection()) {
                Veiculos oldCodveiculoOfLoteentregaCollectionLoteentrega = loteentregaCollectionLoteentrega.getCodveiculo();
                loteentregaCollectionLoteentrega.setCodveiculo(veiculos);
                loteentregaCollectionLoteentrega = em.merge(loteentregaCollectionLoteentrega);
                if (oldCodveiculoOfLoteentregaCollectionLoteentrega != null) {
                    oldCodveiculoOfLoteentregaCollectionLoteentrega.getLoteentregaCollection().remove(loteentregaCollectionLoteentrega);
                    oldCodveiculoOfLoteentregaCollectionLoteentrega = em.merge(oldCodveiculoOfLoteentregaCollectionLoteentrega);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVeiculos(veiculos.getCodveiculo()) != null) {
                throw new PreexistingEntityException("Veiculos " + veiculos + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Veiculos veiculos) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Veiculos persistentVeiculos = em.find(Veiculos.class, veiculos.getCodveiculo());
            Empresa codempresaOld = persistentVeiculos.getCodempresa();
            Empresa codempresaNew = veiculos.getCodempresa();
            Transportadora codtransOld = persistentVeiculos.getCodtrans();
            Transportadora codtransNew = veiculos.getCodtrans();
            Uf codufOld = persistentVeiculos.getCoduf();
            Uf codufNew = veiculos.getCoduf();
            Collection<Mdfeletronicoveiculo> mdfeletronicoveiculoCollectionOld = persistentVeiculos.getMdfeletronicoveiculoCollection();
            Collection<Mdfeletronicoveiculo> mdfeletronicoveiculoCollectionNew = veiculos.getMdfeletronicoveiculoCollection();
            Collection<Orcamento> orcamentoCollectionOld = persistentVeiculos.getOrcamentoCollection();
            Collection<Orcamento> orcamentoCollectionNew = veiculos.getOrcamentoCollection();
            Collection<Movenda> movendaCollectionOld = persistentVeiculos.getMovendaCollection();
            Collection<Movenda> movendaCollectionNew = veiculos.getMovendaCollection();
            Collection<Loteentrega> loteentregaCollectionOld = persistentVeiculos.getLoteentregaCollection();
            Collection<Loteentrega> loteentregaCollectionNew = veiculos.getLoteentregaCollection();
            List<String> illegalOrphanMessages = null;
            for (Mdfeletronicoveiculo mdfeletronicoveiculoCollectionOldMdfeletronicoveiculo : mdfeletronicoveiculoCollectionOld) {
                if (!mdfeletronicoveiculoCollectionNew.contains(mdfeletronicoveiculoCollectionOldMdfeletronicoveiculo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Mdfeletronicoveiculo " + mdfeletronicoveiculoCollectionOldMdfeletronicoveiculo + " since its codveiculo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                veiculos.setCodempresa(codempresaNew);
            }
            if (codtransNew != null) {
                codtransNew = em.getReference(codtransNew.getClass(), codtransNew.getCodtrans());
                veiculos.setCodtrans(codtransNew);
            }
            if (codufNew != null) {
                codufNew = em.getReference(codufNew.getClass(), codufNew.getCoduf());
                veiculos.setCoduf(codufNew);
            }
            Collection<Mdfeletronicoveiculo> attachedMdfeletronicoveiculoCollectionNew = new ArrayList<Mdfeletronicoveiculo>();
            for (Mdfeletronicoveiculo mdfeletronicoveiculoCollectionNewMdfeletronicoveiculoToAttach : mdfeletronicoveiculoCollectionNew) {
                mdfeletronicoveiculoCollectionNewMdfeletronicoveiculoToAttach = em.getReference(mdfeletronicoveiculoCollectionNewMdfeletronicoveiculoToAttach.getClass(), mdfeletronicoveiculoCollectionNewMdfeletronicoveiculoToAttach.getCodmdfeletronicoveiculo());
                attachedMdfeletronicoveiculoCollectionNew.add(mdfeletronicoveiculoCollectionNewMdfeletronicoveiculoToAttach);
            }
            mdfeletronicoveiculoCollectionNew = attachedMdfeletronicoveiculoCollectionNew;
            veiculos.setMdfeletronicoveiculoCollection(mdfeletronicoveiculoCollectionNew);
            Collection<Orcamento> attachedOrcamentoCollectionNew = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollectionNewOrcamentoToAttach : orcamentoCollectionNew) {
                orcamentoCollectionNewOrcamentoToAttach = em.getReference(orcamentoCollectionNewOrcamentoToAttach.getClass(), orcamentoCollectionNewOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollectionNew.add(orcamentoCollectionNewOrcamentoToAttach);
            }
            orcamentoCollectionNew = attachedOrcamentoCollectionNew;
            veiculos.setOrcamentoCollection(orcamentoCollectionNew);
            Collection<Movenda> attachedMovendaCollectionNew = new ArrayList<Movenda>();
            for (Movenda movendaCollectionNewMovendaToAttach : movendaCollectionNew) {
                movendaCollectionNewMovendaToAttach = em.getReference(movendaCollectionNewMovendaToAttach.getClass(), movendaCollectionNewMovendaToAttach.getCodmovenda());
                attachedMovendaCollectionNew.add(movendaCollectionNewMovendaToAttach);
            }
            movendaCollectionNew = attachedMovendaCollectionNew;
            veiculos.setMovendaCollection(movendaCollectionNew);
            Collection<Loteentrega> attachedLoteentregaCollectionNew = new ArrayList<Loteentrega>();
            for (Loteentrega loteentregaCollectionNewLoteentregaToAttach : loteentregaCollectionNew) {
                loteentregaCollectionNewLoteentregaToAttach = em.getReference(loteentregaCollectionNewLoteentregaToAttach.getClass(), loteentregaCollectionNewLoteentregaToAttach.getCodloteentrega());
                attachedLoteentregaCollectionNew.add(loteentregaCollectionNewLoteentregaToAttach);
            }
            loteentregaCollectionNew = attachedLoteentregaCollectionNew;
            veiculos.setLoteentregaCollection(loteentregaCollectionNew);
            veiculos = em.merge(veiculos);
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getVeiculosCollection().remove(veiculos);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getVeiculosCollection().add(veiculos);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codtransOld != null && !codtransOld.equals(codtransNew)) {
                codtransOld.getVeiculosCollection().remove(veiculos);
                codtransOld = em.merge(codtransOld);
            }
            if (codtransNew != null && !codtransNew.equals(codtransOld)) {
                codtransNew.getVeiculosCollection().add(veiculos);
                codtransNew = em.merge(codtransNew);
            }
            if (codufOld != null && !codufOld.equals(codufNew)) {
                codufOld.getVeiculosCollection().remove(veiculos);
                codufOld = em.merge(codufOld);
            }
            if (codufNew != null && !codufNew.equals(codufOld)) {
                codufNew.getVeiculosCollection().add(veiculos);
                codufNew = em.merge(codufNew);
            }
            for (Mdfeletronicoveiculo mdfeletronicoveiculoCollectionNewMdfeletronicoveiculo : mdfeletronicoveiculoCollectionNew) {
                if (!mdfeletronicoveiculoCollectionOld.contains(mdfeletronicoveiculoCollectionNewMdfeletronicoveiculo)) {
                    Veiculos oldCodveiculoOfMdfeletronicoveiculoCollectionNewMdfeletronicoveiculo = mdfeletronicoveiculoCollectionNewMdfeletronicoveiculo.getCodveiculo();
                    mdfeletronicoveiculoCollectionNewMdfeletronicoveiculo.setCodveiculo(veiculos);
                    mdfeletronicoveiculoCollectionNewMdfeletronicoveiculo = em.merge(mdfeletronicoveiculoCollectionNewMdfeletronicoveiculo);
                    if (oldCodveiculoOfMdfeletronicoveiculoCollectionNewMdfeletronicoveiculo != null && !oldCodveiculoOfMdfeletronicoveiculoCollectionNewMdfeletronicoveiculo.equals(veiculos)) {
                        oldCodveiculoOfMdfeletronicoveiculoCollectionNewMdfeletronicoveiculo.getMdfeletronicoveiculoCollection().remove(mdfeletronicoveiculoCollectionNewMdfeletronicoveiculo);
                        oldCodveiculoOfMdfeletronicoveiculoCollectionNewMdfeletronicoveiculo = em.merge(oldCodveiculoOfMdfeletronicoveiculoCollectionNewMdfeletronicoveiculo);
                    }
                }
            }
            for (Orcamento orcamentoCollectionOldOrcamento : orcamentoCollectionOld) {
                if (!orcamentoCollectionNew.contains(orcamentoCollectionOldOrcamento)) {
                    orcamentoCollectionOldOrcamento.setCodveiculo(null);
                    orcamentoCollectionOldOrcamento = em.merge(orcamentoCollectionOldOrcamento);
                }
            }
            for (Orcamento orcamentoCollectionNewOrcamento : orcamentoCollectionNew) {
                if (!orcamentoCollectionOld.contains(orcamentoCollectionNewOrcamento)) {
                    Veiculos oldCodveiculoOfOrcamentoCollectionNewOrcamento = orcamentoCollectionNewOrcamento.getCodveiculo();
                    orcamentoCollectionNewOrcamento.setCodveiculo(veiculos);
                    orcamentoCollectionNewOrcamento = em.merge(orcamentoCollectionNewOrcamento);
                    if (oldCodveiculoOfOrcamentoCollectionNewOrcamento != null && !oldCodveiculoOfOrcamentoCollectionNewOrcamento.equals(veiculos)) {
                        oldCodveiculoOfOrcamentoCollectionNewOrcamento.getOrcamentoCollection().remove(orcamentoCollectionNewOrcamento);
                        oldCodveiculoOfOrcamentoCollectionNewOrcamento = em.merge(oldCodveiculoOfOrcamentoCollectionNewOrcamento);
                    }
                }
            }
            for (Movenda movendaCollectionOldMovenda : movendaCollectionOld) {
                if (!movendaCollectionNew.contains(movendaCollectionOldMovenda)) {
                    movendaCollectionOldMovenda.setCodveiculo(null);
                    movendaCollectionOldMovenda = em.merge(movendaCollectionOldMovenda);
                }
            }
            for (Movenda movendaCollectionNewMovenda : movendaCollectionNew) {
                if (!movendaCollectionOld.contains(movendaCollectionNewMovenda)) {
                    Veiculos oldCodveiculoOfMovendaCollectionNewMovenda = movendaCollectionNewMovenda.getCodveiculo();
                    movendaCollectionNewMovenda.setCodveiculo(veiculos);
                    movendaCollectionNewMovenda = em.merge(movendaCollectionNewMovenda);
                    if (oldCodveiculoOfMovendaCollectionNewMovenda != null && !oldCodveiculoOfMovendaCollectionNewMovenda.equals(veiculos)) {
                        oldCodveiculoOfMovendaCollectionNewMovenda.getMovendaCollection().remove(movendaCollectionNewMovenda);
                        oldCodveiculoOfMovendaCollectionNewMovenda = em.merge(oldCodveiculoOfMovendaCollectionNewMovenda);
                    }
                }
            }
            for (Loteentrega loteentregaCollectionOldLoteentrega : loteentregaCollectionOld) {
                if (!loteentregaCollectionNew.contains(loteentregaCollectionOldLoteentrega)) {
                    loteentregaCollectionOldLoteentrega.setCodveiculo(null);
                    loteentregaCollectionOldLoteentrega = em.merge(loteentregaCollectionOldLoteentrega);
                }
            }
            for (Loteentrega loteentregaCollectionNewLoteentrega : loteentregaCollectionNew) {
                if (!loteentregaCollectionOld.contains(loteentregaCollectionNewLoteentrega)) {
                    Veiculos oldCodveiculoOfLoteentregaCollectionNewLoteentrega = loteentregaCollectionNewLoteentrega.getCodveiculo();
                    loteentregaCollectionNewLoteentrega.setCodveiculo(veiculos);
                    loteentregaCollectionNewLoteentrega = em.merge(loteentregaCollectionNewLoteentrega);
                    if (oldCodveiculoOfLoteentregaCollectionNewLoteentrega != null && !oldCodveiculoOfLoteentregaCollectionNewLoteentrega.equals(veiculos)) {
                        oldCodveiculoOfLoteentregaCollectionNewLoteentrega.getLoteentregaCollection().remove(loteentregaCollectionNewLoteentrega);
                        oldCodveiculoOfLoteentregaCollectionNewLoteentrega = em.merge(oldCodveiculoOfLoteentregaCollectionNewLoteentrega);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = veiculos.getCodveiculo();
                if (findVeiculos(id) == null) {
                    throw new NonexistentEntityException("The veiculos with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Veiculos veiculos;
            try {
                veiculos = em.getReference(Veiculos.class, id);
                veiculos.getCodveiculo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The veiculos with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Mdfeletronicoveiculo> mdfeletronicoveiculoCollectionOrphanCheck = veiculos.getMdfeletronicoveiculoCollection();
            for (Mdfeletronicoveiculo mdfeletronicoveiculoCollectionOrphanCheckMdfeletronicoveiculo : mdfeletronicoveiculoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Veiculos (" + veiculos + ") cannot be destroyed since the Mdfeletronicoveiculo " + mdfeletronicoveiculoCollectionOrphanCheckMdfeletronicoveiculo + " in its mdfeletronicoveiculoCollection field has a non-nullable codveiculo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Empresa codempresa = veiculos.getCodempresa();
            if (codempresa != null) {
                codempresa.getVeiculosCollection().remove(veiculos);
                codempresa = em.merge(codempresa);
            }
            Transportadora codtrans = veiculos.getCodtrans();
            if (codtrans != null) {
                codtrans.getVeiculosCollection().remove(veiculos);
                codtrans = em.merge(codtrans);
            }
            Uf coduf = veiculos.getCoduf();
            if (coduf != null) {
                coduf.getVeiculosCollection().remove(veiculos);
                coduf = em.merge(coduf);
            }
            Collection<Orcamento> orcamentoCollection = veiculos.getOrcamentoCollection();
            for (Orcamento orcamentoCollectionOrcamento : orcamentoCollection) {
                orcamentoCollectionOrcamento.setCodveiculo(null);
                orcamentoCollectionOrcamento = em.merge(orcamentoCollectionOrcamento);
            }
            Collection<Movenda> movendaCollection = veiculos.getMovendaCollection();
            for (Movenda movendaCollectionMovenda : movendaCollection) {
                movendaCollectionMovenda.setCodveiculo(null);
                movendaCollectionMovenda = em.merge(movendaCollectionMovenda);
            }
            Collection<Loteentrega> loteentregaCollection = veiculos.getLoteentregaCollection();
            for (Loteentrega loteentregaCollectionLoteentrega : loteentregaCollection) {
                loteentregaCollectionLoteentrega.setCodveiculo(null);
                loteentregaCollectionLoteentrega = em.merge(loteentregaCollectionLoteentrega);
            }
            em.remove(veiculos);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Veiculos> findVeiculosEntities() {
        return findVeiculosEntities(true, -1, -1);
    }

    public List<Veiculos> findVeiculosEntities(int maxResults, int firstResult) {
        return findVeiculosEntities(false, maxResults, firstResult);
    }

    private List<Veiculos> findVeiculosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Veiculos.class));
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

    public Veiculos findVeiculos(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Veiculos.class, id);
        } finally {
            em.close();
        }
    }

    public int getVeiculosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Veiculos> rt = cq.from(Veiculos.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

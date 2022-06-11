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
import entidade.cplus.Moventrada;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Documento;
import entidade.cplus.Regracfopitem;
import entidade.cplus.Orcamento;
import entidade.cplus.Movenda;
import entidade.cplus.Cliente;
import entidade.cplus.Planocontacfop;
import entidade.cplus.Tipomovimento;
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
public class TipomovimentoJpaController implements Serializable {

    public TipomovimentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipomovimento tipomovimento) throws PreexistingEntityException, Exception {
        if (tipomovimento.getMoventradaCollection() == null) {
            tipomovimento.setMoventradaCollection(new ArrayList<Moventrada>());
        }
        if (tipomovimento.getDocumentoCollection() == null) {
            tipomovimento.setDocumentoCollection(new ArrayList<Documento>());
        }
        if (tipomovimento.getRegracfopitemCollection() == null) {
            tipomovimento.setRegracfopitemCollection(new ArrayList<Regracfopitem>());
        }
        if (tipomovimento.getOrcamentoCollection() == null) {
            tipomovimento.setOrcamentoCollection(new ArrayList<Orcamento>());
        }
        if (tipomovimento.getMovendaCollection() == null) {
            tipomovimento.setMovendaCollection(new ArrayList<Movenda>());
        }
        if (tipomovimento.getClienteCollection() == null) {
            tipomovimento.setClienteCollection(new ArrayList<Cliente>());
        }
        if (tipomovimento.getPlanocontacfopCollection() == null) {
            tipomovimento.setPlanocontacfopCollection(new ArrayList<Planocontacfop>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Moventrada> attachedMoventradaCollection = new ArrayList<Moventrada>();
            for (Moventrada moventradaCollectionMoventradaToAttach : tipomovimento.getMoventradaCollection()) {
                moventradaCollectionMoventradaToAttach = em.getReference(moventradaCollectionMoventradaToAttach.getClass(), moventradaCollectionMoventradaToAttach.getCodmoventr());
                attachedMoventradaCollection.add(moventradaCollectionMoventradaToAttach);
            }
            tipomovimento.setMoventradaCollection(attachedMoventradaCollection);
            Collection<Documento> attachedDocumentoCollection = new ArrayList<Documento>();
            for (Documento documentoCollectionDocumentoToAttach : tipomovimento.getDocumentoCollection()) {
                documentoCollectionDocumentoToAttach = em.getReference(documentoCollectionDocumentoToAttach.getClass(), documentoCollectionDocumentoToAttach.getCoddocumento());
                attachedDocumentoCollection.add(documentoCollectionDocumentoToAttach);
            }
            tipomovimento.setDocumentoCollection(attachedDocumentoCollection);
            Collection<Regracfopitem> attachedRegracfopitemCollection = new ArrayList<Regracfopitem>();
            for (Regracfopitem regracfopitemCollectionRegracfopitemToAttach : tipomovimento.getRegracfopitemCollection()) {
                regracfopitemCollectionRegracfopitemToAttach = em.getReference(regracfopitemCollectionRegracfopitemToAttach.getClass(), regracfopitemCollectionRegracfopitemToAttach.getCodregracfopitem());
                attachedRegracfopitemCollection.add(regracfopitemCollectionRegracfopitemToAttach);
            }
            tipomovimento.setRegracfopitemCollection(attachedRegracfopitemCollection);
            Collection<Orcamento> attachedOrcamentoCollection = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollectionOrcamentoToAttach : tipomovimento.getOrcamentoCollection()) {
                orcamentoCollectionOrcamentoToAttach = em.getReference(orcamentoCollectionOrcamentoToAttach.getClass(), orcamentoCollectionOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollection.add(orcamentoCollectionOrcamentoToAttach);
            }
            tipomovimento.setOrcamentoCollection(attachedOrcamentoCollection);
            Collection<Movenda> attachedMovendaCollection = new ArrayList<Movenda>();
            for (Movenda movendaCollectionMovendaToAttach : tipomovimento.getMovendaCollection()) {
                movendaCollectionMovendaToAttach = em.getReference(movendaCollectionMovendaToAttach.getClass(), movendaCollectionMovendaToAttach.getCodmovenda());
                attachedMovendaCollection.add(movendaCollectionMovendaToAttach);
            }
            tipomovimento.setMovendaCollection(attachedMovendaCollection);
            Collection<Cliente> attachedClienteCollection = new ArrayList<Cliente>();
            for (Cliente clienteCollectionClienteToAttach : tipomovimento.getClienteCollection()) {
                clienteCollectionClienteToAttach = em.getReference(clienteCollectionClienteToAttach.getClass(), clienteCollectionClienteToAttach.getCodcli());
                attachedClienteCollection.add(clienteCollectionClienteToAttach);
            }
            tipomovimento.setClienteCollection(attachedClienteCollection);
            Collection<Planocontacfop> attachedPlanocontacfopCollection = new ArrayList<Planocontacfop>();
            for (Planocontacfop planocontacfopCollectionPlanocontacfopToAttach : tipomovimento.getPlanocontacfopCollection()) {
                planocontacfopCollectionPlanocontacfopToAttach = em.getReference(planocontacfopCollectionPlanocontacfopToAttach.getClass(), planocontacfopCollectionPlanocontacfopToAttach.getCodplanocontacfop());
                attachedPlanocontacfopCollection.add(planocontacfopCollectionPlanocontacfopToAttach);
            }
            tipomovimento.setPlanocontacfopCollection(attachedPlanocontacfopCollection);
            em.persist(tipomovimento);
            for (Moventrada moventradaCollectionMoventrada : tipomovimento.getMoventradaCollection()) {
                Tipomovimento oldCodtipomovimentoOfMoventradaCollectionMoventrada = moventradaCollectionMoventrada.getCodtipomovimento();
                moventradaCollectionMoventrada.setCodtipomovimento(tipomovimento);
                moventradaCollectionMoventrada = em.merge(moventradaCollectionMoventrada);
                if (oldCodtipomovimentoOfMoventradaCollectionMoventrada != null) {
                    oldCodtipomovimentoOfMoventradaCollectionMoventrada.getMoventradaCollection().remove(moventradaCollectionMoventrada);
                    oldCodtipomovimentoOfMoventradaCollectionMoventrada = em.merge(oldCodtipomovimentoOfMoventradaCollectionMoventrada);
                }
            }
            for (Documento documentoCollectionDocumento : tipomovimento.getDocumentoCollection()) {
                Tipomovimento oldCodtipomovimentoOfDocumentoCollectionDocumento = documentoCollectionDocumento.getCodtipomovimento();
                documentoCollectionDocumento.setCodtipomovimento(tipomovimento);
                documentoCollectionDocumento = em.merge(documentoCollectionDocumento);
                if (oldCodtipomovimentoOfDocumentoCollectionDocumento != null) {
                    oldCodtipomovimentoOfDocumentoCollectionDocumento.getDocumentoCollection().remove(documentoCollectionDocumento);
                    oldCodtipomovimentoOfDocumentoCollectionDocumento = em.merge(oldCodtipomovimentoOfDocumentoCollectionDocumento);
                }
            }
            for (Regracfopitem regracfopitemCollectionRegracfopitem : tipomovimento.getRegracfopitemCollection()) {
                Tipomovimento oldCodtipomovimentoOfRegracfopitemCollectionRegracfopitem = regracfopitemCollectionRegracfopitem.getCodtipomovimento();
                regracfopitemCollectionRegracfopitem.setCodtipomovimento(tipomovimento);
                regracfopitemCollectionRegracfopitem = em.merge(regracfopitemCollectionRegracfopitem);
                if (oldCodtipomovimentoOfRegracfopitemCollectionRegracfopitem != null) {
                    oldCodtipomovimentoOfRegracfopitemCollectionRegracfopitem.getRegracfopitemCollection().remove(regracfopitemCollectionRegracfopitem);
                    oldCodtipomovimentoOfRegracfopitemCollectionRegracfopitem = em.merge(oldCodtipomovimentoOfRegracfopitemCollectionRegracfopitem);
                }
            }
            for (Orcamento orcamentoCollectionOrcamento : tipomovimento.getOrcamentoCollection()) {
                Tipomovimento oldCodtipomovimentoOfOrcamentoCollectionOrcamento = orcamentoCollectionOrcamento.getCodtipomovimento();
                orcamentoCollectionOrcamento.setCodtipomovimento(tipomovimento);
                orcamentoCollectionOrcamento = em.merge(orcamentoCollectionOrcamento);
                if (oldCodtipomovimentoOfOrcamentoCollectionOrcamento != null) {
                    oldCodtipomovimentoOfOrcamentoCollectionOrcamento.getOrcamentoCollection().remove(orcamentoCollectionOrcamento);
                    oldCodtipomovimentoOfOrcamentoCollectionOrcamento = em.merge(oldCodtipomovimentoOfOrcamentoCollectionOrcamento);
                }
            }
            for (Movenda movendaCollectionMovenda : tipomovimento.getMovendaCollection()) {
                Tipomovimento oldCodtipomovimentoOfMovendaCollectionMovenda = movendaCollectionMovenda.getCodtipomovimento();
                movendaCollectionMovenda.setCodtipomovimento(tipomovimento);
                movendaCollectionMovenda = em.merge(movendaCollectionMovenda);
                if (oldCodtipomovimentoOfMovendaCollectionMovenda != null) {
                    oldCodtipomovimentoOfMovendaCollectionMovenda.getMovendaCollection().remove(movendaCollectionMovenda);
                    oldCodtipomovimentoOfMovendaCollectionMovenda = em.merge(oldCodtipomovimentoOfMovendaCollectionMovenda);
                }
            }
            for (Cliente clienteCollectionCliente : tipomovimento.getClienteCollection()) {
                Tipomovimento oldCodtipomovimentoOfClienteCollectionCliente = clienteCollectionCliente.getCodtipomovimento();
                clienteCollectionCliente.setCodtipomovimento(tipomovimento);
                clienteCollectionCliente = em.merge(clienteCollectionCliente);
                if (oldCodtipomovimentoOfClienteCollectionCliente != null) {
                    oldCodtipomovimentoOfClienteCollectionCliente.getClienteCollection().remove(clienteCollectionCliente);
                    oldCodtipomovimentoOfClienteCollectionCliente = em.merge(oldCodtipomovimentoOfClienteCollectionCliente);
                }
            }
            for (Planocontacfop planocontacfopCollectionPlanocontacfop : tipomovimento.getPlanocontacfopCollection()) {
                Tipomovimento oldCodtipomovimentoOfPlanocontacfopCollectionPlanocontacfop = planocontacfopCollectionPlanocontacfop.getCodtipomovimento();
                planocontacfopCollectionPlanocontacfop.setCodtipomovimento(tipomovimento);
                planocontacfopCollectionPlanocontacfop = em.merge(planocontacfopCollectionPlanocontacfop);
                if (oldCodtipomovimentoOfPlanocontacfopCollectionPlanocontacfop != null) {
                    oldCodtipomovimentoOfPlanocontacfopCollectionPlanocontacfop.getPlanocontacfopCollection().remove(planocontacfopCollectionPlanocontacfop);
                    oldCodtipomovimentoOfPlanocontacfopCollectionPlanocontacfop = em.merge(oldCodtipomovimentoOfPlanocontacfopCollectionPlanocontacfop);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipomovimento(tipomovimento.getCodtipomovimento()) != null) {
                throw new PreexistingEntityException("Tipomovimento " + tipomovimento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipomovimento tipomovimento) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipomovimento persistentTipomovimento = em.find(Tipomovimento.class, tipomovimento.getCodtipomovimento());
            Collection<Moventrada> moventradaCollectionOld = persistentTipomovimento.getMoventradaCollection();
            Collection<Moventrada> moventradaCollectionNew = tipomovimento.getMoventradaCollection();
            Collection<Documento> documentoCollectionOld = persistentTipomovimento.getDocumentoCollection();
            Collection<Documento> documentoCollectionNew = tipomovimento.getDocumentoCollection();
            Collection<Regracfopitem> regracfopitemCollectionOld = persistentTipomovimento.getRegracfopitemCollection();
            Collection<Regracfopitem> regracfopitemCollectionNew = tipomovimento.getRegracfopitemCollection();
            Collection<Orcamento> orcamentoCollectionOld = persistentTipomovimento.getOrcamentoCollection();
            Collection<Orcamento> orcamentoCollectionNew = tipomovimento.getOrcamentoCollection();
            Collection<Movenda> movendaCollectionOld = persistentTipomovimento.getMovendaCollection();
            Collection<Movenda> movendaCollectionNew = tipomovimento.getMovendaCollection();
            Collection<Cliente> clienteCollectionOld = persistentTipomovimento.getClienteCollection();
            Collection<Cliente> clienteCollectionNew = tipomovimento.getClienteCollection();
            Collection<Planocontacfop> planocontacfopCollectionOld = persistentTipomovimento.getPlanocontacfopCollection();
            Collection<Planocontacfop> planocontacfopCollectionNew = tipomovimento.getPlanocontacfopCollection();
            List<String> illegalOrphanMessages = null;
            for (Moventrada moventradaCollectionOldMoventrada : moventradaCollectionOld) {
                if (!moventradaCollectionNew.contains(moventradaCollectionOldMoventrada)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Moventrada " + moventradaCollectionOldMoventrada + " since its codtipomovimento field is not nullable.");
                }
            }
            for (Movenda movendaCollectionOldMovenda : movendaCollectionOld) {
                if (!movendaCollectionNew.contains(movendaCollectionOldMovenda)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Movenda " + movendaCollectionOldMovenda + " since its codtipomovimento field is not nullable.");
                }
            }
            for (Planocontacfop planocontacfopCollectionOldPlanocontacfop : planocontacfopCollectionOld) {
                if (!planocontacfopCollectionNew.contains(planocontacfopCollectionOldPlanocontacfop)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Planocontacfop " + planocontacfopCollectionOldPlanocontacfop + " since its codtipomovimento field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Moventrada> attachedMoventradaCollectionNew = new ArrayList<Moventrada>();
            for (Moventrada moventradaCollectionNewMoventradaToAttach : moventradaCollectionNew) {
                moventradaCollectionNewMoventradaToAttach = em.getReference(moventradaCollectionNewMoventradaToAttach.getClass(), moventradaCollectionNewMoventradaToAttach.getCodmoventr());
                attachedMoventradaCollectionNew.add(moventradaCollectionNewMoventradaToAttach);
            }
            moventradaCollectionNew = attachedMoventradaCollectionNew;
            tipomovimento.setMoventradaCollection(moventradaCollectionNew);
            Collection<Documento> attachedDocumentoCollectionNew = new ArrayList<Documento>();
            for (Documento documentoCollectionNewDocumentoToAttach : documentoCollectionNew) {
                documentoCollectionNewDocumentoToAttach = em.getReference(documentoCollectionNewDocumentoToAttach.getClass(), documentoCollectionNewDocumentoToAttach.getCoddocumento());
                attachedDocumentoCollectionNew.add(documentoCollectionNewDocumentoToAttach);
            }
            documentoCollectionNew = attachedDocumentoCollectionNew;
            tipomovimento.setDocumentoCollection(documentoCollectionNew);
            Collection<Regracfopitem> attachedRegracfopitemCollectionNew = new ArrayList<Regracfopitem>();
            for (Regracfopitem regracfopitemCollectionNewRegracfopitemToAttach : regracfopitemCollectionNew) {
                regracfopitemCollectionNewRegracfopitemToAttach = em.getReference(regracfopitemCollectionNewRegracfopitemToAttach.getClass(), regracfopitemCollectionNewRegracfopitemToAttach.getCodregracfopitem());
                attachedRegracfopitemCollectionNew.add(regracfopitemCollectionNewRegracfopitemToAttach);
            }
            regracfopitemCollectionNew = attachedRegracfopitemCollectionNew;
            tipomovimento.setRegracfopitemCollection(regracfopitemCollectionNew);
            Collection<Orcamento> attachedOrcamentoCollectionNew = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollectionNewOrcamentoToAttach : orcamentoCollectionNew) {
                orcamentoCollectionNewOrcamentoToAttach = em.getReference(orcamentoCollectionNewOrcamentoToAttach.getClass(), orcamentoCollectionNewOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollectionNew.add(orcamentoCollectionNewOrcamentoToAttach);
            }
            orcamentoCollectionNew = attachedOrcamentoCollectionNew;
            tipomovimento.setOrcamentoCollection(orcamentoCollectionNew);
            Collection<Movenda> attachedMovendaCollectionNew = new ArrayList<Movenda>();
            for (Movenda movendaCollectionNewMovendaToAttach : movendaCollectionNew) {
                movendaCollectionNewMovendaToAttach = em.getReference(movendaCollectionNewMovendaToAttach.getClass(), movendaCollectionNewMovendaToAttach.getCodmovenda());
                attachedMovendaCollectionNew.add(movendaCollectionNewMovendaToAttach);
            }
            movendaCollectionNew = attachedMovendaCollectionNew;
            tipomovimento.setMovendaCollection(movendaCollectionNew);
            Collection<Cliente> attachedClienteCollectionNew = new ArrayList<Cliente>();
            for (Cliente clienteCollectionNewClienteToAttach : clienteCollectionNew) {
                clienteCollectionNewClienteToAttach = em.getReference(clienteCollectionNewClienteToAttach.getClass(), clienteCollectionNewClienteToAttach.getCodcli());
                attachedClienteCollectionNew.add(clienteCollectionNewClienteToAttach);
            }
            clienteCollectionNew = attachedClienteCollectionNew;
            tipomovimento.setClienteCollection(clienteCollectionNew);
            Collection<Planocontacfop> attachedPlanocontacfopCollectionNew = new ArrayList<Planocontacfop>();
            for (Planocontacfop planocontacfopCollectionNewPlanocontacfopToAttach : planocontacfopCollectionNew) {
                planocontacfopCollectionNewPlanocontacfopToAttach = em.getReference(planocontacfopCollectionNewPlanocontacfopToAttach.getClass(), planocontacfopCollectionNewPlanocontacfopToAttach.getCodplanocontacfop());
                attachedPlanocontacfopCollectionNew.add(planocontacfopCollectionNewPlanocontacfopToAttach);
            }
            planocontacfopCollectionNew = attachedPlanocontacfopCollectionNew;
            tipomovimento.setPlanocontacfopCollection(planocontacfopCollectionNew);
            tipomovimento = em.merge(tipomovimento);
            for (Moventrada moventradaCollectionNewMoventrada : moventradaCollectionNew) {
                if (!moventradaCollectionOld.contains(moventradaCollectionNewMoventrada)) {
                    Tipomovimento oldCodtipomovimentoOfMoventradaCollectionNewMoventrada = moventradaCollectionNewMoventrada.getCodtipomovimento();
                    moventradaCollectionNewMoventrada.setCodtipomovimento(tipomovimento);
                    moventradaCollectionNewMoventrada = em.merge(moventradaCollectionNewMoventrada);
                    if (oldCodtipomovimentoOfMoventradaCollectionNewMoventrada != null && !oldCodtipomovimentoOfMoventradaCollectionNewMoventrada.equals(tipomovimento)) {
                        oldCodtipomovimentoOfMoventradaCollectionNewMoventrada.getMoventradaCollection().remove(moventradaCollectionNewMoventrada);
                        oldCodtipomovimentoOfMoventradaCollectionNewMoventrada = em.merge(oldCodtipomovimentoOfMoventradaCollectionNewMoventrada);
                    }
                }
            }
            for (Documento documentoCollectionOldDocumento : documentoCollectionOld) {
                if (!documentoCollectionNew.contains(documentoCollectionOldDocumento)) {
                    documentoCollectionOldDocumento.setCodtipomovimento(null);
                    documentoCollectionOldDocumento = em.merge(documentoCollectionOldDocumento);
                }
            }
            for (Documento documentoCollectionNewDocumento : documentoCollectionNew) {
                if (!documentoCollectionOld.contains(documentoCollectionNewDocumento)) {
                    Tipomovimento oldCodtipomovimentoOfDocumentoCollectionNewDocumento = documentoCollectionNewDocumento.getCodtipomovimento();
                    documentoCollectionNewDocumento.setCodtipomovimento(tipomovimento);
                    documentoCollectionNewDocumento = em.merge(documentoCollectionNewDocumento);
                    if (oldCodtipomovimentoOfDocumentoCollectionNewDocumento != null && !oldCodtipomovimentoOfDocumentoCollectionNewDocumento.equals(tipomovimento)) {
                        oldCodtipomovimentoOfDocumentoCollectionNewDocumento.getDocumentoCollection().remove(documentoCollectionNewDocumento);
                        oldCodtipomovimentoOfDocumentoCollectionNewDocumento = em.merge(oldCodtipomovimentoOfDocumentoCollectionNewDocumento);
                    }
                }
            }
            for (Regracfopitem regracfopitemCollectionOldRegracfopitem : regracfopitemCollectionOld) {
                if (!regracfopitemCollectionNew.contains(regracfopitemCollectionOldRegracfopitem)) {
                    regracfopitemCollectionOldRegracfopitem.setCodtipomovimento(null);
                    regracfopitemCollectionOldRegracfopitem = em.merge(regracfopitemCollectionOldRegracfopitem);
                }
            }
            for (Regracfopitem regracfopitemCollectionNewRegracfopitem : regracfopitemCollectionNew) {
                if (!regracfopitemCollectionOld.contains(regracfopitemCollectionNewRegracfopitem)) {
                    Tipomovimento oldCodtipomovimentoOfRegracfopitemCollectionNewRegracfopitem = regracfopitemCollectionNewRegracfopitem.getCodtipomovimento();
                    regracfopitemCollectionNewRegracfopitem.setCodtipomovimento(tipomovimento);
                    regracfopitemCollectionNewRegracfopitem = em.merge(regracfopitemCollectionNewRegracfopitem);
                    if (oldCodtipomovimentoOfRegracfopitemCollectionNewRegracfopitem != null && !oldCodtipomovimentoOfRegracfopitemCollectionNewRegracfopitem.equals(tipomovimento)) {
                        oldCodtipomovimentoOfRegracfopitemCollectionNewRegracfopitem.getRegracfopitemCollection().remove(regracfopitemCollectionNewRegracfopitem);
                        oldCodtipomovimentoOfRegracfopitemCollectionNewRegracfopitem = em.merge(oldCodtipomovimentoOfRegracfopitemCollectionNewRegracfopitem);
                    }
                }
            }
            for (Orcamento orcamentoCollectionOldOrcamento : orcamentoCollectionOld) {
                if (!orcamentoCollectionNew.contains(orcamentoCollectionOldOrcamento)) {
                    orcamentoCollectionOldOrcamento.setCodtipomovimento(null);
                    orcamentoCollectionOldOrcamento = em.merge(orcamentoCollectionOldOrcamento);
                }
            }
            for (Orcamento orcamentoCollectionNewOrcamento : orcamentoCollectionNew) {
                if (!orcamentoCollectionOld.contains(orcamentoCollectionNewOrcamento)) {
                    Tipomovimento oldCodtipomovimentoOfOrcamentoCollectionNewOrcamento = orcamentoCollectionNewOrcamento.getCodtipomovimento();
                    orcamentoCollectionNewOrcamento.setCodtipomovimento(tipomovimento);
                    orcamentoCollectionNewOrcamento = em.merge(orcamentoCollectionNewOrcamento);
                    if (oldCodtipomovimentoOfOrcamentoCollectionNewOrcamento != null && !oldCodtipomovimentoOfOrcamentoCollectionNewOrcamento.equals(tipomovimento)) {
                        oldCodtipomovimentoOfOrcamentoCollectionNewOrcamento.getOrcamentoCollection().remove(orcamentoCollectionNewOrcamento);
                        oldCodtipomovimentoOfOrcamentoCollectionNewOrcamento = em.merge(oldCodtipomovimentoOfOrcamentoCollectionNewOrcamento);
                    }
                }
            }
            for (Movenda movendaCollectionNewMovenda : movendaCollectionNew) {
                if (!movendaCollectionOld.contains(movendaCollectionNewMovenda)) {
                    Tipomovimento oldCodtipomovimentoOfMovendaCollectionNewMovenda = movendaCollectionNewMovenda.getCodtipomovimento();
                    movendaCollectionNewMovenda.setCodtipomovimento(tipomovimento);
                    movendaCollectionNewMovenda = em.merge(movendaCollectionNewMovenda);
                    if (oldCodtipomovimentoOfMovendaCollectionNewMovenda != null && !oldCodtipomovimentoOfMovendaCollectionNewMovenda.equals(tipomovimento)) {
                        oldCodtipomovimentoOfMovendaCollectionNewMovenda.getMovendaCollection().remove(movendaCollectionNewMovenda);
                        oldCodtipomovimentoOfMovendaCollectionNewMovenda = em.merge(oldCodtipomovimentoOfMovendaCollectionNewMovenda);
                    }
                }
            }
            for (Cliente clienteCollectionOldCliente : clienteCollectionOld) {
                if (!clienteCollectionNew.contains(clienteCollectionOldCliente)) {
                    clienteCollectionOldCliente.setCodtipomovimento(null);
                    clienteCollectionOldCliente = em.merge(clienteCollectionOldCliente);
                }
            }
            for (Cliente clienteCollectionNewCliente : clienteCollectionNew) {
                if (!clienteCollectionOld.contains(clienteCollectionNewCliente)) {
                    Tipomovimento oldCodtipomovimentoOfClienteCollectionNewCliente = clienteCollectionNewCliente.getCodtipomovimento();
                    clienteCollectionNewCliente.setCodtipomovimento(tipomovimento);
                    clienteCollectionNewCliente = em.merge(clienteCollectionNewCliente);
                    if (oldCodtipomovimentoOfClienteCollectionNewCliente != null && !oldCodtipomovimentoOfClienteCollectionNewCliente.equals(tipomovimento)) {
                        oldCodtipomovimentoOfClienteCollectionNewCliente.getClienteCollection().remove(clienteCollectionNewCliente);
                        oldCodtipomovimentoOfClienteCollectionNewCliente = em.merge(oldCodtipomovimentoOfClienteCollectionNewCliente);
                    }
                }
            }
            for (Planocontacfop planocontacfopCollectionNewPlanocontacfop : planocontacfopCollectionNew) {
                if (!planocontacfopCollectionOld.contains(planocontacfopCollectionNewPlanocontacfop)) {
                    Tipomovimento oldCodtipomovimentoOfPlanocontacfopCollectionNewPlanocontacfop = planocontacfopCollectionNewPlanocontacfop.getCodtipomovimento();
                    planocontacfopCollectionNewPlanocontacfop.setCodtipomovimento(tipomovimento);
                    planocontacfopCollectionNewPlanocontacfop = em.merge(planocontacfopCollectionNewPlanocontacfop);
                    if (oldCodtipomovimentoOfPlanocontacfopCollectionNewPlanocontacfop != null && !oldCodtipomovimentoOfPlanocontacfopCollectionNewPlanocontacfop.equals(tipomovimento)) {
                        oldCodtipomovimentoOfPlanocontacfopCollectionNewPlanocontacfop.getPlanocontacfopCollection().remove(planocontacfopCollectionNewPlanocontacfop);
                        oldCodtipomovimentoOfPlanocontacfopCollectionNewPlanocontacfop = em.merge(oldCodtipomovimentoOfPlanocontacfopCollectionNewPlanocontacfop);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tipomovimento.getCodtipomovimento();
                if (findTipomovimento(id) == null) {
                    throw new NonexistentEntityException("The tipomovimento with id " + id + " no longer exists.");
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
            Tipomovimento tipomovimento;
            try {
                tipomovimento = em.getReference(Tipomovimento.class, id);
                tipomovimento.getCodtipomovimento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipomovimento with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Moventrada> moventradaCollectionOrphanCheck = tipomovimento.getMoventradaCollection();
            for (Moventrada moventradaCollectionOrphanCheckMoventrada : moventradaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Tipomovimento (" + tipomovimento + ") cannot be destroyed since the Moventrada " + moventradaCollectionOrphanCheckMoventrada + " in its moventradaCollection field has a non-nullable codtipomovimento field.");
            }
            Collection<Movenda> movendaCollectionOrphanCheck = tipomovimento.getMovendaCollection();
            for (Movenda movendaCollectionOrphanCheckMovenda : movendaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Tipomovimento (" + tipomovimento + ") cannot be destroyed since the Movenda " + movendaCollectionOrphanCheckMovenda + " in its movendaCollection field has a non-nullable codtipomovimento field.");
            }
            Collection<Planocontacfop> planocontacfopCollectionOrphanCheck = tipomovimento.getPlanocontacfopCollection();
            for (Planocontacfop planocontacfopCollectionOrphanCheckPlanocontacfop : planocontacfopCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Tipomovimento (" + tipomovimento + ") cannot be destroyed since the Planocontacfop " + planocontacfopCollectionOrphanCheckPlanocontacfop + " in its planocontacfopCollection field has a non-nullable codtipomovimento field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Documento> documentoCollection = tipomovimento.getDocumentoCollection();
            for (Documento documentoCollectionDocumento : documentoCollection) {
                documentoCollectionDocumento.setCodtipomovimento(null);
                documentoCollectionDocumento = em.merge(documentoCollectionDocumento);
            }
            Collection<Regracfopitem> regracfopitemCollection = tipomovimento.getRegracfopitemCollection();
            for (Regracfopitem regracfopitemCollectionRegracfopitem : regracfopitemCollection) {
                regracfopitemCollectionRegracfopitem.setCodtipomovimento(null);
                regracfopitemCollectionRegracfopitem = em.merge(regracfopitemCollectionRegracfopitem);
            }
            Collection<Orcamento> orcamentoCollection = tipomovimento.getOrcamentoCollection();
            for (Orcamento orcamentoCollectionOrcamento : orcamentoCollection) {
                orcamentoCollectionOrcamento.setCodtipomovimento(null);
                orcamentoCollectionOrcamento = em.merge(orcamentoCollectionOrcamento);
            }
            Collection<Cliente> clienteCollection = tipomovimento.getClienteCollection();
            for (Cliente clienteCollectionCliente : clienteCollection) {
                clienteCollectionCliente.setCodtipomovimento(null);
                clienteCollectionCliente = em.merge(clienteCollectionCliente);
            }
            em.remove(tipomovimento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipomovimento> findTipomovimentoEntities() {
        return findTipomovimentoEntities(true, -1, -1);
    }

    public List<Tipomovimento> findTipomovimentoEntities(int maxResults, int firstResult) {
        return findTipomovimentoEntities(false, maxResults, firstResult);
    }

    private List<Tipomovimento> findTipomovimentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipomovimento.class));
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

    public Tipomovimento findTipomovimento(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipomovimento.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipomovimentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipomovimento> rt = cq.from(Tipomovimento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

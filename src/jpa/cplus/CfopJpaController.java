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
import entidade.cplus.Cfop;
import entidade.cplus.Moventrada;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Calculoicmsestado;
import entidade.cplus.Moventradaprod;
import entidade.cplus.Pedidoitem;
import entidade.cplus.Documento;
import entidade.cplus.Movendaprod;
import entidade.cplus.Regracfopitem;
import entidade.cplus.Movenda;
import entidade.cplus.Pedido;
import entidade.cplus.Planocontacfop;
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
public class CfopJpaController implements Serializable {

    public CfopJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cfop cfop) throws PreexistingEntityException, Exception {
        if (cfop.getMoventradaCollection() == null) {
            cfop.setMoventradaCollection(new ArrayList<Moventrada>());
        }
        if (cfop.getCalculoicmsestadoCollection() == null) {
            cfop.setCalculoicmsestadoCollection(new ArrayList<Calculoicmsestado>());
        }
        if (cfop.getMoventradaprodCollection() == null) {
            cfop.setMoventradaprodCollection(new ArrayList<Moventradaprod>());
        }
        if (cfop.getPedidoitemCollection() == null) {
            cfop.setPedidoitemCollection(new ArrayList<Pedidoitem>());
        }
        if (cfop.getDocumentoCollection() == null) {
            cfop.setDocumentoCollection(new ArrayList<Documento>());
        }
        if (cfop.getCfopCollection() == null) {
            cfop.setCfopCollection(new ArrayList<Cfop>());
        }
        if (cfop.getCfopCollection1() == null) {
            cfop.setCfopCollection1(new ArrayList<Cfop>());
        }
        if (cfop.getMovendaprodCollection() == null) {
            cfop.setMovendaprodCollection(new ArrayList<Movendaprod>());
        }
        if (cfop.getRegracfopitemCollection() == null) {
            cfop.setRegracfopitemCollection(new ArrayList<Regracfopitem>());
        }
        if (cfop.getMovendaCollection() == null) {
            cfop.setMovendaCollection(new ArrayList<Movenda>());
        }
        if (cfop.getPedidoCollection() == null) {
            cfop.setPedidoCollection(new ArrayList<Pedido>());
        }
        if (cfop.getPlanocontacfopCollection() == null) {
            cfop.setPlanocontacfopCollection(new ArrayList<Planocontacfop>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cfop codcfopequivalente = cfop.getCodcfopequivalente();
            if (codcfopequivalente != null) {
                codcfopequivalente = em.getReference(codcfopequivalente.getClass(), codcfopequivalente.getCodcfop());
                cfop.setCodcfopequivalente(codcfopequivalente);
            }
            Cfop codcfopdevolucao = cfop.getCodcfopdevolucao();
            if (codcfopdevolucao != null) {
                codcfopdevolucao = em.getReference(codcfopdevolucao.getClass(), codcfopdevolucao.getCodcfop());
                cfop.setCodcfopdevolucao(codcfopdevolucao);
            }
            Collection<Moventrada> attachedMoventradaCollection = new ArrayList<Moventrada>();
            for (Moventrada moventradaCollectionMoventradaToAttach : cfop.getMoventradaCollection()) {
                moventradaCollectionMoventradaToAttach = em.getReference(moventradaCollectionMoventradaToAttach.getClass(), moventradaCollectionMoventradaToAttach.getCodmoventr());
                attachedMoventradaCollection.add(moventradaCollectionMoventradaToAttach);
            }
            cfop.setMoventradaCollection(attachedMoventradaCollection);
            Collection<Calculoicmsestado> attachedCalculoicmsestadoCollection = new ArrayList<Calculoicmsestado>();
            for (Calculoicmsestado calculoicmsestadoCollectionCalculoicmsestadoToAttach : cfop.getCalculoicmsestadoCollection()) {
                calculoicmsestadoCollectionCalculoicmsestadoToAttach = em.getReference(calculoicmsestadoCollectionCalculoicmsestadoToAttach.getClass(), calculoicmsestadoCollectionCalculoicmsestadoToAttach.getCodcalculoicmsestado());
                attachedCalculoicmsestadoCollection.add(calculoicmsestadoCollectionCalculoicmsestadoToAttach);
            }
            cfop.setCalculoicmsestadoCollection(attachedCalculoicmsestadoCollection);
            Collection<Moventradaprod> attachedMoventradaprodCollection = new ArrayList<Moventradaprod>();
            for (Moventradaprod moventradaprodCollectionMoventradaprodToAttach : cfop.getMoventradaprodCollection()) {
                moventradaprodCollectionMoventradaprodToAttach = em.getReference(moventradaprodCollectionMoventradaprodToAttach.getClass(), moventradaprodCollectionMoventradaprodToAttach.getCodmoveprod());
                attachedMoventradaprodCollection.add(moventradaprodCollectionMoventradaprodToAttach);
            }
            cfop.setMoventradaprodCollection(attachedMoventradaprodCollection);
            Collection<Pedidoitem> attachedPedidoitemCollection = new ArrayList<Pedidoitem>();
            for (Pedidoitem pedidoitemCollectionPedidoitemToAttach : cfop.getPedidoitemCollection()) {
                pedidoitemCollectionPedidoitemToAttach = em.getReference(pedidoitemCollectionPedidoitemToAttach.getClass(), pedidoitemCollectionPedidoitemToAttach.getCodpedidoitem());
                attachedPedidoitemCollection.add(pedidoitemCollectionPedidoitemToAttach);
            }
            cfop.setPedidoitemCollection(attachedPedidoitemCollection);
            Collection<Documento> attachedDocumentoCollection = new ArrayList<Documento>();
            for (Documento documentoCollectionDocumentoToAttach : cfop.getDocumentoCollection()) {
                documentoCollectionDocumentoToAttach = em.getReference(documentoCollectionDocumentoToAttach.getClass(), documentoCollectionDocumentoToAttach.getCoddocumento());
                attachedDocumentoCollection.add(documentoCollectionDocumentoToAttach);
            }
            cfop.setDocumentoCollection(attachedDocumentoCollection);
            Collection<Cfop> attachedCfopCollection = new ArrayList<Cfop>();
            for (Cfop cfopCollectionCfopToAttach : cfop.getCfopCollection()) {
                cfopCollectionCfopToAttach = em.getReference(cfopCollectionCfopToAttach.getClass(), cfopCollectionCfopToAttach.getCodcfop());
                attachedCfopCollection.add(cfopCollectionCfopToAttach);
            }
            cfop.setCfopCollection(attachedCfopCollection);
            Collection<Cfop> attachedCfopCollection1 = new ArrayList<Cfop>();
            for (Cfop cfopCollection1CfopToAttach : cfop.getCfopCollection1()) {
                cfopCollection1CfopToAttach = em.getReference(cfopCollection1CfopToAttach.getClass(), cfopCollection1CfopToAttach.getCodcfop());
                attachedCfopCollection1.add(cfopCollection1CfopToAttach);
            }
            cfop.setCfopCollection1(attachedCfopCollection1);
            Collection<Movendaprod> attachedMovendaprodCollection = new ArrayList<Movendaprod>();
            for (Movendaprod movendaprodCollectionMovendaprodToAttach : cfop.getMovendaprodCollection()) {
                movendaprodCollectionMovendaprodToAttach = em.getReference(movendaprodCollectionMovendaprodToAttach.getClass(), movendaprodCollectionMovendaprodToAttach.getCodmovprod());
                attachedMovendaprodCollection.add(movendaprodCollectionMovendaprodToAttach);
            }
            cfop.setMovendaprodCollection(attachedMovendaprodCollection);
            Collection<Regracfopitem> attachedRegracfopitemCollection = new ArrayList<Regracfopitem>();
            for (Regracfopitem regracfopitemCollectionRegracfopitemToAttach : cfop.getRegracfopitemCollection()) {
                regracfopitemCollectionRegracfopitemToAttach = em.getReference(regracfopitemCollectionRegracfopitemToAttach.getClass(), regracfopitemCollectionRegracfopitemToAttach.getCodregracfopitem());
                attachedRegracfopitemCollection.add(regracfopitemCollectionRegracfopitemToAttach);
            }
            cfop.setRegracfopitemCollection(attachedRegracfopitemCollection);
            Collection<Movenda> attachedMovendaCollection = new ArrayList<Movenda>();
            for (Movenda movendaCollectionMovendaToAttach : cfop.getMovendaCollection()) {
                movendaCollectionMovendaToAttach = em.getReference(movendaCollectionMovendaToAttach.getClass(), movendaCollectionMovendaToAttach.getCodmovenda());
                attachedMovendaCollection.add(movendaCollectionMovendaToAttach);
            }
            cfop.setMovendaCollection(attachedMovendaCollection);
            Collection<Pedido> attachedPedidoCollection = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionPedidoToAttach : cfop.getPedidoCollection()) {
                pedidoCollectionPedidoToAttach = em.getReference(pedidoCollectionPedidoToAttach.getClass(), pedidoCollectionPedidoToAttach.getCodped());
                attachedPedidoCollection.add(pedidoCollectionPedidoToAttach);
            }
            cfop.setPedidoCollection(attachedPedidoCollection);
            Collection<Planocontacfop> attachedPlanocontacfopCollection = new ArrayList<Planocontacfop>();
            for (Planocontacfop planocontacfopCollectionPlanocontacfopToAttach : cfop.getPlanocontacfopCollection()) {
                planocontacfopCollectionPlanocontacfopToAttach = em.getReference(planocontacfopCollectionPlanocontacfopToAttach.getClass(), planocontacfopCollectionPlanocontacfopToAttach.getCodplanocontacfop());
                attachedPlanocontacfopCollection.add(planocontacfopCollectionPlanocontacfopToAttach);
            }
            cfop.setPlanocontacfopCollection(attachedPlanocontacfopCollection);
            em.persist(cfop);
            if (codcfopequivalente != null) {
                codcfopequivalente.getCfopCollection().add(cfop);
                codcfopequivalente = em.merge(codcfopequivalente);
            }
            if (codcfopdevolucao != null) {
                codcfopdevolucao.getCfopCollection().add(cfop);
                codcfopdevolucao = em.merge(codcfopdevolucao);
            }
            for (Moventrada moventradaCollectionMoventrada : cfop.getMoventradaCollection()) {
                Cfop oldCodcfopOfMoventradaCollectionMoventrada = moventradaCollectionMoventrada.getCodcfop();
                moventradaCollectionMoventrada.setCodcfop(cfop);
                moventradaCollectionMoventrada = em.merge(moventradaCollectionMoventrada);
                if (oldCodcfopOfMoventradaCollectionMoventrada != null) {
                    oldCodcfopOfMoventradaCollectionMoventrada.getMoventradaCollection().remove(moventradaCollectionMoventrada);
                    oldCodcfopOfMoventradaCollectionMoventrada = em.merge(oldCodcfopOfMoventradaCollectionMoventrada);
                }
            }
            for (Calculoicmsestado calculoicmsestadoCollectionCalculoicmsestado : cfop.getCalculoicmsestadoCollection()) {
                Cfop oldCodcfopOfCalculoicmsestadoCollectionCalculoicmsestado = calculoicmsestadoCollectionCalculoicmsestado.getCodcfop();
                calculoicmsestadoCollectionCalculoicmsestado.setCodcfop(cfop);
                calculoicmsestadoCollectionCalculoicmsestado = em.merge(calculoicmsestadoCollectionCalculoicmsestado);
                if (oldCodcfopOfCalculoicmsestadoCollectionCalculoicmsestado != null) {
                    oldCodcfopOfCalculoicmsestadoCollectionCalculoicmsestado.getCalculoicmsestadoCollection().remove(calculoicmsestadoCollectionCalculoicmsestado);
                    oldCodcfopOfCalculoicmsestadoCollectionCalculoicmsestado = em.merge(oldCodcfopOfCalculoicmsestadoCollectionCalculoicmsestado);
                }
            }
            for (Moventradaprod moventradaprodCollectionMoventradaprod : cfop.getMoventradaprodCollection()) {
                Cfop oldCodcfopOfMoventradaprodCollectionMoventradaprod = moventradaprodCollectionMoventradaprod.getCodcfop();
                moventradaprodCollectionMoventradaprod.setCodcfop(cfop);
                moventradaprodCollectionMoventradaprod = em.merge(moventradaprodCollectionMoventradaprod);
                if (oldCodcfopOfMoventradaprodCollectionMoventradaprod != null) {
                    oldCodcfopOfMoventradaprodCollectionMoventradaprod.getMoventradaprodCollection().remove(moventradaprodCollectionMoventradaprod);
                    oldCodcfopOfMoventradaprodCollectionMoventradaprod = em.merge(oldCodcfopOfMoventradaprodCollectionMoventradaprod);
                }
            }
            for (Pedidoitem pedidoitemCollectionPedidoitem : cfop.getPedidoitemCollection()) {
                Cfop oldCodcfopOfPedidoitemCollectionPedidoitem = pedidoitemCollectionPedidoitem.getCodcfop();
                pedidoitemCollectionPedidoitem.setCodcfop(cfop);
                pedidoitemCollectionPedidoitem = em.merge(pedidoitemCollectionPedidoitem);
                if (oldCodcfopOfPedidoitemCollectionPedidoitem != null) {
                    oldCodcfopOfPedidoitemCollectionPedidoitem.getPedidoitemCollection().remove(pedidoitemCollectionPedidoitem);
                    oldCodcfopOfPedidoitemCollectionPedidoitem = em.merge(oldCodcfopOfPedidoitemCollectionPedidoitem);
                }
            }
            for (Documento documentoCollectionDocumento : cfop.getDocumentoCollection()) {
                Cfop oldCodcfopOfDocumentoCollectionDocumento = documentoCollectionDocumento.getCodcfop();
                documentoCollectionDocumento.setCodcfop(cfop);
                documentoCollectionDocumento = em.merge(documentoCollectionDocumento);
                if (oldCodcfopOfDocumentoCollectionDocumento != null) {
                    oldCodcfopOfDocumentoCollectionDocumento.getDocumentoCollection().remove(documentoCollectionDocumento);
                    oldCodcfopOfDocumentoCollectionDocumento = em.merge(oldCodcfopOfDocumentoCollectionDocumento);
                }
            }
            for (Cfop cfopCollectionCfop : cfop.getCfopCollection()) {
                Cfop oldCodcfopequivalenteOfCfopCollectionCfop = cfopCollectionCfop.getCodcfopequivalente();
                cfopCollectionCfop.setCodcfopequivalente(cfop);
                cfopCollectionCfop = em.merge(cfopCollectionCfop);
                if (oldCodcfopequivalenteOfCfopCollectionCfop != null) {
                    oldCodcfopequivalenteOfCfopCollectionCfop.getCfopCollection().remove(cfopCollectionCfop);
                    oldCodcfopequivalenteOfCfopCollectionCfop = em.merge(oldCodcfopequivalenteOfCfopCollectionCfop);
                }
            }
            for (Cfop cfopCollection1Cfop : cfop.getCfopCollection1()) {
                Cfop oldCodcfopdevolucaoOfCfopCollection1Cfop = cfopCollection1Cfop.getCodcfopdevolucao();
                cfopCollection1Cfop.setCodcfopdevolucao(cfop);
                cfopCollection1Cfop = em.merge(cfopCollection1Cfop);
                if (oldCodcfopdevolucaoOfCfopCollection1Cfop != null) {
                    oldCodcfopdevolucaoOfCfopCollection1Cfop.getCfopCollection1().remove(cfopCollection1Cfop);
                    oldCodcfopdevolucaoOfCfopCollection1Cfop = em.merge(oldCodcfopdevolucaoOfCfopCollection1Cfop);
                }
            }
            for (Movendaprod movendaprodCollectionMovendaprod : cfop.getMovendaprodCollection()) {
                Cfop oldCodcfopOfMovendaprodCollectionMovendaprod = movendaprodCollectionMovendaprod.getCodcfop();
                movendaprodCollectionMovendaprod.setCodcfop(cfop);
                movendaprodCollectionMovendaprod = em.merge(movendaprodCollectionMovendaprod);
                if (oldCodcfopOfMovendaprodCollectionMovendaprod != null) {
                    oldCodcfopOfMovendaprodCollectionMovendaprod.getMovendaprodCollection().remove(movendaprodCollectionMovendaprod);
                    oldCodcfopOfMovendaprodCollectionMovendaprod = em.merge(oldCodcfopOfMovendaprodCollectionMovendaprod);
                }
            }
            for (Regracfopitem regracfopitemCollectionRegracfopitem : cfop.getRegracfopitemCollection()) {
                Cfop oldCodcfopOfRegracfopitemCollectionRegracfopitem = regracfopitemCollectionRegracfopitem.getCodcfop();
                regracfopitemCollectionRegracfopitem.setCodcfop(cfop);
                regracfopitemCollectionRegracfopitem = em.merge(regracfopitemCollectionRegracfopitem);
                if (oldCodcfopOfRegracfopitemCollectionRegracfopitem != null) {
                    oldCodcfopOfRegracfopitemCollectionRegracfopitem.getRegracfopitemCollection().remove(regracfopitemCollectionRegracfopitem);
                    oldCodcfopOfRegracfopitemCollectionRegracfopitem = em.merge(oldCodcfopOfRegracfopitemCollectionRegracfopitem);
                }
            }
            for (Movenda movendaCollectionMovenda : cfop.getMovendaCollection()) {
                Cfop oldCodcfopOfMovendaCollectionMovenda = movendaCollectionMovenda.getCodcfop();
                movendaCollectionMovenda.setCodcfop(cfop);
                movendaCollectionMovenda = em.merge(movendaCollectionMovenda);
                if (oldCodcfopOfMovendaCollectionMovenda != null) {
                    oldCodcfopOfMovendaCollectionMovenda.getMovendaCollection().remove(movendaCollectionMovenda);
                    oldCodcfopOfMovendaCollectionMovenda = em.merge(oldCodcfopOfMovendaCollectionMovenda);
                }
            }
            for (Pedido pedidoCollectionPedido : cfop.getPedidoCollection()) {
                Cfop oldCodcfopOfPedidoCollectionPedido = pedidoCollectionPedido.getCodcfop();
                pedidoCollectionPedido.setCodcfop(cfop);
                pedidoCollectionPedido = em.merge(pedidoCollectionPedido);
                if (oldCodcfopOfPedidoCollectionPedido != null) {
                    oldCodcfopOfPedidoCollectionPedido.getPedidoCollection().remove(pedidoCollectionPedido);
                    oldCodcfopOfPedidoCollectionPedido = em.merge(oldCodcfopOfPedidoCollectionPedido);
                }
            }
            for (Planocontacfop planocontacfopCollectionPlanocontacfop : cfop.getPlanocontacfopCollection()) {
                Cfop oldCodcfopOfPlanocontacfopCollectionPlanocontacfop = planocontacfopCollectionPlanocontacfop.getCodcfop();
                planocontacfopCollectionPlanocontacfop.setCodcfop(cfop);
                planocontacfopCollectionPlanocontacfop = em.merge(planocontacfopCollectionPlanocontacfop);
                if (oldCodcfopOfPlanocontacfopCollectionPlanocontacfop != null) {
                    oldCodcfopOfPlanocontacfopCollectionPlanocontacfop.getPlanocontacfopCollection().remove(planocontacfopCollectionPlanocontacfop);
                    oldCodcfopOfPlanocontacfopCollectionPlanocontacfop = em.merge(oldCodcfopOfPlanocontacfopCollectionPlanocontacfop);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCfop(cfop.getCodcfop()) != null) {
                throw new PreexistingEntityException("Cfop " + cfop + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cfop cfop) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cfop persistentCfop = em.find(Cfop.class, cfop.getCodcfop());
            Cfop codcfopequivalenteOld = persistentCfop.getCodcfopequivalente();
            Cfop codcfopequivalenteNew = cfop.getCodcfopequivalente();
            Cfop codcfopdevolucaoOld = persistentCfop.getCodcfopdevolucao();
            Cfop codcfopdevolucaoNew = cfop.getCodcfopdevolucao();
            Collection<Moventrada> moventradaCollectionOld = persistentCfop.getMoventradaCollection();
            Collection<Moventrada> moventradaCollectionNew = cfop.getMoventradaCollection();
            Collection<Calculoicmsestado> calculoicmsestadoCollectionOld = persistentCfop.getCalculoicmsestadoCollection();
            Collection<Calculoicmsestado> calculoicmsestadoCollectionNew = cfop.getCalculoicmsestadoCollection();
            Collection<Moventradaprod> moventradaprodCollectionOld = persistentCfop.getMoventradaprodCollection();
            Collection<Moventradaprod> moventradaprodCollectionNew = cfop.getMoventradaprodCollection();
            Collection<Pedidoitem> pedidoitemCollectionOld = persistentCfop.getPedidoitemCollection();
            Collection<Pedidoitem> pedidoitemCollectionNew = cfop.getPedidoitemCollection();
            Collection<Documento> documentoCollectionOld = persistentCfop.getDocumentoCollection();
            Collection<Documento> documentoCollectionNew = cfop.getDocumentoCollection();
            Collection<Cfop> cfopCollectionOld = persistentCfop.getCfopCollection();
            Collection<Cfop> cfopCollectionNew = cfop.getCfopCollection();
            Collection<Cfop> cfopCollection1Old = persistentCfop.getCfopCollection1();
            Collection<Cfop> cfopCollection1New = cfop.getCfopCollection1();
            Collection<Movendaprod> movendaprodCollectionOld = persistentCfop.getMovendaprodCollection();
            Collection<Movendaprod> movendaprodCollectionNew = cfop.getMovendaprodCollection();
            Collection<Regracfopitem> regracfopitemCollectionOld = persistentCfop.getRegracfopitemCollection();
            Collection<Regracfopitem> regracfopitemCollectionNew = cfop.getRegracfopitemCollection();
            Collection<Movenda> movendaCollectionOld = persistentCfop.getMovendaCollection();
            Collection<Movenda> movendaCollectionNew = cfop.getMovendaCollection();
            Collection<Pedido> pedidoCollectionOld = persistentCfop.getPedidoCollection();
            Collection<Pedido> pedidoCollectionNew = cfop.getPedidoCollection();
            Collection<Planocontacfop> planocontacfopCollectionOld = persistentCfop.getPlanocontacfopCollection();
            Collection<Planocontacfop> planocontacfopCollectionNew = cfop.getPlanocontacfopCollection();
            List<String> illegalOrphanMessages = null;
            for (Regracfopitem regracfopitemCollectionOldRegracfopitem : regracfopitemCollectionOld) {
                if (!regracfopitemCollectionNew.contains(regracfopitemCollectionOldRegracfopitem)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Regracfopitem " + regracfopitemCollectionOldRegracfopitem + " since its codcfop field is not nullable.");
                }
            }
            for (Planocontacfop planocontacfopCollectionOldPlanocontacfop : planocontacfopCollectionOld) {
                if (!planocontacfopCollectionNew.contains(planocontacfopCollectionOldPlanocontacfop)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Planocontacfop " + planocontacfopCollectionOldPlanocontacfop + " since its codcfop field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codcfopequivalenteNew != null) {
                codcfopequivalenteNew = em.getReference(codcfopequivalenteNew.getClass(), codcfopequivalenteNew.getCodcfop());
                cfop.setCodcfopequivalente(codcfopequivalenteNew);
            }
            if (codcfopdevolucaoNew != null) {
                codcfopdevolucaoNew = em.getReference(codcfopdevolucaoNew.getClass(), codcfopdevolucaoNew.getCodcfop());
                cfop.setCodcfopdevolucao(codcfopdevolucaoNew);
            }
            Collection<Moventrada> attachedMoventradaCollectionNew = new ArrayList<Moventrada>();
            for (Moventrada moventradaCollectionNewMoventradaToAttach : moventradaCollectionNew) {
                moventradaCollectionNewMoventradaToAttach = em.getReference(moventradaCollectionNewMoventradaToAttach.getClass(), moventradaCollectionNewMoventradaToAttach.getCodmoventr());
                attachedMoventradaCollectionNew.add(moventradaCollectionNewMoventradaToAttach);
            }
            moventradaCollectionNew = attachedMoventradaCollectionNew;
            cfop.setMoventradaCollection(moventradaCollectionNew);
            Collection<Calculoicmsestado> attachedCalculoicmsestadoCollectionNew = new ArrayList<Calculoicmsestado>();
            for (Calculoicmsestado calculoicmsestadoCollectionNewCalculoicmsestadoToAttach : calculoicmsestadoCollectionNew) {
                calculoicmsestadoCollectionNewCalculoicmsestadoToAttach = em.getReference(calculoicmsestadoCollectionNewCalculoicmsestadoToAttach.getClass(), calculoicmsestadoCollectionNewCalculoicmsestadoToAttach.getCodcalculoicmsestado());
                attachedCalculoicmsestadoCollectionNew.add(calculoicmsestadoCollectionNewCalculoicmsestadoToAttach);
            }
            calculoicmsestadoCollectionNew = attachedCalculoicmsestadoCollectionNew;
            cfop.setCalculoicmsestadoCollection(calculoicmsestadoCollectionNew);
            Collection<Moventradaprod> attachedMoventradaprodCollectionNew = new ArrayList<Moventradaprod>();
            for (Moventradaprod moventradaprodCollectionNewMoventradaprodToAttach : moventradaprodCollectionNew) {
                moventradaprodCollectionNewMoventradaprodToAttach = em.getReference(moventradaprodCollectionNewMoventradaprodToAttach.getClass(), moventradaprodCollectionNewMoventradaprodToAttach.getCodmoveprod());
                attachedMoventradaprodCollectionNew.add(moventradaprodCollectionNewMoventradaprodToAttach);
            }
            moventradaprodCollectionNew = attachedMoventradaprodCollectionNew;
            cfop.setMoventradaprodCollection(moventradaprodCollectionNew);
            Collection<Pedidoitem> attachedPedidoitemCollectionNew = new ArrayList<Pedidoitem>();
            for (Pedidoitem pedidoitemCollectionNewPedidoitemToAttach : pedidoitemCollectionNew) {
                pedidoitemCollectionNewPedidoitemToAttach = em.getReference(pedidoitemCollectionNewPedidoitemToAttach.getClass(), pedidoitemCollectionNewPedidoitemToAttach.getCodpedidoitem());
                attachedPedidoitemCollectionNew.add(pedidoitemCollectionNewPedidoitemToAttach);
            }
            pedidoitemCollectionNew = attachedPedidoitemCollectionNew;
            cfop.setPedidoitemCollection(pedidoitemCollectionNew);
            Collection<Documento> attachedDocumentoCollectionNew = new ArrayList<Documento>();
            for (Documento documentoCollectionNewDocumentoToAttach : documentoCollectionNew) {
                documentoCollectionNewDocumentoToAttach = em.getReference(documentoCollectionNewDocumentoToAttach.getClass(), documentoCollectionNewDocumentoToAttach.getCoddocumento());
                attachedDocumentoCollectionNew.add(documentoCollectionNewDocumentoToAttach);
            }
            documentoCollectionNew = attachedDocumentoCollectionNew;
            cfop.setDocumentoCollection(documentoCollectionNew);
            Collection<Cfop> attachedCfopCollectionNew = new ArrayList<Cfop>();
            for (Cfop cfopCollectionNewCfopToAttach : cfopCollectionNew) {
                cfopCollectionNewCfopToAttach = em.getReference(cfopCollectionNewCfopToAttach.getClass(), cfopCollectionNewCfopToAttach.getCodcfop());
                attachedCfopCollectionNew.add(cfopCollectionNewCfopToAttach);
            }
            cfopCollectionNew = attachedCfopCollectionNew;
            cfop.setCfopCollection(cfopCollectionNew);
            Collection<Cfop> attachedCfopCollection1New = new ArrayList<Cfop>();
            for (Cfop cfopCollection1NewCfopToAttach : cfopCollection1New) {
                cfopCollection1NewCfopToAttach = em.getReference(cfopCollection1NewCfopToAttach.getClass(), cfopCollection1NewCfopToAttach.getCodcfop());
                attachedCfopCollection1New.add(cfopCollection1NewCfopToAttach);
            }
            cfopCollection1New = attachedCfopCollection1New;
            cfop.setCfopCollection1(cfopCollection1New);
            Collection<Movendaprod> attachedMovendaprodCollectionNew = new ArrayList<Movendaprod>();
            for (Movendaprod movendaprodCollectionNewMovendaprodToAttach : movendaprodCollectionNew) {
                movendaprodCollectionNewMovendaprodToAttach = em.getReference(movendaprodCollectionNewMovendaprodToAttach.getClass(), movendaprodCollectionNewMovendaprodToAttach.getCodmovprod());
                attachedMovendaprodCollectionNew.add(movendaprodCollectionNewMovendaprodToAttach);
            }
            movendaprodCollectionNew = attachedMovendaprodCollectionNew;
            cfop.setMovendaprodCollection(movendaprodCollectionNew);
            Collection<Regracfopitem> attachedRegracfopitemCollectionNew = new ArrayList<Regracfopitem>();
            for (Regracfopitem regracfopitemCollectionNewRegracfopitemToAttach : regracfopitemCollectionNew) {
                regracfopitemCollectionNewRegracfopitemToAttach = em.getReference(regracfopitemCollectionNewRegracfopitemToAttach.getClass(), regracfopitemCollectionNewRegracfopitemToAttach.getCodregracfopitem());
                attachedRegracfopitemCollectionNew.add(regracfopitemCollectionNewRegracfopitemToAttach);
            }
            regracfopitemCollectionNew = attachedRegracfopitemCollectionNew;
            cfop.setRegracfopitemCollection(regracfopitemCollectionNew);
            Collection<Movenda> attachedMovendaCollectionNew = new ArrayList<Movenda>();
            for (Movenda movendaCollectionNewMovendaToAttach : movendaCollectionNew) {
                movendaCollectionNewMovendaToAttach = em.getReference(movendaCollectionNewMovendaToAttach.getClass(), movendaCollectionNewMovendaToAttach.getCodmovenda());
                attachedMovendaCollectionNew.add(movendaCollectionNewMovendaToAttach);
            }
            movendaCollectionNew = attachedMovendaCollectionNew;
            cfop.setMovendaCollection(movendaCollectionNew);
            Collection<Pedido> attachedPedidoCollectionNew = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionNewPedidoToAttach : pedidoCollectionNew) {
                pedidoCollectionNewPedidoToAttach = em.getReference(pedidoCollectionNewPedidoToAttach.getClass(), pedidoCollectionNewPedidoToAttach.getCodped());
                attachedPedidoCollectionNew.add(pedidoCollectionNewPedidoToAttach);
            }
            pedidoCollectionNew = attachedPedidoCollectionNew;
            cfop.setPedidoCollection(pedidoCollectionNew);
            Collection<Planocontacfop> attachedPlanocontacfopCollectionNew = new ArrayList<Planocontacfop>();
            for (Planocontacfop planocontacfopCollectionNewPlanocontacfopToAttach : planocontacfopCollectionNew) {
                planocontacfopCollectionNewPlanocontacfopToAttach = em.getReference(planocontacfopCollectionNewPlanocontacfopToAttach.getClass(), planocontacfopCollectionNewPlanocontacfopToAttach.getCodplanocontacfop());
                attachedPlanocontacfopCollectionNew.add(planocontacfopCollectionNewPlanocontacfopToAttach);
            }
            planocontacfopCollectionNew = attachedPlanocontacfopCollectionNew;
            cfop.setPlanocontacfopCollection(planocontacfopCollectionNew);
            cfop = em.merge(cfop);
            if (codcfopequivalenteOld != null && !codcfopequivalenteOld.equals(codcfopequivalenteNew)) {
                codcfopequivalenteOld.getCfopCollection().remove(cfop);
                codcfopequivalenteOld = em.merge(codcfopequivalenteOld);
            }
            if (codcfopequivalenteNew != null && !codcfopequivalenteNew.equals(codcfopequivalenteOld)) {
                codcfopequivalenteNew.getCfopCollection().add(cfop);
                codcfopequivalenteNew = em.merge(codcfopequivalenteNew);
            }
            if (codcfopdevolucaoOld != null && !codcfopdevolucaoOld.equals(codcfopdevolucaoNew)) {
                codcfopdevolucaoOld.getCfopCollection().remove(cfop);
                codcfopdevolucaoOld = em.merge(codcfopdevolucaoOld);
            }
            if (codcfopdevolucaoNew != null && !codcfopdevolucaoNew.equals(codcfopdevolucaoOld)) {
                codcfopdevolucaoNew.getCfopCollection().add(cfop);
                codcfopdevolucaoNew = em.merge(codcfopdevolucaoNew);
            }
            for (Moventrada moventradaCollectionOldMoventrada : moventradaCollectionOld) {
                if (!moventradaCollectionNew.contains(moventradaCollectionOldMoventrada)) {
                    moventradaCollectionOldMoventrada.setCodcfop(null);
                    moventradaCollectionOldMoventrada = em.merge(moventradaCollectionOldMoventrada);
                }
            }
            for (Moventrada moventradaCollectionNewMoventrada : moventradaCollectionNew) {
                if (!moventradaCollectionOld.contains(moventradaCollectionNewMoventrada)) {
                    Cfop oldCodcfopOfMoventradaCollectionNewMoventrada = moventradaCollectionNewMoventrada.getCodcfop();
                    moventradaCollectionNewMoventrada.setCodcfop(cfop);
                    moventradaCollectionNewMoventrada = em.merge(moventradaCollectionNewMoventrada);
                    if (oldCodcfopOfMoventradaCollectionNewMoventrada != null && !oldCodcfopOfMoventradaCollectionNewMoventrada.equals(cfop)) {
                        oldCodcfopOfMoventradaCollectionNewMoventrada.getMoventradaCollection().remove(moventradaCollectionNewMoventrada);
                        oldCodcfopOfMoventradaCollectionNewMoventrada = em.merge(oldCodcfopOfMoventradaCollectionNewMoventrada);
                    }
                }
            }
            for (Calculoicmsestado calculoicmsestadoCollectionOldCalculoicmsestado : calculoicmsestadoCollectionOld) {
                if (!calculoicmsestadoCollectionNew.contains(calculoicmsestadoCollectionOldCalculoicmsestado)) {
                    calculoicmsestadoCollectionOldCalculoicmsestado.setCodcfop(null);
                    calculoicmsestadoCollectionOldCalculoicmsestado = em.merge(calculoicmsestadoCollectionOldCalculoicmsestado);
                }
            }
            for (Calculoicmsestado calculoicmsestadoCollectionNewCalculoicmsestado : calculoicmsestadoCollectionNew) {
                if (!calculoicmsestadoCollectionOld.contains(calculoicmsestadoCollectionNewCalculoicmsestado)) {
                    Cfop oldCodcfopOfCalculoicmsestadoCollectionNewCalculoicmsestado = calculoicmsestadoCollectionNewCalculoicmsestado.getCodcfop();
                    calculoicmsestadoCollectionNewCalculoicmsestado.setCodcfop(cfop);
                    calculoicmsestadoCollectionNewCalculoicmsestado = em.merge(calculoicmsestadoCollectionNewCalculoicmsestado);
                    if (oldCodcfopOfCalculoicmsestadoCollectionNewCalculoicmsestado != null && !oldCodcfopOfCalculoicmsestadoCollectionNewCalculoicmsestado.equals(cfop)) {
                        oldCodcfopOfCalculoicmsestadoCollectionNewCalculoicmsestado.getCalculoicmsestadoCollection().remove(calculoicmsestadoCollectionNewCalculoicmsestado);
                        oldCodcfopOfCalculoicmsestadoCollectionNewCalculoicmsestado = em.merge(oldCodcfopOfCalculoicmsestadoCollectionNewCalculoicmsestado);
                    }
                }
            }
            for (Moventradaprod moventradaprodCollectionOldMoventradaprod : moventradaprodCollectionOld) {
                if (!moventradaprodCollectionNew.contains(moventradaprodCollectionOldMoventradaprod)) {
                    moventradaprodCollectionOldMoventradaprod.setCodcfop(null);
                    moventradaprodCollectionOldMoventradaprod = em.merge(moventradaprodCollectionOldMoventradaprod);
                }
            }
            for (Moventradaprod moventradaprodCollectionNewMoventradaprod : moventradaprodCollectionNew) {
                if (!moventradaprodCollectionOld.contains(moventradaprodCollectionNewMoventradaprod)) {
                    Cfop oldCodcfopOfMoventradaprodCollectionNewMoventradaprod = moventradaprodCollectionNewMoventradaprod.getCodcfop();
                    moventradaprodCollectionNewMoventradaprod.setCodcfop(cfop);
                    moventradaprodCollectionNewMoventradaprod = em.merge(moventradaprodCollectionNewMoventradaprod);
                    if (oldCodcfopOfMoventradaprodCollectionNewMoventradaprod != null && !oldCodcfopOfMoventradaprodCollectionNewMoventradaprod.equals(cfop)) {
                        oldCodcfopOfMoventradaprodCollectionNewMoventradaprod.getMoventradaprodCollection().remove(moventradaprodCollectionNewMoventradaprod);
                        oldCodcfopOfMoventradaprodCollectionNewMoventradaprod = em.merge(oldCodcfopOfMoventradaprodCollectionNewMoventradaprod);
                    }
                }
            }
            for (Pedidoitem pedidoitemCollectionOldPedidoitem : pedidoitemCollectionOld) {
                if (!pedidoitemCollectionNew.contains(pedidoitemCollectionOldPedidoitem)) {
                    pedidoitemCollectionOldPedidoitem.setCodcfop(null);
                    pedidoitemCollectionOldPedidoitem = em.merge(pedidoitemCollectionOldPedidoitem);
                }
            }
            for (Pedidoitem pedidoitemCollectionNewPedidoitem : pedidoitemCollectionNew) {
                if (!pedidoitemCollectionOld.contains(pedidoitemCollectionNewPedidoitem)) {
                    Cfop oldCodcfopOfPedidoitemCollectionNewPedidoitem = pedidoitemCollectionNewPedidoitem.getCodcfop();
                    pedidoitemCollectionNewPedidoitem.setCodcfop(cfop);
                    pedidoitemCollectionNewPedidoitem = em.merge(pedidoitemCollectionNewPedidoitem);
                    if (oldCodcfopOfPedidoitemCollectionNewPedidoitem != null && !oldCodcfopOfPedidoitemCollectionNewPedidoitem.equals(cfop)) {
                        oldCodcfopOfPedidoitemCollectionNewPedidoitem.getPedidoitemCollection().remove(pedidoitemCollectionNewPedidoitem);
                        oldCodcfopOfPedidoitemCollectionNewPedidoitem = em.merge(oldCodcfopOfPedidoitemCollectionNewPedidoitem);
                    }
                }
            }
            for (Documento documentoCollectionOldDocumento : documentoCollectionOld) {
                if (!documentoCollectionNew.contains(documentoCollectionOldDocumento)) {
                    documentoCollectionOldDocumento.setCodcfop(null);
                    documentoCollectionOldDocumento = em.merge(documentoCollectionOldDocumento);
                }
            }
            for (Documento documentoCollectionNewDocumento : documentoCollectionNew) {
                if (!documentoCollectionOld.contains(documentoCollectionNewDocumento)) {
                    Cfop oldCodcfopOfDocumentoCollectionNewDocumento = documentoCollectionNewDocumento.getCodcfop();
                    documentoCollectionNewDocumento.setCodcfop(cfop);
                    documentoCollectionNewDocumento = em.merge(documentoCollectionNewDocumento);
                    if (oldCodcfopOfDocumentoCollectionNewDocumento != null && !oldCodcfopOfDocumentoCollectionNewDocumento.equals(cfop)) {
                        oldCodcfopOfDocumentoCollectionNewDocumento.getDocumentoCollection().remove(documentoCollectionNewDocumento);
                        oldCodcfopOfDocumentoCollectionNewDocumento = em.merge(oldCodcfopOfDocumentoCollectionNewDocumento);
                    }
                }
            }
            for (Cfop cfopCollectionOldCfop : cfopCollectionOld) {
                if (!cfopCollectionNew.contains(cfopCollectionOldCfop)) {
                    cfopCollectionOldCfop.setCodcfopequivalente(null);
                    cfopCollectionOldCfop = em.merge(cfopCollectionOldCfop);
                }
            }
            for (Cfop cfopCollectionNewCfop : cfopCollectionNew) {
                if (!cfopCollectionOld.contains(cfopCollectionNewCfop)) {
                    Cfop oldCodcfopequivalenteOfCfopCollectionNewCfop = cfopCollectionNewCfop.getCodcfopequivalente();
                    cfopCollectionNewCfop.setCodcfopequivalente(cfop);
                    cfopCollectionNewCfop = em.merge(cfopCollectionNewCfop);
                    if (oldCodcfopequivalenteOfCfopCollectionNewCfop != null && !oldCodcfopequivalenteOfCfopCollectionNewCfop.equals(cfop)) {
                        oldCodcfopequivalenteOfCfopCollectionNewCfop.getCfopCollection().remove(cfopCollectionNewCfop);
                        oldCodcfopequivalenteOfCfopCollectionNewCfop = em.merge(oldCodcfopequivalenteOfCfopCollectionNewCfop);
                    }
                }
            }
            for (Cfop cfopCollection1OldCfop : cfopCollection1Old) {
                if (!cfopCollection1New.contains(cfopCollection1OldCfop)) {
                    cfopCollection1OldCfop.setCodcfopdevolucao(null);
                    cfopCollection1OldCfop = em.merge(cfopCollection1OldCfop);
                }
            }
            for (Cfop cfopCollection1NewCfop : cfopCollection1New) {
                if (!cfopCollection1Old.contains(cfopCollection1NewCfop)) {
                    Cfop oldCodcfopdevolucaoOfCfopCollection1NewCfop = cfopCollection1NewCfop.getCodcfopdevolucao();
                    cfopCollection1NewCfop.setCodcfopdevolucao(cfop);
                    cfopCollection1NewCfop = em.merge(cfopCollection1NewCfop);
                    if (oldCodcfopdevolucaoOfCfopCollection1NewCfop != null && !oldCodcfopdevolucaoOfCfopCollection1NewCfop.equals(cfop)) {
                        oldCodcfopdevolucaoOfCfopCollection1NewCfop.getCfopCollection1().remove(cfopCollection1NewCfop);
                        oldCodcfopdevolucaoOfCfopCollection1NewCfop = em.merge(oldCodcfopdevolucaoOfCfopCollection1NewCfop);
                    }
                }
            }
            for (Movendaprod movendaprodCollectionOldMovendaprod : movendaprodCollectionOld) {
                if (!movendaprodCollectionNew.contains(movendaprodCollectionOldMovendaprod)) {
                    movendaprodCollectionOldMovendaprod.setCodcfop(null);
                    movendaprodCollectionOldMovendaprod = em.merge(movendaprodCollectionOldMovendaprod);
                }
            }
            for (Movendaprod movendaprodCollectionNewMovendaprod : movendaprodCollectionNew) {
                if (!movendaprodCollectionOld.contains(movendaprodCollectionNewMovendaprod)) {
                    Cfop oldCodcfopOfMovendaprodCollectionNewMovendaprod = movendaprodCollectionNewMovendaprod.getCodcfop();
                    movendaprodCollectionNewMovendaprod.setCodcfop(cfop);
                    movendaprodCollectionNewMovendaprod = em.merge(movendaprodCollectionNewMovendaprod);
                    if (oldCodcfopOfMovendaprodCollectionNewMovendaprod != null && !oldCodcfopOfMovendaprodCollectionNewMovendaprod.equals(cfop)) {
                        oldCodcfopOfMovendaprodCollectionNewMovendaprod.getMovendaprodCollection().remove(movendaprodCollectionNewMovendaprod);
                        oldCodcfopOfMovendaprodCollectionNewMovendaprod = em.merge(oldCodcfopOfMovendaprodCollectionNewMovendaprod);
                    }
                }
            }
            for (Regracfopitem regracfopitemCollectionNewRegracfopitem : regracfopitemCollectionNew) {
                if (!regracfopitemCollectionOld.contains(regracfopitemCollectionNewRegracfopitem)) {
                    Cfop oldCodcfopOfRegracfopitemCollectionNewRegracfopitem = regracfopitemCollectionNewRegracfopitem.getCodcfop();
                    regracfopitemCollectionNewRegracfopitem.setCodcfop(cfop);
                    regracfopitemCollectionNewRegracfopitem = em.merge(regracfopitemCollectionNewRegracfopitem);
                    if (oldCodcfopOfRegracfopitemCollectionNewRegracfopitem != null && !oldCodcfopOfRegracfopitemCollectionNewRegracfopitem.equals(cfop)) {
                        oldCodcfopOfRegracfopitemCollectionNewRegracfopitem.getRegracfopitemCollection().remove(regracfopitemCollectionNewRegracfopitem);
                        oldCodcfopOfRegracfopitemCollectionNewRegracfopitem = em.merge(oldCodcfopOfRegracfopitemCollectionNewRegracfopitem);
                    }
                }
            }
            for (Movenda movendaCollectionOldMovenda : movendaCollectionOld) {
                if (!movendaCollectionNew.contains(movendaCollectionOldMovenda)) {
                    movendaCollectionOldMovenda.setCodcfop(null);
                    movendaCollectionOldMovenda = em.merge(movendaCollectionOldMovenda);
                }
            }
            for (Movenda movendaCollectionNewMovenda : movendaCollectionNew) {
                if (!movendaCollectionOld.contains(movendaCollectionNewMovenda)) {
                    Cfop oldCodcfopOfMovendaCollectionNewMovenda = movendaCollectionNewMovenda.getCodcfop();
                    movendaCollectionNewMovenda.setCodcfop(cfop);
                    movendaCollectionNewMovenda = em.merge(movendaCollectionNewMovenda);
                    if (oldCodcfopOfMovendaCollectionNewMovenda != null && !oldCodcfopOfMovendaCollectionNewMovenda.equals(cfop)) {
                        oldCodcfopOfMovendaCollectionNewMovenda.getMovendaCollection().remove(movendaCollectionNewMovenda);
                        oldCodcfopOfMovendaCollectionNewMovenda = em.merge(oldCodcfopOfMovendaCollectionNewMovenda);
                    }
                }
            }
            for (Pedido pedidoCollectionOldPedido : pedidoCollectionOld) {
                if (!pedidoCollectionNew.contains(pedidoCollectionOldPedido)) {
                    pedidoCollectionOldPedido.setCodcfop(null);
                    pedidoCollectionOldPedido = em.merge(pedidoCollectionOldPedido);
                }
            }
            for (Pedido pedidoCollectionNewPedido : pedidoCollectionNew) {
                if (!pedidoCollectionOld.contains(pedidoCollectionNewPedido)) {
                    Cfop oldCodcfopOfPedidoCollectionNewPedido = pedidoCollectionNewPedido.getCodcfop();
                    pedidoCollectionNewPedido.setCodcfop(cfop);
                    pedidoCollectionNewPedido = em.merge(pedidoCollectionNewPedido);
                    if (oldCodcfopOfPedidoCollectionNewPedido != null && !oldCodcfopOfPedidoCollectionNewPedido.equals(cfop)) {
                        oldCodcfopOfPedidoCollectionNewPedido.getPedidoCollection().remove(pedidoCollectionNewPedido);
                        oldCodcfopOfPedidoCollectionNewPedido = em.merge(oldCodcfopOfPedidoCollectionNewPedido);
                    }
                }
            }
            for (Planocontacfop planocontacfopCollectionNewPlanocontacfop : planocontacfopCollectionNew) {
                if (!planocontacfopCollectionOld.contains(planocontacfopCollectionNewPlanocontacfop)) {
                    Cfop oldCodcfopOfPlanocontacfopCollectionNewPlanocontacfop = planocontacfopCollectionNewPlanocontacfop.getCodcfop();
                    planocontacfopCollectionNewPlanocontacfop.setCodcfop(cfop);
                    planocontacfopCollectionNewPlanocontacfop = em.merge(planocontacfopCollectionNewPlanocontacfop);
                    if (oldCodcfopOfPlanocontacfopCollectionNewPlanocontacfop != null && !oldCodcfopOfPlanocontacfopCollectionNewPlanocontacfop.equals(cfop)) {
                        oldCodcfopOfPlanocontacfopCollectionNewPlanocontacfop.getPlanocontacfopCollection().remove(planocontacfopCollectionNewPlanocontacfop);
                        oldCodcfopOfPlanocontacfopCollectionNewPlanocontacfop = em.merge(oldCodcfopOfPlanocontacfopCollectionNewPlanocontacfop);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cfop.getCodcfop();
                if (findCfop(id) == null) {
                    throw new NonexistentEntityException("The cfop with id " + id + " no longer exists.");
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
            Cfop cfop;
            try {
                cfop = em.getReference(Cfop.class, id);
                cfop.getCodcfop();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cfop with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Regracfopitem> regracfopitemCollectionOrphanCheck = cfop.getRegracfopitemCollection();
            for (Regracfopitem regracfopitemCollectionOrphanCheckRegracfopitem : regracfopitemCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cfop (" + cfop + ") cannot be destroyed since the Regracfopitem " + regracfopitemCollectionOrphanCheckRegracfopitem + " in its regracfopitemCollection field has a non-nullable codcfop field.");
            }
            Collection<Planocontacfop> planocontacfopCollectionOrphanCheck = cfop.getPlanocontacfopCollection();
            for (Planocontacfop planocontacfopCollectionOrphanCheckPlanocontacfop : planocontacfopCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cfop (" + cfop + ") cannot be destroyed since the Planocontacfop " + planocontacfopCollectionOrphanCheckPlanocontacfop + " in its planocontacfopCollection field has a non-nullable codcfop field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cfop codcfopequivalente = cfop.getCodcfopequivalente();
            if (codcfopequivalente != null) {
                codcfopequivalente.getCfopCollection().remove(cfop);
                codcfopequivalente = em.merge(codcfopequivalente);
            }
            Cfop codcfopdevolucao = cfop.getCodcfopdevolucao();
            if (codcfopdevolucao != null) {
                codcfopdevolucao.getCfopCollection().remove(cfop);
                codcfopdevolucao = em.merge(codcfopdevolucao);
            }
            Collection<Moventrada> moventradaCollection = cfop.getMoventradaCollection();
            for (Moventrada moventradaCollectionMoventrada : moventradaCollection) {
                moventradaCollectionMoventrada.setCodcfop(null);
                moventradaCollectionMoventrada = em.merge(moventradaCollectionMoventrada);
            }
            Collection<Calculoicmsestado> calculoicmsestadoCollection = cfop.getCalculoicmsestadoCollection();
            for (Calculoicmsestado calculoicmsestadoCollectionCalculoicmsestado : calculoicmsestadoCollection) {
                calculoicmsestadoCollectionCalculoicmsestado.setCodcfop(null);
                calculoicmsestadoCollectionCalculoicmsestado = em.merge(calculoicmsestadoCollectionCalculoicmsestado);
            }
            Collection<Moventradaprod> moventradaprodCollection = cfop.getMoventradaprodCollection();
            for (Moventradaprod moventradaprodCollectionMoventradaprod : moventradaprodCollection) {
                moventradaprodCollectionMoventradaprod.setCodcfop(null);
                moventradaprodCollectionMoventradaprod = em.merge(moventradaprodCollectionMoventradaprod);
            }
            Collection<Pedidoitem> pedidoitemCollection = cfop.getPedidoitemCollection();
            for (Pedidoitem pedidoitemCollectionPedidoitem : pedidoitemCollection) {
                pedidoitemCollectionPedidoitem.setCodcfop(null);
                pedidoitemCollectionPedidoitem = em.merge(pedidoitemCollectionPedidoitem);
            }
            Collection<Documento> documentoCollection = cfop.getDocumentoCollection();
            for (Documento documentoCollectionDocumento : documentoCollection) {
                documentoCollectionDocumento.setCodcfop(null);
                documentoCollectionDocumento = em.merge(documentoCollectionDocumento);
            }
            Collection<Cfop> cfopCollection = cfop.getCfopCollection();
            for (Cfop cfopCollectionCfop : cfopCollection) {
                cfopCollectionCfop.setCodcfopequivalente(null);
                cfopCollectionCfop = em.merge(cfopCollectionCfop);
            }
            Collection<Cfop> cfopCollection1 = cfop.getCfopCollection1();
            for (Cfop cfopCollection1Cfop : cfopCollection1) {
                cfopCollection1Cfop.setCodcfopdevolucao(null);
                cfopCollection1Cfop = em.merge(cfopCollection1Cfop);
            }
            Collection<Movendaprod> movendaprodCollection = cfop.getMovendaprodCollection();
            for (Movendaprod movendaprodCollectionMovendaprod : movendaprodCollection) {
                movendaprodCollectionMovendaprod.setCodcfop(null);
                movendaprodCollectionMovendaprod = em.merge(movendaprodCollectionMovendaprod);
            }
            Collection<Movenda> movendaCollection = cfop.getMovendaCollection();
            for (Movenda movendaCollectionMovenda : movendaCollection) {
                movendaCollectionMovenda.setCodcfop(null);
                movendaCollectionMovenda = em.merge(movendaCollectionMovenda);
            }
            Collection<Pedido> pedidoCollection = cfop.getPedidoCollection();
            for (Pedido pedidoCollectionPedido : pedidoCollection) {
                pedidoCollectionPedido.setCodcfop(null);
                pedidoCollectionPedido = em.merge(pedidoCollectionPedido);
            }
            em.remove(cfop);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cfop> findCfopEntities() {
        return findCfopEntities(true, -1, -1);
    }

    public List<Cfop> findCfopEntities(int maxResults, int firstResult) {
        return findCfopEntities(false, maxResults, firstResult);
    }

    private List<Cfop> findCfopEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cfop.class));
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

    public Cfop findCfop(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cfop.class, id);
        } finally {
            em.close();
        }
    }

    public int getCfopCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cfop> rt = cq.from(Cfop.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

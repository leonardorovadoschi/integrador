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
import entidade.cplus.Cliente;
import entidade.cplus.Documento;
import entidade.cplus.Empresa;
import entidade.cplus.Formapag;
import entidade.cplus.Setorestoque;
import entidade.cplus.Tipomovimento;
import entidade.cplus.Transportadora;
import entidade.cplus.Usuario;
import entidade.cplus.Vendedor;
import entidade.cplus.Documentocfesatreferenciado;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Documentotransporte;
import entidade.cplus.Documentodocref;
import entidade.cplus.Mdfeletroniconf;
import entidade.cplus.Documentoentrega;
import entidade.cplus.Documentoentidade;
import entidade.cplus.Documentoitem;
import entidade.cplus.Documentopagamento;
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
public class DocumentoJpaController implements Serializable {

    public DocumentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Documento documento) throws PreexistingEntityException, Exception {
        if (documento.getDocumentocfesatreferenciadoCollection() == null) {
            documento.setDocumentocfesatreferenciadoCollection(new ArrayList<Documentocfesatreferenciado>());
        }
        if (documento.getDocumentotransporteCollection() == null) {
            documento.setDocumentotransporteCollection(new ArrayList<Documentotransporte>());
        }
        if (documento.getDocumentodocrefCollection() == null) {
            documento.setDocumentodocrefCollection(new ArrayList<Documentodocref>());
        }
        if (documento.getMdfeletroniconfCollection() == null) {
            documento.setMdfeletroniconfCollection(new ArrayList<Mdfeletroniconf>());
        }
        if (documento.getDocumentoentregaCollection() == null) {
            documento.setDocumentoentregaCollection(new ArrayList<Documentoentrega>());
        }
        if (documento.getDocumentoentidadeCollection() == null) {
            documento.setDocumentoentidadeCollection(new ArrayList<Documentoentidade>());
        }
        if (documento.getDocumentoitemCollection() == null) {
            documento.setDocumentoitemCollection(new ArrayList<Documentoitem>());
        }
        if (documento.getDocumentopagamentoCollection() == null) {
            documento.setDocumentopagamentoCollection(new ArrayList<Documentopagamento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cfop codcfop = documento.getCodcfop();
            if (codcfop != null) {
                codcfop = em.getReference(codcfop.getClass(), codcfop.getCodcfop());
                documento.setCodcfop(codcfop);
            }
            Cliente codcli = documento.getCodcli();
            if (codcli != null) {
                codcli = em.getReference(codcli.getClass(), codcli.getCodcli());
                documento.setCodcli(codcli);
            }
            Empresa codempresa = documento.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                documento.setCodempresa(codempresa);
            }
            Formapag codfp = documento.getCodfp();
            if (codfp != null) {
                codfp = em.getReference(codfp.getClass(), codfp.getCodfp());
                documento.setCodfp(codfp);
            }
            Setorestoque codsetorestoque = documento.getCodsetorestoque();
            if (codsetorestoque != null) {
                codsetorestoque = em.getReference(codsetorestoque.getClass(), codsetorestoque.getCodsetorestoque());
                documento.setCodsetorestoque(codsetorestoque);
            }
            Tipomovimento codtipomovimento = documento.getCodtipomovimento();
            if (codtipomovimento != null) {
                codtipomovimento = em.getReference(codtipomovimento.getClass(), codtipomovimento.getCodtipomovimento());
                documento.setCodtipomovimento(codtipomovimento);
            }
            Transportadora codtrans = documento.getCodtrans();
            if (codtrans != null) {
                codtrans = em.getReference(codtrans.getClass(), codtrans.getCodtrans());
                documento.setCodtrans(codtrans);
            }
            Usuario coduser = documento.getCoduser();
            if (coduser != null) {
                coduser = em.getReference(coduser.getClass(), coduser.getCoduser());
                documento.setCoduser(coduser);
            }
            Vendedor codvended = documento.getCodvended();
            if (codvended != null) {
                codvended = em.getReference(codvended.getClass(), codvended.getCodvended());
                documento.setCodvended(codvended);
            }
            Vendedor codvendedext = documento.getCodvendedext();
            if (codvendedext != null) {
                codvendedext = em.getReference(codvendedext.getClass(), codvendedext.getCodvended());
                documento.setCodvendedext(codvendedext);
            }
            Collection<Documentocfesatreferenciado> attachedDocumentocfesatreferenciadoCollection = new ArrayList<Documentocfesatreferenciado>();
            for (Documentocfesatreferenciado documentocfesatreferenciadoCollectionDocumentocfesatreferenciadoToAttach : documento.getDocumentocfesatreferenciadoCollection()) {
                documentocfesatreferenciadoCollectionDocumentocfesatreferenciadoToAttach = em.getReference(documentocfesatreferenciadoCollectionDocumentocfesatreferenciadoToAttach.getClass(), documentocfesatreferenciadoCollectionDocumentocfesatreferenciadoToAttach.getCoddocumentocfesatreferenciado());
                attachedDocumentocfesatreferenciadoCollection.add(documentocfesatreferenciadoCollectionDocumentocfesatreferenciadoToAttach);
            }
            documento.setDocumentocfesatreferenciadoCollection(attachedDocumentocfesatreferenciadoCollection);
            Collection<Documentotransporte> attachedDocumentotransporteCollection = new ArrayList<Documentotransporte>();
            for (Documentotransporte documentotransporteCollectionDocumentotransporteToAttach : documento.getDocumentotransporteCollection()) {
                documentotransporteCollectionDocumentotransporteToAttach = em.getReference(documentotransporteCollectionDocumentotransporteToAttach.getClass(), documentotransporteCollectionDocumentotransporteToAttach.getCoddocumentotransporte());
                attachedDocumentotransporteCollection.add(documentotransporteCollectionDocumentotransporteToAttach);
            }
            documento.setDocumentotransporteCollection(attachedDocumentotransporteCollection);
            Collection<Documentodocref> attachedDocumentodocrefCollection = new ArrayList<Documentodocref>();
            for (Documentodocref documentodocrefCollectionDocumentodocrefToAttach : documento.getDocumentodocrefCollection()) {
                documentodocrefCollectionDocumentodocrefToAttach = em.getReference(documentodocrefCollectionDocumentodocrefToAttach.getClass(), documentodocrefCollectionDocumentodocrefToAttach.getCoddocumentodocref());
                attachedDocumentodocrefCollection.add(documentodocrefCollectionDocumentodocrefToAttach);
            }
            documento.setDocumentodocrefCollection(attachedDocumentodocrefCollection);
            Collection<Mdfeletroniconf> attachedMdfeletroniconfCollection = new ArrayList<Mdfeletroniconf>();
            for (Mdfeletroniconf mdfeletroniconfCollectionMdfeletroniconfToAttach : documento.getMdfeletroniconfCollection()) {
                mdfeletroniconfCollectionMdfeletroniconfToAttach = em.getReference(mdfeletroniconfCollectionMdfeletroniconfToAttach.getClass(), mdfeletroniconfCollectionMdfeletroniconfToAttach.getCodmdfeletroniconf());
                attachedMdfeletroniconfCollection.add(mdfeletroniconfCollectionMdfeletroniconfToAttach);
            }
            documento.setMdfeletroniconfCollection(attachedMdfeletroniconfCollection);
            Collection<Documentoentrega> attachedDocumentoentregaCollection = new ArrayList<Documentoentrega>();
            for (Documentoentrega documentoentregaCollectionDocumentoentregaToAttach : documento.getDocumentoentregaCollection()) {
                documentoentregaCollectionDocumentoentregaToAttach = em.getReference(documentoentregaCollectionDocumentoentregaToAttach.getClass(), documentoentregaCollectionDocumentoentregaToAttach.getCoddocumentoentrega());
                attachedDocumentoentregaCollection.add(documentoentregaCollectionDocumentoentregaToAttach);
            }
            documento.setDocumentoentregaCollection(attachedDocumentoentregaCollection);
            Collection<Documentoentidade> attachedDocumentoentidadeCollection = new ArrayList<Documentoentidade>();
            for (Documentoentidade documentoentidadeCollectionDocumentoentidadeToAttach : documento.getDocumentoentidadeCollection()) {
                documentoentidadeCollectionDocumentoentidadeToAttach = em.getReference(documentoentidadeCollectionDocumentoentidadeToAttach.getClass(), documentoentidadeCollectionDocumentoentidadeToAttach.getCoddocumentoentidade());
                attachedDocumentoentidadeCollection.add(documentoentidadeCollectionDocumentoentidadeToAttach);
            }
            documento.setDocumentoentidadeCollection(attachedDocumentoentidadeCollection);
            Collection<Documentoitem> attachedDocumentoitemCollection = new ArrayList<Documentoitem>();
            for (Documentoitem documentoitemCollectionDocumentoitemToAttach : documento.getDocumentoitemCollection()) {
                documentoitemCollectionDocumentoitemToAttach = em.getReference(documentoitemCollectionDocumentoitemToAttach.getClass(), documentoitemCollectionDocumentoitemToAttach.getCoddocumentoitem());
                attachedDocumentoitemCollection.add(documentoitemCollectionDocumentoitemToAttach);
            }
            documento.setDocumentoitemCollection(attachedDocumentoitemCollection);
            Collection<Documentopagamento> attachedDocumentopagamentoCollection = new ArrayList<Documentopagamento>();
            for (Documentopagamento documentopagamentoCollectionDocumentopagamentoToAttach : documento.getDocumentopagamentoCollection()) {
                documentopagamentoCollectionDocumentopagamentoToAttach = em.getReference(documentopagamentoCollectionDocumentopagamentoToAttach.getClass(), documentopagamentoCollectionDocumentopagamentoToAttach.getCoddocumentopagamento());
                attachedDocumentopagamentoCollection.add(documentopagamentoCollectionDocumentopagamentoToAttach);
            }
            documento.setDocumentopagamentoCollection(attachedDocumentopagamentoCollection);
            em.persist(documento);
            if (codcfop != null) {
                codcfop.getDocumentoCollection().add(documento);
                codcfop = em.merge(codcfop);
            }
            if (codcli != null) {
                codcli.getDocumentoCollection().add(documento);
                codcli = em.merge(codcli);
            }
            if (codempresa != null) {
                codempresa.getDocumentoCollection().add(documento);
                codempresa = em.merge(codempresa);
            }
            if (codfp != null) {
                codfp.getDocumentoCollection().add(documento);
                codfp = em.merge(codfp);
            }
            if (codsetorestoque != null) {
                codsetorestoque.getDocumentoCollection().add(documento);
                codsetorestoque = em.merge(codsetorestoque);
            }
            if (codtipomovimento != null) {
                codtipomovimento.getDocumentoCollection().add(documento);
                codtipomovimento = em.merge(codtipomovimento);
            }
            if (codtrans != null) {
                codtrans.getDocumentoCollection().add(documento);
                codtrans = em.merge(codtrans);
            }
            if (coduser != null) {
                coduser.getDocumentoCollection().add(documento);
                coduser = em.merge(coduser);
            }
            if (codvended != null) {
                codvended.getDocumentoCollection().add(documento);
                codvended = em.merge(codvended);
            }
            if (codvendedext != null) {
                codvendedext.getDocumentoCollection().add(documento);
                codvendedext = em.merge(codvendedext);
            }
            for (Documentocfesatreferenciado documentocfesatreferenciadoCollectionDocumentocfesatreferenciado : documento.getDocumentocfesatreferenciadoCollection()) {
                Documento oldCoddocumentoOfDocumentocfesatreferenciadoCollectionDocumentocfesatreferenciado = documentocfesatreferenciadoCollectionDocumentocfesatreferenciado.getCoddocumento();
                documentocfesatreferenciadoCollectionDocumentocfesatreferenciado.setCoddocumento(documento);
                documentocfesatreferenciadoCollectionDocumentocfesatreferenciado = em.merge(documentocfesatreferenciadoCollectionDocumentocfesatreferenciado);
                if (oldCoddocumentoOfDocumentocfesatreferenciadoCollectionDocumentocfesatreferenciado != null) {
                    oldCoddocumentoOfDocumentocfesatreferenciadoCollectionDocumentocfesatreferenciado.getDocumentocfesatreferenciadoCollection().remove(documentocfesatreferenciadoCollectionDocumentocfesatreferenciado);
                    oldCoddocumentoOfDocumentocfesatreferenciadoCollectionDocumentocfesatreferenciado = em.merge(oldCoddocumentoOfDocumentocfesatreferenciadoCollectionDocumentocfesatreferenciado);
                }
            }
            for (Documentotransporte documentotransporteCollectionDocumentotransporte : documento.getDocumentotransporteCollection()) {
                Documento oldCoddocumentoOfDocumentotransporteCollectionDocumentotransporte = documentotransporteCollectionDocumentotransporte.getCoddocumento();
                documentotransporteCollectionDocumentotransporte.setCoddocumento(documento);
                documentotransporteCollectionDocumentotransporte = em.merge(documentotransporteCollectionDocumentotransporte);
                if (oldCoddocumentoOfDocumentotransporteCollectionDocumentotransporte != null) {
                    oldCoddocumentoOfDocumentotransporteCollectionDocumentotransporte.getDocumentotransporteCollection().remove(documentotransporteCollectionDocumentotransporte);
                    oldCoddocumentoOfDocumentotransporteCollectionDocumentotransporte = em.merge(oldCoddocumentoOfDocumentotransporteCollectionDocumentotransporte);
                }
            }
            for (Documentodocref documentodocrefCollectionDocumentodocref : documento.getDocumentodocrefCollection()) {
                Documento oldCoddocumentoOfDocumentodocrefCollectionDocumentodocref = documentodocrefCollectionDocumentodocref.getCoddocumento();
                documentodocrefCollectionDocumentodocref.setCoddocumento(documento);
                documentodocrefCollectionDocumentodocref = em.merge(documentodocrefCollectionDocumentodocref);
                if (oldCoddocumentoOfDocumentodocrefCollectionDocumentodocref != null) {
                    oldCoddocumentoOfDocumentodocrefCollectionDocumentodocref.getDocumentodocrefCollection().remove(documentodocrefCollectionDocumentodocref);
                    oldCoddocumentoOfDocumentodocrefCollectionDocumentodocref = em.merge(oldCoddocumentoOfDocumentodocrefCollectionDocumentodocref);
                }
            }
            for (Mdfeletroniconf mdfeletroniconfCollectionMdfeletroniconf : documento.getMdfeletroniconfCollection()) {
                Documento oldCoddocumentoOfMdfeletroniconfCollectionMdfeletroniconf = mdfeletroniconfCollectionMdfeletroniconf.getCoddocumento();
                mdfeletroniconfCollectionMdfeletroniconf.setCoddocumento(documento);
                mdfeletroniconfCollectionMdfeletroniconf = em.merge(mdfeletroniconfCollectionMdfeletroniconf);
                if (oldCoddocumentoOfMdfeletroniconfCollectionMdfeletroniconf != null) {
                    oldCoddocumentoOfMdfeletroniconfCollectionMdfeletroniconf.getMdfeletroniconfCollection().remove(mdfeletroniconfCollectionMdfeletroniconf);
                    oldCoddocumentoOfMdfeletroniconfCollectionMdfeletroniconf = em.merge(oldCoddocumentoOfMdfeletroniconfCollectionMdfeletroniconf);
                }
            }
            for (Documentoentrega documentoentregaCollectionDocumentoentrega : documento.getDocumentoentregaCollection()) {
                Documento oldCoddocumentoOfDocumentoentregaCollectionDocumentoentrega = documentoentregaCollectionDocumentoentrega.getCoddocumento();
                documentoentregaCollectionDocumentoentrega.setCoddocumento(documento);
                documentoentregaCollectionDocumentoentrega = em.merge(documentoentregaCollectionDocumentoentrega);
                if (oldCoddocumentoOfDocumentoentregaCollectionDocumentoentrega != null) {
                    oldCoddocumentoOfDocumentoentregaCollectionDocumentoentrega.getDocumentoentregaCollection().remove(documentoentregaCollectionDocumentoentrega);
                    oldCoddocumentoOfDocumentoentregaCollectionDocumentoentrega = em.merge(oldCoddocumentoOfDocumentoentregaCollectionDocumentoentrega);
                }
            }
            for (Documentoentidade documentoentidadeCollectionDocumentoentidade : documento.getDocumentoentidadeCollection()) {
                Documento oldCoddocumentoOfDocumentoentidadeCollectionDocumentoentidade = documentoentidadeCollectionDocumentoentidade.getCoddocumento();
                documentoentidadeCollectionDocumentoentidade.setCoddocumento(documento);
                documentoentidadeCollectionDocumentoentidade = em.merge(documentoentidadeCollectionDocumentoentidade);
                if (oldCoddocumentoOfDocumentoentidadeCollectionDocumentoentidade != null) {
                    oldCoddocumentoOfDocumentoentidadeCollectionDocumentoentidade.getDocumentoentidadeCollection().remove(documentoentidadeCollectionDocumentoentidade);
                    oldCoddocumentoOfDocumentoentidadeCollectionDocumentoentidade = em.merge(oldCoddocumentoOfDocumentoentidadeCollectionDocumentoentidade);
                }
            }
            for (Documentoitem documentoitemCollectionDocumentoitem : documento.getDocumentoitemCollection()) {
                Documento oldCoddocumentoOfDocumentoitemCollectionDocumentoitem = documentoitemCollectionDocumentoitem.getCoddocumento();
                documentoitemCollectionDocumentoitem.setCoddocumento(documento);
                documentoitemCollectionDocumentoitem = em.merge(documentoitemCollectionDocumentoitem);
                if (oldCoddocumentoOfDocumentoitemCollectionDocumentoitem != null) {
                    oldCoddocumentoOfDocumentoitemCollectionDocumentoitem.getDocumentoitemCollection().remove(documentoitemCollectionDocumentoitem);
                    oldCoddocumentoOfDocumentoitemCollectionDocumentoitem = em.merge(oldCoddocumentoOfDocumentoitemCollectionDocumentoitem);
                }
            }
            for (Documentopagamento documentopagamentoCollectionDocumentopagamento : documento.getDocumentopagamentoCollection()) {
                Documento oldCoddocumentoOfDocumentopagamentoCollectionDocumentopagamento = documentopagamentoCollectionDocumentopagamento.getCoddocumento();
                documentopagamentoCollectionDocumentopagamento.setCoddocumento(documento);
                documentopagamentoCollectionDocumentopagamento = em.merge(documentopagamentoCollectionDocumentopagamento);
                if (oldCoddocumentoOfDocumentopagamentoCollectionDocumentopagamento != null) {
                    oldCoddocumentoOfDocumentopagamentoCollectionDocumentopagamento.getDocumentopagamentoCollection().remove(documentopagamentoCollectionDocumentopagamento);
                    oldCoddocumentoOfDocumentopagamentoCollectionDocumentopagamento = em.merge(oldCoddocumentoOfDocumentopagamentoCollectionDocumentopagamento);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDocumento(documento.getCoddocumento()) != null) {
                throw new PreexistingEntityException("Documento " + documento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Documento documento) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Documento persistentDocumento = em.find(Documento.class, documento.getCoddocumento());
            Cfop codcfopOld = persistentDocumento.getCodcfop();
            Cfop codcfopNew = documento.getCodcfop();
            Cliente codcliOld = persistentDocumento.getCodcli();
            Cliente codcliNew = documento.getCodcli();
            Empresa codempresaOld = persistentDocumento.getCodempresa();
            Empresa codempresaNew = documento.getCodempresa();
            Formapag codfpOld = persistentDocumento.getCodfp();
            Formapag codfpNew = documento.getCodfp();
            Setorestoque codsetorestoqueOld = persistentDocumento.getCodsetorestoque();
            Setorestoque codsetorestoqueNew = documento.getCodsetorestoque();
            Tipomovimento codtipomovimentoOld = persistentDocumento.getCodtipomovimento();
            Tipomovimento codtipomovimentoNew = documento.getCodtipomovimento();
            Transportadora codtransOld = persistentDocumento.getCodtrans();
            Transportadora codtransNew = documento.getCodtrans();
            Usuario coduserOld = persistentDocumento.getCoduser();
            Usuario coduserNew = documento.getCoduser();
            Vendedor codvendedOld = persistentDocumento.getCodvended();
            Vendedor codvendedNew = documento.getCodvended();
            Vendedor codvendedextOld = persistentDocumento.getCodvendedext();
            Vendedor codvendedextNew = documento.getCodvendedext();
            Collection<Documentocfesatreferenciado> documentocfesatreferenciadoCollectionOld = persistentDocumento.getDocumentocfesatreferenciadoCollection();
            Collection<Documentocfesatreferenciado> documentocfesatreferenciadoCollectionNew = documento.getDocumentocfesatreferenciadoCollection();
            Collection<Documentotransporte> documentotransporteCollectionOld = persistentDocumento.getDocumentotransporteCollection();
            Collection<Documentotransporte> documentotransporteCollectionNew = documento.getDocumentotransporteCollection();
            Collection<Documentodocref> documentodocrefCollectionOld = persistentDocumento.getDocumentodocrefCollection();
            Collection<Documentodocref> documentodocrefCollectionNew = documento.getDocumentodocrefCollection();
            Collection<Mdfeletroniconf> mdfeletroniconfCollectionOld = persistentDocumento.getMdfeletroniconfCollection();
            Collection<Mdfeletroniconf> mdfeletroniconfCollectionNew = documento.getMdfeletroniconfCollection();
            Collection<Documentoentrega> documentoentregaCollectionOld = persistentDocumento.getDocumentoentregaCollection();
            Collection<Documentoentrega> documentoentregaCollectionNew = documento.getDocumentoentregaCollection();
            Collection<Documentoentidade> documentoentidadeCollectionOld = persistentDocumento.getDocumentoentidadeCollection();
            Collection<Documentoentidade> documentoentidadeCollectionNew = documento.getDocumentoentidadeCollection();
            Collection<Documentoitem> documentoitemCollectionOld = persistentDocumento.getDocumentoitemCollection();
            Collection<Documentoitem> documentoitemCollectionNew = documento.getDocumentoitemCollection();
            Collection<Documentopagamento> documentopagamentoCollectionOld = persistentDocumento.getDocumentopagamentoCollection();
            Collection<Documentopagamento> documentopagamentoCollectionNew = documento.getDocumentopagamentoCollection();
            List<String> illegalOrphanMessages = null;
            for (Documentocfesatreferenciado documentocfesatreferenciadoCollectionOldDocumentocfesatreferenciado : documentocfesatreferenciadoCollectionOld) {
                if (!documentocfesatreferenciadoCollectionNew.contains(documentocfesatreferenciadoCollectionOldDocumentocfesatreferenciado)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Documentocfesatreferenciado " + documentocfesatreferenciadoCollectionOldDocumentocfesatreferenciado + " since its coddocumento field is not nullable.");
                }
            }
            for (Documentodocref documentodocrefCollectionOldDocumentodocref : documentodocrefCollectionOld) {
                if (!documentodocrefCollectionNew.contains(documentodocrefCollectionOldDocumentodocref)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Documentodocref " + documentodocrefCollectionOldDocumentodocref + " since its coddocumento field is not nullable.");
                }
            }
            for (Documentoentrega documentoentregaCollectionOldDocumentoentrega : documentoentregaCollectionOld) {
                if (!documentoentregaCollectionNew.contains(documentoentregaCollectionOldDocumentoentrega)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Documentoentrega " + documentoentregaCollectionOldDocumentoentrega + " since its coddocumento field is not nullable.");
                }
            }
            for (Documentoentidade documentoentidadeCollectionOldDocumentoentidade : documentoentidadeCollectionOld) {
                if (!documentoentidadeCollectionNew.contains(documentoentidadeCollectionOldDocumentoentidade)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Documentoentidade " + documentoentidadeCollectionOldDocumentoentidade + " since its coddocumento field is not nullable.");
                }
            }
            for (Documentoitem documentoitemCollectionOldDocumentoitem : documentoitemCollectionOld) {
                if (!documentoitemCollectionNew.contains(documentoitemCollectionOldDocumentoitem)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Documentoitem " + documentoitemCollectionOldDocumentoitem + " since its coddocumento field is not nullable.");
                }
            }
            for (Documentopagamento documentopagamentoCollectionOldDocumentopagamento : documentopagamentoCollectionOld) {
                if (!documentopagamentoCollectionNew.contains(documentopagamentoCollectionOldDocumentopagamento)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Documentopagamento " + documentopagamentoCollectionOldDocumentopagamento + " since its coddocumento field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codcfopNew != null) {
                codcfopNew = em.getReference(codcfopNew.getClass(), codcfopNew.getCodcfop());
                documento.setCodcfop(codcfopNew);
            }
            if (codcliNew != null) {
                codcliNew = em.getReference(codcliNew.getClass(), codcliNew.getCodcli());
                documento.setCodcli(codcliNew);
            }
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                documento.setCodempresa(codempresaNew);
            }
            if (codfpNew != null) {
                codfpNew = em.getReference(codfpNew.getClass(), codfpNew.getCodfp());
                documento.setCodfp(codfpNew);
            }
            if (codsetorestoqueNew != null) {
                codsetorestoqueNew = em.getReference(codsetorestoqueNew.getClass(), codsetorestoqueNew.getCodsetorestoque());
                documento.setCodsetorestoque(codsetorestoqueNew);
            }
            if (codtipomovimentoNew != null) {
                codtipomovimentoNew = em.getReference(codtipomovimentoNew.getClass(), codtipomovimentoNew.getCodtipomovimento());
                documento.setCodtipomovimento(codtipomovimentoNew);
            }
            if (codtransNew != null) {
                codtransNew = em.getReference(codtransNew.getClass(), codtransNew.getCodtrans());
                documento.setCodtrans(codtransNew);
            }
            if (coduserNew != null) {
                coduserNew = em.getReference(coduserNew.getClass(), coduserNew.getCoduser());
                documento.setCoduser(coduserNew);
            }
            if (codvendedNew != null) {
                codvendedNew = em.getReference(codvendedNew.getClass(), codvendedNew.getCodvended());
                documento.setCodvended(codvendedNew);
            }
            if (codvendedextNew != null) {
                codvendedextNew = em.getReference(codvendedextNew.getClass(), codvendedextNew.getCodvended());
                documento.setCodvendedext(codvendedextNew);
            }
            Collection<Documentocfesatreferenciado> attachedDocumentocfesatreferenciadoCollectionNew = new ArrayList<Documentocfesatreferenciado>();
            for (Documentocfesatreferenciado documentocfesatreferenciadoCollectionNewDocumentocfesatreferenciadoToAttach : documentocfesatreferenciadoCollectionNew) {
                documentocfesatreferenciadoCollectionNewDocumentocfesatreferenciadoToAttach = em.getReference(documentocfesatreferenciadoCollectionNewDocumentocfesatreferenciadoToAttach.getClass(), documentocfesatreferenciadoCollectionNewDocumentocfesatreferenciadoToAttach.getCoddocumentocfesatreferenciado());
                attachedDocumentocfesatreferenciadoCollectionNew.add(documentocfesatreferenciadoCollectionNewDocumentocfesatreferenciadoToAttach);
            }
            documentocfesatreferenciadoCollectionNew = attachedDocumentocfesatreferenciadoCollectionNew;
            documento.setDocumentocfesatreferenciadoCollection(documentocfesatreferenciadoCollectionNew);
            Collection<Documentotransporte> attachedDocumentotransporteCollectionNew = new ArrayList<Documentotransporte>();
            for (Documentotransporte documentotransporteCollectionNewDocumentotransporteToAttach : documentotransporteCollectionNew) {
                documentotransporteCollectionNewDocumentotransporteToAttach = em.getReference(documentotransporteCollectionNewDocumentotransporteToAttach.getClass(), documentotransporteCollectionNewDocumentotransporteToAttach.getCoddocumentotransporte());
                attachedDocumentotransporteCollectionNew.add(documentotransporteCollectionNewDocumentotransporteToAttach);
            }
            documentotransporteCollectionNew = attachedDocumentotransporteCollectionNew;
            documento.setDocumentotransporteCollection(documentotransporteCollectionNew);
            Collection<Documentodocref> attachedDocumentodocrefCollectionNew = new ArrayList<Documentodocref>();
            for (Documentodocref documentodocrefCollectionNewDocumentodocrefToAttach : documentodocrefCollectionNew) {
                documentodocrefCollectionNewDocumentodocrefToAttach = em.getReference(documentodocrefCollectionNewDocumentodocrefToAttach.getClass(), documentodocrefCollectionNewDocumentodocrefToAttach.getCoddocumentodocref());
                attachedDocumentodocrefCollectionNew.add(documentodocrefCollectionNewDocumentodocrefToAttach);
            }
            documentodocrefCollectionNew = attachedDocumentodocrefCollectionNew;
            documento.setDocumentodocrefCollection(documentodocrefCollectionNew);
            Collection<Mdfeletroniconf> attachedMdfeletroniconfCollectionNew = new ArrayList<Mdfeletroniconf>();
            for (Mdfeletroniconf mdfeletroniconfCollectionNewMdfeletroniconfToAttach : mdfeletroniconfCollectionNew) {
                mdfeletroniconfCollectionNewMdfeletroniconfToAttach = em.getReference(mdfeletroniconfCollectionNewMdfeletroniconfToAttach.getClass(), mdfeletroniconfCollectionNewMdfeletroniconfToAttach.getCodmdfeletroniconf());
                attachedMdfeletroniconfCollectionNew.add(mdfeletroniconfCollectionNewMdfeletroniconfToAttach);
            }
            mdfeletroniconfCollectionNew = attachedMdfeletroniconfCollectionNew;
            documento.setMdfeletroniconfCollection(mdfeletroniconfCollectionNew);
            Collection<Documentoentrega> attachedDocumentoentregaCollectionNew = new ArrayList<Documentoentrega>();
            for (Documentoentrega documentoentregaCollectionNewDocumentoentregaToAttach : documentoentregaCollectionNew) {
                documentoentregaCollectionNewDocumentoentregaToAttach = em.getReference(documentoentregaCollectionNewDocumentoentregaToAttach.getClass(), documentoentregaCollectionNewDocumentoentregaToAttach.getCoddocumentoentrega());
                attachedDocumentoentregaCollectionNew.add(documentoentregaCollectionNewDocumentoentregaToAttach);
            }
            documentoentregaCollectionNew = attachedDocumentoentregaCollectionNew;
            documento.setDocumentoentregaCollection(documentoentregaCollectionNew);
            Collection<Documentoentidade> attachedDocumentoentidadeCollectionNew = new ArrayList<Documentoentidade>();
            for (Documentoentidade documentoentidadeCollectionNewDocumentoentidadeToAttach : documentoentidadeCollectionNew) {
                documentoentidadeCollectionNewDocumentoentidadeToAttach = em.getReference(documentoentidadeCollectionNewDocumentoentidadeToAttach.getClass(), documentoentidadeCollectionNewDocumentoentidadeToAttach.getCoddocumentoentidade());
                attachedDocumentoentidadeCollectionNew.add(documentoentidadeCollectionNewDocumentoentidadeToAttach);
            }
            documentoentidadeCollectionNew = attachedDocumentoentidadeCollectionNew;
            documento.setDocumentoentidadeCollection(documentoentidadeCollectionNew);
            Collection<Documentoitem> attachedDocumentoitemCollectionNew = new ArrayList<Documentoitem>();
            for (Documentoitem documentoitemCollectionNewDocumentoitemToAttach : documentoitemCollectionNew) {
                documentoitemCollectionNewDocumentoitemToAttach = em.getReference(documentoitemCollectionNewDocumentoitemToAttach.getClass(), documentoitemCollectionNewDocumentoitemToAttach.getCoddocumentoitem());
                attachedDocumentoitemCollectionNew.add(documentoitemCollectionNewDocumentoitemToAttach);
            }
            documentoitemCollectionNew = attachedDocumentoitemCollectionNew;
            documento.setDocumentoitemCollection(documentoitemCollectionNew);
            Collection<Documentopagamento> attachedDocumentopagamentoCollectionNew = new ArrayList<Documentopagamento>();
            for (Documentopagamento documentopagamentoCollectionNewDocumentopagamentoToAttach : documentopagamentoCollectionNew) {
                documentopagamentoCollectionNewDocumentopagamentoToAttach = em.getReference(documentopagamentoCollectionNewDocumentopagamentoToAttach.getClass(), documentopagamentoCollectionNewDocumentopagamentoToAttach.getCoddocumentopagamento());
                attachedDocumentopagamentoCollectionNew.add(documentopagamentoCollectionNewDocumentopagamentoToAttach);
            }
            documentopagamentoCollectionNew = attachedDocumentopagamentoCollectionNew;
            documento.setDocumentopagamentoCollection(documentopagamentoCollectionNew);
            documento = em.merge(documento);
            if (codcfopOld != null && !codcfopOld.equals(codcfopNew)) {
                codcfopOld.getDocumentoCollection().remove(documento);
                codcfopOld = em.merge(codcfopOld);
            }
            if (codcfopNew != null && !codcfopNew.equals(codcfopOld)) {
                codcfopNew.getDocumentoCollection().add(documento);
                codcfopNew = em.merge(codcfopNew);
            }
            if (codcliOld != null && !codcliOld.equals(codcliNew)) {
                codcliOld.getDocumentoCollection().remove(documento);
                codcliOld = em.merge(codcliOld);
            }
            if (codcliNew != null && !codcliNew.equals(codcliOld)) {
                codcliNew.getDocumentoCollection().add(documento);
                codcliNew = em.merge(codcliNew);
            }
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getDocumentoCollection().remove(documento);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getDocumentoCollection().add(documento);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codfpOld != null && !codfpOld.equals(codfpNew)) {
                codfpOld.getDocumentoCollection().remove(documento);
                codfpOld = em.merge(codfpOld);
            }
            if (codfpNew != null && !codfpNew.equals(codfpOld)) {
                codfpNew.getDocumentoCollection().add(documento);
                codfpNew = em.merge(codfpNew);
            }
            if (codsetorestoqueOld != null && !codsetorestoqueOld.equals(codsetorestoqueNew)) {
                codsetorestoqueOld.getDocumentoCollection().remove(documento);
                codsetorestoqueOld = em.merge(codsetorestoqueOld);
            }
            if (codsetorestoqueNew != null && !codsetorestoqueNew.equals(codsetorestoqueOld)) {
                codsetorestoqueNew.getDocumentoCollection().add(documento);
                codsetorestoqueNew = em.merge(codsetorestoqueNew);
            }
            if (codtipomovimentoOld != null && !codtipomovimentoOld.equals(codtipomovimentoNew)) {
                codtipomovimentoOld.getDocumentoCollection().remove(documento);
                codtipomovimentoOld = em.merge(codtipomovimentoOld);
            }
            if (codtipomovimentoNew != null && !codtipomovimentoNew.equals(codtipomovimentoOld)) {
                codtipomovimentoNew.getDocumentoCollection().add(documento);
                codtipomovimentoNew = em.merge(codtipomovimentoNew);
            }
            if (codtransOld != null && !codtransOld.equals(codtransNew)) {
                codtransOld.getDocumentoCollection().remove(documento);
                codtransOld = em.merge(codtransOld);
            }
            if (codtransNew != null && !codtransNew.equals(codtransOld)) {
                codtransNew.getDocumentoCollection().add(documento);
                codtransNew = em.merge(codtransNew);
            }
            if (coduserOld != null && !coduserOld.equals(coduserNew)) {
                coduserOld.getDocumentoCollection().remove(documento);
                coduserOld = em.merge(coduserOld);
            }
            if (coduserNew != null && !coduserNew.equals(coduserOld)) {
                coduserNew.getDocumentoCollection().add(documento);
                coduserNew = em.merge(coduserNew);
            }
            if (codvendedOld != null && !codvendedOld.equals(codvendedNew)) {
                codvendedOld.getDocumentoCollection().remove(documento);
                codvendedOld = em.merge(codvendedOld);
            }
            if (codvendedNew != null && !codvendedNew.equals(codvendedOld)) {
                codvendedNew.getDocumentoCollection().add(documento);
                codvendedNew = em.merge(codvendedNew);
            }
            if (codvendedextOld != null && !codvendedextOld.equals(codvendedextNew)) {
                codvendedextOld.getDocumentoCollection().remove(documento);
                codvendedextOld = em.merge(codvendedextOld);
            }
            if (codvendedextNew != null && !codvendedextNew.equals(codvendedextOld)) {
                codvendedextNew.getDocumentoCollection().add(documento);
                codvendedextNew = em.merge(codvendedextNew);
            }
            for (Documentocfesatreferenciado documentocfesatreferenciadoCollectionNewDocumentocfesatreferenciado : documentocfesatreferenciadoCollectionNew) {
                if (!documentocfesatreferenciadoCollectionOld.contains(documentocfesatreferenciadoCollectionNewDocumentocfesatreferenciado)) {
                    Documento oldCoddocumentoOfDocumentocfesatreferenciadoCollectionNewDocumentocfesatreferenciado = documentocfesatreferenciadoCollectionNewDocumentocfesatreferenciado.getCoddocumento();
                    documentocfesatreferenciadoCollectionNewDocumentocfesatreferenciado.setCoddocumento(documento);
                    documentocfesatreferenciadoCollectionNewDocumentocfesatreferenciado = em.merge(documentocfesatreferenciadoCollectionNewDocumentocfesatreferenciado);
                    if (oldCoddocumentoOfDocumentocfesatreferenciadoCollectionNewDocumentocfesatreferenciado != null && !oldCoddocumentoOfDocumentocfesatreferenciadoCollectionNewDocumentocfesatreferenciado.equals(documento)) {
                        oldCoddocumentoOfDocumentocfesatreferenciadoCollectionNewDocumentocfesatreferenciado.getDocumentocfesatreferenciadoCollection().remove(documentocfesatreferenciadoCollectionNewDocumentocfesatreferenciado);
                        oldCoddocumentoOfDocumentocfesatreferenciadoCollectionNewDocumentocfesatreferenciado = em.merge(oldCoddocumentoOfDocumentocfesatreferenciadoCollectionNewDocumentocfesatreferenciado);
                    }
                }
            }
            for (Documentotransporte documentotransporteCollectionOldDocumentotransporte : documentotransporteCollectionOld) {
                if (!documentotransporteCollectionNew.contains(documentotransporteCollectionOldDocumentotransporte)) {
                    documentotransporteCollectionOldDocumentotransporte.setCoddocumento(null);
                    documentotransporteCollectionOldDocumentotransporte = em.merge(documentotransporteCollectionOldDocumentotransporte);
                }
            }
            for (Documentotransporte documentotransporteCollectionNewDocumentotransporte : documentotransporteCollectionNew) {
                if (!documentotransporteCollectionOld.contains(documentotransporteCollectionNewDocumentotransporte)) {
                    Documento oldCoddocumentoOfDocumentotransporteCollectionNewDocumentotransporte = documentotransporteCollectionNewDocumentotransporte.getCoddocumento();
                    documentotransporteCollectionNewDocumentotransporte.setCoddocumento(documento);
                    documentotransporteCollectionNewDocumentotransporte = em.merge(documentotransporteCollectionNewDocumentotransporte);
                    if (oldCoddocumentoOfDocumentotransporteCollectionNewDocumentotransporte != null && !oldCoddocumentoOfDocumentotransporteCollectionNewDocumentotransporte.equals(documento)) {
                        oldCoddocumentoOfDocumentotransporteCollectionNewDocumentotransporte.getDocumentotransporteCollection().remove(documentotransporteCollectionNewDocumentotransporte);
                        oldCoddocumentoOfDocumentotransporteCollectionNewDocumentotransporte = em.merge(oldCoddocumentoOfDocumentotransporteCollectionNewDocumentotransporte);
                    }
                }
            }
            for (Documentodocref documentodocrefCollectionNewDocumentodocref : documentodocrefCollectionNew) {
                if (!documentodocrefCollectionOld.contains(documentodocrefCollectionNewDocumentodocref)) {
                    Documento oldCoddocumentoOfDocumentodocrefCollectionNewDocumentodocref = documentodocrefCollectionNewDocumentodocref.getCoddocumento();
                    documentodocrefCollectionNewDocumentodocref.setCoddocumento(documento);
                    documentodocrefCollectionNewDocumentodocref = em.merge(documentodocrefCollectionNewDocumentodocref);
                    if (oldCoddocumentoOfDocumentodocrefCollectionNewDocumentodocref != null && !oldCoddocumentoOfDocumentodocrefCollectionNewDocumentodocref.equals(documento)) {
                        oldCoddocumentoOfDocumentodocrefCollectionNewDocumentodocref.getDocumentodocrefCollection().remove(documentodocrefCollectionNewDocumentodocref);
                        oldCoddocumentoOfDocumentodocrefCollectionNewDocumentodocref = em.merge(oldCoddocumentoOfDocumentodocrefCollectionNewDocumentodocref);
                    }
                }
            }
            for (Mdfeletroniconf mdfeletroniconfCollectionOldMdfeletroniconf : mdfeletroniconfCollectionOld) {
                if (!mdfeletroniconfCollectionNew.contains(mdfeletroniconfCollectionOldMdfeletroniconf)) {
                    mdfeletroniconfCollectionOldMdfeletroniconf.setCoddocumento(null);
                    mdfeletroniconfCollectionOldMdfeletroniconf = em.merge(mdfeletroniconfCollectionOldMdfeletroniconf);
                }
            }
            for (Mdfeletroniconf mdfeletroniconfCollectionNewMdfeletroniconf : mdfeletroniconfCollectionNew) {
                if (!mdfeletroniconfCollectionOld.contains(mdfeletroniconfCollectionNewMdfeletroniconf)) {
                    Documento oldCoddocumentoOfMdfeletroniconfCollectionNewMdfeletroniconf = mdfeletroniconfCollectionNewMdfeletroniconf.getCoddocumento();
                    mdfeletroniconfCollectionNewMdfeletroniconf.setCoddocumento(documento);
                    mdfeletroniconfCollectionNewMdfeletroniconf = em.merge(mdfeletroniconfCollectionNewMdfeletroniconf);
                    if (oldCoddocumentoOfMdfeletroniconfCollectionNewMdfeletroniconf != null && !oldCoddocumentoOfMdfeletroniconfCollectionNewMdfeletroniconf.equals(documento)) {
                        oldCoddocumentoOfMdfeletroniconfCollectionNewMdfeletroniconf.getMdfeletroniconfCollection().remove(mdfeletroniconfCollectionNewMdfeletroniconf);
                        oldCoddocumentoOfMdfeletroniconfCollectionNewMdfeletroniconf = em.merge(oldCoddocumentoOfMdfeletroniconfCollectionNewMdfeletroniconf);
                    }
                }
            }
            for (Documentoentrega documentoentregaCollectionNewDocumentoentrega : documentoentregaCollectionNew) {
                if (!documentoentregaCollectionOld.contains(documentoentregaCollectionNewDocumentoentrega)) {
                    Documento oldCoddocumentoOfDocumentoentregaCollectionNewDocumentoentrega = documentoentregaCollectionNewDocumentoentrega.getCoddocumento();
                    documentoentregaCollectionNewDocumentoentrega.setCoddocumento(documento);
                    documentoentregaCollectionNewDocumentoentrega = em.merge(documentoentregaCollectionNewDocumentoentrega);
                    if (oldCoddocumentoOfDocumentoentregaCollectionNewDocumentoentrega != null && !oldCoddocumentoOfDocumentoentregaCollectionNewDocumentoentrega.equals(documento)) {
                        oldCoddocumentoOfDocumentoentregaCollectionNewDocumentoentrega.getDocumentoentregaCollection().remove(documentoentregaCollectionNewDocumentoentrega);
                        oldCoddocumentoOfDocumentoentregaCollectionNewDocumentoentrega = em.merge(oldCoddocumentoOfDocumentoentregaCollectionNewDocumentoentrega);
                    }
                }
            }
            for (Documentoentidade documentoentidadeCollectionNewDocumentoentidade : documentoentidadeCollectionNew) {
                if (!documentoentidadeCollectionOld.contains(documentoentidadeCollectionNewDocumentoentidade)) {
                    Documento oldCoddocumentoOfDocumentoentidadeCollectionNewDocumentoentidade = documentoentidadeCollectionNewDocumentoentidade.getCoddocumento();
                    documentoentidadeCollectionNewDocumentoentidade.setCoddocumento(documento);
                    documentoentidadeCollectionNewDocumentoentidade = em.merge(documentoentidadeCollectionNewDocumentoentidade);
                    if (oldCoddocumentoOfDocumentoentidadeCollectionNewDocumentoentidade != null && !oldCoddocumentoOfDocumentoentidadeCollectionNewDocumentoentidade.equals(documento)) {
                        oldCoddocumentoOfDocumentoentidadeCollectionNewDocumentoentidade.getDocumentoentidadeCollection().remove(documentoentidadeCollectionNewDocumentoentidade);
                        oldCoddocumentoOfDocumentoentidadeCollectionNewDocumentoentidade = em.merge(oldCoddocumentoOfDocumentoentidadeCollectionNewDocumentoentidade);
                    }
                }
            }
            for (Documentoitem documentoitemCollectionNewDocumentoitem : documentoitemCollectionNew) {
                if (!documentoitemCollectionOld.contains(documentoitemCollectionNewDocumentoitem)) {
                    Documento oldCoddocumentoOfDocumentoitemCollectionNewDocumentoitem = documentoitemCollectionNewDocumentoitem.getCoddocumento();
                    documentoitemCollectionNewDocumentoitem.setCoddocumento(documento);
                    documentoitemCollectionNewDocumentoitem = em.merge(documentoitemCollectionNewDocumentoitem);
                    if (oldCoddocumentoOfDocumentoitemCollectionNewDocumentoitem != null && !oldCoddocumentoOfDocumentoitemCollectionNewDocumentoitem.equals(documento)) {
                        oldCoddocumentoOfDocumentoitemCollectionNewDocumentoitem.getDocumentoitemCollection().remove(documentoitemCollectionNewDocumentoitem);
                        oldCoddocumentoOfDocumentoitemCollectionNewDocumentoitem = em.merge(oldCoddocumentoOfDocumentoitemCollectionNewDocumentoitem);
                    }
                }
            }
            for (Documentopagamento documentopagamentoCollectionNewDocumentopagamento : documentopagamentoCollectionNew) {
                if (!documentopagamentoCollectionOld.contains(documentopagamentoCollectionNewDocumentopagamento)) {
                    Documento oldCoddocumentoOfDocumentopagamentoCollectionNewDocumentopagamento = documentopagamentoCollectionNewDocumentopagamento.getCoddocumento();
                    documentopagamentoCollectionNewDocumentopagamento.setCoddocumento(documento);
                    documentopagamentoCollectionNewDocumentopagamento = em.merge(documentopagamentoCollectionNewDocumentopagamento);
                    if (oldCoddocumentoOfDocumentopagamentoCollectionNewDocumentopagamento != null && !oldCoddocumentoOfDocumentopagamentoCollectionNewDocumentopagamento.equals(documento)) {
                        oldCoddocumentoOfDocumentopagamentoCollectionNewDocumentopagamento.getDocumentopagamentoCollection().remove(documentopagamentoCollectionNewDocumentopagamento);
                        oldCoddocumentoOfDocumentopagamentoCollectionNewDocumentopagamento = em.merge(oldCoddocumentoOfDocumentopagamentoCollectionNewDocumentopagamento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = documento.getCoddocumento();
                if (findDocumento(id) == null) {
                    throw new NonexistentEntityException("The documento with id " + id + " no longer exists.");
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
            Documento documento;
            try {
                documento = em.getReference(Documento.class, id);
                documento.getCoddocumento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The documento with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Documentocfesatreferenciado> documentocfesatreferenciadoCollectionOrphanCheck = documento.getDocumentocfesatreferenciadoCollection();
            for (Documentocfesatreferenciado documentocfesatreferenciadoCollectionOrphanCheckDocumentocfesatreferenciado : documentocfesatreferenciadoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Documento (" + documento + ") cannot be destroyed since the Documentocfesatreferenciado " + documentocfesatreferenciadoCollectionOrphanCheckDocumentocfesatreferenciado + " in its documentocfesatreferenciadoCollection field has a non-nullable coddocumento field.");
            }
            Collection<Documentodocref> documentodocrefCollectionOrphanCheck = documento.getDocumentodocrefCollection();
            for (Documentodocref documentodocrefCollectionOrphanCheckDocumentodocref : documentodocrefCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Documento (" + documento + ") cannot be destroyed since the Documentodocref " + documentodocrefCollectionOrphanCheckDocumentodocref + " in its documentodocrefCollection field has a non-nullable coddocumento field.");
            }
            Collection<Documentoentrega> documentoentregaCollectionOrphanCheck = documento.getDocumentoentregaCollection();
            for (Documentoentrega documentoentregaCollectionOrphanCheckDocumentoentrega : documentoentregaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Documento (" + documento + ") cannot be destroyed since the Documentoentrega " + documentoentregaCollectionOrphanCheckDocumentoentrega + " in its documentoentregaCollection field has a non-nullable coddocumento field.");
            }
            Collection<Documentoentidade> documentoentidadeCollectionOrphanCheck = documento.getDocumentoentidadeCollection();
            for (Documentoentidade documentoentidadeCollectionOrphanCheckDocumentoentidade : documentoentidadeCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Documento (" + documento + ") cannot be destroyed since the Documentoentidade " + documentoentidadeCollectionOrphanCheckDocumentoentidade + " in its documentoentidadeCollection field has a non-nullable coddocumento field.");
            }
            Collection<Documentoitem> documentoitemCollectionOrphanCheck = documento.getDocumentoitemCollection();
            for (Documentoitem documentoitemCollectionOrphanCheckDocumentoitem : documentoitemCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Documento (" + documento + ") cannot be destroyed since the Documentoitem " + documentoitemCollectionOrphanCheckDocumentoitem + " in its documentoitemCollection field has a non-nullable coddocumento field.");
            }
            Collection<Documentopagamento> documentopagamentoCollectionOrphanCheck = documento.getDocumentopagamentoCollection();
            for (Documentopagamento documentopagamentoCollectionOrphanCheckDocumentopagamento : documentopagamentoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Documento (" + documento + ") cannot be destroyed since the Documentopagamento " + documentopagamentoCollectionOrphanCheckDocumentopagamento + " in its documentopagamentoCollection field has a non-nullable coddocumento field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cfop codcfop = documento.getCodcfop();
            if (codcfop != null) {
                codcfop.getDocumentoCollection().remove(documento);
                codcfop = em.merge(codcfop);
            }
            Cliente codcli = documento.getCodcli();
            if (codcli != null) {
                codcli.getDocumentoCollection().remove(documento);
                codcli = em.merge(codcli);
            }
            Empresa codempresa = documento.getCodempresa();
            if (codempresa != null) {
                codempresa.getDocumentoCollection().remove(documento);
                codempresa = em.merge(codempresa);
            }
            Formapag codfp = documento.getCodfp();
            if (codfp != null) {
                codfp.getDocumentoCollection().remove(documento);
                codfp = em.merge(codfp);
            }
            Setorestoque codsetorestoque = documento.getCodsetorestoque();
            if (codsetorestoque != null) {
                codsetorestoque.getDocumentoCollection().remove(documento);
                codsetorestoque = em.merge(codsetorestoque);
            }
            Tipomovimento codtipomovimento = documento.getCodtipomovimento();
            if (codtipomovimento != null) {
                codtipomovimento.getDocumentoCollection().remove(documento);
                codtipomovimento = em.merge(codtipomovimento);
            }
            Transportadora codtrans = documento.getCodtrans();
            if (codtrans != null) {
                codtrans.getDocumentoCollection().remove(documento);
                codtrans = em.merge(codtrans);
            }
            Usuario coduser = documento.getCoduser();
            if (coduser != null) {
                coduser.getDocumentoCollection().remove(documento);
                coduser = em.merge(coduser);
            }
            Vendedor codvended = documento.getCodvended();
            if (codvended != null) {
                codvended.getDocumentoCollection().remove(documento);
                codvended = em.merge(codvended);
            }
            Vendedor codvendedext = documento.getCodvendedext();
            if (codvendedext != null) {
                codvendedext.getDocumentoCollection().remove(documento);
                codvendedext = em.merge(codvendedext);
            }
            Collection<Documentotransporte> documentotransporteCollection = documento.getDocumentotransporteCollection();
            for (Documentotransporte documentotransporteCollectionDocumentotransporte : documentotransporteCollection) {
                documentotransporteCollectionDocumentotransporte.setCoddocumento(null);
                documentotransporteCollectionDocumentotransporte = em.merge(documentotransporteCollectionDocumentotransporte);
            }
            Collection<Mdfeletroniconf> mdfeletroniconfCollection = documento.getMdfeletroniconfCollection();
            for (Mdfeletroniconf mdfeletroniconfCollectionMdfeletroniconf : mdfeletroniconfCollection) {
                mdfeletroniconfCollectionMdfeletroniconf.setCoddocumento(null);
                mdfeletroniconfCollectionMdfeletroniconf = em.merge(mdfeletroniconfCollectionMdfeletroniconf);
            }
            em.remove(documento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Documento> findDocumentoEntities() {
        return findDocumentoEntities(true, -1, -1);
    }

    public List<Documento> findDocumentoEntities(int maxResults, int firstResult) {
        return findDocumentoEntities(false, maxResults, firstResult);
    }

    private List<Documento> findDocumentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Documento.class));
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

    public Documento findDocumento(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Documento.class, id);
        } finally {
            em.close();
        }
    }

    public int getDocumentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Documento> rt = cq.from(Documento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

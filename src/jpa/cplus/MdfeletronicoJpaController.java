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
import entidade.cplus.Empresatipodocumento;
import entidade.cplus.Mdfeletronico;
import entidade.cplus.Uf;
import entidade.cplus.Mdfeletronicocargaposterior;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Mdfeletronicoveiculo;
import entidade.cplus.Mdfeletronicolocal;
import entidade.cplus.Mdfeletronicoevento;
import entidade.cplus.Mdfeletronicopercurso;
import entidade.cplus.Mdfeletroniconf;
import entidade.cplus.Mdfeletronicocondutor;
import entidade.cplus.Mdfeletronicolacre;
import entidade.cplus.Mdfeletronicoautorizadoxml;
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
public class MdfeletronicoJpaController implements Serializable {

    public MdfeletronicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mdfeletronico mdfeletronico) throws PreexistingEntityException, Exception {
        if (mdfeletronico.getMdfeletronicocargaposteriorCollection() == null) {
            mdfeletronico.setMdfeletronicocargaposteriorCollection(new ArrayList<Mdfeletronicocargaposterior>());
        }
        if (mdfeletronico.getMdfeletronicoveiculoCollection() == null) {
            mdfeletronico.setMdfeletronicoveiculoCollection(new ArrayList<Mdfeletronicoveiculo>());
        }
        if (mdfeletronico.getMdfeletronicolocalCollection() == null) {
            mdfeletronico.setMdfeletronicolocalCollection(new ArrayList<Mdfeletronicolocal>());
        }
        if (mdfeletronico.getMdfeletronicoeventoCollection() == null) {
            mdfeletronico.setMdfeletronicoeventoCollection(new ArrayList<Mdfeletronicoevento>());
        }
        if (mdfeletronico.getMdfeletronicopercursoCollection() == null) {
            mdfeletronico.setMdfeletronicopercursoCollection(new ArrayList<Mdfeletronicopercurso>());
        }
        if (mdfeletronico.getMdfeletroniconfCollection() == null) {
            mdfeletronico.setMdfeletroniconfCollection(new ArrayList<Mdfeletroniconf>());
        }
        if (mdfeletronico.getMdfeletronicocondutorCollection() == null) {
            mdfeletronico.setMdfeletronicocondutorCollection(new ArrayList<Mdfeletronicocondutor>());
        }
        if (mdfeletronico.getMdfeletronicolacreCollection() == null) {
            mdfeletronico.setMdfeletronicolacreCollection(new ArrayList<Mdfeletronicolacre>());
        }
        if (mdfeletronico.getMdfeletronicoautorizadoxmlCollection() == null) {
            mdfeletronico.setMdfeletronicoautorizadoxmlCollection(new ArrayList<Mdfeletronicoautorizadoxml>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa codempresa = mdfeletronico.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                mdfeletronico.setCodempresa(codempresa);
            }
            Empresatipodocumento codempresatipodocumento = mdfeletronico.getCodempresatipodocumento();
            if (codempresatipodocumento != null) {
                codempresatipodocumento = em.getReference(codempresatipodocumento.getClass(), codempresatipodocumento.getCodempresatipodocumento());
                mdfeletronico.setCodempresatipodocumento(codempresatipodocumento);
            }
            Uf coduffim = mdfeletronico.getCoduffim();
            if (coduffim != null) {
                coduffim = em.getReference(coduffim.getClass(), coduffim.getCoduf());
                mdfeletronico.setCoduffim(coduffim);
            }
            Uf codufinicio = mdfeletronico.getCodufinicio();
            if (codufinicio != null) {
                codufinicio = em.getReference(codufinicio.getClass(), codufinicio.getCoduf());
                mdfeletronico.setCodufinicio(codufinicio);
            }
            Collection<Mdfeletronicocargaposterior> attachedMdfeletronicocargaposteriorCollection = new ArrayList<Mdfeletronicocargaposterior>();
            for (Mdfeletronicocargaposterior mdfeletronicocargaposteriorCollectionMdfeletronicocargaposteriorToAttach : mdfeletronico.getMdfeletronicocargaposteriorCollection()) {
                mdfeletronicocargaposteriorCollectionMdfeletronicocargaposteriorToAttach = em.getReference(mdfeletronicocargaposteriorCollectionMdfeletronicocargaposteriorToAttach.getClass(), mdfeletronicocargaposteriorCollectionMdfeletronicocargaposteriorToAttach.getCodmdfeletronicocargaposterior());
                attachedMdfeletronicocargaposteriorCollection.add(mdfeletronicocargaposteriorCollectionMdfeletronicocargaposteriorToAttach);
            }
            mdfeletronico.setMdfeletronicocargaposteriorCollection(attachedMdfeletronicocargaposteriorCollection);
            Collection<Mdfeletronicoveiculo> attachedMdfeletronicoveiculoCollection = new ArrayList<Mdfeletronicoveiculo>();
            for (Mdfeletronicoveiculo mdfeletronicoveiculoCollectionMdfeletronicoveiculoToAttach : mdfeletronico.getMdfeletronicoveiculoCollection()) {
                mdfeletronicoveiculoCollectionMdfeletronicoveiculoToAttach = em.getReference(mdfeletronicoveiculoCollectionMdfeletronicoveiculoToAttach.getClass(), mdfeletronicoveiculoCollectionMdfeletronicoveiculoToAttach.getCodmdfeletronicoveiculo());
                attachedMdfeletronicoveiculoCollection.add(mdfeletronicoveiculoCollectionMdfeletronicoveiculoToAttach);
            }
            mdfeletronico.setMdfeletronicoveiculoCollection(attachedMdfeletronicoveiculoCollection);
            Collection<Mdfeletronicolocal> attachedMdfeletronicolocalCollection = new ArrayList<Mdfeletronicolocal>();
            for (Mdfeletronicolocal mdfeletronicolocalCollectionMdfeletronicolocalToAttach : mdfeletronico.getMdfeletronicolocalCollection()) {
                mdfeletronicolocalCollectionMdfeletronicolocalToAttach = em.getReference(mdfeletronicolocalCollectionMdfeletronicolocalToAttach.getClass(), mdfeletronicolocalCollectionMdfeletronicolocalToAttach.getCodmdfeletronicolocal());
                attachedMdfeletronicolocalCollection.add(mdfeletronicolocalCollectionMdfeletronicolocalToAttach);
            }
            mdfeletronico.setMdfeletronicolocalCollection(attachedMdfeletronicolocalCollection);
            Collection<Mdfeletronicoevento> attachedMdfeletronicoeventoCollection = new ArrayList<Mdfeletronicoevento>();
            for (Mdfeletronicoevento mdfeletronicoeventoCollectionMdfeletronicoeventoToAttach : mdfeletronico.getMdfeletronicoeventoCollection()) {
                mdfeletronicoeventoCollectionMdfeletronicoeventoToAttach = em.getReference(mdfeletronicoeventoCollectionMdfeletronicoeventoToAttach.getClass(), mdfeletronicoeventoCollectionMdfeletronicoeventoToAttach.getCodmdfeletronicoevento());
                attachedMdfeletronicoeventoCollection.add(mdfeletronicoeventoCollectionMdfeletronicoeventoToAttach);
            }
            mdfeletronico.setMdfeletronicoeventoCollection(attachedMdfeletronicoeventoCollection);
            Collection<Mdfeletronicopercurso> attachedMdfeletronicopercursoCollection = new ArrayList<Mdfeletronicopercurso>();
            for (Mdfeletronicopercurso mdfeletronicopercursoCollectionMdfeletronicopercursoToAttach : mdfeletronico.getMdfeletronicopercursoCollection()) {
                mdfeletronicopercursoCollectionMdfeletronicopercursoToAttach = em.getReference(mdfeletronicopercursoCollectionMdfeletronicopercursoToAttach.getClass(), mdfeletronicopercursoCollectionMdfeletronicopercursoToAttach.getCodmdfeletronicopercurso());
                attachedMdfeletronicopercursoCollection.add(mdfeletronicopercursoCollectionMdfeletronicopercursoToAttach);
            }
            mdfeletronico.setMdfeletronicopercursoCollection(attachedMdfeletronicopercursoCollection);
            Collection<Mdfeletroniconf> attachedMdfeletroniconfCollection = new ArrayList<Mdfeletroniconf>();
            for (Mdfeletroniconf mdfeletroniconfCollectionMdfeletroniconfToAttach : mdfeletronico.getMdfeletroniconfCollection()) {
                mdfeletroniconfCollectionMdfeletroniconfToAttach = em.getReference(mdfeletroniconfCollectionMdfeletroniconfToAttach.getClass(), mdfeletroniconfCollectionMdfeletroniconfToAttach.getCodmdfeletroniconf());
                attachedMdfeletroniconfCollection.add(mdfeletroniconfCollectionMdfeletroniconfToAttach);
            }
            mdfeletronico.setMdfeletroniconfCollection(attachedMdfeletroniconfCollection);
            Collection<Mdfeletronicocondutor> attachedMdfeletronicocondutorCollection = new ArrayList<Mdfeletronicocondutor>();
            for (Mdfeletronicocondutor mdfeletronicocondutorCollectionMdfeletronicocondutorToAttach : mdfeletronico.getMdfeletronicocondutorCollection()) {
                mdfeletronicocondutorCollectionMdfeletronicocondutorToAttach = em.getReference(mdfeletronicocondutorCollectionMdfeletronicocondutorToAttach.getClass(), mdfeletronicocondutorCollectionMdfeletronicocondutorToAttach.getCodmdfeletronicocondutor());
                attachedMdfeletronicocondutorCollection.add(mdfeletronicocondutorCollectionMdfeletronicocondutorToAttach);
            }
            mdfeletronico.setMdfeletronicocondutorCollection(attachedMdfeletronicocondutorCollection);
            Collection<Mdfeletronicolacre> attachedMdfeletronicolacreCollection = new ArrayList<Mdfeletronicolacre>();
            for (Mdfeletronicolacre mdfeletronicolacreCollectionMdfeletronicolacreToAttach : mdfeletronico.getMdfeletronicolacreCollection()) {
                mdfeletronicolacreCollectionMdfeletronicolacreToAttach = em.getReference(mdfeletronicolacreCollectionMdfeletronicolacreToAttach.getClass(), mdfeletronicolacreCollectionMdfeletronicolacreToAttach.getCodmdfeletronicolacre());
                attachedMdfeletronicolacreCollection.add(mdfeletronicolacreCollectionMdfeletronicolacreToAttach);
            }
            mdfeletronico.setMdfeletronicolacreCollection(attachedMdfeletronicolacreCollection);
            Collection<Mdfeletronicoautorizadoxml> attachedMdfeletronicoautorizadoxmlCollection = new ArrayList<Mdfeletronicoautorizadoxml>();
            for (Mdfeletronicoautorizadoxml mdfeletronicoautorizadoxmlCollectionMdfeletronicoautorizadoxmlToAttach : mdfeletronico.getMdfeletronicoautorizadoxmlCollection()) {
                mdfeletronicoautorizadoxmlCollectionMdfeletronicoautorizadoxmlToAttach = em.getReference(mdfeletronicoautorizadoxmlCollectionMdfeletronicoautorizadoxmlToAttach.getClass(), mdfeletronicoautorizadoxmlCollectionMdfeletronicoautorizadoxmlToAttach.getCodmdfeletronicoautorizadoxml());
                attachedMdfeletronicoautorizadoxmlCollection.add(mdfeletronicoautorizadoxmlCollectionMdfeletronicoautorizadoxmlToAttach);
            }
            mdfeletronico.setMdfeletronicoautorizadoxmlCollection(attachedMdfeletronicoautorizadoxmlCollection);
            em.persist(mdfeletronico);
            if (codempresa != null) {
                codempresa.getMdfeletronicoCollection().add(mdfeletronico);
                codempresa = em.merge(codempresa);
            }
            if (codempresatipodocumento != null) {
                codempresatipodocumento.getMdfeletronicoCollection().add(mdfeletronico);
                codempresatipodocumento = em.merge(codempresatipodocumento);
            }
            if (coduffim != null) {
                coduffim.getMdfeletronicoCollection().add(mdfeletronico);
                coduffim = em.merge(coduffim);
            }
            if (codufinicio != null) {
                codufinicio.getMdfeletronicoCollection().add(mdfeletronico);
                codufinicio = em.merge(codufinicio);
            }
            for (Mdfeletronicocargaposterior mdfeletronicocargaposteriorCollectionMdfeletronicocargaposterior : mdfeletronico.getMdfeletronicocargaposteriorCollection()) {
                Mdfeletronico oldCodmdfeletronicoOfMdfeletronicocargaposteriorCollectionMdfeletronicocargaposterior = mdfeletronicocargaposteriorCollectionMdfeletronicocargaposterior.getCodmdfeletronico();
                mdfeletronicocargaposteriorCollectionMdfeletronicocargaposterior.setCodmdfeletronico(mdfeletronico);
                mdfeletronicocargaposteriorCollectionMdfeletronicocargaposterior = em.merge(mdfeletronicocargaposteriorCollectionMdfeletronicocargaposterior);
                if (oldCodmdfeletronicoOfMdfeletronicocargaposteriorCollectionMdfeletronicocargaposterior != null) {
                    oldCodmdfeletronicoOfMdfeletronicocargaposteriorCollectionMdfeletronicocargaposterior.getMdfeletronicocargaposteriorCollection().remove(mdfeletronicocargaposteriorCollectionMdfeletronicocargaposterior);
                    oldCodmdfeletronicoOfMdfeletronicocargaposteriorCollectionMdfeletronicocargaposterior = em.merge(oldCodmdfeletronicoOfMdfeletronicocargaposteriorCollectionMdfeletronicocargaposterior);
                }
            }
            for (Mdfeletronicoveiculo mdfeletronicoveiculoCollectionMdfeletronicoveiculo : mdfeletronico.getMdfeletronicoveiculoCollection()) {
                Mdfeletronico oldCodmdfeletronicoOfMdfeletronicoveiculoCollectionMdfeletronicoveiculo = mdfeletronicoveiculoCollectionMdfeletronicoveiculo.getCodmdfeletronico();
                mdfeletronicoveiculoCollectionMdfeletronicoveiculo.setCodmdfeletronico(mdfeletronico);
                mdfeletronicoveiculoCollectionMdfeletronicoveiculo = em.merge(mdfeletronicoveiculoCollectionMdfeletronicoveiculo);
                if (oldCodmdfeletronicoOfMdfeletronicoveiculoCollectionMdfeletronicoveiculo != null) {
                    oldCodmdfeletronicoOfMdfeletronicoveiculoCollectionMdfeletronicoveiculo.getMdfeletronicoveiculoCollection().remove(mdfeletronicoveiculoCollectionMdfeletronicoveiculo);
                    oldCodmdfeletronicoOfMdfeletronicoveiculoCollectionMdfeletronicoveiculo = em.merge(oldCodmdfeletronicoOfMdfeletronicoveiculoCollectionMdfeletronicoveiculo);
                }
            }
            for (Mdfeletronicolocal mdfeletronicolocalCollectionMdfeletronicolocal : mdfeletronico.getMdfeletronicolocalCollection()) {
                Mdfeletronico oldCodmdfeletronicoOfMdfeletronicolocalCollectionMdfeletronicolocal = mdfeletronicolocalCollectionMdfeletronicolocal.getCodmdfeletronico();
                mdfeletronicolocalCollectionMdfeletronicolocal.setCodmdfeletronico(mdfeletronico);
                mdfeletronicolocalCollectionMdfeletronicolocal = em.merge(mdfeletronicolocalCollectionMdfeletronicolocal);
                if (oldCodmdfeletronicoOfMdfeletronicolocalCollectionMdfeletronicolocal != null) {
                    oldCodmdfeletronicoOfMdfeletronicolocalCollectionMdfeletronicolocal.getMdfeletronicolocalCollection().remove(mdfeletronicolocalCollectionMdfeletronicolocal);
                    oldCodmdfeletronicoOfMdfeletronicolocalCollectionMdfeletronicolocal = em.merge(oldCodmdfeletronicoOfMdfeletronicolocalCollectionMdfeletronicolocal);
                }
            }
            for (Mdfeletronicoevento mdfeletronicoeventoCollectionMdfeletronicoevento : mdfeletronico.getMdfeletronicoeventoCollection()) {
                Mdfeletronico oldCodmdfeletronicoOfMdfeletronicoeventoCollectionMdfeletronicoevento = mdfeletronicoeventoCollectionMdfeletronicoevento.getCodmdfeletronico();
                mdfeletronicoeventoCollectionMdfeletronicoevento.setCodmdfeletronico(mdfeletronico);
                mdfeletronicoeventoCollectionMdfeletronicoevento = em.merge(mdfeletronicoeventoCollectionMdfeletronicoevento);
                if (oldCodmdfeletronicoOfMdfeletronicoeventoCollectionMdfeletronicoevento != null) {
                    oldCodmdfeletronicoOfMdfeletronicoeventoCollectionMdfeletronicoevento.getMdfeletronicoeventoCollection().remove(mdfeletronicoeventoCollectionMdfeletronicoevento);
                    oldCodmdfeletronicoOfMdfeletronicoeventoCollectionMdfeletronicoevento = em.merge(oldCodmdfeletronicoOfMdfeletronicoeventoCollectionMdfeletronicoevento);
                }
            }
            for (Mdfeletronicopercurso mdfeletronicopercursoCollectionMdfeletronicopercurso : mdfeletronico.getMdfeletronicopercursoCollection()) {
                Mdfeletronico oldCodmdfeletronicoOfMdfeletronicopercursoCollectionMdfeletronicopercurso = mdfeletronicopercursoCollectionMdfeletronicopercurso.getCodmdfeletronico();
                mdfeletronicopercursoCollectionMdfeletronicopercurso.setCodmdfeletronico(mdfeletronico);
                mdfeletronicopercursoCollectionMdfeletronicopercurso = em.merge(mdfeletronicopercursoCollectionMdfeletronicopercurso);
                if (oldCodmdfeletronicoOfMdfeletronicopercursoCollectionMdfeletronicopercurso != null) {
                    oldCodmdfeletronicoOfMdfeletronicopercursoCollectionMdfeletronicopercurso.getMdfeletronicopercursoCollection().remove(mdfeletronicopercursoCollectionMdfeletronicopercurso);
                    oldCodmdfeletronicoOfMdfeletronicopercursoCollectionMdfeletronicopercurso = em.merge(oldCodmdfeletronicoOfMdfeletronicopercursoCollectionMdfeletronicopercurso);
                }
            }
            for (Mdfeletroniconf mdfeletroniconfCollectionMdfeletroniconf : mdfeletronico.getMdfeletroniconfCollection()) {
                Mdfeletronico oldCodmdfeletronicoOfMdfeletroniconfCollectionMdfeletroniconf = mdfeletroniconfCollectionMdfeletroniconf.getCodmdfeletronico();
                mdfeletroniconfCollectionMdfeletroniconf.setCodmdfeletronico(mdfeletronico);
                mdfeletroniconfCollectionMdfeletroniconf = em.merge(mdfeletroniconfCollectionMdfeletroniconf);
                if (oldCodmdfeletronicoOfMdfeletroniconfCollectionMdfeletroniconf != null) {
                    oldCodmdfeletronicoOfMdfeletroniconfCollectionMdfeletroniconf.getMdfeletroniconfCollection().remove(mdfeletroniconfCollectionMdfeletroniconf);
                    oldCodmdfeletronicoOfMdfeletroniconfCollectionMdfeletroniconf = em.merge(oldCodmdfeletronicoOfMdfeletroniconfCollectionMdfeletroniconf);
                }
            }
            for (Mdfeletronicocondutor mdfeletronicocondutorCollectionMdfeletronicocondutor : mdfeletronico.getMdfeletronicocondutorCollection()) {
                Mdfeletronico oldCodmdfeletronicoOfMdfeletronicocondutorCollectionMdfeletronicocondutor = mdfeletronicocondutorCollectionMdfeletronicocondutor.getCodmdfeletronico();
                mdfeletronicocondutorCollectionMdfeletronicocondutor.setCodmdfeletronico(mdfeletronico);
                mdfeletronicocondutorCollectionMdfeletronicocondutor = em.merge(mdfeletronicocondutorCollectionMdfeletronicocondutor);
                if (oldCodmdfeletronicoOfMdfeletronicocondutorCollectionMdfeletronicocondutor != null) {
                    oldCodmdfeletronicoOfMdfeletronicocondutorCollectionMdfeletronicocondutor.getMdfeletronicocondutorCollection().remove(mdfeletronicocondutorCollectionMdfeletronicocondutor);
                    oldCodmdfeletronicoOfMdfeletronicocondutorCollectionMdfeletronicocondutor = em.merge(oldCodmdfeletronicoOfMdfeletronicocondutorCollectionMdfeletronicocondutor);
                }
            }
            for (Mdfeletronicolacre mdfeletronicolacreCollectionMdfeletronicolacre : mdfeletronico.getMdfeletronicolacreCollection()) {
                Mdfeletronico oldCodmdfeletronicoOfMdfeletronicolacreCollectionMdfeletronicolacre = mdfeletronicolacreCollectionMdfeletronicolacre.getCodmdfeletronico();
                mdfeletronicolacreCollectionMdfeletronicolacre.setCodmdfeletronico(mdfeletronico);
                mdfeletronicolacreCollectionMdfeletronicolacre = em.merge(mdfeletronicolacreCollectionMdfeletronicolacre);
                if (oldCodmdfeletronicoOfMdfeletronicolacreCollectionMdfeletronicolacre != null) {
                    oldCodmdfeletronicoOfMdfeletronicolacreCollectionMdfeletronicolacre.getMdfeletronicolacreCollection().remove(mdfeletronicolacreCollectionMdfeletronicolacre);
                    oldCodmdfeletronicoOfMdfeletronicolacreCollectionMdfeletronicolacre = em.merge(oldCodmdfeletronicoOfMdfeletronicolacreCollectionMdfeletronicolacre);
                }
            }
            for (Mdfeletronicoautorizadoxml mdfeletronicoautorizadoxmlCollectionMdfeletronicoautorizadoxml : mdfeletronico.getMdfeletronicoautorizadoxmlCollection()) {
                Mdfeletronico oldCodmdfeletronicoOfMdfeletronicoautorizadoxmlCollectionMdfeletronicoautorizadoxml = mdfeletronicoautorizadoxmlCollectionMdfeletronicoautorizadoxml.getCodmdfeletronico();
                mdfeletronicoautorizadoxmlCollectionMdfeletronicoautorizadoxml.setCodmdfeletronico(mdfeletronico);
                mdfeletronicoautorizadoxmlCollectionMdfeletronicoautorizadoxml = em.merge(mdfeletronicoautorizadoxmlCollectionMdfeletronicoautorizadoxml);
                if (oldCodmdfeletronicoOfMdfeletronicoautorizadoxmlCollectionMdfeletronicoautorizadoxml != null) {
                    oldCodmdfeletronicoOfMdfeletronicoautorizadoxmlCollectionMdfeletronicoautorizadoxml.getMdfeletronicoautorizadoxmlCollection().remove(mdfeletronicoautorizadoxmlCollectionMdfeletronicoautorizadoxml);
                    oldCodmdfeletronicoOfMdfeletronicoautorizadoxmlCollectionMdfeletronicoautorizadoxml = em.merge(oldCodmdfeletronicoOfMdfeletronicoautorizadoxmlCollectionMdfeletronicoautorizadoxml);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMdfeletronico(mdfeletronico.getCodmdfeletronico()) != null) {
                throw new PreexistingEntityException("Mdfeletronico " + mdfeletronico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mdfeletronico mdfeletronico) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mdfeletronico persistentMdfeletronico = em.find(Mdfeletronico.class, mdfeletronico.getCodmdfeletronico());
            Empresa codempresaOld = persistentMdfeletronico.getCodempresa();
            Empresa codempresaNew = mdfeletronico.getCodempresa();
            Empresatipodocumento codempresatipodocumentoOld = persistentMdfeletronico.getCodempresatipodocumento();
            Empresatipodocumento codempresatipodocumentoNew = mdfeletronico.getCodempresatipodocumento();
            Uf coduffimOld = persistentMdfeletronico.getCoduffim();
            Uf coduffimNew = mdfeletronico.getCoduffim();
            Uf codufinicioOld = persistentMdfeletronico.getCodufinicio();
            Uf codufinicioNew = mdfeletronico.getCodufinicio();
            Collection<Mdfeletronicocargaposterior> mdfeletronicocargaposteriorCollectionOld = persistentMdfeletronico.getMdfeletronicocargaposteriorCollection();
            Collection<Mdfeletronicocargaposterior> mdfeletronicocargaposteriorCollectionNew = mdfeletronico.getMdfeletronicocargaposteriorCollection();
            Collection<Mdfeletronicoveiculo> mdfeletronicoveiculoCollectionOld = persistentMdfeletronico.getMdfeletronicoveiculoCollection();
            Collection<Mdfeletronicoveiculo> mdfeletronicoveiculoCollectionNew = mdfeletronico.getMdfeletronicoveiculoCollection();
            Collection<Mdfeletronicolocal> mdfeletronicolocalCollectionOld = persistentMdfeletronico.getMdfeletronicolocalCollection();
            Collection<Mdfeletronicolocal> mdfeletronicolocalCollectionNew = mdfeletronico.getMdfeletronicolocalCollection();
            Collection<Mdfeletronicoevento> mdfeletronicoeventoCollectionOld = persistentMdfeletronico.getMdfeletronicoeventoCollection();
            Collection<Mdfeletronicoevento> mdfeletronicoeventoCollectionNew = mdfeletronico.getMdfeletronicoeventoCollection();
            Collection<Mdfeletronicopercurso> mdfeletronicopercursoCollectionOld = persistentMdfeletronico.getMdfeletronicopercursoCollection();
            Collection<Mdfeletronicopercurso> mdfeletronicopercursoCollectionNew = mdfeletronico.getMdfeletronicopercursoCollection();
            Collection<Mdfeletroniconf> mdfeletroniconfCollectionOld = persistentMdfeletronico.getMdfeletroniconfCollection();
            Collection<Mdfeletroniconf> mdfeletroniconfCollectionNew = mdfeletronico.getMdfeletroniconfCollection();
            Collection<Mdfeletronicocondutor> mdfeletronicocondutorCollectionOld = persistentMdfeletronico.getMdfeletronicocondutorCollection();
            Collection<Mdfeletronicocondutor> mdfeletronicocondutorCollectionNew = mdfeletronico.getMdfeletronicocondutorCollection();
            Collection<Mdfeletronicolacre> mdfeletronicolacreCollectionOld = persistentMdfeletronico.getMdfeletronicolacreCollection();
            Collection<Mdfeletronicolacre> mdfeletronicolacreCollectionNew = mdfeletronico.getMdfeletronicolacreCollection();
            Collection<Mdfeletronicoautorizadoxml> mdfeletronicoautorizadoxmlCollectionOld = persistentMdfeletronico.getMdfeletronicoautorizadoxmlCollection();
            Collection<Mdfeletronicoautorizadoxml> mdfeletronicoautorizadoxmlCollectionNew = mdfeletronico.getMdfeletronicoautorizadoxmlCollection();
            List<String> illegalOrphanMessages = null;
            for (Mdfeletronicocargaposterior mdfeletronicocargaposteriorCollectionOldMdfeletronicocargaposterior : mdfeletronicocargaposteriorCollectionOld) {
                if (!mdfeletronicocargaposteriorCollectionNew.contains(mdfeletronicocargaposteriorCollectionOldMdfeletronicocargaposterior)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Mdfeletronicocargaposterior " + mdfeletronicocargaposteriorCollectionOldMdfeletronicocargaposterior + " since its codmdfeletronico field is not nullable.");
                }
            }
            for (Mdfeletronicoveiculo mdfeletronicoveiculoCollectionOldMdfeletronicoveiculo : mdfeletronicoveiculoCollectionOld) {
                if (!mdfeletronicoveiculoCollectionNew.contains(mdfeletronicoveiculoCollectionOldMdfeletronicoveiculo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Mdfeletronicoveiculo " + mdfeletronicoveiculoCollectionOldMdfeletronicoveiculo + " since its codmdfeletronico field is not nullable.");
                }
            }
            for (Mdfeletronicolocal mdfeletronicolocalCollectionOldMdfeletronicolocal : mdfeletronicolocalCollectionOld) {
                if (!mdfeletronicolocalCollectionNew.contains(mdfeletronicolocalCollectionOldMdfeletronicolocal)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Mdfeletronicolocal " + mdfeletronicolocalCollectionOldMdfeletronicolocal + " since its codmdfeletronico field is not nullable.");
                }
            }
            for (Mdfeletronicoevento mdfeletronicoeventoCollectionOldMdfeletronicoevento : mdfeletronicoeventoCollectionOld) {
                if (!mdfeletronicoeventoCollectionNew.contains(mdfeletronicoeventoCollectionOldMdfeletronicoevento)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Mdfeletronicoevento " + mdfeletronicoeventoCollectionOldMdfeletronicoevento + " since its codmdfeletronico field is not nullable.");
                }
            }
            for (Mdfeletronicopercurso mdfeletronicopercursoCollectionOldMdfeletronicopercurso : mdfeletronicopercursoCollectionOld) {
                if (!mdfeletronicopercursoCollectionNew.contains(mdfeletronicopercursoCollectionOldMdfeletronicopercurso)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Mdfeletronicopercurso " + mdfeletronicopercursoCollectionOldMdfeletronicopercurso + " since its codmdfeletronico field is not nullable.");
                }
            }
            for (Mdfeletroniconf mdfeletroniconfCollectionOldMdfeletroniconf : mdfeletroniconfCollectionOld) {
                if (!mdfeletroniconfCollectionNew.contains(mdfeletroniconfCollectionOldMdfeletroniconf)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Mdfeletroniconf " + mdfeletroniconfCollectionOldMdfeletroniconf + " since its codmdfeletronico field is not nullable.");
                }
            }
            for (Mdfeletronicocondutor mdfeletronicocondutorCollectionOldMdfeletronicocondutor : mdfeletronicocondutorCollectionOld) {
                if (!mdfeletronicocondutorCollectionNew.contains(mdfeletronicocondutorCollectionOldMdfeletronicocondutor)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Mdfeletronicocondutor " + mdfeletronicocondutorCollectionOldMdfeletronicocondutor + " since its codmdfeletronico field is not nullable.");
                }
            }
            for (Mdfeletronicolacre mdfeletronicolacreCollectionOldMdfeletronicolacre : mdfeletronicolacreCollectionOld) {
                if (!mdfeletronicolacreCollectionNew.contains(mdfeletronicolacreCollectionOldMdfeletronicolacre)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Mdfeletronicolacre " + mdfeletronicolacreCollectionOldMdfeletronicolacre + " since its codmdfeletronico field is not nullable.");
                }
            }
            for (Mdfeletronicoautorizadoxml mdfeletronicoautorizadoxmlCollectionOldMdfeletronicoautorizadoxml : mdfeletronicoautorizadoxmlCollectionOld) {
                if (!mdfeletronicoautorizadoxmlCollectionNew.contains(mdfeletronicoautorizadoxmlCollectionOldMdfeletronicoautorizadoxml)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Mdfeletronicoautorizadoxml " + mdfeletronicoautorizadoxmlCollectionOldMdfeletronicoautorizadoxml + " since its codmdfeletronico field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                mdfeletronico.setCodempresa(codempresaNew);
            }
            if (codempresatipodocumentoNew != null) {
                codempresatipodocumentoNew = em.getReference(codempresatipodocumentoNew.getClass(), codempresatipodocumentoNew.getCodempresatipodocumento());
                mdfeletronico.setCodempresatipodocumento(codempresatipodocumentoNew);
            }
            if (coduffimNew != null) {
                coduffimNew = em.getReference(coduffimNew.getClass(), coduffimNew.getCoduf());
                mdfeletronico.setCoduffim(coduffimNew);
            }
            if (codufinicioNew != null) {
                codufinicioNew = em.getReference(codufinicioNew.getClass(), codufinicioNew.getCoduf());
                mdfeletronico.setCodufinicio(codufinicioNew);
            }
            Collection<Mdfeletronicocargaposterior> attachedMdfeletronicocargaposteriorCollectionNew = new ArrayList<Mdfeletronicocargaposterior>();
            for (Mdfeletronicocargaposterior mdfeletronicocargaposteriorCollectionNewMdfeletronicocargaposteriorToAttach : mdfeletronicocargaposteriorCollectionNew) {
                mdfeletronicocargaposteriorCollectionNewMdfeletronicocargaposteriorToAttach = em.getReference(mdfeletronicocargaposteriorCollectionNewMdfeletronicocargaposteriorToAttach.getClass(), mdfeletronicocargaposteriorCollectionNewMdfeletronicocargaposteriorToAttach.getCodmdfeletronicocargaposterior());
                attachedMdfeletronicocargaposteriorCollectionNew.add(mdfeletronicocargaposteriorCollectionNewMdfeletronicocargaposteriorToAttach);
            }
            mdfeletronicocargaposteriorCollectionNew = attachedMdfeletronicocargaposteriorCollectionNew;
            mdfeletronico.setMdfeletronicocargaposteriorCollection(mdfeletronicocargaposteriorCollectionNew);
            Collection<Mdfeletronicoveiculo> attachedMdfeletronicoveiculoCollectionNew = new ArrayList<Mdfeletronicoveiculo>();
            for (Mdfeletronicoveiculo mdfeletronicoveiculoCollectionNewMdfeletronicoveiculoToAttach : mdfeletronicoveiculoCollectionNew) {
                mdfeletronicoveiculoCollectionNewMdfeletronicoveiculoToAttach = em.getReference(mdfeletronicoveiculoCollectionNewMdfeletronicoveiculoToAttach.getClass(), mdfeletronicoveiculoCollectionNewMdfeletronicoveiculoToAttach.getCodmdfeletronicoveiculo());
                attachedMdfeletronicoveiculoCollectionNew.add(mdfeletronicoveiculoCollectionNewMdfeletronicoveiculoToAttach);
            }
            mdfeletronicoveiculoCollectionNew = attachedMdfeletronicoveiculoCollectionNew;
            mdfeletronico.setMdfeletronicoveiculoCollection(mdfeletronicoveiculoCollectionNew);
            Collection<Mdfeletronicolocal> attachedMdfeletronicolocalCollectionNew = new ArrayList<Mdfeletronicolocal>();
            for (Mdfeletronicolocal mdfeletronicolocalCollectionNewMdfeletronicolocalToAttach : mdfeletronicolocalCollectionNew) {
                mdfeletronicolocalCollectionNewMdfeletronicolocalToAttach = em.getReference(mdfeletronicolocalCollectionNewMdfeletronicolocalToAttach.getClass(), mdfeletronicolocalCollectionNewMdfeletronicolocalToAttach.getCodmdfeletronicolocal());
                attachedMdfeletronicolocalCollectionNew.add(mdfeletronicolocalCollectionNewMdfeletronicolocalToAttach);
            }
            mdfeletronicolocalCollectionNew = attachedMdfeletronicolocalCollectionNew;
            mdfeletronico.setMdfeletronicolocalCollection(mdfeletronicolocalCollectionNew);
            Collection<Mdfeletronicoevento> attachedMdfeletronicoeventoCollectionNew = new ArrayList<Mdfeletronicoevento>();
            for (Mdfeletronicoevento mdfeletronicoeventoCollectionNewMdfeletronicoeventoToAttach : mdfeletronicoeventoCollectionNew) {
                mdfeletronicoeventoCollectionNewMdfeletronicoeventoToAttach = em.getReference(mdfeletronicoeventoCollectionNewMdfeletronicoeventoToAttach.getClass(), mdfeletronicoeventoCollectionNewMdfeletronicoeventoToAttach.getCodmdfeletronicoevento());
                attachedMdfeletronicoeventoCollectionNew.add(mdfeletronicoeventoCollectionNewMdfeletronicoeventoToAttach);
            }
            mdfeletronicoeventoCollectionNew = attachedMdfeletronicoeventoCollectionNew;
            mdfeletronico.setMdfeletronicoeventoCollection(mdfeletronicoeventoCollectionNew);
            Collection<Mdfeletronicopercurso> attachedMdfeletronicopercursoCollectionNew = new ArrayList<Mdfeletronicopercurso>();
            for (Mdfeletronicopercurso mdfeletronicopercursoCollectionNewMdfeletronicopercursoToAttach : mdfeletronicopercursoCollectionNew) {
                mdfeletronicopercursoCollectionNewMdfeletronicopercursoToAttach = em.getReference(mdfeletronicopercursoCollectionNewMdfeletronicopercursoToAttach.getClass(), mdfeletronicopercursoCollectionNewMdfeletronicopercursoToAttach.getCodmdfeletronicopercurso());
                attachedMdfeletronicopercursoCollectionNew.add(mdfeletronicopercursoCollectionNewMdfeletronicopercursoToAttach);
            }
            mdfeletronicopercursoCollectionNew = attachedMdfeletronicopercursoCollectionNew;
            mdfeletronico.setMdfeletronicopercursoCollection(mdfeletronicopercursoCollectionNew);
            Collection<Mdfeletroniconf> attachedMdfeletroniconfCollectionNew = new ArrayList<Mdfeletroniconf>();
            for (Mdfeletroniconf mdfeletroniconfCollectionNewMdfeletroniconfToAttach : mdfeletroniconfCollectionNew) {
                mdfeletroniconfCollectionNewMdfeletroniconfToAttach = em.getReference(mdfeletroniconfCollectionNewMdfeletroniconfToAttach.getClass(), mdfeletroniconfCollectionNewMdfeletroniconfToAttach.getCodmdfeletroniconf());
                attachedMdfeletroniconfCollectionNew.add(mdfeletroniconfCollectionNewMdfeletroniconfToAttach);
            }
            mdfeletroniconfCollectionNew = attachedMdfeletroniconfCollectionNew;
            mdfeletronico.setMdfeletroniconfCollection(mdfeletroniconfCollectionNew);
            Collection<Mdfeletronicocondutor> attachedMdfeletronicocondutorCollectionNew = new ArrayList<Mdfeletronicocondutor>();
            for (Mdfeletronicocondutor mdfeletronicocondutorCollectionNewMdfeletronicocondutorToAttach : mdfeletronicocondutorCollectionNew) {
                mdfeletronicocondutorCollectionNewMdfeletronicocondutorToAttach = em.getReference(mdfeletronicocondutorCollectionNewMdfeletronicocondutorToAttach.getClass(), mdfeletronicocondutorCollectionNewMdfeletronicocondutorToAttach.getCodmdfeletronicocondutor());
                attachedMdfeletronicocondutorCollectionNew.add(mdfeletronicocondutorCollectionNewMdfeletronicocondutorToAttach);
            }
            mdfeletronicocondutorCollectionNew = attachedMdfeletronicocondutorCollectionNew;
            mdfeletronico.setMdfeletronicocondutorCollection(mdfeletronicocondutorCollectionNew);
            Collection<Mdfeletronicolacre> attachedMdfeletronicolacreCollectionNew = new ArrayList<Mdfeletronicolacre>();
            for (Mdfeletronicolacre mdfeletronicolacreCollectionNewMdfeletronicolacreToAttach : mdfeletronicolacreCollectionNew) {
                mdfeletronicolacreCollectionNewMdfeletronicolacreToAttach = em.getReference(mdfeletronicolacreCollectionNewMdfeletronicolacreToAttach.getClass(), mdfeletronicolacreCollectionNewMdfeletronicolacreToAttach.getCodmdfeletronicolacre());
                attachedMdfeletronicolacreCollectionNew.add(mdfeletronicolacreCollectionNewMdfeletronicolacreToAttach);
            }
            mdfeletronicolacreCollectionNew = attachedMdfeletronicolacreCollectionNew;
            mdfeletronico.setMdfeletronicolacreCollection(mdfeletronicolacreCollectionNew);
            Collection<Mdfeletronicoautorizadoxml> attachedMdfeletronicoautorizadoxmlCollectionNew = new ArrayList<Mdfeletronicoautorizadoxml>();
            for (Mdfeletronicoautorizadoxml mdfeletronicoautorizadoxmlCollectionNewMdfeletronicoautorizadoxmlToAttach : mdfeletronicoautorizadoxmlCollectionNew) {
                mdfeletronicoautorizadoxmlCollectionNewMdfeletronicoautorizadoxmlToAttach = em.getReference(mdfeletronicoautorizadoxmlCollectionNewMdfeletronicoautorizadoxmlToAttach.getClass(), mdfeletronicoautorizadoxmlCollectionNewMdfeletronicoautorizadoxmlToAttach.getCodmdfeletronicoautorizadoxml());
                attachedMdfeletronicoautorizadoxmlCollectionNew.add(mdfeletronicoautorizadoxmlCollectionNewMdfeletronicoautorizadoxmlToAttach);
            }
            mdfeletronicoautorizadoxmlCollectionNew = attachedMdfeletronicoautorizadoxmlCollectionNew;
            mdfeletronico.setMdfeletronicoautorizadoxmlCollection(mdfeletronicoautorizadoxmlCollectionNew);
            mdfeletronico = em.merge(mdfeletronico);
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getMdfeletronicoCollection().remove(mdfeletronico);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getMdfeletronicoCollection().add(mdfeletronico);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codempresatipodocumentoOld != null && !codempresatipodocumentoOld.equals(codempresatipodocumentoNew)) {
                codempresatipodocumentoOld.getMdfeletronicoCollection().remove(mdfeletronico);
                codempresatipodocumentoOld = em.merge(codempresatipodocumentoOld);
            }
            if (codempresatipodocumentoNew != null && !codempresatipodocumentoNew.equals(codempresatipodocumentoOld)) {
                codempresatipodocumentoNew.getMdfeletronicoCollection().add(mdfeletronico);
                codempresatipodocumentoNew = em.merge(codempresatipodocumentoNew);
            }
            if (coduffimOld != null && !coduffimOld.equals(coduffimNew)) {
                coduffimOld.getMdfeletronicoCollection().remove(mdfeletronico);
                coduffimOld = em.merge(coduffimOld);
            }
            if (coduffimNew != null && !coduffimNew.equals(coduffimOld)) {
                coduffimNew.getMdfeletronicoCollection().add(mdfeletronico);
                coduffimNew = em.merge(coduffimNew);
            }
            if (codufinicioOld != null && !codufinicioOld.equals(codufinicioNew)) {
                codufinicioOld.getMdfeletronicoCollection().remove(mdfeletronico);
                codufinicioOld = em.merge(codufinicioOld);
            }
            if (codufinicioNew != null && !codufinicioNew.equals(codufinicioOld)) {
                codufinicioNew.getMdfeletronicoCollection().add(mdfeletronico);
                codufinicioNew = em.merge(codufinicioNew);
            }
            for (Mdfeletronicocargaposterior mdfeletronicocargaposteriorCollectionNewMdfeletronicocargaposterior : mdfeletronicocargaposteriorCollectionNew) {
                if (!mdfeletronicocargaposteriorCollectionOld.contains(mdfeletronicocargaposteriorCollectionNewMdfeletronicocargaposterior)) {
                    Mdfeletronico oldCodmdfeletronicoOfMdfeletronicocargaposteriorCollectionNewMdfeletronicocargaposterior = mdfeletronicocargaposteriorCollectionNewMdfeletronicocargaposterior.getCodmdfeletronico();
                    mdfeletronicocargaposteriorCollectionNewMdfeletronicocargaposterior.setCodmdfeletronico(mdfeletronico);
                    mdfeletronicocargaposteriorCollectionNewMdfeletronicocargaposterior = em.merge(mdfeletronicocargaposteriorCollectionNewMdfeletronicocargaposterior);
                    if (oldCodmdfeletronicoOfMdfeletronicocargaposteriorCollectionNewMdfeletronicocargaposterior != null && !oldCodmdfeletronicoOfMdfeletronicocargaposteriorCollectionNewMdfeletronicocargaposterior.equals(mdfeletronico)) {
                        oldCodmdfeletronicoOfMdfeletronicocargaposteriorCollectionNewMdfeletronicocargaposterior.getMdfeletronicocargaposteriorCollection().remove(mdfeletronicocargaposteriorCollectionNewMdfeletronicocargaposterior);
                        oldCodmdfeletronicoOfMdfeletronicocargaposteriorCollectionNewMdfeletronicocargaposterior = em.merge(oldCodmdfeletronicoOfMdfeletronicocargaposteriorCollectionNewMdfeletronicocargaposterior);
                    }
                }
            }
            for (Mdfeletronicoveiculo mdfeletronicoveiculoCollectionNewMdfeletronicoveiculo : mdfeletronicoveiculoCollectionNew) {
                if (!mdfeletronicoveiculoCollectionOld.contains(mdfeletronicoveiculoCollectionNewMdfeletronicoveiculo)) {
                    Mdfeletronico oldCodmdfeletronicoOfMdfeletronicoveiculoCollectionNewMdfeletronicoveiculo = mdfeletronicoveiculoCollectionNewMdfeletronicoveiculo.getCodmdfeletronico();
                    mdfeletronicoveiculoCollectionNewMdfeletronicoveiculo.setCodmdfeletronico(mdfeletronico);
                    mdfeletronicoveiculoCollectionNewMdfeletronicoveiculo = em.merge(mdfeletronicoveiculoCollectionNewMdfeletronicoveiculo);
                    if (oldCodmdfeletronicoOfMdfeletronicoveiculoCollectionNewMdfeletronicoveiculo != null && !oldCodmdfeletronicoOfMdfeletronicoveiculoCollectionNewMdfeletronicoveiculo.equals(mdfeletronico)) {
                        oldCodmdfeletronicoOfMdfeletronicoveiculoCollectionNewMdfeletronicoveiculo.getMdfeletronicoveiculoCollection().remove(mdfeletronicoveiculoCollectionNewMdfeletronicoveiculo);
                        oldCodmdfeletronicoOfMdfeletronicoveiculoCollectionNewMdfeletronicoveiculo = em.merge(oldCodmdfeletronicoOfMdfeletronicoveiculoCollectionNewMdfeletronicoveiculo);
                    }
                }
            }
            for (Mdfeletronicolocal mdfeletronicolocalCollectionNewMdfeletronicolocal : mdfeletronicolocalCollectionNew) {
                if (!mdfeletronicolocalCollectionOld.contains(mdfeletronicolocalCollectionNewMdfeletronicolocal)) {
                    Mdfeletronico oldCodmdfeletronicoOfMdfeletronicolocalCollectionNewMdfeletronicolocal = mdfeletronicolocalCollectionNewMdfeletronicolocal.getCodmdfeletronico();
                    mdfeletronicolocalCollectionNewMdfeletronicolocal.setCodmdfeletronico(mdfeletronico);
                    mdfeletronicolocalCollectionNewMdfeletronicolocal = em.merge(mdfeletronicolocalCollectionNewMdfeletronicolocal);
                    if (oldCodmdfeletronicoOfMdfeletronicolocalCollectionNewMdfeletronicolocal != null && !oldCodmdfeletronicoOfMdfeletronicolocalCollectionNewMdfeletronicolocal.equals(mdfeletronico)) {
                        oldCodmdfeletronicoOfMdfeletronicolocalCollectionNewMdfeletronicolocal.getMdfeletronicolocalCollection().remove(mdfeletronicolocalCollectionNewMdfeletronicolocal);
                        oldCodmdfeletronicoOfMdfeletronicolocalCollectionNewMdfeletronicolocal = em.merge(oldCodmdfeletronicoOfMdfeletronicolocalCollectionNewMdfeletronicolocal);
                    }
                }
            }
            for (Mdfeletronicoevento mdfeletronicoeventoCollectionNewMdfeletronicoevento : mdfeletronicoeventoCollectionNew) {
                if (!mdfeletronicoeventoCollectionOld.contains(mdfeletronicoeventoCollectionNewMdfeletronicoevento)) {
                    Mdfeletronico oldCodmdfeletronicoOfMdfeletronicoeventoCollectionNewMdfeletronicoevento = mdfeletronicoeventoCollectionNewMdfeletronicoevento.getCodmdfeletronico();
                    mdfeletronicoeventoCollectionNewMdfeletronicoevento.setCodmdfeletronico(mdfeletronico);
                    mdfeletronicoeventoCollectionNewMdfeletronicoevento = em.merge(mdfeletronicoeventoCollectionNewMdfeletronicoevento);
                    if (oldCodmdfeletronicoOfMdfeletronicoeventoCollectionNewMdfeletronicoevento != null && !oldCodmdfeletronicoOfMdfeletronicoeventoCollectionNewMdfeletronicoevento.equals(mdfeletronico)) {
                        oldCodmdfeletronicoOfMdfeletronicoeventoCollectionNewMdfeletronicoevento.getMdfeletronicoeventoCollection().remove(mdfeletronicoeventoCollectionNewMdfeletronicoevento);
                        oldCodmdfeletronicoOfMdfeletronicoeventoCollectionNewMdfeletronicoevento = em.merge(oldCodmdfeletronicoOfMdfeletronicoeventoCollectionNewMdfeletronicoevento);
                    }
                }
            }
            for (Mdfeletronicopercurso mdfeletronicopercursoCollectionNewMdfeletronicopercurso : mdfeletronicopercursoCollectionNew) {
                if (!mdfeletronicopercursoCollectionOld.contains(mdfeletronicopercursoCollectionNewMdfeletronicopercurso)) {
                    Mdfeletronico oldCodmdfeletronicoOfMdfeletronicopercursoCollectionNewMdfeletronicopercurso = mdfeletronicopercursoCollectionNewMdfeletronicopercurso.getCodmdfeletronico();
                    mdfeletronicopercursoCollectionNewMdfeletronicopercurso.setCodmdfeletronico(mdfeletronico);
                    mdfeletronicopercursoCollectionNewMdfeletronicopercurso = em.merge(mdfeletronicopercursoCollectionNewMdfeletronicopercurso);
                    if (oldCodmdfeletronicoOfMdfeletronicopercursoCollectionNewMdfeletronicopercurso != null && !oldCodmdfeletronicoOfMdfeletronicopercursoCollectionNewMdfeletronicopercurso.equals(mdfeletronico)) {
                        oldCodmdfeletronicoOfMdfeletronicopercursoCollectionNewMdfeletronicopercurso.getMdfeletronicopercursoCollection().remove(mdfeletronicopercursoCollectionNewMdfeletronicopercurso);
                        oldCodmdfeletronicoOfMdfeletronicopercursoCollectionNewMdfeletronicopercurso = em.merge(oldCodmdfeletronicoOfMdfeletronicopercursoCollectionNewMdfeletronicopercurso);
                    }
                }
            }
            for (Mdfeletroniconf mdfeletroniconfCollectionNewMdfeletroniconf : mdfeletroniconfCollectionNew) {
                if (!mdfeletroniconfCollectionOld.contains(mdfeletroniconfCollectionNewMdfeletroniconf)) {
                    Mdfeletronico oldCodmdfeletronicoOfMdfeletroniconfCollectionNewMdfeletroniconf = mdfeletroniconfCollectionNewMdfeletroniconf.getCodmdfeletronico();
                    mdfeletroniconfCollectionNewMdfeletroniconf.setCodmdfeletronico(mdfeletronico);
                    mdfeletroniconfCollectionNewMdfeletroniconf = em.merge(mdfeletroniconfCollectionNewMdfeletroniconf);
                    if (oldCodmdfeletronicoOfMdfeletroniconfCollectionNewMdfeletroniconf != null && !oldCodmdfeletronicoOfMdfeletroniconfCollectionNewMdfeletroniconf.equals(mdfeletronico)) {
                        oldCodmdfeletronicoOfMdfeletroniconfCollectionNewMdfeletroniconf.getMdfeletroniconfCollection().remove(mdfeletroniconfCollectionNewMdfeletroniconf);
                        oldCodmdfeletronicoOfMdfeletroniconfCollectionNewMdfeletroniconf = em.merge(oldCodmdfeletronicoOfMdfeletroniconfCollectionNewMdfeletroniconf);
                    }
                }
            }
            for (Mdfeletronicocondutor mdfeletronicocondutorCollectionNewMdfeletronicocondutor : mdfeletronicocondutorCollectionNew) {
                if (!mdfeletronicocondutorCollectionOld.contains(mdfeletronicocondutorCollectionNewMdfeletronicocondutor)) {
                    Mdfeletronico oldCodmdfeletronicoOfMdfeletronicocondutorCollectionNewMdfeletronicocondutor = mdfeletronicocondutorCollectionNewMdfeletronicocondutor.getCodmdfeletronico();
                    mdfeletronicocondutorCollectionNewMdfeletronicocondutor.setCodmdfeletronico(mdfeletronico);
                    mdfeletronicocondutorCollectionNewMdfeletronicocondutor = em.merge(mdfeletronicocondutorCollectionNewMdfeletronicocondutor);
                    if (oldCodmdfeletronicoOfMdfeletronicocondutorCollectionNewMdfeletronicocondutor != null && !oldCodmdfeletronicoOfMdfeletronicocondutorCollectionNewMdfeletronicocondutor.equals(mdfeletronico)) {
                        oldCodmdfeletronicoOfMdfeletronicocondutorCollectionNewMdfeletronicocondutor.getMdfeletronicocondutorCollection().remove(mdfeletronicocondutorCollectionNewMdfeletronicocondutor);
                        oldCodmdfeletronicoOfMdfeletronicocondutorCollectionNewMdfeletronicocondutor = em.merge(oldCodmdfeletronicoOfMdfeletronicocondutorCollectionNewMdfeletronicocondutor);
                    }
                }
            }
            for (Mdfeletronicolacre mdfeletronicolacreCollectionNewMdfeletronicolacre : mdfeletronicolacreCollectionNew) {
                if (!mdfeletronicolacreCollectionOld.contains(mdfeletronicolacreCollectionNewMdfeletronicolacre)) {
                    Mdfeletronico oldCodmdfeletronicoOfMdfeletronicolacreCollectionNewMdfeletronicolacre = mdfeletronicolacreCollectionNewMdfeletronicolacre.getCodmdfeletronico();
                    mdfeletronicolacreCollectionNewMdfeletronicolacre.setCodmdfeletronico(mdfeletronico);
                    mdfeletronicolacreCollectionNewMdfeletronicolacre = em.merge(mdfeletronicolacreCollectionNewMdfeletronicolacre);
                    if (oldCodmdfeletronicoOfMdfeletronicolacreCollectionNewMdfeletronicolacre != null && !oldCodmdfeletronicoOfMdfeletronicolacreCollectionNewMdfeletronicolacre.equals(mdfeletronico)) {
                        oldCodmdfeletronicoOfMdfeletronicolacreCollectionNewMdfeletronicolacre.getMdfeletronicolacreCollection().remove(mdfeletronicolacreCollectionNewMdfeletronicolacre);
                        oldCodmdfeletronicoOfMdfeletronicolacreCollectionNewMdfeletronicolacre = em.merge(oldCodmdfeletronicoOfMdfeletronicolacreCollectionNewMdfeletronicolacre);
                    }
                }
            }
            for (Mdfeletronicoautorizadoxml mdfeletronicoautorizadoxmlCollectionNewMdfeletronicoautorizadoxml : mdfeletronicoautorizadoxmlCollectionNew) {
                if (!mdfeletronicoautorizadoxmlCollectionOld.contains(mdfeletronicoautorizadoxmlCollectionNewMdfeletronicoautorizadoxml)) {
                    Mdfeletronico oldCodmdfeletronicoOfMdfeletronicoautorizadoxmlCollectionNewMdfeletronicoautorizadoxml = mdfeletronicoautorizadoxmlCollectionNewMdfeletronicoautorizadoxml.getCodmdfeletronico();
                    mdfeletronicoautorizadoxmlCollectionNewMdfeletronicoautorizadoxml.setCodmdfeletronico(mdfeletronico);
                    mdfeletronicoautorizadoxmlCollectionNewMdfeletronicoautorizadoxml = em.merge(mdfeletronicoautorizadoxmlCollectionNewMdfeletronicoautorizadoxml);
                    if (oldCodmdfeletronicoOfMdfeletronicoautorizadoxmlCollectionNewMdfeletronicoautorizadoxml != null && !oldCodmdfeletronicoOfMdfeletronicoautorizadoxmlCollectionNewMdfeletronicoautorizadoxml.equals(mdfeletronico)) {
                        oldCodmdfeletronicoOfMdfeletronicoautorizadoxmlCollectionNewMdfeletronicoautorizadoxml.getMdfeletronicoautorizadoxmlCollection().remove(mdfeletronicoautorizadoxmlCollectionNewMdfeletronicoautorizadoxml);
                        oldCodmdfeletronicoOfMdfeletronicoautorizadoxmlCollectionNewMdfeletronicoautorizadoxml = em.merge(oldCodmdfeletronicoOfMdfeletronicoautorizadoxmlCollectionNewMdfeletronicoautorizadoxml);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = mdfeletronico.getCodmdfeletronico();
                if (findMdfeletronico(id) == null) {
                    throw new NonexistentEntityException("The mdfeletronico with id " + id + " no longer exists.");
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
            Mdfeletronico mdfeletronico;
            try {
                mdfeletronico = em.getReference(Mdfeletronico.class, id);
                mdfeletronico.getCodmdfeletronico();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mdfeletronico with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Mdfeletronicocargaposterior> mdfeletronicocargaposteriorCollectionOrphanCheck = mdfeletronico.getMdfeletronicocargaposteriorCollection();
            for (Mdfeletronicocargaposterior mdfeletronicocargaposteriorCollectionOrphanCheckMdfeletronicocargaposterior : mdfeletronicocargaposteriorCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Mdfeletronico (" + mdfeletronico + ") cannot be destroyed since the Mdfeletronicocargaposterior " + mdfeletronicocargaposteriorCollectionOrphanCheckMdfeletronicocargaposterior + " in its mdfeletronicocargaposteriorCollection field has a non-nullable codmdfeletronico field.");
            }
            Collection<Mdfeletronicoveiculo> mdfeletronicoveiculoCollectionOrphanCheck = mdfeletronico.getMdfeletronicoveiculoCollection();
            for (Mdfeletronicoveiculo mdfeletronicoveiculoCollectionOrphanCheckMdfeletronicoveiculo : mdfeletronicoveiculoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Mdfeletronico (" + mdfeletronico + ") cannot be destroyed since the Mdfeletronicoveiculo " + mdfeletronicoveiculoCollectionOrphanCheckMdfeletronicoveiculo + " in its mdfeletronicoveiculoCollection field has a non-nullable codmdfeletronico field.");
            }
            Collection<Mdfeletronicolocal> mdfeletronicolocalCollectionOrphanCheck = mdfeletronico.getMdfeletronicolocalCollection();
            for (Mdfeletronicolocal mdfeletronicolocalCollectionOrphanCheckMdfeletronicolocal : mdfeletronicolocalCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Mdfeletronico (" + mdfeletronico + ") cannot be destroyed since the Mdfeletronicolocal " + mdfeletronicolocalCollectionOrphanCheckMdfeletronicolocal + " in its mdfeletronicolocalCollection field has a non-nullable codmdfeletronico field.");
            }
            Collection<Mdfeletronicoevento> mdfeletronicoeventoCollectionOrphanCheck = mdfeletronico.getMdfeletronicoeventoCollection();
            for (Mdfeletronicoevento mdfeletronicoeventoCollectionOrphanCheckMdfeletronicoevento : mdfeletronicoeventoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Mdfeletronico (" + mdfeletronico + ") cannot be destroyed since the Mdfeletronicoevento " + mdfeletronicoeventoCollectionOrphanCheckMdfeletronicoevento + " in its mdfeletronicoeventoCollection field has a non-nullable codmdfeletronico field.");
            }
            Collection<Mdfeletronicopercurso> mdfeletronicopercursoCollectionOrphanCheck = mdfeletronico.getMdfeletronicopercursoCollection();
            for (Mdfeletronicopercurso mdfeletronicopercursoCollectionOrphanCheckMdfeletronicopercurso : mdfeletronicopercursoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Mdfeletronico (" + mdfeletronico + ") cannot be destroyed since the Mdfeletronicopercurso " + mdfeletronicopercursoCollectionOrphanCheckMdfeletronicopercurso + " in its mdfeletronicopercursoCollection field has a non-nullable codmdfeletronico field.");
            }
            Collection<Mdfeletroniconf> mdfeletroniconfCollectionOrphanCheck = mdfeletronico.getMdfeletroniconfCollection();
            for (Mdfeletroniconf mdfeletroniconfCollectionOrphanCheckMdfeletroniconf : mdfeletroniconfCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Mdfeletronico (" + mdfeletronico + ") cannot be destroyed since the Mdfeletroniconf " + mdfeletroniconfCollectionOrphanCheckMdfeletroniconf + " in its mdfeletroniconfCollection field has a non-nullable codmdfeletronico field.");
            }
            Collection<Mdfeletronicocondutor> mdfeletronicocondutorCollectionOrphanCheck = mdfeletronico.getMdfeletronicocondutorCollection();
            for (Mdfeletronicocondutor mdfeletronicocondutorCollectionOrphanCheckMdfeletronicocondutor : mdfeletronicocondutorCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Mdfeletronico (" + mdfeletronico + ") cannot be destroyed since the Mdfeletronicocondutor " + mdfeletronicocondutorCollectionOrphanCheckMdfeletronicocondutor + " in its mdfeletronicocondutorCollection field has a non-nullable codmdfeletronico field.");
            }
            Collection<Mdfeletronicolacre> mdfeletronicolacreCollectionOrphanCheck = mdfeletronico.getMdfeletronicolacreCollection();
            for (Mdfeletronicolacre mdfeletronicolacreCollectionOrphanCheckMdfeletronicolacre : mdfeletronicolacreCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Mdfeletronico (" + mdfeletronico + ") cannot be destroyed since the Mdfeletronicolacre " + mdfeletronicolacreCollectionOrphanCheckMdfeletronicolacre + " in its mdfeletronicolacreCollection field has a non-nullable codmdfeletronico field.");
            }
            Collection<Mdfeletronicoautorizadoxml> mdfeletronicoautorizadoxmlCollectionOrphanCheck = mdfeletronico.getMdfeletronicoautorizadoxmlCollection();
            for (Mdfeletronicoautorizadoxml mdfeletronicoautorizadoxmlCollectionOrphanCheckMdfeletronicoautorizadoxml : mdfeletronicoautorizadoxmlCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Mdfeletronico (" + mdfeletronico + ") cannot be destroyed since the Mdfeletronicoautorizadoxml " + mdfeletronicoautorizadoxmlCollectionOrphanCheckMdfeletronicoautorizadoxml + " in its mdfeletronicoautorizadoxmlCollection field has a non-nullable codmdfeletronico field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Empresa codempresa = mdfeletronico.getCodempresa();
            if (codempresa != null) {
                codempresa.getMdfeletronicoCollection().remove(mdfeletronico);
                codempresa = em.merge(codempresa);
            }
            Empresatipodocumento codempresatipodocumento = mdfeletronico.getCodempresatipodocumento();
            if (codempresatipodocumento != null) {
                codempresatipodocumento.getMdfeletronicoCollection().remove(mdfeletronico);
                codempresatipodocumento = em.merge(codempresatipodocumento);
            }
            Uf coduffim = mdfeletronico.getCoduffim();
            if (coduffim != null) {
                coduffim.getMdfeletronicoCollection().remove(mdfeletronico);
                coduffim = em.merge(coduffim);
            }
            Uf codufinicio = mdfeletronico.getCodufinicio();
            if (codufinicio != null) {
                codufinicio.getMdfeletronicoCollection().remove(mdfeletronico);
                codufinicio = em.merge(codufinicio);
            }
            em.remove(mdfeletronico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mdfeletronico> findMdfeletronicoEntities() {
        return findMdfeletronicoEntities(true, -1, -1);
    }

    public List<Mdfeletronico> findMdfeletronicoEntities(int maxResults, int firstResult) {
        return findMdfeletronicoEntities(false, maxResults, firstResult);
    }

    private List<Mdfeletronico> findMdfeletronicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mdfeletronico.class));
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

    public Mdfeletronico findMdfeletronico(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mdfeletronico.class, id);
        } finally {
            em.close();
        }
    }

    public int getMdfeletronicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mdfeletronico> rt = cq.from(Mdfeletronico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

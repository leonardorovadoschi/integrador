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
import entidade.cplus.Tipodocumento;
import entidade.cplus.Empresatipodocumentocampo;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Empresatipodocumentocf;
import entidade.cplus.Mdfeletronico;
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
public class EmpresatipodocumentoJpaController implements Serializable {

    public EmpresatipodocumentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empresatipodocumento empresatipodocumento) throws PreexistingEntityException, Exception {
        if (empresatipodocumento.getEmpresatipodocumentocampoCollection() == null) {
            empresatipodocumento.setEmpresatipodocumentocampoCollection(new ArrayList<Empresatipodocumentocampo>());
        }
        if (empresatipodocumento.getEmpresatipodocumentocfCollection() == null) {
            empresatipodocumento.setEmpresatipodocumentocfCollection(new ArrayList<Empresatipodocumentocf>());
        }
        if (empresatipodocumento.getMdfeletronicoCollection() == null) {
            empresatipodocumento.setMdfeletronicoCollection(new ArrayList<Mdfeletronico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa codempresa = empresatipodocumento.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                empresatipodocumento.setCodempresa(codempresa);
            }
            Tipodocumento codtipodocumento = empresatipodocumento.getCodtipodocumento();
            if (codtipodocumento != null) {
                codtipodocumento = em.getReference(codtipodocumento.getClass(), codtipodocumento.getCodtipodocumento());
                empresatipodocumento.setCodtipodocumento(codtipodocumento);
            }
            Collection<Empresatipodocumentocampo> attachedEmpresatipodocumentocampoCollection = new ArrayList<Empresatipodocumentocampo>();
            for (Empresatipodocumentocampo empresatipodocumentocampoCollectionEmpresatipodocumentocampoToAttach : empresatipodocumento.getEmpresatipodocumentocampoCollection()) {
                empresatipodocumentocampoCollectionEmpresatipodocumentocampoToAttach = em.getReference(empresatipodocumentocampoCollectionEmpresatipodocumentocampoToAttach.getClass(), empresatipodocumentocampoCollectionEmpresatipodocumentocampoToAttach.getCodempresatipodocumentocampo());
                attachedEmpresatipodocumentocampoCollection.add(empresatipodocumentocampoCollectionEmpresatipodocumentocampoToAttach);
            }
            empresatipodocumento.setEmpresatipodocumentocampoCollection(attachedEmpresatipodocumentocampoCollection);
            Collection<Empresatipodocumentocf> attachedEmpresatipodocumentocfCollection = new ArrayList<Empresatipodocumentocf>();
            for (Empresatipodocumentocf empresatipodocumentocfCollectionEmpresatipodocumentocfToAttach : empresatipodocumento.getEmpresatipodocumentocfCollection()) {
                empresatipodocumentocfCollectionEmpresatipodocumentocfToAttach = em.getReference(empresatipodocumentocfCollectionEmpresatipodocumentocfToAttach.getClass(), empresatipodocumentocfCollectionEmpresatipodocumentocfToAttach.getCodempresatipodocumentocf());
                attachedEmpresatipodocumentocfCollection.add(empresatipodocumentocfCollectionEmpresatipodocumentocfToAttach);
            }
            empresatipodocumento.setEmpresatipodocumentocfCollection(attachedEmpresatipodocumentocfCollection);
            Collection<Mdfeletronico> attachedMdfeletronicoCollection = new ArrayList<Mdfeletronico>();
            for (Mdfeletronico mdfeletronicoCollectionMdfeletronicoToAttach : empresatipodocumento.getMdfeletronicoCollection()) {
                mdfeletronicoCollectionMdfeletronicoToAttach = em.getReference(mdfeletronicoCollectionMdfeletronicoToAttach.getClass(), mdfeletronicoCollectionMdfeletronicoToAttach.getCodmdfeletronico());
                attachedMdfeletronicoCollection.add(mdfeletronicoCollectionMdfeletronicoToAttach);
            }
            empresatipodocumento.setMdfeletronicoCollection(attachedMdfeletronicoCollection);
            em.persist(empresatipodocumento);
            if (codempresa != null) {
                codempresa.getEmpresatipodocumentoCollection().add(empresatipodocumento);
                codempresa = em.merge(codempresa);
            }
            if (codtipodocumento != null) {
                codtipodocumento.getEmpresatipodocumentoCollection().add(empresatipodocumento);
                codtipodocumento = em.merge(codtipodocumento);
            }
            for (Empresatipodocumentocampo empresatipodocumentocampoCollectionEmpresatipodocumentocampo : empresatipodocumento.getEmpresatipodocumentocampoCollection()) {
                Empresatipodocumento oldCodempresatipodocumentoOfEmpresatipodocumentocampoCollectionEmpresatipodocumentocampo = empresatipodocumentocampoCollectionEmpresatipodocumentocampo.getCodempresatipodocumento();
                empresatipodocumentocampoCollectionEmpresatipodocumentocampo.setCodempresatipodocumento(empresatipodocumento);
                empresatipodocumentocampoCollectionEmpresatipodocumentocampo = em.merge(empresatipodocumentocampoCollectionEmpresatipodocumentocampo);
                if (oldCodempresatipodocumentoOfEmpresatipodocumentocampoCollectionEmpresatipodocumentocampo != null) {
                    oldCodempresatipodocumentoOfEmpresatipodocumentocampoCollectionEmpresatipodocumentocampo.getEmpresatipodocumentocampoCollection().remove(empresatipodocumentocampoCollectionEmpresatipodocumentocampo);
                    oldCodempresatipodocumentoOfEmpresatipodocumentocampoCollectionEmpresatipodocumentocampo = em.merge(oldCodempresatipodocumentoOfEmpresatipodocumentocampoCollectionEmpresatipodocumentocampo);
                }
            }
            for (Empresatipodocumentocf empresatipodocumentocfCollectionEmpresatipodocumentocf : empresatipodocumento.getEmpresatipodocumentocfCollection()) {
                Empresatipodocumento oldCodempresatipodocumentoOfEmpresatipodocumentocfCollectionEmpresatipodocumentocf = empresatipodocumentocfCollectionEmpresatipodocumentocf.getCodempresatipodocumento();
                empresatipodocumentocfCollectionEmpresatipodocumentocf.setCodempresatipodocumento(empresatipodocumento);
                empresatipodocumentocfCollectionEmpresatipodocumentocf = em.merge(empresatipodocumentocfCollectionEmpresatipodocumentocf);
                if (oldCodempresatipodocumentoOfEmpresatipodocumentocfCollectionEmpresatipodocumentocf != null) {
                    oldCodempresatipodocumentoOfEmpresatipodocumentocfCollectionEmpresatipodocumentocf.getEmpresatipodocumentocfCollection().remove(empresatipodocumentocfCollectionEmpresatipodocumentocf);
                    oldCodempresatipodocumentoOfEmpresatipodocumentocfCollectionEmpresatipodocumentocf = em.merge(oldCodempresatipodocumentoOfEmpresatipodocumentocfCollectionEmpresatipodocumentocf);
                }
            }
            for (Mdfeletronico mdfeletronicoCollectionMdfeletronico : empresatipodocumento.getMdfeletronicoCollection()) {
                Empresatipodocumento oldCodempresatipodocumentoOfMdfeletronicoCollectionMdfeletronico = mdfeletronicoCollectionMdfeletronico.getCodempresatipodocumento();
                mdfeletronicoCollectionMdfeletronico.setCodempresatipodocumento(empresatipodocumento);
                mdfeletronicoCollectionMdfeletronico = em.merge(mdfeletronicoCollectionMdfeletronico);
                if (oldCodempresatipodocumentoOfMdfeletronicoCollectionMdfeletronico != null) {
                    oldCodempresatipodocumentoOfMdfeletronicoCollectionMdfeletronico.getMdfeletronicoCollection().remove(mdfeletronicoCollectionMdfeletronico);
                    oldCodempresatipodocumentoOfMdfeletronicoCollectionMdfeletronico = em.merge(oldCodempresatipodocumentoOfMdfeletronicoCollectionMdfeletronico);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmpresatipodocumento(empresatipodocumento.getCodempresatipodocumento()) != null) {
                throw new PreexistingEntityException("Empresatipodocumento " + empresatipodocumento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empresatipodocumento empresatipodocumento) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresatipodocumento persistentEmpresatipodocumento = em.find(Empresatipodocumento.class, empresatipodocumento.getCodempresatipodocumento());
            Empresa codempresaOld = persistentEmpresatipodocumento.getCodempresa();
            Empresa codempresaNew = empresatipodocumento.getCodempresa();
            Tipodocumento codtipodocumentoOld = persistentEmpresatipodocumento.getCodtipodocumento();
            Tipodocumento codtipodocumentoNew = empresatipodocumento.getCodtipodocumento();
            Collection<Empresatipodocumentocampo> empresatipodocumentocampoCollectionOld = persistentEmpresatipodocumento.getEmpresatipodocumentocampoCollection();
            Collection<Empresatipodocumentocampo> empresatipodocumentocampoCollectionNew = empresatipodocumento.getEmpresatipodocumentocampoCollection();
            Collection<Empresatipodocumentocf> empresatipodocumentocfCollectionOld = persistentEmpresatipodocumento.getEmpresatipodocumentocfCollection();
            Collection<Empresatipodocumentocf> empresatipodocumentocfCollectionNew = empresatipodocumento.getEmpresatipodocumentocfCollection();
            Collection<Mdfeletronico> mdfeletronicoCollectionOld = persistentEmpresatipodocumento.getMdfeletronicoCollection();
            Collection<Mdfeletronico> mdfeletronicoCollectionNew = empresatipodocumento.getMdfeletronicoCollection();
            List<String> illegalOrphanMessages = null;
            for (Empresatipodocumentocampo empresatipodocumentocampoCollectionOldEmpresatipodocumentocampo : empresatipodocumentocampoCollectionOld) {
                if (!empresatipodocumentocampoCollectionNew.contains(empresatipodocumentocampoCollectionOldEmpresatipodocumentocampo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Empresatipodocumentocampo " + empresatipodocumentocampoCollectionOldEmpresatipodocumentocampo + " since its codempresatipodocumento field is not nullable.");
                }
            }
            for (Empresatipodocumentocf empresatipodocumentocfCollectionOldEmpresatipodocumentocf : empresatipodocumentocfCollectionOld) {
                if (!empresatipodocumentocfCollectionNew.contains(empresatipodocumentocfCollectionOldEmpresatipodocumentocf)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Empresatipodocumentocf " + empresatipodocumentocfCollectionOldEmpresatipodocumentocf + " since its codempresatipodocumento field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                empresatipodocumento.setCodempresa(codempresaNew);
            }
            if (codtipodocumentoNew != null) {
                codtipodocumentoNew = em.getReference(codtipodocumentoNew.getClass(), codtipodocumentoNew.getCodtipodocumento());
                empresatipodocumento.setCodtipodocumento(codtipodocumentoNew);
            }
            Collection<Empresatipodocumentocampo> attachedEmpresatipodocumentocampoCollectionNew = new ArrayList<Empresatipodocumentocampo>();
            for (Empresatipodocumentocampo empresatipodocumentocampoCollectionNewEmpresatipodocumentocampoToAttach : empresatipodocumentocampoCollectionNew) {
                empresatipodocumentocampoCollectionNewEmpresatipodocumentocampoToAttach = em.getReference(empresatipodocumentocampoCollectionNewEmpresatipodocumentocampoToAttach.getClass(), empresatipodocumentocampoCollectionNewEmpresatipodocumentocampoToAttach.getCodempresatipodocumentocampo());
                attachedEmpresatipodocumentocampoCollectionNew.add(empresatipodocumentocampoCollectionNewEmpresatipodocumentocampoToAttach);
            }
            empresatipodocumentocampoCollectionNew = attachedEmpresatipodocumentocampoCollectionNew;
            empresatipodocumento.setEmpresatipodocumentocampoCollection(empresatipodocumentocampoCollectionNew);
            Collection<Empresatipodocumentocf> attachedEmpresatipodocumentocfCollectionNew = new ArrayList<Empresatipodocumentocf>();
            for (Empresatipodocumentocf empresatipodocumentocfCollectionNewEmpresatipodocumentocfToAttach : empresatipodocumentocfCollectionNew) {
                empresatipodocumentocfCollectionNewEmpresatipodocumentocfToAttach = em.getReference(empresatipodocumentocfCollectionNewEmpresatipodocumentocfToAttach.getClass(), empresatipodocumentocfCollectionNewEmpresatipodocumentocfToAttach.getCodempresatipodocumentocf());
                attachedEmpresatipodocumentocfCollectionNew.add(empresatipodocumentocfCollectionNewEmpresatipodocumentocfToAttach);
            }
            empresatipodocumentocfCollectionNew = attachedEmpresatipodocumentocfCollectionNew;
            empresatipodocumento.setEmpresatipodocumentocfCollection(empresatipodocumentocfCollectionNew);
            Collection<Mdfeletronico> attachedMdfeletronicoCollectionNew = new ArrayList<Mdfeletronico>();
            for (Mdfeletronico mdfeletronicoCollectionNewMdfeletronicoToAttach : mdfeletronicoCollectionNew) {
                mdfeletronicoCollectionNewMdfeletronicoToAttach = em.getReference(mdfeletronicoCollectionNewMdfeletronicoToAttach.getClass(), mdfeletronicoCollectionNewMdfeletronicoToAttach.getCodmdfeletronico());
                attachedMdfeletronicoCollectionNew.add(mdfeletronicoCollectionNewMdfeletronicoToAttach);
            }
            mdfeletronicoCollectionNew = attachedMdfeletronicoCollectionNew;
            empresatipodocumento.setMdfeletronicoCollection(mdfeletronicoCollectionNew);
            empresatipodocumento = em.merge(empresatipodocumento);
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getEmpresatipodocumentoCollection().remove(empresatipodocumento);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getEmpresatipodocumentoCollection().add(empresatipodocumento);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codtipodocumentoOld != null && !codtipodocumentoOld.equals(codtipodocumentoNew)) {
                codtipodocumentoOld.getEmpresatipodocumentoCollection().remove(empresatipodocumento);
                codtipodocumentoOld = em.merge(codtipodocumentoOld);
            }
            if (codtipodocumentoNew != null && !codtipodocumentoNew.equals(codtipodocumentoOld)) {
                codtipodocumentoNew.getEmpresatipodocumentoCollection().add(empresatipodocumento);
                codtipodocumentoNew = em.merge(codtipodocumentoNew);
            }
            for (Empresatipodocumentocampo empresatipodocumentocampoCollectionNewEmpresatipodocumentocampo : empresatipodocumentocampoCollectionNew) {
                if (!empresatipodocumentocampoCollectionOld.contains(empresatipodocumentocampoCollectionNewEmpresatipodocumentocampo)) {
                    Empresatipodocumento oldCodempresatipodocumentoOfEmpresatipodocumentocampoCollectionNewEmpresatipodocumentocampo = empresatipodocumentocampoCollectionNewEmpresatipodocumentocampo.getCodempresatipodocumento();
                    empresatipodocumentocampoCollectionNewEmpresatipodocumentocampo.setCodempresatipodocumento(empresatipodocumento);
                    empresatipodocumentocampoCollectionNewEmpresatipodocumentocampo = em.merge(empresatipodocumentocampoCollectionNewEmpresatipodocumentocampo);
                    if (oldCodempresatipodocumentoOfEmpresatipodocumentocampoCollectionNewEmpresatipodocumentocampo != null && !oldCodempresatipodocumentoOfEmpresatipodocumentocampoCollectionNewEmpresatipodocumentocampo.equals(empresatipodocumento)) {
                        oldCodempresatipodocumentoOfEmpresatipodocumentocampoCollectionNewEmpresatipodocumentocampo.getEmpresatipodocumentocampoCollection().remove(empresatipodocumentocampoCollectionNewEmpresatipodocumentocampo);
                        oldCodempresatipodocumentoOfEmpresatipodocumentocampoCollectionNewEmpresatipodocumentocampo = em.merge(oldCodempresatipodocumentoOfEmpresatipodocumentocampoCollectionNewEmpresatipodocumentocampo);
                    }
                }
            }
            for (Empresatipodocumentocf empresatipodocumentocfCollectionNewEmpresatipodocumentocf : empresatipodocumentocfCollectionNew) {
                if (!empresatipodocumentocfCollectionOld.contains(empresatipodocumentocfCollectionNewEmpresatipodocumentocf)) {
                    Empresatipodocumento oldCodempresatipodocumentoOfEmpresatipodocumentocfCollectionNewEmpresatipodocumentocf = empresatipodocumentocfCollectionNewEmpresatipodocumentocf.getCodempresatipodocumento();
                    empresatipodocumentocfCollectionNewEmpresatipodocumentocf.setCodempresatipodocumento(empresatipodocumento);
                    empresatipodocumentocfCollectionNewEmpresatipodocumentocf = em.merge(empresatipodocumentocfCollectionNewEmpresatipodocumentocf);
                    if (oldCodempresatipodocumentoOfEmpresatipodocumentocfCollectionNewEmpresatipodocumentocf != null && !oldCodempresatipodocumentoOfEmpresatipodocumentocfCollectionNewEmpresatipodocumentocf.equals(empresatipodocumento)) {
                        oldCodempresatipodocumentoOfEmpresatipodocumentocfCollectionNewEmpresatipodocumentocf.getEmpresatipodocumentocfCollection().remove(empresatipodocumentocfCollectionNewEmpresatipodocumentocf);
                        oldCodempresatipodocumentoOfEmpresatipodocumentocfCollectionNewEmpresatipodocumentocf = em.merge(oldCodempresatipodocumentoOfEmpresatipodocumentocfCollectionNewEmpresatipodocumentocf);
                    }
                }
            }
            for (Mdfeletronico mdfeletronicoCollectionOldMdfeletronico : mdfeletronicoCollectionOld) {
                if (!mdfeletronicoCollectionNew.contains(mdfeletronicoCollectionOldMdfeletronico)) {
                    mdfeletronicoCollectionOldMdfeletronico.setCodempresatipodocumento(null);
                    mdfeletronicoCollectionOldMdfeletronico = em.merge(mdfeletronicoCollectionOldMdfeletronico);
                }
            }
            for (Mdfeletronico mdfeletronicoCollectionNewMdfeletronico : mdfeletronicoCollectionNew) {
                if (!mdfeletronicoCollectionOld.contains(mdfeletronicoCollectionNewMdfeletronico)) {
                    Empresatipodocumento oldCodempresatipodocumentoOfMdfeletronicoCollectionNewMdfeletronico = mdfeletronicoCollectionNewMdfeletronico.getCodempresatipodocumento();
                    mdfeletronicoCollectionNewMdfeletronico.setCodempresatipodocumento(empresatipodocumento);
                    mdfeletronicoCollectionNewMdfeletronico = em.merge(mdfeletronicoCollectionNewMdfeletronico);
                    if (oldCodempresatipodocumentoOfMdfeletronicoCollectionNewMdfeletronico != null && !oldCodempresatipodocumentoOfMdfeletronicoCollectionNewMdfeletronico.equals(empresatipodocumento)) {
                        oldCodempresatipodocumentoOfMdfeletronicoCollectionNewMdfeletronico.getMdfeletronicoCollection().remove(mdfeletronicoCollectionNewMdfeletronico);
                        oldCodempresatipodocumentoOfMdfeletronicoCollectionNewMdfeletronico = em.merge(oldCodempresatipodocumentoOfMdfeletronicoCollectionNewMdfeletronico);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = empresatipodocumento.getCodempresatipodocumento();
                if (findEmpresatipodocumento(id) == null) {
                    throw new NonexistentEntityException("The empresatipodocumento with id " + id + " no longer exists.");
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
            Empresatipodocumento empresatipodocumento;
            try {
                empresatipodocumento = em.getReference(Empresatipodocumento.class, id);
                empresatipodocumento.getCodempresatipodocumento();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empresatipodocumento with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Empresatipodocumentocampo> empresatipodocumentocampoCollectionOrphanCheck = empresatipodocumento.getEmpresatipodocumentocampoCollection();
            for (Empresatipodocumentocampo empresatipodocumentocampoCollectionOrphanCheckEmpresatipodocumentocampo : empresatipodocumentocampoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresatipodocumento (" + empresatipodocumento + ") cannot be destroyed since the Empresatipodocumentocampo " + empresatipodocumentocampoCollectionOrphanCheckEmpresatipodocumentocampo + " in its empresatipodocumentocampoCollection field has a non-nullable codempresatipodocumento field.");
            }
            Collection<Empresatipodocumentocf> empresatipodocumentocfCollectionOrphanCheck = empresatipodocumento.getEmpresatipodocumentocfCollection();
            for (Empresatipodocumentocf empresatipodocumentocfCollectionOrphanCheckEmpresatipodocumentocf : empresatipodocumentocfCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresatipodocumento (" + empresatipodocumento + ") cannot be destroyed since the Empresatipodocumentocf " + empresatipodocumentocfCollectionOrphanCheckEmpresatipodocumentocf + " in its empresatipodocumentocfCollection field has a non-nullable codempresatipodocumento field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Empresa codempresa = empresatipodocumento.getCodempresa();
            if (codempresa != null) {
                codempresa.getEmpresatipodocumentoCollection().remove(empresatipodocumento);
                codempresa = em.merge(codempresa);
            }
            Tipodocumento codtipodocumento = empresatipodocumento.getCodtipodocumento();
            if (codtipodocumento != null) {
                codtipodocumento.getEmpresatipodocumentoCollection().remove(empresatipodocumento);
                codtipodocumento = em.merge(codtipodocumento);
            }
            Collection<Mdfeletronico> mdfeletronicoCollection = empresatipodocumento.getMdfeletronicoCollection();
            for (Mdfeletronico mdfeletronicoCollectionMdfeletronico : mdfeletronicoCollection) {
                mdfeletronicoCollectionMdfeletronico.setCodempresatipodocumento(null);
                mdfeletronicoCollectionMdfeletronico = em.merge(mdfeletronicoCollectionMdfeletronico);
            }
            em.remove(empresatipodocumento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empresatipodocumento> findEmpresatipodocumentoEntities() {
        return findEmpresatipodocumentoEntities(true, -1, -1);
    }

    public List<Empresatipodocumento> findEmpresatipodocumentoEntities(int maxResults, int firstResult) {
        return findEmpresatipodocumentoEntities(false, maxResults, firstResult);
    }

    private List<Empresatipodocumento> findEmpresatipodocumentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empresatipodocumento.class));
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

    public Empresatipodocumento findEmpresatipodocumento(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empresatipodocumento.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpresatipodocumentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empresatipodocumento> rt = cq.from(Empresatipodocumento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

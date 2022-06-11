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
import entidade.cplus.Pendenciabacen;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Pendenciavarejo;
import entidade.cplus.Pendenciafinaceira;
import entidade.cplus.Pendenciasinternas;
import entidade.cplus.Historicoserasa;
import entidade.cplus.Alertadocumento;
import entidade.cplus.Consultaserasa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ConsultaserasaJpaController implements Serializable {

    public ConsultaserasaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Consultaserasa consultaserasa) throws PreexistingEntityException, Exception {
        if (consultaserasa.getPendenciabacenCollection() == null) {
            consultaserasa.setPendenciabacenCollection(new ArrayList<Pendenciabacen>());
        }
        if (consultaserasa.getPendenciavarejoCollection() == null) {
            consultaserasa.setPendenciavarejoCollection(new ArrayList<Pendenciavarejo>());
        }
        if (consultaserasa.getPendenciafinaceiraCollection() == null) {
            consultaserasa.setPendenciafinaceiraCollection(new ArrayList<Pendenciafinaceira>());
        }
        if (consultaserasa.getPendenciasinternasCollection() == null) {
            consultaserasa.setPendenciasinternasCollection(new ArrayList<Pendenciasinternas>());
        }
        if (consultaserasa.getHistoricoserasaCollection() == null) {
            consultaserasa.setHistoricoserasaCollection(new ArrayList<Historicoserasa>());
        }
        if (consultaserasa.getAlertadocumentoCollection() == null) {
            consultaserasa.setAlertadocumentoCollection(new ArrayList<Alertadocumento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Pendenciabacen> attachedPendenciabacenCollection = new ArrayList<Pendenciabacen>();
            for (Pendenciabacen pendenciabacenCollectionPendenciabacenToAttach : consultaserasa.getPendenciabacenCollection()) {
                pendenciabacenCollectionPendenciabacenToAttach = em.getReference(pendenciabacenCollectionPendenciabacenToAttach.getClass(), pendenciabacenCollectionPendenciabacenToAttach.getCodpendenciabacen());
                attachedPendenciabacenCollection.add(pendenciabacenCollectionPendenciabacenToAttach);
            }
            consultaserasa.setPendenciabacenCollection(attachedPendenciabacenCollection);
            Collection<Pendenciavarejo> attachedPendenciavarejoCollection = new ArrayList<Pendenciavarejo>();
            for (Pendenciavarejo pendenciavarejoCollectionPendenciavarejoToAttach : consultaserasa.getPendenciavarejoCollection()) {
                pendenciavarejoCollectionPendenciavarejoToAttach = em.getReference(pendenciavarejoCollectionPendenciavarejoToAttach.getClass(), pendenciavarejoCollectionPendenciavarejoToAttach.getCodpendenciavarejo());
                attachedPendenciavarejoCollection.add(pendenciavarejoCollectionPendenciavarejoToAttach);
            }
            consultaserasa.setPendenciavarejoCollection(attachedPendenciavarejoCollection);
            Collection<Pendenciafinaceira> attachedPendenciafinaceiraCollection = new ArrayList<Pendenciafinaceira>();
            for (Pendenciafinaceira pendenciafinaceiraCollectionPendenciafinaceiraToAttach : consultaserasa.getPendenciafinaceiraCollection()) {
                pendenciafinaceiraCollectionPendenciafinaceiraToAttach = em.getReference(pendenciafinaceiraCollectionPendenciafinaceiraToAttach.getClass(), pendenciafinaceiraCollectionPendenciafinaceiraToAttach.getCodpendenciafinaceira());
                attachedPendenciafinaceiraCollection.add(pendenciafinaceiraCollectionPendenciafinaceiraToAttach);
            }
            consultaserasa.setPendenciafinaceiraCollection(attachedPendenciafinaceiraCollection);
            Collection<Pendenciasinternas> attachedPendenciasinternasCollection = new ArrayList<Pendenciasinternas>();
            for (Pendenciasinternas pendenciasinternasCollectionPendenciasinternasToAttach : consultaserasa.getPendenciasinternasCollection()) {
                pendenciasinternasCollectionPendenciasinternasToAttach = em.getReference(pendenciasinternasCollectionPendenciasinternasToAttach.getClass(), pendenciasinternasCollectionPendenciasinternasToAttach.getCodpendenciainternas());
                attachedPendenciasinternasCollection.add(pendenciasinternasCollectionPendenciasinternasToAttach);
            }
            consultaserasa.setPendenciasinternasCollection(attachedPendenciasinternasCollection);
            Collection<Historicoserasa> attachedHistoricoserasaCollection = new ArrayList<Historicoserasa>();
            for (Historicoserasa historicoserasaCollectionHistoricoserasaToAttach : consultaserasa.getHistoricoserasaCollection()) {
                historicoserasaCollectionHistoricoserasaToAttach = em.getReference(historicoserasaCollectionHistoricoserasaToAttach.getClass(), historicoserasaCollectionHistoricoserasaToAttach.getCodhistoricoserasa());
                attachedHistoricoserasaCollection.add(historicoserasaCollectionHistoricoserasaToAttach);
            }
            consultaserasa.setHistoricoserasaCollection(attachedHistoricoserasaCollection);
            Collection<Alertadocumento> attachedAlertadocumentoCollection = new ArrayList<Alertadocumento>();
            for (Alertadocumento alertadocumentoCollectionAlertadocumentoToAttach : consultaserasa.getAlertadocumentoCollection()) {
                alertadocumentoCollectionAlertadocumentoToAttach = em.getReference(alertadocumentoCollectionAlertadocumentoToAttach.getClass(), alertadocumentoCollectionAlertadocumentoToAttach.getCodalertadocumento());
                attachedAlertadocumentoCollection.add(alertadocumentoCollectionAlertadocumentoToAttach);
            }
            consultaserasa.setAlertadocumentoCollection(attachedAlertadocumentoCollection);
            em.persist(consultaserasa);
            for (Pendenciabacen pendenciabacenCollectionPendenciabacen : consultaserasa.getPendenciabacenCollection()) {
                Consultaserasa oldCodconsultaserasaOfPendenciabacenCollectionPendenciabacen = pendenciabacenCollectionPendenciabacen.getCodconsultaserasa();
                pendenciabacenCollectionPendenciabacen.setCodconsultaserasa(consultaserasa);
                pendenciabacenCollectionPendenciabacen = em.merge(pendenciabacenCollectionPendenciabacen);
                if (oldCodconsultaserasaOfPendenciabacenCollectionPendenciabacen != null) {
                    oldCodconsultaserasaOfPendenciabacenCollectionPendenciabacen.getPendenciabacenCollection().remove(pendenciabacenCollectionPendenciabacen);
                    oldCodconsultaserasaOfPendenciabacenCollectionPendenciabacen = em.merge(oldCodconsultaserasaOfPendenciabacenCollectionPendenciabacen);
                }
            }
            for (Pendenciavarejo pendenciavarejoCollectionPendenciavarejo : consultaserasa.getPendenciavarejoCollection()) {
                Consultaserasa oldCodconsultaserasaOfPendenciavarejoCollectionPendenciavarejo = pendenciavarejoCollectionPendenciavarejo.getCodconsultaserasa();
                pendenciavarejoCollectionPendenciavarejo.setCodconsultaserasa(consultaserasa);
                pendenciavarejoCollectionPendenciavarejo = em.merge(pendenciavarejoCollectionPendenciavarejo);
                if (oldCodconsultaserasaOfPendenciavarejoCollectionPendenciavarejo != null) {
                    oldCodconsultaserasaOfPendenciavarejoCollectionPendenciavarejo.getPendenciavarejoCollection().remove(pendenciavarejoCollectionPendenciavarejo);
                    oldCodconsultaserasaOfPendenciavarejoCollectionPendenciavarejo = em.merge(oldCodconsultaserasaOfPendenciavarejoCollectionPendenciavarejo);
                }
            }
            for (Pendenciafinaceira pendenciafinaceiraCollectionPendenciafinaceira : consultaserasa.getPendenciafinaceiraCollection()) {
                Consultaserasa oldCodconsultaserasaOfPendenciafinaceiraCollectionPendenciafinaceira = pendenciafinaceiraCollectionPendenciafinaceira.getCodconsultaserasa();
                pendenciafinaceiraCollectionPendenciafinaceira.setCodconsultaserasa(consultaserasa);
                pendenciafinaceiraCollectionPendenciafinaceira = em.merge(pendenciafinaceiraCollectionPendenciafinaceira);
                if (oldCodconsultaserasaOfPendenciafinaceiraCollectionPendenciafinaceira != null) {
                    oldCodconsultaserasaOfPendenciafinaceiraCollectionPendenciafinaceira.getPendenciafinaceiraCollection().remove(pendenciafinaceiraCollectionPendenciafinaceira);
                    oldCodconsultaserasaOfPendenciafinaceiraCollectionPendenciafinaceira = em.merge(oldCodconsultaserasaOfPendenciafinaceiraCollectionPendenciafinaceira);
                }
            }
            for (Pendenciasinternas pendenciasinternasCollectionPendenciasinternas : consultaserasa.getPendenciasinternasCollection()) {
                Consultaserasa oldCodconsultaserasaOfPendenciasinternasCollectionPendenciasinternas = pendenciasinternasCollectionPendenciasinternas.getCodconsultaserasa();
                pendenciasinternasCollectionPendenciasinternas.setCodconsultaserasa(consultaserasa);
                pendenciasinternasCollectionPendenciasinternas = em.merge(pendenciasinternasCollectionPendenciasinternas);
                if (oldCodconsultaserasaOfPendenciasinternasCollectionPendenciasinternas != null) {
                    oldCodconsultaserasaOfPendenciasinternasCollectionPendenciasinternas.getPendenciasinternasCollection().remove(pendenciasinternasCollectionPendenciasinternas);
                    oldCodconsultaserasaOfPendenciasinternasCollectionPendenciasinternas = em.merge(oldCodconsultaserasaOfPendenciasinternasCollectionPendenciasinternas);
                }
            }
            for (Historicoserasa historicoserasaCollectionHistoricoserasa : consultaserasa.getHistoricoserasaCollection()) {
                Consultaserasa oldCodconsultaserasaOfHistoricoserasaCollectionHistoricoserasa = historicoserasaCollectionHistoricoserasa.getCodconsultaserasa();
                historicoserasaCollectionHistoricoserasa.setCodconsultaserasa(consultaserasa);
                historicoserasaCollectionHistoricoserasa = em.merge(historicoserasaCollectionHistoricoserasa);
                if (oldCodconsultaserasaOfHistoricoserasaCollectionHistoricoserasa != null) {
                    oldCodconsultaserasaOfHistoricoserasaCollectionHistoricoserasa.getHistoricoserasaCollection().remove(historicoserasaCollectionHistoricoserasa);
                    oldCodconsultaserasaOfHistoricoserasaCollectionHistoricoserasa = em.merge(oldCodconsultaserasaOfHistoricoserasaCollectionHistoricoserasa);
                }
            }
            for (Alertadocumento alertadocumentoCollectionAlertadocumento : consultaserasa.getAlertadocumentoCollection()) {
                Consultaserasa oldCodconsultaserasaOfAlertadocumentoCollectionAlertadocumento = alertadocumentoCollectionAlertadocumento.getCodconsultaserasa();
                alertadocumentoCollectionAlertadocumento.setCodconsultaserasa(consultaserasa);
                alertadocumentoCollectionAlertadocumento = em.merge(alertadocumentoCollectionAlertadocumento);
                if (oldCodconsultaserasaOfAlertadocumentoCollectionAlertadocumento != null) {
                    oldCodconsultaserasaOfAlertadocumentoCollectionAlertadocumento.getAlertadocumentoCollection().remove(alertadocumentoCollectionAlertadocumento);
                    oldCodconsultaserasaOfAlertadocumentoCollectionAlertadocumento = em.merge(oldCodconsultaserasaOfAlertadocumentoCollectionAlertadocumento);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConsultaserasa(consultaserasa.getCodconsultaserasa()) != null) {
                throw new PreexistingEntityException("Consultaserasa " + consultaserasa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Consultaserasa consultaserasa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consultaserasa persistentConsultaserasa = em.find(Consultaserasa.class, consultaserasa.getCodconsultaserasa());
            Collection<Pendenciabacen> pendenciabacenCollectionOld = persistentConsultaserasa.getPendenciabacenCollection();
            Collection<Pendenciabacen> pendenciabacenCollectionNew = consultaserasa.getPendenciabacenCollection();
            Collection<Pendenciavarejo> pendenciavarejoCollectionOld = persistentConsultaserasa.getPendenciavarejoCollection();
            Collection<Pendenciavarejo> pendenciavarejoCollectionNew = consultaserasa.getPendenciavarejoCollection();
            Collection<Pendenciafinaceira> pendenciafinaceiraCollectionOld = persistentConsultaserasa.getPendenciafinaceiraCollection();
            Collection<Pendenciafinaceira> pendenciafinaceiraCollectionNew = consultaserasa.getPendenciafinaceiraCollection();
            Collection<Pendenciasinternas> pendenciasinternasCollectionOld = persistentConsultaserasa.getPendenciasinternasCollection();
            Collection<Pendenciasinternas> pendenciasinternasCollectionNew = consultaserasa.getPendenciasinternasCollection();
            Collection<Historicoserasa> historicoserasaCollectionOld = persistentConsultaserasa.getHistoricoserasaCollection();
            Collection<Historicoserasa> historicoserasaCollectionNew = consultaserasa.getHistoricoserasaCollection();
            Collection<Alertadocumento> alertadocumentoCollectionOld = persistentConsultaserasa.getAlertadocumentoCollection();
            Collection<Alertadocumento> alertadocumentoCollectionNew = consultaserasa.getAlertadocumentoCollection();
            Collection<Pendenciabacen> attachedPendenciabacenCollectionNew = new ArrayList<Pendenciabacen>();
            for (Pendenciabacen pendenciabacenCollectionNewPendenciabacenToAttach : pendenciabacenCollectionNew) {
                pendenciabacenCollectionNewPendenciabacenToAttach = em.getReference(pendenciabacenCollectionNewPendenciabacenToAttach.getClass(), pendenciabacenCollectionNewPendenciabacenToAttach.getCodpendenciabacen());
                attachedPendenciabacenCollectionNew.add(pendenciabacenCollectionNewPendenciabacenToAttach);
            }
            pendenciabacenCollectionNew = attachedPendenciabacenCollectionNew;
            consultaserasa.setPendenciabacenCollection(pendenciabacenCollectionNew);
            Collection<Pendenciavarejo> attachedPendenciavarejoCollectionNew = new ArrayList<Pendenciavarejo>();
            for (Pendenciavarejo pendenciavarejoCollectionNewPendenciavarejoToAttach : pendenciavarejoCollectionNew) {
                pendenciavarejoCollectionNewPendenciavarejoToAttach = em.getReference(pendenciavarejoCollectionNewPendenciavarejoToAttach.getClass(), pendenciavarejoCollectionNewPendenciavarejoToAttach.getCodpendenciavarejo());
                attachedPendenciavarejoCollectionNew.add(pendenciavarejoCollectionNewPendenciavarejoToAttach);
            }
            pendenciavarejoCollectionNew = attachedPendenciavarejoCollectionNew;
            consultaserasa.setPendenciavarejoCollection(pendenciavarejoCollectionNew);
            Collection<Pendenciafinaceira> attachedPendenciafinaceiraCollectionNew = new ArrayList<Pendenciafinaceira>();
            for (Pendenciafinaceira pendenciafinaceiraCollectionNewPendenciafinaceiraToAttach : pendenciafinaceiraCollectionNew) {
                pendenciafinaceiraCollectionNewPendenciafinaceiraToAttach = em.getReference(pendenciafinaceiraCollectionNewPendenciafinaceiraToAttach.getClass(), pendenciafinaceiraCollectionNewPendenciafinaceiraToAttach.getCodpendenciafinaceira());
                attachedPendenciafinaceiraCollectionNew.add(pendenciafinaceiraCollectionNewPendenciafinaceiraToAttach);
            }
            pendenciafinaceiraCollectionNew = attachedPendenciafinaceiraCollectionNew;
            consultaserasa.setPendenciafinaceiraCollection(pendenciafinaceiraCollectionNew);
            Collection<Pendenciasinternas> attachedPendenciasinternasCollectionNew = new ArrayList<Pendenciasinternas>();
            for (Pendenciasinternas pendenciasinternasCollectionNewPendenciasinternasToAttach : pendenciasinternasCollectionNew) {
                pendenciasinternasCollectionNewPendenciasinternasToAttach = em.getReference(pendenciasinternasCollectionNewPendenciasinternasToAttach.getClass(), pendenciasinternasCollectionNewPendenciasinternasToAttach.getCodpendenciainternas());
                attachedPendenciasinternasCollectionNew.add(pendenciasinternasCollectionNewPendenciasinternasToAttach);
            }
            pendenciasinternasCollectionNew = attachedPendenciasinternasCollectionNew;
            consultaserasa.setPendenciasinternasCollection(pendenciasinternasCollectionNew);
            Collection<Historicoserasa> attachedHistoricoserasaCollectionNew = new ArrayList<Historicoserasa>();
            for (Historicoserasa historicoserasaCollectionNewHistoricoserasaToAttach : historicoserasaCollectionNew) {
                historicoserasaCollectionNewHistoricoserasaToAttach = em.getReference(historicoserasaCollectionNewHistoricoserasaToAttach.getClass(), historicoserasaCollectionNewHistoricoserasaToAttach.getCodhistoricoserasa());
                attachedHistoricoserasaCollectionNew.add(historicoserasaCollectionNewHistoricoserasaToAttach);
            }
            historicoserasaCollectionNew = attachedHistoricoserasaCollectionNew;
            consultaserasa.setHistoricoserasaCollection(historicoserasaCollectionNew);
            Collection<Alertadocumento> attachedAlertadocumentoCollectionNew = new ArrayList<Alertadocumento>();
            for (Alertadocumento alertadocumentoCollectionNewAlertadocumentoToAttach : alertadocumentoCollectionNew) {
                alertadocumentoCollectionNewAlertadocumentoToAttach = em.getReference(alertadocumentoCollectionNewAlertadocumentoToAttach.getClass(), alertadocumentoCollectionNewAlertadocumentoToAttach.getCodalertadocumento());
                attachedAlertadocumentoCollectionNew.add(alertadocumentoCollectionNewAlertadocumentoToAttach);
            }
            alertadocumentoCollectionNew = attachedAlertadocumentoCollectionNew;
            consultaserasa.setAlertadocumentoCollection(alertadocumentoCollectionNew);
            consultaserasa = em.merge(consultaserasa);
            for (Pendenciabacen pendenciabacenCollectionOldPendenciabacen : pendenciabacenCollectionOld) {
                if (!pendenciabacenCollectionNew.contains(pendenciabacenCollectionOldPendenciabacen)) {
                    pendenciabacenCollectionOldPendenciabacen.setCodconsultaserasa(null);
                    pendenciabacenCollectionOldPendenciabacen = em.merge(pendenciabacenCollectionOldPendenciabacen);
                }
            }
            for (Pendenciabacen pendenciabacenCollectionNewPendenciabacen : pendenciabacenCollectionNew) {
                if (!pendenciabacenCollectionOld.contains(pendenciabacenCollectionNewPendenciabacen)) {
                    Consultaserasa oldCodconsultaserasaOfPendenciabacenCollectionNewPendenciabacen = pendenciabacenCollectionNewPendenciabacen.getCodconsultaserasa();
                    pendenciabacenCollectionNewPendenciabacen.setCodconsultaserasa(consultaserasa);
                    pendenciabacenCollectionNewPendenciabacen = em.merge(pendenciabacenCollectionNewPendenciabacen);
                    if (oldCodconsultaserasaOfPendenciabacenCollectionNewPendenciabacen != null && !oldCodconsultaserasaOfPendenciabacenCollectionNewPendenciabacen.equals(consultaserasa)) {
                        oldCodconsultaserasaOfPendenciabacenCollectionNewPendenciabacen.getPendenciabacenCollection().remove(pendenciabacenCollectionNewPendenciabacen);
                        oldCodconsultaserasaOfPendenciabacenCollectionNewPendenciabacen = em.merge(oldCodconsultaserasaOfPendenciabacenCollectionNewPendenciabacen);
                    }
                }
            }
            for (Pendenciavarejo pendenciavarejoCollectionOldPendenciavarejo : pendenciavarejoCollectionOld) {
                if (!pendenciavarejoCollectionNew.contains(pendenciavarejoCollectionOldPendenciavarejo)) {
                    pendenciavarejoCollectionOldPendenciavarejo.setCodconsultaserasa(null);
                    pendenciavarejoCollectionOldPendenciavarejo = em.merge(pendenciavarejoCollectionOldPendenciavarejo);
                }
            }
            for (Pendenciavarejo pendenciavarejoCollectionNewPendenciavarejo : pendenciavarejoCollectionNew) {
                if (!pendenciavarejoCollectionOld.contains(pendenciavarejoCollectionNewPendenciavarejo)) {
                    Consultaserasa oldCodconsultaserasaOfPendenciavarejoCollectionNewPendenciavarejo = pendenciavarejoCollectionNewPendenciavarejo.getCodconsultaserasa();
                    pendenciavarejoCollectionNewPendenciavarejo.setCodconsultaserasa(consultaserasa);
                    pendenciavarejoCollectionNewPendenciavarejo = em.merge(pendenciavarejoCollectionNewPendenciavarejo);
                    if (oldCodconsultaserasaOfPendenciavarejoCollectionNewPendenciavarejo != null && !oldCodconsultaserasaOfPendenciavarejoCollectionNewPendenciavarejo.equals(consultaserasa)) {
                        oldCodconsultaserasaOfPendenciavarejoCollectionNewPendenciavarejo.getPendenciavarejoCollection().remove(pendenciavarejoCollectionNewPendenciavarejo);
                        oldCodconsultaserasaOfPendenciavarejoCollectionNewPendenciavarejo = em.merge(oldCodconsultaserasaOfPendenciavarejoCollectionNewPendenciavarejo);
                    }
                }
            }
            for (Pendenciafinaceira pendenciafinaceiraCollectionOldPendenciafinaceira : pendenciafinaceiraCollectionOld) {
                if (!pendenciafinaceiraCollectionNew.contains(pendenciafinaceiraCollectionOldPendenciafinaceira)) {
                    pendenciafinaceiraCollectionOldPendenciafinaceira.setCodconsultaserasa(null);
                    pendenciafinaceiraCollectionOldPendenciafinaceira = em.merge(pendenciafinaceiraCollectionOldPendenciafinaceira);
                }
            }
            for (Pendenciafinaceira pendenciafinaceiraCollectionNewPendenciafinaceira : pendenciafinaceiraCollectionNew) {
                if (!pendenciafinaceiraCollectionOld.contains(pendenciafinaceiraCollectionNewPendenciafinaceira)) {
                    Consultaserasa oldCodconsultaserasaOfPendenciafinaceiraCollectionNewPendenciafinaceira = pendenciafinaceiraCollectionNewPendenciafinaceira.getCodconsultaserasa();
                    pendenciafinaceiraCollectionNewPendenciafinaceira.setCodconsultaserasa(consultaserasa);
                    pendenciafinaceiraCollectionNewPendenciafinaceira = em.merge(pendenciafinaceiraCollectionNewPendenciafinaceira);
                    if (oldCodconsultaserasaOfPendenciafinaceiraCollectionNewPendenciafinaceira != null && !oldCodconsultaserasaOfPendenciafinaceiraCollectionNewPendenciafinaceira.equals(consultaserasa)) {
                        oldCodconsultaserasaOfPendenciafinaceiraCollectionNewPendenciafinaceira.getPendenciafinaceiraCollection().remove(pendenciafinaceiraCollectionNewPendenciafinaceira);
                        oldCodconsultaserasaOfPendenciafinaceiraCollectionNewPendenciafinaceira = em.merge(oldCodconsultaserasaOfPendenciafinaceiraCollectionNewPendenciafinaceira);
                    }
                }
            }
            for (Pendenciasinternas pendenciasinternasCollectionOldPendenciasinternas : pendenciasinternasCollectionOld) {
                if (!pendenciasinternasCollectionNew.contains(pendenciasinternasCollectionOldPendenciasinternas)) {
                    pendenciasinternasCollectionOldPendenciasinternas.setCodconsultaserasa(null);
                    pendenciasinternasCollectionOldPendenciasinternas = em.merge(pendenciasinternasCollectionOldPendenciasinternas);
                }
            }
            for (Pendenciasinternas pendenciasinternasCollectionNewPendenciasinternas : pendenciasinternasCollectionNew) {
                if (!pendenciasinternasCollectionOld.contains(pendenciasinternasCollectionNewPendenciasinternas)) {
                    Consultaserasa oldCodconsultaserasaOfPendenciasinternasCollectionNewPendenciasinternas = pendenciasinternasCollectionNewPendenciasinternas.getCodconsultaserasa();
                    pendenciasinternasCollectionNewPendenciasinternas.setCodconsultaserasa(consultaserasa);
                    pendenciasinternasCollectionNewPendenciasinternas = em.merge(pendenciasinternasCollectionNewPendenciasinternas);
                    if (oldCodconsultaserasaOfPendenciasinternasCollectionNewPendenciasinternas != null && !oldCodconsultaserasaOfPendenciasinternasCollectionNewPendenciasinternas.equals(consultaserasa)) {
                        oldCodconsultaserasaOfPendenciasinternasCollectionNewPendenciasinternas.getPendenciasinternasCollection().remove(pendenciasinternasCollectionNewPendenciasinternas);
                        oldCodconsultaserasaOfPendenciasinternasCollectionNewPendenciasinternas = em.merge(oldCodconsultaserasaOfPendenciasinternasCollectionNewPendenciasinternas);
                    }
                }
            }
            for (Historicoserasa historicoserasaCollectionOldHistoricoserasa : historicoserasaCollectionOld) {
                if (!historicoserasaCollectionNew.contains(historicoserasaCollectionOldHistoricoserasa)) {
                    historicoserasaCollectionOldHistoricoserasa.setCodconsultaserasa(null);
                    historicoserasaCollectionOldHistoricoserasa = em.merge(historicoserasaCollectionOldHistoricoserasa);
                }
            }
            for (Historicoserasa historicoserasaCollectionNewHistoricoserasa : historicoserasaCollectionNew) {
                if (!historicoserasaCollectionOld.contains(historicoserasaCollectionNewHistoricoserasa)) {
                    Consultaserasa oldCodconsultaserasaOfHistoricoserasaCollectionNewHistoricoserasa = historicoserasaCollectionNewHistoricoserasa.getCodconsultaserasa();
                    historicoserasaCollectionNewHistoricoserasa.setCodconsultaserasa(consultaserasa);
                    historicoserasaCollectionNewHistoricoserasa = em.merge(historicoserasaCollectionNewHistoricoserasa);
                    if (oldCodconsultaserasaOfHistoricoserasaCollectionNewHistoricoserasa != null && !oldCodconsultaserasaOfHistoricoserasaCollectionNewHistoricoserasa.equals(consultaserasa)) {
                        oldCodconsultaserasaOfHistoricoserasaCollectionNewHistoricoserasa.getHistoricoserasaCollection().remove(historicoserasaCollectionNewHistoricoserasa);
                        oldCodconsultaserasaOfHistoricoserasaCollectionNewHistoricoserasa = em.merge(oldCodconsultaserasaOfHistoricoserasaCollectionNewHistoricoserasa);
                    }
                }
            }
            for (Alertadocumento alertadocumentoCollectionOldAlertadocumento : alertadocumentoCollectionOld) {
                if (!alertadocumentoCollectionNew.contains(alertadocumentoCollectionOldAlertadocumento)) {
                    alertadocumentoCollectionOldAlertadocumento.setCodconsultaserasa(null);
                    alertadocumentoCollectionOldAlertadocumento = em.merge(alertadocumentoCollectionOldAlertadocumento);
                }
            }
            for (Alertadocumento alertadocumentoCollectionNewAlertadocumento : alertadocumentoCollectionNew) {
                if (!alertadocumentoCollectionOld.contains(alertadocumentoCollectionNewAlertadocumento)) {
                    Consultaserasa oldCodconsultaserasaOfAlertadocumentoCollectionNewAlertadocumento = alertadocumentoCollectionNewAlertadocumento.getCodconsultaserasa();
                    alertadocumentoCollectionNewAlertadocumento.setCodconsultaserasa(consultaserasa);
                    alertadocumentoCollectionNewAlertadocumento = em.merge(alertadocumentoCollectionNewAlertadocumento);
                    if (oldCodconsultaserasaOfAlertadocumentoCollectionNewAlertadocumento != null && !oldCodconsultaserasaOfAlertadocumentoCollectionNewAlertadocumento.equals(consultaserasa)) {
                        oldCodconsultaserasaOfAlertadocumentoCollectionNewAlertadocumento.getAlertadocumentoCollection().remove(alertadocumentoCollectionNewAlertadocumento);
                        oldCodconsultaserasaOfAlertadocumentoCollectionNewAlertadocumento = em.merge(oldCodconsultaserasaOfAlertadocumentoCollectionNewAlertadocumento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = consultaserasa.getCodconsultaserasa();
                if (findConsultaserasa(id) == null) {
                    throw new NonexistentEntityException("The consultaserasa with id " + id + " no longer exists.");
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
            Consultaserasa consultaserasa;
            try {
                consultaserasa = em.getReference(Consultaserasa.class, id);
                consultaserasa.getCodconsultaserasa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The consultaserasa with id " + id + " no longer exists.", enfe);
            }
            Collection<Pendenciabacen> pendenciabacenCollection = consultaserasa.getPendenciabacenCollection();
            for (Pendenciabacen pendenciabacenCollectionPendenciabacen : pendenciabacenCollection) {
                pendenciabacenCollectionPendenciabacen.setCodconsultaserasa(null);
                pendenciabacenCollectionPendenciabacen = em.merge(pendenciabacenCollectionPendenciabacen);
            }
            Collection<Pendenciavarejo> pendenciavarejoCollection = consultaserasa.getPendenciavarejoCollection();
            for (Pendenciavarejo pendenciavarejoCollectionPendenciavarejo : pendenciavarejoCollection) {
                pendenciavarejoCollectionPendenciavarejo.setCodconsultaserasa(null);
                pendenciavarejoCollectionPendenciavarejo = em.merge(pendenciavarejoCollectionPendenciavarejo);
            }
            Collection<Pendenciafinaceira> pendenciafinaceiraCollection = consultaserasa.getPendenciafinaceiraCollection();
            for (Pendenciafinaceira pendenciafinaceiraCollectionPendenciafinaceira : pendenciafinaceiraCollection) {
                pendenciafinaceiraCollectionPendenciafinaceira.setCodconsultaserasa(null);
                pendenciafinaceiraCollectionPendenciafinaceira = em.merge(pendenciafinaceiraCollectionPendenciafinaceira);
            }
            Collection<Pendenciasinternas> pendenciasinternasCollection = consultaserasa.getPendenciasinternasCollection();
            for (Pendenciasinternas pendenciasinternasCollectionPendenciasinternas : pendenciasinternasCollection) {
                pendenciasinternasCollectionPendenciasinternas.setCodconsultaserasa(null);
                pendenciasinternasCollectionPendenciasinternas = em.merge(pendenciasinternasCollectionPendenciasinternas);
            }
            Collection<Historicoserasa> historicoserasaCollection = consultaserasa.getHistoricoserasaCollection();
            for (Historicoserasa historicoserasaCollectionHistoricoserasa : historicoserasaCollection) {
                historicoserasaCollectionHistoricoserasa.setCodconsultaserasa(null);
                historicoserasaCollectionHistoricoserasa = em.merge(historicoserasaCollectionHistoricoserasa);
            }
            Collection<Alertadocumento> alertadocumentoCollection = consultaserasa.getAlertadocumentoCollection();
            for (Alertadocumento alertadocumentoCollectionAlertadocumento : alertadocumentoCollection) {
                alertadocumentoCollectionAlertadocumento.setCodconsultaserasa(null);
                alertadocumentoCollectionAlertadocumento = em.merge(alertadocumentoCollectionAlertadocumento);
            }
            em.remove(consultaserasa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Consultaserasa> findConsultaserasaEntities() {
        return findConsultaserasaEntities(true, -1, -1);
    }

    public List<Consultaserasa> findConsultaserasaEntities(int maxResults, int firstResult) {
        return findConsultaserasaEntities(false, maxResults, firstResult);
    }

    private List<Consultaserasa> findConsultaserasaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Consultaserasa.class));
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

    public Consultaserasa findConsultaserasa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Consultaserasa.class, id);
        } finally {
            em.close();
        }
    }

    public int getConsultaserasaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Consultaserasa> rt = cq.from(Consultaserasa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

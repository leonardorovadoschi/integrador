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
import entidade.cplus.Consignacaobaixa;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Moventradaprodserial;
import entidade.cplus.OsProdservserial;
import entidade.cplus.Movendaprodserial;
import entidade.cplus.Orcamentoprodserial;
import entidade.cplus.Produtoserial;
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
public class ProdutoserialJpaController implements Serializable {

    public ProdutoserialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtoserial produtoserial) throws PreexistingEntityException, Exception {
        if (produtoserial.getConsignacaobaixaCollection() == null) {
            produtoserial.setConsignacaobaixaCollection(new ArrayList<Consignacaobaixa>());
        }
        if (produtoserial.getMoventradaprodserialCollection() == null) {
            produtoserial.setMoventradaprodserialCollection(new ArrayList<Moventradaprodserial>());
        }
        if (produtoserial.getOsProdservserialCollection() == null) {
            produtoserial.setOsProdservserialCollection(new ArrayList<OsProdservserial>());
        }
        if (produtoserial.getMovendaprodserialCollection() == null) {
            produtoserial.setMovendaprodserialCollection(new ArrayList<Movendaprodserial>());
        }
        if (produtoserial.getOrcamentoprodserialCollection() == null) {
            produtoserial.setOrcamentoprodserialCollection(new ArrayList<Orcamentoprodserial>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Consignacaobaixa> attachedConsignacaobaixaCollection = new ArrayList<Consignacaobaixa>();
            for (Consignacaobaixa consignacaobaixaCollectionConsignacaobaixaToAttach : produtoserial.getConsignacaobaixaCollection()) {
                consignacaobaixaCollectionConsignacaobaixaToAttach = em.getReference(consignacaobaixaCollectionConsignacaobaixaToAttach.getClass(), consignacaobaixaCollectionConsignacaobaixaToAttach.getCodconsignacaobaixa());
                attachedConsignacaobaixaCollection.add(consignacaobaixaCollectionConsignacaobaixaToAttach);
            }
            produtoserial.setConsignacaobaixaCollection(attachedConsignacaobaixaCollection);
            Collection<Moventradaprodserial> attachedMoventradaprodserialCollection = new ArrayList<Moventradaprodserial>();
            for (Moventradaprodserial moventradaprodserialCollectionMoventradaprodserialToAttach : produtoserial.getMoventradaprodserialCollection()) {
                moventradaprodserialCollectionMoventradaprodserialToAttach = em.getReference(moventradaprodserialCollectionMoventradaprodserialToAttach.getClass(), moventradaprodserialCollectionMoventradaprodserialToAttach.getCodmoventradaprodserial());
                attachedMoventradaprodserialCollection.add(moventradaprodserialCollectionMoventradaprodserialToAttach);
            }
            produtoserial.setMoventradaprodserialCollection(attachedMoventradaprodserialCollection);
            Collection<OsProdservserial> attachedOsProdservserialCollection = new ArrayList<OsProdservserial>();
            for (OsProdservserial osProdservserialCollectionOsProdservserialToAttach : produtoserial.getOsProdservserialCollection()) {
                osProdservserialCollectionOsProdservserialToAttach = em.getReference(osProdservserialCollectionOsProdservserialToAttach.getClass(), osProdservserialCollectionOsProdservserialToAttach.getCodprodservserial());
                attachedOsProdservserialCollection.add(osProdservserialCollectionOsProdservserialToAttach);
            }
            produtoserial.setOsProdservserialCollection(attachedOsProdservserialCollection);
            Collection<Movendaprodserial> attachedMovendaprodserialCollection = new ArrayList<Movendaprodserial>();
            for (Movendaprodserial movendaprodserialCollectionMovendaprodserialToAttach : produtoserial.getMovendaprodserialCollection()) {
                movendaprodserialCollectionMovendaprodserialToAttach = em.getReference(movendaprodserialCollectionMovendaprodserialToAttach.getClass(), movendaprodserialCollectionMovendaprodserialToAttach.getCodmovendaprodserial());
                attachedMovendaprodserialCollection.add(movendaprodserialCollectionMovendaprodserialToAttach);
            }
            produtoserial.setMovendaprodserialCollection(attachedMovendaprodserialCollection);
            Collection<Orcamentoprodserial> attachedOrcamentoprodserialCollection = new ArrayList<Orcamentoprodserial>();
            for (Orcamentoprodserial orcamentoprodserialCollectionOrcamentoprodserialToAttach : produtoserial.getOrcamentoprodserialCollection()) {
                orcamentoprodserialCollectionOrcamentoprodserialToAttach = em.getReference(orcamentoprodserialCollectionOrcamentoprodserialToAttach.getClass(), orcamentoprodserialCollectionOrcamentoprodserialToAttach.getCodorcprodser());
                attachedOrcamentoprodserialCollection.add(orcamentoprodserialCollectionOrcamentoprodserialToAttach);
            }
            produtoserial.setOrcamentoprodserialCollection(attachedOrcamentoprodserialCollection);
            em.persist(produtoserial);
            for (Consignacaobaixa consignacaobaixaCollectionConsignacaobaixa : produtoserial.getConsignacaobaixaCollection()) {
                Produtoserial oldCodprodutoserialOfConsignacaobaixaCollectionConsignacaobaixa = consignacaobaixaCollectionConsignacaobaixa.getCodprodutoserial();
                consignacaobaixaCollectionConsignacaobaixa.setCodprodutoserial(produtoserial);
                consignacaobaixaCollectionConsignacaobaixa = em.merge(consignacaobaixaCollectionConsignacaobaixa);
                if (oldCodprodutoserialOfConsignacaobaixaCollectionConsignacaobaixa != null) {
                    oldCodprodutoserialOfConsignacaobaixaCollectionConsignacaobaixa.getConsignacaobaixaCollection().remove(consignacaobaixaCollectionConsignacaobaixa);
                    oldCodprodutoserialOfConsignacaobaixaCollectionConsignacaobaixa = em.merge(oldCodprodutoserialOfConsignacaobaixaCollectionConsignacaobaixa);
                }
            }
            for (Moventradaprodserial moventradaprodserialCollectionMoventradaprodserial : produtoserial.getMoventradaprodserialCollection()) {
                Produtoserial oldCodprodutoserialOfMoventradaprodserialCollectionMoventradaprodserial = moventradaprodserialCollectionMoventradaprodserial.getCodprodutoserial();
                moventradaprodserialCollectionMoventradaprodserial.setCodprodutoserial(produtoserial);
                moventradaprodserialCollectionMoventradaprodserial = em.merge(moventradaprodserialCollectionMoventradaprodserial);
                if (oldCodprodutoserialOfMoventradaprodserialCollectionMoventradaprodserial != null) {
                    oldCodprodutoserialOfMoventradaprodserialCollectionMoventradaprodserial.getMoventradaprodserialCollection().remove(moventradaprodserialCollectionMoventradaprodserial);
                    oldCodprodutoserialOfMoventradaprodserialCollectionMoventradaprodserial = em.merge(oldCodprodutoserialOfMoventradaprodserialCollectionMoventradaprodserial);
                }
            }
            for (OsProdservserial osProdservserialCollectionOsProdservserial : produtoserial.getOsProdservserialCollection()) {
                Produtoserial oldCodprodutoserialOfOsProdservserialCollectionOsProdservserial = osProdservserialCollectionOsProdservserial.getCodprodutoserial();
                osProdservserialCollectionOsProdservserial.setCodprodutoserial(produtoserial);
                osProdservserialCollectionOsProdservserial = em.merge(osProdservserialCollectionOsProdservserial);
                if (oldCodprodutoserialOfOsProdservserialCollectionOsProdservserial != null) {
                    oldCodprodutoserialOfOsProdservserialCollectionOsProdservserial.getOsProdservserialCollection().remove(osProdservserialCollectionOsProdservserial);
                    oldCodprodutoserialOfOsProdservserialCollectionOsProdservserial = em.merge(oldCodprodutoserialOfOsProdservserialCollectionOsProdservserial);
                }
            }
            for (Movendaprodserial movendaprodserialCollectionMovendaprodserial : produtoserial.getMovendaprodserialCollection()) {
                Produtoserial oldCodprodutoserialOfMovendaprodserialCollectionMovendaprodserial = movendaprodserialCollectionMovendaprodserial.getCodprodutoserial();
                movendaprodserialCollectionMovendaprodserial.setCodprodutoserial(produtoserial);
                movendaprodserialCollectionMovendaprodserial = em.merge(movendaprodserialCollectionMovendaprodserial);
                if (oldCodprodutoserialOfMovendaprodserialCollectionMovendaprodserial != null) {
                    oldCodprodutoserialOfMovendaprodserialCollectionMovendaprodserial.getMovendaprodserialCollection().remove(movendaprodserialCollectionMovendaprodserial);
                    oldCodprodutoserialOfMovendaprodserialCollectionMovendaprodserial = em.merge(oldCodprodutoserialOfMovendaprodserialCollectionMovendaprodserial);
                }
            }
            for (Orcamentoprodserial orcamentoprodserialCollectionOrcamentoprodserial : produtoserial.getOrcamentoprodserialCollection()) {
                Produtoserial oldCodprodutoserialOfOrcamentoprodserialCollectionOrcamentoprodserial = orcamentoprodserialCollectionOrcamentoprodserial.getCodprodutoserial();
                orcamentoprodserialCollectionOrcamentoprodserial.setCodprodutoserial(produtoserial);
                orcamentoprodserialCollectionOrcamentoprodserial = em.merge(orcamentoprodserialCollectionOrcamentoprodserial);
                if (oldCodprodutoserialOfOrcamentoprodserialCollectionOrcamentoprodserial != null) {
                    oldCodprodutoserialOfOrcamentoprodserialCollectionOrcamentoprodserial.getOrcamentoprodserialCollection().remove(orcamentoprodserialCollectionOrcamentoprodserial);
                    oldCodprodutoserialOfOrcamentoprodserialCollectionOrcamentoprodserial = em.merge(oldCodprodutoserialOfOrcamentoprodserialCollectionOrcamentoprodserial);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProdutoserial(produtoserial.getCodprodutoserial()) != null) {
                throw new PreexistingEntityException("Produtoserial " + produtoserial + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtoserial produtoserial) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtoserial persistentProdutoserial = em.find(Produtoserial.class, produtoserial.getCodprodutoserial());
            Collection<Consignacaobaixa> consignacaobaixaCollectionOld = persistentProdutoserial.getConsignacaobaixaCollection();
            Collection<Consignacaobaixa> consignacaobaixaCollectionNew = produtoserial.getConsignacaobaixaCollection();
            Collection<Moventradaprodserial> moventradaprodserialCollectionOld = persistentProdutoserial.getMoventradaprodserialCollection();
            Collection<Moventradaprodserial> moventradaprodserialCollectionNew = produtoserial.getMoventradaprodserialCollection();
            Collection<OsProdservserial> osProdservserialCollectionOld = persistentProdutoserial.getOsProdservserialCollection();
            Collection<OsProdservserial> osProdservserialCollectionNew = produtoserial.getOsProdservserialCollection();
            Collection<Movendaprodserial> movendaprodserialCollectionOld = persistentProdutoserial.getMovendaprodserialCollection();
            Collection<Movendaprodserial> movendaprodserialCollectionNew = produtoserial.getMovendaprodserialCollection();
            Collection<Orcamentoprodserial> orcamentoprodserialCollectionOld = persistentProdutoserial.getOrcamentoprodserialCollection();
            Collection<Orcamentoprodserial> orcamentoprodserialCollectionNew = produtoserial.getOrcamentoprodserialCollection();
            List<String> illegalOrphanMessages = null;
            for (Moventradaprodserial moventradaprodserialCollectionOldMoventradaprodserial : moventradaprodserialCollectionOld) {
                if (!moventradaprodserialCollectionNew.contains(moventradaprodserialCollectionOldMoventradaprodserial)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Moventradaprodserial " + moventradaprodserialCollectionOldMoventradaprodserial + " since its codprodutoserial field is not nullable.");
                }
            }
            for (OsProdservserial osProdservserialCollectionOldOsProdservserial : osProdservserialCollectionOld) {
                if (!osProdservserialCollectionNew.contains(osProdservserialCollectionOldOsProdservserial)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain OsProdservserial " + osProdservserialCollectionOldOsProdservserial + " since its codprodutoserial field is not nullable.");
                }
            }
            for (Movendaprodserial movendaprodserialCollectionOldMovendaprodserial : movendaprodserialCollectionOld) {
                if (!movendaprodserialCollectionNew.contains(movendaprodserialCollectionOldMovendaprodserial)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Movendaprodserial " + movendaprodserialCollectionOldMovendaprodserial + " since its codprodutoserial field is not nullable.");
                }
            }
            for (Orcamentoprodserial orcamentoprodserialCollectionOldOrcamentoprodserial : orcamentoprodserialCollectionOld) {
                if (!orcamentoprodserialCollectionNew.contains(orcamentoprodserialCollectionOldOrcamentoprodserial)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Orcamentoprodserial " + orcamentoprodserialCollectionOldOrcamentoprodserial + " since its codprodutoserial field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Consignacaobaixa> attachedConsignacaobaixaCollectionNew = new ArrayList<Consignacaobaixa>();
            for (Consignacaobaixa consignacaobaixaCollectionNewConsignacaobaixaToAttach : consignacaobaixaCollectionNew) {
                consignacaobaixaCollectionNewConsignacaobaixaToAttach = em.getReference(consignacaobaixaCollectionNewConsignacaobaixaToAttach.getClass(), consignacaobaixaCollectionNewConsignacaobaixaToAttach.getCodconsignacaobaixa());
                attachedConsignacaobaixaCollectionNew.add(consignacaobaixaCollectionNewConsignacaobaixaToAttach);
            }
            consignacaobaixaCollectionNew = attachedConsignacaobaixaCollectionNew;
            produtoserial.setConsignacaobaixaCollection(consignacaobaixaCollectionNew);
            Collection<Moventradaprodserial> attachedMoventradaprodserialCollectionNew = new ArrayList<Moventradaprodserial>();
            for (Moventradaprodserial moventradaprodserialCollectionNewMoventradaprodserialToAttach : moventradaprodserialCollectionNew) {
                moventradaprodserialCollectionNewMoventradaprodserialToAttach = em.getReference(moventradaprodserialCollectionNewMoventradaprodserialToAttach.getClass(), moventradaprodserialCollectionNewMoventradaprodserialToAttach.getCodmoventradaprodserial());
                attachedMoventradaprodserialCollectionNew.add(moventradaprodserialCollectionNewMoventradaprodserialToAttach);
            }
            moventradaprodserialCollectionNew = attachedMoventradaprodserialCollectionNew;
            produtoserial.setMoventradaprodserialCollection(moventradaprodserialCollectionNew);
            Collection<OsProdservserial> attachedOsProdservserialCollectionNew = new ArrayList<OsProdservserial>();
            for (OsProdservserial osProdservserialCollectionNewOsProdservserialToAttach : osProdservserialCollectionNew) {
                osProdservserialCollectionNewOsProdservserialToAttach = em.getReference(osProdservserialCollectionNewOsProdservserialToAttach.getClass(), osProdservserialCollectionNewOsProdservserialToAttach.getCodprodservserial());
                attachedOsProdservserialCollectionNew.add(osProdservserialCollectionNewOsProdservserialToAttach);
            }
            osProdservserialCollectionNew = attachedOsProdservserialCollectionNew;
            produtoserial.setOsProdservserialCollection(osProdservserialCollectionNew);
            Collection<Movendaprodserial> attachedMovendaprodserialCollectionNew = new ArrayList<Movendaprodserial>();
            for (Movendaprodserial movendaprodserialCollectionNewMovendaprodserialToAttach : movendaprodserialCollectionNew) {
                movendaprodserialCollectionNewMovendaprodserialToAttach = em.getReference(movendaprodserialCollectionNewMovendaprodserialToAttach.getClass(), movendaprodserialCollectionNewMovendaprodserialToAttach.getCodmovendaprodserial());
                attachedMovendaprodserialCollectionNew.add(movendaprodserialCollectionNewMovendaprodserialToAttach);
            }
            movendaprodserialCollectionNew = attachedMovendaprodserialCollectionNew;
            produtoserial.setMovendaprodserialCollection(movendaprodserialCollectionNew);
            Collection<Orcamentoprodserial> attachedOrcamentoprodserialCollectionNew = new ArrayList<Orcamentoprodserial>();
            for (Orcamentoprodserial orcamentoprodserialCollectionNewOrcamentoprodserialToAttach : orcamentoprodserialCollectionNew) {
                orcamentoprodserialCollectionNewOrcamentoprodserialToAttach = em.getReference(orcamentoprodserialCollectionNewOrcamentoprodserialToAttach.getClass(), orcamentoprodserialCollectionNewOrcamentoprodserialToAttach.getCodorcprodser());
                attachedOrcamentoprodserialCollectionNew.add(orcamentoprodserialCollectionNewOrcamentoprodserialToAttach);
            }
            orcamentoprodserialCollectionNew = attachedOrcamentoprodserialCollectionNew;
            produtoserial.setOrcamentoprodserialCollection(orcamentoprodserialCollectionNew);
            produtoserial = em.merge(produtoserial);
            for (Consignacaobaixa consignacaobaixaCollectionOldConsignacaobaixa : consignacaobaixaCollectionOld) {
                if (!consignacaobaixaCollectionNew.contains(consignacaobaixaCollectionOldConsignacaobaixa)) {
                    consignacaobaixaCollectionOldConsignacaobaixa.setCodprodutoserial(null);
                    consignacaobaixaCollectionOldConsignacaobaixa = em.merge(consignacaobaixaCollectionOldConsignacaobaixa);
                }
            }
            for (Consignacaobaixa consignacaobaixaCollectionNewConsignacaobaixa : consignacaobaixaCollectionNew) {
                if (!consignacaobaixaCollectionOld.contains(consignacaobaixaCollectionNewConsignacaobaixa)) {
                    Produtoserial oldCodprodutoserialOfConsignacaobaixaCollectionNewConsignacaobaixa = consignacaobaixaCollectionNewConsignacaobaixa.getCodprodutoserial();
                    consignacaobaixaCollectionNewConsignacaobaixa.setCodprodutoserial(produtoserial);
                    consignacaobaixaCollectionNewConsignacaobaixa = em.merge(consignacaobaixaCollectionNewConsignacaobaixa);
                    if (oldCodprodutoserialOfConsignacaobaixaCollectionNewConsignacaobaixa != null && !oldCodprodutoserialOfConsignacaobaixaCollectionNewConsignacaobaixa.equals(produtoserial)) {
                        oldCodprodutoserialOfConsignacaobaixaCollectionNewConsignacaobaixa.getConsignacaobaixaCollection().remove(consignacaobaixaCollectionNewConsignacaobaixa);
                        oldCodprodutoserialOfConsignacaobaixaCollectionNewConsignacaobaixa = em.merge(oldCodprodutoserialOfConsignacaobaixaCollectionNewConsignacaobaixa);
                    }
                }
            }
            for (Moventradaprodserial moventradaprodserialCollectionNewMoventradaprodserial : moventradaprodserialCollectionNew) {
                if (!moventradaprodserialCollectionOld.contains(moventradaprodserialCollectionNewMoventradaprodserial)) {
                    Produtoserial oldCodprodutoserialOfMoventradaprodserialCollectionNewMoventradaprodserial = moventradaprodserialCollectionNewMoventradaprodserial.getCodprodutoserial();
                    moventradaprodserialCollectionNewMoventradaprodserial.setCodprodutoserial(produtoserial);
                    moventradaprodserialCollectionNewMoventradaprodserial = em.merge(moventradaprodserialCollectionNewMoventradaprodserial);
                    if (oldCodprodutoserialOfMoventradaprodserialCollectionNewMoventradaprodserial != null && !oldCodprodutoserialOfMoventradaprodserialCollectionNewMoventradaprodserial.equals(produtoserial)) {
                        oldCodprodutoserialOfMoventradaprodserialCollectionNewMoventradaprodserial.getMoventradaprodserialCollection().remove(moventradaprodserialCollectionNewMoventradaprodserial);
                        oldCodprodutoserialOfMoventradaprodserialCollectionNewMoventradaprodserial = em.merge(oldCodprodutoserialOfMoventradaprodserialCollectionNewMoventradaprodserial);
                    }
                }
            }
            for (OsProdservserial osProdservserialCollectionNewOsProdservserial : osProdservserialCollectionNew) {
                if (!osProdservserialCollectionOld.contains(osProdservserialCollectionNewOsProdservserial)) {
                    Produtoserial oldCodprodutoserialOfOsProdservserialCollectionNewOsProdservserial = osProdservserialCollectionNewOsProdservserial.getCodprodutoserial();
                    osProdservserialCollectionNewOsProdservserial.setCodprodutoserial(produtoserial);
                    osProdservserialCollectionNewOsProdservserial = em.merge(osProdservserialCollectionNewOsProdservserial);
                    if (oldCodprodutoserialOfOsProdservserialCollectionNewOsProdservserial != null && !oldCodprodutoserialOfOsProdservserialCollectionNewOsProdservserial.equals(produtoserial)) {
                        oldCodprodutoserialOfOsProdservserialCollectionNewOsProdservserial.getOsProdservserialCollection().remove(osProdservserialCollectionNewOsProdservserial);
                        oldCodprodutoserialOfOsProdservserialCollectionNewOsProdservserial = em.merge(oldCodprodutoserialOfOsProdservserialCollectionNewOsProdservserial);
                    }
                }
            }
            for (Movendaprodserial movendaprodserialCollectionNewMovendaprodserial : movendaprodserialCollectionNew) {
                if (!movendaprodserialCollectionOld.contains(movendaprodserialCollectionNewMovendaprodserial)) {
                    Produtoserial oldCodprodutoserialOfMovendaprodserialCollectionNewMovendaprodserial = movendaprodserialCollectionNewMovendaprodserial.getCodprodutoserial();
                    movendaprodserialCollectionNewMovendaprodserial.setCodprodutoserial(produtoserial);
                    movendaprodserialCollectionNewMovendaprodserial = em.merge(movendaprodserialCollectionNewMovendaprodserial);
                    if (oldCodprodutoserialOfMovendaprodserialCollectionNewMovendaprodserial != null && !oldCodprodutoserialOfMovendaprodserialCollectionNewMovendaprodserial.equals(produtoserial)) {
                        oldCodprodutoserialOfMovendaprodserialCollectionNewMovendaprodserial.getMovendaprodserialCollection().remove(movendaprodserialCollectionNewMovendaprodserial);
                        oldCodprodutoserialOfMovendaprodserialCollectionNewMovendaprodserial = em.merge(oldCodprodutoserialOfMovendaprodserialCollectionNewMovendaprodserial);
                    }
                }
            }
            for (Orcamentoprodserial orcamentoprodserialCollectionNewOrcamentoprodserial : orcamentoprodserialCollectionNew) {
                if (!orcamentoprodserialCollectionOld.contains(orcamentoprodserialCollectionNewOrcamentoprodserial)) {
                    Produtoserial oldCodprodutoserialOfOrcamentoprodserialCollectionNewOrcamentoprodserial = orcamentoprodserialCollectionNewOrcamentoprodserial.getCodprodutoserial();
                    orcamentoprodserialCollectionNewOrcamentoprodserial.setCodprodutoserial(produtoserial);
                    orcamentoprodserialCollectionNewOrcamentoprodserial = em.merge(orcamentoprodserialCollectionNewOrcamentoprodserial);
                    if (oldCodprodutoserialOfOrcamentoprodserialCollectionNewOrcamentoprodserial != null && !oldCodprodutoserialOfOrcamentoprodserialCollectionNewOrcamentoprodserial.equals(produtoserial)) {
                        oldCodprodutoserialOfOrcamentoprodserialCollectionNewOrcamentoprodserial.getOrcamentoprodserialCollection().remove(orcamentoprodserialCollectionNewOrcamentoprodserial);
                        oldCodprodutoserialOfOrcamentoprodserialCollectionNewOrcamentoprodserial = em.merge(oldCodprodutoserialOfOrcamentoprodserialCollectionNewOrcamentoprodserial);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = produtoserial.getCodprodutoserial();
                if (findProdutoserial(id) == null) {
                    throw new NonexistentEntityException("The produtoserial with id " + id + " no longer exists.");
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
            Produtoserial produtoserial;
            try {
                produtoserial = em.getReference(Produtoserial.class, id);
                produtoserial.getCodprodutoserial();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtoserial with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Moventradaprodserial> moventradaprodserialCollectionOrphanCheck = produtoserial.getMoventradaprodserialCollection();
            for (Moventradaprodserial moventradaprodserialCollectionOrphanCheckMoventradaprodserial : moventradaprodserialCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Produtoserial (" + produtoserial + ") cannot be destroyed since the Moventradaprodserial " + moventradaprodserialCollectionOrphanCheckMoventradaprodserial + " in its moventradaprodserialCollection field has a non-nullable codprodutoserial field.");
            }
            Collection<OsProdservserial> osProdservserialCollectionOrphanCheck = produtoserial.getOsProdservserialCollection();
            for (OsProdservserial osProdservserialCollectionOrphanCheckOsProdservserial : osProdservserialCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Produtoserial (" + produtoserial + ") cannot be destroyed since the OsProdservserial " + osProdservserialCollectionOrphanCheckOsProdservserial + " in its osProdservserialCollection field has a non-nullable codprodutoserial field.");
            }
            Collection<Movendaprodserial> movendaprodserialCollectionOrphanCheck = produtoserial.getMovendaprodserialCollection();
            for (Movendaprodserial movendaprodserialCollectionOrphanCheckMovendaprodserial : movendaprodserialCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Produtoserial (" + produtoserial + ") cannot be destroyed since the Movendaprodserial " + movendaprodserialCollectionOrphanCheckMovendaprodserial + " in its movendaprodserialCollection field has a non-nullable codprodutoserial field.");
            }
            Collection<Orcamentoprodserial> orcamentoprodserialCollectionOrphanCheck = produtoserial.getOrcamentoprodserialCollection();
            for (Orcamentoprodserial orcamentoprodserialCollectionOrphanCheckOrcamentoprodserial : orcamentoprodserialCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Produtoserial (" + produtoserial + ") cannot be destroyed since the Orcamentoprodserial " + orcamentoprodserialCollectionOrphanCheckOrcamentoprodserial + " in its orcamentoprodserialCollection field has a non-nullable codprodutoserial field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Consignacaobaixa> consignacaobaixaCollection = produtoserial.getConsignacaobaixaCollection();
            for (Consignacaobaixa consignacaobaixaCollectionConsignacaobaixa : consignacaobaixaCollection) {
                consignacaobaixaCollectionConsignacaobaixa.setCodprodutoserial(null);
                consignacaobaixaCollectionConsignacaobaixa = em.merge(consignacaobaixaCollectionConsignacaobaixa);
            }
            em.remove(produtoserial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtoserial> findProdutoserialEntities() {
        return findProdutoserialEntities(true, -1, -1);
    }

    public List<Produtoserial> findProdutoserialEntities(int maxResults, int firstResult) {
        return findProdutoserialEntities(false, maxResults, firstResult);
    }

    private List<Produtoserial> findProdutoserialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtoserial.class));
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

    public Produtoserial findProdutoserial(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtoserial.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutoserialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtoserial> rt = cq.from(Produtoserial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

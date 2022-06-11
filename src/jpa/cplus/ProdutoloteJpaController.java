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
import entidade.cplus.Produto;
import entidade.cplus.Orcamentoprodlote;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Moventradaprodlote;
import entidade.cplus.Consignacaobaixa;
import entidade.cplus.OsProdservlote;
import entidade.cplus.Movendaprodlote;
import entidade.cplus.Produtoestoquelote;
import entidade.cplus.Produtolote;
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
public class ProdutoloteJpaController implements Serializable {

    public ProdutoloteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtolote produtolote) throws PreexistingEntityException, Exception {
        if (produtolote.getOrcamentoprodloteCollection() == null) {
            produtolote.setOrcamentoprodloteCollection(new ArrayList<Orcamentoprodlote>());
        }
        if (produtolote.getMoventradaprodloteCollection() == null) {
            produtolote.setMoventradaprodloteCollection(new ArrayList<Moventradaprodlote>());
        }
        if (produtolote.getConsignacaobaixaCollection() == null) {
            produtolote.setConsignacaobaixaCollection(new ArrayList<Consignacaobaixa>());
        }
        if (produtolote.getOsProdservloteCollection() == null) {
            produtolote.setOsProdservloteCollection(new ArrayList<OsProdservlote>());
        }
        if (produtolote.getMovendaprodloteCollection() == null) {
            produtolote.setMovendaprodloteCollection(new ArrayList<Movendaprodlote>());
        }
        if (produtolote.getProdutoestoqueloteCollection() == null) {
            produtolote.setProdutoestoqueloteCollection(new ArrayList<Produtoestoquelote>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto codprod = produtolote.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                produtolote.setCodprod(codprod);
            }
            Collection<Orcamentoprodlote> attachedOrcamentoprodloteCollection = new ArrayList<Orcamentoprodlote>();
            for (Orcamentoprodlote orcamentoprodloteCollectionOrcamentoprodloteToAttach : produtolote.getOrcamentoprodloteCollection()) {
                orcamentoprodloteCollectionOrcamentoprodloteToAttach = em.getReference(orcamentoprodloteCollectionOrcamentoprodloteToAttach.getClass(), orcamentoprodloteCollectionOrcamentoprodloteToAttach.getCodorcamentoprodlote());
                attachedOrcamentoprodloteCollection.add(orcamentoprodloteCollectionOrcamentoprodloteToAttach);
            }
            produtolote.setOrcamentoprodloteCollection(attachedOrcamentoprodloteCollection);
            Collection<Moventradaprodlote> attachedMoventradaprodloteCollection = new ArrayList<Moventradaprodlote>();
            for (Moventradaprodlote moventradaprodloteCollectionMoventradaprodloteToAttach : produtolote.getMoventradaprodloteCollection()) {
                moventradaprodloteCollectionMoventradaprodloteToAttach = em.getReference(moventradaprodloteCollectionMoventradaprodloteToAttach.getClass(), moventradaprodloteCollectionMoventradaprodloteToAttach.getCodmoventradaprodlote());
                attachedMoventradaprodloteCollection.add(moventradaprodloteCollectionMoventradaprodloteToAttach);
            }
            produtolote.setMoventradaprodloteCollection(attachedMoventradaprodloteCollection);
            Collection<Consignacaobaixa> attachedConsignacaobaixaCollection = new ArrayList<Consignacaobaixa>();
            for (Consignacaobaixa consignacaobaixaCollectionConsignacaobaixaToAttach : produtolote.getConsignacaobaixaCollection()) {
                consignacaobaixaCollectionConsignacaobaixaToAttach = em.getReference(consignacaobaixaCollectionConsignacaobaixaToAttach.getClass(), consignacaobaixaCollectionConsignacaobaixaToAttach.getCodconsignacaobaixa());
                attachedConsignacaobaixaCollection.add(consignacaobaixaCollectionConsignacaobaixaToAttach);
            }
            produtolote.setConsignacaobaixaCollection(attachedConsignacaobaixaCollection);
            Collection<OsProdservlote> attachedOsProdservloteCollection = new ArrayList<OsProdservlote>();
            for (OsProdservlote osProdservloteCollectionOsProdservloteToAttach : produtolote.getOsProdservloteCollection()) {
                osProdservloteCollectionOsProdservloteToAttach = em.getReference(osProdservloteCollectionOsProdservloteToAttach.getClass(), osProdservloteCollectionOsProdservloteToAttach.getCodprodservlote());
                attachedOsProdservloteCollection.add(osProdservloteCollectionOsProdservloteToAttach);
            }
            produtolote.setOsProdservloteCollection(attachedOsProdservloteCollection);
            Collection<Movendaprodlote> attachedMovendaprodloteCollection = new ArrayList<Movendaprodlote>();
            for (Movendaprodlote movendaprodloteCollectionMovendaprodloteToAttach : produtolote.getMovendaprodloteCollection()) {
                movendaprodloteCollectionMovendaprodloteToAttach = em.getReference(movendaprodloteCollectionMovendaprodloteToAttach.getClass(), movendaprodloteCollectionMovendaprodloteToAttach.getCodmovendaprodlote());
                attachedMovendaprodloteCollection.add(movendaprodloteCollectionMovendaprodloteToAttach);
            }
            produtolote.setMovendaprodloteCollection(attachedMovendaprodloteCollection);
            Collection<Produtoestoquelote> attachedProdutoestoqueloteCollection = new ArrayList<Produtoestoquelote>();
            for (Produtoestoquelote produtoestoqueloteCollectionProdutoestoqueloteToAttach : produtolote.getProdutoestoqueloteCollection()) {
                produtoestoqueloteCollectionProdutoestoqueloteToAttach = em.getReference(produtoestoqueloteCollectionProdutoestoqueloteToAttach.getClass(), produtoestoqueloteCollectionProdutoestoqueloteToAttach.getCodprodutoestoquelote());
                attachedProdutoestoqueloteCollection.add(produtoestoqueloteCollectionProdutoestoqueloteToAttach);
            }
            produtolote.setProdutoestoqueloteCollection(attachedProdutoestoqueloteCollection);
            em.persist(produtolote);
            if (codprod != null) {
                codprod.getProdutoloteCollection().add(produtolote);
                codprod = em.merge(codprod);
            }
            for (Orcamentoprodlote orcamentoprodloteCollectionOrcamentoprodlote : produtolote.getOrcamentoprodloteCollection()) {
                Produtolote oldCodprodutoloteOfOrcamentoprodloteCollectionOrcamentoprodlote = orcamentoprodloteCollectionOrcamentoprodlote.getCodprodutolote();
                orcamentoprodloteCollectionOrcamentoprodlote.setCodprodutolote(produtolote);
                orcamentoprodloteCollectionOrcamentoprodlote = em.merge(orcamentoprodloteCollectionOrcamentoprodlote);
                if (oldCodprodutoloteOfOrcamentoprodloteCollectionOrcamentoprodlote != null) {
                    oldCodprodutoloteOfOrcamentoprodloteCollectionOrcamentoprodlote.getOrcamentoprodloteCollection().remove(orcamentoprodloteCollectionOrcamentoprodlote);
                    oldCodprodutoloteOfOrcamentoprodloteCollectionOrcamentoprodlote = em.merge(oldCodprodutoloteOfOrcamentoprodloteCollectionOrcamentoprodlote);
                }
            }
            for (Moventradaprodlote moventradaprodloteCollectionMoventradaprodlote : produtolote.getMoventradaprodloteCollection()) {
                Produtolote oldCodprodutoloteOfMoventradaprodloteCollectionMoventradaprodlote = moventradaprodloteCollectionMoventradaprodlote.getCodprodutolote();
                moventradaprodloteCollectionMoventradaprodlote.setCodprodutolote(produtolote);
                moventradaprodloteCollectionMoventradaprodlote = em.merge(moventradaprodloteCollectionMoventradaprodlote);
                if (oldCodprodutoloteOfMoventradaprodloteCollectionMoventradaprodlote != null) {
                    oldCodprodutoloteOfMoventradaprodloteCollectionMoventradaprodlote.getMoventradaprodloteCollection().remove(moventradaprodloteCollectionMoventradaprodlote);
                    oldCodprodutoloteOfMoventradaprodloteCollectionMoventradaprodlote = em.merge(oldCodprodutoloteOfMoventradaprodloteCollectionMoventradaprodlote);
                }
            }
            for (Consignacaobaixa consignacaobaixaCollectionConsignacaobaixa : produtolote.getConsignacaobaixaCollection()) {
                Produtolote oldCodprodutoloteOfConsignacaobaixaCollectionConsignacaobaixa = consignacaobaixaCollectionConsignacaobaixa.getCodprodutolote();
                consignacaobaixaCollectionConsignacaobaixa.setCodprodutolote(produtolote);
                consignacaobaixaCollectionConsignacaobaixa = em.merge(consignacaobaixaCollectionConsignacaobaixa);
                if (oldCodprodutoloteOfConsignacaobaixaCollectionConsignacaobaixa != null) {
                    oldCodprodutoloteOfConsignacaobaixaCollectionConsignacaobaixa.getConsignacaobaixaCollection().remove(consignacaobaixaCollectionConsignacaobaixa);
                    oldCodprodutoloteOfConsignacaobaixaCollectionConsignacaobaixa = em.merge(oldCodprodutoloteOfConsignacaobaixaCollectionConsignacaobaixa);
                }
            }
            for (OsProdservlote osProdservloteCollectionOsProdservlote : produtolote.getOsProdservloteCollection()) {
                Produtolote oldCodprodutoloteOfOsProdservloteCollectionOsProdservlote = osProdservloteCollectionOsProdservlote.getCodprodutolote();
                osProdservloteCollectionOsProdservlote.setCodprodutolote(produtolote);
                osProdservloteCollectionOsProdservlote = em.merge(osProdservloteCollectionOsProdservlote);
                if (oldCodprodutoloteOfOsProdservloteCollectionOsProdservlote != null) {
                    oldCodprodutoloteOfOsProdservloteCollectionOsProdservlote.getOsProdservloteCollection().remove(osProdservloteCollectionOsProdservlote);
                    oldCodprodutoloteOfOsProdservloteCollectionOsProdservlote = em.merge(oldCodprodutoloteOfOsProdservloteCollectionOsProdservlote);
                }
            }
            for (Movendaprodlote movendaprodloteCollectionMovendaprodlote : produtolote.getMovendaprodloteCollection()) {
                Produtolote oldCodprodutoloteOfMovendaprodloteCollectionMovendaprodlote = movendaprodloteCollectionMovendaprodlote.getCodprodutolote();
                movendaprodloteCollectionMovendaprodlote.setCodprodutolote(produtolote);
                movendaprodloteCollectionMovendaprodlote = em.merge(movendaprodloteCollectionMovendaprodlote);
                if (oldCodprodutoloteOfMovendaprodloteCollectionMovendaprodlote != null) {
                    oldCodprodutoloteOfMovendaprodloteCollectionMovendaprodlote.getMovendaprodloteCollection().remove(movendaprodloteCollectionMovendaprodlote);
                    oldCodprodutoloteOfMovendaprodloteCollectionMovendaprodlote = em.merge(oldCodprodutoloteOfMovendaprodloteCollectionMovendaprodlote);
                }
            }
            for (Produtoestoquelote produtoestoqueloteCollectionProdutoestoquelote : produtolote.getProdutoestoqueloteCollection()) {
                Produtolote oldCodprodutoloteOfProdutoestoqueloteCollectionProdutoestoquelote = produtoestoqueloteCollectionProdutoestoquelote.getCodprodutolote();
                produtoestoqueloteCollectionProdutoestoquelote.setCodprodutolote(produtolote);
                produtoestoqueloteCollectionProdutoestoquelote = em.merge(produtoestoqueloteCollectionProdutoestoquelote);
                if (oldCodprodutoloteOfProdutoestoqueloteCollectionProdutoestoquelote != null) {
                    oldCodprodutoloteOfProdutoestoqueloteCollectionProdutoestoquelote.getProdutoestoqueloteCollection().remove(produtoestoqueloteCollectionProdutoestoquelote);
                    oldCodprodutoloteOfProdutoestoqueloteCollectionProdutoestoquelote = em.merge(oldCodprodutoloteOfProdutoestoqueloteCollectionProdutoestoquelote);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProdutolote(produtolote.getCodprodutolote()) != null) {
                throw new PreexistingEntityException("Produtolote " + produtolote + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtolote produtolote) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produtolote persistentProdutolote = em.find(Produtolote.class, produtolote.getCodprodutolote());
            Produto codprodOld = persistentProdutolote.getCodprod();
            Produto codprodNew = produtolote.getCodprod();
            Collection<Orcamentoprodlote> orcamentoprodloteCollectionOld = persistentProdutolote.getOrcamentoprodloteCollection();
            Collection<Orcamentoprodlote> orcamentoprodloteCollectionNew = produtolote.getOrcamentoprodloteCollection();
            Collection<Moventradaprodlote> moventradaprodloteCollectionOld = persistentProdutolote.getMoventradaprodloteCollection();
            Collection<Moventradaprodlote> moventradaprodloteCollectionNew = produtolote.getMoventradaprodloteCollection();
            Collection<Consignacaobaixa> consignacaobaixaCollectionOld = persistentProdutolote.getConsignacaobaixaCollection();
            Collection<Consignacaobaixa> consignacaobaixaCollectionNew = produtolote.getConsignacaobaixaCollection();
            Collection<OsProdservlote> osProdservloteCollectionOld = persistentProdutolote.getOsProdservloteCollection();
            Collection<OsProdservlote> osProdservloteCollectionNew = produtolote.getOsProdservloteCollection();
            Collection<Movendaprodlote> movendaprodloteCollectionOld = persistentProdutolote.getMovendaprodloteCollection();
            Collection<Movendaprodlote> movendaprodloteCollectionNew = produtolote.getMovendaprodloteCollection();
            Collection<Produtoestoquelote> produtoestoqueloteCollectionOld = persistentProdutolote.getProdutoestoqueloteCollection();
            Collection<Produtoestoquelote> produtoestoqueloteCollectionNew = produtolote.getProdutoestoqueloteCollection();
            List<String> illegalOrphanMessages = null;
            for (Orcamentoprodlote orcamentoprodloteCollectionOldOrcamentoprodlote : orcamentoprodloteCollectionOld) {
                if (!orcamentoprodloteCollectionNew.contains(orcamentoprodloteCollectionOldOrcamentoprodlote)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Orcamentoprodlote " + orcamentoprodloteCollectionOldOrcamentoprodlote + " since its codprodutolote field is not nullable.");
                }
            }
            for (Moventradaprodlote moventradaprodloteCollectionOldMoventradaprodlote : moventradaprodloteCollectionOld) {
                if (!moventradaprodloteCollectionNew.contains(moventradaprodloteCollectionOldMoventradaprodlote)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Moventradaprodlote " + moventradaprodloteCollectionOldMoventradaprodlote + " since its codprodutolote field is not nullable.");
                }
            }
            for (OsProdservlote osProdservloteCollectionOldOsProdservlote : osProdservloteCollectionOld) {
                if (!osProdservloteCollectionNew.contains(osProdservloteCollectionOldOsProdservlote)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain OsProdservlote " + osProdservloteCollectionOldOsProdservlote + " since its codprodutolote field is not nullable.");
                }
            }
            for (Movendaprodlote movendaprodloteCollectionOldMovendaprodlote : movendaprodloteCollectionOld) {
                if (!movendaprodloteCollectionNew.contains(movendaprodloteCollectionOldMovendaprodlote)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Movendaprodlote " + movendaprodloteCollectionOldMovendaprodlote + " since its codprodutolote field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                produtolote.setCodprod(codprodNew);
            }
            Collection<Orcamentoprodlote> attachedOrcamentoprodloteCollectionNew = new ArrayList<Orcamentoprodlote>();
            for (Orcamentoprodlote orcamentoprodloteCollectionNewOrcamentoprodloteToAttach : orcamentoprodloteCollectionNew) {
                orcamentoprodloteCollectionNewOrcamentoprodloteToAttach = em.getReference(orcamentoprodloteCollectionNewOrcamentoprodloteToAttach.getClass(), orcamentoprodloteCollectionNewOrcamentoprodloteToAttach.getCodorcamentoprodlote());
                attachedOrcamentoprodloteCollectionNew.add(orcamentoprodloteCollectionNewOrcamentoprodloteToAttach);
            }
            orcamentoprodloteCollectionNew = attachedOrcamentoprodloteCollectionNew;
            produtolote.setOrcamentoprodloteCollection(orcamentoprodloteCollectionNew);
            Collection<Moventradaprodlote> attachedMoventradaprodloteCollectionNew = new ArrayList<Moventradaprodlote>();
            for (Moventradaprodlote moventradaprodloteCollectionNewMoventradaprodloteToAttach : moventradaprodloteCollectionNew) {
                moventradaprodloteCollectionNewMoventradaprodloteToAttach = em.getReference(moventradaprodloteCollectionNewMoventradaprodloteToAttach.getClass(), moventradaprodloteCollectionNewMoventradaprodloteToAttach.getCodmoventradaprodlote());
                attachedMoventradaprodloteCollectionNew.add(moventradaprodloteCollectionNewMoventradaprodloteToAttach);
            }
            moventradaprodloteCollectionNew = attachedMoventradaprodloteCollectionNew;
            produtolote.setMoventradaprodloteCollection(moventradaprodloteCollectionNew);
            Collection<Consignacaobaixa> attachedConsignacaobaixaCollectionNew = new ArrayList<Consignacaobaixa>();
            for (Consignacaobaixa consignacaobaixaCollectionNewConsignacaobaixaToAttach : consignacaobaixaCollectionNew) {
                consignacaobaixaCollectionNewConsignacaobaixaToAttach = em.getReference(consignacaobaixaCollectionNewConsignacaobaixaToAttach.getClass(), consignacaobaixaCollectionNewConsignacaobaixaToAttach.getCodconsignacaobaixa());
                attachedConsignacaobaixaCollectionNew.add(consignacaobaixaCollectionNewConsignacaobaixaToAttach);
            }
            consignacaobaixaCollectionNew = attachedConsignacaobaixaCollectionNew;
            produtolote.setConsignacaobaixaCollection(consignacaobaixaCollectionNew);
            Collection<OsProdservlote> attachedOsProdservloteCollectionNew = new ArrayList<OsProdservlote>();
            for (OsProdservlote osProdservloteCollectionNewOsProdservloteToAttach : osProdservloteCollectionNew) {
                osProdservloteCollectionNewOsProdservloteToAttach = em.getReference(osProdservloteCollectionNewOsProdservloteToAttach.getClass(), osProdservloteCollectionNewOsProdservloteToAttach.getCodprodservlote());
                attachedOsProdservloteCollectionNew.add(osProdservloteCollectionNewOsProdservloteToAttach);
            }
            osProdservloteCollectionNew = attachedOsProdservloteCollectionNew;
            produtolote.setOsProdservloteCollection(osProdservloteCollectionNew);
            Collection<Movendaprodlote> attachedMovendaprodloteCollectionNew = new ArrayList<Movendaprodlote>();
            for (Movendaprodlote movendaprodloteCollectionNewMovendaprodloteToAttach : movendaprodloteCollectionNew) {
                movendaprodloteCollectionNewMovendaprodloteToAttach = em.getReference(movendaprodloteCollectionNewMovendaprodloteToAttach.getClass(), movendaprodloteCollectionNewMovendaprodloteToAttach.getCodmovendaprodlote());
                attachedMovendaprodloteCollectionNew.add(movendaprodloteCollectionNewMovendaprodloteToAttach);
            }
            movendaprodloteCollectionNew = attachedMovendaprodloteCollectionNew;
            produtolote.setMovendaprodloteCollection(movendaprodloteCollectionNew);
            Collection<Produtoestoquelote> attachedProdutoestoqueloteCollectionNew = new ArrayList<Produtoestoquelote>();
            for (Produtoestoquelote produtoestoqueloteCollectionNewProdutoestoqueloteToAttach : produtoestoqueloteCollectionNew) {
                produtoestoqueloteCollectionNewProdutoestoqueloteToAttach = em.getReference(produtoestoqueloteCollectionNewProdutoestoqueloteToAttach.getClass(), produtoestoqueloteCollectionNewProdutoestoqueloteToAttach.getCodprodutoestoquelote());
                attachedProdutoestoqueloteCollectionNew.add(produtoestoqueloteCollectionNewProdutoestoqueloteToAttach);
            }
            produtoestoqueloteCollectionNew = attachedProdutoestoqueloteCollectionNew;
            produtolote.setProdutoestoqueloteCollection(produtoestoqueloteCollectionNew);
            produtolote = em.merge(produtolote);
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getProdutoloteCollection().remove(produtolote);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getProdutoloteCollection().add(produtolote);
                codprodNew = em.merge(codprodNew);
            }
            for (Orcamentoprodlote orcamentoprodloteCollectionNewOrcamentoprodlote : orcamentoprodloteCollectionNew) {
                if (!orcamentoprodloteCollectionOld.contains(orcamentoprodloteCollectionNewOrcamentoprodlote)) {
                    Produtolote oldCodprodutoloteOfOrcamentoprodloteCollectionNewOrcamentoprodlote = orcamentoprodloteCollectionNewOrcamentoprodlote.getCodprodutolote();
                    orcamentoprodloteCollectionNewOrcamentoprodlote.setCodprodutolote(produtolote);
                    orcamentoprodloteCollectionNewOrcamentoprodlote = em.merge(orcamentoprodloteCollectionNewOrcamentoprodlote);
                    if (oldCodprodutoloteOfOrcamentoprodloteCollectionNewOrcamentoprodlote != null && !oldCodprodutoloteOfOrcamentoprodloteCollectionNewOrcamentoprodlote.equals(produtolote)) {
                        oldCodprodutoloteOfOrcamentoprodloteCollectionNewOrcamentoprodlote.getOrcamentoprodloteCollection().remove(orcamentoprodloteCollectionNewOrcamentoprodlote);
                        oldCodprodutoloteOfOrcamentoprodloteCollectionNewOrcamentoprodlote = em.merge(oldCodprodutoloteOfOrcamentoprodloteCollectionNewOrcamentoprodlote);
                    }
                }
            }
            for (Moventradaprodlote moventradaprodloteCollectionNewMoventradaprodlote : moventradaprodloteCollectionNew) {
                if (!moventradaprodloteCollectionOld.contains(moventradaprodloteCollectionNewMoventradaprodlote)) {
                    Produtolote oldCodprodutoloteOfMoventradaprodloteCollectionNewMoventradaprodlote = moventradaprodloteCollectionNewMoventradaprodlote.getCodprodutolote();
                    moventradaprodloteCollectionNewMoventradaprodlote.setCodprodutolote(produtolote);
                    moventradaprodloteCollectionNewMoventradaprodlote = em.merge(moventradaprodloteCollectionNewMoventradaprodlote);
                    if (oldCodprodutoloteOfMoventradaprodloteCollectionNewMoventradaprodlote != null && !oldCodprodutoloteOfMoventradaprodloteCollectionNewMoventradaprodlote.equals(produtolote)) {
                        oldCodprodutoloteOfMoventradaprodloteCollectionNewMoventradaprodlote.getMoventradaprodloteCollection().remove(moventradaprodloteCollectionNewMoventradaprodlote);
                        oldCodprodutoloteOfMoventradaprodloteCollectionNewMoventradaprodlote = em.merge(oldCodprodutoloteOfMoventradaprodloteCollectionNewMoventradaprodlote);
                    }
                }
            }
            for (Consignacaobaixa consignacaobaixaCollectionOldConsignacaobaixa : consignacaobaixaCollectionOld) {
                if (!consignacaobaixaCollectionNew.contains(consignacaobaixaCollectionOldConsignacaobaixa)) {
                    consignacaobaixaCollectionOldConsignacaobaixa.setCodprodutolote(null);
                    consignacaobaixaCollectionOldConsignacaobaixa = em.merge(consignacaobaixaCollectionOldConsignacaobaixa);
                }
            }
            for (Consignacaobaixa consignacaobaixaCollectionNewConsignacaobaixa : consignacaobaixaCollectionNew) {
                if (!consignacaobaixaCollectionOld.contains(consignacaobaixaCollectionNewConsignacaobaixa)) {
                    Produtolote oldCodprodutoloteOfConsignacaobaixaCollectionNewConsignacaobaixa = consignacaobaixaCollectionNewConsignacaobaixa.getCodprodutolote();
                    consignacaobaixaCollectionNewConsignacaobaixa.setCodprodutolote(produtolote);
                    consignacaobaixaCollectionNewConsignacaobaixa = em.merge(consignacaobaixaCollectionNewConsignacaobaixa);
                    if (oldCodprodutoloteOfConsignacaobaixaCollectionNewConsignacaobaixa != null && !oldCodprodutoloteOfConsignacaobaixaCollectionNewConsignacaobaixa.equals(produtolote)) {
                        oldCodprodutoloteOfConsignacaobaixaCollectionNewConsignacaobaixa.getConsignacaobaixaCollection().remove(consignacaobaixaCollectionNewConsignacaobaixa);
                        oldCodprodutoloteOfConsignacaobaixaCollectionNewConsignacaobaixa = em.merge(oldCodprodutoloteOfConsignacaobaixaCollectionNewConsignacaobaixa);
                    }
                }
            }
            for (OsProdservlote osProdservloteCollectionNewOsProdservlote : osProdservloteCollectionNew) {
                if (!osProdservloteCollectionOld.contains(osProdservloteCollectionNewOsProdservlote)) {
                    Produtolote oldCodprodutoloteOfOsProdservloteCollectionNewOsProdservlote = osProdservloteCollectionNewOsProdservlote.getCodprodutolote();
                    osProdservloteCollectionNewOsProdservlote.setCodprodutolote(produtolote);
                    osProdservloteCollectionNewOsProdservlote = em.merge(osProdservloteCollectionNewOsProdservlote);
                    if (oldCodprodutoloteOfOsProdservloteCollectionNewOsProdservlote != null && !oldCodprodutoloteOfOsProdservloteCollectionNewOsProdservlote.equals(produtolote)) {
                        oldCodprodutoloteOfOsProdservloteCollectionNewOsProdservlote.getOsProdservloteCollection().remove(osProdservloteCollectionNewOsProdservlote);
                        oldCodprodutoloteOfOsProdservloteCollectionNewOsProdservlote = em.merge(oldCodprodutoloteOfOsProdservloteCollectionNewOsProdservlote);
                    }
                }
            }
            for (Movendaprodlote movendaprodloteCollectionNewMovendaprodlote : movendaprodloteCollectionNew) {
                if (!movendaprodloteCollectionOld.contains(movendaprodloteCollectionNewMovendaprodlote)) {
                    Produtolote oldCodprodutoloteOfMovendaprodloteCollectionNewMovendaprodlote = movendaprodloteCollectionNewMovendaprodlote.getCodprodutolote();
                    movendaprodloteCollectionNewMovendaprodlote.setCodprodutolote(produtolote);
                    movendaprodloteCollectionNewMovendaprodlote = em.merge(movendaprodloteCollectionNewMovendaprodlote);
                    if (oldCodprodutoloteOfMovendaprodloteCollectionNewMovendaprodlote != null && !oldCodprodutoloteOfMovendaprodloteCollectionNewMovendaprodlote.equals(produtolote)) {
                        oldCodprodutoloteOfMovendaprodloteCollectionNewMovendaprodlote.getMovendaprodloteCollection().remove(movendaprodloteCollectionNewMovendaprodlote);
                        oldCodprodutoloteOfMovendaprodloteCollectionNewMovendaprodlote = em.merge(oldCodprodutoloteOfMovendaprodloteCollectionNewMovendaprodlote);
                    }
                }
            }
            for (Produtoestoquelote produtoestoqueloteCollectionOldProdutoestoquelote : produtoestoqueloteCollectionOld) {
                if (!produtoestoqueloteCollectionNew.contains(produtoestoqueloteCollectionOldProdutoestoquelote)) {
                    produtoestoqueloteCollectionOldProdutoestoquelote.setCodprodutolote(null);
                    produtoestoqueloteCollectionOldProdutoestoquelote = em.merge(produtoestoqueloteCollectionOldProdutoestoquelote);
                }
            }
            for (Produtoestoquelote produtoestoqueloteCollectionNewProdutoestoquelote : produtoestoqueloteCollectionNew) {
                if (!produtoestoqueloteCollectionOld.contains(produtoestoqueloteCollectionNewProdutoestoquelote)) {
                    Produtolote oldCodprodutoloteOfProdutoestoqueloteCollectionNewProdutoestoquelote = produtoestoqueloteCollectionNewProdutoestoquelote.getCodprodutolote();
                    produtoestoqueloteCollectionNewProdutoestoquelote.setCodprodutolote(produtolote);
                    produtoestoqueloteCollectionNewProdutoestoquelote = em.merge(produtoestoqueloteCollectionNewProdutoestoquelote);
                    if (oldCodprodutoloteOfProdutoestoqueloteCollectionNewProdutoestoquelote != null && !oldCodprodutoloteOfProdutoestoqueloteCollectionNewProdutoestoquelote.equals(produtolote)) {
                        oldCodprodutoloteOfProdutoestoqueloteCollectionNewProdutoestoquelote.getProdutoestoqueloteCollection().remove(produtoestoqueloteCollectionNewProdutoestoquelote);
                        oldCodprodutoloteOfProdutoestoqueloteCollectionNewProdutoestoquelote = em.merge(oldCodprodutoloteOfProdutoestoqueloteCollectionNewProdutoestoquelote);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = produtolote.getCodprodutolote();
                if (findProdutolote(id) == null) {
                    throw new NonexistentEntityException("The produtolote with id " + id + " no longer exists.");
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
            Produtolote produtolote;
            try {
                produtolote = em.getReference(Produtolote.class, id);
                produtolote.getCodprodutolote();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtolote with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Orcamentoprodlote> orcamentoprodloteCollectionOrphanCheck = produtolote.getOrcamentoprodloteCollection();
            for (Orcamentoprodlote orcamentoprodloteCollectionOrphanCheckOrcamentoprodlote : orcamentoprodloteCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Produtolote (" + produtolote + ") cannot be destroyed since the Orcamentoprodlote " + orcamentoprodloteCollectionOrphanCheckOrcamentoprodlote + " in its orcamentoprodloteCollection field has a non-nullable codprodutolote field.");
            }
            Collection<Moventradaprodlote> moventradaprodloteCollectionOrphanCheck = produtolote.getMoventradaprodloteCollection();
            for (Moventradaprodlote moventradaprodloteCollectionOrphanCheckMoventradaprodlote : moventradaprodloteCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Produtolote (" + produtolote + ") cannot be destroyed since the Moventradaprodlote " + moventradaprodloteCollectionOrphanCheckMoventradaprodlote + " in its moventradaprodloteCollection field has a non-nullable codprodutolote field.");
            }
            Collection<OsProdservlote> osProdservloteCollectionOrphanCheck = produtolote.getOsProdservloteCollection();
            for (OsProdservlote osProdservloteCollectionOrphanCheckOsProdservlote : osProdservloteCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Produtolote (" + produtolote + ") cannot be destroyed since the OsProdservlote " + osProdservloteCollectionOrphanCheckOsProdservlote + " in its osProdservloteCollection field has a non-nullable codprodutolote field.");
            }
            Collection<Movendaprodlote> movendaprodloteCollectionOrphanCheck = produtolote.getMovendaprodloteCollection();
            for (Movendaprodlote movendaprodloteCollectionOrphanCheckMovendaprodlote : movendaprodloteCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Produtolote (" + produtolote + ") cannot be destroyed since the Movendaprodlote " + movendaprodloteCollectionOrphanCheckMovendaprodlote + " in its movendaprodloteCollection field has a non-nullable codprodutolote field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Produto codprod = produtolote.getCodprod();
            if (codprod != null) {
                codprod.getProdutoloteCollection().remove(produtolote);
                codprod = em.merge(codprod);
            }
            Collection<Consignacaobaixa> consignacaobaixaCollection = produtolote.getConsignacaobaixaCollection();
            for (Consignacaobaixa consignacaobaixaCollectionConsignacaobaixa : consignacaobaixaCollection) {
                consignacaobaixaCollectionConsignacaobaixa.setCodprodutolote(null);
                consignacaobaixaCollectionConsignacaobaixa = em.merge(consignacaobaixaCollectionConsignacaobaixa);
            }
            Collection<Produtoestoquelote> produtoestoqueloteCollection = produtolote.getProdutoestoqueloteCollection();
            for (Produtoestoquelote produtoestoqueloteCollectionProdutoestoquelote : produtoestoqueloteCollection) {
                produtoestoqueloteCollectionProdutoestoquelote.setCodprodutolote(null);
                produtoestoqueloteCollectionProdutoestoquelote = em.merge(produtoestoqueloteCollectionProdutoestoquelote);
            }
            em.remove(produtolote);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtolote> findProdutoloteEntities() {
        return findProdutoloteEntities(true, -1, -1);
    }

    public List<Produtolote> findProdutoloteEntities(int maxResults, int firstResult) {
        return findProdutoloteEntities(false, maxResults, firstResult);
    }

    private List<Produtolote> findProdutoloteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtolote.class));
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

    public Produtolote findProdutolote(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtolote.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutoloteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtolote> rt = cq.from(Produtolote.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

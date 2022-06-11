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
import entidade.cplus.Cesticms;
import entidade.cplus.Classificacaofiscal;
import entidade.cplus.Unidade;
import entidade.cplus.Classificacaofiscaluf;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Pedidoitem;
import entidade.cplus.Empresatipodocumentocf;
import entidade.cplus.Regracfopitem;
import entidade.cplus.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ClassificacaofiscalJpaController implements Serializable {

    public ClassificacaofiscalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Classificacaofiscal classificacaofiscal) throws PreexistingEntityException, Exception {
        if (classificacaofiscal.getClassificacaofiscalufCollection() == null) {
            classificacaofiscal.setClassificacaofiscalufCollection(new ArrayList<Classificacaofiscaluf>());
        }
        if (classificacaofiscal.getPedidoitemCollection() == null) {
            classificacaofiscal.setPedidoitemCollection(new ArrayList<Pedidoitem>());
        }
        if (classificacaofiscal.getEmpresatipodocumentocfCollection() == null) {
            classificacaofiscal.setEmpresatipodocumentocfCollection(new ArrayList<Empresatipodocumentocf>());
        }
        if (classificacaofiscal.getRegracfopitemCollection() == null) {
            classificacaofiscal.setRegracfopitemCollection(new ArrayList<Regracfopitem>());
        }
        if (classificacaofiscal.getProdutoCollection() == null) {
            classificacaofiscal.setProdutoCollection(new ArrayList<Produto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cesticms codcesticms = classificacaofiscal.getCodcesticms();
            if (codcesticms != null) {
                codcesticms = em.getReference(codcesticms.getClass(), codcesticms.getCodcesticms());
                classificacaofiscal.setCodcesticms(codcesticms);
            }
            Unidade codunidade = classificacaofiscal.getCodunidade();
            if (codunidade != null) {
                codunidade = em.getReference(codunidade.getClass(), codunidade.getCodunidade());
                classificacaofiscal.setCodunidade(codunidade);
            }
            Collection<Classificacaofiscaluf> attachedClassificacaofiscalufCollection = new ArrayList<Classificacaofiscaluf>();
            for (Classificacaofiscaluf classificacaofiscalufCollectionClassificacaofiscalufToAttach : classificacaofiscal.getClassificacaofiscalufCollection()) {
                classificacaofiscalufCollectionClassificacaofiscalufToAttach = em.getReference(classificacaofiscalufCollectionClassificacaofiscalufToAttach.getClass(), classificacaofiscalufCollectionClassificacaofiscalufToAttach.getCodclassificacaofiscaluf());
                attachedClassificacaofiscalufCollection.add(classificacaofiscalufCollectionClassificacaofiscalufToAttach);
            }
            classificacaofiscal.setClassificacaofiscalufCollection(attachedClassificacaofiscalufCollection);
            Collection<Pedidoitem> attachedPedidoitemCollection = new ArrayList<Pedidoitem>();
            for (Pedidoitem pedidoitemCollectionPedidoitemToAttach : classificacaofiscal.getPedidoitemCollection()) {
                pedidoitemCollectionPedidoitemToAttach = em.getReference(pedidoitemCollectionPedidoitemToAttach.getClass(), pedidoitemCollectionPedidoitemToAttach.getCodpedidoitem());
                attachedPedidoitemCollection.add(pedidoitemCollectionPedidoitemToAttach);
            }
            classificacaofiscal.setPedidoitemCollection(attachedPedidoitemCollection);
            Collection<Empresatipodocumentocf> attachedEmpresatipodocumentocfCollection = new ArrayList<Empresatipodocumentocf>();
            for (Empresatipodocumentocf empresatipodocumentocfCollectionEmpresatipodocumentocfToAttach : classificacaofiscal.getEmpresatipodocumentocfCollection()) {
                empresatipodocumentocfCollectionEmpresatipodocumentocfToAttach = em.getReference(empresatipodocumentocfCollectionEmpresatipodocumentocfToAttach.getClass(), empresatipodocumentocfCollectionEmpresatipodocumentocfToAttach.getCodempresatipodocumentocf());
                attachedEmpresatipodocumentocfCollection.add(empresatipodocumentocfCollectionEmpresatipodocumentocfToAttach);
            }
            classificacaofiscal.setEmpresatipodocumentocfCollection(attachedEmpresatipodocumentocfCollection);
            Collection<Regracfopitem> attachedRegracfopitemCollection = new ArrayList<Regracfopitem>();
            for (Regracfopitem regracfopitemCollectionRegracfopitemToAttach : classificacaofiscal.getRegracfopitemCollection()) {
                regracfopitemCollectionRegracfopitemToAttach = em.getReference(regracfopitemCollectionRegracfopitemToAttach.getClass(), regracfopitemCollectionRegracfopitemToAttach.getCodregracfopitem());
                attachedRegracfopitemCollection.add(regracfopitemCollectionRegracfopitemToAttach);
            }
            classificacaofiscal.setRegracfopitemCollection(attachedRegracfopitemCollection);
            Collection<Produto> attachedProdutoCollection = new ArrayList<Produto>();
            for (Produto produtoCollectionProdutoToAttach : classificacaofiscal.getProdutoCollection()) {
                produtoCollectionProdutoToAttach = em.getReference(produtoCollectionProdutoToAttach.getClass(), produtoCollectionProdutoToAttach.getCodprod());
                attachedProdutoCollection.add(produtoCollectionProdutoToAttach);
            }
            classificacaofiscal.setProdutoCollection(attachedProdutoCollection);
            em.persist(classificacaofiscal);
            if (codcesticms != null) {
                codcesticms.getClassificacaofiscalCollection().add(classificacaofiscal);
                codcesticms = em.merge(codcesticms);
            }
            if (codunidade != null) {
                codunidade.getClassificacaofiscalCollection().add(classificacaofiscal);
                codunidade = em.merge(codunidade);
            }
            for (Classificacaofiscaluf classificacaofiscalufCollectionClassificacaofiscaluf : classificacaofiscal.getClassificacaofiscalufCollection()) {
                Classificacaofiscal oldCodclassificacaofiscalOfClassificacaofiscalufCollectionClassificacaofiscaluf = classificacaofiscalufCollectionClassificacaofiscaluf.getCodclassificacaofiscal();
                classificacaofiscalufCollectionClassificacaofiscaluf.setCodclassificacaofiscal(classificacaofiscal);
                classificacaofiscalufCollectionClassificacaofiscaluf = em.merge(classificacaofiscalufCollectionClassificacaofiscaluf);
                if (oldCodclassificacaofiscalOfClassificacaofiscalufCollectionClassificacaofiscaluf != null) {
                    oldCodclassificacaofiscalOfClassificacaofiscalufCollectionClassificacaofiscaluf.getClassificacaofiscalufCollection().remove(classificacaofiscalufCollectionClassificacaofiscaluf);
                    oldCodclassificacaofiscalOfClassificacaofiscalufCollectionClassificacaofiscaluf = em.merge(oldCodclassificacaofiscalOfClassificacaofiscalufCollectionClassificacaofiscaluf);
                }
            }
            for (Pedidoitem pedidoitemCollectionPedidoitem : classificacaofiscal.getPedidoitemCollection()) {
                Classificacaofiscal oldCodclassificacaofiscalOfPedidoitemCollectionPedidoitem = pedidoitemCollectionPedidoitem.getCodclassificacaofiscal();
                pedidoitemCollectionPedidoitem.setCodclassificacaofiscal(classificacaofiscal);
                pedidoitemCollectionPedidoitem = em.merge(pedidoitemCollectionPedidoitem);
                if (oldCodclassificacaofiscalOfPedidoitemCollectionPedidoitem != null) {
                    oldCodclassificacaofiscalOfPedidoitemCollectionPedidoitem.getPedidoitemCollection().remove(pedidoitemCollectionPedidoitem);
                    oldCodclassificacaofiscalOfPedidoitemCollectionPedidoitem = em.merge(oldCodclassificacaofiscalOfPedidoitemCollectionPedidoitem);
                }
            }
            for (Empresatipodocumentocf empresatipodocumentocfCollectionEmpresatipodocumentocf : classificacaofiscal.getEmpresatipodocumentocfCollection()) {
                Classificacaofiscal oldCodclassificacaofiscalOfEmpresatipodocumentocfCollectionEmpresatipodocumentocf = empresatipodocumentocfCollectionEmpresatipodocumentocf.getCodclassificacaofiscal();
                empresatipodocumentocfCollectionEmpresatipodocumentocf.setCodclassificacaofiscal(classificacaofiscal);
                empresatipodocumentocfCollectionEmpresatipodocumentocf = em.merge(empresatipodocumentocfCollectionEmpresatipodocumentocf);
                if (oldCodclassificacaofiscalOfEmpresatipodocumentocfCollectionEmpresatipodocumentocf != null) {
                    oldCodclassificacaofiscalOfEmpresatipodocumentocfCollectionEmpresatipodocumentocf.getEmpresatipodocumentocfCollection().remove(empresatipodocumentocfCollectionEmpresatipodocumentocf);
                    oldCodclassificacaofiscalOfEmpresatipodocumentocfCollectionEmpresatipodocumentocf = em.merge(oldCodclassificacaofiscalOfEmpresatipodocumentocfCollectionEmpresatipodocumentocf);
                }
            }
            for (Regracfopitem regracfopitemCollectionRegracfopitem : classificacaofiscal.getRegracfopitemCollection()) {
                Classificacaofiscal oldCodclassificacaofiscalOfRegracfopitemCollectionRegracfopitem = regracfopitemCollectionRegracfopitem.getCodclassificacaofiscal();
                regracfopitemCollectionRegracfopitem.setCodclassificacaofiscal(classificacaofiscal);
                regracfopitemCollectionRegracfopitem = em.merge(regracfopitemCollectionRegracfopitem);
                if (oldCodclassificacaofiscalOfRegracfopitemCollectionRegracfopitem != null) {
                    oldCodclassificacaofiscalOfRegracfopitemCollectionRegracfopitem.getRegracfopitemCollection().remove(regracfopitemCollectionRegracfopitem);
                    oldCodclassificacaofiscalOfRegracfopitemCollectionRegracfopitem = em.merge(oldCodclassificacaofiscalOfRegracfopitemCollectionRegracfopitem);
                }
            }
            for (Produto produtoCollectionProduto : classificacaofiscal.getProdutoCollection()) {
                Classificacaofiscal oldCodclassificacaofiscalOfProdutoCollectionProduto = produtoCollectionProduto.getCodclassificacaofiscal();
                produtoCollectionProduto.setCodclassificacaofiscal(classificacaofiscal);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
                if (oldCodclassificacaofiscalOfProdutoCollectionProduto != null) {
                    oldCodclassificacaofiscalOfProdutoCollectionProduto.getProdutoCollection().remove(produtoCollectionProduto);
                    oldCodclassificacaofiscalOfProdutoCollectionProduto = em.merge(oldCodclassificacaofiscalOfProdutoCollectionProduto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findClassificacaofiscal(classificacaofiscal.getCodclassificacaofiscal()) != null) {
                throw new PreexistingEntityException("Classificacaofiscal " + classificacaofiscal + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Classificacaofiscal classificacaofiscal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Classificacaofiscal persistentClassificacaofiscal = em.find(Classificacaofiscal.class, classificacaofiscal.getCodclassificacaofiscal());
            Cesticms codcesticmsOld = persistentClassificacaofiscal.getCodcesticms();
            Cesticms codcesticmsNew = classificacaofiscal.getCodcesticms();
            Unidade codunidadeOld = persistentClassificacaofiscal.getCodunidade();
            Unidade codunidadeNew = classificacaofiscal.getCodunidade();
            Collection<Classificacaofiscaluf> classificacaofiscalufCollectionOld = persistentClassificacaofiscal.getClassificacaofiscalufCollection();
            Collection<Classificacaofiscaluf> classificacaofiscalufCollectionNew = classificacaofiscal.getClassificacaofiscalufCollection();
            Collection<Pedidoitem> pedidoitemCollectionOld = persistentClassificacaofiscal.getPedidoitemCollection();
            Collection<Pedidoitem> pedidoitemCollectionNew = classificacaofiscal.getPedidoitemCollection();
            Collection<Empresatipodocumentocf> empresatipodocumentocfCollectionOld = persistentClassificacaofiscal.getEmpresatipodocumentocfCollection();
            Collection<Empresatipodocumentocf> empresatipodocumentocfCollectionNew = classificacaofiscal.getEmpresatipodocumentocfCollection();
            Collection<Regracfopitem> regracfopitemCollectionOld = persistentClassificacaofiscal.getRegracfopitemCollection();
            Collection<Regracfopitem> regracfopitemCollectionNew = classificacaofiscal.getRegracfopitemCollection();
            Collection<Produto> produtoCollectionOld = persistentClassificacaofiscal.getProdutoCollection();
            Collection<Produto> produtoCollectionNew = classificacaofiscal.getProdutoCollection();
            if (codcesticmsNew != null) {
                codcesticmsNew = em.getReference(codcesticmsNew.getClass(), codcesticmsNew.getCodcesticms());
                classificacaofiscal.setCodcesticms(codcesticmsNew);
            }
            if (codunidadeNew != null) {
                codunidadeNew = em.getReference(codunidadeNew.getClass(), codunidadeNew.getCodunidade());
                classificacaofiscal.setCodunidade(codunidadeNew);
            }
            Collection<Classificacaofiscaluf> attachedClassificacaofiscalufCollectionNew = new ArrayList<Classificacaofiscaluf>();
            for (Classificacaofiscaluf classificacaofiscalufCollectionNewClassificacaofiscalufToAttach : classificacaofiscalufCollectionNew) {
                classificacaofiscalufCollectionNewClassificacaofiscalufToAttach = em.getReference(classificacaofiscalufCollectionNewClassificacaofiscalufToAttach.getClass(), classificacaofiscalufCollectionNewClassificacaofiscalufToAttach.getCodclassificacaofiscaluf());
                attachedClassificacaofiscalufCollectionNew.add(classificacaofiscalufCollectionNewClassificacaofiscalufToAttach);
            }
            classificacaofiscalufCollectionNew = attachedClassificacaofiscalufCollectionNew;
            classificacaofiscal.setClassificacaofiscalufCollection(classificacaofiscalufCollectionNew);
            Collection<Pedidoitem> attachedPedidoitemCollectionNew = new ArrayList<Pedidoitem>();
            for (Pedidoitem pedidoitemCollectionNewPedidoitemToAttach : pedidoitemCollectionNew) {
                pedidoitemCollectionNewPedidoitemToAttach = em.getReference(pedidoitemCollectionNewPedidoitemToAttach.getClass(), pedidoitemCollectionNewPedidoitemToAttach.getCodpedidoitem());
                attachedPedidoitemCollectionNew.add(pedidoitemCollectionNewPedidoitemToAttach);
            }
            pedidoitemCollectionNew = attachedPedidoitemCollectionNew;
            classificacaofiscal.setPedidoitemCollection(pedidoitemCollectionNew);
            Collection<Empresatipodocumentocf> attachedEmpresatipodocumentocfCollectionNew = new ArrayList<Empresatipodocumentocf>();
            for (Empresatipodocumentocf empresatipodocumentocfCollectionNewEmpresatipodocumentocfToAttach : empresatipodocumentocfCollectionNew) {
                empresatipodocumentocfCollectionNewEmpresatipodocumentocfToAttach = em.getReference(empresatipodocumentocfCollectionNewEmpresatipodocumentocfToAttach.getClass(), empresatipodocumentocfCollectionNewEmpresatipodocumentocfToAttach.getCodempresatipodocumentocf());
                attachedEmpresatipodocumentocfCollectionNew.add(empresatipodocumentocfCollectionNewEmpresatipodocumentocfToAttach);
            }
            empresatipodocumentocfCollectionNew = attachedEmpresatipodocumentocfCollectionNew;
            classificacaofiscal.setEmpresatipodocumentocfCollection(empresatipodocumentocfCollectionNew);
            Collection<Regracfopitem> attachedRegracfopitemCollectionNew = new ArrayList<Regracfopitem>();
            for (Regracfopitem regracfopitemCollectionNewRegracfopitemToAttach : regracfopitemCollectionNew) {
                regracfopitemCollectionNewRegracfopitemToAttach = em.getReference(regracfopitemCollectionNewRegracfopitemToAttach.getClass(), regracfopitemCollectionNewRegracfopitemToAttach.getCodregracfopitem());
                attachedRegracfopitemCollectionNew.add(regracfopitemCollectionNewRegracfopitemToAttach);
            }
            regracfopitemCollectionNew = attachedRegracfopitemCollectionNew;
            classificacaofiscal.setRegracfopitemCollection(regracfopitemCollectionNew);
            Collection<Produto> attachedProdutoCollectionNew = new ArrayList<Produto>();
            for (Produto produtoCollectionNewProdutoToAttach : produtoCollectionNew) {
                produtoCollectionNewProdutoToAttach = em.getReference(produtoCollectionNewProdutoToAttach.getClass(), produtoCollectionNewProdutoToAttach.getCodprod());
                attachedProdutoCollectionNew.add(produtoCollectionNewProdutoToAttach);
            }
            produtoCollectionNew = attachedProdutoCollectionNew;
            classificacaofiscal.setProdutoCollection(produtoCollectionNew);
            classificacaofiscal = em.merge(classificacaofiscal);
            if (codcesticmsOld != null && !codcesticmsOld.equals(codcesticmsNew)) {
                codcesticmsOld.getClassificacaofiscalCollection().remove(classificacaofiscal);
                codcesticmsOld = em.merge(codcesticmsOld);
            }
            if (codcesticmsNew != null && !codcesticmsNew.equals(codcesticmsOld)) {
                codcesticmsNew.getClassificacaofiscalCollection().add(classificacaofiscal);
                codcesticmsNew = em.merge(codcesticmsNew);
            }
            if (codunidadeOld != null && !codunidadeOld.equals(codunidadeNew)) {
                codunidadeOld.getClassificacaofiscalCollection().remove(classificacaofiscal);
                codunidadeOld = em.merge(codunidadeOld);
            }
            if (codunidadeNew != null && !codunidadeNew.equals(codunidadeOld)) {
                codunidadeNew.getClassificacaofiscalCollection().add(classificacaofiscal);
                codunidadeNew = em.merge(codunidadeNew);
            }
            for (Classificacaofiscaluf classificacaofiscalufCollectionOldClassificacaofiscaluf : classificacaofiscalufCollectionOld) {
                if (!classificacaofiscalufCollectionNew.contains(classificacaofiscalufCollectionOldClassificacaofiscaluf)) {
                    classificacaofiscalufCollectionOldClassificacaofiscaluf.setCodclassificacaofiscal(null);
                    classificacaofiscalufCollectionOldClassificacaofiscaluf = em.merge(classificacaofiscalufCollectionOldClassificacaofiscaluf);
                }
            }
            for (Classificacaofiscaluf classificacaofiscalufCollectionNewClassificacaofiscaluf : classificacaofiscalufCollectionNew) {
                if (!classificacaofiscalufCollectionOld.contains(classificacaofiscalufCollectionNewClassificacaofiscaluf)) {
                    Classificacaofiscal oldCodclassificacaofiscalOfClassificacaofiscalufCollectionNewClassificacaofiscaluf = classificacaofiscalufCollectionNewClassificacaofiscaluf.getCodclassificacaofiscal();
                    classificacaofiscalufCollectionNewClassificacaofiscaluf.setCodclassificacaofiscal(classificacaofiscal);
                    classificacaofiscalufCollectionNewClassificacaofiscaluf = em.merge(classificacaofiscalufCollectionNewClassificacaofiscaluf);
                    if (oldCodclassificacaofiscalOfClassificacaofiscalufCollectionNewClassificacaofiscaluf != null && !oldCodclassificacaofiscalOfClassificacaofiscalufCollectionNewClassificacaofiscaluf.equals(classificacaofiscal)) {
                        oldCodclassificacaofiscalOfClassificacaofiscalufCollectionNewClassificacaofiscaluf.getClassificacaofiscalufCollection().remove(classificacaofiscalufCollectionNewClassificacaofiscaluf);
                        oldCodclassificacaofiscalOfClassificacaofiscalufCollectionNewClassificacaofiscaluf = em.merge(oldCodclassificacaofiscalOfClassificacaofiscalufCollectionNewClassificacaofiscaluf);
                    }
                }
            }
            for (Pedidoitem pedidoitemCollectionOldPedidoitem : pedidoitemCollectionOld) {
                if (!pedidoitemCollectionNew.contains(pedidoitemCollectionOldPedidoitem)) {
                    pedidoitemCollectionOldPedidoitem.setCodclassificacaofiscal(null);
                    pedidoitemCollectionOldPedidoitem = em.merge(pedidoitemCollectionOldPedidoitem);
                }
            }
            for (Pedidoitem pedidoitemCollectionNewPedidoitem : pedidoitemCollectionNew) {
                if (!pedidoitemCollectionOld.contains(pedidoitemCollectionNewPedidoitem)) {
                    Classificacaofiscal oldCodclassificacaofiscalOfPedidoitemCollectionNewPedidoitem = pedidoitemCollectionNewPedidoitem.getCodclassificacaofiscal();
                    pedidoitemCollectionNewPedidoitem.setCodclassificacaofiscal(classificacaofiscal);
                    pedidoitemCollectionNewPedidoitem = em.merge(pedidoitemCollectionNewPedidoitem);
                    if (oldCodclassificacaofiscalOfPedidoitemCollectionNewPedidoitem != null && !oldCodclassificacaofiscalOfPedidoitemCollectionNewPedidoitem.equals(classificacaofiscal)) {
                        oldCodclassificacaofiscalOfPedidoitemCollectionNewPedidoitem.getPedidoitemCollection().remove(pedidoitemCollectionNewPedidoitem);
                        oldCodclassificacaofiscalOfPedidoitemCollectionNewPedidoitem = em.merge(oldCodclassificacaofiscalOfPedidoitemCollectionNewPedidoitem);
                    }
                }
            }
            for (Empresatipodocumentocf empresatipodocumentocfCollectionOldEmpresatipodocumentocf : empresatipodocumentocfCollectionOld) {
                if (!empresatipodocumentocfCollectionNew.contains(empresatipodocumentocfCollectionOldEmpresatipodocumentocf)) {
                    empresatipodocumentocfCollectionOldEmpresatipodocumentocf.setCodclassificacaofiscal(null);
                    empresatipodocumentocfCollectionOldEmpresatipodocumentocf = em.merge(empresatipodocumentocfCollectionOldEmpresatipodocumentocf);
                }
            }
            for (Empresatipodocumentocf empresatipodocumentocfCollectionNewEmpresatipodocumentocf : empresatipodocumentocfCollectionNew) {
                if (!empresatipodocumentocfCollectionOld.contains(empresatipodocumentocfCollectionNewEmpresatipodocumentocf)) {
                    Classificacaofiscal oldCodclassificacaofiscalOfEmpresatipodocumentocfCollectionNewEmpresatipodocumentocf = empresatipodocumentocfCollectionNewEmpresatipodocumentocf.getCodclassificacaofiscal();
                    empresatipodocumentocfCollectionNewEmpresatipodocumentocf.setCodclassificacaofiscal(classificacaofiscal);
                    empresatipodocumentocfCollectionNewEmpresatipodocumentocf = em.merge(empresatipodocumentocfCollectionNewEmpresatipodocumentocf);
                    if (oldCodclassificacaofiscalOfEmpresatipodocumentocfCollectionNewEmpresatipodocumentocf != null && !oldCodclassificacaofiscalOfEmpresatipodocumentocfCollectionNewEmpresatipodocumentocf.equals(classificacaofiscal)) {
                        oldCodclassificacaofiscalOfEmpresatipodocumentocfCollectionNewEmpresatipodocumentocf.getEmpresatipodocumentocfCollection().remove(empresatipodocumentocfCollectionNewEmpresatipodocumentocf);
                        oldCodclassificacaofiscalOfEmpresatipodocumentocfCollectionNewEmpresatipodocumentocf = em.merge(oldCodclassificacaofiscalOfEmpresatipodocumentocfCollectionNewEmpresatipodocumentocf);
                    }
                }
            }
            for (Regracfopitem regracfopitemCollectionOldRegracfopitem : regracfopitemCollectionOld) {
                if (!regracfopitemCollectionNew.contains(regracfopitemCollectionOldRegracfopitem)) {
                    regracfopitemCollectionOldRegracfopitem.setCodclassificacaofiscal(null);
                    regracfopitemCollectionOldRegracfopitem = em.merge(regracfopitemCollectionOldRegracfopitem);
                }
            }
            for (Regracfopitem regracfopitemCollectionNewRegracfopitem : regracfopitemCollectionNew) {
                if (!regracfopitemCollectionOld.contains(regracfopitemCollectionNewRegracfopitem)) {
                    Classificacaofiscal oldCodclassificacaofiscalOfRegracfopitemCollectionNewRegracfopitem = regracfopitemCollectionNewRegracfopitem.getCodclassificacaofiscal();
                    regracfopitemCollectionNewRegracfopitem.setCodclassificacaofiscal(classificacaofiscal);
                    regracfopitemCollectionNewRegracfopitem = em.merge(regracfopitemCollectionNewRegracfopitem);
                    if (oldCodclassificacaofiscalOfRegracfopitemCollectionNewRegracfopitem != null && !oldCodclassificacaofiscalOfRegracfopitemCollectionNewRegracfopitem.equals(classificacaofiscal)) {
                        oldCodclassificacaofiscalOfRegracfopitemCollectionNewRegracfopitem.getRegracfopitemCollection().remove(regracfopitemCollectionNewRegracfopitem);
                        oldCodclassificacaofiscalOfRegracfopitemCollectionNewRegracfopitem = em.merge(oldCodclassificacaofiscalOfRegracfopitemCollectionNewRegracfopitem);
                    }
                }
            }
            for (Produto produtoCollectionOldProduto : produtoCollectionOld) {
                if (!produtoCollectionNew.contains(produtoCollectionOldProduto)) {
                    produtoCollectionOldProduto.setCodclassificacaofiscal(null);
                    produtoCollectionOldProduto = em.merge(produtoCollectionOldProduto);
                }
            }
            for (Produto produtoCollectionNewProduto : produtoCollectionNew) {
                if (!produtoCollectionOld.contains(produtoCollectionNewProduto)) {
                    Classificacaofiscal oldCodclassificacaofiscalOfProdutoCollectionNewProduto = produtoCollectionNewProduto.getCodclassificacaofiscal();
                    produtoCollectionNewProduto.setCodclassificacaofiscal(classificacaofiscal);
                    produtoCollectionNewProduto = em.merge(produtoCollectionNewProduto);
                    if (oldCodclassificacaofiscalOfProdutoCollectionNewProduto != null && !oldCodclassificacaofiscalOfProdutoCollectionNewProduto.equals(classificacaofiscal)) {
                        oldCodclassificacaofiscalOfProdutoCollectionNewProduto.getProdutoCollection().remove(produtoCollectionNewProduto);
                        oldCodclassificacaofiscalOfProdutoCollectionNewProduto = em.merge(oldCodclassificacaofiscalOfProdutoCollectionNewProduto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = classificacaofiscal.getCodclassificacaofiscal();
                if (findClassificacaofiscal(id) == null) {
                    throw new NonexistentEntityException("The classificacaofiscal with id " + id + " no longer exists.");
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
            Classificacaofiscal classificacaofiscal;
            try {
                classificacaofiscal = em.getReference(Classificacaofiscal.class, id);
                classificacaofiscal.getCodclassificacaofiscal();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The classificacaofiscal with id " + id + " no longer exists.", enfe);
            }
            Cesticms codcesticms = classificacaofiscal.getCodcesticms();
            if (codcesticms != null) {
                codcesticms.getClassificacaofiscalCollection().remove(classificacaofiscal);
                codcesticms = em.merge(codcesticms);
            }
            Unidade codunidade = classificacaofiscal.getCodunidade();
            if (codunidade != null) {
                codunidade.getClassificacaofiscalCollection().remove(classificacaofiscal);
                codunidade = em.merge(codunidade);
            }
            Collection<Classificacaofiscaluf> classificacaofiscalufCollection = classificacaofiscal.getClassificacaofiscalufCollection();
            for (Classificacaofiscaluf classificacaofiscalufCollectionClassificacaofiscaluf : classificacaofiscalufCollection) {
                classificacaofiscalufCollectionClassificacaofiscaluf.setCodclassificacaofiscal(null);
                classificacaofiscalufCollectionClassificacaofiscaluf = em.merge(classificacaofiscalufCollectionClassificacaofiscaluf);
            }
            Collection<Pedidoitem> pedidoitemCollection = classificacaofiscal.getPedidoitemCollection();
            for (Pedidoitem pedidoitemCollectionPedidoitem : pedidoitemCollection) {
                pedidoitemCollectionPedidoitem.setCodclassificacaofiscal(null);
                pedidoitemCollectionPedidoitem = em.merge(pedidoitemCollectionPedidoitem);
            }
            Collection<Empresatipodocumentocf> empresatipodocumentocfCollection = classificacaofiscal.getEmpresatipodocumentocfCollection();
            for (Empresatipodocumentocf empresatipodocumentocfCollectionEmpresatipodocumentocf : empresatipodocumentocfCollection) {
                empresatipodocumentocfCollectionEmpresatipodocumentocf.setCodclassificacaofiscal(null);
                empresatipodocumentocfCollectionEmpresatipodocumentocf = em.merge(empresatipodocumentocfCollectionEmpresatipodocumentocf);
            }
            Collection<Regracfopitem> regracfopitemCollection = classificacaofiscal.getRegracfopitemCollection();
            for (Regracfopitem regracfopitemCollectionRegracfopitem : regracfopitemCollection) {
                regracfopitemCollectionRegracfopitem.setCodclassificacaofiscal(null);
                regracfopitemCollectionRegracfopitem = em.merge(regracfopitemCollectionRegracfopitem);
            }
            Collection<Produto> produtoCollection = classificacaofiscal.getProdutoCollection();
            for (Produto produtoCollectionProduto : produtoCollection) {
                produtoCollectionProduto.setCodclassificacaofiscal(null);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
            }
            em.remove(classificacaofiscal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Classificacaofiscal> findClassificacaofiscalEntities() {
        return findClassificacaofiscalEntities(true, -1, -1);
    }

    public List<Classificacaofiscal> findClassificacaofiscalEntities(int maxResults, int firstResult) {
        return findClassificacaofiscalEntities(false, maxResults, firstResult);
    }

    private List<Classificacaofiscal> findClassificacaofiscalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Classificacaofiscal.class));
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

    public Classificacaofiscal findClassificacaofiscal(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Classificacaofiscal.class, id);
        } finally {
            em.close();
        }
    }

    public int getClassificacaofiscalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Classificacaofiscal> rt = cq.from(Classificacaofiscal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

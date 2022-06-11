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
import entidade.cplus.Classificacaofiscal;
import entidade.cplus.Cor;
import entidade.cplus.Pedido;
import entidade.cplus.Produto;
import entidade.cplus.Pedidoentrada;
import entidade.cplus.Pedidoitem;
import java.util.ArrayList;
import java.util.Collection;
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
public class PedidoitemJpaController implements Serializable {

    public PedidoitemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pedidoitem pedidoitem) throws PreexistingEntityException, Exception {
        if (pedidoitem.getPedidoentradaCollection() == null) {
            pedidoitem.setPedidoentradaCollection(new ArrayList<Pedidoentrada>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cfop codcfop = pedidoitem.getCodcfop();
            if (codcfop != null) {
                codcfop = em.getReference(codcfop.getClass(), codcfop.getCodcfop());
                pedidoitem.setCodcfop(codcfop);
            }
            Classificacaofiscal codclassificacaofiscal = pedidoitem.getCodclassificacaofiscal();
            if (codclassificacaofiscal != null) {
                codclassificacaofiscal = em.getReference(codclassificacaofiscal.getClass(), codclassificacaofiscal.getCodclassificacaofiscal());
                pedidoitem.setCodclassificacaofiscal(codclassificacaofiscal);
            }
            Cor codcor = pedidoitem.getCodcor();
            if (codcor != null) {
                codcor = em.getReference(codcor.getClass(), codcor.getCodcor());
                pedidoitem.setCodcor(codcor);
            }
            Pedido codped = pedidoitem.getCodped();
            if (codped != null) {
                codped = em.getReference(codped.getClass(), codped.getCodped());
                pedidoitem.setCodped(codped);
            }
            Produto codprod = pedidoitem.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                pedidoitem.setCodprod(codprod);
            }
            Collection<Pedidoentrada> attachedPedidoentradaCollection = new ArrayList<Pedidoentrada>();
            for (Pedidoentrada pedidoentradaCollectionPedidoentradaToAttach : pedidoitem.getPedidoentradaCollection()) {
                pedidoentradaCollectionPedidoentradaToAttach = em.getReference(pedidoentradaCollectionPedidoentradaToAttach.getClass(), pedidoentradaCollectionPedidoentradaToAttach.getCodpedidoentrada());
                attachedPedidoentradaCollection.add(pedidoentradaCollectionPedidoentradaToAttach);
            }
            pedidoitem.setPedidoentradaCollection(attachedPedidoentradaCollection);
            em.persist(pedidoitem);
            if (codcfop != null) {
                codcfop.getPedidoitemCollection().add(pedidoitem);
                codcfop = em.merge(codcfop);
            }
            if (codclassificacaofiscal != null) {
                codclassificacaofiscal.getPedidoitemCollection().add(pedidoitem);
                codclassificacaofiscal = em.merge(codclassificacaofiscal);
            }
            if (codcor != null) {
                codcor.getPedidoitemCollection().add(pedidoitem);
                codcor = em.merge(codcor);
            }
            if (codped != null) {
                codped.getPedidoitemCollection().add(pedidoitem);
                codped = em.merge(codped);
            }
            if (codprod != null) {
                codprod.getPedidoitemCollection().add(pedidoitem);
                codprod = em.merge(codprod);
            }
            for (Pedidoentrada pedidoentradaCollectionPedidoentrada : pedidoitem.getPedidoentradaCollection()) {
                Pedidoitem oldCodpedidoitemOfPedidoentradaCollectionPedidoentrada = pedidoentradaCollectionPedidoentrada.getCodpedidoitem();
                pedidoentradaCollectionPedidoentrada.setCodpedidoitem(pedidoitem);
                pedidoentradaCollectionPedidoentrada = em.merge(pedidoentradaCollectionPedidoentrada);
                if (oldCodpedidoitemOfPedidoentradaCollectionPedidoentrada != null) {
                    oldCodpedidoitemOfPedidoentradaCollectionPedidoentrada.getPedidoentradaCollection().remove(pedidoentradaCollectionPedidoentrada);
                    oldCodpedidoitemOfPedidoentradaCollectionPedidoentrada = em.merge(oldCodpedidoitemOfPedidoentradaCollectionPedidoentrada);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPedidoitem(pedidoitem.getCodpedidoitem()) != null) {
                throw new PreexistingEntityException("Pedidoitem " + pedidoitem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pedidoitem pedidoitem) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedidoitem persistentPedidoitem = em.find(Pedidoitem.class, pedidoitem.getCodpedidoitem());
            Cfop codcfopOld = persistentPedidoitem.getCodcfop();
            Cfop codcfopNew = pedidoitem.getCodcfop();
            Classificacaofiscal codclassificacaofiscalOld = persistentPedidoitem.getCodclassificacaofiscal();
            Classificacaofiscal codclassificacaofiscalNew = pedidoitem.getCodclassificacaofiscal();
            Cor codcorOld = persistentPedidoitem.getCodcor();
            Cor codcorNew = pedidoitem.getCodcor();
            Pedido codpedOld = persistentPedidoitem.getCodped();
            Pedido codpedNew = pedidoitem.getCodped();
            Produto codprodOld = persistentPedidoitem.getCodprod();
            Produto codprodNew = pedidoitem.getCodprod();
            Collection<Pedidoentrada> pedidoentradaCollectionOld = persistentPedidoitem.getPedidoentradaCollection();
            Collection<Pedidoentrada> pedidoentradaCollectionNew = pedidoitem.getPedidoentradaCollection();
            List<String> illegalOrphanMessages = null;
            for (Pedidoentrada pedidoentradaCollectionOldPedidoentrada : pedidoentradaCollectionOld) {
                if (!pedidoentradaCollectionNew.contains(pedidoentradaCollectionOldPedidoentrada)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pedidoentrada " + pedidoentradaCollectionOldPedidoentrada + " since its codpedidoitem field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codcfopNew != null) {
                codcfopNew = em.getReference(codcfopNew.getClass(), codcfopNew.getCodcfop());
                pedidoitem.setCodcfop(codcfopNew);
            }
            if (codclassificacaofiscalNew != null) {
                codclassificacaofiscalNew = em.getReference(codclassificacaofiscalNew.getClass(), codclassificacaofiscalNew.getCodclassificacaofiscal());
                pedidoitem.setCodclassificacaofiscal(codclassificacaofiscalNew);
            }
            if (codcorNew != null) {
                codcorNew = em.getReference(codcorNew.getClass(), codcorNew.getCodcor());
                pedidoitem.setCodcor(codcorNew);
            }
            if (codpedNew != null) {
                codpedNew = em.getReference(codpedNew.getClass(), codpedNew.getCodped());
                pedidoitem.setCodped(codpedNew);
            }
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                pedidoitem.setCodprod(codprodNew);
            }
            Collection<Pedidoentrada> attachedPedidoentradaCollectionNew = new ArrayList<Pedidoentrada>();
            for (Pedidoentrada pedidoentradaCollectionNewPedidoentradaToAttach : pedidoentradaCollectionNew) {
                pedidoentradaCollectionNewPedidoentradaToAttach = em.getReference(pedidoentradaCollectionNewPedidoentradaToAttach.getClass(), pedidoentradaCollectionNewPedidoentradaToAttach.getCodpedidoentrada());
                attachedPedidoentradaCollectionNew.add(pedidoentradaCollectionNewPedidoentradaToAttach);
            }
            pedidoentradaCollectionNew = attachedPedidoentradaCollectionNew;
            pedidoitem.setPedidoentradaCollection(pedidoentradaCollectionNew);
            pedidoitem = em.merge(pedidoitem);
            if (codcfopOld != null && !codcfopOld.equals(codcfopNew)) {
                codcfopOld.getPedidoitemCollection().remove(pedidoitem);
                codcfopOld = em.merge(codcfopOld);
            }
            if (codcfopNew != null && !codcfopNew.equals(codcfopOld)) {
                codcfopNew.getPedidoitemCollection().add(pedidoitem);
                codcfopNew = em.merge(codcfopNew);
            }
            if (codclassificacaofiscalOld != null && !codclassificacaofiscalOld.equals(codclassificacaofiscalNew)) {
                codclassificacaofiscalOld.getPedidoitemCollection().remove(pedidoitem);
                codclassificacaofiscalOld = em.merge(codclassificacaofiscalOld);
            }
            if (codclassificacaofiscalNew != null && !codclassificacaofiscalNew.equals(codclassificacaofiscalOld)) {
                codclassificacaofiscalNew.getPedidoitemCollection().add(pedidoitem);
                codclassificacaofiscalNew = em.merge(codclassificacaofiscalNew);
            }
            if (codcorOld != null && !codcorOld.equals(codcorNew)) {
                codcorOld.getPedidoitemCollection().remove(pedidoitem);
                codcorOld = em.merge(codcorOld);
            }
            if (codcorNew != null && !codcorNew.equals(codcorOld)) {
                codcorNew.getPedidoitemCollection().add(pedidoitem);
                codcorNew = em.merge(codcorNew);
            }
            if (codpedOld != null && !codpedOld.equals(codpedNew)) {
                codpedOld.getPedidoitemCollection().remove(pedidoitem);
                codpedOld = em.merge(codpedOld);
            }
            if (codpedNew != null && !codpedNew.equals(codpedOld)) {
                codpedNew.getPedidoitemCollection().add(pedidoitem);
                codpedNew = em.merge(codpedNew);
            }
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getPedidoitemCollection().remove(pedidoitem);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getPedidoitemCollection().add(pedidoitem);
                codprodNew = em.merge(codprodNew);
            }
            for (Pedidoentrada pedidoentradaCollectionNewPedidoentrada : pedidoentradaCollectionNew) {
                if (!pedidoentradaCollectionOld.contains(pedidoentradaCollectionNewPedidoentrada)) {
                    Pedidoitem oldCodpedidoitemOfPedidoentradaCollectionNewPedidoentrada = pedidoentradaCollectionNewPedidoentrada.getCodpedidoitem();
                    pedidoentradaCollectionNewPedidoentrada.setCodpedidoitem(pedidoitem);
                    pedidoentradaCollectionNewPedidoentrada = em.merge(pedidoentradaCollectionNewPedidoentrada);
                    if (oldCodpedidoitemOfPedidoentradaCollectionNewPedidoentrada != null && !oldCodpedidoitemOfPedidoentradaCollectionNewPedidoentrada.equals(pedidoitem)) {
                        oldCodpedidoitemOfPedidoentradaCollectionNewPedidoentrada.getPedidoentradaCollection().remove(pedidoentradaCollectionNewPedidoentrada);
                        oldCodpedidoitemOfPedidoentradaCollectionNewPedidoentrada = em.merge(oldCodpedidoitemOfPedidoentradaCollectionNewPedidoentrada);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = pedidoitem.getCodpedidoitem();
                if (findPedidoitem(id) == null) {
                    throw new NonexistentEntityException("The pedidoitem with id " + id + " no longer exists.");
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
            Pedidoitem pedidoitem;
            try {
                pedidoitem = em.getReference(Pedidoitem.class, id);
                pedidoitem.getCodpedidoitem();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pedidoitem with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Pedidoentrada> pedidoentradaCollectionOrphanCheck = pedidoitem.getPedidoentradaCollection();
            for (Pedidoentrada pedidoentradaCollectionOrphanCheckPedidoentrada : pedidoentradaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pedidoitem (" + pedidoitem + ") cannot be destroyed since the Pedidoentrada " + pedidoentradaCollectionOrphanCheckPedidoentrada + " in its pedidoentradaCollection field has a non-nullable codpedidoitem field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cfop codcfop = pedidoitem.getCodcfop();
            if (codcfop != null) {
                codcfop.getPedidoitemCollection().remove(pedidoitem);
                codcfop = em.merge(codcfop);
            }
            Classificacaofiscal codclassificacaofiscal = pedidoitem.getCodclassificacaofiscal();
            if (codclassificacaofiscal != null) {
                codclassificacaofiscal.getPedidoitemCollection().remove(pedidoitem);
                codclassificacaofiscal = em.merge(codclassificacaofiscal);
            }
            Cor codcor = pedidoitem.getCodcor();
            if (codcor != null) {
                codcor.getPedidoitemCollection().remove(pedidoitem);
                codcor = em.merge(codcor);
            }
            Pedido codped = pedidoitem.getCodped();
            if (codped != null) {
                codped.getPedidoitemCollection().remove(pedidoitem);
                codped = em.merge(codped);
            }
            Produto codprod = pedidoitem.getCodprod();
            if (codprod != null) {
                codprod.getPedidoitemCollection().remove(pedidoitem);
                codprod = em.merge(codprod);
            }
            em.remove(pedidoitem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pedidoitem> findPedidoitemEntities() {
        return findPedidoitemEntities(true, -1, -1);
    }

    public List<Pedidoitem> findPedidoitemEntities(int maxResults, int firstResult) {
        return findPedidoitemEntities(false, maxResults, firstResult);
    }

    private List<Pedidoitem> findPedidoitemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pedidoitem.class));
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

    public Pedidoitem findPedidoitem(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pedidoitem.class, id);
        } finally {
            em.close();
        }
    }

    public int getPedidoitemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pedidoitem> rt = cq.from(Pedidoitem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

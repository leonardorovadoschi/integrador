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
import entidade.cplus.Centrocusto;
import entidade.cplus.Cfop;
import entidade.cplus.Empresa;
import entidade.cplus.Formapag;
import entidade.cplus.Setorestoque;
import entidade.cplus.Transportadora;
import entidade.cplus.Usuario;
import entidade.cplus.Itemped;
import entidade.cplus.Pedido;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Pedidoitem;
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
public class PedidoJpaController implements Serializable {

    public PedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pedido pedido) throws PreexistingEntityException, Exception {
        if (pedido.getItempedCollection() == null) {
            pedido.setItempedCollection(new ArrayList<Itemped>());
        }
        if (pedido.getPedidoitemCollection() == null) {
            pedido.setPedidoitemCollection(new ArrayList<Pedidoitem>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Centrocusto codcentrocusto = pedido.getCodcentrocusto();
            if (codcentrocusto != null) {
                codcentrocusto = em.getReference(codcentrocusto.getClass(), codcentrocusto.getCodcentrocusto());
                pedido.setCodcentrocusto(codcentrocusto);
            }
            Cfop codcfop = pedido.getCodcfop();
            if (codcfop != null) {
                codcfop = em.getReference(codcfop.getClass(), codcfop.getCodcfop());
                pedido.setCodcfop(codcfop);
            }
            Empresa codempresa = pedido.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                pedido.setCodempresa(codempresa);
            }
            Formapag codfp = pedido.getCodfp();
            if (codfp != null) {
                codfp = em.getReference(codfp.getClass(), codfp.getCodfp());
                pedido.setCodfp(codfp);
            }
            Setorestoque codsetorestoque = pedido.getCodsetorestoque();
            if (codsetorestoque != null) {
                codsetorestoque = em.getReference(codsetorestoque.getClass(), codsetorestoque.getCodsetorestoque());
                pedido.setCodsetorestoque(codsetorestoque);
            }
            Transportadora codtrans = pedido.getCodtrans();
            if (codtrans != null) {
                codtrans = em.getReference(codtrans.getClass(), codtrans.getCodtrans());
                pedido.setCodtrans(codtrans);
            }
            Usuario coduser = pedido.getCoduser();
            if (coduser != null) {
                coduser = em.getReference(coduser.getClass(), coduser.getCoduser());
                pedido.setCoduser(coduser);
            }
            Collection<Itemped> attachedItempedCollection = new ArrayList<Itemped>();
            for (Itemped itempedCollectionItempedToAttach : pedido.getItempedCollection()) {
                itempedCollectionItempedToAttach = em.getReference(itempedCollectionItempedToAttach.getClass(), itempedCollectionItempedToAttach.getCoditemped());
                attachedItempedCollection.add(itempedCollectionItempedToAttach);
            }
            pedido.setItempedCollection(attachedItempedCollection);
            Collection<Pedidoitem> attachedPedidoitemCollection = new ArrayList<Pedidoitem>();
            for (Pedidoitem pedidoitemCollectionPedidoitemToAttach : pedido.getPedidoitemCollection()) {
                pedidoitemCollectionPedidoitemToAttach = em.getReference(pedidoitemCollectionPedidoitemToAttach.getClass(), pedidoitemCollectionPedidoitemToAttach.getCodpedidoitem());
                attachedPedidoitemCollection.add(pedidoitemCollectionPedidoitemToAttach);
            }
            pedido.setPedidoitemCollection(attachedPedidoitemCollection);
            em.persist(pedido);
            if (codcentrocusto != null) {
                codcentrocusto.getPedidoCollection().add(pedido);
                codcentrocusto = em.merge(codcentrocusto);
            }
            if (codcfop != null) {
                codcfop.getPedidoCollection().add(pedido);
                codcfop = em.merge(codcfop);
            }
            if (codempresa != null) {
                codempresa.getPedidoCollection().add(pedido);
                codempresa = em.merge(codempresa);
            }
            if (codfp != null) {
                codfp.getPedidoCollection().add(pedido);
                codfp = em.merge(codfp);
            }
            if (codsetorestoque != null) {
                codsetorestoque.getPedidoCollection().add(pedido);
                codsetorestoque = em.merge(codsetorestoque);
            }
            if (codtrans != null) {
                codtrans.getPedidoCollection().add(pedido);
                codtrans = em.merge(codtrans);
            }
            if (coduser != null) {
                coduser.getPedidoCollection().add(pedido);
                coduser = em.merge(coduser);
            }
            for (Itemped itempedCollectionItemped : pedido.getItempedCollection()) {
                Pedido oldCodpedOfItempedCollectionItemped = itempedCollectionItemped.getCodped();
                itempedCollectionItemped.setCodped(pedido);
                itempedCollectionItemped = em.merge(itempedCollectionItemped);
                if (oldCodpedOfItempedCollectionItemped != null) {
                    oldCodpedOfItempedCollectionItemped.getItempedCollection().remove(itempedCollectionItemped);
                    oldCodpedOfItempedCollectionItemped = em.merge(oldCodpedOfItempedCollectionItemped);
                }
            }
            for (Pedidoitem pedidoitemCollectionPedidoitem : pedido.getPedidoitemCollection()) {
                Pedido oldCodpedOfPedidoitemCollectionPedidoitem = pedidoitemCollectionPedidoitem.getCodped();
                pedidoitemCollectionPedidoitem.setCodped(pedido);
                pedidoitemCollectionPedidoitem = em.merge(pedidoitemCollectionPedidoitem);
                if (oldCodpedOfPedidoitemCollectionPedidoitem != null) {
                    oldCodpedOfPedidoitemCollectionPedidoitem.getPedidoitemCollection().remove(pedidoitemCollectionPedidoitem);
                    oldCodpedOfPedidoitemCollectionPedidoitem = em.merge(oldCodpedOfPedidoitemCollectionPedidoitem);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPedido(pedido.getCodped()) != null) {
                throw new PreexistingEntityException("Pedido " + pedido + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pedido pedido) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido persistentPedido = em.find(Pedido.class, pedido.getCodped());
            Centrocusto codcentrocustoOld = persistentPedido.getCodcentrocusto();
            Centrocusto codcentrocustoNew = pedido.getCodcentrocusto();
            Cfop codcfopOld = persistentPedido.getCodcfop();
            Cfop codcfopNew = pedido.getCodcfop();
            Empresa codempresaOld = persistentPedido.getCodempresa();
            Empresa codempresaNew = pedido.getCodempresa();
            Formapag codfpOld = persistentPedido.getCodfp();
            Formapag codfpNew = pedido.getCodfp();
            Setorestoque codsetorestoqueOld = persistentPedido.getCodsetorestoque();
            Setorestoque codsetorestoqueNew = pedido.getCodsetorestoque();
            Transportadora codtransOld = persistentPedido.getCodtrans();
            Transportadora codtransNew = pedido.getCodtrans();
            Usuario coduserOld = persistentPedido.getCoduser();
            Usuario coduserNew = pedido.getCoduser();
            Collection<Itemped> itempedCollectionOld = persistentPedido.getItempedCollection();
            Collection<Itemped> itempedCollectionNew = pedido.getItempedCollection();
            Collection<Pedidoitem> pedidoitemCollectionOld = persistentPedido.getPedidoitemCollection();
            Collection<Pedidoitem> pedidoitemCollectionNew = pedido.getPedidoitemCollection();
            List<String> illegalOrphanMessages = null;
            for (Itemped itempedCollectionOldItemped : itempedCollectionOld) {
                if (!itempedCollectionNew.contains(itempedCollectionOldItemped)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Itemped " + itempedCollectionOldItemped + " since its codped field is not nullable.");
                }
            }
            for (Pedidoitem pedidoitemCollectionOldPedidoitem : pedidoitemCollectionOld) {
                if (!pedidoitemCollectionNew.contains(pedidoitemCollectionOldPedidoitem)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pedidoitem " + pedidoitemCollectionOldPedidoitem + " since its codped field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codcentrocustoNew != null) {
                codcentrocustoNew = em.getReference(codcentrocustoNew.getClass(), codcentrocustoNew.getCodcentrocusto());
                pedido.setCodcentrocusto(codcentrocustoNew);
            }
            if (codcfopNew != null) {
                codcfopNew = em.getReference(codcfopNew.getClass(), codcfopNew.getCodcfop());
                pedido.setCodcfop(codcfopNew);
            }
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                pedido.setCodempresa(codempresaNew);
            }
            if (codfpNew != null) {
                codfpNew = em.getReference(codfpNew.getClass(), codfpNew.getCodfp());
                pedido.setCodfp(codfpNew);
            }
            if (codsetorestoqueNew != null) {
                codsetorestoqueNew = em.getReference(codsetorestoqueNew.getClass(), codsetorestoqueNew.getCodsetorestoque());
                pedido.setCodsetorestoque(codsetorestoqueNew);
            }
            if (codtransNew != null) {
                codtransNew = em.getReference(codtransNew.getClass(), codtransNew.getCodtrans());
                pedido.setCodtrans(codtransNew);
            }
            if (coduserNew != null) {
                coduserNew = em.getReference(coduserNew.getClass(), coduserNew.getCoduser());
                pedido.setCoduser(coduserNew);
            }
            Collection<Itemped> attachedItempedCollectionNew = new ArrayList<Itemped>();
            for (Itemped itempedCollectionNewItempedToAttach : itempedCollectionNew) {
                itempedCollectionNewItempedToAttach = em.getReference(itempedCollectionNewItempedToAttach.getClass(), itempedCollectionNewItempedToAttach.getCoditemped());
                attachedItempedCollectionNew.add(itempedCollectionNewItempedToAttach);
            }
            itempedCollectionNew = attachedItempedCollectionNew;
            pedido.setItempedCollection(itempedCollectionNew);
            Collection<Pedidoitem> attachedPedidoitemCollectionNew = new ArrayList<Pedidoitem>();
            for (Pedidoitem pedidoitemCollectionNewPedidoitemToAttach : pedidoitemCollectionNew) {
                pedidoitemCollectionNewPedidoitemToAttach = em.getReference(pedidoitemCollectionNewPedidoitemToAttach.getClass(), pedidoitemCollectionNewPedidoitemToAttach.getCodpedidoitem());
                attachedPedidoitemCollectionNew.add(pedidoitemCollectionNewPedidoitemToAttach);
            }
            pedidoitemCollectionNew = attachedPedidoitemCollectionNew;
            pedido.setPedidoitemCollection(pedidoitemCollectionNew);
            pedido = em.merge(pedido);
            if (codcentrocustoOld != null && !codcentrocustoOld.equals(codcentrocustoNew)) {
                codcentrocustoOld.getPedidoCollection().remove(pedido);
                codcentrocustoOld = em.merge(codcentrocustoOld);
            }
            if (codcentrocustoNew != null && !codcentrocustoNew.equals(codcentrocustoOld)) {
                codcentrocustoNew.getPedidoCollection().add(pedido);
                codcentrocustoNew = em.merge(codcentrocustoNew);
            }
            if (codcfopOld != null && !codcfopOld.equals(codcfopNew)) {
                codcfopOld.getPedidoCollection().remove(pedido);
                codcfopOld = em.merge(codcfopOld);
            }
            if (codcfopNew != null && !codcfopNew.equals(codcfopOld)) {
                codcfopNew.getPedidoCollection().add(pedido);
                codcfopNew = em.merge(codcfopNew);
            }
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getPedidoCollection().remove(pedido);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getPedidoCollection().add(pedido);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codfpOld != null && !codfpOld.equals(codfpNew)) {
                codfpOld.getPedidoCollection().remove(pedido);
                codfpOld = em.merge(codfpOld);
            }
            if (codfpNew != null && !codfpNew.equals(codfpOld)) {
                codfpNew.getPedidoCollection().add(pedido);
                codfpNew = em.merge(codfpNew);
            }
            if (codsetorestoqueOld != null && !codsetorestoqueOld.equals(codsetorestoqueNew)) {
                codsetorestoqueOld.getPedidoCollection().remove(pedido);
                codsetorestoqueOld = em.merge(codsetorestoqueOld);
            }
            if (codsetorestoqueNew != null && !codsetorestoqueNew.equals(codsetorestoqueOld)) {
                codsetorestoqueNew.getPedidoCollection().add(pedido);
                codsetorestoqueNew = em.merge(codsetorestoqueNew);
            }
            if (codtransOld != null && !codtransOld.equals(codtransNew)) {
                codtransOld.getPedidoCollection().remove(pedido);
                codtransOld = em.merge(codtransOld);
            }
            if (codtransNew != null && !codtransNew.equals(codtransOld)) {
                codtransNew.getPedidoCollection().add(pedido);
                codtransNew = em.merge(codtransNew);
            }
            if (coduserOld != null && !coduserOld.equals(coduserNew)) {
                coduserOld.getPedidoCollection().remove(pedido);
                coduserOld = em.merge(coduserOld);
            }
            if (coduserNew != null && !coduserNew.equals(coduserOld)) {
                coduserNew.getPedidoCollection().add(pedido);
                coduserNew = em.merge(coduserNew);
            }
            for (Itemped itempedCollectionNewItemped : itempedCollectionNew) {
                if (!itempedCollectionOld.contains(itempedCollectionNewItemped)) {
                    Pedido oldCodpedOfItempedCollectionNewItemped = itempedCollectionNewItemped.getCodped();
                    itempedCollectionNewItemped.setCodped(pedido);
                    itempedCollectionNewItemped = em.merge(itempedCollectionNewItemped);
                    if (oldCodpedOfItempedCollectionNewItemped != null && !oldCodpedOfItempedCollectionNewItemped.equals(pedido)) {
                        oldCodpedOfItempedCollectionNewItemped.getItempedCollection().remove(itempedCollectionNewItemped);
                        oldCodpedOfItempedCollectionNewItemped = em.merge(oldCodpedOfItempedCollectionNewItemped);
                    }
                }
            }
            for (Pedidoitem pedidoitemCollectionNewPedidoitem : pedidoitemCollectionNew) {
                if (!pedidoitemCollectionOld.contains(pedidoitemCollectionNewPedidoitem)) {
                    Pedido oldCodpedOfPedidoitemCollectionNewPedidoitem = pedidoitemCollectionNewPedidoitem.getCodped();
                    pedidoitemCollectionNewPedidoitem.setCodped(pedido);
                    pedidoitemCollectionNewPedidoitem = em.merge(pedidoitemCollectionNewPedidoitem);
                    if (oldCodpedOfPedidoitemCollectionNewPedidoitem != null && !oldCodpedOfPedidoitemCollectionNewPedidoitem.equals(pedido)) {
                        oldCodpedOfPedidoitemCollectionNewPedidoitem.getPedidoitemCollection().remove(pedidoitemCollectionNewPedidoitem);
                        oldCodpedOfPedidoitemCollectionNewPedidoitem = em.merge(oldCodpedOfPedidoitemCollectionNewPedidoitem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = pedido.getCodped();
                if (findPedido(id) == null) {
                    throw new NonexistentEntityException("The pedido with id " + id + " no longer exists.");
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
            Pedido pedido;
            try {
                pedido = em.getReference(Pedido.class, id);
                pedido.getCodped();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pedido with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Itemped> itempedCollectionOrphanCheck = pedido.getItempedCollection();
            for (Itemped itempedCollectionOrphanCheckItemped : itempedCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pedido (" + pedido + ") cannot be destroyed since the Itemped " + itempedCollectionOrphanCheckItemped + " in its itempedCollection field has a non-nullable codped field.");
            }
            Collection<Pedidoitem> pedidoitemCollectionOrphanCheck = pedido.getPedidoitemCollection();
            for (Pedidoitem pedidoitemCollectionOrphanCheckPedidoitem : pedidoitemCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pedido (" + pedido + ") cannot be destroyed since the Pedidoitem " + pedidoitemCollectionOrphanCheckPedidoitem + " in its pedidoitemCollection field has a non-nullable codped field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Centrocusto codcentrocusto = pedido.getCodcentrocusto();
            if (codcentrocusto != null) {
                codcentrocusto.getPedidoCollection().remove(pedido);
                codcentrocusto = em.merge(codcentrocusto);
            }
            Cfop codcfop = pedido.getCodcfop();
            if (codcfop != null) {
                codcfop.getPedidoCollection().remove(pedido);
                codcfop = em.merge(codcfop);
            }
            Empresa codempresa = pedido.getCodempresa();
            if (codempresa != null) {
                codempresa.getPedidoCollection().remove(pedido);
                codempresa = em.merge(codempresa);
            }
            Formapag codfp = pedido.getCodfp();
            if (codfp != null) {
                codfp.getPedidoCollection().remove(pedido);
                codfp = em.merge(codfp);
            }
            Setorestoque codsetorestoque = pedido.getCodsetorestoque();
            if (codsetorestoque != null) {
                codsetorestoque.getPedidoCollection().remove(pedido);
                codsetorestoque = em.merge(codsetorestoque);
            }
            Transportadora codtrans = pedido.getCodtrans();
            if (codtrans != null) {
                codtrans.getPedidoCollection().remove(pedido);
                codtrans = em.merge(codtrans);
            }
            Usuario coduser = pedido.getCoduser();
            if (coduser != null) {
                coduser.getPedidoCollection().remove(pedido);
                coduser = em.merge(coduser);
            }
            em.remove(pedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pedido> findPedidoEntities() {
        return findPedidoEntities(true, -1, -1);
    }

    public List<Pedido> findPedidoEntities(int maxResults, int firstResult) {
        return findPedidoEntities(false, maxResults, firstResult);
    }

    private List<Pedido> findPedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pedido.class));
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

    public Pedido findPedido(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getPedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pedido> rt = cq.from(Pedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

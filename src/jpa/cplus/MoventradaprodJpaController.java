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
import entidade.cplus.Moventradaprod;
import entidade.cplus.Produto;
import entidade.cplus.Setorestoque;
import entidade.cplus.Vendedor;
import entidade.cplus.Moventradaprodcomp;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Moventradaprodlote;
import entidade.cplus.Moventradaprodserial;
import entidade.cplus.Pedidoentrada;
import entidade.cplus.Rma;
import entidade.cplus.Moventradaprodfci;
import entidade.cplus.OsOrdemservico;
import entidade.cplus.Vendedordesconto;
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
public class MoventradaprodJpaController implements Serializable {

    public MoventradaprodJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Moventradaprod moventradaprod) throws PreexistingEntityException, Exception {
        
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
           
            em.persist(moventradaprod);
            
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMoventradaprod(moventradaprod.getCodmoveprod()) != null) {
                throw new PreexistingEntityException("Moventradaprod " + moventradaprod + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Moventradaprod moventradaprod) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            
           em.merge(moventradaprod);
            
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = moventradaprod.getCodmoveprod();
                if (findMoventradaprod(id) == null) {
                    throw new NonexistentEntityException("The moventradaprod with id " + id + " no longer exists.");
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
            Moventradaprod moventradaprod;
            try {
                moventradaprod = em.getReference(Moventradaprod.class, id);
                moventradaprod.getCodmoveprod();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The moventradaprod with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Moventradaprodcomp> moventradaprodcompCollectionOrphanCheck = moventradaprod.getMoventradaprodcompCollection();
            for (Moventradaprodcomp moventradaprodcompCollectionOrphanCheckMoventradaprodcomp : moventradaprodcompCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Moventradaprod (" + moventradaprod + ") cannot be destroyed since the Moventradaprodcomp " + moventradaprodcompCollectionOrphanCheckMoventradaprodcomp + " in its moventradaprodcompCollection field has a non-nullable codmoveprod field.");
            }
            Collection<Moventradaprodlote> moventradaprodloteCollectionOrphanCheck = moventradaprod.getMoventradaprodloteCollection();
            for (Moventradaprodlote moventradaprodloteCollectionOrphanCheckMoventradaprodlote : moventradaprodloteCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Moventradaprod (" + moventradaprod + ") cannot be destroyed since the Moventradaprodlote " + moventradaprodloteCollectionOrphanCheckMoventradaprodlote + " in its moventradaprodloteCollection field has a non-nullable codmoveprod field.");
            }
            Collection<Pedidoentrada> pedidoentradaCollectionOrphanCheck = moventradaprod.getPedidoentradaCollection();
            for (Pedidoentrada pedidoentradaCollectionOrphanCheckPedidoentrada : pedidoentradaCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Moventradaprod (" + moventradaprod + ") cannot be destroyed since the Pedidoentrada " + pedidoentradaCollectionOrphanCheckPedidoentrada + " in its pedidoentradaCollection field has a non-nullable codmoveprod field.");
            }
            Collection<Moventradaprodfci> moventradaprodfciCollectionOrphanCheck = moventradaprod.getMoventradaprodfciCollection();
            for (Moventradaprodfci moventradaprodfciCollectionOrphanCheckMoventradaprodfci : moventradaprodfciCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Moventradaprod (" + moventradaprod + ") cannot be destroyed since the Moventradaprodfci " + moventradaprodfciCollectionOrphanCheckMoventradaprodfci + " in its moventradaprodfciCollection field has a non-nullable codmoveprod field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cfop codcfop = moventradaprod.getCodcfop();
            if (codcfop != null) {
                codcfop.getMoventradaprodCollection().remove(moventradaprod);
                codcfop = em.merge(codcfop);
            }
            Moventrada codmoventr = moventradaprod.getCodmoventr();
            if (codmoventr != null) {
                codmoventr.getMoventradaprodCollection().remove(moventradaprod);
                codmoventr = em.merge(codmoventr);
            }
            Produto codprod = moventradaprod.getCodprod();
            if (codprod != null) {
                codprod.getMoventradaprodCollection().remove(moventradaprod);
                codprod = em.merge(codprod);
            }
            Setorestoque codsetorestoque = moventradaprod.getCodsetorestoque();
            if (codsetorestoque != null) {
                codsetorestoque.getMoventradaprodCollection().remove(moventradaprod);
                codsetorestoque = em.merge(codsetorestoque);
            }
            Vendedor codvended = moventradaprod.getCodvended();
            if (codvended != null) {
                codvended.getMoventradaprodCollection().remove(moventradaprod);
                codvended = em.merge(codvended);
            }
            Collection<Moventradaprodserial> moventradaprodserialCollection = moventradaprod.getMoventradaprodserialCollection();
            for (Moventradaprodserial moventradaprodserialCollectionMoventradaprodserial : moventradaprodserialCollection) {
                moventradaprodserialCollectionMoventradaprodserial.setCodmoveprod(null);
                moventradaprodserialCollectionMoventradaprodserial = em.merge(moventradaprodserialCollectionMoventradaprodserial);
            }
            Collection<Rma> rmaCollection = moventradaprod.getRmaCollection();
            for (Rma rmaCollectionRma : rmaCollection) {
                rmaCollectionRma.setCodmoveprod(null);
                rmaCollectionRma = em.merge(rmaCollectionRma);
            }
            Collection<OsOrdemservico> osOrdemservicoCollection = moventradaprod.getOsOrdemservicoCollection();
            for (OsOrdemservico osOrdemservicoCollectionOsOrdemservico : osOrdemservicoCollection) {
                osOrdemservicoCollectionOsOrdemservico.setCodmoveprod(null);
                osOrdemservicoCollectionOsOrdemservico = em.merge(osOrdemservicoCollectionOsOrdemservico);
            }
            Collection<Vendedordesconto> vendedordescontoCollection = moventradaprod.getVendedordescontoCollection();
            for (Vendedordesconto vendedordescontoCollectionVendedordesconto : vendedordescontoCollection) {
                vendedordescontoCollectionVendedordesconto.setCodmoveprod(null);
                vendedordescontoCollectionVendedordesconto = em.merge(vendedordescontoCollectionVendedordesconto);
            }
            em.remove(moventradaprod);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Moventradaprod> findMoventradaprodEntities() {
        return findMoventradaprodEntities(true, -1, -1);
    }

    public List<Moventradaprod> findMoventradaprodEntities(int maxResults, int firstResult) {
        return findMoventradaprodEntities(false, maxResults, firstResult);
    }

    private List<Moventradaprod> findMoventradaprodEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Moventradaprod.class));
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

    public Moventradaprod findMoventradaprod(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Moventradaprod.class, id);
        } finally {
            em.close();
        }
    }

    public int getMoventradaprodCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Moventradaprod> rt = cq.from(Moventradaprod.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
import entidade.cplus.Movenda;
import entidade.cplus.Movendaprod;
import entidade.cplus.Vendedorcomissao;
import entidade.cplus.Vendedordesconto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class VendedorcomissaoJpaController implements Serializable {

    public VendedorcomissaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vendedorcomissao vendedorcomissao) throws PreexistingEntityException, Exception {
        if (vendedorcomissao.getVendedordescontoCollection() == null) {
            vendedorcomissao.setVendedordescontoCollection(new ArrayList<Vendedordesconto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movenda codmovenda = vendedorcomissao.getCodmovenda();
            if (codmovenda != null) {
                codmovenda = em.getReference(codmovenda.getClass(), codmovenda.getCodmovenda());
                vendedorcomissao.setCodmovenda(codmovenda);
            }
            Movendaprod codmovprod = vendedorcomissao.getCodmovprod();
            if (codmovprod != null) {
                codmovprod = em.getReference(codmovprod.getClass(), codmovprod.getCodmovprod());
                vendedorcomissao.setCodmovprod(codmovprod);
            }
            Collection<Vendedordesconto> attachedVendedordescontoCollection = new ArrayList<Vendedordesconto>();
            for (Vendedordesconto vendedordescontoCollectionVendedordescontoToAttach : vendedorcomissao.getVendedordescontoCollection()) {
                vendedordescontoCollectionVendedordescontoToAttach = em.getReference(vendedordescontoCollectionVendedordescontoToAttach.getClass(), vendedordescontoCollectionVendedordescontoToAttach.getCodvendedordesconto());
                attachedVendedordescontoCollection.add(vendedordescontoCollectionVendedordescontoToAttach);
            }
            vendedorcomissao.setVendedordescontoCollection(attachedVendedordescontoCollection);
            em.persist(vendedorcomissao);
            if (codmovenda != null) {
                codmovenda.getVendedorcomissaoCollection().add(vendedorcomissao);
                codmovenda = em.merge(codmovenda);
            }
            if (codmovprod != null) {
                codmovprod.getVendedorcomissaoCollection().add(vendedorcomissao);
                codmovprod = em.merge(codmovprod);
            }
            for (Vendedordesconto vendedordescontoCollectionVendedordesconto : vendedorcomissao.getVendedordescontoCollection()) {
                Vendedorcomissao oldCodvendedorcomissaoOfVendedordescontoCollectionVendedordesconto = vendedordescontoCollectionVendedordesconto.getCodvendedorcomissao();
                vendedordescontoCollectionVendedordesconto.setCodvendedorcomissao(vendedorcomissao);
                vendedordescontoCollectionVendedordesconto = em.merge(vendedordescontoCollectionVendedordesconto);
                if (oldCodvendedorcomissaoOfVendedordescontoCollectionVendedordesconto != null) {
                    oldCodvendedorcomissaoOfVendedordescontoCollectionVendedordesconto.getVendedordescontoCollection().remove(vendedordescontoCollectionVendedordesconto);
                    oldCodvendedorcomissaoOfVendedordescontoCollectionVendedordesconto = em.merge(oldCodvendedorcomissaoOfVendedordescontoCollectionVendedordesconto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVendedorcomissao(vendedorcomissao.getCodvendedorcomissao()) != null) {
                throw new PreexistingEntityException("Vendedorcomissao " + vendedorcomissao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vendedorcomissao vendedorcomissao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vendedorcomissao persistentVendedorcomissao = em.find(Vendedorcomissao.class, vendedorcomissao.getCodvendedorcomissao());
            Movenda codmovendaOld = persistentVendedorcomissao.getCodmovenda();
            Movenda codmovendaNew = vendedorcomissao.getCodmovenda();
            Movendaprod codmovprodOld = persistentVendedorcomissao.getCodmovprod();
            Movendaprod codmovprodNew = vendedorcomissao.getCodmovprod();
            Collection<Vendedordesconto> vendedordescontoCollectionOld = persistentVendedorcomissao.getVendedordescontoCollection();
            Collection<Vendedordesconto> vendedordescontoCollectionNew = vendedorcomissao.getVendedordescontoCollection();
            if (codmovendaNew != null) {
                codmovendaNew = em.getReference(codmovendaNew.getClass(), codmovendaNew.getCodmovenda());
                vendedorcomissao.setCodmovenda(codmovendaNew);
            }
            if (codmovprodNew != null) {
                codmovprodNew = em.getReference(codmovprodNew.getClass(), codmovprodNew.getCodmovprod());
                vendedorcomissao.setCodmovprod(codmovprodNew);
            }
            Collection<Vendedordesconto> attachedVendedordescontoCollectionNew = new ArrayList<Vendedordesconto>();
            for (Vendedordesconto vendedordescontoCollectionNewVendedordescontoToAttach : vendedordescontoCollectionNew) {
                vendedordescontoCollectionNewVendedordescontoToAttach = em.getReference(vendedordescontoCollectionNewVendedordescontoToAttach.getClass(), vendedordescontoCollectionNewVendedordescontoToAttach.getCodvendedordesconto());
                attachedVendedordescontoCollectionNew.add(vendedordescontoCollectionNewVendedordescontoToAttach);
            }
            vendedordescontoCollectionNew = attachedVendedordescontoCollectionNew;
            vendedorcomissao.setVendedordescontoCollection(vendedordescontoCollectionNew);
            vendedorcomissao = em.merge(vendedorcomissao);
            if (codmovendaOld != null && !codmovendaOld.equals(codmovendaNew)) {
                codmovendaOld.getVendedorcomissaoCollection().remove(vendedorcomissao);
                codmovendaOld = em.merge(codmovendaOld);
            }
            if (codmovendaNew != null && !codmovendaNew.equals(codmovendaOld)) {
                codmovendaNew.getVendedorcomissaoCollection().add(vendedorcomissao);
                codmovendaNew = em.merge(codmovendaNew);
            }
            if (codmovprodOld != null && !codmovprodOld.equals(codmovprodNew)) {
                codmovprodOld.getVendedorcomissaoCollection().remove(vendedorcomissao);
                codmovprodOld = em.merge(codmovprodOld);
            }
            if (codmovprodNew != null && !codmovprodNew.equals(codmovprodOld)) {
                codmovprodNew.getVendedorcomissaoCollection().add(vendedorcomissao);
                codmovprodNew = em.merge(codmovprodNew);
            }
            for (Vendedordesconto vendedordescontoCollectionOldVendedordesconto : vendedordescontoCollectionOld) {
                if (!vendedordescontoCollectionNew.contains(vendedordescontoCollectionOldVendedordesconto)) {
                    vendedordescontoCollectionOldVendedordesconto.setCodvendedorcomissao(null);
                    vendedordescontoCollectionOldVendedordesconto = em.merge(vendedordescontoCollectionOldVendedordesconto);
                }
            }
            for (Vendedordesconto vendedordescontoCollectionNewVendedordesconto : vendedordescontoCollectionNew) {
                if (!vendedordescontoCollectionOld.contains(vendedordescontoCollectionNewVendedordesconto)) {
                    Vendedorcomissao oldCodvendedorcomissaoOfVendedordescontoCollectionNewVendedordesconto = vendedordescontoCollectionNewVendedordesconto.getCodvendedorcomissao();
                    vendedordescontoCollectionNewVendedordesconto.setCodvendedorcomissao(vendedorcomissao);
                    vendedordescontoCollectionNewVendedordesconto = em.merge(vendedordescontoCollectionNewVendedordesconto);
                    if (oldCodvendedorcomissaoOfVendedordescontoCollectionNewVendedordesconto != null && !oldCodvendedorcomissaoOfVendedordescontoCollectionNewVendedordesconto.equals(vendedorcomissao)) {
                        oldCodvendedorcomissaoOfVendedordescontoCollectionNewVendedordesconto.getVendedordescontoCollection().remove(vendedordescontoCollectionNewVendedordesconto);
                        oldCodvendedorcomissaoOfVendedordescontoCollectionNewVendedordesconto = em.merge(oldCodvendedorcomissaoOfVendedordescontoCollectionNewVendedordesconto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = vendedorcomissao.getCodvendedorcomissao();
                if (findVendedorcomissao(id) == null) {
                    throw new NonexistentEntityException("The vendedorcomissao with id " + id + " no longer exists.");
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
            Vendedorcomissao vendedorcomissao;
            try {
                vendedorcomissao = em.getReference(Vendedorcomissao.class, id);
                vendedorcomissao.getCodvendedorcomissao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vendedorcomissao with id " + id + " no longer exists.", enfe);
            }
            Movenda codmovenda = vendedorcomissao.getCodmovenda();
            if (codmovenda != null) {
                codmovenda.getVendedorcomissaoCollection().remove(vendedorcomissao);
                codmovenda = em.merge(codmovenda);
            }
            Movendaprod codmovprod = vendedorcomissao.getCodmovprod();
            if (codmovprod != null) {
                codmovprod.getVendedorcomissaoCollection().remove(vendedorcomissao);
                codmovprod = em.merge(codmovprod);
            }
            Collection<Vendedordesconto> vendedordescontoCollection = vendedorcomissao.getVendedordescontoCollection();
            for (Vendedordesconto vendedordescontoCollectionVendedordesconto : vendedordescontoCollection) {
                vendedordescontoCollectionVendedordesconto.setCodvendedorcomissao(null);
                vendedordescontoCollectionVendedordesconto = em.merge(vendedordescontoCollectionVendedordesconto);
            }
            em.remove(vendedorcomissao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vendedorcomissao> findVendedorcomissaoEntities() {
        return findVendedorcomissaoEntities(true, -1, -1);
    }

    public List<Vendedorcomissao> findVendedorcomissaoEntities(int maxResults, int firstResult) {
        return findVendedorcomissaoEntities(false, maxResults, firstResult);
    }

    private List<Vendedorcomissao> findVendedorcomissaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vendedorcomissao.class));
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

    public Vendedorcomissao findVendedorcomissao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vendedorcomissao.class, id);
        } finally {
            em.close();
        }
    }

    public int getVendedorcomissaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vendedorcomissao> rt = cq.from(Vendedorcomissao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

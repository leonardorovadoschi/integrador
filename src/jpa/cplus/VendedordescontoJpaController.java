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
import entidade.cplus.Movendaprod;
import entidade.cplus.Moventradaprod;
import entidade.cplus.Vendedorcomissao;
import entidade.cplus.Vendedordesconto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class VendedordescontoJpaController implements Serializable {

    public VendedordescontoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vendedordesconto vendedordesconto) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movendaprod codmovprod = vendedordesconto.getCodmovprod();
            if (codmovprod != null) {
                codmovprod = em.getReference(codmovprod.getClass(), codmovprod.getCodmovprod());
                vendedordesconto.setCodmovprod(codmovprod);
            }
            Moventradaprod codmoveprod = vendedordesconto.getCodmoveprod();
            if (codmoveprod != null) {
                codmoveprod = em.getReference(codmoveprod.getClass(), codmoveprod.getCodmoveprod());
                vendedordesconto.setCodmoveprod(codmoveprod);
            }
            Vendedorcomissao codvendedorcomissao = vendedordesconto.getCodvendedorcomissao();
            if (codvendedorcomissao != null) {
                codvendedorcomissao = em.getReference(codvendedorcomissao.getClass(), codvendedorcomissao.getCodvendedorcomissao());
                vendedordesconto.setCodvendedorcomissao(codvendedorcomissao);
            }
            em.persist(vendedordesconto);
            if (codmovprod != null) {
                codmovprod.getVendedordescontoCollection().add(vendedordesconto);
                codmovprod = em.merge(codmovprod);
            }
            if (codmoveprod != null) {
                codmoveprod.getVendedordescontoCollection().add(vendedordesconto);
                codmoveprod = em.merge(codmoveprod);
            }
            if (codvendedorcomissao != null) {
                codvendedorcomissao.getVendedordescontoCollection().add(vendedordesconto);
                codvendedorcomissao = em.merge(codvendedorcomissao);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVendedordesconto(vendedordesconto.getCodvendedordesconto()) != null) {
                throw new PreexistingEntityException("Vendedordesconto " + vendedordesconto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vendedordesconto vendedordesconto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vendedordesconto persistentVendedordesconto = em.find(Vendedordesconto.class, vendedordesconto.getCodvendedordesconto());
            Movendaprod codmovprodOld = persistentVendedordesconto.getCodmovprod();
            Movendaprod codmovprodNew = vendedordesconto.getCodmovprod();
            Moventradaprod codmoveprodOld = persistentVendedordesconto.getCodmoveprod();
            Moventradaprod codmoveprodNew = vendedordesconto.getCodmoveprod();
            Vendedorcomissao codvendedorcomissaoOld = persistentVendedordesconto.getCodvendedorcomissao();
            Vendedorcomissao codvendedorcomissaoNew = vendedordesconto.getCodvendedorcomissao();
            if (codmovprodNew != null) {
                codmovprodNew = em.getReference(codmovprodNew.getClass(), codmovprodNew.getCodmovprod());
                vendedordesconto.setCodmovprod(codmovprodNew);
            }
            if (codmoveprodNew != null) {
                codmoveprodNew = em.getReference(codmoveprodNew.getClass(), codmoveprodNew.getCodmoveprod());
                vendedordesconto.setCodmoveprod(codmoveprodNew);
            }
            if (codvendedorcomissaoNew != null) {
                codvendedorcomissaoNew = em.getReference(codvendedorcomissaoNew.getClass(), codvendedorcomissaoNew.getCodvendedorcomissao());
                vendedordesconto.setCodvendedorcomissao(codvendedorcomissaoNew);
            }
            vendedordesconto = em.merge(vendedordesconto);
            if (codmovprodOld != null && !codmovprodOld.equals(codmovprodNew)) {
                codmovprodOld.getVendedordescontoCollection().remove(vendedordesconto);
                codmovprodOld = em.merge(codmovprodOld);
            }
            if (codmovprodNew != null && !codmovprodNew.equals(codmovprodOld)) {
                codmovprodNew.getVendedordescontoCollection().add(vendedordesconto);
                codmovprodNew = em.merge(codmovprodNew);
            }
            if (codmoveprodOld != null && !codmoveprodOld.equals(codmoveprodNew)) {
                codmoveprodOld.getVendedordescontoCollection().remove(vendedordesconto);
                codmoveprodOld = em.merge(codmoveprodOld);
            }
            if (codmoveprodNew != null && !codmoveprodNew.equals(codmoveprodOld)) {
                codmoveprodNew.getVendedordescontoCollection().add(vendedordesconto);
                codmoveprodNew = em.merge(codmoveprodNew);
            }
            if (codvendedorcomissaoOld != null && !codvendedorcomissaoOld.equals(codvendedorcomissaoNew)) {
                codvendedorcomissaoOld.getVendedordescontoCollection().remove(vendedordesconto);
                codvendedorcomissaoOld = em.merge(codvendedorcomissaoOld);
            }
            if (codvendedorcomissaoNew != null && !codvendedorcomissaoNew.equals(codvendedorcomissaoOld)) {
                codvendedorcomissaoNew.getVendedordescontoCollection().add(vendedordesconto);
                codvendedorcomissaoNew = em.merge(codvendedorcomissaoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = vendedordesconto.getCodvendedordesconto();
                if (findVendedordesconto(id) == null) {
                    throw new NonexistentEntityException("The vendedordesconto with id " + id + " no longer exists.");
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
            Vendedordesconto vendedordesconto;
            try {
                vendedordesconto = em.getReference(Vendedordesconto.class, id);
                vendedordesconto.getCodvendedordesconto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vendedordesconto with id " + id + " no longer exists.", enfe);
            }
            Movendaprod codmovprod = vendedordesconto.getCodmovprod();
            if (codmovprod != null) {
                codmovprod.getVendedordescontoCollection().remove(vendedordesconto);
                codmovprod = em.merge(codmovprod);
            }
            Moventradaprod codmoveprod = vendedordesconto.getCodmoveprod();
            if (codmoveprod != null) {
                codmoveprod.getVendedordescontoCollection().remove(vendedordesconto);
                codmoveprod = em.merge(codmoveprod);
            }
            Vendedorcomissao codvendedorcomissao = vendedordesconto.getCodvendedorcomissao();
            if (codvendedorcomissao != null) {
                codvendedorcomissao.getVendedordescontoCollection().remove(vendedordesconto);
                codvendedorcomissao = em.merge(codvendedorcomissao);
            }
            em.remove(vendedordesconto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vendedordesconto> findVendedordescontoEntities() {
        return findVendedordescontoEntities(true, -1, -1);
    }

    public List<Vendedordesconto> findVendedordescontoEntities(int maxResults, int firstResult) {
        return findVendedordescontoEntities(false, maxResults, firstResult);
    }

    private List<Vendedordesconto> findVendedordescontoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vendedordesconto.class));
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

    public Vendedordesconto findVendedordesconto(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vendedordesconto.class, id);
        } finally {
            em.close();
        }
    }

    public int getVendedordescontoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vendedordesconto> rt = cq.from(Vendedordesconto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

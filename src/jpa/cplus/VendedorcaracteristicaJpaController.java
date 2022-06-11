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
import entidade.cplus.Caracteristicapessoa;
import entidade.cplus.Vendedor;
import entidade.cplus.Vendedorcaracteristica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class VendedorcaracteristicaJpaController implements Serializable {

    public VendedorcaracteristicaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vendedorcaracteristica vendedorcaracteristica) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Caracteristicapessoa codcaracteristicapessoa = vendedorcaracteristica.getCodcaracteristicapessoa();
            if (codcaracteristicapessoa != null) {
                codcaracteristicapessoa = em.getReference(codcaracteristicapessoa.getClass(), codcaracteristicapessoa.getCodcaracteristicapessoa());
                vendedorcaracteristica.setCodcaracteristicapessoa(codcaracteristicapessoa);
            }
            Vendedor codvended = vendedorcaracteristica.getCodvended();
            if (codvended != null) {
                codvended = em.getReference(codvended.getClass(), codvended.getCodvended());
                vendedorcaracteristica.setCodvended(codvended);
            }
            em.persist(vendedorcaracteristica);
            if (codcaracteristicapessoa != null) {
                codcaracteristicapessoa.getVendedorcaracteristicaCollection().add(vendedorcaracteristica);
                codcaracteristicapessoa = em.merge(codcaracteristicapessoa);
            }
            if (codvended != null) {
                codvended.getVendedorcaracteristicaCollection().add(vendedorcaracteristica);
                codvended = em.merge(codvended);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVendedorcaracteristica(vendedorcaracteristica.getCodvendedorcaracteristica()) != null) {
                throw new PreexistingEntityException("Vendedorcaracteristica " + vendedorcaracteristica + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vendedorcaracteristica vendedorcaracteristica) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vendedorcaracteristica persistentVendedorcaracteristica = em.find(Vendedorcaracteristica.class, vendedorcaracteristica.getCodvendedorcaracteristica());
            Caracteristicapessoa codcaracteristicapessoaOld = persistentVendedorcaracteristica.getCodcaracteristicapessoa();
            Caracteristicapessoa codcaracteristicapessoaNew = vendedorcaracteristica.getCodcaracteristicapessoa();
            Vendedor codvendedOld = persistentVendedorcaracteristica.getCodvended();
            Vendedor codvendedNew = vendedorcaracteristica.getCodvended();
            if (codcaracteristicapessoaNew != null) {
                codcaracteristicapessoaNew = em.getReference(codcaracteristicapessoaNew.getClass(), codcaracteristicapessoaNew.getCodcaracteristicapessoa());
                vendedorcaracteristica.setCodcaracteristicapessoa(codcaracteristicapessoaNew);
            }
            if (codvendedNew != null) {
                codvendedNew = em.getReference(codvendedNew.getClass(), codvendedNew.getCodvended());
                vendedorcaracteristica.setCodvended(codvendedNew);
            }
            vendedorcaracteristica = em.merge(vendedorcaracteristica);
            if (codcaracteristicapessoaOld != null && !codcaracteristicapessoaOld.equals(codcaracteristicapessoaNew)) {
                codcaracteristicapessoaOld.getVendedorcaracteristicaCollection().remove(vendedorcaracteristica);
                codcaracteristicapessoaOld = em.merge(codcaracteristicapessoaOld);
            }
            if (codcaracteristicapessoaNew != null && !codcaracteristicapessoaNew.equals(codcaracteristicapessoaOld)) {
                codcaracteristicapessoaNew.getVendedorcaracteristicaCollection().add(vendedorcaracteristica);
                codcaracteristicapessoaNew = em.merge(codcaracteristicapessoaNew);
            }
            if (codvendedOld != null && !codvendedOld.equals(codvendedNew)) {
                codvendedOld.getVendedorcaracteristicaCollection().remove(vendedorcaracteristica);
                codvendedOld = em.merge(codvendedOld);
            }
            if (codvendedNew != null && !codvendedNew.equals(codvendedOld)) {
                codvendedNew.getVendedorcaracteristicaCollection().add(vendedorcaracteristica);
                codvendedNew = em.merge(codvendedNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = vendedorcaracteristica.getCodvendedorcaracteristica();
                if (findVendedorcaracteristica(id) == null) {
                    throw new NonexistentEntityException("The vendedorcaracteristica with id " + id + " no longer exists.");
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
            Vendedorcaracteristica vendedorcaracteristica;
            try {
                vendedorcaracteristica = em.getReference(Vendedorcaracteristica.class, id);
                vendedorcaracteristica.getCodvendedorcaracteristica();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vendedorcaracteristica with id " + id + " no longer exists.", enfe);
            }
            Caracteristicapessoa codcaracteristicapessoa = vendedorcaracteristica.getCodcaracteristicapessoa();
            if (codcaracteristicapessoa != null) {
                codcaracteristicapessoa.getVendedorcaracteristicaCollection().remove(vendedorcaracteristica);
                codcaracteristicapessoa = em.merge(codcaracteristicapessoa);
            }
            Vendedor codvended = vendedorcaracteristica.getCodvended();
            if (codvended != null) {
                codvended.getVendedorcaracteristicaCollection().remove(vendedorcaracteristica);
                codvended = em.merge(codvended);
            }
            em.remove(vendedorcaracteristica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vendedorcaracteristica> findVendedorcaracteristicaEntities() {
        return findVendedorcaracteristicaEntities(true, -1, -1);
    }

    public List<Vendedorcaracteristica> findVendedorcaracteristicaEntities(int maxResults, int firstResult) {
        return findVendedorcaracteristicaEntities(false, maxResults, firstResult);
    }

    private List<Vendedorcaracteristica> findVendedorcaracteristicaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vendedorcaracteristica.class));
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

    public Vendedorcaracteristica findVendedorcaracteristica(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vendedorcaracteristica.class, id);
        } finally {
            em.close();
        }
    }

    public int getVendedorcaracteristicaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vendedorcaracteristica> rt = cq.from(Vendedorcaracteristica.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

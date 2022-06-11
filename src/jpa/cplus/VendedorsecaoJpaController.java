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
import entidade.cplus.Secao;
import entidade.cplus.Vendedor;
import entidade.cplus.Vendedorsecao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class VendedorsecaoJpaController implements Serializable {

    public VendedorsecaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vendedorsecao vendedorsecao) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Secao codsec = vendedorsecao.getCodsec();
            if (codsec != null) {
                codsec = em.getReference(codsec.getClass(), codsec.getCodsec());
                vendedorsecao.setCodsec(codsec);
            }
            Vendedor codvended = vendedorsecao.getCodvended();
            if (codvended != null) {
                codvended = em.getReference(codvended.getClass(), codvended.getCodvended());
                vendedorsecao.setCodvended(codvended);
            }
            em.persist(vendedorsecao);
            if (codsec != null) {
                codsec.getVendedorsecaoCollection().add(vendedorsecao);
                codsec = em.merge(codsec);
            }
            if (codvended != null) {
                codvended.getVendedorsecaoCollection().add(vendedorsecao);
                codvended = em.merge(codvended);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVendedorsecao(vendedorsecao.getCodvendedorsecao()) != null) {
                throw new PreexistingEntityException("Vendedorsecao " + vendedorsecao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vendedorsecao vendedorsecao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vendedorsecao persistentVendedorsecao = em.find(Vendedorsecao.class, vendedorsecao.getCodvendedorsecao());
            Secao codsecOld = persistentVendedorsecao.getCodsec();
            Secao codsecNew = vendedorsecao.getCodsec();
            Vendedor codvendedOld = persistentVendedorsecao.getCodvended();
            Vendedor codvendedNew = vendedorsecao.getCodvended();
            if (codsecNew != null) {
                codsecNew = em.getReference(codsecNew.getClass(), codsecNew.getCodsec());
                vendedorsecao.setCodsec(codsecNew);
            }
            if (codvendedNew != null) {
                codvendedNew = em.getReference(codvendedNew.getClass(), codvendedNew.getCodvended());
                vendedorsecao.setCodvended(codvendedNew);
            }
            vendedorsecao = em.merge(vendedorsecao);
            if (codsecOld != null && !codsecOld.equals(codsecNew)) {
                codsecOld.getVendedorsecaoCollection().remove(vendedorsecao);
                codsecOld = em.merge(codsecOld);
            }
            if (codsecNew != null && !codsecNew.equals(codsecOld)) {
                codsecNew.getVendedorsecaoCollection().add(vendedorsecao);
                codsecNew = em.merge(codsecNew);
            }
            if (codvendedOld != null && !codvendedOld.equals(codvendedNew)) {
                codvendedOld.getVendedorsecaoCollection().remove(vendedorsecao);
                codvendedOld = em.merge(codvendedOld);
            }
            if (codvendedNew != null && !codvendedNew.equals(codvendedOld)) {
                codvendedNew.getVendedorsecaoCollection().add(vendedorsecao);
                codvendedNew = em.merge(codvendedNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = vendedorsecao.getCodvendedorsecao();
                if (findVendedorsecao(id) == null) {
                    throw new NonexistentEntityException("The vendedorsecao with id " + id + " no longer exists.");
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
            Vendedorsecao vendedorsecao;
            try {
                vendedorsecao = em.getReference(Vendedorsecao.class, id);
                vendedorsecao.getCodvendedorsecao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vendedorsecao with id " + id + " no longer exists.", enfe);
            }
            Secao codsec = vendedorsecao.getCodsec();
            if (codsec != null) {
                codsec.getVendedorsecaoCollection().remove(vendedorsecao);
                codsec = em.merge(codsec);
            }
            Vendedor codvended = vendedorsecao.getCodvended();
            if (codvended != null) {
                codvended.getVendedorsecaoCollection().remove(vendedorsecao);
                codvended = em.merge(codvended);
            }
            em.remove(vendedorsecao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vendedorsecao> findVendedorsecaoEntities() {
        return findVendedorsecaoEntities(true, -1, -1);
    }

    public List<Vendedorsecao> findVendedorsecaoEntities(int maxResults, int firstResult) {
        return findVendedorsecaoEntities(false, maxResults, firstResult);
    }

    private List<Vendedorsecao> findVendedorsecaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vendedorsecao.class));
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

    public Vendedorsecao findVendedorsecao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vendedorsecao.class, id);
        } finally {
            em.close();
        }
    }

    public int getVendedorsecaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vendedorsecao> rt = cq.from(Vendedorsecao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

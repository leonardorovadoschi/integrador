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
import entidade.cplus.Contratocobranca;
import entidade.cplus.Contratocobrancaproduto;
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
public class ContratocobrancaprodutoJpaController implements Serializable {

    public ContratocobrancaprodutoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Contratocobrancaproduto contratocobrancaproduto) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contratocobranca codcontratocobranca = contratocobrancaproduto.getCodcontratocobranca();
            if (codcontratocobranca != null) {
                codcontratocobranca = em.getReference(codcontratocobranca.getClass(), codcontratocobranca.getCodcontratocobranca());
                contratocobrancaproduto.setCodcontratocobranca(codcontratocobranca);
            }
            Produto codprod = contratocobrancaproduto.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                contratocobrancaproduto.setCodprod(codprod);
            }
            em.persist(contratocobrancaproduto);
            if (codcontratocobranca != null) {
                codcontratocobranca.getContratocobrancaprodutoCollection().add(contratocobrancaproduto);
                codcontratocobranca = em.merge(codcontratocobranca);
            }
            if (codprod != null) {
                codprod.getContratocobrancaprodutoCollection().add(contratocobrancaproduto);
                codprod = em.merge(codprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findContratocobrancaproduto(contratocobrancaproduto.getCodcontratocobrancaproduto()) != null) {
                throw new PreexistingEntityException("Contratocobrancaproduto " + contratocobrancaproduto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Contratocobrancaproduto contratocobrancaproduto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contratocobrancaproduto persistentContratocobrancaproduto = em.find(Contratocobrancaproduto.class, contratocobrancaproduto.getCodcontratocobrancaproduto());
            Contratocobranca codcontratocobrancaOld = persistentContratocobrancaproduto.getCodcontratocobranca();
            Contratocobranca codcontratocobrancaNew = contratocobrancaproduto.getCodcontratocobranca();
            Produto codprodOld = persistentContratocobrancaproduto.getCodprod();
            Produto codprodNew = contratocobrancaproduto.getCodprod();
            if (codcontratocobrancaNew != null) {
                codcontratocobrancaNew = em.getReference(codcontratocobrancaNew.getClass(), codcontratocobrancaNew.getCodcontratocobranca());
                contratocobrancaproduto.setCodcontratocobranca(codcontratocobrancaNew);
            }
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                contratocobrancaproduto.setCodprod(codprodNew);
            }
            contratocobrancaproduto = em.merge(contratocobrancaproduto);
            if (codcontratocobrancaOld != null && !codcontratocobrancaOld.equals(codcontratocobrancaNew)) {
                codcontratocobrancaOld.getContratocobrancaprodutoCollection().remove(contratocobrancaproduto);
                codcontratocobrancaOld = em.merge(codcontratocobrancaOld);
            }
            if (codcontratocobrancaNew != null && !codcontratocobrancaNew.equals(codcontratocobrancaOld)) {
                codcontratocobrancaNew.getContratocobrancaprodutoCollection().add(contratocobrancaproduto);
                codcontratocobrancaNew = em.merge(codcontratocobrancaNew);
            }
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getContratocobrancaprodutoCollection().remove(contratocobrancaproduto);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getContratocobrancaprodutoCollection().add(contratocobrancaproduto);
                codprodNew = em.merge(codprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = contratocobrancaproduto.getCodcontratocobrancaproduto();
                if (findContratocobrancaproduto(id) == null) {
                    throw new NonexistentEntityException("The contratocobrancaproduto with id " + id + " no longer exists.");
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
            Contratocobrancaproduto contratocobrancaproduto;
            try {
                contratocobrancaproduto = em.getReference(Contratocobrancaproduto.class, id);
                contratocobrancaproduto.getCodcontratocobrancaproduto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The contratocobrancaproduto with id " + id + " no longer exists.", enfe);
            }
            Contratocobranca codcontratocobranca = contratocobrancaproduto.getCodcontratocobranca();
            if (codcontratocobranca != null) {
                codcontratocobranca.getContratocobrancaprodutoCollection().remove(contratocobrancaproduto);
                codcontratocobranca = em.merge(codcontratocobranca);
            }
            Produto codprod = contratocobrancaproduto.getCodprod();
            if (codprod != null) {
                codprod.getContratocobrancaprodutoCollection().remove(contratocobrancaproduto);
                codprod = em.merge(codprod);
            }
            em.remove(contratocobrancaproduto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Contratocobrancaproduto> findContratocobrancaprodutoEntities() {
        return findContratocobrancaprodutoEntities(true, -1, -1);
    }

    public List<Contratocobrancaproduto> findContratocobrancaprodutoEntities(int maxResults, int firstResult) {
        return findContratocobrancaprodutoEntities(false, maxResults, firstResult);
    }

    private List<Contratocobrancaproduto> findContratocobrancaprodutoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Contratocobrancaproduto.class));
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

    public Contratocobrancaproduto findContratocobrancaproduto(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Contratocobrancaproduto.class, id);
        } finally {
            em.close();
        }
    }

    public int getContratocobrancaprodutoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Contratocobrancaproduto> rt = cq.from(Contratocobrancaproduto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

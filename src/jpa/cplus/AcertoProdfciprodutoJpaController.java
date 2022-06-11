/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.AcertoProdfciproduto;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class AcertoProdfciprodutoJpaController implements Serializable {

    public AcertoProdfciprodutoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AcertoProdfciproduto acertoProdfciproduto) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto codprod = acertoProdfciproduto.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                acertoProdfciproduto.setCodprod(codprod);
            }
            em.persist(acertoProdfciproduto);
            if (codprod != null) {
                codprod.getAcertoProdfciprodutoCollection().add(acertoProdfciproduto);
                codprod = em.merge(codprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAcertoProdfciproduto(acertoProdfciproduto.getId()) != null) {
                throw new PreexistingEntityException("AcertoProdfciproduto " + acertoProdfciproduto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AcertoProdfciproduto acertoProdfciproduto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AcertoProdfciproduto persistentAcertoProdfciproduto = em.find(AcertoProdfciproduto.class, acertoProdfciproduto.getId());
            Produto codprodOld = persistentAcertoProdfciproduto.getCodprod();
            Produto codprodNew = acertoProdfciproduto.getCodprod();
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                acertoProdfciproduto.setCodprod(codprodNew);
            }
            acertoProdfciproduto = em.merge(acertoProdfciproduto);
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getAcertoProdfciprodutoCollection().remove(acertoProdfciproduto);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getAcertoProdfciprodutoCollection().add(acertoProdfciproduto);
                codprodNew = em.merge(codprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = acertoProdfciproduto.getId();
                if (findAcertoProdfciproduto(id) == null) {
                    throw new NonexistentEntityException("The acertoProdfciproduto with id " + id + " no longer exists.");
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
            AcertoProdfciproduto acertoProdfciproduto;
            try {
                acertoProdfciproduto = em.getReference(AcertoProdfciproduto.class, id);
                acertoProdfciproduto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The acertoProdfciproduto with id " + id + " no longer exists.", enfe);
            }
            Produto codprod = acertoProdfciproduto.getCodprod();
            if (codprod != null) {
                codprod.getAcertoProdfciprodutoCollection().remove(acertoProdfciproduto);
                codprod = em.merge(codprod);
            }
            em.remove(acertoProdfciproduto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AcertoProdfciproduto> findAcertoProdfciprodutoEntities() {
        return findAcertoProdfciprodutoEntities(true, -1, -1);
    }

    public List<AcertoProdfciproduto> findAcertoProdfciprodutoEntities(int maxResults, int firstResult) {
        return findAcertoProdfciprodutoEntities(false, maxResults, firstResult);
    }

    private List<AcertoProdfciproduto> findAcertoProdfciprodutoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AcertoProdfciproduto.class));
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

    public AcertoProdfciproduto findAcertoProdfciproduto(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AcertoProdfciproduto.class, id);
        } finally {
            em.close();
        }
    }

    public int getAcertoProdfciprodutoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AcertoProdfciproduto> rt = cq.from(AcertoProdfciproduto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

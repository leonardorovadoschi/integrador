/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.AcertoProdloteproduto;
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
public class AcertoProdloteprodutoJpaController implements Serializable {

    public AcertoProdloteprodutoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AcertoProdloteproduto acertoProdloteproduto) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto codprod = acertoProdloteproduto.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                acertoProdloteproduto.setCodprod(codprod);
            }
            em.persist(acertoProdloteproduto);
            if (codprod != null) {
                codprod.getAcertoProdloteprodutoCollection().add(acertoProdloteproduto);
                codprod = em.merge(codprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAcertoProdloteproduto(acertoProdloteproduto.getId()) != null) {
                throw new PreexistingEntityException("AcertoProdloteproduto " + acertoProdloteproduto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AcertoProdloteproduto acertoProdloteproduto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AcertoProdloteproduto persistentAcertoProdloteproduto = em.find(AcertoProdloteproduto.class, acertoProdloteproduto.getId());
            Produto codprodOld = persistentAcertoProdloteproduto.getCodprod();
            Produto codprodNew = acertoProdloteproduto.getCodprod();
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                acertoProdloteproduto.setCodprod(codprodNew);
            }
            acertoProdloteproduto = em.merge(acertoProdloteproduto);
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getAcertoProdloteprodutoCollection().remove(acertoProdloteproduto);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getAcertoProdloteprodutoCollection().add(acertoProdloteproduto);
                codprodNew = em.merge(codprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = acertoProdloteproduto.getId();
                if (findAcertoProdloteproduto(id) == null) {
                    throw new NonexistentEntityException("The acertoProdloteproduto with id " + id + " no longer exists.");
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
            AcertoProdloteproduto acertoProdloteproduto;
            try {
                acertoProdloteproduto = em.getReference(AcertoProdloteproduto.class, id);
                acertoProdloteproduto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The acertoProdloteproduto with id " + id + " no longer exists.", enfe);
            }
            Produto codprod = acertoProdloteproduto.getCodprod();
            if (codprod != null) {
                codprod.getAcertoProdloteprodutoCollection().remove(acertoProdloteproduto);
                codprod = em.merge(codprod);
            }
            em.remove(acertoProdloteproduto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AcertoProdloteproduto> findAcertoProdloteprodutoEntities() {
        return findAcertoProdloteprodutoEntities(true, -1, -1);
    }

    public List<AcertoProdloteproduto> findAcertoProdloteprodutoEntities(int maxResults, int firstResult) {
        return findAcertoProdloteprodutoEntities(false, maxResults, firstResult);
    }

    private List<AcertoProdloteproduto> findAcertoProdloteprodutoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AcertoProdloteproduto.class));
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

    public AcertoProdloteproduto findAcertoProdloteproduto(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AcertoProdloteproduto.class, id);
        } finally {
            em.close();
        }
    }

    public int getAcertoProdloteprodutoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AcertoProdloteproduto> rt = cq.from(AcertoProdloteproduto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

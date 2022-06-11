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
import entidade.cplus.Acerto;
import entidade.cplus.Acertoproduto;
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
public class AcertoprodutoJpaController implements Serializable {

    public AcertoprodutoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Acertoproduto acertoproduto) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Acerto codacerto = acertoproduto.getCodacerto();
            if (codacerto != null) {
                codacerto = em.getReference(codacerto.getClass(), codacerto.getCodacerto());
                acertoproduto.setCodacerto(codacerto);
            }
            Produto codprod = acertoproduto.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                acertoproduto.setCodprod(codprod);
            }
            em.persist(acertoproduto);
            if (codacerto != null) {
                codacerto.getAcertoprodutoCollection().add(acertoproduto);
                codacerto = em.merge(codacerto);
            }
            if (codprod != null) {
                codprod.getAcertoprodutoCollection().add(acertoproduto);
                codprod = em.merge(codprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAcertoproduto(acertoproduto.getCodacertoproduto()) != null) {
                throw new PreexistingEntityException("Acertoproduto " + acertoproduto + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Acertoproduto acertoproduto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Acertoproduto persistentAcertoproduto = em.find(Acertoproduto.class, acertoproduto.getCodacertoproduto());
            Acerto codacertoOld = persistentAcertoproduto.getCodacerto();
            Acerto codacertoNew = acertoproduto.getCodacerto();
            Produto codprodOld = persistentAcertoproduto.getCodprod();
            Produto codprodNew = acertoproduto.getCodprod();
            if (codacertoNew != null) {
                codacertoNew = em.getReference(codacertoNew.getClass(), codacertoNew.getCodacerto());
                acertoproduto.setCodacerto(codacertoNew);
            }
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                acertoproduto.setCodprod(codprodNew);
            }
            acertoproduto = em.merge(acertoproduto);
            if (codacertoOld != null && !codacertoOld.equals(codacertoNew)) {
                codacertoOld.getAcertoprodutoCollection().remove(acertoproduto);
                codacertoOld = em.merge(codacertoOld);
            }
            if (codacertoNew != null && !codacertoNew.equals(codacertoOld)) {
                codacertoNew.getAcertoprodutoCollection().add(acertoproduto);
                codacertoNew = em.merge(codacertoNew);
            }
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getAcertoprodutoCollection().remove(acertoproduto);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getAcertoprodutoCollection().add(acertoproduto);
                codprodNew = em.merge(codprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = acertoproduto.getCodacertoproduto();
                if (findAcertoproduto(id) == null) {
                    throw new NonexistentEntityException("The acertoproduto with id " + id + " no longer exists.");
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
            Acertoproduto acertoproduto;
            try {
                acertoproduto = em.getReference(Acertoproduto.class, id);
                acertoproduto.getCodacertoproduto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The acertoproduto with id " + id + " no longer exists.", enfe);
            }
            Acerto codacerto = acertoproduto.getCodacerto();
            if (codacerto != null) {
                codacerto.getAcertoprodutoCollection().remove(acertoproduto);
                codacerto = em.merge(codacerto);
            }
            Produto codprod = acertoproduto.getCodprod();
            if (codprod != null) {
                codprod.getAcertoprodutoCollection().remove(acertoproduto);
                codprod = em.merge(codprod);
            }
            em.remove(acertoproduto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Acertoproduto> findAcertoprodutoEntities() {
        return findAcertoprodutoEntities(true, -1, -1);
    }

    public List<Acertoproduto> findAcertoprodutoEntities(int maxResults, int firstResult) {
        return findAcertoprodutoEntities(false, maxResults, firstResult);
    }

    private List<Acertoproduto> findAcertoprodutoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Acertoproduto.class));
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

    public Acertoproduto findAcertoproduto(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Acertoproduto.class, id);
        } finally {
            em.close();
        }
    }

    public int getAcertoprodutoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Acertoproduto> rt = cq.from(Acertoproduto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

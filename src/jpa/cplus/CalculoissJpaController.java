/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Calculoiss;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Produto;
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
public class CalculoissJpaController implements Serializable {

    public CalculoissJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Calculoiss calculoiss) throws PreexistingEntityException, Exception {
        if (calculoiss.getProdutoCollection() == null) {
            calculoiss.setProdutoCollection(new ArrayList<Produto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Produto> attachedProdutoCollection = new ArrayList<Produto>();
            for (Produto produtoCollectionProdutoToAttach : calculoiss.getProdutoCollection()) {
                produtoCollectionProdutoToAttach = em.getReference(produtoCollectionProdutoToAttach.getClass(), produtoCollectionProdutoToAttach.getCodprod());
                attachedProdutoCollection.add(produtoCollectionProdutoToAttach);
            }
            calculoiss.setProdutoCollection(attachedProdutoCollection);
            em.persist(calculoiss);
            for (Produto produtoCollectionProduto : calculoiss.getProdutoCollection()) {
                Calculoiss oldCodcalculoissOfProdutoCollectionProduto = produtoCollectionProduto.getCodcalculoiss();
                produtoCollectionProduto.setCodcalculoiss(calculoiss);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
                if (oldCodcalculoissOfProdutoCollectionProduto != null) {
                    oldCodcalculoissOfProdutoCollectionProduto.getProdutoCollection().remove(produtoCollectionProduto);
                    oldCodcalculoissOfProdutoCollectionProduto = em.merge(oldCodcalculoissOfProdutoCollectionProduto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCalculoiss(calculoiss.getCodcalculoiss()) != null) {
                throw new PreexistingEntityException("Calculoiss " + calculoiss + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Calculoiss calculoiss) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Calculoiss persistentCalculoiss = em.find(Calculoiss.class, calculoiss.getCodcalculoiss());
            Collection<Produto> produtoCollectionOld = persistentCalculoiss.getProdutoCollection();
            Collection<Produto> produtoCollectionNew = calculoiss.getProdutoCollection();
            Collection<Produto> attachedProdutoCollectionNew = new ArrayList<Produto>();
            for (Produto produtoCollectionNewProdutoToAttach : produtoCollectionNew) {
                produtoCollectionNewProdutoToAttach = em.getReference(produtoCollectionNewProdutoToAttach.getClass(), produtoCollectionNewProdutoToAttach.getCodprod());
                attachedProdutoCollectionNew.add(produtoCollectionNewProdutoToAttach);
            }
            produtoCollectionNew = attachedProdutoCollectionNew;
            calculoiss.setProdutoCollection(produtoCollectionNew);
            calculoiss = em.merge(calculoiss);
            for (Produto produtoCollectionOldProduto : produtoCollectionOld) {
                if (!produtoCollectionNew.contains(produtoCollectionOldProduto)) {
                    produtoCollectionOldProduto.setCodcalculoiss(null);
                    produtoCollectionOldProduto = em.merge(produtoCollectionOldProduto);
                }
            }
            for (Produto produtoCollectionNewProduto : produtoCollectionNew) {
                if (!produtoCollectionOld.contains(produtoCollectionNewProduto)) {
                    Calculoiss oldCodcalculoissOfProdutoCollectionNewProduto = produtoCollectionNewProduto.getCodcalculoiss();
                    produtoCollectionNewProduto.setCodcalculoiss(calculoiss);
                    produtoCollectionNewProduto = em.merge(produtoCollectionNewProduto);
                    if (oldCodcalculoissOfProdutoCollectionNewProduto != null && !oldCodcalculoissOfProdutoCollectionNewProduto.equals(calculoiss)) {
                        oldCodcalculoissOfProdutoCollectionNewProduto.getProdutoCollection().remove(produtoCollectionNewProduto);
                        oldCodcalculoissOfProdutoCollectionNewProduto = em.merge(oldCodcalculoissOfProdutoCollectionNewProduto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = calculoiss.getCodcalculoiss();
                if (findCalculoiss(id) == null) {
                    throw new NonexistentEntityException("The calculoiss with id " + id + " no longer exists.");
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
            Calculoiss calculoiss;
            try {
                calculoiss = em.getReference(Calculoiss.class, id);
                calculoiss.getCodcalculoiss();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The calculoiss with id " + id + " no longer exists.", enfe);
            }
            Collection<Produto> produtoCollection = calculoiss.getProdutoCollection();
            for (Produto produtoCollectionProduto : produtoCollection) {
                produtoCollectionProduto.setCodcalculoiss(null);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
            }
            em.remove(calculoiss);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Calculoiss> findCalculoissEntities() {
        return findCalculoissEntities(true, -1, -1);
    }

    public List<Calculoiss> findCalculoissEntities(int maxResults, int firstResult) {
        return findCalculoissEntities(false, maxResults, firstResult);
    }

    private List<Calculoiss> findCalculoissEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Calculoiss.class));
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

    public Calculoiss findCalculoiss(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Calculoiss.class, id);
        } finally {
            em.close();
        }
    }

    public int getCalculoissCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Calculoiss> rt = cq.from(Calculoiss.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
import entidade.cplus.Produto;
import entidade.cplus.Tributacaoecf;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Tributacaoecfuf;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class TributacaoecfJpaController implements Serializable {

    public TributacaoecfJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tributacaoecf tributacaoecf) throws PreexistingEntityException, Exception {
        if (tributacaoecf.getProdutoCollection() == null) {
            tributacaoecf.setProdutoCollection(new ArrayList<Produto>());
        }
        if (tributacaoecf.getTributacaoecfufCollection() == null) {
            tributacaoecf.setTributacaoecfufCollection(new ArrayList<Tributacaoecfuf>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Produto> attachedProdutoCollection = new ArrayList<Produto>();
            for (Produto produtoCollectionProdutoToAttach : tributacaoecf.getProdutoCollection()) {
                produtoCollectionProdutoToAttach = em.getReference(produtoCollectionProdutoToAttach.getClass(), produtoCollectionProdutoToAttach.getCodprod());
                attachedProdutoCollection.add(produtoCollectionProdutoToAttach);
            }
            tributacaoecf.setProdutoCollection(attachedProdutoCollection);
            Collection<Tributacaoecfuf> attachedTributacaoecfufCollection = new ArrayList<Tributacaoecfuf>();
            for (Tributacaoecfuf tributacaoecfufCollectionTributacaoecfufToAttach : tributacaoecf.getTributacaoecfufCollection()) {
                tributacaoecfufCollectionTributacaoecfufToAttach = em.getReference(tributacaoecfufCollectionTributacaoecfufToAttach.getClass(), tributacaoecfufCollectionTributacaoecfufToAttach.getCodtributacaoecfuf());
                attachedTributacaoecfufCollection.add(tributacaoecfufCollectionTributacaoecfufToAttach);
            }
            tributacaoecf.setTributacaoecfufCollection(attachedTributacaoecfufCollection);
            em.persist(tributacaoecf);
            for (Produto produtoCollectionProduto : tributacaoecf.getProdutoCollection()) {
                Tributacaoecf oldCodtributacaoecfOfProdutoCollectionProduto = produtoCollectionProduto.getCodtributacaoecf();
                produtoCollectionProduto.setCodtributacaoecf(tributacaoecf);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
                if (oldCodtributacaoecfOfProdutoCollectionProduto != null) {
                    oldCodtributacaoecfOfProdutoCollectionProduto.getProdutoCollection().remove(produtoCollectionProduto);
                    oldCodtributacaoecfOfProdutoCollectionProduto = em.merge(oldCodtributacaoecfOfProdutoCollectionProduto);
                }
            }
            for (Tributacaoecfuf tributacaoecfufCollectionTributacaoecfuf : tributacaoecf.getTributacaoecfufCollection()) {
                Tributacaoecf oldCodtributacaoecfOfTributacaoecfufCollectionTributacaoecfuf = tributacaoecfufCollectionTributacaoecfuf.getCodtributacaoecf();
                tributacaoecfufCollectionTributacaoecfuf.setCodtributacaoecf(tributacaoecf);
                tributacaoecfufCollectionTributacaoecfuf = em.merge(tributacaoecfufCollectionTributacaoecfuf);
                if (oldCodtributacaoecfOfTributacaoecfufCollectionTributacaoecfuf != null) {
                    oldCodtributacaoecfOfTributacaoecfufCollectionTributacaoecfuf.getTributacaoecfufCollection().remove(tributacaoecfufCollectionTributacaoecfuf);
                    oldCodtributacaoecfOfTributacaoecfufCollectionTributacaoecfuf = em.merge(oldCodtributacaoecfOfTributacaoecfufCollectionTributacaoecfuf);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTributacaoecf(tributacaoecf.getCodtributacaoecf()) != null) {
                throw new PreexistingEntityException("Tributacaoecf " + tributacaoecf + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tributacaoecf tributacaoecf) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tributacaoecf persistentTributacaoecf = em.find(Tributacaoecf.class, tributacaoecf.getCodtributacaoecf());
            Collection<Produto> produtoCollectionOld = persistentTributacaoecf.getProdutoCollection();
            Collection<Produto> produtoCollectionNew = tributacaoecf.getProdutoCollection();
            Collection<Tributacaoecfuf> tributacaoecfufCollectionOld = persistentTributacaoecf.getTributacaoecfufCollection();
            Collection<Tributacaoecfuf> tributacaoecfufCollectionNew = tributacaoecf.getTributacaoecfufCollection();
            Collection<Produto> attachedProdutoCollectionNew = new ArrayList<Produto>();
            for (Produto produtoCollectionNewProdutoToAttach : produtoCollectionNew) {
                produtoCollectionNewProdutoToAttach = em.getReference(produtoCollectionNewProdutoToAttach.getClass(), produtoCollectionNewProdutoToAttach.getCodprod());
                attachedProdutoCollectionNew.add(produtoCollectionNewProdutoToAttach);
            }
            produtoCollectionNew = attachedProdutoCollectionNew;
            tributacaoecf.setProdutoCollection(produtoCollectionNew);
            Collection<Tributacaoecfuf> attachedTributacaoecfufCollectionNew = new ArrayList<Tributacaoecfuf>();
            for (Tributacaoecfuf tributacaoecfufCollectionNewTributacaoecfufToAttach : tributacaoecfufCollectionNew) {
                tributacaoecfufCollectionNewTributacaoecfufToAttach = em.getReference(tributacaoecfufCollectionNewTributacaoecfufToAttach.getClass(), tributacaoecfufCollectionNewTributacaoecfufToAttach.getCodtributacaoecfuf());
                attachedTributacaoecfufCollectionNew.add(tributacaoecfufCollectionNewTributacaoecfufToAttach);
            }
            tributacaoecfufCollectionNew = attachedTributacaoecfufCollectionNew;
            tributacaoecf.setTributacaoecfufCollection(tributacaoecfufCollectionNew);
            tributacaoecf = em.merge(tributacaoecf);
            for (Produto produtoCollectionOldProduto : produtoCollectionOld) {
                if (!produtoCollectionNew.contains(produtoCollectionOldProduto)) {
                    produtoCollectionOldProduto.setCodtributacaoecf(null);
                    produtoCollectionOldProduto = em.merge(produtoCollectionOldProduto);
                }
            }
            for (Produto produtoCollectionNewProduto : produtoCollectionNew) {
                if (!produtoCollectionOld.contains(produtoCollectionNewProduto)) {
                    Tributacaoecf oldCodtributacaoecfOfProdutoCollectionNewProduto = produtoCollectionNewProduto.getCodtributacaoecf();
                    produtoCollectionNewProduto.setCodtributacaoecf(tributacaoecf);
                    produtoCollectionNewProduto = em.merge(produtoCollectionNewProduto);
                    if (oldCodtributacaoecfOfProdutoCollectionNewProduto != null && !oldCodtributacaoecfOfProdutoCollectionNewProduto.equals(tributacaoecf)) {
                        oldCodtributacaoecfOfProdutoCollectionNewProduto.getProdutoCollection().remove(produtoCollectionNewProduto);
                        oldCodtributacaoecfOfProdutoCollectionNewProduto = em.merge(oldCodtributacaoecfOfProdutoCollectionNewProduto);
                    }
                }
            }
            for (Tributacaoecfuf tributacaoecfufCollectionOldTributacaoecfuf : tributacaoecfufCollectionOld) {
                if (!tributacaoecfufCollectionNew.contains(tributacaoecfufCollectionOldTributacaoecfuf)) {
                    tributacaoecfufCollectionOldTributacaoecfuf.setCodtributacaoecf(null);
                    tributacaoecfufCollectionOldTributacaoecfuf = em.merge(tributacaoecfufCollectionOldTributacaoecfuf);
                }
            }
            for (Tributacaoecfuf tributacaoecfufCollectionNewTributacaoecfuf : tributacaoecfufCollectionNew) {
                if (!tributacaoecfufCollectionOld.contains(tributacaoecfufCollectionNewTributacaoecfuf)) {
                    Tributacaoecf oldCodtributacaoecfOfTributacaoecfufCollectionNewTributacaoecfuf = tributacaoecfufCollectionNewTributacaoecfuf.getCodtributacaoecf();
                    tributacaoecfufCollectionNewTributacaoecfuf.setCodtributacaoecf(tributacaoecf);
                    tributacaoecfufCollectionNewTributacaoecfuf = em.merge(tributacaoecfufCollectionNewTributacaoecfuf);
                    if (oldCodtributacaoecfOfTributacaoecfufCollectionNewTributacaoecfuf != null && !oldCodtributacaoecfOfTributacaoecfufCollectionNewTributacaoecfuf.equals(tributacaoecf)) {
                        oldCodtributacaoecfOfTributacaoecfufCollectionNewTributacaoecfuf.getTributacaoecfufCollection().remove(tributacaoecfufCollectionNewTributacaoecfuf);
                        oldCodtributacaoecfOfTributacaoecfufCollectionNewTributacaoecfuf = em.merge(oldCodtributacaoecfOfTributacaoecfufCollectionNewTributacaoecfuf);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tributacaoecf.getCodtributacaoecf();
                if (findTributacaoecf(id) == null) {
                    throw new NonexistentEntityException("The tributacaoecf with id " + id + " no longer exists.");
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
            Tributacaoecf tributacaoecf;
            try {
                tributacaoecf = em.getReference(Tributacaoecf.class, id);
                tributacaoecf.getCodtributacaoecf();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tributacaoecf with id " + id + " no longer exists.", enfe);
            }
            Collection<Produto> produtoCollection = tributacaoecf.getProdutoCollection();
            for (Produto produtoCollectionProduto : produtoCollection) {
                produtoCollectionProduto.setCodtributacaoecf(null);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
            }
            Collection<Tributacaoecfuf> tributacaoecfufCollection = tributacaoecf.getTributacaoecfufCollection();
            for (Tributacaoecfuf tributacaoecfufCollectionTributacaoecfuf : tributacaoecfufCollection) {
                tributacaoecfufCollectionTributacaoecfuf.setCodtributacaoecf(null);
                tributacaoecfufCollectionTributacaoecfuf = em.merge(tributacaoecfufCollectionTributacaoecfuf);
            }
            em.remove(tributacaoecf);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tributacaoecf> findTributacaoecfEntities() {
        return findTributacaoecfEntities(true, -1, -1);
    }

    public List<Tributacaoecf> findTributacaoecfEntities(int maxResults, int firstResult) {
        return findTributacaoecfEntities(false, maxResults, firstResult);
    }

    private List<Tributacaoecf> findTributacaoecfEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tributacaoecf.class));
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

    public Tributacaoecf findTributacaoecf(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tributacaoecf.class, id);
        } finally {
            em.close();
        }
    }

    public int getTributacaoecfCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tributacaoecf> rt = cq.from(Tributacaoecf.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Moeda;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Produtopreco;
import java.util.ArrayList;
import java.util.Collection;
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
public class MoedaJpaController implements Serializable {

    public MoedaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Moeda moeda) throws PreexistingEntityException, Exception {
        if (moeda.getProdutoprecoCollection() == null) {
            moeda.setProdutoprecoCollection(new ArrayList<Produtopreco>());
        }
        if (moeda.getProdutoCollection() == null) {
            moeda.setProdutoCollection(new ArrayList<Produto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Produtopreco> attachedProdutoprecoCollection = new ArrayList<Produtopreco>();
            for (Produtopreco produtoprecoCollectionProdutoprecoToAttach : moeda.getProdutoprecoCollection()) {
                produtoprecoCollectionProdutoprecoToAttach = em.getReference(produtoprecoCollectionProdutoprecoToAttach.getClass(), produtoprecoCollectionProdutoprecoToAttach.getCodprodutopreco());
                attachedProdutoprecoCollection.add(produtoprecoCollectionProdutoprecoToAttach);
            }
            moeda.setProdutoprecoCollection(attachedProdutoprecoCollection);
            Collection<Produto> attachedProdutoCollection = new ArrayList<Produto>();
            for (Produto produtoCollectionProdutoToAttach : moeda.getProdutoCollection()) {
                produtoCollectionProdutoToAttach = em.getReference(produtoCollectionProdutoToAttach.getClass(), produtoCollectionProdutoToAttach.getCodprod());
                attachedProdutoCollection.add(produtoCollectionProdutoToAttach);
            }
            moeda.setProdutoCollection(attachedProdutoCollection);
            em.persist(moeda);
            for (Produtopreco produtoprecoCollectionProdutopreco : moeda.getProdutoprecoCollection()) {
                Moeda oldCodmoedaOfProdutoprecoCollectionProdutopreco = produtoprecoCollectionProdutopreco.getCodmoeda();
                produtoprecoCollectionProdutopreco.setCodmoeda(moeda);
                produtoprecoCollectionProdutopreco = em.merge(produtoprecoCollectionProdutopreco);
                if (oldCodmoedaOfProdutoprecoCollectionProdutopreco != null) {
                    oldCodmoedaOfProdutoprecoCollectionProdutopreco.getProdutoprecoCollection().remove(produtoprecoCollectionProdutopreco);
                    oldCodmoedaOfProdutoprecoCollectionProdutopreco = em.merge(oldCodmoedaOfProdutoprecoCollectionProdutopreco);
                }
            }
            for (Produto produtoCollectionProduto : moeda.getProdutoCollection()) {
                Moeda oldCodmoedaOfProdutoCollectionProduto = produtoCollectionProduto.getCodmoeda();
                produtoCollectionProduto.setCodmoeda(moeda);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
                if (oldCodmoedaOfProdutoCollectionProduto != null) {
                    oldCodmoedaOfProdutoCollectionProduto.getProdutoCollection().remove(produtoCollectionProduto);
                    oldCodmoedaOfProdutoCollectionProduto = em.merge(oldCodmoedaOfProdutoCollectionProduto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMoeda(moeda.getCodmoeda()) != null) {
                throw new PreexistingEntityException("Moeda " + moeda + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Moeda moeda) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Moeda persistentMoeda = em.find(Moeda.class, moeda.getCodmoeda());
            Collection<Produtopreco> produtoprecoCollectionOld = persistentMoeda.getProdutoprecoCollection();
            Collection<Produtopreco> produtoprecoCollectionNew = moeda.getProdutoprecoCollection();
            Collection<Produto> produtoCollectionOld = persistentMoeda.getProdutoCollection();
            Collection<Produto> produtoCollectionNew = moeda.getProdutoCollection();
            Collection<Produtopreco> attachedProdutoprecoCollectionNew = new ArrayList<Produtopreco>();
            for (Produtopreco produtoprecoCollectionNewProdutoprecoToAttach : produtoprecoCollectionNew) {
                produtoprecoCollectionNewProdutoprecoToAttach = em.getReference(produtoprecoCollectionNewProdutoprecoToAttach.getClass(), produtoprecoCollectionNewProdutoprecoToAttach.getCodprodutopreco());
                attachedProdutoprecoCollectionNew.add(produtoprecoCollectionNewProdutoprecoToAttach);
            }
            produtoprecoCollectionNew = attachedProdutoprecoCollectionNew;
            moeda.setProdutoprecoCollection(produtoprecoCollectionNew);
            Collection<Produto> attachedProdutoCollectionNew = new ArrayList<Produto>();
            for (Produto produtoCollectionNewProdutoToAttach : produtoCollectionNew) {
                produtoCollectionNewProdutoToAttach = em.getReference(produtoCollectionNewProdutoToAttach.getClass(), produtoCollectionNewProdutoToAttach.getCodprod());
                attachedProdutoCollectionNew.add(produtoCollectionNewProdutoToAttach);
            }
            produtoCollectionNew = attachedProdutoCollectionNew;
            moeda.setProdutoCollection(produtoCollectionNew);
            moeda = em.merge(moeda);
            for (Produtopreco produtoprecoCollectionOldProdutopreco : produtoprecoCollectionOld) {
                if (!produtoprecoCollectionNew.contains(produtoprecoCollectionOldProdutopreco)) {
                    produtoprecoCollectionOldProdutopreco.setCodmoeda(null);
                    produtoprecoCollectionOldProdutopreco = em.merge(produtoprecoCollectionOldProdutopreco);
                }
            }
            for (Produtopreco produtoprecoCollectionNewProdutopreco : produtoprecoCollectionNew) {
                if (!produtoprecoCollectionOld.contains(produtoprecoCollectionNewProdutopreco)) {
                    Moeda oldCodmoedaOfProdutoprecoCollectionNewProdutopreco = produtoprecoCollectionNewProdutopreco.getCodmoeda();
                    produtoprecoCollectionNewProdutopreco.setCodmoeda(moeda);
                    produtoprecoCollectionNewProdutopreco = em.merge(produtoprecoCollectionNewProdutopreco);
                    if (oldCodmoedaOfProdutoprecoCollectionNewProdutopreco != null && !oldCodmoedaOfProdutoprecoCollectionNewProdutopreco.equals(moeda)) {
                        oldCodmoedaOfProdutoprecoCollectionNewProdutopreco.getProdutoprecoCollection().remove(produtoprecoCollectionNewProdutopreco);
                        oldCodmoedaOfProdutoprecoCollectionNewProdutopreco = em.merge(oldCodmoedaOfProdutoprecoCollectionNewProdutopreco);
                    }
                }
            }
            for (Produto produtoCollectionOldProduto : produtoCollectionOld) {
                if (!produtoCollectionNew.contains(produtoCollectionOldProduto)) {
                    produtoCollectionOldProduto.setCodmoeda(null);
                    produtoCollectionOldProduto = em.merge(produtoCollectionOldProduto);
                }
            }
            for (Produto produtoCollectionNewProduto : produtoCollectionNew) {
                if (!produtoCollectionOld.contains(produtoCollectionNewProduto)) {
                    Moeda oldCodmoedaOfProdutoCollectionNewProduto = produtoCollectionNewProduto.getCodmoeda();
                    produtoCollectionNewProduto.setCodmoeda(moeda);
                    produtoCollectionNewProduto = em.merge(produtoCollectionNewProduto);
                    if (oldCodmoedaOfProdutoCollectionNewProduto != null && !oldCodmoedaOfProdutoCollectionNewProduto.equals(moeda)) {
                        oldCodmoedaOfProdutoCollectionNewProduto.getProdutoCollection().remove(produtoCollectionNewProduto);
                        oldCodmoedaOfProdutoCollectionNewProduto = em.merge(oldCodmoedaOfProdutoCollectionNewProduto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = moeda.getCodmoeda();
                if (findMoeda(id) == null) {
                    throw new NonexistentEntityException("The moeda with id " + id + " no longer exists.");
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
            Moeda moeda;
            try {
                moeda = em.getReference(Moeda.class, id);
                moeda.getCodmoeda();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The moeda with id " + id + " no longer exists.", enfe);
            }
            Collection<Produtopreco> produtoprecoCollection = moeda.getProdutoprecoCollection();
            for (Produtopreco produtoprecoCollectionProdutopreco : produtoprecoCollection) {
                produtoprecoCollectionProdutopreco.setCodmoeda(null);
                produtoprecoCollectionProdutopreco = em.merge(produtoprecoCollectionProdutopreco);
            }
            Collection<Produto> produtoCollection = moeda.getProdutoCollection();
            for (Produto produtoCollectionProduto : produtoCollection) {
                produtoCollectionProduto.setCodmoeda(null);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
            }
            em.remove(moeda);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Moeda> findMoedaEntities() {
        return findMoedaEntities(true, -1, -1);
    }

    public List<Moeda> findMoedaEntities(int maxResults, int firstResult) {
        return findMoedaEntities(false, maxResults, firstResult);
    }

    private List<Moeda> findMoedaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Moeda.class));
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

    public Moeda findMoeda(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Moeda.class, id);
        } finally {
            em.close();
        }
    }

    public int getMoedaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Moeda> rt = cq.from(Moeda.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

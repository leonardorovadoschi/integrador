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
import entidade.cplus.Vendedorsecao;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Produto;
import entidade.cplus.Secao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.IllegalOrphanException;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class SecaoJpaController implements Serializable {

    public SecaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Secao secao) throws PreexistingEntityException, Exception {
        if (secao.getVendedorsecaoCollection() == null) {
            secao.setVendedorsecaoCollection(new ArrayList<Vendedorsecao>());
        }
        if (secao.getProdutoCollection() == null) {
            secao.setProdutoCollection(new ArrayList<Produto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Vendedorsecao> attachedVendedorsecaoCollection = new ArrayList<Vendedorsecao>();
            for (Vendedorsecao vendedorsecaoCollectionVendedorsecaoToAttach : secao.getVendedorsecaoCollection()) {
                vendedorsecaoCollectionVendedorsecaoToAttach = em.getReference(vendedorsecaoCollectionVendedorsecaoToAttach.getClass(), vendedorsecaoCollectionVendedorsecaoToAttach.getCodvendedorsecao());
                attachedVendedorsecaoCollection.add(vendedorsecaoCollectionVendedorsecaoToAttach);
            }
            secao.setVendedorsecaoCollection(attachedVendedorsecaoCollection);
            Collection<Produto> attachedProdutoCollection = new ArrayList<Produto>();
            for (Produto produtoCollectionProdutoToAttach : secao.getProdutoCollection()) {
                produtoCollectionProdutoToAttach = em.getReference(produtoCollectionProdutoToAttach.getClass(), produtoCollectionProdutoToAttach.getCodprod());
                attachedProdutoCollection.add(produtoCollectionProdutoToAttach);
            }
            secao.setProdutoCollection(attachedProdutoCollection);
            em.persist(secao);
            for (Vendedorsecao vendedorsecaoCollectionVendedorsecao : secao.getVendedorsecaoCollection()) {
                Secao oldCodsecOfVendedorsecaoCollectionVendedorsecao = vendedorsecaoCollectionVendedorsecao.getCodsec();
                vendedorsecaoCollectionVendedorsecao.setCodsec(secao);
                vendedorsecaoCollectionVendedorsecao = em.merge(vendedorsecaoCollectionVendedorsecao);
                if (oldCodsecOfVendedorsecaoCollectionVendedorsecao != null) {
                    oldCodsecOfVendedorsecaoCollectionVendedorsecao.getVendedorsecaoCollection().remove(vendedorsecaoCollectionVendedorsecao);
                    oldCodsecOfVendedorsecaoCollectionVendedorsecao = em.merge(oldCodsecOfVendedorsecaoCollectionVendedorsecao);
                }
            }
            for (Produto produtoCollectionProduto : secao.getProdutoCollection()) {
                Secao oldCodsecOfProdutoCollectionProduto = produtoCollectionProduto.getCodsec();
                produtoCollectionProduto.setCodsec(secao);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
                if (oldCodsecOfProdutoCollectionProduto != null) {
                    oldCodsecOfProdutoCollectionProduto.getProdutoCollection().remove(produtoCollectionProduto);
                    oldCodsecOfProdutoCollectionProduto = em.merge(oldCodsecOfProdutoCollectionProduto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findSecao(secao.getCodsec()) != null) {
                throw new PreexistingEntityException("Secao " + secao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Secao secao) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Secao persistentSecao = em.find(Secao.class, secao.getCodsec());
            Collection<Vendedorsecao> vendedorsecaoCollectionOld = persistentSecao.getVendedorsecaoCollection();
            Collection<Vendedorsecao> vendedorsecaoCollectionNew = secao.getVendedorsecaoCollection();
            Collection<Produto> produtoCollectionOld = persistentSecao.getProdutoCollection();
            Collection<Produto> produtoCollectionNew = secao.getProdutoCollection();
            List<String> illegalOrphanMessages = null;
            for (Vendedorsecao vendedorsecaoCollectionOldVendedorsecao : vendedorsecaoCollectionOld) {
                if (!vendedorsecaoCollectionNew.contains(vendedorsecaoCollectionOldVendedorsecao)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Vendedorsecao " + vendedorsecaoCollectionOldVendedorsecao + " since its codsec field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Vendedorsecao> attachedVendedorsecaoCollectionNew = new ArrayList<Vendedorsecao>();
            for (Vendedorsecao vendedorsecaoCollectionNewVendedorsecaoToAttach : vendedorsecaoCollectionNew) {
                vendedorsecaoCollectionNewVendedorsecaoToAttach = em.getReference(vendedorsecaoCollectionNewVendedorsecaoToAttach.getClass(), vendedorsecaoCollectionNewVendedorsecaoToAttach.getCodvendedorsecao());
                attachedVendedorsecaoCollectionNew.add(vendedorsecaoCollectionNewVendedorsecaoToAttach);
            }
            vendedorsecaoCollectionNew = attachedVendedorsecaoCollectionNew;
            secao.setVendedorsecaoCollection(vendedorsecaoCollectionNew);
            Collection<Produto> attachedProdutoCollectionNew = new ArrayList<Produto>();
            for (Produto produtoCollectionNewProdutoToAttach : produtoCollectionNew) {
                produtoCollectionNewProdutoToAttach = em.getReference(produtoCollectionNewProdutoToAttach.getClass(), produtoCollectionNewProdutoToAttach.getCodprod());
                attachedProdutoCollectionNew.add(produtoCollectionNewProdutoToAttach);
            }
            produtoCollectionNew = attachedProdutoCollectionNew;
            secao.setProdutoCollection(produtoCollectionNew);
            secao = em.merge(secao);
            for (Vendedorsecao vendedorsecaoCollectionNewVendedorsecao : vendedorsecaoCollectionNew) {
                if (!vendedorsecaoCollectionOld.contains(vendedorsecaoCollectionNewVendedorsecao)) {
                    Secao oldCodsecOfVendedorsecaoCollectionNewVendedorsecao = vendedorsecaoCollectionNewVendedorsecao.getCodsec();
                    vendedorsecaoCollectionNewVendedorsecao.setCodsec(secao);
                    vendedorsecaoCollectionNewVendedorsecao = em.merge(vendedorsecaoCollectionNewVendedorsecao);
                    if (oldCodsecOfVendedorsecaoCollectionNewVendedorsecao != null && !oldCodsecOfVendedorsecaoCollectionNewVendedorsecao.equals(secao)) {
                        oldCodsecOfVendedorsecaoCollectionNewVendedorsecao.getVendedorsecaoCollection().remove(vendedorsecaoCollectionNewVendedorsecao);
                        oldCodsecOfVendedorsecaoCollectionNewVendedorsecao = em.merge(oldCodsecOfVendedorsecaoCollectionNewVendedorsecao);
                    }
                }
            }
            for (Produto produtoCollectionOldProduto : produtoCollectionOld) {
                if (!produtoCollectionNew.contains(produtoCollectionOldProduto)) {
                    produtoCollectionOldProduto.setCodsec(null);
                    produtoCollectionOldProduto = em.merge(produtoCollectionOldProduto);
                }
            }
            for (Produto produtoCollectionNewProduto : produtoCollectionNew) {
                if (!produtoCollectionOld.contains(produtoCollectionNewProduto)) {
                    Secao oldCodsecOfProdutoCollectionNewProduto = produtoCollectionNewProduto.getCodsec();
                    produtoCollectionNewProduto.setCodsec(secao);
                    produtoCollectionNewProduto = em.merge(produtoCollectionNewProduto);
                    if (oldCodsecOfProdutoCollectionNewProduto != null && !oldCodsecOfProdutoCollectionNewProduto.equals(secao)) {
                        oldCodsecOfProdutoCollectionNewProduto.getProdutoCollection().remove(produtoCollectionNewProduto);
                        oldCodsecOfProdutoCollectionNewProduto = em.merge(oldCodsecOfProdutoCollectionNewProduto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = secao.getCodsec();
                if (findSecao(id) == null) {
                    throw new NonexistentEntityException("The secao with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Secao secao;
            try {
                secao = em.getReference(Secao.class, id);
                secao.getCodsec();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The secao with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Vendedorsecao> vendedorsecaoCollectionOrphanCheck = secao.getVendedorsecaoCollection();
            for (Vendedorsecao vendedorsecaoCollectionOrphanCheckVendedorsecao : vendedorsecaoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Secao (" + secao + ") cannot be destroyed since the Vendedorsecao " + vendedorsecaoCollectionOrphanCheckVendedorsecao + " in its vendedorsecaoCollection field has a non-nullable codsec field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Produto> produtoCollection = secao.getProdutoCollection();
            for (Produto produtoCollectionProduto : produtoCollection) {
                produtoCollectionProduto.setCodsec(null);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
            }
            em.remove(secao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Secao> findSecaoEntities() {
        return findSecaoEntities(true, -1, -1);
    }

    public List<Secao> findSecaoEntities(int maxResults, int firstResult) {
        return findSecaoEntities(false, maxResults, firstResult);
    }

    private List<Secao> findSecaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Secao.class));
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

    public Secao findSecao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Secao.class, id);
        } finally {
            em.close();
        }
    }

    public int getSecaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Secao> rt = cq.from(Secao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Gtintributavel;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Unidade;
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
public class GtintributavelJpaController implements Serializable {

    public GtintributavelJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Gtintributavel gtintributavel) throws PreexistingEntityException, Exception {
        if (gtintributavel.getProdutoCollection() == null) {
            gtintributavel.setProdutoCollection(new ArrayList<Produto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Unidade codunidade = gtintributavel.getCodunidade();
            if (codunidade != null) {
                codunidade = em.getReference(codunidade.getClass(), codunidade.getCodunidade());
                gtintributavel.setCodunidade(codunidade);
            }
            Collection<Produto> attachedProdutoCollection = new ArrayList<Produto>();
            for (Produto produtoCollectionProdutoToAttach : gtintributavel.getProdutoCollection()) {
                produtoCollectionProdutoToAttach = em.getReference(produtoCollectionProdutoToAttach.getClass(), produtoCollectionProdutoToAttach.getCodprod());
                attachedProdutoCollection.add(produtoCollectionProdutoToAttach);
            }
            gtintributavel.setProdutoCollection(attachedProdutoCollection);
            em.persist(gtintributavel);
            if (codunidade != null) {
                codunidade.getGtintributavelCollection().add(gtintributavel);
                codunidade = em.merge(codunidade);
            }
            for (Produto produtoCollectionProduto : gtintributavel.getProdutoCollection()) {
                Gtintributavel oldCodgtintributavelOfProdutoCollectionProduto = produtoCollectionProduto.getCodgtintributavel();
                produtoCollectionProduto.setCodgtintributavel(gtintributavel);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
                if (oldCodgtintributavelOfProdutoCollectionProduto != null) {
                    oldCodgtintributavelOfProdutoCollectionProduto.getProdutoCollection().remove(produtoCollectionProduto);
                    oldCodgtintributavelOfProdutoCollectionProduto = em.merge(oldCodgtintributavelOfProdutoCollectionProduto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findGtintributavel(gtintributavel.getCodgtintributavel()) != null) {
                throw new PreexistingEntityException("Gtintributavel " + gtintributavel + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Gtintributavel gtintributavel) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Gtintributavel persistentGtintributavel = em.find(Gtintributavel.class, gtintributavel.getCodgtintributavel());
            Unidade codunidadeOld = persistentGtintributavel.getCodunidade();
            Unidade codunidadeNew = gtintributavel.getCodunidade();
            Collection<Produto> produtoCollectionOld = persistentGtintributavel.getProdutoCollection();
            Collection<Produto> produtoCollectionNew = gtintributavel.getProdutoCollection();
            if (codunidadeNew != null) {
                codunidadeNew = em.getReference(codunidadeNew.getClass(), codunidadeNew.getCodunidade());
                gtintributavel.setCodunidade(codunidadeNew);
            }
            Collection<Produto> attachedProdutoCollectionNew = new ArrayList<Produto>();
            for (Produto produtoCollectionNewProdutoToAttach : produtoCollectionNew) {
                produtoCollectionNewProdutoToAttach = em.getReference(produtoCollectionNewProdutoToAttach.getClass(), produtoCollectionNewProdutoToAttach.getCodprod());
                attachedProdutoCollectionNew.add(produtoCollectionNewProdutoToAttach);
            }
            produtoCollectionNew = attachedProdutoCollectionNew;
            gtintributavel.setProdutoCollection(produtoCollectionNew);
            gtintributavel = em.merge(gtintributavel);
            if (codunidadeOld != null && !codunidadeOld.equals(codunidadeNew)) {
                codunidadeOld.getGtintributavelCollection().remove(gtintributavel);
                codunidadeOld = em.merge(codunidadeOld);
            }
            if (codunidadeNew != null && !codunidadeNew.equals(codunidadeOld)) {
                codunidadeNew.getGtintributavelCollection().add(gtintributavel);
                codunidadeNew = em.merge(codunidadeNew);
            }
            for (Produto produtoCollectionOldProduto : produtoCollectionOld) {
                if (!produtoCollectionNew.contains(produtoCollectionOldProduto)) {
                    produtoCollectionOldProduto.setCodgtintributavel(null);
                    produtoCollectionOldProduto = em.merge(produtoCollectionOldProduto);
                }
            }
            for (Produto produtoCollectionNewProduto : produtoCollectionNew) {
                if (!produtoCollectionOld.contains(produtoCollectionNewProduto)) {
                    Gtintributavel oldCodgtintributavelOfProdutoCollectionNewProduto = produtoCollectionNewProduto.getCodgtintributavel();
                    produtoCollectionNewProduto.setCodgtintributavel(gtintributavel);
                    produtoCollectionNewProduto = em.merge(produtoCollectionNewProduto);
                    if (oldCodgtintributavelOfProdutoCollectionNewProduto != null && !oldCodgtintributavelOfProdutoCollectionNewProduto.equals(gtintributavel)) {
                        oldCodgtintributavelOfProdutoCollectionNewProduto.getProdutoCollection().remove(produtoCollectionNewProduto);
                        oldCodgtintributavelOfProdutoCollectionNewProduto = em.merge(oldCodgtintributavelOfProdutoCollectionNewProduto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = gtintributavel.getCodgtintributavel();
                if (findGtintributavel(id) == null) {
                    throw new NonexistentEntityException("The gtintributavel with id " + id + " no longer exists.");
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
            Gtintributavel gtintributavel;
            try {
                gtintributavel = em.getReference(Gtintributavel.class, id);
                gtintributavel.getCodgtintributavel();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The gtintributavel with id " + id + " no longer exists.", enfe);
            }
            Unidade codunidade = gtintributavel.getCodunidade();
            if (codunidade != null) {
                codunidade.getGtintributavelCollection().remove(gtintributavel);
                codunidade = em.merge(codunidade);
            }
            Collection<Produto> produtoCollection = gtintributavel.getProdutoCollection();
            for (Produto produtoCollectionProduto : produtoCollection) {
                produtoCollectionProduto.setCodgtintributavel(null);
                produtoCollectionProduto = em.merge(produtoCollectionProduto);
            }
            em.remove(gtintributavel);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Gtintributavel> findGtintributavelEntities() {
        return findGtintributavelEntities(true, -1, -1);
    }

    public List<Gtintributavel> findGtintributavelEntities(int maxResults, int firstResult) {
        return findGtintributavelEntities(false, maxResults, firstResult);
    }

    private List<Gtintributavel> findGtintributavelEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Gtintributavel.class));
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

    public Gtintributavel findGtintributavel(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Gtintributavel.class, id);
        } finally {
            em.close();
        }
    }

    public int getGtintributavelCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Gtintributavel> rt = cq.from(Gtintributavel.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

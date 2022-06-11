/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Localizacao;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Produtolocalizacao;
import java.util.ArrayList;
import java.util.Collection;
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
public class LocalizacaoJpaController implements Serializable {

    public LocalizacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Localizacao localizacao) throws PreexistingEntityException, Exception {
        if (localizacao.getProdutolocalizacaoCollection() == null) {
            localizacao.setProdutolocalizacaoCollection(new ArrayList<Produtolocalizacao>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Produtolocalizacao> attachedProdutolocalizacaoCollection = new ArrayList<Produtolocalizacao>();
            for (Produtolocalizacao produtolocalizacaoCollectionProdutolocalizacaoToAttach : localizacao.getProdutolocalizacaoCollection()) {
                produtolocalizacaoCollectionProdutolocalizacaoToAttach = em.getReference(produtolocalizacaoCollectionProdutolocalizacaoToAttach.getClass(), produtolocalizacaoCollectionProdutolocalizacaoToAttach.getCodprodutolocalizacao());
                attachedProdutolocalizacaoCollection.add(produtolocalizacaoCollectionProdutolocalizacaoToAttach);
            }
            localizacao.setProdutolocalizacaoCollection(attachedProdutolocalizacaoCollection);
            em.persist(localizacao);
            for (Produtolocalizacao produtolocalizacaoCollectionProdutolocalizacao : localizacao.getProdutolocalizacaoCollection()) {
                Localizacao oldCodlocOfProdutolocalizacaoCollectionProdutolocalizacao = produtolocalizacaoCollectionProdutolocalizacao.getCodloc();
                produtolocalizacaoCollectionProdutolocalizacao.setCodloc(localizacao);
                produtolocalizacaoCollectionProdutolocalizacao = em.merge(produtolocalizacaoCollectionProdutolocalizacao);
                if (oldCodlocOfProdutolocalizacaoCollectionProdutolocalizacao != null) {
                    oldCodlocOfProdutolocalizacaoCollectionProdutolocalizacao.getProdutolocalizacaoCollection().remove(produtolocalizacaoCollectionProdutolocalizacao);
                    oldCodlocOfProdutolocalizacaoCollectionProdutolocalizacao = em.merge(oldCodlocOfProdutolocalizacaoCollectionProdutolocalizacao);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLocalizacao(localizacao.getCodloc()) != null) {
                throw new PreexistingEntityException("Localizacao " + localizacao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Localizacao localizacao) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Localizacao persistentLocalizacao = em.find(Localizacao.class, localizacao.getCodloc());
            Collection<Produtolocalizacao> produtolocalizacaoCollectionOld = persistentLocalizacao.getProdutolocalizacaoCollection();
            Collection<Produtolocalizacao> produtolocalizacaoCollectionNew = localizacao.getProdutolocalizacaoCollection();
            List<String> illegalOrphanMessages = null;
            for (Produtolocalizacao produtolocalizacaoCollectionOldProdutolocalizacao : produtolocalizacaoCollectionOld) {
                if (!produtolocalizacaoCollectionNew.contains(produtolocalizacaoCollectionOldProdutolocalizacao)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Produtolocalizacao " + produtolocalizacaoCollectionOldProdutolocalizacao + " since its codloc field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Produtolocalizacao> attachedProdutolocalizacaoCollectionNew = new ArrayList<Produtolocalizacao>();
            for (Produtolocalizacao produtolocalizacaoCollectionNewProdutolocalizacaoToAttach : produtolocalizacaoCollectionNew) {
                produtolocalizacaoCollectionNewProdutolocalizacaoToAttach = em.getReference(produtolocalizacaoCollectionNewProdutolocalizacaoToAttach.getClass(), produtolocalizacaoCollectionNewProdutolocalizacaoToAttach.getCodprodutolocalizacao());
                attachedProdutolocalizacaoCollectionNew.add(produtolocalizacaoCollectionNewProdutolocalizacaoToAttach);
            }
            produtolocalizacaoCollectionNew = attachedProdutolocalizacaoCollectionNew;
            localizacao.setProdutolocalizacaoCollection(produtolocalizacaoCollectionNew);
            localizacao = em.merge(localizacao);
            for (Produtolocalizacao produtolocalizacaoCollectionNewProdutolocalizacao : produtolocalizacaoCollectionNew) {
                if (!produtolocalizacaoCollectionOld.contains(produtolocalizacaoCollectionNewProdutolocalizacao)) {
                    Localizacao oldCodlocOfProdutolocalizacaoCollectionNewProdutolocalizacao = produtolocalizacaoCollectionNewProdutolocalizacao.getCodloc();
                    produtolocalizacaoCollectionNewProdutolocalizacao.setCodloc(localizacao);
                    produtolocalizacaoCollectionNewProdutolocalizacao = em.merge(produtolocalizacaoCollectionNewProdutolocalizacao);
                    if (oldCodlocOfProdutolocalizacaoCollectionNewProdutolocalizacao != null && !oldCodlocOfProdutolocalizacaoCollectionNewProdutolocalizacao.equals(localizacao)) {
                        oldCodlocOfProdutolocalizacaoCollectionNewProdutolocalizacao.getProdutolocalizacaoCollection().remove(produtolocalizacaoCollectionNewProdutolocalizacao);
                        oldCodlocOfProdutolocalizacaoCollectionNewProdutolocalizacao = em.merge(oldCodlocOfProdutolocalizacaoCollectionNewProdutolocalizacao);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = localizacao.getCodloc();
                if (findLocalizacao(id) == null) {
                    throw new NonexistentEntityException("The localizacao with id " + id + " no longer exists.");
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
            Localizacao localizacao;
            try {
                localizacao = em.getReference(Localizacao.class, id);
                localizacao.getCodloc();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The localizacao with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Produtolocalizacao> produtolocalizacaoCollectionOrphanCheck = localizacao.getProdutolocalizacaoCollection();
            for (Produtolocalizacao produtolocalizacaoCollectionOrphanCheckProdutolocalizacao : produtolocalizacaoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Localizacao (" + localizacao + ") cannot be destroyed since the Produtolocalizacao " + produtolocalizacaoCollectionOrphanCheckProdutolocalizacao + " in its produtolocalizacaoCollection field has a non-nullable codloc field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(localizacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Localizacao> findLocalizacaoEntities() {
        return findLocalizacaoEntities(true, -1, -1);
    }

    public List<Localizacao> findLocalizacaoEntities(int maxResults, int firstResult) {
        return findLocalizacaoEntities(false, maxResults, firstResult);
    }

    private List<Localizacao> findLocalizacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Localizacao.class));
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

    public Localizacao findLocalizacao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Localizacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getLocalizacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Localizacao> rt = cq.from(Localizacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Cartacorrecao;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Cartacorrecaoretificacao;
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
public class CartacorrecaoJpaController implements Serializable {

    public CartacorrecaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cartacorrecao cartacorrecao) throws PreexistingEntityException, Exception {
        if (cartacorrecao.getCartacorrecaoretificacaoCollection() == null) {
            cartacorrecao.setCartacorrecaoretificacaoCollection(new ArrayList<Cartacorrecaoretificacao>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Cartacorrecaoretificacao> attachedCartacorrecaoretificacaoCollection = new ArrayList<Cartacorrecaoretificacao>();
            for (Cartacorrecaoretificacao cartacorrecaoretificacaoCollectionCartacorrecaoretificacaoToAttach : cartacorrecao.getCartacorrecaoretificacaoCollection()) {
                cartacorrecaoretificacaoCollectionCartacorrecaoretificacaoToAttach = em.getReference(cartacorrecaoretificacaoCollectionCartacorrecaoretificacaoToAttach.getClass(), cartacorrecaoretificacaoCollectionCartacorrecaoretificacaoToAttach.getCartacorrecaoretificacaoPK());
                attachedCartacorrecaoretificacaoCollection.add(cartacorrecaoretificacaoCollectionCartacorrecaoretificacaoToAttach);
            }
            cartacorrecao.setCartacorrecaoretificacaoCollection(attachedCartacorrecaoretificacaoCollection);
            em.persist(cartacorrecao);
            for (Cartacorrecaoretificacao cartacorrecaoretificacaoCollectionCartacorrecaoretificacao : cartacorrecao.getCartacorrecaoretificacaoCollection()) {
                Cartacorrecao oldCartacorrecaoOfCartacorrecaoretificacaoCollectionCartacorrecaoretificacao = cartacorrecaoretificacaoCollectionCartacorrecaoretificacao.getCartacorrecao();
                cartacorrecaoretificacaoCollectionCartacorrecaoretificacao.setCartacorrecao(cartacorrecao);
                cartacorrecaoretificacaoCollectionCartacorrecaoretificacao = em.merge(cartacorrecaoretificacaoCollectionCartacorrecaoretificacao);
                if (oldCartacorrecaoOfCartacorrecaoretificacaoCollectionCartacorrecaoretificacao != null) {
                    oldCartacorrecaoOfCartacorrecaoretificacaoCollectionCartacorrecaoretificacao.getCartacorrecaoretificacaoCollection().remove(cartacorrecaoretificacaoCollectionCartacorrecaoretificacao);
                    oldCartacorrecaoOfCartacorrecaoretificacaoCollectionCartacorrecaoretificacao = em.merge(oldCartacorrecaoOfCartacorrecaoretificacaoCollectionCartacorrecaoretificacao);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCartacorrecao(cartacorrecao.getCodcartacorrecao()) != null) {
                throw new PreexistingEntityException("Cartacorrecao " + cartacorrecao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cartacorrecao cartacorrecao) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cartacorrecao persistentCartacorrecao = em.find(Cartacorrecao.class, cartacorrecao.getCodcartacorrecao());
            Collection<Cartacorrecaoretificacao> cartacorrecaoretificacaoCollectionOld = persistentCartacorrecao.getCartacorrecaoretificacaoCollection();
            Collection<Cartacorrecaoretificacao> cartacorrecaoretificacaoCollectionNew = cartacorrecao.getCartacorrecaoretificacaoCollection();
            List<String> illegalOrphanMessages = null;
            for (Cartacorrecaoretificacao cartacorrecaoretificacaoCollectionOldCartacorrecaoretificacao : cartacorrecaoretificacaoCollectionOld) {
                if (!cartacorrecaoretificacaoCollectionNew.contains(cartacorrecaoretificacaoCollectionOldCartacorrecaoretificacao)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cartacorrecaoretificacao " + cartacorrecaoretificacaoCollectionOldCartacorrecaoretificacao + " since its cartacorrecao field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Cartacorrecaoretificacao> attachedCartacorrecaoretificacaoCollectionNew = new ArrayList<Cartacorrecaoretificacao>();
            for (Cartacorrecaoretificacao cartacorrecaoretificacaoCollectionNewCartacorrecaoretificacaoToAttach : cartacorrecaoretificacaoCollectionNew) {
                cartacorrecaoretificacaoCollectionNewCartacorrecaoretificacaoToAttach = em.getReference(cartacorrecaoretificacaoCollectionNewCartacorrecaoretificacaoToAttach.getClass(), cartacorrecaoretificacaoCollectionNewCartacorrecaoretificacaoToAttach.getCartacorrecaoretificacaoPK());
                attachedCartacorrecaoretificacaoCollectionNew.add(cartacorrecaoretificacaoCollectionNewCartacorrecaoretificacaoToAttach);
            }
            cartacorrecaoretificacaoCollectionNew = attachedCartacorrecaoretificacaoCollectionNew;
            cartacorrecao.setCartacorrecaoretificacaoCollection(cartacorrecaoretificacaoCollectionNew);
            cartacorrecao = em.merge(cartacorrecao);
            for (Cartacorrecaoretificacao cartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao : cartacorrecaoretificacaoCollectionNew) {
                if (!cartacorrecaoretificacaoCollectionOld.contains(cartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao)) {
                    Cartacorrecao oldCartacorrecaoOfCartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao = cartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao.getCartacorrecao();
                    cartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao.setCartacorrecao(cartacorrecao);
                    cartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao = em.merge(cartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao);
                    if (oldCartacorrecaoOfCartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao != null && !oldCartacorrecaoOfCartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao.equals(cartacorrecao)) {
                        oldCartacorrecaoOfCartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao.getCartacorrecaoretificacaoCollection().remove(cartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao);
                        oldCartacorrecaoOfCartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao = em.merge(oldCartacorrecaoOfCartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cartacorrecao.getCodcartacorrecao();
                if (findCartacorrecao(id) == null) {
                    throw new NonexistentEntityException("The cartacorrecao with id " + id + " no longer exists.");
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
            Cartacorrecao cartacorrecao;
            try {
                cartacorrecao = em.getReference(Cartacorrecao.class, id);
                cartacorrecao.getCodcartacorrecao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cartacorrecao with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Cartacorrecaoretificacao> cartacorrecaoretificacaoCollectionOrphanCheck = cartacorrecao.getCartacorrecaoretificacaoCollection();
            for (Cartacorrecaoretificacao cartacorrecaoretificacaoCollectionOrphanCheckCartacorrecaoretificacao : cartacorrecaoretificacaoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cartacorrecao (" + cartacorrecao + ") cannot be destroyed since the Cartacorrecaoretificacao " + cartacorrecaoretificacaoCollectionOrphanCheckCartacorrecaoretificacao + " in its cartacorrecaoretificacaoCollection field has a non-nullable cartacorrecao field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(cartacorrecao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cartacorrecao> findCartacorrecaoEntities() {
        return findCartacorrecaoEntities(true, -1, -1);
    }

    public List<Cartacorrecao> findCartacorrecaoEntities(int maxResults, int firstResult) {
        return findCartacorrecaoEntities(false, maxResults, firstResult);
    }

    private List<Cartacorrecao> findCartacorrecaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cartacorrecao.class));
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

    public Cartacorrecao findCartacorrecao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cartacorrecao.class, id);
        } finally {
            em.close();
        }
    }

    public int getCartacorrecaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cartacorrecao> rt = cq.from(Cartacorrecao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

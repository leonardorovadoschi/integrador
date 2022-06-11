/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Cartacorrecaoespecificacao;
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
public class CartacorrecaoespecificacaoJpaController implements Serializable {

    public CartacorrecaoespecificacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cartacorrecaoespecificacao cartacorrecaoespecificacao) throws PreexistingEntityException, Exception {
        if (cartacorrecaoespecificacao.getCartacorrecaoretificacaoCollection() == null) {
            cartacorrecaoespecificacao.setCartacorrecaoretificacaoCollection(new ArrayList<Cartacorrecaoretificacao>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Cartacorrecaoretificacao> attachedCartacorrecaoretificacaoCollection = new ArrayList<Cartacorrecaoretificacao>();
            for (Cartacorrecaoretificacao cartacorrecaoretificacaoCollectionCartacorrecaoretificacaoToAttach : cartacorrecaoespecificacao.getCartacorrecaoretificacaoCollection()) {
                cartacorrecaoretificacaoCollectionCartacorrecaoretificacaoToAttach = em.getReference(cartacorrecaoretificacaoCollectionCartacorrecaoretificacaoToAttach.getClass(), cartacorrecaoretificacaoCollectionCartacorrecaoretificacaoToAttach.getCartacorrecaoretificacaoPK());
                attachedCartacorrecaoretificacaoCollection.add(cartacorrecaoretificacaoCollectionCartacorrecaoretificacaoToAttach);
            }
            cartacorrecaoespecificacao.setCartacorrecaoretificacaoCollection(attachedCartacorrecaoretificacaoCollection);
            em.persist(cartacorrecaoespecificacao);
            for (Cartacorrecaoretificacao cartacorrecaoretificacaoCollectionCartacorrecaoretificacao : cartacorrecaoespecificacao.getCartacorrecaoretificacaoCollection()) {
                Cartacorrecaoespecificacao oldCartacorrecaoespecificacaoOfCartacorrecaoretificacaoCollectionCartacorrecaoretificacao = cartacorrecaoretificacaoCollectionCartacorrecaoretificacao.getCartacorrecaoespecificacao();
                cartacorrecaoretificacaoCollectionCartacorrecaoretificacao.setCartacorrecaoespecificacao(cartacorrecaoespecificacao);
                cartacorrecaoretificacaoCollectionCartacorrecaoretificacao = em.merge(cartacorrecaoretificacaoCollectionCartacorrecaoretificacao);
                if (oldCartacorrecaoespecificacaoOfCartacorrecaoretificacaoCollectionCartacorrecaoretificacao != null) {
                    oldCartacorrecaoespecificacaoOfCartacorrecaoretificacaoCollectionCartacorrecaoretificacao.getCartacorrecaoretificacaoCollection().remove(cartacorrecaoretificacaoCollectionCartacorrecaoretificacao);
                    oldCartacorrecaoespecificacaoOfCartacorrecaoretificacaoCollectionCartacorrecaoretificacao = em.merge(oldCartacorrecaoespecificacaoOfCartacorrecaoretificacaoCollectionCartacorrecaoretificacao);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCartacorrecaoespecificacao(cartacorrecaoespecificacao.getCodcartacorrecaoespecificacao()) != null) {
                throw new PreexistingEntityException("Cartacorrecaoespecificacao " + cartacorrecaoespecificacao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cartacorrecaoespecificacao cartacorrecaoespecificacao) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cartacorrecaoespecificacao persistentCartacorrecaoespecificacao = em.find(Cartacorrecaoespecificacao.class, cartacorrecaoespecificacao.getCodcartacorrecaoespecificacao());
            Collection<Cartacorrecaoretificacao> cartacorrecaoretificacaoCollectionOld = persistentCartacorrecaoespecificacao.getCartacorrecaoretificacaoCollection();
            Collection<Cartacorrecaoretificacao> cartacorrecaoretificacaoCollectionNew = cartacorrecaoespecificacao.getCartacorrecaoretificacaoCollection();
            List<String> illegalOrphanMessages = null;
            for (Cartacorrecaoretificacao cartacorrecaoretificacaoCollectionOldCartacorrecaoretificacao : cartacorrecaoretificacaoCollectionOld) {
                if (!cartacorrecaoretificacaoCollectionNew.contains(cartacorrecaoretificacaoCollectionOldCartacorrecaoretificacao)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cartacorrecaoretificacao " + cartacorrecaoretificacaoCollectionOldCartacorrecaoretificacao + " since its cartacorrecaoespecificacao field is not nullable.");
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
            cartacorrecaoespecificacao.setCartacorrecaoretificacaoCollection(cartacorrecaoretificacaoCollectionNew);
            cartacorrecaoespecificacao = em.merge(cartacorrecaoespecificacao);
            for (Cartacorrecaoretificacao cartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao : cartacorrecaoretificacaoCollectionNew) {
                if (!cartacorrecaoretificacaoCollectionOld.contains(cartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao)) {
                    Cartacorrecaoespecificacao oldCartacorrecaoespecificacaoOfCartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao = cartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao.getCartacorrecaoespecificacao();
                    cartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao.setCartacorrecaoespecificacao(cartacorrecaoespecificacao);
                    cartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao = em.merge(cartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao);
                    if (oldCartacorrecaoespecificacaoOfCartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao != null && !oldCartacorrecaoespecificacaoOfCartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao.equals(cartacorrecaoespecificacao)) {
                        oldCartacorrecaoespecificacaoOfCartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao.getCartacorrecaoretificacaoCollection().remove(cartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao);
                        oldCartacorrecaoespecificacaoOfCartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao = em.merge(oldCartacorrecaoespecificacaoOfCartacorrecaoretificacaoCollectionNewCartacorrecaoretificacao);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cartacorrecaoespecificacao.getCodcartacorrecaoespecificacao();
                if (findCartacorrecaoespecificacao(id) == null) {
                    throw new NonexistentEntityException("The cartacorrecaoespecificacao with id " + id + " no longer exists.");
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
            Cartacorrecaoespecificacao cartacorrecaoespecificacao;
            try {
                cartacorrecaoespecificacao = em.getReference(Cartacorrecaoespecificacao.class, id);
                cartacorrecaoespecificacao.getCodcartacorrecaoespecificacao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cartacorrecaoespecificacao with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Cartacorrecaoretificacao> cartacorrecaoretificacaoCollectionOrphanCheck = cartacorrecaoespecificacao.getCartacorrecaoretificacaoCollection();
            for (Cartacorrecaoretificacao cartacorrecaoretificacaoCollectionOrphanCheckCartacorrecaoretificacao : cartacorrecaoretificacaoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cartacorrecaoespecificacao (" + cartacorrecaoespecificacao + ") cannot be destroyed since the Cartacorrecaoretificacao " + cartacorrecaoretificacaoCollectionOrphanCheckCartacorrecaoretificacao + " in its cartacorrecaoretificacaoCollection field has a non-nullable cartacorrecaoespecificacao field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(cartacorrecaoespecificacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cartacorrecaoespecificacao> findCartacorrecaoespecificacaoEntities() {
        return findCartacorrecaoespecificacaoEntities(true, -1, -1);
    }

    public List<Cartacorrecaoespecificacao> findCartacorrecaoespecificacaoEntities(int maxResults, int firstResult) {
        return findCartacorrecaoespecificacaoEntities(false, maxResults, firstResult);
    }

    private List<Cartacorrecaoespecificacao> findCartacorrecaoespecificacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cartacorrecaoespecificacao.class));
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

    public Cartacorrecaoespecificacao findCartacorrecaoespecificacao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cartacorrecaoespecificacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getCartacorrecaoespecificacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cartacorrecaoespecificacao> rt = cq.from(Cartacorrecaoespecificacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

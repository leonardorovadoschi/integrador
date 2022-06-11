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
import entidade.cplus.Cartacorrecao;
import entidade.cplus.Cartacorrecaoespecificacao;
import entidade.cplus.Cartacorrecaoretificacao;
import entidade.cplus.CartacorrecaoretificacaoPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class CartacorrecaoretificacaoJpaController implements Serializable {

    public CartacorrecaoretificacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cartacorrecaoretificacao cartacorrecaoretificacao) throws PreexistingEntityException, Exception {
        if (cartacorrecaoretificacao.getCartacorrecaoretificacaoPK() == null) {
            cartacorrecaoretificacao.setCartacorrecaoretificacaoPK(new CartacorrecaoretificacaoPK());
        }
        cartacorrecaoretificacao.getCartacorrecaoretificacaoPK().setCodcartacorrecaoespecificacao(cartacorrecaoretificacao.getCartacorrecaoespecificacao().getCodcartacorrecaoespecificacao());
        cartacorrecaoretificacao.getCartacorrecaoretificacaoPK().setCodcartacorrecao(cartacorrecaoretificacao.getCartacorrecao().getCodcartacorrecao());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cartacorrecao cartacorrecao = cartacorrecaoretificacao.getCartacorrecao();
            if (cartacorrecao != null) {
                cartacorrecao = em.getReference(cartacorrecao.getClass(), cartacorrecao.getCodcartacorrecao());
                cartacorrecaoretificacao.setCartacorrecao(cartacorrecao);
            }
            Cartacorrecaoespecificacao cartacorrecaoespecificacao = cartacorrecaoretificacao.getCartacorrecaoespecificacao();
            if (cartacorrecaoespecificacao != null) {
                cartacorrecaoespecificacao = em.getReference(cartacorrecaoespecificacao.getClass(), cartacorrecaoespecificacao.getCodcartacorrecaoespecificacao());
                cartacorrecaoretificacao.setCartacorrecaoespecificacao(cartacorrecaoespecificacao);
            }
            em.persist(cartacorrecaoretificacao);
            if (cartacorrecao != null) {
                cartacorrecao.getCartacorrecaoretificacaoCollection().add(cartacorrecaoretificacao);
                cartacorrecao = em.merge(cartacorrecao);
            }
            if (cartacorrecaoespecificacao != null) {
                cartacorrecaoespecificacao.getCartacorrecaoretificacaoCollection().add(cartacorrecaoretificacao);
                cartacorrecaoespecificacao = em.merge(cartacorrecaoespecificacao);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCartacorrecaoretificacao(cartacorrecaoretificacao.getCartacorrecaoretificacaoPK()) != null) {
                throw new PreexistingEntityException("Cartacorrecaoretificacao " + cartacorrecaoretificacao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cartacorrecaoretificacao cartacorrecaoretificacao) throws NonexistentEntityException, Exception {
        cartacorrecaoretificacao.getCartacorrecaoretificacaoPK().setCodcartacorrecaoespecificacao(cartacorrecaoretificacao.getCartacorrecaoespecificacao().getCodcartacorrecaoespecificacao());
        cartacorrecaoretificacao.getCartacorrecaoretificacaoPK().setCodcartacorrecao(cartacorrecaoretificacao.getCartacorrecao().getCodcartacorrecao());
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cartacorrecaoretificacao persistentCartacorrecaoretificacao = em.find(Cartacorrecaoretificacao.class, cartacorrecaoretificacao.getCartacorrecaoretificacaoPK());
            Cartacorrecao cartacorrecaoOld = persistentCartacorrecaoretificacao.getCartacorrecao();
            Cartacorrecao cartacorrecaoNew = cartacorrecaoretificacao.getCartacorrecao();
            Cartacorrecaoespecificacao cartacorrecaoespecificacaoOld = persistentCartacorrecaoretificacao.getCartacorrecaoespecificacao();
            Cartacorrecaoespecificacao cartacorrecaoespecificacaoNew = cartacorrecaoretificacao.getCartacorrecaoespecificacao();
            if (cartacorrecaoNew != null) {
                cartacorrecaoNew = em.getReference(cartacorrecaoNew.getClass(), cartacorrecaoNew.getCodcartacorrecao());
                cartacorrecaoretificacao.setCartacorrecao(cartacorrecaoNew);
            }
            if (cartacorrecaoespecificacaoNew != null) {
                cartacorrecaoespecificacaoNew = em.getReference(cartacorrecaoespecificacaoNew.getClass(), cartacorrecaoespecificacaoNew.getCodcartacorrecaoespecificacao());
                cartacorrecaoretificacao.setCartacorrecaoespecificacao(cartacorrecaoespecificacaoNew);
            }
            cartacorrecaoretificacao = em.merge(cartacorrecaoretificacao);
            if (cartacorrecaoOld != null && !cartacorrecaoOld.equals(cartacorrecaoNew)) {
                cartacorrecaoOld.getCartacorrecaoretificacaoCollection().remove(cartacorrecaoretificacao);
                cartacorrecaoOld = em.merge(cartacorrecaoOld);
            }
            if (cartacorrecaoNew != null && !cartacorrecaoNew.equals(cartacorrecaoOld)) {
                cartacorrecaoNew.getCartacorrecaoretificacaoCollection().add(cartacorrecaoretificacao);
                cartacorrecaoNew = em.merge(cartacorrecaoNew);
            }
            if (cartacorrecaoespecificacaoOld != null && !cartacorrecaoespecificacaoOld.equals(cartacorrecaoespecificacaoNew)) {
                cartacorrecaoespecificacaoOld.getCartacorrecaoretificacaoCollection().remove(cartacorrecaoretificacao);
                cartacorrecaoespecificacaoOld = em.merge(cartacorrecaoespecificacaoOld);
            }
            if (cartacorrecaoespecificacaoNew != null && !cartacorrecaoespecificacaoNew.equals(cartacorrecaoespecificacaoOld)) {
                cartacorrecaoespecificacaoNew.getCartacorrecaoretificacaoCollection().add(cartacorrecaoretificacao);
                cartacorrecaoespecificacaoNew = em.merge(cartacorrecaoespecificacaoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                CartacorrecaoretificacaoPK id = cartacorrecaoretificacao.getCartacorrecaoretificacaoPK();
                if (findCartacorrecaoretificacao(id) == null) {
                    throw new NonexistentEntityException("The cartacorrecaoretificacao with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(CartacorrecaoretificacaoPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cartacorrecaoretificacao cartacorrecaoretificacao;
            try {
                cartacorrecaoretificacao = em.getReference(Cartacorrecaoretificacao.class, id);
                cartacorrecaoretificacao.getCartacorrecaoretificacaoPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cartacorrecaoretificacao with id " + id + " no longer exists.", enfe);
            }
            Cartacorrecao cartacorrecao = cartacorrecaoretificacao.getCartacorrecao();
            if (cartacorrecao != null) {
                cartacorrecao.getCartacorrecaoretificacaoCollection().remove(cartacorrecaoretificacao);
                cartacorrecao = em.merge(cartacorrecao);
            }
            Cartacorrecaoespecificacao cartacorrecaoespecificacao = cartacorrecaoretificacao.getCartacorrecaoespecificacao();
            if (cartacorrecaoespecificacao != null) {
                cartacorrecaoespecificacao.getCartacorrecaoretificacaoCollection().remove(cartacorrecaoretificacao);
                cartacorrecaoespecificacao = em.merge(cartacorrecaoespecificacao);
            }
            em.remove(cartacorrecaoretificacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cartacorrecaoretificacao> findCartacorrecaoretificacaoEntities() {
        return findCartacorrecaoretificacaoEntities(true, -1, -1);
    }

    public List<Cartacorrecaoretificacao> findCartacorrecaoretificacaoEntities(int maxResults, int firstResult) {
        return findCartacorrecaoretificacaoEntities(false, maxResults, firstResult);
    }

    private List<Cartacorrecaoretificacao> findCartacorrecaoretificacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cartacorrecaoretificacao.class));
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

    public Cartacorrecaoretificacao findCartacorrecaoretificacao(CartacorrecaoretificacaoPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cartacorrecaoretificacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getCartacorrecaoretificacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cartacorrecaoretificacao> rt = cq.from(Cartacorrecaoretificacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

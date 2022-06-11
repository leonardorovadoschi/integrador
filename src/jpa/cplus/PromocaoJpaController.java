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
import entidade.cplus.Formapag;
import entidade.cplus.Promocao;
import entidade.cplus.Promocaoproduto;
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
public class PromocaoJpaController implements Serializable {

    public PromocaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Promocao promocao) throws PreexistingEntityException, Exception {
        if (promocao.getPromocaoprodutoCollection() == null) {
            promocao.setPromocaoprodutoCollection(new ArrayList<Promocaoproduto>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Formapag codfp = promocao.getCodfp();
            if (codfp != null) {
                codfp = em.getReference(codfp.getClass(), codfp.getCodfp());
                promocao.setCodfp(codfp);
            }
            Collection<Promocaoproduto> attachedPromocaoprodutoCollection = new ArrayList<Promocaoproduto>();
            for (Promocaoproduto promocaoprodutoCollectionPromocaoprodutoToAttach : promocao.getPromocaoprodutoCollection()) {
                promocaoprodutoCollectionPromocaoprodutoToAttach = em.getReference(promocaoprodutoCollectionPromocaoprodutoToAttach.getClass(), promocaoprodutoCollectionPromocaoprodutoToAttach.getCodpromocaoproduto());
                attachedPromocaoprodutoCollection.add(promocaoprodutoCollectionPromocaoprodutoToAttach);
            }
            promocao.setPromocaoprodutoCollection(attachedPromocaoprodutoCollection);
            em.persist(promocao);
            if (codfp != null) {
                codfp.getPromocaoCollection().add(promocao);
                codfp = em.merge(codfp);
            }
            for (Promocaoproduto promocaoprodutoCollectionPromocaoproduto : promocao.getPromocaoprodutoCollection()) {
                Promocao oldCodpromocaoOfPromocaoprodutoCollectionPromocaoproduto = promocaoprodutoCollectionPromocaoproduto.getCodpromocao();
                promocaoprodutoCollectionPromocaoproduto.setCodpromocao(promocao);
                promocaoprodutoCollectionPromocaoproduto = em.merge(promocaoprodutoCollectionPromocaoproduto);
                if (oldCodpromocaoOfPromocaoprodutoCollectionPromocaoproduto != null) {
                    oldCodpromocaoOfPromocaoprodutoCollectionPromocaoproduto.getPromocaoprodutoCollection().remove(promocaoprodutoCollectionPromocaoproduto);
                    oldCodpromocaoOfPromocaoprodutoCollectionPromocaoproduto = em.merge(oldCodpromocaoOfPromocaoprodutoCollectionPromocaoproduto);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPromocao(promocao.getCodpromocao()) != null) {
                throw new PreexistingEntityException("Promocao " + promocao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Promocao promocao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Promocao persistentPromocao = em.find(Promocao.class, promocao.getCodpromocao());
            Formapag codfpOld = persistentPromocao.getCodfp();
            Formapag codfpNew = promocao.getCodfp();
            Collection<Promocaoproduto> promocaoprodutoCollectionOld = persistentPromocao.getPromocaoprodutoCollection();
            Collection<Promocaoproduto> promocaoprodutoCollectionNew = promocao.getPromocaoprodutoCollection();
            if (codfpNew != null) {
                codfpNew = em.getReference(codfpNew.getClass(), codfpNew.getCodfp());
                promocao.setCodfp(codfpNew);
            }
            Collection<Promocaoproduto> attachedPromocaoprodutoCollectionNew = new ArrayList<Promocaoproduto>();
            for (Promocaoproduto promocaoprodutoCollectionNewPromocaoprodutoToAttach : promocaoprodutoCollectionNew) {
                promocaoprodutoCollectionNewPromocaoprodutoToAttach = em.getReference(promocaoprodutoCollectionNewPromocaoprodutoToAttach.getClass(), promocaoprodutoCollectionNewPromocaoprodutoToAttach.getCodpromocaoproduto());
                attachedPromocaoprodutoCollectionNew.add(promocaoprodutoCollectionNewPromocaoprodutoToAttach);
            }
            promocaoprodutoCollectionNew = attachedPromocaoprodutoCollectionNew;
            promocao.setPromocaoprodutoCollection(promocaoprodutoCollectionNew);
            promocao = em.merge(promocao);
            if (codfpOld != null && !codfpOld.equals(codfpNew)) {
                codfpOld.getPromocaoCollection().remove(promocao);
                codfpOld = em.merge(codfpOld);
            }
            if (codfpNew != null && !codfpNew.equals(codfpOld)) {
                codfpNew.getPromocaoCollection().add(promocao);
                codfpNew = em.merge(codfpNew);
            }
            for (Promocaoproduto promocaoprodutoCollectionOldPromocaoproduto : promocaoprodutoCollectionOld) {
                if (!promocaoprodutoCollectionNew.contains(promocaoprodutoCollectionOldPromocaoproduto)) {
                    promocaoprodutoCollectionOldPromocaoproduto.setCodpromocao(null);
                    promocaoprodutoCollectionOldPromocaoproduto = em.merge(promocaoprodutoCollectionOldPromocaoproduto);
                }
            }
            for (Promocaoproduto promocaoprodutoCollectionNewPromocaoproduto : promocaoprodutoCollectionNew) {
                if (!promocaoprodutoCollectionOld.contains(promocaoprodutoCollectionNewPromocaoproduto)) {
                    Promocao oldCodpromocaoOfPromocaoprodutoCollectionNewPromocaoproduto = promocaoprodutoCollectionNewPromocaoproduto.getCodpromocao();
                    promocaoprodutoCollectionNewPromocaoproduto.setCodpromocao(promocao);
                    promocaoprodutoCollectionNewPromocaoproduto = em.merge(promocaoprodutoCollectionNewPromocaoproduto);
                    if (oldCodpromocaoOfPromocaoprodutoCollectionNewPromocaoproduto != null && !oldCodpromocaoOfPromocaoprodutoCollectionNewPromocaoproduto.equals(promocao)) {
                        oldCodpromocaoOfPromocaoprodutoCollectionNewPromocaoproduto.getPromocaoprodutoCollection().remove(promocaoprodutoCollectionNewPromocaoproduto);
                        oldCodpromocaoOfPromocaoprodutoCollectionNewPromocaoproduto = em.merge(oldCodpromocaoOfPromocaoprodutoCollectionNewPromocaoproduto);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = promocao.getCodpromocao();
                if (findPromocao(id) == null) {
                    throw new NonexistentEntityException("The promocao with id " + id + " no longer exists.");
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
            Promocao promocao;
            try {
                promocao = em.getReference(Promocao.class, id);
                promocao.getCodpromocao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The promocao with id " + id + " no longer exists.", enfe);
            }
            Formapag codfp = promocao.getCodfp();
            if (codfp != null) {
                codfp.getPromocaoCollection().remove(promocao);
                codfp = em.merge(codfp);
            }
            Collection<Promocaoproduto> promocaoprodutoCollection = promocao.getPromocaoprodutoCollection();
            for (Promocaoproduto promocaoprodutoCollectionPromocaoproduto : promocaoprodutoCollection) {
                promocaoprodutoCollectionPromocaoproduto.setCodpromocao(null);
                promocaoprodutoCollectionPromocaoproduto = em.merge(promocaoprodutoCollectionPromocaoproduto);
            }
            em.remove(promocao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Promocao> findPromocaoEntities() {
        return findPromocaoEntities(true, -1, -1);
    }

    public List<Promocao> findPromocaoEntities(int maxResults, int firstResult) {
        return findPromocaoEntities(false, maxResults, firstResult);
    }

    private List<Promocao> findPromocaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Promocao.class));
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

    public Promocao findPromocao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Promocao.class, id);
        } finally {
            em.close();
        }
    }

    public int getPromocaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Promocao> rt = cq.from(Promocao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

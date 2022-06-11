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
import entidade.cplus.Avaliacao;
import entidade.cplus.Tipoavaliacao;
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
public class TipoavaliacaoJpaController implements Serializable {

    public TipoavaliacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipoavaliacao tipoavaliacao) throws PreexistingEntityException, Exception {
        if (tipoavaliacao.getAvaliacaoCollection() == null) {
            tipoavaliacao.setAvaliacaoCollection(new ArrayList<Avaliacao>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Avaliacao> attachedAvaliacaoCollection = new ArrayList<Avaliacao>();
            for (Avaliacao avaliacaoCollectionAvaliacaoToAttach : tipoavaliacao.getAvaliacaoCollection()) {
                avaliacaoCollectionAvaliacaoToAttach = em.getReference(avaliacaoCollectionAvaliacaoToAttach.getClass(), avaliacaoCollectionAvaliacaoToAttach.getCodavaliacao());
                attachedAvaliacaoCollection.add(avaliacaoCollectionAvaliacaoToAttach);
            }
            tipoavaliacao.setAvaliacaoCollection(attachedAvaliacaoCollection);
            em.persist(tipoavaliacao);
            for (Avaliacao avaliacaoCollectionAvaliacao : tipoavaliacao.getAvaliacaoCollection()) {
                Tipoavaliacao oldCodtipoavaliacaoOfAvaliacaoCollectionAvaliacao = avaliacaoCollectionAvaliacao.getCodtipoavaliacao();
                avaliacaoCollectionAvaliacao.setCodtipoavaliacao(tipoavaliacao);
                avaliacaoCollectionAvaliacao = em.merge(avaliacaoCollectionAvaliacao);
                if (oldCodtipoavaliacaoOfAvaliacaoCollectionAvaliacao != null) {
                    oldCodtipoavaliacaoOfAvaliacaoCollectionAvaliacao.getAvaliacaoCollection().remove(avaliacaoCollectionAvaliacao);
                    oldCodtipoavaliacaoOfAvaliacaoCollectionAvaliacao = em.merge(oldCodtipoavaliacaoOfAvaliacaoCollectionAvaliacao);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipoavaliacao(tipoavaliacao.getCodtipoavaliacao()) != null) {
                throw new PreexistingEntityException("Tipoavaliacao " + tipoavaliacao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipoavaliacao tipoavaliacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipoavaliacao persistentTipoavaliacao = em.find(Tipoavaliacao.class, tipoavaliacao.getCodtipoavaliacao());
            Collection<Avaliacao> avaliacaoCollectionOld = persistentTipoavaliacao.getAvaliacaoCollection();
            Collection<Avaliacao> avaliacaoCollectionNew = tipoavaliacao.getAvaliacaoCollection();
            Collection<Avaliacao> attachedAvaliacaoCollectionNew = new ArrayList<Avaliacao>();
            for (Avaliacao avaliacaoCollectionNewAvaliacaoToAttach : avaliacaoCollectionNew) {
                avaliacaoCollectionNewAvaliacaoToAttach = em.getReference(avaliacaoCollectionNewAvaliacaoToAttach.getClass(), avaliacaoCollectionNewAvaliacaoToAttach.getCodavaliacao());
                attachedAvaliacaoCollectionNew.add(avaliacaoCollectionNewAvaliacaoToAttach);
            }
            avaliacaoCollectionNew = attachedAvaliacaoCollectionNew;
            tipoavaliacao.setAvaliacaoCollection(avaliacaoCollectionNew);
            tipoavaliacao = em.merge(tipoavaliacao);
            for (Avaliacao avaliacaoCollectionOldAvaliacao : avaliacaoCollectionOld) {
                if (!avaliacaoCollectionNew.contains(avaliacaoCollectionOldAvaliacao)) {
                    avaliacaoCollectionOldAvaliacao.setCodtipoavaliacao(null);
                    avaliacaoCollectionOldAvaliacao = em.merge(avaliacaoCollectionOldAvaliacao);
                }
            }
            for (Avaliacao avaliacaoCollectionNewAvaliacao : avaliacaoCollectionNew) {
                if (!avaliacaoCollectionOld.contains(avaliacaoCollectionNewAvaliacao)) {
                    Tipoavaliacao oldCodtipoavaliacaoOfAvaliacaoCollectionNewAvaliacao = avaliacaoCollectionNewAvaliacao.getCodtipoavaliacao();
                    avaliacaoCollectionNewAvaliacao.setCodtipoavaliacao(tipoavaliacao);
                    avaliacaoCollectionNewAvaliacao = em.merge(avaliacaoCollectionNewAvaliacao);
                    if (oldCodtipoavaliacaoOfAvaliacaoCollectionNewAvaliacao != null && !oldCodtipoavaliacaoOfAvaliacaoCollectionNewAvaliacao.equals(tipoavaliacao)) {
                        oldCodtipoavaliacaoOfAvaliacaoCollectionNewAvaliacao.getAvaliacaoCollection().remove(avaliacaoCollectionNewAvaliacao);
                        oldCodtipoavaliacaoOfAvaliacaoCollectionNewAvaliacao = em.merge(oldCodtipoavaliacaoOfAvaliacaoCollectionNewAvaliacao);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tipoavaliacao.getCodtipoavaliacao();
                if (findTipoavaliacao(id) == null) {
                    throw new NonexistentEntityException("The tipoavaliacao with id " + id + " no longer exists.");
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
            Tipoavaliacao tipoavaliacao;
            try {
                tipoavaliacao = em.getReference(Tipoavaliacao.class, id);
                tipoavaliacao.getCodtipoavaliacao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoavaliacao with id " + id + " no longer exists.", enfe);
            }
            Collection<Avaliacao> avaliacaoCollection = tipoavaliacao.getAvaliacaoCollection();
            for (Avaliacao avaliacaoCollectionAvaliacao : avaliacaoCollection) {
                avaliacaoCollectionAvaliacao.setCodtipoavaliacao(null);
                avaliacaoCollectionAvaliacao = em.merge(avaliacaoCollectionAvaliacao);
            }
            em.remove(tipoavaliacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipoavaliacao> findTipoavaliacaoEntities() {
        return findTipoavaliacaoEntities(true, -1, -1);
    }

    public List<Tipoavaliacao> findTipoavaliacaoEntities(int maxResults, int firstResult) {
        return findTipoavaliacaoEntities(false, maxResults, firstResult);
    }

    private List<Tipoavaliacao> findTipoavaliacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipoavaliacao.class));
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

    public Tipoavaliacao findTipoavaliacao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipoavaliacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoavaliacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipoavaliacao> rt = cq.from(Tipoavaliacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

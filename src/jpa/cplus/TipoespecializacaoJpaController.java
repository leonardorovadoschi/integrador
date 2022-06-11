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
import entidade.cplus.Especializacao;
import entidade.cplus.Tipoespecializacao;
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
public class TipoespecializacaoJpaController implements Serializable {

    public TipoespecializacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipoespecializacao tipoespecializacao) throws PreexistingEntityException, Exception {
        if (tipoespecializacao.getEspecializacaoCollection() == null) {
            tipoespecializacao.setEspecializacaoCollection(new ArrayList<Especializacao>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Especializacao> attachedEspecializacaoCollection = new ArrayList<Especializacao>();
            for (Especializacao especializacaoCollectionEspecializacaoToAttach : tipoespecializacao.getEspecializacaoCollection()) {
                especializacaoCollectionEspecializacaoToAttach = em.getReference(especializacaoCollectionEspecializacaoToAttach.getClass(), especializacaoCollectionEspecializacaoToAttach.getCodespecializacao());
                attachedEspecializacaoCollection.add(especializacaoCollectionEspecializacaoToAttach);
            }
            tipoespecializacao.setEspecializacaoCollection(attachedEspecializacaoCollection);
            em.persist(tipoespecializacao);
            for (Especializacao especializacaoCollectionEspecializacao : tipoespecializacao.getEspecializacaoCollection()) {
                Tipoespecializacao oldCodtipoespecializacaoOfEspecializacaoCollectionEspecializacao = especializacaoCollectionEspecializacao.getCodtipoespecializacao();
                especializacaoCollectionEspecializacao.setCodtipoespecializacao(tipoespecializacao);
                especializacaoCollectionEspecializacao = em.merge(especializacaoCollectionEspecializacao);
                if (oldCodtipoespecializacaoOfEspecializacaoCollectionEspecializacao != null) {
                    oldCodtipoespecializacaoOfEspecializacaoCollectionEspecializacao.getEspecializacaoCollection().remove(especializacaoCollectionEspecializacao);
                    oldCodtipoespecializacaoOfEspecializacaoCollectionEspecializacao = em.merge(oldCodtipoespecializacaoOfEspecializacaoCollectionEspecializacao);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipoespecializacao(tipoespecializacao.getCodtipoespecializacao()) != null) {
                throw new PreexistingEntityException("Tipoespecializacao " + tipoespecializacao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipoespecializacao tipoespecializacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipoespecializacao persistentTipoespecializacao = em.find(Tipoespecializacao.class, tipoespecializacao.getCodtipoespecializacao());
            Collection<Especializacao> especializacaoCollectionOld = persistentTipoespecializacao.getEspecializacaoCollection();
            Collection<Especializacao> especializacaoCollectionNew = tipoespecializacao.getEspecializacaoCollection();
            Collection<Especializacao> attachedEspecializacaoCollectionNew = new ArrayList<Especializacao>();
            for (Especializacao especializacaoCollectionNewEspecializacaoToAttach : especializacaoCollectionNew) {
                especializacaoCollectionNewEspecializacaoToAttach = em.getReference(especializacaoCollectionNewEspecializacaoToAttach.getClass(), especializacaoCollectionNewEspecializacaoToAttach.getCodespecializacao());
                attachedEspecializacaoCollectionNew.add(especializacaoCollectionNewEspecializacaoToAttach);
            }
            especializacaoCollectionNew = attachedEspecializacaoCollectionNew;
            tipoespecializacao.setEspecializacaoCollection(especializacaoCollectionNew);
            tipoespecializacao = em.merge(tipoespecializacao);
            for (Especializacao especializacaoCollectionOldEspecializacao : especializacaoCollectionOld) {
                if (!especializacaoCollectionNew.contains(especializacaoCollectionOldEspecializacao)) {
                    especializacaoCollectionOldEspecializacao.setCodtipoespecializacao(null);
                    especializacaoCollectionOldEspecializacao = em.merge(especializacaoCollectionOldEspecializacao);
                }
            }
            for (Especializacao especializacaoCollectionNewEspecializacao : especializacaoCollectionNew) {
                if (!especializacaoCollectionOld.contains(especializacaoCollectionNewEspecializacao)) {
                    Tipoespecializacao oldCodtipoespecializacaoOfEspecializacaoCollectionNewEspecializacao = especializacaoCollectionNewEspecializacao.getCodtipoespecializacao();
                    especializacaoCollectionNewEspecializacao.setCodtipoespecializacao(tipoespecializacao);
                    especializacaoCollectionNewEspecializacao = em.merge(especializacaoCollectionNewEspecializacao);
                    if (oldCodtipoespecializacaoOfEspecializacaoCollectionNewEspecializacao != null && !oldCodtipoespecializacaoOfEspecializacaoCollectionNewEspecializacao.equals(tipoespecializacao)) {
                        oldCodtipoespecializacaoOfEspecializacaoCollectionNewEspecializacao.getEspecializacaoCollection().remove(especializacaoCollectionNewEspecializacao);
                        oldCodtipoespecializacaoOfEspecializacaoCollectionNewEspecializacao = em.merge(oldCodtipoespecializacaoOfEspecializacaoCollectionNewEspecializacao);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tipoespecializacao.getCodtipoespecializacao();
                if (findTipoespecializacao(id) == null) {
                    throw new NonexistentEntityException("The tipoespecializacao with id " + id + " no longer exists.");
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
            Tipoespecializacao tipoespecializacao;
            try {
                tipoespecializacao = em.getReference(Tipoespecializacao.class, id);
                tipoespecializacao.getCodtipoespecializacao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoespecializacao with id " + id + " no longer exists.", enfe);
            }
            Collection<Especializacao> especializacaoCollection = tipoespecializacao.getEspecializacaoCollection();
            for (Especializacao especializacaoCollectionEspecializacao : especializacaoCollection) {
                especializacaoCollectionEspecializacao.setCodtipoespecializacao(null);
                especializacaoCollectionEspecializacao = em.merge(especializacaoCollectionEspecializacao);
            }
            em.remove(tipoespecializacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipoespecializacao> findTipoespecializacaoEntities() {
        return findTipoespecializacaoEntities(true, -1, -1);
    }

    public List<Tipoespecializacao> findTipoespecializacaoEntities(int maxResults, int firstResult) {
        return findTipoespecializacaoEntities(false, maxResults, firstResult);
    }

    private List<Tipoespecializacao> findTipoespecializacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipoespecializacao.class));
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

    public Tipoespecializacao findTipoespecializacao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipoespecializacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoespecializacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipoespecializacao> rt = cq.from(Tipoespecializacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

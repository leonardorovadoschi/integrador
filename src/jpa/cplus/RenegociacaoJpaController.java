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
import entidade.cplus.Contareceber;
import entidade.cplus.Renegociacao;
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
public class RenegociacaoJpaController implements Serializable {

    public RenegociacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Renegociacao renegociacao) throws PreexistingEntityException, Exception {
        if (renegociacao.getContareceberCollection() == null) {
            renegociacao.setContareceberCollection(new ArrayList<Contareceber>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Contareceber> attachedContareceberCollection = new ArrayList<Contareceber>();
            for (Contareceber contareceberCollectionContareceberToAttach : renegociacao.getContareceberCollection()) {
                contareceberCollectionContareceberToAttach = em.getReference(contareceberCollectionContareceberToAttach.getClass(), contareceberCollectionContareceberToAttach.getCodcr());
                attachedContareceberCollection.add(contareceberCollectionContareceberToAttach);
            }
            renegociacao.setContareceberCollection(attachedContareceberCollection);
            em.persist(renegociacao);
            for (Contareceber contareceberCollectionContareceber : renegociacao.getContareceberCollection()) {
                Renegociacao oldCodrenegociacaoOfContareceberCollectionContareceber = contareceberCollectionContareceber.getCodrenegociacao();
                contareceberCollectionContareceber.setCodrenegociacao(renegociacao);
                contareceberCollectionContareceber = em.merge(contareceberCollectionContareceber);
                if (oldCodrenegociacaoOfContareceberCollectionContareceber != null) {
                    oldCodrenegociacaoOfContareceberCollectionContareceber.getContareceberCollection().remove(contareceberCollectionContareceber);
                    oldCodrenegociacaoOfContareceberCollectionContareceber = em.merge(oldCodrenegociacaoOfContareceberCollectionContareceber);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRenegociacao(renegociacao.getCodrenegociacao()) != null) {
                throw new PreexistingEntityException("Renegociacao " + renegociacao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Renegociacao renegociacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Renegociacao persistentRenegociacao = em.find(Renegociacao.class, renegociacao.getCodrenegociacao());
            Collection<Contareceber> contareceberCollectionOld = persistentRenegociacao.getContareceberCollection();
            Collection<Contareceber> contareceberCollectionNew = renegociacao.getContareceberCollection();
            Collection<Contareceber> attachedContareceberCollectionNew = new ArrayList<Contareceber>();
            for (Contareceber contareceberCollectionNewContareceberToAttach : contareceberCollectionNew) {
                contareceberCollectionNewContareceberToAttach = em.getReference(contareceberCollectionNewContareceberToAttach.getClass(), contareceberCollectionNewContareceberToAttach.getCodcr());
                attachedContareceberCollectionNew.add(contareceberCollectionNewContareceberToAttach);
            }
            contareceberCollectionNew = attachedContareceberCollectionNew;
            renegociacao.setContareceberCollection(contareceberCollectionNew);
            renegociacao = em.merge(renegociacao);
            for (Contareceber contareceberCollectionOldContareceber : contareceberCollectionOld) {
                if (!contareceberCollectionNew.contains(contareceberCollectionOldContareceber)) {
                    contareceberCollectionOldContareceber.setCodrenegociacao(null);
                    contareceberCollectionOldContareceber = em.merge(contareceberCollectionOldContareceber);
                }
            }
            for (Contareceber contareceberCollectionNewContareceber : contareceberCollectionNew) {
                if (!contareceberCollectionOld.contains(contareceberCollectionNewContareceber)) {
                    Renegociacao oldCodrenegociacaoOfContareceberCollectionNewContareceber = contareceberCollectionNewContareceber.getCodrenegociacao();
                    contareceberCollectionNewContareceber.setCodrenegociacao(renegociacao);
                    contareceberCollectionNewContareceber = em.merge(contareceberCollectionNewContareceber);
                    if (oldCodrenegociacaoOfContareceberCollectionNewContareceber != null && !oldCodrenegociacaoOfContareceberCollectionNewContareceber.equals(renegociacao)) {
                        oldCodrenegociacaoOfContareceberCollectionNewContareceber.getContareceberCollection().remove(contareceberCollectionNewContareceber);
                        oldCodrenegociacaoOfContareceberCollectionNewContareceber = em.merge(oldCodrenegociacaoOfContareceberCollectionNewContareceber);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = renegociacao.getCodrenegociacao();
                if (findRenegociacao(id) == null) {
                    throw new NonexistentEntityException("The renegociacao with id " + id + " no longer exists.");
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
            Renegociacao renegociacao;
            try {
                renegociacao = em.getReference(Renegociacao.class, id);
                renegociacao.getCodrenegociacao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The renegociacao with id " + id + " no longer exists.", enfe);
            }
            Collection<Contareceber> contareceberCollection = renegociacao.getContareceberCollection();
            for (Contareceber contareceberCollectionContareceber : contareceberCollection) {
                contareceberCollectionContareceber.setCodrenegociacao(null);
                contareceberCollectionContareceber = em.merge(contareceberCollectionContareceber);
            }
            em.remove(renegociacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Renegociacao> findRenegociacaoEntities() {
        return findRenegociacaoEntities(true, -1, -1);
    }

    public List<Renegociacao> findRenegociacaoEntities(int maxResults, int firstResult) {
        return findRenegociacaoEntities(false, maxResults, firstResult);
    }

    private List<Renegociacao> findRenegociacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Renegociacao.class));
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

    public Renegociacao findRenegociacao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Renegociacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getRenegociacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Renegociacao> rt = cq.from(Renegociacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

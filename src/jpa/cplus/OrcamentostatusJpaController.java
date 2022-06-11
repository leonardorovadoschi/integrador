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
import entidade.cplus.Orcamento;
import entidade.cplus.Orcamentostatus;
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
public class OrcamentostatusJpaController implements Serializable {

    public OrcamentostatusJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Orcamentostatus orcamentostatus) throws PreexistingEntityException, Exception {
        if (orcamentostatus.getOrcamentoCollection() == null) {
            orcamentostatus.setOrcamentoCollection(new ArrayList<Orcamento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Orcamento> attachedOrcamentoCollection = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollectionOrcamentoToAttach : orcamentostatus.getOrcamentoCollection()) {
                orcamentoCollectionOrcamentoToAttach = em.getReference(orcamentoCollectionOrcamentoToAttach.getClass(), orcamentoCollectionOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollection.add(orcamentoCollectionOrcamentoToAttach);
            }
            orcamentostatus.setOrcamentoCollection(attachedOrcamentoCollection);
            em.persist(orcamentostatus);
            for (Orcamento orcamentoCollectionOrcamento : orcamentostatus.getOrcamentoCollection()) {
                Orcamentostatus oldCodorcamentostatusOfOrcamentoCollectionOrcamento = orcamentoCollectionOrcamento.getCodorcamentostatus();
                orcamentoCollectionOrcamento.setCodorcamentostatus(orcamentostatus);
                orcamentoCollectionOrcamento = em.merge(orcamentoCollectionOrcamento);
                if (oldCodorcamentostatusOfOrcamentoCollectionOrcamento != null) {
                    oldCodorcamentostatusOfOrcamentoCollectionOrcamento.getOrcamentoCollection().remove(orcamentoCollectionOrcamento);
                    oldCodorcamentostatusOfOrcamentoCollectionOrcamento = em.merge(oldCodorcamentostatusOfOrcamentoCollectionOrcamento);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrcamentostatus(orcamentostatus.getCodorcamentostatus()) != null) {
                throw new PreexistingEntityException("Orcamentostatus " + orcamentostatus + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Orcamentostatus orcamentostatus) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Orcamentostatus persistentOrcamentostatus = em.find(Orcamentostatus.class, orcamentostatus.getCodorcamentostatus());
            Collection<Orcamento> orcamentoCollectionOld = persistentOrcamentostatus.getOrcamentoCollection();
            Collection<Orcamento> orcamentoCollectionNew = orcamentostatus.getOrcamentoCollection();
            Collection<Orcamento> attachedOrcamentoCollectionNew = new ArrayList<Orcamento>();
            for (Orcamento orcamentoCollectionNewOrcamentoToAttach : orcamentoCollectionNew) {
                orcamentoCollectionNewOrcamentoToAttach = em.getReference(orcamentoCollectionNewOrcamentoToAttach.getClass(), orcamentoCollectionNewOrcamentoToAttach.getCodorc());
                attachedOrcamentoCollectionNew.add(orcamentoCollectionNewOrcamentoToAttach);
            }
            orcamentoCollectionNew = attachedOrcamentoCollectionNew;
            orcamentostatus.setOrcamentoCollection(orcamentoCollectionNew);
            orcamentostatus = em.merge(orcamentostatus);
            for (Orcamento orcamentoCollectionOldOrcamento : orcamentoCollectionOld) {
                if (!orcamentoCollectionNew.contains(orcamentoCollectionOldOrcamento)) {
                    orcamentoCollectionOldOrcamento.setCodorcamentostatus(null);
                    orcamentoCollectionOldOrcamento = em.merge(orcamentoCollectionOldOrcamento);
                }
            }
            for (Orcamento orcamentoCollectionNewOrcamento : orcamentoCollectionNew) {
                if (!orcamentoCollectionOld.contains(orcamentoCollectionNewOrcamento)) {
                    Orcamentostatus oldCodorcamentostatusOfOrcamentoCollectionNewOrcamento = orcamentoCollectionNewOrcamento.getCodorcamentostatus();
                    orcamentoCollectionNewOrcamento.setCodorcamentostatus(orcamentostatus);
                    orcamentoCollectionNewOrcamento = em.merge(orcamentoCollectionNewOrcamento);
                    if (oldCodorcamentostatusOfOrcamentoCollectionNewOrcamento != null && !oldCodorcamentostatusOfOrcamentoCollectionNewOrcamento.equals(orcamentostatus)) {
                        oldCodorcamentostatusOfOrcamentoCollectionNewOrcamento.getOrcamentoCollection().remove(orcamentoCollectionNewOrcamento);
                        oldCodorcamentostatusOfOrcamentoCollectionNewOrcamento = em.merge(oldCodorcamentostatusOfOrcamentoCollectionNewOrcamento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = orcamentostatus.getCodorcamentostatus();
                if (findOrcamentostatus(id) == null) {
                    throw new NonexistentEntityException("The orcamentostatus with id " + id + " no longer exists.");
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
            Orcamentostatus orcamentostatus;
            try {
                orcamentostatus = em.getReference(Orcamentostatus.class, id);
                orcamentostatus.getCodorcamentostatus();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The orcamentostatus with id " + id + " no longer exists.", enfe);
            }
            Collection<Orcamento> orcamentoCollection = orcamentostatus.getOrcamentoCollection();
            for (Orcamento orcamentoCollectionOrcamento : orcamentoCollection) {
                orcamentoCollectionOrcamento.setCodorcamentostatus(null);
                orcamentoCollectionOrcamento = em.merge(orcamentoCollectionOrcamento);
            }
            em.remove(orcamentostatus);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Orcamentostatus> findOrcamentostatusEntities() {
        return findOrcamentostatusEntities(true, -1, -1);
    }

    public List<Orcamentostatus> findOrcamentostatusEntities(int maxResults, int firstResult) {
        return findOrcamentostatusEntities(false, maxResults, firstResult);
    }

    private List<Orcamentostatus> findOrcamentostatusEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Orcamentostatus.class));
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

    public Orcamentostatus findOrcamentostatus(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Orcamentostatus.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrcamentostatusCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Orcamentostatus> rt = cq.from(Orcamentostatus.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

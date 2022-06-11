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
import entidade.cplus.Workflow;
import entidade.cplus.Atendimento;
import entidade.cplus.Tipoatendimento;
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
public class TipoatendimentoJpaController implements Serializable {

    public TipoatendimentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipoatendimento tipoatendimento) throws PreexistingEntityException, Exception {
        if (tipoatendimento.getAtendimentoCollection() == null) {
            tipoatendimento.setAtendimentoCollection(new ArrayList<Atendimento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Workflow codworkflow = tipoatendimento.getCodworkflow();
            if (codworkflow != null) {
                codworkflow = em.getReference(codworkflow.getClass(), codworkflow.getCodworkflow());
                tipoatendimento.setCodworkflow(codworkflow);
            }
            Collection<Atendimento> attachedAtendimentoCollection = new ArrayList<Atendimento>();
            for (Atendimento atendimentoCollectionAtendimentoToAttach : tipoatendimento.getAtendimentoCollection()) {
                atendimentoCollectionAtendimentoToAttach = em.getReference(atendimentoCollectionAtendimentoToAttach.getClass(), atendimentoCollectionAtendimentoToAttach.getCodatend());
                attachedAtendimentoCollection.add(atendimentoCollectionAtendimentoToAttach);
            }
            tipoatendimento.setAtendimentoCollection(attachedAtendimentoCollection);
            em.persist(tipoatendimento);
            if (codworkflow != null) {
                codworkflow.getTipoatendimentoCollection().add(tipoatendimento);
                codworkflow = em.merge(codworkflow);
            }
            for (Atendimento atendimentoCollectionAtendimento : tipoatendimento.getAtendimentoCollection()) {
                Tipoatendimento oldCodtipoatendOfAtendimentoCollectionAtendimento = atendimentoCollectionAtendimento.getCodtipoatend();
                atendimentoCollectionAtendimento.setCodtipoatend(tipoatendimento);
                atendimentoCollectionAtendimento = em.merge(atendimentoCollectionAtendimento);
                if (oldCodtipoatendOfAtendimentoCollectionAtendimento != null) {
                    oldCodtipoatendOfAtendimentoCollectionAtendimento.getAtendimentoCollection().remove(atendimentoCollectionAtendimento);
                    oldCodtipoatendOfAtendimentoCollectionAtendimento = em.merge(oldCodtipoatendOfAtendimentoCollectionAtendimento);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipoatendimento(tipoatendimento.getCodtipoatend()) != null) {
                throw new PreexistingEntityException("Tipoatendimento " + tipoatendimento + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipoatendimento tipoatendimento) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipoatendimento persistentTipoatendimento = em.find(Tipoatendimento.class, tipoatendimento.getCodtipoatend());
            Workflow codworkflowOld = persistentTipoatendimento.getCodworkflow();
            Workflow codworkflowNew = tipoatendimento.getCodworkflow();
            Collection<Atendimento> atendimentoCollectionOld = persistentTipoatendimento.getAtendimentoCollection();
            Collection<Atendimento> atendimentoCollectionNew = tipoatendimento.getAtendimentoCollection();
            if (codworkflowNew != null) {
                codworkflowNew = em.getReference(codworkflowNew.getClass(), codworkflowNew.getCodworkflow());
                tipoatendimento.setCodworkflow(codworkflowNew);
            }
            Collection<Atendimento> attachedAtendimentoCollectionNew = new ArrayList<Atendimento>();
            for (Atendimento atendimentoCollectionNewAtendimentoToAttach : atendimentoCollectionNew) {
                atendimentoCollectionNewAtendimentoToAttach = em.getReference(atendimentoCollectionNewAtendimentoToAttach.getClass(), atendimentoCollectionNewAtendimentoToAttach.getCodatend());
                attachedAtendimentoCollectionNew.add(atendimentoCollectionNewAtendimentoToAttach);
            }
            atendimentoCollectionNew = attachedAtendimentoCollectionNew;
            tipoatendimento.setAtendimentoCollection(atendimentoCollectionNew);
            tipoatendimento = em.merge(tipoatendimento);
            if (codworkflowOld != null && !codworkflowOld.equals(codworkflowNew)) {
                codworkflowOld.getTipoatendimentoCollection().remove(tipoatendimento);
                codworkflowOld = em.merge(codworkflowOld);
            }
            if (codworkflowNew != null && !codworkflowNew.equals(codworkflowOld)) {
                codworkflowNew.getTipoatendimentoCollection().add(tipoatendimento);
                codworkflowNew = em.merge(codworkflowNew);
            }
            for (Atendimento atendimentoCollectionOldAtendimento : atendimentoCollectionOld) {
                if (!atendimentoCollectionNew.contains(atendimentoCollectionOldAtendimento)) {
                    atendimentoCollectionOldAtendimento.setCodtipoatend(null);
                    atendimentoCollectionOldAtendimento = em.merge(atendimentoCollectionOldAtendimento);
                }
            }
            for (Atendimento atendimentoCollectionNewAtendimento : atendimentoCollectionNew) {
                if (!atendimentoCollectionOld.contains(atendimentoCollectionNewAtendimento)) {
                    Tipoatendimento oldCodtipoatendOfAtendimentoCollectionNewAtendimento = atendimentoCollectionNewAtendimento.getCodtipoatend();
                    atendimentoCollectionNewAtendimento.setCodtipoatend(tipoatendimento);
                    atendimentoCollectionNewAtendimento = em.merge(atendimentoCollectionNewAtendimento);
                    if (oldCodtipoatendOfAtendimentoCollectionNewAtendimento != null && !oldCodtipoatendOfAtendimentoCollectionNewAtendimento.equals(tipoatendimento)) {
                        oldCodtipoatendOfAtendimentoCollectionNewAtendimento.getAtendimentoCollection().remove(atendimentoCollectionNewAtendimento);
                        oldCodtipoatendOfAtendimentoCollectionNewAtendimento = em.merge(oldCodtipoatendOfAtendimentoCollectionNewAtendimento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tipoatendimento.getCodtipoatend();
                if (findTipoatendimento(id) == null) {
                    throw new NonexistentEntityException("The tipoatendimento with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipoatendimento tipoatendimento;
            try {
                tipoatendimento = em.getReference(Tipoatendimento.class, id);
                tipoatendimento.getCodtipoatend();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoatendimento with id " + id + " no longer exists.", enfe);
            }
            Workflow codworkflow = tipoatendimento.getCodworkflow();
            if (codworkflow != null) {
                codworkflow.getTipoatendimentoCollection().remove(tipoatendimento);
                codworkflow = em.merge(codworkflow);
            }
            Collection<Atendimento> atendimentoCollection = tipoatendimento.getAtendimentoCollection();
            for (Atendimento atendimentoCollectionAtendimento : atendimentoCollection) {
                atendimentoCollectionAtendimento.setCodtipoatend(null);
                atendimentoCollectionAtendimento = em.merge(atendimentoCollectionAtendimento);
            }
            em.remove(tipoatendimento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipoatendimento> findTipoatendimentoEntities() {
        return findTipoatendimentoEntities(true, -1, -1);
    }

    public List<Tipoatendimento> findTipoatendimentoEntities(int maxResults, int firstResult) {
        return findTipoatendimentoEntities(false, maxResults, firstResult);
    }

    private List<Tipoatendimento> findTipoatendimentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipoatendimento.class));
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

    public Tipoatendimento findTipoatendimento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipoatendimento.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoatendimentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipoatendimento> rt = cq.from(Tipoatendimento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

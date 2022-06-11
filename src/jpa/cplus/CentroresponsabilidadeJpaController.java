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
import entidade.cplus.Workflowitem;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Atendimento;
import entidade.cplus.Centroresponsabilidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class CentroresponsabilidadeJpaController implements Serializable {

    public CentroresponsabilidadeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Centroresponsabilidade centroresponsabilidade) throws PreexistingEntityException, Exception {
        if (centroresponsabilidade.getWorkflowitemCollection() == null) {
            centroresponsabilidade.setWorkflowitemCollection(new ArrayList<Workflowitem>());
        }
        if (centroresponsabilidade.getAtendimentoCollection() == null) {
            centroresponsabilidade.setAtendimentoCollection(new ArrayList<Atendimento>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Workflowitem> attachedWorkflowitemCollection = new ArrayList<Workflowitem>();
            for (Workflowitem workflowitemCollectionWorkflowitemToAttach : centroresponsabilidade.getWorkflowitemCollection()) {
                workflowitemCollectionWorkflowitemToAttach = em.getReference(workflowitemCollectionWorkflowitemToAttach.getClass(), workflowitemCollectionWorkflowitemToAttach.getCodworkflowitem());
                attachedWorkflowitemCollection.add(workflowitemCollectionWorkflowitemToAttach);
            }
            centroresponsabilidade.setWorkflowitemCollection(attachedWorkflowitemCollection);
            Collection<Atendimento> attachedAtendimentoCollection = new ArrayList<Atendimento>();
            for (Atendimento atendimentoCollectionAtendimentoToAttach : centroresponsabilidade.getAtendimentoCollection()) {
                atendimentoCollectionAtendimentoToAttach = em.getReference(atendimentoCollectionAtendimentoToAttach.getClass(), atendimentoCollectionAtendimentoToAttach.getCodatend());
                attachedAtendimentoCollection.add(atendimentoCollectionAtendimentoToAttach);
            }
            centroresponsabilidade.setAtendimentoCollection(attachedAtendimentoCollection);
            em.persist(centroresponsabilidade);
            for (Workflowitem workflowitemCollectionWorkflowitem : centroresponsabilidade.getWorkflowitemCollection()) {
                Centroresponsabilidade oldCodcentroresponsabilidadeOfWorkflowitemCollectionWorkflowitem = workflowitemCollectionWorkflowitem.getCodcentroresponsabilidade();
                workflowitemCollectionWorkflowitem.setCodcentroresponsabilidade(centroresponsabilidade);
                workflowitemCollectionWorkflowitem = em.merge(workflowitemCollectionWorkflowitem);
                if (oldCodcentroresponsabilidadeOfWorkflowitemCollectionWorkflowitem != null) {
                    oldCodcentroresponsabilidadeOfWorkflowitemCollectionWorkflowitem.getWorkflowitemCollection().remove(workflowitemCollectionWorkflowitem);
                    oldCodcentroresponsabilidadeOfWorkflowitemCollectionWorkflowitem = em.merge(oldCodcentroresponsabilidadeOfWorkflowitemCollectionWorkflowitem);
                }
            }
            for (Atendimento atendimentoCollectionAtendimento : centroresponsabilidade.getAtendimentoCollection()) {
                Centroresponsabilidade oldCodcentroresponsabilidadeOfAtendimentoCollectionAtendimento = atendimentoCollectionAtendimento.getCodcentroresponsabilidade();
                atendimentoCollectionAtendimento.setCodcentroresponsabilidade(centroresponsabilidade);
                atendimentoCollectionAtendimento = em.merge(atendimentoCollectionAtendimento);
                if (oldCodcentroresponsabilidadeOfAtendimentoCollectionAtendimento != null) {
                    oldCodcentroresponsabilidadeOfAtendimentoCollectionAtendimento.getAtendimentoCollection().remove(atendimentoCollectionAtendimento);
                    oldCodcentroresponsabilidadeOfAtendimentoCollectionAtendimento = em.merge(oldCodcentroresponsabilidadeOfAtendimentoCollectionAtendimento);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCentroresponsabilidade(centroresponsabilidade.getCodcentroresponsabilidade()) != null) {
                throw new PreexistingEntityException("Centroresponsabilidade " + centroresponsabilidade + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Centroresponsabilidade centroresponsabilidade) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Centroresponsabilidade persistentCentroresponsabilidade = em.find(Centroresponsabilidade.class, centroresponsabilidade.getCodcentroresponsabilidade());
            Collection<Workflowitem> workflowitemCollectionOld = persistentCentroresponsabilidade.getWorkflowitemCollection();
            Collection<Workflowitem> workflowitemCollectionNew = centroresponsabilidade.getWorkflowitemCollection();
            Collection<Atendimento> atendimentoCollectionOld = persistentCentroresponsabilidade.getAtendimentoCollection();
            Collection<Atendimento> atendimentoCollectionNew = centroresponsabilidade.getAtendimentoCollection();
            Collection<Workflowitem> attachedWorkflowitemCollectionNew = new ArrayList<Workflowitem>();
            for (Workflowitem workflowitemCollectionNewWorkflowitemToAttach : workflowitemCollectionNew) {
                workflowitemCollectionNewWorkflowitemToAttach = em.getReference(workflowitemCollectionNewWorkflowitemToAttach.getClass(), workflowitemCollectionNewWorkflowitemToAttach.getCodworkflowitem());
                attachedWorkflowitemCollectionNew.add(workflowitemCollectionNewWorkflowitemToAttach);
            }
            workflowitemCollectionNew = attachedWorkflowitemCollectionNew;
            centroresponsabilidade.setWorkflowitemCollection(workflowitemCollectionNew);
            Collection<Atendimento> attachedAtendimentoCollectionNew = new ArrayList<Atendimento>();
            for (Atendimento atendimentoCollectionNewAtendimentoToAttach : atendimentoCollectionNew) {
                atendimentoCollectionNewAtendimentoToAttach = em.getReference(atendimentoCollectionNewAtendimentoToAttach.getClass(), atendimentoCollectionNewAtendimentoToAttach.getCodatend());
                attachedAtendimentoCollectionNew.add(atendimentoCollectionNewAtendimentoToAttach);
            }
            atendimentoCollectionNew = attachedAtendimentoCollectionNew;
            centroresponsabilidade.setAtendimentoCollection(atendimentoCollectionNew);
            centroresponsabilidade = em.merge(centroresponsabilidade);
            for (Workflowitem workflowitemCollectionOldWorkflowitem : workflowitemCollectionOld) {
                if (!workflowitemCollectionNew.contains(workflowitemCollectionOldWorkflowitem)) {
                    workflowitemCollectionOldWorkflowitem.setCodcentroresponsabilidade(null);
                    workflowitemCollectionOldWorkflowitem = em.merge(workflowitemCollectionOldWorkflowitem);
                }
            }
            for (Workflowitem workflowitemCollectionNewWorkflowitem : workflowitemCollectionNew) {
                if (!workflowitemCollectionOld.contains(workflowitemCollectionNewWorkflowitem)) {
                    Centroresponsabilidade oldCodcentroresponsabilidadeOfWorkflowitemCollectionNewWorkflowitem = workflowitemCollectionNewWorkflowitem.getCodcentroresponsabilidade();
                    workflowitemCollectionNewWorkflowitem.setCodcentroresponsabilidade(centroresponsabilidade);
                    workflowitemCollectionNewWorkflowitem = em.merge(workflowitemCollectionNewWorkflowitem);
                    if (oldCodcentroresponsabilidadeOfWorkflowitemCollectionNewWorkflowitem != null && !oldCodcentroresponsabilidadeOfWorkflowitemCollectionNewWorkflowitem.equals(centroresponsabilidade)) {
                        oldCodcentroresponsabilidadeOfWorkflowitemCollectionNewWorkflowitem.getWorkflowitemCollection().remove(workflowitemCollectionNewWorkflowitem);
                        oldCodcentroresponsabilidadeOfWorkflowitemCollectionNewWorkflowitem = em.merge(oldCodcentroresponsabilidadeOfWorkflowitemCollectionNewWorkflowitem);
                    }
                }
            }
            for (Atendimento atendimentoCollectionOldAtendimento : atendimentoCollectionOld) {
                if (!atendimentoCollectionNew.contains(atendimentoCollectionOldAtendimento)) {
                    atendimentoCollectionOldAtendimento.setCodcentroresponsabilidade(null);
                    atendimentoCollectionOldAtendimento = em.merge(atendimentoCollectionOldAtendimento);
                }
            }
            for (Atendimento atendimentoCollectionNewAtendimento : atendimentoCollectionNew) {
                if (!atendimentoCollectionOld.contains(atendimentoCollectionNewAtendimento)) {
                    Centroresponsabilidade oldCodcentroresponsabilidadeOfAtendimentoCollectionNewAtendimento = atendimentoCollectionNewAtendimento.getCodcentroresponsabilidade();
                    atendimentoCollectionNewAtendimento.setCodcentroresponsabilidade(centroresponsabilidade);
                    atendimentoCollectionNewAtendimento = em.merge(atendimentoCollectionNewAtendimento);
                    if (oldCodcentroresponsabilidadeOfAtendimentoCollectionNewAtendimento != null && !oldCodcentroresponsabilidadeOfAtendimentoCollectionNewAtendimento.equals(centroresponsabilidade)) {
                        oldCodcentroresponsabilidadeOfAtendimentoCollectionNewAtendimento.getAtendimentoCollection().remove(atendimentoCollectionNewAtendimento);
                        oldCodcentroresponsabilidadeOfAtendimentoCollectionNewAtendimento = em.merge(oldCodcentroresponsabilidadeOfAtendimentoCollectionNewAtendimento);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = centroresponsabilidade.getCodcentroresponsabilidade();
                if (findCentroresponsabilidade(id) == null) {
                    throw new NonexistentEntityException("The centroresponsabilidade with id " + id + " no longer exists.");
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
            Centroresponsabilidade centroresponsabilidade;
            try {
                centroresponsabilidade = em.getReference(Centroresponsabilidade.class, id);
                centroresponsabilidade.getCodcentroresponsabilidade();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The centroresponsabilidade with id " + id + " no longer exists.", enfe);
            }
            Collection<Workflowitem> workflowitemCollection = centroresponsabilidade.getWorkflowitemCollection();
            for (Workflowitem workflowitemCollectionWorkflowitem : workflowitemCollection) {
                workflowitemCollectionWorkflowitem.setCodcentroresponsabilidade(null);
                workflowitemCollectionWorkflowitem = em.merge(workflowitemCollectionWorkflowitem);
            }
            Collection<Atendimento> atendimentoCollection = centroresponsabilidade.getAtendimentoCollection();
            for (Atendimento atendimentoCollectionAtendimento : atendimentoCollection) {
                atendimentoCollectionAtendimento.setCodcentroresponsabilidade(null);
                atendimentoCollectionAtendimento = em.merge(atendimentoCollectionAtendimento);
            }
            em.remove(centroresponsabilidade);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Centroresponsabilidade> findCentroresponsabilidadeEntities() {
        return findCentroresponsabilidadeEntities(true, -1, -1);
    }

    public List<Centroresponsabilidade> findCentroresponsabilidadeEntities(int maxResults, int firstResult) {
        return findCentroresponsabilidadeEntities(false, maxResults, firstResult);
    }

    private List<Centroresponsabilidade> findCentroresponsabilidadeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Centroresponsabilidade.class));
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

    public Centroresponsabilidade findCentroresponsabilidade(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Centroresponsabilidade.class, id);
        } finally {
            em.close();
        }
    }

    public int getCentroresponsabilidadeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Centroresponsabilidade> rt = cq.from(Centroresponsabilidade.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

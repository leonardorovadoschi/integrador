/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Relatorio;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Sistema;
import entidade.cplus.Relatorioacesso;
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
public class RelatorioJpaController implements Serializable {

    public RelatorioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Relatorio relatorio) throws PreexistingEntityException, Exception {
        if (relatorio.getRelatorioacessoCollection() == null) {
            relatorio.setRelatorioacessoCollection(new ArrayList<Relatorioacesso>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sistema codsistema = relatorio.getCodsistema();
            if (codsistema != null) {
                codsistema = em.getReference(codsistema.getClass(), codsistema.getCodsistema());
                relatorio.setCodsistema(codsistema);
            }
            Collection<Relatorioacesso> attachedRelatorioacessoCollection = new ArrayList<Relatorioacesso>();
            for (Relatorioacesso relatorioacessoCollectionRelatorioacessoToAttach : relatorio.getRelatorioacessoCollection()) {
                relatorioacessoCollectionRelatorioacessoToAttach = em.getReference(relatorioacessoCollectionRelatorioacessoToAttach.getClass(), relatorioacessoCollectionRelatorioacessoToAttach.getId());
                attachedRelatorioacessoCollection.add(relatorioacessoCollectionRelatorioacessoToAttach);
            }
            relatorio.setRelatorioacessoCollection(attachedRelatorioacessoCollection);
            em.persist(relatorio);
            if (codsistema != null) {
                codsistema.getRelatorioCollection().add(relatorio);
                codsistema = em.merge(codsistema);
            }
            for (Relatorioacesso relatorioacessoCollectionRelatorioacesso : relatorio.getRelatorioacessoCollection()) {
                Relatorio oldIdrelatorioOfRelatorioacessoCollectionRelatorioacesso = relatorioacessoCollectionRelatorioacesso.getIdrelatorio();
                relatorioacessoCollectionRelatorioacesso.setIdrelatorio(relatorio);
                relatorioacessoCollectionRelatorioacesso = em.merge(relatorioacessoCollectionRelatorioacesso);
                if (oldIdrelatorioOfRelatorioacessoCollectionRelatorioacesso != null) {
                    oldIdrelatorioOfRelatorioacessoCollectionRelatorioacesso.getRelatorioacessoCollection().remove(relatorioacessoCollectionRelatorioacesso);
                    oldIdrelatorioOfRelatorioacessoCollectionRelatorioacesso = em.merge(oldIdrelatorioOfRelatorioacessoCollectionRelatorioacesso);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRelatorio(relatorio.getId()) != null) {
                throw new PreexistingEntityException("Relatorio " + relatorio + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Relatorio relatorio) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Relatorio persistentRelatorio = em.find(Relatorio.class, relatorio.getId());
            Sistema codsistemaOld = persistentRelatorio.getCodsistema();
            Sistema codsistemaNew = relatorio.getCodsistema();
            Collection<Relatorioacesso> relatorioacessoCollectionOld = persistentRelatorio.getRelatorioacessoCollection();
            Collection<Relatorioacesso> relatorioacessoCollectionNew = relatorio.getRelatorioacessoCollection();
            List<String> illegalOrphanMessages = null;
            for (Relatorioacesso relatorioacessoCollectionOldRelatorioacesso : relatorioacessoCollectionOld) {
                if (!relatorioacessoCollectionNew.contains(relatorioacessoCollectionOldRelatorioacesso)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Relatorioacesso " + relatorioacessoCollectionOldRelatorioacesso + " since its idrelatorio field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codsistemaNew != null) {
                codsistemaNew = em.getReference(codsistemaNew.getClass(), codsistemaNew.getCodsistema());
                relatorio.setCodsistema(codsistemaNew);
            }
            Collection<Relatorioacesso> attachedRelatorioacessoCollectionNew = new ArrayList<Relatorioacesso>();
            for (Relatorioacesso relatorioacessoCollectionNewRelatorioacessoToAttach : relatorioacessoCollectionNew) {
                relatorioacessoCollectionNewRelatorioacessoToAttach = em.getReference(relatorioacessoCollectionNewRelatorioacessoToAttach.getClass(), relatorioacessoCollectionNewRelatorioacessoToAttach.getId());
                attachedRelatorioacessoCollectionNew.add(relatorioacessoCollectionNewRelatorioacessoToAttach);
            }
            relatorioacessoCollectionNew = attachedRelatorioacessoCollectionNew;
            relatorio.setRelatorioacessoCollection(relatorioacessoCollectionNew);
            relatorio = em.merge(relatorio);
            if (codsistemaOld != null && !codsistemaOld.equals(codsistemaNew)) {
                codsistemaOld.getRelatorioCollection().remove(relatorio);
                codsistemaOld = em.merge(codsistemaOld);
            }
            if (codsistemaNew != null && !codsistemaNew.equals(codsistemaOld)) {
                codsistemaNew.getRelatorioCollection().add(relatorio);
                codsistemaNew = em.merge(codsistemaNew);
            }
            for (Relatorioacesso relatorioacessoCollectionNewRelatorioacesso : relatorioacessoCollectionNew) {
                if (!relatorioacessoCollectionOld.contains(relatorioacessoCollectionNewRelatorioacesso)) {
                    Relatorio oldIdrelatorioOfRelatorioacessoCollectionNewRelatorioacesso = relatorioacessoCollectionNewRelatorioacesso.getIdrelatorio();
                    relatorioacessoCollectionNewRelatorioacesso.setIdrelatorio(relatorio);
                    relatorioacessoCollectionNewRelatorioacesso = em.merge(relatorioacessoCollectionNewRelatorioacesso);
                    if (oldIdrelatorioOfRelatorioacessoCollectionNewRelatorioacesso != null && !oldIdrelatorioOfRelatorioacessoCollectionNewRelatorioacesso.equals(relatorio)) {
                        oldIdrelatorioOfRelatorioacessoCollectionNewRelatorioacesso.getRelatorioacessoCollection().remove(relatorioacessoCollectionNewRelatorioacesso);
                        oldIdrelatorioOfRelatorioacessoCollectionNewRelatorioacesso = em.merge(oldIdrelatorioOfRelatorioacessoCollectionNewRelatorioacesso);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = relatorio.getId();
                if (findRelatorio(id) == null) {
                    throw new NonexistentEntityException("The relatorio with id " + id + " no longer exists.");
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
            Relatorio relatorio;
            try {
                relatorio = em.getReference(Relatorio.class, id);
                relatorio.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The relatorio with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Relatorioacesso> relatorioacessoCollectionOrphanCheck = relatorio.getRelatorioacessoCollection();
            for (Relatorioacesso relatorioacessoCollectionOrphanCheckRelatorioacesso : relatorioacessoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Relatorio (" + relatorio + ") cannot be destroyed since the Relatorioacesso " + relatorioacessoCollectionOrphanCheckRelatorioacesso + " in its relatorioacessoCollection field has a non-nullable idrelatorio field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Sistema codsistema = relatorio.getCodsistema();
            if (codsistema != null) {
                codsistema.getRelatorioCollection().remove(relatorio);
                codsistema = em.merge(codsistema);
            }
            em.remove(relatorio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Relatorio> findRelatorioEntities() {
        return findRelatorioEntities(true, -1, -1);
    }

    public List<Relatorio> findRelatorioEntities(int maxResults, int firstResult) {
        return findRelatorioEntities(false, maxResults, firstResult);
    }

    private List<Relatorio> findRelatorioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Relatorio.class));
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

    public Relatorio findRelatorio(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Relatorio.class, id);
        } finally {
            em.close();
        }
    }

    public int getRelatorioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Relatorio> rt = cq.from(Relatorio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

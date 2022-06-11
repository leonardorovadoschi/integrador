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
import entidade.cplus.Calculoicmsestado;
import entidade.cplus.Motivodesoneracao;
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
public class MotivodesoneracaoJpaController implements Serializable {

    public MotivodesoneracaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Motivodesoneracao motivodesoneracao) throws PreexistingEntityException, Exception {
        if (motivodesoneracao.getCalculoicmsestadoCollection() == null) {
            motivodesoneracao.setCalculoicmsestadoCollection(new ArrayList<Calculoicmsestado>());
        }
        if (motivodesoneracao.getCalculoicmsestadoCollection1() == null) {
            motivodesoneracao.setCalculoicmsestadoCollection1(new ArrayList<Calculoicmsestado>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Calculoicmsestado> attachedCalculoicmsestadoCollection = new ArrayList<Calculoicmsestado>();
            for (Calculoicmsestado calculoicmsestadoCollectionCalculoicmsestadoToAttach : motivodesoneracao.getCalculoicmsestadoCollection()) {
                calculoicmsestadoCollectionCalculoicmsestadoToAttach = em.getReference(calculoicmsestadoCollectionCalculoicmsestadoToAttach.getClass(), calculoicmsestadoCollectionCalculoicmsestadoToAttach.getCodcalculoicmsestado());
                attachedCalculoicmsestadoCollection.add(calculoicmsestadoCollectionCalculoicmsestadoToAttach);
            }
            motivodesoneracao.setCalculoicmsestadoCollection(attachedCalculoicmsestadoCollection);
            Collection<Calculoicmsestado> attachedCalculoicmsestadoCollection1 = new ArrayList<Calculoicmsestado>();
            for (Calculoicmsestado calculoicmsestadoCollection1CalculoicmsestadoToAttach : motivodesoneracao.getCalculoicmsestadoCollection1()) {
                calculoicmsestadoCollection1CalculoicmsestadoToAttach = em.getReference(calculoicmsestadoCollection1CalculoicmsestadoToAttach.getClass(), calculoicmsestadoCollection1CalculoicmsestadoToAttach.getCodcalculoicmsestado());
                attachedCalculoicmsestadoCollection1.add(calculoicmsestadoCollection1CalculoicmsestadoToAttach);
            }
            motivodesoneracao.setCalculoicmsestadoCollection1(attachedCalculoicmsestadoCollection1);
            em.persist(motivodesoneracao);
            for (Calculoicmsestado calculoicmsestadoCollectionCalculoicmsestado : motivodesoneracao.getCalculoicmsestadoCollection()) {
                Motivodesoneracao oldCodigomotivodesoOfCalculoicmsestadoCollectionCalculoicmsestado = calculoicmsestadoCollectionCalculoicmsestado.getCodigomotivodeso();
                calculoicmsestadoCollectionCalculoicmsestado.setCodigomotivodeso(motivodesoneracao);
                calculoicmsestadoCollectionCalculoicmsestado = em.merge(calculoicmsestadoCollectionCalculoicmsestado);
                if (oldCodigomotivodesoOfCalculoicmsestadoCollectionCalculoicmsestado != null) {
                    oldCodigomotivodesoOfCalculoicmsestadoCollectionCalculoicmsestado.getCalculoicmsestadoCollection().remove(calculoicmsestadoCollectionCalculoicmsestado);
                    oldCodigomotivodesoOfCalculoicmsestadoCollectionCalculoicmsestado = em.merge(oldCodigomotivodesoOfCalculoicmsestadoCollectionCalculoicmsestado);
                }
            }
            for (Calculoicmsestado calculoicmsestadoCollection1Calculoicmsestado : motivodesoneracao.getCalculoicmsestadoCollection1()) {
                Motivodesoneracao oldCodigomotivodesodifOfCalculoicmsestadoCollection1Calculoicmsestado = calculoicmsestadoCollection1Calculoicmsestado.getCodigomotivodesodif();
                calculoicmsestadoCollection1Calculoicmsestado.setCodigomotivodesodif(motivodesoneracao);
                calculoicmsestadoCollection1Calculoicmsestado = em.merge(calculoicmsestadoCollection1Calculoicmsestado);
                if (oldCodigomotivodesodifOfCalculoicmsestadoCollection1Calculoicmsestado != null) {
                    oldCodigomotivodesodifOfCalculoicmsestadoCollection1Calculoicmsestado.getCalculoicmsestadoCollection1().remove(calculoicmsestadoCollection1Calculoicmsestado);
                    oldCodigomotivodesodifOfCalculoicmsestadoCollection1Calculoicmsestado = em.merge(oldCodigomotivodesodifOfCalculoicmsestadoCollection1Calculoicmsestado);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMotivodesoneracao(motivodesoneracao.getCodigomotivo()) != null) {
                throw new PreexistingEntityException("Motivodesoneracao " + motivodesoneracao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Motivodesoneracao motivodesoneracao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Motivodesoneracao persistentMotivodesoneracao = em.find(Motivodesoneracao.class, motivodesoneracao.getCodigomotivo());
            Collection<Calculoicmsestado> calculoicmsestadoCollectionOld = persistentMotivodesoneracao.getCalculoicmsestadoCollection();
            Collection<Calculoicmsestado> calculoicmsestadoCollectionNew = motivodesoneracao.getCalculoicmsestadoCollection();
            Collection<Calculoicmsestado> calculoicmsestadoCollection1Old = persistentMotivodesoneracao.getCalculoicmsestadoCollection1();
            Collection<Calculoicmsestado> calculoicmsestadoCollection1New = motivodesoneracao.getCalculoicmsestadoCollection1();
            Collection<Calculoicmsestado> attachedCalculoicmsestadoCollectionNew = new ArrayList<Calculoicmsestado>();
            for (Calculoicmsestado calculoicmsestadoCollectionNewCalculoicmsestadoToAttach : calculoicmsestadoCollectionNew) {
                calculoicmsestadoCollectionNewCalculoicmsestadoToAttach = em.getReference(calculoicmsestadoCollectionNewCalculoicmsestadoToAttach.getClass(), calculoicmsestadoCollectionNewCalculoicmsestadoToAttach.getCodcalculoicmsestado());
                attachedCalculoicmsestadoCollectionNew.add(calculoicmsestadoCollectionNewCalculoicmsestadoToAttach);
            }
            calculoicmsestadoCollectionNew = attachedCalculoicmsestadoCollectionNew;
            motivodesoneracao.setCalculoicmsestadoCollection(calculoicmsestadoCollectionNew);
            Collection<Calculoicmsestado> attachedCalculoicmsestadoCollection1New = new ArrayList<Calculoicmsestado>();
            for (Calculoicmsestado calculoicmsestadoCollection1NewCalculoicmsestadoToAttach : calculoicmsestadoCollection1New) {
                calculoicmsestadoCollection1NewCalculoicmsestadoToAttach = em.getReference(calculoicmsestadoCollection1NewCalculoicmsestadoToAttach.getClass(), calculoicmsestadoCollection1NewCalculoicmsestadoToAttach.getCodcalculoicmsestado());
                attachedCalculoicmsestadoCollection1New.add(calculoicmsestadoCollection1NewCalculoicmsestadoToAttach);
            }
            calculoicmsestadoCollection1New = attachedCalculoicmsestadoCollection1New;
            motivodesoneracao.setCalculoicmsestadoCollection1(calculoicmsestadoCollection1New);
            motivodesoneracao = em.merge(motivodesoneracao);
            for (Calculoicmsestado calculoicmsestadoCollectionOldCalculoicmsestado : calculoicmsestadoCollectionOld) {
                if (!calculoicmsestadoCollectionNew.contains(calculoicmsestadoCollectionOldCalculoicmsestado)) {
                    calculoicmsestadoCollectionOldCalculoicmsestado.setCodigomotivodeso(null);
                    calculoicmsestadoCollectionOldCalculoicmsestado = em.merge(calculoicmsestadoCollectionOldCalculoicmsestado);
                }
            }
            for (Calculoicmsestado calculoicmsestadoCollectionNewCalculoicmsestado : calculoicmsestadoCollectionNew) {
                if (!calculoicmsestadoCollectionOld.contains(calculoicmsestadoCollectionNewCalculoicmsestado)) {
                    Motivodesoneracao oldCodigomotivodesoOfCalculoicmsestadoCollectionNewCalculoicmsestado = calculoicmsestadoCollectionNewCalculoicmsestado.getCodigomotivodeso();
                    calculoicmsestadoCollectionNewCalculoicmsestado.setCodigomotivodeso(motivodesoneracao);
                    calculoicmsestadoCollectionNewCalculoicmsestado = em.merge(calculoicmsestadoCollectionNewCalculoicmsestado);
                    if (oldCodigomotivodesoOfCalculoicmsestadoCollectionNewCalculoicmsestado != null && !oldCodigomotivodesoOfCalculoicmsestadoCollectionNewCalculoicmsestado.equals(motivodesoneracao)) {
                        oldCodigomotivodesoOfCalculoicmsestadoCollectionNewCalculoicmsestado.getCalculoicmsestadoCollection().remove(calculoicmsestadoCollectionNewCalculoicmsestado);
                        oldCodigomotivodesoOfCalculoicmsestadoCollectionNewCalculoicmsestado = em.merge(oldCodigomotivodesoOfCalculoicmsestadoCollectionNewCalculoicmsestado);
                    }
                }
            }
            for (Calculoicmsestado calculoicmsestadoCollection1OldCalculoicmsestado : calculoicmsestadoCollection1Old) {
                if (!calculoicmsestadoCollection1New.contains(calculoicmsestadoCollection1OldCalculoicmsestado)) {
                    calculoicmsestadoCollection1OldCalculoicmsestado.setCodigomotivodesodif(null);
                    calculoicmsestadoCollection1OldCalculoicmsestado = em.merge(calculoicmsestadoCollection1OldCalculoicmsestado);
                }
            }
            for (Calculoicmsestado calculoicmsestadoCollection1NewCalculoicmsestado : calculoicmsestadoCollection1New) {
                if (!calculoicmsestadoCollection1Old.contains(calculoicmsestadoCollection1NewCalculoicmsestado)) {
                    Motivodesoneracao oldCodigomotivodesodifOfCalculoicmsestadoCollection1NewCalculoicmsestado = calculoicmsestadoCollection1NewCalculoicmsestado.getCodigomotivodesodif();
                    calculoicmsestadoCollection1NewCalculoicmsestado.setCodigomotivodesodif(motivodesoneracao);
                    calculoicmsestadoCollection1NewCalculoicmsestado = em.merge(calculoicmsestadoCollection1NewCalculoicmsestado);
                    if (oldCodigomotivodesodifOfCalculoicmsestadoCollection1NewCalculoicmsestado != null && !oldCodigomotivodesodifOfCalculoicmsestadoCollection1NewCalculoicmsestado.equals(motivodesoneracao)) {
                        oldCodigomotivodesodifOfCalculoicmsestadoCollection1NewCalculoicmsestado.getCalculoicmsestadoCollection1().remove(calculoicmsestadoCollection1NewCalculoicmsestado);
                        oldCodigomotivodesodifOfCalculoicmsestadoCollection1NewCalculoicmsestado = em.merge(oldCodigomotivodesodifOfCalculoicmsestadoCollection1NewCalculoicmsestado);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = motivodesoneracao.getCodigomotivo();
                if (findMotivodesoneracao(id) == null) {
                    throw new NonexistentEntityException("The motivodesoneracao with id " + id + " no longer exists.");
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
            Motivodesoneracao motivodesoneracao;
            try {
                motivodesoneracao = em.getReference(Motivodesoneracao.class, id);
                motivodesoneracao.getCodigomotivo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The motivodesoneracao with id " + id + " no longer exists.", enfe);
            }
            Collection<Calculoicmsestado> calculoicmsestadoCollection = motivodesoneracao.getCalculoicmsestadoCollection();
            for (Calculoicmsestado calculoicmsestadoCollectionCalculoicmsestado : calculoicmsestadoCollection) {
                calculoicmsestadoCollectionCalculoicmsestado.setCodigomotivodeso(null);
                calculoicmsestadoCollectionCalculoicmsestado = em.merge(calculoicmsestadoCollectionCalculoicmsestado);
            }
            Collection<Calculoicmsestado> calculoicmsestadoCollection1 = motivodesoneracao.getCalculoicmsestadoCollection1();
            for (Calculoicmsestado calculoicmsestadoCollection1Calculoicmsestado : calculoicmsestadoCollection1) {
                calculoicmsestadoCollection1Calculoicmsestado.setCodigomotivodesodif(null);
                calculoicmsestadoCollection1Calculoicmsestado = em.merge(calculoicmsestadoCollection1Calculoicmsestado);
            }
            em.remove(motivodesoneracao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Motivodesoneracao> findMotivodesoneracaoEntities() {
        return findMotivodesoneracaoEntities(true, -1, -1);
    }

    public List<Motivodesoneracao> findMotivodesoneracaoEntities(int maxResults, int firstResult) {
        return findMotivodesoneracaoEntities(false, maxResults, firstResult);
    }

    private List<Motivodesoneracao> findMotivodesoneracaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Motivodesoneracao.class));
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

    public Motivodesoneracao findMotivodesoneracao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Motivodesoneracao.class, id);
        } finally {
            em.close();
        }
    }

    public int getMotivodesoneracaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Motivodesoneracao> rt = cq.from(Motivodesoneracao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

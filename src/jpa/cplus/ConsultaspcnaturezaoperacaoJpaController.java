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
import entidade.cplus.Consultaspc;
import entidade.cplus.Consultaspcnaturezaoperacao;
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
public class ConsultaspcnaturezaoperacaoJpaController implements Serializable {

    public ConsultaspcnaturezaoperacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Consultaspcnaturezaoperacao consultaspcnaturezaoperacao) throws PreexistingEntityException, Exception {
        if (consultaspcnaturezaoperacao.getConsultaspcCollection() == null) {
            consultaspcnaturezaoperacao.setConsultaspcCollection(new ArrayList<Consultaspc>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Consultaspc> attachedConsultaspcCollection = new ArrayList<Consultaspc>();
            for (Consultaspc consultaspcCollectionConsultaspcToAttach : consultaspcnaturezaoperacao.getConsultaspcCollection()) {
                consultaspcCollectionConsultaspcToAttach = em.getReference(consultaspcCollectionConsultaspcToAttach.getClass(), consultaspcCollectionConsultaspcToAttach.getCodconsultaspc());
                attachedConsultaspcCollection.add(consultaspcCollectionConsultaspcToAttach);
            }
            consultaspcnaturezaoperacao.setConsultaspcCollection(attachedConsultaspcCollection);
            em.persist(consultaspcnaturezaoperacao);
            for (Consultaspc consultaspcCollectionConsultaspc : consultaspcnaturezaoperacao.getConsultaspcCollection()) {
                Consultaspcnaturezaoperacao oldCodconsspcnaturezaopOfConsultaspcCollectionConsultaspc = consultaspcCollectionConsultaspc.getCodconsspcnaturezaop();
                consultaspcCollectionConsultaspc.setCodconsspcnaturezaop(consultaspcnaturezaoperacao);
                consultaspcCollectionConsultaspc = em.merge(consultaspcCollectionConsultaspc);
                if (oldCodconsspcnaturezaopOfConsultaspcCollectionConsultaspc != null) {
                    oldCodconsspcnaturezaopOfConsultaspcCollectionConsultaspc.getConsultaspcCollection().remove(consultaspcCollectionConsultaspc);
                    oldCodconsspcnaturezaopOfConsultaspcCollectionConsultaspc = em.merge(oldCodconsspcnaturezaopOfConsultaspcCollectionConsultaspc);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findConsultaspcnaturezaoperacao(consultaspcnaturezaoperacao.getCodconsspcnaturezaop()) != null) {
                throw new PreexistingEntityException("Consultaspcnaturezaoperacao " + consultaspcnaturezaoperacao + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Consultaspcnaturezaoperacao consultaspcnaturezaoperacao) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Consultaspcnaturezaoperacao persistentConsultaspcnaturezaoperacao = em.find(Consultaspcnaturezaoperacao.class, consultaspcnaturezaoperacao.getCodconsspcnaturezaop());
            Collection<Consultaspc> consultaspcCollectionOld = persistentConsultaspcnaturezaoperacao.getConsultaspcCollection();
            Collection<Consultaspc> consultaspcCollectionNew = consultaspcnaturezaoperacao.getConsultaspcCollection();
            Collection<Consultaspc> attachedConsultaspcCollectionNew = new ArrayList<Consultaspc>();
            for (Consultaspc consultaspcCollectionNewConsultaspcToAttach : consultaspcCollectionNew) {
                consultaspcCollectionNewConsultaspcToAttach = em.getReference(consultaspcCollectionNewConsultaspcToAttach.getClass(), consultaspcCollectionNewConsultaspcToAttach.getCodconsultaspc());
                attachedConsultaspcCollectionNew.add(consultaspcCollectionNewConsultaspcToAttach);
            }
            consultaspcCollectionNew = attachedConsultaspcCollectionNew;
            consultaspcnaturezaoperacao.setConsultaspcCollection(consultaspcCollectionNew);
            consultaspcnaturezaoperacao = em.merge(consultaspcnaturezaoperacao);
            for (Consultaspc consultaspcCollectionOldConsultaspc : consultaspcCollectionOld) {
                if (!consultaspcCollectionNew.contains(consultaspcCollectionOldConsultaspc)) {
                    consultaspcCollectionOldConsultaspc.setCodconsspcnaturezaop(null);
                    consultaspcCollectionOldConsultaspc = em.merge(consultaspcCollectionOldConsultaspc);
                }
            }
            for (Consultaspc consultaspcCollectionNewConsultaspc : consultaspcCollectionNew) {
                if (!consultaspcCollectionOld.contains(consultaspcCollectionNewConsultaspc)) {
                    Consultaspcnaturezaoperacao oldCodconsspcnaturezaopOfConsultaspcCollectionNewConsultaspc = consultaspcCollectionNewConsultaspc.getCodconsspcnaturezaop();
                    consultaspcCollectionNewConsultaspc.setCodconsspcnaturezaop(consultaspcnaturezaoperacao);
                    consultaspcCollectionNewConsultaspc = em.merge(consultaspcCollectionNewConsultaspc);
                    if (oldCodconsspcnaturezaopOfConsultaspcCollectionNewConsultaspc != null && !oldCodconsspcnaturezaopOfConsultaspcCollectionNewConsultaspc.equals(consultaspcnaturezaoperacao)) {
                        oldCodconsspcnaturezaopOfConsultaspcCollectionNewConsultaspc.getConsultaspcCollection().remove(consultaspcCollectionNewConsultaspc);
                        oldCodconsspcnaturezaopOfConsultaspcCollectionNewConsultaspc = em.merge(oldCodconsspcnaturezaopOfConsultaspcCollectionNewConsultaspc);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = consultaspcnaturezaoperacao.getCodconsspcnaturezaop();
                if (findConsultaspcnaturezaoperacao(id) == null) {
                    throw new NonexistentEntityException("The consultaspcnaturezaoperacao with id " + id + " no longer exists.");
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
            Consultaspcnaturezaoperacao consultaspcnaturezaoperacao;
            try {
                consultaspcnaturezaoperacao = em.getReference(Consultaspcnaturezaoperacao.class, id);
                consultaspcnaturezaoperacao.getCodconsspcnaturezaop();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The consultaspcnaturezaoperacao with id " + id + " no longer exists.", enfe);
            }
            Collection<Consultaspc> consultaspcCollection = consultaspcnaturezaoperacao.getConsultaspcCollection();
            for (Consultaspc consultaspcCollectionConsultaspc : consultaspcCollection) {
                consultaspcCollectionConsultaspc.setCodconsspcnaturezaop(null);
                consultaspcCollectionConsultaspc = em.merge(consultaspcCollectionConsultaspc);
            }
            em.remove(consultaspcnaturezaoperacao);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Consultaspcnaturezaoperacao> findConsultaspcnaturezaoperacaoEntities() {
        return findConsultaspcnaturezaoperacaoEntities(true, -1, -1);
    }

    public List<Consultaspcnaturezaoperacao> findConsultaspcnaturezaoperacaoEntities(int maxResults, int firstResult) {
        return findConsultaspcnaturezaoperacaoEntities(false, maxResults, firstResult);
    }

    private List<Consultaspcnaturezaoperacao> findConsultaspcnaturezaoperacaoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Consultaspcnaturezaoperacao.class));
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

    public Consultaspcnaturezaoperacao findConsultaspcnaturezaoperacao(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Consultaspcnaturezaoperacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getConsultaspcnaturezaoperacaoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Consultaspcnaturezaoperacao> rt = cq.from(Consultaspcnaturezaoperacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

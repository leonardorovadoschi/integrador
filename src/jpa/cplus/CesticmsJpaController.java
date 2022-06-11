/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Cesticms;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Classificacaofiscal;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Cesticmsclassificacaofiscal;
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
public class CesticmsJpaController implements Serializable {

    public CesticmsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cesticms cesticms) throws PreexistingEntityException, Exception {
        if (cesticms.getClassificacaofiscalCollection() == null) {
            cesticms.setClassificacaofiscalCollection(new ArrayList<Classificacaofiscal>());
        }
        if (cesticms.getCesticmsclassificacaofiscalCollection() == null) {
            cesticms.setCesticmsclassificacaofiscalCollection(new ArrayList<Cesticmsclassificacaofiscal>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Classificacaofiscal> attachedClassificacaofiscalCollection = new ArrayList<Classificacaofiscal>();
            for (Classificacaofiscal classificacaofiscalCollectionClassificacaofiscalToAttach : cesticms.getClassificacaofiscalCollection()) {
                classificacaofiscalCollectionClassificacaofiscalToAttach = em.getReference(classificacaofiscalCollectionClassificacaofiscalToAttach.getClass(), classificacaofiscalCollectionClassificacaofiscalToAttach.getCodclassificacaofiscal());
                attachedClassificacaofiscalCollection.add(classificacaofiscalCollectionClassificacaofiscalToAttach);
            }
            cesticms.setClassificacaofiscalCollection(attachedClassificacaofiscalCollection);
            Collection<Cesticmsclassificacaofiscal> attachedCesticmsclassificacaofiscalCollection = new ArrayList<Cesticmsclassificacaofiscal>();
            for (Cesticmsclassificacaofiscal cesticmsclassificacaofiscalCollectionCesticmsclassificacaofiscalToAttach : cesticms.getCesticmsclassificacaofiscalCollection()) {
                cesticmsclassificacaofiscalCollectionCesticmsclassificacaofiscalToAttach = em.getReference(cesticmsclassificacaofiscalCollectionCesticmsclassificacaofiscalToAttach.getClass(), cesticmsclassificacaofiscalCollectionCesticmsclassificacaofiscalToAttach.getCesticmsclassificacaofiscalPK());
                attachedCesticmsclassificacaofiscalCollection.add(cesticmsclassificacaofiscalCollectionCesticmsclassificacaofiscalToAttach);
            }
            cesticms.setCesticmsclassificacaofiscalCollection(attachedCesticmsclassificacaofiscalCollection);
            em.persist(cesticms);
            for (Classificacaofiscal classificacaofiscalCollectionClassificacaofiscal : cesticms.getClassificacaofiscalCollection()) {
                Cesticms oldCodcesticmsOfClassificacaofiscalCollectionClassificacaofiscal = classificacaofiscalCollectionClassificacaofiscal.getCodcesticms();
                classificacaofiscalCollectionClassificacaofiscal.setCodcesticms(cesticms);
                classificacaofiscalCollectionClassificacaofiscal = em.merge(classificacaofiscalCollectionClassificacaofiscal);
                if (oldCodcesticmsOfClassificacaofiscalCollectionClassificacaofiscal != null) {
                    oldCodcesticmsOfClassificacaofiscalCollectionClassificacaofiscal.getClassificacaofiscalCollection().remove(classificacaofiscalCollectionClassificacaofiscal);
                    oldCodcesticmsOfClassificacaofiscalCollectionClassificacaofiscal = em.merge(oldCodcesticmsOfClassificacaofiscalCollectionClassificacaofiscal);
                }
            }
            for (Cesticmsclassificacaofiscal cesticmsclassificacaofiscalCollectionCesticmsclassificacaofiscal : cesticms.getCesticmsclassificacaofiscalCollection()) {
                Cesticms oldCesticmsOfCesticmsclassificacaofiscalCollectionCesticmsclassificacaofiscal = cesticmsclassificacaofiscalCollectionCesticmsclassificacaofiscal.getCesticms();
                cesticmsclassificacaofiscalCollectionCesticmsclassificacaofiscal.setCesticms(cesticms);
                cesticmsclassificacaofiscalCollectionCesticmsclassificacaofiscal = em.merge(cesticmsclassificacaofiscalCollectionCesticmsclassificacaofiscal);
                if (oldCesticmsOfCesticmsclassificacaofiscalCollectionCesticmsclassificacaofiscal != null) {
                    oldCesticmsOfCesticmsclassificacaofiscalCollectionCesticmsclassificacaofiscal.getCesticmsclassificacaofiscalCollection().remove(cesticmsclassificacaofiscalCollectionCesticmsclassificacaofiscal);
                    oldCesticmsOfCesticmsclassificacaofiscalCollectionCesticmsclassificacaofiscal = em.merge(oldCesticmsOfCesticmsclassificacaofiscalCollectionCesticmsclassificacaofiscal);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCesticms(cesticms.getCodcesticms()) != null) {
                throw new PreexistingEntityException("Cesticms " + cesticms + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cesticms cesticms) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cesticms persistentCesticms = em.find(Cesticms.class, cesticms.getCodcesticms());
            Collection<Classificacaofiscal> classificacaofiscalCollectionOld = persistentCesticms.getClassificacaofiscalCollection();
            Collection<Classificacaofiscal> classificacaofiscalCollectionNew = cesticms.getClassificacaofiscalCollection();
            Collection<Cesticmsclassificacaofiscal> cesticmsclassificacaofiscalCollectionOld = persistentCesticms.getCesticmsclassificacaofiscalCollection();
            Collection<Cesticmsclassificacaofiscal> cesticmsclassificacaofiscalCollectionNew = cesticms.getCesticmsclassificacaofiscalCollection();
            List<String> illegalOrphanMessages = null;
            for (Cesticmsclassificacaofiscal cesticmsclassificacaofiscalCollectionOldCesticmsclassificacaofiscal : cesticmsclassificacaofiscalCollectionOld) {
                if (!cesticmsclassificacaofiscalCollectionNew.contains(cesticmsclassificacaofiscalCollectionOldCesticmsclassificacaofiscal)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cesticmsclassificacaofiscal " + cesticmsclassificacaofiscalCollectionOldCesticmsclassificacaofiscal + " since its cesticms field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Classificacaofiscal> attachedClassificacaofiscalCollectionNew = new ArrayList<Classificacaofiscal>();
            for (Classificacaofiscal classificacaofiscalCollectionNewClassificacaofiscalToAttach : classificacaofiscalCollectionNew) {
                classificacaofiscalCollectionNewClassificacaofiscalToAttach = em.getReference(classificacaofiscalCollectionNewClassificacaofiscalToAttach.getClass(), classificacaofiscalCollectionNewClassificacaofiscalToAttach.getCodclassificacaofiscal());
                attachedClassificacaofiscalCollectionNew.add(classificacaofiscalCollectionNewClassificacaofiscalToAttach);
            }
            classificacaofiscalCollectionNew = attachedClassificacaofiscalCollectionNew;
            cesticms.setClassificacaofiscalCollection(classificacaofiscalCollectionNew);
            Collection<Cesticmsclassificacaofiscal> attachedCesticmsclassificacaofiscalCollectionNew = new ArrayList<Cesticmsclassificacaofiscal>();
            for (Cesticmsclassificacaofiscal cesticmsclassificacaofiscalCollectionNewCesticmsclassificacaofiscalToAttach : cesticmsclassificacaofiscalCollectionNew) {
                cesticmsclassificacaofiscalCollectionNewCesticmsclassificacaofiscalToAttach = em.getReference(cesticmsclassificacaofiscalCollectionNewCesticmsclassificacaofiscalToAttach.getClass(), cesticmsclassificacaofiscalCollectionNewCesticmsclassificacaofiscalToAttach.getCesticmsclassificacaofiscalPK());
                attachedCesticmsclassificacaofiscalCollectionNew.add(cesticmsclassificacaofiscalCollectionNewCesticmsclassificacaofiscalToAttach);
            }
            cesticmsclassificacaofiscalCollectionNew = attachedCesticmsclassificacaofiscalCollectionNew;
            cesticms.setCesticmsclassificacaofiscalCollection(cesticmsclassificacaofiscalCollectionNew);
            cesticms = em.merge(cesticms);
            for (Classificacaofiscal classificacaofiscalCollectionOldClassificacaofiscal : classificacaofiscalCollectionOld) {
                if (!classificacaofiscalCollectionNew.contains(classificacaofiscalCollectionOldClassificacaofiscal)) {
                    classificacaofiscalCollectionOldClassificacaofiscal.setCodcesticms(null);
                    classificacaofiscalCollectionOldClassificacaofiscal = em.merge(classificacaofiscalCollectionOldClassificacaofiscal);
                }
            }
            for (Classificacaofiscal classificacaofiscalCollectionNewClassificacaofiscal : classificacaofiscalCollectionNew) {
                if (!classificacaofiscalCollectionOld.contains(classificacaofiscalCollectionNewClassificacaofiscal)) {
                    Cesticms oldCodcesticmsOfClassificacaofiscalCollectionNewClassificacaofiscal = classificacaofiscalCollectionNewClassificacaofiscal.getCodcesticms();
                    classificacaofiscalCollectionNewClassificacaofiscal.setCodcesticms(cesticms);
                    classificacaofiscalCollectionNewClassificacaofiscal = em.merge(classificacaofiscalCollectionNewClassificacaofiscal);
                    if (oldCodcesticmsOfClassificacaofiscalCollectionNewClassificacaofiscal != null && !oldCodcesticmsOfClassificacaofiscalCollectionNewClassificacaofiscal.equals(cesticms)) {
                        oldCodcesticmsOfClassificacaofiscalCollectionNewClassificacaofiscal.getClassificacaofiscalCollection().remove(classificacaofiscalCollectionNewClassificacaofiscal);
                        oldCodcesticmsOfClassificacaofiscalCollectionNewClassificacaofiscal = em.merge(oldCodcesticmsOfClassificacaofiscalCollectionNewClassificacaofiscal);
                    }
                }
            }
            for (Cesticmsclassificacaofiscal cesticmsclassificacaofiscalCollectionNewCesticmsclassificacaofiscal : cesticmsclassificacaofiscalCollectionNew) {
                if (!cesticmsclassificacaofiscalCollectionOld.contains(cesticmsclassificacaofiscalCollectionNewCesticmsclassificacaofiscal)) {
                    Cesticms oldCesticmsOfCesticmsclassificacaofiscalCollectionNewCesticmsclassificacaofiscal = cesticmsclassificacaofiscalCollectionNewCesticmsclassificacaofiscal.getCesticms();
                    cesticmsclassificacaofiscalCollectionNewCesticmsclassificacaofiscal.setCesticms(cesticms);
                    cesticmsclassificacaofiscalCollectionNewCesticmsclassificacaofiscal = em.merge(cesticmsclassificacaofiscalCollectionNewCesticmsclassificacaofiscal);
                    if (oldCesticmsOfCesticmsclassificacaofiscalCollectionNewCesticmsclassificacaofiscal != null && !oldCesticmsOfCesticmsclassificacaofiscalCollectionNewCesticmsclassificacaofiscal.equals(cesticms)) {
                        oldCesticmsOfCesticmsclassificacaofiscalCollectionNewCesticmsclassificacaofiscal.getCesticmsclassificacaofiscalCollection().remove(cesticmsclassificacaofiscalCollectionNewCesticmsclassificacaofiscal);
                        oldCesticmsOfCesticmsclassificacaofiscalCollectionNewCesticmsclassificacaofiscal = em.merge(oldCesticmsOfCesticmsclassificacaofiscalCollectionNewCesticmsclassificacaofiscal);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cesticms.getCodcesticms();
                if (findCesticms(id) == null) {
                    throw new NonexistentEntityException("The cesticms with id " + id + " no longer exists.");
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
            Cesticms cesticms;
            try {
                cesticms = em.getReference(Cesticms.class, id);
                cesticms.getCodcesticms();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cesticms with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Cesticmsclassificacaofiscal> cesticmsclassificacaofiscalCollectionOrphanCheck = cesticms.getCesticmsclassificacaofiscalCollection();
            for (Cesticmsclassificacaofiscal cesticmsclassificacaofiscalCollectionOrphanCheckCesticmsclassificacaofiscal : cesticmsclassificacaofiscalCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cesticms (" + cesticms + ") cannot be destroyed since the Cesticmsclassificacaofiscal " + cesticmsclassificacaofiscalCollectionOrphanCheckCesticmsclassificacaofiscal + " in its cesticmsclassificacaofiscalCollection field has a non-nullable cesticms field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Classificacaofiscal> classificacaofiscalCollection = cesticms.getClassificacaofiscalCollection();
            for (Classificacaofiscal classificacaofiscalCollectionClassificacaofiscal : classificacaofiscalCollection) {
                classificacaofiscalCollectionClassificacaofiscal.setCodcesticms(null);
                classificacaofiscalCollectionClassificacaofiscal = em.merge(classificacaofiscalCollectionClassificacaofiscal);
            }
            em.remove(cesticms);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cesticms> findCesticmsEntities() {
        return findCesticmsEntities(true, -1, -1);
    }

    public List<Cesticms> findCesticmsEntities(int maxResults, int firstResult) {
        return findCesticmsEntities(false, maxResults, firstResult);
    }

    private List<Cesticms> findCesticmsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cesticms.class));
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

    public Cesticms findCesticms(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cesticms.class, id);
        } finally {
            em.close();
        }
    }

    public int getCesticmsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cesticms> rt = cq.from(Cesticms.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

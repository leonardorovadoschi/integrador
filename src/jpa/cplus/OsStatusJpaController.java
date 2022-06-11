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
import entidade.cplus.OsLaudo;
import entidade.cplus.OsStatus;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.OsStatushistorico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class OsStatusJpaController implements Serializable {

    public OsStatusJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OsStatus osStatus) throws PreexistingEntityException, Exception {
        if (osStatus.getOsLaudoCollection() == null) {
            osStatus.setOsLaudoCollection(new ArrayList<OsLaudo>());
        }
        if (osStatus.getOsStatushistoricoCollection() == null) {
            osStatus.setOsStatushistoricoCollection(new ArrayList<OsStatushistorico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<OsLaudo> attachedOsLaudoCollection = new ArrayList<OsLaudo>();
            for (OsLaudo osLaudoCollectionOsLaudoToAttach : osStatus.getOsLaudoCollection()) {
                osLaudoCollectionOsLaudoToAttach = em.getReference(osLaudoCollectionOsLaudoToAttach.getClass(), osLaudoCollectionOsLaudoToAttach.getCodlaudo());
                attachedOsLaudoCollection.add(osLaudoCollectionOsLaudoToAttach);
            }
            osStatus.setOsLaudoCollection(attachedOsLaudoCollection);
            Collection<OsStatushistorico> attachedOsStatushistoricoCollection = new ArrayList<OsStatushistorico>();
            for (OsStatushistorico osStatushistoricoCollectionOsStatushistoricoToAttach : osStatus.getOsStatushistoricoCollection()) {
                osStatushistoricoCollectionOsStatushistoricoToAttach = em.getReference(osStatushistoricoCollectionOsStatushistoricoToAttach.getClass(), osStatushistoricoCollectionOsStatushistoricoToAttach.getCodstatushistorico());
                attachedOsStatushistoricoCollection.add(osStatushistoricoCollectionOsStatushistoricoToAttach);
            }
            osStatus.setOsStatushistoricoCollection(attachedOsStatushistoricoCollection);
            em.persist(osStatus);
            for (OsLaudo osLaudoCollectionOsLaudo : osStatus.getOsLaudoCollection()) {
                OsStatus oldCodstatusOfOsLaudoCollectionOsLaudo = osLaudoCollectionOsLaudo.getCodstatus();
                osLaudoCollectionOsLaudo.setCodstatus(osStatus);
                osLaudoCollectionOsLaudo = em.merge(osLaudoCollectionOsLaudo);
                if (oldCodstatusOfOsLaudoCollectionOsLaudo != null) {
                    oldCodstatusOfOsLaudoCollectionOsLaudo.getOsLaudoCollection().remove(osLaudoCollectionOsLaudo);
                    oldCodstatusOfOsLaudoCollectionOsLaudo = em.merge(oldCodstatusOfOsLaudoCollectionOsLaudo);
                }
            }
            for (OsStatushistorico osStatushistoricoCollectionOsStatushistorico : osStatus.getOsStatushistoricoCollection()) {
                OsStatus oldCodstatusOfOsStatushistoricoCollectionOsStatushistorico = osStatushistoricoCollectionOsStatushistorico.getCodstatus();
                osStatushistoricoCollectionOsStatushistorico.setCodstatus(osStatus);
                osStatushistoricoCollectionOsStatushistorico = em.merge(osStatushistoricoCollectionOsStatushistorico);
                if (oldCodstatusOfOsStatushistoricoCollectionOsStatushistorico != null) {
                    oldCodstatusOfOsStatushistoricoCollectionOsStatushistorico.getOsStatushistoricoCollection().remove(osStatushistoricoCollectionOsStatushistorico);
                    oldCodstatusOfOsStatushistoricoCollectionOsStatushistorico = em.merge(oldCodstatusOfOsStatushistoricoCollectionOsStatushistorico);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOsStatus(osStatus.getCodstatus()) != null) {
                throw new PreexistingEntityException("OsStatus " + osStatus + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OsStatus osStatus) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsStatus persistentOsStatus = em.find(OsStatus.class, osStatus.getCodstatus());
            Collection<OsLaudo> osLaudoCollectionOld = persistentOsStatus.getOsLaudoCollection();
            Collection<OsLaudo> osLaudoCollectionNew = osStatus.getOsLaudoCollection();
            Collection<OsStatushistorico> osStatushistoricoCollectionOld = persistentOsStatus.getOsStatushistoricoCollection();
            Collection<OsStatushistorico> osStatushistoricoCollectionNew = osStatus.getOsStatushistoricoCollection();
            Collection<OsLaudo> attachedOsLaudoCollectionNew = new ArrayList<OsLaudo>();
            for (OsLaudo osLaudoCollectionNewOsLaudoToAttach : osLaudoCollectionNew) {
                osLaudoCollectionNewOsLaudoToAttach = em.getReference(osLaudoCollectionNewOsLaudoToAttach.getClass(), osLaudoCollectionNewOsLaudoToAttach.getCodlaudo());
                attachedOsLaudoCollectionNew.add(osLaudoCollectionNewOsLaudoToAttach);
            }
            osLaudoCollectionNew = attachedOsLaudoCollectionNew;
            osStatus.setOsLaudoCollection(osLaudoCollectionNew);
            Collection<OsStatushistorico> attachedOsStatushistoricoCollectionNew = new ArrayList<OsStatushistorico>();
            for (OsStatushistorico osStatushistoricoCollectionNewOsStatushistoricoToAttach : osStatushistoricoCollectionNew) {
                osStatushistoricoCollectionNewOsStatushistoricoToAttach = em.getReference(osStatushistoricoCollectionNewOsStatushistoricoToAttach.getClass(), osStatushistoricoCollectionNewOsStatushistoricoToAttach.getCodstatushistorico());
                attachedOsStatushistoricoCollectionNew.add(osStatushistoricoCollectionNewOsStatushistoricoToAttach);
            }
            osStatushistoricoCollectionNew = attachedOsStatushistoricoCollectionNew;
            osStatus.setOsStatushistoricoCollection(osStatushistoricoCollectionNew);
            osStatus = em.merge(osStatus);
            for (OsLaudo osLaudoCollectionOldOsLaudo : osLaudoCollectionOld) {
                if (!osLaudoCollectionNew.contains(osLaudoCollectionOldOsLaudo)) {
                    osLaudoCollectionOldOsLaudo.setCodstatus(null);
                    osLaudoCollectionOldOsLaudo = em.merge(osLaudoCollectionOldOsLaudo);
                }
            }
            for (OsLaudo osLaudoCollectionNewOsLaudo : osLaudoCollectionNew) {
                if (!osLaudoCollectionOld.contains(osLaudoCollectionNewOsLaudo)) {
                    OsStatus oldCodstatusOfOsLaudoCollectionNewOsLaudo = osLaudoCollectionNewOsLaudo.getCodstatus();
                    osLaudoCollectionNewOsLaudo.setCodstatus(osStatus);
                    osLaudoCollectionNewOsLaudo = em.merge(osLaudoCollectionNewOsLaudo);
                    if (oldCodstatusOfOsLaudoCollectionNewOsLaudo != null && !oldCodstatusOfOsLaudoCollectionNewOsLaudo.equals(osStatus)) {
                        oldCodstatusOfOsLaudoCollectionNewOsLaudo.getOsLaudoCollection().remove(osLaudoCollectionNewOsLaudo);
                        oldCodstatusOfOsLaudoCollectionNewOsLaudo = em.merge(oldCodstatusOfOsLaudoCollectionNewOsLaudo);
                    }
                }
            }
            for (OsStatushistorico osStatushistoricoCollectionOldOsStatushistorico : osStatushistoricoCollectionOld) {
                if (!osStatushistoricoCollectionNew.contains(osStatushistoricoCollectionOldOsStatushistorico)) {
                    osStatushistoricoCollectionOldOsStatushistorico.setCodstatus(null);
                    osStatushistoricoCollectionOldOsStatushistorico = em.merge(osStatushistoricoCollectionOldOsStatushistorico);
                }
            }
            for (OsStatushistorico osStatushistoricoCollectionNewOsStatushistorico : osStatushistoricoCollectionNew) {
                if (!osStatushistoricoCollectionOld.contains(osStatushistoricoCollectionNewOsStatushistorico)) {
                    OsStatus oldCodstatusOfOsStatushistoricoCollectionNewOsStatushistorico = osStatushistoricoCollectionNewOsStatushistorico.getCodstatus();
                    osStatushistoricoCollectionNewOsStatushistorico.setCodstatus(osStatus);
                    osStatushistoricoCollectionNewOsStatushistorico = em.merge(osStatushistoricoCollectionNewOsStatushistorico);
                    if (oldCodstatusOfOsStatushistoricoCollectionNewOsStatushistorico != null && !oldCodstatusOfOsStatushistoricoCollectionNewOsStatushistorico.equals(osStatus)) {
                        oldCodstatusOfOsStatushistoricoCollectionNewOsStatushistorico.getOsStatushistoricoCollection().remove(osStatushistoricoCollectionNewOsStatushistorico);
                        oldCodstatusOfOsStatushistoricoCollectionNewOsStatushistorico = em.merge(oldCodstatusOfOsStatushistoricoCollectionNewOsStatushistorico);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = osStatus.getCodstatus();
                if (findOsStatus(id) == null) {
                    throw new NonexistentEntityException("The osStatus with id " + id + " no longer exists.");
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
            OsStatus osStatus;
            try {
                osStatus = em.getReference(OsStatus.class, id);
                osStatus.getCodstatus();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The osStatus with id " + id + " no longer exists.", enfe);
            }
            Collection<OsLaudo> osLaudoCollection = osStatus.getOsLaudoCollection();
            for (OsLaudo osLaudoCollectionOsLaudo : osLaudoCollection) {
                osLaudoCollectionOsLaudo.setCodstatus(null);
                osLaudoCollectionOsLaudo = em.merge(osLaudoCollectionOsLaudo);
            }
            Collection<OsStatushistorico> osStatushistoricoCollection = osStatus.getOsStatushistoricoCollection();
            for (OsStatushistorico osStatushistoricoCollectionOsStatushistorico : osStatushistoricoCollection) {
                osStatushistoricoCollectionOsStatushistorico.setCodstatus(null);
                osStatushistoricoCollectionOsStatushistorico = em.merge(osStatushistoricoCollectionOsStatushistorico);
            }
            em.remove(osStatus);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OsStatus> findOsStatusEntities() {
        return findOsStatusEntities(true, -1, -1);
    }

    public List<OsStatus> findOsStatusEntities(int maxResults, int firstResult) {
        return findOsStatusEntities(false, maxResults, firstResult);
    }

    private List<OsStatus> findOsStatusEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OsStatus.class));
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

    public OsStatus findOsStatus(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OsStatus.class, id);
        } finally {
            em.close();
        }
    }

    public int getOsStatusCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OsStatus> rt = cq.from(OsStatus.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

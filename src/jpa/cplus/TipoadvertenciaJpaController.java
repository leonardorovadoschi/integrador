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
import entidade.cplus.Advertencia;
import entidade.cplus.Tipoadvertencia;
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
public class TipoadvertenciaJpaController implements Serializable {

    public TipoadvertenciaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tipoadvertencia tipoadvertencia) throws PreexistingEntityException, Exception {
        if (tipoadvertencia.getAdvertenciaCollection() == null) {
            tipoadvertencia.setAdvertenciaCollection(new ArrayList<Advertencia>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Advertencia> attachedAdvertenciaCollection = new ArrayList<Advertencia>();
            for (Advertencia advertenciaCollectionAdvertenciaToAttach : tipoadvertencia.getAdvertenciaCollection()) {
                advertenciaCollectionAdvertenciaToAttach = em.getReference(advertenciaCollectionAdvertenciaToAttach.getClass(), advertenciaCollectionAdvertenciaToAttach.getCodadvertencia());
                attachedAdvertenciaCollection.add(advertenciaCollectionAdvertenciaToAttach);
            }
            tipoadvertencia.setAdvertenciaCollection(attachedAdvertenciaCollection);
            em.persist(tipoadvertencia);
            for (Advertencia advertenciaCollectionAdvertencia : tipoadvertencia.getAdvertenciaCollection()) {
                Tipoadvertencia oldCodtipoadvertenciaOfAdvertenciaCollectionAdvertencia = advertenciaCollectionAdvertencia.getCodtipoadvertencia();
                advertenciaCollectionAdvertencia.setCodtipoadvertencia(tipoadvertencia);
                advertenciaCollectionAdvertencia = em.merge(advertenciaCollectionAdvertencia);
                if (oldCodtipoadvertenciaOfAdvertenciaCollectionAdvertencia != null) {
                    oldCodtipoadvertenciaOfAdvertenciaCollectionAdvertencia.getAdvertenciaCollection().remove(advertenciaCollectionAdvertencia);
                    oldCodtipoadvertenciaOfAdvertenciaCollectionAdvertencia = em.merge(oldCodtipoadvertenciaOfAdvertenciaCollectionAdvertencia);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTipoadvertencia(tipoadvertencia.getCodtipoadvertencia()) != null) {
                throw new PreexistingEntityException("Tipoadvertencia " + tipoadvertencia + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tipoadvertencia tipoadvertencia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tipoadvertencia persistentTipoadvertencia = em.find(Tipoadvertencia.class, tipoadvertencia.getCodtipoadvertencia());
            Collection<Advertencia> advertenciaCollectionOld = persistentTipoadvertencia.getAdvertenciaCollection();
            Collection<Advertencia> advertenciaCollectionNew = tipoadvertencia.getAdvertenciaCollection();
            Collection<Advertencia> attachedAdvertenciaCollectionNew = new ArrayList<Advertencia>();
            for (Advertencia advertenciaCollectionNewAdvertenciaToAttach : advertenciaCollectionNew) {
                advertenciaCollectionNewAdvertenciaToAttach = em.getReference(advertenciaCollectionNewAdvertenciaToAttach.getClass(), advertenciaCollectionNewAdvertenciaToAttach.getCodadvertencia());
                attachedAdvertenciaCollectionNew.add(advertenciaCollectionNewAdvertenciaToAttach);
            }
            advertenciaCollectionNew = attachedAdvertenciaCollectionNew;
            tipoadvertencia.setAdvertenciaCollection(advertenciaCollectionNew);
            tipoadvertencia = em.merge(tipoadvertencia);
            for (Advertencia advertenciaCollectionOldAdvertencia : advertenciaCollectionOld) {
                if (!advertenciaCollectionNew.contains(advertenciaCollectionOldAdvertencia)) {
                    advertenciaCollectionOldAdvertencia.setCodtipoadvertencia(null);
                    advertenciaCollectionOldAdvertencia = em.merge(advertenciaCollectionOldAdvertencia);
                }
            }
            for (Advertencia advertenciaCollectionNewAdvertencia : advertenciaCollectionNew) {
                if (!advertenciaCollectionOld.contains(advertenciaCollectionNewAdvertencia)) {
                    Tipoadvertencia oldCodtipoadvertenciaOfAdvertenciaCollectionNewAdvertencia = advertenciaCollectionNewAdvertencia.getCodtipoadvertencia();
                    advertenciaCollectionNewAdvertencia.setCodtipoadvertencia(tipoadvertencia);
                    advertenciaCollectionNewAdvertencia = em.merge(advertenciaCollectionNewAdvertencia);
                    if (oldCodtipoadvertenciaOfAdvertenciaCollectionNewAdvertencia != null && !oldCodtipoadvertenciaOfAdvertenciaCollectionNewAdvertencia.equals(tipoadvertencia)) {
                        oldCodtipoadvertenciaOfAdvertenciaCollectionNewAdvertencia.getAdvertenciaCollection().remove(advertenciaCollectionNewAdvertencia);
                        oldCodtipoadvertenciaOfAdvertenciaCollectionNewAdvertencia = em.merge(oldCodtipoadvertenciaOfAdvertenciaCollectionNewAdvertencia);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tipoadvertencia.getCodtipoadvertencia();
                if (findTipoadvertencia(id) == null) {
                    throw new NonexistentEntityException("The tipoadvertencia with id " + id + " no longer exists.");
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
            Tipoadvertencia tipoadvertencia;
            try {
                tipoadvertencia = em.getReference(Tipoadvertencia.class, id);
                tipoadvertencia.getCodtipoadvertencia();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoadvertencia with id " + id + " no longer exists.", enfe);
            }
            Collection<Advertencia> advertenciaCollection = tipoadvertencia.getAdvertenciaCollection();
            for (Advertencia advertenciaCollectionAdvertencia : advertenciaCollection) {
                advertenciaCollectionAdvertencia.setCodtipoadvertencia(null);
                advertenciaCollectionAdvertencia = em.merge(advertenciaCollectionAdvertencia);
            }
            em.remove(tipoadvertencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tipoadvertencia> findTipoadvertenciaEntities() {
        return findTipoadvertenciaEntities(true, -1, -1);
    }

    public List<Tipoadvertencia> findTipoadvertenciaEntities(int maxResults, int firstResult) {
        return findTipoadvertenciaEntities(false, maxResults, firstResult);
    }

    private List<Tipoadvertencia> findTipoadvertenciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tipoadvertencia.class));
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

    public Tipoadvertencia findTipoadvertencia(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tipoadvertencia.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoadvertenciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tipoadvertencia> rt = cq.from(Tipoadvertencia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

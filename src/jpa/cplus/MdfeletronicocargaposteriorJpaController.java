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
import entidade.cplus.Mdfeletronico;
import entidade.cplus.Mdfeletronicocargaposterior;
import entidade.cplus.Mdfeletronicolocal;
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
public class MdfeletronicocargaposteriorJpaController implements Serializable {

    public MdfeletronicocargaposteriorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mdfeletronicocargaposterior mdfeletronicocargaposterior) throws PreexistingEntityException, Exception {
        if (mdfeletronicocargaposterior.getMdfeletronicolocalCollection() == null) {
            mdfeletronicocargaposterior.setMdfeletronicolocalCollection(new ArrayList<Mdfeletronicolocal>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mdfeletronico codmdfeletronico = mdfeletronicocargaposterior.getCodmdfeletronico();
            if (codmdfeletronico != null) {
                codmdfeletronico = em.getReference(codmdfeletronico.getClass(), codmdfeletronico.getCodmdfeletronico());
                mdfeletronicocargaposterior.setCodmdfeletronico(codmdfeletronico);
            }
            Collection<Mdfeletronicolocal> attachedMdfeletronicolocalCollection = new ArrayList<Mdfeletronicolocal>();
            for (Mdfeletronicolocal mdfeletronicolocalCollectionMdfeletronicolocalToAttach : mdfeletronicocargaposterior.getMdfeletronicolocalCollection()) {
                mdfeletronicolocalCollectionMdfeletronicolocalToAttach = em.getReference(mdfeletronicolocalCollectionMdfeletronicolocalToAttach.getClass(), mdfeletronicolocalCollectionMdfeletronicolocalToAttach.getCodmdfeletronicolocal());
                attachedMdfeletronicolocalCollection.add(mdfeletronicolocalCollectionMdfeletronicolocalToAttach);
            }
            mdfeletronicocargaposterior.setMdfeletronicolocalCollection(attachedMdfeletronicolocalCollection);
            em.persist(mdfeletronicocargaposterior);
            if (codmdfeletronico != null) {
                codmdfeletronico.getMdfeletronicocargaposteriorCollection().add(mdfeletronicocargaposterior);
                codmdfeletronico = em.merge(codmdfeletronico);
            }
            for (Mdfeletronicolocal mdfeletronicolocalCollectionMdfeletronicolocal : mdfeletronicocargaposterior.getMdfeletronicolocalCollection()) {
                Mdfeletronicocargaposterior oldCodmdfeletronicocargaposteriorOfMdfeletronicolocalCollectionMdfeletronicolocal = mdfeletronicolocalCollectionMdfeletronicolocal.getCodmdfeletronicocargaposterior();
                mdfeletronicolocalCollectionMdfeletronicolocal.setCodmdfeletronicocargaposterior(mdfeletronicocargaposterior);
                mdfeletronicolocalCollectionMdfeletronicolocal = em.merge(mdfeletronicolocalCollectionMdfeletronicolocal);
                if (oldCodmdfeletronicocargaposteriorOfMdfeletronicolocalCollectionMdfeletronicolocal != null) {
                    oldCodmdfeletronicocargaposteriorOfMdfeletronicolocalCollectionMdfeletronicolocal.getMdfeletronicolocalCollection().remove(mdfeletronicolocalCollectionMdfeletronicolocal);
                    oldCodmdfeletronicocargaposteriorOfMdfeletronicolocalCollectionMdfeletronicolocal = em.merge(oldCodmdfeletronicocargaposteriorOfMdfeletronicolocalCollectionMdfeletronicolocal);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMdfeletronicocargaposterior(mdfeletronicocargaposterior.getCodmdfeletronicocargaposterior()) != null) {
                throw new PreexistingEntityException("Mdfeletronicocargaposterior " + mdfeletronicocargaposterior + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mdfeletronicocargaposterior mdfeletronicocargaposterior) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mdfeletronicocargaposterior persistentMdfeletronicocargaposterior = em.find(Mdfeletronicocargaposterior.class, mdfeletronicocargaposterior.getCodmdfeletronicocargaposterior());
            Mdfeletronico codmdfeletronicoOld = persistentMdfeletronicocargaposterior.getCodmdfeletronico();
            Mdfeletronico codmdfeletronicoNew = mdfeletronicocargaposterior.getCodmdfeletronico();
            Collection<Mdfeletronicolocal> mdfeletronicolocalCollectionOld = persistentMdfeletronicocargaposterior.getMdfeletronicolocalCollection();
            Collection<Mdfeletronicolocal> mdfeletronicolocalCollectionNew = mdfeletronicocargaposterior.getMdfeletronicolocalCollection();
            if (codmdfeletronicoNew != null) {
                codmdfeletronicoNew = em.getReference(codmdfeletronicoNew.getClass(), codmdfeletronicoNew.getCodmdfeletronico());
                mdfeletronicocargaposterior.setCodmdfeletronico(codmdfeletronicoNew);
            }
            Collection<Mdfeletronicolocal> attachedMdfeletronicolocalCollectionNew = new ArrayList<Mdfeletronicolocal>();
            for (Mdfeletronicolocal mdfeletronicolocalCollectionNewMdfeletronicolocalToAttach : mdfeletronicolocalCollectionNew) {
                mdfeletronicolocalCollectionNewMdfeletronicolocalToAttach = em.getReference(mdfeletronicolocalCollectionNewMdfeletronicolocalToAttach.getClass(), mdfeletronicolocalCollectionNewMdfeletronicolocalToAttach.getCodmdfeletronicolocal());
                attachedMdfeletronicolocalCollectionNew.add(mdfeletronicolocalCollectionNewMdfeletronicolocalToAttach);
            }
            mdfeletronicolocalCollectionNew = attachedMdfeletronicolocalCollectionNew;
            mdfeletronicocargaposterior.setMdfeletronicolocalCollection(mdfeletronicolocalCollectionNew);
            mdfeletronicocargaposterior = em.merge(mdfeletronicocargaposterior);
            if (codmdfeletronicoOld != null && !codmdfeletronicoOld.equals(codmdfeletronicoNew)) {
                codmdfeletronicoOld.getMdfeletronicocargaposteriorCollection().remove(mdfeletronicocargaposterior);
                codmdfeletronicoOld = em.merge(codmdfeletronicoOld);
            }
            if (codmdfeletronicoNew != null && !codmdfeletronicoNew.equals(codmdfeletronicoOld)) {
                codmdfeletronicoNew.getMdfeletronicocargaposteriorCollection().add(mdfeletronicocargaposterior);
                codmdfeletronicoNew = em.merge(codmdfeletronicoNew);
            }
            for (Mdfeletronicolocal mdfeletronicolocalCollectionOldMdfeletronicolocal : mdfeletronicolocalCollectionOld) {
                if (!mdfeletronicolocalCollectionNew.contains(mdfeletronicolocalCollectionOldMdfeletronicolocal)) {
                    mdfeletronicolocalCollectionOldMdfeletronicolocal.setCodmdfeletronicocargaposterior(null);
                    mdfeletronicolocalCollectionOldMdfeletronicolocal = em.merge(mdfeletronicolocalCollectionOldMdfeletronicolocal);
                }
            }
            for (Mdfeletronicolocal mdfeletronicolocalCollectionNewMdfeletronicolocal : mdfeletronicolocalCollectionNew) {
                if (!mdfeletronicolocalCollectionOld.contains(mdfeletronicolocalCollectionNewMdfeletronicolocal)) {
                    Mdfeletronicocargaposterior oldCodmdfeletronicocargaposteriorOfMdfeletronicolocalCollectionNewMdfeletronicolocal = mdfeletronicolocalCollectionNewMdfeletronicolocal.getCodmdfeletronicocargaposterior();
                    mdfeletronicolocalCollectionNewMdfeletronicolocal.setCodmdfeletronicocargaposterior(mdfeletronicocargaposterior);
                    mdfeletronicolocalCollectionNewMdfeletronicolocal = em.merge(mdfeletronicolocalCollectionNewMdfeletronicolocal);
                    if (oldCodmdfeletronicocargaposteriorOfMdfeletronicolocalCollectionNewMdfeletronicolocal != null && !oldCodmdfeletronicocargaposteriorOfMdfeletronicolocalCollectionNewMdfeletronicolocal.equals(mdfeletronicocargaposterior)) {
                        oldCodmdfeletronicocargaposteriorOfMdfeletronicolocalCollectionNewMdfeletronicolocal.getMdfeletronicolocalCollection().remove(mdfeletronicolocalCollectionNewMdfeletronicolocal);
                        oldCodmdfeletronicocargaposteriorOfMdfeletronicolocalCollectionNewMdfeletronicolocal = em.merge(oldCodmdfeletronicocargaposteriorOfMdfeletronicolocalCollectionNewMdfeletronicolocal);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = mdfeletronicocargaposterior.getCodmdfeletronicocargaposterior();
                if (findMdfeletronicocargaposterior(id) == null) {
                    throw new NonexistentEntityException("The mdfeletronicocargaposterior with id " + id + " no longer exists.");
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
            Mdfeletronicocargaposterior mdfeletronicocargaposterior;
            try {
                mdfeletronicocargaposterior = em.getReference(Mdfeletronicocargaposterior.class, id);
                mdfeletronicocargaposterior.getCodmdfeletronicocargaposterior();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mdfeletronicocargaposterior with id " + id + " no longer exists.", enfe);
            }
            Mdfeletronico codmdfeletronico = mdfeletronicocargaposterior.getCodmdfeletronico();
            if (codmdfeletronico != null) {
                codmdfeletronico.getMdfeletronicocargaposteriorCollection().remove(mdfeletronicocargaposterior);
                codmdfeletronico = em.merge(codmdfeletronico);
            }
            Collection<Mdfeletronicolocal> mdfeletronicolocalCollection = mdfeletronicocargaposterior.getMdfeletronicolocalCollection();
            for (Mdfeletronicolocal mdfeletronicolocalCollectionMdfeletronicolocal : mdfeletronicolocalCollection) {
                mdfeletronicolocalCollectionMdfeletronicolocal.setCodmdfeletronicocargaposterior(null);
                mdfeletronicolocalCollectionMdfeletronicolocal = em.merge(mdfeletronicolocalCollectionMdfeletronicolocal);
            }
            em.remove(mdfeletronicocargaposterior);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mdfeletronicocargaposterior> findMdfeletronicocargaposteriorEntities() {
        return findMdfeletronicocargaposteriorEntities(true, -1, -1);
    }

    public List<Mdfeletronicocargaposterior> findMdfeletronicocargaposteriorEntities(int maxResults, int firstResult) {
        return findMdfeletronicocargaposteriorEntities(false, maxResults, firstResult);
    }

    private List<Mdfeletronicocargaposterior> findMdfeletronicocargaposteriorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mdfeletronicocargaposterior.class));
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

    public Mdfeletronicocargaposterior findMdfeletronicocargaposterior(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mdfeletronicocargaposterior.class, id);
        } finally {
            em.close();
        }
    }

    public int getMdfeletronicocargaposteriorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mdfeletronicocargaposterior> rt = cq.from(Mdfeletronicocargaposterior.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

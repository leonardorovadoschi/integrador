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
import entidade.cplus.Mdfeletroniconf;
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
public class MdfeletronicolocalJpaController implements Serializable {

    public MdfeletronicolocalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mdfeletronicolocal mdfeletronicolocal) throws PreexistingEntityException, Exception {
        if (mdfeletronicolocal.getMdfeletroniconfCollection() == null) {
            mdfeletronicolocal.setMdfeletroniconfCollection(new ArrayList<Mdfeletroniconf>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mdfeletronico codmdfeletronico = mdfeletronicolocal.getCodmdfeletronico();
            if (codmdfeletronico != null) {
                codmdfeletronico = em.getReference(codmdfeletronico.getClass(), codmdfeletronico.getCodmdfeletronico());
                mdfeletronicolocal.setCodmdfeletronico(codmdfeletronico);
            }
            Mdfeletronicocargaposterior codmdfeletronicocargaposterior = mdfeletronicolocal.getCodmdfeletronicocargaposterior();
            if (codmdfeletronicocargaposterior != null) {
                codmdfeletronicocargaposterior = em.getReference(codmdfeletronicocargaposterior.getClass(), codmdfeletronicocargaposterior.getCodmdfeletronicocargaposterior());
                mdfeletronicolocal.setCodmdfeletronicocargaposterior(codmdfeletronicocargaposterior);
            }
            Collection<Mdfeletroniconf> attachedMdfeletroniconfCollection = new ArrayList<Mdfeletroniconf>();
            for (Mdfeletroniconf mdfeletroniconfCollectionMdfeletroniconfToAttach : mdfeletronicolocal.getMdfeletroniconfCollection()) {
                mdfeletroniconfCollectionMdfeletroniconfToAttach = em.getReference(mdfeletroniconfCollectionMdfeletroniconfToAttach.getClass(), mdfeletroniconfCollectionMdfeletroniconfToAttach.getCodmdfeletroniconf());
                attachedMdfeletroniconfCollection.add(mdfeletroniconfCollectionMdfeletroniconfToAttach);
            }
            mdfeletronicolocal.setMdfeletroniconfCollection(attachedMdfeletroniconfCollection);
            em.persist(mdfeletronicolocal);
            if (codmdfeletronico != null) {
                codmdfeletronico.getMdfeletronicolocalCollection().add(mdfeletronicolocal);
                codmdfeletronico = em.merge(codmdfeletronico);
            }
            if (codmdfeletronicocargaposterior != null) {
                codmdfeletronicocargaposterior.getMdfeletronicolocalCollection().add(mdfeletronicolocal);
                codmdfeletronicocargaposterior = em.merge(codmdfeletronicocargaposterior);
            }
            for (Mdfeletroniconf mdfeletroniconfCollectionMdfeletroniconf : mdfeletronicolocal.getMdfeletroniconfCollection()) {
                Mdfeletronicolocal oldCodmdfeletronicolocalOfMdfeletroniconfCollectionMdfeletroniconf = mdfeletroniconfCollectionMdfeletroniconf.getCodmdfeletronicolocal();
                mdfeletroniconfCollectionMdfeletroniconf.setCodmdfeletronicolocal(mdfeletronicolocal);
                mdfeletroniconfCollectionMdfeletroniconf = em.merge(mdfeletroniconfCollectionMdfeletroniconf);
                if (oldCodmdfeletronicolocalOfMdfeletroniconfCollectionMdfeletroniconf != null) {
                    oldCodmdfeletronicolocalOfMdfeletroniconfCollectionMdfeletroniconf.getMdfeletroniconfCollection().remove(mdfeletroniconfCollectionMdfeletroniconf);
                    oldCodmdfeletronicolocalOfMdfeletroniconfCollectionMdfeletroniconf = em.merge(oldCodmdfeletronicolocalOfMdfeletroniconfCollectionMdfeletroniconf);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMdfeletronicolocal(mdfeletronicolocal.getCodmdfeletronicolocal()) != null) {
                throw new PreexistingEntityException("Mdfeletronicolocal " + mdfeletronicolocal + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mdfeletronicolocal mdfeletronicolocal) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mdfeletronicolocal persistentMdfeletronicolocal = em.find(Mdfeletronicolocal.class, mdfeletronicolocal.getCodmdfeletronicolocal());
            Mdfeletronico codmdfeletronicoOld = persistentMdfeletronicolocal.getCodmdfeletronico();
            Mdfeletronico codmdfeletronicoNew = mdfeletronicolocal.getCodmdfeletronico();
            Mdfeletronicocargaposterior codmdfeletronicocargaposteriorOld = persistentMdfeletronicolocal.getCodmdfeletronicocargaposterior();
            Mdfeletronicocargaposterior codmdfeletronicocargaposteriorNew = mdfeletronicolocal.getCodmdfeletronicocargaposterior();
            Collection<Mdfeletroniconf> mdfeletroniconfCollectionOld = persistentMdfeletronicolocal.getMdfeletroniconfCollection();
            Collection<Mdfeletroniconf> mdfeletroniconfCollectionNew = mdfeletronicolocal.getMdfeletroniconfCollection();
            List<String> illegalOrphanMessages = null;
            for (Mdfeletroniconf mdfeletroniconfCollectionOldMdfeletroniconf : mdfeletroniconfCollectionOld) {
                if (!mdfeletroniconfCollectionNew.contains(mdfeletroniconfCollectionOldMdfeletroniconf)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Mdfeletroniconf " + mdfeletroniconfCollectionOldMdfeletroniconf + " since its codmdfeletronicolocal field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codmdfeletronicoNew != null) {
                codmdfeletronicoNew = em.getReference(codmdfeletronicoNew.getClass(), codmdfeletronicoNew.getCodmdfeletronico());
                mdfeletronicolocal.setCodmdfeletronico(codmdfeletronicoNew);
            }
            if (codmdfeletronicocargaposteriorNew != null) {
                codmdfeletronicocargaposteriorNew = em.getReference(codmdfeletronicocargaposteriorNew.getClass(), codmdfeletronicocargaposteriorNew.getCodmdfeletronicocargaposterior());
                mdfeletronicolocal.setCodmdfeletronicocargaposterior(codmdfeletronicocargaposteriorNew);
            }
            Collection<Mdfeletroniconf> attachedMdfeletroniconfCollectionNew = new ArrayList<Mdfeletroniconf>();
            for (Mdfeletroniconf mdfeletroniconfCollectionNewMdfeletroniconfToAttach : mdfeletroniconfCollectionNew) {
                mdfeletroniconfCollectionNewMdfeletroniconfToAttach = em.getReference(mdfeletroniconfCollectionNewMdfeletroniconfToAttach.getClass(), mdfeletroniconfCollectionNewMdfeletroniconfToAttach.getCodmdfeletroniconf());
                attachedMdfeletroniconfCollectionNew.add(mdfeletroniconfCollectionNewMdfeletroniconfToAttach);
            }
            mdfeletroniconfCollectionNew = attachedMdfeletroniconfCollectionNew;
            mdfeletronicolocal.setMdfeletroniconfCollection(mdfeletroniconfCollectionNew);
            mdfeletronicolocal = em.merge(mdfeletronicolocal);
            if (codmdfeletronicoOld != null && !codmdfeletronicoOld.equals(codmdfeletronicoNew)) {
                codmdfeletronicoOld.getMdfeletronicolocalCollection().remove(mdfeletronicolocal);
                codmdfeletronicoOld = em.merge(codmdfeletronicoOld);
            }
            if (codmdfeletronicoNew != null && !codmdfeletronicoNew.equals(codmdfeletronicoOld)) {
                codmdfeletronicoNew.getMdfeletronicolocalCollection().add(mdfeletronicolocal);
                codmdfeletronicoNew = em.merge(codmdfeletronicoNew);
            }
            if (codmdfeletronicocargaposteriorOld != null && !codmdfeletronicocargaposteriorOld.equals(codmdfeletronicocargaposteriorNew)) {
                codmdfeletronicocargaposteriorOld.getMdfeletronicolocalCollection().remove(mdfeletronicolocal);
                codmdfeletronicocargaposteriorOld = em.merge(codmdfeletronicocargaposteriorOld);
            }
            if (codmdfeletronicocargaposteriorNew != null && !codmdfeletronicocargaposteriorNew.equals(codmdfeletronicocargaposteriorOld)) {
                codmdfeletronicocargaposteriorNew.getMdfeletronicolocalCollection().add(mdfeletronicolocal);
                codmdfeletronicocargaposteriorNew = em.merge(codmdfeletronicocargaposteriorNew);
            }
            for (Mdfeletroniconf mdfeletroniconfCollectionNewMdfeletroniconf : mdfeletroniconfCollectionNew) {
                if (!mdfeletroniconfCollectionOld.contains(mdfeletroniconfCollectionNewMdfeletroniconf)) {
                    Mdfeletronicolocal oldCodmdfeletronicolocalOfMdfeletroniconfCollectionNewMdfeletroniconf = mdfeletroniconfCollectionNewMdfeletroniconf.getCodmdfeletronicolocal();
                    mdfeletroniconfCollectionNewMdfeletroniconf.setCodmdfeletronicolocal(mdfeletronicolocal);
                    mdfeletroniconfCollectionNewMdfeletroniconf = em.merge(mdfeletroniconfCollectionNewMdfeletroniconf);
                    if (oldCodmdfeletronicolocalOfMdfeletroniconfCollectionNewMdfeletroniconf != null && !oldCodmdfeletronicolocalOfMdfeletroniconfCollectionNewMdfeletroniconf.equals(mdfeletronicolocal)) {
                        oldCodmdfeletronicolocalOfMdfeletroniconfCollectionNewMdfeletroniconf.getMdfeletroniconfCollection().remove(mdfeletroniconfCollectionNewMdfeletroniconf);
                        oldCodmdfeletronicolocalOfMdfeletroniconfCollectionNewMdfeletroniconf = em.merge(oldCodmdfeletronicolocalOfMdfeletroniconfCollectionNewMdfeletroniconf);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = mdfeletronicolocal.getCodmdfeletronicolocal();
                if (findMdfeletronicolocal(id) == null) {
                    throw new NonexistentEntityException("The mdfeletronicolocal with id " + id + " no longer exists.");
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
            Mdfeletronicolocal mdfeletronicolocal;
            try {
                mdfeletronicolocal = em.getReference(Mdfeletronicolocal.class, id);
                mdfeletronicolocal.getCodmdfeletronicolocal();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mdfeletronicolocal with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Mdfeletroniconf> mdfeletroniconfCollectionOrphanCheck = mdfeletronicolocal.getMdfeletroniconfCollection();
            for (Mdfeletroniconf mdfeletroniconfCollectionOrphanCheckMdfeletroniconf : mdfeletroniconfCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Mdfeletronicolocal (" + mdfeletronicolocal + ") cannot be destroyed since the Mdfeletroniconf " + mdfeletroniconfCollectionOrphanCheckMdfeletroniconf + " in its mdfeletroniconfCollection field has a non-nullable codmdfeletronicolocal field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Mdfeletronico codmdfeletronico = mdfeletronicolocal.getCodmdfeletronico();
            if (codmdfeletronico != null) {
                codmdfeletronico.getMdfeletronicolocalCollection().remove(mdfeletronicolocal);
                codmdfeletronico = em.merge(codmdfeletronico);
            }
            Mdfeletronicocargaposterior codmdfeletronicocargaposterior = mdfeletronicolocal.getCodmdfeletronicocargaposterior();
            if (codmdfeletronicocargaposterior != null) {
                codmdfeletronicocargaposterior.getMdfeletronicolocalCollection().remove(mdfeletronicolocal);
                codmdfeletronicocargaposterior = em.merge(codmdfeletronicocargaposterior);
            }
            em.remove(mdfeletronicolocal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mdfeletronicolocal> findMdfeletronicolocalEntities() {
        return findMdfeletronicolocalEntities(true, -1, -1);
    }

    public List<Mdfeletronicolocal> findMdfeletronicolocalEntities(int maxResults, int firstResult) {
        return findMdfeletronicolocalEntities(false, maxResults, firstResult);
    }

    private List<Mdfeletronicolocal> findMdfeletronicolocalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mdfeletronicolocal.class));
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

    public Mdfeletronicolocal findMdfeletronicolocal(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mdfeletronicolocal.class, id);
        } finally {
            em.close();
        }
    }

    public int getMdfeletronicolocalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mdfeletronicolocal> rt = cq.from(Mdfeletronicolocal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
import entidade.cplus.Ecfcodigoid;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Ecfmodelo;
import entidade.cplus.Ecf;
import entidade.cplus.Ecfmarca;
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
public class EcfmarcaJpaController implements Serializable {

    public EcfmarcaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ecfmarca ecfmarca) throws PreexistingEntityException, Exception {
        if (ecfmarca.getEcfcodigoidCollection() == null) {
            ecfmarca.setEcfcodigoidCollection(new ArrayList<Ecfcodigoid>());
        }
        if (ecfmarca.getEcfmodeloCollection() == null) {
            ecfmarca.setEcfmodeloCollection(new ArrayList<Ecfmodelo>());
        }
        if (ecfmarca.getEcfCollection() == null) {
            ecfmarca.setEcfCollection(new ArrayList<Ecf>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Ecfcodigoid> attachedEcfcodigoidCollection = new ArrayList<Ecfcodigoid>();
            for (Ecfcodigoid ecfcodigoidCollectionEcfcodigoidToAttach : ecfmarca.getEcfcodigoidCollection()) {
                ecfcodigoidCollectionEcfcodigoidToAttach = em.getReference(ecfcodigoidCollectionEcfcodigoidToAttach.getClass(), ecfcodigoidCollectionEcfcodigoidToAttach.getCodecfcodigoid());
                attachedEcfcodigoidCollection.add(ecfcodigoidCollectionEcfcodigoidToAttach);
            }
            ecfmarca.setEcfcodigoidCollection(attachedEcfcodigoidCollection);
            Collection<Ecfmodelo> attachedEcfmodeloCollection = new ArrayList<Ecfmodelo>();
            for (Ecfmodelo ecfmodeloCollectionEcfmodeloToAttach : ecfmarca.getEcfmodeloCollection()) {
                ecfmodeloCollectionEcfmodeloToAttach = em.getReference(ecfmodeloCollectionEcfmodeloToAttach.getClass(), ecfmodeloCollectionEcfmodeloToAttach.getCodecfmodelo());
                attachedEcfmodeloCollection.add(ecfmodeloCollectionEcfmodeloToAttach);
            }
            ecfmarca.setEcfmodeloCollection(attachedEcfmodeloCollection);
            Collection<Ecf> attachedEcfCollection = new ArrayList<Ecf>();
            for (Ecf ecfCollectionEcfToAttach : ecfmarca.getEcfCollection()) {
                ecfCollectionEcfToAttach = em.getReference(ecfCollectionEcfToAttach.getClass(), ecfCollectionEcfToAttach.getCodecf());
                attachedEcfCollection.add(ecfCollectionEcfToAttach);
            }
            ecfmarca.setEcfCollection(attachedEcfCollection);
            em.persist(ecfmarca);
            for (Ecfcodigoid ecfcodigoidCollectionEcfcodigoid : ecfmarca.getEcfcodigoidCollection()) {
                Ecfmarca oldCodecfmarcaOfEcfcodigoidCollectionEcfcodigoid = ecfcodigoidCollectionEcfcodigoid.getCodecfmarca();
                ecfcodigoidCollectionEcfcodigoid.setCodecfmarca(ecfmarca);
                ecfcodigoidCollectionEcfcodigoid = em.merge(ecfcodigoidCollectionEcfcodigoid);
                if (oldCodecfmarcaOfEcfcodigoidCollectionEcfcodigoid != null) {
                    oldCodecfmarcaOfEcfcodigoidCollectionEcfcodigoid.getEcfcodigoidCollection().remove(ecfcodigoidCollectionEcfcodigoid);
                    oldCodecfmarcaOfEcfcodigoidCollectionEcfcodigoid = em.merge(oldCodecfmarcaOfEcfcodigoidCollectionEcfcodigoid);
                }
            }
            for (Ecfmodelo ecfmodeloCollectionEcfmodelo : ecfmarca.getEcfmodeloCollection()) {
                Ecfmarca oldCodecfmarcaOfEcfmodeloCollectionEcfmodelo = ecfmodeloCollectionEcfmodelo.getCodecfmarca();
                ecfmodeloCollectionEcfmodelo.setCodecfmarca(ecfmarca);
                ecfmodeloCollectionEcfmodelo = em.merge(ecfmodeloCollectionEcfmodelo);
                if (oldCodecfmarcaOfEcfmodeloCollectionEcfmodelo != null) {
                    oldCodecfmarcaOfEcfmodeloCollectionEcfmodelo.getEcfmodeloCollection().remove(ecfmodeloCollectionEcfmodelo);
                    oldCodecfmarcaOfEcfmodeloCollectionEcfmodelo = em.merge(oldCodecfmarcaOfEcfmodeloCollectionEcfmodelo);
                }
            }
            for (Ecf ecfCollectionEcf : ecfmarca.getEcfCollection()) {
                Ecfmarca oldCodecfmarcaOfEcfCollectionEcf = ecfCollectionEcf.getCodecfmarca();
                ecfCollectionEcf.setCodecfmarca(ecfmarca);
                ecfCollectionEcf = em.merge(ecfCollectionEcf);
                if (oldCodecfmarcaOfEcfCollectionEcf != null) {
                    oldCodecfmarcaOfEcfCollectionEcf.getEcfCollection().remove(ecfCollectionEcf);
                    oldCodecfmarcaOfEcfCollectionEcf = em.merge(oldCodecfmarcaOfEcfCollectionEcf);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEcfmarca(ecfmarca.getCodecfmarca()) != null) {
                throw new PreexistingEntityException("Ecfmarca " + ecfmarca + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ecfmarca ecfmarca) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ecfmarca persistentEcfmarca = em.find(Ecfmarca.class, ecfmarca.getCodecfmarca());
            Collection<Ecfcodigoid> ecfcodigoidCollectionOld = persistentEcfmarca.getEcfcodigoidCollection();
            Collection<Ecfcodigoid> ecfcodigoidCollectionNew = ecfmarca.getEcfcodigoidCollection();
            Collection<Ecfmodelo> ecfmodeloCollectionOld = persistentEcfmarca.getEcfmodeloCollection();
            Collection<Ecfmodelo> ecfmodeloCollectionNew = ecfmarca.getEcfmodeloCollection();
            Collection<Ecf> ecfCollectionOld = persistentEcfmarca.getEcfCollection();
            Collection<Ecf> ecfCollectionNew = ecfmarca.getEcfCollection();
            List<String> illegalOrphanMessages = null;
            for (Ecfmodelo ecfmodeloCollectionOldEcfmodelo : ecfmodeloCollectionOld) {
                if (!ecfmodeloCollectionNew.contains(ecfmodeloCollectionOldEcfmodelo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ecfmodelo " + ecfmodeloCollectionOldEcfmodelo + " since its codecfmarca field is not nullable.");
                }
            }
            for (Ecf ecfCollectionOldEcf : ecfCollectionOld) {
                if (!ecfCollectionNew.contains(ecfCollectionOldEcf)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ecf " + ecfCollectionOldEcf + " since its codecfmarca field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Ecfcodigoid> attachedEcfcodigoidCollectionNew = new ArrayList<Ecfcodigoid>();
            for (Ecfcodigoid ecfcodigoidCollectionNewEcfcodigoidToAttach : ecfcodigoidCollectionNew) {
                ecfcodigoidCollectionNewEcfcodigoidToAttach = em.getReference(ecfcodigoidCollectionNewEcfcodigoidToAttach.getClass(), ecfcodigoidCollectionNewEcfcodigoidToAttach.getCodecfcodigoid());
                attachedEcfcodigoidCollectionNew.add(ecfcodigoidCollectionNewEcfcodigoidToAttach);
            }
            ecfcodigoidCollectionNew = attachedEcfcodigoidCollectionNew;
            ecfmarca.setEcfcodigoidCollection(ecfcodigoidCollectionNew);
            Collection<Ecfmodelo> attachedEcfmodeloCollectionNew = new ArrayList<Ecfmodelo>();
            for (Ecfmodelo ecfmodeloCollectionNewEcfmodeloToAttach : ecfmodeloCollectionNew) {
                ecfmodeloCollectionNewEcfmodeloToAttach = em.getReference(ecfmodeloCollectionNewEcfmodeloToAttach.getClass(), ecfmodeloCollectionNewEcfmodeloToAttach.getCodecfmodelo());
                attachedEcfmodeloCollectionNew.add(ecfmodeloCollectionNewEcfmodeloToAttach);
            }
            ecfmodeloCollectionNew = attachedEcfmodeloCollectionNew;
            ecfmarca.setEcfmodeloCollection(ecfmodeloCollectionNew);
            Collection<Ecf> attachedEcfCollectionNew = new ArrayList<Ecf>();
            for (Ecf ecfCollectionNewEcfToAttach : ecfCollectionNew) {
                ecfCollectionNewEcfToAttach = em.getReference(ecfCollectionNewEcfToAttach.getClass(), ecfCollectionNewEcfToAttach.getCodecf());
                attachedEcfCollectionNew.add(ecfCollectionNewEcfToAttach);
            }
            ecfCollectionNew = attachedEcfCollectionNew;
            ecfmarca.setEcfCollection(ecfCollectionNew);
            ecfmarca = em.merge(ecfmarca);
            for (Ecfcodigoid ecfcodigoidCollectionOldEcfcodigoid : ecfcodigoidCollectionOld) {
                if (!ecfcodigoidCollectionNew.contains(ecfcodigoidCollectionOldEcfcodigoid)) {
                    ecfcodigoidCollectionOldEcfcodigoid.setCodecfmarca(null);
                    ecfcodigoidCollectionOldEcfcodigoid = em.merge(ecfcodigoidCollectionOldEcfcodigoid);
                }
            }
            for (Ecfcodigoid ecfcodigoidCollectionNewEcfcodigoid : ecfcodigoidCollectionNew) {
                if (!ecfcodigoidCollectionOld.contains(ecfcodigoidCollectionNewEcfcodigoid)) {
                    Ecfmarca oldCodecfmarcaOfEcfcodigoidCollectionNewEcfcodigoid = ecfcodigoidCollectionNewEcfcodigoid.getCodecfmarca();
                    ecfcodigoidCollectionNewEcfcodigoid.setCodecfmarca(ecfmarca);
                    ecfcodigoidCollectionNewEcfcodigoid = em.merge(ecfcodigoidCollectionNewEcfcodigoid);
                    if (oldCodecfmarcaOfEcfcodigoidCollectionNewEcfcodigoid != null && !oldCodecfmarcaOfEcfcodigoidCollectionNewEcfcodigoid.equals(ecfmarca)) {
                        oldCodecfmarcaOfEcfcodigoidCollectionNewEcfcodigoid.getEcfcodigoidCollection().remove(ecfcodigoidCollectionNewEcfcodigoid);
                        oldCodecfmarcaOfEcfcodigoidCollectionNewEcfcodigoid = em.merge(oldCodecfmarcaOfEcfcodigoidCollectionNewEcfcodigoid);
                    }
                }
            }
            for (Ecfmodelo ecfmodeloCollectionNewEcfmodelo : ecfmodeloCollectionNew) {
                if (!ecfmodeloCollectionOld.contains(ecfmodeloCollectionNewEcfmodelo)) {
                    Ecfmarca oldCodecfmarcaOfEcfmodeloCollectionNewEcfmodelo = ecfmodeloCollectionNewEcfmodelo.getCodecfmarca();
                    ecfmodeloCollectionNewEcfmodelo.setCodecfmarca(ecfmarca);
                    ecfmodeloCollectionNewEcfmodelo = em.merge(ecfmodeloCollectionNewEcfmodelo);
                    if (oldCodecfmarcaOfEcfmodeloCollectionNewEcfmodelo != null && !oldCodecfmarcaOfEcfmodeloCollectionNewEcfmodelo.equals(ecfmarca)) {
                        oldCodecfmarcaOfEcfmodeloCollectionNewEcfmodelo.getEcfmodeloCollection().remove(ecfmodeloCollectionNewEcfmodelo);
                        oldCodecfmarcaOfEcfmodeloCollectionNewEcfmodelo = em.merge(oldCodecfmarcaOfEcfmodeloCollectionNewEcfmodelo);
                    }
                }
            }
            for (Ecf ecfCollectionNewEcf : ecfCollectionNew) {
                if (!ecfCollectionOld.contains(ecfCollectionNewEcf)) {
                    Ecfmarca oldCodecfmarcaOfEcfCollectionNewEcf = ecfCollectionNewEcf.getCodecfmarca();
                    ecfCollectionNewEcf.setCodecfmarca(ecfmarca);
                    ecfCollectionNewEcf = em.merge(ecfCollectionNewEcf);
                    if (oldCodecfmarcaOfEcfCollectionNewEcf != null && !oldCodecfmarcaOfEcfCollectionNewEcf.equals(ecfmarca)) {
                        oldCodecfmarcaOfEcfCollectionNewEcf.getEcfCollection().remove(ecfCollectionNewEcf);
                        oldCodecfmarcaOfEcfCollectionNewEcf = em.merge(oldCodecfmarcaOfEcfCollectionNewEcf);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ecfmarca.getCodecfmarca();
                if (findEcfmarca(id) == null) {
                    throw new NonexistentEntityException("The ecfmarca with id " + id + " no longer exists.");
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
            Ecfmarca ecfmarca;
            try {
                ecfmarca = em.getReference(Ecfmarca.class, id);
                ecfmarca.getCodecfmarca();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ecfmarca with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Ecfmodelo> ecfmodeloCollectionOrphanCheck = ecfmarca.getEcfmodeloCollection();
            for (Ecfmodelo ecfmodeloCollectionOrphanCheckEcfmodelo : ecfmodeloCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ecfmarca (" + ecfmarca + ") cannot be destroyed since the Ecfmodelo " + ecfmodeloCollectionOrphanCheckEcfmodelo + " in its ecfmodeloCollection field has a non-nullable codecfmarca field.");
            }
            Collection<Ecf> ecfCollectionOrphanCheck = ecfmarca.getEcfCollection();
            for (Ecf ecfCollectionOrphanCheckEcf : ecfCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ecfmarca (" + ecfmarca + ") cannot be destroyed since the Ecf " + ecfCollectionOrphanCheckEcf + " in its ecfCollection field has a non-nullable codecfmarca field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Ecfcodigoid> ecfcodigoidCollection = ecfmarca.getEcfcodigoidCollection();
            for (Ecfcodigoid ecfcodigoidCollectionEcfcodigoid : ecfcodigoidCollection) {
                ecfcodigoidCollectionEcfcodigoid.setCodecfmarca(null);
                ecfcodigoidCollectionEcfcodigoid = em.merge(ecfcodigoidCollectionEcfcodigoid);
            }
            em.remove(ecfmarca);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ecfmarca> findEcfmarcaEntities() {
        return findEcfmarcaEntities(true, -1, -1);
    }

    public List<Ecfmarca> findEcfmarcaEntities(int maxResults, int firstResult) {
        return findEcfmarcaEntities(false, maxResults, firstResult);
    }

    private List<Ecfmarca> findEcfmarcaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ecfmarca.class));
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

    public Ecfmarca findEcfmarca(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ecfmarca.class, id);
        } finally {
            em.close();
        }
    }

    public int getEcfmarcaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ecfmarca> rt = cq.from(Ecfmarca.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

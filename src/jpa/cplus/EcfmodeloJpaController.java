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
import entidade.cplus.Ecfmarca;
import entidade.cplus.Ecfcodigoid;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Ecf;
import entidade.cplus.Ecfmodelo;
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
public class EcfmodeloJpaController implements Serializable {

    public EcfmodeloJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ecfmodelo ecfmodelo) throws PreexistingEntityException, Exception {
        if (ecfmodelo.getEcfcodigoidCollection() == null) {
            ecfmodelo.setEcfcodigoidCollection(new ArrayList<Ecfcodigoid>());
        }
        if (ecfmodelo.getEcfCollection() == null) {
            ecfmodelo.setEcfCollection(new ArrayList<Ecf>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ecfmarca codecfmarca = ecfmodelo.getCodecfmarca();
            if (codecfmarca != null) {
                codecfmarca = em.getReference(codecfmarca.getClass(), codecfmarca.getCodecfmarca());
                ecfmodelo.setCodecfmarca(codecfmarca);
            }
            Collection<Ecfcodigoid> attachedEcfcodigoidCollection = new ArrayList<Ecfcodigoid>();
            for (Ecfcodigoid ecfcodigoidCollectionEcfcodigoidToAttach : ecfmodelo.getEcfcodigoidCollection()) {
                ecfcodigoidCollectionEcfcodigoidToAttach = em.getReference(ecfcodigoidCollectionEcfcodigoidToAttach.getClass(), ecfcodigoidCollectionEcfcodigoidToAttach.getCodecfcodigoid());
                attachedEcfcodigoidCollection.add(ecfcodigoidCollectionEcfcodigoidToAttach);
            }
            ecfmodelo.setEcfcodigoidCollection(attachedEcfcodigoidCollection);
            Collection<Ecf> attachedEcfCollection = new ArrayList<Ecf>();
            for (Ecf ecfCollectionEcfToAttach : ecfmodelo.getEcfCollection()) {
                ecfCollectionEcfToAttach = em.getReference(ecfCollectionEcfToAttach.getClass(), ecfCollectionEcfToAttach.getCodecf());
                attachedEcfCollection.add(ecfCollectionEcfToAttach);
            }
            ecfmodelo.setEcfCollection(attachedEcfCollection);
            em.persist(ecfmodelo);
            if (codecfmarca != null) {
                codecfmarca.getEcfmodeloCollection().add(ecfmodelo);
                codecfmarca = em.merge(codecfmarca);
            }
            for (Ecfcodigoid ecfcodigoidCollectionEcfcodigoid : ecfmodelo.getEcfcodigoidCollection()) {
                Ecfmodelo oldCodecfmodeloOfEcfcodigoidCollectionEcfcodigoid = ecfcodigoidCollectionEcfcodigoid.getCodecfmodelo();
                ecfcodigoidCollectionEcfcodigoid.setCodecfmodelo(ecfmodelo);
                ecfcodigoidCollectionEcfcodigoid = em.merge(ecfcodigoidCollectionEcfcodigoid);
                if (oldCodecfmodeloOfEcfcodigoidCollectionEcfcodigoid != null) {
                    oldCodecfmodeloOfEcfcodigoidCollectionEcfcodigoid.getEcfcodigoidCollection().remove(ecfcodigoidCollectionEcfcodigoid);
                    oldCodecfmodeloOfEcfcodigoidCollectionEcfcodigoid = em.merge(oldCodecfmodeloOfEcfcodigoidCollectionEcfcodigoid);
                }
            }
            for (Ecf ecfCollectionEcf : ecfmodelo.getEcfCollection()) {
                Ecfmodelo oldCodecfmodeloOfEcfCollectionEcf = ecfCollectionEcf.getCodecfmodelo();
                ecfCollectionEcf.setCodecfmodelo(ecfmodelo);
                ecfCollectionEcf = em.merge(ecfCollectionEcf);
                if (oldCodecfmodeloOfEcfCollectionEcf != null) {
                    oldCodecfmodeloOfEcfCollectionEcf.getEcfCollection().remove(ecfCollectionEcf);
                    oldCodecfmodeloOfEcfCollectionEcf = em.merge(oldCodecfmodeloOfEcfCollectionEcf);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEcfmodelo(ecfmodelo.getCodecfmodelo()) != null) {
                throw new PreexistingEntityException("Ecfmodelo " + ecfmodelo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ecfmodelo ecfmodelo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ecfmodelo persistentEcfmodelo = em.find(Ecfmodelo.class, ecfmodelo.getCodecfmodelo());
            Ecfmarca codecfmarcaOld = persistentEcfmodelo.getCodecfmarca();
            Ecfmarca codecfmarcaNew = ecfmodelo.getCodecfmarca();
            Collection<Ecfcodigoid> ecfcodigoidCollectionOld = persistentEcfmodelo.getEcfcodigoidCollection();
            Collection<Ecfcodigoid> ecfcodigoidCollectionNew = ecfmodelo.getEcfcodigoidCollection();
            Collection<Ecf> ecfCollectionOld = persistentEcfmodelo.getEcfCollection();
            Collection<Ecf> ecfCollectionNew = ecfmodelo.getEcfCollection();
            List<String> illegalOrphanMessages = null;
            for (Ecf ecfCollectionOldEcf : ecfCollectionOld) {
                if (!ecfCollectionNew.contains(ecfCollectionOldEcf)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Ecf " + ecfCollectionOldEcf + " since its codecfmodelo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (codecfmarcaNew != null) {
                codecfmarcaNew = em.getReference(codecfmarcaNew.getClass(), codecfmarcaNew.getCodecfmarca());
                ecfmodelo.setCodecfmarca(codecfmarcaNew);
            }
            Collection<Ecfcodigoid> attachedEcfcodigoidCollectionNew = new ArrayList<Ecfcodigoid>();
            for (Ecfcodigoid ecfcodigoidCollectionNewEcfcodigoidToAttach : ecfcodigoidCollectionNew) {
                ecfcodigoidCollectionNewEcfcodigoidToAttach = em.getReference(ecfcodigoidCollectionNewEcfcodigoidToAttach.getClass(), ecfcodigoidCollectionNewEcfcodigoidToAttach.getCodecfcodigoid());
                attachedEcfcodigoidCollectionNew.add(ecfcodigoidCollectionNewEcfcodigoidToAttach);
            }
            ecfcodigoidCollectionNew = attachedEcfcodigoidCollectionNew;
            ecfmodelo.setEcfcodigoidCollection(ecfcodigoidCollectionNew);
            Collection<Ecf> attachedEcfCollectionNew = new ArrayList<Ecf>();
            for (Ecf ecfCollectionNewEcfToAttach : ecfCollectionNew) {
                ecfCollectionNewEcfToAttach = em.getReference(ecfCollectionNewEcfToAttach.getClass(), ecfCollectionNewEcfToAttach.getCodecf());
                attachedEcfCollectionNew.add(ecfCollectionNewEcfToAttach);
            }
            ecfCollectionNew = attachedEcfCollectionNew;
            ecfmodelo.setEcfCollection(ecfCollectionNew);
            ecfmodelo = em.merge(ecfmodelo);
            if (codecfmarcaOld != null && !codecfmarcaOld.equals(codecfmarcaNew)) {
                codecfmarcaOld.getEcfmodeloCollection().remove(ecfmodelo);
                codecfmarcaOld = em.merge(codecfmarcaOld);
            }
            if (codecfmarcaNew != null && !codecfmarcaNew.equals(codecfmarcaOld)) {
                codecfmarcaNew.getEcfmodeloCollection().add(ecfmodelo);
                codecfmarcaNew = em.merge(codecfmarcaNew);
            }
            for (Ecfcodigoid ecfcodigoidCollectionOldEcfcodigoid : ecfcodigoidCollectionOld) {
                if (!ecfcodigoidCollectionNew.contains(ecfcodigoidCollectionOldEcfcodigoid)) {
                    ecfcodigoidCollectionOldEcfcodigoid.setCodecfmodelo(null);
                    ecfcodigoidCollectionOldEcfcodigoid = em.merge(ecfcodigoidCollectionOldEcfcodigoid);
                }
            }
            for (Ecfcodigoid ecfcodigoidCollectionNewEcfcodigoid : ecfcodigoidCollectionNew) {
                if (!ecfcodigoidCollectionOld.contains(ecfcodigoidCollectionNewEcfcodigoid)) {
                    Ecfmodelo oldCodecfmodeloOfEcfcodigoidCollectionNewEcfcodigoid = ecfcodigoidCollectionNewEcfcodigoid.getCodecfmodelo();
                    ecfcodigoidCollectionNewEcfcodigoid.setCodecfmodelo(ecfmodelo);
                    ecfcodigoidCollectionNewEcfcodigoid = em.merge(ecfcodigoidCollectionNewEcfcodigoid);
                    if (oldCodecfmodeloOfEcfcodigoidCollectionNewEcfcodigoid != null && !oldCodecfmodeloOfEcfcodigoidCollectionNewEcfcodigoid.equals(ecfmodelo)) {
                        oldCodecfmodeloOfEcfcodigoidCollectionNewEcfcodigoid.getEcfcodigoidCollection().remove(ecfcodigoidCollectionNewEcfcodigoid);
                        oldCodecfmodeloOfEcfcodigoidCollectionNewEcfcodigoid = em.merge(oldCodecfmodeloOfEcfcodigoidCollectionNewEcfcodigoid);
                    }
                }
            }
            for (Ecf ecfCollectionNewEcf : ecfCollectionNew) {
                if (!ecfCollectionOld.contains(ecfCollectionNewEcf)) {
                    Ecfmodelo oldCodecfmodeloOfEcfCollectionNewEcf = ecfCollectionNewEcf.getCodecfmodelo();
                    ecfCollectionNewEcf.setCodecfmodelo(ecfmodelo);
                    ecfCollectionNewEcf = em.merge(ecfCollectionNewEcf);
                    if (oldCodecfmodeloOfEcfCollectionNewEcf != null && !oldCodecfmodeloOfEcfCollectionNewEcf.equals(ecfmodelo)) {
                        oldCodecfmodeloOfEcfCollectionNewEcf.getEcfCollection().remove(ecfCollectionNewEcf);
                        oldCodecfmodeloOfEcfCollectionNewEcf = em.merge(oldCodecfmodeloOfEcfCollectionNewEcf);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ecfmodelo.getCodecfmodelo();
                if (findEcfmodelo(id) == null) {
                    throw new NonexistentEntityException("The ecfmodelo with id " + id + " no longer exists.");
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
            Ecfmodelo ecfmodelo;
            try {
                ecfmodelo = em.getReference(Ecfmodelo.class, id);
                ecfmodelo.getCodecfmodelo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ecfmodelo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Ecf> ecfCollectionOrphanCheck = ecfmodelo.getEcfCollection();
            for (Ecf ecfCollectionOrphanCheckEcf : ecfCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Ecfmodelo (" + ecfmodelo + ") cannot be destroyed since the Ecf " + ecfCollectionOrphanCheckEcf + " in its ecfCollection field has a non-nullable codecfmodelo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Ecfmarca codecfmarca = ecfmodelo.getCodecfmarca();
            if (codecfmarca != null) {
                codecfmarca.getEcfmodeloCollection().remove(ecfmodelo);
                codecfmarca = em.merge(codecfmarca);
            }
            Collection<Ecfcodigoid> ecfcodigoidCollection = ecfmodelo.getEcfcodigoidCollection();
            for (Ecfcodigoid ecfcodigoidCollectionEcfcodigoid : ecfcodigoidCollection) {
                ecfcodigoidCollectionEcfcodigoid.setCodecfmodelo(null);
                ecfcodigoidCollectionEcfcodigoid = em.merge(ecfcodigoidCollectionEcfcodigoid);
            }
            em.remove(ecfmodelo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ecfmodelo> findEcfmodeloEntities() {
        return findEcfmodeloEntities(true, -1, -1);
    }

    public List<Ecfmodelo> findEcfmodeloEntities(int maxResults, int firstResult) {
        return findEcfmodeloEntities(false, maxResults, firstResult);
    }

    private List<Ecfmodelo> findEcfmodeloEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ecfmodelo.class));
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

    public Ecfmodelo findEcfmodelo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ecfmodelo.class, id);
        } finally {
            em.close();
        }
    }

    public int getEcfmodeloCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ecfmodelo> rt = cq.from(Ecfmodelo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

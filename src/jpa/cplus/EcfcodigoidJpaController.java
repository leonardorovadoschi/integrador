/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Ecfcodigoid;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Ecfmarca;
import entidade.cplus.Ecfmodelo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class EcfcodigoidJpaController implements Serializable {

    public EcfcodigoidJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ecfcodigoid ecfcodigoid) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ecfmarca codecfmarca = ecfcodigoid.getCodecfmarca();
            if (codecfmarca != null) {
                codecfmarca = em.getReference(codecfmarca.getClass(), codecfmarca.getCodecfmarca());
                ecfcodigoid.setCodecfmarca(codecfmarca);
            }
            Ecfmodelo codecfmodelo = ecfcodigoid.getCodecfmodelo();
            if (codecfmodelo != null) {
                codecfmodelo = em.getReference(codecfmodelo.getClass(), codecfmodelo.getCodecfmodelo());
                ecfcodigoid.setCodecfmodelo(codecfmodelo);
            }
            em.persist(ecfcodigoid);
            if (codecfmarca != null) {
                codecfmarca.getEcfcodigoidCollection().add(ecfcodigoid);
                codecfmarca = em.merge(codecfmarca);
            }
            if (codecfmodelo != null) {
                codecfmodelo.getEcfcodigoidCollection().add(ecfcodigoid);
                codecfmodelo = em.merge(codecfmodelo);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEcfcodigoid(ecfcodigoid.getCodecfcodigoid()) != null) {
                throw new PreexistingEntityException("Ecfcodigoid " + ecfcodigoid + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ecfcodigoid ecfcodigoid) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ecfcodigoid persistentEcfcodigoid = em.find(Ecfcodigoid.class, ecfcodigoid.getCodecfcodigoid());
            Ecfmarca codecfmarcaOld = persistentEcfcodigoid.getCodecfmarca();
            Ecfmarca codecfmarcaNew = ecfcodigoid.getCodecfmarca();
            Ecfmodelo codecfmodeloOld = persistentEcfcodigoid.getCodecfmodelo();
            Ecfmodelo codecfmodeloNew = ecfcodigoid.getCodecfmodelo();
            if (codecfmarcaNew != null) {
                codecfmarcaNew = em.getReference(codecfmarcaNew.getClass(), codecfmarcaNew.getCodecfmarca());
                ecfcodigoid.setCodecfmarca(codecfmarcaNew);
            }
            if (codecfmodeloNew != null) {
                codecfmodeloNew = em.getReference(codecfmodeloNew.getClass(), codecfmodeloNew.getCodecfmodelo());
                ecfcodigoid.setCodecfmodelo(codecfmodeloNew);
            }
            ecfcodigoid = em.merge(ecfcodigoid);
            if (codecfmarcaOld != null && !codecfmarcaOld.equals(codecfmarcaNew)) {
                codecfmarcaOld.getEcfcodigoidCollection().remove(ecfcodigoid);
                codecfmarcaOld = em.merge(codecfmarcaOld);
            }
            if (codecfmarcaNew != null && !codecfmarcaNew.equals(codecfmarcaOld)) {
                codecfmarcaNew.getEcfcodigoidCollection().add(ecfcodigoid);
                codecfmarcaNew = em.merge(codecfmarcaNew);
            }
            if (codecfmodeloOld != null && !codecfmodeloOld.equals(codecfmodeloNew)) {
                codecfmodeloOld.getEcfcodigoidCollection().remove(ecfcodigoid);
                codecfmodeloOld = em.merge(codecfmodeloOld);
            }
            if (codecfmodeloNew != null && !codecfmodeloNew.equals(codecfmodeloOld)) {
                codecfmodeloNew.getEcfcodigoidCollection().add(ecfcodigoid);
                codecfmodeloNew = em.merge(codecfmodeloNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ecfcodigoid.getCodecfcodigoid();
                if (findEcfcodigoid(id) == null) {
                    throw new NonexistentEntityException("The ecfcodigoid with id " + id + " no longer exists.");
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
            Ecfcodigoid ecfcodigoid;
            try {
                ecfcodigoid = em.getReference(Ecfcodigoid.class, id);
                ecfcodigoid.getCodecfcodigoid();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ecfcodigoid with id " + id + " no longer exists.", enfe);
            }
            Ecfmarca codecfmarca = ecfcodigoid.getCodecfmarca();
            if (codecfmarca != null) {
                codecfmarca.getEcfcodigoidCollection().remove(ecfcodigoid);
                codecfmarca = em.merge(codecfmarca);
            }
            Ecfmodelo codecfmodelo = ecfcodigoid.getCodecfmodelo();
            if (codecfmodelo != null) {
                codecfmodelo.getEcfcodigoidCollection().remove(ecfcodigoid);
                codecfmodelo = em.merge(codecfmodelo);
            }
            em.remove(ecfcodigoid);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ecfcodigoid> findEcfcodigoidEntities() {
        return findEcfcodigoidEntities(true, -1, -1);
    }

    public List<Ecfcodigoid> findEcfcodigoidEntities(int maxResults, int firstResult) {
        return findEcfcodigoidEntities(false, maxResults, firstResult);
    }

    private List<Ecfcodigoid> findEcfcodigoidEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ecfcodigoid.class));
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

    public Ecfcodigoid findEcfcodigoid(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ecfcodigoid.class, id);
        } finally {
            em.close();
        }
    }

    public int getEcfcodigoidCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ecfcodigoid> rt = cq.from(Ecfcodigoid.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

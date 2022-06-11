/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Ecf;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Ecfmarca;
import entidade.cplus.Ecfmodelo;
import entidade.cplus.Movecfdocumentocaixa;
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
public class EcfJpaController implements Serializable {

    public EcfJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ecf ecf) throws PreexistingEntityException, Exception {
        if (ecf.getMovecfdocumentocaixaCollection() == null) {
            ecf.setMovecfdocumentocaixaCollection(new ArrayList<Movecfdocumentocaixa>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ecfmarca codecfmarca = ecf.getCodecfmarca();
            if (codecfmarca != null) {
                codecfmarca = em.getReference(codecfmarca.getClass(), codecfmarca.getCodecfmarca());
                ecf.setCodecfmarca(codecfmarca);
            }
            Ecfmodelo codecfmodelo = ecf.getCodecfmodelo();
            if (codecfmodelo != null) {
                codecfmodelo = em.getReference(codecfmodelo.getClass(), codecfmodelo.getCodecfmodelo());
                ecf.setCodecfmodelo(codecfmodelo);
            }
            Collection<Movecfdocumentocaixa> attachedMovecfdocumentocaixaCollection = new ArrayList<Movecfdocumentocaixa>();
            for (Movecfdocumentocaixa movecfdocumentocaixaCollectionMovecfdocumentocaixaToAttach : ecf.getMovecfdocumentocaixaCollection()) {
                movecfdocumentocaixaCollectionMovecfdocumentocaixaToAttach = em.getReference(movecfdocumentocaixaCollectionMovecfdocumentocaixaToAttach.getClass(), movecfdocumentocaixaCollectionMovecfdocumentocaixaToAttach.getCodmovecfdocumentocaixa());
                attachedMovecfdocumentocaixaCollection.add(movecfdocumentocaixaCollectionMovecfdocumentocaixaToAttach);
            }
            ecf.setMovecfdocumentocaixaCollection(attachedMovecfdocumentocaixaCollection);
            em.persist(ecf);
            if (codecfmarca != null) {
                codecfmarca.getEcfCollection().add(ecf);
                codecfmarca = em.merge(codecfmarca);
            }
            if (codecfmodelo != null) {
                codecfmodelo.getEcfCollection().add(ecf);
                codecfmodelo = em.merge(codecfmodelo);
            }
            for (Movecfdocumentocaixa movecfdocumentocaixaCollectionMovecfdocumentocaixa : ecf.getMovecfdocumentocaixaCollection()) {
                Ecf oldCodecfOfMovecfdocumentocaixaCollectionMovecfdocumentocaixa = movecfdocumentocaixaCollectionMovecfdocumentocaixa.getCodecf();
                movecfdocumentocaixaCollectionMovecfdocumentocaixa.setCodecf(ecf);
                movecfdocumentocaixaCollectionMovecfdocumentocaixa = em.merge(movecfdocumentocaixaCollectionMovecfdocumentocaixa);
                if (oldCodecfOfMovecfdocumentocaixaCollectionMovecfdocumentocaixa != null) {
                    oldCodecfOfMovecfdocumentocaixaCollectionMovecfdocumentocaixa.getMovecfdocumentocaixaCollection().remove(movecfdocumentocaixaCollectionMovecfdocumentocaixa);
                    oldCodecfOfMovecfdocumentocaixaCollectionMovecfdocumentocaixa = em.merge(oldCodecfOfMovecfdocumentocaixaCollectionMovecfdocumentocaixa);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEcf(ecf.getCodecf()) != null) {
                throw new PreexistingEntityException("Ecf " + ecf + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ecf ecf) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ecf persistentEcf = em.find(Ecf.class, ecf.getCodecf());
            Ecfmarca codecfmarcaOld = persistentEcf.getCodecfmarca();
            Ecfmarca codecfmarcaNew = ecf.getCodecfmarca();
            Ecfmodelo codecfmodeloOld = persistentEcf.getCodecfmodelo();
            Ecfmodelo codecfmodeloNew = ecf.getCodecfmodelo();
            Collection<Movecfdocumentocaixa> movecfdocumentocaixaCollectionOld = persistentEcf.getMovecfdocumentocaixaCollection();
            Collection<Movecfdocumentocaixa> movecfdocumentocaixaCollectionNew = ecf.getMovecfdocumentocaixaCollection();
            if (codecfmarcaNew != null) {
                codecfmarcaNew = em.getReference(codecfmarcaNew.getClass(), codecfmarcaNew.getCodecfmarca());
                ecf.setCodecfmarca(codecfmarcaNew);
            }
            if (codecfmodeloNew != null) {
                codecfmodeloNew = em.getReference(codecfmodeloNew.getClass(), codecfmodeloNew.getCodecfmodelo());
                ecf.setCodecfmodelo(codecfmodeloNew);
            }
            Collection<Movecfdocumentocaixa> attachedMovecfdocumentocaixaCollectionNew = new ArrayList<Movecfdocumentocaixa>();
            for (Movecfdocumentocaixa movecfdocumentocaixaCollectionNewMovecfdocumentocaixaToAttach : movecfdocumentocaixaCollectionNew) {
                movecfdocumentocaixaCollectionNewMovecfdocumentocaixaToAttach = em.getReference(movecfdocumentocaixaCollectionNewMovecfdocumentocaixaToAttach.getClass(), movecfdocumentocaixaCollectionNewMovecfdocumentocaixaToAttach.getCodmovecfdocumentocaixa());
                attachedMovecfdocumentocaixaCollectionNew.add(movecfdocumentocaixaCollectionNewMovecfdocumentocaixaToAttach);
            }
            movecfdocumentocaixaCollectionNew = attachedMovecfdocumentocaixaCollectionNew;
            ecf.setMovecfdocumentocaixaCollection(movecfdocumentocaixaCollectionNew);
            ecf = em.merge(ecf);
            if (codecfmarcaOld != null && !codecfmarcaOld.equals(codecfmarcaNew)) {
                codecfmarcaOld.getEcfCollection().remove(ecf);
                codecfmarcaOld = em.merge(codecfmarcaOld);
            }
            if (codecfmarcaNew != null && !codecfmarcaNew.equals(codecfmarcaOld)) {
                codecfmarcaNew.getEcfCollection().add(ecf);
                codecfmarcaNew = em.merge(codecfmarcaNew);
            }
            if (codecfmodeloOld != null && !codecfmodeloOld.equals(codecfmodeloNew)) {
                codecfmodeloOld.getEcfCollection().remove(ecf);
                codecfmodeloOld = em.merge(codecfmodeloOld);
            }
            if (codecfmodeloNew != null && !codecfmodeloNew.equals(codecfmodeloOld)) {
                codecfmodeloNew.getEcfCollection().add(ecf);
                codecfmodeloNew = em.merge(codecfmodeloNew);
            }
            for (Movecfdocumentocaixa movecfdocumentocaixaCollectionOldMovecfdocumentocaixa : movecfdocumentocaixaCollectionOld) {
                if (!movecfdocumentocaixaCollectionNew.contains(movecfdocumentocaixaCollectionOldMovecfdocumentocaixa)) {
                    movecfdocumentocaixaCollectionOldMovecfdocumentocaixa.setCodecf(null);
                    movecfdocumentocaixaCollectionOldMovecfdocumentocaixa = em.merge(movecfdocumentocaixaCollectionOldMovecfdocumentocaixa);
                }
            }
            for (Movecfdocumentocaixa movecfdocumentocaixaCollectionNewMovecfdocumentocaixa : movecfdocumentocaixaCollectionNew) {
                if (!movecfdocumentocaixaCollectionOld.contains(movecfdocumentocaixaCollectionNewMovecfdocumentocaixa)) {
                    Ecf oldCodecfOfMovecfdocumentocaixaCollectionNewMovecfdocumentocaixa = movecfdocumentocaixaCollectionNewMovecfdocumentocaixa.getCodecf();
                    movecfdocumentocaixaCollectionNewMovecfdocumentocaixa.setCodecf(ecf);
                    movecfdocumentocaixaCollectionNewMovecfdocumentocaixa = em.merge(movecfdocumentocaixaCollectionNewMovecfdocumentocaixa);
                    if (oldCodecfOfMovecfdocumentocaixaCollectionNewMovecfdocumentocaixa != null && !oldCodecfOfMovecfdocumentocaixaCollectionNewMovecfdocumentocaixa.equals(ecf)) {
                        oldCodecfOfMovecfdocumentocaixaCollectionNewMovecfdocumentocaixa.getMovecfdocumentocaixaCollection().remove(movecfdocumentocaixaCollectionNewMovecfdocumentocaixa);
                        oldCodecfOfMovecfdocumentocaixaCollectionNewMovecfdocumentocaixa = em.merge(oldCodecfOfMovecfdocumentocaixaCollectionNewMovecfdocumentocaixa);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = ecf.getCodecf();
                if (findEcf(id) == null) {
                    throw new NonexistentEntityException("The ecf with id " + id + " no longer exists.");
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
            Ecf ecf;
            try {
                ecf = em.getReference(Ecf.class, id);
                ecf.getCodecf();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ecf with id " + id + " no longer exists.", enfe);
            }
            Ecfmarca codecfmarca = ecf.getCodecfmarca();
            if (codecfmarca != null) {
                codecfmarca.getEcfCollection().remove(ecf);
                codecfmarca = em.merge(codecfmarca);
            }
            Ecfmodelo codecfmodelo = ecf.getCodecfmodelo();
            if (codecfmodelo != null) {
                codecfmodelo.getEcfCollection().remove(ecf);
                codecfmodelo = em.merge(codecfmodelo);
            }
            Collection<Movecfdocumentocaixa> movecfdocumentocaixaCollection = ecf.getMovecfdocumentocaixaCollection();
            for (Movecfdocumentocaixa movecfdocumentocaixaCollectionMovecfdocumentocaixa : movecfdocumentocaixaCollection) {
                movecfdocumentocaixaCollectionMovecfdocumentocaixa.setCodecf(null);
                movecfdocumentocaixaCollectionMovecfdocumentocaixa = em.merge(movecfdocumentocaixaCollectionMovecfdocumentocaixa);
            }
            em.remove(ecf);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ecf> findEcfEntities() {
        return findEcfEntities(true, -1, -1);
    }

    public List<Ecf> findEcfEntities(int maxResults, int firstResult) {
        return findEcfEntities(false, maxResults, firstResult);
    }

    private List<Ecf> findEcfEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ecf.class));
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

    public Ecf findEcf(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ecf.class, id);
        } finally {
            em.close();
        }
    }

    public int getEcfCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ecf> rt = cq.from(Ecf.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

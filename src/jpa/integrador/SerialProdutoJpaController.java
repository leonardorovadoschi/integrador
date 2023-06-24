/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jpa.integrador;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.integrador.SaidaSerial;
import java.util.ArrayList;
import java.util.Collection;
import entidade.integrador.EntradaSerial;
import entidade.integrador.SerialProduto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.integrador.exceptions.NonexistentEntityException;

/**
 *
 * @author leonardo
 */
public class SerialProdutoJpaController implements Serializable {

    public SerialProdutoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(SerialProduto serialProduto) {
        if (serialProduto.getSaidaSerialCollection() == null) {
            serialProduto.setSaidaSerialCollection(new ArrayList<SaidaSerial>());
        }
        if (serialProduto.getEntradaSerialCollection() == null) {
            serialProduto.setEntradaSerialCollection(new ArrayList<EntradaSerial>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<SaidaSerial> attachedSaidaSerialCollection = new ArrayList<SaidaSerial>();
            for (SaidaSerial saidaSerialCollectionSaidaSerialToAttach : serialProduto.getSaidaSerialCollection()) {
                saidaSerialCollectionSaidaSerialToAttach = em.getReference(saidaSerialCollectionSaidaSerialToAttach.getClass(), saidaSerialCollectionSaidaSerialToAttach.getIdSaidaSerial());
                attachedSaidaSerialCollection.add(saidaSerialCollectionSaidaSerialToAttach);
            }
            serialProduto.setSaidaSerialCollection(attachedSaidaSerialCollection);
            Collection<EntradaSerial> attachedEntradaSerialCollection = new ArrayList<EntradaSerial>();
            for (EntradaSerial entradaSerialCollectionEntradaSerialToAttach : serialProduto.getEntradaSerialCollection()) {
                entradaSerialCollectionEntradaSerialToAttach = em.getReference(entradaSerialCollectionEntradaSerialToAttach.getClass(), entradaSerialCollectionEntradaSerialToAttach.getIdEntradaSerial());
                attachedEntradaSerialCollection.add(entradaSerialCollectionEntradaSerialToAttach);
            }
            serialProduto.setEntradaSerialCollection(attachedEntradaSerialCollection);
            em.persist(serialProduto);
            for (SaidaSerial saidaSerialCollectionSaidaSerial : serialProduto.getSaidaSerialCollection()) {
                SerialProduto oldIdSerialOfSaidaSerialCollectionSaidaSerial = saidaSerialCollectionSaidaSerial.getIdSerial();
                saidaSerialCollectionSaidaSerial.setIdSerial(serialProduto);
                saidaSerialCollectionSaidaSerial = em.merge(saidaSerialCollectionSaidaSerial);
                if (oldIdSerialOfSaidaSerialCollectionSaidaSerial != null) {
                    oldIdSerialOfSaidaSerialCollectionSaidaSerial.getSaidaSerialCollection().remove(saidaSerialCollectionSaidaSerial);
                    oldIdSerialOfSaidaSerialCollectionSaidaSerial = em.merge(oldIdSerialOfSaidaSerialCollectionSaidaSerial);
                }
            }
            for (EntradaSerial entradaSerialCollectionEntradaSerial : serialProduto.getEntradaSerialCollection()) {
                SerialProduto oldIdSerialOfEntradaSerialCollectionEntradaSerial = entradaSerialCollectionEntradaSerial.getIdSerial();
                entradaSerialCollectionEntradaSerial.setIdSerial(serialProduto);
                entradaSerialCollectionEntradaSerial = em.merge(entradaSerialCollectionEntradaSerial);
                if (oldIdSerialOfEntradaSerialCollectionEntradaSerial != null) {
                    oldIdSerialOfEntradaSerialCollectionEntradaSerial.getEntradaSerialCollection().remove(entradaSerialCollectionEntradaSerial);
                    oldIdSerialOfEntradaSerialCollectionEntradaSerial = em.merge(oldIdSerialOfEntradaSerialCollectionEntradaSerial);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(SerialProduto serialProduto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SerialProduto persistentSerialProduto = em.find(SerialProduto.class, serialProduto.getIdSerial());
            Collection<SaidaSerial> saidaSerialCollectionOld = persistentSerialProduto.getSaidaSerialCollection();
            Collection<SaidaSerial> saidaSerialCollectionNew = serialProduto.getSaidaSerialCollection();
            Collection<EntradaSerial> entradaSerialCollectionOld = persistentSerialProduto.getEntradaSerialCollection();
            Collection<EntradaSerial> entradaSerialCollectionNew = serialProduto.getEntradaSerialCollection();
            Collection<SaidaSerial> attachedSaidaSerialCollectionNew = new ArrayList<SaidaSerial>();
            for (SaidaSerial saidaSerialCollectionNewSaidaSerialToAttach : saidaSerialCollectionNew) {
                saidaSerialCollectionNewSaidaSerialToAttach = em.getReference(saidaSerialCollectionNewSaidaSerialToAttach.getClass(), saidaSerialCollectionNewSaidaSerialToAttach.getIdSaidaSerial());
                attachedSaidaSerialCollectionNew.add(saidaSerialCollectionNewSaidaSerialToAttach);
            }
            saidaSerialCollectionNew = attachedSaidaSerialCollectionNew;
            serialProduto.setSaidaSerialCollection(saidaSerialCollectionNew);
            Collection<EntradaSerial> attachedEntradaSerialCollectionNew = new ArrayList<EntradaSerial>();
            for (EntradaSerial entradaSerialCollectionNewEntradaSerialToAttach : entradaSerialCollectionNew) {
                entradaSerialCollectionNewEntradaSerialToAttach = em.getReference(entradaSerialCollectionNewEntradaSerialToAttach.getClass(), entradaSerialCollectionNewEntradaSerialToAttach.getIdEntradaSerial());
                attachedEntradaSerialCollectionNew.add(entradaSerialCollectionNewEntradaSerialToAttach);
            }
            entradaSerialCollectionNew = attachedEntradaSerialCollectionNew;
            serialProduto.setEntradaSerialCollection(entradaSerialCollectionNew);
            serialProduto = em.merge(serialProduto);
            for (SaidaSerial saidaSerialCollectionOldSaidaSerial : saidaSerialCollectionOld) {
                if (!saidaSerialCollectionNew.contains(saidaSerialCollectionOldSaidaSerial)) {
                    saidaSerialCollectionOldSaidaSerial.setIdSerial(null);
                    saidaSerialCollectionOldSaidaSerial = em.merge(saidaSerialCollectionOldSaidaSerial);
                }
            }
            for (SaidaSerial saidaSerialCollectionNewSaidaSerial : saidaSerialCollectionNew) {
                if (!saidaSerialCollectionOld.contains(saidaSerialCollectionNewSaidaSerial)) {
                    SerialProduto oldIdSerialOfSaidaSerialCollectionNewSaidaSerial = saidaSerialCollectionNewSaidaSerial.getIdSerial();
                    saidaSerialCollectionNewSaidaSerial.setIdSerial(serialProduto);
                    saidaSerialCollectionNewSaidaSerial = em.merge(saidaSerialCollectionNewSaidaSerial);
                    if (oldIdSerialOfSaidaSerialCollectionNewSaidaSerial != null && !oldIdSerialOfSaidaSerialCollectionNewSaidaSerial.equals(serialProduto)) {
                        oldIdSerialOfSaidaSerialCollectionNewSaidaSerial.getSaidaSerialCollection().remove(saidaSerialCollectionNewSaidaSerial);
                        oldIdSerialOfSaidaSerialCollectionNewSaidaSerial = em.merge(oldIdSerialOfSaidaSerialCollectionNewSaidaSerial);
                    }
                }
            }
            for (EntradaSerial entradaSerialCollectionOldEntradaSerial : entradaSerialCollectionOld) {
                if (!entradaSerialCollectionNew.contains(entradaSerialCollectionOldEntradaSerial)) {
                    entradaSerialCollectionOldEntradaSerial.setIdSerial(null);
                    entradaSerialCollectionOldEntradaSerial = em.merge(entradaSerialCollectionOldEntradaSerial);
                }
            }
            for (EntradaSerial entradaSerialCollectionNewEntradaSerial : entradaSerialCollectionNew) {
                if (!entradaSerialCollectionOld.contains(entradaSerialCollectionNewEntradaSerial)) {
                    SerialProduto oldIdSerialOfEntradaSerialCollectionNewEntradaSerial = entradaSerialCollectionNewEntradaSerial.getIdSerial();
                    entradaSerialCollectionNewEntradaSerial.setIdSerial(serialProduto);
                    entradaSerialCollectionNewEntradaSerial = em.merge(entradaSerialCollectionNewEntradaSerial);
                    if (oldIdSerialOfEntradaSerialCollectionNewEntradaSerial != null && !oldIdSerialOfEntradaSerialCollectionNewEntradaSerial.equals(serialProduto)) {
                        oldIdSerialOfEntradaSerialCollectionNewEntradaSerial.getEntradaSerialCollection().remove(entradaSerialCollectionNewEntradaSerial);
                        oldIdSerialOfEntradaSerialCollectionNewEntradaSerial = em.merge(oldIdSerialOfEntradaSerialCollectionNewEntradaSerial);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = serialProduto.getIdSerial();
                if (findSerialProduto(id) == null) {
                    throw new NonexistentEntityException("The serialProduto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            SerialProduto serialProduto;
            try {
                serialProduto = em.getReference(SerialProduto.class, id);
                serialProduto.getIdSerial();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The serialProduto with id " + id + " no longer exists.", enfe);
            }
            Collection<SaidaSerial> saidaSerialCollection = serialProduto.getSaidaSerialCollection();
            for (SaidaSerial saidaSerialCollectionSaidaSerial : saidaSerialCollection) {
                saidaSerialCollectionSaidaSerial.setIdSerial(null);
                saidaSerialCollectionSaidaSerial = em.merge(saidaSerialCollectionSaidaSerial);
            }
            Collection<EntradaSerial> entradaSerialCollection = serialProduto.getEntradaSerialCollection();
            for (EntradaSerial entradaSerialCollectionEntradaSerial : entradaSerialCollection) {
                entradaSerialCollectionEntradaSerial.setIdSerial(null);
                entradaSerialCollectionEntradaSerial = em.merge(entradaSerialCollectionEntradaSerial);
            }
            em.remove(serialProduto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<SerialProduto> findSerialProdutoEntities() {
        return findSerialProdutoEntities(true, -1, -1);
    }

    public List<SerialProduto> findSerialProdutoEntities(int maxResults, int firstResult) {
        return findSerialProdutoEntities(false, maxResults, firstResult);
    }

    private List<SerialProduto> findSerialProdutoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(SerialProduto.class));
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

    public SerialProduto findSerialProduto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(SerialProduto.class, id);
        } finally {
            em.close();
        }
    }

    public int getSerialProdutoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<SerialProduto> rt = cq.from(SerialProduto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

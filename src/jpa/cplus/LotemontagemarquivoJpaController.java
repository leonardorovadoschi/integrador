/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Lotemontagemarquivo;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Montagemarquivoitem;
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
public class LotemontagemarquivoJpaController implements Serializable {

    public LotemontagemarquivoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Lotemontagemarquivo lotemontagemarquivo) throws PreexistingEntityException, Exception {
        if (lotemontagemarquivo.getMontagemarquivoitemCollection() == null) {
            lotemontagemarquivo.setMontagemarquivoitemCollection(new ArrayList<Montagemarquivoitem>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Montagemarquivoitem> attachedMontagemarquivoitemCollection = new ArrayList<Montagemarquivoitem>();
            for (Montagemarquivoitem montagemarquivoitemCollectionMontagemarquivoitemToAttach : lotemontagemarquivo.getMontagemarquivoitemCollection()) {
                montagemarquivoitemCollectionMontagemarquivoitemToAttach = em.getReference(montagemarquivoitemCollectionMontagemarquivoitemToAttach.getClass(), montagemarquivoitemCollectionMontagemarquivoitemToAttach.getCodmontagemarquivoitem());
                attachedMontagemarquivoitemCollection.add(montagemarquivoitemCollectionMontagemarquivoitemToAttach);
            }
            lotemontagemarquivo.setMontagemarquivoitemCollection(attachedMontagemarquivoitemCollection);
            em.persist(lotemontagemarquivo);
            for (Montagemarquivoitem montagemarquivoitemCollectionMontagemarquivoitem : lotemontagemarquivo.getMontagemarquivoitemCollection()) {
                Lotemontagemarquivo oldCodlotemontagemarquivoOfMontagemarquivoitemCollectionMontagemarquivoitem = montagemarquivoitemCollectionMontagemarquivoitem.getCodlotemontagemarquivo();
                montagemarquivoitemCollectionMontagemarquivoitem.setCodlotemontagemarquivo(lotemontagemarquivo);
                montagemarquivoitemCollectionMontagemarquivoitem = em.merge(montagemarquivoitemCollectionMontagemarquivoitem);
                if (oldCodlotemontagemarquivoOfMontagemarquivoitemCollectionMontagemarquivoitem != null) {
                    oldCodlotemontagemarquivoOfMontagemarquivoitemCollectionMontagemarquivoitem.getMontagemarquivoitemCollection().remove(montagemarquivoitemCollectionMontagemarquivoitem);
                    oldCodlotemontagemarquivoOfMontagemarquivoitemCollectionMontagemarquivoitem = em.merge(oldCodlotemontagemarquivoOfMontagemarquivoitemCollectionMontagemarquivoitem);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLotemontagemarquivo(lotemontagemarquivo.getCodlotemontagemarquivo()) != null) {
                throw new PreexistingEntityException("Lotemontagemarquivo " + lotemontagemarquivo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Lotemontagemarquivo lotemontagemarquivo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Lotemontagemarquivo persistentLotemontagemarquivo = em.find(Lotemontagemarquivo.class, lotemontagemarquivo.getCodlotemontagemarquivo());
            Collection<Montagemarquivoitem> montagemarquivoitemCollectionOld = persistentLotemontagemarquivo.getMontagemarquivoitemCollection();
            Collection<Montagemarquivoitem> montagemarquivoitemCollectionNew = lotemontagemarquivo.getMontagemarquivoitemCollection();
            Collection<Montagemarquivoitem> attachedMontagemarquivoitemCollectionNew = new ArrayList<Montagemarquivoitem>();
            for (Montagemarquivoitem montagemarquivoitemCollectionNewMontagemarquivoitemToAttach : montagemarquivoitemCollectionNew) {
                montagemarquivoitemCollectionNewMontagemarquivoitemToAttach = em.getReference(montagemarquivoitemCollectionNewMontagemarquivoitemToAttach.getClass(), montagemarquivoitemCollectionNewMontagemarquivoitemToAttach.getCodmontagemarquivoitem());
                attachedMontagemarquivoitemCollectionNew.add(montagemarquivoitemCollectionNewMontagemarquivoitemToAttach);
            }
            montagemarquivoitemCollectionNew = attachedMontagemarquivoitemCollectionNew;
            lotemontagemarquivo.setMontagemarquivoitemCollection(montagemarquivoitemCollectionNew);
            lotemontagemarquivo = em.merge(lotemontagemarquivo);
            for (Montagemarquivoitem montagemarquivoitemCollectionOldMontagemarquivoitem : montagemarquivoitemCollectionOld) {
                if (!montagemarquivoitemCollectionNew.contains(montagemarquivoitemCollectionOldMontagemarquivoitem)) {
                    montagemarquivoitemCollectionOldMontagemarquivoitem.setCodlotemontagemarquivo(null);
                    montagemarquivoitemCollectionOldMontagemarquivoitem = em.merge(montagemarquivoitemCollectionOldMontagemarquivoitem);
                }
            }
            for (Montagemarquivoitem montagemarquivoitemCollectionNewMontagemarquivoitem : montagemarquivoitemCollectionNew) {
                if (!montagemarquivoitemCollectionOld.contains(montagemarquivoitemCollectionNewMontagemarquivoitem)) {
                    Lotemontagemarquivo oldCodlotemontagemarquivoOfMontagemarquivoitemCollectionNewMontagemarquivoitem = montagemarquivoitemCollectionNewMontagemarquivoitem.getCodlotemontagemarquivo();
                    montagemarquivoitemCollectionNewMontagemarquivoitem.setCodlotemontagemarquivo(lotemontagemarquivo);
                    montagemarquivoitemCollectionNewMontagemarquivoitem = em.merge(montagemarquivoitemCollectionNewMontagemarquivoitem);
                    if (oldCodlotemontagemarquivoOfMontagemarquivoitemCollectionNewMontagemarquivoitem != null && !oldCodlotemontagemarquivoOfMontagemarquivoitemCollectionNewMontagemarquivoitem.equals(lotemontagemarquivo)) {
                        oldCodlotemontagemarquivoOfMontagemarquivoitemCollectionNewMontagemarquivoitem.getMontagemarquivoitemCollection().remove(montagemarquivoitemCollectionNewMontagemarquivoitem);
                        oldCodlotemontagemarquivoOfMontagemarquivoitemCollectionNewMontagemarquivoitem = em.merge(oldCodlotemontagemarquivoOfMontagemarquivoitemCollectionNewMontagemarquivoitem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = lotemontagemarquivo.getCodlotemontagemarquivo();
                if (findLotemontagemarquivo(id) == null) {
                    throw new NonexistentEntityException("The lotemontagemarquivo with id " + id + " no longer exists.");
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
            Lotemontagemarquivo lotemontagemarquivo;
            try {
                lotemontagemarquivo = em.getReference(Lotemontagemarquivo.class, id);
                lotemontagemarquivo.getCodlotemontagemarquivo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The lotemontagemarquivo with id " + id + " no longer exists.", enfe);
            }
            Collection<Montagemarquivoitem> montagemarquivoitemCollection = lotemontagemarquivo.getMontagemarquivoitemCollection();
            for (Montagemarquivoitem montagemarquivoitemCollectionMontagemarquivoitem : montagemarquivoitemCollection) {
                montagemarquivoitemCollectionMontagemarquivoitem.setCodlotemontagemarquivo(null);
                montagemarquivoitemCollectionMontagemarquivoitem = em.merge(montagemarquivoitemCollectionMontagemarquivoitem);
            }
            em.remove(lotemontagemarquivo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Lotemontagemarquivo> findLotemontagemarquivoEntities() {
        return findLotemontagemarquivoEntities(true, -1, -1);
    }

    public List<Lotemontagemarquivo> findLotemontagemarquivoEntities(int maxResults, int firstResult) {
        return findLotemontagemarquivoEntities(false, maxResults, firstResult);
    }

    private List<Lotemontagemarquivo> findLotemontagemarquivoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Lotemontagemarquivo.class));
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

    public Lotemontagemarquivo findLotemontagemarquivo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Lotemontagemarquivo.class, id);
        } finally {
            em.close();
        }
    }

    public int getLotemontagemarquivoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Lotemontagemarquivo> rt = cq.from(Lotemontagemarquivo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

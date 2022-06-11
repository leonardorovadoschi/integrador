/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Cor;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Pedidoitem;
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
public class CorJpaController implements Serializable {

    public CorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cor cor) throws PreexistingEntityException, Exception {
        if (cor.getPedidoitemCollection() == null) {
            cor.setPedidoitemCollection(new ArrayList<Pedidoitem>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Pedidoitem> attachedPedidoitemCollection = new ArrayList<Pedidoitem>();
            for (Pedidoitem pedidoitemCollectionPedidoitemToAttach : cor.getPedidoitemCollection()) {
                pedidoitemCollectionPedidoitemToAttach = em.getReference(pedidoitemCollectionPedidoitemToAttach.getClass(), pedidoitemCollectionPedidoitemToAttach.getCodpedidoitem());
                attachedPedidoitemCollection.add(pedidoitemCollectionPedidoitemToAttach);
            }
            cor.setPedidoitemCollection(attachedPedidoitemCollection);
            em.persist(cor);
            for (Pedidoitem pedidoitemCollectionPedidoitem : cor.getPedidoitemCollection()) {
                Cor oldCodcorOfPedidoitemCollectionPedidoitem = pedidoitemCollectionPedidoitem.getCodcor();
                pedidoitemCollectionPedidoitem.setCodcor(cor);
                pedidoitemCollectionPedidoitem = em.merge(pedidoitemCollectionPedidoitem);
                if (oldCodcorOfPedidoitemCollectionPedidoitem != null) {
                    oldCodcorOfPedidoitemCollectionPedidoitem.getPedidoitemCollection().remove(pedidoitemCollectionPedidoitem);
                    oldCodcorOfPedidoitemCollectionPedidoitem = em.merge(oldCodcorOfPedidoitemCollectionPedidoitem);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCor(cor.getCodcor()) != null) {
                throw new PreexistingEntityException("Cor " + cor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cor cor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cor persistentCor = em.find(Cor.class, cor.getCodcor());
            Collection<Pedidoitem> pedidoitemCollectionOld = persistentCor.getPedidoitemCollection();
            Collection<Pedidoitem> pedidoitemCollectionNew = cor.getPedidoitemCollection();
            Collection<Pedidoitem> attachedPedidoitemCollectionNew = new ArrayList<Pedidoitem>();
            for (Pedidoitem pedidoitemCollectionNewPedidoitemToAttach : pedidoitemCollectionNew) {
                pedidoitemCollectionNewPedidoitemToAttach = em.getReference(pedidoitemCollectionNewPedidoitemToAttach.getClass(), pedidoitemCollectionNewPedidoitemToAttach.getCodpedidoitem());
                attachedPedidoitemCollectionNew.add(pedidoitemCollectionNewPedidoitemToAttach);
            }
            pedidoitemCollectionNew = attachedPedidoitemCollectionNew;
            cor.setPedidoitemCollection(pedidoitemCollectionNew);
            cor = em.merge(cor);
            for (Pedidoitem pedidoitemCollectionOldPedidoitem : pedidoitemCollectionOld) {
                if (!pedidoitemCollectionNew.contains(pedidoitemCollectionOldPedidoitem)) {
                    pedidoitemCollectionOldPedidoitem.setCodcor(null);
                    pedidoitemCollectionOldPedidoitem = em.merge(pedidoitemCollectionOldPedidoitem);
                }
            }
            for (Pedidoitem pedidoitemCollectionNewPedidoitem : pedidoitemCollectionNew) {
                if (!pedidoitemCollectionOld.contains(pedidoitemCollectionNewPedidoitem)) {
                    Cor oldCodcorOfPedidoitemCollectionNewPedidoitem = pedidoitemCollectionNewPedidoitem.getCodcor();
                    pedidoitemCollectionNewPedidoitem.setCodcor(cor);
                    pedidoitemCollectionNewPedidoitem = em.merge(pedidoitemCollectionNewPedidoitem);
                    if (oldCodcorOfPedidoitemCollectionNewPedidoitem != null && !oldCodcorOfPedidoitemCollectionNewPedidoitem.equals(cor)) {
                        oldCodcorOfPedidoitemCollectionNewPedidoitem.getPedidoitemCollection().remove(pedidoitemCollectionNewPedidoitem);
                        oldCodcorOfPedidoitemCollectionNewPedidoitem = em.merge(oldCodcorOfPedidoitemCollectionNewPedidoitem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cor.getCodcor();
                if (findCor(id) == null) {
                    throw new NonexistentEntityException("The cor with id " + id + " no longer exists.");
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
            Cor cor;
            try {
                cor = em.getReference(Cor.class, id);
                cor.getCodcor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cor with id " + id + " no longer exists.", enfe);
            }
            Collection<Pedidoitem> pedidoitemCollection = cor.getPedidoitemCollection();
            for (Pedidoitem pedidoitemCollectionPedidoitem : pedidoitemCollection) {
                pedidoitemCollectionPedidoitem.setCodcor(null);
                pedidoitemCollectionPedidoitem = em.merge(pedidoitemCollectionPedidoitem);
            }
            em.remove(cor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cor> findCorEntities() {
        return findCorEntities(true, -1, -1);
    }

    public List<Cor> findCorEntities(int maxResults, int firstResult) {
        return findCorEntities(false, maxResults, firstResult);
    }

    private List<Cor> findCorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cor.class));
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

    public Cor findCor(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cor.class, id);
        } finally {
            em.close();
        }
    }

    public int getCorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cor> rt = cq.from(Cor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

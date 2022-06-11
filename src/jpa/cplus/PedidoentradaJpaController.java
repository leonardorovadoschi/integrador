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
import entidade.cplus.Moventradaprod;
import entidade.cplus.Pedidoentrada;
import entidade.cplus.Pedidoitem;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class PedidoentradaJpaController implements Serializable {

    public PedidoentradaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pedidoentrada pedidoentrada) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Moventradaprod codmoveprod = pedidoentrada.getCodmoveprod();
            if (codmoveprod != null) {
                codmoveprod = em.getReference(codmoveprod.getClass(), codmoveprod.getCodmoveprod());
                pedidoentrada.setCodmoveprod(codmoveprod);
            }
            Pedidoitem codpedidoitem = pedidoentrada.getCodpedidoitem();
            if (codpedidoitem != null) {
                codpedidoitem = em.getReference(codpedidoitem.getClass(), codpedidoitem.getCodpedidoitem());
                pedidoentrada.setCodpedidoitem(codpedidoitem);
            }
            em.persist(pedidoentrada);
            if (codmoveprod != null) {
                codmoveprod.getPedidoentradaCollection().add(pedidoentrada);
                codmoveprod = em.merge(codmoveprod);
            }
            if (codpedidoitem != null) {
                codpedidoitem.getPedidoentradaCollection().add(pedidoentrada);
                codpedidoitem = em.merge(codpedidoitem);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPedidoentrada(pedidoentrada.getCodpedidoentrada()) != null) {
                throw new PreexistingEntityException("Pedidoentrada " + pedidoentrada + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pedidoentrada pedidoentrada) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedidoentrada persistentPedidoentrada = em.find(Pedidoentrada.class, pedidoentrada.getCodpedidoentrada());
            Moventradaprod codmoveprodOld = persistentPedidoentrada.getCodmoveprod();
            Moventradaprod codmoveprodNew = pedidoentrada.getCodmoveprod();
            Pedidoitem codpedidoitemOld = persistentPedidoentrada.getCodpedidoitem();
            Pedidoitem codpedidoitemNew = pedidoentrada.getCodpedidoitem();
            if (codmoveprodNew != null) {
                codmoveprodNew = em.getReference(codmoveprodNew.getClass(), codmoveprodNew.getCodmoveprod());
                pedidoentrada.setCodmoveprod(codmoveprodNew);
            }
            if (codpedidoitemNew != null) {
                codpedidoitemNew = em.getReference(codpedidoitemNew.getClass(), codpedidoitemNew.getCodpedidoitem());
                pedidoentrada.setCodpedidoitem(codpedidoitemNew);
            }
            pedidoentrada = em.merge(pedidoentrada);
            if (codmoveprodOld != null && !codmoveprodOld.equals(codmoveprodNew)) {
                codmoveprodOld.getPedidoentradaCollection().remove(pedidoentrada);
                codmoveprodOld = em.merge(codmoveprodOld);
            }
            if (codmoveprodNew != null && !codmoveprodNew.equals(codmoveprodOld)) {
                codmoveprodNew.getPedidoentradaCollection().add(pedidoentrada);
                codmoveprodNew = em.merge(codmoveprodNew);
            }
            if (codpedidoitemOld != null && !codpedidoitemOld.equals(codpedidoitemNew)) {
                codpedidoitemOld.getPedidoentradaCollection().remove(pedidoentrada);
                codpedidoitemOld = em.merge(codpedidoitemOld);
            }
            if (codpedidoitemNew != null && !codpedidoitemNew.equals(codpedidoitemOld)) {
                codpedidoitemNew.getPedidoentradaCollection().add(pedidoentrada);
                codpedidoitemNew = em.merge(codpedidoitemNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = pedidoentrada.getCodpedidoentrada();
                if (findPedidoentrada(id) == null) {
                    throw new NonexistentEntityException("The pedidoentrada with id " + id + " no longer exists.");
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
            Pedidoentrada pedidoentrada;
            try {
                pedidoentrada = em.getReference(Pedidoentrada.class, id);
                pedidoentrada.getCodpedidoentrada();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pedidoentrada with id " + id + " no longer exists.", enfe);
            }
            Moventradaprod codmoveprod = pedidoentrada.getCodmoveprod();
            if (codmoveprod != null) {
                codmoveprod.getPedidoentradaCollection().remove(pedidoentrada);
                codmoveprod = em.merge(codmoveprod);
            }
            Pedidoitem codpedidoitem = pedidoentrada.getCodpedidoitem();
            if (codpedidoitem != null) {
                codpedidoitem.getPedidoentradaCollection().remove(pedidoentrada);
                codpedidoitem = em.merge(codpedidoitem);
            }
            em.remove(pedidoentrada);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pedidoentrada> findPedidoentradaEntities() {
        return findPedidoentradaEntities(true, -1, -1);
    }

    public List<Pedidoentrada> findPedidoentradaEntities(int maxResults, int firstResult) {
        return findPedidoentradaEntities(false, maxResults, firstResult);
    }

    private List<Pedidoentrada> findPedidoentradaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pedidoentrada.class));
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

    public Pedidoentrada findPedidoentrada(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pedidoentrada.class, id);
        } finally {
            em.close();
        }
    }

    public int getPedidoentradaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pedidoentrada> rt = cq.from(Pedidoentrada.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

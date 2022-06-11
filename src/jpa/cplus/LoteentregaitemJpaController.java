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
import entidade.cplus.Loteentrega;
import entidade.cplus.Loteentregaitem;
import entidade.cplus.Movenda;
import entidade.cplus.Movendaprod;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class LoteentregaitemJpaController implements Serializable {

    public LoteentregaitemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Loteentregaitem loteentregaitem) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Loteentrega codloteentrega = loteentregaitem.getCodloteentrega();
            if (codloteentrega != null) {
                codloteentrega = em.getReference(codloteentrega.getClass(), codloteentrega.getCodloteentrega());
                loteentregaitem.setCodloteentrega(codloteentrega);
            }
            Movenda codmovenda = loteentregaitem.getCodmovenda();
            if (codmovenda != null) {
                codmovenda = em.getReference(codmovenda.getClass(), codmovenda.getCodmovenda());
                loteentregaitem.setCodmovenda(codmovenda);
            }
            Movendaprod codmovprod = loteentregaitem.getCodmovprod();
            if (codmovprod != null) {
                codmovprod = em.getReference(codmovprod.getClass(), codmovprod.getCodmovprod());
                loteentregaitem.setCodmovprod(codmovprod);
            }
            em.persist(loteentregaitem);
            if (codloteentrega != null) {
                codloteentrega.getLoteentregaitemCollection().add(loteentregaitem);
                codloteentrega = em.merge(codloteentrega);
            }
            if (codmovenda != null) {
                codmovenda.getLoteentregaitemCollection().add(loteentregaitem);
                codmovenda = em.merge(codmovenda);
            }
            if (codmovprod != null) {
                codmovprod.getLoteentregaitemCollection().add(loteentregaitem);
                codmovprod = em.merge(codmovprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLoteentregaitem(loteentregaitem.getCodloteentregaitem()) != null) {
                throw new PreexistingEntityException("Loteentregaitem " + loteentregaitem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Loteentregaitem loteentregaitem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Loteentregaitem persistentLoteentregaitem = em.find(Loteentregaitem.class, loteentregaitem.getCodloteentregaitem());
            Loteentrega codloteentregaOld = persistentLoteentregaitem.getCodloteentrega();
            Loteentrega codloteentregaNew = loteentregaitem.getCodloteentrega();
            Movenda codmovendaOld = persistentLoteentregaitem.getCodmovenda();
            Movenda codmovendaNew = loteentregaitem.getCodmovenda();
            Movendaprod codmovprodOld = persistentLoteentregaitem.getCodmovprod();
            Movendaprod codmovprodNew = loteentregaitem.getCodmovprod();
            if (codloteentregaNew != null) {
                codloteentregaNew = em.getReference(codloteentregaNew.getClass(), codloteentregaNew.getCodloteentrega());
                loteentregaitem.setCodloteentrega(codloteentregaNew);
            }
            if (codmovendaNew != null) {
                codmovendaNew = em.getReference(codmovendaNew.getClass(), codmovendaNew.getCodmovenda());
                loteentregaitem.setCodmovenda(codmovendaNew);
            }
            if (codmovprodNew != null) {
                codmovprodNew = em.getReference(codmovprodNew.getClass(), codmovprodNew.getCodmovprod());
                loteentregaitem.setCodmovprod(codmovprodNew);
            }
            loteentregaitem = em.merge(loteentregaitem);
            if (codloteentregaOld != null && !codloteentregaOld.equals(codloteentregaNew)) {
                codloteentregaOld.getLoteentregaitemCollection().remove(loteentregaitem);
                codloteentregaOld = em.merge(codloteentregaOld);
            }
            if (codloteentregaNew != null && !codloteentregaNew.equals(codloteentregaOld)) {
                codloteentregaNew.getLoteentregaitemCollection().add(loteentregaitem);
                codloteentregaNew = em.merge(codloteentregaNew);
            }
            if (codmovendaOld != null && !codmovendaOld.equals(codmovendaNew)) {
                codmovendaOld.getLoteentregaitemCollection().remove(loteentregaitem);
                codmovendaOld = em.merge(codmovendaOld);
            }
            if (codmovendaNew != null && !codmovendaNew.equals(codmovendaOld)) {
                codmovendaNew.getLoteentregaitemCollection().add(loteentregaitem);
                codmovendaNew = em.merge(codmovendaNew);
            }
            if (codmovprodOld != null && !codmovprodOld.equals(codmovprodNew)) {
                codmovprodOld.getLoteentregaitemCollection().remove(loteentregaitem);
                codmovprodOld = em.merge(codmovprodOld);
            }
            if (codmovprodNew != null && !codmovprodNew.equals(codmovprodOld)) {
                codmovprodNew.getLoteentregaitemCollection().add(loteentregaitem);
                codmovprodNew = em.merge(codmovprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = loteentregaitem.getCodloteentregaitem();
                if (findLoteentregaitem(id) == null) {
                    throw new NonexistentEntityException("The loteentregaitem with id " + id + " no longer exists.");
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
            Loteentregaitem loteentregaitem;
            try {
                loteentregaitem = em.getReference(Loteentregaitem.class, id);
                loteentregaitem.getCodloteentregaitem();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The loteentregaitem with id " + id + " no longer exists.", enfe);
            }
            Loteentrega codloteentrega = loteentregaitem.getCodloteentrega();
            if (codloteentrega != null) {
                codloteentrega.getLoteentregaitemCollection().remove(loteentregaitem);
                codloteentrega = em.merge(codloteentrega);
            }
            Movenda codmovenda = loteentregaitem.getCodmovenda();
            if (codmovenda != null) {
                codmovenda.getLoteentregaitemCollection().remove(loteentregaitem);
                codmovenda = em.merge(codmovenda);
            }
            Movendaprod codmovprod = loteentregaitem.getCodmovprod();
            if (codmovprod != null) {
                codmovprod.getLoteentregaitemCollection().remove(loteentregaitem);
                codmovprod = em.merge(codmovprod);
            }
            em.remove(loteentregaitem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Loteentregaitem> findLoteentregaitemEntities() {
        return findLoteentregaitemEntities(true, -1, -1);
    }

    public List<Loteentregaitem> findLoteentregaitemEntities(int maxResults, int firstResult) {
        return findLoteentregaitemEntities(false, maxResults, firstResult);
    }

    private List<Loteentregaitem> findLoteentregaitemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Loteentregaitem.class));
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

    public Loteentregaitem findLoteentregaitem(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Loteentregaitem.class, id);
        } finally {
            em.close();
        }
    }

    public int getLoteentregaitemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Loteentregaitem> rt = cq.from(Loteentregaitem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

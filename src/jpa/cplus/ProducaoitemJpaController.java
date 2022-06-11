/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Producaoitem;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ProducaoitemJpaController implements Serializable {

    public ProducaoitemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Producaoitem producaoitem) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto codprod = producaoitem.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                producaoitem.setCodprod(codprod);
            }
            em.persist(producaoitem);
            if (codprod != null) {
                codprod.getProducaoitemCollection().add(producaoitem);
                codprod = em.merge(codprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findProducaoitem(producaoitem.getCodproducaoitem()) != null) {
                throw new PreexistingEntityException("Producaoitem " + producaoitem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Producaoitem producaoitem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producaoitem persistentProducaoitem = em.find(Producaoitem.class, producaoitem.getCodproducaoitem());
            Produto codprodOld = persistentProducaoitem.getCodprod();
            Produto codprodNew = producaoitem.getCodprod();
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                producaoitem.setCodprod(codprodNew);
            }
            producaoitem = em.merge(producaoitem);
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getProducaoitemCollection().remove(producaoitem);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getProducaoitemCollection().add(producaoitem);
                codprodNew = em.merge(codprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = producaoitem.getCodproducaoitem();
                if (findProducaoitem(id) == null) {
                    throw new NonexistentEntityException("The producaoitem with id " + id + " no longer exists.");
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
            Producaoitem producaoitem;
            try {
                producaoitem = em.getReference(Producaoitem.class, id);
                producaoitem.getCodproducaoitem();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The producaoitem with id " + id + " no longer exists.", enfe);
            }
            Produto codprod = producaoitem.getCodprod();
            if (codprod != null) {
                codprod.getProducaoitemCollection().remove(producaoitem);
                codprod = em.merge(codprod);
            }
            em.remove(producaoitem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Producaoitem> findProducaoitemEntities() {
        return findProducaoitemEntities(true, -1, -1);
    }

    public List<Producaoitem> findProducaoitemEntities(int maxResults, int firstResult) {
        return findProducaoitemEntities(false, maxResults, firstResult);
    }

    private List<Producaoitem> findProducaoitemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Producaoitem.class));
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

    public Producaoitem findProducaoitem(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Producaoitem.class, id);
        } finally {
            em.close();
        }
    }

    public int getProducaoitemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Producaoitem> rt = cq.from(Producaoitem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Moentregaprodloteentregaitem;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MoentregaprodloteentregaitemJpaController implements Serializable {

    public MoentregaprodloteentregaitemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Moentregaprodloteentregaitem moentregaprodloteentregaitem) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(moentregaprodloteentregaitem);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMoentregaprodloteentregaitem(moentregaprodloteentregaitem.getCodmoentregaprodloteentregaitem()) != null) {
                throw new PreexistingEntityException("Moentregaprodloteentregaitem " + moentregaprodloteentregaitem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Moentregaprodloteentregaitem moentregaprodloteentregaitem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            moentregaprodloteentregaitem = em.merge(moentregaprodloteentregaitem);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = moentregaprodloteentregaitem.getCodmoentregaprodloteentregaitem();
                if (findMoentregaprodloteentregaitem(id) == null) {
                    throw new NonexistentEntityException("The moentregaprodloteentregaitem with id " + id + " no longer exists.");
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
            Moentregaprodloteentregaitem moentregaprodloteentregaitem;
            try {
                moentregaprodloteentregaitem = em.getReference(Moentregaprodloteentregaitem.class, id);
                moentregaprodloteentregaitem.getCodmoentregaprodloteentregaitem();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The moentregaprodloteentregaitem with id " + id + " no longer exists.", enfe);
            }
            em.remove(moentregaprodloteentregaitem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Moentregaprodloteentregaitem> findMoentregaprodloteentregaitemEntities() {
        return findMoentregaprodloteentregaitemEntities(true, -1, -1);
    }

    public List<Moentregaprodloteentregaitem> findMoentregaprodloteentregaitemEntities(int maxResults, int firstResult) {
        return findMoentregaprodloteentregaitemEntities(false, maxResults, firstResult);
    }

    private List<Moentregaprodloteentregaitem> findMoentregaprodloteentregaitemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Moentregaprodloteentregaitem.class));
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

    public Moentregaprodloteentregaitem findMoentregaprodloteentregaitem(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Moentregaprodloteentregaitem.class, id);
        } finally {
            em.close();
        }
    }

    public int getMoentregaprodloteentregaitemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Moentregaprodloteentregaitem> rt = cq.from(Moentregaprodloteentregaitem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Relatorioitem;
import entidade.cplus.RelatorioitemPK;
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
public class RelatorioitemJpaController implements Serializable {

    public RelatorioitemJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Relatorioitem relatorioitem) throws PreexistingEntityException, Exception {
        if (relatorioitem.getRelatorioitemPK() == null) {
            relatorioitem.setRelatorioitemPK(new RelatorioitemPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(relatorioitem);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRelatorioitem(relatorioitem.getRelatorioitemPK()) != null) {
                throw new PreexistingEntityException("Relatorioitem " + relatorioitem + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Relatorioitem relatorioitem) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            relatorioitem = em.merge(relatorioitem);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                RelatorioitemPK id = relatorioitem.getRelatorioitemPK();
                if (findRelatorioitem(id) == null) {
                    throw new NonexistentEntityException("The relatorioitem with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(RelatorioitemPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Relatorioitem relatorioitem;
            try {
                relatorioitem = em.getReference(Relatorioitem.class, id);
                relatorioitem.getRelatorioitemPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The relatorioitem with id " + id + " no longer exists.", enfe);
            }
            em.remove(relatorioitem);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Relatorioitem> findRelatorioitemEntities() {
        return findRelatorioitemEntities(true, -1, -1);
    }

    public List<Relatorioitem> findRelatorioitemEntities(int maxResults, int firstResult) {
        return findRelatorioitemEntities(false, maxResults, firstResult);
    }

    private List<Relatorioitem> findRelatorioitemEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Relatorioitem.class));
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

    public Relatorioitem findRelatorioitem(RelatorioitemPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Relatorioitem.class, id);
        } finally {
            em.close();
        }
    }

    public int getRelatorioitemCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Relatorioitem> rt = cq.from(Relatorioitem.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

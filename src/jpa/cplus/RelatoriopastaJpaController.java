/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Relatoriopasta;
import entidade.cplus.RelatoriopastaPK;
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
public class RelatoriopastaJpaController implements Serializable {

    public RelatoriopastaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Relatoriopasta relatoriopasta) throws PreexistingEntityException, Exception {
        if (relatoriopasta.getRelatoriopastaPK() == null) {
            relatoriopasta.setRelatoriopastaPK(new RelatoriopastaPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(relatoriopasta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRelatoriopasta(relatoriopasta.getRelatoriopastaPK()) != null) {
                throw new PreexistingEntityException("Relatoriopasta " + relatoriopasta + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Relatoriopasta relatoriopasta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            relatoriopasta = em.merge(relatoriopasta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                RelatoriopastaPK id = relatoriopasta.getRelatoriopastaPK();
                if (findRelatoriopasta(id) == null) {
                    throw new NonexistentEntityException("The relatoriopasta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(RelatoriopastaPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Relatoriopasta relatoriopasta;
            try {
                relatoriopasta = em.getReference(Relatoriopasta.class, id);
                relatoriopasta.getRelatoriopastaPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The relatoriopasta with id " + id + " no longer exists.", enfe);
            }
            em.remove(relatoriopasta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Relatoriopasta> findRelatoriopastaEntities() {
        return findRelatoriopastaEntities(true, -1, -1);
    }

    public List<Relatoriopasta> findRelatoriopastaEntities(int maxResults, int firstResult) {
        return findRelatoriopastaEntities(false, maxResults, firstResult);
    }

    private List<Relatoriopasta> findRelatoriopastaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Relatoriopasta.class));
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

    public Relatoriopasta findRelatoriopasta(RelatoriopastaPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Relatoriopasta.class, id);
        } finally {
            em.close();
        }
    }

    public int getRelatoriopastaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Relatoriopasta> rt = cq.from(Relatoriopasta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

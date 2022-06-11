/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.OsPrioridade;
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
public class OsPrioridadeJpaController implements Serializable {

    public OsPrioridadeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OsPrioridade osPrioridade) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(osPrioridade);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOsPrioridade(osPrioridade.getCodprioridade()) != null) {
                throw new PreexistingEntityException("OsPrioridade " + osPrioridade + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OsPrioridade osPrioridade) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            osPrioridade = em.merge(osPrioridade);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = osPrioridade.getCodprioridade();
                if (findOsPrioridade(id) == null) {
                    throw new NonexistentEntityException("The osPrioridade with id " + id + " no longer exists.");
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
            OsPrioridade osPrioridade;
            try {
                osPrioridade = em.getReference(OsPrioridade.class, id);
                osPrioridade.getCodprioridade();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The osPrioridade with id " + id + " no longer exists.", enfe);
            }
            em.remove(osPrioridade);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OsPrioridade> findOsPrioridadeEntities() {
        return findOsPrioridadeEntities(true, -1, -1);
    }

    public List<OsPrioridade> findOsPrioridadeEntities(int maxResults, int firstResult) {
        return findOsPrioridadeEntities(false, maxResults, firstResult);
    }

    private List<OsPrioridade> findOsPrioridadeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OsPrioridade.class));
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

    public OsPrioridade findOsPrioridade(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OsPrioridade.class, id);
        } finally {
            em.close();
        }
    }

    public int getOsPrioridadeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OsPrioridade> rt = cq.from(OsPrioridade.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

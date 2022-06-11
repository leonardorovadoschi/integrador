/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Diainutilfixo;
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
public class DiainutilfixoJpaController implements Serializable {

    public DiainutilfixoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Diainutilfixo diainutilfixo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(diainutilfixo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDiainutilfixo(diainutilfixo.getCoddiainutilfixo()) != null) {
                throw new PreexistingEntityException("Diainutilfixo " + diainutilfixo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Diainutilfixo diainutilfixo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            diainutilfixo = em.merge(diainutilfixo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = diainutilfixo.getCoddiainutilfixo();
                if (findDiainutilfixo(id) == null) {
                    throw new NonexistentEntityException("The diainutilfixo with id " + id + " no longer exists.");
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
            Diainutilfixo diainutilfixo;
            try {
                diainutilfixo = em.getReference(Diainutilfixo.class, id);
                diainutilfixo.getCoddiainutilfixo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The diainutilfixo with id " + id + " no longer exists.", enfe);
            }
            em.remove(diainutilfixo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Diainutilfixo> findDiainutilfixoEntities() {
        return findDiainutilfixoEntities(true, -1, -1);
    }

    public List<Diainutilfixo> findDiainutilfixoEntities(int maxResults, int firstResult) {
        return findDiainutilfixoEntities(false, maxResults, firstResult);
    }

    private List<Diainutilfixo> findDiainutilfixoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Diainutilfixo.class));
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

    public Diainutilfixo findDiainutilfixo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Diainutilfixo.class, id);
        } finally {
            em.close();
        }
    }

    public int getDiainutilfixoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Diainutilfixo> rt = cq.from(Diainutilfixo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Empresacaixapostal;
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
public class EmpresacaixapostalJpaController implements Serializable {

    public EmpresacaixapostalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empresacaixapostal empresacaixapostal) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(empresacaixapostal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmpresacaixapostal(empresacaixapostal.getCodempresacaixapostal()) != null) {
                throw new PreexistingEntityException("Empresacaixapostal " + empresacaixapostal + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empresacaixapostal empresacaixapostal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            empresacaixapostal = em.merge(empresacaixapostal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = empresacaixapostal.getCodempresacaixapostal();
                if (findEmpresacaixapostal(id) == null) {
                    throw new NonexistentEntityException("The empresacaixapostal with id " + id + " no longer exists.");
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
            Empresacaixapostal empresacaixapostal;
            try {
                empresacaixapostal = em.getReference(Empresacaixapostal.class, id);
                empresacaixapostal.getCodempresacaixapostal();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empresacaixapostal with id " + id + " no longer exists.", enfe);
            }
            em.remove(empresacaixapostal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empresacaixapostal> findEmpresacaixapostalEntities() {
        return findEmpresacaixapostalEntities(true, -1, -1);
    }

    public List<Empresacaixapostal> findEmpresacaixapostalEntities(int maxResults, int firstResult) {
        return findEmpresacaixapostalEntities(false, maxResults, firstResult);
    }

    private List<Empresacaixapostal> findEmpresacaixapostalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empresacaixapostal.class));
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

    public Empresacaixapostal findEmpresacaixapostal(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empresacaixapostal.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpresacaixapostalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empresacaixapostal> rt = cq.from(Empresacaixapostal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Empresafilial;
import entidade.cplus.EmpresafilialPK;
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
public class EmpresafilialJpaController implements Serializable {

    public EmpresafilialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empresafilial empresafilial) throws PreexistingEntityException, Exception {
        if (empresafilial.getEmpresafilialPK() == null) {
            empresafilial.setEmpresafilialPK(new EmpresafilialPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(empresafilial);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmpresafilial(empresafilial.getEmpresafilialPK()) != null) {
                throw new PreexistingEntityException("Empresafilial " + empresafilial + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empresafilial empresafilial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            empresafilial = em.merge(empresafilial);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                EmpresafilialPK id = empresafilial.getEmpresafilialPK();
                if (findEmpresafilial(id) == null) {
                    throw new NonexistentEntityException("The empresafilial with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(EmpresafilialPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresafilial empresafilial;
            try {
                empresafilial = em.getReference(Empresafilial.class, id);
                empresafilial.getEmpresafilialPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empresafilial with id " + id + " no longer exists.", enfe);
            }
            em.remove(empresafilial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empresafilial> findEmpresafilialEntities() {
        return findEmpresafilialEntities(true, -1, -1);
    }

    public List<Empresafilial> findEmpresafilialEntities(int maxResults, int firstResult) {
        return findEmpresafilialEntities(false, maxResults, firstResult);
    }

    private List<Empresafilial> findEmpresafilialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empresafilial.class));
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

    public Empresafilial findEmpresafilial(EmpresafilialPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empresafilial.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpresafilialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empresafilial> rt = cq.from(Empresafilial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

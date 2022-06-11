/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Empresaclassificacaofiscal;
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
public class EmpresaclassificacaofiscalJpaController implements Serializable {

    public EmpresaclassificacaofiscalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empresaclassificacaofiscal empresaclassificacaofiscal) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(empresaclassificacaofiscal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmpresaclassificacaofiscal(empresaclassificacaofiscal.getCodempresaclassificacaofiscal()) != null) {
                throw new PreexistingEntityException("Empresaclassificacaofiscal " + empresaclassificacaofiscal + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empresaclassificacaofiscal empresaclassificacaofiscal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            empresaclassificacaofiscal = em.merge(empresaclassificacaofiscal);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = empresaclassificacaofiscal.getCodempresaclassificacaofiscal();
                if (findEmpresaclassificacaofiscal(id) == null) {
                    throw new NonexistentEntityException("The empresaclassificacaofiscal with id " + id + " no longer exists.");
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
            Empresaclassificacaofiscal empresaclassificacaofiscal;
            try {
                empresaclassificacaofiscal = em.getReference(Empresaclassificacaofiscal.class, id);
                empresaclassificacaofiscal.getCodempresaclassificacaofiscal();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empresaclassificacaofiscal with id " + id + " no longer exists.", enfe);
            }
            em.remove(empresaclassificacaofiscal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empresaclassificacaofiscal> findEmpresaclassificacaofiscalEntities() {
        return findEmpresaclassificacaofiscalEntities(true, -1, -1);
    }

    public List<Empresaclassificacaofiscal> findEmpresaclassificacaofiscalEntities(int maxResults, int firstResult) {
        return findEmpresaclassificacaofiscalEntities(false, maxResults, firstResult);
    }

    private List<Empresaclassificacaofiscal> findEmpresaclassificacaofiscalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empresaclassificacaofiscal.class));
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

    public Empresaclassificacaofiscal findEmpresaclassificacaofiscal(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empresaclassificacaofiscal.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpresaclassificacaofiscalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empresaclassificacaofiscal> rt = cq.from(Empresaclassificacaofiscal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

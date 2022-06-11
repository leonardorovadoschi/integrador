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
import entidade.cplus.Empresa;
import entidade.cplus.Empresauf;
import entidade.cplus.Uf;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class EmpresaufJpaController implements Serializable {

    public EmpresaufJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empresauf empresauf) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa codempresa = empresauf.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                empresauf.setCodempresa(codempresa);
            }
            Uf coduf = empresauf.getCoduf();
            if (coduf != null) {
                coduf = em.getReference(coduf.getClass(), coduf.getCoduf());
                empresauf.setCoduf(coduf);
            }
            em.persist(empresauf);
            if (codempresa != null) {
                codempresa.getEmpresaufCollection().add(empresauf);
                codempresa = em.merge(codempresa);
            }
            if (coduf != null) {
                coduf.getEmpresaufCollection().add(empresauf);
                coduf = em.merge(coduf);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEmpresauf(empresauf.getCodempresauf()) != null) {
                throw new PreexistingEntityException("Empresauf " + empresauf + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empresauf empresauf) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresauf persistentEmpresauf = em.find(Empresauf.class, empresauf.getCodempresauf());
            Empresa codempresaOld = persistentEmpresauf.getCodempresa();
            Empresa codempresaNew = empresauf.getCodempresa();
            Uf codufOld = persistentEmpresauf.getCoduf();
            Uf codufNew = empresauf.getCoduf();
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                empresauf.setCodempresa(codempresaNew);
            }
            if (codufNew != null) {
                codufNew = em.getReference(codufNew.getClass(), codufNew.getCoduf());
                empresauf.setCoduf(codufNew);
            }
            empresauf = em.merge(empresauf);
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getEmpresaufCollection().remove(empresauf);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getEmpresaufCollection().add(empresauf);
                codempresaNew = em.merge(codempresaNew);
            }
            if (codufOld != null && !codufOld.equals(codufNew)) {
                codufOld.getEmpresaufCollection().remove(empresauf);
                codufOld = em.merge(codufOld);
            }
            if (codufNew != null && !codufNew.equals(codufOld)) {
                codufNew.getEmpresaufCollection().add(empresauf);
                codufNew = em.merge(codufNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = empresauf.getCodempresauf();
                if (findEmpresauf(id) == null) {
                    throw new NonexistentEntityException("The empresauf with id " + id + " no longer exists.");
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
            Empresauf empresauf;
            try {
                empresauf = em.getReference(Empresauf.class, id);
                empresauf.getCodempresauf();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empresauf with id " + id + " no longer exists.", enfe);
            }
            Empresa codempresa = empresauf.getCodempresa();
            if (codempresa != null) {
                codempresa.getEmpresaufCollection().remove(empresauf);
                codempresa = em.merge(codempresa);
            }
            Uf coduf = empresauf.getCoduf();
            if (coduf != null) {
                coduf.getEmpresaufCollection().remove(empresauf);
                coduf = em.merge(coduf);
            }
            em.remove(empresauf);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empresauf> findEmpresaufEntities() {
        return findEmpresaufEntities(true, -1, -1);
    }

    public List<Empresauf> findEmpresaufEntities(int maxResults, int firstResult) {
        return findEmpresaufEntities(false, maxResults, firstResult);
    }

    private List<Empresauf> findEmpresaufEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empresauf.class));
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

    public Empresauf findEmpresauf(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empresauf.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpresaufCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empresauf> rt = cq.from(Empresauf.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

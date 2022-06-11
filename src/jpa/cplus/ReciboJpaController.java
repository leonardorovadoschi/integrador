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
import entidade.cplus.Recibo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ReciboJpaController implements Serializable {

    public ReciboJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Recibo recibo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa codempresa = recibo.getCodempresa();
            if (codempresa != null) {
                codempresa = em.getReference(codempresa.getClass(), codempresa.getCodempresa());
                recibo.setCodempresa(codempresa);
            }
            em.persist(recibo);
            if (codempresa != null) {
                codempresa.getReciboCollection().add(recibo);
                codempresa = em.merge(codempresa);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRecibo(recibo.getId()) != null) {
                throw new PreexistingEntityException("Recibo " + recibo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Recibo recibo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Recibo persistentRecibo = em.find(Recibo.class, recibo.getId());
            Empresa codempresaOld = persistentRecibo.getCodempresa();
            Empresa codempresaNew = recibo.getCodempresa();
            if (codempresaNew != null) {
                codempresaNew = em.getReference(codempresaNew.getClass(), codempresaNew.getCodempresa());
                recibo.setCodempresa(codempresaNew);
            }
            recibo = em.merge(recibo);
            if (codempresaOld != null && !codempresaOld.equals(codempresaNew)) {
                codempresaOld.getReciboCollection().remove(recibo);
                codempresaOld = em.merge(codempresaOld);
            }
            if (codempresaNew != null && !codempresaNew.equals(codempresaOld)) {
                codempresaNew.getReciboCollection().add(recibo);
                codempresaNew = em.merge(codempresaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = recibo.getId();
                if (findRecibo(id) == null) {
                    throw new NonexistentEntityException("The recibo with id " + id + " no longer exists.");
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
            Recibo recibo;
            try {
                recibo = em.getReference(Recibo.class, id);
                recibo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The recibo with id " + id + " no longer exists.", enfe);
            }
            Empresa codempresa = recibo.getCodempresa();
            if (codempresa != null) {
                codempresa.getReciboCollection().remove(recibo);
                codempresa = em.merge(codempresa);
            }
            em.remove(recibo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Recibo> findReciboEntities() {
        return findReciboEntities(true, -1, -1);
    }

    public List<Recibo> findReciboEntities(int maxResults, int firstResult) {
        return findReciboEntities(false, maxResults, firstResult);
    }

    private List<Recibo> findReciboEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Recibo.class));
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

    public Recibo findRecibo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Recibo.class, id);
        } finally {
            em.close();
        }
    }

    public int getReciboCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Recibo> rt = cq.from(Recibo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

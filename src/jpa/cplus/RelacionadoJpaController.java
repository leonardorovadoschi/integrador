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
import entidade.cplus.Produto;
import entidade.cplus.Relacionado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class RelacionadoJpaController implements Serializable {

    public RelacionadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Relacionado relacionado) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto codprod = relacionado.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                relacionado.setCodprod(codprod);
            }
            em.persist(relacionado);
            if (codprod != null) {
                codprod.getRelacionadoCollection().add(relacionado);
                codprod = em.merge(codprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findRelacionado(relacionado.getCodrelacionado()) != null) {
                throw new PreexistingEntityException("Relacionado " + relacionado + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Relacionado relacionado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Relacionado persistentRelacionado = em.find(Relacionado.class, relacionado.getCodrelacionado());
            Produto codprodOld = persistentRelacionado.getCodprod();
            Produto codprodNew = relacionado.getCodprod();
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                relacionado.setCodprod(codprodNew);
            }
            relacionado = em.merge(relacionado);
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getRelacionadoCollection().remove(relacionado);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getRelacionadoCollection().add(relacionado);
                codprodNew = em.merge(codprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = relacionado.getCodrelacionado();
                if (findRelacionado(id) == null) {
                    throw new NonexistentEntityException("The relacionado with id " + id + " no longer exists.");
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
            Relacionado relacionado;
            try {
                relacionado = em.getReference(Relacionado.class, id);
                relacionado.getCodrelacionado();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The relacionado with id " + id + " no longer exists.", enfe);
            }
            Produto codprod = relacionado.getCodprod();
            if (codprod != null) {
                codprod.getRelacionadoCollection().remove(relacionado);
                codprod = em.merge(codprod);
            }
            em.remove(relacionado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Relacionado> findRelacionadoEntities() {
        return findRelacionadoEntities(true, -1, -1);
    }

    public List<Relacionado> findRelacionadoEntities(int maxResults, int firstResult) {
        return findRelacionadoEntities(false, maxResults, firstResult);
    }

    private List<Relacionado> findRelacionadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Relacionado.class));
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

    public Relacionado findRelacionado(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Relacionado.class, id);
        } finally {
            em.close();
        }
    }

    public int getRelacionadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Relacionado> rt = cq.from(Relacionado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

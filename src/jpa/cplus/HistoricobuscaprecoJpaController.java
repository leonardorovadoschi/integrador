/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Historicobuscapreco;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class HistoricobuscaprecoJpaController implements Serializable {

    public HistoricobuscaprecoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Historicobuscapreco historicobuscapreco) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto codprod = historicobuscapreco.getCodprod();
            if (codprod != null) {
                codprod = em.getReference(codprod.getClass(), codprod.getCodprod());
                historicobuscapreco.setCodprod(codprod);
            }
            em.persist(historicobuscapreco);
            if (codprod != null) {
                codprod.getHistoricobuscaprecoCollection().add(historicobuscapreco);
                codprod = em.merge(codprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findHistoricobuscapreco(historicobuscapreco.getId()) != null) {
                throw new PreexistingEntityException("Historicobuscapreco " + historicobuscapreco + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Historicobuscapreco historicobuscapreco) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Historicobuscapreco persistentHistoricobuscapreco = em.find(Historicobuscapreco.class, historicobuscapreco.getId());
            Produto codprodOld = persistentHistoricobuscapreco.getCodprod();
            Produto codprodNew = historicobuscapreco.getCodprod();
            if (codprodNew != null) {
                codprodNew = em.getReference(codprodNew.getClass(), codprodNew.getCodprod());
                historicobuscapreco.setCodprod(codprodNew);
            }
            historicobuscapreco = em.merge(historicobuscapreco);
            if (codprodOld != null && !codprodOld.equals(codprodNew)) {
                codprodOld.getHistoricobuscaprecoCollection().remove(historicobuscapreco);
                codprodOld = em.merge(codprodOld);
            }
            if (codprodNew != null && !codprodNew.equals(codprodOld)) {
                codprodNew.getHistoricobuscaprecoCollection().add(historicobuscapreco);
                codprodNew = em.merge(codprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = historicobuscapreco.getId();
                if (findHistoricobuscapreco(id) == null) {
                    throw new NonexistentEntityException("The historicobuscapreco with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Historicobuscapreco historicobuscapreco;
            try {
                historicobuscapreco = em.getReference(Historicobuscapreco.class, id);
                historicobuscapreco.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The historicobuscapreco with id " + id + " no longer exists.", enfe);
            }
            Produto codprod = historicobuscapreco.getCodprod();
            if (codprod != null) {
                codprod.getHistoricobuscaprecoCollection().remove(historicobuscapreco);
                codprod = em.merge(codprod);
            }
            em.remove(historicobuscapreco);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Historicobuscapreco> findHistoricobuscaprecoEntities() {
        return findHistoricobuscaprecoEntities(true, -1, -1);
    }

    public List<Historicobuscapreco> findHistoricobuscaprecoEntities(int maxResults, int firstResult) {
        return findHistoricobuscaprecoEntities(false, maxResults, firstResult);
    }

    private List<Historicobuscapreco> findHistoricobuscaprecoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Historicobuscapreco.class));
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

    public Historicobuscapreco findHistoricobuscapreco(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Historicobuscapreco.class, id);
        } finally {
            em.close();
        }
    }

    public int getHistoricobuscaprecoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Historicobuscapreco> rt = cq.from(Historicobuscapreco.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
import entidade.cplus.Orcamentoprod;
import entidade.cplus.Orcamentoprodpharma;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class OrcamentoprodpharmaJpaController implements Serializable {

    public OrcamentoprodpharmaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Orcamentoprodpharma orcamentoprodpharma) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Orcamentoprod codorcprod = orcamentoprodpharma.getCodorcprod();
            if (codorcprod != null) {
                codorcprod = em.getReference(codorcprod.getClass(), codorcprod.getCodorcprod());
                orcamentoprodpharma.setCodorcprod(codorcprod);
            }
            em.persist(orcamentoprodpharma);
            if (codorcprod != null) {
                codorcprod.getOrcamentoprodpharmaCollection().add(orcamentoprodpharma);
                codorcprod = em.merge(codorcprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrcamentoprodpharma(orcamentoprodpharma.getCodorcprodpharma()) != null) {
                throw new PreexistingEntityException("Orcamentoprodpharma " + orcamentoprodpharma + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Orcamentoprodpharma orcamentoprodpharma) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Orcamentoprodpharma persistentOrcamentoprodpharma = em.find(Orcamentoprodpharma.class, orcamentoprodpharma.getCodorcprodpharma());
            Orcamentoprod codorcprodOld = persistentOrcamentoprodpharma.getCodorcprod();
            Orcamentoprod codorcprodNew = orcamentoprodpharma.getCodorcprod();
            if (codorcprodNew != null) {
                codorcprodNew = em.getReference(codorcprodNew.getClass(), codorcprodNew.getCodorcprod());
                orcamentoprodpharma.setCodorcprod(codorcprodNew);
            }
            orcamentoprodpharma = em.merge(orcamentoprodpharma);
            if (codorcprodOld != null && !codorcprodOld.equals(codorcprodNew)) {
                codorcprodOld.getOrcamentoprodpharmaCollection().remove(orcamentoprodpharma);
                codorcprodOld = em.merge(codorcprodOld);
            }
            if (codorcprodNew != null && !codorcprodNew.equals(codorcprodOld)) {
                codorcprodNew.getOrcamentoprodpharmaCollection().add(orcamentoprodpharma);
                codorcprodNew = em.merge(codorcprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = orcamentoprodpharma.getCodorcprodpharma();
                if (findOrcamentoprodpharma(id) == null) {
                    throw new NonexistentEntityException("The orcamentoprodpharma with id " + id + " no longer exists.");
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
            Orcamentoprodpharma orcamentoprodpharma;
            try {
                orcamentoprodpharma = em.getReference(Orcamentoprodpharma.class, id);
                orcamentoprodpharma.getCodorcprodpharma();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The orcamentoprodpharma with id " + id + " no longer exists.", enfe);
            }
            Orcamentoprod codorcprod = orcamentoprodpharma.getCodorcprod();
            if (codorcprod != null) {
                codorcprod.getOrcamentoprodpharmaCollection().remove(orcamentoprodpharma);
                codorcprod = em.merge(codorcprod);
            }
            em.remove(orcamentoprodpharma);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Orcamentoprodpharma> findOrcamentoprodpharmaEntities() {
        return findOrcamentoprodpharmaEntities(true, -1, -1);
    }

    public List<Orcamentoprodpharma> findOrcamentoprodpharmaEntities(int maxResults, int firstResult) {
        return findOrcamentoprodpharmaEntities(false, maxResults, firstResult);
    }

    private List<Orcamentoprodpharma> findOrcamentoprodpharmaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Orcamentoprodpharma.class));
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

    public Orcamentoprodpharma findOrcamentoprodpharma(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Orcamentoprodpharma.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrcamentoprodpharmaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Orcamentoprodpharma> rt = cq.from(Orcamentoprodpharma.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

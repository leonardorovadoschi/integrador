/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Bico;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Tanque;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class BicoJpaController implements Serializable {

    public BicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Bico bico) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tanque codtanque = bico.getCodtanque();
            if (codtanque != null) {
                codtanque = em.getReference(codtanque.getClass(), codtanque.getCodtanque());
                bico.setCodtanque(codtanque);
            }
            em.persist(bico);
            if (codtanque != null) {
                codtanque.getBicoCollection().add(bico);
                codtanque = em.merge(codtanque);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findBico(bico.getCodbico()) != null) {
                throw new PreexistingEntityException("Bico " + bico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Bico bico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Bico persistentBico = em.find(Bico.class, bico.getCodbico());
            Tanque codtanqueOld = persistentBico.getCodtanque();
            Tanque codtanqueNew = bico.getCodtanque();
            if (codtanqueNew != null) {
                codtanqueNew = em.getReference(codtanqueNew.getClass(), codtanqueNew.getCodtanque());
                bico.setCodtanque(codtanqueNew);
            }
            bico = em.merge(bico);
            if (codtanqueOld != null && !codtanqueOld.equals(codtanqueNew)) {
                codtanqueOld.getBicoCollection().remove(bico);
                codtanqueOld = em.merge(codtanqueOld);
            }
            if (codtanqueNew != null && !codtanqueNew.equals(codtanqueOld)) {
                codtanqueNew.getBicoCollection().add(bico);
                codtanqueNew = em.merge(codtanqueNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = bico.getCodbico();
                if (findBico(id) == null) {
                    throw new NonexistentEntityException("The bico with id " + id + " no longer exists.");
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
            Bico bico;
            try {
                bico = em.getReference(Bico.class, id);
                bico.getCodbico();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The bico with id " + id + " no longer exists.", enfe);
            }
            Tanque codtanque = bico.getCodtanque();
            if (codtanque != null) {
                codtanque.getBicoCollection().remove(bico);
                codtanque = em.merge(codtanque);
            }
            em.remove(bico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Bico> findBicoEntities() {
        return findBicoEntities(true, -1, -1);
    }

    public List<Bico> findBicoEntities(int maxResults, int firstResult) {
        return findBicoEntities(false, maxResults, firstResult);
    }

    private List<Bico> findBicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Bico.class));
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

    public Bico findBico(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Bico.class, id);
        } finally {
            em.close();
        }
    }

    public int getBicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Bico> rt = cq.from(Bico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

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
import entidade.cplus.Nfseletronica;
import entidade.cplus.Nfseletronicaerros;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class NfseletronicaerrosJpaController implements Serializable {

    public NfseletronicaerrosJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Nfseletronicaerros nfseletronicaerros) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nfseletronica codnfseletronica = nfseletronicaerros.getCodnfseletronica();
            if (codnfseletronica != null) {
                codnfseletronica = em.getReference(codnfseletronica.getClass(), codnfseletronica.getCodnfseletronica());
                nfseletronicaerros.setCodnfseletronica(codnfseletronica);
            }
            em.persist(nfseletronicaerros);
            if (codnfseletronica != null) {
                codnfseletronica.getNfseletronicaerrosCollection().add(nfseletronicaerros);
                codnfseletronica = em.merge(codnfseletronica);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findNfseletronicaerros(nfseletronicaerros.getCodnfseletronicaerros()) != null) {
                throw new PreexistingEntityException("Nfseletronicaerros " + nfseletronicaerros + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Nfseletronicaerros nfseletronicaerros) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Nfseletronicaerros persistentNfseletronicaerros = em.find(Nfseletronicaerros.class, nfseletronicaerros.getCodnfseletronicaerros());
            Nfseletronica codnfseletronicaOld = persistentNfseletronicaerros.getCodnfseletronica();
            Nfseletronica codnfseletronicaNew = nfseletronicaerros.getCodnfseletronica();
            if (codnfseletronicaNew != null) {
                codnfseletronicaNew = em.getReference(codnfseletronicaNew.getClass(), codnfseletronicaNew.getCodnfseletronica());
                nfseletronicaerros.setCodnfseletronica(codnfseletronicaNew);
            }
            nfseletronicaerros = em.merge(nfseletronicaerros);
            if (codnfseletronicaOld != null && !codnfseletronicaOld.equals(codnfseletronicaNew)) {
                codnfseletronicaOld.getNfseletronicaerrosCollection().remove(nfseletronicaerros);
                codnfseletronicaOld = em.merge(codnfseletronicaOld);
            }
            if (codnfseletronicaNew != null && !codnfseletronicaNew.equals(codnfseletronicaOld)) {
                codnfseletronicaNew.getNfseletronicaerrosCollection().add(nfseletronicaerros);
                codnfseletronicaNew = em.merge(codnfseletronicaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = nfseletronicaerros.getCodnfseletronicaerros();
                if (findNfseletronicaerros(id) == null) {
                    throw new NonexistentEntityException("The nfseletronicaerros with id " + id + " no longer exists.");
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
            Nfseletronicaerros nfseletronicaerros;
            try {
                nfseletronicaerros = em.getReference(Nfseletronicaerros.class, id);
                nfseletronicaerros.getCodnfseletronicaerros();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nfseletronicaerros with id " + id + " no longer exists.", enfe);
            }
            Nfseletronica codnfseletronica = nfseletronicaerros.getCodnfseletronica();
            if (codnfseletronica != null) {
                codnfseletronica.getNfseletronicaerrosCollection().remove(nfseletronicaerros);
                codnfseletronica = em.merge(codnfseletronica);
            }
            em.remove(nfseletronicaerros);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Nfseletronicaerros> findNfseletronicaerrosEntities() {
        return findNfseletronicaerrosEntities(true, -1, -1);
    }

    public List<Nfseletronicaerros> findNfseletronicaerrosEntities(int maxResults, int firstResult) {
        return findNfseletronicaerrosEntities(false, maxResults, firstResult);
    }

    private List<Nfseletronicaerros> findNfseletronicaerrosEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Nfseletronicaerros.class));
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

    public Nfseletronicaerros findNfseletronicaerros(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Nfseletronicaerros.class, id);
        } finally {
            em.close();
        }
    }

    public int getNfseletronicaerrosCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Nfseletronicaerros> rt = cq.from(Nfseletronicaerros.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

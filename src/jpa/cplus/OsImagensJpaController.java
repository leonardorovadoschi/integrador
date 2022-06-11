/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.OsImagens;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.OsOrdemservico;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class OsImagensJpaController implements Serializable {

    public OsImagensJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(OsImagens osImagens) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsOrdemservico codos = osImagens.getCodos();
            if (codos != null) {
                codos = em.getReference(codos.getClass(), codos.getCodos());
                osImagens.setCodos(codos);
            }
            em.persist(osImagens);
            if (codos != null) {
                codos.getOsImagensCollection().add(osImagens);
                codos = em.merge(codos);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOsImagens(osImagens.getCodimgos()) != null) {
                throw new PreexistingEntityException("OsImagens " + osImagens + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(OsImagens osImagens) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            OsImagens persistentOsImagens = em.find(OsImagens.class, osImagens.getCodimgos());
            OsOrdemservico codosOld = persistentOsImagens.getCodos();
            OsOrdemservico codosNew = osImagens.getCodos();
            if (codosNew != null) {
                codosNew = em.getReference(codosNew.getClass(), codosNew.getCodos());
                osImagens.setCodos(codosNew);
            }
            osImagens = em.merge(osImagens);
            if (codosOld != null && !codosOld.equals(codosNew)) {
                codosOld.getOsImagensCollection().remove(osImagens);
                codosOld = em.merge(codosOld);
            }
            if (codosNew != null && !codosNew.equals(codosOld)) {
                codosNew.getOsImagensCollection().add(osImagens);
                codosNew = em.merge(codosNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = osImagens.getCodimgos();
                if (findOsImagens(id) == null) {
                    throw new NonexistentEntityException("The osImagens with id " + id + " no longer exists.");
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
            OsImagens osImagens;
            try {
                osImagens = em.getReference(OsImagens.class, id);
                osImagens.getCodimgos();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The osImagens with id " + id + " no longer exists.", enfe);
            }
            OsOrdemservico codos = osImagens.getCodos();
            if (codos != null) {
                codos.getOsImagensCollection().remove(osImagens);
                codos = em.merge(codos);
            }
            em.remove(osImagens);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<OsImagens> findOsImagensEntities() {
        return findOsImagensEntities(true, -1, -1);
    }

    public List<OsImagens> findOsImagensEntities(int maxResults, int firstResult) {
        return findOsImagensEntities(false, maxResults, firstResult);
    }

    private List<OsImagens> findOsImagensEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(OsImagens.class));
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

    public OsImagens findOsImagens(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(OsImagens.class, id);
        } finally {
            em.close();
        }
    }

    public int getOsImagensCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<OsImagens> rt = cq.from(OsImagens.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

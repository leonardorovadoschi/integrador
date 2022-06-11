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
import entidade.cplus.Mdfeletronico;
import entidade.cplus.Mdfeletronicoautorizadoxml;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MdfeletronicoautorizadoxmlJpaController implements Serializable {

    public MdfeletronicoautorizadoxmlJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mdfeletronicoautorizadoxml mdfeletronicoautorizadoxml) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mdfeletronico codmdfeletronico = mdfeletronicoautorizadoxml.getCodmdfeletronico();
            if (codmdfeletronico != null) {
                codmdfeletronico = em.getReference(codmdfeletronico.getClass(), codmdfeletronico.getCodmdfeletronico());
                mdfeletronicoautorizadoxml.setCodmdfeletronico(codmdfeletronico);
            }
            em.persist(mdfeletronicoautorizadoxml);
            if (codmdfeletronico != null) {
                codmdfeletronico.getMdfeletronicoautorizadoxmlCollection().add(mdfeletronicoautorizadoxml);
                codmdfeletronico = em.merge(codmdfeletronico);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMdfeletronicoautorizadoxml(mdfeletronicoautorizadoxml.getCodmdfeletronicoautorizadoxml()) != null) {
                throw new PreexistingEntityException("Mdfeletronicoautorizadoxml " + mdfeletronicoautorizadoxml + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mdfeletronicoautorizadoxml mdfeletronicoautorizadoxml) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mdfeletronicoautorizadoxml persistentMdfeletronicoautorizadoxml = em.find(Mdfeletronicoautorizadoxml.class, mdfeletronicoautorizadoxml.getCodmdfeletronicoautorizadoxml());
            Mdfeletronico codmdfeletronicoOld = persistentMdfeletronicoautorizadoxml.getCodmdfeletronico();
            Mdfeletronico codmdfeletronicoNew = mdfeletronicoautorizadoxml.getCodmdfeletronico();
            if (codmdfeletronicoNew != null) {
                codmdfeletronicoNew = em.getReference(codmdfeletronicoNew.getClass(), codmdfeletronicoNew.getCodmdfeletronico());
                mdfeletronicoautorizadoxml.setCodmdfeletronico(codmdfeletronicoNew);
            }
            mdfeletronicoautorizadoxml = em.merge(mdfeletronicoautorizadoxml);
            if (codmdfeletronicoOld != null && !codmdfeletronicoOld.equals(codmdfeletronicoNew)) {
                codmdfeletronicoOld.getMdfeletronicoautorizadoxmlCollection().remove(mdfeletronicoautorizadoxml);
                codmdfeletronicoOld = em.merge(codmdfeletronicoOld);
            }
            if (codmdfeletronicoNew != null && !codmdfeletronicoNew.equals(codmdfeletronicoOld)) {
                codmdfeletronicoNew.getMdfeletronicoautorizadoxmlCollection().add(mdfeletronicoautorizadoxml);
                codmdfeletronicoNew = em.merge(codmdfeletronicoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = mdfeletronicoautorizadoxml.getCodmdfeletronicoautorizadoxml();
                if (findMdfeletronicoautorizadoxml(id) == null) {
                    throw new NonexistentEntityException("The mdfeletronicoautorizadoxml with id " + id + " no longer exists.");
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
            Mdfeletronicoautorizadoxml mdfeletronicoautorizadoxml;
            try {
                mdfeletronicoautorizadoxml = em.getReference(Mdfeletronicoautorizadoxml.class, id);
                mdfeletronicoautorizadoxml.getCodmdfeletronicoautorizadoxml();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mdfeletronicoautorizadoxml with id " + id + " no longer exists.", enfe);
            }
            Mdfeletronico codmdfeletronico = mdfeletronicoautorizadoxml.getCodmdfeletronico();
            if (codmdfeletronico != null) {
                codmdfeletronico.getMdfeletronicoautorizadoxmlCollection().remove(mdfeletronicoautorizadoxml);
                codmdfeletronico = em.merge(codmdfeletronico);
            }
            em.remove(mdfeletronicoautorizadoxml);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mdfeletronicoautorizadoxml> findMdfeletronicoautorizadoxmlEntities() {
        return findMdfeletronicoautorizadoxmlEntities(true, -1, -1);
    }

    public List<Mdfeletronicoautorizadoxml> findMdfeletronicoautorizadoxmlEntities(int maxResults, int firstResult) {
        return findMdfeletronicoautorizadoxmlEntities(false, maxResults, firstResult);
    }

    private List<Mdfeletronicoautorizadoxml> findMdfeletronicoautorizadoxmlEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mdfeletronicoautorizadoxml.class));
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

    public Mdfeletronicoautorizadoxml findMdfeletronicoautorizadoxml(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mdfeletronicoautorizadoxml.class, id);
        } finally {
            em.close();
        }
    }

    public int getMdfeletronicoautorizadoxmlCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mdfeletronicoautorizadoxml> rt = cq.from(Mdfeletronicoautorizadoxml.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

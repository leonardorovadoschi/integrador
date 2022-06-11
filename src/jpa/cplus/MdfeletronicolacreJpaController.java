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
import entidade.cplus.Mdfeletronicolacre;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MdfeletronicolacreJpaController implements Serializable {

    public MdfeletronicolacreJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mdfeletronicolacre mdfeletronicolacre) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mdfeletronico codmdfeletronico = mdfeletronicolacre.getCodmdfeletronico();
            if (codmdfeletronico != null) {
                codmdfeletronico = em.getReference(codmdfeletronico.getClass(), codmdfeletronico.getCodmdfeletronico());
                mdfeletronicolacre.setCodmdfeletronico(codmdfeletronico);
            }
            em.persist(mdfeletronicolacre);
            if (codmdfeletronico != null) {
                codmdfeletronico.getMdfeletronicolacreCollection().add(mdfeletronicolacre);
                codmdfeletronico = em.merge(codmdfeletronico);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMdfeletronicolacre(mdfeletronicolacre.getCodmdfeletronicolacre()) != null) {
                throw new PreexistingEntityException("Mdfeletronicolacre " + mdfeletronicolacre + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mdfeletronicolacre mdfeletronicolacre) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mdfeletronicolacre persistentMdfeletronicolacre = em.find(Mdfeletronicolacre.class, mdfeletronicolacre.getCodmdfeletronicolacre());
            Mdfeletronico codmdfeletronicoOld = persistentMdfeletronicolacre.getCodmdfeletronico();
            Mdfeletronico codmdfeletronicoNew = mdfeletronicolacre.getCodmdfeletronico();
            if (codmdfeletronicoNew != null) {
                codmdfeletronicoNew = em.getReference(codmdfeletronicoNew.getClass(), codmdfeletronicoNew.getCodmdfeletronico());
                mdfeletronicolacre.setCodmdfeletronico(codmdfeletronicoNew);
            }
            mdfeletronicolacre = em.merge(mdfeletronicolacre);
            if (codmdfeletronicoOld != null && !codmdfeletronicoOld.equals(codmdfeletronicoNew)) {
                codmdfeletronicoOld.getMdfeletronicolacreCollection().remove(mdfeletronicolacre);
                codmdfeletronicoOld = em.merge(codmdfeletronicoOld);
            }
            if (codmdfeletronicoNew != null && !codmdfeletronicoNew.equals(codmdfeletronicoOld)) {
                codmdfeletronicoNew.getMdfeletronicolacreCollection().add(mdfeletronicolacre);
                codmdfeletronicoNew = em.merge(codmdfeletronicoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = mdfeletronicolacre.getCodmdfeletronicolacre();
                if (findMdfeletronicolacre(id) == null) {
                    throw new NonexistentEntityException("The mdfeletronicolacre with id " + id + " no longer exists.");
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
            Mdfeletronicolacre mdfeletronicolacre;
            try {
                mdfeletronicolacre = em.getReference(Mdfeletronicolacre.class, id);
                mdfeletronicolacre.getCodmdfeletronicolacre();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mdfeletronicolacre with id " + id + " no longer exists.", enfe);
            }
            Mdfeletronico codmdfeletronico = mdfeletronicolacre.getCodmdfeletronico();
            if (codmdfeletronico != null) {
                codmdfeletronico.getMdfeletronicolacreCollection().remove(mdfeletronicolacre);
                codmdfeletronico = em.merge(codmdfeletronico);
            }
            em.remove(mdfeletronicolacre);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mdfeletronicolacre> findMdfeletronicolacreEntities() {
        return findMdfeletronicolacreEntities(true, -1, -1);
    }

    public List<Mdfeletronicolacre> findMdfeletronicolacreEntities(int maxResults, int firstResult) {
        return findMdfeletronicolacreEntities(false, maxResults, firstResult);
    }

    private List<Mdfeletronicolacre> findMdfeletronicolacreEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mdfeletronicolacre.class));
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

    public Mdfeletronicolacre findMdfeletronicolacre(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mdfeletronicolacre.class, id);
        } finally {
            em.close();
        }
    }

    public int getMdfeletronicolacreCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mdfeletronicolacre> rt = cq.from(Mdfeletronicolacre.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

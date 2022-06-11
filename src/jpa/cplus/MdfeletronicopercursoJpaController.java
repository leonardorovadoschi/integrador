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
import entidade.cplus.Mdfeletronicopercurso;
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
public class MdfeletronicopercursoJpaController implements Serializable {

    public MdfeletronicopercursoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Mdfeletronicopercurso mdfeletronicopercurso) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mdfeletronico codmdfeletronico = mdfeletronicopercurso.getCodmdfeletronico();
            if (codmdfeletronico != null) {
                codmdfeletronico = em.getReference(codmdfeletronico.getClass(), codmdfeletronico.getCodmdfeletronico());
                mdfeletronicopercurso.setCodmdfeletronico(codmdfeletronico);
            }
            Uf coduf = mdfeletronicopercurso.getCoduf();
            if (coduf != null) {
                coduf = em.getReference(coduf.getClass(), coduf.getCoduf());
                mdfeletronicopercurso.setCoduf(coduf);
            }
            em.persist(mdfeletronicopercurso);
            if (codmdfeletronico != null) {
                codmdfeletronico.getMdfeletronicopercursoCollection().add(mdfeletronicopercurso);
                codmdfeletronico = em.merge(codmdfeletronico);
            }
            if (coduf != null) {
                coduf.getMdfeletronicopercursoCollection().add(mdfeletronicopercurso);
                coduf = em.merge(coduf);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMdfeletronicopercurso(mdfeletronicopercurso.getCodmdfeletronicopercurso()) != null) {
                throw new PreexistingEntityException("Mdfeletronicopercurso " + mdfeletronicopercurso + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Mdfeletronicopercurso mdfeletronicopercurso) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Mdfeletronicopercurso persistentMdfeletronicopercurso = em.find(Mdfeletronicopercurso.class, mdfeletronicopercurso.getCodmdfeletronicopercurso());
            Mdfeletronico codmdfeletronicoOld = persistentMdfeletronicopercurso.getCodmdfeletronico();
            Mdfeletronico codmdfeletronicoNew = mdfeletronicopercurso.getCodmdfeletronico();
            Uf codufOld = persistentMdfeletronicopercurso.getCoduf();
            Uf codufNew = mdfeletronicopercurso.getCoduf();
            if (codmdfeletronicoNew != null) {
                codmdfeletronicoNew = em.getReference(codmdfeletronicoNew.getClass(), codmdfeletronicoNew.getCodmdfeletronico());
                mdfeletronicopercurso.setCodmdfeletronico(codmdfeletronicoNew);
            }
            if (codufNew != null) {
                codufNew = em.getReference(codufNew.getClass(), codufNew.getCoduf());
                mdfeletronicopercurso.setCoduf(codufNew);
            }
            mdfeletronicopercurso = em.merge(mdfeletronicopercurso);
            if (codmdfeletronicoOld != null && !codmdfeletronicoOld.equals(codmdfeletronicoNew)) {
                codmdfeletronicoOld.getMdfeletronicopercursoCollection().remove(mdfeletronicopercurso);
                codmdfeletronicoOld = em.merge(codmdfeletronicoOld);
            }
            if (codmdfeletronicoNew != null && !codmdfeletronicoNew.equals(codmdfeletronicoOld)) {
                codmdfeletronicoNew.getMdfeletronicopercursoCollection().add(mdfeletronicopercurso);
                codmdfeletronicoNew = em.merge(codmdfeletronicoNew);
            }
            if (codufOld != null && !codufOld.equals(codufNew)) {
                codufOld.getMdfeletronicopercursoCollection().remove(mdfeletronicopercurso);
                codufOld = em.merge(codufOld);
            }
            if (codufNew != null && !codufNew.equals(codufOld)) {
                codufNew.getMdfeletronicopercursoCollection().add(mdfeletronicopercurso);
                codufNew = em.merge(codufNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = mdfeletronicopercurso.getCodmdfeletronicopercurso();
                if (findMdfeletronicopercurso(id) == null) {
                    throw new NonexistentEntityException("The mdfeletronicopercurso with id " + id + " no longer exists.");
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
            Mdfeletronicopercurso mdfeletronicopercurso;
            try {
                mdfeletronicopercurso = em.getReference(Mdfeletronicopercurso.class, id);
                mdfeletronicopercurso.getCodmdfeletronicopercurso();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mdfeletronicopercurso with id " + id + " no longer exists.", enfe);
            }
            Mdfeletronico codmdfeletronico = mdfeletronicopercurso.getCodmdfeletronico();
            if (codmdfeletronico != null) {
                codmdfeletronico.getMdfeletronicopercursoCollection().remove(mdfeletronicopercurso);
                codmdfeletronico = em.merge(codmdfeletronico);
            }
            Uf coduf = mdfeletronicopercurso.getCoduf();
            if (coduf != null) {
                coduf.getMdfeletronicopercursoCollection().remove(mdfeletronicopercurso);
                coduf = em.merge(coduf);
            }
            em.remove(mdfeletronicopercurso);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Mdfeletronicopercurso> findMdfeletronicopercursoEntities() {
        return findMdfeletronicopercursoEntities(true, -1, -1);
    }

    public List<Mdfeletronicopercurso> findMdfeletronicopercursoEntities(int maxResults, int firstResult) {
        return findMdfeletronicopercursoEntities(false, maxResults, firstResult);
    }

    private List<Mdfeletronicopercurso> findMdfeletronicopercursoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Mdfeletronicopercurso.class));
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

    public Mdfeletronicopercurso findMdfeletronicopercurso(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Mdfeletronicopercurso.class, id);
        } finally {
            em.close();
        }
    }

    public int getMdfeletronicopercursoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Mdfeletronicopercurso> rt = cq.from(Mdfeletronicopercurso.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

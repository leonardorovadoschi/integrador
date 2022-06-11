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
import entidade.cplus.Campocustommaster;
import entidade.cplus.Campocustomvalor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class CampocustomvalorJpaController implements Serializable {

    public CampocustomvalorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Campocustomvalor campocustomvalor) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Campocustommaster codcampocustommaster = campocustomvalor.getCodcampocustommaster();
            if (codcampocustommaster != null) {
                codcampocustommaster = em.getReference(codcampocustommaster.getClass(), codcampocustommaster.getCodcampocustommaster());
                campocustomvalor.setCodcampocustommaster(codcampocustommaster);
            }
            em.persist(campocustomvalor);
            if (codcampocustommaster != null) {
                codcampocustommaster.getCampocustomvalorCollection().add(campocustomvalor);
                codcampocustommaster = em.merge(codcampocustommaster);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCampocustomvalor(campocustomvalor.getCodcampocustomvalor()) != null) {
                throw new PreexistingEntityException("Campocustomvalor " + campocustomvalor + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Campocustomvalor campocustomvalor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Campocustomvalor persistentCampocustomvalor = em.find(Campocustomvalor.class, campocustomvalor.getCodcampocustomvalor());
            Campocustommaster codcampocustommasterOld = persistentCampocustomvalor.getCodcampocustommaster();
            Campocustommaster codcampocustommasterNew = campocustomvalor.getCodcampocustommaster();
            if (codcampocustommasterNew != null) {
                codcampocustommasterNew = em.getReference(codcampocustommasterNew.getClass(), codcampocustommasterNew.getCodcampocustommaster());
                campocustomvalor.setCodcampocustommaster(codcampocustommasterNew);
            }
            campocustomvalor = em.merge(campocustomvalor);
            if (codcampocustommasterOld != null && !codcampocustommasterOld.equals(codcampocustommasterNew)) {
                codcampocustommasterOld.getCampocustomvalorCollection().remove(campocustomvalor);
                codcampocustommasterOld = em.merge(codcampocustommasterOld);
            }
            if (codcampocustommasterNew != null && !codcampocustommasterNew.equals(codcampocustommasterOld)) {
                codcampocustommasterNew.getCampocustomvalorCollection().add(campocustomvalor);
                codcampocustommasterNew = em.merge(codcampocustommasterNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = campocustomvalor.getCodcampocustomvalor();
                if (findCampocustomvalor(id) == null) {
                    throw new NonexistentEntityException("The campocustomvalor with id " + id + " no longer exists.");
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
            Campocustomvalor campocustomvalor;
            try {
                campocustomvalor = em.getReference(Campocustomvalor.class, id);
                campocustomvalor.getCodcampocustomvalor();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The campocustomvalor with id " + id + " no longer exists.", enfe);
            }
            Campocustommaster codcampocustommaster = campocustomvalor.getCodcampocustommaster();
            if (codcampocustommaster != null) {
                codcampocustommaster.getCampocustomvalorCollection().remove(campocustomvalor);
                codcampocustommaster = em.merge(codcampocustommaster);
            }
            em.remove(campocustomvalor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Campocustomvalor> findCampocustomvalorEntities() {
        return findCampocustomvalorEntities(true, -1, -1);
    }

    public List<Campocustomvalor> findCampocustomvalorEntities(int maxResults, int firstResult) {
        return findCampocustomvalorEntities(false, maxResults, firstResult);
    }

    private List<Campocustomvalor> findCampocustomvalorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Campocustomvalor.class));
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

    public Campocustomvalor findCampocustomvalor(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Campocustomvalor.class, id);
        } finally {
            em.close();
        }
    }

    public int getCampocustomvalorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Campocustomvalor> rt = cq.from(Campocustomvalor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

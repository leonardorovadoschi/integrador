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
import entidade.cplus.Tributacaoecf;
import entidade.cplus.Tributacaoecfuf;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class TributacaoecfufJpaController implements Serializable {

    public TributacaoecfufJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tributacaoecfuf tributacaoecfuf) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tributacaoecf codtributacaoecf = tributacaoecfuf.getCodtributacaoecf();
            if (codtributacaoecf != null) {
                codtributacaoecf = em.getReference(codtributacaoecf.getClass(), codtributacaoecf.getCodtributacaoecf());
                tributacaoecfuf.setCodtributacaoecf(codtributacaoecf);
            }
            em.persist(tributacaoecfuf);
            if (codtributacaoecf != null) {
                codtributacaoecf.getTributacaoecfufCollection().add(tributacaoecfuf);
                codtributacaoecf = em.merge(codtributacaoecf);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTributacaoecfuf(tributacaoecfuf.getCodtributacaoecfuf()) != null) {
                throw new PreexistingEntityException("Tributacaoecfuf " + tributacaoecfuf + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tributacaoecfuf tributacaoecfuf) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tributacaoecfuf persistentTributacaoecfuf = em.find(Tributacaoecfuf.class, tributacaoecfuf.getCodtributacaoecfuf());
            Tributacaoecf codtributacaoecfOld = persistentTributacaoecfuf.getCodtributacaoecf();
            Tributacaoecf codtributacaoecfNew = tributacaoecfuf.getCodtributacaoecf();
            if (codtributacaoecfNew != null) {
                codtributacaoecfNew = em.getReference(codtributacaoecfNew.getClass(), codtributacaoecfNew.getCodtributacaoecf());
                tributacaoecfuf.setCodtributacaoecf(codtributacaoecfNew);
            }
            tributacaoecfuf = em.merge(tributacaoecfuf);
            if (codtributacaoecfOld != null && !codtributacaoecfOld.equals(codtributacaoecfNew)) {
                codtributacaoecfOld.getTributacaoecfufCollection().remove(tributacaoecfuf);
                codtributacaoecfOld = em.merge(codtributacaoecfOld);
            }
            if (codtributacaoecfNew != null && !codtributacaoecfNew.equals(codtributacaoecfOld)) {
                codtributacaoecfNew.getTributacaoecfufCollection().add(tributacaoecfuf);
                codtributacaoecfNew = em.merge(codtributacaoecfNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = tributacaoecfuf.getCodtributacaoecfuf();
                if (findTributacaoecfuf(id) == null) {
                    throw new NonexistentEntityException("The tributacaoecfuf with id " + id + " no longer exists.");
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
            Tributacaoecfuf tributacaoecfuf;
            try {
                tributacaoecfuf = em.getReference(Tributacaoecfuf.class, id);
                tributacaoecfuf.getCodtributacaoecfuf();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tributacaoecfuf with id " + id + " no longer exists.", enfe);
            }
            Tributacaoecf codtributacaoecf = tributacaoecfuf.getCodtributacaoecf();
            if (codtributacaoecf != null) {
                codtributacaoecf.getTributacaoecfufCollection().remove(tributacaoecfuf);
                codtributacaoecf = em.merge(codtributacaoecf);
            }
            em.remove(tributacaoecfuf);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tributacaoecfuf> findTributacaoecfufEntities() {
        return findTributacaoecfufEntities(true, -1, -1);
    }

    public List<Tributacaoecfuf> findTributacaoecfufEntities(int maxResults, int firstResult) {
        return findTributacaoecfufEntities(false, maxResults, firstResult);
    }

    private List<Tributacaoecfuf> findTributacaoecfufEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tributacaoecfuf.class));
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

    public Tributacaoecfuf findTributacaoecfuf(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tributacaoecfuf.class, id);
        } finally {
            em.close();
        }
    }

    public int getTributacaoecfufCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tributacaoecfuf> rt = cq.from(Tributacaoecfuf.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

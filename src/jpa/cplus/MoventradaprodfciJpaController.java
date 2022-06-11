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
import entidade.cplus.Moventradaprod;
import entidade.cplus.Moventradaprodfci;
import entidade.cplus.Produtofci;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MoventradaprodfciJpaController implements Serializable {

    public MoventradaprodfciJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Moventradaprodfci moventradaprodfci) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Moventradaprod codmoveprod = moventradaprodfci.getCodmoveprod();
            if (codmoveprod != null) {
                codmoveprod = em.getReference(codmoveprod.getClass(), codmoveprod.getCodmoveprod());
                moventradaprodfci.setCodmoveprod(codmoveprod);
            }
            Produtofci codprodutofci = moventradaprodfci.getCodprodutofci();
            if (codprodutofci != null) {
                codprodutofci = em.getReference(codprodutofci.getClass(), codprodutofci.getCodprodutofci());
                moventradaprodfci.setCodprodutofci(codprodutofci);
            }
            em.persist(moventradaprodfci);
            if (codmoveprod != null) {
                codmoveprod.getMoventradaprodfciCollection().add(moventradaprodfci);
                codmoveprod = em.merge(codmoveprod);
            }
            if (codprodutofci != null) {
                codprodutofci.getMoventradaprodfciCollection().add(moventradaprodfci);
                codprodutofci = em.merge(codprodutofci);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMoventradaprodfci(moventradaprodfci.getCodmoventradaprodfci()) != null) {
                throw new PreexistingEntityException("Moventradaprodfci " + moventradaprodfci + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Moventradaprodfci moventradaprodfci) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Moventradaprodfci persistentMoventradaprodfci = em.find(Moventradaprodfci.class, moventradaprodfci.getCodmoventradaprodfci());
            Moventradaprod codmoveprodOld = persistentMoventradaprodfci.getCodmoveprod();
            Moventradaprod codmoveprodNew = moventradaprodfci.getCodmoveprod();
            Produtofci codprodutofciOld = persistentMoventradaprodfci.getCodprodutofci();
            Produtofci codprodutofciNew = moventradaprodfci.getCodprodutofci();
            if (codmoveprodNew != null) {
                codmoveprodNew = em.getReference(codmoveprodNew.getClass(), codmoveprodNew.getCodmoveprod());
                moventradaprodfci.setCodmoveprod(codmoveprodNew);
            }
            if (codprodutofciNew != null) {
                codprodutofciNew = em.getReference(codprodutofciNew.getClass(), codprodutofciNew.getCodprodutofci());
                moventradaprodfci.setCodprodutofci(codprodutofciNew);
            }
            moventradaprodfci = em.merge(moventradaprodfci);
            if (codmoveprodOld != null && !codmoveprodOld.equals(codmoveprodNew)) {
                codmoveprodOld.getMoventradaprodfciCollection().remove(moventradaprodfci);
                codmoveprodOld = em.merge(codmoveprodOld);
            }
            if (codmoveprodNew != null && !codmoveprodNew.equals(codmoveprodOld)) {
                codmoveprodNew.getMoventradaprodfciCollection().add(moventradaprodfci);
                codmoveprodNew = em.merge(codmoveprodNew);
            }
            if (codprodutofciOld != null && !codprodutofciOld.equals(codprodutofciNew)) {
                codprodutofciOld.getMoventradaprodfciCollection().remove(moventradaprodfci);
                codprodutofciOld = em.merge(codprodutofciOld);
            }
            if (codprodutofciNew != null && !codprodutofciNew.equals(codprodutofciOld)) {
                codprodutofciNew.getMoventradaprodfciCollection().add(moventradaprodfci);
                codprodutofciNew = em.merge(codprodutofciNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = moventradaprodfci.getCodmoventradaprodfci();
                if (findMoventradaprodfci(id) == null) {
                    throw new NonexistentEntityException("The moventradaprodfci with id " + id + " no longer exists.");
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
            Moventradaprodfci moventradaprodfci;
            try {
                moventradaprodfci = em.getReference(Moventradaprodfci.class, id);
                moventradaprodfci.getCodmoventradaprodfci();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The moventradaprodfci with id " + id + " no longer exists.", enfe);
            }
            Moventradaprod codmoveprod = moventradaprodfci.getCodmoveprod();
            if (codmoveprod != null) {
                codmoveprod.getMoventradaprodfciCollection().remove(moventradaprodfci);
                codmoveprod = em.merge(codmoveprod);
            }
            Produtofci codprodutofci = moventradaprodfci.getCodprodutofci();
            if (codprodutofci != null) {
                codprodutofci.getMoventradaprodfciCollection().remove(moventradaprodfci);
                codprodutofci = em.merge(codprodutofci);
            }
            em.remove(moventradaprodfci);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Moventradaprodfci> findMoventradaprodfciEntities() {
        return findMoventradaprodfciEntities(true, -1, -1);
    }

    public List<Moventradaprodfci> findMoventradaprodfciEntities(int maxResults, int firstResult) {
        return findMoventradaprodfciEntities(false, maxResults, firstResult);
    }

    private List<Moventradaprodfci> findMoventradaprodfciEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Moventradaprodfci.class));
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

    public Moventradaprodfci findMoventradaprodfci(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Moventradaprodfci.class, id);
        } finally {
            em.close();
        }
    }

    public int getMoventradaprodfciCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Moventradaprodfci> rt = cq.from(Moventradaprodfci.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

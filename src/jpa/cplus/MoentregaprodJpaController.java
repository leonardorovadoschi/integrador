/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Moentregaprod;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Movenda;
import entidade.cplus.Movendaprod;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MoentregaprodJpaController implements Serializable {

    public MoentregaprodJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Moentregaprod moentregaprod) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movenda codmovenda = moentregaprod.getCodmovenda();
            if (codmovenda != null) {
                codmovenda = em.getReference(codmovenda.getClass(), codmovenda.getCodmovenda());
                moentregaprod.setCodmovenda(codmovenda);
            }
            Movendaprod codmovprod = moentregaprod.getCodmovprod();
            if (codmovprod != null) {
                codmovprod = em.getReference(codmovprod.getClass(), codmovprod.getCodmovprod());
                moentregaprod.setCodmovprod(codmovprod);
            }
            em.persist(moentregaprod);
            if (codmovenda != null) {
                codmovenda.getMoentregaprodCollection().add(moentregaprod);
                codmovenda = em.merge(codmovenda);
            }
            if (codmovprod != null) {
                codmovprod.getMoentregaprodCollection().add(moentregaprod);
                codmovprod = em.merge(codmovprod);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMoentregaprod(moentregaprod.getId()) != null) {
                throw new PreexistingEntityException("Moentregaprod " + moentregaprod + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Moentregaprod moentregaprod) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Moentregaprod persistentMoentregaprod = em.find(Moentregaprod.class, moentregaprod.getId());
            Movenda codmovendaOld = persistentMoentregaprod.getCodmovenda();
            Movenda codmovendaNew = moentregaprod.getCodmovenda();
            Movendaprod codmovprodOld = persistentMoentregaprod.getCodmovprod();
            Movendaprod codmovprodNew = moentregaprod.getCodmovprod();
            if (codmovendaNew != null) {
                codmovendaNew = em.getReference(codmovendaNew.getClass(), codmovendaNew.getCodmovenda());
                moentregaprod.setCodmovenda(codmovendaNew);
            }
            if (codmovprodNew != null) {
                codmovprodNew = em.getReference(codmovprodNew.getClass(), codmovprodNew.getCodmovprod());
                moentregaprod.setCodmovprod(codmovprodNew);
            }
            moentregaprod = em.merge(moentregaprod);
            if (codmovendaOld != null && !codmovendaOld.equals(codmovendaNew)) {
                codmovendaOld.getMoentregaprodCollection().remove(moentregaprod);
                codmovendaOld = em.merge(codmovendaOld);
            }
            if (codmovendaNew != null && !codmovendaNew.equals(codmovendaOld)) {
                codmovendaNew.getMoentregaprodCollection().add(moentregaprod);
                codmovendaNew = em.merge(codmovendaNew);
            }
            if (codmovprodOld != null && !codmovprodOld.equals(codmovprodNew)) {
                codmovprodOld.getMoentregaprodCollection().remove(moentregaprod);
                codmovprodOld = em.merge(codmovprodOld);
            }
            if (codmovprodNew != null && !codmovprodNew.equals(codmovprodOld)) {
                codmovprodNew.getMoentregaprodCollection().add(moentregaprod);
                codmovprodNew = em.merge(codmovprodNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = moentregaprod.getId();
                if (findMoentregaprod(id) == null) {
                    throw new NonexistentEntityException("The moentregaprod with id " + id + " no longer exists.");
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
            Moentregaprod moentregaprod;
            try {
                moentregaprod = em.getReference(Moentregaprod.class, id);
                moentregaprod.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The moentregaprod with id " + id + " no longer exists.", enfe);
            }
            Movenda codmovenda = moentregaprod.getCodmovenda();
            if (codmovenda != null) {
                codmovenda.getMoentregaprodCollection().remove(moentregaprod);
                codmovenda = em.merge(codmovenda);
            }
            Movendaprod codmovprod = moentregaprod.getCodmovprod();
            if (codmovprod != null) {
                codmovprod.getMoentregaprodCollection().remove(moentregaprod);
                codmovprod = em.merge(codmovprod);
            }
            em.remove(moentregaprod);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Moentregaprod> findMoentregaprodEntities() {
        return findMoentregaprodEntities(true, -1, -1);
    }

    public List<Moentregaprod> findMoentregaprodEntities(int maxResults, int firstResult) {
        return findMoentregaprodEntities(false, maxResults, firstResult);
    }

    private List<Moentregaprod> findMoentregaprodEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Moentregaprod.class));
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

    public Moentregaprod findMoentregaprod(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Moentregaprod.class, id);
        } finally {
            em.close();
        }
    }

    public int getMoentregaprodCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Moentregaprod> rt = cq.from(Moentregaprod.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

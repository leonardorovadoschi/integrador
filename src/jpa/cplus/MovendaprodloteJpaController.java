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
import entidade.cplus.Movendaprod;
import entidade.cplus.Movendaprodlote;
import entidade.cplus.Produtolote;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class MovendaprodloteJpaController implements Serializable {

    public MovendaprodloteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Movendaprodlote movendaprodlote) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movendaprod codmovprod = movendaprodlote.getCodmovprod();
            if (codmovprod != null) {
                codmovprod = em.getReference(codmovprod.getClass(), codmovprod.getCodmovprod());
                movendaprodlote.setCodmovprod(codmovprod);
            }
            Produtolote codprodutolote = movendaprodlote.getCodprodutolote();
            if (codprodutolote != null) {
                codprodutolote = em.getReference(codprodutolote.getClass(), codprodutolote.getCodprodutolote());
                movendaprodlote.setCodprodutolote(codprodutolote);
            }
            em.persist(movendaprodlote);
            if (codmovprod != null) {
                codmovprod.getMovendaprodloteCollection().add(movendaprodlote);
                codmovprod = em.merge(codmovprod);
            }
            if (codprodutolote != null) {
                codprodutolote.getMovendaprodloteCollection().add(movendaprodlote);
                codprodutolote = em.merge(codprodutolote);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMovendaprodlote(movendaprodlote.getCodmovendaprodlote()) != null) {
                throw new PreexistingEntityException("Movendaprodlote " + movendaprodlote + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Movendaprodlote movendaprodlote) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Movendaprodlote persistentMovendaprodlote = em.find(Movendaprodlote.class, movendaprodlote.getCodmovendaprodlote());
            Movendaprod codmovprodOld = persistentMovendaprodlote.getCodmovprod();
            Movendaprod codmovprodNew = movendaprodlote.getCodmovprod();
            Produtolote codprodutoloteOld = persistentMovendaprodlote.getCodprodutolote();
            Produtolote codprodutoloteNew = movendaprodlote.getCodprodutolote();
            if (codmovprodNew != null) {
                codmovprodNew = em.getReference(codmovprodNew.getClass(), codmovprodNew.getCodmovprod());
                movendaprodlote.setCodmovprod(codmovprodNew);
            }
            if (codprodutoloteNew != null) {
                codprodutoloteNew = em.getReference(codprodutoloteNew.getClass(), codprodutoloteNew.getCodprodutolote());
                movendaprodlote.setCodprodutolote(codprodutoloteNew);
            }
            movendaprodlote = em.merge(movendaprodlote);
            if (codmovprodOld != null && !codmovprodOld.equals(codmovprodNew)) {
                codmovprodOld.getMovendaprodloteCollection().remove(movendaprodlote);
                codmovprodOld = em.merge(codmovprodOld);
            }
            if (codmovprodNew != null && !codmovprodNew.equals(codmovprodOld)) {
                codmovprodNew.getMovendaprodloteCollection().add(movendaprodlote);
                codmovprodNew = em.merge(codmovprodNew);
            }
            if (codprodutoloteOld != null && !codprodutoloteOld.equals(codprodutoloteNew)) {
                codprodutoloteOld.getMovendaprodloteCollection().remove(movendaprodlote);
                codprodutoloteOld = em.merge(codprodutoloteOld);
            }
            if (codprodutoloteNew != null && !codprodutoloteNew.equals(codprodutoloteOld)) {
                codprodutoloteNew.getMovendaprodloteCollection().add(movendaprodlote);
                codprodutoloteNew = em.merge(codprodutoloteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = movendaprodlote.getCodmovendaprodlote();
                if (findMovendaprodlote(id) == null) {
                    throw new NonexistentEntityException("The movendaprodlote with id " + id + " no longer exists.");
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
            Movendaprodlote movendaprodlote;
            try {
                movendaprodlote = em.getReference(Movendaprodlote.class, id);
                movendaprodlote.getCodmovendaprodlote();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movendaprodlote with id " + id + " no longer exists.", enfe);
            }
            Movendaprod codmovprod = movendaprodlote.getCodmovprod();
            if (codmovprod != null) {
                codmovprod.getMovendaprodloteCollection().remove(movendaprodlote);
                codmovprod = em.merge(codmovprod);
            }
            Produtolote codprodutolote = movendaprodlote.getCodprodutolote();
            if (codprodutolote != null) {
                codprodutolote.getMovendaprodloteCollection().remove(movendaprodlote);
                codprodutolote = em.merge(codprodutolote);
            }
            em.remove(movendaprodlote);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Movendaprodlote> findMovendaprodloteEntities() {
        return findMovendaprodloteEntities(true, -1, -1);
    }

    public List<Movendaprodlote> findMovendaprodloteEntities(int maxResults, int firstResult) {
        return findMovendaprodloteEntities(false, maxResults, firstResult);
    }

    private List<Movendaprodlote> findMovendaprodloteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Movendaprodlote.class));
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

    public Movendaprodlote findMovendaprodlote(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Movendaprodlote.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovendaprodloteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Movendaprodlote> rt = cq.from(Movendaprodlote.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

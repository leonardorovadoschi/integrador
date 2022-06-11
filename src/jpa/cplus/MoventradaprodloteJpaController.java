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
import entidade.cplus.Moventradaprodlote;
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
public class MoventradaprodloteJpaController implements Serializable {

    public MoventradaprodloteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Moventradaprodlote moventradaprodlote) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Moventradaprod codmoveprod = moventradaprodlote.getCodmoveprod();
            if (codmoveprod != null) {
                codmoveprod = em.getReference(codmoveprod.getClass(), codmoveprod.getCodmoveprod());
                moventradaprodlote.setCodmoveprod(codmoveprod);
            }
            Produtolote codprodutolote = moventradaprodlote.getCodprodutolote();
            if (codprodutolote != null) {
                codprodutolote = em.getReference(codprodutolote.getClass(), codprodutolote.getCodprodutolote());
                moventradaprodlote.setCodprodutolote(codprodutolote);
            }
            em.persist(moventradaprodlote);
            if (codmoveprod != null) {
                codmoveprod.getMoventradaprodloteCollection().add(moventradaprodlote);
                codmoveprod = em.merge(codmoveprod);
            }
            if (codprodutolote != null) {
                codprodutolote.getMoventradaprodloteCollection().add(moventradaprodlote);
                codprodutolote = em.merge(codprodutolote);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMoventradaprodlote(moventradaprodlote.getCodmoventradaprodlote()) != null) {
                throw new PreexistingEntityException("Moventradaprodlote " + moventradaprodlote + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Moventradaprodlote moventradaprodlote) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Moventradaprodlote persistentMoventradaprodlote = em.find(Moventradaprodlote.class, moventradaprodlote.getCodmoventradaprodlote());
            Moventradaprod codmoveprodOld = persistentMoventradaprodlote.getCodmoveprod();
            Moventradaprod codmoveprodNew = moventradaprodlote.getCodmoveprod();
            Produtolote codprodutoloteOld = persistentMoventradaprodlote.getCodprodutolote();
            Produtolote codprodutoloteNew = moventradaprodlote.getCodprodutolote();
            if (codmoveprodNew != null) {
                codmoveprodNew = em.getReference(codmoveprodNew.getClass(), codmoveprodNew.getCodmoveprod());
                moventradaprodlote.setCodmoveprod(codmoveprodNew);
            }
            if (codprodutoloteNew != null) {
                codprodutoloteNew = em.getReference(codprodutoloteNew.getClass(), codprodutoloteNew.getCodprodutolote());
                moventradaprodlote.setCodprodutolote(codprodutoloteNew);
            }
            moventradaprodlote = em.merge(moventradaprodlote);
            if (codmoveprodOld != null && !codmoveprodOld.equals(codmoveprodNew)) {
                codmoveprodOld.getMoventradaprodloteCollection().remove(moventradaprodlote);
                codmoveprodOld = em.merge(codmoveprodOld);
            }
            if (codmoveprodNew != null && !codmoveprodNew.equals(codmoveprodOld)) {
                codmoveprodNew.getMoventradaprodloteCollection().add(moventradaprodlote);
                codmoveprodNew = em.merge(codmoveprodNew);
            }
            if (codprodutoloteOld != null && !codprodutoloteOld.equals(codprodutoloteNew)) {
                codprodutoloteOld.getMoventradaprodloteCollection().remove(moventradaprodlote);
                codprodutoloteOld = em.merge(codprodutoloteOld);
            }
            if (codprodutoloteNew != null && !codprodutoloteNew.equals(codprodutoloteOld)) {
                codprodutoloteNew.getMoventradaprodloteCollection().add(moventradaprodlote);
                codprodutoloteNew = em.merge(codprodutoloteNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = moventradaprodlote.getCodmoventradaprodlote();
                if (findMoventradaprodlote(id) == null) {
                    throw new NonexistentEntityException("The moventradaprodlote with id " + id + " no longer exists.");
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
            Moventradaprodlote moventradaprodlote;
            try {
                moventradaprodlote = em.getReference(Moventradaprodlote.class, id);
                moventradaprodlote.getCodmoventradaprodlote();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The moventradaprodlote with id " + id + " no longer exists.", enfe);
            }
            Moventradaprod codmoveprod = moventradaprodlote.getCodmoveprod();
            if (codmoveprod != null) {
                codmoveprod.getMoventradaprodloteCollection().remove(moventradaprodlote);
                codmoveprod = em.merge(codmoveprod);
            }
            Produtolote codprodutolote = moventradaprodlote.getCodprodutolote();
            if (codprodutolote != null) {
                codprodutolote.getMoventradaprodloteCollection().remove(moventradaprodlote);
                codprodutolote = em.merge(codprodutolote);
            }
            em.remove(moventradaprodlote);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Moventradaprodlote> findMoventradaprodloteEntities() {
        return findMoventradaprodloteEntities(true, -1, -1);
    }

    public List<Moventradaprodlote> findMoventradaprodloteEntities(int maxResults, int firstResult) {
        return findMoventradaprodloteEntities(false, maxResults, firstResult);
    }

    private List<Moventradaprodlote> findMoventradaprodloteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Moventradaprodlote.class));
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

    public Moventradaprodlote findMoventradaprodlote(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Moventradaprodlote.class, id);
        } finally {
            em.close();
        }
    }

    public int getMoventradaprodloteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Moventradaprodlote> rt = cq.from(Moventradaprodlote.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

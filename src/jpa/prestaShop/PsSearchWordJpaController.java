/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.prestaShop;

import entidade.prestaShop.PsSearchWord;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import jpa.prestaShop.exceptions.NonexistentEntityException;

/**
 *
 * @author leo
 */
public class PsSearchWordJpaController implements Serializable {

    public PsSearchWordJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PsSearchWord psSearchWord) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(psSearchWord);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PsSearchWord psSearchWord) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            psSearchWord = em.merge(psSearchWord);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = psSearchWord.getIdWord();
                if (findPsSearchWord(id) == null) {
                    throw new NonexistentEntityException("The psSearchWord with id " + id + " no longer exists.");
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
            PsSearchWord psSearchWord;
            try {
                psSearchWord = em.getReference(PsSearchWord.class, id);
                psSearchWord.getIdWord();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The psSearchWord with id " + id + " no longer exists.", enfe);
            }
            em.remove(psSearchWord);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PsSearchWord> findPsSearchWordEntities() {
        return findPsSearchWordEntities(true, -1, -1);
    }

    public List<PsSearchWord> findPsSearchWordEntities(int maxResults, int firstResult) {
        return findPsSearchWordEntities(false, maxResults, firstResult);
    }

    private List<PsSearchWord> findPsSearchWordEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PsSearchWord.class));
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

    public PsSearchWord findPsSearchWord(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PsSearchWord.class, id);
        } finally {
            em.close();
        }
    }

    public int getPsSearchWordCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PsSearchWord> rt = cq.from(PsSearchWord.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

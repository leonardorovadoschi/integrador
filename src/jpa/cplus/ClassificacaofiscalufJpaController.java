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
import entidade.cplus.Classificacaofiscal;
import entidade.cplus.Classificacaofiscaluf;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ClassificacaofiscalufJpaController implements Serializable {

    public ClassificacaofiscalufJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Classificacaofiscaluf classificacaofiscaluf) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Classificacaofiscal codclassificacaofiscal = classificacaofiscaluf.getCodclassificacaofiscal();
            if (codclassificacaofiscal != null) {
                codclassificacaofiscal = em.getReference(codclassificacaofiscal.getClass(), codclassificacaofiscal.getCodclassificacaofiscal());
                classificacaofiscaluf.setCodclassificacaofiscal(codclassificacaofiscal);
            }
            em.persist(classificacaofiscaluf);
            if (codclassificacaofiscal != null) {
                codclassificacaofiscal.getClassificacaofiscalufCollection().add(classificacaofiscaluf);
                codclassificacaofiscal = em.merge(codclassificacaofiscal);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findClassificacaofiscaluf(classificacaofiscaluf.getCodclassificacaofiscaluf()) != null) {
                throw new PreexistingEntityException("Classificacaofiscaluf " + classificacaofiscaluf + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Classificacaofiscaluf classificacaofiscaluf) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Classificacaofiscaluf persistentClassificacaofiscaluf = em.find(Classificacaofiscaluf.class, classificacaofiscaluf.getCodclassificacaofiscaluf());
            Classificacaofiscal codclassificacaofiscalOld = persistentClassificacaofiscaluf.getCodclassificacaofiscal();
            Classificacaofiscal codclassificacaofiscalNew = classificacaofiscaluf.getCodclassificacaofiscal();
            if (codclassificacaofiscalNew != null) {
                codclassificacaofiscalNew = em.getReference(codclassificacaofiscalNew.getClass(), codclassificacaofiscalNew.getCodclassificacaofiscal());
                classificacaofiscaluf.setCodclassificacaofiscal(codclassificacaofiscalNew);
            }
            classificacaofiscaluf = em.merge(classificacaofiscaluf);
            if (codclassificacaofiscalOld != null && !codclassificacaofiscalOld.equals(codclassificacaofiscalNew)) {
                codclassificacaofiscalOld.getClassificacaofiscalufCollection().remove(classificacaofiscaluf);
                codclassificacaofiscalOld = em.merge(codclassificacaofiscalOld);
            }
            if (codclassificacaofiscalNew != null && !codclassificacaofiscalNew.equals(codclassificacaofiscalOld)) {
                codclassificacaofiscalNew.getClassificacaofiscalufCollection().add(classificacaofiscaluf);
                codclassificacaofiscalNew = em.merge(codclassificacaofiscalNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = classificacaofiscaluf.getCodclassificacaofiscaluf();
                if (findClassificacaofiscaluf(id) == null) {
                    throw new NonexistentEntityException("The classificacaofiscaluf with id " + id + " no longer exists.");
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
            Classificacaofiscaluf classificacaofiscaluf;
            try {
                classificacaofiscaluf = em.getReference(Classificacaofiscaluf.class, id);
                classificacaofiscaluf.getCodclassificacaofiscaluf();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The classificacaofiscaluf with id " + id + " no longer exists.", enfe);
            }
            Classificacaofiscal codclassificacaofiscal = classificacaofiscaluf.getCodclassificacaofiscal();
            if (codclassificacaofiscal != null) {
                codclassificacaofiscal.getClassificacaofiscalufCollection().remove(classificacaofiscaluf);
                codclassificacaofiscal = em.merge(codclassificacaofiscal);
            }
            em.remove(classificacaofiscaluf);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Classificacaofiscaluf> findClassificacaofiscalufEntities() {
        return findClassificacaofiscalufEntities(true, -1, -1);
    }

    public List<Classificacaofiscaluf> findClassificacaofiscalufEntities(int maxResults, int firstResult) {
        return findClassificacaofiscalufEntities(false, maxResults, firstResult);
    }

    private List<Classificacaofiscaluf> findClassificacaofiscalufEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Classificacaofiscaluf.class));
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

    public Classificacaofiscaluf findClassificacaofiscaluf(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Classificacaofiscaluf.class, id);
        } finally {
            em.close();
        }
    }

    public int getClassificacaofiscalufCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Classificacaofiscaluf> rt = cq.from(Classificacaofiscaluf.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

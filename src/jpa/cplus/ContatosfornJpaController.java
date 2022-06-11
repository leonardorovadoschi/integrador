/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Contatosforn;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Fornecedor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class ContatosfornJpaController implements Serializable {

    public ContatosfornJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Contatosforn contatosforn) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Fornecedor codforn = contatosforn.getCodforn();
            if (codforn != null) {
                codforn = em.getReference(codforn.getClass(), codforn.getCodforn());
                contatosforn.setCodforn(codforn);
            }
            em.persist(contatosforn);
            if (codforn != null) {
                codforn.getContatosfornCollection().add(contatosforn);
                codforn = em.merge(codforn);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findContatosforn(contatosforn.getCodcf()) != null) {
                throw new PreexistingEntityException("Contatosforn " + contatosforn + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Contatosforn contatosforn) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Contatosforn persistentContatosforn = em.find(Contatosforn.class, contatosforn.getCodcf());
            Fornecedor codfornOld = persistentContatosforn.getCodforn();
            Fornecedor codfornNew = contatosforn.getCodforn();
            if (codfornNew != null) {
                codfornNew = em.getReference(codfornNew.getClass(), codfornNew.getCodforn());
                contatosforn.setCodforn(codfornNew);
            }
            contatosforn = em.merge(contatosforn);
            if (codfornOld != null && !codfornOld.equals(codfornNew)) {
                codfornOld.getContatosfornCollection().remove(contatosforn);
                codfornOld = em.merge(codfornOld);
            }
            if (codfornNew != null && !codfornNew.equals(codfornOld)) {
                codfornNew.getContatosfornCollection().add(contatosforn);
                codfornNew = em.merge(codfornNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = contatosforn.getCodcf();
                if (findContatosforn(id) == null) {
                    throw new NonexistentEntityException("The contatosforn with id " + id + " no longer exists.");
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
            Contatosforn contatosforn;
            try {
                contatosforn = em.getReference(Contatosforn.class, id);
                contatosforn.getCodcf();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The contatosforn with id " + id + " no longer exists.", enfe);
            }
            Fornecedor codforn = contatosforn.getCodforn();
            if (codforn != null) {
                codforn.getContatosfornCollection().remove(contatosforn);
                codforn = em.merge(codforn);
            }
            em.remove(contatosforn);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Contatosforn> findContatosfornEntities() {
        return findContatosfornEntities(true, -1, -1);
    }

    public List<Contatosforn> findContatosfornEntities(int maxResults, int firstResult) {
        return findContatosfornEntities(false, maxResults, firstResult);
    }

    private List<Contatosforn> findContatosfornEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Contatosforn.class));
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

    public Contatosforn findContatosforn(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Contatosforn.class, id);
        } finally {
            em.close();
        }
    }

    public int getContatosfornCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Contatosforn> rt = cq.from(Contatosforn.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

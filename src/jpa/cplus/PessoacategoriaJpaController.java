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
import entidade.cplus.Categoriapessoa;
import entidade.cplus.Pessoa;
import entidade.cplus.Pessoacategoria;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class PessoacategoriaJpaController implements Serializable {

    public PessoacategoriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pessoacategoria pessoacategoria) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoriapessoa codcategoriapessoa = pessoacategoria.getCodcategoriapessoa();
            if (codcategoriapessoa != null) {
                codcategoriapessoa = em.getReference(codcategoriapessoa.getClass(), codcategoriapessoa.getCodcategoriapessoa());
                pessoacategoria.setCodcategoriapessoa(codcategoriapessoa);
            }
            Pessoa codpessoa = pessoacategoria.getCodpessoa();
            if (codpessoa != null) {
                codpessoa = em.getReference(codpessoa.getClass(), codpessoa.getCodpessoa());
                pessoacategoria.setCodpessoa(codpessoa);
            }
            em.persist(pessoacategoria);
            if (codcategoriapessoa != null) {
                codcategoriapessoa.getPessoacategoriaCollection().add(pessoacategoria);
                codcategoriapessoa = em.merge(codcategoriapessoa);
            }
            if (codpessoa != null) {
                codpessoa.getPessoacategoriaCollection().add(pessoacategoria);
                codpessoa = em.merge(codpessoa);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPessoacategoria(pessoacategoria.getCodpessoacategoria()) != null) {
                throw new PreexistingEntityException("Pessoacategoria " + pessoacategoria + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pessoacategoria pessoacategoria) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pessoacategoria persistentPessoacategoria = em.find(Pessoacategoria.class, pessoacategoria.getCodpessoacategoria());
            Categoriapessoa codcategoriapessoaOld = persistentPessoacategoria.getCodcategoriapessoa();
            Categoriapessoa codcategoriapessoaNew = pessoacategoria.getCodcategoriapessoa();
            Pessoa codpessoaOld = persistentPessoacategoria.getCodpessoa();
            Pessoa codpessoaNew = pessoacategoria.getCodpessoa();
            if (codcategoriapessoaNew != null) {
                codcategoriapessoaNew = em.getReference(codcategoriapessoaNew.getClass(), codcategoriapessoaNew.getCodcategoriapessoa());
                pessoacategoria.setCodcategoriapessoa(codcategoriapessoaNew);
            }
            if (codpessoaNew != null) {
                codpessoaNew = em.getReference(codpessoaNew.getClass(), codpessoaNew.getCodpessoa());
                pessoacategoria.setCodpessoa(codpessoaNew);
            }
            pessoacategoria = em.merge(pessoacategoria);
            if (codcategoriapessoaOld != null && !codcategoriapessoaOld.equals(codcategoriapessoaNew)) {
                codcategoriapessoaOld.getPessoacategoriaCollection().remove(pessoacategoria);
                codcategoriapessoaOld = em.merge(codcategoriapessoaOld);
            }
            if (codcategoriapessoaNew != null && !codcategoriapessoaNew.equals(codcategoriapessoaOld)) {
                codcategoriapessoaNew.getPessoacategoriaCollection().add(pessoacategoria);
                codcategoriapessoaNew = em.merge(codcategoriapessoaNew);
            }
            if (codpessoaOld != null && !codpessoaOld.equals(codpessoaNew)) {
                codpessoaOld.getPessoacategoriaCollection().remove(pessoacategoria);
                codpessoaOld = em.merge(codpessoaOld);
            }
            if (codpessoaNew != null && !codpessoaNew.equals(codpessoaOld)) {
                codpessoaNew.getPessoacategoriaCollection().add(pessoacategoria);
                codpessoaNew = em.merge(codpessoaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = pessoacategoria.getCodpessoacategoria();
                if (findPessoacategoria(id) == null) {
                    throw new NonexistentEntityException("The pessoacategoria with id " + id + " no longer exists.");
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
            Pessoacategoria pessoacategoria;
            try {
                pessoacategoria = em.getReference(Pessoacategoria.class, id);
                pessoacategoria.getCodpessoacategoria();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pessoacategoria with id " + id + " no longer exists.", enfe);
            }
            Categoriapessoa codcategoriapessoa = pessoacategoria.getCodcategoriapessoa();
            if (codcategoriapessoa != null) {
                codcategoriapessoa.getPessoacategoriaCollection().remove(pessoacategoria);
                codcategoriapessoa = em.merge(codcategoriapessoa);
            }
            Pessoa codpessoa = pessoacategoria.getCodpessoa();
            if (codpessoa != null) {
                codpessoa.getPessoacategoriaCollection().remove(pessoacategoria);
                codpessoa = em.merge(codpessoa);
            }
            em.remove(pessoacategoria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pessoacategoria> findPessoacategoriaEntities() {
        return findPessoacategoriaEntities(true, -1, -1);
    }

    public List<Pessoacategoria> findPessoacategoriaEntities(int maxResults, int firstResult) {
        return findPessoacategoriaEntities(false, maxResults, firstResult);
    }

    private List<Pessoacategoria> findPessoacategoriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pessoacategoria.class));
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

    public Pessoacategoria findPessoacategoria(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pessoacategoria.class, id);
        } finally {
            em.close();
        }
    }

    public int getPessoacategoriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pessoacategoria> rt = cq.from(Pessoacategoria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

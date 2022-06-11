/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Categoriapessoa;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Pessoacategoria;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class CategoriapessoaJpaController implements Serializable {

    public CategoriapessoaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Categoriapessoa categoriapessoa) throws PreexistingEntityException, Exception {
        if (categoriapessoa.getPessoacategoriaCollection() == null) {
            categoriapessoa.setPessoacategoriaCollection(new ArrayList<Pessoacategoria>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Pessoacategoria> attachedPessoacategoriaCollection = new ArrayList<Pessoacategoria>();
            for (Pessoacategoria pessoacategoriaCollectionPessoacategoriaToAttach : categoriapessoa.getPessoacategoriaCollection()) {
                pessoacategoriaCollectionPessoacategoriaToAttach = em.getReference(pessoacategoriaCollectionPessoacategoriaToAttach.getClass(), pessoacategoriaCollectionPessoacategoriaToAttach.getCodpessoacategoria());
                attachedPessoacategoriaCollection.add(pessoacategoriaCollectionPessoacategoriaToAttach);
            }
            categoriapessoa.setPessoacategoriaCollection(attachedPessoacategoriaCollection);
            em.persist(categoriapessoa);
            for (Pessoacategoria pessoacategoriaCollectionPessoacategoria : categoriapessoa.getPessoacategoriaCollection()) {
                Categoriapessoa oldCodcategoriapessoaOfPessoacategoriaCollectionPessoacategoria = pessoacategoriaCollectionPessoacategoria.getCodcategoriapessoa();
                pessoacategoriaCollectionPessoacategoria.setCodcategoriapessoa(categoriapessoa);
                pessoacategoriaCollectionPessoacategoria = em.merge(pessoacategoriaCollectionPessoacategoria);
                if (oldCodcategoriapessoaOfPessoacategoriaCollectionPessoacategoria != null) {
                    oldCodcategoriapessoaOfPessoacategoriaCollectionPessoacategoria.getPessoacategoriaCollection().remove(pessoacategoriaCollectionPessoacategoria);
                    oldCodcategoriapessoaOfPessoacategoriaCollectionPessoacategoria = em.merge(oldCodcategoriapessoaOfPessoacategoriaCollectionPessoacategoria);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCategoriapessoa(categoriapessoa.getCodcategoriapessoa()) != null) {
                throw new PreexistingEntityException("Categoriapessoa " + categoriapessoa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Categoriapessoa categoriapessoa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoriapessoa persistentCategoriapessoa = em.find(Categoriapessoa.class, categoriapessoa.getCodcategoriapessoa());
            Collection<Pessoacategoria> pessoacategoriaCollectionOld = persistentCategoriapessoa.getPessoacategoriaCollection();
            Collection<Pessoacategoria> pessoacategoriaCollectionNew = categoriapessoa.getPessoacategoriaCollection();
            Collection<Pessoacategoria> attachedPessoacategoriaCollectionNew = new ArrayList<Pessoacategoria>();
            for (Pessoacategoria pessoacategoriaCollectionNewPessoacategoriaToAttach : pessoacategoriaCollectionNew) {
                pessoacategoriaCollectionNewPessoacategoriaToAttach = em.getReference(pessoacategoriaCollectionNewPessoacategoriaToAttach.getClass(), pessoacategoriaCollectionNewPessoacategoriaToAttach.getCodpessoacategoria());
                attachedPessoacategoriaCollectionNew.add(pessoacategoriaCollectionNewPessoacategoriaToAttach);
            }
            pessoacategoriaCollectionNew = attachedPessoacategoriaCollectionNew;
            categoriapessoa.setPessoacategoriaCollection(pessoacategoriaCollectionNew);
            categoriapessoa = em.merge(categoriapessoa);
            for (Pessoacategoria pessoacategoriaCollectionOldPessoacategoria : pessoacategoriaCollectionOld) {
                if (!pessoacategoriaCollectionNew.contains(pessoacategoriaCollectionOldPessoacategoria)) {
                    pessoacategoriaCollectionOldPessoacategoria.setCodcategoriapessoa(null);
                    pessoacategoriaCollectionOldPessoacategoria = em.merge(pessoacategoriaCollectionOldPessoacategoria);
                }
            }
            for (Pessoacategoria pessoacategoriaCollectionNewPessoacategoria : pessoacategoriaCollectionNew) {
                if (!pessoacategoriaCollectionOld.contains(pessoacategoriaCollectionNewPessoacategoria)) {
                    Categoriapessoa oldCodcategoriapessoaOfPessoacategoriaCollectionNewPessoacategoria = pessoacategoriaCollectionNewPessoacategoria.getCodcategoriapessoa();
                    pessoacategoriaCollectionNewPessoacategoria.setCodcategoriapessoa(categoriapessoa);
                    pessoacategoriaCollectionNewPessoacategoria = em.merge(pessoacategoriaCollectionNewPessoacategoria);
                    if (oldCodcategoriapessoaOfPessoacategoriaCollectionNewPessoacategoria != null && !oldCodcategoriapessoaOfPessoacategoriaCollectionNewPessoacategoria.equals(categoriapessoa)) {
                        oldCodcategoriapessoaOfPessoacategoriaCollectionNewPessoacategoria.getPessoacategoriaCollection().remove(pessoacategoriaCollectionNewPessoacategoria);
                        oldCodcategoriapessoaOfPessoacategoriaCollectionNewPessoacategoria = em.merge(oldCodcategoriapessoaOfPessoacategoriaCollectionNewPessoacategoria);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = categoriapessoa.getCodcategoriapessoa();
                if (findCategoriapessoa(id) == null) {
                    throw new NonexistentEntityException("The categoriapessoa with id " + id + " no longer exists.");
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
            Categoriapessoa categoriapessoa;
            try {
                categoriapessoa = em.getReference(Categoriapessoa.class, id);
                categoriapessoa.getCodcategoriapessoa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The categoriapessoa with id " + id + " no longer exists.", enfe);
            }
            Collection<Pessoacategoria> pessoacategoriaCollection = categoriapessoa.getPessoacategoriaCollection();
            for (Pessoacategoria pessoacategoriaCollectionPessoacategoria : pessoacategoriaCollection) {
                pessoacategoriaCollectionPessoacategoria.setCodcategoriapessoa(null);
                pessoacategoriaCollectionPessoacategoria = em.merge(pessoacategoriaCollectionPessoacategoria);
            }
            em.remove(categoriapessoa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Categoriapessoa> findCategoriapessoaEntities() {
        return findCategoriapessoaEntities(true, -1, -1);
    }

    public List<Categoriapessoa> findCategoriapessoaEntities(int maxResults, int firstResult) {
        return findCategoriapessoaEntities(false, maxResults, firstResult);
    }

    private List<Categoriapessoa> findCategoriapessoaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Categoriapessoa.class));
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

    public Categoriapessoa findCategoriapessoa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Categoriapessoa.class, id);
        } finally {
            em.close();
        }
    }

    public int getCategoriapessoaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Categoriapessoa> rt = cq.from(Categoriapessoa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

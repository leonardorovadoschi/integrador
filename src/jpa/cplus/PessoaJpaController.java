/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.cplus;

import entidade.cplus.Pessoa;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import entidade.cplus.Uf;
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
public class PessoaJpaController implements Serializable {

    public PessoaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pessoa pessoa) throws PreexistingEntityException, Exception {
        if (pessoa.getPessoacategoriaCollection() == null) {
            pessoa.setPessoacategoriaCollection(new ArrayList<Pessoacategoria>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Uf coduf = pessoa.getCoduf();
            if (coduf != null) {
                coduf = em.getReference(coduf.getClass(), coduf.getCoduf());
                pessoa.setCoduf(coduf);
            }
            Collection<Pessoacategoria> attachedPessoacategoriaCollection = new ArrayList<Pessoacategoria>();
            for (Pessoacategoria pessoacategoriaCollectionPessoacategoriaToAttach : pessoa.getPessoacategoriaCollection()) {
                pessoacategoriaCollectionPessoacategoriaToAttach = em.getReference(pessoacategoriaCollectionPessoacategoriaToAttach.getClass(), pessoacategoriaCollectionPessoacategoriaToAttach.getCodpessoacategoria());
                attachedPessoacategoriaCollection.add(pessoacategoriaCollectionPessoacategoriaToAttach);
            }
            pessoa.setPessoacategoriaCollection(attachedPessoacategoriaCollection);
            em.persist(pessoa);
            if (coduf != null) {
                coduf.getPessoaCollection().add(pessoa);
                coduf = em.merge(coduf);
            }
            for (Pessoacategoria pessoacategoriaCollectionPessoacategoria : pessoa.getPessoacategoriaCollection()) {
                Pessoa oldCodpessoaOfPessoacategoriaCollectionPessoacategoria = pessoacategoriaCollectionPessoacategoria.getCodpessoa();
                pessoacategoriaCollectionPessoacategoria.setCodpessoa(pessoa);
                pessoacategoriaCollectionPessoacategoria = em.merge(pessoacategoriaCollectionPessoacategoria);
                if (oldCodpessoaOfPessoacategoriaCollectionPessoacategoria != null) {
                    oldCodpessoaOfPessoacategoriaCollectionPessoacategoria.getPessoacategoriaCollection().remove(pessoacategoriaCollectionPessoacategoria);
                    oldCodpessoaOfPessoacategoriaCollectionPessoacategoria = em.merge(oldCodpessoaOfPessoacategoriaCollectionPessoacategoria);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPessoa(pessoa.getCodpessoa()) != null) {
                throw new PreexistingEntityException("Pessoa " + pessoa + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pessoa pessoa) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pessoa persistentPessoa = em.find(Pessoa.class, pessoa.getCodpessoa());
            Uf codufOld = persistentPessoa.getCoduf();
            Uf codufNew = pessoa.getCoduf();
            Collection<Pessoacategoria> pessoacategoriaCollectionOld = persistentPessoa.getPessoacategoriaCollection();
            Collection<Pessoacategoria> pessoacategoriaCollectionNew = pessoa.getPessoacategoriaCollection();
            if (codufNew != null) {
                codufNew = em.getReference(codufNew.getClass(), codufNew.getCoduf());
                pessoa.setCoduf(codufNew);
            }
            Collection<Pessoacategoria> attachedPessoacategoriaCollectionNew = new ArrayList<Pessoacategoria>();
            for (Pessoacategoria pessoacategoriaCollectionNewPessoacategoriaToAttach : pessoacategoriaCollectionNew) {
                pessoacategoriaCollectionNewPessoacategoriaToAttach = em.getReference(pessoacategoriaCollectionNewPessoacategoriaToAttach.getClass(), pessoacategoriaCollectionNewPessoacategoriaToAttach.getCodpessoacategoria());
                attachedPessoacategoriaCollectionNew.add(pessoacategoriaCollectionNewPessoacategoriaToAttach);
            }
            pessoacategoriaCollectionNew = attachedPessoacategoriaCollectionNew;
            pessoa.setPessoacategoriaCollection(pessoacategoriaCollectionNew);
            pessoa = em.merge(pessoa);
            if (codufOld != null && !codufOld.equals(codufNew)) {
                codufOld.getPessoaCollection().remove(pessoa);
                codufOld = em.merge(codufOld);
            }
            if (codufNew != null && !codufNew.equals(codufOld)) {
                codufNew.getPessoaCollection().add(pessoa);
                codufNew = em.merge(codufNew);
            }
            for (Pessoacategoria pessoacategoriaCollectionOldPessoacategoria : pessoacategoriaCollectionOld) {
                if (!pessoacategoriaCollectionNew.contains(pessoacategoriaCollectionOldPessoacategoria)) {
                    pessoacategoriaCollectionOldPessoacategoria.setCodpessoa(null);
                    pessoacategoriaCollectionOldPessoacategoria = em.merge(pessoacategoriaCollectionOldPessoacategoria);
                }
            }
            for (Pessoacategoria pessoacategoriaCollectionNewPessoacategoria : pessoacategoriaCollectionNew) {
                if (!pessoacategoriaCollectionOld.contains(pessoacategoriaCollectionNewPessoacategoria)) {
                    Pessoa oldCodpessoaOfPessoacategoriaCollectionNewPessoacategoria = pessoacategoriaCollectionNewPessoacategoria.getCodpessoa();
                    pessoacategoriaCollectionNewPessoacategoria.setCodpessoa(pessoa);
                    pessoacategoriaCollectionNewPessoacategoria = em.merge(pessoacategoriaCollectionNewPessoacategoria);
                    if (oldCodpessoaOfPessoacategoriaCollectionNewPessoacategoria != null && !oldCodpessoaOfPessoacategoriaCollectionNewPessoacategoria.equals(pessoa)) {
                        oldCodpessoaOfPessoacategoriaCollectionNewPessoacategoria.getPessoacategoriaCollection().remove(pessoacategoriaCollectionNewPessoacategoria);
                        oldCodpessoaOfPessoacategoriaCollectionNewPessoacategoria = em.merge(oldCodpessoaOfPessoacategoriaCollectionNewPessoacategoria);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = pessoa.getCodpessoa();
                if (findPessoa(id) == null) {
                    throw new NonexistentEntityException("The pessoa with id " + id + " no longer exists.");
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
            Pessoa pessoa;
            try {
                pessoa = em.getReference(Pessoa.class, id);
                pessoa.getCodpessoa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pessoa with id " + id + " no longer exists.", enfe);
            }
            Uf coduf = pessoa.getCoduf();
            if (coduf != null) {
                coduf.getPessoaCollection().remove(pessoa);
                coduf = em.merge(coduf);
            }
            Collection<Pessoacategoria> pessoacategoriaCollection = pessoa.getPessoacategoriaCollection();
            for (Pessoacategoria pessoacategoriaCollectionPessoacategoria : pessoacategoriaCollection) {
                pessoacategoriaCollectionPessoacategoria.setCodpessoa(null);
                pessoacategoriaCollectionPessoacategoria = em.merge(pessoacategoriaCollectionPessoacategoria);
            }
            em.remove(pessoa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pessoa> findPessoaEntities() {
        return findPessoaEntities(true, -1, -1);
    }

    public List<Pessoa> findPessoaEntities(int maxResults, int firstResult) {
        return findPessoaEntities(false, maxResults, firstResult);
    }

    private List<Pessoa> findPessoaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pessoa.class));
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

    public Pessoa findPessoa(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pessoa.class, id);
        } finally {
            em.close();
        }
    }

    public int getPessoaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pessoa> rt = cq.from(Pessoa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

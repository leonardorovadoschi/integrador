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
import entidade.cplus.Bairro;
import entidade.cplus.Cep;
import entidade.cplus.Cidade;
import entidade.cplus.Tipologradouro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class CepJpaController implements Serializable {

    public CepJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cep cep) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Bairro codbairro = cep.getCodbairro();
            if (codbairro != null) {
                codbairro = em.getReference(codbairro.getClass(), codbairro.getCodbairro());
                cep.setCodbairro(codbairro);
            }
            Cidade codcidade = cep.getCodcidade();
            if (codcidade != null) {
                codcidade = em.getReference(codcidade.getClass(), codcidade.getCodcidade());
                cep.setCodcidade(codcidade);
            }
            Tipologradouro codtipologradouro = cep.getCodtipologradouro();
            if (codtipologradouro != null) {
                codtipologradouro = em.getReference(codtipologradouro.getClass(), codtipologradouro.getCodtipologradouro());
                cep.setCodtipologradouro(codtipologradouro);
            }
            em.persist(cep);
            if (codbairro != null) {
                codbairro.getCepCollection().add(cep);
                codbairro = em.merge(codbairro);
            }
            if (codcidade != null) {
                codcidade.getCepCollection().add(cep);
                codcidade = em.merge(codcidade);
            }
            if (codtipologradouro != null) {
                codtipologradouro.getCepCollection().add(cep);
                codtipologradouro = em.merge(codtipologradouro);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCep(cep.getCodcep()) != null) {
                throw new PreexistingEntityException("Cep " + cep + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cep cep) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cep persistentCep = em.find(Cep.class, cep.getCodcep());
            Bairro codbairroOld = persistentCep.getCodbairro();
            Bairro codbairroNew = cep.getCodbairro();
            Cidade codcidadeOld = persistentCep.getCodcidade();
            Cidade codcidadeNew = cep.getCodcidade();
            Tipologradouro codtipologradouroOld = persistentCep.getCodtipologradouro();
            Tipologradouro codtipologradouroNew = cep.getCodtipologradouro();
            if (codbairroNew != null) {
                codbairroNew = em.getReference(codbairroNew.getClass(), codbairroNew.getCodbairro());
                cep.setCodbairro(codbairroNew);
            }
            if (codcidadeNew != null) {
                codcidadeNew = em.getReference(codcidadeNew.getClass(), codcidadeNew.getCodcidade());
                cep.setCodcidade(codcidadeNew);
            }
            if (codtipologradouroNew != null) {
                codtipologradouroNew = em.getReference(codtipologradouroNew.getClass(), codtipologradouroNew.getCodtipologradouro());
                cep.setCodtipologradouro(codtipologradouroNew);
            }
            cep = em.merge(cep);
            if (codbairroOld != null && !codbairroOld.equals(codbairroNew)) {
                codbairroOld.getCepCollection().remove(cep);
                codbairroOld = em.merge(codbairroOld);
            }
            if (codbairroNew != null && !codbairroNew.equals(codbairroOld)) {
                codbairroNew.getCepCollection().add(cep);
                codbairroNew = em.merge(codbairroNew);
            }
            if (codcidadeOld != null && !codcidadeOld.equals(codcidadeNew)) {
                codcidadeOld.getCepCollection().remove(cep);
                codcidadeOld = em.merge(codcidadeOld);
            }
            if (codcidadeNew != null && !codcidadeNew.equals(codcidadeOld)) {
                codcidadeNew.getCepCollection().add(cep);
                codcidadeNew = em.merge(codcidadeNew);
            }
            if (codtipologradouroOld != null && !codtipologradouroOld.equals(codtipologradouroNew)) {
                codtipologradouroOld.getCepCollection().remove(cep);
                codtipologradouroOld = em.merge(codtipologradouroOld);
            }
            if (codtipologradouroNew != null && !codtipologradouroNew.equals(codtipologradouroOld)) {
                codtipologradouroNew.getCepCollection().add(cep);
                codtipologradouroNew = em.merge(codtipologradouroNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cep.getCodcep();
                if (findCep(id) == null) {
                    throw new NonexistentEntityException("The cep with id " + id + " no longer exists.");
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
            Cep cep;
            try {
                cep = em.getReference(Cep.class, id);
                cep.getCodcep();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cep with id " + id + " no longer exists.", enfe);
            }
            Bairro codbairro = cep.getCodbairro();
            if (codbairro != null) {
                codbairro.getCepCollection().remove(cep);
                codbairro = em.merge(codbairro);
            }
            Cidade codcidade = cep.getCodcidade();
            if (codcidade != null) {
                codcidade.getCepCollection().remove(cep);
                codcidade = em.merge(codcidade);
            }
            Tipologradouro codtipologradouro = cep.getCodtipologradouro();
            if (codtipologradouro != null) {
                codtipologradouro.getCepCollection().remove(cep);
                codtipologradouro = em.merge(codtipologradouro);
            }
            em.remove(cep);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cep> findCepEntities() {
        return findCepEntities(true, -1, -1);
    }

    public List<Cep> findCepEntities(int maxResults, int firstResult) {
        return findCepEntities(false, maxResults, firstResult);
    }

    private List<Cep> findCepEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cep.class));
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

    public Cep findCep(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cep.class, id);
        } finally {
            em.close();
        }
    }

    public int getCepCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cep> rt = cq.from(Cep.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

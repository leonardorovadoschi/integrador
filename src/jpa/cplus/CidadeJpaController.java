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
import entidade.cplus.Pais;
import entidade.cplus.Uf;
import entidade.cplus.Cep;
import entidade.cplus.Cidade;
import java.util.ArrayList;
import java.util.Collection;
import entidade.cplus.Regiaocidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import jpa.cplus.exceptions.NonexistentEntityException;
import jpa.cplus.exceptions.PreexistingEntityException;

/**
 *
 * @author leo
 */
public class CidadeJpaController implements Serializable {

    public CidadeJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cidade cidade) throws PreexistingEntityException, Exception {
        if (cidade.getCepCollection() == null) {
            cidade.setCepCollection(new ArrayList<Cep>());
        }
        if (cidade.getRegiaocidadeCollection() == null) {
            cidade.setRegiaocidadeCollection(new ArrayList<Regiaocidade>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pais codpais = cidade.getCodpais();
            if (codpais != null) {
                codpais = em.getReference(codpais.getClass(), codpais.getCodpais());
                cidade.setCodpais(codpais);
            }
            Uf coduf = cidade.getCoduf();
            if (coduf != null) {
                coduf = em.getReference(coduf.getClass(), coduf.getCoduf());
                cidade.setCoduf(coduf);
            }
            Collection<Cep> attachedCepCollection = new ArrayList<Cep>();
            for (Cep cepCollectionCepToAttach : cidade.getCepCollection()) {
                cepCollectionCepToAttach = em.getReference(cepCollectionCepToAttach.getClass(), cepCollectionCepToAttach.getCodcep());
                attachedCepCollection.add(cepCollectionCepToAttach);
            }
            cidade.setCepCollection(attachedCepCollection);
            Collection<Regiaocidade> attachedRegiaocidadeCollection = new ArrayList<Regiaocidade>();
            for (Regiaocidade regiaocidadeCollectionRegiaocidadeToAttach : cidade.getRegiaocidadeCollection()) {
                regiaocidadeCollectionRegiaocidadeToAttach = em.getReference(regiaocidadeCollectionRegiaocidadeToAttach.getClass(), regiaocidadeCollectionRegiaocidadeToAttach.getCodregiaocidade());
                attachedRegiaocidadeCollection.add(regiaocidadeCollectionRegiaocidadeToAttach);
            }
            cidade.setRegiaocidadeCollection(attachedRegiaocidadeCollection);
            em.persist(cidade);
            if (codpais != null) {
                codpais.getCidadeCollection().add(cidade);
                codpais = em.merge(codpais);
            }
            if (coduf != null) {
                coduf.getCidadeCollection().add(cidade);
                coduf = em.merge(coduf);
            }
            for (Cep cepCollectionCep : cidade.getCepCollection()) {
                Cidade oldCodcidadeOfCepCollectionCep = cepCollectionCep.getCodcidade();
                cepCollectionCep.setCodcidade(cidade);
                cepCollectionCep = em.merge(cepCollectionCep);
                if (oldCodcidadeOfCepCollectionCep != null) {
                    oldCodcidadeOfCepCollectionCep.getCepCollection().remove(cepCollectionCep);
                    oldCodcidadeOfCepCollectionCep = em.merge(oldCodcidadeOfCepCollectionCep);
                }
            }
            for (Regiaocidade regiaocidadeCollectionRegiaocidade : cidade.getRegiaocidadeCollection()) {
                Cidade oldCodcidadeOfRegiaocidadeCollectionRegiaocidade = regiaocidadeCollectionRegiaocidade.getCodcidade();
                regiaocidadeCollectionRegiaocidade.setCodcidade(cidade);
                regiaocidadeCollectionRegiaocidade = em.merge(regiaocidadeCollectionRegiaocidade);
                if (oldCodcidadeOfRegiaocidadeCollectionRegiaocidade != null) {
                    oldCodcidadeOfRegiaocidadeCollectionRegiaocidade.getRegiaocidadeCollection().remove(regiaocidadeCollectionRegiaocidade);
                    oldCodcidadeOfRegiaocidadeCollectionRegiaocidade = em.merge(oldCodcidadeOfRegiaocidadeCollectionRegiaocidade);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCidade(cidade.getCodcidade()) != null) {
                throw new PreexistingEntityException("Cidade " + cidade + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cidade cidade) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cidade persistentCidade = em.find(Cidade.class, cidade.getCodcidade());
            Pais codpaisOld = persistentCidade.getCodpais();
            Pais codpaisNew = cidade.getCodpais();
            Uf codufOld = persistentCidade.getCoduf();
            Uf codufNew = cidade.getCoduf();
            Collection<Cep> cepCollectionOld = persistentCidade.getCepCollection();
            Collection<Cep> cepCollectionNew = cidade.getCepCollection();
            Collection<Regiaocidade> regiaocidadeCollectionOld = persistentCidade.getRegiaocidadeCollection();
            Collection<Regiaocidade> regiaocidadeCollectionNew = cidade.getRegiaocidadeCollection();
            if (codpaisNew != null) {
                codpaisNew = em.getReference(codpaisNew.getClass(), codpaisNew.getCodpais());
                cidade.setCodpais(codpaisNew);
            }
            if (codufNew != null) {
                codufNew = em.getReference(codufNew.getClass(), codufNew.getCoduf());
                cidade.setCoduf(codufNew);
            }
            Collection<Cep> attachedCepCollectionNew = new ArrayList<Cep>();
            for (Cep cepCollectionNewCepToAttach : cepCollectionNew) {
                cepCollectionNewCepToAttach = em.getReference(cepCollectionNewCepToAttach.getClass(), cepCollectionNewCepToAttach.getCodcep());
                attachedCepCollectionNew.add(cepCollectionNewCepToAttach);
            }
            cepCollectionNew = attachedCepCollectionNew;
            cidade.setCepCollection(cepCollectionNew);
            Collection<Regiaocidade> attachedRegiaocidadeCollectionNew = new ArrayList<Regiaocidade>();
            for (Regiaocidade regiaocidadeCollectionNewRegiaocidadeToAttach : regiaocidadeCollectionNew) {
                regiaocidadeCollectionNewRegiaocidadeToAttach = em.getReference(regiaocidadeCollectionNewRegiaocidadeToAttach.getClass(), regiaocidadeCollectionNewRegiaocidadeToAttach.getCodregiaocidade());
                attachedRegiaocidadeCollectionNew.add(regiaocidadeCollectionNewRegiaocidadeToAttach);
            }
            regiaocidadeCollectionNew = attachedRegiaocidadeCollectionNew;
            cidade.setRegiaocidadeCollection(regiaocidadeCollectionNew);
            cidade = em.merge(cidade);
            if (codpaisOld != null && !codpaisOld.equals(codpaisNew)) {
                codpaisOld.getCidadeCollection().remove(cidade);
                codpaisOld = em.merge(codpaisOld);
            }
            if (codpaisNew != null && !codpaisNew.equals(codpaisOld)) {
                codpaisNew.getCidadeCollection().add(cidade);
                codpaisNew = em.merge(codpaisNew);
            }
            if (codufOld != null && !codufOld.equals(codufNew)) {
                codufOld.getCidadeCollection().remove(cidade);
                codufOld = em.merge(codufOld);
            }
            if (codufNew != null && !codufNew.equals(codufOld)) {
                codufNew.getCidadeCollection().add(cidade);
                codufNew = em.merge(codufNew);
            }
            for (Cep cepCollectionOldCep : cepCollectionOld) {
                if (!cepCollectionNew.contains(cepCollectionOldCep)) {
                    cepCollectionOldCep.setCodcidade(null);
                    cepCollectionOldCep = em.merge(cepCollectionOldCep);
                }
            }
            for (Cep cepCollectionNewCep : cepCollectionNew) {
                if (!cepCollectionOld.contains(cepCollectionNewCep)) {
                    Cidade oldCodcidadeOfCepCollectionNewCep = cepCollectionNewCep.getCodcidade();
                    cepCollectionNewCep.setCodcidade(cidade);
                    cepCollectionNewCep = em.merge(cepCollectionNewCep);
                    if (oldCodcidadeOfCepCollectionNewCep != null && !oldCodcidadeOfCepCollectionNewCep.equals(cidade)) {
                        oldCodcidadeOfCepCollectionNewCep.getCepCollection().remove(cepCollectionNewCep);
                        oldCodcidadeOfCepCollectionNewCep = em.merge(oldCodcidadeOfCepCollectionNewCep);
                    }
                }
            }
            for (Regiaocidade regiaocidadeCollectionOldRegiaocidade : regiaocidadeCollectionOld) {
                if (!regiaocidadeCollectionNew.contains(regiaocidadeCollectionOldRegiaocidade)) {
                    regiaocidadeCollectionOldRegiaocidade.setCodcidade(null);
                    regiaocidadeCollectionOldRegiaocidade = em.merge(regiaocidadeCollectionOldRegiaocidade);
                }
            }
            for (Regiaocidade regiaocidadeCollectionNewRegiaocidade : regiaocidadeCollectionNew) {
                if (!regiaocidadeCollectionOld.contains(regiaocidadeCollectionNewRegiaocidade)) {
                    Cidade oldCodcidadeOfRegiaocidadeCollectionNewRegiaocidade = regiaocidadeCollectionNewRegiaocidade.getCodcidade();
                    regiaocidadeCollectionNewRegiaocidade.setCodcidade(cidade);
                    regiaocidadeCollectionNewRegiaocidade = em.merge(regiaocidadeCollectionNewRegiaocidade);
                    if (oldCodcidadeOfRegiaocidadeCollectionNewRegiaocidade != null && !oldCodcidadeOfRegiaocidadeCollectionNewRegiaocidade.equals(cidade)) {
                        oldCodcidadeOfRegiaocidadeCollectionNewRegiaocidade.getRegiaocidadeCollection().remove(regiaocidadeCollectionNewRegiaocidade);
                        oldCodcidadeOfRegiaocidadeCollectionNewRegiaocidade = em.merge(oldCodcidadeOfRegiaocidadeCollectionNewRegiaocidade);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = cidade.getCodcidade();
                if (findCidade(id) == null) {
                    throw new NonexistentEntityException("The cidade with id " + id + " no longer exists.");
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
            Cidade cidade;
            try {
                cidade = em.getReference(Cidade.class, id);
                cidade.getCodcidade();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cidade with id " + id + " no longer exists.", enfe);
            }
            Pais codpais = cidade.getCodpais();
            if (codpais != null) {
                codpais.getCidadeCollection().remove(cidade);
                codpais = em.merge(codpais);
            }
            Uf coduf = cidade.getCoduf();
            if (coduf != null) {
                coduf.getCidadeCollection().remove(cidade);
                coduf = em.merge(coduf);
            }
            Collection<Cep> cepCollection = cidade.getCepCollection();
            for (Cep cepCollectionCep : cepCollection) {
                cepCollectionCep.setCodcidade(null);
                cepCollectionCep = em.merge(cepCollectionCep);
            }
            Collection<Regiaocidade> regiaocidadeCollection = cidade.getRegiaocidadeCollection();
            for (Regiaocidade regiaocidadeCollectionRegiaocidade : regiaocidadeCollection) {
                regiaocidadeCollectionRegiaocidade.setCodcidade(null);
                regiaocidadeCollectionRegiaocidade = em.merge(regiaocidadeCollectionRegiaocidade);
            }
            em.remove(cidade);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cidade> findCidadeEntities() {
        return findCidadeEntities(true, -1, -1);
    }

    public List<Cidade> findCidadeEntities(int maxResults, int firstResult) {
        return findCidadeEntities(false, maxResults, firstResult);
    }

    private List<Cidade> findCidadeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cidade.class));
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

    public Cidade findCidade(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cidade.class, id);
        } finally {
            em.close();
        }
    }

    public int getCidadeCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cidade> rt = cq.from(Cidade.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
